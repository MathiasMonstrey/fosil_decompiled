package com.misfit.ble.setting.uapp;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum UAppEnum$UAppButtonEvent {
    BTN_1(UAppEnum$UAppSystemLevelEvent.BTN_1_PRESS.getId()),
    BTN_2(UAppEnum$UAppSystemLevelEvent.BTN_2_PRESS.getId()),
    BTN_3(UAppEnum$UAppSystemLevelEvent.BTN_3_PRESS.getId());
    
    private static final Map<Byte, UAppEnum$UAppButtonEvent> aD = null;
    private final byte ax;

    static {
        aD = new HashMap();
        Iterator it = EnumSet.allOf(UAppEnum$UAppButtonEvent.class).iterator();
        while (it.hasNext()) {
            UAppEnum$UAppButtonEvent uAppEnum$UAppButtonEvent = (UAppEnum$UAppButtonEvent) it.next();
            aD.put(Byte.valueOf(uAppEnum$UAppButtonEvent.getId()), uAppEnum$UAppButtonEvent);
        }
    }

    private UAppEnum$UAppButtonEvent(byte b) {
        this.ax = b;
    }

    public static UAppEnum$UAppButtonEvent get(byte b) {
        return (UAppEnum$UAppButtonEvent) aD.get(Byte.valueOf(b));
    }

    public byte getId() {
        return this.ax;
    }
}
