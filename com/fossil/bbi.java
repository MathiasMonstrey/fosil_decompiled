package com.fossil;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class bbi implements Callable<String> {
    private /* synthetic */ SharedPreferences boO;
    private /* synthetic */ String boP;
    private /* synthetic */ String boT;

    bbi(SharedPreferences sharedPreferences, String str, String str2) {
        this.boO = sharedPreferences;
        this.boP = str;
        this.boT = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.boO.getString(this.boP, this.boT);
    }
}
