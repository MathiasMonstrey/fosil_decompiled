package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.SourceApplicationInfo.Factory;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
    private static String appId;
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture currentFuture;
    private static volatile SessionInfo currentSession;
    private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static AtomicBoolean tracking = new AtomicBoolean(false);

    static class C13411 implements ActivityLifecycleCallbacks {
        C13411() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            AppEventUtility.assertIsMainThread();
            ActivityLifecycleTracker.onActivityCreated(activity);
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            AppEventUtility.assertIsMainThread();
            ActivityLifecycleTracker.onActivityResumed(activity);
        }

        public void onActivityPaused(Activity activity) {
            AppEventUtility.assertIsMainThread();
            ActivityLifecycleTracker.onActivityPaused(activity);
        }

        public void onActivityStopped(Activity activity) {
            AppEventsLogger.onContextStop();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    public static void startTracking(Application application, String str) {
        if (tracking.compareAndSet(false, true)) {
            appId = str;
            application.registerActivityLifecycleCallbacks(new C13411());
        }
    }

    public static boolean isTracking() {
        return tracking.get();
    }

    public static UUID getCurrentSessionGuid() {
        return currentSession != null ? currentSession.getSessionId() : null;
    }

    public static void onActivityCreated(final Activity activity) {
        final long currentTimeMillis = System.currentTimeMillis();
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                if (ActivityLifecycleTracker.currentSession == null) {
                    Context applicationContext = activity.getApplicationContext();
                    String activityName = Utility.getActivityName(activity);
                    SessionInfo storedSessionInfo = SessionInfo.getStoredSessionInfo();
                    if (storedSessionInfo != null) {
                        SessionLogger.logDeactivateApp(applicationContext, activityName, storedSessionInfo, ActivityLifecycleTracker.appId);
                    }
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SourceApplicationInfo create = Factory.create(activity);
                    ActivityLifecycleTracker.currentSession.setSourceApplicationInfo(create);
                    SessionLogger.logActivateApp(applicationContext, activityName, create, ActivityLifecycleTracker.appId);
                }
            }
        });
    }

    public static void onActivityResumed(final Activity activity) {
        foregroundActivityCount.incrementAndGet();
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                Context applicationContext = activity.getApplicationContext();
                String activityName = Utility.getActivityName(activity);
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SessionLogger.logActivateApp(applicationContext, activityName, null, ActivityLifecycleTracker.appId);
                } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
                    long longValue = currentTimeMillis - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
                    if (longValue > ((long) (ActivityLifecycleTracker.getSessionTimeoutInSeconds() * 1000))) {
                        SessionLogger.logDeactivateApp(applicationContext, activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                        SessionLogger.logActivateApp(applicationContext, activityName, null, ActivityLifecycleTracker.appId);
                        ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > ActivityLifecycleTracker.INTERRUPTION_THRESHOLD_MILLISECONDS) {
                        ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
                    }
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
            }
        });
    }

    private static void onActivityPaused(Activity activity) {
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final Context applicationContext = activity.getApplicationContext();
        final String activityName = Utility.getActivityName(activity);
        singleThreadExecutor.execute(new Runnable() {

            class C13441 implements Runnable {
                C13441() {
                }

                public void run() {
                    if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                        SessionLogger.logDeactivateApp(applicationContext, activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                        SessionInfo.clearSavedSessionFromDisk();
                        ActivityLifecycleTracker.currentSession = null;
                    }
                    ActivityLifecycleTracker.currentFuture = null;
                }
            }

            public void run() {
                long j = 0;
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(new C13441(), (long) ActivityLifecycleTracker.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                }
                long access$700 = ActivityLifecycleTracker.currentActivityAppearTime;
                if (access$700 > 0) {
                    j = (currentTimeMillis - access$700) / ActivityLifecycleTracker.INTERRUPTION_THRESHOLD_MILLISECONDS;
                }
                AutomaticAnalyticsLogger.logActivityTimeSpentEvent(applicationContext, ActivityLifecycleTracker.appId, activityName, j);
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
            }
        });
    }

    private static int getSessionTimeoutInSeconds() {
        FetchedAppSettings appSettingsWithoutQuery = Utility.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    private static void cancelCurrentTask() {
        if (currentFuture != null) {
            currentFuture.cancel(false);
        }
        currentFuture = null;
    }
}
