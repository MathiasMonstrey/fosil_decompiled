package com.fossil;

import android.annotation.TargetApi;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
class jg {
    private static Method PD;
    private static Method PE;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                PE = cls.getMethod("getScript", new Class[]{String.class});
                PD = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            PE = null;
            PD = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m11869a(Locale locale) {
        String b = m11870b(locale);
        if (b != null) {
            return getScript(b);
        }
        return null;
    }

    private static String getScript(String str) {
        try {
            if (PE != null) {
                return (String) PE.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m11870b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (PD != null) {
                return (String) PD.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
