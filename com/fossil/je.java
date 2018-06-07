package com.fossil;

import android.os.Build.VERSION;
import java.util.Locale;

public final class je {
    private static final C3744a PC;

    interface C3744a {
        String mo3234a(Locale locale);
    }

    static class C3745b implements C3744a {
        C3745b() {
        }

        public String mo3234a(Locale locale) {
            return null;
        }
    }

    static class C3746c implements C3744a {
        C3746c() {
        }

        public String mo3234a(Locale locale) {
            return jg.m11869a(locale);
        }
    }

    static class C3747d implements C3744a {
        C3747d() {
        }

        public String mo3234a(Locale locale) {
            return jf.m11868a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            PC = new C3747d();
        } else if (i >= 14) {
            PC = new C3746c();
        } else {
            PC = new C3745b();
        }
    }

    public static String m11867a(Locale locale) {
        return PC.mo3234a(locale);
    }
}
