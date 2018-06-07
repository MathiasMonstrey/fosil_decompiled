package com.fossil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import com.fossil.eni.C3473a;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.io.File;
import java.util.Map;
import java.util.UUID;

public class abn extends emr<Boolean> {
    private String aHl;
    private epb aHm;
    private long aHn;
    abz aHo;
    private String versionName;

    protected /* synthetic */ Object xf() {
        return xi();
    }

    public static abn xg() {
        return (abn) emm.an(abn.class);
    }

    public void m2874a(C3473a c3473a) {
        if (this.aHo != null) {
            this.aHo.aq(c3473a.aFq());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean xh() {
        try {
            this.aHm = new epc(this);
            Context context = getContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.aHl = Integer.toString(packageInfo.versionCode);
            this.versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                this.aHn = packageInfo.firstInstallTime;
            } else {
                this.aHn = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified();
            }
            return true;
        } catch (Throwable e) {
            emm.aEU().mo2953g("Answers", "Error setting up app properties", e);
            return false;
        }
    }

    protected Boolean xi() {
        Context context = getContext();
        m2873M(context);
        try {
            epv aGB = ept.aGA().aGB();
            if (aGB == null) {
                return Boolean.valueOf(false);
            }
            if (aGB.dQG.dQm) {
                this.aHo.m2881a(aGB.aHE, xj());
                return Boolean.valueOf(true);
            }
            CommonUtils.Z(context, "Disabling analytics collection based on settings flag value.");
            this.aHo.disable();
            return Boolean.valueOf(false);
        } catch (Throwable e) {
            emm.aEU().mo2953g("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String getVersion() {
        return "1.2.2.56";
    }

    @SuppressLint({"CommitPrefEdits"})
    @TargetApi(14)
    private void m2873M(Context context) {
        try {
            abx com_fossil_abx = new abx(context, new acc(), new enp(), new eoq(getContext(), xl(), "session_analytics.tap", "session_analytics_to_send"));
            IdManager aEZ = aEZ();
            Map xy = aEZ.xy();
            acb com_fossil_acb = new acb(context.getPackageName(), UUID.randomUUID().toString(), aEZ.aFt(), (String) xy.get(DeviceIdentifierType.ANDROID_ID), (String) xy.get(DeviceIdentifierType.ANDROID_ADVERTISING_ID), (String) xy.get(DeviceIdentifierType.FONT_TOKEN), CommonUtils.eH(context), aEZ.aFv(), aEZ.aFw(), this.aHl, this.versionName);
            Application application = (Application) getContext().getApplicationContext();
            if (application == null || VERSION.SDK_INT < 14) {
                this.aHo = abz.m2880a(context, com_fossil_acb, com_fossil_abx, new eou(emm.aEU()));
            } else {
                this.aHo = abp.m2889a(application, com_fossil_acb, com_fossil_abx, new eou(emm.aEU()));
            }
            if (m2875y(this.aHn)) {
                emm.aEU().mo2950d("Answers", "First launch");
                this.aHo.xr();
                this.aHm.mo2992b(this.aHm.edit().putBoolean("analytics_launched", true));
            }
        } catch (Throwable e) {
            CommonUtils.a(context, "Crashlytics failed to initialize session analytics.", e);
        }
    }

    String xj() {
        return CommonUtils.aa(getContext(), "com.crashlytics.ApiEndpoint");
    }

    boolean xk() {
        return this.aHm.aGu().getBoolean("analytics_launched", false);
    }

    boolean m2875y(long j) {
        return !xk() && m2876z(j);
    }

    boolean m2876z(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }

    File xl() {
        return new epa(this).getFilesDir();
    }
}
