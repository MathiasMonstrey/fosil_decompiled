package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.cfj;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoSettingsSession;
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
import java.util.List;

public class TrackerSetAutoMappingsSession extends SetAutoSettingsSession {
    private boolean[] containGoalTracking = new boolean[2];
    private boolean[] hasHID = new boolean[2];
    protected List<LinkMapping> mappings;
    protected List<LinkMapping> oldMappings;
    protected SdkCallback sdkCallback;

    public class ClearAllMappingState extends ClearMappingBaseState {
        public ClearAllMappingState() {
            super(TrackerSetAutoMappingsSession.this.bleAdapter, TrackerSetAutoMappingsSession.this);
            TrackerSetAutoMappingsSession.this.log("Clear all mappings of device with serial " + TrackerSetAutoMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
            }
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }
    }

    public class DisableGoalTrackingState extends DisableGoalTrackingBaseState {
        public DisableGoalTrackingState() {
            super(TrackerSetAutoMappingsSession.this.bleAdapter, TrackerSetAutoMappingsSession.this);
            TrackerSetAutoMappingsSession.this.log("Disable goal tracking of device with serial " + TrackerSetAutoMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_MAPPING);
            }
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }
    }

    public class DoneSetAutoMappingState extends BleState {
        public DoneSetAutoMappingState() {
            super(TrackerSetAutoMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            TrackerSetAutoMappingsSession.this.log("All done of " + TrackerSetAutoMappingsSession.this.TAG);
            TrackerSetAutoMappingsSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerSetAutoMappingsSession.this.TAG);
            TrackerSetAutoMappingsSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerSetAutoMappingsSession.this.hasHID[1];
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerSetAutoMappingsSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerSetAutoMappingsSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerSetAutoMappingsSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerSetAutoMappingsSession.this.log("Connect HID timeout");
            } else {
                TrackerSetAutoMappingsSession.this.log("Disconnect HID timeout");
            }
            TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessOldMappingState extends BleState {
        public ProcessOldMappingState() {
            super(TrackerSetAutoMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (LinkMapping linkMapping : TrackerSetAutoMappingsSession.this.oldMappings) {
                if (linkMapping.isNeedHID()) {
                    TrackerSetAutoMappingsSession.this.hasHID[0] = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    TrackerSetAutoMappingsSession.this.containGoalTracking[0] = true;
                }
            }
            if (TrackerSetAutoMappingsSession.this.containGoalTracking[0]) {
                TrackerSetAutoMappingsSession.this.enterState(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.DISABLE_GOAL_TRACKING_STATE));
            } else {
                TrackerSetAutoMappingsSession.this.enterState(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.CLEAR_ALL_MAPPINGS_STATE));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class ProcessStreamingState extends BleState {
        public ProcessStreamingState() {
            super(TrackerSetAutoMappingsSession.this.TAG);
            TrackerSetAutoMappingsSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerSetAutoMappingsSession.this.bleAdapter.isStreaming()) {
                TrackerSetAutoMappingsSession.this.log("No need to start streaming");
                TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerSetAutoMappingsSession.this.bleAdapter.startStreaming(TrackerSetAutoMappingsSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerSetAutoMappingsSession.this.log("Start streaming time out");
            TrackerSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerSetAutoMappingsSession.this.enterStateWithDelayTime(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerSetAutoMappingsSession.this.mappings, TrackerSetAutoMappingsSession.this.bleAdapter, (BleSession) TrackerSetAutoMappingsSession.this);
            TrackerSetAutoMappingsSession.this.log("Set goal tracking to device with serial " + TrackerSetAutoMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, false);
                return TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
            }
            TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, true);
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, true);
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return null;
        }
    }

    public class SetMappingsState extends SetMappingBaseState {
        public SetMappingsState() {
            super(TrackerSetAutoMappingsSession.this.mappings, TrackerSetAutoMappingsSession.this.device, TrackerSetAutoMappingsSession.this.bleAdapter, TrackerSetAutoMappingsSession.this);
            TrackerSetAutoMappingsSession.this.log("Set mapping to device with serial " + TrackerSetAutoMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, false);
                return TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
            }
            TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, true);
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerSetAutoMappingsSession.this.storeSettings(TrackerSetAutoMappingsSession.this.mappings, true);
            TrackerSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return null;
        }

        protected boolean isClearAndUpdateEachButton() {
            return TrackerSetAutoMappingsSession.this.bleAdapter.isSupportedFeature(ShineFeature.UNMAP_ONE_BUTTON);
        }
    }

    public class TrackerProcessMappingState extends BleState {
        public TrackerProcessMappingState() {
            super(TrackerSetAutoMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (LinkMapping linkMapping : TrackerSetAutoMappingsSession.this.mappings) {
                if (linkMapping.isNeedHID()) {
                    TrackerSetAutoMappingsSession.this.hasHID[1] = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    TrackerSetAutoMappingsSession.this.containGoalTracking[1] = true;
                }
            }
            if (TrackerSetAutoMappingsSession.this.containGoalTracking[1]) {
                TrackerSetAutoMappingsSession.this.enterState(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_STATE));
            } else if (TrackerSetAutoMappingsSession.this.hasHID[1]) {
                TrackerSetAutoMappingsSession.this.enterState(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.SET_MAPPING_STATE));
            } else {
                TrackerSetAutoMappingsSession.this.enterState(TrackerSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public TrackerSetAutoMappingsSession(List<BLEMapping> list, SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_MAPPING, bleAdapter, bleSessionCallback);
        this.sdkCallback = sdkCallback;
        this.mappings = LinkMapping.convertToLinkMapping(list);
    }

    public BleSession copyObject() {
        BleSession trackerSetAutoMappingsSession = new TrackerSetAutoMappingsSession(LinkMapping.convertToBLEMapping(this.mappings), this.sdkCallback, this.bleAdapter, this.bleSessionCallback);
        trackerSetAutoMappingsSession.setDevice(this.device);
        return trackerSetAutoMappingsSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PROCESS_OLD_MAPPING, ProcessOldMappingState.class.getName());
        this.sessionStateMap.put(SessionState.DISABLE_GOAL_TRACKING_STATE, DisableGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.CLEAR_ALL_MAPPINGS_STATE, ClearAllMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, TrackerProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_STATE, SetMappingsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, ProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoMappingState.class.getName());
    }

    protected void initSettings() {
        this.oldMappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    protected BleState getStartState() {
        if (!this.bleAdapter.isDeviceReady()) {
            storeSettings(this.mappings, true);
            log("Device is not ready. Cannot set mapping.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (BLEMapping.isMappingTheSame(this.oldMappings, this.mappings)) {
            log("New mappings and old mappings are the same. No need to set again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeSettings(this.mappings, true);
            return createConcreteState(SessionState.PROCESS_OLD_MAPPING);
        }
    }

    protected void buildExtraInfoReturned() {
    }

    private void storeSettings(List<LinkMapping> list, boolean z) {
        DevicePreferenceUtils.setAutoSetMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial(), new cfj().toJson(list));
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
        } else {
            DevicePreferenceUtils.removeSettingFlag(this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
        }
    }

    private boolean isContainGoalTracking(List<LinkMapping> list) {
        if (list != null) {
            for (LinkMapping action : list) {
                if (GoalTracking.isActionBelongToThisType(action.getAction())) {
                    return true;
                }
            }
        }
        return false;
    }
}
