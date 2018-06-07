package com.fossil;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.core.CodedOutputStream;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class acw implements UncaughtExceptionHandler {
    static final FilenameFilter aIV = new C15821();
    static final Comparator<File> aIW = new C15909();
    static final Comparator<File> aIX = new Comparator<File>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2977c((File) obj, (File) obj2);
        }

        public int m2977c(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    static final FilenameFilter aIY = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return acw.aIZ.matcher(str).matches();
        }
    };
    private static final Pattern aIZ = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> aJa = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private final act aIK;
    private final IdManager aId;
    private final AtomicInteger aJb = new AtomicInteger(0);
    private final AtomicBoolean aJc = new AtomicBoolean(false);
    private final UncaughtExceptionHandler aJd;
    private final File aJe;
    private final AtomicBoolean aJf;
    private final BroadcastReceiver aJg;
    private final BroadcastReceiver aJh;
    private boolean aJi;
    private final acs aJj;
    private final add aJk;
    private final adk aJl;

    static class C15821 implements FilenameFilter {
        C15821() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    }

    class C15854 implements Callable<Void> {
        final /* synthetic */ acw aJp;

        C15854(acw com_fossil_acw) {
            this.aJp = com_fossil_acw;
        }

        public Void call() throws Exception {
            if (this.aJp.yd()) {
                this.aJp.aJk.aG(this.aJp.yc());
            } else {
                this.aJp.yf();
            }
            return null;
        }
    }

    class C15865 implements Callable<Boolean> {
        final /* synthetic */ acw aJp;

        C15865(acw com_fossil_acw) {
            this.aJp = com_fossil_acw;
        }

        public /* synthetic */ Object call() throws Exception {
            return xT();
        }

        public Boolean xT() throws Exception {
            if (this.aJp.aJf.get()) {
                emm.aEU().mo2950d("Fabric", "Skipping session finalization because a crash has already occurred.");
                return Boolean.valueOf(false);
            }
            adt xN = this.aJp.aJj.xN();
            if (xN != null) {
                this.aJp.m2988a(xN);
            }
            this.aJp.yg();
            this.aJp.yf();
            emm.aEU().mo2950d("Fabric", "Open sessions were closed and a new session was opened.");
            return Boolean.valueOf(true);
        }
    }

    class C15876 implements Runnable {
        final /* synthetic */ acw aJp;

        C15876(acw com_fossil_acw) {
            this.aJp = com_fossil_acw;
        }

        public void run() {
            this.aJp.m3008c(this.aJp.m2994a(acr.aIC));
        }
    }

    static class C15909 implements Comparator<File> {
        C15909() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2978c((File) obj, (File) obj2);
        }

        public int m2978c(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    static class C1591a implements FilenameFilter {
        private C1591a() {
        }

        public boolean accept(File file, String str) {
            return !acw.aIV.accept(file, str) && acw.aIZ.matcher(str).matches();
        }
    }

    static class C1592b implements FilenameFilter {
        private final String string;

        public C1592b(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(".cls_temp");
        }
    }

    static class C1593c implements FilenameFilter {
        private final String sessionId;

        public C1593c(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.sessionId + ".cls") || !str.contains(this.sessionId) || str.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

    acw(UncaughtExceptionHandler uncaughtExceptionHandler, acu com_fossil_acu, act com_fossil_act, IdManager idManager, adk com_fossil_adk, acs com_fossil_acs) {
        this.aJd = uncaughtExceptionHandler;
        this.aIK = com_fossil_act;
        this.aId = idManager;
        this.aJj = com_fossil_acs;
        this.aJl = com_fossil_adk;
        this.aJf = new AtomicBoolean(false);
        this.aJe = com_fossil_acs.xl();
        this.aJk = new add(com_fossil_acs.getContext(), this.aJe);
        m2985a(com_fossil_acu);
        this.aJh = new BroadcastReceiver(this) {
            final /* synthetic */ acw aJp;

            {
                this.aJp = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.aJp.aJi = true;
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        this.aJg = new BroadcastReceiver(this) {
            final /* synthetic */ acw aJp;

            {
                this.aJp = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.aJp.aJi = false;
            }
        };
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        Context context = com_fossil_acs.getContext();
        context.registerReceiver(this.aJh, intentFilter);
        context.registerReceiver(this.aJg, intentFilter2);
        this.aJc.set(true);
    }

    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        this.aJf.set(true);
        try {
            emm.aEU().mo2950d("Fabric", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            if (!this.aJc.getAndSet(true)) {
                emm.aEU().mo2950d("Fabric", "Unregistering power receivers.");
                Context context = this.aJj.getContext();
                context.unregisterReceiver(this.aJh);
                context.unregisterReceiver(this.aJg);
            }
            final Date date = new Date();
            this.aIK.m2974a(new Callable<Void>(this) {
                final /* synthetic */ acw aJp;

                public Void call() throws Exception {
                    this.aJp.m2991a(date, thread, th);
                    return null;
                }
            });
            emm.aEU().mo2950d("Fabric", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.aJd.uncaughtException(thread, th);
            this.aJf.set(false);
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "An error occurred in the uncaught exception handler", e);
            emm.aEU().mo2950d("Fabric", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.aJd.uncaughtException(thread, th);
            this.aJf.set(false);
        } catch (Throwable th2) {
            emm.aEU().mo2950d("Fabric", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.aJd.uncaughtException(thread, th);
            this.aJf.set(false);
        }
    }

    private void m2991a(Date date, Thread thread, Throwable th) throws Exception {
        m2996b(date, thread, th);
        yg();
        yf();
        yj();
        if (!this.aJj.xO()) {
            ym();
        }
    }

    boolean ya() {
        return this.aJf.get();
    }

    private void m2985a(acu com_fossil_acu) {
        emm.aEU().mo2950d("Fabric", "Checking for previous crash marker.");
        File file = new File(this.aJj.xl(), "crash_marker");
        if (file.exists()) {
            file.delete();
            if (com_fossil_acu != null) {
                try {
                    com_fossil_acu.xV();
                } catch (Throwable e) {
                    emm.aEU().mo2953g("Fabric", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
                }
            }
        }
    }

    void m3005a(final long j, final String str) {
        this.aIK.m2975b(new Callable<Void>(this) {
            final /* synthetic */ acw aJp;

            public Void call() throws Exception {
                if (!this.aJp.aJf.get()) {
                    this.aJp.aJk.m3028a(j, str);
                }
                return null;
            }
        });
    }

    private void m2996b(Date date, Thread thread, Throwable th) {
        Closeable com_fossil_acr;
        Throwable e;
        Flushable flushable = null;
        try {
            Closeable closeable;
            new File(this.aJe, "crash_marker").createNewFile();
            String yc = yc();
            if (yc != null) {
                acs.av(yc);
                com_fossil_acr = new acr(this.aJe, yc + "SessionCrash");
                try {
                    flushable = CodedOutputStream.m2632d(com_fossil_acr);
                    m2982a(flushable, date, thread, th, AppMeasurement.CRASH_ORIGIN, true);
                    closeable = com_fossil_acr;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        emm.aEU().mo2953g("Fabric", "An error occurred in the fatal exception logger", e);
                        adb.m3022a(e, (OutputStream) com_fossil_acr);
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(com_fossil_acr, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        e = th2;
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(com_fossil_acr, "Failed to close fatal exception file output stream.");
                        throw e;
                    }
                }
            }
            emm.aEU().mo2953g("Fabric", "Tried to write a fatal exception while no session was open.", null);
            closeable = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            e = e3;
            com_fossil_acr = null;
            emm.aEU().mo2953g("Fabric", "An error occurred in the fatal exception logger", e);
            adb.m3022a(e, (OutputStream) com_fossil_acr);
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(com_fossil_acr, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            e = th3;
            com_fossil_acr = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(com_fossil_acr, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m2988a(adt com_fossil_adt) throws IOException {
        Closeable com_fossil_acr;
        Throwable th;
        Closeable closeable;
        Flushable flushable;
        Throwable th2;
        Flushable flushable2;
        Flushable flushable3 = null;
        try {
            String yc = yc();
            if (yc != null) {
                acs.av(yc);
                com_fossil_acr = new acr(this.aJe, yc + "SessionCrash");
                try {
                    flushable3 = CodedOutputStream.m2632d(com_fossil_acr);
                } catch (Throwable e) {
                    th = e;
                    closeable = com_fossil_acr;
                    flushable = flushable3;
                    th2 = th;
                    try {
                        emm.aEU().mo2953g("Fabric", "An error occurred in the native crash logger", th2);
                        adb.m3022a(th2, (OutputStream) closeable);
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th3) {
                        th2 = th3;
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
                        throw th2;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    closeable = com_fossil_acr;
                    flushable = flushable3;
                    th2 = th;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
                try {
                    adf.m3053a(com_fossil_adt, this.aJk, new ade(this.aJe).aJ(yc), flushable3);
                } catch (Throwable e22) {
                    th = e22;
                    closeable = com_fossil_acr;
                    flushable = flushable3;
                    th2 = th;
                    emm.aEU().mo2953g("Fabric", "An error occurred in the native crash logger", th2);
                    adb.m3022a(th2, (OutputStream) closeable);
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable e222) {
                    th = e222;
                    closeable = com_fossil_acr;
                    flushable = flushable3;
                    th2 = th;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
            }
            emm.aEU().mo2953g("Fabric", "Tried to write a native crash while no session was open.", null);
            Object obj = flushable3;
            CommonUtils.a(flushable3, "Failed to flush to session begin file.");
            CommonUtils.a(com_fossil_acr, "Failed to close fatal exception file output stream.");
        } catch (Throwable e3) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e3;
            flushable = flushable2;
            emm.aEU().mo2953g("Fabric", "An error occurred in the native crash logger", th2);
            adb.m3022a(th2, (OutputStream) closeable);
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable e32) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e32;
            flushable = flushable2;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(closeable, "Failed to close fatal exception file output stream.");
            throw th2;
        }
    }

    void m3007b(final String str, final String str2, final String str3) {
        this.aIK.m2975b(new Callable<Void>(this) {
            final /* synthetic */ acw aJp;

            public Void call() throws Exception {
                new ade(this.aJp.aJe).m3033a(this.aJp.yc(), new adm(str, str2, str3));
                return null;
            }
        });
    }

    void m3006a(final Map<String, String> map) {
        this.aIK.m2975b(new Callable<Void>(this) {
            final /* synthetic */ acw aJp;

            public Void call() throws Exception {
                new ade(this.aJp.aJe).m3034a(this.aJp.yc(), map);
                return null;
            }
        });
    }

    void yb() {
        this.aIK.m2975b(new C15854(this));
    }

    private String yc() {
        File[] a = m2994a(new C1592b("BeginSession"));
        Arrays.sort(a, aIW);
        return a.length > 0 ? m3004r(a[0]) : null;
    }

    private String m3004r(File file) {
        return file.getName().substring(0, 35);
    }

    boolean yd() {
        return yi().length > 0;
    }

    boolean ye() {
        return ((Boolean) this.aIK.m2974a(new C15865(this))).booleanValue();
    }

    private void yf() throws Exception {
        Date date = new Date();
        String com_fossil_acq = new acq(this.aId).toString();
        emm.aEU().mo2950d("Fabric", "Opening an new session with ID " + com_fossil_acq);
        this.aJk.aG(com_fossil_acq);
        m2990a(com_fossil_acq, date);
        aB(com_fossil_acq);
        aC(com_fossil_acq);
        aD(com_fossil_acq);
    }

    private void yg() throws Exception {
        fh(8);
        String yc = yc();
        if (yc != null) {
            aE(yc);
            eps xR = this.aJj.xR();
            if (xR != null) {
                int i = xR.dQv;
                emm.aEU().mo2950d("Fabric", "Closing all open sessions.");
                File[] yi = yi();
                if (yi != null && yi.length > 0) {
                    for (File file : yi) {
                        String r = m3004r(file);
                        emm.aEU().mo2950d("Fabric", "Closing session: " + r);
                        m2989a(file, r, i);
                    }
                    return;
                }
                return;
            }
            emm.aEU().mo2950d("Fabric", "Unable to close session. Settings are not loaded.");
            return;
        }
        emm.aEU().mo2950d("Fabric", "No open sessions exist.");
    }

    private void m2984a(acr com_fossil_acr) {
        if (com_fossil_acr != null) {
            try {
                com_fossil_acr.xB();
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void az(String str) {
        for (File delete : aA(str)) {
            delete.delete();
        }
    }

    private File[] aA(String str) {
        return m2994a(new C1593c(str));
    }

    private File[] yh() {
        return m2994a(aIV);
    }

    File[] yi() {
        return m2994a(new C1592b("BeginSession"));
    }

    private File[] m2994a(FilenameFilter filenameFilter) {
        return m2997b(this.aJe.listFiles(filenameFilter));
    }

    private File[] m2997b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m3003g(String str, int i) {
        adn.m3089a(this.aJe, new C1592b(str + "SessionEvent"), i, aIX);
    }

    void yj() {
        adn.m3089a(this.aJe, aIV, 4, aIX);
    }

    private void fh(int i) {
        int i2 = 0;
        Set hashSet = new HashSet();
        File[] yi = yi();
        Arrays.sort(yi, aIW);
        int min = Math.min(i, yi.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(m3004r(yi[i3]));
        }
        File[] a = m2994a(new C1591a());
        int length = a.length;
        while (i2 < length) {
            File file = a[i2];
            Object name = file.getName();
            Matcher matcher = aIZ.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                emm.aEU().mo2950d("Fabric", "Trimming open session file: " + name);
                file.delete();
            }
            i2++;
        }
    }

    void yk() {
        this.aIK.m2976e(new C15876(this));
    }

    void m3008c(File[] fileArr) {
        yl();
        for (File file : fileArr) {
            emm.aEU().mo2950d("Fabric", "Found invalid session part file: " + file);
            final String r = m3004r(file);
            FilenameFilter c15887 = new FilenameFilter(this) {
                final /* synthetic */ acw aJp;

                public boolean accept(File file, String str) {
                    return str.startsWith(r);
                }
            };
            emm.aEU().mo2950d("Fabric", "Deleting all part files for invalid session: " + r);
            for (File file2 : m2994a(c15887)) {
                emm.aEU().mo2950d("Fabric", "Deleting session file: " + file2);
                file2.delete();
            }
        }
    }

    private void yl() {
        File file = new File(this.aJj.xl(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    private void m2990a(String str, Date date) throws Exception {
        Closeable com_fossil_acr;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            com_fossil_acr = new acr(this.aJe, str + "BeginSession");
            try {
                flushable = CodedOutputStream.m2632d(com_fossil_acr);
                this.aJl.m3085a((CodedOutputStream) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.aJj.getVersion()}), date.getTime() / 1000);
                CommonUtils.a(flushable, "Failed to flush to session begin file.");
                CommonUtils.a(com_fossil_acr, "Failed to close begin session file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = com_fossil_acr;
                try {
                    adb.m3022a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    com_fossil_acr = outputStream;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(com_fossil_acr, "Failed to close begin session file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.a(flushable, "Failed to flush to session begin file.");
                CommonUtils.a(com_fossil_acr, "Failed to close begin session file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            adb.m3022a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            com_fossil_acr = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(com_fossil_acr, "Failed to close begin session file.");
            throw e;
        }
    }

    private void aB(String str) throws Exception {
        Closeable com_fossil_acr;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            com_fossil_acr = new acr(this.aJe, str + "SessionApp");
            try {
                flushable = CodedOutputStream.m2632d(com_fossil_acr);
                this.aJl.m3087a((CodedOutputStream) flushable, this.aJj.getPackageName(), this.aJj.xG(), this.aJj.xF(), this.aId.aFt(), DeliveryMechanism.determineFrom(this.aJj.getInstallerPackageName()).getId());
                CommonUtils.a(flushable, "Failed to flush to session app file.");
                CommonUtils.a(com_fossil_acr, "Failed to close session app file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = com_fossil_acr;
                try {
                    adb.m3022a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    com_fossil_acr = outputStream;
                    CommonUtils.a(flushable, "Failed to flush to session app file.");
                    CommonUtils.a(com_fossil_acr, "Failed to close session app file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.a(flushable, "Failed to flush to session app file.");
                CommonUtils.a(com_fossil_acr, "Failed to close session app file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            adb.m3022a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            com_fossil_acr = null;
            CommonUtils.a(flushable, "Failed to flush to session app file.");
            CommonUtils.a(com_fossil_acr, "Failed to close session app file.");
            throw e;
        }
    }

    private void aC(String str) throws Exception {
        Closeable com_fossil_acr;
        Throwable e;
        Flushable flushable = null;
        try {
            com_fossil_acr = new acr(this.aJe, str + "SessionOS");
            try {
                flushable = CodedOutputStream.m2632d(com_fossil_acr);
                this.aJl.m3088a((CodedOutputStream) flushable, CommonUtils.eB(this.aJj.getContext()));
                CommonUtils.a(flushable, "Failed to flush to session OS file.");
                CommonUtils.a(com_fossil_acr, "Failed to close session OS file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    adb.m3022a(e, (OutputStream) com_fossil_acr);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(flushable, "Failed to flush to session OS file.");
                    CommonUtils.a(com_fossil_acr, "Failed to close session OS file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            com_fossil_acr = null;
            adb.m3022a(e, (OutputStream) com_fossil_acr);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            com_fossil_acr = null;
            CommonUtils.a(flushable, "Failed to flush to session OS file.");
            CommonUtils.a(com_fossil_acr, "Failed to close session OS file.");
            throw e;
        }
    }

    private void aD(String str) throws Exception {
        Throwable e;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        Flushable flushable = null;
        try {
            OutputStream com_fossil_acr = new acr(this.aJe, str + "SessionDevice");
            try {
                flushable = CodedOutputStream.m2632d(com_fossil_acr);
                Context context = this.aJj.getContext();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                this.aJl.m3084a((CodedOutputStream) flushable, this.aId.aFx(), CommonUtils.aFn(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.aFo(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.eA(context), this.aId.xy(), CommonUtils.eC(context), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.a(flushable, "Failed to flush session device info.");
                CommonUtils.a(com_fossil_acr, "Failed to close session device file.");
            } catch (Exception e2) {
                e = e2;
                outputStream2 = com_fossil_acr;
                try {
                    adb.m3022a(e, outputStream2);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    outputStream = outputStream2;
                    CommonUtils.a(flushable, "Failed to flush session device info.");
                    CommonUtils.a(outputStream, "Failed to close session device file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.a(flushable, "Failed to flush session device info.");
                CommonUtils.a(outputStream, "Failed to close session device file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            adb.m3022a(e, outputStream2);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            outputStream = null;
            CommonUtils.a(flushable, "Failed to flush session device info.");
            CommonUtils.a(outputStream, "Failed to close session device file.");
            throw e;
        }
    }

    private void aE(String str) throws Exception {
        Closeable com_fossil_acr;
        Throwable e;
        Flushable flushable = null;
        try {
            com_fossil_acr = new acr(this.aJe, str + "SessionUser");
            try {
                flushable = CodedOutputStream.m2632d(com_fossil_acr);
                adm aF = aF(str);
                if (aF.isEmpty()) {
                    CommonUtils.a(flushable, "Failed to flush session user file.");
                    CommonUtils.a(com_fossil_acr, "Failed to close session user file.");
                    return;
                }
                this.aJl.m3086a((CodedOutputStream) flushable, aF.id, aF.name, aF.email);
                CommonUtils.a(flushable, "Failed to flush session user file.");
                CommonUtils.a(com_fossil_acr, "Failed to close session user file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    adb.m3022a(e, (OutputStream) com_fossil_acr);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(flushable, "Failed to flush session user file.");
                    CommonUtils.a(com_fossil_acr, "Failed to close session user file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            com_fossil_acr = null;
            adb.m3022a(e, (OutputStream) com_fossil_acr);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            com_fossil_acr = null;
            CommonUtils.a(flushable, "Failed to flush session user file.");
            CommonUtils.a(com_fossil_acr, "Failed to close session user file.");
            throw e;
        }
    }

    private adm aF(String str) {
        return ya() ? new adm(this.aJj.xI(), this.aJj.getUserName(), this.aJj.xJ()) : new ade(this.aJe).aI(str);
    }

    private void m2982a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map map;
        Context context = this.aJj.getContext();
        long time = date.getTime() / 1000;
        float ex = CommonUtils.ex(context);
        int k = CommonUtils.k(context, this.aJi);
        boolean ey = CommonUtils.ey(context);
        int i = context.getResources().getConfiguration().orientation;
        long aFo = CommonUtils.aFo() - CommonUtils.ew(context);
        long mj = CommonUtils.mj(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a = CommonUtils.a(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.j(context, "com.crashlytics.CollectCustomKeys", true)) {
            Map attributes = this.aJj.getAttributes();
            if (attributes == null || attributes.size() <= 1) {
                map = attributes;
            } else {
                Map treeMap = new TreeMap(attributes);
            }
        } else {
            map = new TreeMap();
        }
        this.aJl.m3083a(codedOutputStream, time, thread, th, str, threadArr, ex, k, ey, i, aFo, mj, a, linkedList, stackTrace, this.aJk, map);
    }

    private void m2989a(File file, String str, int i) {
        boolean z;
        Closeable com_fossil_acr;
        Flushable d;
        Throwable e;
        Closeable closeable;
        acr com_fossil_acr2 = null;
        emm.aEU().mo2950d("Fabric", "Collecting session parts for ID " + str);
        File[] a = m2994a(new C1592b(str + "SessionCrash"));
        boolean z2 = a != null && a.length > 0;
        emm.aEU().mo2950d("Fabric", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a2 = m2994a(new C1592b(str + "SessionEvent"));
        if (a2 == null || a2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        emm.aEU().mo2950d("Fabric", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            try {
                com_fossil_acr = new acr(this.aJe, str);
                try {
                    d = CodedOutputStream.m2632d(com_fossil_acr);
                } catch (Exception e2) {
                    e = e2;
                    d = null;
                    closeable = com_fossil_acr;
                    try {
                        emm.aEU().mo2953g("Fabric", "Failed to write session file for session ID: " + str, e);
                        adb.m3022a(e, (OutputStream) com_fossil_acr2);
                        CommonUtils.a(d, "Error flushing session file stream");
                        m2984a(com_fossil_acr2);
                        emm.aEU().mo2950d("Fabric", "Removing session part files for ID " + str);
                        az(str);
                    } catch (Throwable th) {
                        e = th;
                        Object obj = com_fossil_acr2;
                        CommonUtils.a(d, "Error flushing session file stream");
                        CommonUtils.a(com_fossil_acr, "Failed to close CLS file");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    d = null;
                    CommonUtils.a(d, "Error flushing session file stream");
                    CommonUtils.a(com_fossil_acr, "Failed to close CLS file");
                    throw e;
                }
                try {
                    emm.aEU().mo2950d("Fabric", "Collecting SessionStart data for session ID " + str);
                    m2980a((CodedOutputStream) d, file);
                    d.m2647f(4, new Date().getTime() / 1000);
                    d.m2649o(5, z2);
                    m2981a((CodedOutputStream) d, str);
                    if (z) {
                        File[] a3;
                        if (a2.length > i) {
                            emm.aEU().mo2950d("Fabric", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
                            m3003g(str, i);
                            a3 = m2994a(new C1592b(str + "SessionEvent"));
                        } else {
                            a3 = a2;
                        }
                        m2983a((CodedOutputStream) d, a3, str);
                    }
                    if (z2) {
                        m2980a((CodedOutputStream) d, a[0]);
                    }
                    d.bh(11, 1);
                    d.bi(12, 3);
                    CommonUtils.a(d, "Error flushing session file stream");
                    CommonUtils.a(com_fossil_acr, "Failed to close CLS file");
                } catch (Exception e3) {
                    e = e3;
                    closeable = com_fossil_acr;
                    emm.aEU().mo2953g("Fabric", "Failed to write session file for session ID: " + str, e);
                    adb.m3022a(e, (OutputStream) com_fossil_acr2);
                    CommonUtils.a(d, "Error flushing session file stream");
                    m2984a(com_fossil_acr2);
                    emm.aEU().mo2950d("Fabric", "Removing session part files for ID " + str);
                    az(str);
                } catch (Throwable th3) {
                    e = th3;
                    CommonUtils.a(d, "Error flushing session file stream");
                    CommonUtils.a(com_fossil_acr, "Failed to close CLS file");
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                d = null;
                emm.aEU().mo2953g("Fabric", "Failed to write session file for session ID: " + str, e);
                adb.m3022a(e, (OutputStream) com_fossil_acr2);
                CommonUtils.a(d, "Error flushing session file stream");
                m2984a(com_fossil_acr2);
                emm.aEU().mo2950d("Fabric", "Removing session part files for ID " + str);
                az(str);
            } catch (Throwable th4) {
                e = th4;
                d = null;
                com_fossil_acr = null;
                CommonUtils.a(d, "Error flushing session file stream");
                CommonUtils.a(com_fossil_acr, "Failed to close CLS file");
                throw e;
            }
        }
        emm.aEU().mo2950d("Fabric", "No events present for session ID " + str);
        emm.aEU().mo2950d("Fabric", "Removing session part files for ID " + str);
        az(str);
    }

    private void m2983a(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.dNJ);
        for (File name : fileArr) {
            try {
                emm.aEU().mo2950d("Fabric", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                m2980a(codedOutputStream, name);
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m2981a(CodedOutputStream codedOutputStream, String str) throws IOException {
        for (String str2 : new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"}) {
            File[] a = m2994a(new C1592b(str + str2));
            if (a.length == 0) {
                emm.aEU().mo2953g("Fabric", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                emm.aEU().mo2950d("Fabric", "Collecting " + str2 + " data for session ID " + str);
                m2980a(codedOutputStream, a[0]);
            }
        }
    }

    private void m2980a(CodedOutputStream codedOutputStream, File file) throws IOException {
        Throwable th;
        if (file.exists()) {
            byte[] bArr = new byte[((int) file.length())];
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                int i = 0;
                while (i < bArr.length) {
                    try {
                        int read = fileInputStream.read(bArr, i, bArr.length - i);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                codedOutputStream.m2639Q(bArr);
                return;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        emm.aEU().mo2953g("Fabric", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private void ym() {
        for (final File file : yh()) {
            this.aIK.m2976e(new Runnable(this) {
                final /* synthetic */ acw aJp;

                public void run() {
                    if (CommonUtils.eI(this.aJp.aJj.getContext())) {
                        emm.aEU().mo2950d("Fabric", "Attempting to send crash report at time of crash...");
                        acy a = this.aJp.aJj.m2972a(ept.aGA().aGB());
                        if (a != null) {
                            new adj(a).m3061a(new adl(file, acw.aJa));
                        }
                    }
                }
            });
        }
    }
}
