package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fossil.dyc.C3292a;

final class dyd implements C3292a {
    private Handler handler = new Handler(Looper.getMainLooper());

    dyd() {
    }

    public final int Ov() {
        return dyc.level;
    }

    public final void bf(String str, String str2) {
        if (dyc.level <= 1) {
            Log.d(str, str2);
        }
    }

    public final void bg(String str, String str2) {
        if (dyc.level <= 3) {
            Log.w(str, str2);
        }
    }

    public final void mo2780f(String str, String str2) {
        if (dyc.level <= 2) {
            Log.i(str, str2);
        }
    }

    public final void mo2781i(String str, String str2) {
        if (dyc.level <= 4) {
            Log.e(str, str2);
        }
    }
}
