package com.fossil;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public abstract class dzm {
    protected static String aXS = null;
    protected String aWR = null;
    protected boolean aXT = false;
    protected long aXw;
    protected String aYv = null;
    protected String aZb = null;
    protected String bcy = null;
    protected int f1483d;
    protected ear dCe = null;
    protected Context dCf;
    private dzh dCg = null;
    protected int f1484f;

    dzm(Context context, int i, dzh com_fossil_dzh) {
        this.dCf = context;
        this.aXw = System.currentTimeMillis() / 1000;
        this.f1483d = i;
        this.bcy = dze.dm(context);
        this.aZb = ebb.dI(context);
        this.aWR = dze.dl(context);
        if (com_fossil_dzh != null) {
            this.dCg = com_fossil_dzh;
            if (ebb.cn(com_fossil_dzh.awy())) {
                this.aWR = com_fossil_dzh.awy();
            }
            if (ebb.cn(com_fossil_dzh.aCf())) {
                this.bcy = com_fossil_dzh.aCf();
            }
            if (ebb.cn(com_fossil_dzh.getVersion())) {
                this.aZb = com_fossil_dzh.getVersion();
            }
            this.aXT = com_fossil_dzh.aCg();
        }
        this.aYv = dze.m10346do(context);
        this.dCe = ead.dy(context).dz(context);
        if (aCl() != f.i) {
            this.f1484f = ebb.dR(context).intValue();
        } else {
            this.f1484f = -f.i.a();
        }
        if (!dxw.cn(aXS)) {
            String dp = dze.dp(context);
            aXS = dp;
            if (!ebb.cn(dp)) {
                aXS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
        }
    }

    public long IL() {
        return this.aXw;
    }

    public String Iw() {
        try {
            JSONObject jSONObject = new JSONObject();
            m10370i(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public Context aBW() {
        return this.dCf;
    }

    public boolean aCj() {
        return this.aXT;
    }

    public abstract f aCl();

    public dzh aCm() {
        return this.dCg;
    }

    public abstract boolean mo2793h(JSONObject jSONObject);

    public boolean m10370i(JSONObject jSONObject) {
        boolean z = false;
        try {
            ebh.m10452a(jSONObject, "ky", this.aWR);
            jSONObject.put("et", aCl().a());
            if (this.dCe != null) {
                jSONObject.put("ui", this.dCe.HI());
                ebh.m10452a(jSONObject, "mc", this.dCe.Ih());
                int IA = this.dCe.IA();
                jSONObject.put("ut", IA);
                if (IA == 0 && ebb.dW(this.dCf) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            ebh.m10452a(jSONObject, "cui", this.aYv);
            if (aCl() != f.b) {
                ebh.m10452a(jSONObject, "av", this.aZb);
                ebh.m10452a(jSONObject, "ch", this.bcy);
            }
            if (this.aXT) {
                jSONObject.put("impt", 1);
            }
            ebh.m10452a(jSONObject, "mid", aXS);
            jSONObject.put("idx", this.f1484f);
            jSONObject.put("si", this.f1483d);
            jSONObject.put("ts", this.aXw);
            jSONObject.put("dts", ebb.m10441j(this.dCf, false));
            z = mo2793h(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }
}
