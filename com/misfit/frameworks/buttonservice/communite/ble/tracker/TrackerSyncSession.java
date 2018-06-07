package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SyncSession;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMappingBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.GoalTracking;
import java.util.List;

public class TrackerSyncSession extends SyncSession {
    private boolean hasHID = false;
    protected List<LinkMapping> linkMappings;

    public class DoneSyncState extends BleState {
        public DoneSyncState() {
            super(TrackerSyncSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            TrackerSyncSession.this.log("All done of " + TrackerSyncSession.this.TAG);
            TrackerSyncSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(TrackerSyncSession.this.TAG);
            TrackerSyncSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return TrackerSyncSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!TrackerSyncSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            TrackerSyncSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!TrackerSyncSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                TrackerSyncSession.this.log("Connect HID timeout");
            } else {
                TrackerSyncSession.this.log("Disconnect HID timeout");
            }
            TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class ProcessMappingState extends BleState {
        public ProcessMappingState() {
            super(TrackerSyncSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            boolean z;
            super.onTimeout();
            boolean z2 = false;
            for (LinkMapping linkMapping : TrackerSyncSession.this.linkMappings) {
                if (linkMapping.isNeedHID()) {
                    TrackerSyncSession.this.hasHID = true;
                }
                if (GoalTracking.isActionBelongToThisType(linkMapping.getAction())) {
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            z = DevicePreferenceUtils.isNeedToSetSetting(TrackerSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            if (!TrackerSyncSession.this.isFullSync() && !z) {
                TrackerSyncSession.this.enterState(TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else if (z2) {
                TrackerSyncSession.this.enterState(TrackerSyncSession.this.createConcreteState(SessionState.SET_GOAL_TRACKING_STATE));
            } else {
                TrackerSyncSession.this.enterState(TrackerSyncSession.this.createConcreteState(SessionState.SET_MAPPING_AFTER_SYNCING_STATE));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class ProcessStreamingState extends BleState {
        public ProcessStreamingState() {
            super(TrackerSyncSession.this.TAG);
            TrackerSyncSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (TrackerSyncSession.this.bleAdapter.isStreaming()) {
                TrackerSyncSession.this.log("No need to start streaming");
                TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!TrackerSyncSession.this.bleAdapter.startStreaming(TrackerSyncSession.this.sdkCallback)) {
                    stopTimeout();
                    TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            TrackerSyncSession.this.log("Start streaming time out");
            TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            TrackerSyncSession.this.enterStateWithDelayTime(TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetGoalTrackingState extends SetGoalTrackingBaseState {
        public SetGoalTrackingState() {
            super(TrackerSyncSession.this.linkMappings, TrackerSyncSession.this.bleAdapter, (BleSession) TrackerSyncSession.this);
            TrackerSyncSession.this.log("Set goal tracking to " + TrackerSyncSession.this.serial + " goalId:" + this.goalId);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            }
            return TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerSyncSession.this.log("Set goal tracking timeout");
            TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_ENABLE_GOAL_TRACKING);
            return TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }
    }

    public class SetMappingAfterSyncingState extends SetMappingBaseState {
        public SetMappingAfterSyncingState() {
            super(TrackerSyncSession.this.linkMappings, TrackerSyncSession.this.device, TrackerSyncSession.this.bleAdapter, TrackerSyncSession.this);
            TrackerSyncSession.this.log("Set mapping to device with serial " + TrackerSyncSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(TrackerSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            }
            return TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected BleState getStateOnTimeOut() {
            TrackerSyncSession.this.log("Set mapping timeout");
            TrackerSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_LINK_MAPPING);
            return TrackerSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING);
        }

        protected boolean isClearAndUpdateEachButton() {
            return false;
        }
    }

    public TrackerSyncSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback, UserProfile userProfile) {
        super(bleAdapter, bleSessionCallback, sdkCallback, userProfile);
    }

    protected void initSettings() {
        super.initSettings();
        this.linkMappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, ProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MAPPING_AFTER_SYNCING_STATE, SetMappingAfterSyncingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_GOAL_TRACKING_STATE, SetGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, ProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SYNC_STATE, DoneSyncState.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }

    public BleSession copyObject() {
        BleSession trackerSyncSession = new TrackerSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, this.userProfile);
        trackerSyncSession.setDevice(this.device);
        return trackerSyncSession;
    }
}
