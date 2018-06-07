package com.misfit.frameworks.buttonservice;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.misfit.ble.setting.MSLSetting;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.shine.log.LogSessionAutomaticUploader;
import com.misfit.ble.shine.log.LogSessionUploader;
import com.misfit.frameworks.buttonservice.IButtonConnectivity.Stub;
import com.misfit.frameworks.buttonservice.communite.CommunicateManager;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator$CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.SyncSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchCalibrationSession;
import com.misfit.frameworks.buttonservice.db.DataFileProvider;
import com.misfit.frameworks.buttonservice.enums.ConnectionStateChange;
import com.misfit.frameworks.buttonservice.enums.DeviceErrorState;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.enums.SupportedDevice;
import com.misfit.frameworks.buttonservice.interfaces.SyncProfileCallback;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.buttonservice.model.AppInfo;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Direction;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.MovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Speed;
import com.misfit.frameworks.buttonservice.model.DeviceTask;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.OtaEvent;
import com.misfit.frameworks.buttonservice.model.ScannedDevice;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.utils.BluetoothUtils;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.DeviceUtils;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil.BRAND;
import com.misfit.frameworks.buttonservice.utils.GestureConvertUtils;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.buttonservice.utils.MicroAppEventLogger;
import com.misfit.frameworks.buttonservice.utils.SharePreferencesUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.parceler.Parcels;

public class ButtonService extends Service implements BleCommunicator$CommunicationResultCallback, SyncProfileCallback {
    public static String ACTION_ANALYTIC_EVENT = ".analytic_event";
    public static String ACTION_CONNECTION_STATE_CHANGE = ".action_connection_state_change";
    public static String ACTION_GET_ALARM = ".action_get_alarm";
    public static String ACTION_GET_COUNTDOWN = ".action_get_countdown";
    public static String ACTION_LOCATION_CHANGED = ".action_location_changed";
    public static String ACTION_OTA_PROGRESS = ".action_service_ota_progress";
    public static String ACTION_SCAN_DEVICE_FOUND = ".scan_device_found";
    public static String ACTION_SERVICE_BLE_RESPONSE = ".action_service_fw_response";
    public static String ACTION_SERVICE_HEARTBEAT_DATA = ".action_service_heartbeat_data";
    public static String ACTION_SERVICE_MICRO_APP_CANCEL_EVENT = ".action_service_micro_app_cancel_event";
    public static String ACTION_SERVICE_MICRO_APP_EVENT = ".action_service_micro_app_event";
    public static String ACTION_SERVICE_STREAMING_EVENT = ".action_service_streaming_event";
    public static final String ACTION_STREAMING_STOP = "fossil_action_service_streaming_stop_event";
    public static final String ALARM_GET_ALARM = ".action.alarm.getAlarm";
    public static final String ALARM_HOUR = ".action.alarm.hour";
    public static final String ALARM_IS_REPEAT = ".action.alarm.repeat";
    public static final String ALARM_MINUTE = ".action.alarm.minute";
    public static final String ALARM_VERIFY_LIST_ALARM = ".action.alarm.verifyMultipleAlarms";
    private static final String APP_INFO = "APP_INFO";
    public static String BLUETOOTH_NOT_SUPPORTED = ".action.countdown.bluetooth.notsupport";
    private static final int BUTTON_SERVICE_ID = 10;
    private static final long CONNECT_TIMEOUT = 10000;
    public static final String COUNTDOWN_END = ".action.countdown.end";
    public static final String COUNTDOWN_PROGRESS = ".action.countdown.progress";
    public static final String COUNTDOWN_START = ".action.countdown.start";
    public static final String COUNTDOWN_TIMEZONE_OFFSET = ".action.countdown.timezoneOffset";
    public static final int DISABLE_GOAL_TRACKING_ID = 255;
    public static final String GET_COUNTDOWN_SETTING = ".action.countdown.getCountDownSetting";
    public static final String GET_VIBRATION_STRENGTH = ".action.vibe.getVibrationStrength";
    public static final int GOAL_TRACKING_ID_RANGE = 255;
    public static final String LAST_DEVICE_ERROR_STATE = "device_error_state";
    public static final String LIST_ERROR_STATE = "list_device_error_state";
    public static final String LOG_ID = "logId";
    public static String SERVICE_ACTION_RESULT = ".service_action_result";
    public static String SERVICE_BLE_PHASE = ".service_ble_phase";
    public static final String SET_COUNTDOWN_IS_ENABLE = "set_countdown_is_enable";
    public static final String START_SYNC_TIME = "start_sync_time";
    public static final String SYNC_MODE = "syncMode";
    private static final String TAG = ButtonService.class.getSimpleName();
    public static final long TIME_STAMP_FOR_NON_EXECUTABLE_METHOD = Long.MAX_VALUE;
    private static final String USER_ID = "userId";
    public static final String VIBRATION_STRENGTH_LEVEL = "vibration_strength_level";
    private static final int WAITING_AFTER_BLUETOOTH_ON = 20000;
    private static AppInfo appInfo;
    private static BRAND fossilBrand;
    private final BroadcastReceiver bluetoothReceiver = new 2(this);
    Stub buttonServiceHub = new C39014();
    private Set<String> connectQueue;
    private ConcurrentHashMap<String, MisfitDeviceProfile> deviceList;
    private long lastBluetoothOn = 0;
    private ScanServiceInstance scanServiceInstance;
    private ConcurrentHashMap<String, ScannedDevice> scannedDevices;
    private int startSyncTime = 0;
    private int state = 12;
    private HandlerThread thread = new HandlerThread(TAG);
    private final BroadcastReceiver timeZoneChangeReceiver = new 1(this);
    private String userId;

    class C39014 extends Stub {
        C39014() {
        }

        public void connectAllButton() throws RemoteException {
            if (ButtonService.this.isBleSupported()) {
                ButtonService.this.connectAllButton();
            }
        }

        public long deviceReconnect(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceReconnect(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.RECONNECT, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long pairDevice(String str, String str2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.pairDevice(str, str2);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.LINK, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deviceDisconnect(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.deviceDisconnect(str);
            } else {
                ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.DISCONNECT, ServiceActionResult.FAILED, null);
            }
        }

        public long deviceUnlink(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceUnlink(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.UNLINK, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public boolean switchActiveDevice(String str, UserProfile userProfile) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.switchActiveDevice(str, userProfile);
            }
            return false;
        }

        public void deviceStartScan() throws RemoteException {
            if (ButtonService.this.isBleSupported()) {
                ButtonService.this.scanServiceInstance.startScan();
            }
        }

        public void deviceStopScan() throws RemoteException {
            if (ButtonService.this.isBleSupported()) {
                ButtonService.this.scanServiceInstance.stopScan();
            }
        }

        public long deviceStartSync(String str, UserProfile userProfile) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceStartSync(str, userProfile);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SYNC, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void updatePercentageGoalProgress(String str, boolean z, int i, int i2) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.updatePercentageGoalProgress(str, z, i, i2);
            }
        }

        public long deviceStartHWLogSync(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceStartHWLogSync(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.HW_LOG_SYNC, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deleteDataFiles(List<String> list, String str) {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.deleteDataFiles(list);
            }
        }

        public long devicePlayAnimation(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.devicePlayAnimation(str);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceReadRealTimeStep(String str) {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceReadRealTimeStep(str);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceUpdateGoalStep(String str, int i) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceUpdateGoalStep(str, i);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceGetBatteryLevel(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetBatteryLevel(str);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceGetRssi(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetRssi(str);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceOta(String str, byte[] bArr, boolean z, String str2, String str3, UserProfile userProfile) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceOta(str, bArr, z, str2, str3, userProfile);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.OTA, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public List<MisfitDeviceProfile> getPairedDevice() throws RemoteException {
            if (ButtonService.this.isBleSupported()) {
                return ButtonService.this.getPairedDevice();
            }
            return new ArrayList();
        }

        public MisfitDeviceProfile getDeviceProfile(String str) {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.getDeviceProfile(str);
            }
            return null;
        }

        public int getGattState(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.getGattState(str);
            }
            return 0;
        }

        public int getHIDState(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.getHIDState(str);
            }
            return 0;
        }

        public void logOut() throws RemoteException {
            ButtonService.this.logOut();
        }

        public boolean isSyncing(String str) throws RemoteException {
            return ButtonService.this.isSyncing(str);
        }

        public boolean isUpdatingFirmware(String str) throws RemoteException {
            return ButtonService.this.isBleSupported(str) && ButtonService.this.isUpdatingFirmware(str);
        }

        public boolean isLinking(String str) throws RemoteException {
            return ButtonService.this.isBleSupported(str) && ButtonService.this.isLinking(str);
        }

        public long playLightAndVibration(String str, int i, int i2, int i3, int i4) {
            MFLogger.m12670d(ButtonService.TAG, "playLightAndVibration");
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.devicePlayLightAndVibration(str, i, i2, i3, i4);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long playLight(String str, int i, int i2, int i3, boolean z) {
            MFLogger.m12670d(ButtonService.TAG, "playLight");
            if (!ButtonService.this.isBleSupported(str)) {
                return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
            }
            return ButtonService.this.devicePlayLight(str, (short) i, i2, i3, z);
        }

        public long playVibration(String str, int i, int i2, boolean z) {
            MFLogger.m12670d(ButtonService.TAG, "playVibration");
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.devicePlayVibration(str, (short) i, i2, z);
            }
            return ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }

        public long deviceSetMapping(String str, List<BLEMapping> list) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetMapping(str, list);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_LINK_MAPPING, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceClearMapping(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceClearMapping(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.CLEAN_LINK_MAPPINGS, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void setAutoMapping(String str, List<BLEMapping> list) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.setAutoMapping(str, list);
            } else {
                ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_AUTO_MAPPING, ServiceActionResult.FAILED, null);
            }
        }

        public List<BLEMapping> getAutoMapping(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.getAutoMapping(str);
            }
            return new ArrayList();
        }

        public void setActiveSerial(String str, String str2) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.setActiveSerial(str, str2);
            }
        }

        public void setPairedSerial(String str, String str2) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.setPairedDevice(str, str2);
            }
        }

        public void removeActiveSerial(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                DevicePreferenceUtils.removeActiveButtonSerial(ButtonService.this, str);
            }
        }

        public void removePairedSerial(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                DevicePreferenceUtils.removePairedButtonSerial(ButtonService.this, str);
            }
        }

        public List<String> getActiveSerial() throws RemoteException {
            return DevicePreferenceUtils.getAllActiveButtonSerial(ButtonService.this);
        }

        public List<String> getPairedSerial() throws RemoteException {
            return DevicePreferenceUtils.getAllPairedButtonSerial(ButtonService.this);
        }

        public long deviceStartCalibration(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceStartCalibration(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.ENTER_CALIBRATION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deviceMovingHand(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.deviceMovingHand(str, i, HandId.fromValue(i2), MovingType.fromValue(i3), Direction.fromValue(i4), Speed.fromValue(i5));
                return;
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.MOVE_HAND, ServiceActionResult.FAILED, null);
        }

        public long resetHandsToZeroDegree(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceResetHandsToZeroDegree(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.RESET_HAND, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceCompleteCalibration(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceCompleteCalibration(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.APPLY_HAND_POSITION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceCancelCalibration(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.cancelCalibration(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.EXIT_CALIBRATION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void interrupt(String str) {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.interrupt(str);
            } else {
                ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.INTERRUPT, ServiceActionResult.FAILED, null);
            }
        }

        @Deprecated
        public long disableGoalTracking(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.disableGoalTracking(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.DISABLE_GOAL_TRACKING, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetSecondTimeZone(String str, String str2) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetSecondTimeZone(str, str2);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_SECOND_TIMEZONE, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceGetSecondTimeZone(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetSecondTimezone(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_SECOND_TIMEZONE, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deviceSetAutoSecondTimezone(String str) {
            ButtonService.this.deviceSetAutoSecondTimezone(str);
        }

        public long deviceClearAllAlarm(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceClearAllAlarm(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.CLEAR_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetAlarm(String str, int i, int i2, int i3, int i4, int i5, boolean z) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetAlarm(str, i, i2, i3, i4, i5, z);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceGetCurrentAlarm(String str) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetAlarm(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetListAlarm(String str, List<Alarm> list) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetListAlarm(str, list);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_LIST_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceVerifyListAlarm(String str, int i) throws RemoteException {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceVerifyListAlarm(str, i);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.VERIFY_LIST_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deviceSetAutoAlarmSetting(int i, int i2, int i3, int i4, int i5, boolean z) {
            ButtonService.this.deviceSetAutoAlarmSetting(i, i2, i3, i4, i5, z);
        }

        public void deviceSetAutoListAlarm(List<Alarm> list) {
            ButtonService.this.deviceSetAutoListAlarm(list);
        }

        public long devicePlayHandsNotification(String str, int i, int[] iArr, int[] iArr2, int i2, boolean z) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.devicePlayHandsNotification(str, i, iArr, iArr2, i2, z);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SEND_NOTIFICATION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceGetVibrationStrength(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetVibrationStrength(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_VIBRATION_STRENGTH, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetVibrationStrength(String str, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetVibrationStrength(str, i);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_VIBRATION_STRENGTH, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetEnableCountDown(String str, long j, long j2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetEnableCountDown(str, j, j2);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_COUNTDOWN, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceSetDisableCountDown(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceSetDisableCountDown(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_COUNTDOWN, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public long deviceGetCountDown(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.deviceGetCountDown(str);
            }
            ButtonService.this.broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_COUNTDOWN, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }

        public void deviceSetAutoCountdownSetting(long j, long j2) {
            ButtonService.this.deviceSetAutoCountdownSetting(j, j2);
        }

        public void updateUserId(String str) {
            ButtonService.this.updateUserId(str);
        }

        public void updateAppInfo(String str) {
            ButtonService.this.updateAppInfo(str);
        }

        public void addLog(int i, String str, String str2) {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.addLog(i, str, str2);
            }
        }

        public int startLog(int i, String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.startLog(i, str);
            }
            return 0;
        }

        public int endLog(int i, String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.endLog(i, str);
            }
            return 0;
        }

        public void stopLogService(int i) {
            ButtonService.this.stopLogService(i);
        }

        public void changePendingLogKey(int i, String str, int i2, String str2) {
            if (ButtonService.this.isBleSupported(str2)) {
                ButtonService.this.changePendingLogKey(i, str, i2, str2);
            }
        }

        public void clearLastNotification(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.deviceClearLastNotification(str);
            }
        }

        public void sendMicroAppRemoteActivity(String str, MicroAppInstruction microAppInstruction) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.sendMicroAppRemoteActivity(str, microAppInstruction);
            }
        }

        public int getCommunicatorModeBySerial(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                return ButtonService.this.getActiveCommunicatorBySerial(str);
            }
            return CommunicateMode.IDLE.getValue();
        }

        public int[] getListActiveCommunicator() throws RemoteException {
            return ButtonService.this.getActiveListCommunicator();
        }

        public void simulateDisconnection(String str, int i, int i2, int i3, int i4) {
            if (ButtonService.this.isBleSupported(str)) {
                ButtonService.this.simulateDisconnection(str, i, i2, i3, i4);
            }
        }

        public void simulatePusherEvent(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                BleCommunicator communicator = CommunicateManager.getInstance(ButtonService.this).getCommunicator(str, ButtonService.this);
                if (communicator != null) {
                    communicator.simulatePusherEvent(i, i2, i3, i4, i5);
                }
            }
        }

        public void resetDeviceSettingToDefault(String str) throws RemoteException {
            if (ButtonService.this.isBleSupported(str)) {
                BleCommunicator communicator = CommunicateManager.getInstance(ButtonService.this).getCommunicator(str, ButtonService.this);
                if (communicator != null) {
                    communicator.resetDeviceSettingInFirmwareToDefault();
                }
            }
        }
    }

    public static void init(String str, String str2, BRAND brand, String str3) {
        LogSessionUploader logSessionAutomaticUploader = new LogSessionAutomaticUploader();
        logSessionAutomaticUploader.setAccessKey(str);
        if (!TextUtils.isEmpty(str2)) {
            logSessionAutomaticUploader.setEndPoint(str2);
        }
        SDKSetting.setLogSessionUploader(logSessionAutomaticUploader);
        fossilBrand = brand;
        appInfo = AppInfo.convertJsonToObject(str3);
    }

    public static void broadcastAnalyticEvent(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("message", str);
        intent.setAction(ACTION_ANALYTIC_EVENT);
        context.sendBroadcast(intent);
    }

    public static List<String> getSupportedDevices(BRAND brand) {
        int i = 0;
        List<String> arrayList = new ArrayList();
        arrayList.add(SupportedDevice.SAM.getName());
        arrayList.add(SupportedDevice.SAM_FACTORY.getName());
        SupportedDevice[] values;
        int length;
        if (brand != null) {
            switch (8.$SwitchMap$com$misfit$frameworks$buttonservice$utils$FossilDeviceSerialPatternUtil$BRAND[brand.ordinal()]) {
                case 1:
                    arrayList.add(SupportedDevice.SAM_CHAP.getName());
                    arrayList.add(SupportedDevice.SAM_CHAP_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_CHAP_FULL_NEW.getName());
                    break;
                case 2:
                    arrayList.add(SupportedDevice.SAM_DIESEL.getName());
                    arrayList.add(SupportedDevice.SAM_DIESEL_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_DIESEL_FULL_NEW.getName());
                    break;
                case 3:
                    arrayList.add(SupportedDevice.SAM_ARMANI.getName());
                    arrayList.add(SupportedDevice.SAM_ARMANI_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_ARMANI_FULL_NEW.getName());
                    break;
                case 4:
                    arrayList.add(SupportedDevice.SAM_FOSSIL.getName());
                    arrayList.add(SupportedDevice.SAM_FOSSIL_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_FOSSIL_FULL_NEW.getName());
                    arrayList.add(SupportedDevice.QMOTION.getName());
                    break;
                case 5:
                    arrayList.add(SupportedDevice.SAM_KATE_SPADE.getName());
                    arrayList.add(SupportedDevice.SAM_KATE_SPADE_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_KATE_SPADE_FULL_NEW.getName());
                    arrayList.add(SupportedDevice.KATE_SPADE.getName());
                    break;
                case 6:
                    arrayList.add(SupportedDevice.SAM_MICHAEL_KORS.getName());
                    arrayList.add(SupportedDevice.SAM_MK_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_MK_FULL_NEW.getName());
                    arrayList.add(SupportedDevice.MICHAEL_KORS.getName());
                    break;
                case 7:
                    arrayList.add(SupportedDevice.SAM_SKAGEN.getName());
                    arrayList.add(SupportedDevice.SAM_SKAGEN_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_SKAGEN_FULL_NEW.getName());
                    break;
                case 8:
                    arrayList.add(SupportedDevice.SAM_ARMANI_EXCHANGE.getName());
                    arrayList.add(SupportedDevice.SAM_ARMANI_EXCHANGE_FULL_OLD.getName());
                    arrayList.add(SupportedDevice.SAM_ARMANI_EXCHANGE_FULL_NEW.getName());
                    break;
                case 9:
                    arrayList.add(SupportedDevice.SAM_RELIC.getName());
                    arrayList.add(SupportedDevice.SAM_RELIC_FULL_NEW.getName());
                    break;
                case 10:
                    arrayList.add(SupportedDevice.SAM_MARC_JACOBS.getName());
                    arrayList.add(SupportedDevice.SAM_MARC_JACOBS_FULL_NEW.getName());
                    break;
                default:
                    values = SupportedDevice.values();
                    length = values.length;
                    while (i < length) {
                        arrayList.add(values[i].getName());
                        i++;
                    }
                    break;
            }
        }
        values = SupportedDevice.values();
        length = values.length;
        while (i < length) {
            arrayList.add(values[i].getName());
            i++;
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".getSupportedDevices=" + arrayList);
        return arrayList;
    }

    public static String getMSLVersion() {
        return MSLSetting.getMSLVersion();
    }

    public static String getSDKVersion() {
        return SDKSetting.getSDKVersion();
    }

    public static AppInfo getAppInfo() {
        return appInfo;
    }

    public IBinder onBind(Intent intent) {
        return this.buttonServiceHub;
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void onCreate() {
        super.onCreate();
        this.thread.start();
        registerTimeZoneChangeEvent();
        MFLogger.initialize(this, "BLE");
        MicroAppEventLogger.initialize(this);
        SDKSetting.setFirmwareModuleEnabled(false);
        MSLSetting.preload();
        this.userId = SharePreferencesUtils.getInstance(this).getString(USER_ID);
        if (appInfo == null) {
            appInfo = AppInfo.convertJsonToObject(SharePreferencesUtils.getInstance(this).getString(APP_INFO));
        }
        MFLogger.m12670d(TAG, "---------- userId=" + this.userId);
        if (TextUtils.isEmpty(this.userId)) {
            this.userId = TextUtils.isEmpty(SDKSetting.getUserId()) ? "example@misfit.com" : SDKSetting.getUserId();
        }
        updateUserId(this.userId);
        SDKSetting.setSupportedDeviceNames(getSupportedDevices(fossilBrand));
        this.scannedDevices = new ConcurrentHashMap();
        this.deviceList = new ConcurrentHashMap();
        this.connectQueue = new HashSet();
        this.scanServiceInstance = new ScanServiceInstance(this, this);
        MFLogger.m12671e(TAG, "---Inside .onCreate current all button is " + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        initReceiverActionWithPackageName();
        registerReceiver(this.bluetoothReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        connectAllButton();
    }

    public void onDestroy() {
        super.onDestroy();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onDestroy");
        unregisterReceiver(this.bluetoothReceiver);
        unregisterReceiver(this.timeZoneChangeReceiver);
        this.thread.interrupt();
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onTaskRemoved");
        for (String str : this.deviceList.keySet()) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            addLogToActiveLog(str, "App task is removed. Interrupt current session.");
            communicator.interruptCurrentSession();
        }
        sendBroadcast(new Intent("RestartButtonService"));
        MFLogManager.getInstance(this).stopLogService(FailureCode.USER_KILL_APP_FROM_TASK_MANAGER);
    }

    public void broadcastServiceBlePhaseEvent(String str, CommunicateMode communicateMode, ServiceActionResult serviceActionResult, Bundle bundle) {
        broadcastServiceBlePhaseEvent(str, communicateMode, serviceActionResult, -1, bundle);
    }

    public void broadcastServiceBlePhaseEvent(String str, CommunicateMode communicateMode, ServiceActionResult serviceActionResult, int i, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.putExtra(SERVICE_BLE_PHASE, communicateMode.ordinal());
        intent.putExtra(SERVICE_ACTION_RESULT, serviceActionResult.ordinal());
        intent.putExtra(LAST_DEVICE_ERROR_STATE, i);
        intent.putIntegerArrayListExtra(LIST_ERROR_STATE, createListErrorState(i));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setAction(ACTION_SERVICE_BLE_RESPONSE);
        MFLogger.m12670d(TAG, "Broadcast " + communicateMode + ", result=" + serviceActionResult + ", intent=" + intent);
        sendBroadcast(intent);
    }

    public void broadcastDeviceScanFound(ShineDevice shineDevice, int i) {
        Intent intent = new Intent();
        intent.putExtra(Constants.DEVICE, Parcels.wrap(shineDevice));
        intent.putExtra(Constants.RSSI, i);
        intent.setAction(ACTION_SCAN_DEVICE_FOUND);
        sendBroadcast(intent);
    }

    public void broadcastOTAEvent(OtaEvent otaEvent) {
        MFLogger.m12673v(TAG, "process : " + otaEvent.getSerial() + String.format(" %.1f", new Object[]{Float.valueOf(otaEvent.getProcess())}));
        Parcelable wrap = Parcels.wrap(otaEvent);
        Intent intent = new Intent();
        intent.putExtra(Constants.OTA_PROCESS, wrap);
        intent.setAction(ACTION_OTA_PROGRESS);
        sendBroadcast(intent);
    }

    public void broadcastStreamingStop(String str) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.setAction(ACTION_STREAMING_STOP);
        sendBroadcast(intent);
    }

    public void broadcastStreamingEvent(String str, Gesture gesture) {
        Intent intent = new Intent();
        intent.putExtra("gesture", gesture.getValue());
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.setAction(ACTION_SERVICE_STREAMING_EVENT);
        sendBroadcast(intent);
    }

    public void broadcastMicroAppEvent(int i, int i2, Gesture gesture, String str) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.putExtra("gesture", gesture.getValue());
        intent.putExtra(Constants.MICRO_APP_ID, i);
        intent.putExtra(Constants.VARIANT_ID, i2);
        intent.setAction(ACTION_SERVICE_MICRO_APP_EVENT);
        sendBroadcast(intent);
    }

    public void broadcastMicroAppCancelEvent(int i, int i2, Gesture gesture, String str) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.putExtra("gesture", gesture.getValue());
        intent.putExtra(Constants.MICRO_APP_ID, i);
        intent.putExtra(Constants.VARIANT_ID, i2);
        intent.setAction(ACTION_SERVICE_MICRO_APP_CANCEL_EVENT);
        sendBroadcast(intent);
    }

    public void broadcastConnectionStateChange(String str, ConnectionStateChange connectionStateChange) {
        Intent intent = new Intent();
        intent.putExtra(Constants.CONNECTION_STATE, connectionStateChange.ordinal());
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.setAction(ACTION_CONNECTION_STATE_CHANGE);
        sendBroadcast(intent);
    }

    public void broadcastLocationChanged(Location location) {
        Intent intent = new Intent();
        intent.setAction(ACTION_LOCATION_CHANGED);
        intent.putExtra(Constants.LON, location.getLongitude());
        intent.putExtra(Constants.LAT, location.getLatitude());
        sendBroadcast(intent);
    }

    public void broadcastHeartBeatData(int i, int i2, String str) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SERIAL_NUMBER, str);
        intent.putExtra(Constants.DAILY_STEPS, i);
        intent.putExtra(Constants.DAILY_POINTS, i2);
        intent.putExtra(Constants.UPDATED_TIME, Calendar.getInstance().getTimeInMillis());
        intent.setAction(ACTION_SERVICE_HEARTBEAT_DATA);
        sendBroadcast(intent);
    }

    public void onSuccess(CommunicateMode communicateMode, int i, String str, Bundle bundle) {
    }

    public void onFail(CommunicateMode communicateMode, int i, String str, DeviceTask deviceTask, DeviceErrorState deviceErrorState) {
    }

    public void onHidConnectionStateChanged(String str, int i) {
        List allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        if (TextUtils.isEmpty(str) || !(allActiveButtonSerial == null || allActiveButtonSerial.contains(str))) {
            MFLogger.m12672i(TAG, "Inside " + TAG + ".onHidConnectionStateChanged - " + str + " is not active device");
            return;
        }
        MisfitDeviceProfile deviceProfile = getDeviceProfile(str);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onHidConnectionStateChanged - profile=" + deviceProfile + ", gatt=" + (deviceProfile != null ? Integer.valueOf(deviceProfile.getGattState()) : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE) + ", hidState: " + i);
        if (deviceProfile != null) {
            deviceProfile.setHidState(i);
        }
        if (reconnectRequired(CommunicateManager.getInstance(this).getCommunicator(str, this).getGattState(), i)) {
            new Handler(getMainLooper()).postDelayed(new 3(this, str), 1000);
        }
        if (i == 2) {
            broadcastConnectionStateChange(str, ConnectionStateChange.HID_ON);
        } else if (i == 0) {
            broadcastConnectionStateChange(str, ConnectionStateChange.HID_OFF);
        }
    }

    public void onStreamingButtonEvent(int i, String str) {
        broadcastStreamingEvent(str, GestureConvertUtils.convertFromSDKEventToGesture(i));
    }

    public void onMicroAppEvent(int i, int i2, int i3, String str) {
        broadcastMicroAppEvent(i, i2, GestureConvertUtils.convertFromMicroAppSDKEventToGesture(i3), str);
    }

    public void onMicroAppCancelEvent(int i, int i2, int i3, String str) {
        broadcastMicroAppCancelEvent(i, i2, GestureConvertUtils.convertFromMicroAppSDKEventToGesture(i3), str);
    }

    public void onHeartBeatDataReceived(int i, int i2, String str) {
        broadcastHeartBeatData(i, i2, str);
    }

    public void onGattConnectionStateChanged(String str, int i) {
        MFLogger.m12670d(TAG, "---Inside " + TAG + ".onGattConnectionStateChanged serial=" + str + ", state=" + i + ", deviceList=" + Arrays.toString(this.deviceList.keySet().toArray()));
        if (str == null || !this.deviceList.containsKey(str)) {
            MFLogger.m12672i(TAG, "Inside " + TAG + ".onGattConnectionStateChanged - " + str + " is not active device");
            return;
        }
        MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) this.deviceList.get(str);
        if (misfitDeviceProfile != null) {
            misfitDeviceProfile.setGattState(i);
        }
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        boolean isDeviceReady = communicator.isDeviceReady();
        if (i == 2) {
            saveMacAddressToCache(str, communicator.getBleAdapter().getMacAddress());
            if (isDeviceReady) {
                broadcastConnectionStateChange(str, ConnectionStateChange.GATT_ON);
            }
        } else if (i == 0) {
            broadcastConnectionStateChange(str, ConnectionStateChange.GATT_OFF);
        }
    }

    public void onTriggerConnectWithoutTimeout(String str) {
        if (str == null || !this.deviceList.containsKey(str)) {
            MFLogger.m12672i(TAG, "Inside " + TAG + ".onTriggerConnectWithoutTimeout - " + str + " is not active device. No call connect without timeout.");
            return;
        }
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        Object obj = (defaultAdapter == null || !defaultAdapter.isEnabled()) ? null : 1;
        if (communicator != null && obj != null && communicator.isQueueEmpty()) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".onTriggerConnectWithoutTimeout - connection is close and session queue is empty. Connect without timeout.");
            communicator.startConnectWithoutTimeout();
        }
    }

    public void onCommunicatorResult(CommunicateMode communicateMode, String str, int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "onCommunicatorResult - serial=" + str + ", mode=" + communicateMode + ", success=" + (i == 0));
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        if (i == 0) {
            switch (8.$SwitchMap$com$misfit$frameworks$buttonservice$communite$CommunicateMode[communicateMode.ordinal()]) {
                case 1:
                    if (bundle != null) {
                        MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) bundle.getParcelable(Constants.DEVICE);
                        if (misfitDeviceProfile != null) {
                            MFLogger.m12670d(TAG, "Inside " + TAG + ".onCommunicatorResult - Add new device to deviceList - profile=" + misfitDeviceProfile.toString());
                            this.deviceList.put(str, misfitDeviceProfile);
                        }
                    }
                    for (String str2 : DevicePreferenceUtils.getAllActiveButtonSerial(this)) {
                        if (!str2.equalsIgnoreCase(str)) {
                            deviceDisconnect(str2);
                        }
                    }
                    DevicePreferenceUtils.addActiveButtonSerial(this, str);
                    DevicePreferenceUtils.addPairedButtonSerial(this, str);
                    communicator.resetSettingFlagsToDefault();
                    onGattConnectionStateChanged(str, 2);
                    break;
                case 2:
                    DevicePreferenceUtils.removePairedButtonSerial(this, str);
                    DevicePreferenceUtils.removeActiveButtonSerial(this, str);
                    communicator.clearMappingsAndSettingFlags();
                    clearDeviceData(str);
                    break;
            }
        }
        broadcastServiceBlePhaseEvent(str, communicateMode, i == 0 ? ServiceActionResult.SUCCEEDED : ServiceActionResult.FAILED, i, bundle);
    }

    public void onReceivedSyncData(String str, Bundle bundle) {
        broadcastServiceBlePhaseEvent(str, CommunicateMode.SYNC, ServiceActionResult.RECEIVED_DATA, bundle);
    }

    public void onOtaProgressUpdated(String str, float f) {
        broadcastOTAEvent(new OtaEvent(str, f));
    }

    public void onPreparationCompleted(boolean z, String str) {
        MFLogger.m12672i(TAG, "Inside " + TAG + ".onPreparationCompleted - serial=" + str + ", success=" + z);
        if (z) {
            MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) this.deviceList.get(str);
            if (misfitDeviceProfile != null) {
                misfitDeviceProfile.setDeviceModel(CommunicateManager.getInstance(this).getDeviceModel(str));
                misfitDeviceProfile.setFirmwareVersion(CommunicateManager.getInstance(this).getFirmwareVersion(str));
                misfitDeviceProfile.setBatteryLevel(CommunicateManager.getInstance(this).getBatteryLevel(str));
                misfitDeviceProfile.setMicroAppMajorVersion(CommunicateManager.getInstance(this).getMicroAppMajorVersion(str));
                misfitDeviceProfile.setMicroAppMinorVersion(CommunicateManager.getInstance(this).getMicroAppMinorVersion(str));
                this.deviceList.put(str, misfitDeviceProfile);
                broadcastConnectionStateChange(str, ConnectionStateChange.GATT_ON);
            }
        }
    }

    public boolean isBleSupported(String str) {
        return (BluetoothAdapter.getDefaultAdapter() == null || FossilDeviceSerialPatternUtil.isGen1Device(str)) ? false : true;
    }

    public boolean isBleSupported() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    public void connectAllButton() {
        if (this.deviceList == null) {
            this.deviceList = new ConcurrentHashMap();
        }
        List<String> allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        MFLogger.m12670d(TAG, "num button user is " + allActiveButtonSerial.size());
        for (String str : allActiveButtonSerial) {
            if (!this.deviceList.keySet().contains(str)) {
                enqueue(str);
            } else if (((MisfitDeviceProfile) this.deviceList.get(str)).getGattState() != 2) {
                enqueue(str);
            }
        }
    }

    public long deviceReconnect(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (isInActiveDeviceList(str)) {
            MFLogger.m12670d(TAG, "---Inside .deviceReconnect with " + str + ", macAddress=" + getMacAddressFromCache(str));
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            if (getGattState(str) == 0) {
                communicator.startConnectionDeviceSession();
                return currentTimeMillis;
            }
            MFLogger.m12670d(TAG, "---Inside .deviceReconnect with " + str + ", device is still connected, no need to reconnect");
        } else {
            MFLogger.m12670d(TAG, "---Inside .deviceReconnect with " + str + ". It is not active device, unallow to reconnect.");
        }
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long pairDevice(String str, String str2) {
        MFLogger.m12670d(TAG, "---Inside .pairDevice with " + str + ", macAddress=" + str2);
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, str2, this);
        long currentTimeMillis = System.currentTimeMillis();
        saveMacAddressToCache(str, str2);
        communicator.startPairingSession();
        return currentTimeMillis;
    }

    public void deviceDisconnect(String str) {
        if (!TextUtils.isEmpty(str)) {
            MFLogger.m12670d(TAG, "---Inside .deviceDisconnect with " + str + " current active device is " + DevicePreferenceUtils.getAllActiveButtonSerial(this).size());
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            addLogToActiveLog(str, "Device is forced to disconnect, terminate current session.");
            clearDeviceData(str);
            communicator.closeConnection();
        }
    }

    public long deviceUnlink(String str) {
        MFLogger.m12670d(TAG, "---Inside .deviceUnlink with " + str);
        if (TextUtils.isEmpty(str)) {
            return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        long currentTimeMillis = System.currentTimeMillis();
        if (communicator != null) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceUnlink");
            addLogToActiveLog(str, "Device is unlinked. Terminate current session if exist.");
            communicator.startUnlinkSession();
        } else {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deviceUnlink - communicator is NULL");
            currentTimeMillis = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        return currentTimeMillis;
    }

    public boolean switchActiveDevice(String str, UserProfile userProfile) {
        if (TextUtils.isEmpty(str)) {
            disconnectAllButton();
            setActiveSerial(str, getMacAddressFromCache(str));
            return true;
        } else if (isInPairedDeviceList(str)) {
            MFLogger.m12670d(TAG, "---Inside .switchActiveDevice to " + str + " executed.");
            userProfile.isNewDevice = true;
            userProfile.syncMode = 13;
            disconnectAllButton();
            setActiveSerial(str, getMacAddressFromCache(str));
            CommunicateManager.getInstance(this).getCommunicator(str, this).resetSettingFlagsToDefault();
            deviceStartSync(str, userProfile);
            return true;
        } else {
            MFLogger.m12670d(TAG, "---Inside .switchActiveDevice to " + str + ". It is unallowed caused by " + str + " is not in paired device list:" + DevicePreferenceUtils.getAllPairedButtonSerial(this));
            return false;
        }
    }

    public long deviceStartSync(String str, UserProfile userProfile) {
        if (userProfile.syncMode == 14) {
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SYNC, ServiceActionResult.UNALLOWED_ACTION, new Bundle());
            return System.currentTimeMillis();
        } else if (isInActiveDeviceList(str)) {
            MFLogger.m12670d(TAG, "---Inside .deviceStartSync with " + str);
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            new Handler(Looper.getMainLooper()).post(new 5(this, str, communicator, userProfile));
            return currentTimeMillis;
        } else {
            MFLogger.m12670d(TAG, "---Inside .deviceStartSync with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SYNC, ServiceActionResult.UNALLOWED_ACTION, new Bundle());
            return System.currentTimeMillis();
        }
    }

    public void updatePercentageGoalProgress(String str, boolean z, int i, int i2) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceUpdateProgressGoal - currentSteps=" + i + ", goalSteps=" + i2);
            BleSession currentSession = communicator.getCurrentSession();
            if (currentSession != null && (currentSession instanceof SyncSession)) {
                ((SyncSession) currentSession).updateCurrentStepAndStepGoalFromApp(z, (long) i, (long) i2);
                return;
            }
            return;
        }
        MFLogger.m12670d(TAG, "---Inside .updatePercentageGoalProgress with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
    }

    public long deviceStartHWLogSync(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            boolean isBluetoothEnable = BluetoothUtils.isBluetoothEnable();
            boolean isLocationEnable = LocationUtils.isLocationEnable(this);
            boolean isLocationPermissionGranted = LocationUtils.isLocationPermissionGranted(this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceStartSync, isBluetoothOn=" + isBluetoothEnable + ", isLocationPermissionOn=" + isLocationPermissionGranted + ", isLocationServiceOn=" + isLocationEnable);
            if (!isBluetoothEnable || !isLocationPermissionGranted) {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceStartHWLogSync, bluetooth or location is off, ignore HWLogSync");
                return currentTimeMillis;
            } else if (communicator.startHWLogSyncSession()) {
                return currentTimeMillis;
            } else {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceStartHWLogSync - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.HW_LOG_SYNC, ServiceActionResult.FAILED, null);
                return currentTimeMillis;
            }
        }
        MFLogger.m12670d(TAG, "---Inside .deviceStartHWLogSync with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public void deleteDataFiles(List<String> list) {
        try {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deleteDataFile - count=" + list.size());
            for (String str : list) {
                MFLogger.m12670d(TAG, "deleteDataFile - id=" + str);
                DataFileProvider.getInstance(this).deleteDataFile(DataFileProvider.getInstance(this).getDataFile(str));
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deleteDataFile - DONE - count=" + list.size());
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deleteDataFile - e=" + e);
        }
    }

    public long devicePlayAnimation(String str) {
        if (isInActiveDeviceList(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".devicePlayAnimation - serial=" + str);
            if (communicator.startPlayAnimationSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayAnimation - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.PLAY_LED_ANIMATION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .devicePlayAnimation with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceReadRealTimeStep(String str) {
        if (isInActiveDeviceList(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceReadRealTimeStep - serial=" + str);
            if (communicator.startReadRealTimeStepSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceReadRealTimeStep - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.READ_REAL_TIME_STEP, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceReadRealTimeStep with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceUpdateGoalStep(String str, int i) {
        if (isInActiveDeviceList(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceUpdateGoalStep - serial=" + str + ", stepGoal=" + i);
            if (communicator.startSetStepGoal(i)) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceUpdateGoalStep - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_STEP_GOAL, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceUpdateGoalStep with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetBatteryLevel(String str) {
        if (isInActiveDeviceList(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetBattery - serial=" + str);
            if (communicator.startGetBatteryLevelSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetBattery - Device is BUSY, using cached configuration");
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.BATTERY, CommunicateManager.getInstance(this).getBatteryLevel(str));
            broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_BATTERY_LEVEL, ServiceActionResult.SUCCEEDED, bundle);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceGetBatteryLevel with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetRssi(String str) {
        long j = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        if (!TextUtils.isEmpty(str)) {
            if (isInActiveDeviceList(str)) {
                BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
                j = System.currentTimeMillis();
                MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetRssi - serial=" + str);
                if (!communicator.startGetRssiSession()) {
                    MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetRssi - Device is BUSY");
                    broadcastServiceBlePhaseEvent(str, CommunicateMode.READ_RSSI, ServiceActionResult.FAILED, null);
                }
            } else {
                MFLogger.m12670d(TAG, "---Inside .deviceGetRssi with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
            }
        }
        return j;
    }

    public long deviceOta(String str, byte[] bArr, boolean z, String str2, String str3, UserProfile userProfile) {
        MFLogger.m12670d(TAG, "deviceOta - serial=" + str + ", isEmbedded=" + z + ", checksum=" + str2 + ", firmwareVersion=" + str3);
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        long currentTimeMillis = System.currentTimeMillis();
        communicator.startOtaSession(bArr, z, str2, str3, userProfile);
        return currentTimeMillis;
    }

    public List<MisfitDeviceProfile> getPairedDevice() {
        Set<String> hashSet = new HashSet(DevicePreferenceUtils.getAllPairedButtonSerial(this));
        hashSet.addAll(DevicePreferenceUtils.getAllActiveButtonSerial(this));
        List<MisfitDeviceProfile> arrayList = new ArrayList();
        for (String str : hashSet) {
            MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) this.deviceList.get(str);
            if (misfitDeviceProfile != null) {
                arrayList.add(misfitDeviceProfile);
            }
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".getPairedDevice - allDevices=" + hashSet + ", activeDevices=" + DevicePreferenceUtils.getAllActiveButtonSerial(this) + ", profiles=" + arrayList.size());
        return arrayList;
    }

    public MisfitDeviceProfile getDeviceProfile(String str) {
        MisfitDeviceProfile misfitDeviceProfile = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MisfitDeviceProfile misfitDeviceProfile2;
        for (MisfitDeviceProfile misfitDeviceProfile22 : getPairedDevice()) {
            if (!misfitDeviceProfile22.getDeviceSerial().equals(str)) {
                misfitDeviceProfile22 = misfitDeviceProfile;
            }
            misfitDeviceProfile = misfitDeviceProfile22;
        }
        if (misfitDeviceProfile == null) {
            misfitDeviceProfile22 = (MisfitDeviceProfile) this.deviceList.get(str);
        } else {
            misfitDeviceProfile22 = misfitDeviceProfile;
        }
        return misfitDeviceProfile22;
    }

    public int getGattState(String str) {
        MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) this.deviceList.get(str);
        if (misfitDeviceProfile != null) {
            return misfitDeviceProfile.getGattState();
        }
        return 0;
    }

    public int getHIDState(String str) {
        int i;
        List allPairedButtonSerial = DevicePreferenceUtils.getAllPairedButtonSerial(this);
        if (allPairedButtonSerial == null || allPairedButtonSerial.size() <= 0) {
            i = 0;
        } else {
            MisfitDeviceProfile misfitDeviceProfile = (MisfitDeviceProfile) this.deviceList.get(str);
            i = misfitDeviceProfile != null ? misfitDeviceProfile.getHidState() : 0;
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".getHIDState - state=" + i);
        return i;
    }

    public void logOut() {
        MFLogger.m12671e(TAG, "Inside " + TAG + ".logOut - clear all device data.");
        disconnectAllButton();
        this.scannedDevices.clear();
        DevicePreferenceUtils.logOut(this);
        SharePreferencesUtils.getInstance(this).setString(USER_ID, "");
    }

    public boolean isSyncing(String str) {
        boolean z = false;
        for (String str2 : this.deviceList.keySet()) {
            boolean containSyncMode = CommunicateManager.getInstance(this).getCommunicator(str2, this).containSyncMode();
            if (containSyncMode && str2.equalsIgnoreCase(str)) {
                return containSyncMode;
            }
            z = containSyncMode;
        }
        return z;
    }

    public boolean isUpdatingFirmware(String str) {
        if (CommunicateManager.getInstance(this).getCommunicator(str, this).getCommunicateMode() == CommunicateMode.OTA) {
            return true;
        }
        return false;
    }

    public boolean isLinking(String str) {
        if (!TextUtils.isEmpty(str) && CommunicateManager.getInstance(this).getCommunicator(str, this).getCommunicateMode() == CommunicateMode.LINK) {
            return true;
        }
        return false;
    }

    public long devicePlayLightAndVibration(String str, int i, int i2, int i3, int i4) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".devicePlayLightAndVibration - serial=" + str);
            if (communicator.startPlayLightAndVibrationSession(getLedColor(i3), VibeEnum.values()[i4], (byte) i, i2)) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayLightAndVibration - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.PLAY_LIGHT_AND_VIBRATION, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .devicePlayLightAndVibration with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long devicePlayLight(String str, short s, int i, int i2, boolean z) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".devicePlayLight - serial=" + str);
            if (!communicator.startPlayLightSession(new LightVibrationSetting(s, i, getLedColor(i2), z, 0))) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayLight - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.PLAY_LIGHT, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .devicePlayLight with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long devicePlayVibration(String str, short s, int i, boolean z) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".devicePlayVibration - serial=" + str);
            if (!communicator.startPlayVibrationSession(new LightVibrationSetting(s, i, null, z, 0))) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayVibration - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.PLAY_VIBRATION, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .devicePlayVibration with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceSetMapping(String str, List<BLEMapping> list) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetMapping - serial=" + str);
            if (communicator.startSetLinkMappingSession(list)) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetMapping - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_LINK_MAPPING, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetMapping with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceClearMapping(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            List autoMapping = DevicePreferenceUtils.getAutoMapping(this, str);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceClearMapping - serial=" + str);
            if (communicator.startCleanLinkMappingSession(autoMapping)) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetAlarm - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.CLEAN_LINK_MAPPINGS, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceClearMapping with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public void setAutoMapping(String str, List<BLEMapping> list) {
        if (!isInActiveDeviceList(str)) {
            MFLogger.m12670d(TAG, "---Inside .setAutoMapping with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        }
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".setAutoMapping - serial=" + str);
        if (!communicator.startSetAutoMapping(list)) {
            MFLogger.m12671e(TAG, "Inside " + TAG + ".setAutoMapping - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_AUTO_MAPPING, ServiceActionResult.FAILED, null);
        }
    }

    public List<BLEMapping> getAutoMapping(String str) {
        return DevicePreferenceUtils.getAutoMapping(this, str);
    }

    public void clearAutoSetMapping(String str) {
        DevicePreferenceUtils.clearAutoSetMapping(this, str);
    }

    public void setActiveSerial(String str, String str2) {
        MFLogger.m12672i(TAG, "Inside " + TAG + ".setActiveSerial - serial=" + str + ", macAddress=" + str2);
        if (TextUtils.isEmpty(str)) {
            DevicePreferenceUtils.addActiveButtonSerial(this, str);
            this.deviceList.clear();
            return;
        }
        saveMacAddressToCache(str, str2);
        DevicePreferenceUtils.addActiveButtonSerial(this, str);
        this.deviceList.put(str, MisfitDeviceProfile.cloneFrom(CommunicateManager.getInstance(this).getCommunicator(str, str2, this).getBleAdapter()));
        MFLogger.m12670d(TAG, "Inside " + TAG + ".setActiveSerial - serial=" + str + ", activeDevices=" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
    }

    public void setPairedDevice(String str, String str2) {
        MFLogger.m12672i(TAG, "Inside " + TAG + ".setPairedDevice=" + str + ", macAddress=" + str2);
        saveMacAddressToCache(str, str2);
        DevicePreferenceUtils.addPairedButtonSerial(this, str);
    }

    public long deviceStartCalibration(String str) {
        long currentTimeMillis;
        Exception e;
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceStartCalibration");
        try {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            currentTimeMillis = System.currentTimeMillis();
            try {
                if (!communicator.startCalibrationSession()) {
                    MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceStartCalibration - Device is BUSY");
                    broadcastServiceBlePhaseEvent(str, CommunicateMode.ENTER_CALIBRATION, ServiceActionResult.FAILED, null);
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return currentTimeMillis;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            currentTimeMillis = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
            e = exception;
            e.printStackTrace();
            return currentTimeMillis;
        }
        return currentTimeMillis;
    }

    public void deviceMovingHand(String str, int i, HandId handId, MovingType movingType, Direction direction, Speed speed) {
        try {
            BleSession currentSession = CommunicateManager.getInstance(this).getCommunicator(str, this).getCurrentSession();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceMovingHand - currentSession=" + currentSession);
            if (currentSession != null && (currentSession instanceof WatchCalibrationSession)) {
                ((WatchCalibrationSession) currentSession).handleMoveHandRequest(handId, movingType, direction, speed, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long deviceResetHandsToZeroDegree(String str) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceResetHandsToZeroDegree");
        long j = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            BleSession currentSession = CommunicateManager.getInstance(this).getCommunicator(str, this).getCurrentSession();
            if (currentSession != null && (currentSession instanceof WatchCalibrationSession)) {
                j = System.currentTimeMillis();
                ((WatchCalibrationSession) currentSession).handleResetHandsPosition();
            }
            return j;
        } catch (Exception e) {
            Exception exception = e;
            long j2 = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
            exception.printStackTrace();
            return j2;
        }
    }

    public long deviceCompleteCalibration(String str) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceCompleteCalibration");
        long j = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        try {
            BleSession currentSession = CommunicateManager.getInstance(this).getCommunicator(str, this).getCurrentSession();
            if (currentSession != null && (currentSession instanceof WatchCalibrationSession)) {
                j = System.currentTimeMillis();
                ((WatchCalibrationSession) currentSession).handleApplyHandsPosition();
            }
            return j;
        } catch (Exception e) {
            Exception exception = e;
            long j2 = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
            exception.printStackTrace();
            return j2;
        }
    }

    public long cancelCalibration(String str) {
        long currentTimeMillis;
        Exception e;
        try {
            currentTimeMillis = System.currentTimeMillis();
            try {
                CommunicateManager.getInstance(this).getCommunicator(str, this).cancelCalibrationSession();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return currentTimeMillis;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            currentTimeMillis = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
            e = exception;
            e.printStackTrace();
            return currentTimeMillis;
        }
        return currentTimeMillis;
    }

    public void interrupt(String str) {
        if (!TextUtils.isEmpty(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            if (communicator.getCommunicateMode() == CommunicateMode.LINK) {
                Log.e(TAG, "Interrupt " + str);
                MFLog activeLog = MFLogManager.getInstance(this).getActiveLog(str);
                if (activeLog != null) {
                    activeLog.log("Setup session " + str + ". User cancelled");
                }
                onFail(CommunicateMode.LINK, -1, str, DeviceTask.UNKNOWN, DeviceErrorState.UNKNOWN_ERROR);
                DevicePreferenceUtils.removeActiveButtonSerial(this, str);
                clearDeviceData(str);
            }
            addLogToActiveLog(str, "App calls interrupt.");
            communicator.interruptCurrentSession();
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".interrupt - serial=" + str + ", activeDevices=" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
    }

    public long disableGoalTracking(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".disableGoalTracking - serial=" + str);
            if (communicator.startDisableGoalTrackingSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".setGoalTrackingEnable - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.DISABLE_GOAL_TRACKING, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .disableGoalTracking with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceSetSecondTimeZone(String str, String str2) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetSecondTimeZone - timezoneId=" + str2);
            if (communicator.startSetSecondTimezoneSession(str2)) {
                return currentTimeMillis;
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetSecondTimeZone - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_SECOND_TIMEZONE, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetSecondTimeZone with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetSecondTimezone(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetSecondTimezone");
            if (communicator.startGetSecondTimezoneSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetSecondTimezone - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_SECOND_TIMEZONE, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceGetSecondTimezone with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public void deviceSetAutoSecondTimezone(String str) {
        List allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        if (allActiveButtonSerial == null || allActiveButtonSerial.isEmpty()) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoSecondTimezone: " + str + " cannot set caused by no active device.");
            return;
        }
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoSecondTimezone: " + str);
        String str2 = (String) allActiveButtonSerial.get(0);
        if (!CommunicateManager.getInstance(this).getCommunicator(str2, this).startSetAutoSecondTimezone(str)) {
            broadcastServiceBlePhaseEvent(str2, CommunicateMode.SET_AUTO_SECOND_TIMEZONE, ServiceActionResult.FAILED, null);
        }
    }

    public void deviceClearAutoSecondTimezone() {
        DevicePreferenceUtils.clearAutoSecondTimezone(this);
    }

    public long deviceClearAllAlarm(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceClearAllAlarm");
            if (communicator.startClearAllAlarmsSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceClearAllAlarm - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.CLEAR_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceClearAllAlarm with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceSetAlarm(String str, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (isInActiveDeviceList(str)) {
            AlarmSettings alarmSettings;
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            short shortValue = Integer.valueOf(i).shortValue();
            short shortValue2 = Integer.valueOf(i2).shortValue();
            short shortValue3 = Integer.valueOf(i5).shortValue();
            LED led = new LED(Integer.valueOf(0).shortValue());
            Vibe vibe = new Vibe(Integer.valueOf(3).shortValue());
            Sound sound = new Sound(Integer.valueOf(0).shortValue());
            short shortValue4 = Integer.valueOf(i4).shortValue();
            short shortValue5 = Integer.valueOf(i3).shortValue();
            if (z) {
                alarmSettings = new AlarmSettings(AlarmSettings.ALL_DAYS, (byte) 1, (byte) 2, shortValue, shortValue2, shortValue3, led, vibe, sound, shortValue4, shortValue5);
            } else {
                alarmSettings = new AlarmSettings(AlarmSettings.ALL_DAYS, (byte) 1, (byte) 1, shortValue, shortValue2, shortValue3, led, vibe, sound, shortValue4, shortValue5);
            }
            Log.e(TAG, "Inside " + TAG + ".deviceSetAlarm - Start set alarms with hour: " + alarmSettings.getAlarmHour() + ", minute: " + alarmSettings.getAlarmMinute() + ", alarmDuration: " + alarmSettings.getAlarmDuration() + ", alarmOperation: " + alarmSettings.getAlarmOperation() + ", alarmDay: " + alarmSettings.getAlarmDay() + ", alarmSnooze: " + alarmSettings.getSnoozeTimeInMinute() + ", alarmSmart: " + alarmSettings.getWindowInMinute());
            if (!communicator.startSetAlarmSession(alarmSettings)) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetAlarm - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_ALARM, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetAlarm with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetAlarm(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetAlarm");
            if (communicator.startGetAlarmSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetAlarm - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceGetAlarm with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceSetListAlarm(String str, List<Alarm> list) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetListAlarm");
            if (communicator.startSetMultipleAlarmsSession(convertAlarmsToMultipleAlarms(list))) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetListAlarm - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_LIST_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetListAlarm with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceVerifyListAlarm(String str, int i) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceVerifyListAlarm");
            if (communicator.startVerifyMultipleAlarmsSession(i)) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceVerifyListAlarm - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.VERIFY_LIST_ALARM, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceVerifyListAlarm with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public void deviceSetAutoAlarmSetting(int i, int i2, int i3, int i4, int i5, boolean z) {
        AlarmSettings alarmSettings;
        short shortValue = Integer.valueOf(i).shortValue();
        short shortValue2 = Integer.valueOf(i2).shortValue();
        short shortValue3 = Integer.valueOf(i5).shortValue();
        LED led = new LED(Integer.valueOf(0).shortValue());
        Vibe vibe = new Vibe(Integer.valueOf(3).shortValue());
        Sound sound = new Sound(Integer.valueOf(0).shortValue());
        short shortValue4 = Integer.valueOf(i4).shortValue();
        short shortValue5 = Integer.valueOf(i3).shortValue();
        if (z) {
            alarmSettings = new AlarmSettings(AlarmSettings.ALL_DAYS, (byte) 1, (byte) 2, shortValue, shortValue2, shortValue3, led, vibe, sound, shortValue4, shortValue5);
        } else {
            alarmSettings = new AlarmSettings(AlarmSettings.ALL_DAYS, (byte) 1, (byte) 1, shortValue, shortValue2, shortValue3, led, vibe, sound, shortValue4, shortValue5);
        }
        List allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoAlarmSetting, hour=" + i + ", minute=" + i2 + ", duration=" + i3 + ", snoozeTime=" + i4 + ", smartAlarmMins=" + i5 + ", isRepeat=" + z);
        if (allActiveButtonSerial == null || allActiveButtonSerial.isEmpty()) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoAlarmSetting cannot set caused by no active device.");
            return;
        }
        String str = (String) allActiveButtonSerial.get(0);
        if (!CommunicateManager.getInstance(this).getCommunicator(str, this).startSetAutoSingleAlarm(alarmSettings)) {
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_AUTO_SINGLE_ALARM, ServiceActionResult.FAILED, null);
        }
    }

    public void deviceClearAutoAlarmSetting() {
        DevicePreferenceUtils.clearAutoAlarmSetting(this);
    }

    public void deviceSetAutoListAlarm(List<Alarm> list) {
        if (list == null) {
            MFLogger.m12670d(TAG, ".deviceSetAutoListAlarm - Alarm list is NULL");
            return;
        }
        List convertAlarmsToMultipleAlarms = convertAlarmsToMultipleAlarms(list);
        List allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoListAlarm, size=" + convertAlarmsToMultipleAlarms.size() + ", objects=" + convertAlarmsToMultipleAlarms);
        if (allActiveButtonSerial == null || allActiveButtonSerial.isEmpty()) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoListAlarm cannot set caused by no active device.");
            return;
        }
        String str = (String) allActiveButtonSerial.get(0);
        if (!CommunicateManager.getInstance(this).getCommunicator(str, this).startSetAutoMultiAlarms(convertAlarmsToMultipleAlarms)) {
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_AUTO_MULTI_ALARM, ServiceActionResult.FAILED, null);
        }
    }

    public void deviceClearAutoListAlarm() {
        DevicePreferenceUtils.clearAutoListAlarm(this);
    }

    public long devicePlayHandsNotification(String str, int i, int[] iArr, int[] iArr2, int i2, boolean z) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            List arrayList = new ArrayList();
            if (iArr != null && iArr.length > 0) {
                for (int fromValue : iArr) {
                    arrayList.add(HandId.fromValue(fromValue));
                }
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".devicePlayHandsNotification");
            if (!communicator.startSendNotificationSession(null, (byte) 0, arrayList, VibeEnum.values()[i2], i, iArr2, z)) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayHandsNotification - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.SEND_NOTIFICATION, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .devicePlayHandsNotification with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetVibrationStrength(String str) {
        long j = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        if (!TextUtils.isEmpty(str)) {
            if (isInActiveDeviceList(str)) {
                BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
                j = System.currentTimeMillis();
                MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetVibrationStrength - serial=" + str);
                if (!communicator.startGetVibrationStrengthSession()) {
                    MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetVibrationStrength - Device is BUSY");
                    broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_VIBRATION_STRENGTH, ServiceActionResult.FAILED, null);
                }
            } else {
                MFLogger.m12670d(TAG, "---Inside .deviceGetVibrationStrength with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
            }
        }
        return j;
    }

    public long deviceSetVibrationStrength(String str, int i) {
        long j = TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        if (!TextUtils.isEmpty(str)) {
            if (isInActiveDeviceList(str)) {
                BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
                j = System.currentTimeMillis();
                MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetVibrationStrength - serial=" + str + ", vibrationStrengthLevel=" + i);
                if (!communicator.startSetVibrationStrengthSession((short) i)) {
                    MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetVibrationStrength - Device is BUSY");
                    broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_VIBRATION_STRENGTH, ServiceActionResult.FAILED, null);
                }
            } else {
                MFLogger.m12670d(TAG, "---Inside .deviceSetVibrationStrength with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
            }
        }
        return j;
    }

    public long deviceSetEnableCountDown(String str, long j, long j2) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetEnableCountDown - serial=" + str);
            if (!communicator.startSetCountdownSettingSession(true, j, j2)) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetEnableCountDown - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_COUNTDOWN, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetEnableCountDown with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceSetDisableCountDown(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetDisableCountDown - serial=" + str);
            if (!communicator.startSetCountdownSettingSession(true, -1, -1)) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceSetDisableCountDown - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_COUNTDOWN, ServiceActionResult.FAILED, null);
            }
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceSetDisableCountDown with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public long deviceGetCountDown(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceGetCountDown - serial=" + str);
            if (communicator.startGetCountdownSettingSession()) {
                return currentTimeMillis;
            }
            MFLogger.m12671e(TAG, "Inside " + TAG + ".deviceGetCountDown - Device is BUSY");
            broadcastServiceBlePhaseEvent(str, CommunicateMode.GET_COUNTDOWN, ServiceActionResult.FAILED, null);
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceGetCountDown with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public void deviceSetAutoCountdownSetting(long j, long j2) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoCountdownSetting - startTime=" + j + ", endTime=" + j2);
        List allActiveButtonSerial = DevicePreferenceUtils.getAllActiveButtonSerial(this);
        if (allActiveButtonSerial == null || allActiveButtonSerial.isEmpty()) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceSetAutoCountdownSetting cannot set caused by no active device.");
            return;
        }
        String str = (String) allActiveButtonSerial.get(0);
        if (!CommunicateManager.getInstance(this).getCommunicator(str, this).startSetAutoCountDown(j, j2)) {
            broadcastServiceBlePhaseEvent(str, CommunicateMode.SET_AUTO_COUNT_DOWN, ServiceActionResult.FAILED, null);
        }
    }

    public void deviceClearAutoCountdownSetting() {
        DevicePreferenceUtils.clearAutoCountdownSetting(this);
    }

    public void updateUserId(String str) {
        CharSequence userId = SDKSetting.getUserId();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".updateUserId - Setting userId to SDK - oldUserId=" + this.userId + ", newUserId=" + str + ", sdkUserId=" + userId);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(this.userId) || !str.equals(this.userId)) {
                this.userId = str;
                MSLSetting.preload();
                try {
                    SDKSetting.setUp(getApplicationContext(), this.userId);
                } catch (IllegalStateException e) {
                    sendBroadcast(new Intent(BLUETOOTH_NOT_SUPPORTED));
                }
                MFLogger.m12670d(TAG, "Inside " + TAG + ".updateUserId - Setting userId to SDK. DONE ");
                SharePreferencesUtils.getInstance(this).setString(USER_ID, this.userId);
            }
        }
    }

    public void updateAppInfo(String str) {
        SharePreferencesUtils.getInstance(this).setString(APP_INFO, str);
    }

    public void addLog(int i, String str, String str2) {
        MFLogManager.getInstance(this).addLogForActiveLog(str, str2);
    }

    public int startLog(int i, String str) {
        switch (8.$SwitchMap$com$misfit$frameworks$buttonservice$communite$CommunicateMode[CommunicateMode.values()[i].ordinal()]) {
            case 1:
                return MFLogManager.getInstance(this).startSetupLog(str, fossilBrand).getStartTimeEpoch();
            case 3:
            case 4:
                return MFLogManager.getInstance(this).startSyncLog(str).getStartTimeEpoch();
            case 5:
                return MFLogManager.getInstance(this).startOtaLog(str).getStartTimeEpoch();
            default:
                return -1;
        }
    }

    public int endLog(int i, String str) {
        MFLog end = MFLogManager.getInstance(this).end(CommunicateMode.values()[i], str);
        MFLogger.m12670d(TAG, ".endLog - communicateMode=" + i + ", serial=" + str + ", mfLog=" + end);
        return end != null ? end.getStartTimeEpoch() : 0;
    }

    public void stopLogService(int i) {
        MFLogger.m12670d(TAG, ".stopLogService - failureCode=" + i);
        MFLogManager.getInstance(this).stopLogService(i);
    }

    public void changePendingLogKey(int i, String str, int i2, String str2) {
        MFLogManager.getInstance(this).changePendingLogKey(CommunicateMode.values()[i], str, CommunicateMode.values()[i2], str2);
    }

    public long deviceClearLastNotification(String str) {
        if (isInActiveDeviceList(str)) {
            BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
            long currentTimeMillis = System.currentTimeMillis();
            if (communicator.isBusy()) {
                MFLogger.m12671e(TAG, "Inside " + TAG + ".devicePlayHandsNotification - Device is BUSY");
                broadcastServiceBlePhaseEvent(str, CommunicateMode.CLEAR_LAST_NOTIFICATION, ServiceActionResult.FAILED, null);
                return currentTimeMillis;
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".deviceClearLastNotification");
            communicator.startClearLastNotificationSession();
            return currentTimeMillis;
        }
        MFLogger.m12670d(TAG, "---Inside .deviceClearLastNotification with " + str + " is not allowed caused by this device is not in active list:" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
        return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    private void sendMicroAppRemoteActivity(String str, MicroAppInstruction microAppInstruction) {
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        System.currentTimeMillis();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".sendMicroAppRemoteActivity - serial=" + str + ", microAppInstruction: " + microAppInstruction.toString());
        communicator.sendMicroAppRemoteCommand(microAppInstruction);
    }

    private int[] getActiveListCommunicator() {
        ConcurrentHashMap bleCommunicators = CommunicateManager.getInstance(this).getBleCommunicators();
        if (bleCommunicators == null || bleCommunicators.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList();
        int[] iArr = new int[bleCommunicators.size()];
        for (BleCommunicator communicateMode : bleCommunicators.values()) {
            arrayList.add(Integer.valueOf(communicateMode.getCommunicateMode().getValue()));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    private int getActiveCommunicatorBySerial(String str) {
        ConcurrentHashMap bleCommunicators = CommunicateManager.getInstance(this).getBleCommunicators();
        if (bleCommunicators == null || bleCommunicators.isEmpty()) {
            return CommunicateMode.IDLE.getValue();
        }
        BleCommunicator bleCommunicator = (BleCommunicator) bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return CommunicateMode.IDLE.getValue();
        }
        return bleCommunicator.getCommunicateMode().getValue();
    }

    private void simulateDisconnection(String str, int i, int i2, int i3, int i4) {
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        if (communicator != null) {
            communicator.simulateDisconnection(i, i2, i3, i4);
        }
    }

    private synchronized void enqueue(String str) {
        if (str != null) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".enqueue - queue=" + this.connectQueue.toString() + ", candidate=" + str);
            if (!this.connectQueue.contains(str)) {
                MFLogger.m12670d(TAG, "Enqueue " + str);
                this.connectQueue.add(str);
            }
            new Handler(Looper.getMainLooper()).post(new 6(this));
        }
    }

    private synchronized void dequeue() {
        if (!BluetoothUtils.isBluetoothEnable()) {
            MFLogger.m12672i(TAG, "Bluetooth is OFF, do nothing!!!");
        } else if (this.connectQueue.size() > 0) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".dequeue - queue=" + this.connectQueue.toString());
            String str = (String) this.connectQueue.iterator().next();
            if (!TextUtils.isEmpty(str)) {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".dequeue - serial=" + str + ", queue=" + this.connectQueue.toString());
                if (!this.deviceList.keySet().contains(str)) {
                    this.deviceList.put(str, MisfitDeviceProfile.cloneFrom(CommunicateManager.getInstance(this).getCommunicator(str, this).getBleAdapter()));
                }
                this.connectQueue.remove(str);
                connect(str);
            }
            new Handler(Looper.getMainLooper()).post(new 7(this));
        } else {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".dequeue - queue is empty. Stop dequeue.");
        }
    }

    private void connect(String str) {
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".connect - serial=" + str + ", gattState=" + communicator.getGattState() + ", hidState=" + communicator.getHidState() + ", communicateMode=" + communicator.getCommunicateMode());
        if (communicator.getCommunicateMode() != CommunicateMode.IDLE) {
            if (communicator.getGattState() == 2) {
                MFLogger.m12672i(TAG, "Inside " + TAG + ".connect - Current device has already connected");
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.DEVICE, MisfitDeviceProfile.cloneFrom(communicator.getBleAdapter()));
                broadcastServiceBlePhaseEvent(str, CommunicateMode.RECONNECT, ServiceActionResult.SUCCEEDED, bundle);
                return;
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".connect - Current syncProfile has pending task. Returning...");
        } else if (DevicePreferenceUtils.getAllActiveButtonSerial(this).contains(str) && communicator.getGattState() == 0) {
            addLogToActiveLog(str, "Connect to device.");
            communicator.startConnectionDeviceSession();
        }
    }

    private void disconnectAllButton() {
        this.scanServiceInstance.stopScan();
        Set<String> hashSet = new HashSet(DevicePreferenceUtils.getAllActiveButtonSerial(this));
        MFLogger.m12670d(TAG, "Inside " + TAG + ".disconnectAll - remove all serials: " + hashSet);
        for (String deviceDisconnect : hashSet) {
            try {
                deviceDisconnect(deviceDisconnect);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".disconnectAll - e=" + e);
                Thread.currentThread().interrupt();
            }
        }
        this.deviceList.clear();
        this.connectQueue.clear();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".disconnectAll - stringSet.size=" + hashSet.size() + ", buttonDeviceList.size=" + this.deviceList.size() + ", pairedDevices=" + DevicePreferenceUtils.getAllPairedButtonSerial(this) + ", activeDevices=" + DevicePreferenceUtils.getAllActiveButtonSerial(this));
    }

    private void clearDeviceData(String str) {
        if (str != null) {
            this.scannedDevices.remove(str);
            this.connectQueue.remove(str);
            this.deviceList.remove(str);
            CommunicateManager.getInstance(this).removeCommunicator(str);
        }
    }

    private long doUpdateTime(String str) {
        Log.d(TAG, "Inside " + TAG + ".doUpdateTime for " + str);
        if (!FossilDeviceSerialPatternUtil.isHybridSmartWatchDevice(str)) {
            return TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        }
        long currentTimeMillis = System.currentTimeMillis();
        BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(str, this);
        if (communicator.isDeviceReady() && communicator.startUpdateCurrentTime()) {
            return currentTimeMillis;
        }
        MFLogger.m12671e(TAG, "Inside " + TAG + ".doUpdateTime - Device is BUSY");
        broadcastServiceBlePhaseEvent(str, CommunicateMode.UPDATE_CURRENT_TIME, ServiceActionResult.FAILED, null);
        return currentTimeMillis;
    }

    private boolean isInPairedDeviceList(String str) {
        return DevicePreferenceUtils.getAllPairedButtonSerial(this).contains(str);
    }

    private boolean isInActiveDeviceList(String str) {
        return DevicePreferenceUtils.getAllActiveButtonSerial(this).contains(str);
    }

    private void saveMacAddressToCache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            DeviceUtils.getInstance(this).saveMacAddress(this, str, str2);
        }
    }

    private String getMacAddressFromCache(String str) {
        return DeviceUtils.getInstance(this).getMacAddress(this, str);
    }

    private void registerTimeZoneChangeEvent() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        registerReceiver(this.timeZoneChangeReceiver, intentFilter);
    }

    private void initReceiverActionWithPackageName() {
        String packageName = getPackageName();
        if (!ACTION_SCAN_DEVICE_FOUND.contains(packageName)) {
            ACTION_SCAN_DEVICE_FOUND = packageName + ACTION_SCAN_DEVICE_FOUND;
            ACTION_ANALYTIC_EVENT = packageName + ACTION_ANALYTIC_EVENT;
            ACTION_SERVICE_BLE_RESPONSE = packageName + ACTION_SERVICE_BLE_RESPONSE;
            ACTION_SERVICE_STREAMING_EVENT = packageName + ACTION_SERVICE_STREAMING_EVENT;
            ACTION_SERVICE_MICRO_APP_EVENT = packageName + ACTION_SERVICE_MICRO_APP_EVENT;
            ACTION_SERVICE_MICRO_APP_CANCEL_EVENT = packageName + ACTION_SERVICE_MICRO_APP_CANCEL_EVENT;
            ACTION_SERVICE_HEARTBEAT_DATA = packageName + ACTION_SERVICE_HEARTBEAT_DATA;
            ACTION_CONNECTION_STATE_CHANGE = packageName + ACTION_CONNECTION_STATE_CHANGE;
            ACTION_OTA_PROGRESS = packageName + ACTION_OTA_PROGRESS;
            ACTION_LOCATION_CHANGED = packageName + ACTION_LOCATION_CHANGED;
            ACTION_GET_ALARM = packageName + ACTION_GET_ALARM;
            BLUETOOTH_NOT_SUPPORTED = packageName + BLUETOOTH_NOT_SUPPORTED;
        }
    }

    private void addLogToActiveLog(String str, String str2) {
        MFLog activeLog = MFLogManager.getInstance(this).getActiveLog(str);
        if (activeLog != null) {
            activeLog.log(str2);
        }
    }

    private LEDColor getLedColor(int i) {
        switch (i) {
            case 0:
                return LEDColor.BLUE;
            case 1:
                return LEDColor.YELLOW;
            case 2:
                return LEDColor.ORANGE;
            case 3:
                return LEDColor.PURPLE;
            case 4:
                return LEDColor.GREEN;
            case 5:
                return LEDColor.PINK;
            default:
                return LEDColor.BLUE;
        }
    }

    private boolean reconnectRequired(int i, int i2) {
        if (i == 2 || i2 != 2) {
            return false;
        }
        return true;
    }

    private ArrayList<Integer> createListErrorState(int i) {
        ArrayList<Integer> arrayList = new ArrayList();
        switch (i) {
            case FailureCode.LOCATION_SERVICE_DISABLED /*1112*/:
            case FailureCode.LOCATION_ACCESS_DENIED /*1113*/:
                if (!BluetoothUtils.isBluetoothEnable()) {
                    arrayList.add(Integer.valueOf(FailureCode.BLUETOOTH_IS_DISABLED));
                }
                if (!LocationUtils.isLocationPermissionGranted(this)) {
                    arrayList.add(Integer.valueOf(FailureCode.LOCATION_ACCESS_DENIED));
                }
                if (!LocationUtils.isLocationEnable(this)) {
                    arrayList.add(Integer.valueOf(FailureCode.LOCATION_SERVICE_DISABLED));
                    break;
                }
                break;
            default:
                arrayList.add(Integer.valueOf(i));
                break;
        }
        return arrayList;
    }

    private Looper getLooper() {
        try {
            synchronized (this.thread) {
                if (!this.thread.isAlive() || this.thread.getState() == State.NEW) {
                    MFLogger.m12672i(TAG, "Inside " + TAG + ".getLooper - Looper thread was stopped, starting it again");
                    this.thread.interrupt();
                    this.thread = new HandlerThread(TAG);
                    this.thread.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            this.thread = new HandlerThread(TAG);
            this.thread.start();
        }
        return this.thread.getLooper();
    }

    private List<MultipleAlarmSettings> convertAlarmsToMultipleAlarms(List<Alarm> list) {
        List<MultipleAlarmSettings> arrayList = new ArrayList();
        for (Alarm alarm : list) {
            if (alarm == null) {
                MFLogger.m12671e(TAG, ".convertAlarmsToMultipleAlarms - alarm object is NULL");
            } else {
                int[] days = alarm.getDays();
                int length = days != null ? days.length : 0;
                byte alarmMinute;
                if (length == 0) {
                    MFLogger.m12670d(TAG, ".convertAlarmsToMultipleAlarms - alarmDay=" + 127);
                    alarmMinute = (byte) (alarm.getAlarmMinute() / 60);
                    arrayList.add(new MultipleAlarmSettings(Byte.MAX_VALUE, alarm.isRepeat(), alarmMinute, (byte) (alarm.getAlarmMinute() - (alarmMinute * 60))));
                } else if (alarm.isRepeat() || length >= 7) {
                    alarmMinute = (byte) (alarm.getAlarmMinute() / 60);
                    arrayList.add(new MultipleAlarmSettings(getMultipleAlarmDayByAlarm(alarm), alarm.isRepeat(), alarmMinute, (byte) (alarm.getAlarmMinute() - (alarmMinute * 60))));
                } else {
                    for (int convertCalendarDayToSDKDay : days) {
                        byte alarmMinute2 = (byte) (alarm.getAlarmMinute() / 60);
                        arrayList.add(new MultipleAlarmSettings(convertCalendarDayToSDKDay(convertCalendarDayToSDKDay), alarm.isRepeat(), alarmMinute2, (byte) (alarm.getAlarmMinute() - (alarmMinute2 * 60))));
                    }
                }
            }
        }
        return arrayList;
    }

    private byte getMultipleAlarmDayByAlarm(Alarm alarm) {
        int[] days = alarm.getDays();
        int length = days != null ? days.length : 0;
        if (length == 0) {
            return (byte) 2;
        }
        if (length == 1) {
            return convertCalendarDayToSDKDay(days[0]);
        }
        byte convertCalendarDayToSDKDay = convertCalendarDayToSDKDay(days[0]);
        int i = 1;
        while (i < length) {
            byte convertCalendarDayToSDKDay2 = (byte) (convertCalendarDayToSDKDay | convertCalendarDayToSDKDay(days[i]));
            i++;
            convertCalendarDayToSDKDay = convertCalendarDayToSDKDay2;
        }
        return convertCalendarDayToSDKDay;
    }

    private byte convertCalendarDayToSDKDay(int i) {
        switch (i) {
            case 1:
                return (byte) 1;
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 4;
            case 4:
                return (byte) 8;
            case 5:
                return (byte) 16;
            case 6:
                return (byte) 32;
            case 7:
                return (byte) 64;
            default:
                MFLogger.m12671e(TAG, "Calendar day isn't correct");
                return (byte) 2;
        }
    }

    public void onDeviceFound(com.misfit.ble.shine.ShineDevice shineDevice, int i) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onDeviceFound device=" + shineDevice.getSerialNumber());
        String serialNumber = shineDevice.getSerialNumber();
        if (serialNumber != null && DeviceIdentityUtils.isMisfitDevice(serialNumber)) {
            ScannedDevice scannedDevice = (ScannedDevice) this.scannedDevices.get(serialNumber);
            if (scannedDevice == null) {
                this.scannedDevices.put(serialNumber, new ScannedDevice(shineDevice, i));
                MFLog activeLog = MFLogManager.getInstance(this).getActiveLog("");
                if (activeLog != null) {
                    activeLog.log("Found: " + serialNumber + ", MAC " + shineDevice.getAddress());
                    activeLog.addCandidate(serialNumber);
                }
            } else {
                scannedDevice.setShineDevice(shineDevice);
                scannedDevice.setRssi(i);
                scannedDevice.setTime(System.currentTimeMillis());
            }
            if (this.deviceList.containsKey(serialNumber)) {
                BleCommunicator communicator = CommunicateManager.getInstance(this).getCommunicator(serialNumber, shineDevice.getAddress(), this);
                if (!(communicator.getGattState() == 2 || communicator.isBusy())) {
                    MFLogger.m12670d(TAG, "Inside " + TAG + ".onDeviceFound, Enqueue because serial is in deviceList queue or candidateDevices queue");
                    enqueue(serialNumber);
                }
            }
            broadcastDeviceScanFound(ShineDevice.clone(shineDevice, i), i);
        }
    }
}
