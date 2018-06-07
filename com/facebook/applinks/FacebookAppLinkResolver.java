package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.fossil.tg;
import com.fossil.tm;
import com.fossil.tn;
import com.fossil.tn.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, tg> cachedAppLinks = new HashMap();

    public tn<tg> getAppLinkFromUrlInBackground(final Uri uri) {
        List arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).b(new tm<Map<Uri, tg>, tg>() {
            public tg then(tn<Map<Uri, tg>> tnVar) throws Exception {
                return (tg) ((Map) tnVar.getResult()).get(uri);
            }
        });
    }

    public tn<Map<Uri, tg>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        final Map hashMap = new HashMap();
        final HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Uri uri : list) {
            synchronized (this.cachedAppLinks) {
                tg tgVar = (tg) this.cachedAppLinks.get(uri);
            }
            if (tgVar != null) {
                hashMap.put(uri, tgVar);
            } else {
                if (!hashSet.isEmpty()) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(uri.toString());
                hashSet.add(uri);
            }
        }
        if (hashSet.isEmpty()) {
            return tn.aT(hashMap);
        }
        final a tf = tn.tf();
        Bundle bundle = new Bundle();
        bundle.putString("ids", stringBuilder.toString());
        bundle.putString(GraphRequest.FIELDS_PARAM, String.format("%s.fields(%s,%s)", new Object[]{APP_LINK_KEY, APP_LINK_ANDROID_TARGET_KEY, "web"}));
        new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    tf.d(error.getException());
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    tf.aV(hashMap);
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (jSONObject.has(uri.toString())) {
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject(FacebookAppLinkResolver.APP_LINK_KEY);
                            JSONArray jSONArray = jSONObject2.getJSONArray(FacebookAppLinkResolver.APP_LINK_ANDROID_TARGET_KEY);
                            int length = jSONArray.length();
                            List arrayList = new ArrayList(length);
                            for (int i = 0; i < length; i++) {
                                tg.a access$000 = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                                if (access$000 != null) {
                                    arrayList.add(access$000);
                                }
                            }
                            tg tgVar = new tg(uri, arrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject2));
                            hashMap.put(uri, tgVar);
                            synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                                FacebookAppLinkResolver.this.cachedAppLinks.put(uri, tgVar);
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
                tf.aV(hashMap);
            }
        }).executeAsync();
        return tf.tk();
    }

    private static tg.a getAndroidTargetFromJson(JSONObject jSONObject) {
        Uri uri = null;
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", null);
        if (tryGetStringFromJson4 != null) {
            uri = Uri.parse(tryGetStringFromJson4);
        }
        return new tg.a(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        Uri uri2 = null;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("web");
            if (!tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            if (uri2 != null) {
                return uri2;
            }
            return uri;
        } catch (JSONException e) {
            return uri;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            z = jSONObject.getBoolean(str);
        } catch (JSONException e) {
        }
        return z;
    }
}
