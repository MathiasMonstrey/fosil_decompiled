package com.fossil;

import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import java.util.List;

public abstract class eve<T> {
    private T dWu;

    public abstract boolean shouldShowRequestPermissionRationale(String str);

    public static eve m11258v(Fragment fragment) {
        if (VERSION.SDK_INT < 23) {
            return new evd(fragment);
        }
        return new evf(fragment);
    }

    public eve(T t) {
        this.dWu = t;
    }

    public boolean aL(List<String> list) {
        for (String mV : list) {
            if (mV(mV)) {
                return true;
            }
        }
        return false;
    }

    public boolean mV(String str) {
        return !shouldShowRequestPermissionRationale(str);
    }

    public T getHost() {
        return this.dWu;
    }
}
