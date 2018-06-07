package com.misfit.ble.setting.flashlink;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum FlashButtonMode {
    SELFIE((short) 1),
    MUSIC((short) 2),
    PRESO((short) 3),
    APPLICATION((short) 4),
    TRACKER((short) 5),
    BOLT_CONTROL((short) 6),
    CUSTOM_MODE((short) 7);
    
    private static final Map<Short, FlashButtonMode> aD = null;
    private short aE;

    static {
        aD = new HashMap();
        Iterator it = EnumSet.allOf(FlashButtonMode.class).iterator();
        while (it.hasNext()) {
            FlashButtonMode flashButtonMode = (FlashButtonMode) it.next();
            aD.put(Short.valueOf(flashButtonMode.getId()), flashButtonMode);
        }
    }

    private FlashButtonMode(short s) {
        this.aE = s;
    }

    public static FlashButtonMode get(short s) {
        return (FlashButtonMode) aD.get(Short.valueOf(s));
    }

    public short getId() {
        return this.aE;
    }
}
