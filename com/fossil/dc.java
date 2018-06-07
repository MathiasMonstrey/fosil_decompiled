package com.fossil;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class dc {
    private static df Gh;

    static {
        if (VERSION.SDK_INT < 19) {
            Gh = new de();
        } else {
            Gh = new dg();
        }
    }

    public static void m8198a(ViewGroup viewGroup, cw cwVar) {
        Gh.mo2330a(viewGroup, cwVar == null ? null : cwVar.Gc);
    }
}
