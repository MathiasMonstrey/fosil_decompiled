package com.fossil;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.AnalyticsEvents;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.DeviceState;
import java.util.Date;
import java.util.Locale;

public class dqv {

    static /* synthetic */ class C31091 {
        static final /* synthetic */ int[] deY = new int[DeviceState.values().length];

        static {
            try {
                deY[DeviceState.Connected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                deY[DeviceState.Disconnected.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                deY[DeviceState.FirmwareUpdate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                deY[DeviceState.RecoveryModeStart.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                deY[DeviceState.RecoveryModeEnd.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                deY[DeviceState.Shutdown.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                deY[DeviceState.NoChange.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static DeviceModel m9408a(MisfitDeviceProfile misfitDeviceProfile, Date date, DeviceState deviceState) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setDeviceId(misfitDeviceProfile.getDeviceSerial());
        deviceModel.setFirmwareRevision(misfitDeviceProfile.getFirmwareVersion());
        deviceModel.setProductDisplayName(misfitDeviceProfile.getProductName());
        deviceModel.setDeviceType("Misfit");
        deviceModel.setManufacturer("Misfit");
        deviceModel.setHardwareRevision(euh.m11222E(misfitDeviceProfile.getDeviceSerial(), 0, 4));
        deviceModel.setSoftwareRevision(SDKSetting.getSDKVersion());
        deviceModel.setMacAddress(misfitDeviceProfile.getAddress());
        deviceModel.setSku(misfitDeviceProfile.getDeviceModel());
        deviceModel.setBatteryLevel(misfitDeviceProfile.getBatteryLevel());
        deviceModel.setLastFirmwareUpdate(cmq.m7131i(date));
        deviceModel.setHostMaker(Build.MANUFACTURER == null ? "" : Build.MANUFACTURER);
        deviceModel.setHostModel(Build.MODEL == null ? "" : Build.MODEL);
        deviceModel.setHostOS("Android");
        deviceModel.setHostOSVersion(VERSION.RELEASE == null ? "" : VERSION.RELEASE);
        Locale locale = Locale.getDefault();
        String locale2 = locale != null ? locale.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String displayLanguage = locale != null ? locale.getDisplayLanguage() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        if (locale2 == null) {
            locale2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        deviceModel.setHostSystemLocale(locale2);
        if (displayLanguage == null) {
            locale2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        } else {
            locale2 = displayLanguage;
        }
        deviceModel.setHostSystemLanguage(locale2);
        switch (C31091.deY[deviceState.ordinal()]) {
            case 1:
                deviceModel.setLastConnection(cmq.m7131i(date));
                break;
            case 2:
                deviceModel.setLastDisconnection(cmq.m7131i(date));
                break;
            case 3:
                deviceModel.setLastFirmwareUpdate(cmq.m7131i(date));
                break;
            case 4:
                deviceModel.setLastRecoveryModeStart(cmq.m7131i(date));
                break;
            case 5:
                deviceModel.setLastRecoveryModeEnd(cmq.m7131i(date));
                break;
        }
        return deviceModel;
    }
}
