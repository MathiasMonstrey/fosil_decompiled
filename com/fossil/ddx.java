package com.fossil;

import android.util.Log;
import com.fossil.ddu.C2690a;
import com.fossil.ddu.C2691b;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;

public class ddx implements C2690a {
    private static final String TAG = ddx.class.getSimpleName();
    private final C2691b cRo;

    class C26921 implements MFServerResultCallback {
        final /* synthetic */ ddx cRq;

        C26921(ddx com_fossil_ddx) {
            this.cRq = com_fossil_ddx;
        }

        public void onSuccess(MFResponse mFResponse) {
            if (this.cRq.cRo.isActive()) {
                this.cRq.cRo.alG();
                this.cRq.cRo.amR();
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            Log.d(ddx.TAG, "changePassword onFailed");
            if (this.cRq.cRo.isActive()) {
                this.cRq.cRo.alG();
                if (mFResponse.getMessage().equalsIgnoreCase("{\"\":[\"New password must different from old password\"]}")) {
                    this.cRq.cRo.amT();
                } else if (mFResponse.getMessage().equalsIgnoreCase("{\"newPassword\":[\"Minimum 7 characters at least 1 Alphabet and 1 Number\"]}")) {
                    this.cRq.cRo.amU();
                } else if (mFResponse.getMessage().equalsIgnoreCase("Wrong old password")) {
                    this.cRq.cRo.amS();
                } else {
                    this.cRq.cRo.kV(mFResponse.getHttpReturnCode());
                }
            }
        }
    }

    ddx(C2691b c2691b, ckc com_fossil_ckc) {
        this.cRo = (C2691b) cco.m5996s(c2691b, "view cannot be nulL!");
    }

    public void ahu() {
        this.cRo.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }

    public void aD(String str, String str2) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cRo.alF();
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqc(PortfolioApp.ZQ(), str, str2), new C26921(this));
            return;
        }
        this.cRo.kV(601);
    }
}
