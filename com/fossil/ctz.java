package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class ctz implements emg<ctx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctz.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<NotificationsRepository> cFY;
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> cys;

    public /* synthetic */ void injectMembers(Object obj) {
        m7580d((ctx) obj);
    }

    public ctz(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.cAF = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                        this.cFY = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ctx> m7579a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new ctz(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }

    public void m7580d(ctx com_fossil_ctx) {
        if (com_fossil_ctx == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_ctx.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_ctx.mDeviceRepository = (DeviceRepository) this.cys.get();
        com_fossil_ctx.mSharedPreferencesManager = (cnr) this.cAF.get();
        com_fossil_ctx.cFK = (NotificationsRepository) this.cFY.get();
    }
}
