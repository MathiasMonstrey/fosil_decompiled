package com.fossil;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.ViewGroup;

@TargetApi(19)
class dv extends db implements dt {

    static class C3218a extends Visibility {
        private final du Hb;

        C3218a(du duVar) {
            this.Hb = duVar;
        }

        public void captureStartValues(TransitionValues transitionValues) {
            db.m7171a(this.Hb, transitionValues);
        }

        public void captureEndValues(TransitionValues transitionValues) {
            db.m7173b(this.Hb, transitionValues);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.Hb.mo1116a(viewGroup, db.m7169a(transitionValues), db.m7169a(transitionValues2));
        }

        public boolean isVisible(TransitionValues transitionValues) {
            if (transitionValues == null) {
                return false;
            }
            dn dnVar = new dn();
            db.m7170a(transitionValues, dnVar);
            return this.Hb.mo1991d(dnVar);
        }

        public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.Hb.mo1989a(viewGroup, db.m7169a(transitionValues), i, db.m7169a(transitionValues2), i2);
        }

        public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.Hb.mo1990b(viewGroup, db.m7169a(transitionValues), i, db.m7169a(transitionValues2), i2);
        }
    }

    dv() {
    }

    public void mo1885a(da daVar, Object obj) {
        this.Ge = daVar;
        if (obj == null) {
            this.Gg = new C3218a((du) daVar);
        } else {
            this.Gg = (Visibility) obj;
        }
    }

    public boolean mo2017d(dn dnVar) {
        return ((Visibility) this.Gg).isVisible(db.m7174e(dnVar));
    }

    public Animator mo2015a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((Visibility) this.Gg).onAppear(viewGroup, db.m7174e(dnVar), i, db.m7174e(dnVar2), i2);
    }

    public Animator mo2016b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((Visibility) this.Gg).onDisappear(viewGroup, db.m7174e(dnVar), i, db.m7174e(dnVar2), i2);
    }
}
