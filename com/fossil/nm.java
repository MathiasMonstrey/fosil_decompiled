package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;

@TargetApi(21)
public class nm {
    private static final int[] WR = new int[]{16843828};

    static class C3920a implements OnApplyWindowInsetsListener {
        C3920a() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((nn) view).m12773o(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public static void aV(View view) {
        if (view instanceof nn) {
            view.setOnApplyWindowInsetsListener(new C3920a());
            view.setSystemUiVisibility(1280);
        }
    }

    public static void m12770a(View view, Object obj, int i) {
        obj = (WindowInsets) obj;
        if (i == 3) {
            obj = obj.replaceSystemWindowInsets(obj.getSystemWindowInsetLeft(), obj.getSystemWindowInsetTop(), 0, obj.getSystemWindowInsetBottom());
        } else if (i == 5) {
            obj = obj.replaceSystemWindowInsets(0, obj.getSystemWindowInsetTop(), obj.getSystemWindowInsetRight(), obj.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(obj);
    }

    public static void m12771a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        obj = (WindowInsets) obj;
        if (i == 3) {
            obj = obj.replaceSystemWindowInsets(obj.getSystemWindowInsetLeft(), obj.getSystemWindowInsetTop(), 0, obj.getSystemWindowInsetBottom());
        } else if (i == 5) {
            obj = obj.replaceSystemWindowInsets(0, obj.getSystemWindowInsetTop(), obj.getSystemWindowInsetRight(), obj.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = obj.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = obj.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = obj.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = obj.getSystemWindowInsetBottom();
    }

    public static int aM(Object obj) {
        return obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
    }

    public static Drawable m12772q(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(WR);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            return drawable;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
