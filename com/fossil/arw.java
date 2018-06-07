package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class arw {
    private aya bdM;
    private bum bdN;
    private boolean bdO;
    private Object bdP = new Object();
    private C1878b bdQ;
    private long bdR;
    private final Context mContext;

    public static final class C1877a {
        private final String bdS;
        private final boolean bdT;

        public C1877a(String str, boolean z) {
            this.bdS = str;
            this.bdT = z;
        }

        public final boolean JI() {
            return this.bdT;
        }

        public final String getId() {
            return this.bdS;
        }

        public final String toString() {
            String str = this.bdS;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.bdT).toString();
        }
    }

    static class C1878b extends Thread {
        private WeakReference<arw> bdU;
        private long bdV;
        CountDownLatch bdW = new CountDownLatch(1);
        boolean bdX = false;

        public C1878b(arw com_fossil_arw, long j) {
            this.bdU = new WeakReference(com_fossil_arw);
            this.bdV = j;
            start();
        }

        private final void disconnect() {
            arw com_fossil_arw = (arw) this.bdU.get();
            if (com_fossil_arw != null) {
                com_fossil_arw.finish();
                this.bdX = true;
            }
        }

        public final void run() {
            try {
                if (!this.bdW.await(this.bdV, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public arw(Context context, long j, boolean z) {
        awa.bO(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        } else {
            this.mContext = context;
        }
        this.bdO = false;
        this.bdR = j;
    }

    private final void JG() {
        synchronized (this.bdP) {
            if (this.bdQ != null) {
                this.bdQ.bdW.countDown();
                try {
                    this.bdQ.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.bdR > 0) {
                this.bdQ = new C1878b(this, this.bdR);
            }
        }
    }

    private static bum m4342a(Context context, aya com_fossil_aya) throws IOException {
        try {
            return bun.m5691m(com_fossil_aya.m4693b(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private final void m4343a(C1877a c1877a, boolean z, float f, Throwable th) {
        if (Math.random() <= ((double) f)) {
            Bundle bundle = new Bundle();
            bundle.putString("app_context", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (c1877a != null) {
                bundle.putString("limit_ad_tracking", c1877a.JI() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            if (!(c1877a == null || c1877a.getId() == null)) {
                bundle.putString("ad_id_size", Integer.toString(c1877a.getId().length()));
            }
            if (th != null) {
                bundle.putString("error", th.getClass().getName());
            }
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
            for (String str : bundle.keySet()) {
                buildUpon.appendQueryParameter(str, bundle.getString(str));
            }
            new arx(this, buildUpon.build().toString()).start();
        }
    }

    private final void aU(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        awa.dh("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.bdO) {
                finish();
            }
            this.bdM = af(this.mContext);
            this.bdN = m4342a(this.mContext, this.bdM);
            this.bdO = true;
            if (z) {
                JG();
            }
        }
    }

    public static void aV(boolean z) {
    }

    private static aya af(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (aye.LN().aj(context)) {
                case 0:
                case 2:
                    Object com_fossil_aya = new aya();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (axh.LD().m4677a(context, intent, com_fossil_aya, 1)) {
                            return com_fossil_aya;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static C1877a ag(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        float f = 0.0f;
        boolean z = false;
        try {
            Context am = ayo.am(context);
            if (am != null) {
                SharedPreferences sharedPreferences = am.getSharedPreferences("google_ads_flags", 0);
                z = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", false);
                f = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
            }
        } catch (Throwable e) {
            Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
        }
        arw com_fossil_arw = new arw(context, -1, z);
        C1877a JH;
        try {
            com_fossil_arw.aU(false);
            JH = com_fossil_arw.JH();
            com_fossil_arw.m4343a(JH, z, f, null);
            return JH;
        } catch (Throwable th) {
            JH = th;
            com_fossil_arw.m4343a(null, z, f, JH);
            return null;
        } finally {
            com_fossil_arw.finish();
        }
    }

    public C1877a JH() throws IOException {
        C1877a c1877a;
        awa.dh("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.bdO) {
                synchronized (this.bdP) {
                    if (this.bdQ == null || !this.bdQ.bdX) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    aU(false);
                    if (!this.bdO) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            awa.bO(this.bdM);
            awa.bO(this.bdN);
            c1877a = new C1877a(this.bdN.getId(), this.bdN.bj(true));
        }
        JG();
        return c1877a;
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.fossil.awa.dh(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.bdM;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.bdO;	 Catch:{ IllegalArgumentException -> 0x002c, Throwable -> 0x0035 }
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        com.fossil.axh.LD();	 Catch:{ IllegalArgumentException -> 0x002c, Throwable -> 0x0035 }
        r0 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002c, Throwable -> 0x0035 }
        r1 = r3.bdM;	 Catch:{ IllegalArgumentException -> 0x002c, Throwable -> 0x0035 }
        r0.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x002c, Throwable -> 0x0035 }
    L_0x001e:
        r0 = 0;
        r3.bdO = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r3.bdN = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r3.bdM = r0;	 Catch:{ all -> 0x0029 }
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        goto L_0x000f;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0029 }
        goto L_0x001e;
    L_0x0035:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0029 }
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.arw.finish():void");
    }
}
