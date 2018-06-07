package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.cts.C2310a;
import com.fossil.cts.C2311b;
import com.fossil.cye.C2501a;
import com.fossil.cye.C2502b;
import com.fossil.cye.C2503c;
import com.fossil.cyy.C2555a;
import com.fossil.cyy.C2556b;
import com.fossil.cyy.C2557c;
import com.fossil.czc.C2562b;
import com.fossil.czc.C2563c;
import com.fossil.czc.C2564d;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.OtaEvent;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.response.buddychallenge.MFGetBCAccountInfoResponse;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeListResponse;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeResponse;
import com.portfolio.platform.response.buddychallenge.MFGetInvitationListResponse;
import com.portfolio.platform.response.buddychallenge.MFGetOpponentResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.parceler.Parcels;

public class ctx implements C2310a {
    private static final String TAG = ctx.class.getSimpleName();
    private C2311b cFA;
    private czc cFE;
    private cye cFF;
    private DataVersioningRepository cFG;
    private cyy cFH;
    private boolean cFI = false;
    private int cFJ;
    NotificationsRepository cFK;
    private BroadcastReceiver cFL = new C23429(this);
    private BroadcastReceiver cFM = new BroadcastReceiver(this) {
        final /* synthetic */ ctx cFR;

        {
            this.cFR = r1;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(ctx.TAG, "---Inside .activeDeviceChangedReceiver currentActiveSerial=" + PortfolioApp.ZQ().aaa());
            this.cFR.cFA.restart();
        }
    };
    private BroadcastReceiver cFN = new BroadcastReceiver(this) {
        final /* synthetic */ ctx cFR;

        {
            this.cFR = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                int intExtra = intent.getIntExtra("sync_result", 3);
                int intExtra2 = intent.getIntExtra("LAST_ERROR_CODE", -1);
                MFLogger.m12670d(ctx.TAG, "Inside .syncReceiver syncResult=" + intExtra + ",  serial=" + stringExtra);
                switch (intExtra) {
                    case 1:
                        this.cFR.agN();
                        this.cFR.agV();
                        return;
                    case 2:
                    case 4:
                        if (intExtra2 == FailureCode.BLUETOOTH_IS_DISABLED || intExtra2 == FailureCode.LOCATION_SERVICE_DISABLED || intExtra2 == FailureCode.LOCATION_ACCESS_DENIED) {
                            ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("LIST_ERROR_CODE");
                            if (integerArrayListExtra == null) {
                                integerArrayListExtra = new ArrayList();
                            }
                            this.cFR.cFA.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(integerArrayListExtra).toArray(new PermissionCodes[0]));
                            return;
                        }
                        this.cFR.cFA.agq();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private BroadcastReceiver cFO = new BroadcastReceiver(this) {
        final /* synthetic */ ctx cFR;

        {
            this.cFR = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                HashMap gv = cnp.acc().gv(intent.getStringExtra("uri"));
                if (gv != null && !gv.isEmpty()) {
                    this.cFR.m7576e(gv);
                }
            }
        }
    };
    private BroadcastReceiver cFP = new BroadcastReceiver(this) {
        final /* synthetic */ ctx cFR;

        {
            this.cFR = r1;
        }

        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("OTA_RESULT", false);
            MFLogger.m12670d(ctx.TAG, "Handle OTA complete on receiver");
            this.cFR.cl(booleanExtra);
        }
    };
    private BroadcastReceiver cFQ = new BroadcastReceiver(this) {
        final /* synthetic */ ctx cFR;

        {
            this.cFR = r1;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(ctx.TAG, "Inside deviceBusySetMicroAppReceiver");
            this.cFR.cFA.agn();
            this.cFR.cFA.agm();
        }
    };
    private final cmi cmS;
    private final Context mContext;
    DeviceRepository mDeviceRepository;
    cnr mSharedPreferencesManager;
    private ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C23341 implements C2126d<C2503c, C2502b> {
        final /* synthetic */ ctx cFR;

        C23341(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7565a((C2502b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7566a((C2503c) obj);
        }

        public void m7566a(C2503c c2503c) {
            if (c2503c.ajL()) {
                MFLogger.m12670d(ctx.TAG, "Inside .checkFirmwareActiveDevice fw is latest, skip OTA after sync success");
            } else {
                this.cFR.agk();
            }
        }

        public void m7565a(C2502b c2502b) {
        }
    }

    class C23363 implements MFServerResultCallback {
        final /* synthetic */ ctx cFR;

        C23363(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, "MFGetBCAccountInfoRequest onSuccess");
            MFUser mFUser = null;
            try {
                mFUser = cnq.acd().ace().getCurrentUser();
            } catch (Exception e) {
                MFLogger.m12671e(ctx.TAG, "MFGetBCAccountInfoRequest Could not get MFUser");
            }
            BCPlayer buddyChallengeAccount = ((MFGetBCAccountInfoResponse) mFResponse).getBuddyChallengeAccount();
            if (!(mFUser == null || TextUtils.isEmpty(mFUser.getProfilePicture()) || mFUser.getProfilePicture().equals(buddyChallengeAccount.getProfilePicture()))) {
                cml.abG().m7097i(-1, ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK, mFUser.getProfilePicture());
            }
            cnq.acd().acw().mo1931b(buddyChallengeAccount);
            this.cFR.agT();
            this.cFR.agU();
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, "MFGetBCAccountInfoRequest onFailed");
            if (mFResponse.getInternalErrorCode() == 404100) {
                cnq.acd().acw().adJ();
                MFLogger.m12670d(ctx.TAG, " Player not found");
            }
        }
    }

    class C23385 implements MFServerResultCallback {
        final /* synthetic */ ctx cFR;

        C23385(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, "getInvitationList onSuccess");
            Serializable invitationList = ((MFGetInvitationListResponse) mFResponse).getInvitationList();
            if (invitationList != null && invitationList.size() > 0) {
                Iterator it = invitationList.iterator();
                while (it.hasNext()) {
                    cnq.acd().acw().mo1923a((BCInvitation) it.next());
                }
                Intent intent = new Intent();
                intent.putExtra("BC_SHOW_NOTIFICATION_INVITATIONS", invitationList);
                intent.setAction("BC_SHOW_NOTIFICATION_ACTION");
                PortfolioApp.ZQ().sendBroadcast(intent);
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, "getInvitationList onFailed");
        }
    }

    class C23396 implements MFServerResultCallback {
        final /* synthetic */ ctx cFR;

        C23396(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, " getChallengeResultList onSuccess");
            Serializable challengeList = ((MFGetChallengeListResponse) mFResponse).getChallengeList();
            Iterator it = challengeList.iterator();
            while (it.hasNext()) {
                BCChallenge bCChallenge = (BCChallenge) it.next();
                bCChallenge.setPinType(0);
                cnq.acd().acw().mo1921a(bCChallenge);
            }
            if (challengeList != null && challengeList.size() > 0) {
                Intent intent = new Intent();
                intent.putExtra("BC_SHOW_NOTIFICATION_CHALLENGES", challengeList);
                intent.setAction("BC_SHOW_NOTIFICATION_ACTION");
                PortfolioApp.ZQ().sendBroadcast(intent);
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, " getChallengeResultList onFailed");
        }
    }

    class C23407 implements MFServerResultCallback {
        final /* synthetic */ ctx cFR;

        C23407(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, " updateShowChallengeResult onSuccess");
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(ctx.TAG, " updateShowChallengeResult onFailed");
        }
    }

    class C23418 implements C2126d<C2564d, C2563c> {
        final /* synthetic */ ctx cFR;

        C23418(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7567a((C2563c) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7568a((C2564d) obj);
        }

        public void m7568a(C2564d c2564d) {
        }

        public void m7567a(C2563c c2563c) {
        }
    }

    class C23429 extends BroadcastReceiver {
        final /* synthetic */ ctx cFR;

        C23429(ctx com_fossil_ctx) {
            this.cFR = com_fossil_ctx;
        }

        public void onReceive(Context context, Intent intent) {
            OtaEvent otaEvent = (OtaEvent) Parcels.unwrap(intent.getParcelableExtra(Constants.OTA_PROCESS));
            MFLogger.m12670d(ctx.TAG, "---Inside .otaProgressReceiver ota progress " + otaEvent.getProcess() + ", serial=" + otaEvent.getSerial());
            if (!TextUtils.isEmpty(otaEvent.getSerial()) && otaEvent.getSerial().equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                this.cFR.cFA.jS((int) (otaEvent.getProcess() * 10.0f));
            }
        }
    }

    public ctx(C2311b c2311b, ckc com_fossil_ckc, DataVersioningRepository dataVersioningRepository, cye com_fossil_cye, czc com_fossil_czc, cyy com_fossil_cyy, UserRepository userRepository, Context context, cmi com_fossil_cmi) {
        this.cFA = (C2311b) emj.m10873f(c2311b, "loginView cannot be null!");
        this.mUseCaseHandler = com_fossil_ckc;
        this.cFG = dataVersioningRepository;
        this.cFH = com_fossil_cyy;
        this.mUserRepository = userRepository;
        this.cFE = com_fossil_czc;
        this.cFF = com_fossil_cye;
        this.cFA.cK(this);
        this.mContext = context;
        this.cmS = com_fossil_cmi;
    }

    public void start() {
        MFLogger.m12670d(TAG, " MainPresenter start");
        PortfolioApp.ZQ().registerReceiver(this.cFL, new IntentFilter(PortfolioApp.ZQ().getPackageName() + ButtonService.ACTION_OTA_PROGRESS));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cFP, new IntentFilter("BROADCAST_OTA_COMPLETE"));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cFM, new IntentFilter("BROADCAST_ACTIVE_DEVICE_STEALED"));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cFO, new IntentFilter("BROADCAST_INTERNAL_NAVIGATION"));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cFQ, new IntentFilter("BROADCAST_DEVICE_BUSY_OTAING"));
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.OTA));
        boolean z = this.mUserRepository.getCurrentUser() == null || TextUtils.isEmpty(PortfolioApp.ZQ().aaa());
        this.cFI = z;
        if (clw.cwB.booleanValue()) {
            agS();
        }
        agM();
        agQ();
        agK();
        agL();
        agP();
        this.cFG.checkDataVersioning(null);
        this.cFA.jT(this.cFJ);
        agV();
    }

    public void stop() {
        MFLogger.m12670d(TAG, "MainPresenter stop()");
        try {
            PortfolioApp.ZQ().unregisterReceiver(this.cFL);
            gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cFP);
            gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cFN);
            gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cFO);
            gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cFM);
            gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cFQ);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "MainPresenter stop() - ex = " + e.toString());
        }
    }

    private void agK() {
        String aaa = PortfolioApp.ZQ().aaa();
        MFLogger.m12670d(TAG, "Inside .checkLastOTASuccess, activeSerial=" + aaa);
        if (!TextUtils.isEmpty(aaa)) {
            Object gM = this.mSharedPreferencesManager.gM(aaa);
            MFLogger.m12670d(TAG, "Inside .checkLastOTASuccess, lastTempFw=" + gM);
            if (!TextUtils.isEmpty(gM)) {
                DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(aaa, null);
                if (deviceBySerial != null) {
                    MFLogger.m12670d(TAG, "Inside .checkLastOTASuccess, currentDeviceFw=" + deviceBySerial.getFirmwareRevision());
                    if (!gM.equalsIgnoreCase(deviceBySerial.getFirmwareRevision())) {
                        MFLogger.m12670d(TAG, "Handle OTA complete on check last OTA success");
                        cl(true);
                        this.mSharedPreferencesManager.gN(aaa);
                    }
                }
            }
        }
    }

    private void agL() {
        if (this.mSharedPreferencesManager.adl() && !this.mSharedPreferencesManager.adk()) {
            this.cFA.agx();
            this.mSharedPreferencesManager.cd(true);
        }
    }

    private void agM() {
        Object aaa = PortfolioApp.ZQ().aaa();
        if (TextUtils.isEmpty(aaa)) {
            this.cFA.agv();
            this.cFA.ags();
            return;
        }
        this.cFA.agw();
        this.cFA.hI(aaa);
    }

    private void agN() {
        MFLogger.m12670d(TAG, "Inside .checkFirmwareActiveDevice, isSkipOTA=" + this.mSharedPreferencesManager.acD());
        this.mUseCaseHandler.m6886a(this.cFF, new C2501a(PortfolioApp.ZQ().aaa()), new C23341(this));
    }

    public void agk() {
        MFLogger.m12670d(TAG, "Inside .updateFirmware");
        String aaa = PortfolioApp.ZQ().aaa();
        if (!TextUtils.isEmpty(aaa)) {
            SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(aaa));
            if (hl != null) {
                Map hashMap = new HashMap();
                hashMap.put("Serial_Number", aaa);
                hashMap.put("Device_Name", hl.getDeviceName());
                m7577f("ota_start", hashMap);
            }
            this.mUseCaseHandler.m6886a(this.cFE, new C2562b(aaa), new C23418(this));
        }
    }

    public void agO() {
        List allAppFilters = this.cFK.getAllAppFilters(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
        if (!dre.dff.auE() && allAppFilters != null && allAppFilters.size() > 0) {
            this.cFA.agA();
        }
    }

    private void agP() {
        MFLogger.m12670d(TAG, "Inside .autoSync");
        if (this.cFI) {
            MFLogger.m12670d(TAG, "User is in guest/explore mode, skip auto sync");
            return;
        }
        MFLogger.m12670d(TAG, "Inside .autoSync lastSyncSuccess=" + this.mSharedPreferencesManager.gB(PortfolioApp.ZQ().aaa()));
        if (System.currentTimeMillis() - this.mSharedPreferencesManager.gC(PortfolioApp.ZQ().aaa()) < 300000) {
            MFLogger.m12670d(TAG, "Inside .autoSync just syncing skip, start check permission for notification and check firmware !!!");
            agO();
            agN();
        } else if (PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa()) != CommunicateMode.OTA.getValue()) {
            agO();
            if (PortfolioApp.ZQ().ZW() || this.mSharedPreferencesManager.acH()) {
                MFLogger.m12670d(TAG, "Inside .autoSync, start auto-sync.");
                PortfolioApp.ZQ().m12698e(false, 10);
            }
        } else {
            MFLogger.m12670d(TAG, "Inside .autoSync, device is ota, wait for the next time");
        }
    }

    private void cl(boolean z) {
        this.cFA.agl();
        this.cFA.agn();
        String aaa = PortfolioApp.ZQ().aaa();
        MFLogger.m12670d(TAG, "Inside .otaCompleteReceiver OTA complete, isSuccess=" + z);
        if (z) {
            this.mSharedPreferencesManager.m7251r(aaa, true);
            this.cFA.ago();
            MFLogger.m12670d(TAG, "Inside .handleOtaComplete, full-sync after OTA successfully.");
            PortfolioApp.ZQ().m12698e(false, 13);
        } else if (this.mSharedPreferencesManager.gQ(aaa)) {
            MFLogger.m12670d(TAG, "Inside .otaCompleteReceiver OTA Fail isDevicePairingComplete=true, Go Ahead");
            this.cFA.agp();
        } else {
            MFLogger.m12670d(TAG, "Inside .otaCompleteReceiver OTA Fail isDevicePairingComplete=false, unlink device");
            this.mUseCaseHandler.m6886a(this.cFH, new C2555a(aaa), new C2126d<C2557c, C2556b>(this) {
                final /* synthetic */ ctx cFR;

                {
                    this.cFR = r1;
                }

                public /* synthetic */ void onError(Object obj) {
                    m7563a((C2556b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m7564a((C2557c) obj);
                }

                public void m7564a(C2557c c2557c) {
                    this.cFR.cFA.agr();
                }

                public void m7563a(C2556b c2556b) {
                    this.cFR.cFA.agr();
                }
            });
        }
    }

    public void agQ() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null) {
            this.cFA.agw();
            this.cFA.agu();
            this.cFA.ags();
            return;
        }
        this.cFA.agt();
        this.cFA.mo2055c(currentUser);
    }

    public int agR() {
        return this.cFJ;
    }

    public void jR(int i) {
        this.cFJ = i;
    }

    public void m7576e(HashMap<String, String> hashMap) {
        this.cFA.mo2057d(hashMap);
    }

    public void agj() {
        MFLogger.m12670d(TAG, "Inside .onDevicePermissionReady");
        if (System.currentTimeMillis() - this.mSharedPreferencesManager.gB(PortfolioApp.ZQ().aaa()) >= 300000) {
            MFLogger.m12670d(TAG, "Inside .onDevicePermissionReady start auto-sync");
            PortfolioApp.ZQ().m12698e(false, 10);
            return;
        }
        MFLogger.m12670d(TAG, "Inside .onDevicePermissionReady just syncing skip!!!");
    }

    public void m7575b(BCNotifications bCNotifications) {
        if (bCNotifications != null) {
            this.cFA.mo2031a(bCNotifications);
            if (bCNotifications.getType() == 7 || bCNotifications.getType() == 8 || bCNotifications.getType() == 9 || bCNotifications.getType() == 10) {
                String challengeId = bCNotifications.getChallengeId();
                if (TextUtils.isEmpty(challengeId)) {
                    challengeId = bCNotifications.getId();
                }
                hH(challengeId);
            }
        }
    }

    public void mo2064a(String str, final BCNotifications bCNotifications, final BCInvitation bCInvitation, final BCChallenge bCChallenge) {
        if (!TextUtils.isEmpty(str) && NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqy(PortfolioApp.ZQ(), str), new MFServerResultCallback(this) {
                final /* synthetic */ ctx cFR;

                public void onSuccess(MFResponse mFResponse) {
                    MFLogger.m12670d(ctx.TAG, "MFGetOpponentRequest onSuccess");
                    BCOpponent opponent = ((MFGetOpponentResponse) mFResponse).getOpponent();
                    cnq.acd().acw().mo1924a(opponent);
                    this.cFR.cFA.mo2033a(bCNotifications, bCInvitation, bCChallenge, opponent);
                }

                public void onFail(int i, MFResponse mFResponse) {
                    MFLogger.m12670d(ctx.TAG, "MFGetOpponentRequest onFailed");
                }
            });
        }
    }

    public void agS() {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqs(PortfolioApp.ZQ()), new C23363(this));
    }

    public void mo2063a(final BCNotifications bCNotifications, final BCOpponent bCOpponent, final String str) {
        if (!TextUtils.isEmpty(str) && NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqu(PortfolioApp.ZQ(), str), new MFServerResultCallback(this) {
                final /* synthetic */ ctx cFR;

                public void onSuccess(MFResponse mFResponse) {
                    MFLogger.m12670d(ctx.TAG, "MFGetChallengeRequest onSuccess");
                    BCChallenge challenge = ((MFGetChallengeResponse) mFResponse).getChallenge();
                    challenge.setPinType(0);
                    cnq.acd().acw().mo1921a(challenge);
                    if (this.cFR.cFA.isActive()) {
                        this.cFR.cFA.mo2032a(bCNotifications, challenge, bCOpponent);
                    }
                }

                public void onFail(int i, MFResponse mFResponse) {
                    MFLogger.m12670d(ctx.TAG, "MFGetChallengeRequest onFailed");
                    BCChallenge ha = cnq.acd().acw().ha(str);
                    if (ha != null && this.cFR.cFA.isActive()) {
                        this.cFR.cFA.mo2032a(bCNotifications, ha, bCOpponent);
                    }
                }
            });
        }
    }

    public void agT() {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqw(PortfolioApp.ZQ()), new C23385(this));
        }
    }

    public void agU() {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqv(PortfolioApp.ZQ()), new C23396(this));
    }

    public void hH(String str) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crb(PortfolioApp.ZQ(), str), new C23407(this));
    }

    private void agV() {
        Object aaa = PortfolioApp.ZQ().aaa();
        if (TextUtils.isEmpty(aaa)) {
            this.cFA.agz();
            return;
        }
        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(aaa, null);
        if (deviceBySerial != null) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".checkAndShowLowBattery - Checking battery for active device - serial=" + deviceBySerial.getDeviceId() + ", model=" + deviceBySerial.getSku() + ", fw=" + deviceBySerial.getFirmwareRevision() + ", battery=" + deviceBySerial.getBatteryLevel());
            int batteryLevel = deviceBySerial.getBatteryLevel();
            if (batteryLevel < 0 || batteryLevel > this.mSharedPreferencesManager.acY()) {
                cna.m7181F(this.mContext, 7);
                this.cmS.abA();
                this.cFA.agz();
                return;
            }
            this.cmS.abz();
            this.cFA.agy();
            return;
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".checkAndShowLowBattery - Checking battery for active device=NULL");
        cna.m7181F(this.mContext, 7);
        this.cmS.abA();
        this.cFA.agz();
    }

    protected void m7577f(String str, Map<String, String> map) {
        cmj.bs(PortfolioApp.ZQ()).m7085e(str, map);
    }
}
