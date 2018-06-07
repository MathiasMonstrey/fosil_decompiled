package com.fossil;

import android.view.View;
import android.view.ViewGroup;

public class ky {
    private final ViewGroup RG;
    private int RH;

    public ky(ViewGroup viewGroup) {
        this.RG = viewGroup;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.RH = i;
    }

    public int getNestedScrollAxes() {
        return this.RH;
    }

    public void onStopNestedScroll(View view) {
        this.RH = 0;
    }
}
