package com.fossil;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import com.fossil.bj.C1929d;

public class bp {
    public static final C1929d Dp = new C19381();

    static class C19381 implements C1929d {
        C19381() {
        }

        public bj ha() {
            return new bj(VERSION.SDK_INT >= 12 ? new bl() : new bk());
        }
    }

    public static bj ha() {
        return Dp.ha();
    }

    public static boolean m5450b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Mode m5449a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }
}
