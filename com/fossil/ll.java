package com.fossil;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

@TargetApi(11)
class ll {
    static long jD() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m12281Q(View view) {
        return view.getAlpha();
    }

    public static void m12287a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m12282R(View view) {
        return view.getLayerType();
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m12283U(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m12284V(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int m12285W(View view) {
        return view.getMeasuredState();
    }

    public static float m12286Z(View view) {
        return view.getTranslationX();
    }

    public static float aa(View view) {
        return view.getTranslationY();
    }

    public static float af(View view) {
        return view.getScaleX();
    }

    public static void m12290e(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m12291f(View view, float f) {
        view.setTranslationY(f);
    }

    public static Matrix ab(View view) {
        return view.getMatrix();
    }

    public static void m12292g(View view, float f) {
        view.setAlpha(f);
    }

    public static void m12293h(View view, float f) {
        view.setScaleX(f);
    }

    public static void m12294i(View view, float f) {
        view.setScaleY(f);
    }

    public static void m12295j(View view, float f) {
        view.setPivotX(f);
    }

    public static void m12296k(View view, float f) {
        view.setPivotY(f);
    }

    public static void al(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m12288c(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m12289d(View view, boolean z) {
        view.setActivated(z);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    static void m12297p(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            ay(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                ay((View) parent);
            }
        }
    }

    static void m12298q(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            ay(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                ay((View) parent);
            }
        }
    }

    private static void ay(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
