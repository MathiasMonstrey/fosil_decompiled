package com.fossil;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

class eau {
    String aWB;
    String aWJ;
    String aWR;
    String aWX;
    String aXS;
    String aXl;
    String aYt;
    String aYv;
    String aZb;
    int aZc;
    private String bbK;
    private String bbL;
    String bcy;
    int f1499d;
    String dBO;
    DisplayMetrics dCM;
    Context dCN;
    private String dCO;
    private String dCP;

    private eau(Context context) {
        this.aWR = "2.0.3";
        this.f1499d = VERSION.SDK_INT;
        this.aWX = Build.MODEL;
        this.aXl = Build.MANUFACTURER;
        this.aYv = Locale.getDefault().getLanguage();
        this.aZc = 0;
        this.aYt = null;
        this.dBO = null;
        this.dCN = null;
        this.dCO = null;
        this.bbK = null;
        this.bbL = null;
        this.dCP = null;
        this.dCN = context.getApplicationContext();
        this.dCM = ebb.dD(this.dCN);
        this.aWB = ebb.dI(this.dCN);
        this.bcy = dze.dm(this.dCN);
        this.aZb = ebb.dH(this.dCN);
        this.aXS = TimeZone.getDefault().getID();
        this.aZc = ebb.dN(this.dCN);
        this.aWJ = ebb.dO(this.dCN);
        this.aYt = this.dCN.getPackageName();
        if (this.f1499d >= 14) {
            this.dCO = ebb.dV(this.dCN);
        }
        this.bbK = ebb.dU(this.dCN).toString();
        this.bbL = ebb.dS(this.dCN);
        this.dCP = ebb.HT();
        this.dBO = ebb.eb(this.dCN);
    }

    void m10422a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.dCM != null) {
                jSONObject.put("sr", this.dCM.widthPixels + "*" + this.dCM.heightPixels);
                jSONObject.put("dpi", this.dCM.xdpi + "*" + this.dCM.ydpi);
            }
            if (dzi.dx(this.dCN).aCi()) {
                JSONObject jSONObject2 = new JSONObject();
                ebh.m10452a(jSONObject2, "bs", ebh.ee(this.dCN));
                ebh.m10452a(jSONObject2, "ss", ebh.ef(this.dCN));
                if (jSONObject2.length() > 0) {
                    ebh.m10452a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray L = ebh.m10449L(this.dCN, 10);
            if (L != null && L.length() > 0) {
                ebh.m10452a(jSONObject, "wflist", L.toString());
            }
            ebh.m10452a(jSONObject, "sen", this.dCO);
        } else {
            ebh.m10452a(jSONObject, "thn", thread.getName());
            ebh.m10452a(jSONObject, "qq", dze.dn(this.dCN));
            ebh.m10452a(jSONObject, "cui", dze.m10346do(this.dCN));
            if (ebb.cn(this.bbL) && this.bbL.split("/").length == 2) {
                ebh.m10452a(jSONObject, "fram", this.bbL.split("/")[0]);
            }
            if (ebb.cn(this.dCP) && this.dCP.split("/").length == 2) {
                ebh.m10452a(jSONObject, "from", this.dCP.split("/")[0]);
            }
            if (ead.dy(this.dCN).dz(this.dCN) != null) {
                jSONObject.put("ui", ead.dy(this.dCN).dz(this.dCN).HI());
            }
            ebh.m10452a(jSONObject, "mid", dze.dp(this.dCN));
        }
        ebh.m10452a(jSONObject, "pcn", ebb.dP(this.dCN));
        ebh.m10452a(jSONObject, "osn", VERSION.RELEASE);
        ebh.m10452a(jSONObject, "av", this.aWB);
        ebh.m10452a(jSONObject, "ch", this.bcy);
        ebh.m10452a(jSONObject, "mf", this.aXl);
        ebh.m10452a(jSONObject, "sv", this.aWR);
        ebh.m10452a(jSONObject, "osd", Build.DISPLAY);
        ebh.m10452a(jSONObject, "prod", Build.PRODUCT);
        ebh.m10452a(jSONObject, "tags", Build.TAGS);
        ebh.m10452a(jSONObject, "id", Build.ID);
        ebh.m10452a(jSONObject, "fng", Build.FINGERPRINT);
        ebh.m10452a(jSONObject, "lch", this.dBO);
        ebh.m10452a(jSONObject, "ov", Integer.toString(this.f1499d));
        jSONObject.put("os", 1);
        ebh.m10452a(jSONObject, "op", this.aZb);
        ebh.m10452a(jSONObject, "lg", this.aYv);
        ebh.m10452a(jSONObject, "md", this.aWX);
        ebh.m10452a(jSONObject, "tz", this.aXS);
        if (this.aZc != 0) {
            jSONObject.put("jb", this.aZc);
        }
        ebh.m10452a(jSONObject, "sd", this.aWJ);
        ebh.m10452a(jSONObject, "apn", this.aYt);
        ebh.m10452a(jSONObject, "cpu", this.bbK);
        ebh.m10452a(jSONObject, "abi", Build.CPU_ABI);
        ebh.m10452a(jSONObject, "abi2", Build.CPU_ABI2);
        ebh.m10452a(jSONObject, "ram", this.bbL);
        ebh.m10452a(jSONObject, "rom", this.dCP);
    }
}
