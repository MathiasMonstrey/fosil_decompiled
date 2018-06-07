package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class ept {
    private final CountDownLatch dQA;
    private epu dQB;
    private final AtomicReference<epv> dQz;
    private boolean initialized;

    public interface C1572b<T> {
        T mo820c(epv com_fossil_epv);
    }

    static class C3493a {
        private static final ept dQC = new ept();
    }

    public static ept aGA() {
        return C3493a.dQC;
    }

    private ept() {
        this.dQz = new AtomicReference();
        this.dQA = new CountDownLatch(1);
        this.initialized = false;
    }

    public synchronized ept m11036a(emr com_fossil_emr, IdManager idManager, eov com_fossil_eov, String str, String str2, String str3) {
        ept com_fossil_ept;
        if (this.initialized) {
            com_fossil_ept = this;
        } else {
            if (this.dQB == null) {
                Context context = com_fossil_emr.getContext();
                String aFu = idManager.aFu();
                String er = new eng().er(context);
                String installerPackageName = idManager.getInstallerPackageName();
                enp com_fossil_enp = new enp();
                epn com_fossil_epn = new epn();
                epl com_fossil_epl = new epl(com_fossil_emr);
                String eF = CommonUtils.eF(context);
                String str4 = str3;
                epo com_fossil_epo = new epo(com_fossil_emr, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{aFu}), com_fossil_eov);
                installerPackageName = str2;
                String str5 = str;
                this.dQB = new epm(com_fossil_emr, new epy(er, idManager.bl(er, aFu), CommonUtils.g(new String[]{CommonUtils.eH(context)}), installerPackageName, str5, DeliveryMechanism.determineFrom(installerPackageName).getId(), eF), com_fossil_enp, com_fossil_epn, com_fossil_epl, com_fossil_epo);
            }
            this.initialized = true;
            com_fossil_ept = this;
        }
        return com_fossil_ept;
    }

    public <T> T m11037a(C1572b<T> c1572b, T t) {
        epv com_fossil_epv = (epv) this.dQz.get();
        return com_fossil_epv == null ? t : c1572b.mo820c(com_fossil_epv);
    }

    public epv aGB() {
        try {
            this.dQA.await();
            return (epv) this.dQz.get();
        } catch (InterruptedException e) {
            emm.aEU().mo2951e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean aGC() {
        epv aGw;
        aGw = this.dQB.aGw();
        m11035d(aGw);
        return aGw != null;
    }

    public synchronized boolean aGD() {
        epv a;
        a = this.dQB.mo2997a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m11035d(a);
        if (a == null) {
            emm.aEU().mo2953g("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m11035d(epv com_fossil_epv) {
        this.dQz.set(com_fossil_epv);
        this.dQA.countDown();
    }
}
