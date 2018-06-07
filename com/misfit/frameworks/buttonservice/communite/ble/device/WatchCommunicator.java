package com.misfit.frameworks.buttonservice.communite.ble.device;

import android.content.Context;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchCalibrationSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchClearLastNotificationSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchClearLinkMappingSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchConnectDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchDisableGoalTrackingSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchGetSecondTimezoneSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchOtaSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchPairingNewDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSendNotificationSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSetAutoMappingsSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSetLinkMappingsSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSetMultipleAlarmsSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSetSecondTimezoneSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchSyncSession;
import com.misfit.frameworks.buttonservice.communite.ble.hybrid.WatchVerifyMultipleAlarmsSession;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.HybridDevice;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import java.util.List;

public class WatchCommunicator extends GeneralCommunicator {
    public WatchCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        super(context, str, str2, communicationResultCallback);
    }

    protected Device getDeviceType() {
        return new HybridDevice();
    }

    public boolean startPairingSession() {
        return queueSessionAndStart(new WatchPairingNewDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startConnectionDeviceSession() {
        return queueSessionAndStart(new WatchConnectDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startCalibrationSession() {
        return queueSessionAndStart(new WatchCalibrationSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSyncingSession(UserProfile userProfile) {
        return queueSessionAndStart(new WatchSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, userProfile));
    }

    public boolean startOtaSession(byte[] bArr, boolean z, String str, String str2, UserProfile userProfile) {
        return queueSessionAndStart(new WatchOtaSession(bArr, z, str, str2, (long) userProfile.goalSteps, (long) userProfile.currentSteps, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetSecondTimezoneSession(String str) {
        return queueSessionAndStart(new WatchSetSecondTimezoneSession(str, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startGetSecondTimezoneSession() {
        return queueSessionAndStart(new WatchGetSecondTimezoneSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSendNotificationSession(LEDColor lEDColor, byte b, List<HandId> list, VibeEnum vibeEnum, int i, int[] iArr, boolean z) {
        return queueSessionAndStart(new WatchSendNotificationSession(list, vibeEnum, iArr, i, this.bleAdapter, this.bleSessionCallback, z));
    }

    public boolean startClearLastNotificationSession() {
        return queueSessionAndStart(new WatchClearLastNotificationSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetLinkMappingSession(List<BLEMapping> list) {
        return queueSessionAndStart(new WatchSetLinkMappingsSession(list, this.sdkCallback, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startCleanLinkMappingSession(List<BLEMapping> list) {
        return queueSessionAndStart(new WatchClearLinkMappingSession(list, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startDisableGoalTrackingSession() {
        return queueSessionAndStart(new WatchDisableGoalTrackingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetMultipleAlarmsSession(List<MultipleAlarmSettings> list) {
        return queueSessionAndStart(new WatchSetMultipleAlarmsSession(list, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startVerifyMultipleAlarmsSession(int i) {
        return queueSessionAndStart(new WatchVerifyMultipleAlarmsSession(i, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetAutoMapping(List<BLEMapping> list) {
        return queueSessionAndStart(new WatchSetAutoMappingsSession(list, this.sdkCallback, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoSingleAlarm(AlarmSettings alarmSettings) {
        throw new UnsupportedOperationException("Unsupported method for Watch");
    }
}
