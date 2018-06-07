package com.portfolio.platform.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.fossil.cfj;
import com.fossil.cka;
import com.fossil.cka.C2130b;
import com.fossil.ckc;
import com.fossil.clx.C2163a;
import com.fossil.clx.C2165c;
import com.fossil.clx.C2168g;
import com.fossil.clx.C2169h;
import com.fossil.clx.C2170i;
import com.fossil.clx.C2171j;
import com.fossil.clx.C2172k;
import com.fossil.clx.C2174m;
import com.fossil.clx.C2175n;
import com.fossil.clx.C2179q;
import com.fossil.clx.C2180r;
import com.fossil.clx.C2182t;
import com.fossil.clx.C2183v;
import com.fossil.clx.C2184w;
import com.fossil.clx.C2185x;
import com.fossil.clx.C2186y;
import com.fossil.cmj;
import com.fossil.cml;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.cmv;
import com.fossil.cnm;
import com.fossil.cnq;
import com.fossil.cnr;
import com.fossil.ctb;
import com.fossil.ctb.C2286a;
import com.fossil.cth;
import com.fossil.djg;
import com.fossil.djg.C2827a;
import com.fossil.djg.C2828b;
import com.fossil.djo;
import com.fossil.djo.C2846a;
import com.fossil.djo.C2847b;
import com.fossil.dkc;
import com.fossil.dkc.C2872a;
import com.fossil.gy;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.location.DeviceLocation;
import com.fossil.wearables.fsl.location.LocationProvider;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.ReadRealTimeStepSession;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.WrapperSleep;
import com.misfit.frameworks.buttonservice.model.WrapperSyncResult;
import com.misfit.frameworks.buttonservice.model.WrapperTapEventSummary;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.model.buddychallenge.BCHeartbeatStep;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository.UAppSystemVersionRepositoryObserver;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.interfaces.ShortcutDownloadingObserver;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

public class MFDeviceService extends Service {
    public static final String LOCATION_UPDATED = (MFDeviceService.class.getPackage().getName() + ".location_updated");
    private static final String TAG = MFDeviceService.class.getSimpleName();
    private final IBinder binder = new C3908b(this);
    public SleepSessionsRepository cBa;
    public cka cCJ;
    public djg cCK;
    public djo cCL;
    public dkc cCM;
    public ctb cCN;
    public cth cCO;
    private String cCP;
    private MisfitDeviceProfile cCQ;
    private boolean cCR;
    private ServiceConnection cCS = new 1(this);
    private boolean cCT;
    private Handler cCU;
    private Runnable cCV = new 10(this);
    private Handler cCW;
    private Runnable cCX = new 11(this);
    private List<String> cCY;
    private HashMap<CommunicateMode, a> cCZ = new HashMap();
    private UAppSystemVersionRepositoryObserver cDa = new 12(this);
    private ShortcutDownloadingObserver cDb = new 13(this);
    private final BroadcastReceiver cDc = new 14(this);
    private final BroadcastReceiver cDd = new 2(this);
    private final BroadcastReceiver cDe = new 3(this);
    private final BroadcastReceiver cDf = new 4(this);
    private final BroadcastReceiver cDg = new 5(this);
    private final BroadcastReceiver cDh = new 6(this);
    private BroadcastReceiver cDi = new 7(this);
    private BroadcastReceiver cDj = new 8(this);
    public cnr cmQ;
    public ActivitiesRepository cxG;
    public ckc czo;
    public DeviceRepository mDeviceRepository;
    public MicroAppSettingRepository mMicroAppSettingRepository;
    public PresetRepository mPresetRepository;
    public UAppSystemVersionRepository mUAppSystemVersionRepository;
    public UserRepository mUserRepository;

    public class C3908b extends Binder {
        final /* synthetic */ MFDeviceService cDk;

        public C3908b(MFDeviceService mFDeviceService) {
            this.cDk = mFDeviceService;
        }

        public MFDeviceService afj() {
            return this.cDk;
        }

        public void m12701a(CommunicateMode communicateMode, long j) {
            if (this.cDk.cCZ != null) {
                a aVar = (a) this.cDk.cCZ.get(communicateMode);
                if (aVar != null) {
                    MFLogger.m12670d(MFDeviceService.TAG, String.format("Inside .retrieveBleAction mode=%s, timeStamp=%s", new Object[]{communicateMode, Long.valueOf(j)}));
                    if (aVar.getTimeStamp() >= j) {
                        MFLogger.m12670d(MFDeviceService.TAG, "Inside .retrieveBleAction mode=%s, timeStamp=%s \n" + aVar.toString());
                        this.cDk.m12702a(this.cDk, aVar);
                        return;
                    }
                    return;
                }
                MFLogger.m12670d(MFDeviceService.TAG, String.format("Inside .retrieveBleAction mode=%s, no result available.", new Object[]{communicateMode}));
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MFLogger.m12672i(TAG, "on startOnboardingFlow misfit service - isButtonServiceBound=" + this.cCT);
        if (!this.cCT) {
            bindService(new Intent(this, ButtonService.class), this.cCS, 1);
        }
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        this.mPresetRepository.removeStatusObserver(this.cDb);
        this.mMicroAppSettingRepository.removeStatusObserver(this.cDb);
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".onTaskRemoved");
            if (this.cCT && this.cCS != null) {
                unbindService(this.cCS);
            }
            stopSelf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        MFLogger.m12672i(TAG, "on misfit service bind");
        return this.binder;
    }

    public void onCreate() {
        super.onCreate();
        PortfolioApp.ZQ().aam().mo1854a(this);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onCreate");
        this.cCZ = new HashMap();
        this.cCP = this.cmQ.acK();
        afe();
        this.mUAppSystemVersionRepository.addContentObserver(this.cDa);
        this.mPresetRepository.addStatusObserver(this.cDb);
        this.mMicroAppSettingRepository.addStatusObserver(this.cDb);
    }

    public void onDestroy() {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onDestroy");
        super.onDestroy();
        this.mUAppSystemVersionRepository.removeContentObserver(this.cDa);
        unregisterReceiver(this.cDc);
        unregisterReceiver(this.cDj);
        unregisterReceiver(this.cDe);
        unregisterReceiver(this.cDd);
        unregisterReceiver(this.cDi);
        unregisterReceiver(this.cDf);
        unregisterReceiver(this.cDg);
        unregisterReceiver(this.cDh);
        this.cCR = false;
    }

    private void afb() {
        afc();
        MFLogger.m12670d(TAG, "Start reading realtime step timeoutHandler 30 mins");
        this.cCU = new Handler(getMainLooper());
        this.cCU.postDelayed(this.cCV, 1800000);
    }

    private void afc() {
        if (this.cCU != null) {
            MFLogger.m12670d(TAG, "Stop reading realtime step timeoutHandler");
            this.cCU.removeCallbacks(this.cCV);
        }
    }

    private void afd() {
        List<DeviceModel> allDevice = this.mDeviceRepository.getAllDevice(null);
        MFLogger.m12670d(TAG, "Get all device success devicesList=" + allDevice.size());
        if (this.mUserRepository.getCurrentUser() != null) {
            for (DeviceModel deviceModel : allDevice) {
                PortfolioApp.ZQ().setPairedSerial(deviceModel.getDeviceId(), deviceModel.getMacAddress());
            }
        }
    }

    private void m12702a(Context context, a aVar) {
        if (aVar == null) {
            MFLogger.m12670d(TAG, "Inside .processBleResult, the bleResultData is null!! Do nothing.");
            return;
        }
        CommunicateMode aff = aVar.aff();
        String serial = aVar.getSerial();
        int afg = aVar.afg();
        int errorCode = aVar.getErrorCode();
        ArrayList afh = aVar.afh();
        Bundle afi = aVar.afi();
        int i = afi != null ? afi.getInt(ButtonService.LOG_ID, -1) : -1;
        int i2;
        String str;
        switch (9.$SwitchMap$com$misfit$frameworks$buttonservice$communite$CommunicateMode[aff.ordinal()]) {
            case 1:
                this.cmQ.aG(System.currentTimeMillis());
                cnm.abX().m7221a(serial, -1, CommunicateMode.SYNC, i);
                break;
            case 2:
                this.cmQ.m7244c(System.currentTimeMillis(), serial);
                PortfolioApp ZQ = PortfolioApp.ZQ();
                if (afg != ServiceActionResult.PROCESSING.ordinal()) {
                    if (afg != ServiceActionResult.UNALLOWED_ACTION.ordinal()) {
                        if (afg != ServiceActionResult.FAILED.ordinal()) {
                            if (afg == ServiceActionResult.RECEIVED_DATA.ordinal()) {
                                if (afi == null) {
                                    ZQ.m12691a(CommunicateMode.SYNC, serial, "Sync data result OK but extra info is EMPTY");
                                    ZQ.bM(true);
                                    break;
                                }
                                Object string = afi.getString(Constants.SYNC_RESULT, "");
                                ZQ.m12691a(CommunicateMode.SYNC, serial, "Sync data result access key=" + string);
                                if (!TextUtils.isEmpty(string)) {
                                    try {
                                        Executors.newSingleThreadExecutor().execute(new 15(this, string, serial, ZQ));
                                        break;
                                    } catch (Exception e) {
                                        MFLogger.m12671e(TAG, "Error while parsing WrapperSyncResult - e=" + e);
                                        ZQ.m12691a(CommunicateMode.SYNC, serial, "Sync data result OK but has exception error e=" + e.toString());
                                        ZQ.bM(true);
                                        break;
                                    }
                                }
                                MFLogger.m12671e(TAG, "Inside " + TAG + ".processBleResult - syncResultAccessKey is EMPTY");
                                ZQ.m12691a(CommunicateMode.SYNC, serial, "Sync data result OK but syncResultAccessKey is EMPTY");
                                ZQ.bM(true);
                                break;
                            }
                            this.cmQ.m7246d(System.currentTimeMillis(), serial);
                            if (afi != null) {
                                this.cCQ = (MisfitDeviceProfile) afi.getParcelable(Constants.DEVICE);
                                if (afi.getInt(ButtonService.SYNC_MODE) == 13 && !this.cmQ.gF(serial)) {
                                    this.cmQ.m7241a(serial, afi.getLong(Constants.SYNC_ID), true);
                                }
                            }
                            cnm.abX().m7221a(serial, -1, CommunicateMode.SYNC, i);
                            m12723r(serial, 1, 0);
                            afb();
                            break;
                        }
                        m12710a(serial, 2, errorCode, afh);
                        cnm.abX().m7221a(serial, -1, CommunicateMode.SYNC, i);
                        break;
                    }
                    m12710a(serial, 4, errorCode, afh);
                    break;
                }
                m12723r(serial, 0, 0);
                break;
            case 4:
                if (afg == ServiceActionResult.SUCCEEDED.ordinal()) {
                    i2 = 100;
                    if (afi != null) {
                        i2 = afi.getInt(Constants.BATTERY);
                        cnq.acd().acp().mo1938C(serial, i2);
                    }
                    PortfolioApp.cL(new C2183v(serial, i2));
                    break;
                }
                break;
            case 5:
                Map map;
                Intent intent = new Intent("BROADCAST_OTA_COMPLETE");
                SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(serial));
                if (hl != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Serial_Number", serial);
                    hashMap.put("Device_Name", hl.getDeviceName());
                    map = hashMap;
                } else {
                    map = null;
                }
                if (afg == ServiceActionResult.SUCCEEDED.ordinal()) {
                    cnm.abX().m7221a(serial, -1, CommunicateMode.OTA, i);
                    if (afi != null) {
                        this.cCQ = (MisfitDeviceProfile) afi.getParcelable(Constants.DEVICE);
                    }
                    str = "";
                    if (this.cCQ != null) {
                        MFLogger.m12670d(TAG, "OTA complete, update fw version from device=" + str);
                        str = this.cCQ.getFirmwareVersion();
                    } else {
                        MFLogger.m12670d(TAG, "OTA complete, update fw version from temp=" + str);
                        str = this.cmQ.gM(serial);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(serial, null);
                        if (deviceBySerial != null) {
                            MFLogger.m12670d(TAG, "OTA complete, update fw version=" + str);
                            deviceBySerial.setFirmwareRevision(str);
                            this.mDeviceRepository.updateDevice(deviceBySerial, null);
                        }
                    }
                    intent.putExtra("OTA_RESULT", true);
                    if (map != null) {
                        m12725f("ota_success", map);
                    }
                } else {
                    if (map != null) {
                        map.put("Error_Code", String.valueOf(errorCode));
                        m12725f("ota_fail", map);
                    }
                    intent.putExtra("OTA_RESULT", false);
                    cnm.abX().m7221a(serial, -1, CommunicateMode.OTA, i);
                }
                MFLogger.m12670d(TAG, "Inside .OTA receiver, broadcast local in app");
                gy.m11536p(PortfolioApp.ZQ()).m11538b(intent);
                break;
            case 6:
                if (afg == ServiceActionResult.SUCCEEDED.ordinal()) {
                    if (afi == null) {
                        cnm.abX().m7220a(serial, -1, CommunicateMode.LINK);
                        break;
                    }
                    this.cCQ = (MisfitDeviceProfile) afi.getParcelable(Constants.DEVICE);
                    if (this.cCQ == null) {
                        MFLogger.m12670d(TAG, ".processBleResult: Weird, currentDeviceProfile is null.");
                        break;
                    }
                    m12704a(this.cCQ, this.cCQ.getDeviceSerial());
                    PortfolioApp.cL(new C2180r(this.cCQ));
                    break;
                }
                PortfolioApp.cL(new C2179q(serial));
                break;
            case 7:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2184w(serial));
                    break;
                } else {
                    PortfolioApp.cL(new C2184w(serial));
                    break;
                }
            case 8:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2182t(serial, false));
                    break;
                } else {
                    PortfolioApp.cL(new C2182t(serial, true));
                    break;
                }
            case 9:
            case 10:
                Intent intent2 = new Intent();
                if (afg == ServiceActionResult.SUCCEEDED.ordinal() && afi != null) {
                    this.cCQ = (MisfitDeviceProfile) afi.getParcelable(Constants.DEVICE);
                }
                if (afg == ServiceActionResult.SUCCEEDED.ordinal()) {
                    intent2.putExtra("goalTrackingSuccess", true);
                    intent2.putExtra("LAST_ERROR_CODE", 0);
                } else {
                    intent2.putExtra("goalTrackingSuccess", false);
                    intent2.putExtra("LAST_ERROR_CODE", FailureCode.FAILED_TO_CONNECT);
                }
                intent2.setAction("BROADCAST_RECONNECT_DEVICE_USECASE");
                gy.m11536p(PortfolioApp.ZQ()).m11538b(intent2);
                break;
            case 11:
                break;
            case 12:
                MFLogger.m12670d(TAG, "Broadcast " + aff + ", result=" + afg);
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2170i(false));
                    break;
                } else {
                    PortfolioApp.cL(new C2170i(true));
                    break;
                }
            case 13:
                MFLogger.m12670d(TAG, "Broadcast " + aff + ", result=" + afg);
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2169h(false));
                    break;
                } else {
                    PortfolioApp.cL(new C2169h(true));
                    break;
                }
            case 14:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2165c(serial, 0, 0, false, false));
                    break;
                }
                str = "";
                if (afi != null) {
                    afi.getString(ButtonService.ALARM_GET_ALARM);
                    break;
                }
                break;
            case 15:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2163a(serial, false));
                    break;
                } else {
                    PortfolioApp.cL(new C2163a(serial, true));
                    break;
                }
            case 16:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2171j(serial, false));
                    break;
                } else {
                    PortfolioApp.cL(new C2171j(serial, true));
                    break;
                }
            case 17:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2185x(serial, false));
                    break;
                } else {
                    PortfolioApp.cL(new C2185x(serial, true));
                    break;
                }
            case 18:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2174m(serial, false, 0));
                    break;
                }
                i2 = 0;
                if (afi != null) {
                    i2 = afi.getInt(Constants.TZ_OFFSET);
                }
                PortfolioApp.cL(new C2174m(serial, true, i2));
                break;
            case 19:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2175n(serial, false, 0));
                    break;
                }
                i2 = 0;
                if (afi != null) {
                    i2 = afi.getInt(ButtonService.GET_VIBRATION_STRENGTH);
                }
                PortfolioApp.cL(new C2175n(serial, true, i2));
                break;
            case 20:
                PortfolioApp.cL(new C2186y(serial, afg == ServiceActionResult.SUCCEEDED.ordinal()));
                break;
            case 21:
                if (afg != ServiceActionResult.SUCCEEDED.ordinal()) {
                    PortfolioApp.cL(new C2172k(serial, false));
                    break;
                } else {
                    PortfolioApp.cL(new C2172k(serial, true));
                    break;
                }
            case 22:
                if (afg == ServiceActionResult.SUCCEEDED.ordinal() && afi != null) {
                    MFLogger.m12670d(TAG, "Read realtime steps succeeded - steps=" + afi.getLong(ReadRealTimeStepSession.STEPS) + ", storedSteps=" + cmt.abK().m7152q(new Date()));
                    break;
                }
        }
        PortfolioApp.cL(new C2168g(serial, afg == ServiceActionResult.SUCCEEDED.ordinal()));
        if (aVar.getIntent() != null) {
            gy.m11536p(PortfolioApp.ZQ()).m11538b(aVar.getIntent());
        }
    }

    private void m12703a(MisfitDeviceProfile misfitDeviceProfile) {
        this.mUAppSystemVersionRepository.addOrUpdateUAppSystemVersionModel(new UAppSystemVersionModel(misfitDeviceProfile.getDeviceSerial(), misfitDeviceProfile.getMicroAppMajorVersion(), misfitDeviceProfile.getMicroAppMinorVersion()));
    }

    private void hy(String str) {
        MFLogger.m12670d(TAG, "downloadVariants deviceSerial=" + str);
        this.czo.m6886a(this.cCN, new C2286a(str), new 16(this));
    }

    private String buildTapEventString(List<WrapperTapEventSummary> list) {
        if (list == null || list.isEmpty()) {
            return "null\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (WrapperTapEventSummary wrapperTapEventSummary : list) {
            stringBuilder.append("[startTime:").append(wrapperTapEventSummary.startTime).append(", doubleTaps:").append(wrapperTapEventSummary.doubleTapCount).append(", tripleTaps:").append(wrapperTapEventSummary.tripleTapCount).append(", goalTrackingIds=").append(wrapperTapEventSummary.goalTrackingIds != null ? Arrays.toString(wrapperTapEventSummary.goalTrackingIds) : "null").append("]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void m12705a(WrapperSyncResult wrapperSyncResult, String str) {
        List list;
        Object e;
        PortfolioApp ZQ = PortfolioApp.ZQ();
        if (wrapperSyncResult == null) {
            MFLogger.m12671e(TAG, "Inside " + TAG + ".saveSyncResult - syncResult is NULL");
            ZQ.m12691a(CommunicateMode.SYNC, str, "saveSyncResult - syncResult is NULL");
            return;
        }
        MFLogger.m12672i(TAG, "Inside " + TAG + ".saveSyncResult - sleeps=" + wrapperSyncResult.getSleep().size() + ", minuteData=" + wrapperSyncResult.getMinuteDataList().size() + ", realTimeSteps=" + wrapperSyncResult.getRealTimeStep() + ", taps=" + buildTapEventString(wrapperSyncResult.getTapEventSummaryList()));
        ZQ.m12691a(CommunicateMode.SYNC, str, "Save sync result - sleeps=" + wrapperSyncResult.getSleep().size() + ", minuteData=" + wrapperSyncResult.getMinuteDataList().size() + ", realTimeSteps=" + wrapperSyncResult.getRealTimeStep() + ", taps=" + buildTapEventString(wrapperSyncResult.getTapEventSummaryList()));
        this.cCY = new ArrayList(wrapperSyncResult.getFileIds());
        MFLogger.m12670d(TAG, "Inside " + TAG + ".saveSyncResult - calling FitnessHelper.sampleRawToSampleHalfHour");
        ArrayList arrayList = new ArrayList();
        List<WrapperSleep> sleep = wrapperSyncResult.getSleep();
        List minuteDataList = wrapperSyncResult.getMinuteDataList();
        List tapEventSummaryList = wrapperSyncResult.getTapEventSummaryList();
        try {
            ZQ.m12691a(CommunicateMode.SYNC, str, "Processing data - minute data list");
            minuteDataList = cmt.abK().m7146a(minuteDataList, str);
            try {
                ZQ.m12691a(CommunicateMode.SYNC, str, "Processing data - minute data list. OK");
                list = minuteDataList;
            } catch (Exception e2) {
                e = e2;
                ZQ.m12691a(CommunicateMode.SYNC, str, "Processing data - minute data list. FAILED");
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - e=" + e);
                list = minuteDataList;
                if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
                }
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - Sync data does not match any user's device");
                m12723r(str, 1, 0);
                return;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            minuteDataList = arrayList;
            e = exception;
            ZQ.m12691a(CommunicateMode.SYNC, str, "Processing data - minute data list. FAILED");
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - e=" + e);
            list = minuteDataList;
            if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
            }
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - Sync data does not match any user's device");
            m12723r(str, 1, 0);
            return;
        }
        if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa()) || !PortfolioApp.ZQ().aaa().equalsIgnoreCase(str)) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - Sync data does not match any user's device");
            m12723r(str, 1, 0);
            return;
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".saveSyncResult - sleepSession=" + sleep.size() + ", sampleRaws=" + r1.size());
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving sleep data");
        List arrayList2 = new ArrayList();
        for (WrapperSleep wrapperSleep : sleep) {
            ZQ.m12691a(CommunicateMode.SYNC, str, "Saving sleep data - startTime=" + wrapperSleep.startTime + ", duration=" + wrapperSleep.duration + ", sleepMinute=" + wrapperSleep.sleepMinute);
            MFSleepSession a = cmt.m7143a(wrapperSleep, str);
            if (a != null) {
                arrayList2.add(a);
            }
        }
        try {
            this.cBa.insertFromDevice(arrayList2);
        } catch (Exception e32) {
            ZQ.m12691a(CommunicateMode.SYNC, str, "Saving sleep data. error=" + e32.getMessage());
        }
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving sleep data. OK");
        MFLogger.m12670d(TAG, ".saveSyncResult - Upload sleep sessions to server");
        ArrayList arrayList3 = new ArrayList();
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving activity data");
        for (SampleRaw sampleRaw : r1) {
            sampleRaw.setSteps(Math.ceil(sampleRaw.getSteps()));
            MFLogger.m12670d(TAG, ".saveSyncResult - Saving " + sampleRaw);
            arrayList3.add(sampleRaw.getUri().toString());
            ThirdPartyUploadIntentService.a(this, sampleRaw, str);
        }
        try {
            this.cxG.insertFromDevice(r1);
        } catch (Exception e322) {
            ZQ.m12691a(CommunicateMode.SYNC, str, "Saving activity data. error=" + e322.getMessage());
        }
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving activity data. OK");
        String str2 = "";
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            str2 = currentUser.getUserId();
        }
        cmt.abK().m7148a(new Date(), wrapperSyncResult.getRealTimeStep(), str2);
        MFLogger.m12670d(TAG, ".saveSyncResult - Update heartbeat step by syncing");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        BCHeartbeatStep bCHeartbeatStep = new BCHeartbeatStep();
        bCHeartbeatStep.setHeartbeatSteps((int) wrapperSyncResult.getRealTimeStep());
        bCHeartbeatStep.setLastHeartbeatStamp(timeInMillis);
        cml.abG().m7096a(bCHeartbeatStep);
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving goal tracking data");
        if (tapEventSummaryList != null) {
            try {
                if (tapEventSummaryList.size() > 0) {
                    m12715b(tapEventSummaryList, str);
                    ZQ.m12691a(CommunicateMode.SYNC, str, "Saving goal tracking data. OK");
                    if (this.cCY != null && !this.cCY.isEmpty()) {
                        MFLogger.m12672i(TAG, "DONE save to database, delete data file");
                        try {
                            PortfolioApp.ZR().deleteDataFiles(this.cCY, str);
                            return;
                        } catch (Exception e3222) {
                            MFLogger.m12671e(TAG, "Error while deleting data file - e=" + e3222);
                            return;
                        } finally {
                            this.cCY.clear();
                        }
                    }
                }
            } catch (Exception e32222) {
                ZQ.m12691a(CommunicateMode.SYNC, str, "Saving goal tracking data. error=" + e32222.getMessage());
            }
        }
        ZQ.m12691a(CommunicateMode.SYNC, str, "No goal tracking data");
        ZQ.m12691a(CommunicateMode.SYNC, str, "Saving goal tracking data. OK");
        if (this.cCY != null) {
        }
    }

    private void m12715b(List<WrapperTapEventSummary> list, String str) {
        MFLogger.m12670d(TAG, "start process goal data, get active preset to check goal tracking");
        PortfolioApp ZQ = PortfolioApp.ZQ();
        Object obj = null;
        C2130b abo = this.cCJ.m6877a(this.cCK, new C2827a(str)).abo();
        if (abo.Kb()) {
            C2828b c2828b = (C2828b) abo.abp();
            if (c2828b != null) {
                ActivePreset aqj = c2828b.aqj();
                if (aqj != null) {
                    for (ButtonMapping microAppId : aqj.getButtonMappingList()) {
                        Object obj2;
                        if (MicroAppID.UAPP_GOAL_TRACKING_ID.getValue().equals(microAppId.getMicroAppId())) {
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
            }
        }
        if (obj != null) {
            GoalTrackingSettings goalTrackingSettings;
            MicroAppSetting microAppSetting;
            Date updatedDate;
            Date time;
            int aE;
            long[] jArr;
            int i;
            Date date;
            MFLogger.m12670d(TAG, "got goal tracking in active preset, get goal tracking setting to filter data.");
            abo = this.cCJ.m6877a(this.cCL, new C2846a(MicroAppID.UAPP_GOAL_TRACKING_ID.getValue())).abo();
            if (abo.Kb()) {
                C2847b c2847b = (C2847b) abo.abp();
                if (c2847b != null) {
                    MicroAppSetting aqu = c2847b.aqu();
                    if (aqu != null) {
                        goalTrackingSettings = (GoalTrackingSettings) new cfj().m6205c(aqu.getSetting(), GoalTrackingSettings.class);
                        microAppSetting = aqu;
                    } else {
                        goalTrackingSettings = null;
                        microAppSetting = aqu;
                    }
                    if (goalTrackingSettings == null) {
                        MFLogger.m12670d(TAG, "goal tracking setting is not null, let's filter data.");
                        updatedDate = goalTrackingSettings.getUpdatedDate();
                        time = Calendar.getInstance().getTime();
                        aE = cmv.aE((long) goalTrackingSettings.getGoalId());
                        for (WrapperTapEventSummary wrapperTapEventSummary : list) {
                            if (wrapperTapEventSummary.goalTrackingIds != null) {
                                jArr = wrapperTapEventSummary.goalTrackingIds;
                                if (jArr.length < 1) {
                                    MFLogger.m12671e(TAG, ".saveSyncResult - Cannot find goalTrackingIds for tap events");
                                    break;
                                }
                                i = 0;
                                for (long j : jArr) {
                                    if (j == ((long) aE)) {
                                        i++;
                                    }
                                }
                                date = new Date(wrapperTapEventSummary.startTime * 1000);
                                if (!cmq.m7108a(date, time)) {
                                    if (cmq.m7123e(date, updatedDate)) {
                                        goalTrackingSettings.setValue(i);
                                        goalTrackingSettings.setUpdatedDate(date);
                                    } else if (cmq.m7108a(date, updatedDate)) {
                                        goalTrackingSettings.setValue(goalTrackingSettings.getValue() + i);
                                    }
                                }
                            } else {
                                MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - goalIds is NULL");
                            }
                        }
                        microAppSetting.setSetting(new cfj().toJson(goalTrackingSettings));
                        this.cCJ.m6877a(this.cCM, new C2872a(microAppSetting)).abo();
                        return;
                    }
                    MFLogger.m12670d(TAG, "Goal tracking setting is null. Ignore this data.");
                    ZQ.m12691a(CommunicateMode.SYNC, str, "Goaltracking setting is null. Ignore this data.");
                    return;
                }
            }
            goalTrackingSettings = null;
            microAppSetting = null;
            if (goalTrackingSettings == null) {
                MFLogger.m12670d(TAG, "Goal tracking setting is null. Ignore this data.");
                ZQ.m12691a(CommunicateMode.SYNC, str, "Goaltracking setting is null. Ignore this data.");
                return;
            }
            MFLogger.m12670d(TAG, "goal tracking setting is not null, let's filter data.");
            updatedDate = goalTrackingSettings.getUpdatedDate();
            time = Calendar.getInstance().getTime();
            aE = cmv.aE((long) goalTrackingSettings.getGoalId());
            for (WrapperTapEventSummary wrapperTapEventSummary2 : list) {
                if (wrapperTapEventSummary2.goalTrackingIds != null) {
                    jArr = wrapperTapEventSummary2.goalTrackingIds;
                    if (jArr.length < 1) {
                        MFLogger.m12671e(TAG, ".saveSyncResult - Cannot find goalTrackingIds for tap events");
                        break;
                    }
                    i = 0;
                    while (r4 < r12) {
                        if (j == ((long) aE)) {
                            i++;
                        }
                    }
                    date = new Date(wrapperTapEventSummary2.startTime * 1000);
                    if (!cmq.m7108a(date, time)) {
                        if (cmq.m7123e(date, updatedDate)) {
                            goalTrackingSettings.setValue(i);
                            goalTrackingSettings.setUpdatedDate(date);
                        } else if (cmq.m7108a(date, updatedDate)) {
                            goalTrackingSettings.setValue(goalTrackingSettings.getValue() + i);
                        }
                    }
                } else {
                    MFLogger.m12671e(TAG, "Error inside " + TAG + ".saveSyncResult - goalIds is NULL");
                }
            }
            microAppSetting.setSetting(new cfj().toJson(goalTrackingSettings));
            this.cCJ.m6877a(this.cCM, new C2872a(microAppSetting)).abo();
            return;
        }
        MFLogger.m12670d(TAG, "Goal tracking is not set as active app. Ignore this data.");
        ZQ.m12691a(CommunicateMode.SYNC, str, "Goaltracking is not set as active app. Ignore this data.");
    }

    private void m12723r(String str, int i, int i2) {
        m12710a(str, i, i2, new ArrayList(i2));
    }

    private void m12710a(String str, int i, int i2, ArrayList<Integer> arrayList) {
        MFLogger.m12672i(TAG, "Broadcast sync status=" + i);
        this.cmQ.m7250r(i, str);
        Intent intent = new Intent("BROADCAST_SYNC_COMPLETE");
        intent.putExtra("sync_result", i);
        intent.putExtra("LAST_ERROR_CODE", i2);
        intent.putIntegerArrayListExtra("LIST_ERROR_CODE", arrayList);
        intent.putExtra("SERIAL", str);
        gy.m11536p(PortfolioApp.ZQ()).m11538b(intent);
    }

    private void m12704a(MisfitDeviceProfile misfitDeviceProfile, String str) {
        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(str, null);
        if (deviceBySerial != null && misfitDeviceProfile != null) {
            MFLogger.m12670d(TAG, "Inside .connectionStateChangeReceiver updateLocalDevice with batteryLevel=" + misfitDeviceProfile.getBatteryLevel() + ", fwRevision=" + misfitDeviceProfile.getFirmwareVersion() + ", deviceModel=" + misfitDeviceProfile.getDeviceModel());
            deviceBySerial.setBatteryLevel(misfitDeviceProfile.getBatteryLevel());
            deviceBySerial.setFirmwareRevision(misfitDeviceProfile.getFirmwareVersion());
            deviceBySerial.setSku(misfitDeviceProfile.getDeviceModel());
            deviceBySerial.setMacAddress(misfitDeviceProfile.getAddress());
            deviceBySerial.setMajor(misfitDeviceProfile.getMicroAppMajorVersion());
            deviceBySerial.setMinor(misfitDeviceProfile.getMicroAppMinorVersion());
            this.mDeviceRepository.updateDevice(deviceBySerial, new 17(this));
            m12703a(misfitDeviceProfile);
        }
    }

    private String hz(String str) {
        MFLogger.m12670d(TAG, "Key=" + getPackageName() + str);
        return getPackageName() + str;
    }

    public void afe() {
        if (this.cCR) {
            MFLogger.m12671e(TAG, "Return from device service register receiver");
            return;
        }
        MFLogger.m12672i(TAG, "Inside " + TAG + ".registerReceiver " + hz(ButtonService.ACTION_SERVICE_BLE_RESPONSE));
        registerReceiver(this.cDc, new IntentFilter(hz(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
        registerReceiver(this.cDj, new IntentFilter(hz(ButtonService.ACTION_ANALYTIC_EVENT)));
        MFLogger.m12672i(TAG, "Inside " + TAG + ".registerReceiver " + ButtonService.ACTION_SERVICE_STREAMING_EVENT);
        registerReceiver(this.cDe, new IntentFilter(hz(ButtonService.ACTION_SERVICE_STREAMING_EVENT)));
        MFLogger.m12672i(TAG, "Inside " + TAG + ".registerReceiver " + ButtonService.ACTION_SERVICE_MICRO_APP_EVENT);
        registerReceiver(this.cDf, new IntentFilter(hz(ButtonService.ACTION_SERVICE_MICRO_APP_EVENT)));
        MFLogger.m12672i(TAG, "Inside " + TAG + ".registerReceiver " + ButtonService.ACTION_SERVICE_MICRO_APP_CANCEL_EVENT);
        registerReceiver(this.cDg, new IntentFilter(hz(ButtonService.ACTION_SERVICE_MICRO_APP_CANCEL_EVENT)));
        MFLogger.m12672i(TAG, "Inside " + TAG + ".registerReceiver " + ButtonService.ACTION_SERVICE_HEARTBEAT_DATA);
        registerReceiver(this.cDh, new IntentFilter(hz(ButtonService.ACTION_SERVICE_HEARTBEAT_DATA)));
        registerReceiver(this.cDd, new IntentFilter(hz(ButtonService.ACTION_CONNECTION_STATE_CHANGE)));
        registerReceiver(this.cDi, new IntentFilter(hz(ButtonService.ACTION_SCAN_DEVICE_FOUND)));
        this.cCR = true;
    }

    private void hA(String str) {
        double latitude;
        double d = 0.0d;
        LocationProvider acl = cnq.acd().acl();
        DeviceLocation deviceLocation = acl.getDeviceLocation(str);
        if (deviceLocation != null) {
            latitude = deviceLocation.getLatitude();
        } else {
            latitude = 0.0d;
        }
        if (deviceLocation != null) {
            d = deviceLocation.getLongitude();
        }
        acl.saveDeviceLocation(new DeviceLocation(str, latitude, d, System.currentTimeMillis()));
    }

    public void m12724a(String str, Location location, int i) {
        if (i >= 0) {
            if (location != null) {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".onLocationUpdated - location=[lat:" + location.getLatitude() + ", lon:" + location.getLongitude() + ", accuracy:" + location.getAccuracy() + "]");
                if (location.getAccuracy() <= 500.0f) {
                    try {
                        DeviceLocation deviceLocation = new DeviceLocation(str, location.getLatitude(), location.getLongitude(), System.currentTimeMillis());
                        cnq.acd().acl().saveDeviceLocation(deviceLocation);
                        m12711a(str, deviceLocation);
                    } catch (Exception e) {
                        MFLogger.m12671e(TAG, "Error inside " + TAG + ".onLocationUpdated - e=" + e);
                    }
                }
            }
        } else if (i != -1) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".onLocationUpdated - code=" + i);
        }
    }

    private void m12711a(String str, DeviceLocation deviceLocation) {
        Intent intent = new Intent();
        intent.putExtra("SERIAL", str);
        intent.putExtra("device_location", deviceLocation);
        intent.setAction(LOCATION_UPDATED);
        sendBroadcast(intent);
    }

    protected void hB(String str) {
        cmj.bs(PortfolioApp.ZQ()).logEvent(str);
    }

    protected void m12725f(String str, Map<String, String> map) {
        cmj.bs(PortfolioApp.ZQ()).m7085e(str, map);
    }
}
