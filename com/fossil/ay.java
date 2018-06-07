package com.fossil;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.Log;
import java.lang.reflect.Method;

public class ay {
    private static Method yX;
    private static boolean yY;

    public static boolean m4691a(DrawableContainer drawableContainer, ConstantState constantState) {
        return m4692b(drawableContainer, constantState);
    }

    private static boolean m4692b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!yY) {
            try {
                yX = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                yX.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            yY = true;
        }
        if (yX != null) {
            try {
                yX.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
