package com.fossil;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public final class bcg {
    private static final AtomicReference<bcg> bqe = new AtomicReference();

    private bcg(Context context) {
    }

    public static void m4833a(cef com_fossil_cef) {
    }

    public static bcg aL(Context context) {
        bqe.compareAndSet(null, new bcg(context));
        return (bcg) bqe.get();
    }
}
