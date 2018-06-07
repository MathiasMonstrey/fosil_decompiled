package com.google.firebase.iid;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.fossil.cei;
import com.fossil.cep;
import com.fossil.cer;
import com.fossil.cew;
import com.misfit.frameworks.buttonservice.model.Alarm;

public class FirebaseInstanceIdService extends cei {
    private static Object bPD = new Object();
    private static boolean bPE = false;
    private boolean bPF = false;

    static class C4394a extends BroadcastReceiver {
        private static BroadcastReceiver receiver;
        private int bPG;

        private C4394a(int i) {
            this.bPG = i;
        }

        static synchronized void m14552D(Context context, int i) {
            synchronized (C4394a.class) {
                if (receiver == null) {
                    receiver = new C4394a(i);
                    context.getApplicationContext().registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C4394a.class) {
                if (receiver != this) {
                } else if (FirebaseInstanceIdService.bg(context)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                    }
                    context.getApplicationContext().unregisterReceiver(this);
                    receiver = null;
                    cew.Wk().d(context, FirebaseInstanceIdService.iQ(this.bPG));
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m14553a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
        r1 = bPD;
        monitor-enter(r1);
        r0 = bPE;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        r0 = r3.VY();
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r1 = com.fossil.cep.bpS;
        r0 = r0.fm(r1);
        if (r0 != 0) goto L_0x0022;
    L_0x0018:
        r0 = com.google.firebase.iid.FirebaseInstanceId.Wa();
        r0 = r0.Wg();
        if (r0 == 0) goto L_0x0008;
    L_0x0022:
        bf(r2);
        goto L_0x0008;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private final void m14554a(Intent intent, String str) {
        int i = 28800;
        boolean bg = bg(this);
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !bg) {
            i = 30;
        } else if (intExtra < 10) {
            i = 10;
        } else if (intExtra <= 28800) {
            i = intExtra;
        }
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(i).append("s").toString());
        synchronized (bPD) {
            ((AlarmManager) getSystemService(Alarm.TABLE_NAME)).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), cew.a(this, 0, iQ(i << 1), 134217728));
            bPE = true;
        }
        if (!bg) {
            if (this.bPF) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            C4394a.m14552D(this, i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m14555a(android.content.Intent r9, boolean r10, boolean r11) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = bPD;
        monitor-enter(r3);
        r0 = 0;
        bPE = r0;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r0 = com.fossil.cer.aK(r8);
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = com.google.firebase.iid.FirebaseInstanceId.VW();
        r3 = r0.VY();
        if (r3 == 0) goto L_0x0025;
    L_0x001d:
        r4 = com.fossil.cep.bpS;
        r4 = r3.fm(r4);
        if (r4 == 0) goto L_0x0063;
    L_0x0025:
        r1 = r0.VZ();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r1 == 0) goto L_0x0054;
    L_0x002b:
        r2 = r8.bPF;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r2 == 0) goto L_0x0036;
    L_0x002f:
        r2 = "FirebaseInstanceId";
        r4 = "get master token succeeded";
        android.util.Log.d(r2, r4);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
    L_0x0036:
        m14553a(r8, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r11 != 0) goto L_0x0047;
    L_0x003b:
        if (r3 == 0) goto L_0x0047;
    L_0x003d:
        if (r3 == 0) goto L_0x000f;
    L_0x003f:
        r0 = r3.bQu;	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        r0 = r1.equals(r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        if (r0 != 0) goto L_0x000f;
    L_0x0047:
        r8.MD();	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x004b:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m14554a(r9, r0);
        goto L_0x000f;
    L_0x0054:
        r0 = "returned token is null";
        r8.m14554a(r9, r0);	 Catch:{ IOException -> 0x004b, SecurityException -> 0x005a }
        goto L_0x000f;
    L_0x005a:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x000f;
    L_0x0063:
        r4 = com.google.firebase.iid.FirebaseInstanceId.Wa();
        r0 = r4.Wg();
        r3 = r0;
    L_0x006c:
        if (r3 == 0) goto L_0x00d4;
    L_0x006e:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0087;
    L_0x0078:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00b7 }
        switch(r7) {
            case 83: goto L_0x0090;
            case 84: goto L_0x0084;
            case 85: goto L_0x009a;
            default: goto L_0x0084;
        };
    L_0x0084:
        switch(r0) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00c1;
            default: goto L_0x0087;
        };
    L_0x0087:
        r4.fh(r3);
        r0 = r4.Wg();
        r3 = r0;
        goto L_0x006c;
    L_0x0090:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x0098:
        r0 = r1;
        goto L_0x0084;
    L_0x009a:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r5 == 0) goto L_0x0084;
    L_0x00a2:
        r0 = r2;
        goto L_0x0084;
    L_0x00a4:
        r0 = com.google.firebase.iid.FirebaseInstanceId.VW();	 Catch:{ IOException -> 0x00b7 }
        r0.fe(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.bPF;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00af:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00b7:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m14554a(r9, r0);
        goto L_0x000f;
    L_0x00c1:
        r0 = com.google.firebase.iid.FirebaseInstanceId.VW();	 Catch:{ IOException -> 0x00b7 }
        r0.ff(r6);	 Catch:{ IOException -> 0x00b7 }
        r0 = r8.bPF;	 Catch:{ IOException -> 0x00b7 }
        if (r0 == 0) goto L_0x0087;
    L_0x00cc:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0087;
    L_0x00d4:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean, boolean):void");
    }

    static void bf(Context context) {
        if (cer.aK(context) != null) {
            synchronized (bPD) {
                if (!bPE) {
                    cew.Wk().d(context, iQ(0));
                    bPE = true;
                }
            }
        }
    }

    private static boolean bg(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private final cep fg(String str) {
        if (str == null) {
            return cep.b(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return cep.b(this, bundle);
    }

    private static Intent iQ(int i) {
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return intent;
    }

    private static String m14556n(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    public void MD() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(android.content.Intent r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 1;
        r0 = r10.getAction();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = "";
    L_0x000a:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0093;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r2;
    L_0x0013:
        switch(r0) {
            case 0: goto L_0x009e;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = m14556n(r10);
        r2 = r9.fg(r0);
        r3 = "CMD";
        r3 = r10.getStringExtra(r3);
        r4 = r9.bPF;
        if (r4 == 0) goto L_0x0078;
    L_0x0028:
        r4 = "FirebaseInstanceId";
        r5 = r10.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = java.lang.String.valueOf(r0);
        r6 = r6.length();
        r6 = r6 + 18;
        r7 = java.lang.String.valueOf(r3);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = java.lang.String.valueOf(r5);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Service command ";
        r6 = r7.append(r6);
        r6 = r6.append(r0);
        r7 = " ";
        r6 = r6.append(r7);
        r6 = r6.append(r3);
        r7 = " ";
        r6 = r6.append(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
        android.util.Log.d(r4, r5);
    L_0x0078:
        r4 = "unregistered";
        r4 = r10.getStringExtra(r4);
        if (r4 == 0) goto L_0x00a2;
    L_0x0080:
        r1 = com.fossil.cep.We();
        if (r0 != 0) goto L_0x0088;
    L_0x0086:
        r0 = "";
    L_0x0088:
        r1.dE(r0);
        r0 = com.fossil.cep.Wf();
        r0.p(r10);
    L_0x0092:
        return;
    L_0x0093:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0012;
    L_0x009b:
        r0 = r1;
        goto L_0x0013;
    L_0x009e:
        r9.m14555a(r10, r1, r1);
        goto L_0x0092;
    L_0x00a2:
        r4 = "gcm.googleapis.com/refresh";
        r5 = "from";
        r5 = r10.getStringExtra(r5);
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x00bb;
    L_0x00b0:
        r2 = com.fossil.cep.We();
        r2.dE(r0);
        r9.m14555a(r10, r1, r8);
        goto L_0x0092;
    L_0x00bb:
        r4 = "RST";
        r4 = r4.equals(r3);
        if (r4 == 0) goto L_0x00ca;
    L_0x00c3:
        r2.MB();
        r9.m14555a(r10, r8, r8);
        goto L_0x0092;
    L_0x00ca:
        r4 = "RST_FULL";
        r4 = r4.equals(r3);
        if (r4 == 0) goto L_0x00ea;
    L_0x00d2:
        r0 = com.fossil.cep.We();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0092;
    L_0x00dc:
        r2.MB();
        r0 = com.fossil.cep.We();
        r0.ME();
        r9.m14555a(r10, r8, r8);
        goto L_0x0092;
    L_0x00ea:
        r2 = "SYNC";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00fd;
    L_0x00f2:
        r2 = com.fossil.cep.We();
        r2.dE(r0);
        r9.m14555a(r10, r1, r8);
        goto L_0x0092;
    L_0x00fd:
        r0 = "PING";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0092;
    L_0x0105:
        r0 = r10.getExtras();
        r1 = com.fossil.cer.aK(r9);
        if (r1 != 0) goto L_0x0118;
    L_0x010f:
        r0 = "FirebaseInstanceId";
        r1 = "Unable to respond to ping due to missing target package";
        android.util.Log.w(r0, r1);
        goto L_0x0092;
    L_0x0118:
        r2 = new android.content.Intent;
        r3 = "com.google.android.gcm.intent.SEND";
        r2.<init>(r3);
        r2.setPackage(r1);
        r2.putExtras(r0);
        com.fossil.cer.c(r9, r2);
        r0 = "google.to";
        r1 = "google.com/iid";
        r2.putExtra(r0, r1);
        r0 = "google.message_id";
        r1 = com.fossil.cer.Wi();
        r2.putExtra(r0, r1);
        r0 = "com.google.android.gtalkservice.permission.GTALK_SERVICE";
        r9.sendOrderedBroadcast(r2, r0);
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.handleIntent(android.content.Intent):void");
    }

    public final boolean m14557l(Intent intent) {
        this.bPF = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return false;
        }
        String n = m14556n(intent);
        if (this.bPF) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(n);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        fg(n);
        cep.Wf().p(intent);
        return true;
    }

    protected final Intent m14558m(Intent intent) {
        return (Intent) cew.Wk().bQr.poll();
    }
}
