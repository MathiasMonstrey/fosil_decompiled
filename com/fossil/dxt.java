package com.fossil;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

public final class dxt extends dxu {
    public dxt(Context context) {
        super(context);
    }

    protected final String HI() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = System.getString(this.baD.getContentResolver(), dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }

    protected final boolean Ja() {
        return dxw.m10271l(this.baD, "android.permission.WRITE_SETTINGS");
    }

    protected final void cg(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            System.putString(this.baD.getContentResolver(), dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }
}
