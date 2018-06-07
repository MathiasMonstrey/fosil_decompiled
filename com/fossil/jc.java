package com.fossil;

import android.os.Build.VERSION;

public final class jc {
    public static void beginSection(String str) {
        if (VERSION.SDK_INT >= 18) {
            jd.beginSection(str);
        }
    }

    public static void endSection() {
        if (VERSION.SDK_INT >= 18) {
            jd.endSection();
        }
    }
}
