package com.fossil;

import android.util.Log;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.del.C2707a;
import com.fossil.del.C2708b;
import com.fossil.dpf.C3051a;
import com.fossil.dpl.C3059a;
import com.fossil.dpl.C3060b;
import com.fossil.dpl.C3061c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;

public class dep implements C2707a {
    private static final String TAG = dep.class.getSimpleName();
    private final C2708b cSk;
    private final dpf cSm;
    private final dpl cSn;
    private final ckc mUseCaseHandler;

    class C27111 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ dep cSo;

        C27111(dep com_fossil_dep) {
            this.cSo = com_fossil_dep;
        }

        public /* synthetic */ void onError(Object obj) {
            m8437a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8438a((C3051a) obj);
        }

        public void m8438a(C3051a c3051a) {
            MFLogger.m12670d(dep.TAG, ".Inside mGetUser onSuccess");
            if (this.cSo.cSk.isActive()) {
                this.cSo.cSk.alG();
                this.cSo.cSk.mo2355f(c3051a.atE());
            }
        }

        public void m8437a(C2131a c2131a) {
            MFLogger.m12670d(dep.TAG, ".Inside mGetUser onError");
            if (this.cSo.cSk.isActive()) {
                this.cSo.cSk.alG();
            }
        }
    }

    class C27122 implements C2126d<C3061c, C3060b> {
        final /* synthetic */ dep cSo;

        C27122(dep com_fossil_dep) {
            this.cSo = com_fossil_dep;
        }

        public /* synthetic */ void onError(Object obj) {
            m8439a((C3060b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8440a((C3061c) obj);
        }

        public void m8440a(C3061c c3061c) {
            MFLogger.m12670d(dep.TAG, ".Inside updateUser onSuccess");
            if (this.cSo.cSk.isActive()) {
                this.cSo.cSk.alG();
                this.cSo.cSk.finish();
            }
        }

        public void m8439a(C3060b c3060b) {
            MFLogger.m12670d(dep.TAG, ".Inside updateUser onError");
            if (this.cSo.cSk.isActive()) {
                this.cSo.cSk.alG();
                this.cSo.cSk.jV(c3060b.getErrorCode());
            }
        }
    }

    dep(C2708b c2708b, dpl com_fossil_dpl, dpf com_fossil_dpf, ckc com_fossil_ckc) {
        this.cSk = (C2708b) cco.m5996s(c2708b, "view cannot be nulL!");
        this.cSm = com_fossil_dpf;
        this.cSn = com_fossil_dpl;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
    }

    public void ahu() {
        this.cSk.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
        any();
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }

    public void any() {
        this.cSk.alF();
        this.mUseCaseHandler.m6886a(this.cSm, null, new C27111(this));
    }

    public void mo2358e(MFUser mFUser) {
        this.cSk.alF();
        this.mUseCaseHandler.m6886a(this.cSn, new C3059a(mFUser), new C27122(this));
    }
}
