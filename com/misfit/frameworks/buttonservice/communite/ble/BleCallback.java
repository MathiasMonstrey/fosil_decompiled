package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.HandPositions;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.error.ShineError;
import java.util.Hashtable;

public interface BleCallback {
    boolean handleOnActivateCompleted(boolean z);

    boolean handleOnApplyHandPositionCompleted(boolean z);

    boolean handleOnButtonEvent(int i);

    boolean handleOnClearAllAlarmsCompleted(boolean z);

    boolean handleOnClearLastNotificationCompleted(boolean z);

    boolean handleOnDataReadCompleted(boolean z);

    boolean handleOnDataReadProgressUpdate(int i, byte[] bArr);

    boolean handleOnDeviceConnected();

    boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult);

    boolean handleOnDevicePreparedCompleted(boolean z);

    boolean handleOnDeviceScanned(ShineDevice shineDevice, int i);

    boolean handleOnDisableCallTextNotificationCompleted(boolean z);

    boolean handleOnEnablingCallTextNotificationCompleted(boolean z);

    boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable);

    boolean handleOnGetCountDownCompleted(boolean z, CountdownSettings countdownSettings);

    boolean handleOnGetHandPositionCompleted(boolean z, HandPositions handPositions);

    boolean handleOnGetLapCountingStatus(boolean z, Hashtable<ShineProperty, Object> hashtable);

    boolean handleOnGetSecondTimeZoneCompleted(boolean z, int i);

    boolean handleOnGetVibrationStrengthCompleted(boolean z, short s);

    boolean handleOnGettingAlarmCompleted(boolean z, AlarmSettings alarmSettings);

    boolean handleOnGettingMappingTypeCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable);

    boolean handleOnHardwareLogRead(boolean z, byte[] bArr);

    boolean handleOnHeartbeatReceived();

    boolean handleOnHidConnected();

    boolean handleOnHidDisconnected();

    boolean handleOnMicroAppConfigCompleted(boolean z);

    boolean handleOnMovingHandsCompleted(ActionResult actionResult);

    boolean handleOnOtaCompleted(boolean z);

    boolean handleOnOtaProgressUpdate(float f);

    boolean handleOnPlayAnimationCompleted(boolean z);

    boolean handleOnPlayButtonAnimationCompleted(boolean z);

    boolean handleOnPlayLightCompleted(boolean z);

    boolean handleOnPlaySyncAnimationCompleted(boolean z);

    boolean handleOnPlayVibrationCompleted(boolean z);

    boolean handleOnReadRssiCompleted(boolean z, int i);

    boolean handleOnReleaseHandsControlCompleted(boolean z);

    boolean handleOnRequestHandsControlCompleted(boolean z);

    boolean handleOnRetrieveDeviceComplete();

    boolean handleOnSendAppNotificationCompleted(boolean z);

    boolean handleOnSendCallNotificationCompleted(boolean z);

    boolean handleOnSendHandNotificationCompleted(boolean z);

    boolean handleOnSendMicroAppRemoteActivityCompleted(boolean z);

    boolean handleOnSendNotificationHandControlCompleted(boolean z);

    boolean handleOnSendTextNotificationCompleted(boolean z);

    boolean handleOnSetActivityType(boolean z);

    boolean handleOnSetConfigurationCompleted(boolean z);

    boolean handleOnSetConnectionParameterCompleted(boolean z, ShineError shineError);

    boolean handleOnSetCountDownCompleted(boolean z);

    boolean handleOnSetFlashButtonModeCompleted(boolean z);

    boolean handleOnSetGoalInStepCompleted(boolean z);

    boolean handleOnSetInactiveNudgeCompleted(boolean z);

    boolean handleOnSetLapCountingLicense(boolean z);

    boolean handleOnSetLapCountingMode(boolean z);

    boolean handleOnSetMicroAppConfigCompleted(boolean z);

    boolean handleOnSetMultipleAlarmsCompleted(boolean z);

    boolean handleOnSetSecondTimeZoneCompleted(boolean z);

    boolean handleOnSetVibrationStrengthCompleted(boolean z);

    boolean handleOnSettingGoalTrackingCompleted(boolean z);

    boolean handleOnSettingMappingAnimationCompleted(boolean z);

    boolean handleOnSettingMappingCompleted(boolean z);

    boolean handleOnSettingSingleAlarmCompleted(boolean z);

    boolean handleOnStartStreamingCompleted(boolean z);

    boolean handleOnStopAnimationCompleted(boolean z);

    boolean handleOnStopStreamingCompleted(boolean z);

    boolean handleOnUnmapAllEventsCompleted(boolean z);

    boolean handleOnVerifyMultipleAlarmsCompleted(boolean z);
}
