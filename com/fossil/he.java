package com.fossil;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class he {
    public static Drawable m11561b(Resources resources, int i, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return hf.m11562b(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
