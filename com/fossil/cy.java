package com.fossil;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.ViewGroup;

@TargetApi(14)
class cy extends cz {
    dh Gd;
    da Ge;

    static class C2498a extends dh {
        private da Gf;

        public C2498a(da daVar) {
            this.Gf = daVar;
        }

        public void mo1864a(dn dnVar) {
            this.Gf.mo1117a(dnVar);
        }

        public void mo1866b(dn dnVar) {
            this.Gf.mo1118b(dnVar);
        }

        public Animator mo1907a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
            return this.Gf.mo1116a(viewGroup, dnVar, dnVar2);
        }
    }

    cy() {
    }

    public void mo1885a(da daVar, Object obj) {
        this.Ge = daVar;
        if (obj == null) {
            this.Gd = new C2498a(daVar);
        } else {
            this.Gd = (dh) obj;
        }
    }

    public void mo1888b(dn dnVar) {
        this.Gd.mo1866b(dnVar);
    }

    public void mo1886a(dn dnVar) {
        this.Gd.mo1864a(dnVar);
    }

    public Animator mo1884a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        return this.Gd.mo1907a(viewGroup, dnVar, dnVar2);
    }

    public cz mo1889j(long j) {
        this.Gd.mo1871k(j);
        return this;
    }

    public cz mo1887b(TimeInterpolator timeInterpolator) {
        this.Gd.mo1867c(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.Gd.toString();
    }
}
