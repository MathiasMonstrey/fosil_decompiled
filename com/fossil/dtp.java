package com.fossil;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class dtp extends SSLSocketFactory {
    private static final String TAG = dtp.class.getName();
    SSLContext dsw = SSLContext.getInstance("TLS");

    public static class C3191a implements X509TrustManager {
        protected ArrayList<X509TrustManager> dsx = new ArrayList();

        protected C3191a(KeyStore... keyStoreArr) {
            ArrayList arrayList = new ArrayList();
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(null);
                arrayList.add(instance);
                for (KeyStore keyStore : keyStoreArr) {
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance2.init(keyStore);
                    arrayList.add(instance2);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (TrustManager trustManager : ((TrustManagerFactory) it.next()).getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            this.dsx.add((X509TrustManager) trustManager);
                        }
                    }
                }
                if (this.dsx.size() == 0) {
                    throw new RuntimeException("Couldn't find any X509TrustManagers");
                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            ((X509TrustManager) this.dsx.get(0)).checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Iterator it = this.dsx.iterator();
            while (it.hasNext()) {
                try {
                    ((X509TrustManager) it.next()).checkServerTrusted(x509CertificateArr, str);
                    return;
                } catch (CertificateException e) {
                }
            }
            throw new CertificateException();
        }

        public X509Certificate[] getAcceptedIssuers() {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.dsx.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(((X509TrustManager) it.next()).getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        }
    }

    public dtp(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        SSLContext sSLContext = this.dsw;
        TrustManager[] trustManagerArr = new TrustManager[1];
        trustManagerArr[0] = new C3191a(keyStore);
        sSLContext.init(null, trustManagerArr, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.dsw.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.dsw.getSocketFactory().createSocket();
    }
}
