package com.fossil;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class dvo {
    private final List<dva> duq;
    private int dwx = 0;
    private boolean dwy;
    private boolean dwz;

    public dvo(List<dva> list) {
        this.duq = list;
    }

    public dva m9940b(SSLSocket sSLSocket) throws IOException {
        dva com_fossil_dva;
        int i = this.dwx;
        int size = this.duq.size();
        for (int i2 = i; i2 < size; i2++) {
            com_fossil_dva = (dva) this.duq.get(i2);
            if (com_fossil_dva.m9836a(sSLSocket)) {
                this.dwx = i2 + 1;
                break;
            }
        }
        com_fossil_dva = null;
        if (com_fossil_dva == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.dwz + ", modes=" + this.duq + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.dwy = m9939c(sSLSocket);
        dvp.dwA.mo2697a(com_fossil_dva, sSLSocket, this.dwz);
        return com_fossil_dva;
    }

    public boolean m9941b(IOException iOException) {
        boolean z = true;
        this.dwz = true;
        if ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!(((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) && this.dwy)) {
            z = false;
        }
        return z;
    }

    private boolean m9939c(SSLSocket sSLSocket) {
        for (int i = this.dwx; i < this.duq.size(); i++) {
            if (((dva) this.duq.get(i)).m9836a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
