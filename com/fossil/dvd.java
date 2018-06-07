package com.fossil;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class dvd {
    private final String dvu;
    private final List<Certificate> dvv;
    private final List<Certificate> dvw;

    private dvd(String str, List<Certificate> list, List<Certificate> list2) {
        this.dvu = str;
        this.dvv = list;
        this.dvw = list2;
    }

    public static dvd m9839a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        Object[] peerCertificates;
        List m;
        List m2;
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            m = dvw.m9976m(peerCertificates);
        } else {
            m = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            m2 = dvw.m9976m(localCertificates);
        } else {
            m2 = Collections.emptyList();
        }
        return new dvd(cipherSuite, m, m2);
    }

    public String ayL() {
        return this.dvu;
    }

    public List<Certificate> ayM() {
        return this.dvv;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dvd)) {
            return false;
        }
        dvd com_fossil_dvd = (dvd) obj;
        if (this.dvu.equals(com_fossil_dvd.dvu) && this.dvv.equals(com_fossil_dvd.dvv) && this.dvw.equals(com_fossil_dvd.dvw)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.dvu.hashCode() + 527) * 31) + this.dvv.hashCode()) * 31) + this.dvw.hashCode();
    }
}
