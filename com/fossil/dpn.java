package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserDataSource.OnDeleteUserComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLogoutUserComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dpn extends ckb<C3064a, C3066c, C3065b> {
    private final SleepSessionsRepository cBa;
    private final ActivitiesRepository cxG;
    private final NotificationsRepository czp;
    private final DataVersioningRepository czr;
    private final cnr dcX;
    private final AlarmsRepository dcY;
    private final MicroAppSettingRepository mMicroAppSettingRepository;
    private final PresetRepository mPresetRepository;
    private final SleepSummariesRepository mSleepSummariesRepository;
    private final SummariesRepository mSummariesRepository;
    private final UserRepository mUserRepository;

    class C30621 implements OnDeleteUserComplete {
        final /* synthetic */ dpn dcZ;

        C30621(dpn com_fossil_dpn) {
            this.dcZ = com_fossil_dpn;
        }

        public void onSuccess() {
            this.dcZ.atJ();
            this.dcZ.abr().onSuccess(new C3066c());
        }

        public void onFailed(int i) {
            this.dcZ.abr().onError(new C3065b(i));
        }
    }

    class C30632 implements OnLogoutUserComplete {
        final /* synthetic */ dpn dcZ;

        C30632(dpn com_fossil_dpn) {
            this.dcZ = com_fossil_dpn;
        }

        public void onSuccess() {
            this.dcZ.atJ();
            this.dcZ.abr().onSuccess(new C3066c());
        }

        public void onFailed(int i) {
            switch (i) {
                case 401:
                case 404:
                    this.dcZ.atJ();
                    this.dcZ.abr().onSuccess(new C3066c());
                    return;
                default:
                    this.dcZ.abr().onError(new C3065b(i));
                    return;
            }
        }
    }

    public static final class C3064a implements C2132b {
        private int mode;

        public C3064a(int i) {
            this.mode = i;
        }

        public int getMode() {
            return this.mode;
        }
    }

    public static final class C3065b implements C2131a {
        private int errorCode;

        public C3065b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3066c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9337a((C3064a) c2132b);
    }

    public dpn(UserRepository userRepository, cnr com_fossil_cnr, PresetRepository presetRepository, ActivitiesRepository activitiesRepository, SummariesRepository summariesRepository, DataVersioningRepository dataVersioningRepository, MicroAppSettingRepository microAppSettingRepository, NotificationsRepository notificationsRepository, SleepSessionsRepository sleepSessionsRepository, AlarmsRepository alarmsRepository, SleepSummariesRepository sleepSummariesRepository) {
        this.mUserRepository = userRepository;
        this.dcX = com_fossil_cnr;
        this.mPresetRepository = presetRepository;
        this.cxG = activitiesRepository;
        this.mSummariesRepository = summariesRepository;
        this.czp = notificationsRepository;
        this.cBa = sleepSessionsRepository;
        this.mSleepSummariesRepository = sleepSummariesRepository;
        this.dcY = alarmsRepository;
        this.mMicroAppSettingRepository = microAppSettingRepository;
        this.czr = dataVersioningRepository;
    }

    protected void m9337a(C3064a c3064a) {
        if (!NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            abr().onError(new C3065b(601));
        } else if (c3064a.getMode() == 0) {
            this.mUserRepository.deleteUser(this.mUserRepository.getCurrentUser(), new C30621(this));
        } else if (c3064a.getMode() == 1) {
            this.mUserRepository.logoutUser(new C30632(this));
        }
    }

    private void atJ() {
        cnw.logOut();
        try {
            PortfolioApp.ZR().deviceUnlink(PortfolioApp.ZQ().aaa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mPresetRepository.clearData();
        this.cxG.cleanUp();
        this.mSummariesRepository.cleanUp();
        this.cBa.cleanUp();
        this.mSleepSummariesRepository.cleanUp();
        this.czp.clearAllNotificationSetting();
        this.czr.clearAllDataVersioning();
        this.mMicroAppSettingRepository.clearData();
        this.dcY.cleanUp();
        cok acp = cnq.acd().acp();
        acp.aec();
        acp.aeb();
        acp.aed();
        acp.aee();
        cnq.acd().reset();
        this.dcX.reset();
        clv.reset();
        PortfolioApp.ZQ().aap();
        PortfolioApp.ZQ().aab();
        this.mUserRepository.clearAllUser();
    }
}
