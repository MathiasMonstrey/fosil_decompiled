package com.fossil;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class nv {
    public static void m12828a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            nx.m12830a(listView, i);
        } else {
            nw.m12829a(listView, i);
        }
    }
}
