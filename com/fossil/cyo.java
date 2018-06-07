package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.DeviceErrorState;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.DeviceState;
import com.portfolio.platform.data.source.DeviceDataSource.LinkDeviceCallback;
import com.portfolio.platform.data.source.DeviceRepository;
import java.util.Date;

public class cyo extends ckb<C2525b, C2526d, C2523c> {
    private static final String TAG = cyo.class.getSimpleName();
    private gy cEa;
    private String cLg;
    private int cLh;
    private boolean cLi;
    private BroadcastReceiver cLj = new C25221(this);
    private DeviceRepository mDeviceRepository;
    private String mSerial;

    class C25221 extends BroadcastReceiver {
        static final /* synthetic */ boolean $assertionsDisabled = (!cyo.class.desiredAssertionStatus());
        final /* synthetic */ cyo cLk;

        class C25201 implements LinkDeviceCallback {
            final /* synthetic */ C25221 cLl;

            C25201(C25221 c25221) {
                this.cLl = c25221;
            }

            public void onSuccess(DeviceModel deviceModel) {
                MFLogger.m12670d(cyo.TAG, "linkDevice onSuccess device=" + deviceModel.getDeviceId());
                PortfolioApp.ZQ().an(deviceModel.getDeviceId(), deviceModel.getMacAddress());
                this.cLl.cLk.abr().onSuccess(new C2526d(deviceModel));
            }

            public void onFail(int i) {
                MFLogger.m12670d(cyo.TAG, "linkDevice onFail errorCode=" + i);
                try {
                    PortfolioApp.ZQ().fP(this.cLl.cLk.mSerial);
                } catch (Exception e) {
                    MFLogger.m12670d(cyo.TAG, "linkDevice onFail exception=" + e.getMessage());
                }
                this.cLl.cLk.abr().onError(new C2527e(this.cLl.cLk, i, this.cLl.cLk.mSerial));
            }
        }

        class C25212 implements LinkDeviceCallback {
            final /* synthetic */ C25221 cLl;

            C25212(C25221 c25221) {
                this.cLl = c25221;
            }

            public void onSuccess(DeviceModel deviceModel) {
                MFLogger.m12670d(cyo.TAG, "stealDevice onSuccess device=" + deviceModel.getDeviceId());
                PortfolioApp.ZQ().an(deviceModel.getDeviceId(), deviceModel.getMacAddress());
                this.cLl.cLk.abr().onSuccess(new C2526d(deviceModel));
            }

            public void onFail(int i) {
                MFLogger.m12670d(cyo.TAG, "stealDevice onFail errorCode=" + i);
                try {
                    PortfolioApp.ZQ().fP(this.cLl.cLk.mSerial);
                } catch (Exception e) {
                    MFLogger.m12670d(cyo.TAG, "stealDevice onFail exception=" + e.getMessage());
                }
                this.cLl.cLk.abr().onError(new C2527e(this.cLl.cLk, i, this.cLl.cLk.mSerial));
            }
        }

        C25221(cyo com_fossil_cyo) {
            this.cLk = com_fossil_cyo;
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal());
            int intExtra2 = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, DeviceErrorState.UNKNOWN_ERROR.getValue());
            CommunicateMode communicateMode = CommunicateMode.values()[intExtra];
            MFLogger.m12670d(cyo.TAG, "Inside .bleReceiver communicateMode=" + communicateMode + ", isExecuted=" + this.cLk.cLi + ", isSuccess=" + intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1));
            if (communicateMode == CommunicateMode.LINK && this.cLk.cLi) {
                this.cLk.cLi = false;
                if ($assertionsDisabled || intent.getExtras() != null) {
                    MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) intent.getExtras().getParcelable(Constants.DEVICE);
                    if (misfitDeviceProfile == null || intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) != ServiceActionResult.SUCCEEDED.ordinal()) {
                        try {
                            MFLogger.m12670d(cyo.TAG, "Pair device failed, remove this device on button service");
                            PortfolioApp.ZR().removePairedSerial(this.cLk.mSerial);
                            PortfolioApp.ZR().removeActiveSerial(this.cLk.mSerial);
                        } catch (Exception e) {
                            MFLogger.m12670d(cyo.TAG, "Pair device failed, remove this device on button service exception=" + e.getMessage());
                        }
                        this.cLk.abr().onError(new C2524a(this.cLk, intExtra2, this.cLk.mSerial));
                        return;
                    }
                    switch (this.cLk.cLh) {
                        case 0:
                            PortfolioApp.ZQ().m12691a(CommunicateMode.LINK, this.cLk.mSerial, "Normal link a device with serial " + this.cLk.mSerial);
                            this.cLk.mDeviceRepository.linkDevice(dqv.m9408a(misfitDeviceProfile, new Date(), DeviceState.Connected), new C25201(this));
                            return;
                        case 1:
                            MFLogger.m12670d(cyo.TAG, "stealDevice");
                            PortfolioApp.ZQ().m12691a(CommunicateMode.LINK, this.cLk.mSerial, "Steal a device with serial " + this.cLk.mSerial);
                            this.cLk.mDeviceRepository.stealDevice(dqv.m9408a(misfitDeviceProfile, new Date(), DeviceState.Connected), new C25212(this));
                            return;
                        default:
                            return;
                    }
                }
                throw new AssertionError();
            }
        }
    }

    public static class C2523c implements C2131a {
        private int errorCode;
        private String mDeviceId;

        C2523c(int i, String str) {
            this.errorCode = i;
            this.mDeviceId = str;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public class C2524a extends C2523c {
        final /* synthetic */ cyo cLk;

        C2524a(cyo com_fossil_cyo, int i, String str) {
            this.cLk = com_fossil_cyo;
            super(i, str);
        }
    }

    public static final class C2525b implements C2132b {
        private final String cLm;
        private final String mSerial;
        private int mode;

        public C2525b(String str, String str2, int i) {
            this.mSerial = (String) cco.m5996s(str, "device cannot be null!");
            this.cLm = (String) cco.m5996s(str2, "device cannot be null!");
            this.mode = i;
        }

        public String ajT() {
            return this.cLm;
        }

        public int getMode() {
            return this.mode;
        }

        public String ajU() {
            return this.mSerial;
        }

        public void setMode(int i) {
            this.mode = i;
        }
    }

    public static final class C2526d implements C2133c {
        private DeviceModel cKL;

        public C2526d(DeviceModel deviceModel) {
            this.cKL = deviceModel;
        }

        public DeviceModel ajK() {
            return this.cKL;
        }
    }

    public class C2527e extends C2523c {
        final /* synthetic */ cyo cLk;

        C2527e(cyo com_fossil_cyo, int i, String str) {
            this.cLk = com_fossil_cyo;
            super(i, str);
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7919a((C2525b) c2132b);
    }

    cyo(DeviceRepository deviceRepository, gy gyVar) {
        this.mDeviceRepository = deviceRepository;
        this.cEa = gyVar;
    }

    public void m7920a(ShineDevice shineDevice, int i, C2126d c2126d) {
        this.cLi = true;
        this.cLh = i;
        this.mSerial = shineDevice.getSerial();
        this.cLg = shineDevice.getMacAddress();
        m6879a(c2126d);
    }

    protected void m7919a(C2525b c2525b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.cLh = c2525b.getMode();
        this.mSerial = c2525b.ajU();
        this.cLg = c2525b.ajT();
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cLi = true;
            PortfolioApp.ZQ().ao(this.mSerial, this.cLg);
            return;
        }
        MFLogger.m12670d(TAG, "executeUseCase network error");
        abr().onError(new C2527e(this, 601, this.mSerial));
    }

    public void ajd() {
        this.cEa.m11537a(this.cLj, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cLj);
    }
}
