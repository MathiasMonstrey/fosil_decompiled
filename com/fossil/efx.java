package com.fossil;

import android.content.Context;
import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import java.net.HttpURLConnection;

public class efx implements efw {
    private final Context context;
    private final String dDv;
    private final String dDw;
    private final ein dGr;
    private final ejb dGs;
    private final eis<egb> dGt;

    public efx(String str, String str2, ein com_fossil_ein, ejb com_fossil_ejb, eis<egb> com_fossil_eis_com_fossil_egb, Context context) {
        this.dGr = (ein) eiy.dd(com_fossil_ein);
        this.dGs = (ejb) eiy.dd(com_fossil_ejb);
        this.dGt = (eis) eiy.dd(com_fossil_eis_com_fossil_egb);
        this.dDv = (String) eiy.dd(str);
        this.dDw = (String) eiy.dd(str2);
        this.context = (Context) eiy.dd(context);
    }

    public String lo(String str) {
        return this.dGs.bj(this.dDv, str).toString();
    }

    public egb ly(String str) throws UaException {
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append("grant_type=authorization_code");
        stringBuilder.append("&client_id=").append(this.dDv);
        stringBuilder.append("&client_secret=").append(this.dDw);
        stringBuilder.append("&code=").append(str);
        return m10625D(stringBuilder);
    }

    public egb aCZ() throws UaException {
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append("grant_type=client_credentials");
        stringBuilder.append("&client_id=").append(this.dDv);
        stringBuilder.append("&client_secret=").append(this.dDw);
        return m10625D(stringBuilder);
    }

    public egb mo2843b(egb com_fossil_egb) throws UaException {
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append("grant_type=refresh_token");
        stringBuilder.append("&client_id=").append(this.dDv);
        stringBuilder.append("&client_secret=").append(this.dDw);
        stringBuilder.append("&refresh_token=").append(com_fossil_egb.getRefreshToken());
        return m10625D(stringBuilder);
    }

    private egb m10625D(CharSequence charSequence) throws UaException {
        HttpURLConnection b;
        try {
            b = this.dGr.m10760b(this.dGs.aDQ());
            b.setRequestMethod("POST");
            b.setDoOutput(true);
            b.setUseCaches(false);
            b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            elx.m10869a(charSequence, b.getOutputStream());
            eiy.m10770c(b);
            egb com_fossil_egb = (egb) this.dGt.mo2803p(b.getInputStream());
            b.disconnect();
            return com_fossil_egb;
        } catch (UaException e) {
            throw e;
        } catch (Throwable e2) {
            throw new UaException(Code.CANCELED, e2);
        } catch (Throwable e22) {
            UaException uaException = new UaException(e22);
        }
    }
}
