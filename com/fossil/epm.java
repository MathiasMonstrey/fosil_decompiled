package com.fossil;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONException;
import org.json.JSONObject;

class epm implements epu {
    private final epb aHm = new epc(this.dNl);
    private final enj aIg;
    private final emr dNl;
    private final epy dQf;
    private final epx dQg;
    private final epj dQh;
    private final epz dQi;

    public epm(emr com_fossil_emr, epy com_fossil_epy, enj com_fossil_enj, epx com_fossil_epx, epj com_fossil_epj, epz com_fossil_epz) {
        this.dNl = com_fossil_emr;
        this.dQf = com_fossil_epy;
        this.aIg = com_fossil_enj;
        this.dQg = com_fossil_epx;
        this.dQh = com_fossil_epj;
        this.dQi = com_fossil_epz;
    }

    public epv aGw() {
        return mo2997a(SettingsCacheBehavior.USE_CACHE);
    }

    public epv mo2997a(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        epv com_fossil_epv;
        Throwable th2;
        epv com_fossil_epv2 = null;
        try {
            if (!(emm.aEV() || aGz())) {
                com_fossil_epv2 = m11015b(settingsCacheBehavior);
            }
            if (com_fossil_epv2 == null) {
                try {
                    JSONObject a = this.dQi.mo3001a(this.dQf);
                    if (a != null) {
                        com_fossil_epv2 = this.dQg.mo2999a(this.aIg, a);
                        this.dQh.mo2995a(com_fossil_epv2.dQI, a);
                        m11016b(a, "Loaded settings: ");
                        mC(aGx());
                    }
                } catch (Throwable e) {
                    th = e;
                    com_fossil_epv = com_fossil_epv2;
                    th2 = th;
                    emm.aEU().mo2953g("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return com_fossil_epv;
                }
            }
            com_fossil_epv = com_fossil_epv2;
            if (com_fossil_epv == null) {
                try {
                    com_fossil_epv = m11015b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    emm.aEU().mo2953g("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return com_fossil_epv;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            com_fossil_epv = null;
            th2 = th;
            emm.aEU().mo2953g("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return com_fossil_epv;
        }
        return com_fossil_epv;
    }

    private epv m11015b(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        epv com_fossil_epv = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject aGv = this.dQh.aGv();
            if (aGv != null) {
                epv a = this.dQg.mo2999a(this.aIg, aGv);
                if (a != null) {
                    m11016b(aGv, "Loaded cached settings: ");
                    long aFr = this.aIg.aFr();
                    if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !a.aW(aFr)) {
                        try {
                            emm.aEU().mo2950d("Fabric", "Returning cached settings.");
                            return a;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            com_fossil_epv = a;
                            th = th2;
                            emm.aEU().mo2953g("Fabric", "Failed to get cached settings", th);
                            return com_fossil_epv;
                        }
                    }
                    emm.aEU().mo2950d("Fabric", "Cached settings have expired.");
                    return null;
                }
                emm.aEU().mo2953g("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            emm.aEU().mo2950d("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            emm.aEU().mo2953g("Fabric", "Failed to get cached settings", th);
            return com_fossil_epv;
        }
    }

    private void m11016b(JSONObject jSONObject, String str) throws JSONException {
        if (!CommonUtils.ez(this.dNl.getContext())) {
            jSONObject = this.dQg.mo3000n(jSONObject);
        }
        emm.aEU().mo2950d("Fabric", str + jSONObject.toString());
    }

    String aGx() {
        return CommonUtils.g(new String[]{CommonUtils.eH(this.dNl.getContext())});
    }

    String aGy() {
        return this.aHm.aGu().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean mC(String str) {
        Editor edit = this.aHm.edit();
        edit.putString("existing_instance_identifier", str);
        return this.aHm.mo2992b(edit);
    }

    boolean aGz() {
        return !aGy().equals(aGx());
    }
}
