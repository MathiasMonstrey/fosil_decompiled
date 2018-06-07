package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Reason;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.StopStreamingBaseState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.log.MFLog;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.buttonservice.log.MFSyncLog;
import com.misfit.frameworks.buttonservice.model.Mapping;
import com.misfit.frameworks.buttonservice.model.MicroAppMode;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class HWLogSyncSession extends ConnectableSession {
    private boolean hasStreaming = isStreamming();
    protected List<Mapping> mappings;
    protected MFSyncLog syncLog;
    protected int syncMode = 14;

    public class DoneSyncState extends BleState {
        public DoneSyncState() {
            super(HWLogSyncSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            HWLogSyncSession.this.log("All done of " + HWLogSyncSession.this.TAG);
            HWLogSyncSession.this.stop(0);
            return true;
        }
    }

    public class InterruptPendingActionState extends BleState {
        public InterruptPendingActionState() {
            super(HWLogSyncSession.this.TAG);
            HWLogSyncSession.this.log("Interrupt pending action of device with serial " + HWLogSyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (HWLogSyncSession.this.bleAdapter.interrupt()) {
                return true;
            }
            stopTimeout();
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            boolean hasPendingAction = HWLogSyncSession.this.bleAdapter.hasPendingAction();
            HWLogSyncSession.this.log("Interrupt timeout - Has pending action=" + hasPendingAction);
            if (hasPendingAction) {
                HWLogSyncSession.this.bleAdapter.closeConnection(!HWLogSyncSession.this.canRetry(HWLogSyncSession.this.maxRetries, FailureCode.UNEXPECTED_DISCONNECT));
                return;
            }
            HWLogSyncSession.this.enterState(HWLogSyncSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAMS_STATE));
        }

        public int getTimeout() {
            return 3000;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            HWLogSyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class ReadHardwareLogState extends BleState {
        public ReadHardwareLogState() {
            super(HWLogSyncSession.this.TAG);
            HWLogSyncSession.this.log("Read hardware log of device with serial " + HWLogSyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (HWLogSyncSession.this.bleAdapter.readHardwareLog(true)) {
                return true;
            }
            stopTimeout();
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.START_STREAMING_AFTER_SYNCING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            HWLogSyncSession.this.log("Read hardware log timeout");
            HWLogSyncSession.this.enterState(HWLogSyncSession.this.createConcreteState(SessionState.START_STREAMING_AFTER_SYNCING_STATE));
        }

        public boolean handleOnHardwareLogRead(boolean z, byte[] bArr) {
            stopTimeout();
            HWLogSyncSession.this.enterState(HWLogSyncSession.this.createConcreteState(SessionState.START_STREAMING_AFTER_SYNCING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            HWLogSyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(HWLogSyncSession.this.TAG);
            HWLogSyncSession.this.log("Set connection params to device with serial " + HWLogSyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (HWLogSyncSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            HWLogSyncSession.this.log("Set connection params timeout.");
            HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            stopTimeout();
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            HWLogSyncSession.this.enterState(HWLogSyncSession.this.createConcreteState(SessionState.STOP_STREAMING_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            HWLogSyncSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public class StartStreamingState extends BleState {
        public StartStreamingState() {
            super(HWLogSyncSession.this.TAG);
            HWLogSyncSession.this.log("Start streaming to device with serial " + HWLogSyncSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (HWLogSyncSession.this.bleAdapter.isStreaming()) {
                HWLogSyncSession.this.log("No need to start streaming");
                HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            } else {
                startTimeout();
                if (!HWLogSyncSession.this.bleAdapter.startStreaming(HWLogSyncSession.this.sdkCallback)) {
                    stopTimeout();
                    HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
                    HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            return true;
        }

        public boolean handleOnStartStreamingCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            }
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            HWLogSyncSession.this.log("Start streaming time out");
            HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_START_STREAMING);
            HWLogSyncSession.this.enterStateWithDelayTime(HWLogSyncSession.this.createConcreteState(SessionState.DONE_SYNC_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    public class StopStreamingState extends StopStreamingBaseState {
        public StopStreamingState() {
            super(HWLogSyncSession.this.bleAdapter, HWLogSyncSession.this);
            HWLogSyncSession.this.log("Stop streaming to device with serial " + HWLogSyncSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (!z) {
                HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            }
            return HWLogSyncSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE);
        }

        protected BleState getStateOnTimeOut() {
            HWLogSyncSession.this.addFailureCode(FailureCode.FAILED_TO_STOP_STREAMING);
            return HWLogSyncSession.this.createConcreteState(SessionState.READ_HARDWARE_LOG_STATE);
        }

        protected boolean isSkipStopStreaming() {
            return HWLogSyncSession.this.bleAdapter.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING);
        }
    }

    public HWLogSyncSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.SYNC, CommunicateMode.HW_LOG_SYNC, bleAdapter, bleSessionCallback, sdkCallback);
        this.sdkCallback = sdkCallback;
    }

    protected boolean onStart(Object... objArr) {
        if (getRetriesCounter() == 0) {
            this.syncLog = MFLogManager.getInstance(this.bleAdapter.getContext()).startSyncLog(this.serial);
            this.mfLog = this.syncLog;
            if (this.syncLog != null) {
                this.syncLog.setSerial(this.serial);
                this.syncLog.setFirmwareVersion(this.bleAdapter.getFirmwareVersion());
                this.syncLog.setSyncMode(this.syncMode);
            }
        }
        MFLogger.i(this.TAG, "START SYNCING SESSION - syncMode=" + this.syncMode + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        log("Start new sync session: syncMode=" + this.syncMode + ", locationServiceEnabled=" + LocationUtils.isLocationEnable(this.context) + ", locationPermissionAllowed=" + LocationUtils.isLocationPermissionGranted(this.context));
        return super.onStart(objArr);
    }

    protected void buildExtraInfoReturned() {
        MFLog end = MFLogManager.getInstance(this.bleAdapter.getContext()).end(CommunicateMode.SYNC, this.serial);
        this.extraInfoReturned.putInt(ButtonService.LOG_ID, end != null ? end.getStartTimeEpoch() : 0);
    }

    protected boolean canRetry(int i, int i2) {
        if (i < getMaxRetries()) {
            return true;
        }
        return false;
    }

    public BleSession copyObject() {
        BleSession hWLogSyncSession = new HWLogSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        hWLogSyncSession.setDevice(this.device);
        return hWLogSyncSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.INTERRUPT_PENDING_ACTION_STATE, InterruptPendingActionState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAMS_STATE, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.STOP_STREAMING_STATE, StopStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.READ_HARDWARE_LOG_STATE, ReadHardwareLogState.class.getName());
        this.sessionStateMap.put(SessionState.START_STREAMING_AFTER_SYNCING_STATE, StartStreamingState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_SYNC_STATE, DoneSyncState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.INTERRUPT_PENDING_ACTION_STATE);
    }

    private boolean isStreamming() {
        if (this.mappings != null) {
            for (Mapping action : this.mappings) {
                if (MicroAppMode.fromAction(action.getAction()) == MicroAppMode.STREAMING) {
                    return true;
                }
            }
        }
        return false;
    }
}
