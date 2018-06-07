package com.fossil;

import com.fossil.dve.C3222a;
import java.io.IOException;
import java.net.URI;

public final class dvj {
    private final dvf dwd;
    private final dve dwf;
    private final dvk dwg;
    private volatile URI dwh;
    private volatile duu dwi;
    private final String method;
    private final Object tag;

    public static class C3227a {
        private dvf dwd;
        private dvk dwg;
        private C3222a dwj;
        private String method;
        private Object tag;

        public C3227a() {
            this.method = "GET";
            this.dwj = new C3222a();
        }

        private C3227a(dvj com_fossil_dvj) {
            this.dwd = com_fossil_dvj.dwd;
            this.method = com_fossil_dvj.method;
            this.dwg = com_fossil_dvj.dwg;
            this.tag = com_fossil_dvj.tag;
            this.dwj = com_fossil_dvj.dwf.ayN();
        }

        public C3227a m9903d(dvf com_fossil_dvf) {
            if (com_fossil_dvf == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.dwd = com_fossil_dvf;
            return this;
        }

        public C3227a kL(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
            }
            dvf kB = dvf.kB(str);
            if (kB != null) {
                return m9903d(kB);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public C3227a aY(String str, String str2) {
            this.dwj.aW(str, str2);
            return this;
        }

        public C3227a aZ(String str, String str2) {
            this.dwj.aU(str, str2);
            return this;
        }

        public C3227a kM(String str) {
            this.dwj.kx(str);
            return this;
        }

        public C3227a m9902a(String str, dvk com_fossil_dvk) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (com_fossil_dvk != null && !dwv.kS(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (com_fossil_dvk == null && dwv.kR(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.method = str;
                this.dwg = com_fossil_dvk;
                return this;
            }
        }

        public dvj azx() {
            if (this.dwd != null) {
                return new dvj();
            }
            throw new IllegalStateException("url == null");
        }
    }

    private dvj(C3227a c3227a) {
        Object e;
        this.dwd = c3227a.dwd;
        this.method = c3227a.method;
        this.dwf = c3227a.dwj.ayO();
        this.dwg = c3227a.dwg;
        if (c3227a.tag != null) {
            e = c3227a.tag;
        } else {
            dvj com_fossil_dvj = this;
        }
        this.tag = e;
    }

    public dvf azq() {
        return this.dwd;
    }

    public URI ayQ() throws IOException {
        try {
            URI uri = this.dwh;
            if (uri == null) {
                uri = this.dwd.ayQ();
                this.dwh = uri;
            }
            return uri;
        } catch (IllegalStateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String azr() {
        return this.dwd.toString();
    }

    public String azs() {
        return this.method;
    }

    public dve azt() {
        return this.dwf;
    }

    public String kK(String str) {
        return this.dwf.get(str);
    }

    public dvk azu() {
        return this.dwg;
    }

    public C3227a azv() {
        return new C3227a();
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

    public boolean ayS() {
        return this.dwd.ayS();
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.dwd + ", tag=" + (this.tag != this ? this.tag : null) + '}';
    }
}
