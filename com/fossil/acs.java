package com.fossil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.eni.C3473a;
import com.fossil.ept.C1572b;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ens(zy = {adp.class})
public class acs extends emr<Void> {
    private String aHV;
    private String aHl;
    private eov aHu;
    private final ConcurrentHashMap<String, String> aID;
    private File aIE;
    private acu aIF;
    private acw aIG;
    private String aIH;
    private float aII;
    private final adg aIJ;
    private act aIK;
    private adp aIL;
    private boolean disabled;
    private String installerPackageName;
    private String packageName;
    private final long startTime;
    private String userId;
    private String userName;
    private String versionName;

    class C15681 extends enu<Void> {
        final /* synthetic */ acs aIM;

        C15681(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public Void call() throws Exception {
            return this.aIM.xc();
        }

        public Priority xS() {
            return Priority.IMMEDIATE;
        }
    }

    class C15692 implements Callable<Void> {
        final /* synthetic */ acs aIM;

        C15692(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public Void call() throws Exception {
            this.aIM.aIE.createNewFile();
            emm.aEU().mo2950d("Fabric", "Initialization marker file created.");
            return null;
        }
    }

    class C15703 implements Callable<Boolean> {
        final /* synthetic */ acs aIM;

        C15703(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public /* synthetic */ Object call() throws Exception {
            return xT();
        }

        public Boolean xT() throws Exception {
            try {
                boolean delete = this.aIM.aIE.delete();
                emm.aEU().mo2950d("Fabric", "Initialization marker file removed: " + delete);
                return Boolean.valueOf(delete);
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    class C15714 implements Callable<Boolean> {
        final /* synthetic */ acs aIM;

        C15714(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public /* synthetic */ Object call() throws Exception {
            return xT();
        }

        public Boolean xT() throws Exception {
            return Boolean.valueOf(this.aIM.aIE.exists());
        }
    }

    class C15735 implements C1572b<Boolean> {
        final /* synthetic */ acs aIM;

        C15735(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public /* synthetic */ Object mo820c(epv com_fossil_epv) {
            return m2957b(com_fossil_epv);
        }

        public Boolean m2957b(epv com_fossil_epv) {
            boolean z = false;
            if (!com_fossil_epv.dQG.dQj) {
                return Boolean.valueOf(false);
            }
            if (!this.aIM.xP()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    class C15746 implements C1572b<Boolean> {
        final /* synthetic */ acs aIM;

        C15746(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
        }

        public /* synthetic */ Object mo820c(epv com_fossil_epv) {
            return m2959b(com_fossil_epv);
        }

        public Boolean m2959b(epv com_fossil_epv) {
            boolean z = true;
            Activity currentActivity = this.aIM.aFa().getCurrentActivity();
            if (!(currentActivity == null || currentActivity.isFinishing() || !this.aIM.xO())) {
                z = this.aIM.m2964a(currentActivity, com_fossil_epv.aJz);
            }
            return Boolean.valueOf(z);
        }
    }

    class C1579a {
        final /* synthetic */ acs aIM;
        private boolean aIR;
        private final CountDownLatch aIS;

        private C1579a(acs com_fossil_acs) {
            this.aIM = com_fossil_acs;
            this.aIR = false;
            this.aIS = new CountDownLatch(1);
        }

        void aF(boolean z) {
            this.aIR = z;
            this.aIS.countDown();
        }

        boolean xU() {
            return this.aIR;
        }

        void await() {
            try {
                this.aIS.await();
            } catch (InterruptedException e) {
            }
        }
    }

    protected /* synthetic */ Object xf() {
        return xc();
    }

    public acs() {
        this(1.0f, null, null, false);
    }

    acs(float f, acu com_fossil_acu, adg com_fossil_adg, boolean z) {
        this(f, com_fossil_acu, com_fossil_adg, z, enl.mk("Crashlytics Exception Handler"));
    }

    acs(float f, acu com_fossil_acu, adg com_fossil_adg, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.aIH = null;
        this.userName = null;
        this.aID = new ConcurrentHashMap();
        this.startTime = System.currentTimeMillis();
        this.aII = f;
        this.aIF = com_fossil_acu;
        this.aIJ = com_fossil_adg;
        this.disabled = z;
        this.aIK = new act(executorService);
    }

    protected boolean xh() {
        return m2970R(super.getContext());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m2970R(android.content.Context r9) {
        /*
        r8 = this;
        r7 = 0;
        r0 = r8.disabled;
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = r7;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = new com.fossil.eng;
        r0.<init>();
        r0 = r0.er(r9);
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r0 = r7;
        goto L_0x0006;
    L_0x0014:
        r1 = com.fossil.emm.aEU();
        r2 = "Fabric";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Initializing Crashlytics ";
        r3 = r3.append(r4);
        r4 = r8.getVersion();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.mo2954i(r2, r3);
        r1 = new java.io.File;
        r2 = r8.xl();
        r3 = "initialization_marker";
        r1.<init>(r2, r3);
        r8.aIE = r1;
        r8.m2969h(r9, r0);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r5 = new com.fossil.adk;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.getContext();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = r8.aHV;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = r8.getPackageName();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r5.<init>(r0, r1, r2);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = com.fossil.emm.aEU();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = "Fabric";
        r2 = "Installing exception handler...";
        r0.mo2950d(r1, r2);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = new com.fossil.acw;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = r8.aIF;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r3 = r8.aIK;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r4 = r8.aEZ();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r6 = r8;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r8.aIG = r0;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = r8.xM();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.aIG;	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0.yb();	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.aIG;	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = com.fossil.emm.aEU();	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = "Fabric";
        r3 = "Successfully installed exception handler.";
        r0.mo2950d(r2, r3);	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
    L_0x008b:
        if (r1 == 0) goto L_0x00ae;
    L_0x008d:
        r0 = io.fabric.sdk.android.services.common.CommonUtils.eI(r9);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        if (r0 == 0) goto L_0x00ae;
    L_0x0093:
        r8.xE();	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r0 = r7;
        goto L_0x0006;
    L_0x0099:
        r0 = move-exception;
        r1 = r7;
    L_0x009b:
        r2 = com.fossil.emm.aEU();	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r3 = "Fabric";
        r4 = "There was a problem installing the exception handler.";
        r2.mo2953g(r3, r4, r0);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        goto L_0x008b;
    L_0x00a7:
        r0 = move-exception;
        r1 = new io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
        r1.<init>(r0);
        throw r1;
    L_0x00ae:
        r0 = 1;
        goto L_0x0006;
    L_0x00b1:
        r0 = move-exception;
        r1 = com.fossil.emm.aEU();
        r2 = "Fabric";
        r3 = "Crashlytics was not started due to an exception during initialization";
        r1.mo2953g(r2, r3, r0);
        r0 = r7;
        goto L_0x0006;
    L_0x00c0:
        r0 = move-exception;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.acs.R(android.content.Context):boolean");
    }

    private void m2969h(Context context, String str) {
        eox com_fossil_acv = this.aIJ != null ? new acv(this.aIJ) : null;
        this.aHu = new eou(emm.aEU());
        this.aHu.mo2990a(com_fossil_acv);
        try {
            this.packageName = context.getPackageName();
            this.installerPackageName = aEZ().getInstallerPackageName();
            emm.aEU().mo2950d("Fabric", "Installer package name is: " + this.installerPackageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.packageName, 0);
            this.aHl = Integer.toString(packageInfo.versionCode);
            this.versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            this.aHV = CommonUtils.eH(context);
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "Error setting up app properties", e);
        }
        aEZ().aFB();
        m2971a(this.aHV, m2961S(context)).m2944m(str, this.packageName);
    }

    protected Void xc() {
        xK();
        this.aIG.yk();
        Object obj = 1;
        try {
            epv aGB = ept.aGA().aGB();
            if (aGB == null) {
                emm.aEU().aS("Fabric", "Received null settings, skipping initialization!");
                xL();
                return null;
            }
            if (aGB.dQG.dQl) {
                obj = null;
                this.aIG.ye();
                acy a = m2972a(aGB);
                if (a != null) {
                    new adj(a).m3060S(this.aII);
                } else {
                    emm.aEU().aS("Fabric", "Unable to create a call to upload reports.");
                }
            }
            if (obj != null) {
                try {
                    emm.aEU().mo2950d("Fabric", "Crash reporting disabled.");
                } catch (Throwable e) {
                    emm.aEU().mo2953g("Fabric", "Problem encountered during Crashlytics initialization.", e);
                } finally {
                    xL();
                }
            }
            xL();
            return null;
        } catch (Throwable e2) {
            Throwable th = e2;
            Object obj2 = obj;
            emm.aEU().mo2953g("Fabric", "Error dealing with settings", th);
            obj = obj2;
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getVersion() {
        return "2.3.3.61";
    }

    public static acs xD() {
        return (acs) emm.an(acs.class);
    }

    private void m2966b(int i, String str, String str2) {
        if (!this.disabled && aw("prior to logging messages.")) {
            this.aIG.m3005a(System.currentTimeMillis() - this.startTime, m2968c(i, str, str2));
        }
    }

    public void m2973a(int i, String str, String str2) {
        m2966b(i, str, str2);
        emm.aEU().mo2947a(i, "" + str, "" + str2, true);
    }

    public void au(String str) {
        if (!this.disabled) {
            this.userId = ax(str);
            this.aIG.m3007b(this.userId, this.userName, this.aIH);
        }
    }

    public void setString(String str, String str2) {
        if (!this.disabled) {
            if (str != null) {
                String ax = ax(str);
                if (this.aID.size() < 64 || this.aID.containsKey(ax)) {
                    this.aID.put(ax, str2 == null ? "" : ax(str2));
                    this.aIG.m3006a(this.aID);
                    return;
                }
                emm.aEU().mo2950d("Fabric", "Exceeded maximum number of custom attributes (64)");
            } else if (getContext() == null || !CommonUtils.eD(getContext())) {
                emm.aEU().mo2953g("Fabric", "Attempting to set custom attribute with null key, ignoring.", null);
            } else {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
        }
    }

    private void xE() {
        Callable c15681 = new C15681(this);
        for (enz a : aFc()) {
            c15681.m2954a(a);
        }
        Future submit = aFa().aET().submit(c15681);
        emm.aEU().mo2950d("Fabric", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            emm.aEU().mo2953g("Fabric", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            emm.aEU().mo2953g("Fabric", "Crashlytics timed out during initialization.", e22);
        }
    }

    static void av(String str) {
        abn com_fossil_abn = (abn) emm.an(abn.class);
        if (com_fossil_abn != null) {
            com_fossil_abn.m2874a(new C3473a(str));
        }
    }

    Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.aID);
    }

    aco m2971a(String str, boolean z) {
        return new aco(str, z);
    }

    String getPackageName() {
        return this.packageName;
    }

    String getInstallerPackageName() {
        return this.installerPackageName;
    }

    String xF() {
        return this.versionName;
    }

    String xG() {
        return this.aHl;
    }

    String xj() {
        return CommonUtils.aa(getContext(), "com.crashlytics.ApiEndpoint");
    }

    acw xH() {
        return this.aIG;
    }

    String xI() {
        return aEZ().aFs() ? this.userId : null;
    }

    String xJ() {
        return aEZ().aFs() ? this.aIH : null;
    }

    String getUserName() {
        return aEZ().aFs() ? this.userName : null;
    }

    void xK() {
        this.aIK.m2974a(new C15692(this));
    }

    void xL() {
        this.aIK.m2975b(new C15703(this));
    }

    boolean xM() {
        return ((Boolean) this.aIK.m2974a(new C15714(this))).booleanValue();
    }

    adt xN() {
        if (this.aIL != null) {
            return this.aIL.yM();
        }
        return null;
    }

    File xl() {
        return new epa(this).getFilesDir();
    }

    boolean xO() {
        return ((Boolean) ept.aGA().m11037a(new C15735(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean xP() {
        return new epc(this).aGu().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void aE(boolean z) {
        epb com_fossil_epc = new epc(this);
        com_fossil_epc.mo2992b(com_fossil_epc.edit().putBoolean("always_send_reports_opt_in", z));
    }

    boolean xQ() {
        return ((Boolean) ept.aGA().m11037a(new C15746(this), Boolean.valueOf(true))).booleanValue();
    }

    acy m2972a(epv com_fossil_epv) {
        if (com_fossil_epv != null) {
            return new acz(this, xj(), com_fossil_epv.dQE.dQa, this.aHu);
        }
        return null;
    }

    private boolean m2964a(Activity activity, epr com_fossil_epr) {
        final ada com_fossil_ada = new ada(activity, com_fossil_epr);
        final C1579a c1579a = new C1579a();
        final Activity activity2 = activity;
        final epr com_fossil_epr2 = com_fossil_epr;
        activity.runOnUiThread(new Runnable(this) {
            final /* synthetic */ acs aIM;

            class C15751 implements OnClickListener {
                final /* synthetic */ C15787 aIQ;

                C15751(C15787 c15787) {
                    this.aIQ = c15787;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c1579a.aF(true);
                    dialogInterface.dismiss();
                }
            }

            class C15762 implements OnClickListener {
                final /* synthetic */ C15787 aIQ;

                C15762(C15787 c15787) {
                    this.aIQ = c15787;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c1579a.aF(false);
                    dialogInterface.dismiss();
                }
            }

            class C15773 implements OnClickListener {
                final /* synthetic */ C15787 aIQ;

                C15773(C15787 c15787) {
                    this.aIQ = c15787;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.aIQ.aIM.aE(true);
                    c1579a.aF(true);
                    dialogInterface.dismiss();
                }
            }

            public void run() {
                Builder builder = new Builder(activity2);
                OnClickListener c15751 = new C15751(this);
                float f = activity2.getResources().getDisplayMetrics().density;
                int a = this.aIM.m2967c(f, 5);
                View textView = new TextView(activity2);
                textView.setAutoLinkMask(15);
                textView.setText(com_fossil_ada.getMessage());
                textView.setTextAppearance(activity2, 16973892);
                textView.setPadding(a, a, a, a);
                textView.setFocusable(false);
                View scrollView = new ScrollView(activity2);
                scrollView.setPadding(this.aIM.m2967c(f, 14), this.aIM.m2967c(f, 2), this.aIM.m2967c(f, 10), this.aIM.m2967c(f, 12));
                scrollView.addView(textView);
                builder.setView(scrollView).setTitle(com_fossil_ada.getTitle()).setCancelable(false).setNeutralButton(com_fossil_ada.yp(), c15751);
                if (com_fossil_epr2.dQp) {
                    builder.setNegativeButton(com_fossil_ada.yr(), new C15762(this));
                }
                if (com_fossil_epr2.dQr) {
                    builder.setPositiveButton(com_fossil_ada.yq(), new C15773(this));
                }
                builder.show();
            }
        });
        emm.aEU().mo2950d("Fabric", "Waiting for user opt-in.");
        c1579a.await();
        return c1579a.xU();
    }

    eps xR() {
        epv aGB = ept.aGA().aGB();
        return aGB == null ? null : aGB.dQF;
    }

    private boolean m2961S(Context context) {
        return CommonUtils.j(context, "com.crashlytics.RequireBuildId", true);
    }

    private static String m2968c(int i, String str, String str2) {
        return CommonUtils.pc(i) + "/" + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2;
    }

    private static boolean aw(String str) {
        acs xD = xD();
        if (xD != null && xD.aIG != null) {
            return true;
        }
        emm.aEU().mo2953g("Fabric", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static String ax(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > 1024) {
            return str.substring(0, 1024);
        }
        return str;
    }

    private int m2967c(float f, int i) {
        return (int) (((float) i) * f);
    }
}
