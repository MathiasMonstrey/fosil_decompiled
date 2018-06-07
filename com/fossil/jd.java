package com.fossil;

import android.annotation.TargetApi;
import android.os.Trace;

@TargetApi(18)
class jd {
    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
