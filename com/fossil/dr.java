package com.fossil;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public abstract class dr extends cw implements du {
    dr(boolean z) {
        super(true);
        if (!z) {
            if (VERSION.SDK_INT >= 19) {
                this.Gc = new dv();
            } else {
                this.Gc = new ds();
            }
            this.Gc.m7049a((da) this);
        }
    }

    public void mo1118b(dn dnVar) {
        this.Gc.mo1888b(dnVar);
    }

    public void mo1117a(dn dnVar) {
        this.Gc.mo1886a(dnVar);
    }

    public boolean mo1991d(dn dnVar) {
        return ((dt) this.Gc).mo2017d(dnVar);
    }

    public Animator mo1989a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((dt) this.Gc).mo2015a(viewGroup, dnVar, i, dnVar2, i2);
    }

    public Animator mo1990b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((dt) this.Gc).mo2016b(viewGroup, dnVar, i, dnVar2, i2);
    }
}
