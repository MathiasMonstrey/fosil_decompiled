package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SyncSession;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public class WatchSyncSession extends SyncSession {
    private boolean hasHID = false;
    private List<MicroAppMapping> microAppMappings;

    public class DoneSyncState extends BleState {
        public DoneSyncState() {
            super(WatchSyncSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            WatchSyncSession.this.log("All done of " + WatchSyncSession.this.TAG);
            WatchSyncSession.this.stop(0);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchSyncSession.this.TAG);
            WatchSyncSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchSyncSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchSyncSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchSyncSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchSyncSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchSyncSession.this.log("Connect HID timeout");
            } else {
                WatchSyncSession.this.log("Disconnect HID timeout");
            }
            WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchSyncSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping isNeedHID : WatchSyncSession.this.microAppMappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchSyncSession.this.hasHID = true;
                }
            }
            boolean isNeedToSetSetting = DevicePreferenceUtils.isNeedToSetSetting(WatchSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            if (WatchSyncSession.this.isFullSync() || isNeedToSetSetting) {
                WatchSyncSession.this.enterState(WatchSyncSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE));
            } else {
                WatchSyncSession.this.enterState(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchSyncSession.this.TAG);
            WatchSyncSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchSyncSession.this.bleAdapter.isStreaming()) {
                WatchSyncSession.this.log("No need to start streaming");
                WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSyncSession.this.bleAdapter.startStreaming(WatchSyncSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSyncSession.this.log("Start streaming time out");
            WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchSyncSession.this.TAG);
            WatchSyncSession.this.log("Set micro app mapping to " + WatchSyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchSyncSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchSyncSession.this.microAppMappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchSyncSession.this.log("Micro app mapping is empty, size=" + WatchSyncSession.this.microAppMappings.size());
                } else {
                    WatchSyncSession.this.log("Not support new micro app system");
                }
                DevicePreferenceUtils.removeSettingFlag(WatchSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSyncSession.this.bleAdapter.setMicroAppMappings(WatchSyncSession.this.microAppMappings)) {
                    stopTimeout();
                    WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    WatchSyncSession.this.enterStateWithDelayTime(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(WatchSyncSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            WatchSyncSession.this.enterState(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSyncSession.this.log("Set micro app mapping timeout " + WatchSyncSession.this.serial);
            WatchSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            WatchSyncSession.this.enterState(WatchSyncSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
        }
    }

    public WatchSyncSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback, UserProfile userProfile) {
        super(bleAdapter, bleSessionCallback, sdkCallback, userProfile);
    }

    protected void initSettings() {
        super.initSettings();
        this.microAppMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession watchSyncSession = new WatchSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, this.userProfile);
        watchSyncSession.setDevice(this.device);
        return watchSyncSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SYNC_STATE, DoneSyncState.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
