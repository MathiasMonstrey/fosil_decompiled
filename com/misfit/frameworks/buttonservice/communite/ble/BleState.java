package com.misfit.frameworks.buttonservice.communite.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.HandPositions;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.frameworks.buttonservice.log.MFLogManager;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Hashtable;
import java.util.Locale;

public abstract class BleState implements BleCallback {
    protected static final int DELAY_TIME_ENTER_STATE = 500;
    private String TAG = BleState.class.getSimpleName();
    private boolean isExist = true;
    protected int retryCounter = 0;
    private Handler timeoutHandler;
    private Runnable timeoutTask = new C47001();

    class C47001 implements Runnable {
        C47001() {
        }

        public void run() {
            BleState.this.onTimeout();
        }
    }

    public BleState(String str) {
        this.TAG = str + "." + getClass().getSimpleName();
        this.isExist = true;
    }

    protected synchronized void startTimeout() {
        stopTimeout();
        long timeout = (long) getTimeout();
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".startTimeout " + (timeout / 1000) + " second(s)");
        if (this.isExist) {
            this.timeoutHandler = new Handler(Looper.getMainLooper());
            this.timeoutHandler.postDelayed(this.timeoutTask, timeout);
        }
    }

    protected synchronized void stopTimeout() {
        if (this.timeoutHandler != null) {
            MFLogger.d(this.TAG, "Inside " + this.TAG + ".stopTimeout");
            this.timeoutHandler.removeCallbacks(this.timeoutTask);
        }
        this.timeoutHandler = null;
    }

    public boolean onEnter() {
        MFLogger.d(this.TAG, "Enter state: " + this.TAG.toUpperCase(Locale.US));
        return true;
    }

    public void onExit() {
        stopTimeout();
        this.isExist = false;
        MFLogger.d(this.TAG, "Exit state: " + this.TAG.toUpperCase(Locale.US));
    }

    public void onTimeout() {
        MFLogger.d(this.TAG, "onTimeout state: " + this.TAG);
    }

    protected boolean onRetry(Context context, String str) {
        MFLogger.d(this.TAG, "Retry state: " + this.TAG + ", counter=" + this.retryCounter + ", maxRetries=" + getMaxRetries());
        MFLogManager.getInstance(context).addLogForActiveLog(str, "Retry state: " + this.TAG + ", counter=" + this.retryCounter + ", maxRetries=" + getMaxRetries());
        if (this.retryCounter >= getMaxRetries()) {
            return false;
        }
        this.retryCounter++;
        onEnter();
        return true;
    }

    public void onFatal(int i) {
        MFLogger.d(this.TAG, "Fatal state: " + this.TAG + ", failureCode=" + i);
    }

    protected int getMaxRetries() {
        return 0;
    }

    protected boolean isInterruptable() {
        return false;
    }

    public int getTimeout() {
        return 45000;
    }

    protected final void logUnexpectedCallback() {
        MFLogger.i(this.TAG, this + " State  not expected to " + new Throwable().getStackTrace()[1]);
    }

    public boolean handleOnDeviceScanned(ShineDevice shineDevice, int i) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnRetrieveDeviceComplete() {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDeviceConnected() {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDevicePreparedCompleted(boolean z) {
        return false;
    }

    public boolean handleOnPlayAnimationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnPlaySyncAnimationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnStopAnimationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnPlayButtonAnimationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnUnmapAllEventsCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnActivateCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGettingMappingTypeCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetConfigurationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnEnablingCallTextNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDisableCallTextNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendCallNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendTextNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendAppNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendHandNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetInactiveNudgeCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSettingSingleAlarmCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGettingAlarmCompleted(boolean z, AlarmSettings alarmSettings) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnClearAllAlarmsCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetFlashButtonModeCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetLapCountingStatus(boolean z, Hashtable<ShineProperty, Object> hashtable) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetLapCountingMode(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetLapCountingLicense(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetActivityType(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnStartStreamingCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnHeartbeatReceived() {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnButtonEvent(int i) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnStopStreamingCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDataReadProgressUpdate(int i, byte[] bArr) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnHardwareLogRead(boolean z, byte[] bArr) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnDataReadCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnOtaCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnOtaProgressUpdate(float f) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnApplyHandPositionCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnMovingHandsCompleted(ActionResult actionResult) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnRequestHandsControlCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnReleaseHandsControlCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetGoalInStepCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetSecondTimeZoneCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetSecondTimeZoneCompleted(boolean z, int i) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSettingMappingCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnMicroAppConfigCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetHandPositionCompleted(boolean z, HandPositions handPositions) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSettingMappingAnimationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSettingGoalTrackingCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetVibrationStrengthCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetVibrationStrengthCompleted(boolean z, short s) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnHidConnected() {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnHidDisconnected() {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetCountDownCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnGetCountDownCompleted(boolean z, CountdownSettings countdownSettings) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnReadRssiCompleted(boolean z, int i) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnPlayLightCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnPlayVibrationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendNotificationHandControlCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnClearLastNotificationCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetMultipleAlarmsCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnVerifyMultipleAlarmsCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSetMicroAppConfigCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }

    public boolean handleOnSendMicroAppRemoteActivityCompleted(boolean z) {
        logUnexpectedCallback();
        return false;
    }
}
