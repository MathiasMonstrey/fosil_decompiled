package com.misfit.ble.obfuscated;

import com.fossil.jt;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import java.util.Hashtable;

public class C4597w {
    private static Hashtable<Short, jt<UAppID, UAppVariant>> bL = new Hashtable();

    static {
        bL.put(Short.valueOf((short) 3073), new jt(UAppID.UAPP_RING_PHONE, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 6657), new jt(UAppID.UAPP_ALARM, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 6658), new jt(UAppID.UAPP_ALARM, UAppVariant.UAPP_VARIANT_SEQUENCE));
        bL.put(Short.valueOf((short) 7169), new jt(UAppID.UAPP_PROGRESS, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 7170), new jt(UAppID.UAPP_PROGRESS, UAppVariant.UAPP_VARIANT_SWEEP));
        bL.put(Short.valueOf((short) 7681), new jt(UAppID.UAPP_24H, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 7682), new jt(UAppID.UAPP_24H, UAppVariant.UAPP_VARIANT_SEQUENCE));
        bL.put(Short.valueOf((short) 1025), new jt(UAppID.UAPP_GOAL_TRACKING, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 4097), new jt(UAppID.UAPP_SELFIE, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 4609), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_PLAY_PAUSE));
        bL.put(Short.valueOf((short) 4610), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_NEXT));
        bL.put(Short.valueOf((short) 4611), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_PREVIOUS));
        bL.put(Short.valueOf((short) 4612), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_VOLUME_UP));
        bL.put(Short.valueOf((short) 4613), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_VOLUME_DOWN));
        bL.put(Short.valueOf((short) 4614), new jt(UAppID.UAPP_MUSIC_CONTROL, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 5121), new jt(UAppID.UAPP_DATE, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 5122), new jt(UAppID.UAPP_DATE, UAppVariant.UAPP_VARIANT_SEQUENCE));
        bL.put(Short.valueOf((short) 5633), new jt(UAppID.UAPP_TIME_2, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 5634), new jt(UAppID.UAPP_TIME_2, UAppVariant.UAPP_VARIANT_SEQUENCE));
        bL.put(Short.valueOf((short) 6145), new jt(UAppID.UAPP_ALERT, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 6146), new jt(UAppID.UAPP_ALERT, UAppVariant.UAPP_VARIANT_SEQUENCE));
        bL.put(Short.valueOf((short) 8193), new jt(UAppID.UAPP_STOP_WATCH, UAppVariant.UAPP_VARIANT_STANDARD));
        bL.put(Short.valueOf((short) 9217), new jt(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_TRAVEL));
        bL.put(Short.valueOf((short) 9218), new jt(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_ETA));
    }

    public static UAppID m15232a(short s) {
        jt jtVar = (jt) bL.get(Short.valueOf(s));
        if (jtVar != null) {
            return (UAppID) jtVar.first;
        }
        return UAppID.UAPP_UNDEFINED;
    }

    public static UAppVariant m15233b(short s) {
        jt jtVar = (jt) bL.get(Short.valueOf(s));
        if (jtVar != null) {
            return (UAppVariant) jtVar.second;
        }
        return UAppVariant.UAPP_VARIANT_UNDEFINED;
    }
}
