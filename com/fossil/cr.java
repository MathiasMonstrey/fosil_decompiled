package com.fossil;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.transition.Fade;
import android.view.ViewGroup;

@TargetApi(19)
class cr extends db implements dt {
    public cr(da daVar) {
        mo1885a(daVar, (Object) new Fade());
    }

    public cr(da daVar, int i) {
        mo1885a(daVar, (Object) new Fade(i));
    }

    public boolean mo2017d(dn dnVar) {
        return ((Fade) this.Gg).isVisible(db.m7174e(dnVar));
    }

    public Animator mo2015a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((Fade) this.Gg).onAppear(viewGroup, db.m7174e(dnVar), i, db.m7174e(dnVar2), i2);
    }

    public Animator mo2016b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return ((Fade) this.Gg).onDisappear(viewGroup, db.m7174e(dnVar), i, db.m7174e(dnVar2), i2);
    }
}
