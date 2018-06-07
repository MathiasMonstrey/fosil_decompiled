package com.fossil;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;

public final class axh {
    private static final Object bhj = new Object();
    private static volatile axh biT;
    private final List<String> biU = Collections.EMPTY_LIST;
    private final List<String> biV = Collections.EMPTY_LIST;
    private final List<String> biW = Collections.EMPTY_LIST;
    private final List<String> biX = Collections.EMPTY_LIST;

    private axh() {
    }

    public static axh LD() {
        if (biT == null) {
            synchronized (bhj) {
                if (biT == null) {
                    biT = new axh();
                }
            }
        }
        return biT;
    }

    @SuppressLint({"UntrackedBindService"})
    public static boolean m4676a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : axl.m4684n(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public final boolean m4677a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m4676a(context, context.getClass().getName(), intent, serviceConnection, i);
    }
}
