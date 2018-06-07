package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public class dzo extends dzm {
    private static String aWB = null;
    private String aYt = null;
    private String dBO = null;

    public dzo(Context context, int i, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        this.aYt = dzi.dx(context).HI();
        if (aWB == null) {
            aWB = ebb.dH(context);
        }
    }

    public f aCl() {
        return f.h;
    }

    public void cg(String str) {
        this.dBO = str;
    }

    public boolean mo2793h(JSONObject jSONObject) {
        ebh.m10452a(jSONObject, "op", aWB);
        ebh.m10452a(jSONObject, "cn", this.aYt);
        jSONObject.put("sp", this.dBO);
        return true;
    }
}
