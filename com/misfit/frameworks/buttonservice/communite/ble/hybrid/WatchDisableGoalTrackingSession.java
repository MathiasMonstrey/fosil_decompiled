package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction$MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLEGoalTrackingCustomization;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchDisableGoalTrackingSession extends ConnectableSession {
    protected boolean hasHID;
    protected List<MicroAppMapping> oldMappings;

    public class DoneState extends BleState {
        public DoneState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchDisableGoalTrackingSession.this.TAG, "Disable goal tracking done.");
            WatchDisableGoalTrackingSession.this.stop(0);
            return true;
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
            WatchDisableGoalTrackingSession.this.log("Set connection params to device with serial " + WatchDisableGoalTrackingSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchDisableGoalTrackingSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchDisableGoalTrackingSession.this.log("Set connection params timeout.");
            WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            WatchDisableGoalTrackingSession.this.enterState(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.SET_MICRO_APP_MAPPING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchDisableGoalTrackingSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
            WatchDisableGoalTrackingSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchDisableGoalTrackingSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchDisableGoalTrackingSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchDisableGoalTrackingSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchDisableGoalTrackingSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchDisableGoalTrackingSession.this.log("Connect HID timeout");
            } else {
                WatchDisableGoalTrackingSession.this.log("Disconnect HID timeout");
            }
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping microAppMapping : WatchDisableGoalTrackingSession.this.oldMappings) {
                if (microAppMapping.isNeedHID()) {
                    WatchDisableGoalTrackingSession.this.hasHID = true;
                }
                if (MicroAppInstruction$MicroAppID.UAPP_GOAL_TRACKING_ID.getValue().equalsIgnoreCase(microAppMapping.getMicroAppId())) {
                    ((BLEGoalTrackingCustomization) microAppMapping.getCustomization()).setGoalId(255);
                }
            }
            WatchDisableGoalTrackingSession.this.enterState(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
            WatchDisableGoalTrackingSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchDisableGoalTrackingSession.this.bleAdapter.isStreaming()) {
                WatchDisableGoalTrackingSession.this.log("No need to start streaming");
                WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchDisableGoalTrackingSession.this.bleAdapter.startStreaming(WatchDisableGoalTrackingSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchDisableGoalTrackingSession.this.log("Start streaming time out");
            WatchDisableGoalTrackingSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchSetMicroAppMappingState extends BleState {
        public WatchSetMicroAppMappingState() {
            super(WatchDisableGoalTrackingSession.this.TAG);
            WatchDisableGoalTrackingSession.this.log("Set micro app mapping to " + WatchDisableGoalTrackingSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            boolean isSupportedFeature = WatchDisableGoalTrackingSession.this.bleAdapter.isSupportedFeature(ShineFeature.UAPP);
            if (!isSupportedFeature || WatchDisableGoalTrackingSession.this.oldMappings.isEmpty()) {
                if (isSupportedFeature) {
                    WatchDisableGoalTrackingSession.this.log("Micro app mapping is empty, size=" + WatchDisableGoalTrackingSession.this.oldMappings.size());
                } else {
                    WatchDisableGoalTrackingSession.this.log("Not support new micro app system");
                }
                WatchDisableGoalTrackingSession.this.enterStateWithDelayTime(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchDisableGoalTrackingSession.this.bleAdapter.setMicroAppMappings(WatchDisableGoalTrackingSession.this.oldMappings)) {
                    stopTimeout();
                    WatchDisableGoalTrackingSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
            stopTimeout();
            if (z) {
                WatchDisableGoalTrackingSession.this.enterState(WatchDisableGoalTrackingSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
            } else {
                WatchDisableGoalTrackingSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchDisableGoalTrackingSession.this.log("Set micro app mapping timeout " + WatchDisableGoalTrackingSession.this.serial);
            WatchDisableGoalTrackingSession.this.stop(FailureCode.FAILED_TO_SET_MICRO_APP_MAPPING);
        }
    }

    public WatchDisableGoalTrackingSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.URGENT, CommunicateMode.DISABLE_GOAL_TRACKING, bleAdapter, bleSessionCallback, sdkCallback);
        this.oldMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(bleAdapter.getContext(), bleAdapter.getSerial()));
    }

    public BleSession copyObject() {
        BleSession watchDisableGoalTrackingSession = new WatchDisableGoalTrackingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchDisableGoalTrackingSession.setDevice(this.device);
        return watchDisableGoalTrackingSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MICRO_APP_MAPPING_STATE, WatchSetMicroAppMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_STATE, DoneState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
