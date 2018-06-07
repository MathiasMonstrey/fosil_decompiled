package com.flurry.sdk;

import com.flurry.sdk.lo.C1544a;
import com.fossil.aoq;
import com.fossil.aow;
import com.fossil.aoy;
import com.fossil.apc;
import com.fossil.apj;
import com.fossil.apk;
import com.fossil.apl;
import com.fossil.app;
import com.fossil.aqv;
import com.fossil.aqx;
import com.fossil.arw;
import com.fossil.arw.C1877a;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ji {
    private static final String aWR = ji.class.getSimpleName();
    private static ji aZT;
    private String aYv;
    private final Set<String> aZU;
    public final Map<jq, byte[]> aZV = new HashMap();
    private aow aZW;
    private aoy aZX;
    private final apk<lo> aZY = new C15301(this);
    private C1534a f1313e = C1534a.NONE;

    class C15301 implements apk<lo> {
        final /* synthetic */ ji aZZ;

        class C15291 extends aqx {
            final /* synthetic */ C15301 baa;

            C15291(C15301 c15301) {
                this.baa = c15301;
            }

            public final void HJ() {
                this.baa.aZZ.HK();
            }
        }

        C15301(ji jiVar) {
            this.aZZ = jiVar;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            switch (C15334.f1306a[((lo) com_fossil_apj).f1359c - 1]) {
                case 1:
                    if (this.aZZ.Ie()) {
                        apc.IO().m4160b(new C15291(this));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C15312 extends aqx {
        final /* synthetic */ ji aZZ;

        C15312(ji jiVar) {
            this.aZZ = jiVar;
        }

        public final void HJ() {
            ji.m2773b(this.aZZ);
        }
    }

    class C15323 implements FilenameFilter {
        final /* synthetic */ ji aZZ;

        C15323(ji jiVar) {
            this.aZZ = jiVar;
        }

        public final boolean accept(File file, String str) {
            return str.startsWith(".flurryagent.");
        }
    }

    static /* synthetic */ class C15334 {
        static final /* synthetic */ int[] f1306a = new int[C1544a.m2793a().length];

        static {
            aXh = new int[C1534a.values().length];
            try {
                aXh[C1534a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aXh[C1534a.ADVERTISING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aXh[C1534a.INSTALL_ID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                aXh[C1534a.DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                aXh[C1534a.REPORTED_IDS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1306a[C1544a.f1353a - 1] = 1;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    enum C1534a {
        NONE,
        ADVERTISING,
        DEVICE,
        INSTALL_ID,
        REPORTED_IDS,
        FINISHED
    }

    private ji() {
        Set hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.aZU = Collections.unmodifiableSet(hashSet);
        apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionEvent", this.aZY);
        apc.IO().m4160b(new C15312(this));
    }

    public static synchronized ji Iu() {
        ji jiVar;
        synchronized (ji.class) {
            if (aZT == null) {
                aZT = new ji();
            }
            jiVar = aZT;
        }
        return jiVar;
    }

    public final boolean Ie() {
        return C1534a.FINISHED.equals(this.f1313e);
    }

    private byte[] If() {
        if (this.aZX == null) {
            this.aZX = new aoy();
        }
        try {
            return this.aZX.Ii();
        } catch (Exception e) {
            return null;
        }
    }

    public final boolean m2776c() {
        if (this.aZW != null && this.aZW.aXI) {
            return false;
        }
        return true;
    }

    private void HK() {
        aqv.HO();
        this.aZW = Iv();
        if (Ie()) {
            HP();
            apl.IW().m4167a(new aoq());
        }
    }

    private static aow Iv() {
        try {
            C1877a ag = arw.ag(apc.IO().baD);
            return new aow(ag.getId(), ag.JI());
        } catch (NoClassDefFoundError e) {
            app.m4182x(aWR, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (Exception e2) {
            app.m4182x(aWR, "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            app.m4182x(aWR, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }

    private static void m2774c(String str, File file) {
        Closeable dataOutputStream;
        Throwable th;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeUTF(str);
                aqv.m4252a(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    app.m4174b(6, aWR, "Error when saving deviceId", th);
                    aqv.m4252a(dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    aqv.m4252a(dataOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            aqv.m4252a(dataOutputStream);
            throw th;
        }
    }

    private static String Iw() {
        Closeable dataInputStream;
        Throwable th;
        Throwable th2;
        String str = null;
        File fileStreamPath = apc.IO().baD.getFileStreamPath(".flurryb.");
        if (fileStreamPath != null && fileStreamPath.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    if (1 == dataInputStream.readInt()) {
                        str = dataInputStream.readUTF();
                    }
                    aqv.m4252a(dataInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        app.m4174b(6, aWR, "Error when loading deviceId", th);
                        aqv.m4252a(dataInputStream);
                        return str;
                    } catch (Throwable th4) {
                        th2 = th4;
                        aqv.m4252a(dataInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                dataInputStream = str;
                th2 = th5;
                aqv.m4252a(dataInputStream);
                throw th2;
            }
        }
        return str;
    }

    private String m2775h() {
        Closeable dataInputStream;
        Throwable th;
        Throwable th2;
        String str = null;
        File filesDir = apc.IO().baD.getFilesDir();
        if (filesDir != null) {
            String[] list = filesDir.list(new C15323(this));
            if (!(list == null || list.length == 0)) {
                filesDir = apc.IO().baD.getFileStreamPath(list[0]);
                if (filesDir != null && filesDir.exists()) {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(filesDir));
                        try {
                            if (46586 == dataInputStream.readUnsignedShort()) {
                                if (2 == dataInputStream.readUnsignedShort()) {
                                    dataInputStream.readUTF();
                                    str = dataInputStream.readUTF();
                                }
                            }
                            aqv.m4252a(dataInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                app.m4174b(6, aWR, "Error when loading deviceId", th);
                                aqv.m4252a(dataInputStream);
                                return str;
                            } catch (Throwable th4) {
                                th2 = th4;
                                aqv.m4252a(dataInputStream);
                                throw th2;
                            }
                        }
                    } catch (Throwable th5) {
                        dataInputStream = null;
                        th2 = th5;
                        aqv.m4252a(dataInputStream);
                        throw th2;
                    }
                }
            }
        }
        return str;
    }

    private void HP() {
        String str;
        if (this.aZW == null) {
            str = null;
        } else {
            str = this.aZW.aWB;
        }
        if (str != null) {
            app.m4180g(3, aWR, "Fetched advertising id");
            this.aZV.put(jq.AndroidAdvertisingId, aqv.cz(str));
        }
        Object If = If();
        if (If != null) {
            app.m4180g(3, aWR, "Fetched install id");
            this.aZV.put(jq.AndroidInstallationId, If);
        }
        str = this.aYv;
        if (str != null) {
            app.m4180g(3, aWR, "Fetched device id");
            this.aZV.put(jq.DeviceId, aqv.cz(str));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m2773b(com.flurry.sdk.ji r8) {
        /*
        r6 = 37;
    L_0x0002:
        r0 = com.flurry.sdk.ji.C1534a.FINISHED;
        r1 = r8.f1313e;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0125;
    L_0x000c:
        r0 = com.flurry.sdk.ji.C15334.aXh;
        r1 = r8.f1313e;
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x004e;
            case 2: goto L_0x0053;
            case 3: goto L_0x0058;
            case 4: goto L_0x005d;
            case 5: goto L_0x0062;
            default: goto L_0x0019;
        };
    L_0x0019:
        r0 = com.flurry.sdk.ji.C15334.aXh;	 Catch:{ Exception -> 0x002b }
        r1 = r8.f1313e;	 Catch:{ Exception -> 0x002b }
        r1 = r1.ordinal();	 Catch:{ Exception -> 0x002b }
        r0 = r0[r1];	 Catch:{ Exception -> 0x002b }
        switch(r0) {
            case 2: goto L_0x0027;
            case 3: goto L_0x0067;
            case 4: goto L_0x0076;
            case 5: goto L_0x0120;
            default: goto L_0x0026;
        };	 Catch:{ Exception -> 0x002b }
    L_0x0026:
        goto L_0x0002;
    L_0x0027:
        r8.HK();	 Catch:{ Exception -> 0x002b }
        goto L_0x0002;
    L_0x002b:
        r0 = move-exception;
        r1 = 4;
        r2 = aWR;
        r3 = new java.lang.StringBuilder;
        r4 = "Exception during id fetch:";
        r3.<init>(r4);
        r4 = r8.f1313e;
        r3 = r3.append(r4);
        r4 = ", ";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.fossil.app.m4180g(r1, r2, r0);
        goto L_0x0002;
    L_0x004e:
        r0 = com.flurry.sdk.ji.C1534a.ADVERTISING;
        r8.f1313e = r0;
        goto L_0x0019;
    L_0x0053:
        r0 = com.flurry.sdk.ji.C1534a.INSTALL_ID;
        r8.f1313e = r0;
        goto L_0x0019;
    L_0x0058:
        r0 = com.flurry.sdk.ji.C1534a.DEVICE;
        r8.f1313e = r0;
        goto L_0x0019;
    L_0x005d:
        r0 = com.flurry.sdk.ji.C1534a.REPORTED_IDS;
        r8.f1313e = r0;
        goto L_0x0019;
    L_0x0062:
        r0 = com.flurry.sdk.ji.C1534a.FINISHED;
        r8.f1313e = r0;
        goto L_0x0019;
    L_0x0067:
        com.fossil.aqv.HO();	 Catch:{ Exception -> 0x002b }
        r0 = r8.aZX;	 Catch:{ Exception -> 0x002b }
        if (r0 != 0) goto L_0x0002;
    L_0x006e:
        r0 = new com.fossil.aoy;	 Catch:{ Exception -> 0x002b }
        r0.<init>();	 Catch:{ Exception -> 0x002b }
        r8.aZX = r0;	 Catch:{ Exception -> 0x002b }
        goto L_0x0002;
    L_0x0076:
        com.fossil.aqv.HO();	 Catch:{ Exception -> 0x002b }
        r0 = com.fossil.apc.IO();	 Catch:{ Exception -> 0x002b }
        r0 = r0.baD;	 Catch:{ Exception -> 0x002b }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x002b }
        r1 = "android_id";
        r1 = android.provider.Settings.Secure.getString(r0, r1);	 Catch:{ Exception -> 0x002b }
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x002b }
        if (r0 != 0) goto L_0x00ab;
    L_0x008f:
        r0 = java.util.Locale.US;	 Catch:{ Exception -> 0x002b }
        r0 = r1.toLowerCase(r0);	 Catch:{ Exception -> 0x002b }
        r2 = r8.aZU;	 Catch:{ Exception -> 0x002b }
        r0 = r2.contains(r0);	 Catch:{ Exception -> 0x002b }
        if (r0 != 0) goto L_0x00ab;
    L_0x009d:
        r0 = 1;
    L_0x009e:
        if (r0 != 0) goto L_0x00ad;
    L_0x00a0:
        r0 = 0;
    L_0x00a1:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002b }
        if (r1 != 0) goto L_0x00bd;
    L_0x00a7:
        r8.aYv = r0;	 Catch:{ Exception -> 0x002b }
        goto L_0x0002;
    L_0x00ab:
        r0 = 0;
        goto L_0x009e;
    L_0x00ad:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002b }
        r2 = "AND";
        r0.<init>(r2);	 Catch:{ Exception -> 0x002b }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x002b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x002b }
        goto L_0x00a1;
    L_0x00bd:
        r0 = Iw();	 Catch:{ Exception -> 0x002b }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002b }
        if (r1 == 0) goto L_0x00a7;
    L_0x00c7:
        r0 = r8.m2775h();	 Catch:{ Exception -> 0x002b }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002b }
        if (r1 == 0) goto L_0x0104;
    L_0x00d1:
        r0 = java.lang.Math.random();	 Catch:{ Exception -> 0x002b }
        r0 = java.lang.Double.doubleToLongBits(r0);	 Catch:{ Exception -> 0x002b }
        r2 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x002b }
        r4 = com.fossil.apc.IO();	 Catch:{ Exception -> 0x002b }
        r4 = r4.baD;	 Catch:{ Exception -> 0x002b }
        r4 = com.fossil.aqs.m4244Y(r4);	 Catch:{ Exception -> 0x002b }
        r4 = com.fossil.aqv.cC(r4);	 Catch:{ Exception -> 0x002b }
        r4 = r4 * r6;
        r2 = r2 + r4;
        r2 = r2 * r6;
        r0 = r0 + r2;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002b }
        r3 = "ID";
        r2.<init>(r3);	 Catch:{ Exception -> 0x002b }
        r3 = 16;
        r0 = java.lang.Long.toString(r0, r3);	 Catch:{ Exception -> 0x002b }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x002b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x002b }
    L_0x0104:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x002b }
        if (r1 != 0) goto L_0x00a7;
    L_0x010a:
        r1 = com.fossil.apc.IO();	 Catch:{ Exception -> 0x002b }
        r1 = r1.baD;	 Catch:{ Exception -> 0x002b }
        r2 = ".flurryb.";
        r1 = r1.getFileStreamPath(r2);	 Catch:{ Exception -> 0x002b }
        r2 = com.fossil.aqu.m4247t(r1);	 Catch:{ Exception -> 0x002b }
        if (r2 == 0) goto L_0x00a7;
    L_0x011c:
        m2774c(r0, r1);	 Catch:{ Exception -> 0x002b }
        goto L_0x00a7;
    L_0x0120:
        r8.HP();	 Catch:{ Exception -> 0x002b }
        goto L_0x0002;
    L_0x0125:
        r0 = new com.fossil.aop;
        r0.<init>();
        r1 = com.fossil.apl.IW();
        r1.m4167a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.ji.b(com.flurry.sdk.ji):void");
    }
}
