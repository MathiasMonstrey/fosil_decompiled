package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class bbk implements Callable<SharedPreferences> {
    private /* synthetic */ Context bjN;

    bbk(Context context) {
        this.bjN = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.bjN.getSharedPreferences("google_sdk_flags", 0);
    }
}
