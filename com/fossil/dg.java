package com.fossil;

import android.annotation.TargetApi;
import android.transition.TransitionManager;
import android.view.ViewGroup;

@TargetApi(19)
class dg extends df {
    dg() {
    }

    public void mo2330a(ViewGroup viewGroup, cz czVar) {
        TransitionManager.beginDelayedTransition(viewGroup, czVar == null ? null : ((db) czVar).Gg);
    }
}
