package com.fossil;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(19)
class mc {
    public static void m12444a(final View view, final mf mfVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (mfVar != null) {
            animatorUpdateListener = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    mfVar.aH(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
