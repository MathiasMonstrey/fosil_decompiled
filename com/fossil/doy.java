package com.fossil;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2133c;
import com.fossil.dov.C3024a;
import com.fossil.dov.C3025b;
import com.fossil.dpb.C3047a;
import com.fossil.dpb.C3048b;
import com.fossil.dpd.C3049a;
import com.fossil.dpd.C3050b;
import com.fossil.dpf.C3051a;
import com.fossil.dph.C3053a;
import com.fossil.dph.C3054b;
import com.fossil.dpj.C3056a;
import com.fossil.dpj.C3057b;
import com.fossil.dpl.C3059a;
import com.fossil.dpl.C3060b;
import com.fossil.dpl.C3061c;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.Unit;
import com.portfolio.platform.service.BackendFitnessService;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class doy implements C3024a {
    private static final String TAG = doy.class.getSimpleName();
    private int cGo;
    private final PortfolioApp cIo;
    private final dpf cSm;
    private final dpl cSn;
    private MFUser cTi;
    private final C3025b dcE;
    private final dpd dcF;
    private final dpb dcG;
    private final dpj dcH;
    private final dph dcI;
    private int dcJ;
    private final ckc mUseCaseHandler;

    class C30381 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ doy dcK;

        C30381(doy com_fossil_doy) {
            this.dcK = com_fossil_doy;
        }

        public /* synthetic */ void onError(Object obj) {
            m9279a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9280a((C3051a) obj);
        }

        public void m9280a(C3051a c3051a) {
            this.dcK.dcE.afU();
            this.dcK.cTi = c3051a.atE();
            Unit heightUnit = this.dcK.cTi.getHeightUnit();
            Unit weightUnit = this.dcK.cTi.getWeightUnit();
            this.dcK.dcE.mo2638d(heightUnit);
            this.dcK.dcE.mo2639e(weightUnit);
            this.dcK.dcE.mo2640f(this.dcK.cTi.getDistanceUnit());
            this.dcK.dcE.je(this.dcK.m9300a(this.dcK.cTi.getHeightInCentimeters(), heightUnit));
            this.dcK.dcE.jf(this.dcK.m9304b(this.dcK.cTi.getWeightInGrams(), weightUnit));
        }

        public void m9279a(C2131a c2131a) {
            this.dcK.dcE.afU();
            this.dcK.dcE.finish();
        }
    }

    class C30403 implements C2126d<C3050b, C2131a> {
        final /* synthetic */ doy dcK;

        C30403(doy com_fossil_doy) {
            this.dcK = com_fossil_doy;
        }

        public /* synthetic */ void onError(Object obj) {
            m9283a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9284a((C3050b) obj);
        }

        public void m9284a(C3050b c3050b) {
            this.dcK.cGo = c3050b.getStepGoal();
            this.dcK.dcE.jg(NumberFormat.getNumberInstance(Locale.US).format((long) this.dcK.cGo) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(this.dcK.cIo, R.string.Stats_Activity_Info_Text_Steps));
        }

        public void m9283a(C2131a c2131a) {
        }
    }

    class C30414 implements C2126d<C3048b, C2131a> {
        final /* synthetic */ doy dcK;

        C30414(doy com_fossil_doy) {
            this.dcK = com_fossil_doy;
        }

        public /* synthetic */ void onError(Object obj) {
            m9285a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9286a((C3048b) obj);
        }

        public void m9286a(C3048b c3048b) {
            this.dcK.dcJ = c3048b.atB();
            this.dcK.dcE.jh(String.format(arp.m4318u(this.dcK.cIo, R.string.Stats_Activity_Info_Text_Hours), new Object[]{Float.valueOf(((float) this.dcK.dcJ) / 60.0f)}));
        }

        public void m9285a(C2131a c2131a) {
        }
    }

    doy(C3025b c3025b, ckc com_fossil_ckc, dpf com_fossil_dpf, dpl com_fossil_dpl, dpd com_fossil_dpd, dpb com_fossil_dpb, dpj com_fossil_dpj, dph com_fossil_dph, PortfolioApp portfolioApp) {
        this.dcE = c3025b;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cSm = com_fossil_dpf;
        this.cSn = com_fossil_dpl;
        this.dcF = com_fossil_dpd;
        this.dcG = com_fossil_dpb;
        this.dcH = com_fossil_dpj;
        this.dcI = com_fossil_dph;
        this.cIo = portfolioApp;
    }

    public void ahu() {
        this.dcE.cK(this);
    }

    public void atp() {
        this.dcE.afT();
        this.mUseCaseHandler.m6886a(this.cSm, null, new C30381(this));
        this.mUseCaseHandler.m6886a(this.dcF, new C3049a(new Date()), new C30403(this));
        this.mUseCaseHandler.m6886a(this.dcG, new C3047a(new Date()), new C30414(this));
    }

    public void mo2651a(final Unit unit) {
        MFLogger.m12670d(TAG, "setHeightUnit: unit = " + unit);
        if (unit == this.cTi.getHeightUnit()) {
            return;
        }
        if (this.cIo.aak()) {
            this.cTi.setHeightUnit(unit.getValue());
            this.dcE.afT();
            this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                final /* synthetic */ doy dcK;

                public /* synthetic */ void onError(Object obj) {
                    m9287a((C3060b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m9288a((C3061c) obj);
                }

                public void m9288a(C3061c c3061c) {
                    this.dcK.dcE.afU();
                    this.dcK.dcE.mo2638d(unit);
                    this.dcK.dcE.je(this.dcK.m9300a(this.dcK.cTi.getHeightInCentimeters(), unit));
                }

                public void m9287a(C3060b c3060b) {
                    this.dcK.dcE.afU();
                    if (this.dcK.dcE.isActive()) {
                        this.dcK.dcE.kZ(c3060b.getErrorCode());
                    }
                }
            });
            return;
        }
        this.dcE.kZ(601);
    }

    public void mo2657b(final Unit unit) {
        MFLogger.m12670d(TAG, "setWeightUnit: unit = " + unit);
        if (unit == this.cTi.getWeightUnit()) {
            return;
        }
        if (this.cIo.aak()) {
            this.cTi.setWeightUnit(unit.getValue());
            this.dcE.afT();
            this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                final /* synthetic */ doy dcK;

                public /* synthetic */ void onError(Object obj) {
                    m9289a((C3060b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m9290a((C3061c) obj);
                }

                public void m9290a(C3061c c3061c) {
                    this.dcK.dcE.afU();
                    this.dcK.dcE.mo2639e(unit);
                    this.dcK.dcE.jf(this.dcK.m9304b(this.dcK.cTi.getWeightInGrams(), unit));
                }

                public void m9289a(C3060b c3060b) {
                    this.dcK.dcE.afU();
                    if (this.dcK.dcE.isActive()) {
                        this.dcK.dcE.kZ(c3060b.getErrorCode());
                    }
                }
            });
            return;
        }
        this.dcE.kZ(601);
    }

    public void mo2658c(final Unit unit) {
        MFLogger.m12670d(TAG, "setDistanceUnit: unit = " + unit);
        if (unit == this.cTi.getDistanceUnit()) {
            return;
        }
        if (this.cIo.aak()) {
            this.cTi.setDistanceUnit(unit.getValue());
            this.dcE.afT();
            this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                final /* synthetic */ doy dcK;

                public /* synthetic */ void onError(Object obj) {
                    m9291a((C3060b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m9292a((C3061c) obj);
                }

                public void m9292a(C3061c c3061c) {
                    this.dcK.dcE.afU();
                    this.dcK.dcE.mo2640f(unit);
                }

                public void m9291a(C3060b c3060b) {
                    this.dcK.dcE.afU();
                    if (this.dcK.dcE.isActive()) {
                        this.dcK.dcE.kZ(c3060b.getErrorCode());
                    }
                }
            });
            return;
        }
        this.dcE.kZ(601);
    }

    public void atq() {
        int heightInCentimeters = this.cTi.getHeightInCentimeters();
        MFLogger.m12670d(TAG, "editHeight: height = " + heightInCentimeters);
        C3025b c3025b = this.dcE;
        if (heightInCentimeters == 0) {
            heightInCentimeters = 170;
        }
        c3025b.lr(heightInCentimeters);
    }

    public void atr() {
        int weightInGrams = this.cTi.getWeightInGrams();
        MFLogger.m12670d(TAG, "editWeight: weight = " + weightInGrams);
        C3025b c3025b = this.dcE;
        if (weightInGrams == 0) {
            weightInGrams = 68039;
        }
        c3025b.ls(weightInGrams);
    }

    public void ats() {
        this.dcE.lt(this.cGo);
    }

    public void att() {
        this.dcE.lu(this.dcJ);
    }

    public void ln(final int i) {
        if (i != this.cTi.getHeightInCentimeters()) {
            MFLogger.m12670d(TAG, "updateHeight: height = " + i);
            if (this.cIo.aak()) {
                this.cTi.setHeightInCentimeters(i);
                this.dcE.afT();
                this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                    final /* synthetic */ doy dcK;

                    public /* synthetic */ void onError(Object obj) {
                        m9293a((C3060b) obj);
                    }

                    public /* synthetic */ void onSuccess(Object obj) {
                        m9294a((C3061c) obj);
                    }

                    public void m9294a(C3061c c3061c) {
                        MFLogger.m12670d(doy.TAG, "UpdateUser: onSuccess");
                        this.dcK.dcE.afU();
                        this.dcK.dcE.je(this.dcK.m9300a(i, this.dcK.cTi.getHeightUnit()));
                    }

                    public void m9293a(C3060b c3060b) {
                        MFLogger.m12670d(doy.TAG, "UpdateUser: onError");
                        this.dcK.dcE.afU();
                        if (this.dcK.dcE.isActive()) {
                            this.dcK.dcE.kZ(c3060b.getErrorCode());
                        }
                    }
                });
                return;
            }
            this.dcE.kZ(601);
        }
    }

    public void lo(final int i) {
        if (i != this.cTi.getWeightInGrams()) {
            MFLogger.m12670d(TAG, "updateWeight: weightInGrams = " + i);
            if (this.cIo.aak()) {
                this.cTi.setWeightInGrams(i);
                this.dcE.afT();
                this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                    final /* synthetic */ doy dcK;

                    public /* synthetic */ void onError(Object obj) {
                        m9295a((C3060b) obj);
                    }

                    public /* synthetic */ void onSuccess(Object obj) {
                        m9296a((C3061c) obj);
                    }

                    public void m9296a(C3061c c3061c) {
                        MFLogger.m12670d(doy.TAG, "UpdateUser: onSuccess");
                        this.dcK.dcE.afU();
                        this.dcK.dcE.jf(this.dcK.m9304b(i, this.dcK.cTi.getWeightUnit()));
                    }

                    public void m9295a(C3060b c3060b) {
                        MFLogger.m12670d(doy.TAG, "UpdateUser: onError");
                        this.dcK.dcE.afU();
                        if (this.dcK.dcE.isActive()) {
                            this.dcK.dcE.kZ(c3060b.getErrorCode());
                        }
                    }
                });
                return;
            }
            this.dcE.kZ(601);
        }
    }

    public void lp(final int i) {
        if (i == this.cGo) {
            return;
        }
        if (this.cIo.aak()) {
            Object aaa = this.cIo.aaa();
            if (!TextUtils.isEmpty(aaa)) {
                this.cIo.m12699z(aaa, i);
            }
            this.dcE.afT();
            this.mUseCaseHandler.m6886a(this.dcH, new C3056a(i), new C2126d<C2133c, C3057b>(this) {
                final /* synthetic */ doy dcK;

                public /* synthetic */ void onError(Object obj) {
                    m9278a((C3057b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m9277a((C2133c) obj);
                }

                public void m9277a(C2133c c2133c) {
                    this.dcK.dcE.afU();
                    this.dcK.cGo = i;
                    BackendFitnessService.H(this.dcK.cIo, this.dcK.cGo);
                    this.dcK.dcE.jg(NumberFormat.getNumberInstance(Locale.US).format((long) this.dcK.cGo) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(this.dcK.cIo, R.string.Stats_Activity_Info_Text_Steps));
                }

                public void m9278a(C3057b c3057b) {
                    this.dcK.dcE.afU();
                    if (this.dcK.dcE.isActive()) {
                        this.dcK.dcE.kZ(c3057b.getErrorCode());
                    }
                }
            });
            return;
        }
        this.dcE.kZ(601);
    }

    public void lq(final int i) {
        if (i == this.dcJ) {
            return;
        }
        if (this.cIo.aak()) {
            this.dcE.afT();
            this.mUseCaseHandler.m6886a(this.dcI, new C3053a(i), new C2126d<C2133c, C3054b>(this) {
                final /* synthetic */ doy dcK;

                public /* synthetic */ void onError(Object obj) {
                    m9282a((C3054b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m9281a((C2133c) obj);
                }

                public void m9281a(C2133c c2133c) {
                    this.dcK.dcE.afU();
                    this.dcK.dcJ = i;
                    this.dcK.dcE.jh(String.format(arp.m4318u(this.dcK.cIo, R.string.Stats_Activity_Info_Text_Hours), new Object[]{Float.valueOf(((float) this.dcK.dcJ) / 60.0f)}));
                }

                public void m9282a(C3054b c3054b) {
                    this.dcK.dcE.afU();
                    if (this.dcK.dcE.isActive()) {
                        this.dcK.dcE.kZ(c3054b.getErrorCode());
                    }
                }
            });
            return;
        }
        this.dcE.kZ(601);
    }

    private String m9300a(int i, Unit unit) {
        if (unit == Unit.IMPERIAL) {
            Pair av = cmo.av((float) i);
            return String.format("%s' %s \"", new Object[]{av.first, av.second});
        } else if (unit == Unit.METRIC) {
            return i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cIo.getResources().getString(R.string.Stats_Activity_Info_Label_cm);
        } else {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    private String m9304b(int i, Unit unit) {
        if (unit == Unit.IMPERIAL) {
            return Math.round(cmo.aA((float) (i + 1))) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cIo.getResources().getString(R.string.Stats_Activity_Info_Label_lbs);
        }
        if (unit == Unit.METRIC) {
            return Math.round(cmo.az((float) i)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cIo.getResources().getString(R.string.Stats_Activity_Info_Label_kg);
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }
}
