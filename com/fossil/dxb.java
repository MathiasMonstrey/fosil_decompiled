package com.fossil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class dxb {
    private final dvi client;
    private List<InetSocketAddress> dAa = Collections.emptyList();
    private int dAb;
    private final List<dvn> dAc = new ArrayList();
    private final dvv dvO;
    private final dvs dvV;
    private final dvf dwd;
    private final dur dwu;
    private Proxy dzW;
    private InetSocketAddress dzX;
    private List<Proxy> dzY = Collections.emptyList();
    private int dzZ;

    private dxb(dur com_fossil_dur, dvf com_fossil_dvf, dvi com_fossil_dvi) {
        this.dwu = com_fossil_dur;
        this.dwd = com_fossil_dvf;
        this.client = com_fossil_dvi;
        this.dvO = dvp.dwA.mo2702c(com_fossil_dvi);
        this.dvV = dvp.dwA.mo2703d(com_fossil_dvi);
        m10252a(com_fossil_dvf, com_fossil_dur.ayg());
    }

    public static dxb m10250a(dur com_fossil_dur, dvj com_fossil_dvj, dvi com_fossil_dvi) throws IOException {
        return new dxb(com_fossil_dur, com_fossil_dvj.azq(), com_fossil_dvi);
    }

    public boolean hasNext() {
        return aBl() || aBj() || aBn();
    }

    public dvn aBi() throws IOException {
        if (!aBl()) {
            if (aBj()) {
                this.dzW = aBk();
            } else if (aBn()) {
                return aBo();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.dzX = aBm();
        dvn com_fossil_dvn = new dvn(this.dwu, this.dzW, this.dzX);
        if (!this.dvO.m9965c(com_fossil_dvn)) {
            return com_fossil_dvn;
        }
        this.dAc.add(com_fossil_dvn);
        return aBi();
    }

    public void m10254a(dvn com_fossil_dvn, IOException iOException) {
        if (!(com_fossil_dvn.ayg().type() == Type.DIRECT || this.dwu.getProxySelector() == null)) {
            this.dwu.getProxySelector().connectFailed(this.dwd.ayQ(), com_fossil_dvn.ayg().address(), iOException);
        }
        this.dvO.m9963a(com_fossil_dvn);
    }

    private void m10252a(dvf com_fossil_dvf, Proxy proxy) {
        if (proxy != null) {
            this.dzY = Collections.singletonList(proxy);
        } else {
            this.dzY = new ArrayList();
            Collection select = this.client.getProxySelector().select(com_fossil_dvf.ayQ());
            if (select != null) {
                this.dzY.addAll(select);
            }
            this.dzY.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.dzY.add(Proxy.NO_PROXY);
        }
        this.dzZ = 0;
    }

    private boolean aBj() {
        return this.dzZ < this.dzY.size();
    }

    private Proxy aBk() throws IOException {
        if (aBj()) {
            List list = this.dzY;
            int i = this.dzZ;
            this.dzZ = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m10253a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.dwu.aya() + "; exhausted proxy configurations: " + this.dzY);
    }

    private void m10253a(Proxy proxy) throws IOException {
        String aya;
        int ayb;
        this.dAa = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            aya = this.dwu.aya();
            ayb = this.dwu.ayb();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                String a = m10251a(inetSocketAddress);
                int port = inetSocketAddress.getPort();
                aya = a;
                ayb = port;
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (ayb < 1 || ayb > 65535) {
            throw new SocketException("No route to " + aya + ":" + ayb + "; port is out of range");
        }
        for (InetAddress inetSocketAddress2 : this.dvV.kO(aya)) {
            this.dAa.add(new InetSocketAddress(inetSocketAddress2, ayb));
        }
        this.dAb = 0;
    }

    static String m10251a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean aBl() {
        return this.dAb < this.dAa.size();
    }

    private InetSocketAddress aBm() throws IOException {
        if (aBl()) {
            List list = this.dAa;
            int i = this.dAb;
            this.dAb = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        throw new SocketException("No route to " + this.dwu.aya() + "; exhausted inet socket addresses: " + this.dAa);
    }

    private boolean aBn() {
        return !this.dAc.isEmpty();
    }

    private dvn aBo() {
        return (dvn) this.dAc.remove(0);
    }
}
