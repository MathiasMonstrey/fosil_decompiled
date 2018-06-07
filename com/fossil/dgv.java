package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dgq.C2741a;
import com.fossil.dgq.C2742b;
import com.fossil.dpf.C3051a;
import com.fossil.dpl.C3059a;
import com.fossil.dpl.C3060b;
import com.fossil.dpl.C3061c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.Unit;

public class dgv implements C2741a {
    private static final String TAG = dgv.class.getSimpleName();
    private final dpf cSm;
    private final dpl cSn;
    private final C2742b cTN;
    private MFUser cTi;
    private final ckc mUseCaseHandler;

    class C27511 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ dgv cTP;

        C27511(dgv com_fossil_dgv) {
            this.cTP = com_fossil_dgv;
        }

        public /* synthetic */ void onError(Object obj) {
            m8521a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8522a((C3051a) obj);
        }

        public void m8522a(C3051a c3051a) {
            MFLogger.m12670d(dgv.TAG, "GetUser information onSuccess");
            this.cTP.cTN.afU();
            this.cTP.cTi = c3051a.atE();
            if (this.cTP.cTi != null && this.cTP.cTN.isActive()) {
                this.cTP.cTN.mo2376d(this.cTP.cTi.getHeightUnit());
                this.cTP.cTN.mo2377e(this.cTP.cTi.getWeightUnit());
                this.cTP.cTN.mo2378f(this.cTP.cTi.getDistanceUnit());
            }
        }

        public void m8521a(C2131a c2131a) {
            this.cTP.cTN.afU();
            MFLogger.m12670d(dgv.TAG, "GetUser information onError");
        }
    }

    dgv(C2742b c2742b, ckc com_fossil_ckc, dpl com_fossil_dpl, dpf com_fossil_dpf) {
        this.cTN = (C2742b) cco.m5996s(c2742b, "view cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cSn = (dpl) cco.m5996s(com_fossil_dpl, "mUpdateUser cannot be null!");
        this.cSm = (dpf) cco.m5996s(com_fossil_dpf, "getUser cannot be null!");
    }

    public void ahu() {
        this.cTN.cK(this);
    }

    public void start() {
        MFLogger.m12670d(TAG, "presenter starts: Get user information");
        this.cTN.afT();
        this.mUseCaseHandler.m6886a(this.cSm, null, new C27511(this));
    }

    public void stop() {
        MFLogger.m12670d(TAG, "presenter stop");
    }

    public void mo2380a(final Unit unit) {
        MFLogger.m12670d(TAG, "setHeightUnit() called with: unit = [" + unit + "]");
        if (this.cTi == null) {
            MFLogger.m12670d(TAG, "Can't save height with null user");
            return;
        }
        this.cTi.setHeightUnit(unit.getValue());
        this.cTN.afT();
        this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
            final /* synthetic */ dgv cTP;

            public /* synthetic */ void onError(Object obj) {
                m8523a((C3060b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8524a((C3061c) obj);
            }

            public void m8524a(C3061c c3061c) {
                this.cTP.cTN.afU();
                this.cTP.cTN.mo2376d(unit);
            }

            public void m8523a(C3060b c3060b) {
                this.cTP.cTN.afU();
                if (c3060b != null) {
                    this.cTP.cTN.jV(c3060b.getErrorCode());
                }
            }
        });
    }

    public void mo2381b(final Unit unit) {
        MFLogger.m12670d(TAG, "setWeightUnit() called with: unit = [" + unit + "]");
        if (this.cTi == null) {
            MFLogger.m12670d(TAG, "Can't save weight with null user");
            return;
        }
        this.cTi.setWeightUnit(unit.getValue());
        this.cTN.afT();
        this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
            final /* synthetic */ dgv cTP;

            public /* synthetic */ void onError(Object obj) {
                m8525a((C3060b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8526a((C3061c) obj);
            }

            public void m8526a(C3061c c3061c) {
                this.cTP.cTN.afU();
                this.cTP.cTN.mo2377e(unit);
            }

            public void m8525a(C3060b c3060b) {
                this.cTP.cTN.afU();
                if (c3060b != null) {
                    this.cTP.cTN.jV(c3060b.getErrorCode());
                }
            }
        });
    }

    public void mo2382c(final Unit unit) {
        MFLogger.m12670d(TAG, "setDistanceUnit() called with: unit = [" + unit + "]");
        MFLogger.m12670d(TAG, "setDistanceUnit: unit = " + unit);
        if (this.cTi == null) {
            MFLogger.m12670d(TAG, "Can't save distance unit with null user");
            return;
        }
        this.cTi.setDistanceUnit(unit.getValue());
        this.cTN.afT();
        this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
            final /* synthetic */ dgv cTP;

            public /* synthetic */ void onError(Object obj) {
                m8527a((C3060b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8528a((C3061c) obj);
            }

            public void m8528a(C3061c c3061c) {
                this.cTP.cTN.afU();
                this.cTP.cTN.mo2378f(unit);
            }

            public void m8527a(C3060b c3060b) {
                this.cTP.cTN.afU();
                if (c3060b != null) {
                    this.cTP.cTN.jV(c3060b.getErrorCode());
                }
            }
        });
    }
}
