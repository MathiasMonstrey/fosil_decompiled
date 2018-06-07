package com.fossil;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Random;

public final class cer {
    private static PendingIntent bQf;
    private static String bpV = null;
    private static boolean bpW = false;
    private static int bpX = 0;
    private static int bpY = 0;
    private static int bpZ = 0;
    private static BroadcastReceiver bqa = null;
    private final jv<String, cev> bQb = new jv();
    private Messenger bQc;
    private Messenger bQd;
    private MessengerCompat bQe;
    private long bQg;
    private long bQh;
    private int bQi;
    private int bQj;
    private long bQk;
    private Context bqb;

    public cer(Context context) {
        this.bqb = context;
    }

    private final void Wh() {
        if (this.bQc == null) {
            aK(this.bqb);
            this.bQc = new Messenger(new ces(this, Looper.getMainLooper()));
        }
    }

    public static synchronized String Wi() {
        String num;
        synchronized (cer.class) {
            int i = bpZ;
            bpZ = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static String m6106a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.am(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private final void m6107a(String str, Intent intent) {
        synchronized (this.bQb) {
            cev com_fossil_cev = (cev) this.bQb.remove(str);
            if (com_fossil_cev == null) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            com_fossil_cev.mo1655q(intent);
        }
    }

    private static boolean m6108a(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (m6110a(packageManager, resolveInfo.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                bpW = true;
                return true;
            }
        }
        return false;
    }

    private static boolean m6109a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            bpV = applicationInfo.packageName;
            bpY = applicationInfo.uid;
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean m6110a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return m6109a(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    public static String aK(Context context) {
        if (bpV != null) {
            return bpV;
        }
        bpX = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!axt.LK()) {
            boolean z;
            for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
                if (m6110a(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    bpW = false;
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return bpV;
            }
        }
        if (m6108a(packageManager)) {
            return bpV;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (m6109a(packageManager, "com.google.android.gms")) {
            bpW = axt.LK();
            return bpV;
        } else if (axt.LJ() || !m6109a(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            bpW = false;
            return bpV;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void ah(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r2 = r5.bQb;
        monitor-enter(r2);
        if (r6 != 0) goto L_0x0025;
    L_0x0005:
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r0 = r5.bQb;	 Catch:{ all -> 0x0046 }
        r0 = r0.size();	 Catch:{ all -> 0x0046 }
        if (r1 >= r0) goto L_0x001e;
    L_0x000f:
        r0 = r5.bQb;	 Catch:{ all -> 0x0046 }
        r0 = r0.valueAt(r1);	 Catch:{ all -> 0x0046 }
        r0 = (com.fossil.cev) r0;	 Catch:{ all -> 0x0046 }
        r0.onError(r7);	 Catch:{ all -> 0x0046 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0007;
    L_0x001e:
        r0 = r5.bQb;	 Catch:{ all -> 0x0046 }
        r0.clear();	 Catch:{ all -> 0x0046 }
    L_0x0023:
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
    L_0x0024:
        return;
    L_0x0025:
        r0 = r5.bQb;	 Catch:{ all -> 0x0046 }
        r0 = r0.remove(r6);	 Catch:{ all -> 0x0046 }
        r0 = (com.fossil.cev) r0;	 Catch:{ all -> 0x0046 }
        if (r0 != 0) goto L_0x004f;
    L_0x002f:
        r1 = "InstanceID/Rpc";
        r3 = "Missing callback for ";
        r0 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x0046 }
        r4 = r0.length();	 Catch:{ all -> 0x0046 }
        if (r4 == 0) goto L_0x0049;
    L_0x003d:
        r0 = r3.concat(r0);	 Catch:{ all -> 0x0046 }
    L_0x0041:
        android.util.Log.w(r1, r0);	 Catch:{ all -> 0x0046 }
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        goto L_0x0024;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0046 }
        throw r0;
    L_0x0049:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0046 }
        r0.<init>(r3);	 Catch:{ all -> 0x0046 }
        goto L_0x0041;
    L_0x004f:
        r0.onError(r7);	 Catch:{ all -> 0x0046 }
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cer.ah(java.lang.String, java.lang.String):void");
    }

    private final Intent m6111b(Bundle bundle, KeyPair keyPair) throws IOException {
        String Wi = Wi();
        ceu com_fossil_ceu = new ceu();
        synchronized (this.bQb) {
            this.bQb.put(Wi, com_fossil_ceu);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.bQk == 0 || elapsedRealtime > this.bQk) {
            Wh();
            if (bpV == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.bQg = SystemClock.elapsedRealtime();
            Intent intent = new Intent(bpW ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(bpV);
            bundle.putString("gmsv", Integer.toString(FirebaseInstanceId.m12669w(this.bqb, aK(this.bqb))));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.bb(this.bqb)));
            bundle.putString("app_ver_name", FirebaseInstanceId.bc(this.bqb));
            bundle.putString("cliv", "fiid-11020000");
            bundle.putString("appid", FirebaseInstanceId.m12667a(keyPair));
            bundle.putString("pub2", FirebaseInstanceId.am(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", m6106a(keyPair, this.bqb.getPackageName(), r0));
            intent.putExtras(bundle);
            m6112c(this.bqb, intent);
            this.bQg = SystemClock.elapsedRealtime();
            intent.putExtra("kid", new StringBuilder(String.valueOf(Wi).length() + 5).append("|ID|").append(Wi).append("|").toString());
            intent.putExtra("X-kid", new StringBuilder(String.valueOf(Wi).length() + 5).append("|ID|").append(Wi).append("|").toString());
            boolean equals = "com.google.android.gsf".equals(bpV);
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
            }
            if (equals) {
                synchronized (this) {
                    if (bqa == null) {
                        bqa = new cet(this);
                        if (Log.isLoggable("InstanceID/Rpc", 3)) {
                            Log.d("InstanceID/Rpc", "Registered GSF callback receiver");
                        }
                        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                        intentFilter.addCategory(this.bqb.getPackageName());
                        this.bqb.registerReceiver(bqa, intentFilter, "com.google.android.c2dm.permission.SEND", null);
                    }
                }
                this.bqb.startService(intent);
            } else {
                intent.putExtra("google.messenger", this.bQc);
                if (!(this.bQd == null && this.bQe == null)) {
                    Message obtain = Message.obtain();
                    obtain.obj = intent;
                    try {
                        if (this.bQd != null) {
                            this.bQd.send(obtain);
                        } else {
                            this.bQe.send(obtain);
                        }
                    } catch (RemoteException e) {
                        if (Log.isLoggable("InstanceID/Rpc", 3)) {
                            Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                        }
                    }
                }
                if (bpW) {
                    this.bqb.sendBroadcast(intent);
                } else {
                    this.bqb.startService(intent);
                }
            }
            try {
                Intent Wj = com_fossil_ceu.Wj();
                synchronized (this.bQb) {
                    this.bQb.remove(Wi);
                }
                return Wj;
            } catch (Throwable th) {
                synchronized (this.bQb) {
                    this.bQb.remove(Wi);
                }
            }
        } else {
            Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.bQk - elapsedRealtime) + " interval: " + this.bQj);
            throw new IOException("RETRY_LATER");
        }
    }

    public static synchronized void m6112c(Context context, Intent intent) {
        synchronized (cer.class) {
            if (bQf == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                bQf = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", bQf);
        }
    }

    final Intent m6113a(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent b = m6111b(bundle, keyPair);
        if (b == null || !b.hasExtra("google.messenger")) {
            return b;
        }
        b = m6111b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : null;
    }

    final void m6114c(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.bQe = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.bQd = (Messenger) parcelableExtra;
                    }
                }
                m6115p((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    public final void m6115p(Intent intent) {
        String str = null;
        if (intent != null) {
            String stringExtra;
            String stringExtra2;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                String str2;
                String[] split;
                if (stringExtra == null) {
                    stringExtra2 = intent.getStringExtra("error");
                    if (stringExtra2 == null) {
                        str = String.valueOf(intent.getExtras());
                        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 49).append("Unexpected response, no error or registration id ").append(str).toString());
                        return;
                    }
                    if (Log.isLoggable("InstanceID/Rpc", 3)) {
                        String str3 = "InstanceID/Rpc";
                        str2 = "Received InstanceID error ";
                        stringExtra = String.valueOf(stringExtra2);
                        Log.d(str3, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    if (stringExtra2.startsWith("|")) {
                        split = stringExtra2.split("\\|");
                        if (!"ID".equals(split[1])) {
                            str2 = "InstanceID/Rpc";
                            String str4 = "Unexpected structured response ";
                            stringExtra = String.valueOf(stringExtra2);
                            Log.w(str2, stringExtra.length() != 0 ? str4.concat(stringExtra) : new String(str4));
                        }
                        if (split.length > 2) {
                            stringExtra = split[2];
                            str = split[3];
                            if (str.startsWith(":")) {
                                str = str.substring(1);
                            }
                        } else {
                            str = "UNKNOWN";
                            stringExtra = null;
                        }
                        intent.putExtra("error", str);
                    } else {
                        stringExtra = null;
                        str = stringExtra2;
                    }
                    ah(stringExtra, str);
                    long longExtra = intent.getLongExtra("Retry-After", 0);
                    if (longExtra > 0) {
                        this.bQh = SystemClock.elapsedRealtime();
                        this.bQj = ((int) longExtra) * 1000;
                        this.bQk = SystemClock.elapsedRealtime() + ((long) this.bQj);
                        Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.bQj);
                        return;
                    } else if (("SERVICE_NOT_AVAILABLE".equals(str) || "AUTHENTICATION_FAILED".equals(str)) && "com.google.android.gsf".equals(bpV)) {
                        this.bQi++;
                        if (this.bQi >= 3) {
                            if (this.bQi == 3) {
                                this.bQj = new Random().nextInt(1000) + 1000;
                            }
                            this.bQj <<= 1;
                            this.bQk = SystemClock.elapsedRealtime() + ((long) this.bQj);
                            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.bQj).toString());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                this.bQg = SystemClock.elapsedRealtime();
                this.bQk = 0;
                this.bQi = 0;
                this.bQj = 0;
                if (stringExtra.startsWith("|")) {
                    split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        stringExtra2 = "InstanceID/Rpc";
                        str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(stringExtra2, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    stringExtra2 = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.bd(this.bqb);
                        } else if ("RST".equals(split[3])) {
                            Context context = this.bqb;
                            cep.m6102b(this.bqb, null);
                            FirebaseInstanceId.m12668a(context, cep.We());
                            intent.removeExtra("registration_id");
                            m6107a(stringExtra2, intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    str = stringExtra2;
                }
                if (str != null) {
                    m6107a(str, intent);
                } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Ignoring response without a request ID");
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                stringExtra2 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? stringExtra2.concat(stringExtra) : new String(stringExtra2));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
