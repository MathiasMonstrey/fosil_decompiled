package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.czc.C2561a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.data.source.DeviceRepository;

public class cye extends ckb<C2501a, C2503c, C2502b> {
    private static final String TAG = cye.class.getSimpleName();
    private final String cKK = "release";
    private DeviceRepository mDeviceRepository;
    private cnr mSharedPreferencesManager;

    public static final class C2501a implements C2132b {
        private DeviceModel cKL;
        private String mSerial;

        public C2501a(String str) {
            this.mSerial = str;
        }

        public C2501a(DeviceModel deviceModel) {
            this.cKL = deviceModel;
        }

        public String getSerial() {
            return this.mSerial;
        }

        public DeviceModel ajK() {
            return this.cKL;
        }
    }

    public static final class C2502b implements C2131a {
    }

    public static final class C2503c implements C2133c {
        private boolean cKM;

        public C2503c(boolean z) {
            this.cKM = z;
        }

        public boolean ajL() {
            return this.cKM;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7892a((C2501a) c2132b);
    }

    public cye(DeviceRepository deviceRepository, cnr com_fossil_cnr) {
        this.mDeviceRepository = deviceRepository;
        this.mSharedPreferencesManager = com_fossil_cnr;
    }

    protected void m7892a(C2501a c2501a) {
        DeviceModel deviceBySerial;
        DeviceModel ajK = c2501a.ajK();
        MFLogger.m12670d(TAG, "Inside .executeUseCase activeDevice=" + ajK);
        if (ajK == null) {
            deviceBySerial = this.mDeviceRepository.getDeviceBySerial(c2501a.getSerial(), null);
        } else {
            deviceBySerial = ajK;
        }
        if (deviceBySerial == null) {
            abr().onSuccess(new C2503c(true));
            return;
        }
        Firmware hr;
        String firmwareRevision = deviceBySerial.getFirmwareRevision();
        if ("release".equalsIgnoreCase("release") || !this.mSharedPreferencesManager.acE()) {
            hr = cnq.acd().act().hr(deviceBySerial.getSku());
        } else {
            hr = C2561a.m7960if(deviceBySerial.getSku());
            if (hr == null) {
                hr = cnq.acd().act().hr(deviceBySerial.getSku());
            }
        }
        MFLogger.m12670d(TAG, "Inside .executeUseCase latestFw=" + hr);
        if (hr == null) {
            MFLogger.m12671e(TAG, "Error when update firmware, can't find latest fw of model=" + deviceBySerial.getSku());
            abr().onSuccess(new C2503c(true));
            return;
        }
        MFLogger.m12670d(TAG, "Inside .executeUseCase CheckFirmwareActiveDeviceUseCase currentDeviceFw=" + firmwareRevision + ", latestFw=" + hr.getVersionNumber());
        if (hr.getVersionNumber().equalsIgnoreCase(firmwareRevision)) {
            abr().onSuccess(new C2503c(true));
        } else {
            abr().onSuccess(new C2503c(false));
        }
    }
}
