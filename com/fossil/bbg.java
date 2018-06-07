package com.fossil;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class bbg implements Callable<Long> {
    private /* synthetic */ SharedPreferences boO;
    private /* synthetic */ String boP;
    private /* synthetic */ Long boS;

    bbg(SharedPreferences sharedPreferences, String str, Long l) {
        this.boO = sharedPreferences;
        this.boP = str;
        this.boS = l;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Long.valueOf(this.boO.getLong(this.boP, this.boS.longValue()));
    }
}
