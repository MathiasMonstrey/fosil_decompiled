package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;

public class ReadRssiSession extends BleSession {
    private static final String TAG = ReadRssiSession.class.getSimpleName();
    private int remoteRssi = 100;

    public class ReadRssiState extends BleState {
        public ReadRssiState() {
            super(ReadRssiSession.TAG);
            ReadRssiSession.this.log("Read rssi of device with serial " + ReadRssiSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (ReadRssiSession.this.bleAdapter.readRssi()) {
                return true;
            }
            stopTimeout();
            ReadRssiSession.this.stop(FailureCode.FAILED_TO_READ_RSSI);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            ReadRssiSession.this.log("Read rssi timeout.");
            ReadRssiSession.this.stop(FailureCode.FAILED_TO_READ_RSSI);
        }

        public boolean handleOnReadRssiCompleted(boolean z, int i) {
            stopTimeout();
            if (z) {
                MFLogger.d(ReadRssiSession.TAG, "All done of " + ReadRssiSession.TAG);
                ReadRssiSession.this.remoteRssi = i;
                ReadRssiSession.this.stop(0);
            } else {
                ReadRssiSession.this.stop(FailureCode.FAILED_TO_READ_RSSI);
            }
            return true;
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public ReadRssiSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.READ_RSSI, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession readRssiSession = new ReadRssiSession(this.bleAdapter, this.bleSessionCallback);
        readRssiSession.setDevice(this.device);
        return readRssiSession;
    }

    protected boolean mustSendBroadcast() {
        return true;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.READ_RSSI_STATE, ReadRssiState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            enterState(createConcreteState(SessionState.READ_RSSI_STATE));
        } else {
            stop(FailureCode.FAILED_TO_READ_RSSI);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putInt(Constants.RSSI, this.remoteRssi);
    }
}
