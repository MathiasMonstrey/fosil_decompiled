package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.WidgetRepository;
import com.portfolio.platform.ui.SplashScreenActivity;

public final class cui implements emg<SplashScreenActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cui.class.desiredAssertionStatus());
    private final eru<WidgetRepository> cBC;
    private final eru<cnr> cGh;
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> cys;
    private final eru<LandingPageRepository> czC;

    public /* synthetic */ void injectMembers(Object obj) {
        m7588b((SplashScreenActivity) obj);
    }

    public cui(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cGh = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                    this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                        this.czC = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository != null) {
                            this.cBC = com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository;
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
        throw new AssertionError();
    }

    public static emg<SplashScreenActivity> m7587a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository) {
        return new cui(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository);
    }

    public void m7588b(SplashScreenActivity splashScreenActivity) {
        if (splashScreenActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        splashScreenActivity.mUserRepository = (UserRepository) this.cnc.get();
        splashScreenActivity.cEF = (cnr) this.cGh.get();
        splashScreenActivity.mDeviceRepository = (DeviceRepository) this.cys.get();
        splashScreenActivity.czn = (cnr) this.cGh.get();
        splashScreenActivity.mLandingPageRepository = (LandingPageRepository) this.czC.get();
        splashScreenActivity.mWidgetRepository = (WidgetRepository) this.cBC.get();
    }
}
