package com.fossil;

import com.fossil.dbn.C2624b;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.loader.ActivePresetLoader;

public final class dbq implements emi<dbp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbq.class.desiredAssertionStatus());
    private final eru<fj> cIC;
    private final eru<C2624b> cOH;
    private final eru<ActivePresetLoader> ciK;
    private final eru<LandingPageRepository> landingPageRepositoryProvider;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return alp();
    }

    public dbq(eru<C2624b> com_fossil_eru_com_fossil_dbn_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivePresetLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivePresetLoader, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dbn_b != null) {
            this.cOH = com_fossil_eru_com_fossil_dbn_b;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                this.cIC = com_fossil_eru_com_fossil_fj;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_ActivePresetLoader != null) {
                    this.ciK = com_fossil_eru_com_portfolio_platform_data_source_loader_ActivePresetLoader;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                        this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                            this.landingPageRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
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

    public dbp alp() {
        return new dbp((C2624b) this.cOH.get(), (fj) this.cIC.get(), (ActivePresetLoader) this.ciK.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (LandingPageRepository) this.landingPageRepositoryProvider.get());
    }

    public static emi<dbp> m8165b(eru<C2624b> com_fossil_eru_com_fossil_dbn_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivePresetLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivePresetLoader, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        return new dbq(com_fossil_eru_com_fossil_dbn_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_ActivePresetLoader, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository);
    }
}
