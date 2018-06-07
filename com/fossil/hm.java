package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;

@TargetApi(19)
class hm {
    public static void m11646a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m11647d(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m11649k(Drawable drawable) {
        if (drawable instanceof ht) {
            return drawable;
        }
        return new hr(drawable);
    }

    public static int m11648e(Drawable drawable) {
        return drawable.getAlpha();
    }
}
