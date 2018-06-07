package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.fossil.cfj;
import com.fossil.cfk;
import com.fossil.cgu;
import com.fossil.euh;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMappingDeserializer;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DevicePreferenceUtils {
    private static final String TAG = DevicePreferenceUtils.class.getSimpleName();

    static class C47221 extends cgu<List<BLEMapping>> {
        C47221() {
        }
    }

    static class C47232 extends cgu<AlarmSettings> {
        C47232() {
        }
    }

    static class C47243 extends cgu<List<MultipleAlarmSettings>> {
        C47243() {
        }
    }

    static class C47254 extends cgu<CountdownSettings> {
        C47254() {
        }
    }

    static class C47265 extends cgu<Set<String>> {
        C47265() {
        }
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(KeyUtils.getButtonPreferenceKey(context), 0);
    }

    public static void addPairedButtonSerial(Context context, String str) {
        addButtonSerialTo(context, str, KeyUtils.getKeyAllPairedButton(context));
    }

    public static void addActiveButtonSerial(Context context, String str) {
        removeString(context, KeyUtils.getKeyAllActiveButton(context));
        addButtonSerialTo(context, str, KeyUtils.getKeyAllActiveButton(context));
    }

    public static void removeActiveButtonSerial(Context context, String str) {
        removeButtonSerialFrom(context, str, KeyUtils.getKeyAllActiveButton(context));
    }

    public static void removePairedButtonSerial(Context context, String str) {
        removeButtonSerialFrom(context, str, KeyUtils.getKeyAllPairedButton(context));
    }

    public static List<String> getAllActiveButtonSerial(Context context) {
        return getAllButtonSerialFrom(context, KeyUtils.getKeyAllActiveButton(context));
    }

    public static List<String> getAllPairedButtonSerial(Context context) {
        return getAllButtonSerialFrom(context, KeyUtils.getKeyAllPairedButton(context));
    }

    public static boolean isActiveDevice(Context context, String str) {
        List allActiveButtonSerial = getAllActiveButtonSerial(context);
        return allActiveButtonSerial != null && allActiveButtonSerial.size() > 0 && allActiveButtonSerial.contains(str);
    }

    private static void addButtonSerialTo(Context context, String str, String str2) {
        MFLogger.d(TAG, ".addButtonSerialTo - serial=" + str + ", key=" + str2);
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            String string = preferences.getString(str2, "");
            if (TextUtils.isEmpty(string) || !string.contains(str)) {
                Editor edit = preferences.edit();
                edit.putString(str2, string + str + "_");
                edit.apply();
                return;
            }
            MFLogger.e(TAG, ".addButtonSerialTo - is exist in " + string + ", no need to add again ");
            return;
        }
        MFLogger.e(TAG, ".addButtonSerialTo - preferences=NULL");
    }

    private static void removeButtonSerialFrom(Context context, String str, String str2) {
        List<String> allButtonSerialFrom = getAllButtonSerialFrom(context, str2);
        MFLogger.d(TAG, ".removeButtonSerialFrom - serial=" + str + ", key=" + str2);
        if (allButtonSerialFrom != null && allButtonSerialFrom.contains(str)) {
            allButtonSerialFrom.remove(str);
            removeString(context, str2);
            for (String str3 : allButtonSerialFrom) {
                MFLogger.d(TAG, ".removeButtonSerialFrom re-Add button serial " + str3 + " to " + str2);
                addButtonSerialTo(context, str3, str2);
            }
        }
    }

    private static List<String> getAllButtonSerialFrom(Context context, String str) {
        List<String> arrayList = new ArrayList();
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Object string = preferences.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                for (CharSequence charSequence : string.split("_")) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        arrayList.add(charSequence);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isButtonExist(Context context, String str) {
        return isButtonExistIn(context, str, KeyUtils.getKeyAllActiveButton(context));
    }

    private static boolean isButtonExistIn(Context context, String str, String str2) {
        Object string = getString(context, str2);
        return !TextUtils.isEmpty(string) && string.contains(str);
    }

    public static String getString(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.v(TAG, "getString: " + str);
            return preferences.getString(str, "");
        }
        MFLogger.v(TAG, "getString: " + str);
        return "";
    }

    public static void setString(Context context, String str, String str2) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, "setString: " + str);
            Editor edit = preferences.edit();
            edit.putString(str, str2);
            edit.apply();
            return;
        }
        MFLogger.d(TAG, "setString: " + str);
    }

    private static void removeString(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, "removeString: " + str);
            Editor edit = preferences.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static void clearAutoSetMapping(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".clearAutoSetMapping: " + str + ", keyAutoMapping=" + KeyUtils.getKeyAutoSetMapping(context));
            Editor edit = preferences.edit();
            edit.remove(DeviceIdentityUtils.getDeviceFamily(str) + KeyUtils.getKeyAutoSetMapping(context));
            edit.apply();
        }
        removeSettingFlag(context, DeviceSettings.MAPPINGS);
    }

    public static void setAutoSetMapping(Context context, String str, String str2) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".setAutoSetMapping: " + DeviceIdentityUtils.getDeviceFamily(str) + KeyUtils.getKeyAutoSetMapping(context) + ", mappingJsonArray=" + str2);
            Editor edit = preferences.edit();
            edit.putString(DeviceIdentityUtils.getDeviceFamily(str) + KeyUtils.getKeyAutoSetMapping(context), str2);
            edit.apply();
        }
        removeSettingFlag(context, DeviceSettings.MAPPINGS);
    }

    public static List<BLEMapping> getAutoMapping(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Object string = preferences.getString(DeviceIdentityUtils.getDeviceFamily(str) + KeyUtils.getKeyAutoSetMapping(context), "");
            MFLogger.v(TAG, ".getAutoMapping - deviceFamily=" + DeviceIdentityUtils.getDeviceFamily(str) + ", key=" + KeyUtils.getKeyAutoSetMapping(context) + ", mappingJsonArray=" + string);
            if (!euh.isEmpty(string)) {
                try {
                    cfk com_fossil_cfk = new cfk();
                    com_fossil_cfk.a(BLEMapping.class, new BLEMappingDeserializer());
                    List<BLEMapping> list = (List) com_fossil_cfk.Wu().a(string, new C47221().getType());
                    MFLogger.v(TAG, ".getAutoMapping - autoMapping=" + list.size());
                    return list;
                } catch (Exception e) {
                    MFLogger.e(TAG, ".getAutoMapping - ex=" + e.toString());
                    return new ArrayList();
                }
            }
        }
        return new ArrayList();
    }

    public static void clearAutoSecondTimezone(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".clearAutoSecondTimezone - key=" + KeyUtils.getKeySecondTimezone(context));
            Editor edit = preferences.edit();
            edit.remove(KeyUtils.getKeySecondTimezone(context));
            edit.apply();
        }
    }

    public static void setAutoSecondTimezone(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".setAutoSecondTimezone - timezoneId=" + str);
            Editor edit = preferences.edit();
            edit.putString(KeyUtils.getKeySecondTimezone(context), str);
            edit.apply();
        }
        setCurrentSecondTimezoneOffset(context, ConversionUtils.getTimezoneRawOffsetById(str));
    }

    private static void setCurrentSecondTimezoneOffset(Context context, int i) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".setCurrentSecondTimezoneOffset - timezoneOffset=" + i);
            Editor edit = preferences.edit();
            edit.putInt(KeyUtils.getKeyCurrentSecondTimezoneOffset(context), i);
            edit.apply();
        }
    }

    public static int getCurrentSecondTimezoneOffset(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences == null) {
            return -1;
        }
        MFLogger.d(TAG, ".getCurrentSecondTimezoneOffset");
        return preferences.getInt(KeyUtils.getKeyCurrentSecondTimezoneOffset(context), -1);
    }

    public static String getAutoSecondTimezoneId(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getString(KeyUtils.getKeySecondTimezone(context), "");
        }
        return "";
    }

    public static int getAutoSecondTimezone(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences == null) {
            return 1024;
        }
        Object string = preferences.getString(KeyUtils.getKeySecondTimezone(context), "");
        MFLogger.d(TAG, ".getAutoSecondTimezone - timezoneId=" + string);
        if (TextUtils.isEmpty(string)) {
            return 1024;
        }
        return ConversionUtils.getTimezoneRawOffsetById(string);
    }

    public static void clearAutoAlarmSetting(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, "clearAutoAlarmSetting - key=" + KeyUtils.getKeyAlarmSetting(context));
            Editor edit = preferences.edit();
            edit.remove(KeyUtils.getKeyAlarmSetting(context));
            edit.apply();
        }
    }

    public static void setAutoAlarmSetting(Context context, AlarmSettings alarmSettings) {
        SharedPreferences preferences = getPreferences(context);
        String toJson = new cfj().toJson(alarmSettings);
        if (preferences != null) {
            MFLogger.d(TAG, ".setAutoAlarmSetting - alarmJson=" + toJson);
            Editor edit = preferences.edit();
            edit.putString(KeyUtils.getKeyAlarmSetting(context), toJson);
            edit.apply();
        }
    }

    public static AlarmSettings getAutoAlarmSetting(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Object string = preferences.getString(KeyUtils.getKeyAlarmSetting(context), "");
            MFLogger.d(TAG, ".getAutoAlarmSetting - alarmJson=" + string);
            if (!euh.isEmpty(string)) {
                try {
                    return (AlarmSettings) new cfj().a(string, new C47232().getType());
                } catch (Exception e) {
                    MFLogger.e(TAG, ".getAutoAlarmSetting - ex=" + e.toString());
                    return null;
                }
            }
        }
        return null;
    }

    public static void clearAutoListAlarm(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".clearAutoAlarmSetting - key=" + KeyUtils.getKeyListAlarm(context));
            Editor edit = preferences.edit();
            edit.remove(KeyUtils.getKeyListAlarm(context));
            edit.apply();
        }
    }

    public static void setAutoListAlarm(Context context, List<MultipleAlarmSettings> list) {
        SharedPreferences preferences = getPreferences(context);
        String toJson = new cfj().toJson(list);
        if (preferences != null) {
            MFLogger.d(TAG, ".setAutoListAlarm - alarmsJson=" + toJson);
            Editor edit = preferences.edit();
            edit.putString(KeyUtils.getKeyListAlarm(context), toJson);
            edit.apply();
        }
    }

    public static List<MultipleAlarmSettings> getAutoListAlarm(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Object string = preferences.getString(KeyUtils.getKeyListAlarm(context), "");
            MFLogger.d(TAG, ".getAutoListAlarm - alarmJson=" + string);
            if (!euh.isEmpty(string)) {
                try {
                    return (List) new cfj().a(string, new C47243().getType());
                } catch (Exception e) {
                    MFLogger.e(TAG, ".getAutoListAlarm - ex=" + e.toString());
                    return new ArrayList();
                }
            }
        }
        return new ArrayList();
    }

    public static void clearAutoCountdownSetting(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            MFLogger.d(TAG, ".clearAutoCountdownSetting - key=" + KeyUtils.getKeyAutoCountdownSetting(context));
            Editor edit = preferences.edit();
            edit.remove(KeyUtils.getKeyAutoCountdownSetting(context));
            edit.apply();
        }
    }

    public static void setAutoCountdownSetting(Context context, CountdownSettings countdownSettings) {
        SharedPreferences preferences = getPreferences(context);
        String toJson = new cfj().toJson(countdownSettings);
        if (preferences != null) {
            MFLogger.d(TAG, ".setAutoCountdownSetting - countdownJson=" + toJson);
            Editor edit = preferences.edit();
            edit.putString(KeyUtils.getKeyAutoCountdownSetting(context), toJson);
            edit.apply();
        }
    }

    public static CountdownSettings getAutoCountDownSetting(Context context) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Object string = preferences.getString(KeyUtils.getKeyAutoCountdownSetting(context), "");
            MFLogger.d(TAG, ".getAutoCountDownSetting - countdownJson=" + string);
            if (!euh.isEmpty(string)) {
                try {
                    return (CountdownSettings) new cfj().a(string, new C47254().getType());
                } catch (Exception e) {
                    MFLogger.e(TAG, ".getAutoCountDownSetting - ex=" + e.toString());
                    return new CountdownSettings(0, 0, GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER);
                }
            }
        }
        return new CountdownSettings(0, 0, GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER);
    }

    public static void setSettingFlag(Context context, DeviceSettings deviceSettings) {
        Set settingFlags = getSettingFlags(context);
        settingFlags.add(deviceSettings.name());
        String toJson = new cfj().toJson(settingFlags);
        MFLogger.d(TAG, ".setSettingFlag - flags=" + toJson);
        setString(context, KeyUtils.getKeyDeviceSettingData(context), toJson);
    }

    private static Set<String> getSettingFlags(Context context) {
        Set<String> set = (Set) new cfj().a(getString(context, KeyUtils.getKeyDeviceSettingData(context)), new C47265().getType());
        return set == null ? new HashSet() : set;
    }

    public static void removeSettingFlag(Context context, DeviceSettings deviceSettings) {
        Set settingFlags = getSettingFlags(context);
        settingFlags.remove(deviceSettings.name());
        String toJson = new cfj().toJson(settingFlags);
        MFLogger.d(TAG, ".removeSettingFlag - flags=" + toJson + ", removed=" + deviceSettings.name());
        setString(context, KeyUtils.getKeyDeviceSettingData(context), toJson);
    }

    public static void clearAllSettingFlag(Context context) {
        removeString(context, KeyUtils.getKeyDeviceSettingData(context));
    }

    public static boolean isNeedToSetSetting(Context context, DeviceSettings deviceSettings) {
        return getSettingFlags(context).contains(deviceSettings.name());
    }

    public static void logOut(final Context context) {
        new Thread() {
            public void run() {
                for (String clearAutoSetMapping : DevicePreferenceUtils.getAllPairedButtonSerial(context)) {
                    DevicePreferenceUtils.clearAutoSetMapping(context, clearAutoSetMapping);
                }
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyDeviceSettingData(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyAllActiveButton(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyAllPairedButton(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyDeviceProfile(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeySecondTimezone(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyCurrentSecondTimezoneOffset(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyAlarmSetting(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyListAlarm(context));
                DevicePreferenceUtils.removeString(context, KeyUtils.getKeyAutoCountdownSetting(context));
            }
        }.start();
    }
}
