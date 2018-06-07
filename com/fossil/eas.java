package com.fossil;

import android.content.Context;
import org.json.JSONObject;

public class eas {
    static eau dCJ;
    private static eaq dCK = ebb.aCr();
    private static JSONObject dCL = new JSONObject();
    String aWS = null;
    Integer bct = null;

    public eas(Context context) {
        try {
            dA(context);
            this.bct = ebb.dL(context.getApplicationContext());
            this.aWS = dzi.dx(context).HI();
        } catch (Throwable th) {
            dCK.m10419g(th);
        }
    }

    static synchronized eau dA(Context context) {
        eau com_fossil_eau;
        synchronized (eas.class) {
            if (dCJ == null) {
                dCJ = new eau(context.getApplicationContext());
            }
            com_fossil_eau = dCJ;
        }
        return com_fossil_eau;
    }

    public void m10421a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (dCJ != null) {
                dCJ.m10422a(jSONObject2, thread);
            }
            ebh.m10452a(jSONObject2, "cn", this.aWS);
            if (this.bct != null) {
                jSONObject2.put("tn", this.bct);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (dCL != null && dCL.length() > 0) {
                jSONObject.put("eva", dCL);
            }
        } catch (Throwable th) {
            dCK.m10419g(th);
        }
    }
}
