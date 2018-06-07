package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.link.PairDeviceActivity;

public final class czf implements emg<PairDeviceActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czf.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<czn> cLZ;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7969b((PairDeviceActivity) obj);
    }

    public czf(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<czn> com_fossil_eru_com_fossil_czn) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_czn != null) {
                    this.cLZ = com_fossil_eru_com_fossil_czn;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<PairDeviceActivity> m7968a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<czn> com_fossil_eru_com_fossil_czn) {
        return new czf(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_czn);
    }

    public void m7969b(PairDeviceActivity pairDeviceActivity) {
        if (pairDeviceActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        pairDeviceActivity.mUserRepository = (UserRepository) this.cnc.get();
        pairDeviceActivity.cEF = (cnr) this.cEM.get();
        pairDeviceActivity.cLY = (czn) this.cLZ.get();
    }
}
