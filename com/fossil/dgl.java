package com.fossil;

import android.util.Log;
import com.fossil.dgh.C2739a;
import com.fossil.dgh.C2740b;

public class dgl implements C2739a {
    private static final String TAG = dgl.class.getSimpleName();
    private final C2740b cTD;
    private cnr mSharedPreferencesManager;

    dgl(C2740b c2740b, ckc com_fossil_ckc, cnr com_fossil_cnr) {
        this.cTD = (C2740b) cco.m5996s(c2740b, "view cannot be nulL!");
        this.mSharedPreferencesManager = (cnr) cco.m5996s(com_fossil_cnr, "view cannot be nulL!");
    }

    public void ahu() {
        this.cTD.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }

    public void anV() {
        this.mSharedPreferencesManager.adp();
    }
}
