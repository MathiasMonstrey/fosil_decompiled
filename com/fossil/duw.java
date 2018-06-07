package com.fossil;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class duw {
    public static final duw duN = new C3216a().ayu();
    private final Map<String, Set<ByteString>> duO;

    public static final class C3216a {
        private final Map<String, Set<ByteString>> duO = new LinkedHashMap();

        public duw ayu() {
            return new duw();
        }
    }

    private duw(C3216a c3216a) {
        this.duO = dvw.m9978z(c3216a.duO);
    }

    public void m9804i(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        int i = 0;
        Set<ByteString> ku = ku(str);
        if (ku != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (!ku.contains(m9803a((X509Certificate) list.get(i2)))) {
                    i2++;
                } else {
                    return;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            size = list.size();
            while (i < size) {
                Certificate certificate = (X509Certificate) list.get(i);
                append.append("\n    ").append(m9802a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
                i++;
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            for (ByteString base64 : ku) {
                append.append("\n    sha1/").append(base64.base64());
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    Set<ByteString> ku(String str) {
        Collection collection;
        Set<ByteString> set = (Set) this.duO.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            collection = (Set) this.duO.get("*." + str.substring(indexOf + 1));
        } else {
            collection = null;
        }
        if (set == null && collection == null) {
            return null;
        }
        if (set != null && collection != null) {
            Set<ByteString> linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(set);
            linkedHashSet.addAll(collection);
            return linkedHashSet;
        } else if (set == null) {
            return collection;
        } else {
            return set;
        }
    }

    public static String m9802a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + m9803a((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString m9803a(X509Certificate x509Certificate) {
        return dvw.m9967a(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }
}
