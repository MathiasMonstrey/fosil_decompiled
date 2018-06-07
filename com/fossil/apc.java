package com.fossil;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

public class apc {
    private static boolean aWH = false;
    private static final String aWX = apc.class.getSimpleName();
    private static apc baC;
    public final Context baD;
    public final Handler baE = new Handler(Looper.getMainLooper());
    public final Handler baF;
    private final HandlerThread baG = new HandlerThread("FlurryAgent");
    private final apr baH;
    public final String f1440d;

    private apc(Context context, String str) {
        this.baD = context.getApplicationContext();
        this.baG.start();
        this.baF = new Handler(this.baG.getLooper());
        this.f1440d = str;
        this.baH = new apr();
    }

    public static apc IO() {
        return baC;
    }

    public static synchronized void m4156k(Context context, String str) {
        synchronized (apc.class) {
            if (baC != null) {
                if (baC.f1440d.equals(str)) {
                    app.m4178e(aWX, "Flurry is already initialized");
                } else {
                    throw new IllegalStateException("Only one API key per application is supported!");
                }
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("API key must be specified");
            } else {
                apc com_fossil_apc = new apc(context, str);
                baC = com_fossil_apc;
                com_fossil_apc.baH.m4186a(context);
            }
        }
    }

    public final void m4158a(Runnable runnable) {
        this.baE.post(runnable);
    }

    public final void m4160b(Runnable runnable) {
        this.baF.post(runnable);
    }

    public final void m4159a(Runnable runnable, long j) {
        if (runnable != null) {
            this.baF.postDelayed(runnable, j);
        }
    }

    public final aps m4157H(Class<? extends aps> cls) {
        return this.baH.m4185J(cls);
    }

    public static synchronized void m4155a(boolean z) {
        synchronized (apc.class) {
            aWH = z;
        }
    }

    public static synchronized boolean Ie() {
        boolean z;
        synchronized (apc.class) {
            z = aWH;
        }
        return z;
    }
}
