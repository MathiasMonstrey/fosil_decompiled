package com.facebook;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FacebookSdk {
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized.";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final int DEFAULT_THEME = C1325R.style.com_facebook_activity_theme;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new C13091();
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = 64206;
    private static volatile Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static Boolean sdkInitialized = Boolean.valueOf(false);
    private static volatile int webDialogTheme;

    static class C13091 implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(0);

        C13091() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    }

    static class C13102 implements Callable<File> {
        C13102() {
        }

        public File call() throws Exception {
            return FacebookSdk.applicationContext.getCacheDir();
        }
    }

    public interface InitializeCallback {
        void onInitialized();
    }

    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i, null);
        }
    }

    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue() && i != callbackRequestCodeOffset) {
                throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
            } else if (i < 0) {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            } else {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
            }
        }
    }

    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, null);
        }
    }

    public static synchronized void sdkInitialize(final Context context, final InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (!sdkInitialized.booleanValue()) {
                Validate.notNull(context, "applicationContext");
                Validate.hasFacebookActivity(context, false);
                Validate.hasInternetPermissions(context, false);
                applicationContext = context.getApplicationContext();
                loadDefaultsFromMetadata(applicationContext);
                sdkInitialized = Boolean.valueOf(true);
                Utility.loadAppSettingsAsync(applicationContext, applicationId);
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.getInstance(applicationContext);
                cacheDir = new LockOnGetVariable(new C13102());
                getExecutor().execute(new FutureTask(new Callable<Void>() {
                    public Void call() throws Exception {
                        AccessTokenManager.getInstance().loadCurrentAccessToken();
                        ProfileManager.getInstance().loadCurrentProfile();
                        if (AccessToken.getCurrentAccessToken() != null && Profile.getCurrentProfile() == null) {
                            Profile.fetchProfileForCurrentAccessToken();
                        }
                        if (initializeCallback != null) {
                            initializeCallback.onInitialized();
                        }
                        AppEventsLogger.newLogger(context.getApplicationContext()).flush();
                        return null;
                    }
                }));
            } else if (initializeCallback != null) {
                initializeCallback.onInitialized();
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            updateGraphDebugBehavior();
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (LOCK) {
            executor = executor;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static void setGraphApiVersion(String str) {
        if (!Utility.isNullOrEmpty(str) && !graphApiVersion.equals(str)) {
            graphApiVersion = str;
        }
    }

    public static String getGraphApiVersion() {
        return graphApiVersion;
    }

    public static void publishInstallAsync(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                FacebookSdk.publishInstallAndWaitForResponse(applicationContext, str);
            }
        });
    }

    static com.facebook.GraphResponse publishInstallAndWaitForResponse(android.content.Context r14, java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.facebook.FacebookSdk.publishInstallAndWaitForResponse(android.content.Context, java.lang.String):com.facebook.GraphResponse. bs: [B:3:0x0007, B:11:0x005d]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r12 = 0;
        r1 = 0;
        if (r14 == 0) goto L_0x0007;
    L_0x0005:
        if (r15 != 0) goto L_0x0021;
    L_0x0007:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x000f }
        r2 = "Both context and applicationId must be non-null";	 Catch:{ Exception -> 0x000f }
        r0.<init>(r2);	 Catch:{ Exception -> 0x000f }
        throw r0;	 Catch:{ Exception -> 0x000f }
    L_0x000f:
        r0 = move-exception;
        r2 = r0;
        r0 = "Facebook-publish";
        com.facebook.internal.Utility.logd(r0, r2);
        r0 = new com.facebook.GraphResponse;
        r3 = new com.facebook.FacebookRequestError;
        r3.<init>(r1, r2);
        r0.<init>(r1, r1, r3);
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(r14);	 Catch:{ Exception -> 0x000f }
        r2 = "com.facebook.sdk.attributionTracking";	 Catch:{ Exception -> 0x000f }
        r3 = 0;	 Catch:{ Exception -> 0x000f }
        r2 = r14.getSharedPreferences(r2, r3);	 Catch:{ Exception -> 0x000f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000f }
        r3.<init>();	 Catch:{ Exception -> 0x000f }
        r3 = r3.append(r15);	 Catch:{ Exception -> 0x000f }
        r4 = "ping";	 Catch:{ Exception -> 0x000f }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x000f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x000f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000f }
        r4.<init>();	 Catch:{ Exception -> 0x000f }
        r4 = r4.append(r15);	 Catch:{ Exception -> 0x000f }
        r5 = "json";	 Catch:{ Exception -> 0x000f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x000f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x000f }
        r6 = 0;	 Catch:{ Exception -> 0x000f }
        r6 = r2.getLong(r3, r6);	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r5 = r2.getString(r4, r5);	 Catch:{ Exception -> 0x000f }
        r8 = com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT;	 Catch:{ JSONException -> 0x00a6 }
        r9 = com.facebook.appevents.AppEventsLogger.getAnonymousAppDeviceGUID(r14);	 Catch:{ JSONException -> 0x00a6 }
        r10 = getLimitEventAndDataUsage(r14);	 Catch:{ JSONException -> 0x00a6 }
        r0 = com.facebook.internal.AppEventsLoggerUtility.getJSONObjectForGraphAPICall(r8, r0, r9, r10, r14);	 Catch:{ JSONException -> 0x00a6 }
        r8 = "%s/activities";	 Catch:{ Exception -> 0x000f }
        r9 = 1;	 Catch:{ Exception -> 0x000f }
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x000f }
        r10 = 0;	 Catch:{ Exception -> 0x000f }
        r9[r10] = r15;	 Catch:{ Exception -> 0x000f }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ Exception -> 0x000f }
        r9 = 0;	 Catch:{ Exception -> 0x000f }
        r10 = 0;	 Catch:{ Exception -> 0x000f }
        r8 = com.facebook.GraphRequest.newPostRequest(r9, r8, r0, r10);	 Catch:{ Exception -> 0x000f }
        r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r0 == 0) goto L_0x00bc;
    L_0x0081:
        if (r5 == 0) goto L_0x00e1;
    L_0x0083:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00af }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x00af }
    L_0x0088:
        r2 = r0;
    L_0x0089:
        if (r2 != 0) goto L_0x00b2;
    L_0x008b:
        r0 = "true";	 Catch:{ Exception -> 0x000f }
        r2 = 0;	 Catch:{ Exception -> 0x000f }
        r3 = new com.facebook.GraphRequestBatch;	 Catch:{ Exception -> 0x000f }
        r4 = 1;	 Catch:{ Exception -> 0x000f }
        r4 = new com.facebook.GraphRequest[r4];	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r4[r5] = r8;	 Catch:{ Exception -> 0x000f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x000f }
        r0 = com.facebook.GraphResponse.createResponsesFromString(r0, r2, r3);	 Catch:{ Exception -> 0x000f }
        r2 = 0;	 Catch:{ Exception -> 0x000f }
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x000f }
        r0 = (com.facebook.GraphResponse) r0;	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;	 Catch:{ Exception -> 0x000f }
    L_0x00a6:
        r0 = move-exception;	 Catch:{ Exception -> 0x000f }
        r2 = new com.facebook.FacebookException;	 Catch:{ Exception -> 0x000f }
        r3 = "An error occurred while publishing install.";	 Catch:{ Exception -> 0x000f }
        r2.<init>(r3, r0);	 Catch:{ Exception -> 0x000f }
        throw r2;	 Catch:{ Exception -> 0x000f }
    L_0x00af:
        r0 = move-exception;	 Catch:{ Exception -> 0x000f }
        r2 = r1;	 Catch:{ Exception -> 0x000f }
        goto L_0x0089;	 Catch:{ Exception -> 0x000f }
    L_0x00b2:
        r0 = new com.facebook.GraphResponse;	 Catch:{ Exception -> 0x000f }
        r3 = 0;	 Catch:{ Exception -> 0x000f }
        r4 = 0;	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r0.<init>(r3, r4, r5, r2);	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;	 Catch:{ Exception -> 0x000f }
    L_0x00bc:
        r0 = r8.executeAndWait();	 Catch:{ Exception -> 0x000f }
        r2 = r2.edit();	 Catch:{ Exception -> 0x000f }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x000f }
        r2.putLong(r3, r6);	 Catch:{ Exception -> 0x000f }
        r3 = r0.getJSONObject();	 Catch:{ Exception -> 0x000f }
        if (r3 == 0) goto L_0x00dc;	 Catch:{ Exception -> 0x000f }
    L_0x00d1:
        r3 = r0.getJSONObject();	 Catch:{ Exception -> 0x000f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x000f }
        r2.putString(r4, r3);	 Catch:{ Exception -> 0x000f }
    L_0x00dc:
        r2.apply();	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;
    L_0x00e1:
        r0 = r1;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.publishInstallAndWaitForResponse(android.content.Context, java.lang.String):com.facebook.GraphResponse");
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    static void loadDefaultsFromMetadata(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                applicationId = str.substring(2);
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (webDialogTheme == 0) {
                        setWebDialogTheme(applicationInfo.metaData.getInt(WEB_DIALOG_THEME));
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    public static String getApplicationSignature(Context context) {
        String str = null;
        Validate.sdkInitialized();
        if (context == null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(instance.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        } catch (NameNotFoundException e2) {
            return str;
        }
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static int getWebDialogTheme() {
        Validate.sdkInitialized();
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i) {
        if (i == 0) {
            i = DEFAULT_THEME;
        }
        webDialogTheme = i;
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return (File) cacheDir.getValue();
    }

    public static void setCacheDir(File file) {
        cacheDir = new LockOnGetVariable((Object) file);
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static boolean isFacebookRequestCode(int i) {
        return i >= callbackRequestCodeOffset && i < callbackRequestCodeOffset + 100;
    }
}
