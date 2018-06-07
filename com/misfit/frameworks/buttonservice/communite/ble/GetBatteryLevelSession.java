package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.Constants;

public class GetBatteryLevelSession extends BleSession {
    private int batteryLevel = -1;

    public GetBatteryLevelSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.GET_BATTERY_LEVEL, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession getBatteryLevelSession = new GetBatteryLevelSession(this.bleAdapter, this.bleSessionCallback);
        getBatteryLevelSession.setDevice(this.device);
        return getBatteryLevelSession;
    }

    protected void initStateMap() {
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            this.batteryLevel = this.bleAdapter.getBatteryLevel();
            stop(0);
        } else {
            stop(FailureCode.FAILED_TO_GET_BATTERY);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putInt(Constants.BATTERY, this.batteryLevel);
    }
}
