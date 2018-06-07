package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.calibration.DeviceCalibrationActivity;

public final class cxs implements emg<DeviceCalibrationActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxs.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cxy> cHZ;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7863b((DeviceCalibrationActivity) obj);
    }

    public cxs(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cxy> com_fossil_eru_com_fossil_cxy) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cxy != null) {
                    this.cHZ = com_fossil_eru_com_fossil_cxy;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceCalibrationActivity> m7862a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cxy> com_fossil_eru_com_fossil_cxy) {
        return new cxs(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cxy);
    }

    public void m7863b(DeviceCalibrationActivity deviceCalibrationActivity) {
        if (deviceCalibrationActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceCalibrationActivity.mUserRepository = (UserRepository) this.cnc.get();
        deviceCalibrationActivity.cEF = (cnr) this.cEM.get();
        deviceCalibrationActivity.cKm = (cxy) this.cHZ.get();
    }
}
