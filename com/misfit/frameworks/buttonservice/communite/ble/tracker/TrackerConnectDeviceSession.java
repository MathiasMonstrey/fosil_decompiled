package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMappingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import java.util.List;

public class TrackerConnectDeviceSession extends ConnectDeviceSession {
    protected List<LinkMapping> mappings;

    public class DoneConnectDevice extends BleState {
        public DoneConnectDevice() {
            super(TrackerConnectDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            TrackerConnectDeviceSession.this.log("All done of " + TrackerConnectDeviceSession.this.TAG);
            TrackerConnectDeviceSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerConnectDeviceSession.this.TAG);
            TrackerConnectDeviceSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerConnectDeviceSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerConnectDeviceSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerConnectDeviceSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerConnectDeviceSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerConnectDeviceSession.this.log("Connect HID timeout");
            } else {
                TrackerConnectDeviceSession.this.log("Disconnect HID timeout");
            }
            TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessMappingState extends BleState {
        public ProcessMappingState() {
            super(TrackerConnectDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            boolean z = false;
            for (LinkMapping linkMapping : TrackerConnectDeviceSession.this.mappings) {
                boolean z2;
                if (linkMapping.isNeedHID()) {
                    TrackerConnectDeviceSession.this.hasHID = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            if (!DevicePreferenceUtils.isNeedToSetSetting(TrackerConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS)) {
                TrackerConnectDeviceSession.this.enterState(TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else if (z) {
                TrackerConnectDeviceSession.this.enterState(TrackerConnectDeviceSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_STATE));
            } else {
                TrackerConnectDeviceSession.this.enterState(TrackerConnectDeviceSession.this.createConcreteState(SessionState.SET_MAPPING_STATE));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerConnectDeviceSession.this.mappings, TrackerConnectDeviceSession.this.bleAdapter, (BleSession) TrackerConnectDeviceSession.this);
            TrackerConnectDeviceSession.this.log("Set goal tracking to " + TrackerConnectDeviceSession.this.serial + " goalId:" + this.goalId);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            }
            return TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerConnectDeviceSession.this.log("Set goal tracking timeout");
            TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }
    }

    public class SetMappingState extends SetMappingBaseState {
        public SetMappingState() {
            super(TrackerConnectDeviceSession.this.mappings, TrackerConnectDeviceSession.this.device, TrackerConnectDeviceSession.this.bleAdapter, TrackerConnectDeviceSession.this);
            TrackerConnectDeviceSession.this.log("Set mapping to device with serial " + TrackerConnectDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            }
            return TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerConnectDeviceSession.this.log("Set mapping timeout");
            TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected boolean isClearAndUpdateEachButton() {
            return false;
        }
    }

    public class StartStreamingState extends BleState {
        public StartStreamingState() {
            super(TrackerConnectDeviceSession.this.TAG);
            TrackerConnectDeviceSession.this.log("Start streaming to device with serial " + TrackerConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerConnectDeviceSession.this.bleAdapter.isStreaming()) {
                TrackerConnectDeviceSession.this.log("No need to start streaming");
                TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerConnectDeviceSession.this.bleAdapter.startStreaming(TrackerConnectDeviceSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerConnectDeviceSession.this.log("Start streaming time out");
            TrackerConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerConnectDeviceSession.this.enterStateWithDelayTime(TrackerConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public TrackerConnectDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.mappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession trackerConnectDeviceSession = new TrackerConnectDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        trackerConnectDeviceSession.setDevice(this.device);
        return trackerConnectDeviceSession;
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, ProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_STATE, SetMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, StartStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_CONNECT_DEVICE, DoneConnectDevice.class.getName());
    }
}
