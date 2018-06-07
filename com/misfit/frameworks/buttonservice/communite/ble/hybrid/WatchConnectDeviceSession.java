package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

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
import com.misfit.frameworks.buttonservice.communite.ble.ConnectDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public class WatchConnectDeviceSession extends ConnectDeviceSession {
    private List<MicroAppMapping> mappings;

    public class DoneConnectDevice extends BleState {
        public DoneConnectDevice() {
            super(WatchConnectDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            WatchConnectDeviceSession.this.log("All done of " + WatchConnectDeviceSession.this.TAG);
            WatchConnectDeviceSession.this.stop(0);
            return true;
        }
    }

    public class ProcessHIDState extends BleState {
        public ProcessHIDState() {
            super(WatchConnectDeviceSession.this.TAG);
            WatchConnectDeviceSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchConnectDeviceSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchConnectDeviceSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchConnectDeviceSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchConnectDeviceSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchConnectDeviceSession.this.log("Connect HID timeout");
            } else {
                WatchConnectDeviceSession.this.log("Disconnect HID timeout");
            }
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.DONE_CONNECT_DEVICE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(WatchConnectDeviceSession.this.TAG);
            WatchConnectDeviceSession.this.log("Set connection params to device with serial " + WatchConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchConnectDeviceSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchConnectDeviceSession.this.log("Set connection params timeout.");
            WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            WatchConnectDeviceSession.this.enterState(WatchConnectDeviceSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchConnectDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class StartStreamingState extends BleState {
        public StartStreamingState() {
            super(WatchConnectDeviceSession.this.TAG);
            WatchConnectDeviceSession.this.log("Start streaming to device with serial " + WatchConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchConnectDeviceSession.this.bleAdapter.isStreaming()) {
                WatchConnectDeviceSession.this.log("No need to start streaming");
                WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchConnectDeviceSession.this.bleAdapter.startStreaming(WatchConnectDeviceSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchConnectDeviceSession.this.log("Start streaming time out");
            WatchConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchConnectDeviceSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (BLEMapping isNeedHID : WatchConnectDeviceSession.this.mappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchConnectDeviceSession.this.hasHID = true;
                    break;
                }
            }
            if (DevicePreferenceUtils.isNeedToSetSetting(WatchConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS)) {
                WatchConnectDeviceSession.this.enterState(WatchConnectDeviceSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
            } else {
                WatchConnectDeviceSession.this.enterState(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            }
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchConnectDeviceSession.this.TAG);
            WatchConnectDeviceSession.this.log("Set micro app mapping to " + WatchConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchConnectDeviceSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchConnectDeviceSession.this.mappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchConnectDeviceSession.this.log("Micro app mapping is empty, size=" + WatchConnectDeviceSession.this.mappings.size());
                } else {
                    WatchConnectDeviceSession.this.log("Not support new micro app system");
                }
                DevicePreferenceUtils.removeSettingFlag(WatchConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                WatchConnectDeviceSession.this.enterStateWithDelayTime(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchConnectDeviceSession.this.bleAdapter.setMicroAppMappings(WatchConnectDeviceSession.this.mappings)) {
                    stopTimeout();
                    WatchConnectDeviceSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(WatchConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                WatchConnectDeviceSession.this.enterState(WatchConnectDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else {
                WatchConnectDeviceSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchConnectDeviceSession.this.log("Set micro app mapping timeout " + WatchConnectDeviceSession.this.serial);
            WatchConnectDeviceSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
        }
    }

    public WatchConnectDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.mappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession watchConnectDeviceSession = new WatchConnectDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchConnectDeviceSession.setDevice(this.device);
        return watchConnectDeviceSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, StartStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, ProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_CONNECT_DEVICE, DoneConnectDevice.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
