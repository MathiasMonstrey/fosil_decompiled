package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;

@TargetApi(9)
class lk {
    private static Field SB;
    private static boolean SC;
    private static Field SD;
    private static boolean SE;

    static ColorStateList ao(View view) {
        return view instanceof lf ? ((lf) view).getSupportBackgroundTintList() : null;
    }

    static void m12277a(View view, ColorStateList colorStateList) {
        if (view instanceof lf) {
            ((lf) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode ap(View view) {
        return view instanceof lf ? ((lf) view).getSupportBackgroundTintMode() : null;
    }

    static void m12278a(View view, Mode mode) {
        if (view instanceof lf) {
            ((lf) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean as(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int ac(View view) {
        if (!SC) {
            try {
                SB = View.class.getDeclaredField("mMinWidth");
                SB.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            SC = true;
        }
        if (SB != null) {
            try {
                return ((Integer) SB.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int ad(View view) {
        if (!SE) {
            try {
                SD = View.class.getDeclaredField("mMinHeight");
                SD.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            SE = true;
        }
        if (SD != null) {
            try {
                return ((Integer) SD.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean au(View view) {
        return view.getWindowToken() != null;
    }

    static void m12279p(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m12280q(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    static Display aw(View view) {
        if (au(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }
}
