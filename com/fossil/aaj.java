package com.fossil;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.fossil.aao.C1550a;

public class aaj<T extends Drawable> implements aam<T> {
    private final aap<T> aGw;
    private aak<T> aGx;
    private aak<T> aGy;
    private final int duration;

    static class C1551a implements C1550a {
        private final int duration;

        C1551a(int i) {
            this.duration = i;
        }

        public Animation wJ() {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.duration);
            return alphaAnimation;
        }
    }

    public aaj() {
        this(300);
    }

    public aaj(int i) {
        this(new aap(new C1551a(i)), i);
    }

    aaj(aap<T> com_fossil_aap_T, int i) {
        this.aGw = com_fossil_aap_T;
        this.duration = i;
    }

    public aal<T> mo776i(boolean z, boolean z2) {
        if (z) {
            return aan.wM();
        }
        if (z2) {
            return wH();
        }
        return wI();
    }

    private aal<T> wH() {
        if (this.aGx == null) {
            this.aGx = new aak(this.aGw.mo776i(false, true), this.duration);
        }
        return this.aGx;
    }

    private aal<T> wI() {
        if (this.aGy == null) {
            this.aGy = new aak(this.aGw.mo776i(false, false), this.duration);
        }
        return this.aGy;
    }
}
