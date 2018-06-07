package com.fossil;

import com.fossil.dve.C3222a;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class dvi implements Cloneable {
    private static final List<Protocol> dvL = dvw.m9976m(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static final List<dva> dvM = dvw.m9976m(dva.dvi, dva.dvj, dva.dvk);
    private static SSLSocketFactory dvN;
    private Proxy dui;
    private SocketFactory dul;
    private SSLSocketFactory dum;
    private duw dun;
    private dus duo;
    private List<Protocol> dup;
    private List<dva> duq;
    private dvq dur;
    private final dvv dvO;
    private dvc dvP;
    private final List<dvg> dvQ;
    private final List<dvg> dvR;
    private CookieHandler dvS;
    private dut dvT;
    private duz dvU;
    private dvs dvV;
    private boolean dvW;
    private boolean dvX;
    private boolean dvY;
    private int dvZ;
    private int dwa;
    private int dwb;
    private HostnameVerifier hostnameVerifier;
    private ProxySelector proxySelector;

    static class C32251 extends dvp {
        C32251() {
        }

        public dxd mo2694a(duy com_fossil_duy, dwu com_fossil_dwu) throws IOException {
            return com_fossil_duy.m9809a(com_fossil_dwu);
        }

        public boolean mo2704d(duy com_fossil_duy) {
            return com_fossil_duy.ayv();
        }

        public int mo2705e(duy com_fossil_duy) {
            return com_fossil_duy.ayD();
        }

        public void mo2695a(duy com_fossil_duy, Protocol protocol) {
            com_fossil_duy.m9812a(protocol);
        }

        public void mo2701b(duy com_fossil_duy, dwu com_fossil_dwu) {
            com_fossil_duy.cR(com_fossil_dwu);
        }

        public boolean mo2706f(duy com_fossil_duy) {
            return com_fossil_duy.isReadable();
        }

        public void mo2698a(C3222a c3222a, String str) {
            c3222a.kw(str);
        }

        public dvq mo2700b(dvi com_fossil_dvi) {
            return com_fossil_dvi.azg();
        }

        public void mo2696a(duz com_fossil_duz, duy com_fossil_duy) {
            com_fossil_duz.m9816a(com_fossil_duy);
        }

        public dvv mo2702c(dvi com_fossil_dvi) {
            return com_fossil_dvi.azk();
        }

        public dvs mo2703d(dvi com_fossil_dvi) {
            return com_fossil_dvi.dvV;
        }

        public void mo2699a(dvi com_fossil_dvi, duy com_fossil_duy, dwu com_fossil_dwu, dvj com_fossil_dvj) throws RouteException {
            com_fossil_duy.m9811a(com_fossil_dvi, (Object) com_fossil_dwu, com_fossil_dvj);
        }

        public void mo2697a(dva com_fossil_dva, SSLSocket sSLSocket, boolean z) {
            com_fossil_dva.m9835a(sSLSocket, z);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return azp();
    }

    static {
        dvp.dwA = new C32251();
    }

    public dvi() {
        this.dvQ = new ArrayList();
        this.dvR = new ArrayList();
        this.dvW = true;
        this.dvX = true;
        this.dvY = true;
        this.dvZ = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dwa = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dwb = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dvO = new dvv();
        this.dvP = new dvc();
    }

    private dvi(dvi com_fossil_dvi) {
        this.dvQ = new ArrayList();
        this.dvR = new ArrayList();
        this.dvW = true;
        this.dvX = true;
        this.dvY = true;
        this.dvZ = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dwa = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dwb = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        this.dvO = com_fossil_dvi.dvO;
        this.dvP = com_fossil_dvi.dvP;
        this.dui = com_fossil_dvi.dui;
        this.dup = com_fossil_dvi.dup;
        this.duq = com_fossil_dvi.duq;
        this.dvQ.addAll(com_fossil_dvi.dvQ);
        this.dvR.addAll(com_fossil_dvi.dvR);
        this.proxySelector = com_fossil_dvi.proxySelector;
        this.dvS = com_fossil_dvi.dvS;
        this.dvT = com_fossil_dvi.dvT;
        this.dur = this.dvT != null ? this.dvT.dur : com_fossil_dvi.dur;
        this.dul = com_fossil_dvi.dul;
        this.dum = com_fossil_dvi.dum;
        this.hostnameVerifier = com_fossil_dvi.hostnameVerifier;
        this.dun = com_fossil_dvi.dun;
        this.duo = com_fossil_dvi.duo;
        this.dvU = com_fossil_dvi.dvU;
        this.dvV = com_fossil_dvi.dvV;
        this.dvW = com_fossil_dvi.dvW;
        this.dvX = com_fossil_dvi.dvX;
        this.dvY = com_fossil_dvi.dvY;
        this.dvZ = com_fossil_dvi.dvZ;
        this.dwa = com_fossil_dvi.dwa;
        this.dwb = com_fossil_dvi.dwb;
    }

    public void m9895c(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.dvZ = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public int getConnectTimeout() {
        return this.dvZ;
    }

    public void m9896d(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.dwa = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public int getReadTimeout() {
        return this.dwa;
    }

    public int aze() {
        return this.dwb;
    }

    public Proxy ayg() {
        return this.dui;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public CookieHandler azf() {
        return this.dvS;
    }

    dvq azg() {
        return this.dur;
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

    public duw ayh() {
        return this.dun;
    }

    public dus ayd() {
        return this.duo;
    }

    public duz azh() {
        return this.dvU;
    }

    public boolean azi() {
        return this.dvW;
    }

    public boolean getFollowRedirects() {
        return this.dvX;
    }

    public boolean azj() {
        return this.dvY;
    }

    dvv azk() {
        return this.dvO;
    }

    public dvc azl() {
        return this.dvP;
    }

    public List<Protocol> aye() {
        return this.dup;
    }

    public List<dva> ayf() {
        return this.duq;
    }

    public List<dvg> azm() {
        return this.dvQ;
    }

    public List<dvg> azn() {
        return this.dvR;
    }

    public duv m9894c(dvj com_fossil_dvj) {
        return new duv(this, com_fossil_dvj);
    }

    dvi azo() {
        dvi com_fossil_dvi = new dvi(this);
        if (com_fossil_dvi.proxySelector == null) {
            com_fossil_dvi.proxySelector = ProxySelector.getDefault();
        }
        if (com_fossil_dvi.dvS == null) {
            com_fossil_dvi.dvS = CookieHandler.getDefault();
        }
        if (com_fossil_dvi.dul == null) {
            com_fossil_dvi.dul = SocketFactory.getDefault();
        }
        if (com_fossil_dvi.dum == null) {
            com_fossil_dvi.dum = getDefaultSSLSocketFactory();
        }
        if (com_fossil_dvi.hostnameVerifier == null) {
            com_fossil_dvi.hostnameVerifier = dxf.dAg;
        }
        if (com_fossil_dvi.dun == null) {
            com_fossil_dvi.dun = duw.duN;
        }
        if (com_fossil_dvi.duo == null) {
            com_fossil_dvi.duo = dwn.dyZ;
        }
        if (com_fossil_dvi.dvU == null) {
            com_fossil_dvi.dvU = duz.ayE();
        }
        if (com_fossil_dvi.dup == null) {
            com_fossil_dvi.dup = dvL;
        }
        if (com_fossil_dvi.duq == null) {
            com_fossil_dvi.duq = dvM;
        }
        if (com_fossil_dvi.dvV == null) {
            com_fossil_dvi.dvV = dvs.dwB;
        }
        return com_fossil_dvi;
    }

    private synchronized SSLSocketFactory getDefaultSSLSocketFactory() {
        if (dvN == null) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                dvN = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        return dvN;
    }

    public dvi azp() {
        return new dvi(this);
    }
}
