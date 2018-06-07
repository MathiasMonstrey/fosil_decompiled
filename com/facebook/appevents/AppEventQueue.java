package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.fossil.gy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG = AppEventQueue.class.getName();
    private static volatile AppEventCollection appEventCollection = new AppEventCollection();
    private static final Runnable flushRunnable = new C13291();
    private static ScheduledFuture scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    static class C13291 implements Runnable {
        C13291() {
        }

        public void run() {
            AppEventQueue.scheduledFuture = null;
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flushAndWait(FlushReason.TIMER);
            }
        }
    }

    static class C13302 implements Runnable {
        C13302() {
        }

        public void run() {
            AppEventStore.persistEvents(AppEventQueue.appEventCollection);
            AppEventQueue.appEventCollection = new AppEventCollection();
        }
    }

    AppEventQueue() {
    }

    public static void persistToDisk() {
        singleThreadExecutor.execute(new C13302());
    }

    public static void flush(final FlushReason flushReason) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                AppEventQueue.flushAndWait(flushReason);
            }
        });
    }

    public static void add(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && AppEventQueue.appEventCollection.getEventCount() > 100) {
                    AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                } else if (AppEventQueue.scheduledFuture == null) {
                    AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15, TimeUnit.SECONDS);
                }
            }
        });
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        return appEventCollection.keySet();
    }

    static void flushAndWait(FlushReason flushReason) {
        appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
        try {
            FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
            if (sendEventsToServer != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.numEvents);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.result);
                gy.m11536p(FacebookSdk.getApplicationContext()).m11538b(intent);
            }
        } catch (Throwable e) {
            Log.w(TAG, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    private static FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection) {
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        List<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
            GraphRequest buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair), limitEventAndDataUsage, flushStatistics);
            if (buildRequestForSession != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
        for (GraphRequest buildRequestForSession2 : arrayList) {
            buildRequestForSession2.executeAndWait();
        }
        return flushStatistics;
    }

    private static GraphRequest buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        FetchedAppSettings queryAppSettings = Utility.queryAppSettings(accessTokenAppIdPair.getApplicationId(), false);
        final GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String pushNotificationsRegistrationId = AppEventsLogger.getPushNotificationsRegistrationId();
        if (pushNotificationsRegistrationId != null) {
            parameters.putString("device_token", pushNotificationsRegistrationId);
        }
        newPostRequest.setParameters(parameters);
        if (queryAppSettings == null) {
            return null;
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), queryAppSettings.supportsImplicitLogging(), z);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppEventQueue.handleResponse(accessTokenAppIdPair, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
            }
        });
        return newPostRequest;
    }

    private static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        FacebookRequestError error = graphResponse.getError();
        String str = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        String str2;
        if (error == null) {
            str2 = str;
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            Object obj = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str2 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{graphResponse.toString(), error.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException e) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), obj, jSONArray);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
                }
            });
        }
        if (flushResult != FlushResult.SUCCESS && flushStatistics.result != FlushResult.NO_CONNECTIVITY) {
            flushStatistics.result = flushResult;
        }
    }
}
