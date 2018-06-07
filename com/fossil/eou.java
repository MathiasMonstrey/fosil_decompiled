package com.fossil;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class eou implements eov {
    private final emu dMZ;
    private eox dPm;
    private boolean dPn;
    private SSLSocketFactory dum;

    static /* synthetic */ class C34911 {
        static final /* synthetic */ int[] dPo = new int[HttpMethod.values().length];

        static {
            try {
                dPo[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dPo[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dPo[HttpMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dPo[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public eou() {
        this(new eml());
    }

    public eou(emu com_fossil_emu) {
        this.dMZ = com_fossil_emu;
    }

    public void mo2990a(eox com_fossil_eox) {
        if (this.dPm != com_fossil_eox) {
            this.dPm = com_fossil_eox;
            aGd();
        }
    }

    private synchronized void aGd() {
        this.dPn = false;
        this.dum = null;
    }

    public HttpRequest mo2989a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest a;
        switch (C34911.dPo[httpMethod.ordinal()]) {
            case 1:
                a = HttpRequest.a(str, map, true);
                break;
            case 2:
                a = HttpRequest.b(str, map, true);
                break;
            case 3:
                a = HttpRequest.H(str);
                break;
            case 4:
                a = HttpRequest.I(str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (mu(str) && this.dPm != null) {
            SSLSocketFactory sSLSocketFactory = getSSLSocketFactory();
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) a.getConnection()).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return a;
    }

    private boolean mu(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith(UpPlatformSdkConstants.URI_SCHEME);
    }

    private synchronized SSLSocketFactory getSSLSocketFactory() {
        if (this.dum == null && !this.dPn) {
            this.dum = aGe();
        }
        return this.dum;
    }

    private synchronized SSLSocketFactory aGe() {
        SSLSocketFactory b;
        this.dPn = true;
        try {
            b = eow.m10994b(this.dPm);
            this.dMZ.mo2950d("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.dMZ.mo2953g("Fabric", "Exception while validating pinned certs", e);
            b = null;
        }
        return b;
    }
}
