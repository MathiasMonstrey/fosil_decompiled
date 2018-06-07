package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import com.fossil.dve.C3222a;
import com.fossil.dvg.C3213a;
import com.fossil.dvj.C3227a;
import com.fossil.dvl.C3232a;
import com.fossil.dwp.C3269a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class dwu {
    private static final dvm dzy = new C32781();
    final dvi client;
    private final boolean duL;
    private dvn duS;
    private dvl dws;
    private final dvl dwt;
    private dur dwu;
    private dxd dzA;
    private boolean dzB;
    public final boolean dzC;
    private final dvj dzD;
    private dvl dzE;
    private etu dzF;
    private eti dzG;
    private final boolean dzH;
    private dwo dzI;
    private dwp dzJ;
    private dvj dza;
    long dzg = -1;
    private duy dzn;
    private dxb dzz;

    static class C32781 extends dvm {
        C32781() {
        }

        public dvh contentType() {
            return null;
        }

        public long contentLength() {
            return 0;
        }

        public etj azH() {
            return new eth();
        }
    }

    class C3280a implements C3213a {
        private final dvj duK;
        final /* synthetic */ dwu dzO;
        private int dzP;
        private final int index;

        C3280a(dwu com_fossil_dwu, int i, dvj com_fossil_dvj) {
            this.dzO = com_fossil_dwu;
            this.index = i;
            this.duK = com_fossil_dvj;
        }

        public duy aBh() {
            return this.dzO.dzn;
        }

        public dvl mo2693a(dvj com_fossil_dvj) throws IOException {
            dvg com_fossil_dvg;
            this.dzP++;
            if (this.index > 0) {
                com_fossil_dvg = (dvg) this.dzO.client.azn().get(this.index - 1);
                dur azI = aBh().ayw().azI();
                if (!com_fossil_dvj.azq().ayV().equals(azI.aya()) || com_fossil_dvj.azq().ayW() != azI.ayb()) {
                    throw new IllegalStateException("network interceptor " + com_fossil_dvg + " must retain the same host and port");
                } else if (this.dzP > 1) {
                    throw new IllegalStateException("network interceptor " + com_fossil_dvg + " must call proceed() exactly once");
                }
            }
            if (this.index < this.dzO.client.azn().size()) {
                Object c3280a = new C3280a(this.dzO, this.index + 1, com_fossil_dvj);
                com_fossil_dvg = (dvg) this.dzO.client.azn().get(this.index);
                dvl a = com_fossil_dvg.m9866a(c3280a);
                if (c3280a.dzP == 1) {
                    return a;
                }
                throw new IllegalStateException("network interceptor " + com_fossil_dvg + " must call proceed() exactly once");
            }
            this.dzO.dzA.mo2766m(com_fossil_dvj);
            this.dzO.dza = com_fossil_dvj;
            if (this.dzO.aAY() && com_fossil_dvj.azu() != null) {
                eti c = etp.m11179c(this.dzO.dzA.mo2760a(com_fossil_dvj, com_fossil_dvj.azu().contentLength()));
                com_fossil_dvj.azu().writeTo(c);
                c.close();
            }
            dvl e = this.dzO.aBf();
            int azA = e.azA();
            if ((azA != 204 && azA != 205) || e.azC().contentLength() <= 0) {
                return e;
            }
            throw new ProtocolException("HTTP " + azA + " had non-zero Content-Length: " + e.azC().contentLength());
        }
    }

    public dwu(dvi com_fossil_dvi, dvj com_fossil_dvj, boolean z, boolean z2, boolean z3, duy com_fossil_duy, dxb com_fossil_dxb, dxa com_fossil_dxa, dvl com_fossil_dvl) {
        this.client = com_fossil_dvi;
        this.dzD = com_fossil_dvj;
        this.dzC = z;
        this.dzH = z2;
        this.duL = z3;
        this.dzn = com_fossil_duy;
        this.dzz = com_fossil_dxb;
        this.dzF = com_fossil_dxa;
        this.dwt = com_fossil_dvl;
        if (com_fossil_duy != null) {
            dvp.dwA.mo2701b(com_fossil_duy, this);
            this.duS = com_fossil_duy.ayw();
            return;
        }
        this.duS = null;
    }

    public void aAV() throws RequestException, RouteException, IOException {
        if (this.dzJ == null) {
            if (this.dzA != null) {
                throw new IllegalStateException();
            }
            dvj n = m10223n(this.dzD);
            dvq b = dvp.dwA.mo2700b(this.client);
            dvl j = b != null ? b.m9944j(n) : null;
            this.dzJ = new C3269a(System.currentTimeMillis(), n, j).aAD();
            this.dza = this.dzJ.dza;
            this.dws = this.dzJ.dws;
            if (b != null) {
                b.m9943a(this.dzJ);
            }
            if (j != null && this.dws == null) {
                dvw.closeQuietly(j.azC());
            }
            if (this.dza != null) {
                if (this.dzn == null) {
                    connect();
                }
                this.dzA = dvp.dwA.mo2694a(this.dzn, this);
                if (this.dzH && aAY() && this.dzF == null) {
                    long o = dwx.m10241o(n);
                    if (!this.dzC) {
                        this.dzA.mo2766m(this.dza);
                        this.dzF = this.dzA.mo2760a(this.dza, o);
                        return;
                    } else if (o > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else if (o != -1) {
                        this.dzA.mo2766m(this.dza);
                        this.dzF = new dxa((int) o);
                        return;
                    } else {
                        this.dzF = new dxa();
                        return;
                    }
                }
                return;
            }
            if (this.dzn != null) {
                dvp.dwA.mo2696a(this.client.azh(), this.dzn);
                this.dzn = null;
            }
            if (this.dws != null) {
                this.dzE = this.dws.azD().m9925i(this.dzD).m9928m(m10224q(this.dwt)).m9927l(m10224q(this.dws)).azF();
            } else {
                this.dzE = new C3232a().m9925i(this.dzD).m9928m(m10224q(this.dwt)).m9924b(Protocol.HTTP_1_1).mB(504).kN("Unsatisfiable Request (only-if-cached)").m9922a(dzy).azF();
            }
            this.dzE = m10225r(this.dzE);
        }
    }

    private static dvl m10224q(dvl com_fossil_dvl) {
        return (com_fossil_dvl == null || com_fossil_dvl.azC() == null) ? com_fossil_dvl : com_fossil_dvl.azD().m9922a(null).azF();
    }

    private void connect() throws RequestException, RouteException {
        if (this.dzn != null) {
            throw new IllegalStateException();
        }
        if (this.dzz == null) {
            this.dwu = m10212a(this.client, this.dza);
            try {
                this.dzz = dxb.m10250a(this.dwu, this.dza, this.client);
            } catch (IOException e) {
                throw new RequestException(e);
            }
        }
        this.dzn = aAW();
        dvp.dwA.mo2699a(this.client, this.dzn, this, this.dza);
        this.duS = this.dzn.ayw();
    }

    private duy aAW() throws RouteException {
        duy a;
        duz azh = this.client.azh();
        while (true) {
            a = azh.m9815a(this.dwu);
            if (a != null) {
                if (this.dza.azs().equals("GET") || dvp.dwA.mo2706f(a)) {
                    break;
                }
                dvw.m9969a(a.getSocket());
            } else {
                try {
                    break;
                } catch (IOException e) {
                    throw new RouteException(e);
                }
            }
        }
        a = new duy(azh, this.dzz.aBi());
        return a;
    }

    public void aAX() {
        if (this.dzg != -1) {
            throw new IllegalStateException();
        }
        this.dzg = System.currentTimeMillis();
    }

    boolean aAY() {
        return dwv.kS(this.dzD.azs());
    }

    public dvj aAZ() {
        return this.dzD;
    }

    public dvl aBa() {
        if (this.dzE != null) {
            return this.dzE;
        }
        throw new IllegalStateException();
    }

    public duy aBb() {
        return this.dzn;
    }

    public dwu m10227a(RouteException routeException) {
        if (!(this.dzz == null || this.dzn == null)) {
            m10216a(this.dzz, routeException.getLastConnectException());
        }
        if ((this.dzz == null && this.dzn == null) || ((this.dzz != null && !this.dzz.hasNext()) || !m10218b(routeException))) {
            return null;
        }
        return new dwu(this.client, this.dzD, this.dzC, this.dzH, this.duL, aBd(), this.dzz, (dxa) this.dzF, this.dwt);
    }

    private boolean m10218b(RouteException routeException) {
        if (!this.client.azj()) {
            return false;
        }
        IOException lastConnectException = routeException.getLastConnectException();
        if ((lastConnectException instanceof ProtocolException) || (lastConnectException instanceof InterruptedIOException)) {
            return false;
        }
        if (((lastConnectException instanceof SSLHandshakeException) && (lastConnectException.getCause() instanceof CertificateException)) || (lastConnectException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    public dwu m10228a(IOException iOException, etu com_fossil_etu) {
        if (!(this.dzz == null || this.dzn == null)) {
            m10216a(this.dzz, iOException);
        }
        Object obj = (com_fossil_etu == null || (com_fossil_etu instanceof dxa)) ? 1 : null;
        if ((this.dzz == null && this.dzn == null) || ((this.dzz != null && !this.dzz.hasNext()) || !m10221d(iOException) || obj == null)) {
            return null;
        }
        return new dwu(this.client, this.dzD, this.dzC, this.dzH, this.duL, aBd(), this.dzz, (dxa) com_fossil_etu, this.dwt);
    }

    private void m10216a(dxb com_fossil_dxb, IOException iOException) {
        if (dvp.dwA.mo2705e(this.dzn) <= 0) {
            com_fossil_dxb.m10254a(this.dzn.ayw(), iOException);
        }
    }

    private boolean m10221d(IOException iOException) {
        if (!this.client.azj() || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        return true;
    }

    public dvn ayw() {
        return this.duS;
    }

    private void aBc() throws IOException {
        dvq b = dvp.dwA.mo2700b(this.client);
        if (b != null) {
            if (dwp.m10176a(this.dzE, this.dza)) {
                this.dzI = b.m9946o(m10224q(this.dzE));
            } else if (dwv.kQ(this.dza.azs())) {
                try {
                    b.m9945k(this.dza);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseConnection() throws IOException {
        if (!(this.dzA == null || this.dzn == null)) {
            this.dzA.aAK();
        }
        this.dzn = null;
    }

    public duy aBd() {
        if (this.dzG != null) {
            dvw.closeQuietly(this.dzG);
        } else if (this.dzF != null) {
            dvw.closeQuietly(this.dzF);
        }
        if (this.dzE == null) {
            if (this.dzn != null) {
                dvw.m9969a(this.dzn.getSocket());
            }
            this.dzn = null;
            return null;
        }
        dvw.closeQuietly(this.dzE.azC());
        if (this.dzA == null || this.dzn == null || this.dzA.aAL()) {
            if (!(this.dzn == null || dvp.dwA.mo2704d(this.dzn))) {
                this.dzn = null;
            }
            duy com_fossil_duy = this.dzn;
            this.dzn = null;
            return com_fossil_duy;
        }
        dvw.m9969a(this.dzn.getSocket());
        this.dzn = null;
        return null;
    }

    private dvl m10225r(dvl com_fossil_dvl) throws IOException {
        if (!this.dzB || !"gzip".equalsIgnoreCase(this.dzE.kK("Content-Encoding")) || com_fossil_dvl.azC() == null) {
            return com_fossil_dvl;
        }
        etv com_fossil_etn = new etn(com_fossil_dvl.azC().azH());
        dve ayO = com_fossil_dvl.azt().ayN().kx("Content-Encoding").kx("Content-Length").ayO();
        return com_fossil_dvl.azD().m9923b(ayO).m9922a(new dwy(ayO, etp.m11180c(com_fossil_etn))).azF();
    }

    public static boolean m10226s(dvl com_fossil_dvl) {
        if (com_fossil_dvl.azy().azs().equals("HEAD")) {
            return false;
        }
        int azA = com_fossil_dvl.azA();
        if ((azA < 100 || azA >= MFNetworkReturnCode.RESPONSE_OK) && azA != 204 && azA != 304) {
            return true;
        }
        if (dwx.m10242u(com_fossil_dvl) != -1 || "chunked".equalsIgnoreCase(com_fossil_dvl.kK("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    private dvj m10223n(dvj com_fossil_dvj) throws IOException {
        C3227a azv = com_fossil_dvj.azv();
        if (com_fossil_dvj.kK("Host") == null) {
            azv.aY("Host", dvw.m9975e(com_fossil_dvj.azq()));
        }
        if ((this.dzn == null || this.dzn.ayB() != Protocol.HTTP_1_0) && com_fossil_dvj.kK("Connection") == null) {
            azv.aY("Connection", "Keep-Alive");
        }
        if (com_fossil_dvj.kK("Accept-Encoding") == null) {
            this.dzB = true;
            azv.aY("Accept-Encoding", "gzip");
        }
        CookieHandler azf = this.client.azf();
        if (azf != null) {
            dwx.m10237a(azv, azf.get(com_fossil_dvj.ayQ(), dwx.m10238b(azv.azx().azt(), null)));
        }
        if (com_fossil_dvj.kK("User-Agent") == null) {
            azv.aY("User-Agent", dvx.azO());
        }
        return azv.azx();
    }

    public void aBe() throws IOException {
        if (this.dzE == null) {
            if (this.dza == null && this.dws == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.dza != null) {
                dvl aBf;
                if (this.duL) {
                    this.dzA.mo2766m(this.dza);
                    aBf = aBf();
                } else if (this.dzH) {
                    if (this.dzG != null && this.dzG.aHe().size() > 0) {
                        this.dzG.aHh();
                    }
                    if (this.dzg == -1) {
                        if (dwx.m10241o(this.dza) == -1 && (this.dzF instanceof dxa)) {
                            this.dza = this.dza.azv().aY("Content-Length", Long.toString(((dxa) this.dzF).contentLength())).azx();
                        }
                        this.dzA.mo2766m(this.dza);
                    }
                    if (this.dzF != null) {
                        if (this.dzG != null) {
                            this.dzG.close();
                        } else {
                            this.dzF.close();
                        }
                        if (this.dzF instanceof dxa) {
                            this.dzA.mo2761a((dxa) this.dzF);
                        }
                    }
                    aBf = aBf();
                } else {
                    aBf = new C3280a(this, 0, this.dza).mo2693a(this.dza);
                }
                m10229c(aBf.azt());
                if (this.dws != null) {
                    if (m10217b(this.dws, aBf)) {
                        this.dzE = this.dws.azD().m9925i(this.dzD).m9928m(m10224q(this.dwt)).m9923b(m10213a(this.dws.azt(), aBf.azt())).m9927l(m10224q(this.dws)).m9926k(m10224q(aBf)).azF();
                        aBf.azC().close();
                        releaseConnection();
                        dvq b = dvp.dwA.mo2700b(this.client);
                        b.azL();
                        b.m9942a(this.dws, m10224q(this.dzE));
                        this.dzE = m10225r(this.dzE);
                        return;
                    }
                    dvw.closeQuietly(this.dws.azC());
                }
                this.dzE = aBf.azD().m9925i(this.dzD).m9928m(m10224q(this.dwt)).m9927l(m10224q(this.dws)).m9926k(m10224q(aBf)).azF();
                if (m10226s(this.dzE)) {
                    aBc();
                    this.dzE = m10225r(m10215a(this.dzI, this.dzE));
                }
            }
        }
    }

    private dvl aBf() throws IOException {
        this.dzA.aAI();
        dvl azF = this.dzA.aAJ().m9925i(this.dza).m9921a(this.dzn.ayz()).bb(dwx.dzR, Long.toString(this.dzg)).bb(dwx.dzS, Long.toString(System.currentTimeMillis())).azF();
        if (!this.duL) {
            azF = azF.azD().m9922a(this.dzA.mo2767p(azF)).azF();
        }
        dvp.dwA.mo2695a(this.dzn, azF.azz());
        return azF;
    }

    private dvl m10215a(final dwo com_fossil_dwo, dvl com_fossil_dvl) throws IOException {
        if (com_fossil_dwo == null) {
            return com_fossil_dvl;
        }
        etu aAC = com_fossil_dwo.aAC();
        if (aAC == null) {
            return com_fossil_dvl;
        }
        final etj azH = com_fossil_dvl.azC().azH();
        final eti c = etp.m11179c(aAC);
        return com_fossil_dvl.azD().m9922a(new dwy(com_fossil_dvl.azt(), etp.m11180c(new etv(this) {
            boolean dzK;
            final /* synthetic */ dwu dzO;

            public long mo2733b(eth com_fossil_eth, long j) throws IOException {
                try {
                    long b = azH.mo2733b(com_fossil_eth, j);
                    if (b == -1) {
                        if (!this.dzK) {
                            this.dzK = true;
                            c.close();
                        }
                        return -1;
                    }
                    com_fossil_eth.m11155a(c.aHe(), com_fossil_eth.size() - b, b);
                    c.aHs();
                    return b;
                } catch (IOException e) {
                    if (!this.dzK) {
                        this.dzK = true;
                        com_fossil_dwo.abort();
                    }
                    throw e;
                }
            }

            public etw aAf() {
                return azH.aAf();
            }

            public void close() throws IOException {
                if (!(this.dzK || dvw.m9970a((etv) this, 100, TimeUnit.MILLISECONDS))) {
                    this.dzK = true;
                    com_fossil_dwo.abort();
                }
                azH.close();
            }
        }))).azF();
    }

    private static boolean m10217b(dvl com_fossil_dvl, dvl com_fossil_dvl2) {
        if (com_fossil_dvl2.azA() == 304) {
            return true;
        }
        Date kv = com_fossil_dvl.azt().kv("Last-Modified");
        if (kv != null) {
            Date kv2 = com_fossil_dvl2.azt().kv("Last-Modified");
            if (kv2 != null && kv2.getTime() < kv.getTime()) {
                return true;
            }
        }
        return false;
    }

    private static dve m10213a(dve com_fossil_dve, dve com_fossil_dve2) throws IOException {
        int i;
        int i2 = 0;
        C3222a c3222a = new C3222a();
        int size = com_fossil_dve.size();
        for (i = 0; i < size; i++) {
            String my = com_fossil_dve.my(i);
            String mz = com_fossil_dve.mz(i);
            if (!("Warning".equalsIgnoreCase(my) && mz.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) && (!dwx.kU(my) || com_fossil_dve2.get(my) == null)) {
                c3222a.aU(my, mz);
            }
        }
        i = com_fossil_dve2.size();
        while (i2 < i) {
            String my2 = com_fossil_dve2.my(i2);
            if (!"Content-Length".equalsIgnoreCase(my2) && dwx.kU(my2)) {
                c3222a.aU(my2, com_fossil_dve2.mz(i2));
            }
            i2++;
        }
        return c3222a.ayO();
    }

    public void m10229c(dve com_fossil_dve) throws IOException {
        CookieHandler azf = this.client.azf();
        if (azf != null) {
            azf.put(this.dzD.ayQ(), dwx.m10238b(com_fossil_dve, null));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fossil.dvj aBg() throws java.io.IOException {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.dzE;
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x000b:
        r0 = r4.ayw();
        if (r0 == 0) goto L_0x0024;
    L_0x0011:
        r0 = r4.ayw();
        r0 = r0.ayg();
    L_0x0019:
        r2 = r4.dzE;
        r2 = r2.azA();
        switch(r2) {
            case 300: goto L_0x0066;
            case 301: goto L_0x0066;
            case 302: goto L_0x0066;
            case 303: goto L_0x0066;
            case 307: goto L_0x0048;
            case 308: goto L_0x0048;
            case 401: goto L_0x003b;
            case 407: goto L_0x002b;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = r1;
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = r4.client;
        r0 = r0.ayg();
        goto L_0x0019;
    L_0x002b:
        r1 = r0.type();
        r2 = java.net.Proxy.Type.HTTP;
        if (r1 == r2) goto L_0x003b;
    L_0x0033:
        r0 = new java.net.ProtocolException;
        r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r0.<init>(r1);
        throw r0;
    L_0x003b:
        r1 = r4.client;
        r1 = r1.ayd();
        r2 = r4.dzE;
        r0 = com.fossil.dwx.m10236a(r1, r2, r0);
        goto L_0x0023;
    L_0x0048:
        r0 = r4.dzD;
        r0 = r0.azs();
        r2 = "GET";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0056:
        r0 = r4.dzD;
        r0 = r0.azs();
        r2 = "HEAD";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r1;
        goto L_0x0023;
    L_0x0066:
        r0 = r4.client;
        r0 = r0.getFollowRedirects();
        if (r0 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r1;
        goto L_0x0023;
    L_0x0070:
        r0 = r4.dzE;
        r2 = "Location";
        r0 = r0.kK(r2);
        if (r0 != 0) goto L_0x007c;
    L_0x007a:
        r0 = r1;
        goto L_0x0023;
    L_0x007c:
        r2 = r4.dzD;
        r2 = r2.azq();
        r0 = r2.kA(r0);
        if (r0 != 0) goto L_0x008a;
    L_0x0088:
        r0 = r1;
        goto L_0x0023;
    L_0x008a:
        r2 = r0.ayR();
        r3 = r4.dzD;
        r3 = r3.azq();
        r3 = r3.ayR();
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x00a9;
    L_0x009e:
        r2 = r4.client;
        r2 = r2.azi();
        if (r2 != 0) goto L_0x00a9;
    L_0x00a6:
        r0 = r1;
        goto L_0x0023;
    L_0x00a9:
        r2 = r4.dzD;
        r2 = r2.azv();
        r3 = r4.dzD;
        r3 = r3.azs();
        r3 = com.fossil.dwv.kS(r3);
        if (r3 == 0) goto L_0x00cf;
    L_0x00bb:
        r3 = "GET";
        r2.m9902a(r3, r1);
        r1 = "Transfer-Encoding";
        r2.kM(r1);
        r1 = "Content-Length";
        r2.kM(r1);
        r1 = "Content-Type";
        r2.kM(r1);
    L_0x00cf:
        r1 = r4.m10230f(r0);
        if (r1 != 0) goto L_0x00da;
    L_0x00d5:
        r1 = "Authorization";
        r2.kM(r1);
    L_0x00da:
        r0 = r2.m9903d(r0);
        r0 = r0.azx();
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dwu.aBg():com.fossil.dvj");
    }

    public boolean m10230f(dvf com_fossil_dvf) {
        dvf azq = this.dzD.azq();
        return azq.ayV().equals(com_fossil_dvf.ayV()) && azq.ayW() == com_fossil_dvf.ayW() && azq.ayR().equals(com_fossil_dvf.ayR());
    }

    private static dur m10212a(dvi com_fossil_dvi, dvj com_fossil_dvj) {
        SSLSocketFactory ayc;
        HostnameVerifier hostnameVerifier;
        duw com_fossil_duw = null;
        if (com_fossil_dvj.ayS()) {
            ayc = com_fossil_dvi.ayc();
            hostnameVerifier = com_fossil_dvi.getHostnameVerifier();
            com_fossil_duw = com_fossil_dvi.ayh();
        } else {
            hostnameVerifier = null;
            ayc = null;
        }
        return new dur(com_fossil_dvj.azq().ayV(), com_fossil_dvj.azq().ayW(), com_fossil_dvi.getSocketFactory(), ayc, hostnameVerifier, com_fossil_duw, com_fossil_dvi.ayd(), com_fossil_dvi.ayg(), com_fossil_dvi.aye(), com_fossil_dvi.ayf(), com_fossil_dvi.getProxySelector());
    }
}
