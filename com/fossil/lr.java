package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

@TargetApi(21)
class lr {
    private static ThreadLocal<Rect> SF;

    public interface C3830a {
        Object mo3376c(View view, Object obj);
    }

    public static String ah(View view) {
        return view.getTransitionName();
    }

    public static void aj(View view) {
        view.requestApplyInsets();
    }

    public static void m12323l(View view, float f) {
        view.setElevation(f);
    }

    public static float ag(View view) {
        return view.getElevation();
    }

    public static float ax(View view) {
        return view.getTranslationZ();
    }

    public static void m12320a(View view, final C3830a c3830a) {
        if (c3830a == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) c3830a.mo3376c(view, windowInsets);
                }
            });
        }
    }

    static ColorStateList ao(View view) {
        return view.getBackgroundTintList();
    }

    static void m12318a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode ap(View view) {
        return view.getBackgroundTintMode();
    }

    static void m12319a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static Object m12321c(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            return new WindowInsets(onApplyWindowInsets);
        }
        return obj;
    }

    public static Object m12322f(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            return new WindowInsets(dispatchApplyWindowInsets);
        }
        return obj;
    }

    public static boolean aq(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void ar(View view) {
        view.stopNestedScroll();
    }

    public static float at(View view) {
        return view.getZ();
    }

    static void m12324p(View view, int i) {
        Object obj;
        Rect jE = jE();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            jE.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !jE.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ll.m12297p(view, i);
        if (obj != null && jE.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(jE);
        }
    }

    static void m12325q(View view, int i) {
        Object obj;
        Rect jE = jE();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            jE.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !jE.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ll.m12298q(view, i);
        if (obj != null && jE.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(jE);
        }
    }

    private static Rect jE() {
        if (SF == null) {
            SF = new ThreadLocal();
        }
        Rect rect = (Rect) SF.get();
        if (rect == null) {
            rect = new Rect();
            SF.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
