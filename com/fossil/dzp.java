package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public class dzp extends dzm {
    String aYt;
    String dBO;
    Long dCi = null;

    public dzp(Context context, String str, String str2, int i, Long l, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        this.dBO = str;
        this.aYt = str2;
        this.dCi = l;
    }

    public f aCl() {
        return f.a;
    }

    public boolean mo2793h(JSONObject jSONObject) {
        ebh.m10452a(jSONObject, "pi", this.aYt);
        ebh.m10452a(jSONObject, "rf", this.dBO);
        if (this.dCi != null) {
            jSONObject.put("du", this.dCi);
        }
        return true;
    }
}
