package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class UnlinkSession extends BleSession {
    private static final String TAG = UnlinkSession.class.getSimpleName();

    public class CloseConnectionState extends BleState {
        public CloseConnectionState() {
            super(UnlinkSession.TAG);
            UnlinkSession.this.log("Close connection to device with serial " + UnlinkSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            UnlinkSession.this.bleAdapter.closeConnection(true);
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            UnlinkSession.this.enterState(UnlinkSession.this.createConcreteState(SessionState.HID_DISCONNECT_STATE));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            UnlinkSession.this.log("Close connection timeout.");
            UnlinkSession.this.enterState(UnlinkSession.this.createConcreteState(SessionState.HID_DISCONNECT_STATE));
        }

        public int getTimeout() {
            return 3000;
        }
    }

    public class HidDisconnectState extends BleState {
        public HidDisconnectState() {
            super(UnlinkSession.TAG);
            UnlinkSession.this.log("HID Disconnect with serial " + UnlinkSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            UnlinkSession.this.bleAdapter.hidDisconnect();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            UnlinkSession.this.log("HID Disconnect timeout.");
            UnlinkSession.this.stop(0);
        }

        public int getTimeout() {
            return 1000;
        }
    }

    public class InterruptState extends BleState {
        public InterruptState() {
            super(UnlinkSession.TAG);
            UnlinkSession.this.log("Interrupt all actions");
        }

        public boolean onEnter() {
            super.onEnter();
            UnlinkSession.this.bleAdapter.interrupt();
            UnlinkSession.this.enterStateWithDelayTime(UnlinkSession.this.createConcreteState(SessionState.CLOSE_CONNECTION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }
    }

    public UnlinkSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.SPECIAL, CommunicateMode.UNLINK, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession unlinkSession = new UnlinkSession(this.bleAdapter, this.bleSessionCallback);
        unlinkSession.setDevice(this.device);
        return unlinkSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.INTERRUPT_PENDING_ACTION_STATE, InterruptState.class.getName());
        this.sessionStateMap.put(SessionState.CLOSE_CONNECTION_STATE, CloseConnectionState.class.getName());
        this.sessionStateMap.put(SessionState.HID_DISCONNECT_STATE, HidDisconnectState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        return enterState(createConcreteState(SessionState.INTERRUPT_PENDING_ACTION_STATE));
    }

    protected void buildExtraInfoReturned() {
    }
}
