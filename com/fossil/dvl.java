package com.fossil;

import com.fossil.dve.C3222a;
import com.squareup.okhttp.Protocol;
import java.util.Collections;
import java.util.List;

public final class dvl {
    private final int drk;
    private final dvj duK;
    private final Protocol duW;
    private final dvd duY;
    private final dve dwf;
    private volatile duu dwi;
    private final dvm dwq;
    private dvl dwr;
    private dvl dws;
    private final dvl dwt;
    private final String message;

    public static class C3232a {
        private int drk;
        private dvj duK;
        private Protocol duW;
        private dvd duY;
        private C3222a dwj;
        private dvm dwq;
        private dvl dwr;
        private dvl dws;
        private dvl dwt;
        private String message;

        public C3232a() {
            this.drk = -1;
            this.dwj = new C3222a();
        }

        private C3232a(dvl com_fossil_dvl) {
            this.drk = -1;
            this.duK = com_fossil_dvl.duK;
            this.duW = com_fossil_dvl.duW;
            this.drk = com_fossil_dvl.drk;
            this.message = com_fossil_dvl.message;
            this.duY = com_fossil_dvl.duY;
            this.dwj = com_fossil_dvl.dwf.ayN();
            this.dwq = com_fossil_dvl.dwq;
            this.dwr = com_fossil_dvl.dwr;
            this.dws = com_fossil_dvl.dws;
            this.dwt = com_fossil_dvl.dwt;
        }

        public C3232a m9925i(dvj com_fossil_dvj) {
            this.duK = com_fossil_dvj;
            return this;
        }

        public C3232a m9924b(Protocol protocol) {
            this.duW = protocol;
            return this;
        }

        public C3232a mB(int i) {
            this.drk = i;
            return this;
        }

        public C3232a kN(String str) {
            this.message = str;
            return this;
        }

        public C3232a m9921a(dvd com_fossil_dvd) {
            this.duY = com_fossil_dvd;
            return this;
        }

        public C3232a bb(String str, String str2) {
            this.dwj.aW(str, str2);
            return this;
        }

        public C3232a bc(String str, String str2) {
            this.dwj.aU(str, str2);
            return this;
        }

        public C3232a m9923b(dve com_fossil_dve) {
            this.dwj = com_fossil_dve.ayN();
            return this;
        }

        public C3232a m9922a(dvm com_fossil_dvm) {
            this.dwq = com_fossil_dvm;
            return this;
        }

        public C3232a m9926k(dvl com_fossil_dvl) {
            if (com_fossil_dvl != null) {
                m9910a("networkResponse", com_fossil_dvl);
            }
            this.dwr = com_fossil_dvl;
            return this;
        }

        public C3232a m9927l(dvl com_fossil_dvl) {
            if (com_fossil_dvl != null) {
                m9910a("cacheResponse", com_fossil_dvl);
            }
            this.dws = com_fossil_dvl;
            return this;
        }

        private void m9910a(String str, dvl com_fossil_dvl) {
            if (com_fossil_dvl.dwq != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (com_fossil_dvl.dwr != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (com_fossil_dvl.dws != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (com_fossil_dvl.dwt != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public C3232a m9928m(dvl com_fossil_dvl) {
            if (com_fossil_dvl != null) {
                m9920n(com_fossil_dvl);
            }
            this.dwt = com_fossil_dvl;
            return this;
        }

        private void m9920n(dvl com_fossil_dvl) {
            if (com_fossil_dvl.dwq != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public dvl azF() {
            if (this.duK == null) {
                throw new IllegalStateException("request == null");
            } else if (this.duW == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.drk >= 0) {
                return new dvl();
            } else {
                throw new IllegalStateException("code < 0: " + this.drk);
            }
        }
    }

    private dvl(C3232a c3232a) {
        this.duK = c3232a.duK;
        this.duW = c3232a.duW;
        this.drk = c3232a.drk;
        this.message = c3232a.message;
        this.duY = c3232a.duY;
        this.dwf = c3232a.dwj.ayO();
        this.dwq = c3232a.dwq;
        this.dwr = c3232a.dwr;
        this.dws = c3232a.dws;
        this.dwt = c3232a.dwt;
    }

    public dvj azy() {
        return this.duK;
    }

    public Protocol azz() {
        return this.duW;
    }

    public int azA() {
        return this.drk;
    }

    public String message() {
        return this.message;
    }

    public dvd azB() {
        return this.duY;
    }

    public String kK(String str) {
        return ba(str, null);
    }

    public String ba(String str, String str2) {
        String str3 = this.dwf.get(str);
        return str3 != null ? str3 : str2;
    }

    public dve azt() {
        return this.dwf;
    }

    public dvm azC() {
        return this.dwq;
    }

    public C3232a azD() {
        return new C3232a();
    }

    public List<dux> azE() {
        String str;
        if (this.drk == 401) {
            str = "WWW-Authenticate";
        } else if (this.drk != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return dwx.m10239c(azt(), str);
    }

    public duu azw() {
        duu com_fossil_duu = this.dwi;
        if (com_fossil_duu != null) {
            return com_fossil_duu;
        }
        com_fossil_duu = duu.m9796a(this.dwf);
        this.dwi = com_fossil_duu;
        return com_fossil_duu;
    }

    public String toString() {
        return "Response{protocol=" + this.duW + ", code=" + this.drk + ", message=" + this.message + ", url=" + this.duK.azr() + '}';
    }
}
