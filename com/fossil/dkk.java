package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.SecondTimezone;

public class dkk extends ckb<C2895a, C2896b, C2131a> {
    private static final String TAG = dkk.class.getSimpleName();
    private final gy cEa;
    private BroadcastReceiver cEe = new C28941(this);
    private boolean cJG;
    private SecondTimezone cWW;

    class C28941 extends BroadcastReceiver {
        final /* synthetic */ dkk cYk;

        C28941(dkk com_fossil_dkk) {
            this.cYk = com_fossil_dkk;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_SECOND_TIMEZONE && this.cYk.cJG) {
                this.cYk.cJG = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    z = true;
                }
                if (z) {
                    MFLogger.m12670d(dkk.TAG, "onReceive success");
                    this.cYk.abr().onSuccess(new C2896b(this.cYk.cWW));
                    return;
                }
                MFLogger.m12670d(dkk.TAG, "onReceive failed");
                this.cYk.abr().onError(null);
            }
        }
    }

    public static final class C2895a implements C2132b {
        private final SecondTimezone cWW;
        private final String mDeviceId;

        public C2895a(String str, SecondTimezone secondTimezone) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
            this.cWW = (SecondTimezone) cco.m5996s(secondTimezone, "secondTimezone cannot be null!");
        }
    }

    public static final class C2896b implements C2133c {
        private final SecondTimezone cWW;

        public C2896b(SecondTimezone secondTimezone) {
            this.cWW = (SecondTimezone) cco.m5996s(secondTimezone, "secondTimezone cannot be null!");
        }

        public SecondTimezone aqP() {
            return this.cWW;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8922a((C2895a) c2132b);
    }

    dkk(gy gyVar) {
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
    }

    protected void m8922a(C2895a c2895a) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.cJG = true;
        this.cWW = c2895a.cWW;
        PortfolioApp.ZQ().m12689a(c2895a.mDeviceId, this.cWW);
        PortfolioApp.ZQ().m12692a(this.cWW);
    }

    public void ajd() {
        this.cEa.m11537a(this.cEe, new IntentFilter(PortfolioApp.ZQ().getPackageName() + ButtonService.ACTION_SERVICE_BLE_RESPONSE));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cEe);
    }
}
