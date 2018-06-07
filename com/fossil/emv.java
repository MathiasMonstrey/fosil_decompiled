package com.fossil;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import retrofit.mime.MultipartTypedOutput;

class emv extends emr<Boolean> {
    private String aHl;
    private final eov dNp = new eou();
    private PackageManager dNq;
    private PackageInfo dNr;
    private String dNs;
    private String dNt;
    private final Future<Map<String, emt>> dNu;
    private final Collection<emr> dNv;
    private String installerPackageName;
    private String packageName;
    private String versionName;

    protected /* synthetic */ Object xf() {
        return xi();
    }

    public emv(Future<Map<String, emt>> future, Collection<emr> collection) {
        this.dNu = future;
        this.dNv = collection;
    }

    public String getVersion() {
        return "1.3.4.60";
    }

    protected boolean xh() {
        try {
            this.installerPackageName = aEZ().getInstallerPackageName();
            this.dNq = getContext().getPackageManager();
            this.packageName = getContext().getPackageName();
            this.dNr = this.dNq.getPackageInfo(this.packageName, 0);
            this.aHl = Integer.toString(this.dNr.versionCode);
            this.versionName = this.dNr.versionName == null ? "0.0" : this.dNr.versionName;
            this.dNs = this.dNq.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.dNt = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean xi() {
        boolean a;
        String eF = CommonUtils.eF(getContext());
        epv aFe = aFe();
        if (aFe != null) {
            try {
                Map map;
                if (this.dNu != null) {
                    map = (Map) this.dNu.get();
                } else {
                    map = new HashMap();
                }
                a = m10917a(eF, aFe.dQE, m10920e(map, this.dNv).values());
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private epv aFe() {
        try {
            ept.aGA().m11036a(this, this.aId, this.dNp, this.aHl, this.versionName, xj()).aGC();
            return ept.aGA().aGB();
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, emt> m10920e(Map<String, emt> map, Collection<emr> collection) {
        for (emr com_fossil_emr : collection) {
            if (!map.containsKey(com_fossil_emr.getIdentifier())) {
                map.put(com_fossil_emr.getIdentifier(), new emt(com_fossil_emr.getIdentifier(), com_fossil_emr.getVersion(), MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING));
            }
        }
        return map;
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m10917a(String str, eph com_fossil_eph, Collection<emt> collection) {
        if ("new".equals(com_fossil_eph.dPZ)) {
            if (m10918b(str, com_fossil_eph, collection)) {
                return ept.aGA().aGD();
            }
            emm.aEU().mo2953g("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(com_fossil_eph.dPZ)) {
            return ept.aGA().aGD();
        } else {
            if (!com_fossil_eph.dQb) {
                return true;
            }
            emm.aEU().mo2950d("Fabric", "Server says an update is required - forcing a full App update.");
            m10919c(str, com_fossil_eph, collection);
            return true;
        }
    }

    private boolean m10918b(String str, eph com_fossil_eph, Collection<emt> collection) {
        return new epk(this, xj(), com_fossil_eph.url, this.dNp).mo2994a(m10915a(epq.ac(getContext(), str), collection));
    }

    private boolean m10919c(String str, eph com_fossil_eph, Collection<emt> collection) {
        return m10916a(com_fossil_eph, epq.ac(getContext(), str), (Collection) collection);
    }

    private boolean m10916a(eph com_fossil_eph, epq com_fossil_epq, Collection<emt> collection) {
        return new eqa(this, xj(), com_fossil_eph.url, this.dNp).mo2994a(m10915a(com_fossil_epq, collection));
    }

    private epg m10915a(epq com_fossil_epq, Collection<emt> collection) {
        return new epg(new eng().er(getContext()), aEZ().aFu(), this.versionName, this.aHl, CommonUtils.g(new String[]{CommonUtils.eH(r0)}), this.dNs, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.dNt, AppEventsConstants.EVENT_PARAM_VALUE_NO, com_fossil_epq, collection);
    }

    String xj() {
        return CommonUtils.aa(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
