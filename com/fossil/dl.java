package com.fossil;

import android.annotation.TargetApi;
import android.transition.TransitionSet;

@TargetApi(19)
class dl extends db implements dk {
    private TransitionSet GM = new TransitionSet();

    public /* synthetic */ dk ax(int i) {
        return ay(i);
    }

    public /* synthetic */ dk mo2509b(cz czVar) {
        return m8952c(czVar);
    }

    public dl(da daVar) {
        mo1885a(daVar, (Object) this.GM);
    }

    public dl ay(int i) {
        this.GM.setOrdering(i);
        return this;
    }

    public dl m8952c(cz czVar) {
        this.GM.addTransition(((db) czVar).Gg);
        return this;
    }
}
