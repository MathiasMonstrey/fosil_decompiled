package com.misfit.frameworks.buttonservice.communite.ble.device;

import android.content.Context;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.communite.ble.ClearAllAlarmsSession;
import com.misfit.frameworks.buttonservice.communite.ble.ClearLinkMappingsSession;
import com.misfit.frameworks.buttonservice.communite.ble.GetAlarmSession;
import com.misfit.frameworks.buttonservice.communite.ble.GetBatteryLevelSession;
import com.misfit.frameworks.buttonservice.communite.ble.GetCountdownSettingSession;
import com.misfit.frameworks.buttonservice.communite.ble.GetVibrationStrengthSession;
import com.misfit.frameworks.buttonservice.communite.ble.HWLogSyncSession;
import com.misfit.frameworks.buttonservice.communite.ble.PlayAnimationSession;
import com.misfit.frameworks.buttonservice.communite.ble.PlayLightAndVibrationSession;
import com.misfit.frameworks.buttonservice.communite.ble.PlayLightSession;
import com.misfit.frameworks.buttonservice.communite.ble.PlayVibrationSession;
import com.misfit.frameworks.buttonservice.communite.ble.ReadRealTimeStepSession;
import com.misfit.frameworks.buttonservice.communite.ble.ReadRssiSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoCountDownSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoMultiAlarmSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoSecondTimezoneSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetAutoSingleAlarmSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetCountdownSettingSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetSingleAlarmSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetStepGoalSession;
import com.misfit.frameworks.buttonservice.communite.ble.SetVibrationStrengthSession;
import com.misfit.frameworks.buttonservice.communite.ble.UnlinkSession;
import com.misfit.frameworks.buttonservice.communite.ble.UpdateCurrentTimeSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerConnectDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerOtaSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerPairingNewDeviceSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerSetLinkMappingSession;
import com.misfit.frameworks.buttonservice.communite.ble.tracker.TrackerSyncSession;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import java.util.List;

public abstract class GeneralCommunicator extends BleCommunicator {
    public GeneralCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        super(context, str, str2, communicationResultCallback);
    }

    public boolean startPairingSession() {
        return queueSessionAndStart(new TrackerPairingNewDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startConnectionDeviceSession() {
        return queueSessionAndStart(new TrackerConnectDeviceSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startUnlinkSession() {
        return queueSessionAndStart(new UnlinkSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startOtaSession(byte[] bArr, boolean z, String str, String str2, UserProfile userProfile) {
        return queueSessionAndStart(new TrackerOtaSession(bArr, z, str, str2, (long) userProfile.goalSteps, (long) userProfile.currentSteps, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSyncingSession(UserProfile userProfile) {
        return queueSessionAndStart(new TrackerSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, userProfile));
    }

    public boolean startHWLogSyncSession() {
        return queueSessionAndStart(new HWLogSyncSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetAlarmSession(AlarmSettings alarmSettings) {
        return queueSessionAndStart(new SetSingleAlarmSession(alarmSettings, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startGetAlarmSession() {
        return queueSessionAndStart(new GetAlarmSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startClearAllAlarmsSession() {
        return queueSessionAndStart(new ClearAllAlarmsSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetStepGoal(int i) {
        return queueSessionAndStart(new SetStepGoalSession(i, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetLinkMappingSession(List<BLEMapping> list) {
        return queueSessionAndStart(new TrackerSetLinkMappingSession(list, this.sdkCallback, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startCleanLinkMappingSession(List<BLEMapping> list) {
        return queueSessionAndStart(new ClearLinkMappingsSession(list, this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startPlayAnimationSession() {
        return queueSessionAndStart(new PlayAnimationSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startGetBatteryLevelSession() {
        return queueSessionAndStart(new GetBatteryLevelSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startGetRssiSession() {
        return queueSessionAndStart(new ReadRssiSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startReadRealTimeStepSession() {
        return queueSessionAndStart(new ReadRealTimeStepSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startPlayLightSession(LightVibrationSetting lightVibrationSetting) {
        return queueSessionAndStart(new PlayLightSession(this.bleAdapter, this.bleSessionCallback, lightVibrationSetting));
    }

    public boolean startPlayVibrationSession(LightVibrationSetting lightVibrationSetting) {
        return queueSessionAndStart(new PlayVibrationSession(this.bleAdapter, this.bleSessionCallback, lightVibrationSetting));
    }

    public boolean startPlayLightAndVibrationSession(LEDColor lEDColor, VibeEnum vibeEnum, byte b, int i) {
        return queueSessionAndStart(new PlayLightAndVibrationSession(this.bleAdapter, this.bleSessionCallback, lEDColor, vibeEnum, b, i));
    }

    public boolean startSetVibrationStrengthSession(short s) {
        return queueSessionAndStart(new SetVibrationStrengthSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, s));
    }

    public boolean startGetVibrationStrengthSession() {
        return queueSessionAndStart(new GetVibrationStrengthSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startSetCountdownSettingSession(boolean z, long j, long j2) {
        return queueSessionAndStart(new SetCountdownSettingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, z, j, j2));
    }

    public boolean startGetCountdownSettingSession() {
        return queueSessionAndStart(new GetCountdownSettingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback));
    }

    public boolean startUpdateCurrentTime() {
        return queueSessionAndStart(new UpdateCurrentTimeSession(this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoSingleAlarm(AlarmSettings alarmSettings) {
        return queueSessionAndStart(new SetAutoSingleAlarmSession(alarmSettings, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoMultiAlarms(List<MultipleAlarmSettings> list) {
        return queueSessionAndStart(new SetAutoMultiAlarmSession(list, this.sdkCallback, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoSecondTimezone(String str) {
        return queueSessionAndStart(new SetAutoSecondTimezoneSession(str, this.bleAdapter, this.bleSessionCallback));
    }

    public boolean startSetAutoCountDown(long j, long j2) {
        return queueSessionAndStart(new SetAutoCountDownSession(j, j2, this.bleAdapter, this.bleSessionCallback));
    }
}
