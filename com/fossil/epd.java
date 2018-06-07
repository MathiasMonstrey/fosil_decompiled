package com.fossil;

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.util.Locale;

abstract class epd extends ena {
    public epd(emr com_fossil_emr, String str, String str2, eov com_fossil_eov, HttpMethod httpMethod) {
        super(com_fossil_emr, str, str2, com_fossil_eov, httpMethod);
    }

    public boolean mo2994a(epg com_fossil_epg) {
        HttpRequest b = m11007b(m11006a(aFf(), com_fossil_epg), com_fossil_epg);
        emm.aEU().mo2950d("Fabric", "Sending app info to " + getUrl());
        if (com_fossil_epg.dPX != null) {
            emm.aEU().mo2950d("Fabric", "App icon hash is " + com_fossil_epg.dPX.dPT);
            emm.aEU().mo2950d("Fabric", "App icon size is " + com_fossil_epg.dPX.width + "x" + com_fossil_epg.dPX.height);
        }
        int azA = b.azA();
        emm.aEU().mo2950d("Fabric", ("POST".equals(b.azs()) ? "Create" : "Update") + " app request ID: " + b.kK("X-REQUEST-ID"));
        emm.aEU().mo2950d("Fabric", "Result was " + azA);
        if (eno.pg(azA) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest m11006a(HttpRequest httpRequest, epg com_fossil_epg) {
        return httpRequest.bm("X-CRASHLYTICS-API-KEY", com_fossil_epg.aHF).bm("X-CRASHLYTICS-API-CLIENT-TYPE", "android").bm("X-CRASHLYTICS-API-CLIENT-VERSION", this.dNl.getVersion());
    }

    private HttpRequest m11007b(HttpRequest httpRequest, epg com_fossil_epg) {
        HttpRequest bq = httpRequest.bq("app[identifier]", com_fossil_epg.appId).bq("app[name]", com_fossil_epg.name).bq("app[display_version]", com_fossil_epg.aIr).bq("app[build_version]", com_fossil_epg.aIs).a("app[source]", Integer.valueOf(com_fossil_epg.source)).bq("app[minimum_sdk_version]", com_fossil_epg.dPV).bq("app[built_sdk_version]", com_fossil_epg.dPW);
        if (!CommonUtils.isNullOrEmpty(com_fossil_epg.dPU)) {
            bq.bq("app[instance_identifier]", com_fossil_epg.dPU);
        }
        if (com_fossil_epg.dPX != null) {
            Closeable closeable = null;
            try {
                closeable = this.dNl.getContext().getResources().openRawResource(com_fossil_epg.dPX.dQn);
                bq.bq("app[icon][hash]", com_fossil_epg.dPX.dPT).a("app[icon][data]", "icon.png", "application/octet-stream", closeable).a("app[icon][width]", Integer.valueOf(com_fossil_epg.dPX.width)).a("app[icon][height]", Integer.valueOf(com_fossil_epg.dPX.height));
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Failed to find app icon with resource ID: " + com_fossil_epg.dPX.dQn, e);
            } finally {
                bq = "Failed to close app icon InputStream.";
                CommonUtils.a(closeable, bq);
            }
        }
        if (com_fossil_epg.dPY != null) {
            for (emt com_fossil_emt : com_fossil_epg.dPY) {
                bq.bq(m11008a(com_fossil_emt), com_fossil_emt.getVersion());
                bq.bq(m11010b(com_fossil_emt), com_fossil_emt.aFd());
            }
        }
        return bq;
    }

    String m11008a(emt com_fossil_emt) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{com_fossil_emt.getIdentifier()});
    }

    String m11010b(emt com_fossil_emt) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{com_fossil_emt.getIdentifier()});
    }
}
