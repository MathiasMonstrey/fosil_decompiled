package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.fossil.ats.C1890b;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.Set;

public final class bgw extends btz implements C1898b, C1899c {
    private static C1890b<? extends btu, btv> buJ = btq.bvj;
    private final C1890b<? extends btu, btv> bfR;
    private Set<Scope> bfc;
    private awy biS;
    private btu bsO;
    private final boolean buK;
    private bgy buL;
    private final Context mContext;
    private final Handler mHandler;

    public bgw(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
        this.bfR = buJ;
        this.buK = true;
    }

    public bgw(Context context, Handler handler, awy com_fossil_awy, C1890b<? extends btu, btv> c1890b) {
        this.mContext = context;
        this.mHandler = handler;
        this.biS = (awy) awa.m4640p(com_fossil_awy, "ClientSettings must not be null");
        this.bfc = com_fossil_awy.Lu();
        this.bfR = c1890b;
        this.buK = false;
    }

    private final void m5147c(buh com_fossil_buh) {
        atn Ld = com_fossil_buh.Ld();
        if (Ld.Kb()) {
            awd SG = com_fossil_buh.SG();
            atn Ld2 = SG.Ld();
            if (Ld2.Kb()) {
                this.buL.mo1343b(SG.Lc(), this.bfc);
            } else {
                String valueOf = String.valueOf(Ld2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.buL.mo1344k(Ld2);
                this.bsO.disconnect();
                return;
            }
        }
        this.buL.mo1344k(Ld);
        this.bsO.disconnect();
    }

    public final btu Of() {
        return this.bsO;
    }

    public final void Oq() {
        if (this.bsO != null) {
            this.bsO.disconnect();
        }
    }

    public final void mo1273a(atn com_fossil_atn) {
        this.buL.mo1344k(com_fossil_atn);
    }

    public final void m5149a(bgy com_fossil_bgy) {
        if (this.bsO != null) {
            this.bsO.disconnect();
        }
        if (this.buK) {
            GoogleSignInOptions Kp = atb.ai(this.mContext).Kp();
            this.bfc = Kp == null ? new HashSet() : new HashSet(Kp.JT());
            this.biS = new awy(null, this.bfc, null, 0, null, null, null, btv.bGd);
        }
        this.biS.m4658b(Integer.valueOf(System.identityHashCode(this)));
        this.bsO = (btu) this.bfR.mo1176a(this.mContext, this.mHandler.getLooper(), this.biS, this.biS.Lz(), this, this);
        this.buL = com_fossil_bgy;
        this.bsO.connect();
    }

    public final void mo1327b(buh com_fossil_buh) {
        this.mHandler.post(new bgx(this, com_fossil_buh));
    }

    public final void hr(int i) {
        this.bsO.disconnect();
    }

    public final void mo1284l(Bundle bundle) {
        this.bsO.mo1483a(this);
    }
}
