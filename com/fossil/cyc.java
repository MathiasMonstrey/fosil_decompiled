package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class cyc extends ckb<C2499a, C2500b, C2131a> {
    private final String TAG = getClass().getSimpleName();

    public static final class C2499a implements C2132b {
        private final String mDeviceId;

        public C2499a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2500b implements C2133c {
        private final int cKI;

        public C2500b(int i) {
            this.cKI = i;
        }

        public int getGattState() {
            return this.cKI;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7889a((C2499a) c2132b);
    }

    cyc() {
    }

    protected void m7889a(C2499a c2499a) {
        MFLogger.m12670d(this.TAG, "executeUseCase");
        try {
            abr().onSuccess(new C2500b(PortfolioApp.ZR().getGattState(c2499a.getDeviceId())));
        } catch (Exception e) {
            e.printStackTrace();
            abr().onError(null);
        }
    }
}
