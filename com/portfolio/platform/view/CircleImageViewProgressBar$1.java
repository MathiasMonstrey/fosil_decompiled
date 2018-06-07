package com.portfolio.platform.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CircleImageViewProgressBar$1 implements AnimatorUpdateListener {
    final /* synthetic */ CircleImageViewProgressBar dhq;

    CircleImageViewProgressBar$1(CircleImageViewProgressBar circleImageViewProgressBar) {
        this.dhq = circleImageViewProgressBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        CircleImageViewProgressBar.a(this.dhq, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.dhq.invalidate();
    }
}
