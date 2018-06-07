package com.fossil;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.ViewGroup;

@TargetApi(14)
class ds extends cy implements dt {

    static class C3159a extends dw {
        private du Hb;

        C3159a(du duVar) {
            this.Hb = duVar;
        }

        public void mo1864a(dn dnVar) {
            this.Hb.mo1117a(dnVar);
        }

        public void mo1866b(dn dnVar) {
            this.Hb.mo1118b(dnVar);
        }

        public Animator mo1907a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
            return this.Hb.mo1116a(viewGroup, dnVar, dnVar2);
        }

        public boolean mo2676d(dn dnVar) {
            return this.Hb.mo1991d(dnVar);
        }

        public Animator mo2020a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
            return this.Hb.mo1989a(viewGroup, dnVar, i, dnVar2, i2);
        }

        public Animator mo2021b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
            return this.Hb.mo1990b(viewGroup, dnVar, i, dnVar2, i2);
        }
    }

    ds() {
    }

    public void mo1885a(da daVar, Object obj) {
        this.Ge = daVar;
        if (obj == null) {
            this.Gd = new C3159a((du) daVar);
        } else {
            this.Gd = (dw) obj;
        }
    }

    public boolean mo2017d(dn dnVar) {
        return ((dw) this.Gd).mo2676d(dnVar);
    }

    public Animator mo2015a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((dw) this.Gd).mo2020a(viewGroup, dnVar, i, dnVar2, i2);
    }

    public Animator mo2016b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((dw) this.Gd).mo2021b(viewGroup, dnVar, i, dnVar2, i2);
    }
}
