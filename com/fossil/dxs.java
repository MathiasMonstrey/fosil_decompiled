package com.fossil;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

final class dxs extends dxu {
    public dxs(Context context) {
        super(context);
    }

    protected final String HI() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.baD).getString(dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }

    protected final boolean Ja() {
        return true;
    }

    protected final void cg(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.baD).edit();
            edit.putString(dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }
}
