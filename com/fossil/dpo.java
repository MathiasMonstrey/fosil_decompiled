package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpo implements emi<dpn> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpo.class.desiredAssertionStatus());
    private final eru<AlarmsRepository> ceE;
    private final eru<DataVersioningRepository> cfU;
    private final eru<ActivitiesRepository> cfd;
    private final eru<UserRepository> cnc;
    private final emg<dpn> dda;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<SleepSessionsRepository> sleepSessionsRepositoryProvider;
    private final eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;
    private final eru<SummariesRepository> summariesRepositoryProvider;

    public /* synthetic */ Object get() {
        return atK();
    }

    public dpo(emg<dpn> com_fossil_emg_com_fossil_dpn, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpn != null) {
            this.dda = com_fossil_emg_com_fossil_dpn;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                        this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                            this.cfd = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                                    this.cfU = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
                                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                                        this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                                            this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                                                this.sleepSessionsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
                                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                                                    this.ceE = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
                                                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                                                        this.sleepSummariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
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

    public dpn atK() {
        return (dpn) MembersInjectors.a(this.dda, new dpn((UserRepository) this.cnc.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (PresetRepository) this.presetRepositoryProvider.get(), (ActivitiesRepository) this.cfd.get(), (SummariesRepository) this.summariesRepositoryProvider.get(), (DataVersioningRepository) this.cfU.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (NotificationsRepository) this.notificationsRepositoryProvider.get(), (SleepSessionsRepository) this.sleepSessionsRepositoryProvider.get(), (AlarmsRepository) this.ceE.get(), (SleepSummariesRepository) this.sleepSummariesRepositoryProvider.get()));
    }

    public static emi<dpn> m9339a(emg<dpn> com_fossil_emg_com_fossil_dpn, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new dpo(com_fossil_emg_com_fossil_dpn, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
