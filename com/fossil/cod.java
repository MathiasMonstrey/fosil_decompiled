package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.manager.network.BestTimeService;

public final class cod implements emg<BestTimeService> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cod.class.desiredAssertionStatus());
    private final eru<SleepSessionsRepository> cBb;
    private final eru<SleepSummariesRepository> cBc;
    private final eru<SummariesRepository> cnd;
    private final eru<ActivitiesRepository> cxL;

    public /* synthetic */ void injectMembers(Object obj) {
        m7337b((BestTimeService) obj);
    }

    public cod(eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
            this.cxL = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                this.cBb = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                    this.cnd = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                        this.cBc = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
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

    public static emg<BestTimeService> m7336a(eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new cod(com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }

    public void m7337b(BestTimeService bestTimeService) {
        if (bestTimeService == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bestTimeService.cxG = (ActivitiesRepository) this.cxL.get();
        bestTimeService.cBa = (SleepSessionsRepository) this.cBb.get();
        bestTimeService.mSummariesRepository = (SummariesRepository) this.cnd.get();
        bestTimeService.mSleepSummariesRepository = (SleepSummariesRepository) this.cBc.get();
    }
}
