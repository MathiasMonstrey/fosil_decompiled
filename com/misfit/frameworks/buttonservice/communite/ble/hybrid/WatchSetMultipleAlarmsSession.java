package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchSetMultipleAlarmsSession extends ConnectableSession {
    private boolean isStreaming = false;
    private List<MultipleAlarmSettings> mMultipleAlarmSettings;
    private List<MultipleAlarmSettings> mOldMultiAlarmSettings;

    public class DoneSetMultipleAlarmsState extends BleState {
        public DoneSetMultipleAlarmsState() {
            super(WatchSetMultipleAlarmsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchSetMultipleAlarmsSession.this.TAG, "All done of " + WatchSetMultipleAlarmsSession.this.TAG);
            WatchSetMultipleAlarmsSession.this.stop(0);
            return true;
        }
    }

    public class SetMultipleAlarmsState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsState() {
            super(WatchSetMultipleAlarmsSession.this.mMultipleAlarmSettings, WatchSetMultipleAlarmsSession.this.bleAdapter, WatchSetMultipleAlarmsSession.this);
            WatchSetMultipleAlarmsSession.this.log("Multiple alarms of device with serial " + WatchSetMultipleAlarmsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.setAutoListAlarm(WatchSetMultipleAlarmsSession.this.bleAdapter.getContext(), WatchSetMultipleAlarmsSession.this.mMultipleAlarmSettings);
                DevicePreferenceUtils.removeSettingFlag(WatchSetMultipleAlarmsSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
                return WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.START_STREAMING_AGAIN_STATE);
            }
            WatchSetMultipleAlarmsSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            WatchSetMultipleAlarmsSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return null;
        }
    }

    public class StartStreamingAgainState extends BleState {
        public StartStreamingAgainState() {
            super(WatchSetMultipleAlarmsSession.this.TAG);
            WatchSetMultipleAlarmsSession.this.log("Start streaming to device with serial " + WatchSetMultipleAlarmsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchSetMultipleAlarmsSession.this.isStreaming) {
                startTimeout();
                if (!WatchSetMultipleAlarmsSession.this.bleAdapter.startStreaming(WatchSetMultipleAlarmsSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchSetMultipleAlarmsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchSetMultipleAlarmsSession.this.enterStateWithDelayTime(WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchSetMultipleAlarmsSession.this.log("No need to start streaming");
            WatchSetMultipleAlarmsSession.this.enterStateWithDelayTime(WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchSetMultipleAlarmsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchSetMultipleAlarmsSession.this.enterStateWithDelayTime(WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetMultipleAlarmsSession.this.log("Start streaming time out");
            WatchSetMultipleAlarmsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchSetMultipleAlarmsSession.this.enterStateWithDelayTime(WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(WatchSetMultipleAlarmsSession.this.bleAdapter, WatchSetMultipleAlarmsSession.this);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return WatchSetMultipleAlarmsSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
            }
            WatchSetMultipleAlarmsSession.this.stop(FailureCode.FAILED_TO_STOP_STREAMING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            WatchSetMultipleAlarmsSession.this.stop(FailureCode.FAILED_TO_STOP_STREAMING);
            return null;
        }

        protected boolean isSkipStopStreaming() {
            return WatchSetMultipleAlarmsSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public WatchSetMultipleAlarmsSession(List<MultipleAlarmSettings> list, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.SET_LIST_ALARM, bleAdapter, bleSessionCallback, sdkCallback);
        this.mMultipleAlarmSettings = list;
        this.isStreaming = bleAdapter.isStreaming();
    }

    public BleSession copyObject() {
        BleSession watchSetMultipleAlarmsSession = new WatchSetMultipleAlarmsSession(this.mMultipleAlarmSettings, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchSetMultipleAlarmsSession.setDevice(this.device);
        return watchSetMultipleAlarmsSession;
    }

    public boolean accept(BleSession bleSession) {
        return (getCommunicateMode() == bleSession.getCommunicateMode() || bleSession.getCommunicateMode() == CommunicateMode.SET_AUTO_MULTI_ALARM) ? false : true;
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        if (!SettingsUtils.isMultiAlarmListTheSame(this.mOldMultiAlarmSettings, this.mMultipleAlarmSettings)) {
            return super.onStart(objArr);
        }
        log("The multi alarms are the same. No need to set again");
        enterStateWithDelayTime(createConcreteState(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }

    private void initSettings() {
        this.mOldMultiAlarmSettings = DevicePreferenceUtils.getAutoListAlarm(this.context);
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_STATE, SetMultipleAlarmsState.class.getName());
        this.sessionStateMap.put(SessionState.START_STREAMING_AGAIN_STATE, StartStreamingAgainState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SET_MULTIPLE_ALARMS_STATE, DoneSetMultipleAlarmsState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        if (this.isStreaming) {
            return createConcreteState(SessionState.STOP_STREAMING_STATE);
        }
        return createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
