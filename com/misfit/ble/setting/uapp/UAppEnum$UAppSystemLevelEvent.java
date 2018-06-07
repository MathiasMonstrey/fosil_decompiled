package com.misfit.ble.setting.uapp;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum UAppEnum$UAppSystemLevelEvent {
    EVENT_INVALID((byte) 0),
    TAP_DOUBLE((byte) 14),
    TAP_TRIPLE((byte) 15),
    BTN_1_PRESS((byte) 16),
    BTN_1_RELEASED((byte) 17),
    BTN_1_SINGLE_CLICK((byte) 18),
    BTN_1_SINGLE_PRESS_AND_HOLD((byte) 19),
    BTN_1_DOUBLE_CLICK((byte) 20),
    BTN_1_DOUBLE_PRESS_AND_HOLD((byte) 21),
    BTN_1_TRIPLE_CLICK((byte) 22),
    BTN_1_TRIPLE_PRESS_AND_HOLD((byte) 23),
    BTN_1_HOLD_RELEASED((byte) 24),
    BTN_2_PRESS((byte) 32),
    BTN_2_RELEASED((byte) 33),
    BTN_2_SINGLE_CLICK((byte) 34),
    BTN_2_SINGLE_PRESS_AND_HOLD((byte) 35),
    BTN_2_DOUBLE_CLICK((byte) 36),
    BTN_2_DOUBLE_PRESS_AND_HOLD((byte) 37),
    BTN_2_TRIPLE_CLICK((byte) 38),
    BTN_2_TRIPLE_PRESS_AND_HOLD((byte) 39),
    BTN_2_HOLD_RELEASED((byte) 40),
    BTN_3_PRESS((byte) 48),
    BTN_3_RELEASED((byte) 49),
    BTN_3_SINGLE_CLICK((byte) 50),
    BTN_3_SINGLE_PRESS_AND_HOLD((byte) 51),
    BTN_3_DOUBLE_CLICK((byte) 52),
    BTN_3_DOUBLE_PRESS_AND_HOLD((byte) 53),
    BTN_3_TRIPLE_CLICK((byte) 54),
    BTN_3_TRIPLE_PRESS_AND_HOLD((byte) 55),
    BTN_3_HOLD_RELEASED((byte) 56),
    NOTIFICATION((byte) -16),
    ALARM_FIRE((byte) -15),
    FW_SERVICE_COMPLETE((byte) -14),
    BLE_OPENED((byte) -13),
    BLE_CLOSED((byte) -12),
    UAPP_TIME_LIMIT_EXCEEDED((byte) -11),
    THIS_UAPP_LAUNCH_EVENT((byte) -10),
    CUSTOM_0((byte) -9),
    CUSTOM_1((byte) -8),
    CUSTOM_2((byte) -7),
    CUSTOM_3((byte) -6),
    CUSTOM_4((byte) -5),
    CUSTOM_5((byte) -4),
    CUSTOM_6((byte) -3),
    CUSTOM_7((byte) -2);
    
    private static final Map<Byte, UAppEnum$UAppSystemLevelEvent> aD = null;
    private final byte ax;

    static {
        aD = new HashMap();
        Iterator it = EnumSet.allOf(UAppEnum$UAppSystemLevelEvent.class).iterator();
        while (it.hasNext()) {
            UAppEnum$UAppSystemLevelEvent uAppEnum$UAppSystemLevelEvent = (UAppEnum$UAppSystemLevelEvent) it.next();
            aD.put(Byte.valueOf(uAppEnum$UAppSystemLevelEvent.getId()), uAppEnum$UAppSystemLevelEvent);
        }
    }

    private UAppEnum$UAppSystemLevelEvent(byte b) {
        this.ax = b;
    }

    public static UAppEnum$UAppSystemLevelEvent get(byte b) {
        return (UAppEnum$UAppSystemLevelEvent) aD.get(Byte.valueOf(b));
    }

    public byte getId() {
        return this.ax;
    }
}
