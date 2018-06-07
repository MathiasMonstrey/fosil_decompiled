package com.fossil;

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;

class aby extends ena implements eop {
    private final String aHF;

    public aby(emr com_fossil_emr, String str, String str2, eov com_fossil_eov, String str3) {
        super(com_fossil_emr, str, str2, com_fossil_eov, HttpMethod.POST);
        this.aHF = str3;
    }

    public boolean mo788u(List<File> list) {
        HttpRequest a = m2906a(m2905a(aFf(), this.aHF), (List) list);
        CommonUtils.Z(abn.xg().getContext(), "Sending " + list.size() + " analytics files to " + getUrl());
        int azA = a.azA();
        CommonUtils.Z(abn.xg().getContext(), "Response code for analytics file send is " + azA);
        return eno.pg(azA) == 0;
    }

    private HttpRequest m2905a(HttpRequest httpRequest, String str) {
        return httpRequest.bm("X-CRASHLYTICS-API-CLIENT-TYPE", "android").bm("X-CRASHLYTICS-API-CLIENT-VERSION", abn.xg().getVersion()).bm("X-CRASHLYTICS-API-KEY", str);
    }

    private HttpRequest m2906a(HttpRequest httpRequest, List<File> list) {
        int i = 0;
        for (File file : list) {
            CommonUtils.Z(abn.xg().getContext(), "Adding analytics session file " + file.getName() + " to multipart POST");
            httpRequest.a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        return httpRequest;
    }
}
