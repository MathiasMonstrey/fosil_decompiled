package com.fossil;

import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.receiver.UpgradeReceiver;

public final class cps implements emg<UpgradeReceiver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cps.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;
    private final eru<NotificationsRepository> czA;
    private final eru<ctd> czB;
    private final eru<LandingPageRepository> czC;
    private final eru<MicroAppSettingRepository> czk;
    private final eru<cnr> czx;
    private final eru<ckc> czy;
    private final eru<PresetRepository> czz;

    public /* synthetic */ void injectMembers(Object obj) {
        m7453b((UpgradeReceiver) obj);
    }

    public cps(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<ctd> com_fossil_eru_com_fossil_ctd, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.czx = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.czy = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                        this.czz = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                            this.czk = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                                this.czA = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_ctd != null) {
                                    this.czB = com_fossil_eru_com_fossil_ctd;
                                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                                        this.czC = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
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

    public static emg<UpgradeReceiver> m7452a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<ctd> com_fossil_eru_com_fossil_ctd, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        return new cps(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, com_fossil_eru_com_fossil_ctd, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository);
    }

    public void m7453b(UpgradeReceiver upgradeReceiver) {
        if (upgradeReceiver == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        upgradeReceiver.czn = (cnr) this.czx.get();
        upgradeReceiver.mUserRepository = (UserRepository) this.cnc.get();
        upgradeReceiver.czo = (ckc) this.czy.get();
        upgradeReceiver.mPresetRepository = (PresetRepository) this.czz.get();
        upgradeReceiver.mMicroAppSettingRepository = (MicroAppSettingRepository) this.czk.get();
        upgradeReceiver.czp = (NotificationsRepository) this.czA.get();
        upgradeReceiver.czq = (ctd) this.czB.get();
        upgradeReceiver.mLandingPageRepository = (LandingPageRepository) this.czC.get();
    }
}
