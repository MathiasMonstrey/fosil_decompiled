package com.fossil;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

final class ayf {
    private static avr bjl;
    private static final Object bjm = new Object();
    private static Context bjn;

    private static boolean LO() {
        boolean z = true;
        if (bjl == null) {
            awa.bO(bjn);
            synchronized (bjm) {
                if (bjl == null) {
                    try {
                        bjl = avs.m4602h(DynamiteModule.a(bjn, DynamiteModule.bkb, "com.google.android.gms.googlecertificates").dm("com.google.android.gms.common.GoogleCertificatesImpl"));
                    } catch (Throwable e) {
                        Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    static boolean m4694a(String str, ayg com_fossil_ayg) {
        return m4695a(str, com_fossil_ayg, false);
    }

    private static boolean m4695a(String str, ayg com_fossil_ayg, boolean z) {
        boolean z2 = false;
        if (LO()) {
            awa.bO(bjn);
            try {
                z2 = bjl.mo1202a(new aym(str, com_fossil_ayg, z), azc.bQ(bjn.getPackageManager()));
            } catch (Throwable e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return z2;
    }

    static synchronized void ay(Context context) {
        synchronized (ayf.class) {
            if (bjn != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                bjn = context.getApplicationContext();
            }
        }
    }

    static boolean m4696b(String str, ayg com_fossil_ayg) {
        return m4695a(str, com_fossil_ayg, true);
    }
}
