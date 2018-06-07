package com.fossil;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class dxf implements HostnameVerifier {
    public static final dxf dAg = new dxf();
    private static final Pattern dAh = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private dxf() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m10259a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    public boolean m10259a(String str, X509Certificate x509Certificate) {
        if (kX(str)) {
            return m10257b(str, x509Certificate);
        }
        return m10258c(str, x509Certificate);
    }

    static boolean kX(String str) {
        return dAh.matcher(str).matches();
    }

    private boolean m10257b(String str, X509Certificate x509Certificate) {
        List a = m10255a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) a.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean m10258c(String str, X509Certificate x509Certificate) {
        String toLowerCase = str.toLowerCase(Locale.US);
        List a = m10255a(x509Certificate, 2);
        int size = a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            if (be(toLowerCase, (String) a.get(i))) {
                return true;
            }
            i++;
            int i2 = 1;
        }
        if (obj == null) {
            String kW = new dxe(x509Certificate.getSubjectX500Principal()).kW("cn");
            if (kW != null) {
                return be(toLowerCase, kW);
            }
        }
        return false;
    }

    public static List<String> m10256b(X509Certificate x509Certificate) {
        Collection a = m10255a(x509Certificate, 7);
        Collection a2 = m10255a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    private static List<String> m10255a(X509Certificate x509Certificate, int i) {
        List<String> arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private boolean be(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String toLowerCase = str2.toLowerCase(Locale.US);
        if (!toLowerCase.contains("*")) {
            return str.equals(toLowerCase);
        }
        if (!toLowerCase.startsWith("*.") || toLowerCase.indexOf(42, 1) != -1 || str.length() < toLowerCase.length() || "*.".equals(toLowerCase)) {
            return false;
        }
        toLowerCase = toLowerCase.substring(1);
        if (!str.endsWith(toLowerCase)) {
            return false;
        }
        int length = str.length() - toLowerCase.length();
        if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
            return true;
        }
        return false;
    }
}
