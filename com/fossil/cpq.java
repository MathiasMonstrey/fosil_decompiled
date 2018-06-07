package com.fossil;

import com.portfolio.platform.data.source.ExploreRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.WidgetRepository;
import com.portfolio.platform.receiver.LocaleChangedReceiver;

public final class cpq implements emg<LocaleChangedReceiver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cpq.class.desiredAssertionStatus());
    private final eru<WidgetRepository> cBC;
    private final eru<ExploreRepository> cBD;
    private final eru<MicroAppSettingRepository> czk;

    public /* synthetic */ void injectMembers(Object obj) {
        m7449b((LocaleChangedReceiver) obj);
    }

    public cpq(eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository != null) {
            this.cBC = com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository != null) {
                this.cBD = com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                    this.czk = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<LocaleChangedReceiver> m7448a(eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new cpq(com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }

    public void m7449b(LocaleChangedReceiver localeChangedReceiver) {
        if (localeChangedReceiver == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localeChangedReceiver.mWidgetRepository = (WidgetRepository) this.cBC.get();
        localeChangedReceiver.mExplorationRepository = (ExploreRepository) this.cBD.get();
        localeChangedReceiver.mMicroAppSettingRepository = (MicroAppSettingRepository) this.czk.get();
    }
}
