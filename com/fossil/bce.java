package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class bce {
    private Context bqb;
    private SharedPreferences bqd;

    public bce(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private bce(Context context, String str) {
        this.bqb = context;
        this.bqd = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        File file = new File(axx.aw(this.bqb), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    bbz.m4824a(this.bqb, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    valueOf = "InstanceID/Store";
                    String str2 = "Error creating file in no backup dir: ";
                    valueOf2 = String.valueOf(e.getMessage());
                    Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
            }
        }
    }

    public final synchronized void ME() {
        this.bqd.edit().clear().commit();
    }

    public final synchronized void dD(String str) {
        Editor edit = this.bqd.edit();
        for (String str2 : this.bqd.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public final void dE(String str) {
        dD(String.valueOf(str).concat("|T|"));
    }

    public final boolean isEmpty() {
        return this.bqd.getAll().isEmpty();
    }
}
