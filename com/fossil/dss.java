package com.fossil;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.fossil.dsk.C3178a;
import com.fossil.dun.C3210a;
import java.io.File;
import java.util.List;

class dss {
    private static final String TAG = dss.class.getName();
    private static final String dqC = (Environment.getExternalStorageDirectory() + "/Android/org_share_data/");
    private boolean aED = false;
    private Looper dqD;
    private C3179a dqE;
    private Context mContext;
    private HandlerThread thread;

    class C3179a extends Handler {
        final /* synthetic */ dss dqF;

        public C3179a(dss com_fossil_dss, Looper looper) {
            this.dqF = com_fossil_dss;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.dqF.m9638a((dsr) message.obj);
                    return;
                case 2:
                    this.dqF.dqD.quit();
                    this.dqF.aED = false;
                    return;
                default:
                    return;
            }
        }
    }

    private void m9638a(com.fossil.dsr r9) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.mContext;
        r0 = m9641a(r0, r9);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = dqC;
        r2 = r9.getDownloadUrl();
        r4 = r9.awF();
        r0 = r8.mContext;
        r3 = m9636a(r0, r1, r9);
        if (r3 == 0) goto L_0x003a;
    L_0x001b:
        r0 = r3.second;
        if (r0 == 0) goto L_0x003a;
    L_0x001f:
        r0 = r3.first;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r6 = (long) r0;
        r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x003a;
    L_0x002c:
        r1 = r8.mContext;
        r0 = r3.second;
        r0 = (java.io.File) r0;
        r0 = r0.getAbsolutePath();
        m9637a(r1, r9, r0);
        goto L_0x0008;
    L_0x003a:
        r0 = r8.mContext;
        r0 = com.fossil.dul.dc(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x0042:
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0008;
    L_0x0048:
        r3 = "";
        r0 = r8.mContext;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r4 = "GET";	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r5 = new com.fossil.dtq;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r6 = "";	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r5.<init>(r6);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r0 = com.fossil.dtn.m9732d(r0, r2, r4, r5);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r2 = jC(r0);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        if (r4 != 0) goto L_0x006b;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
    L_0x0063:
        r4 = ".apk";	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r4 = r2.endsWith(r4);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        if (r4 != 0) goto L_0x007e;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
    L_0x006b:
        r0 = TAG;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r1 = "redirectDownloadUrl is illeagle";	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        com.fossil.duj.m9770e(r0, r1);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0008;
    L_0x0078:
        r0 = r8.mContext;
        m9637a(r0, r9, r3);
        goto L_0x0008;
    L_0x007e:
        r4 = r8.mContext;	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r0 = com.fossil.dtn.m9731b(r4, r0, r1, r2);	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0008;
    L_0x008a:
        r1 = r8.mContext;
        m9637a(r1, r9, r0);
        goto L_0x0008;
    L_0x0091:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ WeiboException -> 0x0091, all -> 0x00a2 }
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0008;
    L_0x009b:
        r0 = r8.mContext;
        m9637a(r0, r9, r3);
        goto L_0x0008;
    L_0x00a2:
        r0 = move-exception;
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 != 0) goto L_0x00ae;
    L_0x00a9:
        r1 = r8.mContext;
        m9637a(r1, r9, r3);
    L_0x00ae:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dss.a(com.fossil.dsr):void");
    }

    public dss(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static boolean m9641a(Context context, dsr com_fossil_dsr) {
        List<String> awG = com_fossil_dsr.awG();
        if (awG == null || awG.size() == 0 || TextUtils.isEmpty(com_fossil_dsr.awH()) || TextUtils.isEmpty(com_fossil_dsr.getDownloadUrl()) || TextUtils.isEmpty(com_fossil_dsr.awJ())) {
            return false;
        }
        if (awG.contains("com.sina.weibo")) {
            C3178a awu = dsk.cF(context).awu();
            return awu == null || !awu.aww();
        } else {
            for (String I : awG) {
                if (m9632I(context, I)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean m9632I(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 1) != null) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public void start() {
        if (!this.aED) {
            this.aED = true;
            this.thread = new HandlerThread("");
            this.thread.start();
            this.dqD = this.thread.getLooper();
            this.dqE = new C3179a(this, this.dqD);
        }
    }

    public void stop() {
        if (this.thread == null || this.dqE == null) {
            duj.aS(TAG, "no thread running. please call start method first!");
            return;
        }
        Message obtainMessage = this.dqE.obtainMessage();
        obtainMessage.what = 2;
        this.dqE.sendMessage(obtainMessage);
    }

    public boolean m9645b(dsr com_fossil_dsr) {
        if (this.thread == null || this.dqE == null) {
            throw new RuntimeException("no thread running. please call start method first!");
        }
        if (com_fossil_dsr != null) {
            Message obtainMessage = this.dqE.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = com_fossil_dsr;
            this.dqE.sendMessage(obtainMessage);
        }
        return false;
    }

    private static Pair<Integer, File> m9636a(Context context, String str, dsr com_fossil_dsr) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        int length = listFiles.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            File file2 = listFiles[i];
            String name = file2.getName();
            if (file2.isFile() && name.endsWith(".apk")) {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 64);
                if (!m9643a(packageArchiveInfo, com_fossil_dsr.awG(), com_fossil_dsr.awH())) {
                    i3 = i2;
                } else if (packageArchiveInfo.versionCode > i2) {
                    File file3 = file2;
                    i3 = packageArchiveInfo.versionCode;
                    File file4 = file3;
                }
                i++;
                i2 = i3;
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        return new Pair(Integer.valueOf(i2), obj);
    }

    private static boolean m9643a(PackageInfo packageInfo, List<String> list, String str) {
        boolean z;
        for (String a : list) {
            if (m9642a(packageInfo, a)) {
                z = true;
                break;
            }
        }
        z = false;
        boolean b = m9644b(packageInfo, str);
        if (z && b) {
            return true;
        }
        return false;
    }

    private static boolean m9642a(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        return str.equals(packageInfo.packageName);
    }

    private static boolean m9644b(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        if (packageInfo.signatures != null) {
            String str2 = "";
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    str2 = duk.aq(toByteArray2);
                }
            }
            if (str2 != null) {
                return str2.equals(str);
            }
            return false;
        } else if (VERSION.SDK_INT < 11) {
            return true;
        } else {
            return false;
        }
    }

    private static String jC(String str) {
        String str2 = "";
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1, str.length());
        }
        return str2;
    }

    private static void m9637a(Context context, dsr com_fossil_dsr, String str) {
        C3210a.axY().kq(com_fossil_dsr.awJ()).m9785c(m9633J(context, str)).kp(m9634K(context, com_fossil_dsr.awK())).ko(com_fossil_dsr.awJ()).dh(context).show(1);
    }

    private static PendingIntent m9633J(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return PendingIntent.getActivity(context, 0, new Intent(), 16);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return PendingIntent.getActivity(context, 0, intent, 16);
    }

    private static String m9634K(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return dum.m9779c(context, "Weibo", "微博", "微博");
        }
        return str;
    }
}
