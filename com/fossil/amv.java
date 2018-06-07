package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.lo;
import com.flurry.sdk.lo.C1544a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class amv {
    private static final String aWB = amv.class.getSimpleName();
    private static amw aWC = null;
    private static final apk<lo> aWD = new C17141();
    private static boolean aWE = false;
    private static boolean aWF = true;
    private static boolean aWG = false;
    private static boolean aWH = true;
    private static List<Object> aWI = new ArrayList();
    private static String aWJ = null;
    private static int f1376e = 5;
    private static long f1377f = 10000;

    class C17141 implements apk<lo> {
        C17141() {
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            final lo loVar = (lo) com_fossil_apj;
            apc.IO().m4158a(new Runnable(this) {
                final /* synthetic */ C17141 aWL;

                public final void run() {
                    switch (C17152.f1374a[loVar.f1359c - 1]) {
                        case 1:
                            if (amv.aWC != null) {
                                amv.aWC.onSessionStarted();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    static /* synthetic */ class C17152 {
        static final /* synthetic */ int[] f1374a = new int[C1544a.m2793a().length];

        static {
            try {
                f1374a[C1544a.f1358f - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static class C1716a {
        private static amw aWC = null;
        private boolean aWF = false;
        private boolean aWG = true;
        private boolean aWM = false;
        private long aWN = 10000;
        private boolean aWO = true;
        List<Object> aWP = new ArrayList();
        private int f1375d = 5;

        public C1716a m3937b(amw com_fossil_amw) {
            aWC = com_fossil_amw;
            return this;
        }

        public C1716a aS(boolean z) {
            this.aWM = z;
            return this;
        }

        public C1716a m3936O(long j) {
            this.aWN = j;
            return this;
        }

        public void m3938j(Context context, String str) {
            amv.m3944a(aWC, this.aWM, this.f1375d, this.aWN, this.aWO, this.aWF, this.aWG, this.aWP, context, str);
        }
    }

    private amv() {
    }

    @Deprecated
    public static void m3943a(amw com_fossil_amw) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (com_fossil_amw == null) {
            app.m4182x(aWB, "Listener cannot be null");
            apl.IW().m4170b("com.flurry.android.sdk.FlurrySessionEvent", aWD);
        } else {
            aWC = com_fossil_amw;
            apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionEvent", aWD);
        }
    }

    @Deprecated
    public static void aP(boolean z) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (z) {
            app.HO();
        } else {
            app.HJ();
        }
    }

    @Deprecated
    public static void hh(int i) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else {
            app.m4172a(i);
        }
    }

    @Deprecated
    public static void m3939N(long j) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (j < 5000) {
            app.m4182x(aWB, "Invalid time set for session resumption: " + j);
        } else {
            aqp.Jf().m4242a("ContinueSessionMillis", (Object) Long.valueOf(j));
        }
    }

    @Deprecated
    public static void aQ(boolean z) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else {
            aqp.Jf().m4242a("CaptureUncaughtExceptions", (Object) Boolean.valueOf(z));
        }
    }

    @Deprecated
    public static void aR(boolean z) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
            return;
        }
        aqp.Jf().m4242a("ProtonEnabled", (Object) Boolean.valueOf(z));
        if (!z) {
            aqp.Jf().m4242a("analyticsEnabled", (Object) Boolean.valueOf(true));
        }
    }

    @Deprecated
    public static synchronized void m3946i(Context context, String str) {
        synchronized (amv.class) {
            if (VERSION.SDK_INT < 16) {
                app.m4182x(aWB, "Device SDK Version older than 16");
            } else if (context == null) {
                throw new NullPointerException("Null context");
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("API key not specified");
            } else {
                if (apc.IO() != null) {
                    app.m4178e(aWB, "Flurry is already initialized");
                }
                try {
                    ard.HJ();
                    apc.m4156k(context, str);
                } catch (Throwable th) {
                    app.m4175b(aWB, "", th);
                }
            }
        }
    }

    public static void ce(String str) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (str == null) {
            app.m4182x(aWB, "String versionName passed to setVersionName was null.");
        } else {
            aqp.Jf().m4242a("VersionName", (Object) str);
        }
    }

    public static void m3940T(Context context) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (context == null) {
            throw new NullPointerException("Null context");
        } else if (apc.IO() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        } else {
            try {
                aqm.Jc().m4233W(context);
            } catch (Throwable th) {
                app.m4175b(aWB, "", th);
            }
        }
    }

    public static void m3941U(Context context) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (context == null) {
            throw new NullPointerException("Null context");
        } else if (apc.IO() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before ending a session");
        } else {
            try {
                aqm.Jc().m4236c(context);
            } catch (Throwable th) {
                app.m4175b(aWB, "", th);
            }
        }
    }

    public static boolean HB() {
        boolean z = false;
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else {
            try {
                z = aqm.Jc().m4237c();
            } catch (Throwable th) {
                app.m4175b(aWB, "", th);
            }
        }
        return z;
    }

    public static FlurryEventRecordStatus m3942a(String str, Map<String, String> map, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (str == null) {
            app.m4182x(aWB, "String eventId passed to logEvent was null.");
        } else {
            if (map == null) {
                app.m4183y(aWB, "String parameters passed to logEvent was null.");
            }
            try {
                flurryEventRecordStatus = ana.HD().m3955b(str, (Map) map, z);
            } catch (Throwable th) {
                app.m4175b(aWB, "Failed to log event: " + str, th);
            }
        }
        return flurryEventRecordStatus;
    }

    public static void m3945a(String str, String str2, Throwable th) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (str == null) {
            app.m4182x(aWB, "String errorId passed to onError was null.");
        } else if (str2 == null) {
            app.m4182x(aWB, "String message passed to onError was null.");
        } else if (th == null) {
            app.m4182x(aWB, "Throwable passed to onError was null.");
        } else {
            try {
                ana.HD().m3956b(str, str2, th);
            } catch (Throwable th2) {
                app.m4175b(aWB, "", th2);
            }
        }
    }

    public static void setUserId(String str) {
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else if (str == null) {
            app.m4182x(aWB, "String userId passed to setUserId was null.");
        } else {
            aqp.Jf().m4242a("UserId", (Object) aqv.cx(str));
        }
    }

    static /* synthetic */ void m3944a(amw com_fossil_amw, boolean z, int i, long j, boolean z2, boolean z3, boolean z4, List list, Context context, String str) {
        aWC = com_fossil_amw;
        m3943a(com_fossil_amw);
        aWE = z;
        aP(z);
        f1376e = i;
        hh(i);
        f1377f = j;
        m3939N(j);
        aWF = z2;
        aQ(z2);
        aWG = z3;
        aR(z3);
        aWH = z4;
        if (VERSION.SDK_INT < 16) {
            app.m4182x(aWB, "Device SDK Version older than 16");
        } else {
            aqp.Jf().m4242a("IncludeBackgroundSessionsInMetrics", (Object) Boolean.valueOf(z4));
        }
        aWI = list;
        aWJ = str;
        m3946i(context, aWJ);
    }
}
