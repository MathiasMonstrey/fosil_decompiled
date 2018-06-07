package com.fossil;

import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class cno implements emg<cnn> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cno.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;
    private final eru<NotificationsRepository> czA;
    private final eru<ctd> czB;
    private final eru<LandingPageRepository> czC;
    private final eru<DataVersioningRepository> czD;
    private final eru<MicroAppSettingRepository> czk;
    private final eru<cnr> czx;
    private final eru<ckc> czy;
    private final eru<PresetRepository> czz;

    public /* synthetic */ void injectMembers(Object obj) {
        m7226b((cnn) obj);
    }

    public cno(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<ctd> com_fossil_eru_com_fossil_ctd, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
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
                                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                                            this.czD = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
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

    public static emg<cnn> m7225a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, eru<ctd> com_fossil_eru_com_fossil_ctd, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        return new cno(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository, com_fossil_eru_com_fossil_ctd, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository);
    }

    public void m7226b(cnn com_fossil_cnn) {
        if (com_fossil_cnn == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cnn.czn = (cnr) this.czx.get();
        com_fossil_cnn.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_cnn.czo = (ckc) this.czy.get();
        com_fossil_cnn.mPresetRepository = (PresetRepository) this.czz.get();
        com_fossil_cnn.mMicroAppSettingRepository = (MicroAppSettingRepository) this.czk.get();
        com_fossil_cnn.czp = (NotificationsRepository) this.czA.get();
        com_fossil_cnn.czq = (ctd) this.czB.get();
        com_fossil_cnn.mLandingPageRepository = (LandingPageRepository) this.czC.get();
        com_fossil_cnn.czr = (DataVersioningRepository) this.czD.get();
    }
}
