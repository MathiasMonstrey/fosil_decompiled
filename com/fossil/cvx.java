package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.cvr.C2401a;
import com.fossil.cvr.C2402b;
import com.fossil.cyc.C2499a;
import com.fossil.cyc.C2500b;
import com.fossil.cym.C2518a;
import com.fossil.cym.C2519b;
import com.fossil.cyq.C2529a;
import com.fossil.cyq.C2530b;
import com.fossil.cyq.C2531c;
import com.fossil.cyu.C2544a;
import com.fossil.cyu.C2545b;
import com.fossil.cyu.C2546c;
import com.fossil.cyy.C2555a;
import com.fossil.cyy.C2556b;
import com.fossil.cyy.C2557c;
import com.fossil.fj.C2426a;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.enums.ConnectionStateChange;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.DeviceDataSource.GetAllDeviceCallback;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.DeviceLoader;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.List;

public class cvx implements C2401a, C2426a<List<DeviceModel>> {
    private static final String TAG = cvx.class.getSimpleName();
    private final gy cEa;
    private fj cFC;
    private final C2402b cIm;
    private final PortfolioApp cIo;
    private final cyy cIp;
    private final cym cIq;
    private final cyc cIr;
    private DeviceModel cIs;
    private DeviceLoader cIt;
    private cyq cIu;
    private cyu cIv;
    private final Runnable cIw = new C24171(this);
    private final BroadcastReceiver cIx = new C24204(this);
    private final BroadcastReceiver cIy = new C24215(this);
    private final cmi cmS;
    private DeviceRepository mDeviceRepository;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final cnq mProviderManager;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C24171 implements Runnable {
        final /* synthetic */ cvx cIz;

        C24171(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public void run() {
            this.cIz.aiI();
        }
    }

    class C24182 implements OnUpdateUserComplete {
        final /* synthetic */ cvx cIz;

        C24182(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
            MFLogger.m12670d(cvx.TAG, "Update user active device to empty complete");
        }
    }

    class C24193 implements C2126d<C2519b, C2131a> {
        final /* synthetic */ cvx cIz;

        C24193(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7709a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7710a((C2519b) obj);
        }

        public void m7710a(C2519b c2519b) {
            this.cIz.kf(c2519b.getBatteryLevel());
        }

        public void m7709a(C2131a c2131a) {
            MFLogger.m12670d(cvx.TAG, "GetBattery onError");
        }
    }

    class C24204 extends BroadcastReceiver {
        final /* synthetic */ cvx cIz;

        C24204(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(Constants.SERIAL_NUMBER);
            int intExtra = intent.getIntExtra(Constants.CONNECTION_STATE, ConnectionStateChange.GATT_OFF.ordinal());
            MFLogger.m12670d(cvx.TAG, "mConnectionStateChangeReceiver: serial = " + stringExtra + ", state = " + intExtra);
            if (this.cIz.cIs != null && this.cIz.cIs.getDeviceId().equalsIgnoreCase(stringExtra)) {
                switch (intExtra) {
                    case 0:
                        this.cIz.cIm.kd(1);
                        return;
                    case 1:
                        this.cIz.cIm.kd(2);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class C24215 extends BroadcastReceiver {
        final /* synthetic */ cvx cIz;

        C24215(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            MFLogger.m12670d(cvx.TAG, "Inside .syncReceiver serial=" + stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                int intExtra = intent.getIntExtra("sync_result", 3);
                MFLogger.m12670d(cvx.TAG, "Inside .syncReceiver syncResult=" + intExtra + ",  serial=" + stringExtra);
                if (this.cIz.cIm.isActive()) {
                    int intExtra2 = intent.getIntExtra("LAST_ERROR_CODE", -1);
                    switch (intExtra) {
                        case 2:
                        case 4:
                            switch (intExtra2) {
                                case FailureCode.BLUETOOTH_IS_DISABLED /*1101*/:
                                case FailureCode.LOCATION_SERVICE_DISABLED /*1112*/:
                                case FailureCode.LOCATION_ACCESS_DENIED /*1113*/:
                                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("LIST_ERROR_CODE");
                                    if (integerArrayListExtra == null) {
                                        integerArrayListExtra = new ArrayList();
                                    }
                                    this.cIz.cIm.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(integerArrayListExtra).toArray(new PermissionCodes[0]));
                                    break;
                                default:
                                    this.cIz.cIm.kc(intExtra);
                                    break;
                            }
                            MFLogger.m12670d(cvx.TAG, "Sync failed due to" + intExtra2);
                            return;
                        default:
                            this.cIz.cIm.kc(intExtra);
                            return;
                    }
                }
            }
        }
    }

    class C24226 implements C2126d<C2500b, C2131a> {
        final /* synthetic */ cvx cIz;

        C24226(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7711a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7712a((C2500b) obj);
        }

        public void m7712a(C2500b c2500b) {
            int gattState = c2500b.getGattState();
            MFLogger.m12670d(cvx.TAG, "Inside .checkDeviceConnectionStatus device=" + this.cIz.cIs.getDeviceId() + ", state=" + gattState);
            this.cIz.cIm.kd(gattState == 2 ? 1 : 2);
            if (gattState != 2) {
                MFLogger.m12670d(cvx.TAG, "Inside .checkDeviceConnectionStatus device=" + this.cIz.cIs.getDeviceId() + " is disconnected, reconnecting");
                this.cIz.aiH();
            }
        }

        public void m7711a(C2131a c2131a) {
            MFLogger.m12670d(cvx.TAG, "Inside .checkDeviceConnectionStatus fail to get gattState of device=" + this.cIz.cIs.getDeviceId());
            this.cIz.cIm.kd(3);
        }
    }

    class C24237 implements C2126d<C2531c, C2530b> {
        final /* synthetic */ cvx cIz;

        C24237(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7713a((C2530b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7714a((C2531c) obj);
        }

        public void m7714a(C2531c c2531c) {
            this.cIz.cIm.kd(1);
        }

        public void m7713a(C2530b c2530b) {
            this.cIz.cIm.kd(3);
        }
    }

    class C24248 implements C2126d<C2557c, C2556b> {
        final /* synthetic */ cvx cIz;

        C24248(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7715a((C2556b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7716a((C2557c) obj);
        }

        public void m7716a(C2557c c2557c) {
            this.cIz.cIm.afU();
            this.cIz.cIm.aiA();
        }

        public void m7715a(C2556b c2556b) {
            this.cIz.cIm.afU();
            this.cIz.cIm.jV(c2556b.getErrorCode());
        }
    }

    class C24259 implements C2126d<C2546c, C2545b> {
        final /* synthetic */ cvx cIz;

        C24259(cvx com_fossil_cvx) {
            this.cIz = com_fossil_cvx;
        }

        public /* synthetic */ void onError(Object obj) {
            m7717a((C2545b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7718a((C2546c) obj);
        }

        public void m7718a(C2546c c2546c) {
            this.cIz.cIm.afU();
            this.cIz.cIm.aiA();
        }

        public void m7717a(C2545b c2545b) {
            this.cIz.cIm.afU();
            this.cIz.cIm.jV(c2545b.getErrorCode());
        }
    }

    cvx(PortfolioApp portfolioApp, C2402b c2402b, cnr com_fossil_cnr, gy gyVar, cnq com_fossil_cnq, fj fjVar, cmi com_fossil_cmi, ckc com_fossil_ckc, cyq com_fossil_cyq, cyy com_fossil_cyy, cyu com_fossil_cyu, DeviceRepository deviceRepository, UserRepository userRepository, cym com_fossil_cym, cyc com_fossil_cyc) {
        this.cIo = portfolioApp;
        this.cIm = c2402b;
        this.mDeviceRepository = deviceRepository;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cEa = gyVar;
        this.mProviderManager = com_fossil_cnq;
        this.cmS = com_fossil_cmi;
        this.cIp = com_fossil_cyy;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cFC = fjVar;
        this.mUserRepository = userRepository;
        this.cIv = com_fossil_cyu;
        this.cIu = com_fossil_cyq;
        this.cIt = new DeviceLoader(this.cIo);
        this.cIq = com_fossil_cym;
        this.cIr = com_fossil_cyc;
    }

    public void ahu() {
        this.cIm.cK(this);
    }

    public void start() {
        this.cFC.mo3100a(17, null, this);
        this.cIo.registerReceiver(this.cIx, new IntentFilter(this.cIo.getPackageName() + ButtonService.ACTION_CONNECTION_STATE_CHANGE));
        this.cEa.m11537a(this.cIy, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        aiI();
        this.cIq.ajd();
    }

    private void kf(int i) {
        MFLogger.m12670d(TAG, "GetBattery onSuccess: batteryLevel = " + i);
        this.mProviderManager.acp().mo1938C(this.cIo.aaa(), i);
        this.cIm.ke(i);
        if (i < 0 || i > this.mSharedPreferencesManager.acY()) {
            this.cIm.aiA();
            this.cmS.abA();
            return;
        }
        this.cmS.abz();
        if (TextUtils.equals(this.cIo.aaa(), this.mSharedPreferencesManager.acW())) {
            this.cIm.aiz();
        }
    }

    private void aiF() {
        this.mUseCaseHandler.m6886a(this.cIq, new C2518a(this.cIo.aaa()), new C24193(this));
    }

    public void stop() {
        try {
            this.mHandler.removeCallbacksAndMessages(null);
            this.cIo.unregisterReceiver(this.cIx);
            this.cEa.unregisterReceiver(this.cIy);
            this.cIq.aje();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Exception when unregister receiver");
            abm.m2872a(0, TAG, "Exception when unregister receiver e=" + e);
        }
    }

    private void aiG() {
        if (this.cIs != null) {
            this.mUseCaseHandler.m6886a(this.cIr, new C2499a(this.cIs.getDeviceId()), new C24226(this));
        }
    }

    public void aiw() {
        MFLogger.m12670d(TAG, "Inside .checkDeviceSyncStatus isSyncing=" + this.cIo.isSyncing(this.cIo.aaa()));
        if (this.cIs != null) {
            if (this.cIo.isSyncing(this.cIo.aaa())) {
                this.cIm.co(false);
                this.cIm.kc(0);
                return;
            }
            this.cIm.co(true);
            this.cIm.aJ(this.mSharedPreferencesManager.gC(this.cIs.getDeviceId()));
        }
    }

    public int getBatteryLevel(String str) {
        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(str, null);
        if (deviceBySerial == null) {
            return 0;
        }
        return deviceBySerial.getBatteryLevel();
    }

    public void aix() {
    }

    private void aiH() {
        if (!TextUtils.isEmpty(this.cIo.aaa())) {
            this.mUseCaseHandler.m6886a(this.cIu, new C2529a(this.cIo.aaa()), new C24237(this));
        }
    }

    public void he(String str) {
        if (this.cIs != null) {
            this.cIm.afT();
            this.mUseCaseHandler.m6886a(this.cIp, new C2555a(this.cIs.getDeviceId()), new C24248(this));
        }
    }

    public void ais() {
        this.cIm.aiy();
    }

    public void ait() {
        this.cIm.aiy();
    }

    public void aiu() {
        if (this.cIs != null) {
            this.cIm.aJ(this.mSharedPreferencesManager.gC(this.cIs.getDeviceId()));
        }
    }

    public void hS(String str) {
        this.cIm.afT();
        this.mUseCaseHandler.m6886a(this.cIv, new C2544a(PortfolioApp.ZQ().aaa(), str), new C24259(this));
    }

    public void aiv() {
        this.cIm.hT(this.cIs.getDeviceId());
    }

    private void aiI() {
        if (this.cIs != null) {
            if (!this.cIo.isSyncing(this.cIo.aaa())) {
                long j;
                C2402b c2402b = this.cIm;
                if (this.cIo.isSyncing(this.cIo.aaa())) {
                    j = -1;
                } else {
                    j = this.mSharedPreferencesManager.gC(this.cIs.getDeviceId());
                }
                c2402b.aJ(j);
            }
            this.mHandler.postDelayed(this.cIw, ShineProfile.LOG_UPLOADING_DELAY);
        }
    }

    public gx<List<DeviceModel>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        this.cIm.afT();
        return this.cIt;
    }

    public void m7732a(gx<List<DeviceModel>> gxVar, List<DeviceModel> list) {
        MFLogger.m12670d(TAG, "Inside .onLoadFinished allDevices=" + list);
        if (list == null || list.isEmpty()) {
            MFLogger.m12670d(TAG, "Inside .onLoadFinish local device is empty, try to fetch on server");
            this.mDeviceRepository.getAllDevice(new GetAllDeviceCallback(this) {
                final /* synthetic */ cvx cIz;

                {
                    this.cIz = r1;
                }

                public void onSuccess(List<DeviceModel> list) {
                    this.cIz.cIm.afU();
                    if (list == null || list.isEmpty()) {
                        MFLogger.m12670d(cvx.TAG, "Inside .onLoadFinish list device on server is empty too, currentActive=" + PortfolioApp.ZQ().aaa());
                        if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
                            PortfolioApp.ZQ().fO("");
                            this.cIz.aiJ();
                        }
                        this.cIz.cIm.finish();
                        return;
                    }
                    MFLogger.m12670d(cvx.TAG, "Inside .onLoadFinish fetch list device on server success, init data currentActive=" + PortfolioApp.ZQ().aaa());
                    this.cIz.m7722W(list);
                }

                public void onFailed(int i) {
                    this.cIz.cIm.afU();
                    this.cIz.cIm.finish();
                }
            });
            return;
        }
        m7722W(list);
    }

    private void aiJ() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        MFLogger.m12670d(TAG, "Inside .updateUserWhenActiveDeviceWasSteal, currentUser=" + currentUser);
        if (currentUser != null) {
            currentUser.setActiveDeviceId("");
            this.mUserRepository.addOrUpdateUser(currentUser, new C24182(this));
        }
    }

    private void m7722W(List<DeviceModel> list) {
        this.cIm.afU();
        String aaa = this.cIo.aaa();
        MFLogger.m12670d(TAG, "Inside .initData with activeSerial=" + aaa);
        for (DeviceModel deviceModel : list) {
            if (!TextUtils.isEmpty(deviceModel.getDeviceId()) && deviceModel.getDeviceId().equalsIgnoreCase(aaa)) {
                this.cIs = deviceModel;
                break;
            }
        }
        if (this.cIs != null) {
            this.cIm.mo2119b(this.cIs);
            kf(this.cIs.getBatteryLevel());
        }
        aiF();
        aiG();
        aiw();
        aiK();
    }

    private void aiK() {
        if (this.cIs != null) {
            this.cIm.cp(DeviceHelper.gk(this.cIs.getDeviceId()));
            this.cIm.cn(DeviceHelper.abH().gd(this.cIs.getDeviceId()));
        }
    }

    public void mo2129a(gx<List<DeviceModel>> gxVar) {
    }
}
