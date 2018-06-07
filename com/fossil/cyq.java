package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class cyq extends ckb<C2529a, C2531c, C2530b> {
    private static final String TAG = cyq.class.getSimpleName();
    private gy cEa;
    private boolean cLi;
    private BroadcastReceiver cLj = new C25281(this);
    private String mSerial;

    class C25281 extends BroadcastReceiver {
        final /* synthetic */ cyq cLp;

        C25281(cyq com_fossil_cyq) {
            this.cLp = com_fossil_cyq;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            CommunicateMode communicateMode = CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())];
            MFLogger.m12670d(cyq.TAG, "Inside .bleReceiver communicateMode=" + communicateMode + ", isExecuted=" + this.cLp.cLi + ", isSuccess=" + intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1));
            if (communicateMode == CommunicateMode.RECONNECT || (communicateMode == CommunicateMode.CONNECT_WITHOUT_TIMEOUT && this.cLp.cLi)) {
                this.cLp.cLi = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    z = true;
                }
                if (z) {
                    this.cLp.abr().onSuccess(new C2531c());
                } else {
                    this.cLp.abr().onError(new C2530b(FailureCode.FAILED_TO_CONNECT));
                }
                this.cLp.aje();
            }
        }
    }

    public static final class C2529a implements C2132b {
        private final String mSerial;

        public C2529a(String str) {
            this.mSerial = str;
        }

        public String getSerial() {
            return this.mSerial;
        }
    }

    public static final class C2530b implements C2131a {
        private int errorCode;

        public C2530b(int i) {
            this.errorCode = i;
        }
    }

    public static final class C2531c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7924a((C2529a) c2132b);
    }

    public cyq(gy gyVar) {
        this.cEa = gyVar;
    }

    protected void m7924a(C2529a c2529a) {
        this.cLi = true;
        this.mSerial = c2529a.getSerial();
        try {
            PortfolioApp.ZR().deviceReconnect(this.mSerial);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".connectDevice - e=" + e);
        }
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cLj);
    }
}
