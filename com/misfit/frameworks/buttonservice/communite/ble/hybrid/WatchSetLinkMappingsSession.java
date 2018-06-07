package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.cfj;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.SetLinkMappingsSession;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchSetLinkMappingsSession extends SetLinkMappingsSession {
    private boolean[] hasHID = new boolean[2];
    protected List<MicroAppMapping> mappings;
    protected List<MicroAppMapping> oldMappings;

    public class DoneSetLinkMappingState extends BleState {
        public DoneSetLinkMappingState() {
            super(WatchSetLinkMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchSetLinkMappingsSession.this.TAG, "All done of " + WatchSetLinkMappingsSession.this.TAG);
            WatchSetLinkMappingsSession.this.stop(0);
            return true;
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(WatchSetLinkMappingsSession.this.TAG);
            WatchSetLinkMappingsSession.this.log("Set connection params to device with serial " + WatchSetLinkMappingsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchSetLinkMappingsSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetLinkMappingsSession.this.log("Set connection params timeout.");
            WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            WatchSetLinkMappingsSession.this.enterState(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchSetLinkMappingsSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchSetLinkMappingsSession.this.TAG);
            WatchSetLinkMappingsSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchSetLinkMappingsSession.this.hasHID[1];
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchSetLinkMappingsSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchSetLinkMappingsSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchSetLinkMappingsSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchSetLinkMappingsSession.this.log("Connect HID timeout");
            } else {
                WatchSetLinkMappingsSession.this.log("Disconnect HID timeout");
            }
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.DONE_SET_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchSetLinkMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping isNeedHID : WatchSetLinkMappingsSession.this.oldMappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchSetLinkMappingsSession.this.hasHID[0] = true;
                }
            }
            for (MicroAppMapping isNeedHID2 : WatchSetLinkMappingsSession.this.mappings) {
                if (isNeedHID2.isNeedHID()) {
                    WatchSetLinkMappingsSession.this.hasHID[1] = true;
                }
            }
            WatchSetLinkMappingsSession.this.enterState(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchSetLinkMappingsSession.this.TAG);
            WatchSetLinkMappingsSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchSetLinkMappingsSession.this.bleAdapter.isStreaming()) {
                WatchSetLinkMappingsSession.this.log("No need to start streaming");
                WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSetLinkMappingsSession.this.bleAdapter.startStreaming(WatchSetLinkMappingsSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetLinkMappingsSession.this.log("Start streaming time out");
            WatchSetLinkMappingsSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchSetLinkMappingsSession.this.TAG);
            WatchSetLinkMappingsSession.this.log("Set micro app mapping to " + WatchSetLinkMappingsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchSetLinkMappingsSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchSetLinkMappingsSession.this.mappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchSetLinkMappingsSession.this.log("Micro app mapping is empty, size=" + WatchSetLinkMappingsSession.this.mappings.size());
                    storeSettings(WatchSetLinkMappingsSession.this.mappings);
                } else {
                    WatchSetLinkMappingsSession.this.log("Not support new micro app system");
                }
                WatchSetLinkMappingsSession.this.enterStateWithDelayTime(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchSetLinkMappingsSession.this.bleAdapter.setMicroAppMappings(WatchSetLinkMappingsSession.this.mappings)) {
                    stopTimeout();
                    WatchSetLinkMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                storeSettings(WatchSetLinkMappingsSession.this.mappings);
                WatchSetLinkMappingsSession.this.enterState(WatchSetLinkMappingsSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else {
                WatchSetLinkMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetLinkMappingsSession.this.log("Set micro app mapping timeout " + WatchSetLinkMappingsSession.this.serial);
            WatchSetLinkMappingsSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
        }

        private void storeSettings(List<MicroAppMapping> list) {
            DevicePreferenceUtils.setAutoSetMapping(WatchSetLinkMappingsSession.this.bleAdapter.getContext(), WatchSetLinkMappingsSession.this.bleAdapter.getSerial(), new cfj().toJson(list));
            DevicePreferenceUtils.removeSettingFlag(WatchSetLinkMappingsSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
        }
    }

    public WatchSetLinkMappingsSession(List<BLEMapping> list, SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(sdkCallback, bleAdapter, bleSessionCallback);
        this.mappings = MicroAppMapping.convertToMicroAppMapping(list);
        this.sdkCallback = sdkCallback;
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
        this.oldMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial()));
    }

    public BleSession copyObject() {
        BleSession watchSetLinkMappingsSession = new WatchSetLinkMappingsSession(MicroAppMapping.convertToBLEMapping(this.mappings), this.sdkCallback, this.bleAdapter, this.bleSessionCallback);
        watchSetLinkMappingsSession.setDevice(this.device);
        return watchSetLinkMappingsSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SET_LINK_MAPPING_STATE, DoneSetLinkMappingState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
