package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.OtaSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.share.ClearMappingBaseState;
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

public class TrackerOtaSession extends OtaSession {
    private boolean hasHID = false;
    protected List<LinkMapping> mappings;

    public class ClearAllMappingsAfterOtaState extends ClearMappingBaseState {
        public ClearAllMappingsAfterOtaState() {
            super(TrackerOtaSession.this.bleAdapter, TrackerOtaSession.this);
            TrackerOtaSession.this.log("Clear all mappings of device with serial " + TrackerOtaSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            }
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
        }
    }

    public class DoneOTASession extends BleState {
        public DoneOTASession() {
            super(TrackerOtaSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(TrackerOtaSession.this.TAG, "All done of " + TrackerOtaSession.this.TAG);
            TrackerOtaSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerOtaSession.this.TAG);
            TrackerOtaSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerOtaSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerOtaSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerOtaSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerOtaSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerOtaSession.this.log("Connect HID timeout");
            } else {
                TrackerOtaSession.this.log("Disconnect HID timeout");
            }
            TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessMappingState extends BleState {
        public ProcessMappingState() {
            super(TrackerOtaSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            boolean z = false;
            for (LinkMapping linkMapping : TrackerOtaSession.this.mappings) {
                boolean z2;
                if (linkMapping.isNeedHID()) {
                    TrackerOtaSession.this.hasHID = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            if (z) {
                TrackerOtaSession.this.enterState(TrackerOtaSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_AFTER_OTA_STATE));
            } else if (TrackerOtaSession.this.hasHID) {
                TrackerOtaSession.this.enterState(TrackerOtaSession.this.createConcreteState(SessionState.SET_MAPPING_AFTER_OTA_STATE));
            } else {
                TrackerOtaSession.this.enterState(TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class ProcessStreamingState extends BleState {
        public ProcessStreamingState() {
            super(TrackerOtaSession.this.TAG);
            TrackerOtaSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerOtaSession.this.bleAdapter.isStreaming()) {
                TrackerOtaSession.this.log("No need to start streaming");
                TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerOtaSession.this.bleAdapter.startStreaming(TrackerOtaSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerOtaSession.this.log("Start streaming time out");
            TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerOtaSession.this.enterStateWithDelayTime(TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerOtaSession.this.mappings, TrackerOtaSession.this.bleAdapter, (BleSession) TrackerOtaSession.this);
            TrackerOtaSession.this.log("Set goal tracking to " + TrackerOtaSession.this.serial + " goalId:" + this.goalId);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerOtaSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            }
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }
    }

    public class SetMappingAfterOtaState extends SetMappingBaseState {
        public SetMappingAfterOtaState() {
            super(TrackerOtaSession.this.mappings, TrackerOtaSession.this.device, TrackerOtaSession.this.bleAdapter, TrackerOtaSession.this);
            TrackerOtaSession.this.log("Set mapping to device with serial " + TrackerOtaSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerOtaSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            }
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return TrackerOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected boolean isClearAndUpdateEachButton() {
            return TrackerOtaSession.this.bleAdapter.isSupportedFeature(ShineFeature.UNMAP_ONE_BUTTON);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            TrackerOtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public TrackerOtaSession(byte[] bArr, boolean z, String str, String str2, long j, long j2, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bArr, z, str, str2, j, j2, bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.mappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CLEAR_ALL_MAPPINGS_AFTER_OTA_STATE, ClearAllMappingsAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, ProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_AFTER_OTA_STATE, SetMappingAfterOtaState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_AFTER_OTA_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, ProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_OTA_SESSION_STATE, DoneOTASession.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.CLEAR_ALL_MAPPINGS_AFTER_OTA_STATE);
    }

    public BleSession copyObject() {
        BleSession trackerOtaSession = new TrackerOtaSession(this.binaryData, this.isEmbedded, this.checksum, this.targetFirmwareVersion, this.stepGoal, this.realTimeSteps, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        trackerOtaSession.setDevice(this.device);
        return trackerOtaSession;
    }
}
