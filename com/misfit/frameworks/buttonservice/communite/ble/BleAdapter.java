package com.misfit.frameworks.buttonservice.communite.ble;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.misfit.ble.setting.eventmapping.ButtonEventMappingOne;
import com.misfit.ble.setting.eventmapping.ButtonEventMappingThree;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.setting.eventmapping.HIDMediaEventMapping;
import com.misfit.ble.setting.eventmapping.ModeDisplayEventMapping;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.KeyCode;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.ModeDisplay;
import com.misfit.ble.setting.flashlink.EventMappingEnum.StopWatchSecondHand;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.rmm.GoalTrackingSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.HandControl;
import com.misfit.ble.setting.sam.HandSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum$HandID;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingDirection;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingSpeed;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingType;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.setting.uapp.UAppEnum$UAppButtonEvent;
import com.misfit.ble.setting.uapp.UAppEventSetting;
import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import com.misfit.ble.setting.uapp.files.declaration.UAppDeclarationFrame;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.CustomRequest;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineConnectionParameters;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineDevice.ShineHIDConnectionCallback;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionCallback;
import com.misfit.ble.shine.ShineProfile.ConnectionResult;
import com.misfit.ble.shine.ShineProfile.CustomRequestResponseCallback;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import com.misfit.ble.shine.ShineProfile.PreparationCallback;
import com.misfit.ble.shine.ShineProfile.PreparationResult;
import com.misfit.ble.shine.ShineProfile.PrepareActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProfile.RetrieveHardwareLogCallback;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.ble.shine.ShineProfile.StreamingCallback;
import com.misfit.ble.shine.ShineProfile.SyncCallback;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.firmware.CustomFirmware;
import com.misfit.ble.shine.firmware.Firmware;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.ble.ResetSettingDefaultCommand;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.buttonservice.ble.ScanService.Callback;
import com.misfit.frameworks.buttonservice.ble.ScanService.ScanServiceError;
import com.misfit.frameworks.buttonservice.ble.SimulateDisconnectionCommand;
import com.misfit.frameworks.buttonservice.ble.SimulatePusherEventCommand;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.db.DataFileProvider;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Direction;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.MovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Speed;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.MicroAppMode;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.CalibrationUtils;
import com.misfit.frameworks.buttonservice.utils.DeviceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArraySet;

public class BleAdapter {
    public static final int APP_CODE = -1000;
    private static final int DEFAULT_CONNECT_TIMEOUT = 40000;
    public static final int[] FAST_CONNECTION_PARAMS = new int[]{15, 0, 720};
    private static final String TAG = BleAdapter.class.getSimpleName();
    private long closeConnectionTimeStamp = System.currentTimeMillis();
    private ConfigurationCallback configurationCallback;
    private Context context;
    private DataTransferCallback dataTransferCallback;
    private int deviceFamily;
    private String deviceModel;
    private String firmwareVersion;
    private ConnectionCallback gattConnectionCallback;
    private RetrieveHardwareLogCallback hardwareLogCallback;
    private ShineHIDConnectionCallback hidConnectionCallback;
    private int hidState;
    private boolean isScanning;
    private String macAddress;
    private PreparationCallback preparationCallback;
    private Callback scanCallback;
    private ScanService scanService;
    private String serial;
    private ShineConfiguration shineConfiguration = null;
    private ShineDevice shineDevice;
    private ShineProfile shineProfile;
    private SyncCallback syncCallback;
    private UAppSystemVersion uAppSystemVersion;

    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$misfit$frameworks$common$enums$Gesture = new int[Gesture.values().length];

        static {
            f1619x90f3d0e4 = new int[MicroAppMode.values().length];
            try {
                f1619x90f3d0e4[MicroAppMode.DISPLAY_ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1619x90f3d0e4[MicroAppMode.STREAMING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1619x90f3d0e4[MicroAppMode.HID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1619x90f3d0e4[MicroAppMode.GOAL_TRACKING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SINGLE_PRESS.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.DOUBLE_PRESS.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.TRIPLE_PRESS.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.LONG_PRESS.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.DOUBLE_LONG_PRESS.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_SINGLE_PRESS.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_SINGLE_PRESS_AND_HOLD.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_DOUBLE_PRESS.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_TRIPLE_PRESS.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT1_PRESSED.ordinal()] = 10;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_SINGLE_PRESS.ordinal()] = 11;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_SINGLE_PRESS_AND_HOLD.ordinal()] = 12;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_DOUBLE_PRESS.ordinal()] = 13;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_TRIPLE_PRESS.ordinal()] = 14;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT2_PRESSED.ordinal()] = 15;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_SINGLE_PRESS.ordinal()] = 16;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_SINGLE_PRESS_AND_HOLD.ordinal()] = 17;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_DOUBLE_PRESS.ordinal()] = 18;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_TRIPLE_PRESS.ordinal()] = 19;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$misfit$frameworks$common$enums$Gesture[Gesture.SAM_BT3_PRESSED.ordinal()] = 20;
            } catch (NoSuchFieldError e24) {
            }
            $SwitchMap$com$misfit$ble$shine$ShineProfile$State = new int[State.values().length];
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.OTA.ordinal()] = 3;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.PREPARING.ordinal()] = 5;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.CONNECTING.ordinal()] = 6;
            } catch (NoSuchFieldError e30) {
            }
            try {
                $SwitchMap$com$misfit$ble$shine$ShineProfile$State[State.DISCONNECTING.ordinal()] = 7;
            } catch (NoSuchFieldError e31) {
            }
        }
    }

    class C46801 implements Runnable {
        C46801() {
        }

        public void run() {
            BleAdapter.this.log("Retrieving GATT Connected Devices");
            List retrieveGattConnectedDevice = BleAdapter.this.scanService.retrieveGattConnectedDevice();
            if (retrieveGattConnectedDevice == null) {
                retrieveGattConnectedDevice = new ArrayList();
            }
            BleAdapter.this.log("Retrieved GATT Connected Devices: " + r0.size());
            int i = 0;
            for (ShineDevice shineDevice : r0) {
                ShineDevice shineDevice2;
                int i2;
                BleAdapter.this.log("\t GATT Connected: " + shineDevice2.getSerialNumber() + ", " + shineDevice2.getAddress());
                BleAdapter.this.scanCallback.onDeviceFound(shineDevice2, 0);
                if ((TextUtils.isEmpty(shineDevice2.getSerialNumber()) || !shineDevice2.getSerialNumber().equals(BleAdapter.this.serial)) && !shineDevice2.getAddress().equals(BleAdapter.this.macAddress)) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
                i = i2;
            }
            if (i == 0) {
                BleAdapter.this.log("Build device by mac address, mac=" + BleAdapter.this.macAddress);
                shineDevice2 = BleAdapter.this.scanService.buildDeviceByMacAddress(BleAdapter.this.macAddress);
                if (shineDevice2 != null) {
                    BleAdapter.this.scanCallback.onDeviceFound(shineDevice2, 0);
                }
            }
            BleAdapter.this.scanCallback.onConnectedDeviceRetrieved(new ArrayList());
        }
    }

    class C46812 implements ShineHIDConnectionCallback {
        C46812() {
        }

        public void onHIDConnectionStateChanged(ShineDevice shineDevice, int i) {
            MFLogger.d(BleAdapter.TAG, "Inside " + BleAdapter.TAG + ", method connect(), hid state changed, old state=" + BleAdapter.this.hidState + ", new state=" + i);
            BleAdapter.this.hidState = i;
            BleAdapter.this.hidConnectionCallback.onHIDConnectionStateChanged(shineDevice, i);
        }
    }

    class C46823 implements PreparationCallback {
        C46823() {
        }

        public void onPreparationCompleted(ShineProfile shineProfile, PrepareActionResult prepareActionResult) {
            if (prepareActionResult.getResultCode() == PreparationResult.SUCCEEDED) {
                BleAdapter.this.readDeviceInformation();
            }
            BleAdapter.this.preparationCallback.onPreparationCompleted(shineProfile, prepareActionResult);
        }
    }

    class C46834 implements Runnable {
        C46834() {
        }

        public void run() {
            BleAdapter.this.hidConnectionCallback.onHIDConnectionStateChanged(BleAdapter.this.shineDevice, BleAdapter.this.hidState);
        }
    }

    class C46845 implements ConfigurationCallback {
        C46845() {
        }

        public void onConfigCompleted(ActionID actionID, ActionResult actionResult, Hashtable<ShineProperty, Object> hashtable) {
            BleAdapter.this.configurationCallback.onConfigCompleted(actionID, actionResult, hashtable);
            BleAdapter.this.onGettingConfigurationCompleted(actionResult, (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION));
        }
    }

    class C46878 implements CustomRequestResponseCallback {
        C46878() {
        }

        public void onResponseReceived(ActionID actionID, ActionResult actionResult, CustomRequest customRequest) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ActionID: " + actionID.name() + " - ");
            stringBuffer.append(customRequest.getResponseDescriptionJSON());
            MFLogger.d(BleAdapter.TAG, "simulateDisconnection: " + stringBuffer.toString());
        }
    }

    class C46889 implements CustomRequestResponseCallback {
        C46889() {
        }

        public void onResponseReceived(ActionID actionID, ActionResult actionResult, CustomRequest customRequest) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ActionID: " + actionID.name() + " - ");
            stringBuffer.append(customRequest.getResponseDescriptionJSON());
            MFLogger.d(BleAdapter.TAG, "simulatePusherEvent: " + stringBuffer.toString());
        }
    }

    class BleScanServiceCallback implements Callback {
        private BleScanServiceCallback() {
        }

        public void onDeviceFound(ShineDevice shineDevice, int i) {
            BleAdapter.this.scanCallback.onDeviceFound(shineDevice, i);
        }

        public void onConnectedDeviceRetrieved(List<ShineDevice> list) {
            BleAdapter.this.log("Retrieved HID Connected Devices: " + list.size());
            for (ShineDevice shineDevice : list) {
                BleAdapter.this.log(" -- HID Connected Device: " + shineDevice.getSerialNumber() + ", " + shineDevice.getAddress());
                BleAdapter.this.hidConnectionCallback.onHIDConnectionStateChanged(shineDevice, 2);
                if (!shineDevice.getAddress().equals(BleAdapter.this.macAddress)) {
                    if (!TextUtils.isEmpty(shineDevice.getSerialNumber()) && shineDevice.getSerialNumber().equals(BleAdapter.this.serial)) {
                        BleAdapter.this.hidState = 2;
                        break;
                    }
                } else {
                    BleAdapter.this.hidState = 2;
                    break;
                }
            }
            BleAdapter.this.scanCallback.onConnectedDeviceRetrieved(list);
        }

        public void onScanFail(ScanServiceError scanServiceError) {
            BleAdapter.this.scanCallback.onScanFail(scanServiceError);
        }
    }

    enum CustomActionId implements ActionID {
        SIMULATE_DISCONNECTION("100"),
        SIMULATE_PUSHER_EVENT("101"),
        RESET_DEVICE_SETTING_TO_DEFAULT("110");
        
        private static final Map<String, CustomActionId> lookup = null;
        private String mId;

        static {
            lookup = new HashMap();
            Iterator it = EnumSet.allOf(CustomActionId.class).iterator();
            while (it.hasNext()) {
                CustomActionId customActionId = (CustomActionId) it.next();
                lookup.put(customActionId.getId(), customActionId);
            }
        }

        private CustomActionId(String str) {
            this.mId = str;
        }

        public static CustomActionId get(String str) {
            return (CustomActionId) lookup.get(str);
        }

        public String getId() {
            return this.mId;
        }
    }

    class CustomConfigurationSession extends ConfigurationSession {
        public CustomConfigurationSession(ShineConfiguration shineConfiguration) {
            this.mShineConfiguration = shineConfiguration;
        }

        private void prepareSetTimeParams() {
            long currentTimeMillis = System.currentTimeMillis();
            this.mTimestamp = currentTimeMillis / 1000;
            this.mPartialSecond = (short) ((int) (currentTimeMillis - (this.mTimestamp * 1000)));
            this.mTimeZoneOffset = (short) ((TimeZone.getDefault().getOffset(currentTimeMillis) / 1000) / 60);
            Log.d(BleAdapter.TAG, "Enable clock with timestamp=" + currentTimeMillis + ", timeZoneOffset=" + this.mTimeZoneOffset);
        }
    }

    public BleAdapter(Context context, ShineHIDConnectionCallback shineHIDConnectionCallback, ConnectionCallback connectionCallback, Callback callback) {
        this.context = context;
        this.hidConnectionCallback = shineHIDConnectionCallback;
        this.gattConnectionCallback = connectionCallback;
        this.scanCallback = callback;
        letBroadCastDisconnectionState();
    }

    public void setPreparationCallback(PreparationCallback preparationCallback) {
        this.preparationCallback = preparationCallback;
    }

    public void setSyncCallback(SyncCallback syncCallback) {
        this.syncCallback = syncCallback;
    }

    public void setConfigurationCallback(ConfigurationCallback configurationCallback) {
        this.configurationCallback = configurationCallback;
    }

    public void setHardwareLogCallback(RetrieveHardwareLogCallback retrieveHardwareLogCallback) {
        this.hardwareLogCallback = retrieveHardwareLogCallback;
    }

    public void setDataTransferCallback(DataTransferCallback dataTransferCallback) {
        this.dataTransferCallback = dataTransferCallback;
    }

    public ShineProfile getShineProfile() {
        return this.shineProfile;
    }

    public void setShineProfile(ShineProfile shineProfile) {
        this.shineProfile = shineProfile;
    }

    public ShineDevice getShineDevice() {
        return this.shineDevice;
    }

    public void setShineDevice(ShineDevice shineDevice) {
        this.shineDevice = shineDevice;
        if (!TextUtils.isEmpty(shineDevice.getAddress())) {
            setMacAddress(shineDevice.getAddress());
        }
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getGattState() {
        return getGattState(this.shineDevice);
    }

    public int getHidState() {
        return getHIDState(this.shineDevice);
    }

    public boolean isDeviceReady() {
        boolean z = false;
        if (this.shineDevice != null) {
            synchronized (this.shineDevice) {
                MFLogger.d(TAG, "Inside " + TAG + ".isDeviceReady - serial=" + this.serial + ", state=" + this.shineDevice.getShineProfileState());
                if (this.shineDevice.getShineProfileState() == State.READY) {
                    z = true;
                }
                if (!z) {
                    log("Is device ready: " + this.serial + ". FALSE");
                }
            }
        } else {
            error("Is device ready " + this.serial + ". FAILED: shineProfile is NULL");
        }
        return z;
    }

    private int getHIDState(ShineDevice shineDevice) {
        if (shineDevice != null) {
            return shineDevice.getHIDConnectionState();
        }
        return -1;
    }

    private int getGattState(ShineDevice shineDevice) {
        if (shineDevice != null) {
            switch (shineDevice.getShineProfileState()) {
                case CLOSED:
                    return 0;
                case READY:
                case OTA:
                case CONNECTED:
                case PREPARING:
                    return 2;
                case CONNECTING:
                    return 1;
                case DISCONNECTING:
                    return 3;
            }
        }
        MFLogger.e(TAG, "Inside " + TAG + ".getGattState - serial=" + this.serial + ", shineDevice=NULL");
        return 0;
    }

    public Context getContext() {
        return this.context;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getDeviceFamily() {
        return this.deviceFamily;
    }

    public short getMicroAppMajorVersion() {
        if (this.uAppSystemVersion != null) {
            return this.uAppSystemVersion.majorVersion;
        }
        return (short) -1;
    }

    public short getMicroAppMinorVersion() {
        if (this.uAppSystemVersion != null) {
            return this.uAppSystemVersion.minorVersion;
        }
        return (short) -1;
    }

    public int getBatteryLevel() {
        if (this.shineConfiguration != null) {
            return this.shineConfiguration.mBatteryLevel;
        }
        return -1;
    }

    public boolean shouldBroadCastDisconnectionState() {
        return this.closeConnectionTimeStamp <= System.currentTimeMillis();
    }

    public void letBroadCastDisconnectionState() {
        this.closeConnectionTimeStamp = System.currentTimeMillis();
    }

    public void notBroadCastDisconnectionState() {
        this.closeConnectionTimeStamp = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public boolean addDataCollectionTag(String str) {
        try {
            if (this.shineDevice != null) {
                synchronized (this.shineDevice) {
                    MFLogger.d(TAG, ".addDataCollectionTag - serial=" + this.serial + ", tag=" + str);
                    log("SDK Tag: " + str);
                    this.shineDevice.addDataCollectionTag(str);
                }
                return true;
            }
        } catch (Exception e) {
            MFLogger.e(TAG, ".addDataCollectionTag - serial=" + this.serial + ", tag=" + str + ", ex=" + e.toString());
        }
        return false;
    }

    public void startRetrieveDevices(long j) {
        MFLogger.d(TAG, "Inside " + TAG + ".retrieve devices");
        this.isScanning = true;
        this.scanService = new ScanService(this.context, new BleScanServiceCallback(), j);
        this.scanService.setActiveDeviceLog(this.serial);
        log("Retrieving GATT Connected Devices");
        List retrieveGattConnectedDevice = this.scanService.retrieveGattConnectedDevice();
        if (retrieveGattConnectedDevice == null) {
            retrieveGattConnectedDevice = new ArrayList();
        }
        log("Retrieved GATT Connected Devices: " + retrieveGattConnectedDevice.size());
        new Handler(Looper.getMainLooper()).postDelayed(new C46801(), 200);
    }

    public List<ShineDevice> retrieveGattDevices(long j) {
        this.scanService = new ScanService(this.context, new BleScanServiceCallback(), j);
        this.scanService.setActiveDeviceLog(this.serial);
        List<ShineDevice> retrieveGattConnectedDevice = this.scanService.retrieveGattConnectedDevice();
        if (retrieveGattConnectedDevice == null) {
            retrieveGattConnectedDevice = new ArrayList();
        }
        log("Retrieved GATT Connected Devices: " + retrieveGattConnectedDevice.size());
        return retrieveGattConnectedDevice;
    }

    public ShineDevice buildShineDeviceByMAC(long j) {
        if (TextUtils.isEmpty(this.macAddress)) {
            log("Build device by mac address, mac is empty.");
            return null;
        }
        this.scanService = new ScanService(this.context, new BleScanServiceCallback(), j);
        this.scanService.setActiveDeviceLog(this.serial);
        ShineDevice buildDeviceByMacAddress = this.scanService.buildDeviceByMacAddress(this.macAddress);
        log("Build device by mac address, mac=" + this.macAddress + ", device=" + buildDeviceByMacAddress);
        return buildDeviceByMacAddress;
    }

    public void startScanning(long j) {
        log("Start scanning...");
        this.isScanning = true;
        this.scanService = new ScanService(this.context, new BleScanServiceCallback(), j);
        this.scanService.setActiveDeviceLog(this.serial);
        this.scanService.startScanWithAutoStopTimer();
    }

    public void stopScanning() {
        MFLogger.d(TAG, "Inside " + TAG + ".stopScanning - scanService=" + this.scanService);
        if (this.scanService != null) {
            this.scanService.stopScan();
            if (this.isScanning) {
                log("Stop scanning for " + this.serial);
            }
        }
        this.isScanning = false;
    }

    public boolean retrieveBondedDeviceIfExisted(long j) {
        if (this.scanService == null) {
            this.scanService = new ScanService(this.context, new BleScanServiceCallback(), j);
        }
        List<ShineDevice> retrieveBondedDevices = this.scanService.retrieveBondedDevices();
        int size = (retrieveBondedDevices == null || retrieveBondedDevices.size() == 0) ? 0 : retrieveBondedDevices.size();
        log("Retrieving Bonded Devices - count=" + size + ", candidate address=" + this.macAddress);
        if (retrieveBondedDevices == null) {
            return false;
        }
        for (ShineDevice shineDevice : retrieveBondedDevices) {
            if (!this.serial.equalsIgnoreCase(shineDevice.getSerialNumber())) {
                if (shineDevice.getAddress().equals(this.macAddress)) {
                }
            }
            setShineDevice(shineDevice);
            return true;
        }
        return false;
    }

    public boolean connect(boolean z, long j) {
        log("Connecting to " + this.serial + ", shineDevice=" + this.shineDevice + ", shineProfile=" + this.shineProfile);
        if (this.shineDevice != null) {
            this.shineDevice.registerHIDConnectionCallback(new C46812());
            if (this.shineProfile == null || getGattState() != 2) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                this.shineProfile = this.shineDevice.getShineProfile();
                int gattState = getGattState();
                long j2 = z ? 40000 : 0;
                if (this.shineProfile == null) {
                    log("Start connectProfile to " + this.serial + "...");
                } else if (gattState == 2) {
                    log("Device already connected");
                } else if (gattState == 1) {
                    log("Device is being connected");
                } else if (gattState == 0) {
                    log("Device is disconnected. Start connectProfile to " + this.serial + "...");
                }
                this.shineDevice.connectProfile(j2, this.gattConnectionCallback);
                MFLog activeLog = MFLogManager.getInstance(this.context).getActiveLog(this.serial);
                if (activeLog != null) {
                    addDataCollectionTag(String.valueOf(activeLog.getStartTimeEpoch()));
                } else {
                    addDataCollectionTag(Long.toString(j));
                }
            } else {
                this.gattConnectionCallback.onConnectionStateChanged(this.shineProfile, State.CONNECTED, new ConnectActionResult(-1000, ConnectionResult.SUCCEEDED, null));
            }
        } else {
            log("Connecting to " + this.serial + ": FAILED - shineDevice is NULL");
            this.gattConnectionCallback.onConnectionStateChanged(this.shineProfile, State.CLOSED, new ConnectActionResult(-1000, ConnectionResult.FAILED, null));
        }
        return true;
    }

    public boolean prepare() {
        log("Preparing to " + this.serial);
        if (!isDeviceReady()) {
            return this.shineProfile.prepare(new C46823());
        }
        this.preparationCallback.onPreparationCompleted(this.shineProfile, new PrepareActionResult(PreparationResult.SUCCEEDED, null));
        readDeviceInformation();
        return true;
    }

    private void readDeviceInformation() {
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                this.deviceModel = this.shineProfile.getModelNumber();
                this.firmwareVersion = this.shineProfile.getFirmwareVersion();
                this.deviceFamily = this.shineProfile.getDeviceFamily();
                this.uAppSystemVersion = this.shineProfile.getUAppSystemVersion();
                MFLog activeLog = MFLogManager.getInstance(this.context).getActiveLog(this.serial);
                if (activeLog != null) {
                    activeLog.log("Device's Firmware: " + this.firmwareVersion);
                    activeLog.setFirmwareVersion(this.firmwareVersion);
                }
            }
        } else {
            error("Read device information " + this.serial + ". FAILED: shineProfile is NULL");
        }
        MFLogger.d(TAG, "Inside " + TAG + ".readDeviceInformation - deviceModel=" + this.deviceModel + ", firmwareVersion=" + this.firmwareVersion + ", uAppSystemMajorVersion:" + this.uAppSystemVersion.majorVersion + ", uAppSystemMinorVersion:" + this.uAppSystemVersion.minorVersion);
    }

    public void closeConnection(boolean z) {
        log("Close connection to " + this.serial);
        if (this.shineDevice != null) {
            synchronized (this.shineDevice) {
                if (getGattState(this.shineDevice) != 0) {
                    if (z) {
                        letBroadCastDisconnectionState();
                    } else {
                        notBroadCastDisconnectionState();
                    }
                }
                this.shineDevice.closeProfile();
            }
            return;
        }
        error("Close connection " + this.serial + ". FAILED: shineProfile is NULL");
    }

    public void refreshDevicesCache() {
        log("Refresh device cache");
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                this.shineProfile.refreshDeviceCache();
            }
            return;
        }
        error("Refresh device cache " + this.serial + ". FAILED: shineProfile is NULL");
    }

    public boolean eraseFiles(boolean z) {
        boolean z2 = false;
        log("Erase files - clearInternalCache=" + z);
        if (z) {
            DataFileProvider.getInstance(this.context).clearFiles();
        }
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(ShineProfile.SKIP_READ_ACTIVITY_FILES, true);
                bundle.putBoolean(ShineProfile.SKIP_ERASE_ACTIVITY_FILES, false);
                z2 = this.shineProfile.sync(this.syncCallback, bundle);
                logSdkResult("Erase files", z2);
            }
        }
        return z2;
    }

    public boolean readFiles(boolean z) {
        boolean z2 = false;
        log("Read files - delete=" + z);
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(ShineProfile.SKIP_READ_ACTIVITY_FILES, false);
                String str = ShineProfile.SKIP_ERASE_ACTIVITY_FILES;
                if (!z) {
                    z2 = true;
                }
                bundle.putBoolean(str, z2);
                z2 = this.shineProfile.sync(this.syncCallback, bundle);
                logSdkResult("Read files", z2);
            }
        }
        return z2;
    }

    public boolean readHardwareLog(boolean z) {
        log("Read hardware log");
        return doReadHardwareLog(z);
    }

    public boolean eraseHardwareLog() {
        MFLogger.d(TAG, "Inside " + TAG + ".eraseHardwareLog - serial=" + this.serial);
        return doReadHardwareLog(true);
    }

    private boolean doReadHardwareLog(boolean z) {
        boolean z2 = false;
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                Bundle bundle = new Bundle();
                String str = ShineProfile.SKIP_ERASE_HARDWARE_LOG;
                if (!z) {
                    z2 = true;
                }
                bundle.putBoolean(str, z2);
                z2 = this.shineProfile.retrieveHardwareLog(this.hardwareLogCallback, bundle);
                logSdkResult("Read hardware log", z2);
            }
        }
        return z2;
    }

    public boolean setRealTimeStep(long j) {
        log("Set real time steps: " + j);
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        ShineConfiguration shineConfiguration = new ShineConfiguration();
        shineConfiguration.mCurrentSteps = j;
        ConfigurationSession customConfigurationSession = new CustomConfigurationSession(shineConfiguration);
        customConfigurationSession.prepareSetTimeParams();
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(customConfigurationSession, this.configurationCallback);
            logSdkResult("Set real time step", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean getRealTimeStep() {
        log("Get realtime step");
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.getDeviceConfiguration(this.configurationCallback, Collections.singletonList(ShineProfile.DEVICE_CONFIGURATION_CURRENT_STEPS_KEY));
            logSdkResult("Get realtime step", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean setGoalInStep(long j) {
        log("Set goal in step: " + j);
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            shineConfiguration.mGoalInSteps = j;
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(new CustomConfigurationSession(shineConfiguration), this.configurationCallback);
            logSdkResult("Set goal in step", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    private boolean isHidAvailable(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.contains(".prod")) {
            return false;
        }
        return true;
    }

    public boolean hidConnect() {
        if (isHidAvailable(this.serial, getFirmwareVersion())) {
            log("HID connect");
            if (this.hidState == 2) {
                new Handler(Looper.getMainLooper()).postDelayed(new C46834(), 1000);
                return true;
            } else if (this.shineDevice == null) {
                return true;
            } else {
                boolean hidConnect;
                synchronized (this.shineDevice) {
                    hidConnect = this.shineDevice.hidConnect();
                    log("HID connect currentState=" + (this.hidState == 2 ? "Connecting" : "Disconnected") + ". hidConnect executable: " + hidConnect);
                }
                return hidConnect;
            }
        }
        MFLogger.e(TAG, "Device is running factory firmware, HID is not allowed. Returning...");
        return false;
    }

    public boolean hidDisconnect() {
        if (this.shineDevice == null) {
            MFLogger.d(TAG, "Inside " + TAG + ".hidDisconnect - Failed: shine device is null");
            return false;
        }
        boolean hidDisconnect;
        MFLogger.d(TAG, "HID_Disconnect with " + this.shineDevice.getSerialNumber());
        synchronized (this.shineDevice) {
            hidDisconnect = this.shineDevice.hidDisconnect();
            log("HID disconnect " + this.serial + ", current state=" + (this.hidState == 2 ? "Connecting" : "Disconnected") + ". Result: " + hidDisconnect);
        }
        return hidDisconnect;
    }

    public boolean setConnectionParams(int[] iArr) {
        boolean z = false;
        log("Set connection params");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                ShineConnectionParameters shineConnectionParameters = new ShineConnectionParameters((double) iArr[0], iArr[1], iArr[2]);
                log(String.format("Setting connection params: %s, %s, %s", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2])}));
                z = this.shineProfile.setConnectionParameters(shineConnectionParameters, this.configurationCallback);
                logSdkResult("Set connection params", z);
            }
        }
        return z;
    }

    public boolean getDeviceConfiguration(Device device) {
        boolean z = false;
        log("Get configuration");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                ConfigurationCallback c46845 = new C46845();
                List arrayList = new ArrayList(Arrays.asList(new String[]{ShineProfile.DEVICE_CONFIGURATION_BATTERY_KEY, ShineProfile.DEVICE_CONFIGURATION_CURRENT_STEPS_KEY, ShineProfile.DEVICE_CONFIGURATION_GOAL_IN_STEPS_KEY, ShineProfile.DEVICE_CONFIGURATION_GOAL_TRACKING_SETTINGS_KEY, ShineProfile.DEVICE_CONFIGURATION_TIME_KEY}));
                if (device != null) {
                    if (device.isSupportDeviceState(CommunicateMode.GET_SECOND_TIMEZONE)) {
                        arrayList.add(ShineProfile.DEVICE_CONFIGURATION_TIMEZONE_OFFSET_KEY);
                    }
                    if (device.isSupportDeviceState(CommunicateMode.GET_COUNTDOWN)) {
                        arrayList.add(ShineProfile.DEVICE_CONFIGURATION_COUNTDOWN_SETTINGS_KEY);
                    }
                    if (device.isSupportDeviceState(CommunicateMode.GET_VIBRATION_STRENGTH)) {
                        arrayList.add(ShineProfile.DEVICE_CONFIGURATION_VIBE_STRENGTH_KEY);
                    }
                }
                z = this.shineProfile.getDeviceConfiguration(c46845, arrayList);
                logSdkResult("Get configuration", z);
            }
        }
        return z;
    }

    private void onGettingConfigurationCompleted(ActionResult actionResult, ConfigurationSession configurationSession) {
        if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
            this.shineConfiguration = configurationSession.mShineConfiguration;
        }
    }

    public boolean enableAlarm(AlarmSettings alarmSettings) {
        log("Enable alarm");
        if (!isDeviceReady()) {
            return false;
        }
        boolean singleAlarm;
        synchronized (this.shineProfile) {
            singleAlarm = this.shineProfile.setSingleAlarm(alarmSettings, this.configurationCallback);
            logSdkResult("Enable alarm", singleAlarm);
        }
        return singleAlarm;
    }

    public boolean getAlarm() {
        log("Get alarm");
        if (!isDeviceReady()) {
            return false;
        }
        boolean singleAlarm;
        synchronized (this.shineProfile) {
            singleAlarm = this.shineProfile.getSingleAlarm(AlarmSettings.ALL_DAYS, this.configurationCallback);
            logSdkResult("Get alarm", singleAlarm);
        }
        return singleAlarm;
    }

    public boolean disableAlarm() {
        log("Disable alarm");
        if (!isDeviceReady()) {
            return false;
        }
        boolean clearAllAlarms;
        synchronized (this.shineProfile) {
            clearAllAlarms = this.shineProfile.clearAllAlarms(this.configurationCallback);
            logSdkResult("Disable alarm", clearAllAlarms);
        }
        return clearAllAlarms;
    }

    public boolean setMultipleAlarms(List<MultipleAlarmSettings> list) {
        log("Set multiple alarms");
        if (!isDeviceReady()) {
            return false;
        }
        boolean multipleAlarms;
        synchronized (this.shineProfile) {
            multipleAlarms = this.shineProfile.setMultipleAlarms(list, this.configurationCallback);
            logSdkResult("Set multiple alarms", multipleAlarms);
        }
        return multipleAlarms;
    }

    public boolean verifyMultipleAlarms(int i) {
        log("Verify multiple alarms");
        if (!isDeviceReady()) {
            return false;
        }
        boolean verifyMultipleAlarms;
        synchronized (this.shineProfile) {
            verifyMultipleAlarms = this.shineProfile.verifyMultipleAlarms(i, this.configurationCallback);
            logSdkResult("Verify multiple alarms", verifyMultipleAlarms);
        }
        return verifyMultipleAlarms;
    }

    public boolean enableSecondTimezone(int i) {
        log("Set second timezone - offset=" + i);
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            shineConfiguration.mTimezoneOffset = (short) i;
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(new CustomConfigurationSession(shineConfiguration), this.configurationCallback);
            logSdkResult("Set second timezone", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean getSecondTimezone() {
        log("Get second timezone");
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.getDeviceConfiguration(this.configurationCallback, Collections.singletonList(ShineProfile.DEVICE_CONFIGURATION_TIMEZONE_OFFSET_KEY));
            logSdkResult("Get second timezone", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean disableSecondTimezone() {
        log("Disable second timezone");
        return enableSecondTimezone(1024);
    }

    public boolean setLinkMappings(List<LinkMapping> list, boolean z) {
        log("Set LINK mapping");
        if (list == null || list.size() == 0) {
            this.configurationCallback.onConfigCompleted(ShineActionID.SET_EVENT_MAPPING, new ActionResult(ResultCode.SUCCEEDED, null), null);
            return true;
        }
        List arrayList = new ArrayList();
        for (LinkMapping linkMapping : list) {
            if (linkMapping != null) {
                Object modeDisplayEventMapping;
                boolean z2 = false;
                MemEventNumber memEventNumber = MemEventNumber.SINGLE_CLICK;
                AnimNumber animNumber = AnimNumber.NO_ANIMATION;
                switch (AnonymousClass11.$SwitchMap$com$misfit$frameworks$common$enums$Gesture[linkMapping.getGesture().ordinal()]) {
                    case 1:
                        memEventNumber = MemEventNumber.SINGLE_CLICK;
                        animNumber = AnimNumber.SINGLE_CLICK_SUCCEEDED;
                        break;
                    case 2:
                        memEventNumber = MemEventNumber.DOUBLE_CLICK;
                        animNumber = AnimNumber.DOUBLE_CLICK_SUCCEEDED;
                        break;
                    case 3:
                        memEventNumber = MemEventNumber.PLUTO_TRIPLE_TAP;
                        animNumber = AnimNumber.TRIPLE_PRESS_SUCCEEDED;
                        break;
                    case 4:
                        memEventNumber = MemEventNumber.LONG_PRESS;
                        animNumber = AnimNumber.LONG_PRESS_SUCCEEDED;
                        z2 = true;
                        break;
                    case 5:
                        memEventNumber = MemEventNumber.DOUBLE_PRESS_N_HOLD;
                        animNumber = AnimNumber.DOUBLE_PRESS_N_HOLD_SUCCEEDED;
                        z2 = true;
                        break;
                    case 6:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON1_SINGLE_PRESS;
                        animNumber = AnimNumber.SINGLE_CLICK_SUCCEEDED;
                        break;
                    case 7:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON1_SINGLE_PRESS_AND_HOLD;
                        animNumber = AnimNumber.LONG_PRESS_SUCCEEDED;
                        z2 = true;
                        break;
                    case 8:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON1_DOUBLE_PRESS;
                        animNumber = AnimNumber.DOUBLE_CLICK_SUCCEEDED;
                        break;
                    case 9:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON1_TRIPLE_PRESS;
                        animNumber = AnimNumber.TRIPLE_PRESS_SUCCEEDED;
                        break;
                    case 10:
                        memEventNumber = MemEventNumber.BUTTON1_PRESSED;
                        animNumber = AnimNumber.SINGLE_CLICK_RECEIVED;
                        break;
                    case 11:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON2_SINGLE_PRESS;
                        animNumber = AnimNumber.SINGLE_CLICK_SUCCEEDED;
                        break;
                    case 12:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON2_SINGLE_PRESS_AND_HOLD;
                        animNumber = AnimNumber.LONG_PRESS_SUCCEEDED;
                        z2 = true;
                        break;
                    case 13:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON2_DOUBLE_PRESS;
                        animNumber = AnimNumber.DOUBLE_CLICK_SUCCEEDED;
                        break;
                    case 14:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON2_TRIPLE_PRESS;
                        animNumber = AnimNumber.TRIPLE_PRESS_SUCCEEDED;
                        break;
                    case 15:
                        memEventNumber = MemEventNumber.BUTTON2_PRESSED;
                        animNumber = AnimNumber.SINGLE_CLICK_RECEIVED;
                        break;
                    case 16:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON3_SINGLE_PRESS;
                        animNumber = AnimNumber.SINGLE_CLICK_SUCCEEDED;
                        break;
                    case 17:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON3_SINGLE_PRESS_AND_HOLD;
                        animNumber = AnimNumber.LONG_PRESS_SUCCEEDED;
                        z2 = true;
                        break;
                    case 18:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON3_DOUBLE_PRESS;
                        animNumber = AnimNumber.DOUBLE_CLICK_SUCCEEDED;
                        break;
                    case 19:
                        memEventNumber = MemEventNumber.EVENT_TYPE_BUTTON3_TRIPLE_PRESS;
                        animNumber = AnimNumber.TRIPLE_PRESS_SUCCEEDED;
                        break;
                    case 20:
                        memEventNumber = MemEventNumber.BUTTON3_PRESSED;
                        animNumber = AnimNumber.SINGLE_CLICK_RECEIVED;
                        break;
                }
                MicroAppMode fromAction = MicroAppMode.fromAction(linkMapping.getAction());
                KeyCode customModeKeyCodeByAction = DeviceUtils.getInstance(this.context).getCustomModeKeyCodeByAction(linkMapping.getAction());
                MFLogger.d(TAG, "Start set mapping with button type is " + fromAction + " and custom keycode is " + customModeKeyCodeByAction + " and memEventNumber is " + memEventNumber);
                switch (fromAction) {
                    case DISPLAY_ACTION:
                        ModeDisplay displayMode = DeviceUtils.getInstance(this.context).getDisplayMode(linkMapping.getAction());
                        modeDisplayEventMapping = new ModeDisplayEventMapping(memEventNumber, displayMode, displayMode);
                        break;
                    case STREAMING:
                        modeDisplayEventMapping = new ButtonEventMappingOne(memEventNumber, AnimNumber.NO_ANIMATION, AnimNumber.NO_ANIMATION);
                        break;
                    case HID:
                        modeDisplayEventMapping = new HIDMediaEventMapping(memEventNumber, animNumber, customModeKeyCodeByAction, z2);
                        break;
                    case GOAL_TRACKING:
                        short parseShort;
                        try {
                            parseShort = Short.parseShort(linkMapping.getExtraInfo());
                        } catch (Exception e) {
                            Log.d(TAG, "getStateOnCompleted - ex=" + e.toString());
                            parseShort = GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER;
                        }
                        GoalTrackingEventMapping goalTrackingEventMapping = new GoalTrackingEventMapping(memEventNumber, parseShort);
                        break;
                    default:
                        modeDisplayEventMapping = new HIDMediaEventMapping(memEventNumber, animNumber, customModeKeyCodeByAction, z2);
                        break;
                }
                arrayList.add(modeDisplayEventMapping);
            }
        }
        if (arrayList.size() == 0) {
            this.configurationCallback.onConfigCompleted(ShineActionID.SET_EVENT_MAPPING, new ActionResult(ResultCode.SUCCEEDED, null), null);
            return false;
        }
        boolean z3 = z && this.shineProfile.isSupportedFeature(ShineFeature.UNMAP_ONE_BUTTON);
        z3 = this.shineProfile.setEventMapping(arrayList, z3, this.configurationCallback);
        logSdkResult("Set LINK mapping", z3);
        return z3;
    }

    public boolean setMicroAppMappings(List<MicroAppMapping> list) {
        log("Set Micro-app mapping");
        Set linkedHashSet = new LinkedHashSet();
        if (list == null || list.size() == 0) {
            this.configurationCallback.onConfigCompleted(ShineActionID.SET_UAPP_CONFIGURATION, new ActionResult(ResultCode.SUCCEEDED, null), null);
            return true;
        }
        for (MicroAppMapping microAppMapping : list) {
            if (microAppMapping != null) {
                UAppEnum$UAppButtonEvent uAppEnum$UAppButtonEvent = UAppEnum$UAppButtonEvent.BTN_1;
                switch (AnonymousClass11.$SwitchMap$com$misfit$frameworks$common$enums$Gesture[microAppMapping.getGesture().ordinal()]) {
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        uAppEnum$UAppButtonEvent = UAppEnum$UAppButtonEvent.BTN_1;
                        break;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        uAppEnum$UAppButtonEvent = UAppEnum$UAppButtonEvent.BTN_2;
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        uAppEnum$UAppButtonEvent = UAppEnum$UAppButtonEvent.BTN_3;
                        break;
                }
                byte[] bArr = new byte[0];
                String[] declarationFiles = microAppMapping.getDeclarationFiles();
                List arrayList = new ArrayList();
                if (declarationFiles != null) {
                    byte[] bArr2 = bArr;
                    for (String str : declarationFiles) {
                        if (str != null) {
                            bArr2 = Base64.decode(str, 0);
                        }
                        UAppDeclarationFrame uAppDeclarationFrame = new UAppDeclarationFrame(bArr2);
                        UAppCustomizationFrame customizationFrame = microAppMapping.getCustomization().getCustomizationFrame();
                        if (customizationFrame != null) {
                            uAppDeclarationFrame.setCustomization(customizationFrame);
                        }
                        arrayList.add(uAppDeclarationFrame);
                        MFLogger.d(TAG, "Start set micro app mapping with appId is " + uAppDeclarationFrame.getUAppId() + " and variant is " + uAppDeclarationFrame.getUAppVariant() + " and memEventNumber is " + uAppEnum$UAppButtonEvent + " and extraInfo=" + str);
                    }
                } else {
                    MFLogger.d(TAG, "Start set micro app mapping, memEventNumber is " + uAppEnum$UAppButtonEvent + ", declaration file is null");
                }
                linkedHashSet.add(new UAppEventSetting(uAppEnum$UAppButtonEvent, arrayList));
            }
        }
        boolean uAppConfiguration = this.shineProfile.setUAppConfiguration(linkedHashSet, this.dataTransferCallback);
        logSdkResult("Set Micro-app mappings", uAppConfiguration);
        return uAppConfiguration;
    }

    public boolean sendMicroAppRemoteCommand(UAppNotification uAppNotification, List<UAppInstruction> list) {
        boolean z = false;
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.sendUAppRemoteActivity(uAppNotification, list, this.dataTransferCallback);
            }
        }
        return z;
    }

    public boolean isSupportedFeature(ShineFeature shineFeature) {
        boolean z = false;
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.isSupportedFeature(shineFeature);
                MFLogger.d(TAG, "isSupportedFeature, feature:" + shineFeature.name() + ", result = " + z);
            }
        }
        return z;
    }

    public boolean clearAllMappings() {
        log("Clear LINK mapping");
        if (!isDeviceReady()) {
            return false;
        }
        boolean unmapAllButtonEvents;
        synchronized (this.shineProfile) {
            unmapAllButtonEvents = this.shineProfile.unmapAllButtonEvents(this.configurationCallback);
            logSdkResult("Clear LINK mapping", unmapAllButtonEvents);
        }
        return unmapAllButtonEvents;
    }

    public boolean setStopWatchSetting(StopWatchSecondHand stopWatchSecondHand) {
        log("Set stop watch setting");
        if (isDeviceReady()) {
            boolean stopWatchSetting;
            synchronized (this.shineProfile) {
                stopWatchSetting = this.shineProfile.setStopWatchSetting(stopWatchSecondHand, this.configurationCallback);
                logSdkResult("Set stop watch setting", stopWatchSetting);
            }
            return stopWatchSetting;
        }
        error("Set stop watch setting: FAILED - device is not ready.");
        return false;
    }

    public boolean enableGoalTracking(int i, boolean z) {
        log("Enable goal tracking");
        if (isDeviceReady()) {
            boolean deviceConfiguration;
            synchronized (this.shineProfile) {
                GoalTrackingSettings goalTrackingSettings = new GoalTrackingSettings((short) i, z);
                MFLogger.d(TAG, "Inside " + TAG + ".doEnableGoalTracking - serial=" + this.serial + ", goalId=" + goalTrackingSettings.mGoalIdNumber + ", enabled=" + goalTrackingSettings.mGoalTrackingState);
                ShineConfiguration shineConfiguration = new ShineConfiguration();
                shineConfiguration.mGoalTrackingSettings = goalTrackingSettings;
                deviceConfiguration = this.shineProfile.setDeviceConfiguration(new CustomConfigurationSession(shineConfiguration), this.configurationCallback);
                MFLogger.d(TAG, "Inside " + TAG + ".doEnableGoalTracking - serial=" + this.serial + ", ret=" + deviceConfiguration);
                logSdkResult("Enable goal tracking", deviceConfiguration);
            }
            return deviceConfiguration;
        }
        error("Enable goal tracking: FAILED - shineProfile is NULL");
        return false;
    }

    public boolean enableCountdown(CountdownSettings countdownSettings) {
        log("Enable countdown: startTime=" + countdownSettings.getStartTimeInUTCSeconds() + ", endTime=" + countdownSettings.getEndTimeInUTCSeconds() + ", timezone=" + countdownSettings.getTimezoneOffset());
        if (!isDeviceReady()) {
            error("Enable countdown: FAILED - shineProfile is NULL");
            return false;
        } else if (countdownSettings != null) {
            boolean deviceConfiguration;
            synchronized (this.shineProfile) {
                MFLogger.d(TAG, "Inside " + TAG + ".doEnableCountDown - startTime=" + countdownSettings.getStartTimeInUTCSeconds() + ", endTime=" + countdownSettings.getEndTimeInUTCSeconds() + ", timezone=" + countdownSettings.getTimezoneOffset());
                ShineConfiguration shineConfiguration = new ShineConfiguration();
                shineConfiguration.mCountdownSettings = countdownSettings;
                deviceConfiguration = this.shineProfile.setDeviceConfiguration(new CustomConfigurationSession(shineConfiguration), this.configurationCallback);
                logSdkResult("Enable countdown", deviceConfiguration);
            }
            return deviceConfiguration;
        } else {
            MFLogger.d(TAG, "Inside " + TAG + ".doEnableCountDown - countdownSetting=null");
            return true;
        }
    }

    public CountdownSettings getDisableCountDownSetting() {
        return new CountdownSettings(0, 0, GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER);
    }

    public boolean disableCountdown() {
        return enableCountdown(getDisableCountDownSetting());
    }

    public boolean getCountdown() {
        log("Get countdown");
        if (!isDeviceReady()) {
            error("Get countdown: FAILED - shineProfile is NULL");
            return false;
        } else if (SettingsUtils.isSupportCountDown(this.serial)) {
            boolean deviceConfiguration;
            MFLogger.d(TAG, "Inside " + TAG + ".doGetCountDown - serial=" + this.serial);
            synchronized (this.shineProfile) {
                deviceConfiguration = this.shineProfile.getDeviceConfiguration(this.configurationCallback, Collections.singletonList(ShineProfile.DEVICE_CONFIGURATION_COUNTDOWN_SETTINGS_KEY));
                logSdkResult("Get countdown", deviceConfiguration);
            }
            return deviceConfiguration;
        } else {
            MFLogger.d(TAG, "Inside " + TAG + ".doEnableCountDown - countdownSetting=null");
            return true;
        }
    }

    public boolean isStreaming() {
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                for (ActionID actionID : this.shineProfile.getCurrentActions()) {
                    if (actionID == ShineActionID.STREAM_USER_INPUT_EVENTS) {
                        return true;
                    }
                }
                return false;
            }
        }
        Log.e(TAG, ".isStreaming false caused by shine profile is null");
        return false;
    }

    public boolean startStreaming(final StreamingCallback streamingCallback) {
        boolean z = true;
        int gattState = getGattState();
        log("Start streaming");
        MFLogger.d(TAG, ".startStreaming, isStreaming of " + this.serial + " is " + isStreaming() + ", gattState=" + gattState);
        if (isStreaming()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    streamingCallback.onStreamingStarted(new ActionResult(ResultCode.SUCCEEDED, null));
                }
            }, 1000);
        } else if (isDeviceReady() && gattState == 2) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.streamUserInputEvents(streamingCallback);
            }
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    streamingCallback.onStreamingStarted(new ActionResult(ResultCode.FAILED, null));
                }
            }, 1000);
        }
        return z;
    }

    public boolean stopStreaming() {
        log("Stop streaming");
        if (!isStreaming()) {
            return true;
        }
        if (!isDeviceReady()) {
            return false;
        }
        boolean interrupt;
        synchronized (this.shineProfile) {
            interrupt = this.shineProfile.interrupt(ShineActionID.STREAM_USER_INPUT_EVENTS);
            logSdkResult("Stop streaming", interrupt);
        }
        return interrupt;
    }

    public boolean interrupt() {
        stopScanning();
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                ActionID actionID;
                CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
                for (ActionID actionID2 : this.shineProfile.getCurrentActions()) {
                    if (actionID2 != ShineActionID.STREAM_USER_INPUT_EVENTS) {
                        copyOnWriteArraySet.add(actionID2);
                    }
                }
                MFLogger.d(TAG, "---Inside .doInterruptAllAction, total action now is " + copyOnWriteArraySet.size() + ", serial=" + this.serial);
                if (copyOnWriteArraySet.size() == 0) {
                    return false;
                }
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    actionID2 = (ActionID) it.next();
                    MFLogger.d(TAG, "Interrupt action " + actionID2 + ", complete is " + this.shineProfile.interrupt(actionID2));
                }
                return true;
            }
        }
        MFLogger.e(TAG, "shineProfile is null, Fail to interrupt");
        return false;
    }

    public boolean hasPendingAction() {
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
                for (ActionID actionID : this.shineProfile.getCurrentActions()) {
                    if (actionID != ShineActionID.STREAM_USER_INPUT_EVENTS) {
                        copyOnWriteArraySet.add(actionID);
                    }
                }
                MFLogger.d(TAG, "---Inside .hasPendingAction, total action now is " + copyOnWriteArraySet.size() + ", serial=" + this.serial);
                if (copyOnWriteArraySet.size() == 0) {
                    return false;
                }
                return true;
            }
        }
        MFLogger.e(TAG, "hasPendingAction - shineProfile is null");
        return false;
    }

    public boolean doOTA(byte[] bArr, boolean z) {
        boolean z2 = false;
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                MFLogger.i(TAG, "start OTA - serial=" + this.serial + ", shineProfile=" + this.shineProfile + ", dataTransferCallback=" + this.dataTransferCallback + ", currentFw=" + this.shineProfile.getFirmwareVersion() + ", resume=" + z);
                try {
                    Firmware customFirmware = new CustomFirmware("Model Number", "Fw version", bArr);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(ShineProfile.SKIP_RESUME_OTA, !z);
                    z2 = this.shineProfile.ota(customFirmware, this.dataTransferCallback, bundle);
                } catch (Exception e) {
                    MFLogger.e(TAG, "Error inside " + TAG + ".updateOTA - e=" + e);
                }
            }
        }
        return z2;
    }

    public boolean activateDevice() {
        if (!isDeviceReady()) {
            return false;
        }
        boolean activate;
        synchronized (this.shineProfile) {
            activate = this.shineProfile.activate(this.configurationCallback);
        }
        return activate;
    }

    public boolean setMappingAnimation() {
        boolean z = false;
        log("Set mapping animation");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                ButtonEventMappingThree buttonEventMappingThree = new ButtonEventMappingThree(MemEventNumber.PLUTO_TRIPLE_TAP, AnimNumber.TRIPLE_PRESS_SUCCEEDED, (short) 1, AnimNumber.ERROR, (short) 3, AnimNumber.ERROR, (short) 0);
                List arrayList = new ArrayList();
                arrayList.add(buttonEventMappingThree);
                z = this.shineProfile.setEventMapping(arrayList, false, this.configurationCallback);
                logSdkResult("Set mapping animation", z);
            }
        }
        return z;
    }

    public boolean requestHandControl() {
        boolean z = false;
        log("Request hand control");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.setRequestHandsControl((byte) 1, false, false, this.configurationCallback);
                logSdkResult("Request hand control", z);
            }
        } else {
            error("Request hand control: FAILED - shineProfile is NULL");
        }
        return z;
    }

    public boolean releaseHandControl() {
        boolean z = false;
        log("Release hand control");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.setReleaseHandsControl(0, this.configurationCallback);
                logSdkResult("Release hand control", z);
            }
        } else {
            error("Release hand control: FAILED - shineProfile is NULL");
        }
        return z;
    }

    public boolean applyHandPosition() {
        log("Apply hand position");
        if (!isDeviceReady()) {
            return false;
        }
        boolean calibratedHandPosition = this.shineProfile.setCalibratedHandPosition(this.configurationCallback);
        logSdkResult("Apply hand position", calibratedHandPosition);
        return calibratedHandPosition;
    }

    public boolean moveHandsToPosition(HandId handId, MovingType movingType, Direction direction, Speed speed, int i) {
        MFLogger.d(TAG, "Inside " + TAG + ".moveHandsToPosition - serial=" + this.serial);
        if (isDeviceReady()) {
            List arrayList = new ArrayList();
            arrayList.add(new HandSettings(CalibrationUtils.getCalibrationId(handId), i, CalibrationUtils.getCalibrationDirection(direction), CalibrationUtils.getCalibrationSpeed(speed)));
            return this.shineProfile.setMovingHands(CalibrationUtils.getCalibrationMovingType(movingType), arrayList, this.configurationCallback);
        }
        MFLogger.e(TAG, "Error inside .doMoveHands shineProfile is null");
        return false;
    }

    public boolean resetHandsPosition() {
        boolean z = false;
        log("Reset hand position");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                List arrayList = new ArrayList();
                arrayList.add(new HandSettings(SAMEnum$HandID.HOUR, 0, SAMEnum$HandMovingDirection.SHORTEST_PATH, SAMEnum$HandMovingSpeed.FULL));
                arrayList.add(new HandSettings(SAMEnum$HandID.MINUTE, 0, SAMEnum$HandMovingDirection.SHORTEST_PATH, SAMEnum$HandMovingSpeed.FULL));
                arrayList.add(new HandSettings(SAMEnum$HandID.SUB_EYE, 0, SAMEnum$HandMovingDirection.SHORTEST_PATH, SAMEnum$HandMovingSpeed.FULL));
                z = this.shineProfile.setMovingHands(SAMEnum$HandMovingType.POSITION, arrayList, this.configurationCallback);
                logSdkResult("Reset hand position", z);
            }
        }
        return z;
    }

    public boolean getCurrentHandPosition() {
        log("Get current hand position");
        if (!isDeviceReady()) {
            return false;
        }
        boolean currentHandPositions;
        synchronized (this.shineProfile) {
            currentHandPositions = this.shineProfile.getCurrentHandPositions(this.configurationCallback);
            logSdkResult("Get current hand position", currentHandPositions);
        }
        return currentHandPositions;
    }

    public boolean playLight(LightVibrationSetting lightVibrationSetting) {
        boolean z = false;
        log("Play light");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                z = this.shineProfile.playNotificationFilterLEDAnimation(lightVibrationSetting.getColor(), false, lightVibrationSetting.getNumRepeat(), lightVibrationSetting.getInterval(), this.configurationCallback);
                logSdkResult("Play light", z);
            }
        }
        return z;
    }

    public boolean playVibration(LightVibrationSetting lightVibrationSetting) {
        log("Play vibe");
        if (!isDeviceReady()) {
            return false;
        }
        boolean playNotificationFilterVibration;
        if (this.shineProfile.getDeviceFamily() == 9) {
            playNotificationFilterVibration = this.shineProfile.playNotificationFilterVibration(lightVibrationSetting.isLong(), lightVibrationSetting.getNumRepeat(), lightVibrationSetting.getInterval(), this.configurationCallback);
        } else {
            VibeEnum vibeEnum;
            switch (lightVibrationSetting.getNumRepeat()) {
                case (short) 1:
                    vibeEnum = lightVibrationSetting.isLong() ? VibeEnum.SINGLE_LONG_VIBE : VibeEnum.SINGLE_SHORT_VIBE;
                    break;
                case (short) 2:
                    vibeEnum = VibeEnum.DOUBLE_SHORT_VIBE;
                    break;
                case (short) 3:
                    vibeEnum = VibeEnum.TRIPLE_SHORT_VIBE;
                    break;
                default:
                    vibeEnum = VibeEnum.TRIPLE_SHORT_VIBE;
                    break;
            }
            playNotificationFilterVibration = this.shineProfile.sendNotificationHandControl(LEDColor.PINK, (byte) 0, vibeEnum, 0, new ArrayList(), this.configurationCallback);
        }
        logSdkResult("Play vibe", playNotificationFilterVibration);
        return playNotificationFilterVibration;
    }

    public boolean playLedAnimation() {
        log("Play Led animation");
        if (!isDeviceReady()) {
            return false;
        }
        boolean playAnimation;
        synchronized (this.shineProfile) {
            playAnimation = this.shineProfile.playAnimation(this.configurationCallback);
            logSdkResult("Play Led animation", playAnimation);
        }
        return playAnimation;
    }

    public boolean playSyncAnimation() {
        log("Play sync animation");
        if (!isDeviceReady()) {
            return false;
        }
        boolean playSyncAnimation;
        synchronized (this.shineProfile) {
            playSyncAnimation = this.shineProfile.playSyncAnimation(this.configurationCallback);
            logSdkResult("Play sync animation", playSyncAnimation);
        }
        return playSyncAnimation;
    }

    public boolean setDeviceConfiguration(ShineConfiguration shineConfiguration) {
        log("Set device configuration");
        if (!isDeviceReady() || shineConfiguration == null) {
            return false;
        }
        boolean deviceConfiguration;
        ConfigurationSession customConfigurationSession = new CustomConfigurationSession(shineConfiguration);
        customConfigurationSession.prepareSetTimeParams();
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(customConfigurationSession, this.configurationCallback);
            logSdkResult("Set device configuration", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean setCurrentTime() {
        log("Set time");
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        ConfigurationSession customConfigurationSession = new CustomConfigurationSession(new ShineConfiguration());
        customConfigurationSession.prepareSetTimeParams();
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(customConfigurationSession, this.configurationCallback);
            logSdkResult("Set time", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean getVibrationStrength() {
        log("Get vibration strength");
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            deviceConfiguration = this.shineProfile.getDeviceConfiguration(this.configurationCallback, Collections.singletonList(ShineProfile.DEVICE_CONFIGURATION_VIBE_STRENGTH_KEY));
            logSdkResult("Get vibration strength", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean setVibrationStrength(short s) {
        log("Set vibration strength");
        if (!isDeviceReady()) {
            return false;
        }
        boolean deviceConfiguration;
        synchronized (this.shineProfile) {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            shineConfiguration.mVibeStrength = s;
            deviceConfiguration = this.shineProfile.setDeviceConfiguration(new CustomConfigurationSession(shineConfiguration), this.configurationCallback);
            logSdkResult("Set vibration strength", deviceConfiguration);
        }
        return deviceConfiguration;
    }

    public boolean readRssi() {
        log("Read rssi");
        if (!isDeviceReady()) {
            return false;
        }
        boolean readRssi;
        synchronized (this.shineProfile) {
            readRssi = this.shineProfile.readRssi(this.configurationCallback);
            logSdkResult("Read rssi", readRssi);
        }
        return readRssi;
    }

    private boolean sendNotification(LEDColor lEDColor, byte b, List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr) {
        boolean z = false;
        log("Send notification");
        if (isDeviceReady()) {
            synchronized (this.shineProfile) {
                List arrayList = new ArrayList();
                if (!(list == null || iArr == null || list.size() != iArr.length)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        arrayList.add(new HandControl(CalibrationUtils.getCalibrationId((HandId) list.get(i2)), (short) iArr[i2]));
                    }
                }
                z = this.shineProfile.sendNotificationHandControl(lEDColor, b, vibeEnum, i, arrayList, this.configurationCallback);
                logSdkResult("Send notification", z);
            }
        }
        return z;
    }

    public boolean sendHandNotification(List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr) {
        return sendNotification(LEDColor.BLUE, (byte) 0, list, vibeEnum, i, iArr);
    }

    public boolean clearLastNotification() {
        log("Clear last notification");
        if (!isDeviceReady()) {
            return false;
        }
        synchronized (this.shineProfile) {
            logSdkResult("Clear last notification", this.shineProfile.clearAllHandNotifications(this.configurationCallback));
        }
        return true;
    }

    public boolean sendLedAndVibeNotification(LEDColor lEDColor, byte b, VibeEnum vibeEnum, int i) {
        return sendNotification(lEDColor, b, new ArrayList(), vibeEnum, i, new int[0]);
    }

    private void logSdkResult(String str, boolean z) {
        log(str + ": SDK -> " + (z ? "OK" : "FAILED"));
    }

    private void log(String str) {
        MFLog activeLog = MFLogManager.getInstance(this.context).getActiveLog(this.serial);
        MFLogger.d(TAG, str);
        if (activeLog != null) {
            activeLog.log("[" + this.serial + "] " + str);
        }
    }

    private void error(String str) {
        MFLog activeLog = MFLogManager.getInstance(this.context).getActiveLog(this.serial);
        MFLogger.e(TAG, str);
        if (activeLog != null) {
            activeLog.error("[" + this.serial + "] " + str);
        }
    }

    public void simulateDisconnection(int i, int i2, int i3, int i4) {
        MFLogger.d(TAG, "Inside " + TAG + ".simulateDisconnection - delay before off=" + i + ", duration=" + i2 + ", repeat times=" + i3 + ", delay each time=" + i4);
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                this.shineProfile.executeCustomRequest(CustomActionId.SIMULATE_DISCONNECTION, new SimulateDisconnectionCommand(i, i2, i3, i4 * 1000), new C46878());
            }
            return;
        }
        MFLogger.e(TAG, "Failed to simulateDisconnection - shineProfile is NULL");
    }

    public void simulatePusherEvent(int i, int i2, int i3, int i4, int i5) {
        MFLogger.d(TAG, "Inside " + TAG + ".simulatePusherEvent - pusher=" + i + ", event=" + i2 + ", delay=" + i3 + ", repeat=" + i4 + ", delayBetweenRepetitions=" + i5);
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                this.shineProfile.executeCustomRequest(CustomActionId.SIMULATE_PUSHER_EVENT, new SimulatePusherEventCommand(i, i2, i3, i4, i5), new C46889());
            }
            return;
        }
        MFLogger.e(TAG, "Failed to simulatePusherEvent - shineProfile is NULL");
    }

    public void resetDeviceSettingToDefault() {
        MFLogger.d(TAG, "Inside " + TAG + ".resetDeviceSettingToDefault");
        if (this.shineProfile != null) {
            synchronized (this.shineProfile) {
                this.shineProfile.executeCustomRequest(CustomActionId.RESET_DEVICE_SETTING_TO_DEFAULT, new ResetSettingDefaultCommand(), new CustomRequestResponseCallback() {
                    public void onResponseReceived(ActionID actionID, ActionResult actionResult, CustomRequest customRequest) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("ActionID: " + actionID.name() + " - ");
                        stringBuffer.append(customRequest.getResponseDescriptionJSON());
                        MFLogger.d(BleAdapter.TAG, "resetDeviceSettingToDefault: " + stringBuffer.toString());
                    }
                });
            }
            return;
        }
        MFLogger.e(TAG, "Failed to resetDeviceSettingToDefault - shineProfile is NULL");
    }
}
