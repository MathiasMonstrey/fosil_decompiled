package com.fossil;

import android.os.Looper;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class bgp {
    private final Set<bgl<?>> buC = Collections.newSetFromMap(new WeakHashMap());

    public static <L> bgl<L> m5140a(L l, Looper looper, String str) {
        awa.m4640p(l, "Listener must not be null");
        awa.m4640p(looper, "Looper must not be null");
        awa.m4640p(str, "Listener type must not be null");
        return new bgl(looper, l, str);
    }

    public static <L> bgn<L> m5141d(L l, String str) {
        awa.m4640p(l, "Listener must not be null");
        awa.m4640p(str, "Listener type must not be null");
        awa.m4639c(str, "Listener type must not be empty");
        return new bgn(l, str);
    }

    public final void release() {
        for (bgl clear : this.buC) {
            clear.clear();
        }
        this.buC.clear();
    }
}
