package com.fossil;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;

public class rv {
    public static final Rect amG = new Rect();
    private static Class<?> amH;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                amH = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static Rect m13470t(Drawable drawable) {
        if (amH != null) {
            try {
                Drawable j = hh.j(drawable);
                Object invoke = j.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(j, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : amH.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return amG;
    }

    static void m13471u(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m13473w(drawable);
        }
    }

    public static boolean m13472v(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable v : ((DrawableContainerState) constantState).getChildren()) {
                    if (!m13472v(v)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof ho) {
            return m13472v(((ho) drawable).iM());
        } else {
            if (drawable instanceof pp) {
                return m13472v(((pp) drawable).iM());
            }
            if (drawable instanceof ScaleDrawable) {
                return m13472v(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    private static void m13473w(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(sr.tH);
        } else {
            drawable.setState(sr.EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static Mode m13469a(int i, Mode mode) {
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
            case 16:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
