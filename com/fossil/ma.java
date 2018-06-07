package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Interpolator;

@TargetApi(14)
class ma {
    public static void m12438b(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m12440n(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m12441o(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m12442p(View view, float f) {
        view.animate().translationY(f);
    }

    public static long aE(View view) {
        return view.animate().getDuration();
    }

    public static void m12436a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m12439c(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void aF(View view) {
        view.animate().cancel();
    }

    public static void aG(View view) {
        view.animate().start();
    }

    public static void m12437a(final View view, final md mdVar) {
        if (mdVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    mdVar.aD(view);
                }

                public void onAnimationEnd(Animator animator) {
                    mdVar.mo82f(view);
                }

                public void onAnimationStart(Animator animator) {
                    mdVar.mo81e(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
