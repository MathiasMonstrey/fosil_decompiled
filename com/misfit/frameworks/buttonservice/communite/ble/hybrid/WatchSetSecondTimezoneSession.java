package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.ConversionUtils;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;

public class WatchSetSecondTimezoneSession extends ConnectableSession {
    protected String mOldSecondTimezoneId;
    protected String mSecondTimezoneId;

    public class DoneSetAutoSecondTimezoneState extends BleState {
        public DoneSetAutoSecondTimezoneState() {
            super(WatchSetSecondTimezoneSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchSetSecondTimezoneSession.this.TAG, "All done of " + WatchSetSecondTimezoneSession.this.TAG);
            WatchSetSecondTimezoneSession.this.stop(0);
            return true;
        }
    }

    public class SetSecondTimezoneState extends BleState {
        public SetSecondTimezoneState() {
            super(WatchSetSecondTimezoneSession.this.TAG);
            WatchSetSecondTimezoneSession.this.log("Set second timezone to device with serial " + WatchSetSecondTimezoneSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchSetSecondTimezoneSession.this.bleAdapter.enableSecondTimezone(ConversionUtils.getTimezoneRawOffsetById(WatchSetSecondTimezoneSession.this.mSecondTimezoneId))) {
                return true;
            }
            stopTimeout();
            WatchSetSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
            return false;
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.setAutoSecondTimezone(WatchSetSecondTimezoneSession.this.bleAdapter.getContext(), WatchSetSecondTimezoneSession.this.mSecondTimezoneId);
                DevicePreferenceUtils.removeSettingFlag(WatchSetSecondTimezoneSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
            }
            WatchSetSecondTimezoneSession.this.stop(z ? 0 : FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSetSecondTimezoneSession.this.log("Set second timezone to " + WatchSetSecondTimezoneSession.this.serial + " onTimeout");
            WatchSetSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
        }
    }

    public WatchSetSecondTimezoneSession(String str, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.SET_SECOND_TIMEZONE, bleAdapter, bleSessionCallback, sdkCallback);
        this.mSecondTimezoneId = str;
    }

    public BleSession copyObject() {
        BleSession watchSetSecondTimezoneSession = new WatchSetSecondTimezoneSession(this.mSecondTimezoneId, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchSetSecondTimezoneSession.setDevice(this.device);
        return watchSetSecondTimezoneSession;
    }

    public boolean accept(BleSession bleSession) {
        return (getCommunicateMode() == bleSession.getCommunicateMode() || bleSession.getCommunicateMode() == CommunicateMode.SET_AUTO_SECOND_TIMEZONE) ? false : true;
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        if (!this.mOldSecondTimezoneId.equals(this.mSecondTimezoneId)) {
            return super.onStart(objArr);
        }
        log("The second timezone ids are the same. No need to set again");
        enterStateWithDelayTime(createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }

    private void initSettings() {
        this.mOldSecondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(this.context);
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_SECOND_TIMEZONE_STATE, SetSecondTimezoneState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoSecondTimezoneState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_SECOND_TIMEZONE_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
