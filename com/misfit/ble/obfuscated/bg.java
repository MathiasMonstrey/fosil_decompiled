package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.ShineConnectionParameters;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bg {
    private static final String hT = ("com.misfit.ble.set_conn_params_history_" + C4592s.m15226v() + "_" + C4592s.getSDKVersion());
    private static HashMap<String, Integer> hU = new HashMap();

    static {
        bc();
    }

    public static boolean m14911a(ba baVar, ShineConnectionParameters shineConnectionParameters) {
        if (baVar instanceof bi) {
            return true;
        }
        String a = m14910a(shineConnectionParameters);
        if (!hU.containsKey(a)) {
            return true;
        }
        return ((Integer) hU.get(a)).intValue() < 3;
    }

    public static void m14912b(ba baVar, ShineConnectionParameters shineConnectionParameters) {
        if (!(baVar instanceof bi)) {
            String a = m14910a(shineConnectionParameters);
            if (!hU.containsKey(a)) {
                hU.put(a, Integer.valueOf(0));
            }
            int intValue = ((Integer) hU.get(a)).intValue();
            if (intValue < 3) {
                intValue++;
            }
            hU.put(a, Integer.valueOf(intValue));
            bb();
        }
    }

    public static void m14913c(ba baVar, ShineConnectionParameters shineConnectionParameters) {
        if (!(baVar instanceof bi)) {
            String a = m14910a(shineConnectionParameters);
            if (hU.containsKey(a)) {
                int intValue = ((Integer) hU.get(a)).intValue();
                if (intValue > 0) {
                    intValue = 0;
                }
                hU.put(a, Integer.valueOf(intValue));
                bb();
            }
        }
    }

    private static String m14910a(ShineConnectionParameters shineConnectionParameters) {
        JSONObject jSONObject;
        Throwable e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("connection_interval", shineConnectionParameters.getConnectionInterval());
                jSONObject.put("connection_latency", shineConnectionParameters.getConnectionLatency());
                jSONObject.put("supervision_timeout", shineConnectionParameters.getSupervisionTimeout());
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                if (jSONObject == null) {
                    return null;
                }
                return jSONObject.toString();
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            C4462b.m14831a(e, "");
            if (jSONObject == null) {
                return jSONObject.toString();
            }
            return null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    private static void bb() {
        JSONArray jSONArray = new JSONArray();
        for (String str : hU.keySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("connection_params_key", str);
                jSONObject.put("connection_params_failure_key", hU.get(str));
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            jSONArray.put(jSONObject);
        }
        gz.m15154j(C4589k.m15216d(jSONArray.toString()), hT);
    }

    private static void bc() {
        String H = gz.m15149H(hT);
        if (H != null) {
            H = C4589k.m15217e(H);
            if (H != null) {
                try {
                    JSONArray jSONArray = new JSONArray(H);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        hU.put(jSONObject.getString("connection_params_key"), Integer.valueOf(jSONObject.getInt("connection_params_failure_key")));
                    }
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
            }
        }
    }
}
