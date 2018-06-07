package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.ji;
import com.flurry.sdk.ln;
import com.flurry.sdk.lo;
import com.flurry.sdk.lo.C1544a;
import com.flurry.sdk.mb;
import com.fossil.aoj.C1764a;
import com.fossil.aqq.C1543a;
import com.misfit.frameworks.common.constants.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class aol implements C1543a {
    static final String aWB = aol.class.getSimpleName();
    static int f1421b = 100;
    static int f1422c = 10;
    static int f1423d = 1000;
    static int f1424e = 160000;
    static int f1425f = 50;
    private int f1426E = -1;
    private int f1427I = 0;
    boolean aXT;
    String aYp;
    public boolean aYx;
    private long aZA;
    private String aZB;
    private String aZC;
    byte aZD;
    Long aZE;
    private boolean aZF = true;
    private int aZG = 0;
    private int aZH = 0;
    boolean aZI = true;
    final apk<aop> aZJ = new C17671(this);
    private final apk<lo> aZK = new apk<lo>(this) {
        final /* synthetic */ aol aZL;

        {
            this.aZL = r1;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            lo loVar = (lo) com_fossil_apj;
            if (this.aZL.aZx == null || loVar.bce == this.aZL.aZx.get()) {
                aol com_fossil_aol;
                switch (AnonymousClass15.f1420a[loVar.f1359c - 1]) {
                    case 1:
                        C1543a c1543a = this.aZL;
                        ln lnVar = loVar.bce;
                        Context context = (Context) loVar.baz.get();
                        c1543a.aZx = new WeakReference(lnVar);
                        aqq Jf = aqp.Jf();
                        c1543a.aXT = ((Boolean) Jf.cw("LogEvents")).booleanValue();
                        Jf.m4241a("LogEvents", c1543a);
                        app.m4180g(4, aol.aWB, "initSettings, LogEvents = " + c1543a.aXT);
                        c1543a.aYp = (String) Jf.cw("UserId");
                        Jf.m4241a("UserId", c1543a);
                        app.m4180g(4, aol.aWB, "initSettings, UserId = " + c1543a.aYp);
                        c1543a.aZD = ((Byte) Jf.cw("Gender")).byteValue();
                        Jf.m4241a("Gender", c1543a);
                        app.m4180g(4, aol.aWB, "initSettings, Gender = " + c1543a.aZD);
                        c1543a.aZE = (Long) Jf.cw("Age");
                        Jf.m4241a("Age", c1543a);
                        app.m4180g(4, aol.aWB, "initSettings, BirthDate = " + c1543a.aZE);
                        c1543a.aZI = ((Boolean) Jf.cw("analyticsEnabled")).booleanValue();
                        Jf.m4241a("analyticsEnabled", c1543a);
                        app.m4180g(4, aol.aWB, "initSettings, AnalyticsEnabled = " + c1543a.aZI);
                        c1543a.aZy = context.getFileStreamPath(".flurryagent." + Integer.toString(apc.IO().f1440d.hashCode(), 16));
                        c1543a.aZz = new api(context.getFileStreamPath(".yflurryreport." + Long.toString(aqv.cC(apc.IO().f1440d), 16)), ".yflurryreport.", 1, new C17682(c1543a));
                        c1543a.f1428o = lnVar.Ja();
                        c1543a.m4111a(context);
                        c1543a.m4114a(true);
                        if (ana.HD().aWY != null) {
                            apc.IO().m4160b(new C17693(c1543a));
                        }
                        apc.IO().m4160b(new C17704(c1543a));
                        apc.IO().m4160b(new C17715(c1543a));
                        if (ji.Iu().Ie()) {
                            apc.IO().m4160b(new C17726(c1543a));
                            return;
                        } else {
                            apl.IW().m4169a("com.flurry.android.sdk.IdProviderFinishedEvent", c1543a.aZJ);
                            return;
                        }
                    case 2:
                        com_fossil_aol = this.aZL;
                        loVar.baz.get();
                        com_fossil_aol.HJ();
                        return;
                    case 3:
                        com_fossil_aol = this.aZL;
                        loVar.baz.get();
                        com_fossil_aol.HO();
                        return;
                    case 4:
                        apl.IW().m4170b("com.flurry.android.sdk.FlurrySessionEvent", this.aZL.aZK);
                        this.aZL.m4110a(loVar.aYX);
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private final List<String> aZm = new ArrayList();
    private final AtomicInteger aZo = new AtomicInteger(0);
    private final AtomicInteger aZp = new AtomicInteger(0);
    private final List<aoj> aZq = new ArrayList();
    private final Map<String, List<String>> aZr = new HashMap();
    private final Map<String, String> aZs = new HashMap();
    private final Map<String, aof> aZt = new HashMap();
    private final List<aog> aZu = new ArrayList();
    private final List<aoe> aZv = new ArrayList();
    private final anb aZw = new anb();
    WeakReference<ln> aZx;
    File aZy;
    api<List<aoj>> aZz;
    boolean f1428o;

    static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] f1420a = new int[C1544a.m2793a().length];

        static {
            try {
                f1420a[C1544a.f1353a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1420a[C1544a.f1355c - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1420a[C1544a.f1356d - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1420a[C1544a.f1357e - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    class C17671 implements apk<aop> {
        final /* synthetic */ aol aZL;

        class C17651 extends aqx {
            final /* synthetic */ C17671 aZM;

            C17651(C17671 c17671) {
                this.aZM = c17671;
            }

            public final void HJ() {
                aol com_fossil_aol = this.aZM.aZL;
                aon.Il();
                com_fossil_aol.m4101a(true, aon.In());
            }
        }

        C17671(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            apc.IO().m4160b(new C17651(this));
        }
    }

    class C17682 implements aqk<List<aoj>> {
        final /* synthetic */ aol aZL;

        C17682(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final aqi<List<aoj>> hi(int i) {
            return new aqh(new C1764a());
        }
    }

    class C17693 extends aqx {
        final /* synthetic */ aol aZL;

        C17693(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            ana.HD().aWY.HJ();
        }
    }

    class C17704 extends aqx {
        final /* synthetic */ aol aZL;

        C17704(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            this.aZL.m4105d();
        }
    }

    class C17715 extends aqx {
        final /* synthetic */ aol aZL;

        C17715(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            aol.m4106d(this.aZL);
        }
    }

    class C17726 extends aqx {
        final /* synthetic */ aol aZL;

        C17726(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            aol com_fossil_aol = this.aZL;
            aon.Il();
            com_fossil_aol.m4101a(true, aon.In());
        }
    }

    class C17737 extends aqx {
        final /* synthetic */ aol aZL;

        C17737(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            ana.HD().aXa.HH();
        }
    }

    class C17748 extends aqx {
        final /* synthetic */ aol aZL;

        C17748(aol com_fossil_aol) {
            this.aZL = com_fossil_aol;
        }

        public final void HJ() {
            ana.HD().aWY.HO();
        }
    }

    public aol() {
        apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionEvent", this.aZK);
    }

    final void m4111a(Context context) {
        if (context instanceof Activity) {
            Bundle extras = ((Activity) context).getIntent().getExtras();
            if (extras != null) {
                app.m4180g(3, aWB, "Launch Options Bundle is present " + extras.toString());
                for (String str : extras.keySet()) {
                    if (str != null) {
                        Object obj = extras.get(str);
                        String obj2 = obj != null ? obj.toString() : "null";
                        this.aZr.put(str, Collections.singletonList(obj2));
                        app.m4180g(3, aWB, "Launch options Key: " + str + ". Its value: " + obj2);
                    }
                }
            }
        }
    }

    @TargetApi(18)
    final void m4114a(boolean z) {
        boolean z2;
        int intExtra;
        Exception exception;
        int i;
        Object obj;
        float f;
        int i2 = -1;
        if (z) {
            this.aZs.put("boot.time", Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (VERSION.SDK_INT >= 18) {
                this.aZs.put("disk.size.total.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.aZs.put("disk.size.available.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.aZs.put("disk.size.total.external", Long.toString(statFs2.getAvailableBlocksLong()));
                this.aZs.put("disk.size.available.external", Long.toString(statFs2.getAvailableBlocksLong()));
            } else {
                this.aZs.put("disk.size.total.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.aZs.put("disk.size.available.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.aZs.put("disk.size.total.external", Long.toString((long) statFs2.getAvailableBlocks()));
                this.aZs.put("disk.size.available.external", Long.toString((long) statFs2.getAvailableBlocks()));
            }
            aou.IE();
            this.aZs.put("carrier.name", aou.HI());
            aou.IE();
            this.aZs.put("carrier.details", aou.Ih());
        }
        ActivityManager activityManager = (ActivityManager) apc.IO().baD.getSystemService(Constants.ACTIVITY);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        this.aZs.put("memory.available" + (z ? ".start" : ".end"), Long.toString(memoryInfo.availMem));
        if (VERSION.SDK_INT >= 16) {
            this.aZs.put("memory.total" + (z ? ".start" : ".end"), Long.toString(memoryInfo.availMem));
        }
        try {
            Intent registerReceiver = apc.IO().baD.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra2 = registerReceiver.getIntExtra("status", -1);
                z2 = intExtra2 == 2 || intExtra2 == 5;
                try {
                    intExtra = registerReceiver.getIntExtra("level", -1);
                } catch (Exception e) {
                    exception = e;
                    i = -1;
                    app.m4180g(5, aWB, "Error getting battery status: " + obj);
                    i2 = i;
                    i = -1;
                    f = ((float) i2) / ((float) i);
                    this.aZs.put("battery.charging" + (z ? ".end" : ".start"), Boolean.toString(z2));
                    this.aZs.put("battery.remaining" + (z ? ".end" : ".start"), Float.toString(f));
                }
                try {
                    i = registerReceiver.getIntExtra("scale", -1);
                    i2 = intExtra;
                } catch (Exception e2) {
                    Exception exception2 = e2;
                    i = intExtra;
                    exception = exception2;
                    app.m4180g(5, aWB, "Error getting battery status: " + obj);
                    i2 = i;
                    i = -1;
                    f = ((float) i2) / ((float) i);
                    if (z) {
                    }
                    this.aZs.put("battery.charging" + (z ? ".end" : ".start"), Boolean.toString(z2));
                    if (z) {
                    }
                    this.aZs.put("battery.remaining" + (z ? ".end" : ".start"), Float.toString(f));
                }
            }
            z2 = false;
            i = -1;
        } catch (Exception e3) {
            obj = e3;
            z2 = false;
            i = -1;
            app.m4180g(5, aWB, "Error getting battery status: " + obj);
            i2 = i;
            i = -1;
            f = ((float) i2) / ((float) i);
            if (z) {
            }
            this.aZs.put("battery.charging" + (z ? ".end" : ".start"), Boolean.toString(z2));
            if (z) {
            }
            this.aZs.put("battery.remaining" + (z ? ".end" : ".start"), Float.toString(f));
        }
        f = ((float) i2) / ((float) i);
        if (z) {
        }
        this.aZs.put("battery.charging" + (z ? ".end" : ".start"), Boolean.toString(z2));
        if (z) {
        }
        this.aZs.put("battery.remaining" + (z ? ".end" : ".start"), Float.toString(f));
    }

    private synchronized void m4105d() {
        app.m4180g(4, aWB, "Loading persistent session report data.");
        List list = (List) this.aZz.IV();
        if (list != null) {
            this.aZq.addAll(list);
        } else if (this.aZy.exists()) {
            app.m4180g(4, aWB, "Legacy persistent agent data found, converting.");
            aom s = and.m3957s(this.aZy);
            if (s != null) {
                boolean z = s.aXI;
                long j = s.aXw;
                if (j <= 0) {
                    aon.Il();
                    j = aon.In();
                }
                this.aYx = z;
                this.aZA = j;
                HK();
                Collection unmodifiableList = Collections.unmodifiableList(s.aWP);
                if (unmodifiableList != null) {
                    this.aZq.addAll(unmodifiableList);
                }
            }
            this.aZy.delete();
            HW();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m4101a(boolean r23, long r24) {
        /*
        r22 = this;
        monitor-enter(r22);
        r0 = r22;
        r2 = r0.aZI;	 Catch:{ all -> 0x0097 }
        if (r2 != 0) goto L_0x0011;
    L_0x0007:
        r2 = 3;
        r3 = aWB;	 Catch:{ all -> 0x0097 }
        r4 = "Analytics disabled, not sending agent report.";
        com.fossil.app.m4180g(r2, r3, r4);	 Catch:{ all -> 0x0097 }
    L_0x000f:
        monitor-exit(r22);
        return;
    L_0x0011:
        if (r23 != 0) goto L_0x001d;
    L_0x0013:
        r0 = r22;
        r2 = r0.aZq;	 Catch:{ all -> 0x0097 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0097 }
        if (r2 != 0) goto L_0x000f;
    L_0x001d:
        r2 = 3;
        r3 = aWB;	 Catch:{ all -> 0x0097 }
        r4 = "generating agent report";
        com.fossil.app.m4180g(r2, r3, r4);	 Catch:{ all -> 0x0097 }
        r21 = 0;
        r3 = new com.fossil.aoh;	 Catch:{ Exception -> 0x009a }
        r2 = com.fossil.apc.IO();	 Catch:{ Exception -> 0x009a }
        r4 = r2.f1440d;	 Catch:{ Exception -> 0x009a }
        r2 = com.fossil.aov.IF();	 Catch:{ Exception -> 0x009a }
        r5 = r2.Iw();	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r6 = r0.aYx;	 Catch:{ Exception -> 0x009a }
        r2 = com.flurry.sdk.ji.Iu();	 Catch:{ Exception -> 0x009a }
        r7 = r2.m2776c();	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r8 = r0.aZA;	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r12 = r0.aZq;	 Catch:{ Exception -> 0x009a }
        r2 = com.flurry.sdk.ji.Iu();	 Catch:{ Exception -> 0x009a }
        r2 = r2.aZV;	 Catch:{ Exception -> 0x009a }
        r13 = java.util.Collections.unmodifiableMap(r2);	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r2 = r0.aZw;	 Catch:{ Exception -> 0x009a }
        r14 = r2.HG();	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r15 = r0.aZr;	 Catch:{ Exception -> 0x009a }
        r2 = com.fossil.ape.IP();	 Catch:{ Exception -> 0x009a }
        r16 = r2.m4161b();	 Catch:{ Exception -> 0x009a }
        r17 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x009a }
        r19 = com.fossil.aqp.Jf();	 Catch:{ Exception -> 0x009a }
        r0 = r22;
        r0 = r0.f1428o;	 Catch:{ Exception -> 0x009a }
        r20 = r0;
        r10 = r24;
        r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r19, r20);	 Catch:{ Exception -> 0x009a }
        r2 = r3.aYe;	 Catch:{ Exception -> 0x009a }
    L_0x007e:
        if (r2 != 0) goto L_0x00b2;
    L_0x0080:
        r2 = aWB;	 Catch:{ all -> 0x0097 }
        r3 = "Error generating report";
        com.fossil.app.m4178e(r2, r3);	 Catch:{ all -> 0x0097 }
    L_0x0087:
        r0 = r22;
        r2 = r0.aZq;	 Catch:{ all -> 0x0097 }
        r2.clear();	 Catch:{ all -> 0x0097 }
        r0 = r22;
        r2 = r0.aZz;	 Catch:{ all -> 0x0097 }
        r2.Ie();	 Catch:{ all -> 0x0097 }
        goto L_0x000f;
    L_0x0097:
        r2 = move-exception;
        monitor-exit(r22);
        throw r2;
    L_0x009a:
        r2 = move-exception;
        r3 = aWB;	 Catch:{ all -> 0x0097 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r5 = "Exception while generating report: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0097 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0097 }
        r2 = r2.toString();	 Catch:{ all -> 0x0097 }
        com.fossil.app.m4178e(r3, r2);	 Catch:{ all -> 0x0097 }
        r2 = r21;
        goto L_0x007e;
    L_0x00b2:
        r3 = 3;
        r4 = aWB;	 Catch:{ all -> 0x0097 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r6 = "generated report of size ";
        r5.<init>(r6);	 Catch:{ all -> 0x0097 }
        r6 = r2.length;	 Catch:{ all -> 0x0097 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0097 }
        r6 = " with ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0097 }
        r0 = r22;
        r6 = r0.aZq;	 Catch:{ all -> 0x0097 }
        r6 = r6.size();	 Catch:{ all -> 0x0097 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0097 }
        r6 = " reports.";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0097 }
        r5 = r5.toString();	 Catch:{ all -> 0x0097 }
        com.fossil.app.m4180g(r3, r4, r5);	 Catch:{ all -> 0x0097 }
        r3 = com.fossil.ana.HD();	 Catch:{ all -> 0x0097 }
        r3 = r3.aWZ;	 Catch:{ all -> 0x0097 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r4.<init>();	 Catch:{ all -> 0x0097 }
        r5 = com.fossil.apd.Iz();	 Catch:{ all -> 0x0097 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0097 }
        r4 = r4.toString();	 Catch:{ all -> 0x0097 }
        r5 = com.fossil.apc.IO();	 Catch:{ all -> 0x0097 }
        r5 = r5.f1440d;	 Catch:{ all -> 0x0097 }
        r3.m4086c(r2, r5, r4);	 Catch:{ all -> 0x0097 }
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.aol.a(boolean, long):void");
    }

    private void HK() {
        Editor edit = apc.IO().baD.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putBoolean("com.flurry.sdk.previous_successful_report", this.aYx);
        edit.putLong("com.flurry.sdk.initial_run_time", this.aZA);
        edit.putString("com.flurry.sdk.api_key", apc.IO().f1440d);
        edit.apply();
    }

    private synchronized void HW() {
        app.m4180g(4, aWB, "Saving persistent agent data.");
        this.aZz.bJ(this.aZq);
    }

    public final synchronized void HJ() {
        this.f1426E = aqt.HF();
        if (ana.HD().aXa != null) {
            apc.IO().m4160b(new C17737(this));
        }
        if (this.aZI && ana.HD().aWY != null) {
            apc.IO().m4160b(new C17748(this));
        }
    }

    public final synchronized void HO() {
        HM();
    }

    private synchronized void HM() {
        m4114a(false);
        aon.Il();
        final long In = aon.In();
        aon.Il();
        final long Ip = aon.Ip();
        aon.Il();
        final long Ir = aon.Ir();
        aon.Il();
        final int Is = aon.Is() - 1;
        if (this.aZI && ana.HD().aWY != null) {
            apc.IO().m4160b(new aqx(this) {
                final /* synthetic */ aol aZN;

                public final void HJ() {
                    ana.HD().aWY.m3993a(In);
                }
            });
        }
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aol aZL;

            {
                this.aZL = r1;
            }

            public final void HJ() {
                this.aZL.HK();
            }
        });
        if (ji.Iu().Ie()) {
            apc.IO().m4160b(new aqx(this) {
                final /* synthetic */ aol aZO;

                public final void HJ() {
                    aol.m4099a(this.aZO, In, Ip, Ir, Is);
                }
            });
        }
    }

    private synchronized aoj m4097a(long j, long j2, long j3, int i) {
        aoj com_fossil_aoj;
        String HT;
        Map IN;
        aok com_fossil_aok = new aok();
        com_fossil_aok.aZi = ((Boolean) aqp.Jf().cw("IncludeBackgroundSessionsInMetrics")).booleanValue();
        com_fossil_aok.aZh = this.f1428o;
        com_fossil_aok.aWB = aov.IF().Iw();
        com_fossil_aok.aXv = j;
        com_fossil_aok.aXw = j2;
        com_fossil_aok.aYX = j3;
        com_fossil_aok.aWU = this.aZs;
        aon.Il();
        apb Im = aon.Im();
        if (Im != null) {
            HT = Im.HT();
        } else {
            HT = null;
        }
        com_fossil_aok.aXl = HT;
        aon.Il();
        Im = aon.Im();
        if (Im != null) {
            HT = Im.IM();
        } else {
            HT = null;
        }
        com_fossil_aok.aYv = HT;
        aon.Il();
        Im = aon.Im();
        if (Im != null) {
            IN = Im.IN();
        } else {
            IN = null;
        }
        com_fossil_aok.aYW = IN;
        aor.Ix();
        com_fossil_aok.aZb = aor.HI();
        aor.Ix();
        com_fossil_aok.aXS = TimeZone.getDefault().getID();
        com_fossil_aok.f1414k = i;
        com_fossil_aok.aZc = this.f1426E != -1 ? this.f1426E : aqt.HF();
        if (this.aYp == null) {
            HT = "";
        } else {
            HT = this.aYp;
        }
        com_fossil_aok.aYt = HT;
        com_fossil_aok.aZd = aos.Iy().IB();
        com_fossil_aok.aZe = this.f1427I;
        com_fossil_aok.f1416x = mb.ab(apc.IO().baD).f1373i;
        com_fossil_aok.aZf = this.aZD;
        com_fossil_aok.aZg = this.aZE;
        com_fossil_aok.aZj = this.aZt;
        List list = this.aZu;
        app.m4180g(3, aWB, "Total events in session report: " + list.size());
        com_fossil_aok.aZk = list;
        com_fossil_aok.f1415w = this.aZF;
        com_fossil_aok.aZm = this.aZv;
        com_fossil_aok.f1417y = this.aZH;
        app.m4180g(3, aWB, "Total errors in session report: " + this.aZH);
        com_fossil_aok.aZl = this.aZm;
        com_fossil_aok.aZn = this.aZC;
        try {
            com_fossil_aoj = new aoj(com_fossil_aok);
        } catch (IOException e) {
            app.m4180g(5, aWB, "Error creating analytics session report: " + e);
            com_fossil_aoj = null;
        }
        if (com_fossil_aoj == null) {
            app.m4178e(aWB, "New session report wasn't created");
        }
        return com_fossil_aoj;
    }

    private synchronized void m4103b(long j) {
        for (aog com_fossil_aog : this.aZu) {
            if (com_fossil_aog.aXI && !com_fossil_aog.aWM) {
                com_fossil_aog.m4080a(j);
            }
        }
    }

    public final synchronized void m4110a(long j) {
        apl.IW().m4168a(this.aZJ);
        aon.Il();
        m4103b(aon.Ip());
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aol aZL;

            class C17661 extends aqx {
                final /* synthetic */ AnonymousClass12 aZP;

                C17661(AnonymousClass12 anonymousClass12) {
                    this.aZP = anonymousClass12;
                }

                public final void HJ() {
                    ana.HD().aXa.aWM = true;
                }
            }

            {
                this.aZL = r1;
            }

            public final void HJ() {
                if (this.aZL.aZI && ana.HD().aWY != null) {
                    ana.HD().aWY.HH();
                }
                if (ana.HD().aXa != null) {
                    apc.IO().m4160b(new C17661(this));
                }
            }
        });
        if (ji.Iu().Ie()) {
            aon.Il();
            final long Ip = aon.Ip();
            aon.Il();
            final long Ir = aon.Ir();
            aon.Il();
            final int Is = aon.Is() - 1;
            final long j2 = j;
            apc.IO().m4160b(new aqx(this) {
                final /* synthetic */ aol aZO;

                public final void HJ() {
                    aol.m4099a(this.aZO, j2, Ip, Ir, Is);
                    this.aZO.m4101a(false, j2);
                }
            });
        }
        aqp.Jf().m4243b("Gender", this);
        aqp.Jf().m4243b("UserId", this);
        aqp.Jf().m4243b("Age", this);
        aqp.Jf().m4243b("LogEvents", this);
    }

    public final void mo761a(String str, Object obj) {
        int i = -1;
        switch (str.hashCode()) {
            case -1752163738:
                if (str.equals("UserId")) {
                    i = 1;
                    break;
                }
                break;
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    i = 4;
                    break;
                }
                break;
            case -738063011:
                if (str.equals("LogEvents")) {
                    i = 0;
                    break;
                }
                break;
            case 65759:
                if (str.equals("Age")) {
                    i = 3;
                    break;
                }
                break;
            case 2129321697:
                if (str.equals("Gender")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                this.aXT = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, LogEvents = " + this.aXT);
                return;
            case 1:
                this.aYp = (String) obj;
                app.m4180g(4, aWB, "onSettingUpdate, UserId = " + this.aYp);
                return;
            case 2:
                this.aZD = ((Byte) obj).byteValue();
                app.m4180g(4, aWB, "onSettingUpdate, Gender = " + this.aZD);
                return;
            case 3:
                this.aZE = (Long) obj;
                app.m4180g(4, aWB, "onSettingUpdate, Birthdate = " + this.aZE);
                return;
            case 4:
                this.aZI = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, AnalyticsEnabled = " + this.aZI);
                return;
            default:
                app.m4180g(6, aWB, "onSettingUpdate internal error!");
                return;
        }
    }

    public final synchronized FlurryEventRecordStatus m4109a(String str, Map<String, String> map, boolean z, int i) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (this.aZI) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aon.Il();
            long Io = elapsedRealtime - aon.Io();
            final String cx = aqv.cx(str);
            if (cx.length() == 0) {
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
            } else {
                aof com_fossil_aof = (aof) this.aZt.get(cx);
                if (com_fossil_aof != null) {
                    com_fossil_aof.f1409a++;
                    app.m4178e(aWB, "Event count incremented: " + cx);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
                } else if (this.aZt.size() < f1421b) {
                    com_fossil_aof = new aof();
                    com_fossil_aof.f1409a = 1;
                    this.aZt.put(cx, com_fossil_aof);
                    app.m4178e(aWB, "Event count started: " + cx);
                    flurryEventRecordStatus = flurryEventRecordStatus2;
                } else {
                    app.m4178e(aWB, "Too many different events. Event not counted: " + cx);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
                }
                if (!this.aXT || this.aZu.size() >= f1423d || this.aZG >= f1424e) {
                    this.aZF = false;
                } else {
                    Map emptyMap;
                    if (map == null) {
                        emptyMap = Collections.emptyMap();
                    } else {
                        Map<String, String> map2 = map;
                    }
                    if (emptyMap.size() - i > f1422c) {
                        app.m4178e(aWB, "MaxEventParams exceeded: " + (emptyMap.size() - i));
                        flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
                    } else {
                        aog com_fossil_aog = new aog(this.aZo.incrementAndGet(), cx, emptyMap, Io, z);
                        if (com_fossil_aog.Ij().length + this.aZG <= f1424e) {
                            this.aZu.add(com_fossil_aog);
                            this.aZG += com_fossil_aog.Ij().length;
                            FlurryEventRecordStatus flurryEventRecordStatus3 = FlurryEventRecordStatus.kFlurryEventRecorded;
                            if ("Flurry.purchase".equals(cx)) {
                                Map HG = com_fossil_aog.HG();
                                String str2 = (String) HG.get("fl.OrderJSON");
                                String str3 = (String) HG.get("fl.OrderJSONSignature");
                                if (!(str2 == null || str3 == null)) {
                                    HG.remove("fl.OrderJSON");
                                    HG.remove("fl.OrderJSONSignature");
                                    com_fossil_aog.m4082p(HG);
                                    this.aZm.add(str3 + '\n' + str2);
                                }
                            }
                            if (this.aZI && ana.HD().aWY != null) {
                                apc.IO().m4160b(new Runnable(this) {
                                    final /* synthetic */ aol aZQ;

                                    public final void run() {
                                        ana.HD().aWY.m3995d(cx, emptyMap);
                                    }
                                });
                            }
                            flurryEventRecordStatus = flurryEventRecordStatus3;
                        } else {
                            this.aZG = f1424e;
                            this.aZF = false;
                            app.m4178e(aWB, "Event Log size exceeded. No more event details logged.");
                            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
                        }
                    }
                }
            }
        } else {
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
            app.m4178e(aWB, "Analytics has been disabled, not logging event.");
        }
        return flurryEventRecordStatus;
    }

    public final synchronized void m4115d(String str, Map<String, String> map) {
        for (aog com_fossil_aog : this.aZu) {
            Object obj;
            if (com_fossil_aog.aXI && com_fossil_aog.aYX == 0 && com_fossil_aog.aWB.equals(str)) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                aon.Il();
                elapsedRealtime -= aon.Io();
                if (map != null && map.size() > 0 && this.aZG < f1424e) {
                    int length = this.aZG - com_fossil_aog.Ij().length;
                    Map hashMap = new HashMap(com_fossil_aog.HG());
                    com_fossil_aog.m4081o(map);
                    if (com_fossil_aog.Ij().length + length > f1424e) {
                        com_fossil_aog.m4082p(hashMap);
                        this.aZF = false;
                        this.aZG = f1424e;
                        app.m4178e(aWB, "Event Log size exceeded. No more event details logged.");
                    } else if (com_fossil_aog.HG().size() > f1422c) {
                        app.m4178e(aWB, "MaxEventParams exceeded on endEvent: " + com_fossil_aog.HG().size());
                        com_fossil_aog.m4082p(hashMap);
                    } else {
                        this.aZG = length + com_fossil_aog.Ij().length;
                    }
                }
                com_fossil_aog.m4080a(elapsedRealtime);
            }
        }
    }

    public final synchronized void m4112a(amy com_fossil_amy) {
        Object obj = (com_fossil_amy.aWB == null || !"uncaught".equals(com_fossil_amy.aWB)) ? null : 1;
        this.aZH++;
        aoe com_fossil_aoe;
        if (this.aZv.size() < f1425f) {
            com_fossil_aoe = new aoe(this.aZp.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), com_fossil_amy.aWB, com_fossil_amy.aWR, com_fossil_amy.aWS, com_fossil_amy.aWT, com_fossil_amy.aWU, com_fossil_amy.aWV);
            this.aZv.add(com_fossil_aoe);
            app.m4178e(aWB, "Error logged: " + com_fossil_aoe.aWB);
        } else if (obj != null) {
            for (int i = 0; i < this.aZv.size(); i++) {
                com_fossil_aoe = (aoe) this.aZv.get(i);
                if (com_fossil_aoe.aWB != null && !"uncaught".equals(com_fossil_aoe.aWB)) {
                    this.aZv.set(i, new aoe(this.aZp.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), com_fossil_amy.aWB, com_fossil_amy.aWR, com_fossil_amy.aWS, com_fossil_amy.aWT, com_fossil_amy.aWU, com_fossil_amy.aWV));
                    break;
                }
            }
        } else {
            app.m4178e(aWB, "Max errors logged. No more errors logged.");
        }
    }

    static /* synthetic */ void m4106d(aol com_fossil_aol) {
        SharedPreferences sharedPreferences = apc.IO().baD.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        com_fossil_aol.aYx = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        aon.Il();
        com_fossil_aol.aZA = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", aon.In());
        com_fossil_aol.aZB = sharedPreferences.getString("com.flurry.sdk.api_key", "");
        com_fossil_aol.aZC = sharedPreferences.getString("com.flurry.sdk.variant_ids", null);
        if (TextUtils.isEmpty(com_fossil_aol.aZB) && com_fossil_aol.aZA > 0) {
            com_fossil_aol.aZB = apc.IO().f1440d;
        } else if (!com_fossil_aol.aZB.equals(apc.IO().f1440d)) {
            aon.Il();
            com_fossil_aol.aZA = aon.In();
        }
    }

    static /* synthetic */ void m4099a(aol com_fossil_aol, long j, long j2, long j3, int i) {
        aoj a = com_fossil_aol.m4097a(j, j2, j3, i);
        com_fossil_aol.aZq.clear();
        com_fossil_aol.aZq.add(a);
        com_fossil_aol.HW();
    }
}
