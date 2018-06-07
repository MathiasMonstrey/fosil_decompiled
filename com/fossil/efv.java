package com.fossil;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.misfit.frameworks.common.constants.Constants;
import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.authentication.AuthenticationManager.AuthenticationType;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;

public class efv implements AuthenticationManager {
    protected ExecutorService aIj;
    protected efw dGm;
    protected SharedPreferences dGn;
    protected egb dGo;
    private long dGp = Long.MIN_VALUE;

    static /* synthetic */ class C33761 {
        static final /* synthetic */ int[] dGq = new int[AuthenticationType.values().length];

        static {
            try {
                dGq[AuthenticationType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dGq[AuthenticationType.CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dGq[AuthenticationType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void m10619a(efw com_fossil_efw, ExecutorService executorService, SharedPreferences sharedPreferences) {
        this.dGm = (efw) eiy.dd(com_fossil_efw);
        this.aIj = (ExecutorService) eiy.dd(executorService);
        this.dGn = (SharedPreferences) eiy.dd(sharedPreferences);
        String string = sharedPreferences.getString("mmdk_oauth2_access_token", null);
        if (string != null) {
            String string2 = sharedPreferences.getString("mmdk_oauth2_refresh_token", null);
            long j = sharedPreferences.getLong("mmdk_oauth2_refresh_time", 0);
            this.dGo = new egc();
            this.dGo.setAccessToken(string);
            this.dGo.setRefreshToken(string2);
            this.dGo.mo2855e(Long.valueOf(j));
        }
    }

    public synchronized void aU(long j) throws UaException {
        if (!abM()) {
            ecq.error("Can't refresh Oauth2Credentials, not authenticated.");
            throw new UaException(Code.NOT_AUTHENTICATED);
        } else if (j > this.dGp) {
            try {
                egb b = this.dGm.mo2843b(this.dGo);
                this.dGp = SystemClock.elapsedRealtime();
                m10620a(b);
                ecq.debug("Oauth2Credentials have been refreshed");
            } catch (Throwable e) {
                if (e.getResponseCode() == 401) {
                    ecq.m10489d("Failed to refresh Oauth2Credentials.", e);
                }
                aCB();
                throw e;
            } catch (Throwable e2) {
                ecq.m10489d("Failed to refresh Oauth2Credentials.", e2);
                throw e2;
            }
        } else {
            ecq.debug("Oauth2Credentials were already refreshed. Not refreshing again.");
        }
    }

    public void m10622a(URLConnection uRLConnection, AuthenticationType authenticationType) throws UaException {
        if (authenticationType != null) {
            switch (C33761.dGq[authenticationType.ordinal()]) {
                case 1:
                    m10621a(uRLConnection);
                    return;
                case 2:
                    m10623b(uRLConnection);
                    return;
                default:
                    return;
            }
        }
    }

    public synchronized void m10621a(URLConnection uRLConnection) throws UaException {
        eiy.m10768a(this);
        if (this.dGo != null) {
            aCY();
            m10618a(this.dGo, uRLConnection);
        }
    }

    public synchronized void m10623b(URLConnection uRLConnection) throws UaException {
        m10618a(this.dGm.aCZ(), uRLConnection);
    }

    private synchronized void m10618a(egb com_fossil_egb, URLConnection uRLConnection) {
        uRLConnection.setRequestProperty(Constants.YO_HEADER_TOKEN, "Bearer " + com_fossil_egb.getAccessToken());
    }

    private synchronized void aCY() throws UaException {
        if (this.dGo != null && this.dGo.aDa().longValue() - 1200000 <= System.currentTimeMillis()) {
            aU(System.nanoTime());
        }
    }

    public synchronized void lx(String str) throws UaException {
        ecq.debug("Attempting login with authorization code.");
        m10620a(this.dGm.ly(str));
        ecq.debug("Successfully logged in using authorization code.");
    }

    public boolean abM() {
        return this.dGo != null;
    }

    public synchronized void aCB() {
        this.dGo = null;
        this.dGn.edit().remove("mmdk_oauth2_access_token").remove("mmdk_oauth2_refresh_token").remove("mmdk_oauth2_refresh_time").commit();
    }

    public synchronized void m10620a(egb com_fossil_egb) {
        eiy.m10771e(com_fossil_egb, "oAuth2Credentials");
        this.dGo = com_fossil_egb;
        this.dGn.edit().putString("mmdk_oauth2_access_token", com_fossil_egb.getAccessToken()).putString("mmdk_oauth2_refresh_token", com_fossil_egb.getRefreshToken()).putLong("mmdk_oauth2_refresh_time", com_fossil_egb.aDa().longValue()).commit();
    }

    public synchronized String lo(String str) {
        return this.dGm.lo(str);
    }
}
