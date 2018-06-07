package com.misfit.frameworks.buttonservice.communite.ble.device;

import android.content.Context;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerDisableGoalTrackingSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerSetAutoMappingsSession;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.QMotionDevice;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import java.util.List;

public class TrackerVibeCommunicator extends GeneralCommunicator {
    public TrackerVibeCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        super(context, str, str2, communicationResultCallback);
    }

    protected Device getDeviceType() {
        return new QMotionDevice();
    }

    public boolean startCalibrationSession() {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startDisableGoalTrackingSession() {
        return queueSessionAndStart(new TrackerDisableGoalTrackingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetSecondTimezoneSession(String str) {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startGetSecondTimezoneSession() {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startSendNotificationSession(LEDColor lEDColor, byte b, List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr, boolean z) {
        return false;
    }

    public boolean startClearLastNotificationSession() {
        return false;
    }

    public boolean startSetCountdownSettingSession(boolean z, long j, long j2) {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startGetCountdownSettingSession() {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startSetMultipleAlarmsSession(List<MultipleAlarmSettings> list) {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startVerifyMultipleAlarmsSession(int i) {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }

    public boolean startSetAutoMapping(List<BLEMapping> list) {
        return queueSessionAndStart(new TrackerSetAutoMappingsSession(list, this.sdkCallback, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoMultiAlarms(List<MultipleAlarmSettings> list) {
        throw new UnsupportedOperationException("Unsupported method for QMotion");
    }
}
