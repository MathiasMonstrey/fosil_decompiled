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
import com.misfit.frameworks.buttonservice.communite.ble.OtaSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchOtaSession extends OtaSession {
    private boolean hasHID = false;
    private List<MicroAppMapping> microAppMappings;

    public class DoneOTASession extends BleState {
        public DoneOTASession() {
            super(WatchOtaSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchOtaSession.this.TAG, "All done of " + WatchOtaSession.this.TAG);
            WatchOtaSession.this.stop(0);
            return true;
        }
    }

    public class SetConnectionParamsAfterOTAState extends BleState {
        public SetConnectionParamsAfterOTAState() {
            super(WatchOtaSession.this.TAG);
            WatchOtaSession.this.log("Set connection params to device with serial " + WatchOtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchOtaSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchOtaSession.this.log("Set connection params timeout.");
            WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            WatchOtaSession.this.enterState(WatchOtaSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchOtaSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchOtaSession.this.TAG);
            WatchOtaSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchOtaSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchOtaSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchOtaSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchOtaSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchOtaSession.this.log("Connect HID timeout");
            } else {
                WatchOtaSession.this.log("Disconnect HID timeout");
            }
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.DONE_OTA_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchOtaSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping isNeedHID : WatchOtaSession.this.microAppMappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchOtaSession.this.hasHID = true;
                }
            }
            WatchOtaSession.this.enterState(WatchOtaSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_AFTER_OTA_STATE));
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchOtaSession.this.TAG);
            WatchOtaSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchOtaSession.this.bleAdapter.isStreaming()) {
                WatchOtaSession.this.log("No need to start streaming");
                WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchOtaSession.this.bleAdapter.startStreaming(WatchOtaSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchOtaSession.this.log("Start streaming time out");
            WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchOtaSession.this.TAG);
            WatchOtaSession.this.log("Set micro app mapping to " + WatchOtaSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchOtaSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchOtaSession.this.microAppMappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchOtaSession.this.log("Micro app mapping is empty, size=" + WatchOtaSession.this.microAppMappings.size());
                } else {
                    WatchOtaSession.this.log("Not support new micro app system");
                }
                DevicePreferenceUtils.removeSettingFlag(WatchOtaSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
                WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchOtaSession.this.bleAdapter.setMicroAppMappings(WatchOtaSession.this.microAppMappings)) {
                    stopTimeout();
                    WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    WatchOtaSession.this.enterStateWithDelayTime(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(WatchOtaSession.this.bleAdapter.getContext(), DeviceSettings.MAPPINGS);
            } else {
                WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            WatchOtaSession.this.enterState(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchOtaSession.this.log("Set micro app mapping timeout " + WatchOtaSession.this.serial);
            WatchOtaSession.this.addFailureCode(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            WatchOtaSession.this.enterState(WatchOtaSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
        }
    }

    public WatchOtaSession(byte[] bArr, boolean z, String str, String str2, long j, long j2, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bArr, z, str, str2, j, j2, bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.microAppMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession watchOtaSession = new WatchOtaSession(this.binaryData, this.isEmbedded, this.checksum, this.targetFirmwareVersion, this.stepGoal, this.realTimeSteps, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchOtaSession.setDevice(this.device);
        return watchOtaSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_AFTER_OTA_STATE, SetConnectionParamsAfterOTAState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_AFTER_OTA_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_OTA_SESSION_STATE, DoneOTASession.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
