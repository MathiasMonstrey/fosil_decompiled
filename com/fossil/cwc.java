package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.cwa.C2427a;
import com.fossil.cwa.C2428b;
import com.fossil.cys.C2533a;
import com.fossil.cys.C2534b;
import com.fossil.cys.C2535c;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.Collections;

public class cwc implements C2427a {
    private static final String TAG = cwc.class.getSimpleName();
    private final C2428b cII;
    private cys cIJ;
    private final PortfolioApp cIo;
    private DeviceRepository mDeviceRepository;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;

    cwc(C2428b c2428b, ckc com_fossil_ckc, cys com_fossil_cys, DeviceRepository deviceRepository, PortfolioApp portfolioApp, cnr com_fossil_cnr) {
        this.cII = (C2428b) cco.m5996s(c2428b, "view cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cIJ = (cys) cco.m5996s(com_fossil_cys, "setVibrationStrengthUseCase cannot be null!");
        this.cIo = (PortfolioApp) cco.m5996s(portfolioApp, "app cannot be null!");
        this.mDeviceRepository = (DeviceRepository) cco.m5996s(deviceRepository, "deviceRepository cannot be null!");
        this.mSharedPreferencesManager = (cnr) cco.m5996s(com_fossil_cnr, "sharedPreferencesManager cannot be null!");
    }

    public void start() {
        this.cIJ.ajd();
        this.cII.kg(this.mSharedPreferencesManager.gE(PortfolioApp.ZQ().aaa()));
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_VIBRATION_STRENGTH));
    }

    public void stop() {
        this.cIJ.aje();
    }

    public void ahu() {
        this.cII.cK(this);
    }

    public void setVibrationStrength(final int i) {
        MFLogger.m12670d(TAG, "setVibrationStrength() - vibrationStrength = " + i);
        this.cII.afL();
        this.mUseCaseHandler.m6886a(this.cIJ, new C2533a(PortfolioApp.ZQ().aaa(), i), new C2126d<C2535c, C2534b>(this) {
            final /* synthetic */ cwc cIL;

            public /* synthetic */ void onError(Object obj) {
                m7741a((C2534b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7742a((C2535c) obj);
            }

            public void m7742a(C2535c c2535c) {
                MFLogger.m12670d(cwc.TAG, "setVibrationStrength() - onSuccess");
                this.cIL.cII.afM();
                this.cIL.cII.kg(i);
            }

            public void m7741a(C2534b c2534b) {
                this.cIL.cII.afM();
                int ajg = c2534b.ajg();
                MFLogger.m12670d(cwc.TAG, "setVibrationStrength() - onError - lastErrorCode = " + ajg);
                if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                    this.cIL.cII.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(c2534b.ajf()).toArray(new PermissionCodes[0]));
                    return;
                }
                this.cIL.cII.aiM();
            }
        });
    }
}
