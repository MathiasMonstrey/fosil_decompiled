package com.fossil;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class auz {
    private static final Object bhj = new Object();
    private static auz bhk;

    public static auz an(Context context) {
        synchronized (bhj) {
            if (bhk == null) {
                bhk = new avb(context.getApplicationContext());
            }
        }
        return bhk;
    }

    public final void m4580a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        mo1196b(new ava(str, str2), serviceConnection, str3);
    }

    protected abstract boolean mo1195a(ava com_fossil_ava, ServiceConnection serviceConnection, String str);

    protected abstract void mo1196b(ava com_fossil_ava, ServiceConnection serviceConnection, String str);
}
