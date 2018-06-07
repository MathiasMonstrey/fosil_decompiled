package com.fossil;

import java.util.Locale;

public final class aor {
    private static aor bac;

    private aor() {
    }

    public static synchronized aor Ix() {
        aor com_fossil_aor;
        synchronized (aor.class) {
            if (bac == null) {
                bac = new aor();
            }
            com_fossil_aor = bac;
        }
        return com_fossil_aor;
    }

    public static String HI() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }
}
