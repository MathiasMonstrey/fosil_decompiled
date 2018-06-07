package com.fossil;

import android.content.Context;
import android.os.Bundle;
import com.fossil.atv.C1897a;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.concurrent.Executor;

public class cmw {
    private static final String TAG = cmw.class.getSimpleName();
    private atv cph;
    public C2213a cyx;
    private Executor mExecutor;

    class C22101 implements C1899c {
        final /* synthetic */ cmw cyy;

        C22101(cmw com_fossil_cmw) {
            this.cyy = com_fossil_cmw;
        }

        public void mo1273a(atn com_fossil_atn) {
            if (this.cyy.cyx != null) {
                this.cyy.cyx.mo2352m(com_fossil_atn);
            }
        }
    }

    class C22112 implements C1898b {
        final /* synthetic */ cmw cyy;

        C22112(cmw com_fossil_cmw) {
            this.cyy = com_fossil_cmw;
        }

        public void mo1284l(Bundle bundle) {
            if (this.cyy.cyx != null) {
                this.cyy.cyx.abL();
            }
        }

        public void hr(int i) {
            if (i == 2) {
                MFLogger.m12672i(cmw.TAG, "Connection lost.  Cause: Network Lost.");
            } else if (i == 1) {
                MFLogger.m12672i(cmw.TAG, "Connection lost.  Reason: Service Disconnected");
            }
        }
    }

    class C22123 implements Runnable {
        final /* synthetic */ cmw cyy;

        C22123(cmw com_fossil_cmw) {
            this.cyy = com_fossil_cmw;
        }

        public void run() {
            atw e = azu.bkv.mo1381e(this.cyy.cph);
            if (this.cyy.cyx != null) {
                this.cyy.cyx.mo2348b(e);
            }
        }
    }

    public interface C2213a {
        void abL();

        void mo2348b(atw<Status> com_fossil_atw_com_google_android_gms_common_api_Status);

        void mo2352m(atn com_fossil_atn);
    }

    public cmw(Context context, Executor executor) {
        this.cph = new C1897a(context).m4467a(azu.bkq, new Scope[0]).m4467a(azu.bkm, new Scope[0]).m4467a(azu.bku, new Scope[0]).m4469a(new Scope("https://www.googleapis.com/auth/fitness.activity.write")).m4470b(new C22112(this)).m4472c(new C22101(this)).KI();
        this.cph.connect();
        this.mExecutor = executor;
    }

    public void connect() {
        this.cph.connect();
    }

    public void disconnect() {
        this.cph.disconnect();
    }

    public boolean isConnected() {
        return this.cph.isConnected();
    }

    public void logout() {
        this.mExecutor.execute(new C22123(this));
    }

    public void m7161a(C2213a c2213a) {
        this.cyx = c2213a;
    }
}
