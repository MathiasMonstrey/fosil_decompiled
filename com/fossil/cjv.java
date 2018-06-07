package com.fossil;

import android.content.ContentResolver;
import android.content.Context;
import com.fossil.cun.C2344b;
import com.fossil.cuv.C2358b;
import com.fossil.cvg.C2383b;
import com.fossil.cvr.C2402b;
import com.fossil.cwa.C2428b;
import com.fossil.cwj.C2442b;
import com.fossil.cwx.C2456b;
import com.fossil.cxl.C2479b;
import com.fossil.cxu.C2485b;
import com.fossil.czj.C2567b;
import com.fossil.czt.C2584b;
import com.fossil.daj.C2602b;
import com.fossil.dau.C2614b;
import com.fossil.dbg.C2620b;
import com.fossil.dbn.C2624b;
import com.fossil.dbr.C2633b;
import com.fossil.dbx.C2639b;
import com.fossil.dec.C2694b;
import com.fossil.dfp.C2727b;
import com.fossil.dgq.C2742b;
import com.fossil.dha.C2764b;
import com.fossil.dhh.C2785b;
import com.fossil.dhs.C2800b;
import com.fossil.dib.C2804b;
import com.fossil.dii.C2807b;
import com.fossil.dip.C2810b;
import com.fossil.diz.C2816b;
import com.fossil.dkr.C2908b;
import com.fossil.dlj.C2925b;
import com.fossil.dlq.C2939b;
import com.fossil.dlx.C2947b;
import com.fossil.dmc.C2954b;
import com.fossil.dmh.C2958b;
import com.fossil.dmo.C2967b;
import com.fossil.dmv.C2975b;
import com.fossil.dna.C2981b;
import com.fossil.dov.C3025b;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.source.ActivitiesDataSource;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.ActivitiesRepository_Factory;
import com.portfolio.platform.data.source.AlarmsDataSource;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.AlarmsRepository_Factory;
import com.portfolio.platform.data.source.AlarmsSettingDataSource;
import com.portfolio.platform.data.source.AlarmsSettingRepository;
import com.portfolio.platform.data.source.AlarmsSettingRepository_Factory;
import com.portfolio.platform.data.source.DataVersioningDataSource;
import com.portfolio.platform.data.source.DataVersioningModule;
import com.portfolio.platform.data.source.DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory;
import com.portfolio.platform.data.source.DataVersioningModule_ProvideDataVersioningRemoteDataSourceFactory;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DataVersioningRepository_Factory;
import com.portfolio.platform.data.source.DeviceDataSource;
import com.portfolio.platform.data.source.DeviceModule;
import com.portfolio.platform.data.source.DeviceModule_ProvideFitnessLocalDataSourceFactory;
import com.portfolio.platform.data.source.DeviceModule_ProvideFitnessRemoteDataSourceFactory;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.DeviceRepository_Factory;
import com.portfolio.platform.data.source.ExploreDataSource;
import com.portfolio.platform.data.source.ExploreRepository;
import com.portfolio.platform.data.source.ExploreRepositoryModule;
import com.portfolio.platform.data.source.ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory;
import com.portfolio.platform.data.source.ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory;
import com.portfolio.platform.data.source.ExploreRepository_Factory;
import com.portfolio.platform.data.source.IntegrationDataSource;
import com.portfolio.platform.data.source.IntegrationModule;
import com.portfolio.platform.data.source.IntegrationModule_ProvideLocalDataSourceFactory;
import com.portfolio.platform.data.source.IntegrationModule_ProvideRemoteDataSourceFactory;
import com.portfolio.platform.data.source.IntegrationRepository;
import com.portfolio.platform.data.source.IntegrationRepository_Factory;
import com.portfolio.platform.data.source.LandingPageDataSource;
import com.portfolio.platform.data.source.LandingPageModule;
import com.portfolio.platform.data.source.LandingPageModule_ProvideLocalDataSourceFactory;
import com.portfolio.platform.data.source.LandingPageModule_ProvideRemoteDataSourceFactory;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.LandingPageRepository_Factory;
import com.portfolio.platform.data.source.MicroAppSettingDataSource;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepositoryModule;
import com.portfolio.platform.data.source.MicroAppSettingRepositoryModule_ProvideFavoriteMappingSetLocalDataSourceFactory;
import com.portfolio.platform.data.source.MicroAppSettingRepositoryModule_ProvideFavoriteMappingSetRemoteDataSourceFactory;
import com.portfolio.platform.data.source.MicroAppSettingRepository_Factory;
import com.portfolio.platform.data.source.NotificationsDataSource;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.NotificationsRepositoryModule;
import com.portfolio.platform.data.source.NotificationsRepositoryModule_ProvideLocalNotificationsDataSourceFactory;
import com.portfolio.platform.data.source.NotificationsRepositoryModule_ProvideRemoteNotificationsDataSourceFactory;
import com.portfolio.platform.data.source.NotificationsRepository_Factory;
import com.portfolio.platform.data.source.PresetDataSource;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.PresetRepositoryModule;
import com.portfolio.platform.data.source.PresetRepositoryModule_ProvideFavoriteMappingSetLocalDataSourceFactory;
import com.portfolio.platform.data.source.PresetRepositoryModule_ProvideFavoriteMappingSetRemoteDataSourceFactory;
import com.portfolio.platform.data.source.PresetRepository_Factory;
import com.portfolio.platform.data.source.RepositoriesModule;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideActivitiesLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideAlarmsLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSleepSummariesRemoteDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSummariesLocalDataSourceFactory;
import com.portfolio.platform.data.source.RepositoriesModule_ProvideSummariesRemoteDataSourceFactory;
import com.portfolio.platform.data.source.SleepSessionsDataSource;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository_Factory;
import com.portfolio.platform.data.source.SleepSummariesDataSource;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository_Factory;
import com.portfolio.platform.data.source.SummariesDataSource;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository_Factory;
import com.portfolio.platform.data.source.UAppSystemVersionDataSource;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepositoryModule;
import com.portfolio.platform.data.source.UAppSystemVersionRepositoryModule_ProvideUserLocalDataSourceFactory;
import com.portfolio.platform.data.source.UAppSystemVersionRepository_Factory;
import com.portfolio.platform.data.source.UserDataSource;
import com.portfolio.platform.data.source.UserModule;
import com.portfolio.platform.data.source.UserModule_ProvideRemoteLocalDataSourceFactory;
import com.portfolio.platform.data.source.UserModule_ProvideUserLocalDataSourceFactory;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.UserRepository_Factory;
import com.portfolio.platform.data.source.WidgetDataSource;
import com.portfolio.platform.data.source.WidgetModule;
import com.portfolio.platform.data.source.WidgetModule_ProvideWidgetLocalDataSourceFactory;
import com.portfolio.platform.data.source.WidgetModule_ProvideWidgetRemoteDataSourceFactory;
import com.portfolio.platform.data.source.WidgetRepository;
import com.portfolio.platform.data.source.WidgetRepository_Factory;
import com.portfolio.platform.data.source.loader.ActivePresetLoader;
import com.portfolio.platform.data.source.loader.ActivePresetLoader_Factory;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader_Factory;
import com.portfolio.platform.data.source.loader.ActivitiesWeekLoader;
import com.portfolio.platform.data.source.loader.ActivitiesWeekLoader_Factory;
import com.portfolio.platform.data.source.loader.DeviceLoader;
import com.portfolio.platform.data.source.loader.DeviceLoader_MembersInjector;
import com.portfolio.platform.data.source.loader.ExploreLoader;
import com.portfolio.platform.data.source.loader.ExploreLoader_MembersInjector;
import com.portfolio.platform.data.source.loader.IntegrationLoader;
import com.portfolio.platform.data.source.loader.IntegrationLoader_MembersInjector;
import com.portfolio.platform.data.source.loader.MicroAppSettingListLoader;
import com.portfolio.platform.data.source.loader.MicroAppSettingListLoader_Factory;
import com.portfolio.platform.data.source.loader.MicroAppSettingsLoader;
import com.portfolio.platform.data.source.loader.MicroAppSettingsLoader_Factory;
import com.portfolio.platform.data.source.loader.NotificationsLoader;
import com.portfolio.platform.data.source.loader.NotificationsLoader_Factory;
import com.portfolio.platform.data.source.loader.SavedPresetListLoader;
import com.portfolio.platform.data.source.loader.SavedPresetListLoader_Factory;
import com.portfolio.platform.data.source.loader.SleepSessionsDayLoader;
import com.portfolio.platform.data.source.loader.SleepSessionsDayLoader_Factory;
import com.portfolio.platform.data.source.loader.SleepSessionsWeekLoader;
import com.portfolio.platform.data.source.loader.SleepSessionsWeekLoader_Factory;
import com.portfolio.platform.data.source.loader.SleepSummariesLoader;
import com.portfolio.platform.data.source.loader.SleepSummariesLoader_Factory;
import com.portfolio.platform.data.source.loader.SleepSummaryLoader;
import com.portfolio.platform.data.source.loader.SleepSummaryLoader_Factory;
import com.portfolio.platform.data.source.loader.SummariesLoader;
import com.portfolio.platform.data.source.loader.SummariesLoader_Factory;
import com.portfolio.platform.data.source.loader.SummaryLoader;
import com.portfolio.platform.data.source.loader.SummaryLoader_Factory;
import com.portfolio.platform.data.source.loader.WidgetLoader;
import com.portfolio.platform.data.source.loader.WidgetLoader_MembersInjector;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.manager.network.BestTimeService;
import com.portfolio.platform.receiver.AlarmReceiver;
import com.portfolio.platform.receiver.BootReceiver;
import com.portfolio.platform.receiver.LocaleChangedReceiver;
import com.portfolio.platform.receiver.NetworkChangedReceiver;
import com.portfolio.platform.receiver.UpgradeReceiver;
import com.portfolio.platform.service.ExecutePendingDataService;
import com.portfolio.platform.service.MFDeviceService;
import com.portfolio.platform.service.ThirdPartyUploadIntentService;
import com.portfolio.platform.service.microapp.CommuteTimeService;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.SplashScreenActivity;
import com.portfolio.platform.ui.buddychallenge.activity.BCCreateAccountActivity;
import com.portfolio.platform.ui.buddychallenge.activity.BCFindOpponentActivity;
import com.portfolio.platform.ui.debug.DebugActivity;
import com.portfolio.platform.ui.device.DeviceActivity;
import com.portfolio.platform.ui.device.alarm.main.AlarmMainActivity;
import com.portfolio.platform.ui.device.alarm.set.AlarmSetActivity;
import com.portfolio.platform.ui.device.battery.DeviceBatteryActivity;
import com.portfolio.platform.ui.device.calibration.DeviceCalibrationActivity;
import com.portfolio.platform.ui.device.link.PairDeviceActivity;
import com.portfolio.platform.ui.device.locate.map.DeviceLocateMapActivity;
import com.portfolio.platform.ui.device.locate.proximity.DeviceLocateProximityActivity;
import com.portfolio.platform.ui.notifications.contactandapp.NotificationContactAndAppActivity;
import com.portfolio.platform.ui.profile.changepassword.ChangePasswordActivity;
import com.portfolio.platform.ui.profile.connectedapps.ProfileConnectedAppsActivity;
import com.portfolio.platform.ui.profile.editprofile.EditProfileActivity;
import com.portfolio.platform.ui.profile.homeconfig.ProfileHomeConfigActivity;
import com.portfolio.platform.ui.profile.main.MainProfileActivity;
import com.portfolio.platform.ui.profile.optin.ProfileOptInActivity;
import com.portfolio.platform.ui.profile.preferences.ProfilePrefActivity;
import com.portfolio.platform.ui.profile.support.ProfileSupportActivity;
import com.portfolio.platform.ui.profile.unit.ProfileUnitActivity;
import com.portfolio.platform.ui.shortcuts.details.goaltracking.GoalTrackingEditActivity;
import com.portfolio.platform.ui.user.ForgotPasswordActivity;
import com.portfolio.platform.ui.user.LoginActivity;
import com.portfolio.platform.ui.user.LoginEmailActivity;
import com.portfolio.platform.ui.user.SignUpActivity;
import com.portfolio.platform.ui.user.SignUpEmailActivity;
import dagger.internal.MembersInjectors;
import java.util.Date;
import java.util.List;

public final class cjv implements ciy {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjv.class.desiredAssertionStatus());
    private eru<AlarmsSettingRepository> alarmsSettingRepositoryProvider;
    private eru<ciw> appExecutorsProvider;
    private eru<AlarmsRepository> ceE;
    private eru<Context> ceM;
    private eru<UserDataSource> ceN;
    private eru<UserDataSource> ceO;
    private eru<cnr> ceP;
    private eru<ckc> ceQ;
    private eru<PresetDataSource> ceR;
    private eru<PresetDataSource> ceS;
    private eru<MicroAppSettingDataSource> ceT;
    private eru<MicroAppSettingDataSource> ceU;
    private eru<UAppSystemVersionDataSource> ceV;
    private eru<NotificationsDataSource> ceW;
    private eru<NotificationsDataSource> ceX;
    private eru<MFNetwork> ceY;
    private eru<ActivitiesDataSource> ceZ;
    private emg<BestTimeService> cfA;
    private eru<DeviceDataSource> cfB;
    private eru<DeviceDataSource> cfC;
    private emg<DeviceHelper> cfD;
    private emg<cmt> cfE;
    private emg<cng> cfF;
    private eru<cka> cfG;
    private eru<djg> cfH;
    private eru<djo> cfI;
    private eru<dkc> cfJ;
    private eru<ctb> cfK;
    private eru<cth> cfL;
    private emg<MFDeviceService> cfM;
    private emg<AlarmReceiver> cfN;
    private eru<DataVersioningDataSource> cfO;
    private eru<DataVersioningDataSource> cfP;
    private eru<WidgetDataSource> cfQ;
    private eru<WidgetDataSource> cfR;
    private eru<ExploreDataSource> cfS;
    private eru<ExploreDataSource> cfT;
    private eru<DataVersioningRepository> cfU;
    private eru<ctf> cfV;
    private emg<NetworkChangedReceiver> cfW;
    private emg<ExecutePendingDataService> cfX;
    private emg<cnk> cfY;
    private emg<cml> cfZ;
    private eru<cnq> cfa;
    private eru<ActivitiesDataSource> cfb;
    private eru<bbm> cfc;
    private eru<ActivitiesRepository> cfd;
    private eru<SleepSessionsDataSource> cfe;
    private eru<ctd> cff;
    private eru<LandingPageDataSource> cfg;
    private eru<LandingPageDataSource> cfh;
    private emg<UpgradeReceiver> cfi;
    private eru<SummariesDataSource> cfj;
    private eru<SummariesDataSource> cfk;
    private eru<cyw> cfl;
    private eru<AlarmsDataSource> cfm;
    private eru<AlarmsDataSource> cfn;
    private eru<AlarmsSettingDataSource> cfo;
    private eru<AlarmsSettingDataSource> cfp;
    private eru<cmi> cfq;
    private eru<PortfolioApp> cfr;
    private eru<ddh> cfs;
    private eru<ddj> cft;
    private eru<ContentResolver> cfu;
    private eru<dqs> cfv;
    private emg<PortfolioApp> cfw;
    private eru<SleepSessionsDataSource> cfx;
    private eru<SleepSummariesDataSource> cfy;
    private eru<SleepSummariesDataSource> cfz;
    private eru<cmx> cgA;
    private emg<ThirdPartyUploadIntentService> cgB;
    private eru<cmj> cgC;
    private eru<cng> cgD;
    private eru<civ> cgE;
    private eru<cmw> cgF;
    private eru<cns> cgG;
    private emg<cnu> cga;
    private emg<cnw> cgb;
    private emg<coa> cgc;
    private emg<cny> cgd;
    private emg<ctj> cge;
    private eru<cza> cgf;
    private emg<DebugActivity> cgg;
    private emg<SplashScreenActivity> cgh;
    private emg<WidgetLoader> cgi;
    private emg<ExploreLoader> cgj;
    private eru<IntegrationDataSource> cgk;
    private eru<IntegrationDataSource> cgl;
    private eru<IntegrationRepository> cgm;
    private emg<IntegrationLoader> cgn;
    private eru<gy> cgo;
    private eru<djk> cgp;
    private emg<CommuteTimeService> cgq;
    private emg<ddn> cgr;
    private emg<ddl> cgs;
    private emg<dch> cgt;
    private emg<DeviceLoader> cgu;
    private emg<LocaleChangedReceiver> cgv;
    private emg<dby> cgw;
    private emg<BootReceiver> cgx;
    private emg<cnn> cgy;
    private eru<ecp> cgz;
    private eru<DeviceRepository> deviceRepositoryProvider;
    private eru<ExploreRepository> exploreRepositoryProvider;
    private eru<cyk> fetchFirmwareListUseCaseProvider;
    private eru<LandingPageRepository> landingPageRepositoryProvider;
    private eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private eru<NotificationsRepository> notificationsRepositoryProvider;
    private eru<PresetRepository> presetRepositoryProvider;
    private eru<SleepSessionsRepository> sleepSessionsRepositoryProvider;
    private eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;
    private eru<SummariesRepository> summariesRepositoryProvider;
    private eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;
    private eru<UserRepository> userRepositoryProvider;
    private eru<WidgetRepository> widgetRepositoryProvider;

    final class C2098a implements cwi {
        private final cwm cgH;
        private emg<cwl> cgI;
        private eru<C2442b> cgJ;
        private eru<String> cgK;
        private eru<cwt> cgL;
        private eru<cxh> cgM;
        private eru<cwr> cgN;
        private eru<cwl> cgO;
        private emg<AlarmMainActivity> cgP;
        final /* synthetic */ cjv cgQ;

        private C2098a(cjv com_fossil_cjv, cwm com_fossil_cwm) {
            this.cgQ = com_fossil_cjv;
            this.cgH = (cwm) emj.ce(com_fossil_cwm);
            initialize();
        }

        private void initialize() {
            this.cgI = cwq.ahw();
            this.cgJ = cwn.m7799b(this.cgH);
            this.cgK = cwo.m7800b(this.cgH);
            this.cgL = cwu.m7810a(MembersInjectors.aEQ(), this.cgQ.ceE);
            this.cgM = cxi.create(MembersInjectors.aEQ(), this.cgQ.cfr, this.cgQ.cgo, this.cgQ.ceE);
            this.cgN = cws.create(MembersInjectors.aEQ(), this.cgQ.cgo, this.cgQ.ceE);
            this.cgO = cwp.m7801a(this.cgI, this.cgQ.ceM, this.cgQ.cgC, this.cgJ, this.cgQ.cfq, this.cgQ.ceP, this.cgK, this.cgQ.ceQ, this.cgL, this.cgM, this.cgN);
            this.cgP = cwg.m7753a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cgO);
        }

        public void mo1755a(AlarmMainActivity alarmMainActivity) {
            this.cgP.injectMembers(alarmMainActivity);
        }
    }

    final class aa implements dfo {
        final /* synthetic */ cjv cgQ;
        private eru<dpl> cil;
        private eru<dpf> cim;
        private eru<C2727b> cjA;
        private final dfr ckT;
        private emg<dft> ckU;
        private eru<dft> ckV;
        private emg<ProfileOptInActivity> ckW;

        private aa(cjv com_fossil_cjv, dfr com_fossil_dfr) {
            this.cgQ = com_fossil_cjv;
            this.ckT = (dfr) emj.ce(com_fossil_dfr);
            initialize();
        }

        private void initialize() {
            this.ckU = dfv.create(this.cgQ.userRepositoryProvider);
            this.cjA = dfs.m8484b(this.ckT);
            this.cim = dpg.m9324a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.ckV = dfu.m8492a(this.ckU, this.cjA, this.cgQ.ceQ, this.cim, this.cil, this.cgQ.ceM);
            this.ckW = dfn.m8480a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.ckV);
        }

        public void mo1756a(ProfileOptInActivity profileOptInActivity) {
            this.ckW.injectMembers(profileOptInActivity);
        }
    }

    final class ab implements dfx {
        final /* synthetic */ cjv cgQ;
        private eru cjA;
        private final dga ckX;
        private emg<dgc> ckY;
        private eru<dgc> ckZ;
        private emg<ProfilePrefActivity> cla;

        private ab(cjv com_fossil_cjv, dga com_fossil_dga) {
            this.cgQ = com_fossil_cjv;
            this.ckX = (dga) emj.ce(com_fossil_dga);
            initialize();
        }

        private void initialize() {
            this.ckY = dge.ahw();
            this.cjA = dgb.m8498b(this.ckX);
            this.ckZ = dgd.create(this.ckY, this.cjA, this.cgQ.ceQ);
            this.cla = dfw.m8494a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.ckZ);
        }

        public void mo1757a(ProfilePrefActivity profilePrefActivity) {
            this.cla.injectMembers(profilePrefActivity);
        }
    }

    final class ac implements dgg {
        final /* synthetic */ cjv cgQ;
        private eru cjA;
        private final dgj clb;
        private emg<dgl> clc;
        private eru<dgl> cld;
        private emg<ProfileSupportActivity> cle;

        private ac(cjv com_fossil_cjv, dgj com_fossil_dgj) {
            this.cgQ = com_fossil_cjv;
            this.clb = (dgj) emj.ce(com_fossil_dgj);
            initialize();
        }

        private void initialize() {
            this.clc = dgn.ahw();
            this.cjA = dgk.m8504b(this.clb);
            this.cld = dgm.create(this.clc, this.cjA, this.cgQ.ceQ, this.cgQ.ceP);
            this.cle = dgf.m8500a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cld);
        }

        public void mo1758a(ProfileSupportActivity profileSupportActivity) {
            this.cle.injectMembers(profileSupportActivity);
        }
    }

    final class ad implements dgp {
        final /* synthetic */ cjv cgQ;
        private eru<dpl> cil;
        private eru<dpf> cim;
        private eru<C2742b> cjA;
        private final dgt clf;
        private emg<dgv> clg;
        private eru<dgv> clh;
        private emg<ProfileUnitActivity> cli;

        private ad(cjv com_fossil_cjv, dgt com_fossil_dgt) {
            this.cgQ = com_fossil_cjv;
            this.clf = (dgt) emj.ce(com_fossil_dgt);
            initialize();
        }

        private void initialize() {
            this.clg = dgx.ahw();
            this.cjA = dgu.m8520b(this.clf);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cim = dpg.m9324a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.clh = dgw.create(this.clg, this.cjA, this.cgQ.ceQ, this.cil, this.cim);
            this.cli = dgo.m8506a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.clh);
        }

        public void mo1759a(ProfileUnitActivity profileUnitActivity) {
            this.cli.injectMembers(profileUnitActivity);
        }
    }

    final class ae implements czi {
        final /* synthetic */ cjv cgQ;
        private eru<cyy> chO;
        private eru<dji> cjd;
        private eru<cye> cju;
        private eru<czc> cjv;
        private final czl clj;
        private emg<czn> clk;
        private eru<C2567b> cll;
        private eru<cyo> clm;
        private eru<cyi> cln;
        private eru<cyg> clo;
        private eru<czn> clp;
        private emg<PairDeviceActivity> clq;

        private ae(cjv com_fossil_cjv, czl com_fossil_czl) {
            this.cgQ = com_fossil_cjv;
            this.clj = (czl) emj.ce(com_fossil_czl);
            initialize();
        }

        private void initialize() {
            this.clk = czp.m8029a(this.cgQ.ceP, this.cgQ.userRepositoryProvider);
            this.cll = czm.m7985b(this.clj);
            this.clm = cyp.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.cgo);
            this.chO = cyz.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.userRepositoryProvider, this.cgQ.cfU);
            this.cjv = czd.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.ceP, this.cgQ.cfU);
            this.cln = cyj.m7902a(MembersInjectors.aEQ(), this.cgQ.ceY);
            this.cjd = djj.create(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider, this.cgQ.presetRepositoryProvider);
            this.cju = cyf.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.ceP);
            this.clo = cyh.m7898a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.clp = czo.m8028a(this.clk, this.cll, this.cgQ.ceQ, this.clm, this.chO, this.cjv, this.cgQ.cfU, this.cln, this.cjd, this.cju, this.cgQ.cfK, this.clo);
            this.clq = czf.m7968a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.clp);
        }

        public void mo1760a(PairDeviceActivity pairDeviceActivity) {
            this.clq.injectMembers(pairDeviceActivity);
        }
    }

    final class af implements dhg {
        final /* synthetic */ cjv cgQ;
        private eru<fj> chM;
        private eru<ActivePresetLoader> ciK;
        private eru<dkg> cjQ;
        private emg<dhb> clA;
        private final dhl clr;
        private emg<dhk> cls;
        private eru<C2785b> clt;
        private eru<MicroApp> clu;
        private eru<djp> clv;
        private eru<dko> clw;
        private eru<dka> clx;
        private eru<MicroAppSettingsLoader> cly;
        private eru<dhk> clz;

        private af(cjv com_fossil_cjv, dhl com_fossil_dhl) {
            this.cgQ = com_fossil_cjv;
            this.clr = (dhl) emj.ce(com_fossil_dhl);
            initialize();
        }

        private void initialize() {
            this.cls = dhq.ahw();
            this.clt = dhm.m8720b(this.clr);
            this.clu = dho.m8722b(this.clr);
            this.clv = djq.m8846a(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider);
            this.clw = dkp.m8939a(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider);
            this.chM = dhn.m8721b(this.clr);
            this.ciK = ActivePresetLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.presetRepositoryProvider);
            this.cjQ = dkh.create(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cgo);
            this.clx = dkb.create(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider, this.cgQ.presetRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cgo);
            this.cly = MicroAppSettingsLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.microAppSettingRepositoryProvider);
            this.clz = dhp.m8723a(this.cls, this.clt, this.clu, this.clv, this.clw, this.chM, this.ciK, this.cjQ, this.cgQ.cfJ, this.clx, this.cly, this.cgQ.ceQ);
            this.clA = dhc.create(this.clz);
        }

        public void mo1761a(dhb com_fossil_dhb) {
            this.clA.injectMembers(com_fossil_dhb);
        }
    }

    final class ag implements doh {
        final /* synthetic */ cjv cgQ;
        private eru<cyq> chN;
        private emg<dng> ciV;
        private eru ciW;
        private eru<ctj> ciX;
        private eru<dpx> ciY;
        private eru<dpz> ciZ;
        private eru<dqd> cja;
        private eru<dqb> cjb;
        private eru<dpt> cjc;
        private eru<dji> cjd;
        private eru<dpr> cje;
        private eru<dlo> cjf;
        private eru<dlv> cjg;
        private eru<dmm> cjh;
        private eru<dmt> cji;
        private eru<dng> cjj;
        private final dos clB;
        private emg<SignUpActivity> clC;

        private ag(cjv com_fossil_cjv, dos com_fossil_dos) {
            this.cgQ = com_fossil_cjv;
            this.clB = (dos) emj.ce(com_fossil_dos);
            initialize();
        }

        private void initialize() {
            this.ciV = dni.m9177a(this.cgQ.userRepositoryProvider, this.cgQ.deviceRepositoryProvider, this.cgQ.ceE, this.cgQ.ceP, this.cgQ.landingPageRepositoryProvider);
            this.ciW = dou.m9259b(this.clB);
            this.ciX = dot.m9258b(this.clB);
            this.ciY = dpy.m9355a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.ciZ = dqa.m9359a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cja = dqe.m9365a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjb = dqc.m9362a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjc = dpu.m9349a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.chN = cyr.m7926a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.cjd = djj.create(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider, this.cgQ.presetRepositoryProvider);
            this.cje = dps.m9346a(MembersInjectors.aEQ());
            this.cjf = dlp.create(MembersInjectors.aEQ(), this.cgQ.cfd, this.cgQ.userRepositoryProvider);
            this.cjg = dlw.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjh = dmn.create(MembersInjectors.aEQ(), this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cji = dmu.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjj = dnh.m9176a(this.ciV, this.ciW, this.cgQ.ceQ, this.ciX, this.ciY, this.ciZ, this.cja, this.cjb, this.cjc, this.chN, this.cjd, this.cje, this.cjf, this.cjg, this.cjh, this.cji);
            this.clC = dog.m9221a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cjj);
        }

        public void mo1762a(SignUpActivity signUpActivity) {
            this.clC.injectMembers(signUpActivity);
        }
    }

    final class ah implements doj {
        final /* synthetic */ cjv cgQ;
        private eru ciW;
        private eru<dlv> cjg;
        private eru<dmt> cji;
        private final dom clD;
        private emg<doo> clE;
        private eru<dqh> clF;
        private eru<doo> clG;
        private emg<SignUpEmailActivity> clH;

        private ah(cjv com_fossil_cjv, dom com_fossil_dom) {
            this.cgQ = com_fossil_cjv;
            this.clD = (dom) emj.ce(com_fossil_dom);
            initialize();
        }

        private void initialize() {
            this.clE = doq.m9254a(this.cgQ.userRepositoryProvider, this.cgQ.deviceRepositoryProvider);
            this.ciW = don.m9240b(this.clD);
            this.clF = dqi.m9371a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjg = dlw.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cji = dmu.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.clG = dop.m9253a(this.clE, this.ciW, this.clF, this.cgQ.ceQ, this.cjg, this.cji, this.cgQ.ceP, this.cgQ.cgC);
            this.clH = doi.m9223a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.clG);
        }

        public void mo1763a(SignUpEmailActivity signUpEmailActivity) {
            this.clH.injectMembers(signUpEmailActivity);
        }
    }

    final class ai implements dkq {
        final /* synthetic */ cjv cgQ;
        private eru<fj> chM;
        private emg<doy> ciA;
        private eru<C3025b> ciB;
        private eru<dpd> ciC;
        private eru<dpb> ciD;
        private eru<dpj> ciE;
        private eru<dph> ciF;
        private eru<doy> ciG;
        private eru<ActivitiesDayLoader> ciQ;
        private eru<dpl> cil;
        private eru<dpf> cim;
        private eru<dlo> cjf;
        private eru<dlv> cjg;
        private eru<dmm> cjh;
        private eru<dmt> cji;
        private final dku clI;
        private emg<dll> clJ;
        private eru<C2925b> clK;
        private eru<dll> clL;
        private emg<dls> clM;
        private eru<C2939b> clN;
        private eru<SummariesLoader> clO;
        private eru<dls> clP;
        private emg<dme> clQ;
        private eru<C2954b> clR;
        private eru<ActivitiesWeekLoader> clS;
        private eru<dme> clT;
        private emg<dlz> clU;
        private eru<C2947b> clV;
        private eru<dlz> clW;
        private emg<dmj> clX;
        private eru<C2958b> clY;
        private eru<SleepSessionsDayLoader> clZ;
        private eru<dmj> cma;
        private emg<dmq> cmb;
        private eru<C2967b> cmc;
        private eru<SleepSummariesLoader> cme;
        private eru<dmq> cmf;
        private emg<dnc> cmg;
        private eru<C2981b> cmh;
        private eru<SleepSessionsWeekLoader> cmi;
        private eru<dnc> cmj;
        private emg<dmx> cmk;
        private eru<C2975b> cml;
        private eru<SleepSummaryLoader> cmm;
        private eru<dmx> cmn;
        private emg<cvh> cmo;
        private eru<C2383b> cmp;
        private eru<cvh> cmq;
        private emg<dks> cmr;

        private ai(cjv com_fossil_cjv, dku com_fossil_dku) {
            this.cgQ = com_fossil_cjv;
            this.clI = (dku) emj.ce(com_fossil_dku);
            initialize();
        }

        private void initialize() {
            this.clJ = dln.ahw();
            this.clK = dkw.m8947b(this.clI);
            this.chM = dkv.m8946b(this.clI);
            this.ciQ = ActivitiesDayLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.cfd, this.cgQ.summariesRepositoryProvider);
            this.cim = dpg.m9324a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjf = dlp.create(MembersInjectors.aEQ(), this.cgQ.cfd, this.cgQ.userRepositoryProvider);
            this.cjg = dlw.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.clL = dlm.m9013a(this.clJ, this.clK, this.cgQ.ceP, this.cgQ.cgo, this.chM, this.ciQ, this.cgQ.ceQ, this.cim, this.cjf, this.cjg, this.cgQ.cfr, this.cgQ.userRepositoryProvider);
            this.clM = dlu.ahw();
            this.clN = dkx.m8948b(this.clI);
            this.clO = SummariesLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.summariesRepositoryProvider);
            this.clP = dlt.m9036a(this.clM, this.clN, this.chM, this.clO, this.cgQ.userRepositoryProvider, this.cgQ.ceQ, this.cim, this.cjg);
            this.clQ = dmg.ahw();
            this.clR = dkz.m8950b(this.clI);
            this.clS = ActivitiesWeekLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.cfd, this.cgQ.summariesRepositoryProvider);
            this.clT = dmf.create(this.clQ, this.clR, this.chM, this.clS, this.cgQ.userRepositoryProvider);
            this.clU = dmb.ahw();
            this.clV = dky.m8949b(this.clI);
            this.clW = dma.create(this.clU, this.clV, this.chM, this.ciQ);
            this.clX = dml.ahw();
            this.clY = dlb.m8954b(this.clI);
            this.clZ = SleepSessionsDayLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.sleepSummariesRepositoryProvider);
            this.cjh = dmn.create(MembersInjectors.aEQ(), this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cji = dmu.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cma = dmk.m9092a(this.clX, this.cgQ.cfr, this.clY, this.cgQ.ceP, this.cgQ.cgo, this.chM, this.clZ, this.cgQ.ceQ, this.cjh, this.cji, this.cgQ.userRepositoryProvider);
            this.cmb = dms.ahw();
            this.cmc = dlc.m8955b(this.clI);
            this.cme = SleepSummariesLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.sleepSummariesRepositoryProvider);
            this.cmf = dmr.m9115a(this.cmb, this.cmc, this.chM, this.cme, this.cgQ.userRepositoryProvider, this.cgQ.ceQ, this.cim, this.cji);
            this.cmg = dne.ahw();
            this.cmh = dle.m8957b(this.clI);
            this.cmi = SleepSessionsWeekLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.sleepSummariesRepositoryProvider);
            this.cmj = dnd.m9147a(this.cmg, this.cmh, this.chM, this.cmi, this.cgQ.userRepositoryProvider, this.cgQ.ceQ);
            this.cmk = dmz.ahw();
            this.cml = dld.m8956b(this.clI);
            this.cmm = SleepSummaryLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.sleepSummariesRepositoryProvider);
            this.cmn = dmy.create(this.cmk, this.cml, this.chM, this.cmm);
            this.ciA = dpa.ahw();
            this.ciB = dlf.m8958b(this.clI);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.ciC = dpe.m9322a(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider);
            this.ciD = dpc.m9319a(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider);
            this.ciE = dpk.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.cfd);
            this.ciF = dpi.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.sleepSessionsRepositoryProvider);
            this.ciG = doz.m9312a(this.ciA, this.ciB, this.cgQ.ceQ, this.cim, this.cil, this.ciC, this.ciD, this.ciE, this.ciF, this.cgQ.cfr);
            this.cmo = cvj.ahw();
            this.cmp = dla.m8953b(this.clI);
            this.cmq = cvi.create(this.cmo, this.cmp, this.cgQ.ceQ, this.ciC);
            this.cmr = dkt.m8944a(this.clL, this.clP, this.clT, this.clW, this.cma, this.cmf, this.cmj, this.cmn, this.ciG, this.cmq);
        }

        public void mo1764a(dks com_fossil_dks) {
            this.cmr.injectMembers(com_fossil_dks);
        }
    }

    final class aj implements cuj {
        final /* synthetic */ cjv cgQ;
        private final cuk cms;
        private emg<cwc> cmt;
        private eru<C2428b> cmu;
        private eru<cys> cmv;
        private eru<cwc> cmw;
        private emg<cvs> cmx;

        private aj(cjv com_fossil_cjv, cuk com_fossil_cuk) {
            this.cgQ = com_fossil_cjv;
            this.cms = (cuk) emj.ce(com_fossil_cuk);
            initialize();
        }

        private void initialize() {
            this.cmt = cwe.ahw();
            this.cmu = cul.m7589b(this.cms);
            this.cmv = cyt.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.cgo, this.cgQ.ceP);
            this.cmw = cwd.m7744a(this.cmt, this.cmu, this.cgQ.ceQ, this.cmv, this.cgQ.deviceRepositoryProvider, this.cgQ.cfr, this.cgQ.ceP);
            this.cmx = cvt.create(this.cmw);
        }

        public void mo1765a(cvs com_fossil_cvs) {
            this.cmx.injectMembers(com_fossil_cvs);
        }
    }

    final class C2099b implements cww {
        private eru<String> cgK;
        private eru<cxh> cgM;
        final /* synthetic */ cjv cgQ;
        private final cxa cgR;
        private emg<cwz> cgS;
        private eru<C2456b> cgT;
        private eru<List<Alarm>> cgU;
        private eru<Alarm> cgV;
        private eru<cwz> cgW;
        private emg<AlarmSetActivity> cgX;

        private C2099b(cjv com_fossil_cjv, cxa com_fossil_cxa) {
            this.cgQ = com_fossil_cjv;
            this.cgR = (cxa) emj.ce(com_fossil_cxa);
            initialize();
        }

        private void initialize() {
            this.cgS = cxg.ahw();
            this.cgT = cxb.m7839b(this.cgR);
            this.cgK = cxe.m7842b(this.cgR);
            this.cgU = cxd.m7841b(this.cgR);
            this.cgV = cxc.m7840b(this.cgR);
            this.cgM = cxi.create(MembersInjectors.aEQ(), this.cgQ.cfr, this.cgQ.cgo, this.cgQ.ceE);
            this.cgW = cxf.m7843a(this.cgS, this.cgQ.ceM, this.cgQ.cgC, this.cgT, this.cgK, this.cgU, this.cgV, this.cgQ.ceQ, this.cgM);
            this.cgX = cwv.m7811a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cgW);
        }

        public void mo1766a(AlarmSetActivity alarmSetActivity) {
            this.cgX.injectMembers(alarmSetActivity);
        }
    }

    final class C2100c implements cum {
        final /* synthetic */ cjv cgQ;
        private final cup cgY;
        private emg<cur> cgZ;
        private eru<C2344b> cha;
        private eru<cur> chb;
        private emg<BCCreateAccountActivity> chc;

        private C2100c(cjv com_fossil_cjv, cup com_fossil_cup) {
            this.cgQ = com_fossil_cjv;
            this.cgY = (cup) emj.ce(com_fossil_cup);
            initialize();
        }

        private void initialize() {
            this.cgZ = cut.ahw();
            this.cha = cuq.m7605b(this.cgY);
            this.chb = cus.m7609a(this.cgZ, this.cha);
            this.chc = cvl.m7681a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chb);
        }

        public void mo1767a(BCCreateAccountActivity bCCreateAccountActivity) {
            this.chc.injectMembers(bCCreateAccountActivity);
        }
    }

    final class C2101d implements cuu {
        final /* synthetic */ cjv cgQ;
        private eru<C2358b> cha;
        private final cux chd;
        private emg<cuz> che;
        private eru<cuz> chf;
        private emg<BCFindOpponentActivity> chg;

        private C2101d(cjv com_fossil_cjv, cux com_fossil_cux) {
            this.cgQ = com_fossil_cjv;
            this.chd = (cux) emj.ce(com_fossil_cux);
            initialize();
        }

        private void initialize() {
            this.che = cvb.ahw();
            this.cha = cuy.m7614b(this.chd);
            this.chf = cva.m7617a(this.che, this.cha);
            this.chg = cvm.m7683a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chf);
        }

        public void mo1768a(BCFindOpponentActivity bCFindOpponentActivity) {
            this.chg.injectMembers(bCFindOpponentActivity);
        }
    }

    public static final class C2102e {
        private ciz chh;
        private UserModule chi;
        private PresetRepositoryModule chj;
        private MicroAppSettingRepositoryModule chk;
        private UAppSystemVersionRepositoryModule chl;
        private NotificationsRepositoryModule chm;
        private RepositoriesModule chn;
        private LandingPageModule cho;
        private DeviceModule chp;
        private DataVersioningModule chq;
        private WidgetModule chr;
        private ExploreRepositoryModule chs;
        private IntegrationModule cht;

        private C2102e() {
        }

        public ciy ZO() {
            if (this.chh == null) {
                throw new IllegalStateException(ciz.class.getCanonicalName() + " must be set");
            }
            if (this.chi == null) {
                this.chi = new UserModule();
            }
            if (this.chj == null) {
                this.chj = new PresetRepositoryModule();
            }
            if (this.chk == null) {
                this.chk = new MicroAppSettingRepositoryModule();
            }
            if (this.chl == null) {
                this.chl = new UAppSystemVersionRepositoryModule();
            }
            if (this.chm == null) {
                this.chm = new NotificationsRepositoryModule();
            }
            if (this.chn == null) {
                this.chn = new RepositoriesModule();
            }
            if (this.cho == null) {
                this.cho = new LandingPageModule();
            }
            if (this.chp == null) {
                this.chp = new DeviceModule();
            }
            if (this.chq == null) {
                this.chq = new DataVersioningModule();
            }
            if (this.chr == null) {
                this.chr = new WidgetModule();
            }
            if (this.chs == null) {
                this.chs = new ExploreRepositoryModule();
            }
            if (this.cht == null) {
                this.cht = new IntegrationModule();
            }
            return new cjv();
        }

        public C2102e m6691b(ciz com_fossil_ciz) {
            this.chh = (ciz) emj.ce(com_fossil_ciz);
            return this;
        }
    }

    final class C2103f implements ddt {
        final /* synthetic */ cjv cgQ;
        private final ddv chu;
        private emg<ddx> chv;
        private eru chw;
        private eru<ddx> chx;
        private emg<ChangePasswordActivity> chy;

        private C2103f(cjv com_fossil_cjv, ddv com_fossil_ddv) {
            this.cgQ = com_fossil_cjv;
            this.chu = (ddv) emj.ce(com_fossil_ddv);
            initialize();
        }

        private void initialize() {
            this.chv = ddz.ahw();
            this.chw = ddw.m8395b(this.chu);
            this.chx = ddy.create(this.chv, this.chw, this.cgQ.ceQ);
            this.chy = dds.m8393a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chx);
        }

        public void mo1769a(ChangePasswordActivity changePasswordActivity) {
            this.chy.injectMembers(changePasswordActivity);
        }
    }

    final class C2104g implements cxk {
        final /* synthetic */ cjv cgQ;
        private emg<cxp> chA;
        private eru<C2479b> chB;
        private eru<cxp> chC;
        private emg<DeviceBatteryActivity> chD;
        private final cxn chz;

        private C2104g(cjv com_fossil_cjv, cxn com_fossil_cxn) {
            this.cgQ = com_fossil_cjv;
            this.chz = (cxn) emj.ce(com_fossil_cxn);
            initialize();
        }

        private void initialize() {
            this.chA = cxr.ahw();
            this.chB = cxo.m7859b(this.chz);
            this.chC = cxq.m7860a(this.chA, this.chB);
            this.chD = cxj.m7853a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chC);
        }

        public void mo1770a(DeviceBatteryActivity deviceBatteryActivity) {
            this.chD.injectMembers(deviceBatteryActivity);
        }
    }

    final class C2105h implements cxt {
        final /* synthetic */ cjv cgQ;
        private final cxw chE;
        private emg<cxy> chF;
        private eru<C2485b> chG;
        private eru<cxy> chH;
        private emg<DeviceCalibrationActivity> chI;

        private C2105h(cjv com_fossil_cjv, cxw com_fossil_cxw) {
            this.cgQ = com_fossil_cjv;
            this.chE = (cxw) emj.ce(com_fossil_cxw);
            initialize();
        }

        private void initialize() {
            this.chF = cya.ahw();
            this.chG = cxx.m7871b(this.chE);
            this.chH = cxz.create(this.chF, this.cgQ.cfr, this.chG, this.cgQ.cgo, this.cgQ.cgD);
            this.chI = cxs.m7862a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chH);
        }

        public void mo1771a(DeviceCalibrationActivity deviceCalibrationActivity) {
            this.chI.injectMembers(deviceCalibrationActivity);
        }
    }

    final class C2106i implements cvq {
        final /* synthetic */ cjv cgQ;
        private final cvu chJ;
        private emg<cvx> chK;
        private eru<C2402b> chL;
        private eru<fj> chM;
        private eru<cyq> chN;
        private eru<cyy> chO;
        private eru<cyu> chP;
        private eru<cym> chQ;
        private eru<cyc> chR;
        private eru<cvx> chS;
        private emg<DeviceActivity> chT;

        private C2106i(cjv com_fossil_cjv, cvu com_fossil_cvu) {
            this.cgQ = com_fossil_cjv;
            this.chJ = (cvu) emj.ce(com_fossil_cvu);
            initialize();
        }

        private void initialize() {
            this.chK = cvz.create(this.cgQ.userRepositoryProvider);
            this.chL = cvv.m7707b(this.chJ);
            this.chM = cvw.m7708b(this.chJ);
            this.chN = cyr.m7926a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.chO = cyz.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.userRepositoryProvider, this.cgQ.cfU);
            this.chP = cyv.m7942a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider, this.cgQ.deviceRepositoryProvider, this.cgQ.presetRepositoryProvider, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cfU, this.cgQ.appExecutorsProvider);
            this.chQ = cyn.m7913a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.chR = cyd.m7891a(MembersInjectors.aEQ());
            this.chS = cvy.m7734a(this.chK, this.cgQ.cfr, this.chL, this.cgQ.ceP, this.cgQ.cgo, this.cgQ.cfa, this.chM, this.cgQ.cfq, this.cgQ.ceQ, this.chN, this.chO, this.chP, this.cgQ.deviceRepositoryProvider, this.cgQ.userRepositoryProvider, this.chQ, this.chR);
            this.chT = cvp.m7692a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.chS);
        }

        public void mo1772a(DeviceActivity deviceActivity) {
            this.chT.injectMembers(deviceActivity);
        }
    }

    final class C2107j implements czs {
        private eru<String> cgK;
        final /* synthetic */ cjv cgQ;
        private final czw chU;
        private emg<czv> chV;
        private eru<C2584b> chW;
        private eru<dad> chX;
        private eru<daf> chY;
        private eru<dab> chZ;
        private eru<czv> cia;
        private emg<DeviceLocateMapActivity> cib;

        private C2107j(cjv com_fossil_cjv, czw com_fossil_czw) {
            this.cgQ = com_fossil_cjv;
            this.chU = (czw) emj.ce(com_fossil_czw);
            initialize();
        }

        private void initialize() {
            this.chV = daa.ahw();
            this.cgK = czx.m8061b(this.chU);
            this.chW = czy.m8062b(this.chU);
            this.chX = dae.m8070a(MembersInjectors.aEQ());
            this.chY = dag.m8075a(MembersInjectors.aEQ(), this.cgQ.cgE);
            this.chZ = dac.m8067a(MembersInjectors.aEQ());
            this.cia = czz.m8063a(this.chV, this.cgQ.cgo, this.cgK, this.chW, this.cgQ.ceQ, this.chX, this.chY, this.chZ);
            this.cib = czr.m8036a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cia);
        }

        public void mo1773a(DeviceLocateMapActivity deviceLocateMapActivity) {
            this.cib.injectMembers(deviceLocateMapActivity);
        }
    }

    final class C2108k implements dai {
        private eru<String> cgK;
        final /* synthetic */ cjv cgQ;
        private final dam cic;
        private emg<dal> cid;
        private eru<C2602b> cie;
        private eru<dar> cif;
        private eru<dal> cig;
        private emg<DeviceLocateProximityActivity> cih;

        private C2108k(cjv com_fossil_cjv, dam com_fossil_dam) {
            this.cgQ = com_fossil_cjv;
            this.cic = (dam) emj.ce(com_fossil_dam);
            initialize();
        }

        private void initialize() {
            this.cid = daq.ahw();
            this.cgK = dan.m8095b(this.cic);
            this.cie = dao.m8096b(this.cic);
            this.cif = das.m8104a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.cig = dap.m8097a(this.cid, this.cgQ.ceM, this.cgQ.ceP, this.cgK, this.cie, this.cgQ.ceQ, this.cgQ.userRepositoryProvider, this.cif);
            this.cih = dah.m8076a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cig);
        }

        public void mo1774a(DeviceLocateProximityActivity deviceLocateProximityActivity) {
            this.cih.injectMembers(deviceLocateProximityActivity);
        }
    }

    final class C2109l implements dek {
        final /* synthetic */ cjv cgQ;
        private final den cii;
        private emg<dep> cij;
        private eru cik;
        private eru<dpl> cil;
        private eru<dpf> cim;
        private eru<dep> cin;
        private emg<EditProfileActivity> cio;

        private C2109l(cjv com_fossil_cjv, den com_fossil_den) {
            this.cgQ = com_fossil_cjv;
            this.cii = (den) emj.ce(com_fossil_den);
            initialize();
        }

        private void initialize() {
            this.cij = der.ahw();
            this.cik = deo.m8436b(this.cii);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cim = dpg.m9324a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cin = deq.create(this.cij, this.cik, this.cil, this.cim, this.cgQ.ceQ);
            this.cio = dej.m8428a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cin);
        }

        public void mo1775a(EditProfileActivity editProfileActivity) {
            this.cio.injectMembers(editProfileActivity);
        }
    }

    final class C2110m implements dnk {
        final /* synthetic */ cjv cgQ;
        private final dnn cip;
        private eru ciq;
        private eru<dqf> cir;
        private eru<dnp> cis;
        private emg<ForgotPasswordActivity> cit;

        private C2110m(cjv com_fossil_cjv, dnn com_fossil_dnn) {
            this.cgQ = com_fossil_cjv;
            this.cip = (dnn) emj.ce(com_fossil_dnn);
            initialize();
        }

        private void initialize() {
            this.ciq = dno.m9183b(this.cip);
            this.cir = dqg.m9368a(MembersInjectors.aEQ());
            this.cis = dnq.create(this.ciq, this.cgQ.ceQ, this.cir);
            this.cit = dnj.m9179a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cis);
        }

        public void mo1776a(ForgotPasswordActivity forgotPasswordActivity) {
            this.cit.injectMembers(forgotPasswordActivity);
        }
    }

    final class C2111n implements dia {
        final /* synthetic */ cjv cgQ;
        private final die ciu;
        private eru<C2804b> civ;
        private eru<String> ciw;
        private eru<did> cix;
        private emg<GoalTrackingEditActivity> ciy;

        private C2111n(cjv com_fossil_cjv, die com_fossil_die) {
            this.cgQ = com_fossil_cjv;
            this.ciu = (die) emj.ce(com_fossil_die);
            initialize();
        }

        private void initialize() {
            this.civ = dif.m8752b(this.ciu);
            this.ciw = dig.m8753b(this.ciu);
            this.cix = dih.m8754b(this.civ, this.ciw, this.cgQ.cfI, this.cgQ.cfJ, this.cgQ.ceQ);
            this.ciy = dhz.m8733a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cix);
        }

        public void mo1777a(GoalTrackingEditActivity goalTrackingEditActivity) {
            this.ciy.injectMembers(goalTrackingEditActivity);
        }
    }

    final class C2112o implements dbf {
        final /* synthetic */ cjv cgQ;
        private emg<doy> ciA;
        private eru<C3025b> ciB;
        private eru<dpd> ciC;
        private eru<dpb> ciD;
        private eru<dpj> ciE;
        private eru<dph> ciF;
        private eru<doy> ciG;
        private emg<dbh> ciH;
        private eru<dpl> cil;
        private eru<dpf> cim;
        private final dbj ciz;

        private C2112o(cjv com_fossil_cjv, dbj com_fossil_dbj) {
            this.cgQ = com_fossil_cjv;
            this.ciz = (dbj) emj.ce(com_fossil_dbj);
            initialize();
        }

        private void initialize() {
            this.ciA = dpa.ahw();
            this.ciB = dbk.m8132b(this.ciz);
            this.cim = dpg.m9324a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.ciC = dpe.m9322a(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider);
            this.ciD = dpc.m9319a(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider);
            this.ciE = dpk.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.cfd);
            this.ciF = dpi.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.sleepSessionsRepositoryProvider);
            this.ciG = doz.m9312a(this.ciA, this.ciB, this.cgQ.ceQ, this.cim, this.cil, this.ciC, this.ciD, this.ciE, this.ciF, this.cgQ.cfr);
            this.ciH = dbi.create(this.ciG);
        }

        public void mo1778a(dbh com_fossil_dbh) {
            this.ciH.injectMembers(com_fossil_dbh);
        }
    }

    final class C2113p implements dat {
        final /* synthetic */ cjv cgQ;
        private eru<fj> chM;
        private final dax ciI;
        private eru<C2624b> ciJ;
        private eru<ActivePresetLoader> ciK;
        private eru<dbp> ciL;
        private eru<C2633b> ciM;
        private eru<NotificationsLoader> ciN;
        private eru<dbt> ciO;
        private eru<C2620b> ciP;
        private eru<ActivitiesDayLoader> ciQ;
        private eru<SummaryLoader> ciR;
        private eru<dbl> ciS;
        private emg<dav> ciT;

        private C2113p(cjv com_fossil_cjv, dax com_fossil_dax) {
            this.cgQ = com_fossil_cjv;
            this.ciI = (dax) emj.ce(com_fossil_dax);
            initialize();
        }

        private void initialize() {
            this.ciJ = daz.m8112b(this.ciI);
            this.chM = dbb.m8114b(this.ciI);
            this.ciK = ActivePresetLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.presetRepositoryProvider);
            this.ciL = dbq.m8165b(this.ciJ, this.chM, this.ciK, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.landingPageRepositoryProvider);
            this.ciM = dba.m8113b(this.ciI);
            this.ciN = NotificationsLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.notificationsRepositoryProvider);
            this.ciO = dbu.create(this.ciM, this.chM, this.cgQ.landingPageRepositoryProvider, this.ciN);
            this.ciP = day.m8111b(this.ciI);
            this.ciQ = ActivitiesDayLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.cfd, this.cgQ.summariesRepositoryProvider);
            this.ciR = SummaryLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.summariesRepositoryProvider);
            this.ciS = dbm.m8143b(this.ciP, this.chM, this.ciQ, this.ciR, this.cgQ.landingPageRepositoryProvider);
            this.ciT = daw.m8109a(this.ciL, this.ciO, this.ciS);
        }

        public void mo1779a(dav com_fossil_dav) {
            this.ciT.injectMembers(com_fossil_dav);
        }
    }

    final class C2114q implements dns {
        final /* synthetic */ cjv cgQ;
        private eru<cyq> chN;
        private final dod ciU;
        private emg<dng> ciV;
        private eru ciW;
        private eru<ctj> ciX;
        private eru<dpx> ciY;
        private eru<dpz> ciZ;
        private eru<dqd> cja;
        private eru<dqb> cjb;
        private eru<dpt> cjc;
        private eru<dji> cjd;
        private eru<dpr> cje;
        private eru<dlo> cjf;
        private eru<dlv> cjg;
        private eru<dmm> cjh;
        private eru<dmt> cji;
        private eru<dng> cjj;
        private emg<LoginActivity> cjk;

        private C2114q(cjv com_fossil_cjv, dod com_fossil_dod) {
            this.cgQ = com_fossil_cjv;
            this.ciU = (dod) emj.ce(com_fossil_dod);
            initialize();
        }

        private void initialize() {
            this.ciV = dni.m9177a(this.cgQ.userRepositoryProvider, this.cgQ.deviceRepositoryProvider, this.cgQ.ceE, this.cgQ.ceP, this.cgQ.landingPageRepositoryProvider);
            this.ciW = dof.m9220b(this.ciU);
            this.ciX = doe.m9219b(this.ciU);
            this.ciY = dpy.m9355a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.ciZ = dqa.m9359a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cja = dqe.m9365a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjb = dqc.m9362a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjc = dpu.m9349a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.chN = cyr.m7926a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.cjd = djj.create(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider, this.cgQ.presetRepositoryProvider);
            this.cje = dps.m9346a(MembersInjectors.aEQ());
            this.cjf = dlp.create(MembersInjectors.aEQ(), this.cgQ.cfd, this.cgQ.userRepositoryProvider);
            this.cjg = dlw.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjh = dmn.create(MembersInjectors.aEQ(), this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cji = dmu.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjj = dnh.m9176a(this.ciV, this.ciW, this.cgQ.ceQ, this.ciX, this.ciY, this.ciZ, this.cja, this.cjb, this.cjc, this.chN, this.cjd, this.cje, this.cjf, this.cjg, this.cjh, this.cji);
            this.cjk = dnr.m9187a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cjj);
        }

        public void mo1780a(LoginActivity loginActivity) {
            this.cjk.injectMembers(loginActivity);
        }
    }

    final class C2115r implements dnu {
        final /* synthetic */ cjv cgQ;
        private eru<cyq> chN;
        private eru<dpt> cjc;
        private eru<dji> cjd;
        private eru<dpr> cje;
        private eru<dlo> cjf;
        private eru<dlv> cjg;
        private eru<dmm> cjh;
        private eru<dmt> cji;
        private final dnx cjl;
        private emg<dnz> cjm;
        private eru cjn;
        private eru<dpv> cjo;
        private eru<dnz> cjp;
        private emg<LoginEmailActivity> cjq;

        private C2115r(cjv com_fossil_cjv, dnx com_fossil_dnx) {
            this.cgQ = com_fossil_cjv;
            this.cjl = (dnx) emj.ce(com_fossil_dnx);
            initialize();
        }

        private void initialize() {
            this.cjm = dob.m9215a(this.cgQ.userRepositoryProvider, this.cgQ.ceE, this.cgQ.deviceRepositoryProvider, this.cgQ.ceP, this.cgQ.landingPageRepositoryProvider);
            this.cjn = dny.m9194b(this.cjl);
            this.cjo = dpw.m9352a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjc = dpu.m9349a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjd = djj.create(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider, this.cgQ.presetRepositoryProvider);
            this.chN = cyr.m7926a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.cje = dps.m9346a(MembersInjectors.aEQ());
            this.cjf = dlp.create(MembersInjectors.aEQ(), this.cgQ.cfd, this.cgQ.userRepositoryProvider);
            this.cjg = dlw.create(MembersInjectors.aEQ(), this.cgQ.summariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjh = dmn.create(MembersInjectors.aEQ(), this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cji = dmu.create(MembersInjectors.aEQ(), this.cgQ.sleepSummariesRepositoryProvider, this.cgQ.userRepositoryProvider);
            this.cjp = doa.m9214a(this.cjm, this.cjn, this.cgQ.ceQ, this.cjo, this.cjc, this.cjd, this.chN, this.cje, this.cgQ.cgC, this.cjf, this.cjg, this.cjh, this.cji);
            this.cjq = dnt.m9189a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cjp);
        }

        public void mo1781a(LoginEmailActivity loginEmailActivity) {
            this.cjq.injectMembers(loginEmailActivity);
        }
    }

    final class C2116s implements ctr {
        final /* synthetic */ cjv cgQ;
        private eru<cyy> chO;
        private final ctv cjr;
        private emg<ctx> cjs;
        private eru cjt;
        private eru<cye> cju;
        private eru<czc> cjv;
        private eru<ctx> cjw;
        private emg<MainActivity> cjx;

        private C2116s(cjv com_fossil_cjv, ctv com_fossil_ctv) {
            this.cgQ = com_fossil_cjv;
            this.cjr = (ctv) emj.ce(com_fossil_ctv);
            initialize();
        }

        private void initialize() {
            this.cjs = ctz.m7579a(this.cgQ.userRepositoryProvider, this.cgQ.deviceRepositoryProvider, this.cgQ.ceP, this.cgQ.notificationsRepositoryProvider);
            this.cjt = ctw.m7562b(this.cjr);
            this.cju = cyf.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.ceP);
            this.cjv = czd.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.ceP, this.cgQ.cfU);
            this.chO = cyz.create(MembersInjectors.aEQ(), this.cgQ.deviceRepositoryProvider, this.cgQ.userRepositoryProvider, this.cgQ.cfU);
            this.cjw = cty.m7578a(this.cjs, this.cjt, this.cgQ.ceQ, this.cgQ.cfU, this.cju, this.cjv, this.chO, this.cgQ.userRepositoryProvider, this.cgQ.ceM, this.cgQ.cfq);
            this.cjx = ctq.m7525a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cjw);
        }

        public void mo1782a(MainActivity mainActivity) {
            this.cjx.injectMembers(mainActivity);
        }
    }

    final class C2117t implements dff {
        final /* synthetic */ cjv cgQ;
        private eru<dpl> cil;
        private eru cjA;
        private eru<dpn> cjB;
        private eru<dpp> cjC;
        private eru<dfk> cjD;
        private emg<MainProfileActivity> cjE;
        private final dfi cjy;
        private emg<dfk> cjz;

        private C2117t(cjv com_fossil_cjv, dfi com_fossil_dfi) {
            this.cgQ = com_fossil_cjv;
            this.cjy = (dfi) emj.ce(com_fossil_dfi);
            initialize();
        }

        private void initialize() {
            this.cjz = dfm.create(this.cgQ.userRepositoryProvider);
            this.cjA = dfj.m8465b(this.cjy);
            this.cjB = dpo.m9339a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cgQ.presetRepositoryProvider, this.cgQ.cfd, this.cgQ.summariesRepositoryProvider, this.cgQ.cfU, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.notificationsRepositoryProvider, this.cgQ.sleepSessionsRepositoryProvider, this.cgQ.ceE, this.cgQ.sleepSummariesRepositoryProvider);
            this.cjC = dpq.m9341a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cil = dpm.m9335a(MembersInjectors.aEQ(), this.cgQ.userRepositoryProvider);
            this.cjD = dfl.m8478a(this.cjz, this.cjA, this.cgQ.ceQ, this.cjB, this.cjC, this.cil);
            this.cjE = dfe.m8456a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.cjD);
        }

        public void mo1783a(MainProfileActivity mainProfileActivity) {
            this.cjE.injectMembers(mainProfileActivity);
        }
    }

    final class C2118u implements cua {
        final /* synthetic */ cjv cgQ;
        private eru<fj> chM;
        private eru<ActivePresetLoader> ciK;
        private eru<NotificationsLoader> ciN;
        private final cub cjF;
        private emg<dbc> cjG;
        private eru<C2614b> cjH;
        private eru<dbc> cjI;
        private emg<dhd> cjJ;
        private eru<C2764b> cjK;
        private eru<djy> cjL;
        private eru<dke> cjM;
        private eru<dki> cjN;
        private eru<djm> cjO;
        private eru<dje> cjP;
        private eru<dkg> cjQ;
        private eru<dkm> cjR;
        private eru<dju> cjS;
        private eru<SavedPresetListLoader> cjT;
        private eru<MicroAppSettingListLoader> cjU;
        private eru<dhd> cjV;
        private emg<dcb> cjW;
        private eru<C2639b> cjX;
        private eru<ddb> cjY;
        private eru<dcb> cjZ;
        private emg<dlg> cka;
        private eru<C2908b> ckb;
        private eru<Date> ckc;
        private eru<dlg> ckd;
        private emg<ctt> cke;

        private C2118u(cjv com_fossil_cjv, cub com_fossil_cub) {
            this.cgQ = com_fossil_cjv;
            this.cjF = (cub) emj.ce(com_fossil_cub);
            initialize();
        }

        private void initialize() {
            this.cjG = dbe.ahw();
            this.cjH = cue.m7583b(this.cjF);
            this.chM = cuf.m7584b(this.cjF);
            this.cjI = dbd.create(this.cjG, this.cgQ.cfr, this.cjH, this.cgQ.cgo, this.chM);
            this.cjJ = dhf.create(this.cgQ.ceP);
            this.cjK = cud.m7582b(this.cjF);
            this.cjL = djz.m8858a(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider);
            this.cjM = dkf.m8884a(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider);
            this.cjN = dkj.create(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cgo);
            this.cjO = djn.m8841a(MembersInjectors.aEQ(), this.cgQ.microAppSettingRepositoryProvider);
            this.cjP = djf.m8818a(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider);
            this.cjQ = dkh.create(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cgo);
            this.cjR = dkn.create(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider, this.cgQ.microAppSettingRepositoryProvider, this.cgQ.uAppSystemVersionRepositoryProvider, this.cgQ.cgo);
            this.cjS = djv.m8853a(MembersInjectors.aEQ(), this.cgQ.presetRepositoryProvider);
            this.cjT = SavedPresetListLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.presetRepositoryProvider);
            this.ciK = ActivePresetLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.presetRepositoryProvider);
            this.cjU = MicroAppSettingListLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.microAppSettingRepositoryProvider);
            this.cjV = dhe.m8664a(this.cjJ, this.cjK, this.cgQ.cgo, this.cjL, this.cjM, this.cjN, this.cjO, this.cjP, this.cjQ, this.cjR, this.cjS, this.chM, this.cjT, this.ciK, this.cjU, this.cgQ.ceQ);
            this.cjW = dcd.ahw();
            this.cjX = cug.m7585b(this.cjF);
            this.ciN = NotificationsLoader_Factory.create(MembersInjectors.aEQ(), this.cgQ.ceM, this.cgQ.notificationsRepositoryProvider);
            this.cjY = ddc.m8357a(MembersInjectors.aEQ(), this.cgQ.notificationsRepositoryProvider);
            this.cjZ = dcc.m8205a(this.cjW, this.cjX, this.cgQ.cgo, this.chM, this.cgQ.ceP, this.ciN, this.cjY, this.cgQ.ceQ);
            this.cka = dli.ahw();
            this.ckb = cuh.m7586b(this.cjF);
            this.ckc = cuc.m7581b(this.cjF);
            this.ckd = dlh.m8974a(this.cka, this.cgQ.cfr, this.ckb, this.ckc, this.cgQ.ceP, this.cgQ.cgo);
            this.cke = ctu.m7560a(this.cjI, this.cjV, this.cjZ, this.ckd, this.cgQ.ceP);
        }

        public void mo1784a(ctt com_fossil_ctt) {
            this.cke.injectMembers(com_fossil_ctt);
        }
    }

    final class C2119v implements dhr {
        final /* synthetic */ cjv cgQ;
        private eru<fj> chM;
        private final dil ckf;
        private final dhv ckg;
        private final dis ckh;
        private final dix cki;
        private eru<C2807b> ckj;
        private eru<dik> ckk;
        private emg<dhu> ckl;
        private eru<C2800b> ckm;
        private eru<dhu> ckn;
        private emg<dir> cko;
        private eru<C2810b> ckp;
        private eru<djw> ckq;
        private eru<dir> ckr;
        private emg<djb> cks;
        private eru<C2816b> ckt;
        private eru<djs> cku;
        private eru<dkk> ckv;
        private eru<djb> ckw;
        private emg<dhi> ckx;

        private C2119v(cjv com_fossil_cjv, dil com_fossil_dil, dhv com_fossil_dhv, dis com_fossil_dis, dix com_fossil_dix) {
            this.cgQ = com_fossil_cjv;
            this.ckf = (dil) emj.ce(com_fossil_dil);
            this.ckg = (dhv) emj.ce(com_fossil_dhv);
            this.ckh = (dis) emj.ce(com_fossil_dis);
            this.cki = (dix) emj.ce(com_fossil_dix);
            initialize();
        }

        private void initialize() {
            this.ckj = dim.m8769a(this.ckf);
            this.chM = din.m8770a(this.ckf);
            this.ckk = dio.m8771a(this.ckj, this.cgQ.cfI, this.cgQ.cfJ, this.cgQ.ceQ, this.cgQ.ceP, this.chM);
            this.ckl = dhy.ahw();
            this.ckm = dhw.m8730a(this.ckg);
            this.ckn = dhx.m8731a(this.ckl, this.ckm);
            this.cko = div.ahw();
            this.ckp = dit.m8783a(this.ckh);
            this.ckq = djx.m8855a(MembersInjectors.aEQ());
            this.ckr = diu.create(this.cko, this.ckp, this.ckq, this.cgQ.cgG, this.cgQ.ceQ);
            this.cks = djd.ahw();
            this.ckt = diy.m8790a(this.cki);
            this.cku = djt.m8850a(MembersInjectors.aEQ(), this.cgQ.ceM);
            this.ckv = dkl.m8924a(MembersInjectors.aEQ(), this.cgQ.cgo);
            this.ckw = djc.create(this.cks, this.ckt, this.cku, this.ckv, this.cgQ.ceQ);
            this.ckx = dhj.m8675a(this.ckk, this.ckn, this.ckr, this.ckw);
        }

        public void mo1785a(dhi com_fossil_dhi) {
            this.ckx.injectMembers(com_fossil_dhi);
        }
    }

    final class C2120w implements dcf {
        final /* synthetic */ cjv cgQ;
        private eru ckA;
        private eru<Integer> ckB;
        private eru<Boolean> ckC;
        private eru<dcz> ckD;
        private eru<ddd> ckE;
        private eru<dcx> ckF;
        private eru<ddf> ckG;
        private eru<dcv> ckH;
        private eru<dcn> ckI;
        private emg<NotificationContactAndAppActivity> ckJ;
        private final dcj cky;
        private emg<dcn> ckz;

        private C2120w(cjv com_fossil_cjv, dcj com_fossil_dcj) {
            this.cgQ = com_fossil_cjv;
            this.cky = (dcj) emj.ce(com_fossil_dcj);
            initialize();
        }

        private void initialize() {
            this.ckz = dcp.ahw();
            this.ckA = dcm.m8262b(this.cky);
            this.ckB = dck.m8260b(this.cky);
            this.ckC = dcl.m8261b(this.cky);
            this.ckD = dda.m8355a(MembersInjectors.aEQ(), this.cgQ.ceM);
            this.ckE = dde.m8360a(MembersInjectors.aEQ(), this.cgQ.notificationsRepositoryProvider);
            this.ckF = dcy.m8349a(MembersInjectors.aEQ(), this.cgQ.notificationsRepositoryProvider);
            this.ckG = ddg.m8365a(MembersInjectors.aEQ(), this.cgQ.notificationsRepositoryProvider);
            this.ckH = dcw.m8347a(MembersInjectors.aEQ());
            this.ckI = dco.m8294a(this.ckz, this.ckA, this.cgQ.ceQ, this.ckB, this.ckC, this.ckD, this.ckE, this.ckF, this.ckG, this.cgQ.ceP, this.ckH);
            this.ckJ = dce.m8207a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.ckI);
        }

        public void mo1786a(NotificationContactAndAppActivity notificationContactAndAppActivity) {
            this.ckJ.injectMembers(notificationContactAndAppActivity);
        }
    }

    final class C2121x implements dbw {
        final /* synthetic */ cjv cgQ;
        private final dca ckK;

        private C2121x(cjv com_fossil_cjv, dca com_fossil_dca) {
            this.cgQ = com_fossil_cjv;
            this.ckK = (dca) emj.ce(com_fossil_dca);
        }

        public void mo1787a(dby com_fossil_dby) {
            this.cgQ.cgw.injectMembers(com_fossil_dby);
        }
    }

    final class C2122y implements deb {
        final /* synthetic */ cjv cgQ;
        private eru<C2694b> cjA;
        private final dee ckL;
        private emg<deg> ckM;
        private eru<deg> ckN;
        private emg<ProfileConnectedAppsActivity> ckO;

        private C2122y(cjv com_fossil_cjv, dee com_fossil_dee) {
            this.cgQ = com_fossil_cjv;
            this.ckL = (dee) emj.ce(com_fossil_dee);
            initialize();
        }

        private void initialize() {
            this.ckM = dei.ahw();
            this.cjA = def.m8408b(this.ckL);
            this.ckN = deh.m8426a(this.ckM, this.cjA, this.cgQ.ceQ, this.cgQ.userRepositoryProvider, this.cgQ.cgz, this.cgQ.cgA, this.cgQ.cgF);
            this.ckO = dea.m8400a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.ckN);
        }

        public void mo1788a(ProfileConnectedAppsActivity profileConnectedAppsActivity) {
            this.ckO.injectMembers(profileConnectedAppsActivity);
        }
    }

    final class C2123z implements det {
        final /* synthetic */ cjv cgQ;
        private eru cjA;
        private final dew ckP;
        private emg<dey> ckQ;
        private eru<dey> ckR;
        private emg<ProfileHomeConfigActivity> ckS;

        private C2123z(cjv com_fossil_cjv, dew com_fossil_dew) {
            this.cgQ = com_fossil_cjv;
            this.ckP = (dew) emj.ce(com_fossil_dew);
            initialize();
        }

        private void initialize() {
            this.ckQ = dfa.ahw();
            this.cjA = dex.m8447b(this.ckP);
            this.ckR = dez.create(this.ckQ, this.cjA, this.cgQ.ceQ);
            this.ckS = des.m8444a(this.cgQ.userRepositoryProvider, this.cgQ.ceP, this.ckR);
        }

        public void mo1789a(ProfileHomeConfigActivity profileHomeConfigActivity) {
            this.ckS.injectMembers(profileHomeConfigActivity);
        }
    }

    private cjv(C2102e c2102e) {
        if ($assertionsDisabled || c2102e != null) {
            m6742a(c2102e);
            m6744b(c2102e);
            return;
        }
        throw new AssertionError();
    }

    public static C2102e ZN() {
        return new C2102e();
    }

    private void m6742a(C2102e c2102e) {
        this.ceM = emh.m10872a(cjc.m6617a(c2102e.chh));
        this.ceN = UserModule_ProvideRemoteLocalDataSourceFactory.create(c2102e.chi);
        this.ceO = UserModule_ProvideUserLocalDataSourceFactory.create(c2102e.chi);
        this.userRepositoryProvider = emh.m10872a(UserRepository_Factory.create(this.ceN, this.ceO));
        this.ceP = emh.m10872a(cjm.m6627a(c2102e.chh, this.ceM, this.userRepositoryProvider));
        this.ceQ = emh.m10872a(cjq.m6631a(c2102e.chh));
        this.ceR = emh.m10872a(PresetRepositoryModule_ProvideFavoriteMappingSetRemoteDataSourceFactory.create(c2102e.chj));
        this.ceS = emh.m10872a(PresetRepositoryModule_ProvideFavoriteMappingSetLocalDataSourceFactory.create(c2102e.chj));
        this.appExecutorsProvider = emh.m10872a(cix.YU());
        this.presetRepositoryProvider = emh.m10872a(PresetRepository_Factory.create(this.ceR, this.ceS, this.appExecutorsProvider));
        this.ceT = emh.m10872a(MicroAppSettingRepositoryModule_ProvideFavoriteMappingSetRemoteDataSourceFactory.create(c2102e.chk));
        this.ceU = emh.m10872a(MicroAppSettingRepositoryModule_ProvideFavoriteMappingSetLocalDataSourceFactory.create(c2102e.chk));
        this.ceV = emh.m10872a(UAppSystemVersionRepositoryModule_ProvideUserLocalDataSourceFactory.create(c2102e.chl));
        this.uAppSystemVersionRepositoryProvider = UAppSystemVersionRepository_Factory.create(this.ceV);
        this.microAppSettingRepositoryProvider = emh.m10872a(MicroAppSettingRepository_Factory.create(this.ceT, this.ceU, this.uAppSystemVersionRepositoryProvider, this.appExecutorsProvider));
        this.ceW = emh.m10872a(NotificationsRepositoryModule_ProvideRemoteNotificationsDataSourceFactory.create(c2102e.chm));
        this.ceX = emh.m10872a(NotificationsRepositoryModule_ProvideLocalNotificationsDataSourceFactory.create(c2102e.chm));
        this.notificationsRepositoryProvider = emh.m10872a(NotificationsRepository_Factory.create(this.ceW, this.ceX));
        this.ceY = emh.m10872a(cjk.m6625a(c2102e.chh));
        this.ceZ = emh.m10872a(RepositoriesModule_ProvideActivitiesRemoteDataSourceFactory.create(c2102e.chn, this.ceM, this.ceY));
        this.cfa = emh.m10872a(cjl.m6626a(c2102e.chh));
        this.cfb = emh.m10872a(RepositoriesModule_ProvideActivitiesLocalDataSourceFactory.create(c2102e.chn, this.cfa));
        this.cfc = emh.m10872a(cjf.m6620a(c2102e.chh, this.ceM));
        this.cfd = emh.m10872a(ActivitiesRepository_Factory.create(MembersInjectors.aEQ(), this.ceZ, this.cfb, this.cfc, this.appExecutorsProvider));
        this.cfe = emh.m10872a(RepositoriesModule_ProvideSleepSessionsLocalDataSourceFactory.create(c2102e.chn, this.cfa));
        this.cff = cte.create(MembersInjectors.aEQ(), this.cfd, this.cfe);
        this.cfg = emh.m10872a(LandingPageModule_ProvideRemoteDataSourceFactory.create(c2102e.cho));
        this.cfh = emh.m10872a(LandingPageModule_ProvideLocalDataSourceFactory.create(c2102e.cho));
        this.landingPageRepositoryProvider = emh.m10872a(LandingPageRepository_Factory.create(this.cfg, this.cfh));
        this.cfi = cps.m7452a(this.ceP, this.userRepositoryProvider, this.ceQ, this.presetRepositoryProvider, this.microAppSettingRepositoryProvider, this.notificationsRepositoryProvider, this.cff, this.landingPageRepositoryProvider);
        this.cfj = emh.m10872a(RepositoriesModule_ProvideSummariesRemoteDataSourceFactory.create(c2102e.chn, this.ceM, this.ceY));
        this.cfk = emh.m10872a(RepositoriesModule_ProvideSummariesLocalDataSourceFactory.create(c2102e.chn, this.cfa));
        this.summariesRepositoryProvider = emh.m10872a(SummariesRepository_Factory.create(MembersInjectors.aEQ(), this.cfj, this.cfk, this.cfc, this.appExecutorsProvider));
        this.cfl = cyx.create(MembersInjectors.aEQ(), this.microAppSettingRepositoryProvider, this.uAppSystemVersionRepositoryProvider, this.ceP, this.presetRepositoryProvider);
        this.cfm = emh.m10872a(RepositoriesModule_ProvideAlarmsRemoteDataSourceFactory.create(c2102e.chn));
        this.cfn = emh.m10872a(RepositoriesModule_ProvideAlarmsLocalDataSourceFactory.create(c2102e.chn));
        this.cfo = emh.m10872a(RepositoriesModule_ProvideAlarmsSettingLocalDataSourceFactory.create(c2102e.chn, this.ceM, this.ceP));
        this.cfp = emh.m10872a(RepositoriesModule_ProvideAlarmsSettingRemoteDataSourceFactory.create(c2102e.chn, this.ceM));
        this.alarmsSettingRepositoryProvider = emh.m10872a(AlarmsSettingRepository_Factory.create(this.cfo, this.cfp, this.cfa));
        this.ceE = emh.m10872a(AlarmsRepository_Factory.create(this.cfm, this.cfn, this.alarmsSettingRepositoryProvider, this.ceP));
        this.cfq = emh.m10872a(cja.m6615a(c2102e.chh, this.ceM, this.ceP, this.userRepositoryProvider, this.ceE));
        this.cfr = emh.m10872a(cjd.m6618a(c2102e.chh));
        this.cfs = ddi.m8371a(MembersInjectors.aEQ(), this.notificationsRepositoryProvider);
        this.cft = ddk.m8375a(MembersInjectors.aEQ(), this.notificationsRepositoryProvider);
        this.cfu = emh.m10872a(cje.m6619a(c2102e.chh));
        this.cfv = dqt.m9407a(MembersInjectors.aEQ(), this.cfr, this.ceQ, this.cfs, this.ceP, this.cft, this.cfu);
        this.cfw = cjx.m6837a(this.ceP, this.userRepositoryProvider, this.summariesRepositoryProvider, this.ceQ, this.cfl, this.cfq, this.cfv);
        this.cfx = emh.m10872a(RepositoriesModule_ProvideSleepSessionsRemoteDataSourceFactory.create(c2102e.chn, this.ceM, this.ceY));
        this.sleepSessionsRepositoryProvider = emh.m10872a(SleepSessionsRepository_Factory.create(MembersInjectors.aEQ(), this.cfx, this.cfe, this.cfc, this.appExecutorsProvider));
        this.cfy = emh.m10872a(RepositoriesModule_ProvideSleepSummariesRemoteDataSourceFactory.create(c2102e.chn, this.ceM, this.ceY));
        this.cfz = emh.m10872a(RepositoriesModule_ProvideSleepSummariesLocalDataSourceFactory.create(c2102e.chn, this.cfa));
        this.sleepSummariesRepositoryProvider = emh.m10872a(SleepSummariesRepository_Factory.create(MembersInjectors.aEQ(), this.cfy, this.cfz, this.cfc, this.appExecutorsProvider));
        this.cfA = cod.m7336a(this.cfd, this.sleepSessionsRepositoryProvider, this.summariesRepositoryProvider, this.sleepSummariesRepositoryProvider);
        this.cfB = emh.m10872a(DeviceModule_ProvideFitnessRemoteDataSourceFactory.create(c2102e.chp));
        this.cfC = emh.m10872a(DeviceModule_ProvideFitnessLocalDataSourceFactory.create(c2102e.chp));
        this.deviceRepositoryProvider = emh.m10872a(DeviceRepository_Factory.create(this.cfB, this.cfC, this.uAppSystemVersionRepositoryProvider));
        this.cfD = cmr.m7139a(this.ceP, this.deviceRepositoryProvider);
        this.cfE = cmu.create(this.ceP);
        this.cfF = cnh.create(this.ceP);
        this.cfG = emh.m10872a(cjo.m6629a(c2102e.chh));
        this.cfH = djh.create(MembersInjectors.aEQ(), this.presetRepositoryProvider, this.appExecutorsProvider);
        this.cfI = djr.m8847a(MembersInjectors.aEQ(), this.microAppSettingRepositoryProvider);
        this.cfJ = dkd.m8879a(MembersInjectors.aEQ(), this.microAppSettingRepositoryProvider);
        this.cfK = ctc.create(MembersInjectors.aEQ(), this.microAppSettingRepositoryProvider, this.uAppSystemVersionRepositoryProvider);
        this.cfL = cti.create(MembersInjectors.aEQ(), this.microAppSettingRepositoryProvider, this.uAppSystemVersionRepositoryProvider, this.presetRepositoryProvider);
        this.cfM = csv.m7481a(this.ceP, this.deviceRepositoryProvider, this.cfd, this.sleepSessionsRepositoryProvider, this.userRepositoryProvider, this.uAppSystemVersionRepositoryProvider, this.presetRepositoryProvider, this.microAppSettingRepositoryProvider, this.ceQ, this.cfG, this.cfH, this.cfI, this.cfJ, this.cfK, this.cfL);
        this.cfN = cpn.m7439a(this.userRepositoryProvider, this.ceP, this.deviceRepositoryProvider, this.cfq);
        this.cfO = emh.m10872a(DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory.create(c2102e.chq));
        this.cfP = emh.m10872a(DataVersioningModule_ProvideDataVersioningRemoteDataSourceFactory.create(c2102e.chq));
        this.cfQ = emh.m10872a(WidgetModule_ProvideWidgetRemoteDataSourceFactory.create(c2102e.chr));
        this.cfR = emh.m10872a(WidgetModule_ProvideWidgetLocalDataSourceFactory.create(c2102e.chr));
        this.widgetRepositoryProvider = emh.m10872a(WidgetRepository_Factory.create(this.cfQ, this.cfR));
        this.fetchFirmwareListUseCaseProvider = cyl.m7907a(MembersInjectors.aEQ(), this.ceY);
        this.cfS = emh.m10872a(ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory.create(c2102e.chs));
        this.cfT = emh.m10872a(ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory.create(c2102e.chs));
        this.exploreRepositoryProvider = emh.m10872a(ExploreRepository_Factory.create(this.cfS, this.cfT));
        this.cfU = emh.m10872a(DataVersioningRepository_Factory.create(this.cfO, this.cfP, this.widgetRepositoryProvider, this.landingPageRepositoryProvider, this.microAppSettingRepositoryProvider, this.presetRepositoryProvider, this.userRepositoryProvider, this.ceQ, this.deviceRepositoryProvider, this.fetchFirmwareListUseCaseProvider, this.uAppSystemVersionRepositoryProvider, this.exploreRepositoryProvider));
        this.cfV = ctg.m7501a(MembersInjectors.aEQ(), this.cfd, this.sleepSessionsRepositoryProvider, this.presetRepositoryProvider, this.microAppSettingRepositoryProvider, this.ceE, this.cfU);
        this.cfW = cpr.m7450a(this.userRepositoryProvider, this.ceQ, this.cfV);
        this.cfX = csu.m7479a(this.userRepositoryProvider, this.ceQ, this.cfV);
        this.cfY = cnl.m7218a(this.presetRepositoryProvider, this.microAppSettingRepositoryProvider);
        this.cfZ = cmm.m7098a(this.ceP, this.cfa, this.cfd);
        this.cga = cnv.m7272a(this.userRepositoryProvider, this.ceP);
        this.cgb = cnx.m7284a(this.userRepositoryProvider, this.ceP);
        this.cgc = cob.m7334a(this.userRepositoryProvider, this.ceP);
        this.cgd = cnz.m7301a(this.userRepositoryProvider, this.ceP);
        this.cge = ctk.m7509a(this.userRepositoryProvider, this.ceP);
        this.cgf = czb.create(MembersInjectors.aEQ(), this.deviceRepositoryProvider, this.ceP);
        this.cgg = cvo.m7690a(this.userRepositoryProvider, this.ceP, this.ceQ, this.cgf);
        this.cgh = cui.m7587a(this.userRepositoryProvider, this.ceP, this.deviceRepositoryProvider, this.landingPageRepositoryProvider, this.widgetRepositoryProvider);
        this.cgi = WidgetLoader_MembersInjector.create(this.widgetRepositoryProvider);
        this.cgj = ExploreLoader_MembersInjector.create(this.exploreRepositoryProvider);
        this.cgk = emh.m10872a(IntegrationModule_ProvideLocalDataSourceFactory.create(c2102e.cht));
        this.cgl = emh.m10872a(IntegrationModule_ProvideRemoteDataSourceFactory.create(c2102e.cht));
        this.cgm = emh.m10872a(IntegrationRepository_Factory.create(this.cgk, this.cgl));
        this.cgn = IntegrationLoader_MembersInjector.create(this.cgm);
        this.cgo = emh.m10872a(cji.m6623a(c2102e.chh));
        this.cgp = djl.m8838a(MembersInjectors.aEQ());
        this.cgq = csz.m7493a(this.ceQ, this.cgo, this.cgp, this.cfr);
        this.cgr = ddo.create(this.userRepositoryProvider);
    }

    private void m6744b(C2102e c2102e) {
        this.cgs = ddm.m8384a(this.ceP, this.userRepositoryProvider);
        this.cgt = dci.create(this.ceP);
        this.cgu = DeviceLoader_MembersInjector.create(this.deviceRepositoryProvider);
        this.cgv = cpq.m7448a(this.widgetRepositoryProvider, this.exploreRepositoryProvider, this.microAppSettingRepositoryProvider);
        this.cgw = dbz.m8196a(this.cfv, this.ceP);
        this.cgx = cpp.create(this.cfq);
        this.cgy = cno.m7225a(this.ceP, this.userRepositoryProvider, this.ceQ, this.presetRepositoryProvider, this.microAppSettingRepositoryProvider, this.notificationsRepositoryProvider, this.cff, this.landingPageRepositoryProvider, this.cfU);
        this.cgz = cjp.m6630a(c2102e.chh);
        this.cgA = cjh.m6622a(c2102e.chh, this.ceP);
        this.cgB = csx.m7490a(this.cgz, this.cgA);
        this.cgC = emh.m10872a(cjb.m6616a(c2102e.chh));
        this.cgD = emh.m10872a(cjr.m6632a(c2102e.chh));
        this.cgE = emh.m10872a(cjj.m6624a(c2102e.chh));
        this.cgF = cjg.m6621a(c2102e.chh, this.ceM, this.appExecutorsProvider);
        this.cgG = emh.m10872a(cjn.m6628a(c2102e.chh));
    }

    public void mo1852a(UpgradeReceiver upgradeReceiver) {
        this.cfi.injectMembers(upgradeReceiver);
    }

    public cnr YV() {
        return (cnr) this.ceP.get();
    }

    public void mo1841a(PortfolioApp portfolioApp) {
        this.cfw.injectMembers(portfolioApp);
    }

    public void mo1847a(BestTimeService bestTimeService) {
        this.cfA.injectMembers(bestTimeService);
    }

    public void mo1846a(DeviceHelper deviceHelper) {
        this.cfD.injectMembers(deviceHelper);
    }

    public void mo1828a(cmt com_fossil_cmt) {
        this.cfE.injectMembers(com_fossil_cmt);
    }

    public void mo1829a(cng com_fossil_cng) {
        this.cfF.injectMembers(com_fossil_cng);
    }

    public void mo1854a(MFDeviceService mFDeviceService) {
        this.cfM.injectMembers(mFDeviceService);
    }

    public void mo1848a(AlarmReceiver alarmReceiver) {
        this.cfN.injectMembers(alarmReceiver);
    }

    public void mo1851a(NetworkChangedReceiver networkChangedReceiver) {
        this.cfW.injectMembers(networkChangedReceiver);
    }

    public void mo1853a(ExecutePendingDataService executePendingDataService) {
        this.cfX.injectMembers(executePendingDataService);
    }

    public void mo1830a(cnk com_fossil_cnk) {
        this.cfY.injectMembers(com_fossil_cnk);
    }

    public void mo1827a(cml com_fossil_cml) {
        this.cfZ.injectMembers(com_fossil_cml);
    }

    public void mo1832a(cnu com_fossil_cnu) {
        this.cga.injectMembers(com_fossil_cnu);
    }

    public void mo1833a(cnw com_fossil_cnw) {
        this.cgb.injectMembers(com_fossil_cnw);
    }

    public void mo1835a(coa com_fossil_coa) {
        this.cgc.injectMembers(com_fossil_coa);
    }

    public void mo1834a(cny com_fossil_cny) {
        this.cgd.injectMembers(com_fossil_cny);
    }

    public void mo1836a(ctj com_fossil_ctj) {
        this.cge.injectMembers(com_fossil_ctj);
    }

    public void mo1858a(DebugActivity debugActivity) {
        this.cgg.injectMembers(debugActivity);
    }

    public void mo1857a(SplashScreenActivity splashScreenActivity) {
        this.cgh.injectMembers(splashScreenActivity);
    }

    public void mo1845a(WidgetLoader widgetLoader) {
        this.cgi.injectMembers(widgetLoader);
    }

    public void mo1843a(ExploreLoader exploreLoader) {
        this.cgj.injectMembers(exploreLoader);
    }

    public void mo1844a(IntegrationLoader integrationLoader) {
        this.cgn.injectMembers(integrationLoader);
    }

    public void mo1856a(CommuteTimeService commuteTimeService) {
        this.cgq.injectMembers(commuteTimeService);
    }

    public void mo1840a(ddn com_fossil_ddn) {
        this.cgr.injectMembers(com_fossil_ddn);
    }

    public void mo1839a(ddl com_fossil_ddl) {
        this.cgs.injectMembers(com_fossil_ddl);
    }

    public void mo1838a(dch com_fossil_dch) {
        this.cgt.injectMembers(com_fossil_dch);
    }

    public void mo1842a(DeviceLoader deviceLoader) {
        this.cgu.injectMembers(deviceLoader);
    }

    public void mo1850a(LocaleChangedReceiver localeChangedReceiver) {
        this.cgv.injectMembers(localeChangedReceiver);
    }

    public void mo1837a(dby com_fossil_dby) {
        this.cgw.injectMembers(com_fossil_dby);
    }

    public void mo1849a(BootReceiver bootReceiver) {
        this.cgx.injectMembers(bootReceiver);
    }

    public ciw YW() {
        return (ciw) this.appExecutorsProvider.get();
    }

    public void mo1831a(cnn com_fossil_cnn) {
        this.cgy.injectMembers(com_fossil_cnn);
    }

    public void mo1855a(ThirdPartyUploadIntentService thirdPartyUploadIntentService) {
        this.cgB.injectMembers(thirdPartyUploadIntentService);
    }

    public ctr mo1792a(ctv com_fossil_ctv) {
        return new C2116s(com_fossil_ctv);
    }

    public cua mo1793a(cub com_fossil_cub) {
        return new C2118u(com_fossil_cub);
    }

    public dat mo1805a(dax com_fossil_dax) {
        return new C2113p(com_fossil_dax);
    }

    public dbf mo1806a(dbj com_fossil_dbj) {
        return new C2112o(com_fossil_dbj);
    }

    public dkq mo1821a(dku com_fossil_dku) {
        return new ai(com_fossil_dku);
    }

    public cuj mo1794a(cuk com_fossil_cuk) {
        return new aj(com_fossil_cuk);
    }

    public dhg mo1818a(dhl com_fossil_dhl) {
        return new af(com_fossil_dhl);
    }

    public dia mo1820a(die com_fossil_die) {
        return new C2111n(com_fossil_die);
    }

    public dnu mo1824a(dnx com_fossil_dnx) {
        return new C2115r(com_fossil_dnx);
    }

    public dcf mo1808a(dcj com_fossil_dcj) {
        return new C2120w(com_fossil_dcj);
    }

    public dbw mo1807a(dca com_fossil_dca) {
        return new C2121x(com_fossil_dca);
    }

    public doh mo1825a(dos com_fossil_dos) {
        return new ag(com_fossil_dos);
    }

    public dns mo1823a(dod com_fossil_dod) {
        return new C2114q(com_fossil_dod);
    }

    public doj mo1826a(dom com_fossil_dom) {
        return new ah(com_fossil_dom);
    }

    public dnk mo1822a(dnn com_fossil_dnn) {
        return new C2110m(com_fossil_dnn);
    }

    public czi mo1802a(czl com_fossil_czl) {
        return new ae(com_fossil_czl);
    }

    public dff mo1813a(dfi com_fossil_dfi) {
        return new C2117t(com_fossil_dfi);
    }

    public cvq mo1797a(cvu com_fossil_cvu) {
        return new C2106i(com_fossil_cvu);
    }

    public cxt mo1801a(cxw com_fossil_cxw) {
        return new C2105h(com_fossil_cxw);
    }

    public cwi mo1798a(cwm com_fossil_cwm) {
        return new C2098a(com_fossil_cwm);
    }

    public cww mo1799a(cxa com_fossil_cxa) {
        return new C2099b(com_fossil_cxa);
    }

    public dai mo1804a(dam com_fossil_dam) {
        return new C2108k(com_fossil_dam);
    }

    public czs mo1803a(czw com_fossil_czw) {
        return new C2107j(com_fossil_czw);
    }

    public cxk mo1800a(cxn com_fossil_cxn) {
        return new C2104g(com_fossil_cxn);
    }

    public cum mo1795a(cup com_fossil_cup) {
        return new C2100c(com_fossil_cup);
    }

    public cuu mo1796a(cux com_fossil_cux) {
        return new C2101d(com_fossil_cux);
    }

    public dfx mo1815a(dga com_fossil_dga) {
        return new ab(com_fossil_dga);
    }

    public dgg mo1816a(dgj com_fossil_dgj) {
        return new ac(com_fossil_dgj);
    }

    public ddt mo1809a(ddv com_fossil_ddv) {
        return new C2103f(com_fossil_ddv);
    }

    public dek mo1811a(den com_fossil_den) {
        return new C2109l(com_fossil_den);
    }

    public dgp mo1817a(dgt com_fossil_dgt) {
        return new ad(com_fossil_dgt);
    }

    public deb mo1810a(dee com_fossil_dee) {
        return new C2122y(com_fossil_dee);
    }

    public dhr mo1819a(dil com_fossil_dil, dhv com_fossil_dhv, dis com_fossil_dis, dix com_fossil_dix) {
        return new C2119v(com_fossil_dil, com_fossil_dhv, com_fossil_dis, com_fossil_dix);
    }

    public dfo mo1814a(dfr com_fossil_dfr) {
        return new aa(com_fossil_dfr);
    }

    public det mo1812a(dew com_fossil_dew) {
        return new C2123z(com_fossil_dew);
    }
}
