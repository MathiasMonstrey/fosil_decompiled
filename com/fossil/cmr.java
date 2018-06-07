package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.helper.DeviceHelper;

public final class cmr implements emg<DeviceHelper> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cmr.class.desiredAssertionStatus());
    private final eru<DeviceRepository> cys;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ void injectMembers(Object obj) {
        m7140b((DeviceHelper) obj);
    }

    public cmr(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceHelper> m7139a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        return new cmr(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository);
    }

    public void m7140b(DeviceHelper deviceHelper) {
        if (deviceHelper == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceHelper.cmQ = (cnr) this.sharedPreferencesManagerProvider.get();
        deviceHelper.mDeviceRepository = (DeviceRepository) this.cys.get();
    }
}
