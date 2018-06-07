package com.fossil;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class wh {
    private final wi aDl;
    private final String aDm;
    private String aDn;
    private URL aDo;
    private final URL url;

    public wh(URL url) {
        this(url, wi.aDq);
    }

    public wh(String str) {
        this(str, wi.aDq);
    }

    public wh(URL url, wi wiVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        } else if (wiVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.url = url;
            this.aDm = null;
            this.aDl = wiVar;
        }
    }

    public wh(String str, wi wiVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        } else if (wiVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.aDm = str;
            this.url = null;
            this.aDl = wiVar;
        }
    }

    public URL toURL() throws MalformedURLException {
        return vr();
    }

    private URL vr() throws MalformedURLException {
        if (this.aDo == null) {
            this.aDo = new URL(vs());
        }
        return this.aDo;
    }

    private String vs() {
        if (TextUtils.isEmpty(this.aDn)) {
            String str = this.aDm;
            if (TextUtils.isEmpty(str)) {
                str = this.url.toString();
            }
            this.aDn = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.aDn;
    }

    public Map<String, String> getHeaders() {
        return this.aDl.getHeaders();
    }

    public String vt() {
        return this.aDm != null ? this.aDm : this.url.toString();
    }

    public String toString() {
        return vt() + '\n' + this.aDl.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wh)) {
            return false;
        }
        wh whVar = (wh) obj;
        if (vt().equals(whVar.vt()) && this.aDl.equals(whVar.aDl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (vt().hashCode() * 31) + this.aDl.hashCode();
    }
}
