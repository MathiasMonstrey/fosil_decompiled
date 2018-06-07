package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.cfj;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SetLinkMappingsSession;
import com.misfit.frameworks.buttonservice.communite.ble.share.ClearMappingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.DisableGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMappingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class TrackerSetLinkMappingSession extends SetLinkMappingsSession {
    private boolean[] containGoalTracking;
    private boolean[] hasHID;
    protected List<LinkMapping> mappings;
    protected List<LinkMapping> oldMappings;

    public class ClearAllMappingState extends ClearMappingBaseState {
        public ClearAllMappingState() {
            super(TrackerSetLinkMappingSession.this.bleAdapter, TrackerSetLinkMappingSession.this);
            TrackerSetLinkMappingSession.this.log("Clear all mappings of device with serial " + TrackerSetLinkMappingSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
            }
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }
    }

    public class DisableGoalTrackingState extends DisableGoalTrackingBaseState {
        public DisableGoalTrackingState() {
            super(TrackerSetLinkMappingSession.this.bleAdapter, TrackerSetLinkMappingSession.this);
            TrackerSetLinkMappingSession.this.log("Disable goal tracking of device with serial " + TrackerSetLinkMappingSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
            }
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }
    }

    public class DoneSetLinkMappingState extends BleState {
        public DoneSetLinkMappingState() {
            super(TrackerSetLinkMappingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(TrackerSetLinkMappingSession.this.TAG, "All done of " + TrackerSetLinkMappingSession.this.TAG);
            TrackerSetLinkMappingSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerSetLinkMappingSession.this.TAG);
            TrackerSetLinkMappingSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerSetLinkMappingSession.this.hasHID[1];
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerSetLinkMappingSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerSetLinkMappingSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerSetLinkMappingSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerSetLinkMappingSession.this.log("Connect HID timeout");
            } else {
                TrackerSetLinkMappingSession.this.log("Disconnect HID timeout");
            }
            TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessStreamingState extends BleState {
        public ProcessStreamingState() {
            super(TrackerSetLinkMappingSession.this.TAG);
            TrackerSetLinkMappingSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerSetLinkMappingSession.this.bleAdapter.isStreaming()) {
                TrackerSetLinkMappingSession.this.log("No need to start streaming");
                TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerSetLinkMappingSession.this.bleAdapter.startStreaming(TrackerSetLinkMappingSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerSetLinkMappingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerSetLinkMappingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerSetLinkMappingSession.this.log("Start streaming time out");
            TrackerSetLinkMappingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerSetLinkMappingSession.this.enterStateWithDelayTime(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerSetLinkMappingSession.this.mappings, TrackerSetLinkMappingSession.this.bleAdapter, (BleSession) TrackerSetLinkMappingSession.this);
            TrackerSetLinkMappingSession.this.log("Set goal tracking to device with serial " + TrackerSetLinkMappingSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.setAutoSetMapping(TrackerSetLinkMappingSession.this.bleAdapter.getContext(), TrackerSetLinkMappingSession.this.bleAdapter.getSerial(), new cfj().toJson(TrackerSetLinkMappingSession.this.mappings));
                DevicePreferenceUtils.removeSettingFlag(TrackerSetLinkMappingSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                return TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
            }
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return null;
        }
    }

    public class SetMappingsState extends SetMappingBaseState {
        public SetMappingsState() {
            super(TrackerSetLinkMappingSession.this.mappings, TrackerSetLinkMappingSession.this.device, TrackerSetLinkMappingSession.this.bleAdapter, TrackerSetLinkMappingSession.this);
            TrackerSetLinkMappingSession.this.log("Set mapping to device with serial " + TrackerSetLinkMappingSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.setAutoSetMapping(TrackerSetLinkMappingSession.this.bleAdapter.getContext(), TrackerSetLinkMappingSession.this.bleAdapter.getSerial(), new cfj().toJson(TrackerSetLinkMappingSession.this.mappings));
                DevicePreferenceUtils.removeSettingFlag(TrackerSetLinkMappingSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                return TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
            }
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetLinkMappingSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return null;
        }

        protected boolean isClearAndUpdateEachButton() {
            return TrackerSetLinkMappingSession.this.bleAdapter.isSupportedFeature(ShineFeature.UNMAP_ONE_BUTTON);
        }
    }

    public class TrackerProcessMappingState extends BleState {
        public TrackerProcessMappingState() {
            super(TrackerSetLinkMappingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (LinkMapping linkMapping : TrackerSetLinkMappingSession.this.mappings) {
                if (linkMapping.isNeedHID()) {
                    TrackerSetLinkMappingSession.this.hasHID[1] = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    TrackerSetLinkMappingSession.this.containGoalTracking[1] = true;
                }
            }
            if (TrackerSetLinkMappingSession.this.containGoalTracking[1]) {
                TrackerSetLinkMappingSession.this.enterState(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_STATE));
            } else if (TrackerSetLinkMappingSession.this.hasHID[1]) {
                TrackerSetLinkMappingSession.this.enterState(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.SET_MAPPING_STATE));
            } else {
                TrackerSetLinkMappingSession.this.enterState(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class TrackerProcessOldMappingState extends BleState {
        public TrackerProcessOldMappingState() {
            super(TrackerSetLinkMappingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (LinkMapping linkMapping : TrackerSetLinkMappingSession.this.oldMappings) {
                if (linkMapping.isNeedHID()) {
                    TrackerSetLinkMappingSession.this.hasHID[0] = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    TrackerSetLinkMappingSession.this.containGoalTracking[0] = true;
                }
            }
            if (TrackerSetLinkMappingSession.this.containGoalTracking[0]) {
                TrackerSetLinkMappingSession.this.enterState(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.DISABLE_GOAL_TRACKING_STATE));
            } else {
                TrackerSetLinkMappingSession.this.enterState(TrackerSetLinkMappingSession.this.createConcreteState(SessionState.CLEAR_ALL_MAPPINGS_STATE));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public TrackerSetLinkMappingSession(List<BLEMapping> list, SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(sdkCallback, bleAdapter, bleSessionCallback);
        if (list == null || list.size() == 0) {
            stop(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return;
        }
        this.mappings = LinkMapping.convertToLinkMapping(list);
        this.hasHID = new boolean[2];
        this.containGoalTracking = new boolean[2];
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        if (!BLEMapping.isMappingTheSame(this.oldMappings, this.mappings)) {
            return super.onStart(objArr);
        }
        log("New mappings and old mappings are the same. No need to set again.");
        enterStateWithDelayTime(createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }

    private void initSettings() {
        this.oldMappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial()));
    }

    public BleSession copyObject() {
        BleSession trackerSetLinkMappingSession = new TrackerSetLinkMappingSession(LinkMapping.convertToBLEMapping(this.mappings), this.sdkCallback, this.bleAdapter, this.bleSessionCallback);
        trackerSetLinkMappingSession.setDevice(this.device);
        return trackerSetLinkMappingSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_OLD_MAPPING, TrackerProcessOldMappingState.class.getName());
        this.sessionStateMap.put(SessionState.DISABLE_GOAL_TRACKING_STATE, DisableGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.CLEAR_ALL_MAPPINGS_STATE, ClearAllMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, TrackerProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_STATE, SetMappingsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, ProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SET_LINK_MAPPING_STATE, DoneSetLinkMappingState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        if (this.oldMappings == null || this.oldMappings.isEmpty()) {
            return createConcreteState(SessionState.PROCESS_MAPPING);
        }
        return createConcreteState(SessionState.PROCESS_OLD_MAPPING);
    }

    protected void buildExtraInfoReturned() {
    }
}
