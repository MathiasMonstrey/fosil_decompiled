package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.misfit.frameworks.common.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new C13501();

    static class C13501 extends HashMap<GraphAPIActivityType, String> {
        C13501() {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    }

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EVENT, API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
