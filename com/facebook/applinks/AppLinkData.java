package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData {
    private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
    private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
    private static final String APPLINK_VERSION_KEY = "version";
    public static final String ARGUMENTS_EXTRAS_KEY = "extras";
    public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
    public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
    public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    private static final String BRIDGE_ARGS_METHOD_KEY = "method";
    private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
    static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
    private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
    private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
    private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
    private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
    private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
    private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
    private static final String EXTRAS_DEEPLINK_CONTEXT_KEY = "deeplink_context";
    private static final String METHOD_ARGS_REF_KEY = "ref";
    private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
    private static final String PROMOTION_CODE_KEY = "promo_code";
    private static final String REFERER_DATA_REF_KEY = "fb_ref";
    private static final String TAG = AppLinkData.class.getCanonicalName();
    private Bundle argumentBundle;
    private JSONObject arguments;
    private String promotionCode;
    private String ref;
    private Uri targetUri;

    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(AppLinkData appLinkData);
    }

    public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionHandler) {
        fetchDeferredAppLinkData(context, null, completionHandler);
    }

    public static void fetchDeferredAppLinkData(Context context, String str, final CompletionHandler completionHandler) {
        Validate.notNull(context, "context");
        Validate.notNull(completionHandler, "completionHandler");
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        final Context applicationContext = context.getApplicationContext();
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                AppLinkData.fetchDeferredAppLinkFromServer(applicationContext, str, completionHandler);
            }
        });
    }

    private static void fetchDeferredAppLinkFromServer(Context context, String str, CompletionHandler completionHandler) {
        AppLinkData appLinkData = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.EVENT, DEFERRED_APP_LINK_EVENT);
            Utility.setAppEventAttributionParameters(jSONObject, AttributionIdentifiers.getAttributionIdentifiers(context), AppEventsLogger.getAnonymousAppDeviceGUID(context), FacebookSdk.getLimitEventAndDataUsage(context));
            jSONObject.put("application_package_name", context.getPackageName());
            try {
                jSONObject = GraphRequest.newPostRequest(null, String.format(DEFERRED_APP_LINK_PATH, new Object[]{str}), jSONObject, null).executeAndWait().getJSONObject();
                if (jSONObject != null) {
                    Object optString = jSONObject.optString(DEFERRED_APP_LINK_ARGS_FIELD);
                    long optLong = jSONObject.optLong(DEFERRED_APP_LINK_CLICK_TIME_FIELD, -1);
                    String optString2 = jSONObject.optString(DEFERRED_APP_LINK_CLASS_FIELD);
                    String optString3 = jSONObject.optString(DEFERRED_APP_LINK_URL_FIELD);
                    if (!TextUtils.isEmpty(optString)) {
                        appLinkData = createFromJson(optString);
                        if (optLong != -1) {
                            try {
                                if (appLinkData.arguments != null) {
                                    appLinkData.arguments.put(ARGUMENTS_TAPTIME_KEY, optLong);
                                }
                                if (appLinkData.argumentBundle != null) {
                                    appLinkData.argumentBundle.putString(ARGUMENTS_TAPTIME_KEY, Long.toString(optLong));
                                }
                            } catch (JSONException e) {
                                Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
                            }
                        }
                        if (optString2 != null) {
                            try {
                                if (appLinkData.arguments != null) {
                                    appLinkData.arguments.put(ARGUMENTS_NATIVE_CLASS_KEY, optString2);
                                }
                                if (appLinkData.argumentBundle != null) {
                                    appLinkData.argumentBundle.putString(ARGUMENTS_NATIVE_CLASS_KEY, optString2);
                                }
                            } catch (JSONException e2) {
                                Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
                            }
                        }
                        if (optString3 != null) {
                            try {
                                if (appLinkData.arguments != null) {
                                    appLinkData.arguments.put(ARGUMENTS_NATIVE_URL, optString3);
                                }
                                if (appLinkData.argumentBundle != null) {
                                    appLinkData.argumentBundle.putString(ARGUMENTS_NATIVE_URL, optString3);
                                }
                            } catch (JSONException e3) {
                                Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                Utility.logd(TAG, "Unable to fetch deferred applink from server");
            }
            completionHandler.onDeferredAppLinkDataFetched(appLinkData);
        } catch (Throwable e5) {
            throw new FacebookException("An error occurred while preparing deferred app link", e5);
        }
    }

    public static AppLinkData createFromActivity(Activity activity) {
        Validate.notNull(activity, Constants.ACTIVITY);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        AppLinkData createFromAlApplinkData = createFromAlApplinkData(intent);
        if (createFromAlApplinkData == null) {
            createFromAlApplinkData = createFromJson(intent.getStringExtra(BUNDLE_APPLINK_ARGS_KEY));
        }
        if (createFromAlApplinkData == null) {
            return createFromUri(intent.getData());
        }
        return createFromAlApplinkData;
    }

    public static AppLinkData createFromAlApplinkData(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle bundleExtra = intent.getBundleExtra(BUNDLE_AL_APPLINK_DATA_KEY);
        if (bundleExtra == null) {
            return null;
        }
        AppLinkData appLinkData = new AppLinkData();
        appLinkData.targetUri = intent.getData();
        if (appLinkData.targetUri == null) {
            String string = bundleExtra.getString(METHOD_ARGS_TARGET_URL_KEY);
            if (string != null) {
                appLinkData.targetUri = Uri.parse(string);
            }
        }
        appLinkData.argumentBundle = bundleExtra;
        appLinkData.arguments = null;
        Bundle bundle = bundleExtra.getBundle(ARGUMENTS_REFERER_DATA_KEY);
        if (bundle != null) {
            appLinkData.ref = bundle.getString(REFERER_DATA_REF_KEY);
        }
        bundle = bundleExtra.getBundle(ARGUMENTS_EXTRAS_KEY);
        if (bundle != null) {
            String string2 = bundle.getString("deeplink_context");
            if (string2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    if (jSONObject.has("promo_code")) {
                        appLinkData.promotionCode = jSONObject.getString("promo_code");
                    }
                } catch (Throwable e) {
                    Log.d(TAG, "Unable to parse deeplink_context JSON", e);
                }
            }
        }
        return appLinkData;
    }

    private static AppLinkData createFromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("version");
            if (!jSONObject.getJSONObject("bridge_args").getString(BRIDGE_ARGS_METHOD_KEY).equals("applink") || !string.equals("2")) {
                return null;
            }
            AppLinkData appLinkData = new AppLinkData();
            appLinkData.arguments = jSONObject.getJSONObject("method_args");
            if (appLinkData.arguments.has(METHOD_ARGS_REF_KEY)) {
                appLinkData.ref = appLinkData.arguments.getString(METHOD_ARGS_REF_KEY);
            } else if (appLinkData.arguments.has(ARGUMENTS_REFERER_DATA_KEY)) {
                jSONObject = appLinkData.arguments.getJSONObject(ARGUMENTS_REFERER_DATA_KEY);
                if (jSONObject.has(REFERER_DATA_REF_KEY)) {
                    appLinkData.ref = jSONObject.getString(REFERER_DATA_REF_KEY);
                }
            }
            if (appLinkData.arguments.has(METHOD_ARGS_TARGET_URL_KEY)) {
                appLinkData.targetUri = Uri.parse(appLinkData.arguments.getString(METHOD_ARGS_TARGET_URL_KEY));
            }
            if (appLinkData.arguments.has(ARGUMENTS_EXTRAS_KEY)) {
                jSONObject = appLinkData.arguments.getJSONObject(ARGUMENTS_EXTRAS_KEY);
                if (jSONObject.has("deeplink_context")) {
                    jSONObject = jSONObject.getJSONObject("deeplink_context");
                    if (jSONObject.has("promo_code")) {
                        appLinkData.promotionCode = jSONObject.getString("promo_code");
                    }
                }
            }
            appLinkData.argumentBundle = toBundle(appLinkData.arguments);
            return appLinkData;
        } catch (Throwable e) {
            Log.d(TAG, "Unable to parse AppLink JSON", e);
            return null;
        } catch (Throwable e2) {
            Log.d(TAG, "Unable to parse AppLink JSON", e2);
            return null;
        }
    }

    private static AppLinkData createFromUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        AppLinkData appLinkData = new AppLinkData();
        appLinkData.targetUri = uri;
        return appLinkData;
    }

    private static Bundle toBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONObject) {
                bundle.putBundle(str, toBundle((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() == 0) {
                    bundle.putStringArray(str, new String[0]);
                } else {
                    Object obj2 = jSONArray.get(0);
                    int i;
                    if (obj2 instanceof JSONObject) {
                        Parcelable[] parcelableArr = new Bundle[jSONArray.length()];
                        for (i = 0; i < jSONArray.length(); i++) {
                            parcelableArr[i] = toBundle(jSONArray.getJSONObject(i));
                        }
                        bundle.putParcelableArray(str, parcelableArr);
                    } else if (obj2 instanceof JSONArray) {
                        throw new FacebookException("Nested arrays are not supported.");
                    } else {
                        String[] strArr = new String[jSONArray.length()];
                        for (i = 0; i < jSONArray.length(); i++) {
                            strArr[i] = jSONArray.get(i).toString();
                        }
                        bundle.putStringArray(str, strArr);
                    }
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    private AppLinkData() {
    }

    public Uri getTargetUri() {
        return this.targetUri;
    }

    public String getRef() {
        return this.ref;
    }

    public String getPromotionCode() {
        return this.promotionCode;
    }

    public Bundle getArgumentBundle() {
        return this.argumentBundle;
    }

    public Bundle getRefererData() {
        if (this.argumentBundle != null) {
            return this.argumentBundle.getBundle(ARGUMENTS_REFERER_DATA_KEY);
        }
        return null;
    }
}
