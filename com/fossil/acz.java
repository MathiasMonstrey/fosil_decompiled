package com.fossil;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map.Entry;

class acz extends ena implements acy {
    public acz(emr com_fossil_emr, String str, String str2, eov com_fossil_eov) {
        super(com_fossil_emr, str, str2, com_fossil_eov, HttpMethod.POST);
    }

    public boolean mo825a(acx com_fossil_acx) {
        HttpRequest b = m3011b(m3010a(aFf(), com_fossil_acx), com_fossil_acx);
        emm.aEU().mo2950d("Fabric", "Sending report to: " + getUrl());
        int azA = b.azA();
        emm.aEU().mo2950d("Fabric", "Create report request ID: " + b.kK("X-REQUEST-ID"));
        emm.aEU().mo2950d("Fabric", "Result was: " + azA);
        return eno.pg(azA) == 0;
    }

    private HttpRequest m3010a(HttpRequest httpRequest, acx com_fossil_acx) {
        HttpRequest bm = httpRequest.bm("X-CRASHLYTICS-API-KEY", com_fossil_acx.aHF).bm("X-CRASHLYTICS-API-CLIENT-TYPE", "android").bm("X-CRASHLYTICS-API-CLIENT-VERSION", acs.xD().getVersion());
        HttpRequest httpRequest2 = bm;
        for (Entry h : com_fossil_acx.aJy.yE().entrySet()) {
            httpRequest2 = httpRequest2.h(h);
        }
        return httpRequest2;
    }

    private HttpRequest m3011b(HttpRequest httpRequest, acx com_fossil_acx) {
        adi com_fossil_adi = com_fossil_acx.aJy;
        return httpRequest.a("report[file]", com_fossil_adi.getFileName(), "application/octet-stream", com_fossil_adi.getFile()).bq("report[identifier]", com_fossil_adi.getIdentifier());
    }
}
