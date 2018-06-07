package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dip.C2798a;
import com.fossil.dip.C2810b;
import com.fossil.djw.C2856a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Ringtone;
import java.util.ArrayList;

public class dir implements C2798a {
    private static final String TAG = dir.class.getSimpleName();
    private C2810b cWA;
    private djw cWB;
    private cns cWC;
    private ArrayList<Ringtone> cWD;
    private Ringtone cWE;
    private ckc mUseCaseHandler;

    class C28131 implements C2126d<C2856a, C2131a> {
        final /* synthetic */ dir cWF;

        C28131(dir com_fossil_dir) {
            this.cWF = com_fossil_dir;
        }

        public /* synthetic */ void onError(Object obj) {
            m8777a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8778a((C2856a) obj);
        }

        public void m8778a(C2856a c2856a) {
            MFLogger.m12670d(dir.TAG, "startRingPhoneDetails onSuccess");
            this.cWF.cWD = c2856a.aqB();
            this.cWF.cWA.mo2506c(this.cWF.cWE);
        }

        public void m8777a(C2131a c2131a) {
            MFLogger.m12670d(dir.TAG, "startRingPhoneDetails onError");
            this.cWF.cWE = new Ringtone();
        }
    }

    public dir(C2810b c2810b, djw com_fossil_djw, cns com_fossil_cns, ckc com_fossil_ckc) {
        this.cWA = (C2810b) emj.ce(c2810b);
        this.cWB = (djw) emj.ce(com_fossil_djw);
        this.mUseCaseHandler = (ckc) emj.ce(com_fossil_ckc);
        this.cWC = (cns) cco.m5996s(com_fossil_cns, "soundManager cannot be null!");
    }

    public void apt() {
        MFLogger.m12670d(TAG, "startRingPhoneDetails");
        this.mUseCaseHandler.m6886a(this.cWB, null, new C28131(this));
    }

    public void apu() {
    }

    public boolean apo() {
        return (this.cWE == null || this.cWE.getName() == null || this.cWE.getName().isEmpty()) ? false : true;
    }

    public String apW() {
        return new cfj().toJson(this.cWE);
    }

    public void apq() {
        if (this.cWD != null) {
            int i = 0;
            while (i < this.cWD.size()) {
                if (this.cWE.getName().equalsIgnoreCase(((Ringtone) this.cWD.get(i)).getName())) {
                    break;
                }
                i++;
            }
            i = -1;
            this.cWA.mo2507d(this.cWD, i);
        }
    }

    public void ld(int i) {
        this.cWE = (Ringtone) this.cWD.get(i);
        this.cWA.apc();
        this.cWA.mo2506c(this.cWE);
    }

    public void le(int i) {
        this.cWC.m7262b((Ringtone) this.cWD.get(i));
    }

    public void apr() {
        this.cWC.adr();
    }

    public void iI(String str) {
        if (str == null || str.isEmpty()) {
            this.cWE = new Ringtone();
            return;
        }
        try {
            this.cWE = (Ringtone) new cfj().m6205c(str, Ringtone.class);
        } catch (Exception e) {
            this.cWE = new Ringtone();
        }
    }

    public void ahu() {
        this.cWA.cK(this);
    }

    public void aoW() {
        MFLogger.m12670d(TAG, "reloadSettings");
        if (this.cWE != null) {
            this.cWA.mo2506c(this.cWE);
        }
    }
}
