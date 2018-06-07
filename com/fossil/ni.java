package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

@TargetApi(9)
class ni {
    private static Field VK;
    private static boolean VL;

    static void m12765a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof oo) {
            ((oo) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m12766a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof oo) {
            ((oo) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static Drawable m12764a(CompoundButton compoundButton) {
        if (!VL) {
            try {
                VK = CompoundButton.class.getDeclaredField("mButtonDrawable");
                VK.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to retrieve mButtonDrawable field", e);
            }
            VL = true;
        }
        if (VK != null) {
            try {
                return (Drawable) VK.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatGingerbread", "Failed to get button drawable via reflection", e2);
                VK = null;
            }
        }
        return null;
    }
}
