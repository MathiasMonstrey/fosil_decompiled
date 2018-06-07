package com.misfit.frameworks.buttonservice.utils;

import android.text.TextUtils;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil.BRAND;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SettingsUtils {

    static class C47311 implements Comparator<MultipleAlarmSettings> {
        C47311() {
        }

        public int compare(MultipleAlarmSettings multipleAlarmSettings, MultipleAlarmSettings multipleAlarmSettings2) {
            int i = 1;
            int i2 = -1;
            int i3;
            if (multipleAlarmSettings == null || multipleAlarmSettings2 == null) {
                i3 = multipleAlarmSettings == null ? -1 : 1;
                if (multipleAlarmSettings2 != null) {
                    i2 = 1;
                }
                return i3 - i2;
            } else if (multipleAlarmSettings.getAlarmDay() - multipleAlarmSettings2.getAlarmDay() != 0) {
                return multipleAlarmSettings.getAlarmDay() - multipleAlarmSettings2.getAlarmDay();
            } else {
                if (multipleAlarmSettings.getAlarmHour() - multipleAlarmSettings2.getAlarmHour() != 0) {
                    return multipleAlarmSettings.getAlarmHour() - multipleAlarmSettings2.getAlarmHour();
                }
                if (multipleAlarmSettings.getAlarmMinute() - multipleAlarmSettings2.getAlarmMinute() != 0) {
                    return multipleAlarmSettings.getAlarmMinute() - multipleAlarmSettings2.getAlarmMinute();
                }
                if (multipleAlarmSettings.isAlarmRepeat()) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                if (!multipleAlarmSettings2.isAlarmRepeat()) {
                    i = -1;
                }
                return i3 - i;
            }
        }
    }

    public static void sortMultiAlarmSettingList(List<MultipleAlarmSettings> list) {
        Collections.sort(list, new C47311());
    }

    public static boolean isMultiAlarmListTheSame(List<MultipleAlarmSettings> list, List<MultipleAlarmSettings> list2) {
        Object obj = (list == null || list.isEmpty()) ? 1 : null;
        Object obj2;
        if (list2 == null || list2.isEmpty()) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj == null && r0 == null) {
            if (list.size() != list2.size()) {
                return false;
            }
            List arrayList = new ArrayList(list);
            List arrayList2 = new ArrayList(list2);
            sortMultiAlarmSettingList(arrayList);
            sortMultiAlarmSettingList(arrayList2);
            int size = arrayList.size();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                MultipleAlarmSettings multipleAlarmSettings = (MultipleAlarmSettings) arrayList.get(i);
                if (multipleAlarmSettings != null) {
                    MultipleAlarmSettings multipleAlarmSettings2 = (MultipleAlarmSettings) arrayList2.get(i);
                    z = multipleAlarmSettings2 == null ? false : multipleAlarmSettings.toString().equals(multipleAlarmSettings2.toString());
                } else {
                    z = arrayList2.get(i) == null;
                }
                if (!z) {
                    return z;
                }
            }
            return z;
        } else if (obj == null || r0 == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSupportCountDown(String str) {
        return !TextUtils.isEmpty(str) && FossilDeviceSerialPatternUtil.getBrandBySerial(str) == BRAND.KATE_SPADE && FossilDeviceSerialPatternUtil.isHybridSmartWatchDevice(str);
    }
}
