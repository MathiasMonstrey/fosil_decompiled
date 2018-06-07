package com.fossil;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class dvn {
    final Proxy dui;
    final dur dwu;
    final InetSocketAddress dwv;

    public dvn(dur com_fossil_dur, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (com_fossil_dur == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.dwu = com_fossil_dur;
            this.dui = proxy;
            this.dwv = inetSocketAddress;
        }
    }

    public dur azI() {
        return this.dwu;
    }

    public Proxy ayg() {
        return this.dui;
    }

    public InetSocketAddress azJ() {
        return this.dwv;
    }

    public boolean azK() {
        return this.dwu.dum != null && this.dui.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dvn)) {
            return false;
        }
        dvn com_fossil_dvn = (dvn) obj;
        if (this.dwu.equals(com_fossil_dvn.dwu) && this.dui.equals(com_fossil_dvn.dui) && this.dwv.equals(com_fossil_dvn.dwv)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.dwu.hashCode() + 527) * 31) + this.dui.hashCode()) * 31) + this.dwv.hashCode();
    }
}
