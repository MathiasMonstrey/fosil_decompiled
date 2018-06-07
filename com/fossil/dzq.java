package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public class dzq extends dzm {
    private eas dCj;
    private JSONObject dCk = null;

    public dzq(Context context, int i, JSONObject jSONObject, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        this.dCj = new eas(context);
        this.dCk = jSONObject;
    }

    public f aCl() {
        return f.b;
    }

    public boolean mo2793h(JSONObject jSONObject) {
        if (this.dCe != null) {
            jSONObject.put("ut", this.dCe.IA());
        }
        if (this.dCk != null) {
            jSONObject.put("cfg", this.dCk);
        }
        if (ebb.dY(this.dCf)) {
            jSONObject.put("ncts", 1);
        }
        this.dCj.m10421a(jSONObject, null);
        return true;
    }
}
