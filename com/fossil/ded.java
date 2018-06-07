package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fossil.dec.C2693a;
import com.fossil.dec.C2694b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.profile.connectedapps.underamourrecord.UnderAmourRecordActivity;
import com.portfolio.platform.ui.profile.connectedapps.underamourrecord.UnderAmourRecordActivity.a;
import com.portfolio.platform.ui.profile.connectedapps.upbyjawbone.UpByJawBoneActivity;

public final class ded extends ctm implements C2694b {
    private static final String TAG = ded.class.getSimpleName();
    private static final int cRu = 1;
    private static final int cRv = 2;
    public static final C2695a cRw = new C2695a();
    private dqo<cle> cEY;
    private C2693a cRt;

    public static final class C2695a {
        private C2695a() {
        }

        public final String getTAG() {
            return ded.TAG;
        }

        public final int ani() {
            return ded.cRu;
        }

        public final ded anj() {
            return new ded();
        }
    }

    static final class C2696b implements OnClickListener {
        final /* synthetic */ ded cRx;

        C2696b(ded com_fossil_ded) {
            this.cRx = com_fossil_ded;
        }

        public final void onClick(View view) {
            this.cRx.finish();
        }
    }

    static final class C2697c implements OnClickListener {
        final /* synthetic */ ded cRx;

        C2697c(ded com_fossil_ded) {
            this.cRx = com_fossil_ded;
        }

        public final void onClick(View view) {
            ded.m8404a(this.cRx).anb();
        }
    }

    static final class C2698d implements OnClickListener {
        final /* synthetic */ ded cRx;

        C2698d(ded com_fossil_ded) {
            this.cRx = com_fossil_ded;
        }

        public final void onClick(View view) {
            ded.m8404a(this.cRx).anc();
        }
    }

    static final class C2699e implements OnClickListener {
        final /* synthetic */ ded cRx;

        C2699e(ded com_fossil_ded) {
            this.cRx = com_fossil_ded;
        }

        public final void onClick(View view) {
            ded.m8404a(this.cRx).ane();
        }
    }

    public static final /* synthetic */ C2693a m8404a(ded com_fossil_ded) {
        C2693a c2693a = com_fossil_ded.cRt;
        if (c2693a == null) {
            esl.mF("mPresenter");
        }
        return c2693a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8405a((C2693a) obj);
    }

    public void m8405a(C2693a c2693a) {
        esl.m11128j(c2693a, "presenter");
        Object ce = cco.ce(c2693a);
        esl.m11127i(ce, "checkNotNull<ProfileConn…act.Presenter>(presenter)");
        this.cRt = (C2693a) ce;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cle com_fossil_cle = (cle) C3311e.m10386a(LayoutInflater.from(getContext()), R.layout.fragment_profile_connected_app, null, false, this.cEN);
        com_fossil_cle.cqc.setOnClickListener(new C2696b(this));
        com_fossil_cle.ctz.setOnClickListener(new C2697c(this));
        com_fossil_cle.ctA.setOnClickListener(new C2698d(this));
        com_fossil_cle.cty.setOnClickListener(new C2699e(this));
        this.cEY = new dqo(this, com_fossil_cle);
        return com_fossil_cle.dz();
    }

    public void onResume() {
        super.onResume();
        C2693a c2693a = this.cRt;
        if (c2693a == null) {
            esl.mF("mPresenter");
        }
        c2693a.start();
    }

    public void onPause() {
        super.onPause();
        C2693a c2693a = this.cRt;
        if (c2693a == null) {
            esl.mF("mPresenter");
        }
        c2693a.stop();
    }

    public void cJ(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cle com_fossil_cle = (cle) com_fossil_dqo.get();
        if (com_fossil_cle != null) {
            ImageView imageView = com_fossil_cle.ctC;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void mo2331a(ecp com_fossil_ecp) {
        esl.m11128j(com_fossil_ecp, "ua");
        a aVar = UnderAmourRecordActivity.cRJ;
        ew activity = getActivity();
        esl.m11127i(activity, Constants.ACTIVITY);
        aVar.a(activity, com_fossil_ecp);
    }

    public void cK(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cle com_fossil_cle = (cle) com_fossil_dqo.get();
        if (com_fossil_cle != null) {
            ImageView imageView = com_fossil_cle.ctD;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void ang() {
        UpByJawBoneActivity.a aVar = UpByJawBoneActivity.cRN;
        ew activity = getActivity();
        esl.m11127i(activity, Constants.ACTIVITY);
        aVar.z(activity);
    }

    public void cL(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cle com_fossil_cle = (cle) com_fossil_dqo.get();
        if (com_fossil_cle != null) {
            ImageView imageView = com_fossil_cle.ctB;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void mo2337n(atn com_fossil_atn) {
        esl.m11128j(com_fossil_atn, "connectionResult");
        com_fossil_atn.m4433b(getActivity(), cRw.ani());
    }

    public void kW(int i) {
        if (!isActive()) {
            return;
        }
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            dqw.m9419a(i, getChildFragmentManager());
        } else {
            dqw.m9419a(601, getChildFragmentManager());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        super.onActivityResult(i, i2, intent);
        C2693a c2693a;
        if (i == UnderAmourRecordActivity.cRJ.anr()) {
            if (i2 == -1) {
                if (intent != null) {
                    str = intent.getStringExtra("code");
                }
                if (str != null) {
                    MFLogger.m12670d(cRw.getTAG(), "We got a UA code! " + str);
                    c2693a = this.cRt;
                    if (c2693a == null) {
                        esl.mF("mPresenter");
                    }
                    c2693a.is(str);
                    return;
                }
                return;
            }
            MFLogger.m12671e(cRw.getTAG(), "Something went wrong with UA login");
        } else if (i == 101) {
            if (i2 == -1) {
                MFLogger.m12670d(cRw.getTAG(), "JB came back ok!");
                if (intent != null) {
                    str = intent.getStringExtra("code");
                }
                if (str != null) {
                    MFLogger.m12670d(cRw.getTAG(), "The code is - " + str);
                    c2693a = this.cRt;
                    if (c2693a == null) {
                        esl.mF("mPresenter");
                    }
                    c2693a.it(str);
                    return;
                }
                return;
            }
            MFLogger.m12671e(cRw.getTAG(), "Something went wrong with JB login");
        } else if (i == cRw.ani() && i2 == -1) {
            C2693a c2693a2 = this.cRt;
            if (c2693a2 == null) {
                esl.mF("mPresenter");
            }
            c2693a2.anf();
        }
    }

    public void finish() {
        getActivity().finish();
    }
}
