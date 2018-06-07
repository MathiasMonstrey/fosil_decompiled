package com.misfit.ble.shine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4518o;
import com.misfit.ble.obfuscated.C4563r;
import com.misfit.ble.obfuscated.C4592s;
import com.misfit.ble.obfuscated.am;
import com.misfit.ble.obfuscated.an;
import com.misfit.ble.obfuscated.ao;
import com.misfit.ble.obfuscated.ao.C4452c;
import com.misfit.ble.obfuscated.ao.C4453d;
import com.misfit.ble.obfuscated.ap;
import com.misfit.ble.obfuscated.aq;
import com.misfit.ble.obfuscated.aq.C4454a;
import com.misfit.ble.obfuscated.ar;
import com.misfit.ble.obfuscated.au;
import com.misfit.ble.obfuscated.av;
import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ax;
import com.misfit.ble.obfuscated.ay;
import com.misfit.ble.obfuscated.az;
import com.misfit.ble.obfuscated.ba;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.bb;
import com.misfit.ble.obfuscated.bc;
import com.misfit.ble.obfuscated.bd;
import com.misfit.ble.obfuscated.be;
import com.misfit.ble.obfuscated.bf;
import com.misfit.ble.obfuscated.bh;
import com.misfit.ble.obfuscated.bi;
import com.misfit.ble.obfuscated.bj;
import com.misfit.ble.obfuscated.bk;
import com.misfit.ble.obfuscated.bl;
import com.misfit.ble.obfuscated.bm;
import com.misfit.ble.obfuscated.bn.C4497a;
import com.misfit.ble.obfuscated.bo;
import com.misfit.ble.obfuscated.bo.C4498a;
import com.misfit.ble.obfuscated.bp;
import com.misfit.ble.obfuscated.bq;
import com.misfit.ble.obfuscated.bw;
import com.misfit.ble.obfuscated.bx;
import com.misfit.ble.obfuscated.bx.C4505a;
import com.misfit.ble.obfuscated.by;
import com.misfit.ble.obfuscated.bz;
import com.misfit.ble.obfuscated.bz.C4506a;
import com.misfit.ble.obfuscated.bz.C4507b;
import com.misfit.ble.obfuscated.bz.C4508c;
import com.misfit.ble.obfuscated.bz.C4509d;
import com.misfit.ble.obfuscated.ca;
import com.misfit.ble.obfuscated.cb;
import com.misfit.ble.obfuscated.cc;
import com.misfit.ble.obfuscated.ci;
import com.misfit.ble.obfuscated.ew;
import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.obfuscated.hd;
import com.misfit.ble.setting.eventmapping.EventMapping;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.setting.eventmapping.HIDKeyboardEventMapping;
import com.misfit.ble.setting.eventmapping.HIDMediaEventMapping;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.StopWatchSecondHand;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.pluto.GoalHitNotificationSettings;
import com.misfit.ble.setting.pluto.InactivityNudgeSettings;
import com.misfit.ble.setting.pluto.NotificationsSettings;
import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.HandControl;
import com.misfit.ble.setting.sam.HandSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingType;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.setting.uapp.UAppEventSetting;
import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.ble.shine.firmware.CustomFirmware;
import com.misfit.ble.shine.firmware.Firmware;
import com.misfit.ble.shine.log.LogManager;
import com.misfit.ble.util.LogUtils;
import com.misfit.ble.util.MutableBoolean;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.data.MFDeviceModel;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class ShineProfile {
    public static final String DEVICE_CONFIGURATION_ACTIVITY_POINT_KEY = "com.misfit.ble.Shine.Configuration.activityPointKey";
    public static final String DEVICE_CONFIGURATION_ACTIVITY_TAGGING_KEY = "com.misfit.ble.Shine.Configuration.activityTaggingKey";
    public static final String DEVICE_CONFIGURATION_BATTERY_KEY = "com.misfit.ble.Shine.Configuration.batteryKey";
    public static final String DEVICE_CONFIGURATION_CLOCK_STATE_KEY = "com.misfit.ble.Shine.Configuration.clockStateKey";
    public static final String DEVICE_CONFIGURATION_COUNTDOWN_SETTINGS_KEY = "com.misfit.ble.Shine.Configuration.countdownSettingKey";
    public static final String DEVICE_CONFIGURATION_CURRENT_STEPS_KEY = "com.misfit.ble.Shine.Configuration.currentStepsKey";
    public static final String DEVICE_CONFIGURATION_EXTRA_ADVERTISING_DATA_STATE_KEY = "com.misfit.ble.Shine.Configuration.extraAdvertisingDataStateKey";
    public static final String DEVICE_CONFIGURATION_FLASH_BUTTON_MODE_KEY = "com.misfit.ble.Shine.Configuration.flashButtonModeKey";
    public static final String DEVICE_CONFIGURATION_GOAL_IN_STEPS_KEY = "com.misfit.ble.Shine.Configuration.goalInStepsKey";
    public static final String DEVICE_CONFIGURATION_GOAL_KEY = "com.misfit.ble.Shine.Configuration.goalKey";
    public static final String DEVICE_CONFIGURATION_GOAL_TRACKING_SETTINGS_KEY = "com.misfit.ble.Shine.Configuration.goalTrackingSettingsKey";
    public static final String DEVICE_CONFIGURATION_GROUP_ID_KEY = "com.misfit.ble.Shine.Configuration.groupIDKey";
    public static final String DEVICE_CONFIGURATION_PASSCODE_KEY = "com.misfit.ble.Shine.Configuration.passcodeKey";
    public static final String DEVICE_CONFIGURATION_TIMEZONE_OFFSET_KEY = "com.misfit.ble.Shine.Configuration.timezoneOffsetKey";
    public static final String DEVICE_CONFIGURATION_TIME_KEY = "com.misfit.ble.Shine.Configuration.timeKey";
    public static final String DEVICE_CONFIGURATION_TRIPLE_TAP_KEY = "com.misfit.ble.Shine.Configuration.tripleTapKey";
    public static final String DEVICE_CONFIGURATION_VIBE_STRENGTH_KEY = "com.misfit.ble.Shine.Configuration.vibeStrengthKey";
    public static final String DEVICE_CONFIGURATION_WRIST_FLICK_STATE_KEY = "com.misfit.ble.Shine.Configuration.wristFlickStateKey";
    public static final int DEVICE_FAMILY_BMW = 8;
    public static final int DEVICE_FAMILY_BUTTON = 3;
    public static final int DEVICE_FAMILY_FLASH = 2;
    public static final int DEVICE_FAMILY_PLUTO = 5;
    public static final int DEVICE_FAMILY_Q_MOTION = 9;
    public static final int DEVICE_FAMILY_RMM = 10;
    public static final int DEVICE_FAMILY_SAM = 11;
    public static final int DEVICE_FAMILY_SAM_MINI = 13;
    public static final int DEVICE_FAMILY_SAM_SLIM = 12;
    public static final int DEVICE_FAMILY_SHINE = 1;
    public static final int DEVICE_FAMILY_SHINE_MKII = 4;
    public static final int DEVICE_FAMILY_SILVRETTA = 6;
    public static final int DEVICE_FAMILY_SWAROVSKI = 7;
    public static final int DEVICE_FAMILY_UNKNOWN = 0;
    public static final short INVALID_TIMEZONE_OFFSET = (short) 1024;
    public static final long LOG_UPLOADING_DELAY = 30000;
    public static final String SKIP_ERASE_ACTIVITY_FILES = "com.misfit.ble.Shine.ShineProfile.skipEraseActivityFiles";
    public static final String SKIP_ERASE_HARDWARE_LOG = "com.misfit.ble.Shine.ShineProfile.skipEraseHardwareLog";
    public static final String SKIP_READ_ACTIVITY_FILES = "com.misfit.ble.Shine.ShineProfile.skipReadActivityFiles";
    public static final String SKIP_READ_HARDWARE_LOG = "com.misfit.ble.Shine.ShineProfile.skipReadHardwareLog";
    public static final String SKIP_RESUME_OTA = "com.misfit.ble.Shine.ShineProfile.skipResumeOTA";
    public static final String SYNC_PROGRESS_KEY = "com.misfit.ble.Shine.ShineProfile.syncProgressDataKey";
    public static final String SYNC_RESUME_ENABLED_KEY = "com.misfit.ble.Shine.ShineProfile.syncResumeEnabledKey";
    private static final String TAG = ShineProfile.class.getSimpleName();
    private UAppSystemVersion bM;
    private ao eU;
    private ConnectionCallback eV;
    private PreparationCallback eW;
    private ConfigurationCallback eX;
    private StreamingCallback eY;
    private State eZ;
    private volatile boolean fA = false;
    private C4631e fB = null;
    private C4629c fC = null;
    private C4628b fD = null;
    private C4630d fE = null;
    private C4453d fF = new C46171(this);
    private C4463a fG = new C46214(this);
    private C4497a fH = new C46225(this);
    private C4498a fI = new C46236(this);
    private final BroadcastReceiver fJ = new BroadcastReceiver(this) {
        final /* synthetic */ ShineProfile fK;

        {
            this.fK = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                LogUtils.m15476d(ShineProfile.TAG, "BluetoothAdapter state changed, from: " + intExtra + ", to: " + intExtra2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("prevState", intExtra);
                    jSONObject.put("state", intExtra2);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                this.fK.m15358a("bluetoothStateChanged", "bluetoothStateChanged", jSONObject);
                switch (intExtra2) {
                    case 10:
                    case 13:
                        if (this.fK.eZ != State.IDLE && this.fK.eZ != State.CLOSED) {
                            this.fK.m15340a(new ConnectActionResult(1, ConnectionResult.UNEXPECTED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.UNKNOWN, Event.UNKNOWN, Reason.UNKNOWN)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private String fa;
    private String fb;
    private Firmware fc;
    private cb fd;
    private bz fe;
    private Hashtable<ActionID, bz> ff;
    private Hashtable<Event, bz> fg;
    private bz fh;
    private bz fi;
    private Hashtable<ActionID, Integer> fj;
    private Hashtable<ActionID, Integer> fk;
    private Hashtable<ActionID, Integer> fl;
    private int fm;
    private int fn;
    private bm fo;
    private bb fp;
    private ax fq;
    private bc fr;
    private be fs;
    private Event ft;
    private Hashtable<ActionID, ba> fu;
    private ShineDevice fv;
    private long fw;
    private ConnectActionResult fx;
    private boolean fy = false;
    private C4627a fz = null;
    private Handler mHandler;

    public interface ConfigurationCallback {
        void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable);
    }

    class C46171 implements C4453d {
        final /* synthetic */ ShineProfile fK;

        class C46161 implements Runnable {
            final /* synthetic */ C46171 fL;

            C46161(C46171 c46171) {
                this.fL = c46171;
            }

            public void run() {
                this.fL.fK.m15331Z();
            }
        }

        C46171(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void mo4906a(Event event) {
            this.fK.ft = event;
        }

        public void mo4905a(ew ewVar, int i, byte[] bArr) {
            bz bzVar = (bz) this.fK.fg.get(ewVar.getEventID());
            if (bzVar != null && bzVar.jW == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", hb.m15159E(bArr));
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                if (this.fK.am() && this.fK.fu.isEmpty()) {
                    this.fK.m15359a("onFirstResponseReceived", jSONObject);
                    return;
                }
                bzVar.jW = new C4509d(Integer.valueOf(i), jSONObject);
            }
        }

        public void mo4911b(ew ewVar, int i, byte[] bArr) {
            synchronized (this.fK.eU.gi) {
                try {
                    new JSONObject().put("data", hb.m15159E(bArr));
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                if (this.fK.am() && this.fK.fu.isEmpty()) {
                    this.fK.m15359a("onResponseReceived", r2);
                    return;
                }
                bz bzVar = (bz) this.fK.fg.get(ewVar.getEventID());
                if (bzVar == null) {
                    this.fK.m15359a("onResponseReceived", r2);
                } else {
                    bzVar.jX = new C4508c(Integer.valueOf(i), ewVar.getResponseDescriptionJSON());
                    if (!ewVar.isWaitingForResponse()) {
                        this.fK.fg.remove(ewVar.getEventID());
                    }
                }
                for (ba b : new ArrayList(this.fK.fu.values())) {
                    b.m14784b(ewVar, i);
                }
            }
        }

        public void mo4915g(byte[] bArr) {
            if (this.fK.ah() != null) {
                this.fK.m15361a((short) 4, bArr);
            }
        }

        public void mo4914d(C4518o c4518o) {
            synchronized (this.fK.eU.gi) {
                String h = c4518o.mo4860h();
                byte[] value = c4518o.getValue();
                JSONObject jSONObject;
                if ("3dda0002-957f-7d4a-34a6-74696673696d".equals(h) && (byte) 3 == value[0] && (byte) 10 == value[1]) {
                    jSONObject = new JSONObject();
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(value);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        jSONObject.put("status", wrap.get(2));
                        jSONObject.put("connectionInterval", ((double) wrap.getShort(3)) * 1.25d);
                        jSONObject.put("connectionLatency", wrap.getShort(5));
                        jSONObject.put("supervisionTimeout", wrap.getShort(7) * 10);
                    } catch (Throwable e) {
                        C4462b.m14831a(e, "");
                    }
                    this.fK.m15358a("asyncConnectionParametersUpdated", "onConnectionParametersUpdated", jSONObject);
                } else {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", h);
                        jSONObject.put("data", hb.m15159E(value));
                    } catch (Throwable e2) {
                        C4462b.m14831a(e2, "");
                    }
                    this.fK.m15359a("onUnexpectedResponseReceived", jSONObject);
                }
            }
        }

        public void mo4910b(ew ewVar, int i, ap apVar) {
            synchronized (this.fK.eU.gi) {
                if (this.fK.am() && this.fK.fu.isEmpty()) {
                    return;
                }
                this.fK.m15339a(ewVar, i, apVar);
                if (!ewVar.isWaitingForResponse()) {
                    this.fK.fg.remove(ewVar.getEventID());
                }
                for (ba c : new ArrayList(this.fK.fu.values())) {
                    c.m14788c(ewVar, i, apVar);
                }
            }
        }

        public void mo4908b(int i, int i2) {
            int i3 = 1;
            synchronized (this.fK.eU.gi) {
                if (i == 0) {
                    i3 = 0;
                }
                if (!(this.fK.eZ == State.CONNECTING || this.fK.eZ == State.DISCONNECTING || this.fK.fy)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Constants.RESULT, i3);
                        jSONObject.put("status", i);
                        jSONObject.put("state", i2);
                    } catch (Throwable e) {
                        C4462b.m14831a(e, "");
                    }
                    this.fK.m15359a("onConnectionStateChange", jSONObject);
                }
                ConnectActionResult connectActionResult;
                if (this.fK.eZ == State.CONNECTING) {
                    if (i3 == 0 && i2 == 2) {
                        this.fK.m15330Y();
                        this.fK.fn = 0;
                        this.fK.mHandler.postDelayed(new C46161(this), 1600);
                    } else if (this.fK.fn <= 0) {
                        connectActionResult = new ConnectActionResult(i, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, Event.ESTABLISH_CONNECTION, Reason.SENDING_REQUEST_FAILED));
                        this.fK.m15337a(i3, i, i2, connectActionResult.getError());
                        this.fK.m15340a(connectActionResult);
                    } else if (i == 133) {
                        this.fK.m15337a(i3, i, i2, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, Event.ESTABLISH_CONNECTION, Reason.UNKNOWN));
                        this.fK.m15389e(i);
                    } else {
                        this.fK.fn = this.fK.fn - 1;
                        if (i == 19) {
                            if (this.fK.ah() != null) {
                                this.fK.ah().invalidate();
                            }
                            connectActionResult = new ConnectActionResult(i, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, Event.ESTABLISH_CONNECTION, Reason.SENDING_REQUEST_FAILED));
                            this.fK.m15337a(i3, i, i2, connectActionResult.getError());
                            this.fK.m15340a(connectActionResult);
                        } else {
                            connectActionResult = new ConnectActionResult(i, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, Event.ESTABLISH_CONNECTION, Reason.SENDING_REQUEST_FAILED));
                            this.fK.m15337a(i3, i, i2, connectActionResult.getError());
                            this.fK.m15340a(connectActionResult);
                        }
                    }
                } else if (i2 == 0) {
                    if (this.fK.eZ == State.DISCONNECTING) {
                        this.fK.m15340a(this.fK.fx);
                    } else if (this.fK.fy) {
                        this.fK.m15340a(new ConnectActionResult(0, ConnectionResult.SUCCEEDED, null));
                    } else {
                        this.fK.m15340a(new ConnectActionResult(i, ConnectionResult.UNEXPECTED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.UNKNOWN, Event.UNKNOWN, Reason.UNKNOWN)));
                    }
                } else if (i2 == 2) {
                    connectActionResult = new ConnectActionResult(i, ConnectionResult.UNEXPECTED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.UNKNOWN, Event.UNKNOWN, Reason.UNKNOWN));
                    this.fK.m15337a(i3, i, i2, connectActionResult.getError());
                    this.fK.m15340a(connectActionResult);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4912c(int r8, int r9) {
            /*
            r7 = this;
            r0 = r7.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r0 = r0.eZ;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.ShineProfile.State.CONNECTING;	 Catch:{ all -> 0x0038 }
            if (r0 == r2) goto L_0x003b;
        L_0x0013:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0038 }
            r2.<init>();	 Catch:{ all -> 0x0038 }
            r0 = "result";
            r2.put(r0, r9);	 Catch:{ JSONException -> 0x0031 }
            r0 = "status";
            r2.put(r0, r8);	 Catch:{ JSONException -> 0x0031 }
        L_0x0022:
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = "onHandshaking";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0038 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0038 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0038 }
            monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        L_0x0030:
            return;
        L_0x0031:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0038 }
            goto L_0x0022;
        L_0x0038:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0038 }
            throw r0;
        L_0x003b:
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r0.ad();	 Catch:{ all -> 0x0038 }
            if (r9 != 0) goto L_0x006b;
        L_0x0042:
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.ShineProfile.State.CONNECTED;	 Catch:{ all -> 0x0038 }
            r0.eZ = r2;	 Catch:{ all -> 0x0038 }
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r2 = 2;
            r3 = 0;
            r0.m15337a(r9, r8, r2, r3);	 Catch:{ all -> 0x0038 }
            r0 = r7.fK;	 Catch:{ all -> 0x0038 }
            r0 = r0.eV;	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = r3.eZ;	 Catch:{ all -> 0x0038 }
            r4 = new com.misfit.ble.shine.ShineProfile$ConnectActionResult;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.ShineProfile.ConnectionResult.SUCCEEDED;	 Catch:{ all -> 0x0038 }
            r6 = 0;
            r4.<init>(r8, r5, r6);	 Catch:{ all -> 0x0038 }
            r0.onConnectionStateChanged(r2, r3, r4);	 Catch:{ all -> 0x0038 }
        L_0x0069:
            monitor-exit(r1);	 Catch:{ all -> 0x0038 }
            goto L_0x0030;
        L_0x006b:
            r0 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
            if (r8 != r0) goto L_0x0095;
        L_0x006f:
            r0 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0038 }
            r3 = com.misfit.ble.shine.ShineActionID.CONNECT;	 Catch:{ all -> 0x0038 }
            r4 = r7.fK;	 Catch:{ all -> 0x0038 }
            r4 = r4.ft;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.error.ShineError.Reason.GATT_INTERNAL_ERROR;	 Catch:{ all -> 0x0038 }
            r0.<init>(r2, r3, r4, r5);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = 2;
            r2.m15337a(r9, r8, r3, r0);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = "internalDisconnect";
            r4 = new com.misfit.ble.shine.ShineProfile$ConnectActionResult;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.ShineProfile.ConnectionResult.FAILED;	 Catch:{ all -> 0x0038 }
            r4.<init>(r8, r5, r0);	 Catch:{ all -> 0x0038 }
            r2.m15357a(r3, r4);	 Catch:{ all -> 0x0038 }
            goto L_0x0069;
        L_0x0095:
            r0 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
            if (r8 != r0) goto L_0x00bf;
        L_0x0099:
            r0 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0038 }
            r3 = com.misfit.ble.shine.ShineActionID.CONNECT;	 Catch:{ all -> 0x0038 }
            r4 = r7.fK;	 Catch:{ all -> 0x0038 }
            r4 = r4.ft;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.error.ShineError.Reason.LACK_OF_SERVICES;	 Catch:{ all -> 0x0038 }
            r0.<init>(r2, r3, r4, r5);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = 2;
            r2.m15337a(r9, r8, r3, r0);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = "internalDisconnect";
            r4 = new com.misfit.ble.shine.ShineProfile$ConnectActionResult;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.ShineProfile.ConnectionResult.FAILED;	 Catch:{ all -> 0x0038 }
            r4.<init>(r8, r5, r0);	 Catch:{ all -> 0x0038 }
            r2.m15357a(r3, r4);	 Catch:{ all -> 0x0038 }
            goto L_0x0069;
        L_0x00bf:
            r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
            if (r8 != r0) goto L_0x00e9;
        L_0x00c3:
            r0 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0038 }
            r3 = com.misfit.ble.shine.ShineActionID.CONNECT;	 Catch:{ all -> 0x0038 }
            r4 = r7.fK;	 Catch:{ all -> 0x0038 }
            r4 = r4.ft;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.error.ShineError.Reason.LACK_OF_CHARACTERISTICS;	 Catch:{ all -> 0x0038 }
            r0.<init>(r2, r3, r4, r5);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = 2;
            r2.m15337a(r9, r8, r3, r0);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = "internalDisconnect";
            r4 = new com.misfit.ble.shine.ShineProfile$ConnectActionResult;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.ShineProfile.ConnectionResult.FAILED;	 Catch:{ all -> 0x0038 }
            r4.<init>(r8, r5, r0);	 Catch:{ all -> 0x0038 }
            r2.m15357a(r3, r4);	 Catch:{ all -> 0x0038 }
            goto L_0x0069;
        L_0x00e9:
            r0 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0038 }
            r2 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0038 }
            r3 = com.misfit.ble.shine.ShineActionID.CONNECT;	 Catch:{ all -> 0x0038 }
            r4 = r7.fK;	 Catch:{ all -> 0x0038 }
            r4 = r4.ft;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0038 }
            r0.<init>(r2, r3, r4, r5);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = 2;
            r2.m15337a(r9, r8, r3, r0);	 Catch:{ all -> 0x0038 }
            r2 = r7.fK;	 Catch:{ all -> 0x0038 }
            r3 = "internalDisconnect";
            r4 = new com.misfit.ble.shine.ShineProfile$ConnectActionResult;	 Catch:{ all -> 0x0038 }
            r5 = com.misfit.ble.shine.ShineProfile.ConnectionResult.FAILED;	 Catch:{ all -> 0x0038 }
            r4.<init>(r8, r5, r0);	 Catch:{ all -> 0x0038 }
            r2.m15357a(r3, r4);	 Catch:{ all -> 0x0038 }
            goto L_0x0069;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.1.c(int, int):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4903a(int r10, java.lang.String r11) {
            /*
            r9 = this;
            r0 = r9.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0033 }
            r2.<init>();	 Catch:{ all -> 0x0033 }
            r0 = "serialNumber";
            r2.put(r0, r11);	 Catch:{ JSONException -> 0x002c }
        L_0x0013:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.eZ;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.State.PREPARING;	 Catch:{ all -> 0x0033 }
            if (r0 == r3) goto L_0x0036;
        L_0x001d:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = "onSerialNumberRead";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0033 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0033 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0033 }
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        L_0x002b:
            return;
        L_0x002c:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0033 }
            goto L_0x0013;
        L_0x0033:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            throw r0;
        L_0x0036:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r3 = new com.misfit.ble.obfuscated.bz$c;	 Catch:{ all -> 0x0033 }
            r4 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0033 }
            r3.<init>(r4, r2);	 Catch:{ all -> 0x0033 }
            r0.jX = r3;	 Catch:{ all -> 0x0033 }
            if (r10 != 0) goto L_0x00b4;
        L_0x0049:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.m15403l(r11);	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = "readModelNumber";
            r2 = r2.m15405m(r3);	 Catch:{ all -> 0x0033 }
            r0.fe = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.obfuscated.bz$b;	 Catch:{ all -> 0x0033 }
            r3 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = r3.eZ;	 Catch:{ all -> 0x0033 }
            r4 = 0;
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.jU = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r0.m15370b(r2);	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.eU;	 Catch:{ all -> 0x0033 }
            r0 = r0.aC();	 Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x00b1;
        L_0x0082:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x0033 }
            r3 = 1;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3);	 Catch:{ all -> 0x0033 }
            r0.jV = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_MODEL_NUMBER_FAILED;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = r9.fK;	 Catch:{ all -> 0x0033 }
            r7 = r7.ft;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
        L_0x00b1:
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            goto L_0x002b;
        L_0x00b4:
            r0 = 4;
            if (r10 != r0) goto L_0x00bd;
        L_0x00b7:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.createBond();	 Catch:{ all -> 0x0033 }
            goto L_0x00b1;
        L_0x00bd:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_SERIAL_NUMBER_FAILED;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = r9.fK;	 Catch:{ all -> 0x0033 }
            r7 = r7.ft;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
            goto L_0x00b1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.1.a(int, java.lang.String):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4909b(int r10, java.lang.String r11) {
            /*
            r9 = this;
            r0 = r9.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0033 }
            r2.<init>();	 Catch:{ all -> 0x0033 }
            r0 = "model";
            r2.put(r0, r11);	 Catch:{ JSONException -> 0x002c }
        L_0x0013:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.eZ;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.State.PREPARING;	 Catch:{ all -> 0x0033 }
            if (r0 == r3) goto L_0x0036;
        L_0x001d:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = "onModelNumberRead";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0033 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0033 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0033 }
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        L_0x002b:
            return;
        L_0x002c:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0033 }
            goto L_0x0013;
        L_0x0033:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            throw r0;
        L_0x0036:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r3 = new com.misfit.ble.obfuscated.bz$c;	 Catch:{ all -> 0x0033 }
            r4 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0033 }
            r3.<init>(r4, r2);	 Catch:{ all -> 0x0033 }
            r0.jX = r3;	 Catch:{ all -> 0x0033 }
            if (r10 != 0) goto L_0x00ba;
        L_0x0049:
            r0 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x00ba;
        L_0x004f:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.m15401k(r11);	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = "readFirmwareVersion";
            r2 = r2.m15405m(r3);	 Catch:{ all -> 0x0033 }
            r0.fe = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.obfuscated.bz$b;	 Catch:{ all -> 0x0033 }
            r3 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = r3.eZ;	 Catch:{ all -> 0x0033 }
            r4 = 0;
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.jU = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r0.m15370b(r2);	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.eU;	 Catch:{ all -> 0x0033 }
            r0 = r0.aB();	 Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x00b7;
        L_0x0088:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x0033 }
            r3 = 1;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3);	 Catch:{ all -> 0x0033 }
            r0.jV = r2;	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_FW_VERSION_FAILED;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = r9.fK;	 Catch:{ all -> 0x0033 }
            r7 = r7.ft;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
        L_0x00b7:
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            goto L_0x002b;
        L_0x00ba:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_MODEL_NUMBER_FAILED;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = r9.fK;	 Catch:{ all -> 0x0033 }
            r7 = r7.ft;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
            goto L_0x00b7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.1.b(int, java.lang.String):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4913c(int r10, java.lang.String r11) {
            /*
            r9 = this;
            r0 = r9.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0033 }
            r2.<init>();	 Catch:{ all -> 0x0033 }
            r0 = "version";
            r2.put(r0, r11);	 Catch:{ JSONException -> 0x002c }
        L_0x0013:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.eZ;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.State.PREPARING;	 Catch:{ all -> 0x0033 }
            if (r0 == r3) goto L_0x0036;
        L_0x001d:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r3 = "onFirmwareVersionRead";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0033 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0033 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0033 }
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        L_0x002b:
            return;
        L_0x002c:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0033 }
            goto L_0x0013;
        L_0x0033:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            throw r0;
        L_0x0036:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0 = r0.fe;	 Catch:{ all -> 0x0033 }
            r3 = new com.misfit.ble.obfuscated.bz$c;	 Catch:{ all -> 0x0033 }
            r4 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0033 }
            r3.<init>(r4, r2);	 Catch:{ all -> 0x0033 }
            r0.jX = r3;	 Catch:{ all -> 0x0033 }
            if (r10 != 0) goto L_0x0080;
        L_0x0049:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.ab();	 Catch:{ all -> 0x0033 }
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.m15399j(r11);	 Catch:{ all -> 0x0033 }
            r0 = com.misfit.ble.obfuscated.bw.m14977t(r11);	 Catch:{ all -> 0x0033 }
            r2 = com.misfit.ble.obfuscated.C4592s.m15222A();	 Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x007a;
        L_0x005d:
            if (r0 != 0) goto L_0x007a;
        L_0x005f:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.UNKNOWN_FIRMWARE;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = com.misfit.ble.shine.error.ShineError.Event.UNKNOWN_FIRMWARE;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
        L_0x0078:
            monitor-exit(r1);	 Catch:{ all -> 0x0033 }
            goto L_0x002b;
        L_0x007a:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r0.aq();	 Catch:{ all -> 0x0033 }
            goto L_0x0078;
        L_0x0080:
            r0 = r9.fK;	 Catch:{ all -> 0x0033 }
            r2 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x0033 }
            r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_FW_VERSION_FAILED;	 Catch:{ all -> 0x0033 }
            r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0033 }
            r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0033 }
            r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x0033 }
            r7 = r9.fK;	 Catch:{ all -> 0x0033 }
            r7 = r7.ft;	 Catch:{ all -> 0x0033 }
            r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x0033 }
            r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0033 }
            r0.m15341a(r2);	 Catch:{ all -> 0x0033 }
            goto L_0x0078;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.1.c(int, java.lang.String):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4902a(int r8, int r9) {
            /*
            r7 = this;
            r0 = r7.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            r0 = r7.fK;	 Catch:{ all -> 0x0042 }
            r0 = r0.eX;	 Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x001c;
        L_0x0011:
            r0 = com.misfit.ble.shine.ShineProfile.TAG;	 Catch:{ all -> 0x0042 }
            r2 = "ReadRSSICallback is NULL";
            com.misfit.ble.util.LogUtils.m15477e(r0, r2);	 Catch:{ all -> 0x0042 }
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
        L_0x001b:
            return;
        L_0x001c:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0042 }
            r2.<init>();	 Catch:{ all -> 0x0042 }
            r0 = "result";
            r2.put(r0, r8);	 Catch:{ JSONException -> 0x0045 }
            r0 = "rssi";
            r2.put(r0, r9);	 Catch:{ JSONException -> 0x0045 }
        L_0x002b:
            r0 = r7.fK;	 Catch:{ all -> 0x0042 }
            r0 = r0.al();	 Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x004c;
        L_0x0033:
            r0 = r7.fK;	 Catch:{ all -> 0x0042 }
            r3 = "onReadRemoteRssi";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0042 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0042 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0042 }
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            goto L_0x001b;
        L_0x0042:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            throw r0;
        L_0x0045:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0042 }
            goto L_0x002b;
        L_0x004c:
            r0 = new java.util.Hashtable;	 Catch:{ all -> 0x0042 }
            r0.<init>();	 Catch:{ all -> 0x0042 }
            if (r8 != 0) goto L_0x0071;
        L_0x0053:
            r2 = com.misfit.ble.shine.ShineProperty.RSSI;	 Catch:{ all -> 0x0042 }
            r3 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x0042 }
            r0.put(r2, r3);	 Catch:{ all -> 0x0042 }
            r2 = r7.fK;	 Catch:{ all -> 0x0042 }
            r2 = r2.eX;	 Catch:{ all -> 0x0042 }
            r3 = com.misfit.ble.shine.ShineActionID.READ_REMOTE_RSSI;	 Catch:{ all -> 0x0042 }
            r4 = new com.misfit.ble.shine.ShineProfile$ActionResult;	 Catch:{ all -> 0x0042 }
            r5 = com.misfit.ble.shine.ShineProfile.ResultCode.SUCCEEDED;	 Catch:{ all -> 0x0042 }
            r6 = 0;
            r4.<init>(r5, r6);	 Catch:{ all -> 0x0042 }
            r2.onConfigCompleted(r3, r4, r0);	 Catch:{ all -> 0x0042 }
        L_0x006f:
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            goto L_0x001b;
        L_0x0071:
            r2 = com.misfit.ble.shine.ShineProperty.RSSI;	 Catch:{ all -> 0x0042 }
            r3 = -1;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0042 }
            r0.put(r2, r3);	 Catch:{ all -> 0x0042 }
            r2 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x0042 }
            r3 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x0042 }
            r4 = com.misfit.ble.shine.ShineActionID.READ_REMOTE_RSSI;	 Catch:{ all -> 0x0042 }
            r5 = com.misfit.ble.shine.error.ShineError.Event.UNKNOWN;	 Catch:{ all -> 0x0042 }
            r6 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED_WITH_UNKNOWN_ERROR;	 Catch:{ all -> 0x0042 }
            r2.<init>(r3, r4, r5, r6);	 Catch:{ all -> 0x0042 }
            r3 = r7.fK;	 Catch:{ all -> 0x0042 }
            r3 = r3.eX;	 Catch:{ all -> 0x0042 }
            r4 = com.misfit.ble.shine.ShineActionID.READ_REMOTE_RSSI;	 Catch:{ all -> 0x0042 }
            r5 = new com.misfit.ble.shine.ShineProfile$ActionResult;	 Catch:{ all -> 0x0042 }
            r6 = com.misfit.ble.shine.ShineProfile.ResultCode.FAILED;	 Catch:{ all -> 0x0042 }
            r5.<init>(r6, r2);	 Catch:{ all -> 0x0042 }
            r3.onConfigCompleted(r4, r5, r0);	 Catch:{ all -> 0x0042 }
            goto L_0x006f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.1.a(int, int):void");
        }

        public void mo4904a(ba baVar, int i, int i2, int i3, int i4) {
            if (baVar == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("totalSize", i3);
                    jSONObject.put("transferredSize", i4);
                    jSONObject.put("status", i2);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                this.fK.m15359a("onPackageTransferred", jSONObject);
                return;
            }
            this.fK.fk.put(baVar.aR(), Integer.valueOf(i));
            this.fK.fl.put(baVar.aR(), Integer.valueOf(i2));
            this.fK.fj.put(baVar.aR(), Integer.valueOf(i4));
            baVar.mo4828a(i, i3, i4);
        }

        public void ay() {
            if (!this.fK.getCurrentActions().contains(ShineActionID.OTA) && !this.fK.getCurrentActions().contains(ShineActionID.SYNC)) {
                this.fK.as();
            }
        }
    }

    class C46214 implements C4463a {
        final /* synthetic */ ShineProfile fK;

        C46214(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void mo4918a(ba baVar, ew ewVar) {
            synchronized (this.fK.eU.gi) {
                JSONObject requestDescriptionJSON;
                if (baVar != null) {
                    if (this.fK.fu.containsValue(baVar)) {
                        requestDescriptionJSON = ewVar.getRequestDescriptionJSON();
                        Firmware firmware = this.fK.getFirmware();
                        if (firmware == null || TextUtils.isEmpty(firmware.getDeviceModel()) || TextUtils.isEmpty(firmware.getFirmwareVersion())) {
                            try {
                                requestDescriptionJSON.put("firmware", firmware == null ? "null" : firmware.toString());
                            } catch (Throwable e) {
                                C4462b.m14831a(e, "");
                            }
                        }
                        bz b = this.fK.m15405m(ewVar.getRequestName());
                        this.fK.fg.put(ewVar.getEventID(), b);
                        b.jU = new C4507b(this.fK.eZ, requestDescriptionJSON);
                        if (ar.m14767a(firmware, ewVar)) {
                            m15307a(baVar, ewVar, 2);
                            return;
                        }
                        b.jV = new C4506a(Integer.valueOf(3));
                        baVar.m14788c(ewVar, 3, null);
                        return;
                    }
                }
                requestDescriptionJSON = new JSONObject();
                try {
                    requestDescriptionJSON.put("expectedPhase", Arrays.toString(this.fK.getCurrentActions().toArray()));
                    requestDescriptionJSON.put("actualPhase", baVar.getClass().getName());
                    requestDescriptionJSON.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ewVar.getRequestDescriptionJSON());
                } catch (Throwable e2) {
                    C4462b.m14831a(e2, "");
                }
                this.fK.m15359a("onSyncPhaseSendRequest", requestDescriptionJSON);
            }
        }

        public void mo4917a(ba baVar, ci ciVar) {
            synchronized (this.fK.eU.gi) {
                JSONObject jSONObject;
                if (baVar != null) {
                    if (this.fK.fu.containsValue(baVar)) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("dataLength", ciVar.bS());
                        } catch (Throwable e) {
                            C4462b.m14831a(e, "");
                        }
                        this.fK.fh = this.fK.m15405m("transferDataUsingSystemCallback");
                        this.fK.fh.jU = new C4507b(this.fK.eZ, jSONObject);
                        this.fK.fj.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.fk.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.fl.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.eU.m14761c(baVar, ciVar);
                        return;
                    }
                }
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", baVar.aR().toString());
                    jSONObject.put("dataLength", ciVar.bS());
                } catch (Throwable e2) {
                    C4462b.m14831a(e2, "");
                }
                this.fK.m15359a("onSyncPhaseTransferData", jSONObject);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4920c(com.misfit.ble.obfuscated.ba r7) {
            /*
            r6 = this;
            r0 = r6.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            if (r7 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fu;	 Catch:{ all -> 0x003f }
            r0 = r0.containsValue(r7);	 Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0042;
        L_0x0017:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x003f }
            r2.<init>();	 Catch:{ all -> 0x003f }
            r0 = "action";
            r3 = r7.aR();	 Catch:{ JSONException -> 0x0038 }
            r3 = r3.toString();	 Catch:{ JSONException -> 0x0038 }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x0038 }
        L_0x0029:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r3 = "onSyncPhaseStopTransferData";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x003f }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x003f }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
        L_0x0037:
            return;
        L_0x0038:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x003f }
            goto L_0x0029;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.eU;	 Catch:{ all -> 0x003f }
            r2 = r7.aR();	 Catch:{ all -> 0x003f }
            r0.m14757b(r2);	 Catch:{ all -> 0x003f }
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fh;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x009d;
        L_0x0057:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x003f }
            r2.<init>();	 Catch:{ all -> 0x003f }
            r0 = "transferredSize";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x009f }
            r3 = r3.fj;	 Catch:{ JSONException -> 0x009f }
            r4 = r7.aR();	 Catch:{ JSONException -> 0x009f }
            r3 = r3.remove(r4);	 Catch:{ JSONException -> 0x009f }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x009f }
            r0 = "status";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x009f }
            r3 = r3.fl;	 Catch:{ JSONException -> 0x009f }
            r4 = r7.aR();	 Catch:{ JSONException -> 0x009f }
            r3 = r3.remove(r4);	 Catch:{ JSONException -> 0x009f }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x009f }
        L_0x0082:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fh;	 Catch:{ all -> 0x003f }
            r3 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x003f }
            r4 = r6.fK;	 Catch:{ all -> 0x003f }
            r4 = r4.fk;	 Catch:{ all -> 0x003f }
            r5 = r7.aR();	 Catch:{ all -> 0x003f }
            r4 = r4.remove(r5);	 Catch:{ all -> 0x003f }
            r3.<init>(r4, r2);	 Catch:{ all -> 0x003f }
            r0.jV = r3;	 Catch:{ all -> 0x003f }
        L_0x009d:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            goto L_0x0037;
        L_0x009f:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x003f }
            goto L_0x0082;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.4.c(com.misfit.ble.obfuscated.ba):void");
        }

        public void mo4919b(ba baVar, ci ciVar) {
            synchronized (this.fK.eU.gi) {
                JSONObject jSONObject;
                if (baVar != null) {
                    if (this.fK.fu.containsValue(baVar)) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("dataLength", ciVar.bS());
                        } catch (Throwable e) {
                            C4462b.m14831a(e, "");
                        }
                        this.fK.fh = this.fK.m15405m("transferDataUsingTimer");
                        this.fK.fh.jU = new C4507b(this.fK.eZ, jSONObject);
                        this.fK.fj.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.fk.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.fl.put(baVar.aR(), Integer.valueOf(0));
                        this.fK.eU.m14763d(baVar, ciVar);
                        return;
                    }
                }
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", baVar.aR().toString());
                    jSONObject.put("dataLength", ciVar.bS());
                } catch (Throwable e2) {
                    C4462b.m14831a(e2, "");
                }
                this.fK.m15359a("onSyncPhaseTransferData", jSONObject);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4921d(com.misfit.ble.obfuscated.ba r7) {
            /*
            r6 = this;
            r0 = r6.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            if (r7 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fu;	 Catch:{ all -> 0x003f }
            r0 = r0.containsValue(r7);	 Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0042;
        L_0x0017:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x003f }
            r2.<init>();	 Catch:{ all -> 0x003f }
            r0 = "action";
            r3 = r7.aR();	 Catch:{ JSONException -> 0x0038 }
            r3 = r3.toString();	 Catch:{ JSONException -> 0x0038 }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x0038 }
        L_0x0029:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r3 = "onSyncPhaseStopTransferData";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x003f }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x003f }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
        L_0x0037:
            return;
        L_0x0038:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x003f }
            goto L_0x0029;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.eU;	 Catch:{ all -> 0x003f }
            r2 = r7.aR();	 Catch:{ all -> 0x003f }
            r0.m14762c(r2);	 Catch:{ all -> 0x003f }
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fh;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x009d;
        L_0x0057:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x003f }
            r2.<init>();	 Catch:{ all -> 0x003f }
            r0 = "transferredSize";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x009f }
            r3 = r3.fj;	 Catch:{ JSONException -> 0x009f }
            r4 = r7.aR();	 Catch:{ JSONException -> 0x009f }
            r3 = r3.remove(r4);	 Catch:{ JSONException -> 0x009f }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x009f }
            r0 = "status";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x009f }
            r3 = r3.fl;	 Catch:{ JSONException -> 0x009f }
            r4 = r7.aR();	 Catch:{ JSONException -> 0x009f }
            r3 = r3.remove(r4);	 Catch:{ JSONException -> 0x009f }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x009f }
        L_0x0082:
            r0 = r6.fK;	 Catch:{ all -> 0x003f }
            r0 = r0.fh;	 Catch:{ all -> 0x003f }
            r3 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x003f }
            r4 = r6.fK;	 Catch:{ all -> 0x003f }
            r4 = r4.fk;	 Catch:{ all -> 0x003f }
            r5 = r7.aR();	 Catch:{ all -> 0x003f }
            r4 = r4.remove(r5);	 Catch:{ all -> 0x003f }
            r3.<init>(r4, r2);	 Catch:{ all -> 0x003f }
            r0.jV = r3;	 Catch:{ all -> 0x003f }
        L_0x009d:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            goto L_0x0037;
        L_0x009f:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x003f }
            goto L_0x0082;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.4.d(com.misfit.ble.obfuscated.ba):void");
        }

        public void m15307a(final ba baVar, final ew ewVar, final int i) {
            if (baVar != null && !baVar.hasFinished()) {
                Object a = this.fK.eU.m14752a(ewVar);
                if (C4452c.SUCCEEDED == a) {
                    this.fK.m15339a(ewVar, 0, (ap) a);
                } else if (i <= 0 || C4452c.FAILED == a) {
                    ewVar.cancel();
                    this.fK.m15339a(ewVar, 1, (ap) a);
                    baVar.m14788c(ewVar, 1, a);
                } else if (C4452c.CHARACTERISTIC_WRITING_FAILED == a) {
                    LogUtils.m15476d(ShineProfile.TAG, "sendRequestImpl - request: " + ewVar.getRequestName() + ", retry left: " + i);
                    this.fK.mHandler.postDelayed(new Runnable(this) {
                        final /* synthetic */ C46214 fR;

                        public void run() {
                            this.fR.m15307a(baVar, ewVar, i - 1);
                        }
                    }, 250);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4922e(com.misfit.ble.obfuscated.ba r7) {
            /*
            r6 = this;
            r0 = r6.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            if (r7 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r0 = r0.containsValue(r7);	 Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x0055;
        L_0x0017:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0052 }
            r2.<init>();	 Catch:{ all -> 0x0052 }
            r0 = "expectedPhase";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x004b }
            r3 = r3.getCurrentActions();	 Catch:{ JSONException -> 0x004b }
            r3 = r3.toArray();	 Catch:{ JSONException -> 0x004b }
            r3 = java.util.Arrays.toString(r3);	 Catch:{ JSONException -> 0x004b }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x004b }
            r0 = "actualPhase";
            r3 = r7.getClass();	 Catch:{ JSONException -> 0x004b }
            r3 = r3.getName();	 Catch:{ JSONException -> 0x004b }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x004b }
        L_0x003c:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r3 = "onSyncPhaseCompleted";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0052 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0052 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0052 }
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        L_0x004a:
            return;
        L_0x004b:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0052 }
            goto L_0x003c;
        L_0x0052:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
            throw r0;
        L_0x0055:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.ff;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0 = r0.get(r2);	 Catch:{ all -> 0x0052 }
            r0 = (com.misfit.ble.obfuscated.bz) r0;	 Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0087;
        L_0x0067:
            r2 = new com.misfit.ble.obfuscated.bz$c;	 Catch:{ all -> 0x0052 }
            r3 = r7.getResultCode();	 Catch:{ all -> 0x0052 }
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0052 }
            r4 = r7.aV();	 Catch:{ all -> 0x0052 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0052 }
            r0.jX = r2;	 Catch:{ all -> 0x0052 }
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.ff;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0.remove(r2);	 Catch:{ all -> 0x0052 }
        L_0x0087:
            r0 = r7 instanceof com.misfit.ble.obfuscated.az;	 Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0092;
        L_0x008b:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r2 = com.misfit.ble.shine.ShineProfile.State.READY;	 Catch:{ all -> 0x0052 }
            r0.eZ = r2;	 Catch:{ all -> 0x0052 }
        L_0x0092:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x00ab;
        L_0x009e:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0.remove(r2);	 Catch:{ all -> 0x0052 }
        L_0x00ab:
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
            goto L_0x004a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.4.e(com.misfit.ble.obfuscated.ba):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4923f(com.misfit.ble.obfuscated.ba r7) {
            /*
            r6 = this;
            r0 = r6.fK;
            r0 = r0.eU;
            r1 = r0.gi;
            monitor-enter(r1);
            if (r7 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r0 = r0.containsValue(r7);	 Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x0055;
        L_0x0017:
            r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0052 }
            r2.<init>();	 Catch:{ all -> 0x0052 }
            r0 = "expectedPhase";
            r3 = r6.fK;	 Catch:{ JSONException -> 0x004b }
            r3 = r3.getCurrentActions();	 Catch:{ JSONException -> 0x004b }
            r3 = r3.toArray();	 Catch:{ JSONException -> 0x004b }
            r3 = java.util.Arrays.toString(r3);	 Catch:{ JSONException -> 0x004b }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x004b }
            r0 = "actualPhase";
            r3 = r7.getClass();	 Catch:{ JSONException -> 0x004b }
            r3 = r3.getName();	 Catch:{ JSONException -> 0x004b }
            r2.put(r0, r3);	 Catch:{ JSONException -> 0x004b }
        L_0x003c:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r3 = "onSyncPhaseFailed";
            r4 = 1;
            r4 = new org.json.JSONObject[r4];	 Catch:{ all -> 0x0052 }
            r5 = 0;
            r4[r5] = r2;	 Catch:{ all -> 0x0052 }
            r0.m15359a(r3, r4);	 Catch:{ all -> 0x0052 }
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        L_0x004a:
            return;
        L_0x004b:
            r0 = move-exception;
            r3 = "";
            com.misfit.ble.obfuscated.C4462b.m14831a(r0, r3);	 Catch:{ all -> 0x0052 }
            goto L_0x003c;
        L_0x0052:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
            throw r0;
        L_0x0055:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.ff;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0 = r0.get(r2);	 Catch:{ all -> 0x0052 }
            r0 = (com.misfit.ble.obfuscated.bz) r0;	 Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0087;
        L_0x0067:
            r2 = new com.misfit.ble.obfuscated.bz$c;	 Catch:{ all -> 0x0052 }
            r3 = r7.getResultCode();	 Catch:{ all -> 0x0052 }
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0052 }
            r4 = r7.aV();	 Catch:{ all -> 0x0052 }
            r2.<init>(r3, r4);	 Catch:{ all -> 0x0052 }
            r0.jX = r2;	 Catch:{ all -> 0x0052 }
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.ff;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0.remove(r2);	 Catch:{ all -> 0x0052 }
        L_0x0087:
            r0 = r7 instanceof com.misfit.ble.obfuscated.az;	 Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x00ad;
        L_0x008b:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r2 = com.misfit.ble.shine.ShineProfile.State.READY;	 Catch:{ all -> 0x0052 }
            r0.eZ = r2;	 Catch:{ all -> 0x0052 }
        L_0x0092:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x00ab;
        L_0x009e:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r0 = r0.fu;	 Catch:{ all -> 0x0052 }
            r2 = r7.aR();	 Catch:{ all -> 0x0052 }
            r0.remove(r2);	 Catch:{ all -> 0x0052 }
        L_0x00ab:
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
            goto L_0x004a;
        L_0x00ad:
            r0 = r7 instanceof com.misfit.ble.obfuscated.bo;	 Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0092;
        L_0x00b1:
            r0 = r6.fK;	 Catch:{ all -> 0x0052 }
            r2 = "syncFailed";
            r0.addDataCollectionTag(r2);	 Catch:{ all -> 0x0052 }
            goto L_0x0092;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.4.f(com.misfit.ble.obfuscated.ba):void");
        }

        public void mo4924g(ba baVar) {
            synchronized (this.fK.eU.gi) {
                this.fK.fy = true;
            }
        }

        public void mo4925h(ba baVar) {
            synchronized (this.fK.eU.gi) {
                this.fK.m15403l(((au) baVar).getSerialNumber());
            }
        }

        public void mo4916a(ba baVar, long j) {
            synchronized (this.fK.eU.gi) {
                this.fK.m15385d(j);
            }
        }
    }

    class C46225 implements C4497a {
        final /* synthetic */ ShineProfile fK;

        C46225(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void onStreamingStarted(ActionResult actionResult) {
            if (this.fK.eY != null) {
                this.fK.eY.onStreamingStarted(actionResult);
            }
        }

        public void onStreamingStopped(ActionResult actionResult) {
            if (this.fK.eY != null) {
                this.fK.eY.onStreamingStopped(actionResult);
            }
        }

        public void mo4926b(short s, byte[] bArr) {
            this.fK.m15361a(s, bArr);
        }
    }

    class C46236 implements C4498a {
        final /* synthetic */ ShineProfile fK;

        C46236(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void mo4929a(bo boVar, byte[] bArr, Bundle bundle, MutableBoolean mutableBoolean, SyncCallback syncCallback) {
            if (boVar == null || !this.fK.fu.containsValue(boVar)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("expectedPhase", ShineActionID.SYNC.toString());
                    jSONObject.put("actualPhase", boVar.aR().toString());
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                this.fK.m15359a("onSyncPhaseProgressChanged", jSONObject);
                mutableBoolean.setValue(true);
                return;
            }
            syncCallback.onSyncDataRead(bArr, bundle, mutableBoolean);
        }
    }

    class C46247 implements ConfigurationCallback {
        final /* synthetic */ ShineProfile fK;

        C46247(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable) {
        }
    }

    class C46258 implements ConfigurationCallback {
        final /* synthetic */ ShineProfile fK;

        C46258(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable) {
            this.fK.as();
        }
    }

    class C46269 implements ConfigurationCallback {
        final /* synthetic */ ShineProfile fK;

        C46269(ShineProfile shineProfile) {
            this.fK = shineProfile;
        }

        public void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable) {
            this.fK.au();
        }
    }

    public static class ActionResult {
        private ResultCode fS;
        private ShineError fT;

        public ActionResult(ResultCode resultCode, ShineError shineError) {
            this.fS = resultCode;
            this.fT = shineError;
        }

        public ResultCode getResultCode() {
            return this.fS;
        }

        public ShineError getError() {
            return this.fT;
        }
    }

    public static class ConnectActionResult {
        private ShineError fT;
        private ConnectionResult fU;
        private int fV;

        public ConnectActionResult(int i, ConnectionResult connectionResult, ShineError shineError) {
            this.fV = i;
            this.fU = connectionResult;
            this.fT = shineError;
        }

        public ConnectionResult getResultCode() {
            return this.fU;
        }

        public int getStatus() {
            return this.fV;
        }

        public ShineError getError() {
            return this.fT;
        }
    }

    public interface ConnectionCallback {
        void onConnectionStateChanged(ShineProfile shineProfile, State state, ConnectActionResult connectActionResult);
    }

    public enum ConnectionResult {
        SUCCEEDED,
        FAILED,
        TIMED_OUT,
        UNEXPECTED
    }

    public interface CustomRequestResponseCallback {
        void onResponseReceived(ActionID actionID, ActionResult actionResult, CustomRequest customRequest);
    }

    public interface DataTransferCallback {
        void onDataTransferCompleted(ActionID actionID, ActionResult actionResult);

        void onDataTransferProgressChanged(ActionID actionID, float f);
    }

    public interface PreparationCallback {
        void onPreparationCompleted(ShineProfile shineProfile, PrepareActionResult prepareActionResult);
    }

    public enum PreparationResult {
        SUCCEEDED,
        FAILED,
        TIMED_OUT,
        CONNECTION_DROPPED,
        READ_SERIAL_NUMBER_FAILED,
        READ_MODEL_NUMBER_FAILED,
        READ_FW_VERSION_FAILED,
        READ_UAPP_SYSTEM_VERSION_FAILED,
        UNKNOWN_FIRMWARE
    }

    public static class PrepareActionResult {
        private ShineError fT;
        private PreparationResult fZ;

        public PrepareActionResult(PreparationResult preparationResult, ShineError shineError) {
            this.fZ = preparationResult;
            this.fT = shineError;
        }

        public PreparationResult getResultCode() {
            return this.fZ;
        }

        public ShineError getError() {
            return this.fT;
        }
    }

    public enum ResultCode {
        SUCCEEDED,
        FAILED,
        TIMED_OUT,
        INTERNAL_ERROR,
        INTERRUPTED,
        UNSUPPORTED,
        CONNECTION_DROPPED
    }

    public interface RetrieveHardwareLogCallback {
        void onRetrievingHardwareLogCompleted(ActionResult actionResult, byte[] bArr);
    }

    public enum State {
        IDLE(0),
        CONNECTING(1),
        CONNECTED(2),
        PREPARING(3),
        READY(4),
        OTA(5),
        DISCONNECTING(6),
        CLOSED(7);
        
        int ga;

        private State(int i) {
            this.ga = i;
        }
    }

    public interface StreamingCallback {
        public static final String EXTRA_BUTTON_EVENT_ID = "extra_button_event_id";
        public static final String EXTRA_HEARTBEAT_DAILY_POINTS = "extra_heartbeat_daily_points";
        public static final String EXTRA_HEARTBEAT_DAILY_STEPS = "extra_heartbeat_daily_steps";
        public static final String EXTRA_UAPP_NOTIFICATION = "extra_uapp_notification";

        public enum StreamingEventType {
            BUTTON_EVENT,
            HEARTBEAT,
            UAPP_NOTIFICATION
        }

        void onStreamingEvent(StreamingEventType streamingEventType, Bundle bundle);

        void onStreamingEventData(byte[] bArr);

        void onStreamingStarted(ActionResult actionResult);

        void onStreamingStopped(ActionResult actionResult);
    }

    public interface SyncCallback {
        void onSyncCompleted(ActionResult actionResult);

        void onSyncDataRead(byte[] bArr, Bundle bundle, MutableBoolean mutableBoolean);
    }

    class C4627a implements Runnable {
        final /* synthetic */ ShineProfile fK;
        private boolean fW;

        public C4627a(ShineProfile shineProfile) {
            this.fK = shineProfile;
            this.fW = false;
            this.fW = false;
        }

        public void run() {
            synchronized (this.fK.eU.gi) {
                if (!this.fW) {
                    this.fK.m15356a((Runnable) this);
                }
            }
        }
    }

    class C4628b implements Runnable {
        final /* synthetic */ ShineProfile fK;
        private boolean fW;

        public C4628b(ShineProfile shineProfile) {
            this.fK = shineProfile;
            this.fW = false;
            this.fW = false;
        }

        public void run() {
            synchronized (this.fK.eU.gi) {
                if (!this.fW) {
                    this.fK.m15382c((Runnable) this);
                }
            }
        }
    }

    class C4629c implements Runnable {
        final /* synthetic */ ShineProfile fK;
        private boolean fY;

        private C4629c(ShineProfile shineProfile) {
            this.fK = shineProfile;
            this.fY = false;
        }

        public void run() {
            synchronized (this.fK.eU.gi) {
                if (!this.fY) {
                    this.fK.m15357a("internalDisconnect", new ConnectActionResult(1, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, this.fK.ft, Reason.TIMED_OUT)));
                }
            }
        }
    }

    class C4630d implements Runnable {
        final /* synthetic */ ShineProfile fK;
        private boolean fW;

        public C4630d(ShineProfile shineProfile) {
            this.fK = shineProfile;
            this.fW = false;
            this.fW = false;
        }

        public void run() {
            synchronized (this.fK.eU.gi) {
                if (!this.fW) {
                    this.fK.m15343a(this);
                }
            }
        }
    }

    class C4631e implements Runnable {
        final /* synthetic */ ShineProfile fK;
        private boolean fW;

        public C4631e(ShineProfile shineProfile) {
            this.fK = shineProfile;
            this.fW = false;
            this.fW = false;
        }

        public void run() {
            synchronized (this.fK.eU.gi) {
                if (!this.fW) {
                    this.fK.m15373b((Runnable) this);
                }
            }
        }
    }

    ShineProfile(Context context, ShineDevice shineDevice) {
        C4592s.m15224c(context);
        this.fd = new cb(shineDevice.getSerialNumber());
        this.fv = shineDevice;
        this.eU = new ao(context, shineDevice);
        this.eU.m14753a(this.fd);
        m15342a(State.IDLE);
        ao();
        this.fu = new Hashtable();
        this.fp = new bb(this.fG);
        this.fo = new bm(this.fG);
        this.fq = new ax(this.fG);
        this.fr = new bc(this.fG);
        this.fs = new be(this.fG);
        this.ff = new Hashtable();
        this.fg = new Hashtable();
        this.fk = new Hashtable();
        this.fl = new Hashtable();
        this.fj = new Hashtable();
        if (this.mHandler == null) {
            this.mHandler = hd.m15181do();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        shineDevice.addDataCollectionTag(C4592s.m15223B());
        this.ft = Event.DISCOVER_SERVICES;
        this.fx = new ConnectActionResult(0, ConnectionResult.SUCCEEDED, null);
        this.fy = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m15421a(com.misfit.ble.shine.ShineDevice r10, boolean r11, long r12, com.misfit.ble.shine.ShineProfile.ConnectionCallback r14) {
        /*
        r9 = this;
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2 = 1;
        r0 = 0;
        r1 = r9.eU;
        r3 = r1.gi;
        monitor-enter(r3);
        r1 = r9.eZ;	 Catch:{ all -> 0x009b }
        r4 = com.misfit.ble.shine.ShineProfile.State.IDLE;	 Catch:{ all -> 0x009b }
        if (r1 == r4) goto L_0x0019;
    L_0x000f:
        r1 = "connect";
        r2 = 0;
        r2 = new org.json.JSONObject[r2];	 Catch:{ all -> 0x009b }
        r9.m15359a(r1, r2);	 Catch:{ all -> 0x009b }
        monitor-exit(r3);	 Catch:{ all -> 0x009b }
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = r9.fd;	 Catch:{ all -> 0x009b }
        r1.start();	 Catch:{ all -> 0x009b }
        r1 = r9.ff;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r9.fg;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = "connect";
        r1 = r9.m15405m(r1);	 Catch:{ all -> 0x009b }
        r9.fe = r1;	 Catch:{ all -> 0x009b }
        r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0035;
    L_0x0034:
        r12 = r12 - r6;
    L_0x0035:
        r4 = new org.json.JSONObject;	 Catch:{ all -> 0x009b }
        r4.<init>();	 Catch:{ all -> 0x009b }
        r1 = "autoConnect";
        r4.put(r1, r11);	 Catch:{ JSONException -> 0x0094 }
        r1 = "timeout";
        r4.put(r1, r12);	 Catch:{ JSONException -> 0x0094 }
        r1 = "callback";
        r5 = com.misfit.ble.obfuscated.hb.m15161a(r14);	 Catch:{ JSONException -> 0x0094 }
        r4.put(r1, r5);	 Catch:{ JSONException -> 0x0094 }
        r1 = "macAddress";
        r5 = r10.getAddress();	 Catch:{ JSONException -> 0x0094 }
        r4.put(r1, r5);	 Catch:{ JSONException -> 0x0094 }
    L_0x0056:
        r1 = r9.fe;	 Catch:{ all -> 0x009b }
        r5 = new com.misfit.ble.obfuscated.bz$b;	 Catch:{ all -> 0x009b }
        r6 = r9.eZ;	 Catch:{ all -> 0x009b }
        r5.<init>(r6, r4);	 Catch:{ all -> 0x009b }
        r1.jU = r5;	 Catch:{ all -> 0x009b }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x009b }
        r9.fw = r4;	 Catch:{ all -> 0x009b }
        r1 = r9.eU;	 Catch:{ all -> 0x009b }
        r4 = r9.fF;	 Catch:{ all -> 0x009b }
        r1 = r1.m14756a(r11, r4);	 Catch:{ all -> 0x009b }
        r4 = r9.fe;	 Catch:{ all -> 0x009b }
        r5 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x009e;
    L_0x0075:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x009b }
        r5.<init>(r0);	 Catch:{ all -> 0x009b }
        r4.jV = r5;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x0091;
    L_0x0080:
        r0 = com.misfit.ble.shine.ShineProfile.State.CONNECTING;	 Catch:{ all -> 0x009b }
        r9.m15342a(r0);	 Catch:{ all -> 0x009b }
        r0 = 10;
        r9.fn = r0;	 Catch:{ all -> 0x009b }
        r0 = 1;
        r9.fm = r0;	 Catch:{ all -> 0x009b }
        r9.eV = r14;	 Catch:{ all -> 0x009b }
        r9.m15338a(r12);	 Catch:{ all -> 0x009b }
    L_0x0091:
        monitor-exit(r3);	 Catch:{ all -> 0x009b }
        r0 = r1;
        goto L_0x0018;
    L_0x0094:
        r1 = move-exception;
        r5 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r5);	 Catch:{ all -> 0x009b }
        goto L_0x0056;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r0 = r2;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.a(com.misfit.ble.shine.ShineDevice, boolean, long, com.misfit.ble.shine.ShineProfile$ConnectionCallback):boolean");
    }

    void m15420a(ConnectionCallback connectionCallback, long j) {
        synchronized (this.eU.gi) {
            this.eV = connectionCallback;
            if (this.eZ != State.CONNECTING) {
                m15358a("getExistShineProfile", "connect", new JSONObject[0]);
                return;
            }
            this.fe = m15405m("connect");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timeout", j);
                jSONObject.put(Constants.CALLBACK, hb.m15161a(connectionCallback));
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            this.fe.jU = new C4507b(this.eZ, jSONObject);
            this.fe.jV = new C4506a(Integer.valueOf(0));
            m15338a(j);
        }
    }

    void m15419a(ConnectionCallback connectionCallback) {
        synchronized (this.eU.gi) {
            this.eV = connectionCallback;
            this.fe = m15405m("overwriteConnectionCallback");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.CALLBACK, hb.m15161a(connectionCallback));
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            this.fe.jU = new C4507b(this.eZ, jSONObject);
            this.fe.jV = new C4506a(Integer.valueOf(0));
        }
    }

    private boolean m15389e(int i) {
        synchronized (this.eU.gi) {
            this.fm++;
            if (this.fm < 3 || this.fe == null) {
                this.fe = m15405m("connectInternalRetry");
                this.fe.jU = new C4507b(this.eZ, null);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("numberOfConnectionAttempt", this.fm);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            boolean connect = this.eU.connect();
            this.fe.jV = new C4506a(Integer.valueOf(connect ? 0 : 1), jSONObject);
            if (!connect) {
                m15357a("internalDisconnect", new ConnectActionResult(i, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, this.ft, Reason.SENDING_REQUEST_FAILED)));
            }
        }
        return true;
    }

    private void m15356a(Runnable runnable) {
        if (runnable == this.fz) {
            this.fz = null;
            ConnectActionResult connectActionResult = new ConnectActionResult(2, ConnectionResult.TIMED_OUT, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, Event.ESTABLISH_CONNECTION, Reason.TIMED_OUT));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", connectActionResult.getError().toJSON());
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            this.fe.jX = new C4508c(Integer.valueOf(2), jSONObject);
            addDataCollectionTag("connectTimeout");
            m15374b("internalClose", connectActionResult);
        }
    }

    private void m15338a(long j) {
        m15330Y();
        if (j > 0) {
            this.fz = new C4627a(this);
            this.mHandler.postDelayed(this.fz, j);
        }
    }

    private void m15330Y() {
        if (this.fz != null) {
            this.fz.fW = true;
            this.mHandler.removeCallbacks(this.fz);
        }
    }

    private void m15331Z() {
        ac();
        if (!this.eU.aD()) {
            m15357a("internalDisconnect", new ConnectActionResult(1, ConnectionResult.FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.CONNECT, this.ft, Reason.SENDING_REQUEST_FAILED)));
        }
    }

    public boolean refreshDeviceCache() {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (al()) {
                z = this.eU.m14759b(this.eZ);
            } else {
                m15359a("refreshDeviceCache", new JSONObject[0]);
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean prepare(com.misfit.ble.shine.ShineProfile.PreparationCallback r10) {
        /*
        r9 = this;
        r0 = 0;
        r1 = 1;
        r2 = r9.eU;
        r2 = r2.gi;
        monitor-enter(r2);
        r3 = com.misfit.ble.shine.ShineProfile.State.CONNECTED;	 Catch:{ all -> 0x007f }
        r4 = r9.eZ;	 Catch:{ all -> 0x007f }
        if (r3 == r4) goto L_0x0017;
    L_0x000d:
        r1 = "prepare";
        r3 = 0;
        r3 = new org.json.JSONObject[r3];	 Catch:{ all -> 0x007f }
        r9.m15359a(r1, r3);	 Catch:{ all -> 0x007f }
        monitor-exit(r2);	 Catch:{ all -> 0x007f }
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = "prepare";
        r0 = r9.m15405m(r0);	 Catch:{ all -> 0x007f }
        r9.fi = r0;	 Catch:{ all -> 0x007f }
        r0 = r9.fi;	 Catch:{ all -> 0x007f }
        r3 = new com.misfit.ble.obfuscated.bz$b;	 Catch:{ all -> 0x007f }
        r4 = r9.eZ;	 Catch:{ all -> 0x007f }
        r5 = 0;
        r3.<init>(r4, r5);	 Catch:{ all -> 0x007f }
        r0.jU = r3;	 Catch:{ all -> 0x007f }
        r9.eW = r10;	 Catch:{ all -> 0x007f }
        r0 = 1;
        r9.fA = r0;	 Catch:{ all -> 0x007f }
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r9.m15370b(r4);	 Catch:{ all -> 0x007f }
        r0 = "readSerialNumber";
        r0 = r9.m15405m(r0);	 Catch:{ all -> 0x007f }
        r9.fe = r0;	 Catch:{ all -> 0x007f }
        r0 = r9.fe;	 Catch:{ all -> 0x007f }
        r3 = new com.misfit.ble.obfuscated.bz$b;	 Catch:{ all -> 0x007f }
        r4 = r9.eZ;	 Catch:{ all -> 0x007f }
        r5 = 0;
        r3.<init>(r4, r5);	 Catch:{ all -> 0x007f }
        r0.jU = r3;	 Catch:{ all -> 0x007f }
        r0 = r9.eU;	 Catch:{ all -> 0x007f }
        r0 = r0.aA();	 Catch:{ all -> 0x007f }
        if (r0 != 0) goto L_0x0079;
    L_0x0051:
        r0 = r9.fe;	 Catch:{ all -> 0x007f }
        r3 = new com.misfit.ble.obfuscated.bz$a;	 Catch:{ all -> 0x007f }
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x007f }
        r3.<init>(r4);	 Catch:{ all -> 0x007f }
        r0.jV = r3;	 Catch:{ all -> 0x007f }
        r0 = new com.misfit.ble.shine.ShineProfile$PrepareActionResult;	 Catch:{ all -> 0x007f }
        r3 = com.misfit.ble.shine.ShineProfile.PreparationResult.READ_SERIAL_NUMBER_FAILED;	 Catch:{ all -> 0x007f }
        r4 = new com.misfit.ble.shine.error.ShineError;	 Catch:{ all -> 0x007f }
        r5 = com.misfit.ble.shine.error.ShineError.Domain.SHINE_PROFILE_ERROR;	 Catch:{ all -> 0x007f }
        r6 = com.misfit.ble.shine.ShineActionID.PREPARE;	 Catch:{ all -> 0x007f }
        r7 = r9.ft;	 Catch:{ all -> 0x007f }
        r8 = com.misfit.ble.shine.error.ShineError.Reason.SENDING_REQUEST_FAILED;	 Catch:{ all -> 0x007f }
        r4.<init>(r5, r6, r7, r8);	 Catch:{ all -> 0x007f }
        r0.<init>(r3, r4);	 Catch:{ all -> 0x007f }
        r9.m15341a(r0);	 Catch:{ all -> 0x007f }
    L_0x0076:
        monitor-exit(r2);	 Catch:{ all -> 0x007f }
        r0 = r1;
        goto L_0x0016;
    L_0x0079:
        r0 = com.misfit.ble.shine.ShineProfile.State.PREPARING;	 Catch:{ all -> 0x007f }
        r9.m15342a(r0);	 Catch:{ all -> 0x007f }
        goto L_0x0076;
    L_0x007f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x007f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.prepare(com.misfit.ble.shine.ShineProfile$PreparationCallback):boolean");
    }

    private void aa() {
        if (this.eZ == State.PREPARING) {
            m15341a(new PrepareActionResult(PreparationResult.SUCCEEDED, null));
        }
    }

    private void m15341a(PrepareActionResult prepareActionResult) {
        synchronized (this.eU.gi) {
            if (this.fA) {
                this.fA = false;
                ab();
                ShineError error = prepareActionResult.getError();
                int i = error == null ? 0 : 1;
                JSONObject jSONObject = new JSONObject();
                if (error != null) {
                    try {
                        jSONObject.put("error", error.toJSON());
                    } catch (Throwable e) {
                        C4462b.m14831a(e, "");
                    }
                }
                this.fi.jX = new C4508c(Integer.valueOf(i), jSONObject);
                PreparationResult resultCode = prepareActionResult.getResultCode();
                if (resultCode == PreparationResult.SUCCEEDED) {
                    m15342a(State.READY);
                } else if (resultCode != PreparationResult.CONNECTION_DROPPED) {
                    addDataCollectionTag("prepareFailed");
                    m15342a(State.CONNECTED);
                }
                this.eW.onPreparationCompleted(this, prepareActionResult);
            }
        }
    }

    private void m15373b(Runnable runnable) {
        if (runnable == this.fB) {
            this.fB = null;
            m15341a(new PrepareActionResult(PreparationResult.TIMED_OUT, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.PREPARE, this.ft, Reason.TIMED_OUT)));
        }
    }

    private void m15370b(long j) {
        ab();
        this.fB = new C4631e(this);
        this.mHandler.postDelayed(this.fB, j);
    }

    private void ab() {
        if (this.fB != null) {
            this.fB.fW = true;
            this.mHandler.removeCallbacks(this.fB);
        }
    }

    private void ac() {
        ad();
        this.fC = new C4629c();
        this.mHandler.postDelayed(this.fC, 10000);
    }

    private void ad() {
        if (this.fC != null) {
            this.fC.fY = true;
            this.mHandler.removeCallbacks(this.fC);
        }
    }

    public boolean getDeviceConfiguration(ConfigurationCallback configurationCallback, List<String> list) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_CONFIGURATION)) {
                z = m15362a(this.fo.m14942a(getFirmware(), configurationCallback, (List) list));
            } else {
                m15359a("phaseGetDeviceConfiguration", an());
            }
        }
        return z;
    }

    public boolean setDeviceConfiguration(ConfigurationSession configurationSession, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_CONFIGURATION)) {
                z = m15362a(this.fo.m14943a(getFirmware(), configurationSession, configurationCallback));
            } else {
                m15359a("phaseSetDeviceConfiguration", an());
            }
        }
        return z;
    }

    public boolean sync(SyncCallback syncCallback, Bundle bundle) {
        boolean a;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SYNC)) {
                boolean z = false;
                if (bundle != null) {
                    if (bundle.containsKey(SYNC_RESUME_ENABLED_KEY)) {
                        z = bundle.getBoolean(SYNC_RESUME_ENABLED_KEY);
                    }
                }
                boolean z2 = false;
                if (bundle != null) {
                    if (bundle.containsKey(SKIP_READ_ACTIVITY_FILES)) {
                        z2 = bundle.getBoolean(SKIP_READ_ACTIVITY_FILES);
                    }
                }
                boolean z3 = false;
                if (bundle != null) {
                    if (bundle.containsKey(SKIP_ERASE_ACTIVITY_FILES)) {
                        z3 = bundle.getBoolean(SKIP_ERASE_ACTIVITY_FILES);
                    }
                }
                if (ar.m14773f(this, this.fa)) {
                    a = m15362a(new bq(this.fG, syncCallback, this.fI, z, z2, z3));
                } else if (z) {
                    m15359a("phaseSync", new JSONObject[0]);
                    a = false;
                } else {
                    a = m15362a(new bp(this.fG, syncCallback, this.fI, z2, z3));
                }
            } else {
                m15359a("phaseSync", an());
                a = false;
            }
        }
        return a;
    }

    public boolean retrieveHardwareLog(RetrieveHardwareLogCallback retrieveHardwareLogCallback, Bundle bundle) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.RETRIEVE_HARDWARE_LOG)) {
                boolean z2;
                if (bundle == null || !bundle.containsKey(SKIP_READ_HARDWARE_LOG)) {
                    z2 = false;
                } else {
                    z2 = bundle.getBoolean(SKIP_READ_HARDWARE_LOG);
                }
                if (bundle != null && bundle.containsKey(SKIP_ERASE_HARDWARE_LOG)) {
                    z = bundle.getBoolean(SKIP_ERASE_HARDWARE_LOG);
                }
                z = m15362a(new bd(this.fG, retrieveHardwareLogCallback, z2, z));
            } else {
                m15359a("phaseRetrieveHardwareLog", an());
            }
        }
        return z;
    }

    public boolean ota(Firmware firmware, DataTransferCallback dataTransferCallback, Bundle bundle) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.OTA)) {
                byte[] firmwareData = firmware.getFirmwareData();
                if (firmwareData == null) {
                    throw new IllegalArgumentException("Invalid firmware data");
                }
                boolean z2;
                if (bundle != null) {
                    if (bundle.containsKey(SKIP_RESUME_OTA)) {
                        z2 = bundle.getBoolean(SKIP_RESUME_OTA);
                        z = m15362a(new az(this.fG, dataTransferCallback, firmwareData, this, this.fa, z2));
                    }
                }
                z2 = false;
                z = m15362a(new az(this.fG, dataTransferCallback, firmwareData, this, this.fa, z2));
            } else {
                m15359a("phaseOTA", an());
            }
        }
        return z;
    }

    public boolean changeSerialNumber(String str, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.CHANGE_SERIAL_NUMBER)) {
                z = m15362a(new au(this.fG, configurationCallback, str, this.eU.getDevice().getSerialNumber()));
            } else {
                m15359a("phaseChangeSerialNumber", an());
            }
        }
        return z;
    }

    public boolean setConnectionParameters(ShineConnectionParameters shineConnectionParameters, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (!m15364a(ShineActionID.SET_CONNECTION_PARAMETERS)) {
                m15359a("phaseSetConnectionParameters", an());
            } else if (ar.aF()) {
                z = m15362a(new bi(this.fG, configurationCallback, shineConnectionParameters));
            } else {
                z = m15362a(new bh(this.fG, configurationCallback, shineConnectionParameters));
            }
        }
        return z;
    }

    public boolean getConnectionParameters(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_CONNECTION_PARAMETERS)) {
                z = m15362a(this.fo.m14951s(configurationCallback));
            } else {
                m15359a("phaseGetConnectionParameters", an());
            }
        }
        return z;
    }

    public boolean playAnimation(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.ANIMATE)) {
                z = m15362a(this.fo.m14947o(configurationCallback));
            } else {
                m15359a("phasePlayAnimation", an());
            }
        }
        return z;
    }

    public boolean stopPlayingAnimation(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.STOP_ANIMATING)) {
                z = m15362a(this.fo.m14948p(configurationCallback));
            } else {
                m15359a("phaseStopPlayingAnimation", an());
            }
        }
        return z;
    }

    public boolean playSyncAnimation(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SYNC_ANIMATE)) {
                z = m15362a(this.fo.m14949q(configurationCallback));
            } else {
                m15359a("phasePlaySyncAnimation", an());
            }
        }
        return z;
    }

    public boolean activate(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.ACTIVATE)) {
                z = m15362a(this.fo.m14946n(configurationCallback));
            } else {
                m15359a("phaseActivate", an());
            }
        }
        return z;
    }

    public boolean getActivationState(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_ACTIVATION_STATE)) {
                z = m15362a(this.fo.m14950r(configurationCallback));
            } else {
                m15359a("phaseGetActivationState", an());
            }
        }
        return z;
    }

    public boolean streamUserInputEvents(StreamingCallback streamingCallback) {
        if (this.fa != null) {
            return customStreamUserInputEvents(ar.m14771e(this, this.fa), streamingCallback);
        }
        m15359a("phaseStreamUserInputEvents", new JSONObject[0]);
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean customStreamUserInputEvents(short r7, com.misfit.ble.shine.ShineProfile.StreamingCallback r8) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = r6.eU;
        r2 = r2.gi;
        monitor-enter(r2);
        r3 = com.misfit.ble.shine.ShineActionID.STREAM_USER_INPUT_EVENTS;	 Catch:{ all -> 0x0055 }
        r3 = r6.m15364a(r3);	 Catch:{ all -> 0x0055 }
        if (r3 != 0) goto L_0x0020;
    L_0x000f:
        r1 = "phaseStreamUserInputEvents";
        r3 = 1;
        r3 = new org.json.JSONObject[r3];	 Catch:{ all -> 0x0055 }
        r4 = 0;
        r5 = r6.an();	 Catch:{ all -> 0x0055 }
        r3[r4] = r5;	 Catch:{ all -> 0x0055 }
        r6.m15359a(r1, r3);	 Catch:{ all -> 0x0055 }
        monitor-exit(r2);	 Catch:{ all -> 0x0055 }
    L_0x001f:
        return r0;
    L_0x0020:
        r4 = 0;
        r6.m15385d(r4);	 Catch:{ all -> 0x0055 }
        r6.eY = r8;	 Catch:{ all -> 0x0055 }
        r0 = 4;
        if (r7 != r0) goto L_0x0046;
    L_0x002a:
        r0 = com.misfit.ble.shine.ShineFeature.UAPP;	 Catch:{ all -> 0x0055 }
        r0 = r6.m15422a(r0);	 Catch:{ all -> 0x0055 }
        if (r0 == 0) goto L_0x0046;
    L_0x0032:
        r0 = r6.eY;	 Catch:{ all -> 0x0055 }
        if (r0 == 0) goto L_0x0043;
    L_0x0036:
        r0 = r6.eY;	 Catch:{ all -> 0x0055 }
        r3 = new com.misfit.ble.shine.ShineProfile$ActionResult;	 Catch:{ all -> 0x0055 }
        r4 = com.misfit.ble.shine.ShineProfile.ResultCode.SUCCEEDED;	 Catch:{ all -> 0x0055 }
        r5 = 0;
        r3.<init>(r4, r5);	 Catch:{ all -> 0x0055 }
        r0.onStreamingStarted(r3);	 Catch:{ all -> 0x0055 }
    L_0x0043:
        monitor-exit(r2);	 Catch:{ all -> 0x0055 }
        r0 = r1;
        goto L_0x001f;
    L_0x0046:
        r0 = new com.misfit.ble.obfuscated.bn;	 Catch:{ all -> 0x0055 }
        r1 = r6.fG;	 Catch:{ all -> 0x0055 }
        r3 = r6.fH;	 Catch:{ all -> 0x0055 }
        r0.<init>(r1, r3, r7);	 Catch:{ all -> 0x0055 }
        r0 = r6.m15362a(r0);	 Catch:{ all -> 0x0055 }
        monitor-exit(r2);	 Catch:{ all -> 0x0055 }
        goto L_0x001f;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0055 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.ShineProfile.customStreamUserInputEvents(short, com.misfit.ble.shine.ShineProfile$StreamingCallback):boolean");
    }

    public boolean getStreamingConfiguration(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_STREAMING_CONFIGURATION)) {
                z = m15362a(new ay(this.fG, configurationCallback));
            } else {
                m15359a("phaseGetStreamingConfiguration", an());
            }
        }
        return z;
    }

    public boolean setStreamingConfiguration(ShineStreamingConfiguration shineStreamingConfiguration, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_STREAMING_CONFIGURATION)) {
                z = m15362a(new bk(this.fG, configurationCallback, shineStreamingConfiguration));
            } else {
                m15359a("phaseSetStreamingConfiguration", an());
            }
        }
        return z;
    }

    public boolean playButtonEventAnimation(AnimNumber animNumber, short s, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_BUTTON_EVENT_ANIMATION)) {
                z = m15362a(this.fq.m14811a((short) animNumber.getId(), s, configurationCallback));
            } else {
                m15359a("phasePlayButtonEventAnimation", an());
            }
        }
        return z;
    }

    public boolean systemControlEventMapping(short s, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.EVENT_MAPPING_SYSTEM_CONTROL)) {
                z = m15362a(this.fq.m14807a((byte) (hb.m15166e(s) | -32), configurationCallback));
            } else {
                m15359a("phaseEventMappingSystemControl", an());
            }
        }
        return z;
    }

    public String getFirmwareVersion() {
        String str;
        synchronized (this.eU.gi) {
            if (this.eZ == State.READY || this.eZ == State.OTA || this.eZ == State.DISCONNECTING) {
                str = this.fa;
            } else {
                m15359a("getFirmwareVersion", new JSONObject[0]);
                str = null;
            }
        }
        return str;
    }

    public String getModelNumber() {
        String str;
        synchronized (this.eU.gi) {
            if (this.eZ == State.READY || this.eZ == State.OTA || this.eZ == State.DISCONNECTING) {
                str = this.fb;
            } else {
                m15359a("getModelNumber", new JSONObject[0]);
                str = null;
            }
        }
        return str;
    }

    public int getDeviceFamily() {
        int i = 0;
        synchronized (this.eU.gi) {
            if (this.eZ != State.READY && this.eZ != State.OTA && this.eZ != State.DISCONNECTING) {
                m15359a("getDeviceFamily", new JSONObject[0]);
            } else if (this.fb == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", this.eZ);
                    jSONObject.put("serialNumber", this.eU.getDevice().getSerialNumber());
                    jSONObject.put(Constants.BOLT_FIRMWARE_VERSION, this.fa);
                    jSONObject.put("modelNumber", this.fb);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                m15359a("getDeviceFamily", jSONObject);
            } else {
                i = ae();
            }
        }
        return i;
    }

    private int ae() {
        if (this.fb == null) {
            return 0;
        }
        if (this.fb.startsWith("SH") || this.fb.startsWith("misfit model num")) {
            return 1;
        }
        if (this.fb.startsWith("SV")) {
            return 4;
        }
        if (this.fb.startsWith("S2")) {
            return 5;
        }
        if (this.fb.startsWith(MFDeviceModel.RMM)) {
            return 6;
        }
        if (this.fb.startsWith(MFDeviceModel.RMM_FOSSIL)) {
            return 10;
        }
        if (this.fb.startsWith(DeviceIdentityUtils.SWAROVSKI_SERIAL_NUMBER_PREFIX)) {
            return 7;
        }
        if (this.fb.startsWith(DeviceIdentityUtils.RAY_SERIAL_NUMBER_PREFIX)) {
            return 8;
        }
        if (this.fb.startsWith("BF")) {
            return 9;
        }
        if (this.fb.startsWith("HW")) {
            return 11;
        }
        if (this.fb.startsWith("HL")) {
            return 12;
        }
        if (this.fb.startsWith("HM")) {
            return 13;
        }
        if (!this.fb.startsWith(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX)) {
            return 0;
        }
        ShineDevice ah = ah();
        String str = null;
        if (ah != null) {
            str = ah.getName();
        }
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("Shine") || str.equalsIgnoreCase("Zhine 2")) {
            return 2;
        }
        return 3;
    }

    public boolean readRssi(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (al()) {
                this.eX = configurationCallback;
                z = this.eU.readRemoteRssi();
            } else {
                m15359a("readRSSI", new JSONObject[0]);
            }
        }
        return z;
    }

    private void m15357a(String str, ConnectActionResult connectActionResult) {
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE || this.eZ == State.DISCONNECTING || this.eZ == State.CLOSED) {
                m15359a(str, new JSONObject[0]);
                return;
            }
            this.fe = m15405m(str);
            this.fe.jU = new C4507b(this.eZ, null);
            this.fx = connectActionResult;
            m15342a(State.DISCONNECTING);
            ai();
            this.eU.disconnect();
            this.fe.jV = new C4506a(Integer.valueOf(0));
            m15379c((long) LOG_UPLOADING_DELAY);
        }
    }

    private void m15382c(Runnable runnable) {
        if (runnable == this.fD) {
            this.fD = null;
            this.fe.jX = new C4508c(Integer.valueOf(2), null);
            addDataCollectionTag("disconnectTimeout");
            m15374b("forceClose", new ConnectActionResult(2, ConnectionResult.TIMED_OUT, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.DISCONNECT, Event.DISCONNECT, Reason.TIMED_OUT)));
        }
    }

    private void m15379c(long j) {
        af();
        if (j > 0) {
            this.fD = new C4628b(this);
            this.mHandler.postDelayed(this.fD, j);
        }
    }

    private void af() {
        if (this.fD != null) {
            this.fD.fW = true;
            this.mHandler.removeCallbacks(this.fD);
        }
    }

    private void ag() {
        af();
        this.mHandler.removeCallbacksAndMessages(null);
        this.fc = null;
        this.fa = null;
        this.fb = null;
        this.bM = null;
        C4462b.m14833d();
    }

    void close() {
        if (this.eZ == State.CONNECTING) {
            m15374b("close", new ConnectActionResult(0, ConnectionResult.SUCCEEDED, null));
        } else {
            m15357a("disconnect", new ConnectActionResult(0, ConnectionResult.SUCCEEDED, null));
        }
    }

    private void m15374b(String str, ConnectActionResult connectActionResult) {
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE || this.eZ == State.CLOSED) {
                m15359a(str, new JSONObject[0]);
                return;
            }
            bz m = m15405m(str);
            m.jU = new C4507b(this.eZ, null);
            ai();
            m15342a(State.CLOSED);
            this.eU.close();
            m.jV = new C4506a(Integer.valueOf(0));
            this.fd.stop();
            m15385d(0);
            this.ff.clear();
            this.fg.clear();
            this.fk.clear();
            this.fl.clear();
            this.fj.clear();
            ap();
            this.eV.onConnectionStateChanged(this, State.CLOSED, connectActionResult);
            ag();
        }
    }

    private void m15340a(ConnectActionResult connectActionResult) {
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE || this.eZ == State.CLOSED) {
                m15359a("internalClose", new JSONObject[0]);
                return;
            }
            ShineDevice ah = ah();
            bz m = m15405m("internalClose");
            m.jU = new C4507b(this.eZ, null);
            ai();
            m15342a(State.CLOSED);
            if (m15387d(ah) || m15366a(connectActionResult.getError())) {
                this.eU.m14759b(this.eZ);
            }
            this.eU.close();
            m.jV = new C4506a(Integer.valueOf(0));
            this.fd.stop();
            m15385d(0);
            this.ff.clear();
            this.fg.clear();
            this.fk.clear();
            this.fl.clear();
            this.fj.clear();
            if (m15390e(ah)) {
                m15393f(ah);
            }
            ap();
            this.eV.onConnectionStateChanged(this, State.CLOSED, connectActionResult);
            ag();
        }
    }

    private ShineDevice ah() {
        ShineDevice shineDevice;
        synchronized (this.eU.gi) {
            if (this.eU == null) {
                shineDevice = null;
            } else {
                shineDevice = this.eU.getDevice();
            }
        }
        return shineDevice;
    }

    public ShineDevice getDevice() {
        ShineDevice shineDevice = null;
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE) {
                m15359a("getDevice", new JSONObject[0]);
            } else {
                bz m = m15405m("getDevice");
                m.jU = new C4507b(this.eZ, null);
                shineDevice = this.eU.getDevice();
                m.jV = new C4506a(Integer.valueOf(0));
                JSONObject jSONObject = new JSONObject();
                if (shineDevice != null) {
                    try {
                        jSONObject.put("name", shineDevice.getName());
                        jSONObject.put("address", shineDevice.getAddress());
                        jSONObject.put("serialNumber", shineDevice.getSerialNumber());
                    } catch (Throwable e) {
                        C4462b.m14831a(e, "");
                    }
                }
                m.jX = new C4508c(Integer.valueOf(0), jSONObject);
            }
        }
        return shineDevice;
    }

    private boolean m15362a(ba baVar) {
        if (baVar == null) {
            LogUtils.m15477e(TAG, "PhaseController NULL");
            return false;
        }
        bz i = m15396i(baVar.aS());
        if (i == null) {
            LogUtils.m15477e(TAG, "LogEventItem NULL");
            return false;
        }
        this.ff.put(baVar.aR(), i);
        i.jU = new C4507b(this.eZ, baVar.aH());
        ActionID aR = baVar.aR();
        if (aR == ShineActionID.OTA) {
            m15342a(State.OTA);
        }
        synchronized (this.fu) {
            this.fu.put(aR, baVar);
        }
        baVar.start();
        i.jV = new C4506a(Integer.valueOf(0));
        return true;
    }

    public boolean interrupt(ActionID actionID) {
        return interrupt(actionID, false);
    }

    public boolean interrupt(ActionID actionID, boolean z) {
        synchronized (this.eU.gi) {
            String str = z ? "interruptOnConnectionDropped" : "interrupt";
            if (actionID == null || !am()) {
                m15359a(str, new JSONObject[0]);
                return false;
            }
            ba baVar = (ba) this.fu.get(actionID);
            if (baVar != null || m15363a(actionID)) {
                bz i = m15396i(str);
                if (i == null) {
                    LogUtils.m15477e(TAG, "LogEventItem NULL");
                    return false;
                }
                i.jU = new C4507b(this.eZ, null);
                if (m15363a(actionID)) {
                    this.eY.onStreamingStopped(new ActionResult(ResultCode.SUCCEEDED, null));
                    this.eY = null;
                } else {
                    baVar.mo4821a(z);
                    if (actionID == ShineActionID.STREAM_USER_INPUT_EVENTS) {
                        this.eY = null;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("actionID", actionID.name());
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                i.jV = new C4506a(Integer.valueOf(0), jSONObject);
                return true;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionID", actionID);
                jSONObject2.put("currentActions", Arrays.toString(getCurrentActions().toArray()));
            } catch (Throwable e2) {
                C4462b.m14831a(e2, "");
            }
            m15359a(str, jSONObject2);
            return false;
        }
    }

    private boolean m15363a(ActionID actionID) {
        return actionID == ShineActionID.STREAM_USER_INPUT_EVENTS && m15422a(ShineFeature.ASYNCHRONOUS_DATA_STREAMING) && this.eY != null;
    }

    private void ai() {
        m15341a(new PrepareActionResult(PreparationResult.CONNECTION_DROPPED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.PREPARE, this.ft, Reason.CONNECTION_DROPPED)));
        for (ActionID interrupt : getCurrentActions()) {
            interrupt(interrupt, true);
        }
    }

    State aj() {
        return this.eZ;
    }

    public Set<ActionID> getCurrentActions() {
        Set hashSet;
        synchronized (this.fu) {
            hashSet = new HashSet(this.fu.keySet());
        }
        return hashSet;
    }

    void addDataCollectionTag(String str) {
        this.fd.addDataCollectionTag(str);
    }

    private bz m15396i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m15405m(str);
    }

    private void m15385d(long j) {
        m15388e(j);
    }

    private void m15343a(C4630d c4630d) {
        synchronized (this.eU.gi) {
            if (c4630d == this.fE && this.fu.isEmpty()) {
                Set Q = this.fv.m15282Q();
                if (!(Q == null || Q.isEmpty())) {
                    this.fd.m14998d(Q);
                    this.fv.m15283R();
                }
                LogManager.bA().m15450b(this.fd);
                this.fd.bH();
            }
        }
    }

    private void m15388e(long j) {
        synchronized (this.eU.gi) {
            ak();
            this.fE = new C4630d(this);
            LogManager.bz().postDelayed(this.fE, j);
        }
    }

    private void ak() {
        synchronized (this.eU.gi) {
            if (this.fE != null) {
                this.fE.fW = true;
                LogManager.bz().removeCallbacks(this.fE);
            }
        }
    }

    private void m15342a(State state) {
        if (this.eZ != state) {
            this.eZ = state;
        }
    }

    private void m15399j(String str) {
        this.fa = str;
        if (this.fd.getFirmwareVersion() == null) {
            this.fd.m15000j(str);
        }
    }

    private void m15401k(String str) {
        this.fb = str;
        if (this.fd.getModelNumber() == null) {
            this.fd.m15001k(str);
        }
    }

    private void m15403l(String str) {
        ShineDevice device = this.eU.getDevice();
        if (str != null && device != null && !str.equals(device.getSerialNumber())) {
            device.m15289g(str);
            an.m14695W();
            if (this.fd.getSerialNumber() == null) {
                this.fd.m14999g(str);
            }
        }
    }

    private boolean al() {
        return State.CONNECTED == this.eZ || State.PREPARING == this.eZ || State.READY == this.eZ || State.OTA == this.eZ;
    }

    private boolean am() {
        return State.READY == this.eZ || State.OTA == this.eZ;
    }

    private boolean m15377b(Set<String> set) {
        C4563r c = this.eU.m14760c("3dda0001-957f-7d4a-34a6-74696673696d");
        if (c == null) {
            return false;
        }
        for (String b : set) {
            if (c.mo4872b(b) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean m15383c(Set<String> set) {
        boolean z = false;
        synchronized (this.fu) {
            if (this.eZ != State.READY && this.eZ != State.OTA && this.eZ != State.DISCONNECTING) {
            } else if (m15377b((Set) set)) {
                Collection hashSet = new HashSet();
                for (ba aI : this.fu.values()) {
                    hashSet.addAll(aI.aI());
                }
                z = Collections.disjoint(set, hashSet);
            }
        }
        return z;
    }

    private boolean m15364a(ShineActionID shineActionID) {
        if (shineActionID == ShineActionID.OTA) {
            if (this.eZ == State.READY && this.fu.isEmpty()) {
                return true;
            }
            return false;
        } else if (shineActionID == ShineActionID.SYNC || shineActionID == ShineActionID.RETRIEVE_HARDWARE_LOG) {
            return m15383c(new HashSet(Arrays.asList(new String[]{"3dda0003-957f-7d4a-34a6-74696673696d", "3dda0004-957f-7d4a-34a6-74696673696d"})));
        } else if (shineActionID != ShineActionID.STREAM_USER_INPUT_EVENTS) {
            return m15383c(new HashSet(Arrays.asList(new String[]{"3dda0002-957f-7d4a-34a6-74696673696d"})));
        } else if (m15422a(ShineFeature.ASYNCHRONOUS_DATA_STREAMING)) {
            return m15383c(new HashSet(Arrays.asList(new String[]{"3dda0006-957f-7d4a-34a6-74696673696d"})));
        } else {
            return m15383c(new HashSet(Arrays.asList(new String[]{"3dda0003-957f-7d4a-34a6-74696673696d", "3dda0004-957f-7d4a-34a6-74696673696d"})));
        }
    }

    private boolean m15375b(ba baVar) {
        return m15383c(baVar.aI());
    }

    private JSONObject an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentActions", Arrays.toString(getCurrentActions().toArray()));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    private void m15358a(String str, String str2, JSONObject... jSONObjectArr) {
        if (this.fd != null) {
            this.fd.m14997a(new by(str, this.eZ, str2, jSONObjectArr));
        }
    }

    private void m15359a(String str, JSONObject... jSONObjectArr) {
        if (this.fd != null) {
            this.fd.m14997a(new cc(this.eZ, str, jSONObjectArr));
        }
    }

    private bz m15405m(String str) {
        ca bzVar = new bz(str);
        if (this.fd != null) {
            this.fd.m14997a(bzVar);
        }
        return bzVar;
    }

    private void m15337a(int i, int i2, int i3, ShineError shineError) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", i3);
            jSONObject.put("status", i2);
            jSONObject.put("bondState", ah().getBondState());
            jSONObject.put("hidState", ah().getHIDConnectionState());
            if (shineError != null) {
                jSONObject.put("error", shineError.toJSON());
            }
            if (this.eZ == State.CONNECTED) {
                jSONObject.put(Constants.DURATION, (((double) (System.currentTimeMillis() - this.fw)) * 1.0d) / 1000.0d);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        this.fe.jX = new C4508c(Integer.valueOf(i), jSONObject);
    }

    private void m15339a(ew ewVar, int i, ap apVar) {
        Object obj;
        Throwable e;
        JSONObject jSONObject;
        bz bzVar;
        if (i == 0 || apVar == null || apVar.getId() == 0) {
            obj = null;
        } else {
            Object obj2;
            int id;
            Object name;
            if (apVar instanceof am) {
                obj2 = "ATT_ERROR";
                id = apVar.getId();
                name = apVar.name();
            } else if (apVar instanceof C4452c) {
                String str = "SENDING_REQUEST_ERROR";
                id = apVar.getId();
                String name2 = apVar.name();
            } else {
                name = null;
                id = -1;
                obj2 = null;
            }
            try {
                obj = new JSONObject();
                try {
                    obj.put("domain", obj2);
                    obj.put("code", id);
                    obj.put("reason", name);
                } catch (JSONException e2) {
                    e = e2;
                    C4462b.m14831a(e, "");
                    jSONObject = new JSONObject();
                    jSONObject.put("error", obj);
                    jSONObject.put("data", hb.m15159E(ewVar.getRequestData()));
                    bzVar = (bz) this.fg.get(ewVar.getEventID());
                    if (bzVar == null) {
                        bzVar.jV = new C4506a(Integer.valueOf(i), jSONObject);
                    }
                    m15358a("unexpectedOnRequestSent", ewVar.getRequestName(), jSONObject);
                    return;
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                obj = null;
                e = th;
                C4462b.m14831a(e, "");
                jSONObject = new JSONObject();
                jSONObject.put("error", obj);
                jSONObject.put("data", hb.m15159E(ewVar.getRequestData()));
                bzVar = (bz) this.fg.get(ewVar.getEventID());
                if (bzVar == null) {
                    m15358a("unexpectedOnRequestSent", ewVar.getRequestName(), jSONObject);
                    return;
                }
                bzVar.jV = new C4506a(Integer.valueOf(i), jSONObject);
            }
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("error", obj);
            jSONObject.put("data", hb.m15159E(ewVar.getRequestData()));
        } catch (Throwable e32) {
            C4462b.m14831a(e32, "");
        }
        bzVar = (bz) this.fg.get(ewVar.getEventID());
        if (bzVar == null) {
            m15358a("unexpectedOnRequestSent", ewVar.getRequestName(), jSONObject);
            return;
        }
        bzVar.jV = new C4506a(Integer.valueOf(i), jSONObject);
    }

    private void m15361a(short s, byte[] bArr) {
        LogUtils.m15476d(TAG, "Data: " + hb.m15159E(bArr));
        if (this.eY != null) {
            this.eY.onStreamingEventData(bArr);
            C4454a a = aq.m14764a(ah().getAddress(), s, bArr);
            if (a != null) {
                if (s == (short) 4 && a.gJ == StreamingEventType.HEARTBEAT && a.gK.containsKey("event_sequence_number")) {
                    m15362a(this.fo.m14944c(a.gK.getByte("event_sequence_number"), new C46247(this)));
                }
                this.eY.onStreamingEvent(a.gJ, a.gK);
            }
        }
    }

    private boolean createBond() {
        if (ah() == null) {
            return false;
        }
        return ah().createBond();
    }

    private boolean m15387d(ShineDevice shineDevice) {
        return this.fy && !shineDevice.m15286U();
    }

    private boolean m15390e(ShineDevice shineDevice) {
        return this.fy && shineDevice.m15286U();
    }

    private boolean m15393f(ShineDevice shineDevice) {
        bz m = m15405m("removeBond");
        m.jU = new C4507b(this.eZ, null);
        if (shineDevice == null) {
            LogUtils.m15476d(TAG, "removeBond: device is null!");
            m.jV = new C4506a(Integer.valueOf(1));
            return false;
        }
        boolean T = shineDevice.m15285T();
        if (T) {
            m.jX = new C4508c(Integer.valueOf(0), null);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("previousBondState", shineDevice.getBondState());
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            m.jX = new C4508c(Integer.valueOf(1), jSONObject);
        }
        return T;
    }

    private void ao() {
        C4592s.getApplicationContext().registerReceiver(this.fJ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    private void ap() {
        try {
            C4592s.getApplicationContext().unregisterReceiver(this.fJ);
        } catch (Throwable e) {
            Throwable th = e;
            String address = ah() != null ? ah().getAddress() : "UnknownDevice";
            LogUtils.m15477e(TAG, address + " - state=" + this.eZ);
            C4462b.m14831a(th, address + " - state=" + this.eZ);
        }
    }

    private void aq() {
        if (!ar()) {
            as();
        }
    }

    private boolean ar() {
        return m15362a(this.fo.m14945m(new C46258(this)));
    }

    private void as() {
        if (!at()) {
            au();
        }
    }

    private boolean at() {
        boolean z;
        if (this.eZ != State.PREPARING) {
            if (!m15383c(new HashSet(Arrays.asList(new String[]{"3dda0002-957f-7d4a-34a6-74696673696d"})))) {
                z = false;
                if (z) {
                    m15359a("phaseSetCurrentTimeService", an());
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis / 1000;
                return m15362a(this.fs.m14895a(j, (int) (currentTimeMillis - (j * 1000)), (short) ((TimeZone.getDefault().getOffset(currentTimeMillis) / 1000) / 60), new C46269(this)));
            }
        }
        z = true;
        if (z) {
            long currentTimeMillis2 = System.currentTimeMillis();
            long j2 = currentTimeMillis2 / 1000;
            return m15362a(this.fs.m14895a(j2, (int) (currentTimeMillis2 - (j2 * 1000)), (short) ((TimeZone.getDefault().getOffset(currentTimeMillis2) / 1000) / 60), new C46269(this)));
        }
        m15359a("phaseSetCurrentTimeService", an());
        return false;
    }

    private void au() {
        short s;
        short s2 = GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER;
        if (ar.m14770d(ae(), this.fa)) {
            C4505a v = bx.m14981v(this.fa);
            if (v != null) {
                s = v.jA.majorVersion;
                s2 = v.jA.minorVersion;
            } else if (!av()) {
                m15341a(new PrepareActionResult(PreparationResult.READ_UAPP_SYSTEM_VERSION_FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.READ_UAPP_SYSTEM_VERSION, Event.NONE, Reason.RESOURCE_UNAVAILABLE_ERROR)));
                return;
            } else {
                return;
            }
        }
        s = GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER;
        m15360a(s, s2);
        aa();
    }

    private boolean av() {
        boolean z;
        if (this.eZ != State.PREPARING) {
            if (!m15383c(new HashSet(Arrays.asList(new String[]{"3dda0002-957f-7d4a-34a6-74696673696d"})))) {
                z = false;
                if (!z) {
                    return m15362a(this.fo.m14952t(new ConfigurationCallback(this) {
                        final /* synthetic */ ShineProfile fK;

                        {
                            this.fK = r1;
                        }

                        public void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable) {
                            if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                                UAppSystemVersion uAppSystemVersion = (UAppSystemVersion) hashtable.get(ShineProperty.UAPP_SYSTEM_VERSION);
                                if (uAppSystemVersion != null) {
                                    this.fK.bM = new UAppSystemVersion(uAppSystemVersion);
                                    this.fK.aa();
                                    bx.m14980a(new C4505a(this.fK.fa, new UAppSystemVersion(this.fK.bM)));
                                    bx.by();
                                    return;
                                }
                                this.fK.m15341a(new PrepareActionResult(PreparationResult.READ_UAPP_SYSTEM_VERSION_FAILED, new ShineError(Domain.SHINE_PROFILE_ERROR, ShineActionID.READ_UAPP_SYSTEM_VERSION, Event.READ_UAPP_SYSTEM_VERSION, Reason.RESPONSE_PARSE_ERROR)));
                                return;
                            }
                            this.fK.m15341a(new PrepareActionResult(PreparationResult.READ_UAPP_SYSTEM_VERSION_FAILED, actionResult.getError()));
                        }
                    }));
                }
                m15359a("phaseReadUAppSystemVersion", an());
                return false;
            }
        }
        z = true;
        if (!z) {
            return m15362a(this.fo.m14952t(/* anonymous class already generated */));
        }
        m15359a("phaseReadUAppSystemVersion", an());
        return false;
    }

    private void m15360a(short s, short s2) {
        this.bM = new UAppSystemVersion(s, s2);
    }

    public boolean setInactivityNudge(InactivityNudgeSettings inactivityNudgeSettings, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_INACTIVITY_NUDGE)) {
                z = m15362a(this.fp.m14861a(inactivityNudgeSettings, configurationCallback));
            } else {
                m15359a("phaseSetInactivityNudge", an());
            }
        }
        return z;
    }

    public boolean getInactivityNudge(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_INACTIVITY_NUDGE)) {
                z = m15362a(this.fp.m14867b(configurationCallback));
            } else {
                m15359a("phaseGetInactivityNudge", an());
            }
        }
        return z;
    }

    public boolean setSingleAlarm(AlarmSettings alarmSettings, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_SINGLE_ALARM_TIME)) {
                z = m15362a(this.fp.m14859a(alarmSettings, configurationCallback));
            } else {
                m15359a("phaseSetSingleAlarmTime", an());
            }
        }
        return z;
    }

    public boolean getSingleAlarm(byte b, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_SINGLE_ALARM_TIME)) {
                z = m15362a(this.fp.m14866b(b, configurationCallback));
            } else {
                m15359a("phaseGetSingleAlarmTime", an());
            }
        }
        return z;
    }

    public boolean clearAllAlarms(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.CLEAR_ALL_ALARMS)) {
                z = m15362a(this.fp.m14868c(configurationCallback));
            } else {
                m15359a("phaseClearAllAlarms", an());
            }
        }
        return z;
    }

    public boolean setGoalReachNotification(GoalHitNotificationSettings goalHitNotificationSettings, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_GOAL_HIT_NOTIFICATION)) {
                z = m15362a(this.fp.m14860a(goalHitNotificationSettings, configurationCallback));
            } else {
                m15359a("phaseSetGoalHitNotification", an());
            }
        }
        return z;
    }

    public boolean getGoalReachNotification(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_GOAL_HIT_NOTIFICATION)) {
                z = m15362a(this.fp.m14869d(configurationCallback));
            } else {
                m15359a("phaseGetGoalHitNotification", an());
            }
        }
        return z;
    }

    public boolean setCallTextNotifications(NotificationsSettings notificationsSettings, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_CALL_TEXT_NOTIFICATIONS)) {
                z = m15362a(this.fp.m14862a(notificationsSettings, configurationCallback));
            } else {
                m15359a("phaseSetCallTextNotifications", an());
            }
        }
        return z;
    }

    public boolean getCallTextNotifications(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_CALL_TEXT_NOTIFICATIONS)) {
                z = m15362a(this.fp.m14870e(configurationCallback));
            } else {
                m15359a("phaseGetCallTextNotifications", an());
            }
        }
        return z;
    }

    public boolean disableAllCallTextNotifications(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.DISABLE_ALL_CALL_TEXT_NOTIFICATIONS)) {
                z = m15362a(this.fp.m14871f(configurationCallback));
            } else {
                m15359a("phaseDisableAllCallTextNotifications", an());
            }
        }
        return z;
    }

    public boolean sendCallNotification(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SEND_CALL_NOTIFICATION)) {
                z = m15362a(this.fp.m14872g(configurationCallback));
            } else {
                m15359a("phaseSendCallNotification", an());
            }
        }
        return z;
    }

    public boolean sendTextNotification(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SEND_TEXT_NOTIFICATION)) {
                z = m15362a(this.fp.m14873h(configurationCallback));
            } else {
                m15359a("phaseSendTextNotification", an());
            }
        }
        return z;
    }

    public boolean playVibration(Vibe vibe, short s, int i, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_VIBRATION)) {
                z = m15362a(this.fp.m14865a(vibe, s, i, configurationCallback));
            } else {
                m15359a("phasePlayVibration", an());
            }
        }
        return z;
    }

    public boolean playSound(Sound sound, short s, int i, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_SOUND)) {
                z = m15362a(this.fp.m14864a(sound, s, i, configurationCallback));
            } else {
                m15359a("phasePlaySound", an());
            }
        }
        return z;
    }

    public boolean playLEDAnimation(LED led, short s, int i, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_LED_ANIMATION)) {
                z = m15362a(this.fp.m14863a(led, s, i, configurationCallback));
            } else {
                m15359a("phasePlayLEDAnimation", an());
            }
        }
        return z;
    }

    public boolean setEventMapping(List<EventMapping> list, boolean z, ConfigurationCallback configurationCallback) {
        boolean z2 = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_EVENT_MAPPING)) {
                for (EventMapping eventMapping : list) {
                    if (eventMapping instanceof HIDKeyboardEventMapping) {
                        ((HIDKeyboardEventMapping) eventMapping).setReleaseEnable(ar.m14768a(((HIDKeyboardEventMapping) eventMapping).isReleaseEnable(), ae(), this.fa));
                    } else if (eventMapping instanceof HIDMediaEventMapping) {
                        ((HIDMediaEventMapping) eventMapping).setReleaseEnable(ar.m14768a(((HIDMediaEventMapping) eventMapping).isReleaseEnable(), ae(), this.fa));
                    }
                }
                z2 = m15362a(this.fq.m14810a((List) list, z, configurationCallback));
            } else {
                m15359a("phaseSetEventMapping", an());
            }
        }
        return z2;
    }

    public boolean unmapAllButtonEvents(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.UNMAP_ALL_BUTTON_EVENTS)) {
                z = m15362a(this.fq.m14809a(configurationCallback));
            } else {
                m15359a("phaseUnmapAllButtonEvents", an());
            }
        }
        return z;
    }

    public boolean unmapButtonEvent(MemEventNumber memEventNumber, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.UNMAP_BUTTON_EVENT)) {
                z = m15362a(this.fq.m14808a(memEventNumber, configurationCallback));
            } else {
                m15359a("phaseUnmapButtonEvent", an());
            }
        }
        return z;
    }

    public Firmware getFirmware() {
        Firmware firmware = null;
        synchronized (this.eU.gi) {
            if (this.eZ == State.PREPARING || this.eZ == State.READY || this.eZ == State.OTA || this.eZ == State.DISCONNECTING) {
                if (C4592s.m15222A()) {
                    if (this.fc == null || !TextUtils.equals(this.fa, this.fc.getFirmwareVersion())) {
                        this.fc = bw.m14977t(this.fa);
                    }
                } else if (!(this.fc != null || TextUtils.isEmpty(this.fb) || TextUtils.isEmpty(this.fa))) {
                    this.fc = new CustomFirmware(this.fb, this.fa, null);
                }
                firmware = this.fc;
            } else {
                m15359a("getFirmware", new JSONObject[0]);
            }
        }
        return firmware;
    }

    public boolean executeCustomRequest(ActionID actionID, CustomRequest customRequest, final CustomRequestResponseCallback customRequestResponseCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (actionID instanceof ShineActionID) {
                throw new IllegalArgumentException("actionID must not be a ShineActionID enumeration");
            } else if (customRequest == null) {
                throw new IllegalArgumentException("request must not be null");
            } else {
                String requestName = customRequest.getRequestName();
                String str = Constants.CUSTOM + (requestName.substring(0, 1).toUpperCase() + requestName.substring(1));
                if (!customRequest.isForced) {
                    if (!m15383c(new HashSet(Arrays.asList(new String[]{customRequest.getCharacteristicUUID()})))) {
                        m15359a(str, new JSONObject[0]);
                    }
                }
                ActionID actionID2 = actionID;
                z = m15362a(new av(actionID2, str, Arrays.asList(new ew[]{customRequest}), this.fG, new C4455a(this) {
                    final /* synthetic */ ShineProfile fK;

                    public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                        customRequestResponseCallback.onResponseReceived(baVar.aR(), actionResult, (CustomRequest) list.get(0));
                    }
                }, new JSONObject[0]));
            }
        }
        return z;
    }

    public boolean playNotificationFilterLEDAnimation(LEDColor lEDColor, boolean z, short s, int i, ConfigurationCallback configurationCallback) {
        boolean z2 = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_NOTIFICATION_FILTER_LED_ANIMATION)) {
                z2 = m15362a(this.fr.m14876a(lEDColor, z, s, i, configurationCallback));
            } else {
                m15359a("phasePlayNotificationFilterLEDAnimation", an());
            }
        }
        return z2;
    }

    public boolean playNotificationFilterVibration(boolean z, short s, int i, ConfigurationCallback configurationCallback) {
        boolean z2 = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.PLAY_NOTIFICATION_FILTER_VIBRATION)) {
                z2 = m15362a(this.fr.m14877a(z, s, i, configurationCallback));
            } else {
                m15359a("phasePlayNotificationFilterVibration", an());
            }
        }
        return z2;
    }

    public boolean setCalibratedHandPosition(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_CALIBRATED_HAND_POSITION)) {
                z = m15362a(this.fs.m14900i(configurationCallback));
            } else {
                m15359a("phaseSetCalibratedHandPosition", an());
            }
        }
        return z;
    }

    public boolean setMovingHands(SAMEnum$HandMovingType sAMEnum$HandMovingType, List<HandSettings> list, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_MOVING_HANDS)) {
                z = m15362a(this.fs.m14898a(sAMEnum$HandMovingType, list, configurationCallback));
            } else {
                m15359a("phaseSetMovingHands", an());
            }
        }
        return z;
    }

    public boolean setRequestHandsControl(byte b, boolean z, boolean z2, ConfigurationCallback configurationCallback) {
        boolean z3 = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_REQUEST_HANDS_CONTROL)) {
                z3 = m15362a(this.fs.m14893a(b, z, z2, configurationCallback));
            } else {
                m15359a("phaseSetRequestHandsControl", an());
            }
        }
        return z3;
    }

    public boolean setReleaseHandsControl(int i, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SET_RELEASE_HANDS_CONTROL)) {
                z = m15362a(this.fs.m14894a(i, configurationCallback));
            } else {
                m15359a("phaseSetReleaseHandsControl", an());
            }
        }
        return z;
    }

    public boolean getCurrentHandPositions(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.GET_CURRENT_HAND_POSITIONS)) {
                z = m15362a(this.fs.m14901j(configurationCallback));
            } else {
                m15359a("phaseGetCurrentHandPositions", an());
            }
        }
        return z;
    }

    public boolean sendNotificationHandControl(LEDColor lEDColor, byte b, VibeEnum vibeEnum, int i, List<HandControl> list, ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.SEND_NOTIFICATION_HAND_CONTROL)) {
                z = m15362a(this.fs.m14897a(lEDColor, b, vibeEnum, i, list, configurationCallback));
            } else {
                m15359a("phaseSendNotificationHandControl", an());
            }
        }
        return z;
    }

    public boolean clearAllHandNotifications(ConfigurationCallback configurationCallback) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (m15364a(ShineActionID.CLEAR_ALL_HAND_NOTIFICATIONS)) {
                z = m15362a(this.fs.m14902k(configurationCallback));
            } else {
                m15359a("phaseClearAllHandNotifications", an());
            }
        }
        return z;
    }

    public boolean setMultipleAlarms(List<MultipleAlarmSettings> list, ConfigurationCallback configurationCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (list == null) {
                throw new IllegalArgumentException("Multiple Alarm Settings List can not be null!");
            } else if (list.size() > 32) {
                throw new IllegalArgumentException("Number of Multiple Alarm Settings is more than 32");
            } else {
                ba bjVar = new bj(this.fG, configurationCallback, list);
                if (m15375b(bjVar)) {
                    z = m15362a(bjVar);
                } else {
                    m15359a("phaseSetMultipleAlarms", an());
                }
            }
        }
        return z;
    }

    public boolean verifyMultipleAlarms(int i, ConfigurationCallback configurationCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (i < 0) {
                throw new IllegalArgumentException("Number of alarm settings can not be under zero!");
            }
            ba b = this.fs.m14899b(i, configurationCallback);
            if (m15375b(b)) {
                z = m15362a(b);
            } else {
                m15359a("phaseVerifyMultipleAlarms", an());
            }
        }
        return z;
    }

    public boolean setStopWatchSetting(StopWatchSecondHand stopWatchSecondHand, ConfigurationCallback configurationCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            ba a = this.fs.m14896a(stopWatchSecondHand, configurationCallback);
            if (m15375b(a)) {
                z = m15362a(a);
            } else {
                m15359a("phaseSetStopWatchSetting", an());
            }
        }
        return z;
    }

    public boolean getStopWatchSetting(ConfigurationCallback configurationCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            ba l = this.fs.m14903l(configurationCallback);
            if (m15375b(l)) {
                z = m15362a(l);
            } else {
                m15359a("phaseGetStopWatchSetting", an());
            }
        }
        return z;
    }

    public boolean setUAppConfiguration(Set<UAppEventSetting> set, DataTransferCallback dataTransferCallback) throws IllegalArgumentException {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (set != null) {
                if (!set.isEmpty()) {
                    ba blVar = new bl(this.fG, dataTransferCallback, this.bM, set);
                    if (m15375b(blVar)) {
                        z = m15362a(blVar);
                    } else {
                        m15359a("phaseSetUAppConfiguration", an());
                    }
                }
            }
            throw new IllegalArgumentException("uAppEventMappings must not be null or empty.");
        }
        return z;
    }

    public boolean sendUAppRemoteActivity(UAppNotification uAppNotification, List<UAppInstruction> list, DataTransferCallback dataTransferCallback) throws IllegalArgumentException {
        synchronized (this.eU.gi) {
            if (uAppNotification == null) {
                throw new IllegalArgumentException("uAppNotification must not be null.");
            } else if (list == null) {
                throw new IllegalArgumentException("instructions must not be null.");
            } else {
                ba bfVar = new bf(this.fG, dataTransferCallback, this.bM, uAppNotification, list);
                if (m15375b(bfVar)) {
                    boolean a = m15362a(bfVar);
                    return a;
                }
                m15359a("phaseSendUAppRemoteActivity", an());
                return false;
            }
        }
    }

    public UAppSystemVersion getUAppSystemVersion() {
        UAppSystemVersion uAppSystemVersion = null;
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE) {
                m15359a("getUAppSystemVersion", new JSONObject[0]);
            } else {
                bz m = m15405m("getUAppSystemVersion");
                m.jU = new C4507b(this.eZ, null);
                uAppSystemVersion = aw();
                m.jV = new C4506a(Integer.valueOf(0));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UAppSystemVersionModel.COLUMN_MAJOR_VERSION, uAppSystemVersion.majorVersion);
                    jSONObject.put(UAppSystemVersionModel.COLUMN_MINOR_VERSION, uAppSystemVersion.minorVersion);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                m.jX = new C4508c(Integer.valueOf(0), jSONObject);
            }
        }
        return uAppSystemVersion;
    }

    UAppSystemVersion aw() {
        return new UAppSystemVersion(this.bM);
    }

    public boolean isSupportedFeature(ShineFeature shineFeature) {
        boolean z = false;
        synchronized (this.eU.gi) {
            if (this.eZ == State.IDLE) {
                m15359a("isFeatureSupported", new JSONObject[0]);
            } else {
                bz m = m15405m("isFeatureSupported");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feature", shineFeature);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
                m.jU = new C4507b(this.eZ, jSONObject);
                m.jV = new C4506a(Integer.valueOf(0));
                z = m15422a(shineFeature);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("isSupported", z);
                } catch (Throwable e2) {
                    C4462b.m14831a(e2, "");
                }
                m.jX = new C4508c(Integer.valueOf(0), jSONObject2);
            }
        }
        return z;
    }

    boolean m15422a(ShineFeature shineFeature) {
        switch (shineFeature) {
            case UNMAP_ONE_BUTTON:
                return ar.m14772e(ae(), this.fa);
            case ASYNCHRONOUS_DATA_STREAMING:
                return m15377b(new HashSet(Arrays.asList(new String[]{"3dda0006-957f-7d4a-34a6-74696673696d"})));
            case UAPP:
                return m15377b(new HashSet(Arrays.asList(new String[]{"3dda0006-957f-7d4a-34a6-74696673696d", "3dda0007-957f-7d4a-34a6-74696673696d"}))) & ar.m14770d(ae(), this.fa);
            default:
                return false;
        }
    }

    private boolean m15366a(ShineError shineError) {
        return shineError != null && ((VERSION.SDK_INT < 24 && shineError.getReason() == Reason.GATT_INTERNAL_ERROR) || shineError.getReason() == Reason.LACK_OF_SERVICES || shineError.getReason() == Reason.LACK_OF_CHARACTERISTICS || shineError.getReason() == Reason.TIMED_OUT);
    }
}
