package com.fossil;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class ke {
    static final C3786a Ru;

    interface C3786a {
        void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4);

        int getAbsoluteGravity(int i, int i2);
    }

    static class C3787b implements C3786a {
        C3787b() {
        }

        public int getAbsoluteGravity(int i, int i2) {
            return -8388609 & i;
        }

        public void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class C3788c implements C3786a {
        C3788c() {
        }

        public int getAbsoluteGravity(int i, int i2) {
            return kf.getAbsoluteGravity(i, i2);
        }

        public void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            kf.apply(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            Ru = new C3788c();
        } else {
            Ru = new C3787b();
        }
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Ru.apply(i, i2, i3, rect, rect2, i4);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return Ru.getAbsoluteGravity(i, i2);
    }
}
