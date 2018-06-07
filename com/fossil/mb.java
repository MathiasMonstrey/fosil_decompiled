package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(16)
class mb {
    public static void m12443a(final View view, final md mdVar) {
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
