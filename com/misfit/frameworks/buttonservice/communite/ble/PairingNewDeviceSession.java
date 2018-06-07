package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.PlayAnimationBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetAlarmBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.Hashtable;
import java.util.List;

public abstract class PairingNewDeviceSession extends ConnectableSession {
    protected AlarmSettings alarmSettings;
    protected CountdownSettings countdownSettings;
    protected Device device;
    protected List<MultipleAlarmSettings> multipleAlarmSettingsList;
    protected String secondTimezoneId;
    protected int secondTimezoneOffset;

    public class EraseFileState extends BleState {
        public EraseFileState() {
            super(PairingNewDeviceSession.this.TAG);
            PairingNewDeviceSession.this.log("Erase file of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PairingNewDeviceSession.this.bleAdapter.eraseFiles(true)) {
                return true;
            }
            stopTimeout();
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnDataReadCompleted(boolean z) {
            stopTimeout();
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            PairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            PairingNewDeviceSession.this.log("Erase file timeout.");
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
        }
    }

    public class GetConfigState extends BleState {
        public GetConfigState() {
            super(PairingNewDeviceSession.this.TAG);
            PairingNewDeviceSession.this.log("Get device config of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PairingNewDeviceSession.this.bleAdapter.getDeviceConfiguration(PairingNewDeviceSession.this.device)) {
                return true;
            }
            stopTimeout();
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.PLAY_ANIMATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                logConfiguration(hashtable);
                PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.PLAY_ANIMATION_STATE));
            } else {
                PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
                PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.PLAY_ANIMATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            PairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            PairingNewDeviceSession.this.log("Get config params timeout.");
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.PLAY_ANIMATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        private void logConfiguration(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                ShineConfiguration shineConfiguration = null;
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                }
                if (shineConfiguration != null) {
                    PairingNewDeviceSession.this.log(String.format("Get configuration  " + PairingNewDeviceSession.this.serial + "\n\t[timeConfiguration: \n\t{milliseconds = %d;\n\ttimeZoneOffsetInMinutes = %d;\n\ttimestamp = %d;}, \n\tgoalValue: %d, \n\tactivityTaggingState: %d, \n\tactivityPoint: %d, \n\tbatteryLevel: %d, \n\t]", new Object[]{Integer.valueOf(configurationSession.mPartialSecond), Short.valueOf(configurationSession.mTimeZoneOffset), Long.valueOf(configurationSession.mTimestamp), Long.valueOf(shineConfiguration.mGoalInSteps), Byte.valueOf(shineConfiguration.mActivityTaggingState), Long.valueOf(shineConfiguration.mActivityPoint), Short.valueOf(shineConfiguration.mBatteryLevel)}));
                }
            }
        }
    }

    public class PlayAnimationState extends PlayAnimationBaseState {
        public PlayAnimationState() {
            super(PairingNewDeviceSession.this.bleAdapter, PairingNewDeviceSession.this);
            PairingNewDeviceSession.this.log("Play animation of device with serial " + PairingNewDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                PairingNewDeviceSession.this.addFailureCode(201);
            }
            return PairingNewDeviceSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE);
        }

        protected BleState getStateOnTimeOut() {
            PairingNewDeviceSession.this.addFailureCode(201);
            return PairingNewDeviceSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE);
        }
    }

    public class ReadHardwareLogState extends BleState {
        public ReadHardwareLogState() {
            super(PairingNewDeviceSession.this.TAG);
            PairingNewDeviceSession.this.log("Read hardware log of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PairingNewDeviceSession.this.bleAdapter.readHardwareLog(true)) {
                return true;
            }
            stopTimeout();
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.ERASE_FILE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            PairingNewDeviceSession.this.log("Read hardware log timeout");
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.ERASE_FILE_STATE));
        }

        public boolean handleOnHardwareLogRead(boolean z, byte[] bArr) {
            stopTimeout();
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.ERASE_FILE_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            PairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetAlarmAfterPairingState extends SetAlarmBaseState {
        public SetAlarmAfterPairingState() {
            super(PairingNewDeviceSession.this.alarmSettings, PairingNewDeviceSession.this.bleAdapter, PairingNewDeviceSession.this);
            PairingNewDeviceSession.this.log("Set alarm of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            if (PairingNewDeviceSession.this.device != null && PairingNewDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_ALARM)) {
                return super.onEnter();
            }
            PairingNewDeviceSession.this.log("Single alarm function is not supported");
            DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALAMRS_AFTER_PAIRING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            } else {
                PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return PairingNewDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALAMRS_AFTER_PAIRING_STATE);
        }

        protected BleState getStateOnTimeOut() {
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return PairingNewDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALAMRS_AFTER_PAIRING_STATE);
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(PairingNewDeviceSession.this.TAG);
            PairingNewDeviceSession.this.log("Set connection params of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PairingNewDeviceSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_ALARM_AFTER_PAIRING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_ALARM_AFTER_PAIRING_STATE));
            return true;
        }

        protected void onFatal(int i) {
            stopTimeout();
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_ALARM_AFTER_PAIRING_STATE));
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            PairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            PairingNewDeviceSession.this.log("Prepare timeout.");
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_ALARM_AFTER_PAIRING_STATE));
        }
    }

    public class SetDeviceConfigurationState extends BleState {
        private boolean countDownSupport;
        private boolean secondTimeZoneSupport;

        public SetDeviceConfigurationState() {
            super(PairingNewDeviceSession.this.TAG);
            boolean z = PairingNewDeviceSession.this.device != null && PairingNewDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_SECOND_TIMEZONE);
            this.secondTimeZoneSupport = z;
            this.countDownSupport = SettingsUtils.isSupportCountDown(PairingNewDeviceSession.this.serial);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set device configuration  " + PairingNewDeviceSession.this.serial + "\n");
            stringBuilder.append("\trealTimeSteps: 0, \n");
            if (this.secondTimeZoneSupport) {
                stringBuilder.append("\tsecondTimezoneOffset: " + PairingNewDeviceSession.this.secondTimezoneOffset);
            }
            if (this.countDownSupport) {
                stringBuilder.append("\tcountdown: " + PairingNewDeviceSession.this.countdownSettings.toString());
            }
            PairingNewDeviceSession.this.log(stringBuilder.toString());
        }

        private ShineConfiguration prepareData() {
            ShineConfiguration shineConfiguration = new ShineConfiguration();
            shineConfiguration.mCurrentSteps = 0;
            if (this.secondTimeZoneSupport) {
                shineConfiguration.mTimezoneOffset = (short) PairingNewDeviceSession.this.secondTimezoneOffset;
            }
            if (this.countDownSupport) {
                shineConfiguration.mCountdownSettings = PairingNewDeviceSession.this.countdownSettings;
            }
            return shineConfiguration;
        }

        public boolean onEnter() {
            super.onEnter();
            ShineConfiguration prepareData = prepareData();
            startTimeout();
            if (PairingNewDeviceSession.this.bleAdapter.setDeviceConfiguration(prepareData)) {
                return true;
            }
            stopTimeout();
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            PairingNewDeviceSession.this.log("Set device configuration timeout");
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
                DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
            } else {
                PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
            }
            PairingNewDeviceSession.this.enterState(PairingNewDeviceSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            PairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetMultipleAlarmsAfterPairingState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsAfterPairingState() {
            super(PairingNewDeviceSession.this.multipleAlarmSettingsList, PairingNewDeviceSession.this.bleAdapter, PairingNewDeviceSession.this);
            PairingNewDeviceSession.this.log("Set multiple alarms of device with serial " + PairingNewDeviceSession.this.serial);
        }

        public boolean onEnter() {
            if (PairingNewDeviceSession.this.device != null && PairingNewDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM)) {
                return super.onEnter();
            }
            PairingNewDeviceSession.this.log("Multi alarm function is not supported");
            DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            PairingNewDeviceSession.this.enterStateWithDelayTime(PairingNewDeviceSession.this.getStateAfterSetMultipleAlarm(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(PairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            } else {
                PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return PairingNewDeviceSession.this.getStateAfterSetMultipleAlarm();
        }

        protected BleState getStateOnTimeOut() {
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return PairingNewDeviceSession.this.getStateAfterSetMultipleAlarm();
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(PairingNewDeviceSession.this.bleAdapter, PairingNewDeviceSession.this);
            PairingNewDeviceSession.this.log("Stop streaming of device with serial " + PairingNewDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            }
            return PairingNewDeviceSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE);
        }

        protected BleState getStateOnTimeOut() {
            PairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            return PairingNewDeviceSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE);
        }

        protected boolean isSkipStopStreaming() {
            return PairingNewDeviceSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public abstract BleState getStateAfterSetMultipleAlarm();

    public PairingNewDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.SPECIAL, CommunicateMode.LINK, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_STATE, GetConfigState.class.getName());
        this.sessionStateMap.put(SessionState.PLAY_ANIMATION_STATE, PlayAnimationState.class.getName());
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.READ_HARDWARE_LOG_STATE, ReadHardwareLogState.class.getName());
        this.sessionStateMap.put(SessionState.ERASE_FILE_STATE, EraseFileState.class.getName());
        this.sessionStateMap.put(SessionState.SET_DEVICE_CONFIGURATION_STATE, SetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_ALARM_AFTER_PAIRING_STATE, SetAlarmAfterPairingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALAMRS_AFTER_PAIRING_STATE, SetMultipleAlarmsAfterPairingState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        log("STARTING PAIRING FLOW WITH " + this.serial + ", " + this.bleAdapter.getMacAddress());
        if (this.mfLog != null) {
            this.mfLog.setSerial(this.serial);
        }
        initSettings();
        return super.onStart(new Object[0]);
    }

    public void initSettings() {
        this.alarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
        this.multipleAlarmSettingsList = DevicePreferenceUtils.getAutoListAlarm(this.context);
        this.secondTimezoneOffset = DevicePreferenceUtils.getCurrentSecondTimezoneOffset(this.context);
        this.secondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(this.context);
        this.countdownSettings = DevicePreferenceUtils.getAutoCountDownSetting(this.context);
    }

    protected boolean containConnectState() {
        return true;
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_STATE);
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putParcelable(Constants.DEVICE, MisfitDeviceProfile.cloneFrom(this.bleAdapter));
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
