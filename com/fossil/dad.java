package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.log.MFLogger;

public class dad extends ckb<C2596a, C2597b, C2131a> {

    public static final class C2596a implements C2132b {
        private final String mDeviceId;

        public C2596a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2597b implements C2133c {
        private final DeviceLocation cNk;

        public C2597b(DeviceLocation deviceLocation) {
            this.cNk = deviceLocation;
        }

        public DeviceLocation akO() {
            return this.cNk;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8068a((C2596a) c2132b);
    }

    protected void m8068a(C2596a c2596a) {
        MFLogger.m12670d("GetLocation", "executeUseCase");
        DeviceLocation deviceLocation = cnq.acd().acl().getDeviceLocation(c2596a.getDeviceId());
        if (deviceLocation != null) {
            abr().onSuccess(new C2597b(deviceLocation));
        } else {
            abr().onError(null);
        }
    }
}
