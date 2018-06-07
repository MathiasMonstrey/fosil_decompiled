package com.fossil;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.ViewGroup;

@TargetApi(14)
class cq extends cy implements dt {
    public cq(da daVar) {
        mo1885a(daVar, new cs());
    }

    public cq(da daVar, int i) {
        mo1885a(daVar, new cs(i));
    }

    public boolean mo2017d(dn dnVar) {
        return ((cs) this.Gd).mo2676d(dnVar);
    }

    public Animator mo2015a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((cs) this.Gd).mo2020a(viewGroup, dnVar, i, dnVar2, i2);
    }

    public Animator mo2016b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((cs) this.Gd).mo2021b(viewGroup, dnVar, i, dnVar, i);
    }
}
