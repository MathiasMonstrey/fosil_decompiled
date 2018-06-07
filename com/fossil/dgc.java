package com.fossil;

import android.util.Log;
import com.fossil.dfy.C2737a;
import com.fossil.dfy.C2738b;

public class dgc implements C2737a {
    private static final String TAG = dgc.class.getSimpleName();
    private final C2738b cTs;

    dgc(C2738b c2738b, ckc com_fossil_ckc) {
        this.cTs = (C2738b) cco.m5996s(c2738b, "view cannot be nulL!");
    }

    public void ahu() {
        this.cTs.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }
}
