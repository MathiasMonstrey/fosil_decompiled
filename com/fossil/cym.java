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
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class cym extends ckb<C2518a, C2519b, C2131a> {
    private final String TAG = getClass().getSimpleName();
    private gy cEa;
    private final BroadcastReceiver cEe = new C25171(this);
    private boolean cLc = false;

    class C25171 extends BroadcastReceiver {
        final /* synthetic */ cym cLd;

        C25171(cym com_fossil_cym) {
            this.cLd = com_fossil_cym;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(Constants.SERIAL_NUMBER);
            int intExtra = intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal());
            if (this.cLd.cLc && ((C2518a) this.cLd.abq()).getDeviceId().equals(stringExtra) && intExtra == CommunicateMode.GET_BATTERY_LEVEL.ordinal()) {
                int i;
                MFLogger.m12670d(this.cLd.TAG, "onReceive - blePhase: " + intExtra + " - deviceId: " + stringExtra + " - mIsExecuted: " + this.cLd.cLc);
                this.cLd.cLc = false;
                if (intent.getExtras() != null) {
                    i = intent.getExtras().getInt(Constants.BATTERY);
                } else {
                    i = 0;
                }
                if (i < 0 || i > 100) {
                    this.cLd.abr().onError(null);
                } else {
                    this.cLd.abr().onSuccess(new C2519b(i));
                }
            }
        }
    }

    public static final class C2518a implements C2132b {
        private final String mDeviceId;

        public C2518a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2519b implements C2133c {
        private final int cLe;

        public C2519b(int i) {
            this.cLe = i;
        }

        public int getBatteryLevel() {
            return this.cLe;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7911a((C2518a) c2132b);
    }

    cym(gy gyVar) {
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
    }

    protected void m7911a(C2518a c2518a) {
        MFLogger.m12670d(this.TAG, "executeUseCase");
        try {
            this.cLc = true;
            if (PortfolioApp.ZR() != null) {
                PortfolioApp.ZR().deviceGetBatteryLevel(c2518a.getDeviceId());
            } else {
                abr().onError(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajd() {
        this.cEa.m11537a(this.cEe, new IntentFilter(PortfolioApp.ZQ().getPackageName() + ButtonService.ACTION_SERVICE_BLE_RESPONSE));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cEe);
    }
}
