package com.fossil;

import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;

class epn implements epx {
    epn() {
    }

    public epv mo2999a(enj com_fossil_enj, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", DateTimeConstants.SECONDS_PER_HOUR);
        return new epv(m11020a(com_fossil_enj, (long) optInt2, jSONObject), m11021o(jSONObject.getJSONObject("app")), m11025s(jSONObject.getJSONObject(Constants.SESSION)), m11026t(jSONObject.getJSONObject("prompt")), m11023q(jSONObject.getJSONObject("features")), m11024r(jSONObject.getJSONObject("analytics")), m11027u(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    public JSONObject mo3000n(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        jSONObject2.getJSONObject("features").remove("collect_analytics");
        jSONObject2.remove("analytics");
        return jSONObject2;
    }

    private eph m11021o(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString("status");
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        epf com_fossil_epf = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            com_fossil_epf = m11022p(jSONObject.getJSONObject("icon"));
        }
        return new eph(string, string2, string3, string4, optBoolean, com_fossil_epf);
    }

    private epf m11022p(JSONObject jSONObject) throws JSONException {
        return new epf(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt(Constants.PROFILE_KEY_UNITS_HEIGHT));
    }

    private epp m11023q(JSONObject jSONObject) {
        return new epp(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private epe m11024r(JSONObject jSONObject) {
        return new epe(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", MFNetworkReturnCode.REQUEST_NOT_FOUND), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optInt("sampling_rate", 1));
    }

    private eps m11025s(JSONObject jSONObject) throws JSONException {
        return new eps(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private epr m11026t(JSONObject jSONObject) throws JSONException {
        return new epr(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private epi m11027u(JSONObject jSONObject) throws JSONException {
        return new epi(jSONObject.optString("update_endpoint", epw.dQL), jSONObject.optInt("update_suspend_duration", DateTimeConstants.SECONDS_PER_HOUR));
    }

    private long m11020a(enj com_fossil_enj, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return com_fossil_enj.aFr() + (1000 * j);
    }
}
