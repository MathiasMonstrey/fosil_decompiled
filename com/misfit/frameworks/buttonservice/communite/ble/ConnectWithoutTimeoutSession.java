package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;

public class ConnectWithoutTimeoutSession extends BleSession {

    public class CloseConnectionState extends BleState {
        public CloseConnectionState() {
            super(ConnectWithoutTimeoutSession.this.TAG);
            ConnectWithoutTimeoutSession.this.log("Close connection of device with serial " + ConnectWithoutTimeoutSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (ConnectWithoutTimeoutSession.this.bleAdapter.getGattState() == 2) {
                ConnectWithoutTimeoutSession.this.stop(0);
                return false;
            }
            startTimeout();
            ConnectWithoutTimeoutSession.this.bleAdapter.closeConnection(false);
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ConnectWithoutTimeoutSession.this.stop(0);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectWithoutTimeoutSession.this.log("Close connection timeout.");
            ConnectWithoutTimeoutSession.this.stop(0);
        }
    }

    public class ConnectWithoutTimeoutState extends BleState {
        public ConnectWithoutTimeoutState() {
            super(ConnectWithoutTimeoutSession.this.TAG);
            ConnectWithoutTimeoutSession.this.log("Connect without timeout " + ConnectWithoutTimeoutSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            ConnectWithoutTimeoutSession.this.bleAdapter.connect(false, (long) ConnectWithoutTimeoutSession.this.getStartTime());
            return true;
        }

        public boolean handleOnDeviceConnected() {
            ConnectWithoutTimeoutSession.this.stop(0);
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            ConnectWithoutTimeoutSession.this.stop(FailureCode.FAILED_TO_CONNECT);
            return true;
        }
    }

    protected ConnectWithoutTimeoutSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.CONNECT_WITHOUT_TIMEOUT, CommunicateMode.CONNECT_WITHOUT_TIMEOUT, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession connectWithoutTimeoutSession = new ConnectWithoutTimeoutSession(this.bleAdapter, this.bleSessionCallback);
        connectWithoutTimeoutSession.setDevice(this.device);
        return connectWithoutTimeoutSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.CONNECT_WITHOUT_TIMEOUT, ConnectWithoutTimeoutState.class.getName());
        this.sessionStateMap.put(SessionState.CLOSE_CONNECTION_STATE, CloseConnectionState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        return enterState(createConcreteState(SessionState.CONNECT_WITHOUT_TIMEOUT));
    }

    protected void buildExtraInfoReturned() {
    }

    public void closeConnectWithoutTimeout() {
        log("Close connect without timeout to run another session");
        enterState(createConcreteState(SessionState.CLOSE_CONNECTION_STATE));
    }
}
