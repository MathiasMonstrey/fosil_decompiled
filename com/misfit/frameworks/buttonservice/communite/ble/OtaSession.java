package com.misfit.frameworks.buttonservice.communite.ble;

import android.text.TextUtils;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession.ConnectingState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession.PrepareState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession.ScanningFirstStepState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession.WorkaroundHIDConnectingState;
import com.misfit.frameworks.buttonservice.communite.ble.share.PlayAnimationBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetAlarmBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.log.MFOtaLog;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.FirmwareUtils;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Hashtable;
import java.util.List;

public abstract class OtaSession extends ConnectableSession {
    protected static final int OTA_MAX_RETRIES = 7;
    protected static final float OTA_STABLE_THRESHOLD = 10.0f;
    protected final int RESCAN_AFTER_OTA_DELAY = 15000;
    protected AlarmSettings alarmSettings;
    protected byte[] binaryData;
    protected String checksum;
    protected CountdownSettings countdownSettings;
    protected float currentOtaProgress = 0.0f;
    protected boolean isEmbedded;
    protected boolean isTransferCompleted;
    protected float lastOtaFailedProgress = -1.0f;
    protected List<MultipleAlarmSettings> multipleAlarmSettingsList;
    private MFOtaLog otaLog;
    protected long realTimeSteps;
    protected String secondTimezoneId;
    protected int secondTimezoneOffset;
    protected long stepGoal;
    protected String targetFirmwareVersion;
    protected short vibeStrength = (short) 0;

    public final class ConnectingAfterOtaState extends ConnectingState {
        public ConnectingAfterOtaState() {
            super();
            this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_AFTER_OTA;
        }

        public boolean handleOnDeviceConnected() {
            MFLogger.d(OtaSession.this.TAG, "Inside " + OtaSession.this.TAG + ".handleOnDeviceConnected - Connect to device after OTA successfully");
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.PREPARE_AFTER_OTA_STATE));
            return true;
        }

        protected void processActionResult(ConnectActionResult connectActionResult) {
            if (connectActionResult.getResultCode() != ConnectionResult.TIMED_OUT) {
                return;
            }
            if (this.isScannedDevice) {
                this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_BY_SCANNED_DEVICE_TIMEOUT;
            } else {
                this.failureCodeOfState = FailureCode.FAILED_TO_CONNECT_AFTER_OTA_TIMEOUT;
            }
        }

        protected void onFatal(int i) {
            OtaSession.this.maxRetries = 0;
            super.onFatal(i);
        }
    }

    public class GetDeviceConfigurationAfterOtaState extends BleState {
        public GetDeviceConfigurationAfterOtaState() {
            super(OtaSession.this.TAG);
            OtaSession.this.log("Get device configuration of device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (OtaSession.this.bleAdapter.getDeviceConfiguration(OtaSession.this.device)) {
                return true;
            }
            stopTimeout();
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            OtaSession.this.enterStateWithDelayTime(OtaSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            OtaSession.this.log("Get configuration timeout");
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                logConfigurationAfterOTA(hashtable);
            } else {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            }
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        private void logConfigurationAfterOTA(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                ShineConfiguration shineConfiguration = null;
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                }
                if (shineConfiguration != null) {
                    OtaSession.this.log(String.format("Get configuration  " + OtaSession.this.serial + "\n\t[timeConfiguration: \n\t{milliseconds = %d;\n\ttimeZoneOffsetInMinutes = %d;\n\ttimestamp = %d;}, \n\tgoalValue: %d, \n\tactivityTaggingState: %d, \n\tactivityPoint: %d, \n\tbatteryLevel: %d, \n\tvibrationStrength: %d, \n\trealTimeSteps: %d\t]", new Object[]{Integer.valueOf(configurationSession.mPartialSecond), Short.valueOf(configurationSession.mTimeZoneOffset), Long.valueOf(configurationSession.mTimestamp), Long.valueOf(shineConfiguration.mGoalInSteps), Byte.valueOf(shineConfiguration.mActivityTaggingState), Long.valueOf(shineConfiguration.mActivityPoint), Short.valueOf(shineConfiguration.mBatteryLevel), Short.valueOf(shineConfiguration.mVibeStrength), Long.valueOf(shineConfiguration.mCurrentSteps)}));
                    if (OtaSession.this.otaLog != null) {
                        OtaSession.this.otaLog.setBatteryLevel(shineConfiguration.mBatteryLevel);
                    }
                }
            }
        }
    }

    public class GetDeviceConfigurationState extends BleState {
        public GetDeviceConfigurationState() {
            super(OtaSession.this.TAG);
            OtaSession.this.log("Get configuration of device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (OtaSession.this.bleAdapter.getDeviceConfiguration(OtaSession.this.device)) {
                return true;
            }
            stopTimeout();
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            OtaSession.this.enterStateWithDelayTime(OtaSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                storeValue(hashtable);
                logConfiguration(hashtable);
            } else {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            }
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            OtaSession.this.log("Get config params timeout.");
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE));
        }

        protected void storeValue(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    OtaSession.this.stepGoal = Math.max(shineConfiguration.mGoalInSteps, OtaSession.this.stepGoal);
                    OtaSession.this.realTimeSteps = Math.max(shineConfiguration.mCurrentSteps, OtaSession.this.realTimeSteps);
                    return;
                }
                MFLogger.d(OtaSession.this.TAG, "Inside " + OtaSession.this.TAG + ", storeValue failed, shineConfiguration is null");
            }
        }

        protected void logConfiguration(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                ShineConfiguration shineConfiguration = null;
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                }
                if (shineConfiguration != null) {
                    OtaSession.this.log(String.format("Get configuration  " + OtaSession.this.serial + "\n\t[timeConfiguration: \n\t{milliseconds = %d;\n\ttimeZoneOffsetInMinutes = %d;\n\ttimestamp = %d;}, \n\tgoalValue: %d, \n\tactivityTaggingState: %d, \n\tactivityPoint: %d, \n\tbatteryLevel: %d, \n\tvibrationStrength: %d, \n\trealTimeSteps: %d\t]", new Object[]{Integer.valueOf(configurationSession.mPartialSecond), Short.valueOf(configurationSession.mTimeZoneOffset), Long.valueOf(configurationSession.mTimestamp), Long.valueOf(shineConfiguration.mGoalInSteps), Byte.valueOf(shineConfiguration.mActivityTaggingState), Long.valueOf(shineConfiguration.mActivityPoint), Short.valueOf(shineConfiguration.mBatteryLevel), Short.valueOf(shineConfiguration.mVibeStrength), Long.valueOf(shineConfiguration.mCurrentSteps)}));
                    OtaSession.this.vibeStrength = shineConfiguration.mVibeStrength;
                    if (OtaSession.this.otaLog != null) {
                        OtaSession.this.otaLog.setBatteryLevel(shineConfiguration.mBatteryLevel);
                    }
                }
            }
        }
    }

    public final class PlayAnimationAfterOtaState extends PlayAnimationBaseState {
        public PlayAnimationAfterOtaState() {
            super(OtaSession.this.bleAdapter, OtaSession.this);
            OtaSession.this.log("Play animation of device with serial " + OtaSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                OtaSession.this.addFailureCode(201);
            }
            return OtaSession.this.createConcreteState(SessionState.READ_FIRMWARE_VERSION_AFTER_OTA_STATE);
        }

        protected BleState getStateOnTimeOut() {
            OtaSession.this.addFailureCode(201);
            return OtaSession.this.createConcreteState(SessionState.READ_FIRMWARE_VERSION_AFTER_OTA_STATE);
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }
    }

    public final class PrepareAfterOtaState extends PrepareState {
        public PrepareAfterOtaState() {
            super();
            this.failureCodeOfState = FailureCode.FAILED_TO_PREPARE_AFTER_OTA;
        }

        public boolean handleOnDevicePreparedCompleted(boolean z) {
            stopTimeout();
            if (z) {
                OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.PLAY_ANIMATION_AFTER_OTA_STATE));
            } else {
                OtaSession.this.stop(this.failureCodeOfState);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class ReadFirmwareVersionAfterOtaState extends BleState {
        public ReadFirmwareVersionAfterOtaState() {
            super(OtaSession.this.TAG);
            OtaSession.this.log("Read firmware version of device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            Object firmwareVersion = OtaSession.this.bleAdapter.getFirmwareVersion();
            MFLogger.d(OtaSession.this.TAG, "Inside " + OtaSession.this.TAG + ".ReadFirmwareVersionAfterOtaState - currentVersion=" + firmwareVersion + ", targetVersion=" + OtaSession.this.targetFirmwareVersion);
            OtaSession.this.log(String.format("Read firmware version %s, currentDeviceFw=%s, targetFw=%s", new Object[]{OtaSession.this.serial, firmwareVersion, OtaSession.this.targetFirmwareVersion}));
            if (TextUtils.isEmpty(firmwareVersion) || !firmwareVersion.equals(OtaSession.this.targetFirmwareVersion)) {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_OTA_FW_NOT_MATCH);
            }
            startTimeout();
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            OtaSession.this.log("Read firmware timeout");
            OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_AFTER_OTA_STATE));
        }

        public int getTimeout() {
            return 2000;
        }
    }

    public final class ScanningFirstStepAfterOtaState extends ScanningFirstStepState {
        public ScanningFirstStepAfterOtaState() {
            super();
        }

        protected BleState stateAfterFoundDevice(int i) {
            if (i == 0) {
                return OtaSession.this.createConcreteState(SessionState.CONNECTING_AFTER_OTA_STATE);
            }
            BleState createConcreteState = OtaSession.this.createConcreteState(SessionState.WORKAROUND_HID_CONNECTING_AFTER_OTA_STATE);
            ((WorkaroundHIDConnectingAfterOtaState) createConcreteState).setIsScannedDevice(i == 2);
            return createConcreteState;
        }
    }

    public class SendingFileState extends BleState {
        private int currentProgress;
        private boolean isWaitingForDisconnect;

        class C47021 implements Runnable {
            C47021() {
            }

            public void run() {
                SendingFileState.this.handleOnOtaCompleted(true);
            }
        }

        public SendingFileState() {
            super(OtaSession.this.TAG);
            this.currentProgress = -1;
            this.isWaitingForDisconnect = false;
            this.isWaitingForDisconnect = false;
            OtaSession.this.log(String.format("Updating firmware %s, currentFw=%s, newFw=%s", new Object[]{r5.serial, r5.bleAdapter.getFirmwareVersion(), r5.targetFirmwareVersion}));
        }

        public int getTimeout() {
            return 20000;
        }

        public boolean onEnter() {
            super.onEnter();
            if (OtaSession.this.binaryData == null || OtaSession.this.binaryData.length == 0) {
                OtaSession.this.stop(FailureCode.FAILED_TO_OTA_FILE_NOT_READY);
                return false;
            }
            boolean z;
            startTimeout();
            ShineProfile shineProfile = OtaSession.this.bleAdapter.getShineProfile();
            if (shineProfile != null) {
                String firmwareVersion = shineProfile.getFirmwareVersion();
                if (firmwareVersion != null && firmwareVersion.equals(OtaSession.this.targetFirmwareVersion)) {
                    stopTimeout();
                    OtaSession.this.enterTaskWithDelayTime(new C47021(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return true;
                }
            }
            BleAdapter bleAdapter = OtaSession.this.bleAdapter;
            byte[] bArr = OtaSession.this.binaryData;
            if (OtaSession.this.otaLog.getRetries() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (bleAdapter.doOTA(bArr, z)) {
                return true;
            }
            stopTimeout();
            OtaSession.this.stop(FailureCode.FAILED_TO_OTA);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            OtaSession.this.log("Start OTA timeout");
            OtaSession.this.stop(FailureCode.FAILED_TO_OTA);
        }

        public boolean handleOnOtaProgressUpdate(float f) {
            MFLogger.d(MFLogManager.TAG, "OTA progress: " + f);
            int i = (int) f;
            if (i != this.currentProgress) {
                this.currentProgress = i;
                if (OtaSession.this.otaLog != null) {
                    OtaSession.this.otaLog.setProgress((float) i);
                    OtaSession.this.otaLog.log("OTA progress: " + i);
                }
            }
            if (OtaSession.this.lastOtaFailedProgress > 0.0f && f - OtaSession.this.lastOtaFailedProgress > OtaSession.OTA_STABLE_THRESHOLD) {
                OtaSession.this.resetRetriesCounter();
                OtaSession.this.lastOtaFailedProgress = -1.0f;
            }
            OtaSession.this.currentOtaProgress = f;
            stopTimeout();
            return true;
        }

        public boolean handleOnOtaCompleted(boolean z) {
            stopTimeout();
            if (z) {
                this.isWaitingForDisconnect = true;
                OtaSession.this.bleAdapter.notBroadCastDisconnectionState();
                OtaSession.this.enterStateWithDelayTime(OtaSession.this.createConcreteState(SessionState.SCANNING_FIRST_STEP_AFTER_OTA_STATE), 15000);
            } else {
                OtaSession.this.lastOtaFailedProgress = OtaSession.this.currentOtaProgress;
                OtaSession.this.stop(FailureCode.FAILED_TO_OTA);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            if (this.isWaitingForDisconnect) {
                this.isWaitingForDisconnect = false;
            } else {
                OtaSession.this.log("Start OTA. Device disconnected");
                stopTimeout();
                OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            }
            return true;
        }
    }

    public class SetAlarmAfterOtaState extends SetAlarmBaseState {
        public SetAlarmAfterOtaState() {
            super(OtaSession.this.alarmSettings, OtaSession.this.bleAdapter, OtaSession.this);
            OtaSession.this.log("Set alarm of device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            if (OtaSession.this.device != null && OtaSession.this.device.isSupportDeviceState(CommunicateMode.SET_ALARM)) {
                return super.onEnter();
            }
            OtaSession.this.log("Single alarm function is not supported");
            DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            OtaSession.this.enterStateWithDelayTime(OtaSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_AFTER_OTA_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            } else {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            }
            return OtaSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_AFTER_OTA_STATE);
        }

        protected BleState getStateOnTimeOut() {
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            return OtaSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_AFTER_OTA_STATE);
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(OtaSession.this.TAG);
            OtaSession.this.log("Set connection params to device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (OtaSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            OtaSession.this.stop(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            OtaSession.this.log("Set connection params timeout.");
            OtaSession.this.stop(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (z) {
                OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.SENDING_FILE_STATE));
            } else if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                OtaSession.this.enterState(OtaSession.this.createConcreteState(SessionState.SENDING_FILE_STATE));
            } else {
                OtaSession.this.stop(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            }
            return true;
        }
    }

    public class SetDeviceConfigurationState extends BleState {
        private boolean countDownSupport;
        private boolean secondTimeZoneSupport;

        public SetDeviceConfigurationState() {
            super(OtaSession.this.TAG);
            boolean z = OtaSession.this.device != null && OtaSession.this.device.isSupportDeviceState(CommunicateMode.SET_SECOND_TIMEZONE);
            this.secondTimeZoneSupport = z;
            this.countDownSupport = SettingsUtils.isSupportCountDown(OtaSession.this.bleAdapter.getSerial());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set device configuration  " + OtaSession.this.serial + "\n");
            stringBuilder.append("\tstepGoals: " + OtaSession.this.stepGoal + ", \n");
            stringBuilder.append("\trealTimeSteps: " + OtaSession.this.realTimeSteps + ", \n");
            if (this.secondTimeZoneSupport) {
                stringBuilder.append("\tsecondTimezoneOffset: " + OtaSession.this.secondTimezoneOffset);
            }
            if (this.countDownSupport) {
                stringBuilder.append("\tcountDown: " + OtaSession.this.countdownSettings.toString());
            }
            OtaSession.this.log(stringBuilder.toString());
        }

        private ShineConfiguration prepareData() {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            shineConfiguration.mGoalInSteps = OtaSession.this.stepGoal;
            shineConfiguration.mCurrentSteps = OtaSession.this.realTimeSteps;
            if (OtaSession.this.vibeStrength != (short) 0) {
                shineConfiguration.mVibeStrength = OtaSession.this.vibeStrength;
            }
            if (this.secondTimeZoneSupport) {
                shineConfiguration.mTimezoneOffset = (short) OtaSession.this.secondTimezoneOffset;
            }
            if (this.countDownSupport) {
                shineConfiguration.mCountdownSettings = OtaSession.this.countdownSettings;
            }
            return shineConfiguration;
        }

        public boolean onEnter() {
            super.onEnter();
            ShineConfiguration prepareData = prepareData();
            startTimeout();
            if (OtaSession.this.bleAdapter.setDeviceConfiguration(prepareData)) {
                return true;
            }
            stopTimeout();
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            BleState nextState = getNextState();
            if (nextState != null) {
                OtaSession.this.enterStateWithDelayTime(nextState, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            OtaSession.this.log("Set device configuration timeout");
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            OtaSession.this.enterState(getNextState());
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
                DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
            } else {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            }
            OtaSession.this.enterState(getNextState());
            return true;
        }

        protected BleState getNextState() {
            return OtaSession.this.createConcreteState(SessionState.SET_ALARM_AFTER_OTA_STATE);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            OtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetMultipleAlarmsAfterOtaState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsAfterOtaState() {
            super(OtaSession.this.multipleAlarmSettingsList, OtaSession.this.bleAdapter, OtaSession.this);
            OtaSession.this.log("Set multiple alarms of device with serial " + OtaSession.this.serial);
        }

        public boolean onEnter() {
            if (OtaSession.this.device != null && OtaSession.this.device.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM)) {
                return super.onEnter();
            }
            OtaSession.this.log("Multi alarm function is not supported");
            DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            OtaSession.this.enterStateWithDelayTime(OtaSession.this.getStateAfterSetMultipleAlarm(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(OtaSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            } else {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_ALARM);
            }
            return OtaSession.this.getStateAfterSetMultipleAlarm();
        }

        protected BleState getStateOnTimeOut() {
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_ALARM);
            return OtaSession.this.getStateAfterSetMultipleAlarm();
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(OtaSession.this.bleAdapter, OtaSession.this);
        }

        protected BleState getStateOnCompleted(boolean z) {
            OtaSession.this.log("Stop streaming to " + OtaSession.this.serial + (z ? ". OK" : ". FAILED"));
            if (!z) {
                OtaSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            }
            return OtaSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE);
        }

        protected BleState getStateOnTimeOut() {
            OtaSession.this.log("Stop streaming timeout");
            OtaSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            return OtaSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE);
        }

        protected boolean isSkipStopStreaming() {
            return OtaSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public final class WorkaroundHIDConnectingAfterOtaState extends WorkaroundHIDConnectingState {
        protected WorkaroundHIDConnectingAfterOtaState() {
            super();
        }

        protected BleState stateAfterDone() {
            ConnectingAfterOtaState connectingAfterOtaState = (ConnectingAfterOtaState) OtaSession.this.createConcreteState(SessionState.CONNECTING_AFTER_OTA_STATE);
            connectingAfterOtaState.setIsScannedDevice(this.isScannedDevice);
            return connectingAfterOtaState;
        }
    }

    public abstract BleState getStateAfterSetMultipleAlarm();

    public OtaSession(byte[] bArr, boolean z, String str, String str2, long j, long j2, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.SPECIAL, CommunicateMode.OTA, bleAdapter, bleSessionCallback, sdkCallback);
        this.isEmbedded = z;
        this.checksum = str;
        this.maxRetries = 7;
        this.binaryData = bArr;
        this.targetFirmwareVersion = str2;
        this.stepGoal = j;
        this.realTimeSteps = j2;
        this.isTransferCompleted = false;
    }

    public void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_STATE, GetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SENDING_FILE_STATE, SendingFileState.class.getName());
        this.sessionStateMap.put(SessionState.SCANNING_FIRST_STEP_AFTER_OTA_STATE, ScanningFirstStepAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.WORKAROUND_HID_CONNECTING_AFTER_OTA_STATE, WorkaroundHIDConnectingAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.CONNECTING_AFTER_OTA_STATE, ConnectingAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.PREPARE_AFTER_OTA_STATE, PrepareAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.PLAY_ANIMATION_AFTER_OTA_STATE, PlayAnimationAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.READ_FIRMWARE_VERSION_AFTER_OTA_STATE, ReadFirmwareVersionAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_AFTER_OTA_STATE, GetDeviceConfigurationAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.SET_DEVICE_CONFIGURATION_STATE, SetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.SET_ALARM_AFTER_OTA_STATE, SetAlarmAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_AFTER_OTA_STATE, SetMultipleAlarmsAfterOtaState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (getRetriesCounter() == 0) {
            this.otaLog = MFLogManager.getInstance(this.bleAdapter.getContext()).startOtaLog(this.serial);
            this.mfLog = this.otaLog;
            if (this.otaLog != null) {
                String firmwareVersion = this.bleAdapter.getFirmwareVersion();
                this.otaLog.setFirmwareVersion(firmwareVersion);
                this.otaLog.setSerial(this.serial);
                this.otaLog.setOldFirmware(firmwareVersion);
                this.otaLog.setNewFirmware(this.targetFirmwareVersion);
            }
        }
        MFLogger.i(this.TAG, "START OTA SESSION - targetFirmware=" + this.targetFirmwareVersion + ", fileLen=" + (this.binaryData != null ? Integer.valueOf(this.binaryData.length) : "NULL") + ", stepGoal=" + this.stepGoal + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        log("Start new ota session: stepGoal=" + this.stepGoal + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        log("Verifying firmware...");
        log("- Version: " + this.targetFirmwareVersion);
        log("- Checksum: " + this.checksum);
        log("- Length: " + (this.binaryData != null ? Integer.valueOf(this.binaryData.length) : "Empty"));
        log("- In-app Bundled: " + this.isEmbedded);
        if (this.isEmbedded) {
            log("In-app bundled firmware, skip verifying!");
        } else if (FirmwareUtils.verifyFirmware(this.binaryData, this.checksum)) {
            log("Verified: OK");
        } else {
            log("Verified: FAILED. Skip OTA");
            stop(FailureCode.FAILED_TO_OTA_FILE_NOT_READY);
            return false;
        }
        initSettings();
        return super.onStart(objArr);
    }

    public void initSettings() {
        this.alarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
        this.multipleAlarmSettingsList = DevicePreferenceUtils.getAutoListAlarm(this.context);
        this.secondTimezoneOffset = DevicePreferenceUtils.getAutoSecondTimezone(this.context);
        this.secondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(this.context);
        this.countdownSettings = DevicePreferenceUtils.getAutoCountDownSetting(this.context);
    }

    protected boolean canRetry(int i, int i2) {
        if (getLastFailureCode() == FailureCode.FAILED_TO_OTA_FILE_NOT_READY || i >= getMaxRetries()) {
            return false;
        }
        if (this.otaLog != null) {
            this.otaLog.setRetries(this.otaLog.getRetries() + 1);
            MFLogger.d(this.TAG, "Inside " + this.TAG + ".canRetry - counter=" + this.otaLog.getRetries());
        }
        return true;
    }

    private void resetRetriesCounter() {
        setRetriesCounter(0);
    }

    protected BleState getFirstState() {
        if (this.isTransferCompleted) {
            return createConcreteState(SessionState.SCANNING_FIRST_STEP_AFTER_OTA_STATE);
        }
        return createConcreteState(SessionState.SCANNING_FIRST_STEP_STATE);
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_STATE);
    }

    protected void onStop(int i) {
        super.onStop(i);
    }

    protected void buildExtraInfoReturned() {
        MFLog end = MFLogManager.getInstance(this.bleAdapter.getContext()).end(CommunicateMode.OTA, this.serial);
        this.extraInfoReturned.putInt(ButtonService.LOG_ID, end != null ? end.getStartTimeEpoch() : 0);
        this.extraInfoReturned.putParcelable(Constants.DEVICE, MisfitDeviceProfile.cloneFrom(this.bleAdapter));
    }
}
