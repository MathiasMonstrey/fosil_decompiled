package com.fossil;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class aci extends ena {
    private final ack aIp;

    public aci(emr com_fossil_emr, String str, String str2, eov com_fossil_eov, ack com_fossil_ack) {
        super(com_fossil_emr, str, str2, com_fossil_eov, HttpMethod.GET);
        this.aIp = com_fossil_ack;
    }

    public acj m2937a(String str, String str2, ach com_fossil_ach) {
        HttpRequest a;
        Throwable e;
        Throwable th;
        acj com_fossil_acj = null;
        try {
            Map a2 = m2936a(com_fossil_ach);
            try {
                a = m2935a(m2904B(a2), str, str2);
                emm.aEU().mo2950d("Beta", "Checking for updates from " + getUrl());
                emm.aEU().mo2950d("Beta", "Checking for updates query params are: " + a2);
                if (a.aGh()) {
                    emm.aEU().mo2950d("Beta", "Checking for updates was successful");
                    com_fossil_acj = this.aIp.m2938d(new JSONObject(a.aGj()));
                    if (a != null) {
                        emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
                    }
                } else {
                    emm.aEU().mo2951e("Beta", "Checking for updates failed. Response code: " + a.azA());
                    if (a != null) {
                        emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Beta", "Error while checking for updates from " + getUrl(), e);
                    if (a != null) {
                        emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
                    }
                    return com_fossil_acj;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            emm.aEU().mo2953g("Beta", "Error while checking for updates from " + getUrl(), e);
            if (a != null) {
                emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
            }
            return com_fossil_acj;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                emm.aEU().mo2950d("Fabric", "Checking for updates request ID: " + a.kK("X-REQUEST-ID"));
            }
            throw th;
        }
        return com_fossil_acj;
    }

    private HttpRequest m2935a(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.bm("Accept", "application/json").bm("User-Agent", "Crashlytics Android SDK/" + this.dNl.getVersion()).bm("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").bm("X-CRASHLYTICS-API-CLIENT-TYPE", "android").bm("X-CRASHLYTICS-API-CLIENT-VERSION", this.dNl.getVersion()).bm("X-CRASHLYTICS-API-KEY", str).bm("X-CRASHLYTICS-D", str2);
    }

    private Map<String, String> m2936a(ach com_fossil_ach) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", com_fossil_ach.aHl);
        hashMap.put("display_version", com_fossil_ach.versionName);
        hashMap.put("instance", com_fossil_ach.aHV);
        hashMap.put("source", "3");
        return hashMap;
    }
}
