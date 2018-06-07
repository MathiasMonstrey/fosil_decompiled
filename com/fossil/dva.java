package com.fossil;

import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.TlsVersion;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class dva {
    private static final CipherSuite[] dvh = new CipherSuite[]{CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final dva dvi = new C3220a(true).m9826a(dvh).m9827a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).dx(true).ayK();
    public static final dva dvj = new C3220a(dvi).m9827a(TlsVersion.TLS_1_0).dx(true).ayK();
    public static final dva dvk = new C3220a(false).ayK();
    final boolean dvl;
    private final String[] dvm;
    private final String[] dvn;
    final boolean dvo;

    public static final class C3220a {
        private boolean dvl;
        private String[] dvm;
        private String[] dvn;
        private boolean dvo;

        C3220a(boolean z) {
            this.dvl = z;
        }

        public C3220a(dva com_fossil_dva) {
            this.dvl = com_fossil_dva.dvl;
            this.dvm = com_fossil_dva.dvm;
            this.dvn = com_fossil_dva.dvn;
            this.dvo = com_fossil_dva.dvo;
        }

        public C3220a m9826a(CipherSuite... cipherSuiteArr) {
            if (this.dvl) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                this.dvm = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C3220a m9828e(String... strArr) {
            if (this.dvl) {
                if (strArr == null) {
                    this.dvm = null;
                } else {
                    this.dvm = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C3220a m9827a(TlsVersion... tlsVersionArr) {
            if (!this.dvl) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (tlsVersionArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            } else {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                this.dvn = strArr;
                return this;
            }
        }

        public C3220a m9829f(String... strArr) {
            if (this.dvl) {
                if (strArr == null) {
                    this.dvn = null;
                } else {
                    this.dvn = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C3220a dx(boolean z) {
            if (this.dvl) {
                this.dvo = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public dva ayK() {
            return new dva();
        }
    }

    private dva(C3220a c3220a) {
        this.dvl = c3220a.dvl;
        this.dvm = c3220a.dvm;
        this.dvn = c3220a.dvn;
        this.dvo = c3220a.dvo;
    }

    public List<CipherSuite> ayH() {
        if (this.dvm == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[this.dvm.length];
        for (int i = 0; i < this.dvm.length; i++) {
            cipherSuiteArr[i] = CipherSuite.forJavaName(this.dvm[i]);
        }
        return dvw.m9976m(cipherSuiteArr);
    }

    public List<TlsVersion> ayI() {
        TlsVersion[] tlsVersionArr = new TlsVersion[this.dvn.length];
        for (int i = 0; i < this.dvn.length; i++) {
            tlsVersionArr[i] = TlsVersion.forJavaName(this.dvn[i]);
        }
        return dvw.m9976m(tlsVersionArr);
    }

    public boolean ayJ() {
        return this.dvo;
    }

    void m9835a(SSLSocket sSLSocket, boolean z) {
        dva b = m9832b(sSLSocket, z);
        sSLSocket.setEnabledProtocols(b.dvn);
        String[] strArr = b.dvm;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    private dva m9832b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        Object obj = null;
        if (this.dvm != null) {
            obj = (String[]) dvw.m9972a(String.class, this.dvm, sSLSocket.getEnabledCipherSuites());
        }
        if (z) {
            String str = "TLS_FALLBACK_SCSV";
            if (Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
                if (obj == null) {
                    obj = sSLSocket.getEnabledCipherSuites();
                }
                strArr = new String[(obj.length + 1)];
                System.arraycopy(obj, 0, strArr, 0, obj.length);
                strArr[strArr.length - 1] = "TLS_FALLBACK_SCSV";
                return new C3220a(this).m9828e(strArr).m9829f((String[]) dvw.m9972a(String.class, this.dvn, sSLSocket.getEnabledProtocols())).ayK();
            }
        }
        Object obj2 = obj;
        return new C3220a(this).m9828e(strArr).m9829f((String[]) dvw.m9972a(String.class, this.dvn, sSLSocket.getEnabledProtocols())).ayK();
    }

    public boolean m9836a(SSLSocket sSLSocket) {
        if (!this.dvl) {
            return false;
        }
        if (!m9830a(this.dvn, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.dvm != null) {
            return m9830a(this.dvm, sSLSocket.getEnabledCipherSuites());
        } else if (sSLSocket.getEnabledCipherSuites().length > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean m9830a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (Object b : strArr) {
            if (m9833b((Object[]) strArr2, b)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean m9833b(T[] tArr, T t) {
        for (Object equal : tArr) {
            if (dvw.equal(t, equal)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dva)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        dva com_fossil_dva = (dva) obj;
        if (this.dvl != com_fossil_dva.dvl) {
            return false;
        }
        if (!this.dvl || (Arrays.equals(this.dvm, com_fossil_dva.dvm) && Arrays.equals(this.dvn, com_fossil_dva.dvn) && this.dvo == com_fossil_dva.dvo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.dvl) {
            return 17;
        }
        return (this.dvo ? 0 : 1) + ((((Arrays.hashCode(this.dvm) + 527) * 31) + Arrays.hashCode(this.dvn)) * 31);
    }

    public String toString() {
        if (!this.dvl) {
            return "ConnectionSpec()";
        }
        List ayH = ayH();
        return "ConnectionSpec(cipherSuites=" + (ayH == null ? "[use default]" : ayH.toString()) + ", tlsVersions=" + ayI() + ", supportsTlsExtensions=" + this.dvo + ")";
    }
}
