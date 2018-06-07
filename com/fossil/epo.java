package com.fossil;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.Selfie;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class epo extends ena implements epz {
    public epo(emr com_fossil_emr, String str, String str2, eov com_fossil_eov) {
        this(com_fossil_emr, str, str2, com_fossil_eov, HttpMethod.GET);
    }

    epo(emr com_fossil_emr, String str, String str2, eov com_fossil_eov, HttpMethod httpMethod) {
        super(com_fossil_emr, str, str2, com_fossil_eov, httpMethod);
    }

    public JSONObject mo3001a(epy com_fossil_epy) {
        HttpRequest httpRequest = null;
        try {
            Map b = m11032b(com_fossil_epy);
            httpRequest = m11031a(m2904B(b), com_fossil_epy);
            emm.aEU().mo2950d("Fabric", "Requesting settings from " + getUrl());
            emm.aEU().mo2950d("Fabric", "Settings query params were: " + b);
            JSONObject b2 = m11034b(httpRequest);
            return b2;
        } finally {
            if (httpRequest != null) {
                emm.aEU().mo2950d("Fabric", "Settings request ID: " + httpRequest.kK("X-REQUEST-ID"));
            }
        }
    }

    JSONObject m11034b(HttpRequest httpRequest) {
        int azA = httpRequest.azA();
        emm.aEU().mo2950d("Fabric", "Settings result was: " + azA);
        if (pl(azA)) {
            return mD(httpRequest.aGj());
        }
        emm.aEU().mo2951e("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    boolean pl(int i) {
        return i == MFNetworkReturnCode.RESPONSE_OK || i == 201 || i == Selfie.TAKE_BURST || i == 203;
    }

    private JSONObject mD(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            emm.aEU().mo2949c("Fabric", "Failed to parse settings JSON from " + getUrl(), e);
            emm.aEU().mo2950d("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m11032b(epy com_fossil_epy) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", com_fossil_epy.aIs);
        hashMap.put("display_version", com_fossil_epy.aIr);
        hashMap.put("source", Integer.toString(com_fossil_epy.source));
        if (com_fossil_epy.dQM != null) {
            hashMap.put("icon_hash", com_fossil_epy.dQM);
        }
        String str = com_fossil_epy.aIt;
        if (!CommonUtils.isNullOrEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest m11031a(HttpRequest httpRequest, epy com_fossil_epy) {
        return httpRequest.bm("X-CRASHLYTICS-API-KEY", com_fossil_epy.aHF).bm("X-CRASHLYTICS-API-CLIENT-TYPE", "android").bm("X-CRASHLYTICS-D", com_fossil_epy.deviceId).bm("X-CRASHLYTICS-API-CLIENT-VERSION", this.dNl.getVersion()).bm("Accept", "application/json");
    }
}
