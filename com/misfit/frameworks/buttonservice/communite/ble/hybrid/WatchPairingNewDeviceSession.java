package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.PairingNewDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchPairingNewDeviceSession extends PairingNewDeviceSession {
    private static final String TAG = WatchPairingNewDeviceSession.class.getSimpleName();
    private boolean hasHID = false;
    private List<MicroAppMapping> microAppMappings;

    public class DonePairingNewDeviceSessionState extends BleState {
        public DonePairingNewDeviceSessionState() {
            super(WatchPairingNewDeviceSession.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchPairingNewDeviceSession.TAG, "All done of " + WatchPairingNewDeviceSession.TAG);
            WatchPairingNewDeviceSession.this.stop(0);
            return true;
        }
    }

    public class WatchProcessHIDState extends BleState {
        public WatchProcessHIDState() {
            super(WatchPairingNewDeviceSession.TAG);
            WatchPairingNewDeviceSession.this.log("Process HID");
        }

        private boolean isNeedConnectHID() {
            return WatchPairingNewDeviceSession.this.hasHID;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean onEnter() {
            super.onEnter();
            if (isNeedConnectHID()) {
                startTimeout();
                if (!WatchPairingNewDeviceSession.this.bleAdapter.hidConnect()) {
                    stopTimeout();
                    WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            WatchPairingNewDeviceSession.this.log("No need to connect HID. Try to disconnect HID.");
            startTimeout();
            if (!WatchPairingNewDeviceSession.this.bleAdapter.hidDisconnect()) {
                stopTimeout();
                WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
            return true;
        }

        public boolean handleOnHidConnected() {
            stopTimeout();
            WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (isNeedConnectHID()) {
                WatchPairingNewDeviceSession.this.log("Connect HID timeout");
            } else {
                WatchPairingNewDeviceSession.this.log("Disconnect HID timeout");
            }
            WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class WatchProcessMappingState extends BleState {
        public WatchProcessMappingState() {
            super(WatchPairingNewDeviceSession.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            for (MicroAppMapping isNeedHID : WatchPairingNewDeviceSession.this.microAppMappings) {
                if (isNeedHID.isNeedHID()) {
                    WatchPairingNewDeviceSession.this.hasHID = true;
                }
            }
            WatchPairingNewDeviceSession.this.enterState(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_STREAMING));
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class WatchProcessStreamingState extends BleState {
        public WatchProcessStreamingState() {
            super(WatchPairingNewDeviceSession.TAG);
            WatchPairingNewDeviceSession.this.log("Process streaming");
        }

        public boolean onEnter() {
            super.onEnter();
            if (WatchPairingNewDeviceSession.this.bleAdapter.isStreaming()) {
                WatchPairingNewDeviceSession.this.log("No need to start streaming");
                WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!WatchPairingNewDeviceSession.this.bleAdapter.startStreaming(WatchPairingNewDeviceSession.this.sdkCallback)) {
                    stopTimeout();
                    WatchPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchPairingNewDeviceSession.this.log("Start streaming time out");
            WatchPairingNewDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            WatchPairingNewDeviceSession.this.enterStateWithDelayTime(WatchPairingNewDeviceSession.this.createConcreteState(SessionState.PROCESS_HID), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public WatchPairingNewDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected void initSettings() {
        super.initSettings();
        this.microAppMappings = MicroAppMapping.convertToMicroAppMapping(DevicePreferenceUtils.getAutoMapping(this.context, this.serial));
    }

    public BleSession copyObject() {
        BleSession watchPairingNewDeviceSession = new WatchPairingNewDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchPairingNewDeviceSession.setDevice(this.device);
        return watchPairingNewDeviceSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.PROCESS_MAPPING, WatchProcessMappingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_STREAMING, WatchProcessStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.PROCESS_HID, WatchProcessHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_PAIRING_NEW_DEVICE_SESSION_STATE, DonePairingNewDeviceSessionState.class.getName());
    }

    protected BleState getStateAfterSetMultipleAlarm() {
        return createConcreteState(SessionState.PROCESS_MAPPING);
    }
}
