package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.firmware.Firmware;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class at {
    private static final String TAG = LogUtils.m15475b(at.class);
    private static final List<String> gL = new ArrayList();

    static {
        gL.add(cr.class.getSimpleName());
        gL.add(cs.class.getSimpleName());
        gL.add(gb.class.getSimpleName());
        gL.add(ej.class.getSimpleName());
        gL.add(el.class.getSimpleName());
        gL.add(em.class.getSimpleName());
        gL.add(eo.class.getSimpleName());
        gL.add(ep.class.getSimpleName());
        gL.add(ek.class.getSimpleName());
        gL.add(en.class.getSimpleName());
        gL.add(cv.class.getSimpleName());
        gL.add(fl.class.getSimpleName());
        gL.add(ds.class.getSimpleName());
    }

    public static boolean m14777a(Firmware firmware, ew ewVar) {
        if (ewVar == null) {
            LogUtils.m15477e(TAG, "Request is null");
            return false;
        } else if (gL.contains(ewVar.getClass().getSimpleName())) {
            LogUtils.m15478k(TAG, "Default supported request");
            return true;
        } else if (firmware == null) {
            LogUtils.m15477e(TAG, "Firmware is null");
            return false;
        } else {
            String E = hb.m15159E(ewVar.getRequestData());
            Set<String> set = (Set) firmware.supportedCommands.get(ewVar.getCharacteristicUUID());
            if (set == null) {
                LogUtils.m15477e(TAG, "Command is null");
                return false;
            }
            for (String startsWith : set) {
                if (E.startsWith(startsWith)) {
                    return true;
                }
            }
            return false;
        }
    }
}
