package com.portfolio.platform.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

public class CustomGridLayoutManager extends LinearLayoutManager {
    private boolean diu = true;

    public CustomGridLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public boolean pf() {
        return this.diu && super.pf();
    }

    public boolean pe() {
        return this.diu && super.pe();
    }
}
