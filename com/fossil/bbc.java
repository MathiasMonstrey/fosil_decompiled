package com.fossil;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class bbc implements Callable<Boolean> {
    private /* synthetic */ SharedPreferences boO;
    private /* synthetic */ String boP;
    private /* synthetic */ Boolean boQ;

    bbc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.boO = sharedPreferences;
        this.boP = str;
        this.boQ = bool;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.boO.getBoolean(this.boP, this.boQ.booleanValue()));
    }
}
