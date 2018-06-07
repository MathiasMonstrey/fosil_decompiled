package com.fossil;

import android.annotation.TargetApi;
import android.os.CancellationSignal;

@TargetApi(16)
class iv {
    public static Object jk() {
        return new CancellationSignal();
    }

    public static void aa(Object obj) {
        ((CancellationSignal) obj).cancel();
    }
}
