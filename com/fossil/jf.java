package com.fossil;

import android.annotation.TargetApi;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(23)
class jf {
    private static Method PD;

    static {
        try {
            PD = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m11868a(Locale locale) {
        try {
            return ((Locale) PD.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
