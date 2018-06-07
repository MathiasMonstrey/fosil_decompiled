package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class epc implements epb {
    private final Context context;
    private final String dPM;
    private final SharedPreferences sharedPreferences;

    public epc(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.context = context;
        this.dPM = str;
        this.sharedPreferences = this.context.getSharedPreferences(this.dPM, 0);
    }

    public epc(emr com_fossil_emr) {
        this(com_fossil_emr.getContext(), com_fossil_emr.getClass().getName());
    }

    public SharedPreferences aGu() {
        return this.sharedPreferences;
    }

    public Editor edit() {
        return this.sharedPreferences.edit();
    }

    @TargetApi(9)
    public boolean mo2992b(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
