package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class SetAutoMultiAlarmSession extends SetAutoSettingsSession {
    private List<MultipleAlarmSettings> mMultiAlarmSettings;
    private List<MultipleAlarmSettings> mOldMultiAlarmSettings;
    private SdkCallback mSdkCallback;

    public class DoneSetAutoMultiAlarmState extends BleState {
        public DoneSetAutoMultiAlarmState() {
            super(SetAutoMultiAlarmSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetAutoMultiAlarmSession.this.TAG, "All done of " + SetAutoMultiAlarmSession.this.TAG);
            SetAutoMultiAlarmSession.this.stop(0);
            return true;
        }
    }

    public class SetMultipleAlarmsState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsState() {
            super(SetAutoMultiAlarmSession.this.mMultiAlarmSettings, SetAutoMultiAlarmSession.this.bleAdapter, SetAutoMultiAlarmSession.this);
            SetAutoMultiAlarmSession.this.log("Multiple alarms of device with serial " + SetAutoMultiAlarmSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                SetAutoMultiAlarmSession.this.storeSettings(SetAutoMultiAlarmSession.this.mMultiAlarmSettings, false);
                return SetAutoMultiAlarmSession.this.createConcreteState(SessionState.START_STREAMING_AGAIN_STATE);
            }
            SetAutoMultiAlarmSession.this.storeSettings(SetAutoMultiAlarmSession.this.mMultiAlarmSettings, true);
            SetAutoMultiAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            SetAutoMultiAlarmSession.this.storeSettings(SetAutoMultiAlarmSession.this.mMultiAlarmSettings, true);
            SetAutoMultiAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return null;
        }
    }

    public class StartStreamingAgainState extends BleState {
        public StartStreamingAgainState() {
            super(SetAutoMultiAlarmSession.this.TAG);
            SetAutoMultiAlarmSession.this.log("Start streaming to device with serial " + SetAutoMultiAlarmSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetAutoMultiAlarmSession.this.bleAdapter.startStreaming(SetAutoMultiAlarmSession.this.mSdkCallback)) {
                return true;
            }
            stopTimeout();
            SetAutoMultiAlarmSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            SetAutoMultiAlarmSession.this.enterStateWithDelayTime(SetAutoMultiAlarmSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                SetAutoMultiAlarmSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            SetAutoMultiAlarmSession.this.enterStateWithDelayTime(SetAutoMultiAlarmSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetAutoMultiAlarmSession.this.log("Start streaming time out");
            SetAutoMultiAlarmSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            SetAutoMultiAlarmSession.this.enterStateWithDelayTime(SetAutoMultiAlarmSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(SetAutoMultiAlarmSession.this.bleAdapter, SetAutoMultiAlarmSession.this);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return SetAutoMultiAlarmSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
            }
            SetAutoMultiAlarmSession.this.stop(FailureCode.FAILED_TO_STOP_STREAMING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            SetAutoMultiAlarmSession.this.stop(FailureCode.FAILED_TO_STOP_STREAMING);
            return null;
        }

        protected boolean isSkipStopStreaming() {
            return SetAutoMultiAlarmSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public SetAutoMultiAlarmSession(List<MultipleAlarmSettings> list, SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_MULTI_ALARM, bleAdapter, bleSessionCallback);
        this.mMultiAlarmSettings = list;
        this.mSdkCallback = sdkCallback;
    }

    protected void initSettings() {
        this.mOldMultiAlarmSettings = DevicePreferenceUtils.getAutoListAlarm(this.context);
        storeSettings(this.mMultiAlarmSettings, true);
    }

    private void storeSettings(List<MultipleAlarmSettings> list, boolean z) {
        DevicePreferenceUtils.setAutoListAlarm(this.bleAdapter.getContext(), list);
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
        } else {
            DevicePreferenceUtils.removeSettingFlag(this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
        }
    }

    protected BleState getStartState() {
        if (!this.device.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM)) {
            log("This device does not support set multi alarm.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (!this.bleAdapter.isDeviceReady()) {
            storeSettings(this.mMultiAlarmSettings, true);
            log("Device is not ready. Cannot set multi alarm.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (SettingsUtils.isMultiAlarmListTheSame(this.mOldMultiAlarmSettings, this.mMultiAlarmSettings)) {
            log("The multi alarms are the same, no need to store again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeSettings(this.mMultiAlarmSettings, true);
            return createConcreteState(SessionState.STOP_STREAMING_STATE);
        }
    }

    public BleSession copyObject() {
        BleSession setAutoMultiAlarmSession = new SetAutoMultiAlarmSession(this.mMultiAlarmSettings, this.mSdkCallback, this.bleAdapter, this.bleSessionCallback);
        setAutoMultiAlarmSession.setDevice(this.device);
        return setAutoMultiAlarmSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_STATE, SetMultipleAlarmsState.class.getName());
        this.sessionStateMap.put(SessionState.START_STREAMING_AGAIN_STATE, StartStreamingAgainState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoMultiAlarmState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }
}
