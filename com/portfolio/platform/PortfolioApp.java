package com.portfolio.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.facebook.FacebookSdk;
import com.fossil.abm;
import com.fossil.arh;
import com.fossil.arq;
import com.fossil.cc;
import com.fossil.cd;
import com.fossil.ciy;
import com.fossil.ciz;
import com.fossil.cjv;
import com.fossil.cjw;
import com.fossil.cjy;
import com.fossil.ckc;
import com.fossil.clw;
import com.fossil.cly;
import com.fossil.cmi;
import com.fossil.cmj;
import com.fossil.cmk;
import com.fossil.cmo;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.cne;
import com.fossil.cnf;
import com.fossil.cnq;
import com.fossil.cnr;
import com.fossil.crf;
import com.fossil.cyw;
import com.fossil.cyw.C2552a;
import com.fossil.dqn;
import com.fossil.dqp;
import com.fossil.dqs;
import com.fossil.dqz;
import com.fossil.dre;
import com.fossil.dxh;
import com.fossil.dxo;
import com.fossil.emm;
import com.fossil.emm.C3464a;
import com.fossil.gy;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.google.firebase.iid.FirebaseInstanceId;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.IButtonConnectivity;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.buttonservice.model.AppInfo;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil.BRAND;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.buttonservice.utils.MicroAppEventLogger;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.NotificationType;
import com.portfolio.platform.data.model.Installation;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.FossilBrand;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.receiver.NetworkChangedReceiver;
import com.portfolio.platform.response.device.MFInstallationResponse;
import com.portfolio.platform.service.MFDeviceService;
import com.portfolio.platform.service.MFDeviceService.C3908b;
import com.portfolio.platform.ui.SplashScreenActivity;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig.Builder;

public class PortfolioApp extends cd implements ActivityLifecycleCallbacks {
    private static final String TAG = PortfolioApp.class.getSimpleName();
    public static boolean cmB = false;
    private static PortfolioApp cmC;
    private static dxh cmD;
    private static IButtonConnectivity cmE;
    private static C3908b cmF;
    private static Typeface cmG;
    private static Typeface cmH;
    private LIFECIRCLE cmA;
    protected arq cmI;
    private HashMap<CommunicateMode, Long> cmJ;
    private boolean cmK = false;
    private boolean cmL = true;
    private Runnable cmM;
    private boolean cmN = false;
    private NetworkChangedReceiver cmO;
    private ciy cmP;
    public cnr cmQ;
    public cyw cmR;
    public cmi cmS;
    public dqs cmT;
    private UncaughtExceptionHandler cmU;
    private Handler handler = new Handler();
    public cnr mSharedPreferencesManager;
    public SummariesRepository mSummariesRepository;
    public ckc mUseCaseHandler;
    public UserRepository mUserRepository;

    class C39021 implements UncaughtExceptionHandler {
        final /* synthetic */ PortfolioApp cmV;

        C39021(PortfolioApp portfolioApp) {
            this.cmV = portfolioApp;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            int i = 0;
            MFLogger.m12671e(PortfolioApp.TAG, "uncaughtException - ex=" + th.toString());
            th.printStackTrace();
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace != null ? stackTrace.length : 0;
            if (length > 0) {
                while (i < length) {
                    if (stackTrace[i].getClassName().contains(ButtonService.class.getSimpleName())) {
                        MFLogger.m12671e(PortfolioApp.TAG, "uncaughtException - stopLogService");
                        PortfolioApp.ZQ().stopLogService(FailureCode.APP_CRASH_FROM_BUTTON_SERVICE);
                        break;
                    }
                    i++;
                }
            }
            this.cmV.cmU.uncaughtException(thread, th);
        }
    }

    class C39043 implements MFServerResultCallback {
        final /* synthetic */ PortfolioApp cmV;

        C39043(PortfolioApp portfolioApp) {
            this.cmV = portfolioApp;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(PortfolioApp.TAG, "Save installation success");
            this.cmV.cmQ.gy(((MFInstallationResponse) mFResponse).getInstallation().getInstallationId());
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12671e(PortfolioApp.TAG, "Save installation fail, " + i);
        }
    }

    class C39054 implements Runnable {
        final /* synthetic */ PortfolioApp cmV;

        C39054(PortfolioApp portfolioApp) {
            this.cmV = portfolioApp;
        }

        public void run() {
            if (this.cmV.cmK && this.cmV.cmL) {
                this.cmV.cmK = false;
                MFLogger.m12670d(PortfolioApp.TAG, "went background");
                this.cmV.cmQ.m7245c(this.cmV.cmJ);
                return;
            }
            MFLogger.m12670d(PortfolioApp.TAG, "still foreground");
        }
    }

    class C39065 extends Thread {
        final /* synthetic */ PortfolioApp cmV;

        C39065(PortfolioApp portfolioApp) {
            this.cmV = portfolioApp;
        }

        public void run() {
            try {
                FirebaseInstanceId.VW().VX();
            } catch (IOException e) {
                MFLogger.m12671e(PortfolioApp.TAG, e.toString());
            }
        }
    }

    enum LIFECIRCLE {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    public static PortfolioApp ZQ() {
        return cmC;
    }

    public static IButtonConnectivity ZR() {
        return cmE;
    }

    public static void m12674a(IButtonConnectivity iButtonConnectivity) {
        cmE = iButtonConnectivity;
    }

    public static void m12676a(C3908b c3908b) {
        cmF = c3908b;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        cc.m5968h(this);
    }

    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "On app create");
        cmC = this;
        this.cmP = cjv.ZN().m6691b(new ciz(this)).ZO();
        this.cmP.mo1841a(this);
        MFLogger.initialize(this, "App");
        MicroAppEventLogger.initialize(this);
        emm.m10900a(new C3464a(this).m10899a(new abm()).dI(true).aEW());
        cmD = new cly(dxo.dAw);
        this.cmJ = new HashMap();
        MFNetwork.getInstance(this).setLocale(getLocale());
        FacebookSdk.sdkInitialize(this);
        aan();
        ZS();
        ZZ();
        cmj.bs(this).bQ(cmj.bs(this).abD());
        CalligraphyConfig.initDefault(new Builder().setFontAttrId(R.attr.fontPath).build());
        cmG = Typeface.createFromAsset(getAssets(), getString(R.string.font_path_regular));
        cmH = Typeface.createFromAsset(getAssets(), getString(R.string.font_path_bold));
        registerActivityLifecycleCallbacks(this);
        aae();
        cmk.abF();
        this.cmI = new arq(this, "2.3.1");
        cjw.init();
        registerReceiver(this.cmI, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        registerActivityLifecycleCallbacks(this.cmI.Jz());
        ZT();
        this.cmI.Jy();
        arh.Jj().m4278a(dqn.bK(this));
        arh.Jj().ac(this);
        if (LocationUtils.isLocationPermissionGranted(this)) {
            ZZ();
        }
        abm.xd().aHj.setString("Network Version", MFNetwork.getInstance(this).getVersion());
        abm.xd().aHj.setString("SDK Version", ButtonService.getSDKVersion());
        abm.xd().aHj.setString("Locale", Locale.getDefault().toString());
        try {
            if (VERSION.SDK_INT >= 24) {
                this.cmO = new NetworkChangedReceiver();
                registerReceiver(this.cmO, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "onCreate - jobScheduler - ex=" + e);
        }
        this.cmU = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new C39021(this));
        VmPolicy.Builder builder = new VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        this.cmS.abC();
        this.cmS.bp(this);
        this.mSharedPreferencesManager.cg(true);
        this.mSharedPreferencesManager.ch(false);
    }

    private void ZS() {
        ZY();
    }

    public static void cL(Object obj) {
        cmD.cO(obj);
    }

    public static void cM(Object obj) {
        try {
            cmD.cV(obj);
        } catch (Exception e) {
            abm.m2872a(0, TAG, "Exception when register bus events for object=" + obj + ",exception=" + e);
        }
    }

    public static void cN(Object obj) {
        try {
            cmD.cW(obj);
        } catch (Exception e) {
            abm.m2872a(0, TAG, "Exception when unregister bus events for object=" + obj + ",exception=" + e);
        }
    }

    private void ZT() {
        if (dre.dff.ct(this)) {
            getContentResolver().registerContentObserver(Contacts.CONTENT_URI, true, this.cmT);
        }
    }

    private void ZU() {
        getContentResolver().unregisterContentObserver(this.cmT);
    }

    public void onTerminate() {
        super.onTerminate();
        MFLogger.m12670d(TAG, "---Inside .onTerminate of Application");
        unregisterReceiver(this.cmI);
        ZU();
        unregisterActivityLifecycleCallbacks(this.cmI.Jz());
        if (VERSION.SDK_INT >= 24) {
            MFLogger.m12670d(TAG, "unregister NetworkChangedReceiver");
            unregisterReceiver(this.cmO);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        System.runFinalization();
    }

    public void onTrimMemory(int i) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onTrimMemory");
        super.onTrimMemory(i);
        System.runFinalization();
    }

    public static Typeface ZV() {
        return cmG;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.cmA = LIFECIRCLE.CREATE;
    }

    public void onActivityStarted(Activity activity) {
        this.cmA = LIFECIRCLE.START;
    }

    public void onActivityStopped(Activity activity) {
        this.cmA = LIFECIRCLE.STOP;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        this.cmA = LIFECIRCLE.DESTROY;
    }

    public boolean isSyncing(String str) {
        try {
            return cmE.isSyncing(str);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ZW() {
        return "release".equalsIgnoreCase("release");
    }

    public void m12698e(final boolean z, final int i) {
        MFLogger.m12670d(TAG, "startDeviceSync, isNewDevice=" + z + ", syncMode=" + i);
        Intent intent = new Intent("BROADCAST_SYNC_COMPLETE");
        intent.putExtra("sync_result", 0);
        intent.putExtra("SERIAL", aaa());
        this.cmQ.m7250r(0, aaa());
        gy.m11536p(ZQ()).m11538b(intent);
        if (isSyncing(aaa())) {
            MFLogger.m12670d(TAG, "Device is syncing, Skip this sync.");
        } else {
            Executors.newSingleThreadExecutor().execute(new Runnable(this) {
                final /* synthetic */ PortfolioApp cmV;

                public void run() {
                    this.cmV.cmR.m7951a(new C2552a(this.cmV.aaa(), i, z));
                }
            });
        }
    }

    public void ZX() {
        long gB = this.cmQ.gB(aaa());
        long acJ = this.cmQ.acJ();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".startHWLogSync, lastSyncTime=" + gB + ", lastHWLogSyncTime=" + acJ);
        if (!cmq.m7114c(new Date(gB)).booleanValue() && !cmq.m7114c(new Date(acJ)).booleanValue()) {
            Object aaa = ZQ().aaa();
            if (TextUtils.isEmpty(aaa)) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".startHWLogSync - serial is null");
                return;
            }
            try {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".startHWLogSync, OK");
                cmE.deviceStartHWLogSync(aaa);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".startHWLogSync - e=" + e);
            }
        }
    }

    public void ZY() {
        startService(new Intent(this, MFDeviceService.class));
    }

    public void ZZ() {
        MFLogger.m12670d(TAG, ".startButtonService");
        startService(new Intent(this, ButtonService.class));
    }

    public String aaa() {
        String activeDeviceId = this.cmQ.getActiveDeviceId();
        return activeDeviceId != null ? activeDeviceId : "";
    }

    public void an(String str, String str2) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".setActiveDeviceSerial - current=" + aaa() + ", new=" + str);
        this.cmQ.gx(str);
        try {
            ZR().setActiveSerial(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean fO(String str) {
        boolean z = false;
        UserProfile aad = ZQ().aad();
        if (aad == null) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".switchActiveDevice - user is null");
        } else {
            try {
                z = ZR().switchActiveDevice(str, aad);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String aaa = aaa();
            if (z) {
                this.cmQ.gx(str);
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".switchActiveDevice - current=" + aaa + ", new=" + str + ", success=" + z);
        }
        return z;
    }

    public void fP(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.equalsIgnoreCase(aaa())) {
                    this.cmQ.gx("");
                }
                ZR().deviceUnlink(str);
                this.cmQ.m7241a(str, 0, false);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".unlinkDevice - serial=" + str + ", ex=" + e.toString());
            }
        }
    }

    public void aab() {
        try {
            ZR().logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date aac() {
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        if (currentUser != null) {
            Object createdAt = currentUser.getCreatedAt();
            if (!TextUtils.isEmpty(createdAt)) {
                return cne.getStartOfDay(cmq.fZ(createdAt));
            }
        }
        MFLogger.m12670d(TAG, "Fail to getCurrentUserRegisteringDate, return new Date(1, 1, 1)");
        return new Date(1, 1, 1);
    }

    public UserProfile aad() {
        int i = 1;
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null) {
            return null;
        }
        long j = 0;
        Object birthday = currentUser.getBirthday();
        if (!TextUtils.isEmpty(birthday)) {
            j = (long) (Calendar.getInstance().get(1) - Integer.valueOf(birthday.split("-")[0]).intValue());
        }
        float az = cmo.az(currentUser.getWeightInGrams() > 0 ? (float) currentUser.getWeightInGrams() : 68039.0f);
        float au = cmo.au(currentUser.getHeightInCentimeters() > 0 ? (float) currentUser.getHeightInCentimeters() : 170.0f);
        float b = cmt.abK().m7150b(new Date(), true);
        if (currentUser.getGender() == Gender.MALE) {
            i = 0;
        } else if (currentUser.getGender() != Gender.FEMALE) {
            i = 0;
        }
        return new UserProfile(0, j, au, az, i, FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL, (int) b, false, -1, System.currentTimeMillis());
    }

    public void aae() {
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        if (currentUser != null) {
            Installation installation = new Installation();
            installation.setAppMarketingVersion("2.3.1");
            installation.setAppBuildNumber(12638);
            installation.setModel(Build.MODEL);
            installation.setOsVersion(VERSION.RELEASE);
            installation.setInstallationId(cmk.fV(currentUser.getUserId()));
            installation.setAppPermissions(dre.dff.auP());
            if (this.cmQ != null) {
                installation.setDeviceToken(this.cmQ.acC());
            }
            String id = TimeZone.getDefault().getID();
            if (id.indexOf(47) > 0) {
                installation.setTimeZone(id);
            }
            try {
                id = getPackageName();
                PackageManager packageManager = getPackageManager();
                Object obj = packageManager.getPackageInfo(id, 0).versionName;
                Object charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(id, 0)).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    installation.setAppName(charSequence);
                }
                if (!TextUtils.isEmpty(obj)) {
                    installation.setAppVersion(obj);
                }
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Cannot load package info; will not be saved to installation");
            }
            installation.setDeviceType("android");
            m12675a(installation);
            MFNetwork.getInstance(this).execute(new crf(this, installation), new C39043(this));
        }
    }

    public void fQ(String str) {
        this.cmQ.gz(str);
    }

    private void m12675a(Installation installation) {
        installation.setLocaleIdentifier(getLocale());
    }

    public String getLocale() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        CharSequence country = locale.getCountry();
        if (TextUtils.isEmpty(language)) {
            return "";
        }
        if (language.equals("iw")) {
            language = "he";
        }
        if (language.equals("in")) {
            language = "id";
        }
        if (language.equals("ji")) {
            language = "yi";
        }
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format(Locale.US, "%s-%s", new Object[]{language, country});
    }

    public String aaf() {
        return "2.3.1";
    }

    public FossilBrand aag() {
        return FossilBrand.fromInt(Integer.parseInt(cjy.cnN.aaR()));
    }

    public BRAND aah() {
        switch (aag()) {
            case CHAPS:
                return BRAND.CHAPS;
            case DIESEL:
                return BRAND.DIESEL;
            case EA:
                return BRAND.EA;
            case KATESPADE:
                return BRAND.KATE_SPADE;
            case MICHAELKORS:
                return BRAND.MICHAEL_KORS;
            case SKAGEN:
                return BRAND.SKAGEN;
            case AX:
                return BRAND.ARMANI_EXCHANGE;
            case RELIC:
                return BRAND.RELIC;
            case MJ:
                return BRAND.MARC_JACOBS;
            case FOSSIL:
                return BRAND.FOSSIL;
            default:
                return BRAND.UNKNOWN;
        }
    }

    public long m12699z(String str, int i) {
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".setUpdateGoalSteps - serial=" + str + ", goalSteps=" + i);
            if (TextUtils.isEmpty(str)) {
                MFLogger.m12671e(TAG, "Error Inside " + TAG + ".setUpdateGoalSteps - serial=" + str + ", goalSteps=" + i);
            } else {
                j = cmE.deviceUpdateGoalStep(str, i);
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error Inside " + TAG + ".setUpdateGoalSteps - serial=" + str + ", goalSteps=" + i + ", ex=" + e.toString());
        }
        this.cmJ.put(CommunicateMode.SET_STEP_GOAL, Long.valueOf(j));
        return j;
    }

    public long m12687a(NotificationType notificationType, String str, int i, int[] iArr, int[] iArr2, boolean z) {
        long devicePlayHandsNotification;
        try {
            VibeEnum vibeEnum;
            MFLogger.m12670d(TAG, "Inside " + TAG + ".playHandsNotification");
            VibeEnum vibeEnum2 = VibeEnum.OTHERS;
            switch (notificationType) {
                case CALL:
                    vibeEnum = VibeEnum.CALL;
                    break;
                case SMS:
                    vibeEnum = VibeEnum.TEXT;
                    break;
                case EMAIL:
                    vibeEnum = VibeEnum.EMAIL;
                    break;
                case APP_FILTER:
                    vibeEnum = VibeEnum.OTHERS;
                    break;
                case OTHER:
                    vibeEnum = VibeEnum.OTHERS;
                    break;
                default:
                    vibeEnum = vibeEnum2;
                    break;
            }
            devicePlayHandsNotification = cmE.devicePlayHandsNotification(str, i, iArr, iArr2, vibeEnum.ordinal(), z);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".playHandsNotification - e=" + e);
            devicePlayHandsNotification = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        this.cmJ.put(CommunicateMode.SEND_NOTIFICATION, Long.valueOf(devicePlayHandsNotification));
        return devicePlayHandsNotification;
    }

    public long fR(String str) {
        return m12688a(str, 1, 1, true);
    }

    public long m12688a(String str, int i, int i2, boolean z) {
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".playVibeNotification");
            j = cmE.playVibration(str, i, i2, true);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".playVibeNotification - e=" + e);
        }
        this.cmJ.put(CommunicateMode.PLAY_VIBRATION, Long.valueOf(j));
        return j;
    }

    public long m12696d(String str, List<Alarm> list) {
        MFLogger.m12670d(TAG, "setMultipleAlarms - alarms size=" + list.size());
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            j = cmE.deviceSetListAlarm(str, list);
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "setMultipleAlarms - ex=" + e.toString());
        }
        this.cmJ.put(CommunicateMode.SET_LIST_ALARM, Long.valueOf(j));
        return j;
    }

    public void m12684H(List<Alarm> list) {
        MFLogger.m12671e(TAG, "setAutoAlarms - alarms=" + list);
        try {
            cmE.deviceSetAutoListAlarm(list);
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "setAutoAlarms - e=" + e);
        }
    }

    public long m12689a(String str, SecondTimezone secondTimezone) {
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        if (secondTimezone == null) {
            MFLogger.m12671e(TAG, "Fail to set a null second timezone to device");
        } else {
            int timezoneOffset = (int) (secondTimezone.getTimezoneOffset() / 60000);
            try {
                MFLogger.m12670d(TAG, "Set second timezone of serial=" + str + " with minutesOffset: " + timezoneOffset);
                j = cmE.deviceSetSecondTimeZone(str, secondTimezone.getTimezoneId());
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.m12670d(TAG, "Error Set second timezone of serial=" + str + " with minutesOffset: " + timezoneOffset + ", ex=" + e.toString());
            }
        }
        this.cmJ.put(CommunicateMode.SET_SECOND_TIMEZONE, Long.valueOf(j));
        return j;
    }

    public void m12692a(SecondTimezone secondTimezone) {
        try {
            int i;
            String str = "";
            if (secondTimezone == null) {
                i = 1024;
            } else {
                i = cnf.getTimezoneRawOffsetById(secondTimezone.getTimezoneId());
                str = secondTimezone.getTimezoneId();
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".setAutoSecondTimezone - offsetMinutes=" + i + ", mSecondTimezoneId=" + str);
            cmE.deviceSetAutoSecondTimezone(secondTimezone == null ? "" : secondTimezone.getTimezoneId());
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "Inside " + TAG + ".setAutoSecondTimezone - ex=" + e.toString());
        }
    }

    public void bM(boolean z) {
        try {
            String aaa = aaa();
            if (z) {
                cmE.updatePercentageGoalProgress(aaa, true, -1, -1);
                return;
            }
            cmE.updatePercentageGoalProgress(aaa, false, (int) cmt.abK().m7150b(new Date(), true), this.mSummariesRepository.getLastStepGoal(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int fS(String str) {
        try {
            return cmE.getCommunicatorModeBySerial(str);
        } catch (Exception e) {
            return -1;
        }
    }

    public void aai() {
        this.cmQ.jI(16);
        File file = new File(getCacheDir().getParent());
        if (file.exists()) {
            for (String str : file.list()) {
                if (!str.equals("lib")) {
                    m12683y(new File(file, str));
                }
            }
        }
        ((AlarmManager) getSystemService(Alarm.TABLE_NAME)).set(1, System.currentTimeMillis() + 1000, PendingIntent.getActivity(this, 123456, new Intent(this, SplashScreenActivity.class), 268435456));
        if (19 <= VERSION.SDK_INT) {
            ((ActivityManager) getSystemService(Constants.ACTIVITY)).clearApplicationUserData();
            return;
        }
        try {
            Runtime.getRuntime().exec("pm clear " + getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean m12683y(File file) {
        if (file == null) {
            return true;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        boolean z = true;
        for (String file2 : file.list()) {
            if (m12683y(new File(file, file2)) && z) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void onActivityResumed(Activity activity) {
        this.cmA = LIFECIRCLE.RESUME;
        this.cmL = false;
        boolean z = !this.cmK;
        this.cmK = true;
        if (this.cmM != null) {
            this.handler.removeCallbacks(this.cmM);
        }
        if (z) {
            cmB = true;
            MFLogger.m12670d(TAG, "from background");
            this.cmJ = this.cmQ.acL();
            return;
        }
        cmB = false;
        MFLogger.m12670d(TAG, "still foreground");
    }

    public void onActivityPaused(Activity activity) {
        this.cmA = LIFECIRCLE.PAUSE;
        this.cmL = true;
        if (this.cmM != null) {
            this.handler.removeCallbacks(this.cmM);
        }
        Handler handler = this.handler;
        Runnable c39054 = new C39054(this);
        this.cmM = c39054;
        handler.postDelayed(c39054, 500);
    }

    public boolean aaj() {
        return this.cmK;
    }

    public boolean aak() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void m12691a(CommunicateMode communicateMode, String str, String str2) {
        MFLogger.m12670d(TAG, "addLog - communicateMode=" + communicateMode + ", serial=" + str + ", message=" + str2);
        try {
            ZR().addLog(communicateMode.ordinal(), str, str2);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "addLog - ex=" + e.toString());
        }
    }

    public void stopLogService(int i) {
        MFLogger.m12670d(TAG, "stopLogService - failureCode=" + i);
        try {
            ZR().stopLogService(i);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "stopLogService - ex=" + e.toString());
        }
    }

    public int m12686a(CommunicateMode communicateMode, String str) {
        MFLogger.m12670d(TAG, "endLog - communicateMode=" + communicateMode + ", serial=" + str);
        try {
            return ZR().endLog(communicateMode.ordinal(), str);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "endLog - ex=" + e.toString());
            return -1;
        }
    }

    public int m12695b(CommunicateMode communicateMode, String str) {
        MFLogger.m12670d(TAG, "startLog - communicateMode=" + communicateMode + ", serial=" + str);
        try {
            return ZR().startLog(communicateMode.ordinal(), str);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "startLog - ex=" + e.toString());
            return -1;
        }
    }

    public void changePendingLogKey(CommunicateMode communicateMode, String str, CommunicateMode communicateMode2, String str2) {
        MFLogger.m12670d(TAG, "changePendingLogKey - curCommunicateMode=" + communicateMode + ", curSerial=" + str + ", newCommunicateMode=" + communicateMode2 + ", newSerial=" + str2);
        try {
            ZR().changePendingLogKey(communicateMode.ordinal(), str, communicateMode2.ordinal(), str2);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "changePendingLogKey - ex=" + e.toString());
        }
    }

    public long aal() {
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            j = cmE.deviceReadRealTimeStep(aaa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.cmJ.put(CommunicateMode.READ_REAL_TIME_STEP, Long.valueOf(j));
        return j;
    }

    public void bN(boolean z) {
        this.cmN = z;
    }

    public ciy aam() {
        return this.cmP;
    }

    public void simulateDisconnection(int i, int i2, int i3, int i4) {
        String aaa = aaa();
        int min = Math.min(i, 65535);
        int min2 = Math.min(i2, 65535);
        int min3 = Math.min(i3, 65535);
        int min4 = Math.min(i4, 4294967);
        try {
            MFLogger.m12670d(TAG, "Inside simulateDisconnection - delay=" + min + ", duration=" + min2);
            cmE.simulateDisconnection(aaa, min, min2, min3, min4);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".simulateDisconnection - e=" + e);
        }
    }

    public void resetDeviceSettingToDefault() {
        String aaa = aaa();
        try {
            MFLogger.m12670d(TAG, "Inside resetDeviceSettingToDefault");
            cmE.resetDeviceSettingToDefault(aaa);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".resetDeviceSettingToDefault - e=" + e);
        }
    }

    public void setPairedSerial(String str, String str2) {
        MFLogger.m12670d(TAG, ".setPairedSerial - serial=" + str);
        try {
            cmE.setPairedSerial(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "setPairedSerial - serial=" + str + ", ex=" + e.toString());
        }
    }

    public void m12690a(CommunicateMode communicateMode) {
        MFLogger.m12670d(TAG, String.format("Inside " + TAG + " .markReceiveBleResult, mark result received, mode=", new Object[]{communicateMode}));
        if (this.cmJ != null && communicateMode != null) {
            Long l = (Long) this.cmJ.get(communicateMode);
            if (System.currentTimeMillis() >= Long.valueOf(l != null ? l.longValue() : ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD).longValue()) {
                this.cmJ.put(communicateMode, Long.valueOf(ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD));
            }
        }
    }

    public boolean m12694a(Intent intent, Uri uri) {
        Object l = m12682l(uri);
        Object obj = "";
        if (intent != null) {
            obj = intent.getType();
        }
        MFLogger.m12670d(TAG, "isImageFile intentMimeType=" + obj + ", uriMimeType=" + l);
        return uri.getPath().contains("pickerImage") || ((!TextUtils.isEmpty(obj) && obj.contains("image")) || (!TextUtils.isEmpty(l) && l.contains("image")));
    }

    private String m12682l(Uri uri) {
        if (uri.getScheme().equals("content")) {
            return getContentResolver().getType(uri);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString()));
    }

    public void m12685I(List<CommunicateMode> list) {
        if (list != null) {
            for (CommunicateMode communicateMode : list) {
                MFLogger.m12670d(TAG, String.format("Inside " + TAG + " .retrieveBleAction, try retrieve ble action with mode %s", new Object[]{communicateMode}));
                if (cmF == null) {
                    MFLogger.m12670d(TAG, "Inside " + TAG + " .retrieveBleAction, cannot retrieve ble action cause by misfitServiceBinder null");
                } else if (this.cmJ != null) {
                    Long l = (Long) this.cmJ.get(communicateMode);
                    cmF.m12701a(communicateMode, Long.valueOf(l != null ? l.longValue() : ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD).longValue());
                } else {
                    MFLogger.m12670d(TAG, "Inside " + TAG + " .retrieveBleAction, cannot retrieve ble action cause by bleTimeStamp null");
                }
            }
        }
    }

    public void ao(String str, String str2) {
        long j = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".pairDevice");
            j = cmE.pairDevice(str, str2);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".pairDevice - e=" + e);
        }
        this.cmJ.put(CommunicateMode.LINK, Long.valueOf(j));
        this.cmQ.m7245c(this.cmJ);
    }

    public void m12693a(String str, byte[] bArr, boolean z, String str2, String str3, UserProfile userProfile) {
        long deviceOta;
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".otaDevice");
            deviceOta = cmE.deviceOta(str, bArr, z, str2, str3, userProfile);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".otaDevice - e=" + e);
            deviceOta = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        this.cmJ.put(CommunicateMode.OTA, Long.valueOf(deviceOta));
        this.cmQ.m7245c(this.cmJ);
    }

    public cnr YV() {
        return this.cmQ;
    }

    public void aan() {
        ButtonService.init(cjy.cnN.aba(), dqp.lx(2), "release".equals("release") ? aah() : BRAND.UNKNOWN, AppInfo.getAppInfoJson(new AppInfo("2.3.1 - 12638", VERSION.RELEASE)));
        MFNetwork.getInstance(this).initialize(false, clw.USER_AGENT);
        dqz.aum().m9451F(this, dqp.lx(0));
    }

    public long m12697e(String str, List<MicroAppMapping> list) {
        long deviceSetMapping;
        try {
            for (MicroAppMapping microAppMapping : list) {
                StringBuilder stringBuilder = new StringBuilder("Inside .setMappings set mapping of deviceId=" + str + ", gesture=" + microAppMapping.getGesture() + ", appID=" + microAppMapping.getMicroAppId() + ", declarationFiles=");
                for (String append : microAppMapping.getDeclarationFiles()) {
                    stringBuilder.append("||").append(append);
                }
                MFLogger.m12670d(TAG, stringBuilder.toString());
                MFLogger.m12670d(TAG, "Inside .setMappings set mapping of deviceId=" + str + ", gesture=" + microAppMapping.getGesture() + ", appID=" + microAppMapping.getMicroAppId() + ", extraInfo=" + microAppMapping.getDeclarationFiles());
            }
            deviceSetMapping = cmE.deviceSetMapping(str, MicroAppMapping.convertToBLEMapping(list));
        } catch (Exception e) {
            e.printStackTrace();
            deviceSetMapping = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        this.cmJ.put(CommunicateMode.SET_LINK_MAPPING, Long.valueOf(deviceSetMapping));
        return deviceSetMapping;
    }

    public void setAutoMapping(String str, List<BLEMapping> list) {
        MFLogger.m12670d(TAG, "setAutoMapping serial=" + str);
        try {
            cmE.setAutoMapping(str, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMicroAppRemoteActivity(String str, MicroAppInstruction microAppInstruction) {
        try {
            cmE.sendMicroAppRemoteActivity(str, microAppInstruction);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".sendMicroAppRemoteActivity - e=" + e);
        }
    }

    public void aao() {
        FirebaseInstanceId.VW().getToken();
    }

    public void aap() {
        new C39065(this).start();
    }
}
