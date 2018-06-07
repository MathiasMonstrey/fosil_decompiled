package com.misfit.frameworks.buttonservice.communite.ble;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.fossil.cco;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.HandPositions;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.setting.uapp.UAppEnum$UAppError;
import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.PreparationResult;
import com.misfit.ble.shine.ShineProfile.PrepareActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.ble.shine.ShineProfile.StreamingCallback;
import com.misfit.ble.shine.ShineProfile.StreamingCallback.StreamingEventType;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.util.MutableBoolean;
import com.misfit.frameworks.buttonservice.ble.ScanService.ScanServiceError;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchCalibrationSession;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.utils.BluetoothUtils;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.MicroAppEventLogger;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public abstract class BleCommunicator {
    private static final int MSG_ACTIVATE = 14;
    private static final int MSG_APPLY_HAND_POSITION = 40;
    private static final int MSG_ARG_CONNECTED = 0;
    private static final int MSG_ARG_DISCONNECTED = 1;
    private static final int MSG_ARG_FAILED = 0;
    private static final int MSG_ARG_SUCCEEDED = 1;
    private static final int MSG_BUTTON_EVENT = 30;
    private static final int MSG_CLEAR_ALL_ALARMS = 23;
    private static final int MSG_CONNECTION_CHANGED = 3;
    private static final int MSG_DATA_ALL_READ = 5;
    private static final int MSG_DATA_READ_COMPLETED = 7;
    private static final int MSG_DATA_READ_PROGRESS_UPDATE = 4;
    private static final int MSG_DEVICE_RETRIEVED_DONE = 100;
    private static final int MSG_DEVICE_SCANNED = 2;
    private static final int MSG_DISABLE_CALL_TEXT_NOTIFICATION = 22;
    private static final int MSG_ENABLE_CALL_TEXT_NOTIFICATION = 18;
    private static final int MSG_GET_ACTIVITY_TYPE = 36;
    private static final int MSG_GET_ALARM_COMPLETED = 59;
    private static final int MSG_GET_CONFIG = 15;
    private static final int MSG_GET_COUNT_DOWN_COMPLETED = 56;
    private static final int MSG_GET_CURRENT_HAND_POSITION_COMPLETED = 70;
    private static final int MSG_GET_LAP_COUNTING_STATUS = 32;
    private static final int MSG_GET_MAPPING_TYPE = 35;
    private static final int MSG_GET_REAL_TIME_STEP_COMPLETED = 52;
    private static final int MSG_GET_SECOND_TIMEZONE_COMPLETED = 60;
    private static final int MSG_GET_STEP_GOAL_COMPLETED = 54;
    private static final int MSG_GET_VIBRATION_STRENGTH_COMPLETED = 55;
    private static final int MSG_HARDWARE_LOG_READ = 6;
    private static final int MSG_HEARTBEAT_RECEIVED = 29;
    private static final int MSG_HID_CONNECTION_STATE_CHANGED = 45;
    private static final int MSG_LEAR_LAST_NOTIFICATION_COMPLETED = 69;
    private static final int MSG_MICRO_APP_EVENT = 72;
    private static final int MSG_MICRO_APP_SEND_REMOTE_ACTIVITY_COMPLETED = 73;
    private static final int MSG_MOVING_HANDS = 41;
    private static final int MSG_OTA_COMPLETED = 9;
    private static final int MSG_OTA_PROGRESS_UPDATE = 8;
    private static final int MSG_PLAY_ANIMATION_COMPLETED = 10;
    private static final int MSG_PLAY_BUTTON_ANIMATION_COMPLETED = 12;
    private static final int MSG_PLAY_LIGHT_COMPLETED = 64;
    private static final int MSG_PLAY_SYNC_ANIMATION_COMPLETED = 58;
    private static final int MSG_PLAY_VIBRATION_COMPLETED = 65;
    private static final int MSG_PREPARE_COMPLETED = 46;
    private static final int MSG_READ_REMOTE_RSSI_COMPLETED = 63;
    private static final int MSG_RELEASE_HANDS_CONTROL = 43;
    private static final int MSG_REQUEST_HANDS_CONTROL = 42;
    private static final int MSG_RETRIEVE_HID_CONNECTED_DEVICES_MODE = 39;
    private static final int MSG_SEND_APP_NOTIFICATION = 26;
    private static final int MSG_SEND_CALL_NOTIFICATION = 24;
    private static final int MSG_SEND_HAND_NOTIFICATION = 44;
    private static final int MSG_SEND_NOTIFICATION_HAND_CONTROL_COMPLETED = 66;
    private static final int MSG_SEND_TEXT_NOTIFICATION = 25;
    private static final int MSG_SET_ACTIVITY_TYPE = 37;
    private static final int MSG_SET_BUTTON_CUSTOM_MODE = 38;
    private static final int MSG_SET_CONFIG = 16;
    private static final int MSG_SET_CONNECTION_PARAMETERS = 17;
    private static final int MSG_SET_COUNT_DOWN_COMPLETED = 57;
    private static final int MSG_SET_EVENT_ANIMATION = 49;
    private static final int MSG_SET_FLASH_BUTTON_MODE = 27;
    private static final int MSG_SET_GOAL_TRACKING = 50;
    private static final int MSG_SET_INACTIVITY_NUDGE = 19;
    private static final int MSG_SET_LAP_COUNTING_LICENSE = 34;
    private static final int MSG_SET_LAP_COUNTING_MODE = 33;
    private static final int MSG_SET_MICRO_APP_CONFIG_COMPLETED = 71;
    private static final int MSG_SET_MULTIPLE_ALARMS_COMPLETED = 67;
    private static final int MSG_SET_REAL_TIME_STEP_COMPLETED = 51;
    private static final int MSG_SET_SECOND_TIMEZONE_COMPLETED = 47;
    private static final int MSG_SET_SINGLE_ALARM = 21;
    private static final int MSG_SET_STEP_GOAL_COMPLETED = 53;
    private static final int MSG_SET_VIBRATION_STRENGTH_COMPLETED = 62;
    private static final int MSG_START_STREAMING = 28;
    private static final int MSG_STOP_ANIMATION_COMPLETED = 11;
    private static final int MSG_STOP_STREAMING = 31;
    private static final int MSG_STREAMING_BUTTON_EVENT = 61;
    private static final int MSG_UNMAP_ALL_EVENTS = 13;
    private static final int MSG_UNMAP_EVENT = 48;
    private static final int MSG_VERIFY_MULTIPLE_ALARMS_COMPLETED = 68;
    private static final String TAG = BleCommunicator.class.getSimpleName();
    private static final HandlerThread handlerThread = new HandlerThread(TAG);
    protected BleAdapter bleAdapter;
    protected BleSessionCallback bleSessionCallback = new C46902();
    private CommunicationResultCallback communicationResultCallback;
    protected BleSession currentSession;
    private Handler handler = new Handler(handlerThread.getLooper()) {
        public void handleMessage(Message message) {
            boolean z = false;
            if (message.arg1 == 1) {
                z = true;
            }
            try {
                switch (message.what) {
                    case 2:
                        if (message.obj != null) {
                            BleCommunicator.this.handleOnDeviceScanned((ShineDevice) message.obj, message.arg2);
                            return;
                        } else if (message.arg1 == 0) {
                            BleCommunicator.this.handleOnDeviceScanningFailed();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (message.arg1 == 0) {
                            BleCommunicator.this.handleOnDeviceConnected();
                            return;
                        } else {
                            BleCommunicator.this.handleOnDeviceDisconnected((ConnectActionResult) message.obj);
                            return;
                        }
                    case 4:
                        BleCommunicator.this.handleReadFilesProgressUpdated(message.arg2, (byte[]) message.obj);
                        return;
                    case 6:
                        BleCommunicator.this.handleOnHardwareLogRead(z, (byte[]) message.obj);
                        return;
                    case 7:
                        BleCommunicator.this.handleReadFilesCompleted(z);
                        return;
                    case 8:
                        BleCommunicator.this.handleOnOtaProgressUpdate((((Float) message.obj).floatValue() * 1000.0f) / 10.0f);
                        return;
                    case 9:
                        BleCommunicator.this.handleOnOtaCompleted(z);
                        return;
                    case 10:
                        BleCommunicator.this.handleOnPlayAnimationCompleted(z);
                        return;
                    case 13:
                        BleCommunicator.this.handleOnUnmapAllEventsCompleted(z);
                        return;
                    case 15:
                        BleCommunicator.this.handleOnGetConfigurationCompleted(z, (Hashtable) message.obj);
                        return;
                    case 16:
                        BleCommunicator.this.handleOnSetConfigurationCompleted(z);
                        return;
                    case 17:
                        if (message.arg1 == 1) {
                            BleCommunicator.this.handleOnSetConnectionParameterCompleted(true, (ShineError) message.obj);
                            return;
                        } else {
                            BleCommunicator.this.handleOnSetConnectionParameterCompleted(false, (ShineError) message.obj);
                            return;
                        }
                    case 21:
                        BleCommunicator.this.handleOnSettingSingleAlarmCompleted(z);
                        return;
                    case 23:
                        BleCommunicator.this.handleOnClearingAlarmCompleted(z);
                        return;
                    case 28:
                        BleCommunicator.this.handleOnStartStreamingCompleted(z);
                        return;
                    case 29:
                        BleCommunicator.this.handleOnReceivedHeartbeat(message.arg1, message.arg2, BleCommunicator.this.bleAdapter.getSerial());
                        return;
                    case 31:
                        BleCommunicator.this.handleOnStopStreamingCompleted(z);
                        return;
                    case 38:
                        BleCommunicator.this.handleOnSettingMappingCompleted(z);
                        return;
                    case 40:
                        BleCommunicator.this.handleOnApplyHandPositionCompleted(z);
                        return;
                    case 41:
                        BleCommunicator.this.handleOnMovingHandsCompleted((ActionResult) message.obj);
                        return;
                    case 42:
                        BleCommunicator.this.handleOnRequestHandsControlCompleted(z);
                        return;
                    case 43:
                        BleCommunicator.this.handleOnReleaseHandsControlCompleted(z);
                        return;
                    case 45:
                        if (message.arg1 == 0) {
                            BleCommunicator.this.handleOnHidConnected((ShineDevice) message.obj);
                            return;
                        } else {
                            BleCommunicator.this.handleOnHidDisconnected((ShineDevice) message.obj);
                            return;
                        }
                    case 46:
                        BleCommunicator.this.handleOnPrepareCompleted(z);
                        return;
                    case 47:
                        BleCommunicator.this.handleOnSetSecondTimeZoneCompleted(z);
                        return;
                    case 49:
                        BleCommunicator.this.handleOnSettingMappingAnimationCompleted(z);
                        return;
                    case 50:
                        BleCommunicator.this.handleOnSettingGoalTrackingCompleted(z);
                        return;
                    case 53:
                        BleCommunicator.this.handleOnSetGoalInStepCompleted(z);
                        return;
                    case 55:
                        BleCommunicator.this.handleOnGetVibrationStrengthCompleted(z, (short) message.arg2);
                        return;
                    case 56:
                        BleCommunicator.this.handleOnGetCountDownCompleted(z, (CountdownSettings) message.obj);
                        return;
                    case 57:
                        BleCommunicator.this.handleOnSetCountDownCompleted(z);
                        return;
                    case 58:
                        BleCommunicator.this.handleOnPlaySyncAnimationCompleted(z);
                        return;
                    case 59:
                        BleCommunicator.this.handleOnGettingSingleAlarmCompleted(z, (AlarmSettings) message.obj);
                        return;
                    case 60:
                        BleCommunicator.this.handleOnGetSecondTimeZoneCompleted(z, message.arg2);
                        return;
                    case 61:
                        BleCommunicator.this.handleOnStreamingButtonEvent(message.arg1, (String) message.obj);
                        return;
                    case 62:
                        BleCommunicator.this.handleOnSetVibrationStrengthCompleted(z);
                        return;
                    case 63:
                        BleCommunicator.this.handleOnReadRemoteRssiCompleted(z, message.arg2);
                        return;
                    case 64:
                        BleCommunicator.this.handleOnPlayLightCompleted(z);
                        return;
                    case 65:
                        BleCommunicator.this.handleOnPlayVibrationCompleted(z);
                        return;
                    case 66:
                        BleCommunicator.this.handleOnSendNotificationHandControlCompleted(z);
                        return;
                    case 67:
                        BleCommunicator.this.handleOnSetMultipleAlarmsCompleted(z);
                        return;
                    case 68:
                        BleCommunicator.this.handleOnVerifyMultipleAlarmsCompleted(z);
                        return;
                    case 69:
                        BleCommunicator.this.handleOnClearLastNotificationCompleted(z);
                        return;
                    case 70:
                        HandPositions handPositions = null;
                        if (z && message.obj != null) {
                            handPositions = (HandPositions) message.obj;
                        }
                        BleCommunicator.this.handleOnGetHandPositionCompleted(z, handPositions);
                        return;
                    case 71:
                        BleCommunicator.this.handleOnSetMicroAppConfigCompleted(z);
                        return;
                    case 72:
                        UAppNotification uAppNotification = (UAppNotification) message.obj;
                        if (uAppNotification != null) {
                            BleCommunicator.this.handleOnMicroAppEvent(uAppNotification, BleCommunicator.this.bleAdapter.getSerial());
                            return;
                        }
                        return;
                    case 73:
                        BleCommunicator.this.handleOnSendMicroAppRemoteActivityCompleted(z);
                        return;
                    case 100:
                        BleCommunicator.this.handleOnRetrieveDeviceComplete();
                        return;
                    default:
                        return;
                }
            } catch (NullPointerException e) {
                MFLogger.e(BleCommunicator.TAG, "Access to null session caused by bleSessionCallback.onStop called while handlerMessage is processing. Could ignore it now. e:" + e);
            }
            MFLogger.e(BleCommunicator.TAG, "Access to null session caused by bleSessionCallback.onStop called while handlerMessage is processing. Could ignore it now. e:" + e);
        }
    };
    protected PriorityBlockingQueue<BleSession> highSessionQueue;
    protected PriorityBlockingQueue<BleSession> lowSessionQueue;
    private HashMap<String, UAppNotification> mMicroAppNotifications;
    protected SdkCallback sdkCallback = new C46913();

    class C46902 implements BleSessionCallback {
        C46902() {
        }

        public void onStop(int i, Bundle bundle, BleSession bleSession) {
            if (BleCommunicator.this.communicationResultCallback != null && (bleSession.equals(BleCommunicator.this.currentSession) || bleSession.requireBroadCastInAnyCase())) {
                BleCommunicator.this.communicationResultCallback.onCommunicatorResult(bleSession.getCommunicateMode(), BleCommunicator.this.bleAdapter.getSerial(), i, bundle);
            }
            if (bleSession.equals(BleCommunicator.this.currentSession)) {
                BleCommunicator.this.currentSession = null;
                MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".bleSessionCallback.onStop");
                BleCommunicator.this.startSessionInQueue();
            }
        }

        public void onBleStateResult(int i, Bundle bundle) {
            if (BleCommunicator.this.communicationResultCallback != null && BleCommunicator.this.currentSession != null) {
                BleCommunicator.this.communicationResultCallback.onCommunicatorResult(BleCommunicator.this.currentSession.getCommunicateMode(), BleCommunicator.this.bleAdapter.getSerial(), i, bundle);
            }
        }

        public void onReceivedSyncData(Bundle bundle) {
            if (BleCommunicator.this.communicationResultCallback != null && BleCommunicator.this.bleAdapter != null && BleCommunicator.this.currentSession != null && BleCommunicator.this.currentSession.getCommunicateMode() == CommunicateMode.SYNC) {
                BleCommunicator.this.communicationResultCallback.onReceivedSyncData(BleCommunicator.this.bleAdapter.getSerial(), bundle);
            }
        }
    }

    class C46913 implements SdkCallback {
        C46913() {
        }

        public void onDataTransferCompleted(ActionID actionID, ActionResult actionResult) {
            Message obtainMessage;
            MFLogger.d(BleCommunicator.TAG, "Inside onDataTransferCompleted - actionID=" + actionID + ", result=" + actionResult.getResultCode() + ", info=" + actionResult.getError());
            switch ((ShineActionID) actionID) {
                case OTA:
                    obtainMessage = BleCommunicator.this.handler.obtainMessage(9);
                    break;
                case SET_UAPP_CONFIGURATION:
                    obtainMessage = BleCommunicator.this.handler.obtainMessage(71);
                    break;
                case SEND_UAPP_REMOTE_ACTIVITY:
                    obtainMessage = BleCommunicator.this.handler.obtainMessage(73);
                    break;
                default:
                    obtainMessage = null;
                    break;
            }
            if (obtainMessage != null) {
                obtainMessage.arg1 = actionResult.getResultCode() == ResultCode.SUCCEEDED ? 1 : 0;
                obtainMessage.sendToTarget();
            }
        }

        public void onDataTransferProgressChanged(ActionID actionID, float f) {
            MFLogger.d(BleCommunicator.TAG, "Inside onDataTransferProgressChanged - actionID=" + actionID + ", value=" + f);
            Message message = null;
            switch ((ShineActionID) actionID) {
                case OTA:
                    message = BleCommunicator.this.handler.obtainMessage(8);
                    message.obj = Float.valueOf(f);
                    break;
            }
            if (message != null) {
                message.sendToTarget();
            }
        }

        public void onHIDConnectionStateChanged(ShineDevice shineDevice, int i) {
            MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + "." + BleCommunicator.this.getCurrentSessionName() + ".onHIDConnectionStateChanged - state=" + i + ", serial=" + shineDevice.getSerialNumber());
            BleCommunicator.this.log("HID connection state changed: " + i);
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(45);
            if (i == 2) {
                obtainMessage.arg1 = 0;
            } else if (i == 0) {
                obtainMessage.arg1 = 1;
            } else {
                return;
            }
            obtainMessage.obj = shineDevice;
            obtainMessage.sendToTarget();
        }

        public void onConnectionStateChanged(ShineProfile shineProfile, State state, ConnectActionResult connectActionResult) {
            MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + "." + BleCommunicator.this.getCurrentSessionName() + ".onConnectionStateChanged - state=" + state + ", serial=" + BleCommunicator.this.bleAdapter.getSerial() + ", status=" + connectActionResult.getStatus() + ", resultCode=" + connectActionResult.getResultCode());
            BleCommunicator.this.log("GATT connection state changed: " + state + ", result:[status=" + (connectActionResult.getStatus() == -1000 ? "_From app_" : Integer.valueOf(connectActionResult.getStatus())) + ", resultCode=" + connectActionResult.getResultCode() + "]");
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(3);
            if (state == State.CONNECTED) {
                BleCommunicator.this.bleAdapter.setShineProfile(shineProfile);
                obtainMessage.arg1 = 0;
            } else if (state == State.CLOSED) {
                obtainMessage.arg1 = 1;
                obtainMessage.obj = connectActionResult;
            } else {
                return;
            }
            obtainMessage.sendToTarget();
        }

        public void onPreparationCompleted(ShineProfile shineProfile, PrepareActionResult prepareActionResult) {
            MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onPreparationCompleted - RESULT - resultCode=" + prepareActionResult.getResultCode() + ", resultInfo=" + prepareActionResult.getError());
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(46);
            if (prepareActionResult.getResultCode() == PreparationResult.SUCCEEDED) {
                obtainMessage.arg1 = 1;
            } else {
                obtainMessage.arg1 = 0;
            }
            obtainMessage.sendToTarget();
        }

        public void onDeviceFound(ShineDevice shineDevice, int i) {
            MFLogger.d(BleCommunicator.TAG, "onDeviceFound - device=" + shineDevice.getSerialNumber() + ", mac=" + shineDevice.getAddress() + ", rssi=" + i);
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(2);
            obtainMessage.obj = shineDevice;
            obtainMessage.arg1 = 0;
            obtainMessage.arg2 = i;
            obtainMessage.sendToTarget();
        }

        public void onConnectedDeviceRetrieved(List<ShineDevice> list) {
            for (ShineDevice shineDevice : list) {
                MFLogger.d(BleCommunicator.TAG, "onConnectedDeviceRetrieved - device: [serial=" + shineDevice.getSerialNumber() + ", mac=" + shineDevice.getAddress() + "]");
                Message obtainMessage = BleCommunicator.this.handler.obtainMessage(2);
                obtainMessage.obj = shineDevice;
                obtainMessage.arg1 = 0;
                obtainMessage.arg2 = 0;
                obtainMessage.sendToTarget();
            }
            MFLogger.d(BleCommunicator.TAG, "onConnectedDeviceRetrieved - complete.");
            BleCommunicator.this.handler.obtainMessage(100).sendToTarget();
        }

        public void onScanFail(ScanServiceError scanServiceError) {
            BleCommunicator.this.log("Failed to start scanning - Error: " + scanServiceError.sdkError + ":" + scanServiceError.message);
            MFLogger.e(BleCommunicator.TAG, "onScanFail - error=" + scanServiceError.sdkError + ":" + scanServiceError.message);
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(2);
            obtainMessage.arg1 = 0;
            obtainMessage.sendToTarget();
        }

        public void onSyncDataRead(byte[] bArr, Bundle bundle, MutableBoolean mutableBoolean) {
            float f = bundle.getFloat(ShineProfile.SYNC_PROGRESS_KEY);
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(4);
            obtainMessage.obj = bArr;
            obtainMessage.arg2 = (int) (f * 100.0f);
            obtainMessage.sendToTarget();
        }

        public void onSyncCompleted(ActionResult actionResult) {
            MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onSyncCompleted - result=" + actionResult.getResultCode() + ", info=" + actionResult.getError());
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(7);
            obtainMessage.arg1 = actionResult.getResultCode() == ResultCode.SUCCEEDED ? 1 : 0;
            obtainMessage.sendToTarget();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConfigCompleted(com.misfit.ble.shine.ActionID r6, com.misfit.ble.shine.ShineProfile.ActionResult r7, java.util.Hashtable<com.misfit.ble.shine.ShineProperty, java.lang.Object> r8) {
            /*
            r5 = this;
            r1 = 0;
            r6 = (com.misfit.ble.shine.ShineActionID) r6;
            r2 = 0;
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.TAG;
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "Inside onConfigCompleted - action=";
            r3 = r3.append(r4);
            r3 = r3.append(r6);
            r4 = ", result=";
            r3 = r3.append(r4);
            r4 = r7.getResultCode();
            r3 = r3.append(r4);
            r4 = ", info=";
            r3 = r3.append(r4);
            r4 = r7.getError();
            r3 = r3.append(r4);
            r4 = ", hashTable=";
            r3 = r3.append(r4);
            r3 = r3.append(r8);
            r3 = r3.toString();
            com.misfit.frameworks.common.log.MFLogger.d(r0, r3);
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.C46946.$SwitchMap$com$misfit$ble$shine$ShineActionID;
            r3 = r6.ordinal();
            r0 = r0[r3];
            switch(r0) {
                case 4: goto L_0x0060;
                case 5: goto L_0x006e;
                case 6: goto L_0x007c;
                case 7: goto L_0x0090;
                case 8: goto L_0x00a0;
                case 9: goto L_0x00ae;
                case 10: goto L_0x00bc;
                case 11: goto L_0x00db;
                case 12: goto L_0x00ea;
                case 13: goto L_0x00f9;
                case 14: goto L_0x0108;
                case 15: goto L_0x013e;
                case 16: goto L_0x014d;
                case 17: goto L_0x015e;
                case 18: goto L_0x016d;
                case 19: goto L_0x017c;
                case 20: goto L_0x01a0;
                case 21: goto L_0x01af;
                case 22: goto L_0x01be;
                case 23: goto L_0x01cd;
                case 24: goto L_0x01dc;
                case 25: goto L_0x01eb;
                case 26: goto L_0x01fa;
                default: goto L_0x004f;
            };
        L_0x004f:
            if (r2 == 0) goto L_0x005f;
        L_0x0051:
            r0 = r7.getResultCode();
            r3 = com.misfit.ble.shine.ShineProfile.ResultCode.SUCCEEDED;
            if (r0 != r3) goto L_0x0219;
        L_0x0059:
            r0 = 1;
        L_0x005a:
            r2.arg1 = r0;
            r2.sendToTarget();
        L_0x005f:
            return;
        L_0x0060:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 10;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x006e:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 58;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x007c:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 17;
            r0 = r0.obtainMessage(r2);
            r2 = r7.getError();
            r0.obj = r2;
            r2 = r0;
            goto L_0x004f;
        L_0x0090:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 15;
            r0 = r0.obtainMessage(r2);
            r0.obj = r8;
            r2 = r0;
            goto L_0x004f;
        L_0x00a0:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 16;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x00ae:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 21;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x00bc:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 59;
            r0 = r0.obtainMessage(r2);
            if (r8 == 0) goto L_0x0216;
        L_0x00ca:
            r2 = r8.isEmpty();
            if (r2 != 0) goto L_0x0216;
        L_0x00d0:
            r2 = com.misfit.ble.shine.ShineProperty.ALARM_SETTINGS;
            r2 = r8.get(r2);
            r0.obj = r2;
            r2 = r0;
            goto L_0x004f;
        L_0x00db:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 23;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x00ea:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 13;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x00f9:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 48;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x0108:
            r0 = com.misfit.ble.shine.ShineProperty.EVENT_MAPPINGS;
            r0 = r8.get(r0);
            r0 = (java.util.List) r0;
            if (r0 == 0) goto L_0x004f;
        L_0x0112:
            r3 = r0.size();
            if (r3 == 0) goto L_0x004f;
        L_0x0118:
            r0 = r0.get(r1);
            r0 = (com.misfit.ble.setting.eventmapping.EventMapping) r0;
            r0 = r0 instanceof com.misfit.ble.setting.eventmapping.ButtonEventMappingThree;
            if (r0 == 0) goto L_0x0131;
        L_0x0122:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 49;
            r0 = r0.obtainMessage(r2);
        L_0x012e:
            r2 = r0;
            goto L_0x004f;
        L_0x0131:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 38;
            r0 = r0.obtainMessage(r2);
            goto L_0x012e;
        L_0x013e:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 42;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x014d:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 41;
            r0 = r0.obtainMessage(r2);
            r0.obj = r7;
            r2 = r0;
            goto L_0x004f;
        L_0x015e:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 43;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x016d:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 40;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x017c:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 63;
            r2 = r0.obtainMessage(r2);
            if (r8 == 0) goto L_0x004f;
        L_0x018a:
            r0 = r8.isEmpty();
            if (r0 != 0) goto L_0x004f;
        L_0x0190:
            r0 = com.misfit.ble.shine.ShineProperty.RSSI;
            r0 = r8.get(r0);
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r2.arg2 = r0;
            goto L_0x004f;
        L_0x01a0:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 64;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01af:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 65;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01be:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 66;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01cd:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 69;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01dc:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 67;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01eb:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 68;
            r0 = r0.obtainMessage(r2);
            r2 = r0;
            goto L_0x004f;
        L_0x01fa:
            r0 = com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.this;
            r0 = r0.handler;
            r2 = 70;
            r0 = r0.obtainMessage(r2);
            if (r8 == 0) goto L_0x0216;
        L_0x0208:
            r2 = r8.isEmpty();
            if (r2 != 0) goto L_0x0216;
        L_0x020e:
            r2 = com.misfit.ble.shine.ShineProperty.HAND_POSITIONS;
            r2 = r8.get(r2);
            r0.obj = r2;
        L_0x0216:
            r2 = r0;
            goto L_0x004f;
        L_0x0219:
            r0 = r1;
            goto L_0x005a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.3.onConfigCompleted(com.misfit.ble.shine.ActionID, com.misfit.ble.shine.ShineProfile$ActionResult, java.util.Hashtable):void");
        }

        public void onStreamingStarted(ActionResult actionResult) {
            MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + "." + BleCommunicator.this.getCurrentSessionName() + ".onStreamingStarted - result=" + actionResult.getResultCode() + ", currentState=" + BleCommunicator.this.getCurrentStateName());
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(28);
            obtainMessage.arg1 = actionResult.getResultCode() == ResultCode.SUCCEEDED ? 1 : 0;
            obtainMessage.sendToTarget();
        }

        public void onStreamingStopped(ActionResult actionResult) {
            MFLogger.d(BleCommunicator.TAG, "Streaming stopped callback with result code:" + actionResult.getResultCode() + ", info:" + actionResult.getError());
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(31);
            obtainMessage.arg1 = actionResult.getResultCode() == ResultCode.INTERRUPTED ? 1 : 0;
            obtainMessage.sendToTarget();
        }

        public void onStreamingEvent(StreamingEventType streamingEventType, Bundle bundle) {
            int i;
            Message obtainMessage;
            switch (streamingEventType) {
                case BUTTON_EVENT:
                    i = bundle.getInt(StreamingCallback.EXTRA_BUTTON_EVENT_ID);
                    MFLogger.i(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onStreamingEvent, buttonEvent - event=" + i);
                    obtainMessage = BleCommunicator.this.handler.obtainMessage(61);
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = BleCommunicator.this.bleAdapter.getSerial();
                    obtainMessage.sendToTarget();
                    return;
                case UAPP_NOTIFICATION:
                    UAppNotification uAppNotification = (UAppNotification) bundle.getParcelable(StreamingCallback.EXTRA_UAPP_NOTIFICATION);
                    MFLogger.i(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onStreamingEvent, UAppBLEStreamingEvent - uAppNotification=" + uAppNotification.toString());
                    obtainMessage = BleCommunicator.this.handler.obtainMessage(72);
                    obtainMessage.obj = uAppNotification;
                    obtainMessage.sendToTarget();
                    return;
                case HEARTBEAT:
                    if (bundle.containsKey(StreamingCallback.EXTRA_HEARTBEAT_DAILY_POINTS) && bundle.containsKey(StreamingCallback.EXTRA_HEARTBEAT_DAILY_STEPS)) {
                        i = bundle.getInt(StreamingCallback.EXTRA_HEARTBEAT_DAILY_STEPS);
                        int i2 = bundle.getInt(StreamingCallback.EXTRA_HEARTBEAT_DAILY_POINTS);
                        MFLogger.i(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onStreamingEvent, HeartbeatReceived - dailySteps=" + i + ", dailyPoint=" + i2);
                        Message obtainMessage2 = BleCommunicator.this.handler.obtainMessage(29);
                        obtainMessage2.arg1 = i;
                        obtainMessage2.arg2 = i2;
                        obtainMessage2.sendToTarget();
                        return;
                    }
                    MFLogger.d(BleCommunicator.TAG, "Inside " + BleCommunicator.TAG + ".onStreamingEvent, HeartbeatReceived - OK");
                    return;
                default:
                    return;
            }
        }

        public void onStreamingEventData(byte[] bArr) {
        }

        public void onRetrievingHardwareLogCompleted(ActionResult actionResult, byte[] bArr) {
            Message obtainMessage = BleCommunicator.this.handler.obtainMessage(6);
            obtainMessage.arg1 = actionResult.getResultCode() == ResultCode.SUCCEEDED ? 1 : 0;
            obtainMessage.obj = bArr;
            obtainMessage.sendToTarget();
        }
    }

    class C46924 implements Comparator<BleSession> {
        C46924() {
        }

        public int compare(BleSession bleSession, BleSession bleSession2) {
            return bleSession2.getSessionType().compareTo(bleSession.getSessionType());
        }
    }

    class C46935 implements Comparator<BleSession> {
        C46935() {
        }

        public int compare(BleSession bleSession, BleSession bleSession2) {
            return bleSession2.getSessionType().compareTo(bleSession.getSessionType());
        }
    }

    public abstract Device getDeviceType();

    public abstract boolean startCalibrationSession();

    public abstract boolean startCleanLinkMappingSession(List<BLEMapping> list);

    public abstract boolean startClearAllAlarmsSession();

    public abstract boolean startClearLastNotificationSession();

    public abstract boolean startConnectionDeviceSession();

    public abstract boolean startDisableGoalTrackingSession();

    public abstract boolean startGetAlarmSession();

    public abstract boolean startGetBatteryLevelSession();

    public abstract boolean startGetCountdownSettingSession();

    public abstract boolean startGetRssiSession();

    public abstract boolean startGetSecondTimezoneSession();

    public abstract boolean startGetVibrationStrengthSession();

    public abstract boolean startHWLogSyncSession();

    public abstract boolean startOtaSession(byte[] bArr, boolean z, String str, String str2, UserProfile userProfile);

    public abstract boolean startPairingSession();

    public abstract boolean startPlayAnimationSession();

    public abstract boolean startPlayLightAndVibrationSession(LEDColor lEDColor, VibeEnum vibeEnum, byte b, int i);

    public abstract boolean startPlayLightSession(LightVibrationSetting lightVibrationSetting);

    public abstract boolean startPlayVibrationSession(LightVibrationSetting lightVibrationSetting);

    public abstract boolean startReadRealTimeStepSession();

    public abstract boolean startSendNotificationSession(LEDColor lEDColor, byte b, List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr, boolean z);

    public abstract boolean startSetAlarmSession(AlarmSettings alarmSettings);

    public abstract boolean startSetAutoCountDown(long j, long j2);

    public abstract boolean startSetAutoMapping(List<BLEMapping> list);

    public abstract boolean startSetAutoMultiAlarms(List<MultipleAlarmSettings> list);

    public abstract boolean startSetAutoSecondTimezone(String str);

    public abstract boolean startSetAutoSingleAlarm(AlarmSettings alarmSettings);

    public abstract boolean startSetCountdownSettingSession(boolean z, long j, long j2);

    public abstract boolean startSetLinkMappingSession(List<BLEMapping> list);

    public abstract boolean startSetMultipleAlarmsSession(List<MultipleAlarmSettings> list);

    public abstract boolean startSetSecondTimezoneSession(String str);

    public abstract boolean startSetStepGoal(int i);

    public abstract boolean startSetVibrationStrengthSession(short s);

    public abstract boolean startSyncingSession(UserProfile userProfile);

    public abstract boolean startUnlinkSession();

    public abstract boolean startUpdateCurrentTime();

    public abstract boolean startVerifyMultipleAlarmsSession(int i);

    static {
        handlerThread.start();
    }

    public BleCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        this.communicationResultCallback = (CommunicationResultCallback) cco.ce(communicationResultCallback);
        this.bleAdapter = new BleAdapter(context, this.sdkCallback, this.sdkCallback, this.sdkCallback);
        this.bleAdapter.setSerial(str);
        this.bleAdapter.setMacAddress(str2);
        this.bleAdapter.setConfigurationCallback(this.sdkCallback);
        this.bleAdapter.setPreparationCallback(this.sdkCallback);
        this.bleAdapter.setSyncCallback(this.sdkCallback);
        this.bleAdapter.setHardwareLogCallback(this.sdkCallback);
        this.bleAdapter.setDataTransferCallback(this.sdkCallback);
        this.highSessionQueue = new PriorityBlockingQueue(11, new C46924());
        this.lowSessionQueue = new PriorityBlockingQueue(11, new C46935());
        this.mMicroAppNotifications = new HashMap();
    }

    public BleSession getCurrentSession() {
        return this.currentSession;
    }

    public BleAdapter getBleAdapter() {
        return this.bleAdapter;
    }

    public boolean isBusy() {
        if (this.currentSession == null || (!(this.currentSession instanceof UnlinkSession) && !(this.currentSession instanceof ConnectDeviceSession))) {
            return false;
        }
        return true;
    }

    private String getCurrentSessionName() {
        if (this.currentSession == null) {
            return "NULL";
        }
        return this.currentSession.getClass().getSimpleName();
    }

    private String getCurrentStateName() {
        if (this.currentSession == null) {
            return "NULL Session";
        }
        if (this.currentSession.getState() == null) {
            return "NULL State";
        }
        return this.currentSession.getState().getClass().getSimpleName();
    }

    private void log(String str) {
        if (this.currentSession != null) {
            MFLog mFLog = this.currentSession.mfLog;
            if (mFLog != null) {
                mFLog.log("[" + this.bleAdapter.getSerial() + "] " + str);
            }
        }
    }

    private void logNoCurrentSession(String str) {
        MFLogger.i(TAG, "No running session to handle " + str);
        log("No running session to handle " + str);
    }

    private void logNoCurrentState(String str) {
        MFLogger.i(TAG, "No current state to handle " + str);
        log("No current state to handle " + str);
    }

    private boolean handleOnDeviceScanned(ShineDevice shineDevice, int i) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnDeviceScanned");
            return false;
        } else if (this.currentSession.getState() != null) {
            return this.currentSession.getState().handleOnDeviceScanned(shineDevice, i);
        } else {
            logNoCurrentState("handleOnDeviceScanned");
            return false;
        }
    }

    private boolean handleOnDeviceScanningFailed() {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnDeviceScanningFailed");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnDeviceScanningFailed");
            return false;
        } else {
            this.currentSession.getState().onFatal(FailureCode.SCANNING_FAILED_WITH_SDK_EXCEPTION);
            return true;
        }
    }

    private boolean handleOnRetrieveDeviceComplete() {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnRetrieveDeviceComplete");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnRetrieveDeviceComplete");
            return false;
        } else {
            this.currentSession.getState().handleOnRetrieveDeviceComplete();
            return true;
        }
    }

    private boolean handleOnDeviceConnected() {
        if (this.communicationResultCallback != null) {
            this.communicationResultCallback.onGattConnectionStateChanged(this.bleAdapter.getSerial(), 2);
        }
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnDeviceConnected");
            log("GATT is reconnected automatically, but current session is not ConnectableSession. Start ConnectDeviceSession.");
            startConnectionDeviceSession();
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnDeviceConnected");
            return false;
        } else if (this.currentSession.getSessionType() == SessionType.CONNECT_WITHOUT_TIMEOUT) {
            log("GATT is reconnected automatically, try to reconnect to device");
            startConnectionDeviceSession();
            return false;
        } else {
            if (!(this.currentSession instanceof ConnectableSession)) {
                log("GATT is reconnected automatically, but current session is not ConnectableSession. Start ConnectDeviceSession.");
                startConnectionDeviceSession();
            }
            log("Connected");
            return this.currentSession.getState().handleOnDeviceConnected();
        }
    }

    private boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        if (this.communicationResultCallback != null) {
            if (this.bleAdapter.shouldBroadCastDisconnectionState()) {
                this.communicationResultCallback.onGattConnectionStateChanged(this.bleAdapter.getSerial(), 0);
            } else {
                this.bleAdapter.letBroadCastDisconnectionState();
            }
        }
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnDeviceDisconnected");
            if (!isQueueEmpty()) {
                return false;
            }
            startSessionInQueue();
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnDeviceDisconnected");
            return false;
        } else {
            log("Disconnected");
            if (!this.currentSession.getState().handleOnDeviceDisconnected(connectActionResult)) {
                this.currentSession.handleUnexpectedDisconnection();
            }
            return true;
        }
    }

    private boolean handleOnHidConnected(ShineDevice shineDevice) {
        Object serialNumber = shineDevice.getSerialNumber();
        if (this.communicationResultCallback != null) {
            this.communicationResultCallback.onHidConnectionStateChanged(serialNumber, 2);
        }
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnHidConnected");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnHidConnected");
            return false;
        } else if (TextUtils.isEmpty(serialNumber) || !serialNumber.equals(this.bleAdapter.getSerial())) {
            return false;
        } else {
            log("HID Connected");
            return this.currentSession.getState().handleOnHidConnected();
        }
    }

    private boolean handleOnHidDisconnected(ShineDevice shineDevice) {
        Object serialNumber = shineDevice.getSerialNumber();
        if (this.communicationResultCallback != null) {
            this.communicationResultCallback.onHidConnectionStateChanged(serialNumber, 0);
        }
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnHidDisconnected");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnHidDisconnected");
            return false;
        } else if (TextUtils.isEmpty(serialNumber) || !serialNumber.equals(this.bleAdapter.getSerial())) {
            return false;
        } else {
            log("HID Disconnected");
            return this.currentSession.getState().handleOnHidDisconnected();
        }
    }

    private boolean handleOnPrepareCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnPrepareCompleted");
            return false;
        }
        if (this.communicationResultCallback != null) {
            this.communicationResultCallback.onPreparationCompleted(z, this.bleAdapter.getSerial());
        }
        if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnPrepareCompleted");
            return false;
        }
        log("Prepared: " + (z ? "OK" : "FAILED"));
        return this.currentSession.getState().handleOnDevicePreparedCompleted(z);
    }

    private boolean handleOnPlayAnimationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnPlayAnimationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnPlayAnimationCompleted");
            return false;
        } else {
            log("Play animation: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnPlayAnimationCompleted(z);
        }
    }

    private boolean handleReadFilesCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleReadFilesCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleReadFilesCompleted");
            return false;
        } else {
            log("Read files: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnDataReadCompleted(z);
        }
    }

    private boolean handleReadFilesProgressUpdated(int i, byte[] bArr) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleReadFilesProgressUpdated");
            return false;
        } else if (this.currentSession.getState() != null) {
            return this.currentSession.getState().handleOnDataReadProgressUpdate(i, bArr);
        } else {
            logNoCurrentState("handleReadFilesProgressUpdated");
            return false;
        }
    }

    private boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetConnectionParameterCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetConnectionParameterCompleted");
            return false;
        } else {
            log("Set connection params: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetConnectionParameterCompleted(z, shineError);
        }
    }

    private boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGetConfigurationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGetConfigurationCompleted");
            return false;
        } else {
            log("Get config params: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGetConfigurationCompleted(z, hashtable);
        }
    }

    private boolean handleOnSetConfigurationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetConfigurationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetConfigurationCompleted");
            return false;
        } else {
            log("Set config params: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetConfigurationCompleted(z);
        }
    }

    private boolean handleOnSettingSingleAlarmCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSettingSingleAlarmCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSettingSingleAlarmCompleted");
            return false;
        } else {
            log("Set single alarm: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSettingSingleAlarmCompleted(z);
        }
    }

    private boolean handleOnGettingSingleAlarmCompleted(boolean z, AlarmSettings alarmSettings) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGettingAlarmCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGettingAlarmCompleted");
            return false;
        } else {
            log("Get single alarm: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGettingAlarmCompleted(z, alarmSettings);
        }
    }

    private boolean handleOnClearingAlarmCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnClearingAlarmCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnClearingAlarmCompleted");
            return false;
        } else {
            log("Clear alarm: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnClearAllAlarmsCompleted(z);
        }
    }

    private boolean handleOnSetSecondTimeZoneCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetSecondTimeZoneCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetSecondTimeZoneCompleted");
            return false;
        } else {
            log("Set 2nd timezone: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetSecondTimeZoneCompleted(z);
        }
    }

    private boolean handleOnGetSecondTimeZoneCompleted(boolean z, int i) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGetSecondTimeZoneCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGetSecondTimeZoneCompleted");
            return false;
        } else {
            log("Get 2nd timezone: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGetSecondTimeZoneCompleted(z, i);
        }
    }

    private boolean handleOnUnmapAllEventsCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnUnmapAllEventsCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnUnmapAllEventsCompleted");
            return false;
        } else {
            log("Clear LINK mappings: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnUnmapAllEventsCompleted(z);
        }
    }

    private boolean handleOnSettingMappingCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSettingMappingCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSettingMappingCompleted");
            return false;
        } else {
            log("Set LINK mappings: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSettingMappingCompleted(z);
        }
    }

    private boolean handleOnMicroAppConfigCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnMicroAppConfigCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnMicroAppConfigCompleted");
            return false;
        } else {
            log("Set micro app configuration: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnMicroAppConfigCompleted(z);
        }
    }

    private boolean handleOnGetHandPositionCompleted(boolean z, HandPositions handPositions) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGetHandPositionCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGetHandPositionCompleted");
            return false;
        } else {
            log("Get hand position: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGetHandPositionCompleted(z, handPositions);
        }
    }

    private boolean handleOnSettingMappingAnimationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSettingMappingAnimationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSettingMappingAnimationCompleted");
            return false;
        } else {
            log("Set mapping animation: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSettingMappingAnimationCompleted(z);
        }
    }

    private boolean handleOnSettingGoalTrackingCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSettingGoalTrackingCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSettingGoalTrackingCompleted");
            return false;
        } else {
            log("Set goal tracking: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSettingGoalTrackingCompleted(z);
        }
    }

    private boolean handleOnStartStreamingCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnStartStreamingCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnStartStreamingCompleted");
            return false;
        } else {
            log("Start streaming: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnStartStreamingCompleted(z);
        }
    }

    private boolean handleOnStopStreamingCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnStartStreamingCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnStartStreamingCompleted");
            return false;
        } else {
            log("Stop streaming: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnStopStreamingCompleted(z);
        }
    }

    private boolean handleOnStreamingButtonEvent(int i, String str) {
        this.communicationResultCallback.onStreamingButtonEvent(i, str);
        return true;
    }

    private boolean handleOnRequestHandsControlCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnRequestHandsControlCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnRequestHandsControlCompleted");
            return false;
        } else {
            log("Request hand control: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnRequestHandsControlCompleted(z);
        }
    }

    private boolean handleOnMovingHandsCompleted(ActionResult actionResult) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnMovingHandsCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnMovingHandsCompleted");
            return false;
        } else {
            log("Move hand: " + (actionResult.getResultCode() == ResultCode.SUCCEEDED ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnMovingHandsCompleted(actionResult);
        }
    }

    private boolean handleOnReleaseHandsControlCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnReleaseHandsControlCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnReleaseHandsControlCompleted");
            return false;
        } else {
            log("Release hand control: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnReleaseHandsControlCompleted(z);
        }
    }

    private boolean handleOnApplyHandPositionCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnApplyHandPositionCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnApplyHandPositionCompleted");
            return false;
        } else {
            log("Apply hand position: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnApplyHandPositionCompleted(z);
        }
    }

    private boolean handleOnOtaCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnOtaCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnOtaCompleted");
            return false;
        } else {
            log("OTA complete: " + (z ? "OK" : "FAILED"));
            if (z) {
                log("Reset setting flags");
                resetSettingFlagsToDefault();
            }
            return this.currentSession.getState().handleOnOtaCompleted(z);
        }
    }

    private boolean handleOnOtaProgressUpdate(float f) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnOtaProgressUpdate");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnOtaProgressUpdate");
            return false;
        } else {
            this.communicationResultCallback.onOtaProgressUpdated(this.bleAdapter.getSerial(), f);
            return this.currentSession.getState().handleOnOtaProgressUpdate(f);
        }
    }

    private boolean handleOnSetGoalInStepCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetGoalInStepCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetGoalInStepCompleted");
            return false;
        } else {
            log("Set goal in steps: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetGoalInStepCompleted(z);
        }
    }

    private boolean handleOnGetVibrationStrengthCompleted(boolean z, short s) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGetVibrationStrengthCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGetVibrationStrengthCompleted");
            return false;
        } else {
            log("Get vibration strength: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGetVibrationStrengthCompleted(z, s);
        }
    }

    private boolean handleOnSetVibrationStrengthCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetVibrationStrengthCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetVibrationStrengthCompleted");
            return false;
        } else {
            log("Set vibration strength: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetVibrationStrengthCompleted(z);
        }
    }

    private boolean handleOnGetCountDownCompleted(boolean z, CountdownSettings countdownSettings) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnGetCountDownCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnGetCountDownCompleted");
            return false;
        } else {
            log("Get countdown: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnGetCountDownCompleted(z, countdownSettings);
        }
    }

    private boolean handleOnSetCountDownCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetCountDownCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetCountDownCompleted");
            return false;
        } else {
            log("Set countdown: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetCountDownCompleted(z);
        }
    }

    private boolean handleOnPlaySyncAnimationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnPlaySyncAnimationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnPlaySyncAnimationCompleted");
            return false;
        } else {
            log("Play sync animation: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnPlaySyncAnimationCompleted(z);
        }
    }

    private boolean handleOnHardwareLogRead(boolean z, byte[] bArr) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnHardwareLogRead");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnHardwareLogRead");
            return false;
        } else {
            log("Read hardware log: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnHardwareLogRead(z, bArr);
        }
    }

    private boolean handleOnReadRemoteRssiCompleted(boolean z, int i) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnReadRemoteRssiCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnReadRemoteRssiCompleted");
            return false;
        } else {
            log("Read rssi: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnReadRssiCompleted(z, i);
        }
    }

    private boolean handleOnPlayLightCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnPlayLightCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnPlayLightCompleted");
            return false;
        } else {
            log("Play light: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnPlayLightCompleted(z);
        }
    }

    private boolean handleOnPlayVibrationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnPlayVibrationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnPlayVibrationCompleted");
            return false;
        } else {
            log("Play vibe: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnPlayVibrationCompleted(z);
        }
    }

    private boolean handleOnSendNotificationHandControlCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSendNotificationHandControlCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSendNotificationHandControlCompleted");
            return false;
        } else {
            log("Send notification: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSendNotificationHandControlCompleted(z);
        }
    }

    private boolean handleOnClearLastNotificationCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnClearLastNotificationCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnClearLastNotificationCompleted");
            return false;
        } else {
            log("Clear last notification: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnClearLastNotificationCompleted(z);
        }
    }

    private boolean handleOnSetMultipleAlarmsCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetMultipleAlarmsCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetMultipleAlarmsCompleted");
            return false;
        } else {
            log("Set multiple alarms: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetMultipleAlarmsCompleted(z);
        }
    }

    private boolean handleOnVerifyMultipleAlarmsCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnVerifyMultipleAlarmsCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnVerifyMultipleAlarmsCompleted");
            return false;
        } else {
            log("Verify multiple alarms: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnVerifyMultipleAlarmsCompleted(z);
        }
    }

    private boolean handleOnSetMicroAppConfigCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSetMicroAppConfigCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSetMicroAppConfigCompleted");
            return false;
        } else {
            log("Set Micro-App config: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSetMicroAppConfigCompleted(z);
        }
    }

    private boolean handleOnMicroAppEvent(UAppNotification uAppNotification, String str) {
        UAppEnum$UAppError uAppError = uAppNotification.getUAppError();
        MFLogger.d(TAG, "----------------------uAppNotification, serial: " + str + ", handleOnMicroAppEvent: " + uAppNotification.toString());
        if (uAppError == null) {
            MicroAppEventLogger.log(str, uAppNotification.getUAppId().toString(), uAppNotification.getUAppVariant().toString(), "receive_event");
            this.mMicroAppNotifications.put(uAppNotification.getUAppId().name() + uAppNotification.getUAppVariant(), uAppNotification);
            this.communicationResultCallback.onMicroAppEvent(uAppNotification.getUAppId().ordinal(), uAppNotification.getUAppVariant().ordinal(), uAppNotification.getUAppSystemEvent().getId(), str);
        } else if (uAppError == UAppEnum$UAppError.TIMEOUT) {
            this.communicationResultCallback.onMicroAppCancelEvent(uAppNotification.getUAppId().ordinal(), uAppNotification.getUAppVariant().ordinal(), uAppNotification.getUAppSystemEvent().getId(), str);
        } else {
            log("Micro app event: appId: " + uAppNotification.getUAppId() + ", variant:" + uAppNotification.getUAppVariant() + ", error: " + uAppError + " is weird.");
        }
        return true;
    }

    private boolean handleOnSendMicroAppRemoteActivityCompleted(boolean z) {
        if (this.currentSession == null) {
            logNoCurrentSession("handleOnSendMicroAppRemoteActivityCompleted");
            return false;
        } else if (this.currentSession.getState() == null) {
            logNoCurrentState("handleOnSendMicroAppRemoteActivityCompleted");
            return false;
        } else {
            log("Send Micro-App remote activity: " + (z ? "OK" : "FAILED"));
            return this.currentSession.getState().handleOnSendMicroAppRemoteActivityCompleted(z);
        }
    }

    private boolean handleOnReceivedHeartbeat(int i, int i2, String str) {
        this.communicationResultCallback.onHeartBeatDataReceived(i, i2, str);
        return true;
    }

    public void startConnectWithoutTimeout() {
        if (BluetoothUtils.isBluetoothEnable()) {
            queueSessionAndStart(new ConnectWithoutTimeoutSession(this.bleAdapter, this.bleSessionCallback));
        } else {
            MFLogger.e(TAG, "Inside " + TAG + ".startConnectWithoutTimeout - Bluetooth is disable");
        }
    }

    public synchronized void interruptCurrentSession() {
        if (!(this.currentSession == null || this.currentSession.getSessionType() == SessionType.CONNECT_WITHOUT_TIMEOUT)) {
            MFLogger.d(TAG, "Inside " + TAG + ".interruptCurrentSession - currentSession=" + this.currentSession);
            this.currentSession.stop(FailureCode.SESSION_INTERRUPTED);
            this.currentSession = null;
        }
    }

    public void closeConnection() {
        clearSessionQueue();
        if (this.currentSession == null || !(this.currentSession instanceof UnlinkSession)) {
            this.bleAdapter.closeConnection(true);
            this.bleAdapter.hidDisconnect();
        }
    }

    public CommunicateMode getCommunicateMode() {
        if (this.currentSession == null) {
            return CommunicateMode.IDLE;
        }
        return this.currentSession.getCommunicateMode();
    }

    public boolean containSyncMode() {
        CommunicateMode communicateMode;
        CommunicateMode communicateMode2 = getCommunicateMode();
        if (!(communicateMode2 == CommunicateMode.SYNC || this.highSessionQueue == null || this.highSessionQueue.isEmpty())) {
            Iterator it = this.highSessionQueue.iterator();
            while (it.hasNext()) {
                if (((BleSession) it.next()) instanceof SyncSession) {
                    communicateMode = CommunicateMode.SYNC;
                    break;
                }
            }
        }
        communicateMode = communicateMode2;
        return communicateMode == CommunicateMode.SYNC;
    }

    public int getGattState() {
        return this.bleAdapter.getGattState();
    }

    public int getHidState() {
        return this.bleAdapter.getHidState();
    }

    public synchronized void clearSessionQueue() {
        synchronized (this.lowSessionQueue) {
            synchronized (this.highSessionQueue) {
                Iterator it = this.highSessionQueue.iterator();
                while (it.hasNext()) {
                    ((BleSession) it.next()).stop(FailureCode.SESSION_INTERRUPTED);
                }
                this.highSessionQueue.clear();
                it = this.lowSessionQueue.iterator();
                while (it.hasNext()) {
                    ((BleSession) it.next()).stop(FailureCode.SESSION_INTERRUPTED);
                }
                this.lowSessionQueue.clear();
                if (!(this.currentSession == null || (this.currentSession instanceof UnlinkSession))) {
                    interruptCurrentSession();
                }
            }
        }
    }

    protected synchronized boolean queueSessionAndStart(BleSession bleSession) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            MFLogger.d(TAG, "Inside queueSessionAndStart - session=" + bleSession);
            if (bleSession == null) {
                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - input session is NULL.");
            } else {
                bleSession.setDevice(getDeviceType());
                SessionType sessionType = bleSession.getSessionType();
                if (sessionType == SessionType.CONNECT_WITHOUT_TIMEOUT) {
                    if (this.currentSession == null && this.highSessionQueue.isEmpty() && this.lowSessionQueue.isEmpty()) {
                        this.highSessionQueue.offer(bleSession);
                        printQueue();
                        startSessionInQueue();
                    } else {
                        MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Still have session in queue. Not queue ConnectWithoutTimeout Session.");
                        z = false;
                    }
                } else if (this.currentSession == null || this.currentSession.accept(bleSession)) {
                    BleSession bleSession2;
                    SessionType sessionType2;
                    Collection arrayList;
                    Iterator it;
                    Iterator it2;
                    switch (sessionType) {
                        case SPECIAL:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Clean up all sessions and start input session.");
                            log("Input session is a SPECIAL session, interrupt all other ones.");
                            clearSessionQueue();
                            this.highSessionQueue.offer(bleSession);
                            break;
                        case SYNC:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Sync Mode");
                            if (this.currentSession != null && this.currentSession.getSessionType() == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Sync Mode, current session is " + this.currentSession.getSessionType() + ", reject this session.");
                                z = false;
                                break;
                            }
                            Collection arrayList2 = new ArrayList();
                            Iterator it3 = this.highSessionQueue.iterator();
                            while (it3.hasNext()) {
                                bleSession2 = (BleSession) it3.next();
                                sessionType2 = bleSession2.getSessionType();
                                if (sessionType2 != SessionType.CONNECT) {
                                    if (sessionType2 == SessionType.SYNC) {
                                        if (bleSession.getCommunicateMode() != CommunicateMode.SYNC) {
                                            z = false;
                                        } else if (((SyncSession) bleSession).getSyncMode() == 13) {
                                            arrayList2.add(bleSession2);
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            this.highSessionQueue.removeAll(arrayList2);
                                            this.highSessionQueue.offer(bleSession);
                                            break;
                                        }
                                    }
                                    continue;
                                } else {
                                    arrayList2.add(bleSession2);
                                }
                            }
                            if (z) {
                                this.highSessionQueue.removeAll(arrayList2);
                                this.highSessionQueue.offer(bleSession);
                            }
                            break;
                        case CONNECT:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Connect Mode");
                            if (this.currentSession != null && this.currentSession.getSessionType() == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Connect Mode, current session is " + this.currentSession.getSessionType() + ", reject this session.");
                                z = false;
                                break;
                            } else if (this.currentSession == null || !(this.currentSession instanceof ConnectDeviceSession)) {
                                Iterator it4 = this.highSessionQueue.iterator();
                                while (it4.hasNext()) {
                                    if (((BleSession) it4.next()) instanceof ConnectDeviceSession) {
                                        z2 = true;
                                        if (!z2) {
                                            this.highSessionQueue.offer(bleSession);
                                            break;
                                        }
                                    }
                                }
                                if (z2) {
                                    this.highSessionQueue.offer(bleSession);
                                }
                            }
                            break;
                        case UI:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - type:" + sessionType);
                            if (this.currentSession == null) {
                                arrayList = new ArrayList();
                                it = this.highSessionQueue.iterator();
                                while (it.hasNext()) {
                                    bleSession2 = (BleSession) it.next();
                                    if (bleSession2.getSessionType() == SessionType.UI) {
                                        arrayList.add(bleSession2);
                                    }
                                }
                                this.highSessionQueue.removeAll(arrayList);
                                this.highSessionQueue.offer(bleSession);
                                break;
                            }
                            boolean z3;
                            sessionType2 = this.currentSession.getSessionType();
                            if (sessionType2 == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Sync Mode, current session is " + sessionType2 + ", reject this session.");
                                z3 = false;
                            } else if (sessionType2 == SessionType.SYNC || sessionType2 == SessionType.CONNECT || sessionType2 == SessionType.DEVICE_SETTING) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - this UI session will be put in queue. CurrentSessionType: " + sessionType2);
                                arrayList = new ArrayList();
                                it = this.highSessionQueue.iterator();
                                while (it.hasNext()) {
                                    bleSession2 = (BleSession) it.next();
                                    if (bleSession2.getSessionType() == SessionType.UI) {
                                        arrayList.add(bleSession2);
                                    }
                                }
                                this.highSessionQueue.removeAll(arrayList);
                                this.highSessionQueue.offer(bleSession);
                                z3 = true;
                            } else {
                                Collection arrayList3 = new ArrayList();
                                it2 = this.highSessionQueue.iterator();
                                while (it2.hasNext()) {
                                    bleSession2 = (BleSession) it2.next();
                                    if (bleSession2.getSessionType() == SessionType.UI) {
                                        arrayList3.add(bleSession2);
                                    }
                                }
                                this.highSessionQueue.removeAll(arrayList3);
                                if (sessionType2 != SessionType.CONNECT_WITHOUT_TIMEOUT) {
                                    if (sessionType2 == SessionType.UI) {
                                        interruptCurrentSession();
                                    } else {
                                        bleSession2 = this.currentSession.copyObject();
                                        interruptCurrentSession();
                                        if (bleSession2.getSessionType() == SessionType.BACK_GROUND) {
                                            this.lowSessionQueue.offer(bleSession2);
                                        } else {
                                            this.highSessionQueue.offer(bleSession2);
                                        }
                                    }
                                }
                                this.highSessionQueue.offer(bleSession);
                                z3 = true;
                            }
                            z = z3;
                            break;
                        case DEVICE_SETTING:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Micro App Set Up Mode");
                            if (this.currentSession != null && this.currentSession.getSessionType() == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Micro App Set Up Mode, current session is " + this.currentSession.getSessionType() + ", reject this session.");
                                z = false;
                                break;
                            }
                            arrayList = new ArrayList();
                            it2 = this.highSessionQueue.iterator();
                            while (it2.hasNext()) {
                                bleSession2 = (BleSession) it2.next();
                                if (bleSession2.getSessionType() != SessionType.CONNECT) {
                                    if (!bleSession2.accept(bleSession)) {
                                        if (bleSession2.getCommunicateMode() != bleSession.getCommunicateMode()) {
                                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Micro App Set Up Mode, session in queue is " + bleSession2.getCommunicateMode().name() + ", reject this session, communicateMode=" + bleSession.getCommunicateMode().name());
                                            z = false;
                                            if (z) {
                                                this.highSessionQueue.removeAll(arrayList);
                                                this.highSessionQueue.offer(bleSession);
                                                break;
                                            }
                                        }
                                        arrayList.add(bleSession2);
                                    } else {
                                        continue;
                                    }
                                } else {
                                    arrayList.add(bleSession2);
                                }
                            }
                            if (z) {
                                this.highSessionQueue.removeAll(arrayList);
                                this.highSessionQueue.offer(bleSession);
                            }
                            break;
                        case URGENT:
                            if (this.currentSession != null && this.currentSession.getSessionType() == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Urgent Mode, current session is " + this.currentSession.getSessionType() + ", reject this session.");
                                z = false;
                                break;
                            }
                            arrayList = new ArrayList();
                            it = this.highSessionQueue.iterator();
                            while (it.hasNext()) {
                                bleSession2 = (BleSession) it.next();
                                if (bleSession.getClass().getName().equalsIgnoreCase(bleSession2.getClass().getName())) {
                                    arrayList.add(bleSession2);
                                }
                            }
                            this.highSessionQueue.removeAll(arrayList);
                            this.highSessionQueue.offer(bleSession);
                            break;
                            break;
                        default:
                            MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Other Mode");
                            if (this.currentSession != null && this.currentSession.getSessionType() == SessionType.SPECIAL) {
                                MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart - Other Mode, current session is " + this.currentSession.getSessionType() + ", reject this session.");
                                z = false;
                                break;
                            }
                            CommunicateMode communicateMode = bleSession.getCommunicateMode();
                            Collection arrayList4 = new ArrayList();
                            Iterator it5 = this.lowSessionQueue.iterator();
                            while (it5.hasNext()) {
                                boolean z4;
                                bleSession2 = (BleSession) it5.next();
                                if (communicateMode == bleSession2.getCommunicateMode()) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    arrayList4.add(bleSession2);
                                }
                            }
                            this.lowSessionQueue.removeAll(arrayList4);
                            this.lowSessionQueue.offer(bleSession);
                            break;
                            break;
                    }
                    printQueue();
                    if (z) {
                        startSessionInQueue();
                    }
                } else {
                    MFLogger.d(TAG, "Inside " + TAG + ".queueSessionAndStart -Input session is same as current session. Do nothing.");
                    printQueue();
                }
                z2 = z;
            }
        }
        return z2;
    }

    private void printQueue() {
        MFLogger.d(TAG, "Inside " + TAG + ".printQueue - current session=" + (this.currentSession != null ? this.currentSession.getClass().getSimpleName() : "NULL"));
        Iterator it = this.highSessionQueue.iterator();
        while (it.hasNext()) {
            MFLogger.d(TAG, "Inside " + TAG + ".printQueue - high session=" + ((BleSession) it.next()).getClass().getSimpleName());
        }
        it = this.lowSessionQueue.iterator();
        while (it.hasNext()) {
            MFLogger.d(TAG, "Inside " + TAG + ".printQueue - low session=" + ((BleSession) it.next()).getClass().getSimpleName());
        }
    }

    protected synchronized boolean startSessionInQueue() {
        boolean start;
        MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - Starting currentSession=" + this.currentSession);
        BleSession bleSession;
        if (this.currentSession == null) {
            bleSession = (BleSession) this.highSessionQueue.poll();
            if (bleSession == null) {
                bleSession = (BleSession) this.lowSessionQueue.poll();
            }
            if (bleSession != null) {
                this.currentSession = bleSession;
                start = this.currentSession.start(new Object[0]);
            } else {
                MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - queue is empty.");
                int gattState = this.bleAdapter.getGattState();
                if (gattState == 3 || gattState == 0) {
                    MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - gattState " + gattState + ". Connect without timeout.");
                    if (this.bleAdapter.getShineDevice() != null) {
                        this.communicationResultCallback.onTriggerConnectWithoutTimeout(this.bleAdapter.getSerial());
                    } else {
                        MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - shineDevice is null. Cannot trigger connection without timeout.");
                    }
                    start = true;
                } else {
                    start = false;
                }
            }
        } else if (this.currentSession.getSessionType() == SessionType.CONNECT_WITHOUT_TIMEOUT) {
            bleSession = (BleSession) this.highSessionQueue.peek();
            if (bleSession == null) {
                bleSession = (BleSession) this.lowSessionQueue.peek();
            }
            if (bleSession == null || !((bleSession instanceof ConnectableSession) || bleSession.getSessionType() == SessionType.UI || bleSession.getSessionType() == SessionType.SPECIAL)) {
                MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - do not stop connection without timeout and start next session. It is not Connectable session. Stop it.");
                if (bleSession != null) {
                    bleSession = (BleSession) this.highSessionQueue.poll();
                    if (bleSession == null) {
                        bleSession = (BleSession) this.lowSessionQueue.poll();
                    }
                    bleSession.stop(FailureCode.SESSION_INTERRUPTED);
                }
                start = false;
            } else {
                MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - stop connection without timeout to start next session.");
                ((ConnectWithoutTimeoutSession) this.currentSession).closeConnectWithoutTimeout();
                start = true;
            }
        } else {
            MFLogger.d(TAG, "Inside " + TAG + ".startSessionInQueue - a session is exist, session will be start later.");
            start = false;
        }
        return start;
    }

    public synchronized boolean isQueueEmpty() {
        boolean z;
        z = this.highSessionQueue.isEmpty() && this.lowSessionQueue.isEmpty();
        return z;
    }

    public void simulateDisconnection(int i, int i2, int i3, int i4) {
        this.bleAdapter.simulateDisconnection(i, i2, i3, i4);
    }

    public void simulatePusherEvent(int i, int i2, int i3, int i4, int i5) {
        this.bleAdapter.simulatePusherEvent(i, i2, i3, i4, i5);
    }

    public void resetDeviceSettingInFirmwareToDefault() {
        this.bleAdapter.resetDeviceSettingToDefault();
    }

    public boolean isDeviceReady() {
        if (BluetoothUtils.isBluetoothEnable()) {
            return this.bleAdapter.isDeviceReady();
        }
        return false;
    }

    public boolean sendMicroAppRemoteCommand(MicroAppInstruction microAppInstruction) {
        if (this.bleAdapter != null) {
            String str = microAppInstruction.getDeclarationID().name() + microAppInstruction.getVariantID();
            UAppNotification uAppNotification = (UAppNotification) this.mMicroAppNotifications.get(str);
            if (uAppNotification != null) {
                MFLogger.d(TAG, "----------------------uAppNotification " + this.bleAdapter.getSerial() + " sendMicroAppRemoteCommand: " + uAppNotification.toString());
                boolean sendMicroAppRemoteCommand = this.bleAdapter.sendMicroAppRemoteCommand(uAppNotification, microAppInstruction.getInstructions());
                MFLogger.d(TAG, "Inside " + TAG + ".sendMicroAppRemoteCommand " + this.bleAdapter.getSerial() + ", running result: " + sendMicroAppRemoteCommand);
                return sendMicroAppRemoteCommand;
            }
            MFLogger.e(TAG, "----------------------uAppNotification " + this.bleAdapter.getSerial() + " sendMicroAppRemoteCommand, uAppNotification with key[" + str + "] is not exist.");
        } else {
            MFLogger.e(TAG, "Inside " + TAG + ".sendMicroAppRemoteCommand, bleAdapter is null");
        }
        return false;
    }

    public void clearMappingsAndSettingFlags() {
        DevicePreferenceUtils.clearAutoSetMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial());
        DevicePreferenceUtils.clearAllSettingFlag(this.bleAdapter.getContext());
    }

    public void resetSettingFlagsToDefault() {
        Context context = this.bleAdapter.getContext();
        AlarmSettings autoAlarmSetting = DevicePreferenceUtils.getAutoAlarmSetting(context);
        List autoListAlarm = DevicePreferenceUtils.getAutoListAlarm(context);
        CharSequence autoSecondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(context);
        CountdownSettings autoCountDownSetting = DevicePreferenceUtils.getAutoCountDownSetting(context);
        List autoMapping = DevicePreferenceUtils.getAutoMapping(context, this.bleAdapter.getSerial());
        DevicePreferenceUtils.clearAllSettingFlag(context);
        Device deviceType = getDeviceType();
        if (autoAlarmSetting != null && deviceType.isSupportDeviceState(CommunicateMode.SET_ALARM)) {
            DevicePreferenceUtils.setSettingFlag(context, DeviceSettings.SINGLE_ALARM);
        }
        if (!(autoListAlarm == null || autoListAlarm.isEmpty() || !deviceType.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM))) {
            DevicePreferenceUtils.setSettingFlag(context, DeviceSettings.MULTI_ALARM);
        }
        if (!TextUtils.isEmpty(autoSecondTimezoneId) && deviceType.isSupportDeviceState(CommunicateMode.SET_SECOND_TIMEZONE)) {
            DevicePreferenceUtils.setSettingFlag(context, DeviceSettings.SECOND_TIMEZONE);
        }
        if (autoCountDownSetting != null && SettingsUtils.isSupportCountDown(this.bleAdapter.getSerial())) {
            DevicePreferenceUtils.setSettingFlag(context, DeviceSettings.COUNT_DOWN);
        }
        if (autoMapping != null && !autoMapping.isEmpty()) {
            DevicePreferenceUtils.setSettingFlag(context, DeviceSettings.MAPPINGS);
        }
    }

    public synchronized void cancelCalibrationSession() {
        MFLogger.d(TAG, "inside .cancelCalibrationSession - current session=" + this.currentSession);
        if (this.currentSession != null && (this.currentSession instanceof WatchCalibrationSession)) {
            ((WatchCalibrationSession) this.currentSession).handleReleaseHandControl();
        }
        Collection arrayList = new ArrayList();
        printQueue();
        Iterator it = this.highSessionQueue.iterator();
        while (it.hasNext()) {
            BleSession bleSession = (BleSession) it.next();
            if (bleSession instanceof WatchCalibrationSession) {
                arrayList.add(bleSession);
                bleSession.stop(0);
            }
        }
        this.highSessionQueue.removeAll(arrayList);
    }
}
