package com.fossil;

import com.squareup.okhttp.Protocol;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class dur {
    final Proxy dui;
    final String duj;
    final int duk;
    final SocketFactory dul;
    final SSLSocketFactory dum;
    final duw dun;
    final dus duo;
    final List<Protocol> dup;
    final List<dva> duq;
    final HostnameVerifier hostnameVerifier;
    final ProxySelector proxySelector;

    public dur(String str, int i, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, duw com_fossil_duw, dus com_fossil_dus, Proxy proxy, List<Protocol> list, List<dva> list2, ProxySelector proxySelector) {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        } else if (com_fossil_dus == null) {
            throw new IllegalArgumentException("authenticator == null");
        } else if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        } else if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        } else {
            this.dui = proxy;
            this.duj = str;
            this.duk = i;
            this.dul = socketFactory;
            this.dum = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier;
            this.dun = com_fossil_duw;
            this.duo = com_fossil_dus;
            this.dup = dvw.ay(list);
            this.duq = dvw.ay(list2);
            this.proxySelector = proxySelector;
        }
    }

    public String aya() {
        return this.duj;
    }

    public int ayb() {
        return this.duk;
    }

    public SocketFactory getSocketFactory() {
        return this.dul;
    }

    public SSLSocketFactory ayc() {
        return this.dum;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public dus ayd() {
        return this.duo;
    }

    public List<Protocol> aye() {
        return this.dup;
    }

    public List<dva> ayf() {
        return this.duq;
    }

    public Proxy ayg() {
        return this.dui;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public duw ayh() {
        return this.dun;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dur)) {
            return false;
        }
        dur com_fossil_dur = (dur) obj;
        if (dvw.equal(this.dui, com_fossil_dur.dui) && this.duj.equals(com_fossil_dur.duj) && this.duk == com_fossil_dur.duk && dvw.equal(this.dum, com_fossil_dur.dum) && dvw.equal(this.hostnameVerifier, com_fossil_dur.hostnameVerifier) && dvw.equal(this.dun, com_fossil_dur.dun) && dvw.equal(this.duo, com_fossil_dur.duo) && dvw.equal(this.dup, com_fossil_dur.dup) && dvw.equal(this.duq, com_fossil_dur.duq) && dvw.equal(this.proxySelector, com_fossil_dur.proxySelector)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = ((((((this.dui != null ? this.dui.hashCode() : 0) + 527) * 31) + this.duj.hashCode()) * 31) + this.duk) * 31;
        if (this.dum != null) {
            hashCode = this.dum.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.hostnameVerifier != null) {
            hashCode = this.hostnameVerifier.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.dun != null) {
            i = this.dun.hashCode();
        }
        return ((((((((hashCode + i) * 31) + this.duo.hashCode()) * 31) + this.dup.hashCode()) * 31) + this.duq.hashCode()) * 31) + this.proxySelector.hashCode();
    }
}
