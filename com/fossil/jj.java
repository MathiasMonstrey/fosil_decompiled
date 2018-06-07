package com.fossil;

import android.os.Build.VERSION;
import java.util.Locale;

public final class jj {
    private static final C3754a PT;
    static String PU = "Arab";
    static String PV = "Hebr";
    public static final Locale ROOT = new Locale("", "");

    static class C3754a {
        C3754a() {
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (!(locale == null || locale.equals(jj.ROOT))) {
                String a = je.m11867a(locale);
                if (a == null) {
                    return C3754a.m11875c(locale);
                }
                if (a.equalsIgnoreCase(jj.PU) || a.equalsIgnoreCase(jj.PV)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m11875c(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    static class C3755b extends C3754a {
        C3755b() {
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            return jk.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            PT = new C3755b();
        } else {
            PT = new C3754a();
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return PT.getLayoutDirectionFromLocale(locale);
    }
}
