package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
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
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Direction;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.MovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Speed;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;

public class WatchCalibrationSession extends ConnectableSession {
    private static final int FAST_CONNECTION_TIMEOUT = 30000;
    private static final String TAG = WatchCalibrationSession.class.getSimpleName();

    public class ApplyHandsPositionState extends BleState {
        public ApplyHandsPositionState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Apply hands to device with serial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            WatchCalibrationSession.this.setCommunicateMode(CommunicateMode.APPLY_HAND_POSITION);
            if (WatchCalibrationSession.this.bleAdapter.applyHandPosition()) {
                return true;
            }
            stopTimeout();
            WatchCalibrationSession.this.setFailureCode(FailureCode.FAILED_TO_APPLY_HAND_POSITION);
            WatchCalibrationSession.this.enterStateWithDelayTime(WatchCalibrationSession.this.createConcreteState(SessionState.RELEASE_HAND_CONTROL_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnApplyHandPositionCompleted(boolean z) {
            stopTimeout();
            if (z) {
                if (WatchCalibrationSession.this.bleSessionCallback != null) {
                    WatchCalibrationSession.this.bleSessionCallback.onBleStateResult(0, null);
                }
                WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.RELEASE_HAND_CONTROL_STATE));
            } else {
                WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_APPLY_HAND_POSITION);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Apply hands timeout.");
            WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_APPLY_HAND_POSITION);
        }
    }

    public class MoveHandState extends BleState {
        private boolean isSending;

        public MoveHandState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Move hand of device with serial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            WatchCalibrationSession.this.setCommunicateMode(CommunicateMode.MOVE_HAND);
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchCalibrationSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        public boolean moveHand(HandId handId, MovingType movingType, Direction direction, Speed speed, int i) {
            this.isSending = true;
            startTimeout();
            return WatchCalibrationSession.this.bleAdapter.moveHandsToPosition(handId, movingType, direction, speed, i);
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Move hand timeout.");
            this.isSending = false;
            WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_MOVE_HAND);
            if (WatchCalibrationSession.this.bleSessionCallback != null) {
                WatchCalibrationSession.this.bleSessionCallback.onBleStateResult(FailureCode.FAILED_TO_MOVE_HAND, null);
            }
        }

        public boolean handleOnMovingHandsCompleted(ActionResult actionResult) {
            Reason reason = null;
            this.isSending = false;
            stopTimeout();
            if (actionResult.getResultCode() != ResultCode.SUCCEEDED) {
                WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_MOVE_HAND);
                try {
                    reason = actionResult.getError().getReason();
                } catch (IllegalArgumentException e) {
                    WatchCalibrationSession.this.log("Error Inside " + WatchCalibrationSession.TAG + ".handleOnMovingHandsCompleted - ex=" + e.toString());
                }
                if (reason == Reason.RESOURCE_UNAVAILABLE_ERROR) {
                    WatchCalibrationSession.this.log("Error inside " + WatchCalibrationSession.TAG + ".handleOnMovingHandsCompleted - Device is not in calibration mode. Enter calibration mode again");
                    WatchCalibrationSession.this.start(WatchCalibrationSession.this.sessionParams);
                }
            } else if (WatchCalibrationSession.this.bleSessionCallback != null) {
                WatchCalibrationSession.this.bleSessionCallback.onBleStateResult(0, reason);
            }
            return true;
        }
    }

    public class ReleaseHandControlState extends BleState {
        public ReleaseHandControlState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Release hand control of device with serial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            WatchCalibrationSession.this.setCommunicateMode(CommunicateMode.EXIT_CALIBRATION);
            startTimeout();
            if (WatchCalibrationSession.this.bleAdapter.releaseHandControl()) {
                return true;
            }
            stopTimeout();
            WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_RELEASE_HAND_CONTROL);
            return false;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchCalibrationSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        public boolean handleOnReleaseHandsControlCompleted(boolean z) {
            stopTimeout();
            WatchCalibrationSession.this.stop(z ? 0 : FailureCode.FAILED_TO_RELEASE_HAND_CONTROL);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Release hand control timeout.");
            WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_RELEASE_HAND_CONTROL);
        }
    }

    public class RequestHandControlState extends BleState {
        public RequestHandControlState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Request hand control of device with seial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            WatchCalibrationSession.this.setCommunicateMode(CommunicateMode.ENTER_CALIBRATION);
            if (WatchCalibrationSession.this.bleAdapter.requestHandControl()) {
                return true;
            }
            stopTimeout();
            WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_REQUEST_HAND_CONTROL);
            return false;
        }

        public int getTimeout() {
            return 20000;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Request hand control of device with serial timeout.");
            WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_REQUEST_HAND_CONTROL);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            WatchCalibrationSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        public boolean handleOnRequestHandsControlCompleted(boolean z) {
            stopTimeout();
            if (!z) {
                WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_REQUEST_HAND_CONTROL);
            } else if (WatchCalibrationSession.this.bleSessionCallback != null) {
                WatchCalibrationSession.this.bleSessionCallback.onBleStateResult(0, null);
            }
            return true;
        }
    }

    public class ResetHandPositionState extends BleState {

        class C47031 implements Runnable {
            C47031() {
            }

            public void run() {
                if (!WatchCalibrationSession.this.bleAdapter.resetHandsPosition()) {
                    ResetHandPositionState.this.stopTimeout();
                    WatchCalibrationSession.this.stop(FailureCode.FAILED_TO_RESET_HAND_CONTROL);
                }
            }
        }

        public ResetHandPositionState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Reset hand position of device with serial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            WatchCalibrationSession.this.setCommunicateMode(CommunicateMode.RESET_HAND);
            WatchCalibrationSession.this.enterTaskWithDelayTime(new C47031(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnMovingHandsCompleted(ActionResult actionResult) {
            Reason reason = null;
            if (actionResult.getResultCode() != ResultCode.SUCCEEDED) {
                WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_RESET_HAND_CONTROL);
                try {
                    reason = actionResult.getError().getReason();
                } catch (IllegalArgumentException e) {
                    WatchCalibrationSession.this.log("Error Inside " + WatchCalibrationSession.TAG + ".handleOnMovingHandsCompleted - ex=" + e.toString());
                }
                if (reason == Reason.RESOURCE_UNAVAILABLE_ERROR) {
                    WatchCalibrationSession.this.log("Error inside " + WatchCalibrationSession.TAG + ".handleOnMovingHandsCompleted - Device is not in calibration mode. Enter calibration mode again");
                    WatchCalibrationSession.this.start(WatchCalibrationSession.this.sessionParams);
                }
            } else {
                if (WatchCalibrationSession.this.bleSessionCallback != null) {
                    WatchCalibrationSession.this.bleSessionCallback.onBleStateResult(0, reason);
                }
                WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAM_FOR_CALIBRATION));
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Reset hand position timeout");
            WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_RESET_HAND_CONTROL);
            WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.SET_CONNECTION_PARAM_FOR_CALIBRATION));
        }
    }

    public class SetConnectionParamsState extends BleState {
        public SetConnectionParamsState() {
            super(WatchCalibrationSession.TAG);
            WatchCalibrationSession.this.log("Set connection params to device with serial " + WatchCalibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchCalibrationSession.this.bleAdapter.setConnectionParams(BleAdapter.FAST_CONNECTION_PARAMS)) {
                return true;
            }
            stopTimeout();
            WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchCalibrationSession.this.enterStateWithDelayTime(WatchCalibrationSession.this.createConcreteState(SessionState.MOVE_HAND_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
            if (!z) {
                if (shineError.getReason() == Reason.INCOMPATIBLE_PARAMS) {
                    WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM_INCOMPATIBLE);
                } else {
                    WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
                }
            }
            stopTimeout();
            WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.MOVE_HAND_STATE));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchCalibrationSession.this.log("Set connection params timeout.");
            WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.MOVE_HAND_STATE));
        }

        protected void onFatal(int i) {
            WatchCalibrationSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONNECTION_PARAM);
            WatchCalibrationSession.this.enterState(WatchCalibrationSession.this.createConcreteState(SessionState.MOVE_HAND_STATE));
        }

        public int getTimeout() {
            return 20000;
        }
    }

    protected int getMaxRetries() {
        return 0;
    }

    public BleSession copyObject() {
        BleSession watchCalibrationSession = new WatchCalibrationSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchCalibrationSession.setDevice(this.device);
        return watchCalibrationSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.REQUEST_HAND_CONTROL_STATE, RequestHandControlState.class.getName());
        this.sessionStateMap.put(SessionState.RESET_HAND_POSITION_STATE, ResetHandPositionState.class.getName());
        this.sessionStateMap.put(SessionState.SET_CONNECTION_PARAM_FOR_CALIBRATION, SetConnectionParamsState.class.getName());
        this.sessionStateMap.put(SessionState.MOVE_HAND_STATE, MoveHandState.class.getName());
        this.sessionStateMap.put(SessionState.APPLY_HANDS_POSITION_STATE, ApplyHandsPositionState.class.getName());
        this.sessionStateMap.put(SessionState.RELEASE_HAND_CONTROL_STATE, ReleaseHandControlState.class.getName());
    }

    public WatchCalibrationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.ENTER_CALIBRATION, bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected boolean onStart(Object... objArr) {
        return super.onStart(objArr);
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.REQUEST_HAND_CONTROL_STATE);
    }

    public boolean handleMoveHandRequest(HandId handId, MovingType movingType, Direction direction, Speed speed, int i) {
        BleState state = getState();
        MFLogger.d(TAG, "Inside " + TAG + ".handleMoveHandRequest - currentState=" + state);
        if (state != null) {
            if (state instanceof MoveHandState) {
                MoveHandState moveHandState = (MoveHandState) state;
                if (!moveHandState.isSending) {
                    moveHandState.moveHand(handId, movingType, direction, speed, i);
                }
            } else {
                MFLogger.e(TAG, "Inside " + TAG + ".handleMoveHandRequest - currentState is not move hand state");
            }
        } else if (this.bleAdapter.getGattState() == 2) {
            if (this.bleAdapter.isDeviceReady()) {
                enterState(createConcreteState(SessionState.REQUEST_HAND_CONTROL_STATE));
            } else {
                onStart(this.sessionParams);
            }
        }
        return false;
    }

    public boolean handleReleaseHandControl() {
        return enterState(createConcreteState(SessionState.RELEASE_HAND_CONTROL_STATE));
    }

    public boolean handleResetHandsPosition() {
        return enterState(createConcreteState(SessionState.RESET_HAND_POSITION_STATE));
    }

    public boolean handleApplyHandsPosition() {
        return enterState(createConcreteState(SessionState.APPLY_HANDS_POSITION_STATE));
    }

    protected void buildExtraInfoReturned() {
    }
}
