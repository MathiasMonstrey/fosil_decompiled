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
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class dar extends ckb<C2611a, C2612b, C2131a> {
    private final String TAG = getClass().getSimpleName();
    private gy cEa;
    private BroadcastReceiver cEe = new C26101(this);
    private boolean cLc = false;

    class C26101 extends BroadcastReceiver {
        final /* synthetic */ dar cND;

        C26101(dar com_fossil_dar) {
            this.cND = com_fossil_dar;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(Constants.SERIAL_NUMBER);
            int intExtra = intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal());
            int intExtra2 = intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, ServiceActionResult.UNALLOWED_ACTION.ordinal());
            if (this.cND.cLc && ((C2611a) this.cND.abq()).getDeviceId().equals(stringExtra) && intExtra == CommunicateMode.READ_RSSI.ordinal()) {
                MFLogger.m12670d(this.cND.TAG, "onReceive - blePhase: " + intExtra + " - deviceId: " + stringExtra + " - mIsExecuted: " + this.cND.cLc);
                this.cND.cLc = false;
                if (intExtra2 != ServiceActionResult.SUCCEEDED.ordinal() || intent.getExtras() == null) {
                    this.cND.abr().onError(null);
                    return;
                }
                this.cND.abr().onSuccess(new C2612b(intent.getExtras().getInt(Constants.RSSI, 0)));
            }
        }
    }

    public static final class C2611a implements C2132b {
        private final String mDeviceId;

        public C2611a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2612b implements C2133c {
        private final int mRssi;

        public C2612b(int i) {
            this.mRssi = i;
        }

        public int getRssi() {
            return this.mRssi;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8102a((C2611a) c2132b);
    }

    dar(gy gyVar) {
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
    }

    protected void m8102a(C2611a c2611a) {
        MFLogger.m12670d(this.TAG, "executeUseCase");
        try {
            this.cLc = true;
            if (PortfolioApp.ZR() != null) {
                PortfolioApp.ZR().deviceGetRssi(c2611a.getDeviceId());
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
