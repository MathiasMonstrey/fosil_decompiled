package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.cfj;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoSettingsSession;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchSetAutoMappingsSession extends SetAutoSettingsSession {
    private boolean[] hasHID = new boolean[2];
    protected List<MicroAppMapping> mappings;
    protected List<MicroAppMapping> oldMappings;
    protected SdkCallback sdkCallback;

    public class DoneSetAutoMappingState extends BleState {
        public DoneSetAutoMappingState() {
            super(WatchSetAutoMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchSetAutoMappingsSession.this.TAG, "All done of " + WatchSetAutoMappingsSession.this.TAG);
            WatchSetAutoMappingsSession.this.stop(0);
            return true;
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(WatchSetAutoMappingsSession.this.TAG);
            WatchSetAutoMappingsSession.this.log("Set connection params to device with serial " + WatchSetAutoMappingsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchSetAutoMappingsSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetAutoMappingsSession.this.log("Set connection params timeout.");
            WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            WatchSetAutoMappingsSession.this.enterState(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchSetAutoMappingsSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchSetAutoMappingsSession.this.TAG);
            WatchSetAutoMappingsSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchSetAutoMappingsSession.this.hasHID[1];
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchSetAutoMappingsSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchSetAutoMappingsSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchSetAutoMappingsSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchSetAutoMappingsSession.this.log("Connect HID timeout");
            } else {
                WatchSetAutoMappingsSession.this.log("Disconnect HID timeout");
            }
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchSetAutoMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping isNeedHID : WatchSetAutoMappingsSession.this.oldMappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchSetAutoMappingsSession.this.hasHID[0] = true;
                    break;
                }
            }
            for (MicroAppMapping isNeedHID2 : WatchSetAutoMappingsSession.this.mappings) {
                if (isNeedHID2.isNeedHID()) {
                    WatchSetAutoMappingsSession.this.hasHID[1] = true;
                    break;
                }
            }
            WatchSetAutoMappingsSession.this.enterState(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchSetAutoMappingsSession.this.TAG);
            WatchSetAutoMappingsSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchSetAutoMappingsSession.this.bleAdapter.isStreaming()) {
                WatchSetAutoMappingsSession.this.log("No need to start streaming");
                WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSetAutoMappingsSession.this.bleAdapter.startStreaming(WatchSetAutoMappingsSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetAutoMappingsSession.this.log("Start streaming time out");
            WatchSetAutoMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchSetAutoMappingsSession.this.TAG);
            WatchSetAutoMappingsSession.this.log("Set micro app mapping to " + WatchSetAutoMappingsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchSetAutoMappingsSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchSetAutoMappingsSession.this.mappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchSetAutoMappingsSession.this.log("Micro app mapping is empty, size=" + WatchSetAutoMappingsSession.this.mappings.size());
                } else {
                    WatchSetAutoMappingsSession.this.log("Not support new micro app system");
                }
                WatchSetAutoMappingsSession.this.storeMappings(WatchSetAutoMappingsSession.this.mappings, false);
                WatchSetAutoMappingsSession.this.enterStateWithDelayTime(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSetAutoMappingsSession.this.bleAdapter.setMicroAppMappings(WatchSetAutoMappingsSession.this.mappings)) {
                    stopTimeout();
                    WatchSetAutoMappingsSession.this.storeMappings(WatchSetAutoMappingsSession.this.mappings, true);
                    WatchSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                WatchSetAutoMappingsSession.this.storeMappings(WatchSetAutoMappingsSession.this.mappings, false);
                WatchSetAutoMappingsSession.this.enterState(WatchSetAutoMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else {
                WatchSetAutoMappingsSession.this.storeMappings(WatchSetAutoMappingsSession.this.mappings, true);
                WatchSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetAutoMappingsSession.this.log("Set micro app mapping timeout " + WatchSetAutoMappingsSession.this.serial);
            WatchSetAutoMappingsSession.this.storeMappings(WatchSetAutoMappingsSession.this.mappings, true);
            WatchSetAutoMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
        }
    }

    public WatchSetAutoMappingsSession(List<BLEMapping> list, SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_MAPPING, bleAdapter, bleSessionCallback);
        this.sdkCallback = sdkCallback;
        this.mappings = MicroAppMapping.convertToMicroAppMapping(list);
    }

    protected void initSettings() {
        this.oldMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial()));
    }

    protected BleState getStartState() {
        if (!this.bleAdapter.isDeviceReady()) {
            storeMappings(this.mappings, true);
            log("Device is not ready. Cannot set mapping.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (BLEMapping.isMappingTheSame(this.oldMappings, this.mappings)) {
            log("New mappings and old mappings are the same. No need to set again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeMappings(this.mappings, true);
            return createConcreteState(SessionState.PROCESS_MAPPING);
        }
    }

    public BleSession copyObject() {
        BleSession watchSetAutoMappingsSession = new WatchSetAutoMappingsSession(MicroAppMapping.convertToBLEMapping(this.mappings), this.sdkCallback, this.bleAdapter, this.bleSessionCallback);
        watchSetAutoMappingsSession.setDevice(this.device);
        return watchSetAutoMappingsSession;
    }

    public boolean accept(BleSession bleSession) {
        return true;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoMappingState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }

    private void storeMappings(List<MicroAppMapping> list, boolean z) {
        DevicePreferenceUtils.setAutoSetMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial(), new cfj().toJson(list));
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
        }
    }
}
