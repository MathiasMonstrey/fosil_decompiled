package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
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
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Hashtable;

public class WatchGetSecondTimezoneSession extends ConnectableSession {
    private int secondTimezoneOffset = 1024;

    public class GetSecondTimezoneState extends BleState {
        public GetSecondTimezoneState() {
            super(WatchGetSecondTimezoneSession.this.TAG);
            WatchGetSecondTimezoneSession.this.log("Get second timezone of device with serial " + WatchGetSecondTimezoneSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchGetSecondTimezoneSession.this.bleAdapter.getSecondTimezone()) {
                return true;
            }
            stopTimeout();
            WatchGetSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_GET_SECOND_TIMEZONE);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchGetSecondTimezoneSession.this.log("Get second timezone timeout.");
            WatchGetSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_GET_SECOND_TIMEZONE);
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                MFLogger.d(WatchGetSecondTimezoneSession.this.TAG, "All done of " + WatchGetSecondTimezoneSession.this.TAG);
                WatchGetSecondTimezoneSession.this.secondTimezoneOffset = getSecondTimezoneOffset(hashtable);
                WatchGetSecondTimezoneSession.this.stop(0);
            } else {
                WatchGetSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_GET_SECOND_TIMEZONE);
            }
            return true;
        }

        private short getSecondTimezoneOffset(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    return shineConfiguration.mTimezoneOffset;
                }
                MFLogger.d(WatchGetSecondTimezoneSession.this.TAG, "Inside " + WatchGetSecondTimezoneSession.this.TAG + ", getVibrationStrength failed, shineConfiguration is null");
            }
            return (short) -1;
        }
    }

    public WatchGetSecondTimezoneSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.GET_SECOND_TIMEZONE, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession watchGetSecondTimezoneSession = new WatchGetSecondTimezoneSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchGetSecondTimezoneSession.setDevice(this.device);
        return watchGetSecondTimezoneSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_SECOND_TIMEZONE_STATE, GetSecondTimezoneState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_SECOND_TIMEZONE_STATE);
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putInt(Constants.TZ_OFFSET, this.secondTimezoneOffset);
    }
}
