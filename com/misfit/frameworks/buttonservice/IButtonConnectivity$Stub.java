package com.misfit.frameworks.buttonservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import java.util.List;

public abstract class IButtonConnectivity$Stub extends Binder implements IButtonConnectivity {
    private static final String DESCRIPTOR = "com.misfit.frameworks.buttonservice.IButtonConnectivity";
    static final int TRANSACTION_addLog = 66;
    static final int TRANSACTION_changePendingLogKey = 70;
    static final int TRANSACTION_clearLastNotification = 71;
    static final int TRANSACTION_connectAllButton = 1;
    static final int TRANSACTION_deleteDataFiles = 12;
    static final int TRANSACTION_deviceCancelCalibration = 44;
    static final int TRANSACTION_deviceClearAllAlarm = 50;
    static final int TRANSACTION_deviceClearMapping = 31;
    static final int TRANSACTION_deviceCompleteCalibration = 43;
    static final int TRANSACTION_deviceDisconnect = 4;
    static final int TRANSACTION_deviceGetBatteryLevel = 16;
    static final int TRANSACTION_deviceGetCountDown = 62;
    static final int TRANSACTION_deviceGetCurrentAlarm = 52;
    static final int TRANSACTION_deviceGetRssi = 17;
    static final int TRANSACTION_deviceGetSecondTimeZone = 48;
    static final int TRANSACTION_deviceGetVibrationStrength = 58;
    static final int TRANSACTION_deviceMovingHand = 41;
    static final int TRANSACTION_deviceOta = 18;
    static final int TRANSACTION_devicePlayAnimation = 13;
    static final int TRANSACTION_devicePlayHandsNotification = 57;
    static final int TRANSACTION_deviceReadRealTimeStep = 14;
    static final int TRANSACTION_deviceReconnect = 2;
    static final int TRANSACTION_deviceSetAlarm = 51;
    static final int TRANSACTION_deviceSetAutoAlarmSetting = 55;
    static final int TRANSACTION_deviceSetAutoCountdownSetting = 63;
    static final int TRANSACTION_deviceSetAutoListAlarm = 56;
    static final int TRANSACTION_deviceSetAutoSecondTimezone = 49;
    static final int TRANSACTION_deviceSetDisableCountDown = 61;
    static final int TRANSACTION_deviceSetEnableCountDown = 60;
    static final int TRANSACTION_deviceSetListAlarm = 53;
    static final int TRANSACTION_deviceSetMapping = 30;
    static final int TRANSACTION_deviceSetSecondTimeZone = 47;
    static final int TRANSACTION_deviceSetVibrationStrength = 59;
    static final int TRANSACTION_deviceStartCalibration = 40;
    static final int TRANSACTION_deviceStartHWLogSync = 11;
    static final int TRANSACTION_deviceStartScan = 7;
    static final int TRANSACTION_deviceStartSync = 9;
    static final int TRANSACTION_deviceStopScan = 8;
    static final int TRANSACTION_deviceUnlink = 5;
    static final int TRANSACTION_deviceUpdateGoalStep = 15;
    static final int TRANSACTION_deviceVerifyListAlarm = 54;
    static final int TRANSACTION_disableGoalTracking = 46;
    static final int TRANSACTION_endLog = 68;
    static final int TRANSACTION_getActiveSerial = 38;
    static final int TRANSACTION_getAutoMapping = 33;
    static final int TRANSACTION_getCommunicatorModeBySerial = 73;
    static final int TRANSACTION_getDeviceProfile = 20;
    static final int TRANSACTION_getGattState = 21;
    static final int TRANSACTION_getHIDState = 22;
    static final int TRANSACTION_getListActiveCommunicator = 74;
    static final int TRANSACTION_getPairedDevice = 19;
    static final int TRANSACTION_getPairedSerial = 39;
    static final int TRANSACTION_interrupt = 45;
    static final int TRANSACTION_isLinking = 26;
    static final int TRANSACTION_isSyncing = 24;
    static final int TRANSACTION_isUpdatingFirmware = 25;
    static final int TRANSACTION_logOut = 23;
    static final int TRANSACTION_pairDevice = 3;
    static final int TRANSACTION_playLight = 28;
    static final int TRANSACTION_playLightAndVibration = 27;
    static final int TRANSACTION_playVibration = 29;
    static final int TRANSACTION_removeActiveSerial = 36;
    static final int TRANSACTION_removePairedSerial = 37;
    static final int TRANSACTION_resetDeviceSettingToDefault = 77;
    static final int TRANSACTION_resetHandsToZeroDegree = 42;
    static final int TRANSACTION_sendMicroAppRemoteActivity = 72;
    static final int TRANSACTION_setActiveSerial = 34;
    static final int TRANSACTION_setAutoMapping = 32;
    static final int TRANSACTION_setPairedSerial = 35;
    static final int TRANSACTION_simulateDisconnection = 75;
    static final int TRANSACTION_simulatePusherEvent = 76;
    static final int TRANSACTION_startLog = 67;
    static final int TRANSACTION_stopLogService = 69;
    static final int TRANSACTION_switchActiveDevice = 6;
    static final int TRANSACTION_updateAppInfo = 65;
    static final int TRANSACTION_updatePercentageGoalProgress = 10;
    static final int TRANSACTION_updateUserId = 64;

    static class Proxy implements IButtonConnectivity {
        private IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public String getInterfaceDescriptor() {
            return IButtonConnectivity$Stub.DESCRIPTOR;
        }

        public void connectAllButton() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(1, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceReconnect(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long pairDevice(String str, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceDisconnect(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(4, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceUnlink(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(5, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean switchActiveDevice(String str, UserProfile userProfile) throws RemoteException {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                if (userProfile != null) {
                    obtain.writeInt(1);
                    userProfile.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.mRemote.transact(6, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceStartScan() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(7, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceStopScan() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(8, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceStartSync(String str, UserProfile userProfile) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                if (userProfile != null) {
                    obtain.writeInt(1);
                    userProfile.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.mRemote.transact(9, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void updatePercentageGoalProgress(String str, boolean z, int i, int i2) throws RemoteException {
            int i3 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                if (z) {
                    i3 = 1;
                }
                obtain.writeInt(i3);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                this.mRemote.transact(10, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceStartHWLogSync(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(11, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deleteDataFiles(List<String> list, String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeStringList(list);
                obtain.writeString(str);
                this.mRemote.transact(12, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long devicePlayAnimation(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(13, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceReadRealTimeStep(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(14, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceUpdateGoalStep(String str, int i) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                this.mRemote.transact(15, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetBatteryLevel(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(16, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetRssi(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(17, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceOta(String str, byte[] bArr, boolean z, String str2, String str3, UserProfile userProfile) throws RemoteException {
            int i = 1;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeByteArray(bArr);
                if (!z) {
                    i = 0;
                }
                obtain.writeInt(i);
                obtain.writeString(str2);
                obtain.writeString(str3);
                if (userProfile != null) {
                    obtain.writeInt(1);
                    userProfile.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.mRemote.transact(18, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public List<MisfitDeviceProfile> getPairedDevice() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(19, obtain, obtain2, 0);
                obtain2.readException();
                List<MisfitDeviceProfile> createTypedArrayList = obtain2.createTypedArrayList(MisfitDeviceProfile.CREATOR);
                return createTypedArrayList;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public MisfitDeviceProfile getDeviceProfile(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                MisfitDeviceProfile misfitDeviceProfile;
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(20, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    misfitDeviceProfile = (MisfitDeviceProfile) MisfitDeviceProfile.CREATOR.createFromParcel(obtain2);
                } else {
                    misfitDeviceProfile = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return misfitDeviceProfile;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getGattState(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(21, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getHIDState(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(22, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void logOut() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(23, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isSyncing(String str) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(24, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isUpdatingFirmware(String str) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(25, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isLinking(String str) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(26, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long playLightAndVibration(String str, int i, int i2, int i3, int i4) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                this.mRemote.transact(27, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long playLight(String str, int i, int i2, int i3, boolean z) throws RemoteException {
            int i4 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                if (z) {
                    i4 = 1;
                }
                obtain.writeInt(i4);
                this.mRemote.transact(28, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long playVibration(String str, int i, int i2, boolean z) throws RemoteException {
            int i3 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                if (z) {
                    i3 = 1;
                }
                obtain.writeInt(i3);
                this.mRemote.transact(29, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetMapping(String str, List<BLEMapping> list) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeTypedList(list);
                this.mRemote.transact(30, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceClearMapping(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(31, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void setAutoMapping(String str, List<BLEMapping> list) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeTypedList(list);
                this.mRemote.transact(32, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public List<BLEMapping> getAutoMapping(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(33, obtain, obtain2, 0);
                obtain2.readException();
                List<BLEMapping> createTypedArrayList = obtain2.createTypedArrayList(BLEMapping.CREATOR);
                return createTypedArrayList;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void setActiveSerial(String str, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(34, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void setPairedSerial(String str, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(35, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void removeActiveSerial(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(36, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void removePairedSerial(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(37, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public List<String> getActiveSerial() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(38, obtain, obtain2, 0);
                obtain2.readException();
                List<String> createStringArrayList = obtain2.createStringArrayList();
                return createStringArrayList;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public List<String> getPairedSerial() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(39, obtain, obtain2, 0);
                obtain2.readException();
                List<String> createStringArrayList = obtain2.createStringArrayList();
                return createStringArrayList;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceStartCalibration(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(40, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceMovingHand(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                obtain.writeInt(i5);
                this.mRemote.transact(41, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long resetHandsToZeroDegree(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(42, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceCompleteCalibration(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(43, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceCancelCalibration(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(44, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void interrupt(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(45, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long disableGoalTracking(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(46, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetSecondTimeZone(String str, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(47, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetSecondTimeZone(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(48, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceSetAutoSecondTimezone(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(49, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceClearAllAlarm(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(50, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetAlarm(String str, int i, int i2, int i3, int i4, int i5, boolean z) throws RemoteException {
            int i6 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                obtain.writeInt(i5);
                if (z) {
                    i6 = 1;
                }
                obtain.writeInt(i6);
                this.mRemote.transact(51, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetCurrentAlarm(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(52, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetListAlarm(String str, List<Alarm> list) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeTypedList(list);
                this.mRemote.transact(53, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceVerifyListAlarm(String str, int i) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                this.mRemote.transact(54, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceSetAutoAlarmSetting(int i, int i2, int i3, int i4, int i5, boolean z) throws RemoteException {
            int i6 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                obtain.writeInt(i5);
                if (z) {
                    i6 = 1;
                }
                obtain.writeInt(i6);
                this.mRemote.transact(55, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceSetAutoListAlarm(List<Alarm> list) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeTypedList(list);
                this.mRemote.transact(56, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long devicePlayHandsNotification(String str, int i, int[] iArr, int[] iArr2, int i2, boolean z) throws RemoteException {
            int i3 = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeIntArray(iArr);
                obtain.writeIntArray(iArr2);
                obtain.writeInt(i2);
                if (z) {
                    i3 = 1;
                }
                obtain.writeInt(i3);
                this.mRemote.transact(57, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetVibrationStrength(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(58, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetVibrationStrength(String str, int i) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                this.mRemote.transact(59, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetEnableCountDown(String str, long j, long j2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeLong(j);
                obtain.writeLong(j2);
                this.mRemote.transact(60, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceSetDisableCountDown(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(61, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long deviceGetCountDown(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(62, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void deviceSetAutoCountdownSetting(long j, long j2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeLong(j);
                obtain.writeLong(j2);
                this.mRemote.transact(63, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void updateUserId(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(64, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void updateAppInfo(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(65, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void addLog(int i, String str, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(66, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int startLog(int i, String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.mRemote.transact(67, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int endLog(int i, String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.mRemote.transact(68, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void stopLogService(int i) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(69, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void changePendingLogKey(int i, String str, int i2, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeInt(i2);
                obtain.writeString(str2);
                this.mRemote.transact(70, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void clearLastNotification(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(71, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void sendMicroAppRemoteActivity(String str, MicroAppInstruction microAppInstruction) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                if (microAppInstruction != null) {
                    obtain.writeInt(1);
                    microAppInstruction.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.mRemote.transact(72, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getCommunicatorModeBySerial(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(73, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int[] getListActiveCommunicator() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                this.mRemote.transact(74, obtain, obtain2, 0);
                obtain2.readException();
                int[] createIntArray = obtain2.createIntArray();
                return createIntArray;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void simulateDisconnection(String str, int i, int i2, int i3, int i4) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                this.mRemote.transact(75, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void simulatePusherEvent(String str, int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeInt(i4);
                obtain.writeInt(i5);
                this.mRemote.transact(76, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void resetDeviceSettingToDefault(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IButtonConnectivity$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(77, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public IButtonConnectivity$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IButtonConnectivity asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof IButtonConnectivity)) {
            return new Proxy(iBinder);
        }
        return (IButtonConnectivity) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        MicroAppInstruction microAppInstruction = null;
        boolean z = false;
        long deviceReconnect;
        String readString;
        UserProfile userProfile;
        boolean switchActiveDevice;
        String readString2;
        List pairedDevice;
        int gattState;
        int i3;
        int readInt;
        int readInt2;
        int readInt3;
        int readInt4;
        int readInt5;
        boolean z2;
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                connectAllButton();
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceReconnect(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = pairDevice(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                deviceDisconnect(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceUnlink(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    userProfile = (UserProfile) UserProfile.CREATOR.createFromParcel(parcel);
                }
                switchActiveDevice = switchActiveDevice(readString, userProfile);
                parcel2.writeNoException();
                parcel2.writeInt(switchActiveDevice ? 1 : 0);
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                deviceStartScan();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface(DESCRIPTOR);
                deviceStopScan();
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    userProfile = (UserProfile) UserProfile.CREATOR.createFromParcel(parcel);
                }
                deviceReconnect = deviceStartSync(readString, userProfile);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 10:
                parcel.enforceInterface(DESCRIPTOR);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                updatePercentageGoalProgress(readString2, z, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceStartHWLogSync(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 12:
                parcel.enforceInterface(DESCRIPTOR);
                deleteDataFiles(parcel.createStringArrayList(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = devicePlayAnimation(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 14:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceReadRealTimeStep(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 15:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceUpdateGoalStep(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 16:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetBatteryLevel(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 17:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetRssi(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 18:
                UserProfile userProfile2;
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                byte[] createByteArray = parcel.createByteArray();
                boolean z3 = parcel.readInt() != 0;
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                if (parcel.readInt() != 0) {
                    userProfile2 = (UserProfile) UserProfile.CREATOR.createFromParcel(parcel);
                } else {
                    userProfile2 = null;
                }
                deviceReconnect = deviceOta(readString, createByteArray, z3, readString3, readString4, userProfile2);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 19:
                parcel.enforceInterface(DESCRIPTOR);
                pairedDevice = getPairedDevice();
                parcel2.writeNoException();
                parcel2.writeTypedList(pairedDevice);
                return true;
            case 20:
                parcel.enforceInterface(DESCRIPTOR);
                MisfitDeviceProfile deviceProfile = getDeviceProfile(parcel.readString());
                parcel2.writeNoException();
                if (deviceProfile != null) {
                    parcel2.writeInt(1);
                    deviceProfile.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 21:
                parcel.enforceInterface(DESCRIPTOR);
                gattState = getGattState(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(gattState);
                return true;
            case 22:
                parcel.enforceInterface(DESCRIPTOR);
                gattState = getHIDState(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(gattState);
                return true;
            case 23:
                parcel.enforceInterface(DESCRIPTOR);
                logOut();
                parcel2.writeNoException();
                return true;
            case 24:
                parcel.enforceInterface(DESCRIPTOR);
                switchActiveDevice = isSyncing(parcel.readString());
                parcel2.writeNoException();
                if (switchActiveDevice) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 25:
                parcel.enforceInterface(DESCRIPTOR);
                switchActiveDevice = isUpdatingFirmware(parcel.readString());
                parcel2.writeNoException();
                if (switchActiveDevice) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 26:
                parcel.enforceInterface(DESCRIPTOR);
                switchActiveDevice = isLinking(parcel.readString());
                parcel2.writeNoException();
                if (switchActiveDevice) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 27:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = playLightAndVibration(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 28:
                boolean z4;
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                readInt = parcel.readInt();
                readInt2 = parcel.readInt();
                readInt3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                deviceReconnect = playLight(readString, readInt, readInt2, readInt3, z4);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 29:
                parcel.enforceInterface(DESCRIPTOR);
                readString2 = parcel.readString();
                readInt4 = parcel.readInt();
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                deviceReconnect = playVibration(readString2, readInt4, readInt, z);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 30:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetMapping(parcel.readString(), parcel.createTypedArrayList(BLEMapping.CREATOR));
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 31:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceClearMapping(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 32:
                parcel.enforceInterface(DESCRIPTOR);
                setAutoMapping(parcel.readString(), parcel.createTypedArrayList(BLEMapping.CREATOR));
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface(DESCRIPTOR);
                pairedDevice = getAutoMapping(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(pairedDevice);
                return true;
            case 34:
                parcel.enforceInterface(DESCRIPTOR);
                setActiveSerial(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface(DESCRIPTOR);
                setPairedSerial(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 36:
                parcel.enforceInterface(DESCRIPTOR);
                removeActiveSerial(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface(DESCRIPTOR);
                removePairedSerial(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 38:
                parcel.enforceInterface(DESCRIPTOR);
                pairedDevice = getActiveSerial();
                parcel2.writeNoException();
                parcel2.writeStringList(pairedDevice);
                return true;
            case 39:
                parcel.enforceInterface(DESCRIPTOR);
                pairedDevice = getPairedSerial();
                parcel2.writeNoException();
                parcel2.writeStringList(pairedDevice);
                return true;
            case 40:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceStartCalibration(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 41:
                parcel.enforceInterface(DESCRIPTOR);
                deviceMovingHand(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 42:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = resetHandsToZeroDegree(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 43:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceCompleteCalibration(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 44:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceCancelCalibration(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 45:
                parcel.enforceInterface(DESCRIPTOR);
                interrupt(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 46:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = disableGoalTracking(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 47:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetSecondTimeZone(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 48:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetSecondTimeZone(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 49:
                parcel.enforceInterface(DESCRIPTOR);
                deviceSetAutoSecondTimezone(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 50:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceClearAllAlarm(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 51:
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                readInt = parcel.readInt();
                readInt2 = parcel.readInt();
                readInt3 = parcel.readInt();
                readInt5 = parcel.readInt();
                int readInt6 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                deviceReconnect = deviceSetAlarm(readString, readInt, readInt2, readInt3, readInt5, readInt6, z);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 52:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetCurrentAlarm(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 53:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetListAlarm(parcel.readString(), parcel.createTypedArrayList(Alarm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 54:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceVerifyListAlarm(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 55:
                parcel.enforceInterface(DESCRIPTOR);
                readInt4 = parcel.readInt();
                readInt = parcel.readInt();
                readInt2 = parcel.readInt();
                readInt3 = parcel.readInt();
                readInt5 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                deviceSetAutoAlarmSetting(readInt4, readInt, readInt2, readInt3, readInt5, z2);
                parcel2.writeNoException();
                return true;
            case 56:
                parcel.enforceInterface(DESCRIPTOR);
                deviceSetAutoListAlarm(parcel.createTypedArrayList(Alarm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 57:
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                readInt = parcel.readInt();
                int[] createIntArray = parcel.createIntArray();
                int[] createIntArray2 = parcel.createIntArray();
                readInt5 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                deviceReconnect = devicePlayHandsNotification(readString, readInt, createIntArray, createIntArray2, readInt5, z2);
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 58:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetVibrationStrength(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 59:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetVibrationStrength(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 60:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetEnableCountDown(parcel.readString(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 61:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceSetDisableCountDown(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 62:
                parcel.enforceInterface(DESCRIPTOR);
                deviceReconnect = deviceGetCountDown(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(deviceReconnect);
                return true;
            case 63:
                parcel.enforceInterface(DESCRIPTOR);
                deviceSetAutoCountdownSetting(parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 64:
                parcel.enforceInterface(DESCRIPTOR);
                updateUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 65:
                parcel.enforceInterface(DESCRIPTOR);
                updateAppInfo(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 66:
                parcel.enforceInterface(DESCRIPTOR);
                addLog(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 67:
                parcel.enforceInterface(DESCRIPTOR);
                gattState = startLog(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(gattState);
                return true;
            case 68:
                parcel.enforceInterface(DESCRIPTOR);
                gattState = endLog(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(gattState);
                return true;
            case 69:
                parcel.enforceInterface(DESCRIPTOR);
                stopLogService(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 70:
                parcel.enforceInterface(DESCRIPTOR);
                changePendingLogKey(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 71:
                parcel.enforceInterface(DESCRIPTOR);
                clearLastNotification(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 72:
                parcel.enforceInterface(DESCRIPTOR);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    microAppInstruction = (MicroAppInstruction) MicroAppInstruction.CREATOR.createFromParcel(parcel);
                }
                sendMicroAppRemoteActivity(readString, microAppInstruction);
                parcel2.writeNoException();
                return true;
            case 73:
                parcel.enforceInterface(DESCRIPTOR);
                gattState = getCommunicatorModeBySerial(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(gattState);
                return true;
            case 74:
                parcel.enforceInterface(DESCRIPTOR);
                int[] listActiveCommunicator = getListActiveCommunicator();
                parcel2.writeNoException();
                parcel2.writeIntArray(listActiveCommunicator);
                return true;
            case 75:
                parcel.enforceInterface(DESCRIPTOR);
                simulateDisconnection(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 76:
                parcel.enforceInterface(DESCRIPTOR);
                simulatePusherEvent(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 77:
                parcel.enforceInterface(DESCRIPTOR);
                resetDeviceSettingToDefault(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
