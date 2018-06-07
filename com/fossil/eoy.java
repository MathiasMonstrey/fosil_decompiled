package com.fossil;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class eoy implements X509TrustManager {
    private final TrustManager[] dPD;
    private final eoz dPE;
    private final long dPF;
    private final List<byte[]> dPG = new LinkedList();
    private final Set<X509Certificate> dPH = Collections.synchronizedSet(new HashSet());

    public eoy(eoz com_fossil_eoz, eox com_fossil_eox) {
        this.dPD = m10997a(com_fossil_eoz);
        this.dPE = com_fossil_eoz;
        this.dPF = com_fossil_eox.xZ();
        for (String mB : com_fossil_eox.xY()) {
            this.dPG.add(mB(mB));
        }
    }

    private TrustManager[] m10997a(eoz com_fossil_eoz) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(com_fossil_eoz.dPI);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m10998c(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.dPG) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m10996a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.dPD) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m10995a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.dPF == -1 || System.currentTimeMillis() - this.dPF <= 15552000000L) {
            X509Certificate[] a = eot.m10989a(x509CertificateArr, this.dPE);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m10998c(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        emm.aEU().aS("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.dPF) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.dPH.contains(x509CertificateArr[0])) {
            m10996a(x509CertificateArr, str);
            m10995a(x509CertificateArr);
            this.dPH.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    private byte[] mB(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
