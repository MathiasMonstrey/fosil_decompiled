package com.misfit.frameworks.buttonservice;

import android.os.IInterface;
import android.os.RemoteException;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import java.util.List;

public interface IButtonConnectivity extends IInterface {
    void addLog(int i, String str, String str2) throws RemoteException;

    void changePendingLogKey(int i, String str, int i2, String str2) throws RemoteException;

    void clearLastNotification(String str) throws RemoteException;

    void connectAllButton() throws RemoteException;

    void deleteDataFiles(List<String> list, String str) throws RemoteException;

    long deviceCancelCalibration(String str) throws RemoteException;

    long deviceClearAllAlarm(String str) throws RemoteException;

    long deviceClearMapping(String str) throws RemoteException;

    long deviceCompleteCalibration(String str) throws RemoteException;

    void deviceDisconnect(String str) throws RemoteException;

    long deviceGetBatteryLevel(String str) throws RemoteException;

    long deviceGetCountDown(String str) throws RemoteException;

    long deviceGetCurrentAlarm(String str) throws RemoteException;

    long deviceGetRssi(String str) throws RemoteException;

    long deviceGetSecondTimeZone(String str) throws RemoteException;

    long deviceGetVibrationStrength(String str) throws RemoteException;

    void deviceMovingHand(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException;

    long deviceOta(String str, byte[] bArr, boolean z, String str2, String str3, UserProfile userProfile) throws RemoteException;

    long devicePlayAnimation(String str) throws RemoteException;

    long devicePlayHandsNotification(String str, int i, int[] iArr, int[] iArr2, int i2, boolean z) throws RemoteException;

    long deviceReadRealTimeStep(String str) throws RemoteException;

    long deviceReconnect(String str) throws RemoteException;

    long deviceSetAlarm(String str, int i, int i2, int i3, int i4, int i5, boolean z) throws RemoteException;

    void deviceSetAutoAlarmSetting(int i, int i2, int i3, int i4, int i5, boolean z) throws RemoteException;

    void deviceSetAutoCountdownSetting(long j, long j2) throws RemoteException;

    void deviceSetAutoListAlarm(List<Alarm> list) throws RemoteException;

    void deviceSetAutoSecondTimezone(String str) throws RemoteException;

    long deviceSetDisableCountDown(String str) throws RemoteException;

    long deviceSetEnableCountDown(String str, long j, long j2) throws RemoteException;

    long deviceSetListAlarm(String str, List<Alarm> list) throws RemoteException;

    long deviceSetMapping(String str, List<BLEMapping> list) throws RemoteException;

    long deviceSetSecondTimeZone(String str, String str2) throws RemoteException;

    long deviceSetVibrationStrength(String str, int i) throws RemoteException;

    long deviceStartCalibration(String str) throws RemoteException;

    long deviceStartHWLogSync(String str) throws RemoteException;

    void deviceStartScan() throws RemoteException;

    long deviceStartSync(String str, UserProfile userProfile) throws RemoteException;

    void deviceStopScan() throws RemoteException;

    long deviceUnlink(String str) throws RemoteException;

    long deviceUpdateGoalStep(String str, int i) throws RemoteException;

    long deviceVerifyListAlarm(String str, int i) throws RemoteException;

    long disableGoalTracking(String str) throws RemoteException;

    int endLog(int i, String str) throws RemoteException;

    List<String> getActiveSerial() throws RemoteException;

    List<BLEMapping> getAutoMapping(String str) throws RemoteException;

    int getCommunicatorModeBySerial(String str) throws RemoteException;

    MisfitDeviceProfile getDeviceProfile(String str) throws RemoteException;

    int getGattState(String str) throws RemoteException;

    int getHIDState(String str) throws RemoteException;

    int[] getListActiveCommunicator() throws RemoteException;

    List<MisfitDeviceProfile> getPairedDevice() throws RemoteException;

    List<String> getPairedSerial() throws RemoteException;

    void interrupt(String str) throws RemoteException;

    boolean isLinking(String str) throws RemoteException;

    boolean isSyncing(String str) throws RemoteException;

    boolean isUpdatingFirmware(String str) throws RemoteException;

    void logOut() throws RemoteException;

    long pairDevice(String str, String str2) throws RemoteException;

    long playLight(String str, int i, int i2, int i3, boolean z) throws RemoteException;

    long playLightAndVibration(String str, int i, int i2, int i3, int i4) throws RemoteException;

    long playVibration(String str, int i, int i2, boolean z) throws RemoteException;

    void removeActiveSerial(String str) throws RemoteException;

    void removePairedSerial(String str) throws RemoteException;

    void resetDeviceSettingToDefault(String str) throws RemoteException;

    long resetHandsToZeroDegree(String str) throws RemoteException;

    void sendMicroAppRemoteActivity(String str, MicroAppInstruction microAppInstruction) throws RemoteException;

    void setActiveSerial(String str, String str2) throws RemoteException;

    void setAutoMapping(String str, List<BLEMapping> list) throws RemoteException;

    void setPairedSerial(String str, String str2) throws RemoteException;

    void simulateDisconnection(String str, int i, int i2, int i3, int i4) throws RemoteException;

    void simulatePusherEvent(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException;

    int startLog(int i, String str) throws RemoteException;

    void stopLogService(int i) throws RemoteException;

    boolean switchActiveDevice(String str, UserProfile userProfile) throws RemoteException;

    void updateAppInfo(String str) throws RemoteException;

    void updatePercentageGoalProgress(String str, boolean z, int i, int i2) throws RemoteException;

    void updateUserId(String str) throws RemoteException;
}
