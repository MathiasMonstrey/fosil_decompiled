package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class ayw implements aza {
    private /* synthetic */ ays bjH;
    private /* synthetic */ Bundle bjJ;
    private /* synthetic */ FrameLayout bjK;
    private /* synthetic */ LayoutInflater bjL;
    private /* synthetic */ ViewGroup bjM;

    ayw(ays com_fossil_ays, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bjH = com_fossil_ays;
        this.bjK = frameLayout;
        this.bjL = layoutInflater;
        this.bjM = viewGroup;
        this.bjJ = bundle;
    }

    public final void mo1220b(ayr com_fossil_ayr) {
        this.bjK.removeAllViews();
        this.bjK.addView(this.bjH.bjD.onCreateView(this.bjL, this.bjM, this.bjJ));
    }

    public final int getState() {
        return 2;
    }
}
