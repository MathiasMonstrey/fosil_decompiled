package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class bog extends bqi {
    private String bwT;
    private String bwZ;
    private String bxb;
    private long bxf;
    private int bzi;
    private String bzj;
    private long bzk;
    private int bzl;
    private String mAppId;

    bog(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final String Pl() {
        super.OP();
        try {
            return FirebaseInstanceId.VW().getId();
        } catch (IllegalStateException e) {
            super.Pf().Re().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
        int i = 1;
        String str = "unknown";
        String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i2 = Integer.MIN_VALUE;
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String packageName = super.getContext().getPackageName();
        PackageManager packageManager = super.getContext().getPackageManager();
        if (packageManager == null) {
            super.Pf().Rc().m5439d("PackageManager is null, app identity information might be inaccurate. appId", bol.ei(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                super.Pf().Rc().m5439d("Error retrieving app installer package name. appId", bol.ei(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(super.getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e2) {
                super.Pf().Rc().m5437a("Error retrieving package info. appId, appName", bol.ei(packageName), str3);
            }
        }
        this.mAppId = packageName;
        this.bxb = str;
        this.bwZ = str2;
        this.bzi = i2;
        this.bzj = str3;
        this.bzk = 0;
        bnm.Qh();
        Status aN = bgd.aN(super.getContext());
        int i3 = (aN == null || !aN.Kb()) ? 0 : 1;
        if (i3 == 0) {
            if (aN == null) {
                super.Pf().Rc().log("GoogleService failed to initialize (no status)");
            } else {
                super.Pf().Rc().m5437a("GoogleService failed to initialize, status", Integer.valueOf(aN.getStatusCode()), aN.getStatusMessage());
            }
        }
        if (i3 != 0) {
            Boolean dW = super.Ph().dW("firebase_analytics_collection_enabled");
            if (super.Ph().Qj()) {
                super.Pf().Rg().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                i3 = 0;
            } else if (dW != null && !dW.booleanValue()) {
                super.Pf().Rg().log("Collection disabled with firebase_analytics_collection_enabled=0");
                i3 = 0;
            } else if (dW == null && bnm.Oi()) {
                super.Pf().Rg().log("Collection disabled with google_app_measurement_enable=0");
                i3 = 0;
            } else {
                super.Pf().Ri().log("Collection enabled");
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        this.bwT = "";
        this.bxf = 0;
        bnm.Qh();
        try {
            String Oh = bgd.Oh();
            if (TextUtils.isEmpty(Oh)) {
                Oh = "";
            }
            this.bwT = Oh;
            if (i3 != 0) {
                super.Pf().Ri().m5437a("App package, google app id", this.mAppId, this.bwT);
            }
        } catch (IllegalStateException e3) {
            super.Pf().Rc().m5437a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", bol.ei(packageName), e3);
        }
        if (VERSION.SDK_INT >= 16) {
            if (!bjc.aO(super.getContext())) {
                i = 0;
            }
            this.bzl = i;
            return;
        }
        this.bzl = 0;
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    final String Pj() {
        RA();
        return this.mAppId;
    }

    final String QZ() {
        super.Pb().Sj().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final int Ra() {
        RA();
        return this.bzi;
    }

    final bnh ee(String str) {
        super.OP();
        String Pj = Pj();
        String gmpAppId = getGmpAppId();
        RA();
        String str2 = this.bwZ;
        long Ra = (long) Ra();
        RA();
        String str3 = this.bxb;
        long Pr = bnm.Pr();
        RA();
        super.OP();
        if (this.bzk == 0) {
            this.bzk = this.zzboe.Pb().m5610u(super.getContext(), super.getContext().getPackageName());
        }
        long j = this.bzk;
        boolean isEnabled = this.zzboe.isEnabled();
        boolean z = !super.Pg().bAp;
        String Pl = Pl();
        RA();
        long RK = this.zzboe.RK();
        RA();
        return new bnh(Pj, gmpAppId, str2, Ra, str3, Pr, j, str, isEnabled, z, Pl, 0, RK, this.bzl);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final String getGmpAppId() {
        RA();
        return this.bwT;
    }
}
