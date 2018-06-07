package com.fossil;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class eow {
    public static final SSLSocketFactory m10994b(eox com_fossil_eox) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        eoy com_fossil_eoy = new eoy(new eoz(com_fossil_eox.xW(), com_fossil_eox.xX()), com_fossil_eox);
        instance.init(null, new TrustManager[]{com_fossil_eoy}, null);
        return instance.getSocketFactory();
    }
}
