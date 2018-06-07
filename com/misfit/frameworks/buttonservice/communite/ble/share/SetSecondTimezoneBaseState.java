package com.misfit.frameworks.buttonservice.communite.ble.share;

import android.text.TextUtils;
import android.util.Log;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class SetSecondTimezoneBaseState extends BleState {
    private static final String TAG = SetSecondTimezoneBaseState.class.getSimpleName();
    private BleAdapter bleAdapter;
    private BleSession currentSession;
    private String secondTimezoneId;
    private int secondTimezoneOffset;

    protected abstract BleState getStateOnCompleted(boolean z);

    protected abstract BleState getStateOnTimeOut();

    public SetSecondTimezoneBaseState(int i, String str, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.secondTimezoneOffset = i;
        this.secondTimezoneId = str;
    }

    public boolean onEnter() {
        boolean disableSecondTimezone;
        super.onEnter();
        startTimeout();
        if (TextUtils.isEmpty(this.secondTimezoneId)) {
            disableSecondTimezone = this.bleAdapter.disableSecondTimezone();
        } else {
            disableSecondTimezone = this.bleAdapter.enableSecondTimezone(this.secondTimezoneOffset);
        }
        if (disableSecondTimezone) {
            return true;
        }
        stopTimeout();
        BleState stateOnCompleted = getStateOnCompleted(false);
        if (stateOnCompleted == null) {
            return false;
        }
        this.currentSession.enterStateWithDelayTime(stateOnCompleted, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return false;
    }

    public boolean handleOnSetSecondTimeZoneCompleted(boolean z) {
        stopTimeout();
        if (z) {
            Log.d(TAG, "Set secondTimezoneId=" + this.secondTimezoneId + " to preferences");
            DevicePreferenceUtils.setAutoSecondTimezone(this.bleAdapter.getContext(), this.secondTimezoneId);
            this.currentSession.enterState(getStateOnCompleted(true));
        } else {
            this.currentSession.enterState(getStateOnCompleted(false));
        }
        return true;
    }

    public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        stopTimeout();
        this.currentSession.stop(FailureCode.UNEXPECTED_DISCONNECT);
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("Set second timezone timeout.");
        this.currentSession.enterState(getStateOnCompleted(false));
    }
}
