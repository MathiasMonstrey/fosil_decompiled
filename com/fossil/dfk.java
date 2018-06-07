package com.fossil;

import android.util.Log;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dfg.C2718a;
import com.fossil.dfg.C2719b;
import com.fossil.dpl.C3059a;
import com.fossil.dpl.C3060b;
import com.fossil.dpl.C3061c;
import com.fossil.dpn.C3064a;
import com.fossil.dpn.C3065b;
import com.fossil.dpn.C3066c;
import com.fossil.dpp.C3068a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;

public class dfk implements C2718a {
    private static final String TAG = dfk.class.getSimpleName();
    private final C2719b cSV;
    private final dpn cSX;
    private final dpp cSY;
    private final dpl cSn;
    private final ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C27221 implements C2126d<C3068a, C2131a> {
        final /* synthetic */ dfk cSZ;

        C27221(dfk com_fossil_dfk) {
            this.cSZ = com_fossil_dfk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8466a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8467a((C3068a) obj);
        }

        public void m8467a(C3068a c3068a) {
            if (this.cSZ.cSV.isActive()) {
                this.cSZ.anK();
            }
        }

        public void m8466a(C2131a c2131a) {
        }
    }

    class C27232 implements C2126d<C3066c, C3065b> {
        final /* synthetic */ dfk cSZ;

        C27232(dfk com_fossil_dfk) {
            this.cSZ = com_fossil_dfk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8468a((C3065b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8469a((C3066c) obj);
        }

        public void m8469a(C3066c c3066c) {
            this.cSZ.cSV.anF();
        }

        public void m8468a(C3065b c3065b) {
            this.cSZ.cSV.kY(c3065b.getErrorCode());
        }
    }

    class C27243 implements C2126d<C3066c, C3065b> {
        final /* synthetic */ dfk cSZ;

        C27243(dfk com_fossil_dfk) {
            this.cSZ = com_fossil_dfk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8470a((C3065b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8471a((C3066c) obj);
        }

        public void m8471a(C3066c c3066c) {
            this.cSZ.cSV.alG();
            this.cSZ.cSV.anG();
        }

        public void m8470a(C3065b c3065b) {
            this.cSZ.cSV.alG();
            this.cSZ.cSV.kY(c3065b.getErrorCode());
        }
    }

    class C27254 implements C2126d<C3061c, C3060b> {
        final /* synthetic */ dfk cSZ;

        C27254(dfk com_fossil_dfk) {
            this.cSZ = com_fossil_dfk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8472a((C3060b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8473a((C3061c) obj);
        }

        public void m8473a(C3061c c3061c) {
            MFLogger.m12670d(dfk.TAG, ".Inside updateUser onSuccess");
            if (this.cSZ.cSV.isActive()) {
                this.cSZ.cSV.alG();
                this.cSZ.anK();
            }
        }

        public void m8472a(C3060b c3060b) {
            MFLogger.m12670d(dfk.TAG, ".Inside updateUser onError errorCode=" + c3060b.getErrorCode());
            if (this.cSZ.cSV.isActive()) {
                this.cSZ.cSV.alG();
                this.cSZ.cSV.kY(c3060b.getErrorCode());
            }
        }
    }

    dfk(C2719b c2719b, ckc com_fossil_ckc, dpn com_fossil_dpn, dpp com_fossil_dpp, dpl com_fossil_dpl) {
        this.cSV = (C2719b) cco.m5996s(c2719b, "view cannot be nulL!");
        this.cSX = com_fossil_dpn;
        this.cSY = com_fossil_dpp;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.cSn = com_fossil_dpl;
    }

    public void ahu() {
        this.cSV.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
        any();
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }

    public void any() {
        if (this.mUserRepository.getCurrentUser() != null) {
            this.cSV.mo2364f(this.mUserRepository.getCurrentUser());
            anL();
        }
    }

    private void anK() {
        if (this.mUserRepository.getCurrentUser() != null) {
            this.cSV.mo2364f(this.mUserRepository.getCurrentUser());
        }
    }

    private void anL() {
        this.mUseCaseHandler.m6886a(this.cSY, null, new C27221(this));
    }

    public void mo2367b(MFUser mFUser) {
        this.mUseCaseHandler.m6886a(this.cSX, new C3064a(0), new C27232(this));
    }

    public void anE() {
        this.cSV.alF();
        this.mUseCaseHandler.m6886a(this.cSX, new C3064a(1), new C27243(this));
    }

    public void mo2368e(MFUser mFUser) {
        this.cSV.alF();
        this.mUseCaseHandler.m6886a(this.cSn, new C3059a(mFUser), new C27254(this));
    }
}
