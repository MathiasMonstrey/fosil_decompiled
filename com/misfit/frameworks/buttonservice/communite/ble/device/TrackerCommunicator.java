package com.misfit.frameworks.buttonservice.communite.ble.device;

import android.content.Context;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.TrackerDevice;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import java.util.List;

public class TrackerCommunicator extends TrackerVibeCommunicator {
    public TrackerCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        super(context, str, str2, communicationResultCallback);
    }

    protected Device getDeviceType() {
        return new TrackerDevice();
    }

    public boolean startCalibrationSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startSetSecondTimezoneSession(String str) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startGetSecondTimezoneSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startSendNotificationSession(LEDColor lEDColor, byte b, List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr, boolean z) {
        return false;
    }

    public boolean startClearLastNotificationSession() {
        return false;
    }

    public boolean startSetCountdownSettingSession(boolean z, long j, long j2) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startGetCountdownSettingSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startSetAlarmSession(AlarmSettings alarmSettings) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startGetAlarmSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startSetMultipleAlarmsSession(List<MultipleAlarmSettings> list) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startVerifyMultipleAlarmsSession(int i) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startClearAllAlarmsSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startPlayVibrationSession(LightVibrationSetting lightVibrationSetting) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startPlayLightAndVibrationSession(LEDColor lEDColor, VibeEnum vibeEnum, byte b, int i) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startSetVibrationStrengthSession(short s) {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }

    public boolean startGetVibrationStrengthSession() {
        throw new UnsupportedOperationException("Unsupported method for Tracker");
    }
}
