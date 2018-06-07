package com.fossil;

import com.fossil.dvf.C3224a;
import com.fossil.dvj.C3227a;
import com.fossil.dwa.C3247a;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class duy {
    private boolean connected = false;
    private final duz duR;
    private final dvn duS;
    private Socket duT;
    private dws duU;
    private dwa duV;
    private Protocol duW = Protocol.HTTP_1_1;
    private long duX;
    private dvd duY;
    private int duZ;
    private Object dva;

    public duy(duz com_fossil_duz, dvn com_fossil_dvn) {
        this.duR = com_fossil_duz;
        this.duS = com_fossil_dvn;
    }

    void cR(Object obj) {
        if (!ayA()) {
            synchronized (this.duR) {
                if (this.dva != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.dva = obj;
            }
        }
    }

    boolean ayv() {
        boolean z;
        synchronized (this.duR) {
            if (this.dva == null) {
                z = false;
            } else {
                this.dva = null;
                z = true;
            }
        }
        return z;
    }

    void m9810a(int i, int i2, int i3, dvj com_fossil_dvj, List<dva> list, boolean z) throws RouteException {
        RouteException routeException;
        if (this.connected) {
            throw new IllegalStateException("already connected");
        }
        dvo com_fossil_dvo = new dvo(list);
        Proxy ayg = this.duS.ayg();
        dur azI = this.duS.azI();
        if (this.duS.dwu.ayc() != null || list.contains(dva.dvk)) {
            RouteException routeException2 = null;
            while (!this.connected) {
                try {
                    Socket createSocket = (ayg.type() == Type.DIRECT || ayg.type() == Type.HTTP) ? azI.getSocketFactory().createSocket() : new Socket(ayg);
                    this.duT = createSocket;
                    m9805a(i, i2, i3, com_fossil_dvj, com_fossil_dvo);
                    this.connected = true;
                } catch (IOException e) {
                    IOException iOException = e;
                    dvw.m9969a(this.duT);
                    this.duT = null;
                    if (routeException2 == null) {
                        routeException = new RouteException(iOException);
                    } else {
                        routeException2.addConnectException(iOException);
                        routeException = routeException2;
                    }
                    if (z && com_fossil_dvo.m9941b(iOException)) {
                        routeException2 = routeException;
                    } else {
                        throw routeException;
                    }
                }
            }
            return;
        }
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
    }

    private void m9805a(int i, int i2, int i3, dvj com_fossil_dvj, dvo com_fossil_dvo) throws IOException {
        this.duT.setSoTimeout(i2);
        dvu.azM().mo2711a(this.duT, this.duS.azJ(), i);
        if (this.duS.dwu.ayc() != null) {
            m9807a(i2, i3, com_fossil_dvj, com_fossil_dvo);
        }
        if (this.duW == Protocol.SPDY_3 || this.duW == Protocol.HTTP_2) {
            this.duT.setSoTimeout(0);
            this.duV = new C3247a(this.duS.dwu.duj, true, this.duT).m10004c(this.duW).azV();
            this.duV.azT();
            return;
        }
        this.duU = new dws(this.duR, this, this.duT);
    }

    private void m9807a(int i, int i2, dvj com_fossil_dvj, dvo com_fossil_dvo) throws IOException {
        Throwable th;
        Socket socket;
        AssertionError assertionError;
        Throwable th2;
        String str = null;
        if (this.duS.azK()) {
            m9806a(i, i2, com_fossil_dvj);
        }
        dur azI = this.duS.azI();
        try {
            Socket socket2 = (SSLSocket) azI.ayc().createSocket(this.duT, azI.aya(), azI.ayb(), true);
            try {
                dva b = com_fossil_dvo.m9940b((SSLSocket) socket2);
                if (b.ayJ()) {
                    dvu.azM().mo2712a((SSLSocket) socket2, azI.aya(), azI.aye());
                }
                socket2.startHandshake();
                dvd a = dvd.m9839a(socket2.getSession());
                if (azI.getHostnameVerifier().verify(azI.aya(), socket2.getSession())) {
                    azI.ayh().m9804i(azI.aya(), a.ayM());
                    if (b.ayJ()) {
                        str = dvu.azM().mo2713e(socket2);
                    }
                    this.duW = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                    this.duY = a;
                    this.duT = socket2;
                    if (socket2 != null) {
                        dvu.azM().mo2716d(socket2);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) a.ayM().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + azI.aya() + " not verified:" + "\n    certificate: " + duw.m9802a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + dxf.m10256b(certificate));
            } catch (Throwable e) {
                th = e;
                socket = socket2;
                assertionError = th;
                try {
                    if (dvw.m9971a(assertionError)) {
                        throw assertionError;
                    } else {
                        throw new IOException(assertionError);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Throwable e2) {
                th = e2;
                socket = socket2;
                th2 = th;
                if (socket != null) {
                    dvu.azM().mo2716d(socket);
                }
                dvw.m9969a(socket);
                throw th2;
            }
        } catch (AssertionError e3) {
            assertionError = e3;
            if (dvw.m9971a(assertionError)) {
                throw assertionError;
            } else {
                throw new IOException(assertionError);
            }
        }
    }

    private void m9806a(int i, int i2, dvj com_fossil_dvj) throws IOException {
        dvj b = m9808b(com_fossil_dvj);
        dws com_fossil_dws = new dws(this.duR, this, this.duT);
        com_fossil_dws.cm(i, i2);
        dvf azq = b.azq();
        String str = "CONNECT " + azq.ayV() + ":" + azq.ayW() + " HTTP/1.1";
        do {
            com_fossil_dws.m10206a(b.azt(), str);
            com_fossil_dws.flush();
            dvl azF = com_fossil_dws.aAP().m9925i(b).azF();
            long u = dwx.m10242u(azF);
            if (u == -1) {
                u = 0;
            }
            etv aO = com_fossil_dws.aO(u);
            dvw.m9974b(aO, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            aO.close();
            switch (azF.azA()) {
                case MFNetworkReturnCode.RESPONSE_OK /*200*/:
                    if (com_fossil_dws.aAO() > 0) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case 407:
                    b = dwx.m10236a(this.duS.azI().ayd(), azF, this.duS.ayg());
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + azF.azA());
            }
        } while (b != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private dvj m9808b(dvj com_fossil_dvj) throws IOException {
        dvf azc = new C3224a().kD(UpPlatformSdkConstants.URI_SCHEME).kE(com_fossil_dvj.azq().ayV()).mA(com_fossil_dvj.azq().ayW()).azc();
        C3227a aY = new C3227a().m9903d(azc).aY("Host", dvw.m9975e(azc)).aY("Proxy-Connection", "Keep-Alive");
        String kK = com_fossil_dvj.kK("User-Agent");
        if (kK != null) {
            aY.aY("User-Agent", kK);
        }
        kK = com_fossil_dvj.kK("Proxy-Authorization");
        if (kK != null) {
            aY.aY("Proxy-Authorization", kK);
        }
        return aY.azx();
    }

    void m9811a(dvi com_fossil_dvi, Object obj, dvj com_fossil_dvj) throws RouteException {
        cR(obj);
        if (!isConnected()) {
            dvj com_fossil_dvj2 = com_fossil_dvj;
            m9810a(com_fossil_dvi.getConnectTimeout(), com_fossil_dvi.getReadTimeout(), com_fossil_dvi.aze(), com_fossil_dvj2, this.duS.dwu.ayf(), com_fossil_dvi.azj());
            if (ayA()) {
                com_fossil_dvi.azh().m9817c(this);
            }
            com_fossil_dvi.azk().m9964b(ayw());
        }
        cm(com_fossil_dvi.getReadTimeout(), com_fossil_dvi.aze());
    }

    boolean isConnected() {
        return this.connected;
    }

    public dvn ayw() {
        return this.duS;
    }

    public Socket getSocket() {
        return this.duT;
    }

    boolean isAlive() {
        return (this.duT.isClosed() || this.duT.isInputShutdown() || this.duT.isOutputShutdown()) ? false : true;
    }

    boolean isReadable() {
        if (this.duU != null) {
            return this.duU.isReadable();
        }
        return true;
    }

    void ayx() {
        if (this.duV != null) {
            throw new IllegalStateException("framedConnection != null");
        }
        this.duX = System.nanoTime();
    }

    boolean isIdle() {
        return this.duV == null || this.duV.isIdle();
    }

    long ayy() {
        return this.duV == null ? this.duX : this.duV.ayy();
    }

    public dvd ayz() {
        return this.duY;
    }

    dxd m9809a(dwu com_fossil_dwu) throws IOException {
        return this.duV != null ? new dwq(com_fossil_dwu, this.duV) : new dww(com_fossil_dwu, this.duU);
    }

    boolean ayA() {
        return this.duV != null;
    }

    public Protocol ayB() {
        return this.duW;
    }

    void m9812a(Protocol protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        this.duW = protocol;
    }

    void cm(int i, int i2) throws RouteException {
        if (!this.connected) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (this.duU != null) {
            try {
                this.duT.setSoTimeout(i);
                this.duU.cm(i, i2);
            } catch (IOException e) {
                throw new RouteException(e);
            }
        }
    }

    void ayC() {
        this.duZ++;
    }

    int ayD() {
        return this.duZ;
    }

    public String toString() {
        return "Connection{" + this.duS.dwu.duj + ":" + this.duS.dwu.duk + ", proxy=" + this.duS.dui + " hostAddress=" + this.duS.dwv.getAddress().getHostAddress() + " cipherSuite=" + (this.duY != null ? this.duY.ayL() : "none") + " protocol=" + this.duW + '}';
    }
}
