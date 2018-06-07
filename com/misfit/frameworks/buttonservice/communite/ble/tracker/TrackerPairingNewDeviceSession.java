package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.PairingNewDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.share.ClearMappingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.DisableGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMappingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class TrackerPairingNewDeviceSession extends PairingNewDeviceSession {
    private boolean hasHID;
    protected List<LinkMapping> mappings;

    public class ClearAllMappingsState extends ClearMappingBaseState {
        public ClearAllMappingsState() {
            super(TrackerPairingNewDeviceSession.this.bleAdapter, TrackerPairingNewDeviceSession.this);
            TrackerPairingNewDeviceSession.this.log("Clear all mappings of device with serial " + TrackerPairingNewDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            }
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DISABLE_GOAL_TRACKING_STATE);
        }

        protected BleState getStateOnTimeOut() {
            TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DISABLE_GOAL_TRACKING_STATE);
        }
    }

    public class DisableGoalTrackingState extends DisableGoalTrackingBaseState {
        public DisableGoalTrackingState() {
            super(TrackerPairingNewDeviceSession.this.bleAdapter, TrackerPairingNewDeviceSession.this);
            TrackerPairingNewDeviceSession.this.log("Disable goal tracking of device with serial " + TrackerPairingNewDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            }
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
        }
    }

    public class DonePairingNewDeviceSessionState extends BleState {
        public DonePairingNewDeviceSessionState() {
            super(TrackerPairingNewDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(TrackerPairingNewDeviceSession.this.TAG, "All done of " + TrackerPairingNewDeviceSession.this.TAG);
            TrackerPairingNewDeviceSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerPairingNewDeviceSession.this.TAG);
            TrackerPairingNewDeviceSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerPairingNewDeviceSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerPairingNewDeviceSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerPairingNewDeviceSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerPairingNewDeviceSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerPairingNewDeviceSession.this.log("Connect HID timeout");
            } else {
                TrackerPairingNewDeviceSession.this.log("Disconnect HID timeout");
            }
            TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessMappingState extends BleState {
        public ProcessMappingState() {
            super(TrackerPairingNewDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            boolean z = false;
            for (LinkMapping linkMapping : TrackerPairingNewDeviceSession.this.mappings) {
                boolean z2;
                if (linkMapping.isNeedHID()) {
                    TrackerPairingNewDeviceSession.this.hasHID = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            if (z) {
                TrackerPairingNewDeviceSession.this.enterState(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_STATE));
            } else if (TrackerPairingNewDeviceSession.this.hasHID) {
                TrackerPairingNewDeviceSession.this.enterState(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.SET_MAPPING_STATE));
            } else {
                TrackerPairingNewDeviceSession.this.enterState(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class ProcessStreamingState extends BleState {
        public ProcessStreamingState() {
            super(TrackerPairingNewDeviceSession.this.TAG);
            TrackerPairingNewDeviceSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerPairingNewDeviceSession.this.bleAdapter.isStreaming()) {
                TrackerPairingNewDeviceSession.this.log("No need to start streaming");
                TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerPairingNewDeviceSession.this.bleAdapter.startStreaming(TrackerPairingNewDeviceSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerPairingNewDeviceSession.this.log("Start streaming time out");
            TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerPairingNewDeviceSession.this.enterStateWithDelayTime(TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerPairingNewDeviceSession.this.mappings, TrackerPairingNewDeviceSession.this.bleAdapter, (BleSession) TrackerPairingNewDeviceSession.this);
            TrackerPairingNewDeviceSession.this.log("Set goal tracking to " + TrackerPairingNewDeviceSession.this.serial + " goalId:" + this.goalId);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerPairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            }
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }
    }

    public class SetMappingState extends SetMappingBaseState {
        public SetMappingState() {
            super(TrackerPairingNewDeviceSession.this.mappings, TrackerPairingNewDeviceSession.this.device, TrackerPairingNewDeviceSession.this.bleAdapter, TrackerPairingNewDeviceSession.this);
            TrackerPairingNewDeviceSession.this.log("Set mapping of device with serial " + TrackerPairingNewDeviceSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerPairingNewDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            }
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return TrackerPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected boolean isClearAndUpdateEachButton() {
            return TrackerPairingNewDeviceSession.this.bleAdapter.isSupportedFeature(ShineFeature.UNMAP_ONE_BUTTON);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            TrackerPairingNewDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public TrackerPairingNewDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.mappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession trackerPairingNewDeviceSession = new TrackerPairingNewDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        trackerPairingNewDeviceSession.setDevice(this.device);
        return trackerPairingNewDeviceSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CLEAR_ALL_MAPPINGS_STATE, ClearAllMappingsState.class.getName());
        this.sessionStateMap.put(SessionState.DISABLE_GOAL_TRACKING_STATE, DisableGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, ProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_STATE, SetMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, ProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE, DonePairingNewDeviceSessionState.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.CLEAR_ALL_MAPPINGS_STATE);
    }
}
