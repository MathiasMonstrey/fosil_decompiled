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
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.source.DeviceRepository;
import java.util.ArrayList;

public class cys extends ckb<C2533a, C2535c, C2534b> {
    private static final String TAG = cys.class.getSimpleName();
    private gy cEa;
    private boolean cLi;
    BroadcastReceiver cLj = new C25321(this);
    private int cLr;
    DeviceRepository mDeviceRepository;
    cnr mSharedPreferencesManager;

    class C25321 extends BroadcastReceiver {
        final /* synthetic */ cys cLs;

        C25321(cys com_fossil_cys) {
            this.cLs = com_fossil_cys;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            CommunicateMode communicateMode = CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())];
            MFLogger.m12670d(cys.TAG, "Inside .bleReceiver communicateMode=" + communicateMode + ", isExecuted=" + this.cLs.cLi + ", isSuccess=" + intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1));
            if (communicateMode == CommunicateMode.SET_VIBRATION_STRENGTH && this.cLs.cLi) {
                this.cLs.cLi = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    z = true;
                }
                if (z) {
                    DeviceModel deviceBySerial = this.cLs.mDeviceRepository.getDeviceBySerial(((C2533a) this.cLs.abq()).getDeviceSerial(), null);
                    if (deviceBySerial != null) {
                        deviceBySerial.setVibrationStrength(this.cLs.cLr);
                    }
                    this.cLs.mDeviceRepository.updateDevice(deviceBySerial, null);
                    this.cLs.mSharedPreferencesManager.m7238A(PortfolioApp.ZQ().aaa(), this.cLs.cLr);
                    this.cLs.abr().onSuccess(new C2535c());
                    return;
                }
                MFLogger.m12670d(cys.TAG, "onReceive failed");
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cLs.abr().onError(new C2534b(FailureCode.FAILED_TO_CONNECT, intExtra, integerArrayListExtra));
            }
        }
    }

    public static final class C2533a implements C2132b {
        private final String cFB;
        private final int cLt;

        public C2533a(String str, int i) {
            this.cFB = (String) cco.m5996s(str, "device serial cannot be null!");
            this.cLt = i;
        }

        public int ajX() {
            return this.cLt;
        }

        public String getDeviceSerial() {
            return this.cFB;
        }
    }

    public static final class C2534b implements C2131a {
        private final int cJJ;
        private final ArrayList<Integer> cJK;
        private int mErrorCode;

        public C2534b(int i, int i2, ArrayList<Integer> arrayList) {
            this.mErrorCode = i;
            this.cJJ = i2;
            this.cJK = (ArrayList) cco.ce(arrayList);
        }

        public ArrayList<Integer> ajf() {
            return this.cJK;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2535c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7930a((C2533a) c2132b);
    }

    public cys(DeviceRepository deviceRepository, gy gyVar, cnr com_fossil_cnr) {
        this.mDeviceRepository = deviceRepository;
        this.cEa = gyVar;
        this.mSharedPreferencesManager = com_fossil_cnr;
    }

    protected void m7930a(C2533a c2533a) {
        this.cLi = true;
        try {
            this.cLr = c2533a.ajX();
            PortfolioApp.ZR().deviceSetVibrationStrength(c2533a.getDeviceSerial(), km(c2533a.ajX()));
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".connectDevice - e=" + e);
        }
    }

    private int km(int i) {
        switch (i) {
            case 50:
                return 50;
            case 100:
                return 100;
            default:
                return 25;
        }
    }

    public void ajd() {
        this.cEa.m11537a(this.cLj, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cLj);
    }
}
