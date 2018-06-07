package com.fossil;

import android.util.Log;
import com.fossil.ats.C1888f;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

final class bfy implements aws, bgy {
    private final bdn<?> bfX;
    private Set<Scope> bfc = null;
    private avg bsS = null;
    private final C1888f bsj;
    final /* synthetic */ bfs btV;
    private boolean buh = false;

    public bfy(bfs com_fossil_bfs, C1888f c1888f, bdn<?> com_fossil_bdn_) {
        this.btV = com_fossil_bfs;
        this.bsj = c1888f;
        this.bfX = com_fossil_bdn_;
    }

    private final void Og() {
        if (this.buh && this.bsS != null) {
            this.bsj.m4387a(this.bsS, this.bfc);
        }
    }

    public final void mo1343b(avg com_fossil_avg, Set<Scope> set) {
        if (com_fossil_avg == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo1344k(new atn(4));
            return;
        }
        this.bsS = com_fossil_avg;
        this.bfc = set;
        Og();
    }

    public final void mo1210d(atn com_fossil_atn) {
        this.btV.mHandler.post(new bfz(this, com_fossil_atn));
    }

    public final void mo1344k(atn com_fossil_atn) {
        ((bfu) this.btV.bsl.get(this.bfX)).m5103k(com_fossil_atn);
    }
}
