package com.fossil;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.View;

@TargetApi(12)
class ee implements eb {
    private TimeInterpolator HF;

    static class C3329a implements AnimatorListener {
        final ea HG;
        final ef HH;

        public C3329a(ea eaVar, ef efVar) {
            this.HG = eaVar;
            this.HH = efVar;
        }

        public void onAnimationStart(Animator animator) {
            this.HG.m10390a(this.HH);
        }

        public void onAnimationEnd(Animator animator) {
            this.HG.m10391b(this.HH);
        }

        public void onAnimationCancel(Animator animator) {
            this.HG.m10392c(this.HH);
        }

        public void onAnimationRepeat(Animator animator) {
            this.HG.m10393d(this.HH);
        }
    }

    static class C3331b implements ef {
        final Animator HI;

        public C3331b(Animator animator) {
            this.HI = animator;
        }

        public void mo2808G(View view) {
            this.HI.setTarget(view);
        }

        public void mo2809a(ea eaVar) {
            this.HI.addListener(new C3329a(eaVar, this));
        }

        public void setDuration(long j) {
            this.HI.setDuration(j);
        }

        public void start() {
            this.HI.start();
        }

        public void cancel() {
            this.HI.cancel();
        }

        public void mo2810a(final ec ecVar) {
            if (this.HI instanceof ValueAnimator) {
                ((ValueAnimator) this.HI).addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ C3331b HK;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ecVar.m10469e(this.HK);
                    }
                });
            }
        }

        public float getAnimatedFraction() {
            return ((ValueAnimator) this.HI).getAnimatedFraction();
        }
    }

    ee() {
    }

    public ef hH() {
        return new C3331b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public void mo2815F(View view) {
        if (this.HF == null) {
            this.HF = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.HF);
    }
}
