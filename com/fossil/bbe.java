package com.fossil;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class bbe implements Callable<Integer> {
    private /* synthetic */ SharedPreferences boO;
    private /* synthetic */ String boP;
    private /* synthetic */ Integer boR;

    bbe(SharedPreferences sharedPreferences, String str, Integer num) {
        this.boO = sharedPreferences;
        this.boP = str;
        this.boR = num;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.boO.getInt(this.boP, this.boR.intValue()));
    }
}
