package com.fossil;

import android.location.Location;
import com.fossil.civ.C2090a;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class daf extends ckb<C2599a, C2600b, C2131a> {
    private civ cNm;

    class C25981 implements C2090a {
        final /* synthetic */ daf cNn;

        C25981(daf com_fossil_daf) {
            this.cNn = com_fossil_daf;
        }

        public void mo2224a(Location location, int i) {
            if (i >= 0) {
                MFLogger.m12670d("LoadLocation", "onLocationUpdated OK");
                if (location != null) {
                    float accuracy = location.getAccuracy();
                    if (accuracy <= 500.0f) {
                        MFLogger.m12671e("LoadLocation", "onLocationUpdated - accuracy: " + accuracy);
                        try {
                            DeviceLocation deviceLocation = new DeviceLocation(PortfolioApp.ZQ().aaa(), location.getLatitude(), location.getLongitude(), System.currentTimeMillis());
                            cnq.acd().acl().saveDeviceLocation(deviceLocation);
                            this.cNn.abr().onSuccess(new C2600b(deviceLocation));
                        } catch (Exception e) {
                            this.cNn.abr().onError(null);
                        }
                        this.cNn.cNm.m6538b((C2090a) this);
                        return;
                    }
                    return;
                }
                return;
            }
            MFLogger.m12670d("LoadLocation", "onLocationUpdated error - error: " + i);
            this.cNn.cNm.m6538b((C2090a) this);
            this.cNn.abr().onError(null);
        }
    }

    public static final class C2599a implements C2132b {
    }

    public static final class C2600b implements C2133c {
        private final DeviceLocation cNk;

        public C2600b(DeviceLocation deviceLocation) {
            this.cNk = deviceLocation;
        }

        public DeviceLocation akO() {
            return this.cNk;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8073a((C2599a) c2132b);
    }

    daf(civ com_fossil_civ) {
        this.cNm = (civ) cco.m5996s(com_fossil_civ, "mfLocationService cannot be null!");
    }

    protected void m8073a(C2599a c2599a) {
        MFLogger.m12670d("LoadLocation", "executeUseCase");
        this.cNm.m6537a(new C25981(this));
    }
}
