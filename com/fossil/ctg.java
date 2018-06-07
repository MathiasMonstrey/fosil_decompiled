package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import dagger.internal.MembersInjectors;

public final class ctg implements emi<ctf> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctg.class.desiredAssertionStatus());
    private final emg<ctf> cEr;
    private final eru<AlarmsRepository> ceE;
    private final eru<DataVersioningRepository> cfU;
    private final eru<ActivitiesRepository> cfd;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<SleepSessionsRepository> sleepSessionsRepositoryProvider;

    public /* synthetic */ Object get() {
        return afD();
    }

    public ctg(emg<ctf> com_fossil_emg_com_fossil_ctf, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ctf != null) {
            this.cEr = com_fossil_emg_com_fossil_ctf;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                this.cfd = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                    this.sleepSessionsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                        this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                            this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                                this.ceE = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                                    this.cfU = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ctf afD() {
        return (ctf) MembersInjectors.a(this.cEr, new ctf((ActivitiesRepository) this.cfd.get(), (SleepSessionsRepository) this.sleepSessionsRepositoryProvider.get(), (PresetRepository) this.presetRepositoryProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (AlarmsRepository) this.ceE.get(), (DataVersioningRepository) this.cfU.get()));
    }

    public static emi<ctf> m7501a(emg<ctf> com_fossil_emg_com_fossil_ctf, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        return new ctg(com_fossil_emg_com_fossil_ctf, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository);
    }
}
