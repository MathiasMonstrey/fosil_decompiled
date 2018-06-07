package com.fossil;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

@TargetApi(19)
class db extends cz {
    da Ge;
    Transition Gg;

    static class C2617a extends Transition {
        private da Gf;

        public C2617a(da daVar) {
            this.Gf = daVar;
        }

        public void captureStartValues(TransitionValues transitionValues) {
            db.m7171a(this.Gf, transitionValues);
        }

        public void captureEndValues(TransitionValues transitionValues) {
            db.m7173b(this.Gf, transitionValues);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.Gf.mo1116a(viewGroup, db.m7169a(transitionValues), db.m7169a(transitionValues2));
        }
    }

    db() {
    }

    static void m7170a(TransitionValues transitionValues, dn dnVar) {
        if (transitionValues != null) {
            dnVar.view = transitionValues.view;
            if (transitionValues.values.size() > 0) {
                dnVar.values.putAll(transitionValues.values);
            }
        }
    }

    static void m7172a(dn dnVar, TransitionValues transitionValues) {
        if (dnVar != null) {
            transitionValues.view = dnVar.view;
            if (dnVar.values.size() > 0) {
                transitionValues.values.putAll(dnVar.values);
            }
        }
    }

    static void m7171a(da daVar, TransitionValues transitionValues) {
        dn dnVar = new dn();
        m7170a(transitionValues, dnVar);
        daVar.mo1117a(dnVar);
        m7172a(dnVar, transitionValues);
    }

    static void m7173b(da daVar, TransitionValues transitionValues) {
        dn dnVar = new dn();
        m7170a(transitionValues, dnVar);
        daVar.mo1118b(dnVar);
        m7172a(dnVar, transitionValues);
    }

    static dn m7169a(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        dn dnVar = new dn();
        m7170a(transitionValues, dnVar);
        return dnVar;
    }

    static TransitionValues m7174e(dn dnVar) {
        if (dnVar == null) {
            return null;
        }
        TransitionValues transitionValues = new TransitionValues();
        m7172a(dnVar, transitionValues);
        return transitionValues;
    }

    public void mo1885a(da daVar, Object obj) {
        this.Ge = daVar;
        if (obj == null) {
            this.Gg = new C2617a(daVar);
        } else {
            this.Gg = (Transition) obj;
        }
    }

    public void mo1888b(dn dnVar) {
        TransitionValues transitionValues = new TransitionValues();
        m7172a(dnVar, transitionValues);
        this.Gg.captureEndValues(transitionValues);
        m7170a(transitionValues, dnVar);
    }

    public void mo1886a(dn dnVar) {
        TransitionValues transitionValues = new TransitionValues();
        m7172a(dnVar, transitionValues);
        this.Gg.captureStartValues(transitionValues);
        m7170a(transitionValues, dnVar);
    }

    public Animator mo1884a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        TransitionValues transitionValues;
        TransitionValues transitionValues2 = null;
        if (dnVar != null) {
            transitionValues = new TransitionValues();
            m7172a(dnVar, transitionValues);
        } else {
            transitionValues = null;
        }
        if (dnVar2 != null) {
            transitionValues2 = new TransitionValues();
            m7172a(dnVar2, transitionValues2);
        }
        return this.Gg.createAnimator(viewGroup, transitionValues, transitionValues2);
    }

    public cz mo1889j(long j) {
        this.Gg.setDuration(j);
        return this;
    }

    public cz mo1887b(TimeInterpolator timeInterpolator) {
        this.Gg.setInterpolator(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.Gg.toString();
    }
}
