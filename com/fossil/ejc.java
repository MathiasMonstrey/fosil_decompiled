package com.fossil;

import java.net.URL;
import java.util.Locale;

public class ejc implements ejb {
    protected String dJf;
    protected String dty;

    public ejc() {
        this("https://oauth2-api.mapmyapi.com", "https://www.mapmyfitness.com");
    }

    public ejc(String str, String str2) {
        lH(str);
        lI(str2);
    }

    public void lH(String str) {
        this.dty = (String) eiy.m10771e(str, "baseUrl");
    }

    public void lI(String str) {
        this.dJf = (String) eiy.m10771e(str, "baseUrl");
    }

    protected String aDV() {
        return this.dJf;
    }

    public URL aDQ() {
        return m10779a(null, this.dty, "/v7.0/oauth2/access_token/", new Object[0]);
    }

    public URL bj(String str, String str2) {
        return m10779a(null, aDV(), "/v7.0/oauth2/uacf/authorize/?client_id=%s&response_type=code&redirect_uri=%s", str, str2);
    }

    public URL aDR() {
        return m10779a(null, this.dty, "/v7.0/user/self/", new Object[0]);
    }

    public URL mo2888g(ecj com_fossil_ecj) {
        eiy.dd(com_fossil_ecj);
        return m10779a(com_fossil_ecj, this.dty, "/v7.0/user/%s/", com_fossil_ecj.getId());
    }

    public URL aDS() {
        return m10779a(null, this.dty, "/v7.0/user/", new Object[0]);
    }

    public URL mo2889h(ecj com_fossil_ecj) {
        eiy.dd(com_fossil_ecj);
        return m10779a(com_fossil_ecj, this.dty, "/v7.0/user_profile_photo/", com_fossil_ecj.getId());
    }

    public URL mo2890i(ecj com_fossil_ecj) {
        if (com_fossil_ecj == null || com_fossil_ecj.getId() == null) {
            return m10779a(null, this.dty, "/v7.0/remoteconnectiontype/", new Object[0]);
        }
        return m10779a(com_fossil_ecj, this.dty, "/v7.0/remoteconnectiontype/%s/", com_fossil_ecj.getId());
    }

    public URL mo2891j(ecj com_fossil_ecj) {
        return m10779a(null, this.dty, "/api/0.1/actigraphy_settings/%s/", com_fossil_ecj.getId());
    }

    public URL aDT() {
        return m10779a(null, this.dty, "/api/0.1/actigraphy_recorder_priority/", new Object[0]);
    }

    public URL aDU() {
        return m10779a(null, this.dty, "/api/0.1/activity_timeseries/", new Object[0]);
    }

    protected static URL m10779a(ecj com_fossil_ecj, String str, String str2, Object... objArr) {
        String str3 = null;
        if (!(com_fossil_ecj == null || com_fossil_ecj.getHref() == null)) {
            str3 = str + com_fossil_ecj.getHref();
        }
        if (str3 == null) {
            str3 = str + String.format(Locale.US, str2, objArr);
        }
        try {
            return new URL(str3);
        } catch (Throwable e) {
            ecq.m10489d("bad url", e);
            throw new RuntimeException(e);
        }
    }
}
