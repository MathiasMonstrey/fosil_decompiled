package com.fossil;

import android.text.TextUtils;
import com.flurry.sdk.id;
import com.flurry.sdk.is;
import com.misfit.frameworks.common.constants.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aod implements aqi<ani> {
    private static final String aWB = aod.class.getSimpleName();

    public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
        return m4077k(inputStream);
    }

    private static ani m4077k(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        String str = new String(aqv.m4256m(inputStream));
        app.m4180g(5, aWB, "Proton response string: " + str);
        ani com_fossil_ani = new ani();
        try {
            JSONObject jSONObject = new JSONObject(str);
            com_fossil_ani.aXm = jSONObject.optLong("issued_at", -1);
            com_fossil_ani.aXv = jSONObject.optLong("refresh_ttl", 3600);
            com_fossil_ani.aXw = jSONObject.optLong("expiration_ttl", 86400);
            JSONObject optJSONObject = jSONObject.optJSONObject("global_settings");
            com_fossil_ani.aXx = new anp();
            if (optJSONObject != null) {
                com_fossil_ani.aXx.f1389a = ci(optJSONObject.optString("log_level"));
            }
            optJSONObject = jSONObject.optJSONObject("pulse");
            ang com_fossil_ang = new ang();
            if (optJSONObject != null) {
                m4076a(com_fossil_ang, optJSONObject.optJSONArray("callbacks"));
                com_fossil_ang.f1383b = optJSONObject.optInt("max_callback_retries", 3);
                com_fossil_ang.f1384c = optJSONObject.optInt("max_callback_attempts_per_report", 15);
                com_fossil_ang.f1385d = optJSONObject.optInt("max_report_delay_seconds", 600);
                com_fossil_ang.aWX = optJSONObject.optString("agent_report_url", "");
            }
            com_fossil_ani.aXy = com_fossil_ang;
            optJSONObject = jSONObject.optJSONObject("analytics");
            com_fossil_ani.aXz = new anr();
            if (optJSONObject == null) {
                return com_fossil_ani;
            }
            com_fossil_ani.aXz.aXI = optJSONObject.optBoolean("analytics_enabled", true);
            com_fossil_ani.aXz.f1390a = optJSONObject.optInt("max_session_properties", 10);
            return com_fossil_ani;
        } catch (Throwable e) {
            throw new IOException("Exception while deserialize: ", e);
        }
    }

    private static id ci(String str) {
        id idVar = id.OFF;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (id) Enum.valueOf(id.class, str);
            }
        } catch (Exception e) {
        }
        return idVar;
    }

    private static void m4076a(ang com_fossil_ang, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    anf com_fossil_anf = new anf();
                    com_fossil_anf.aWR = optJSONObject.optString("partner", "");
                    m4075a(com_fossil_anf, optJSONObject.optJSONArray("events"));
                    com_fossil_anf.aXo = cj(optJSONObject.optString("method"));
                    com_fossil_anf.aWX = optJSONObject.optString("uri_template", "");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("body_template");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("string", "null");
                        if (!optString.equals("null")) {
                            com_fossil_anf.aXl = optString;
                        }
                    }
                    com_fossil_anf.f1381g = optJSONObject.optInt("max_redirects", 5);
                    com_fossil_anf.aXp = optJSONObject.optInt("connect_timeout", 20);
                    com_fossil_anf.f1382i = optJSONObject.optInt("request_timeout", 20);
                    com_fossil_anf.aXm = optJSONObject.optLong("callback_id", -1);
                    optJSONObject = optJSONObject.optJSONObject("headers");
                    if (optJSONObject != null) {
                        optJSONObject = optJSONObject.optJSONObject(Constants.MAP);
                        if (optJSONObject != null) {
                            com_fossil_anf.aXq = aqw.m4257a(optJSONObject);
                        }
                    }
                    arrayList.add(com_fossil_anf);
                }
            }
            com_fossil_ang.aWP = arrayList;
        }
    }

    private static void m4075a(anf com_fossil_anf, JSONArray jSONArray) {
        if (jSONArray != null) {
            List list = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    if (optJSONObject.has("string")) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        anl com_fossil_anl = new anl();
                        com_fossil_anl.aWB = optJSONObject.optString("string", "");
                        list.add(com_fossil_anl);
                    } else if (optJSONObject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger")) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        optJSONObject = optJSONObject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                        if (optJSONObject != null) {
                            String[] strArr;
                            anm com_fossil_anm = new anm();
                            com_fossil_anm.aWB = optJSONObject.optString("event_name", "");
                            com_fossil_anm.aWS = optJSONObject.optString("event_parameter_name", "");
                            JSONArray optJSONArray = optJSONObject.optJSONArray("event_parameter_values");
                            if (optJSONArray != null) {
                                String[] strArr2 = new String[optJSONArray.length()];
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    strArr2[i2] = optJSONArray.optString(i2, "");
                                }
                                strArr = strArr2;
                            } else {
                                strArr = new String[0];
                            }
                            com_fossil_anm.aXC = strArr;
                            list.add(com_fossil_anm);
                        }
                    }
                }
            }
            com_fossil_anf.aXn = list;
        }
    }

    private static is cj(String str) {
        is isVar = is.GET;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (is) Enum.valueOf(is.class, str);
            }
        } catch (Exception e) {
        }
        return isVar;
    }

    public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
        throw new IOException("Serialize not supported for response");
    }
}
