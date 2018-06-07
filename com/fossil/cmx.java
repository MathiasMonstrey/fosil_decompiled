package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import com.jawbone.upplatformsdk.api.ApiManager;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.jawbone.upplatformsdk.oauth.OauthUtils;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants.UpPlatformAuthScope;
import com.portfolio.platform.ui.profile.connectedapps.upbyjawbone.UpByJawBoneActivity;
import java.util.ArrayList;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class cmx {
    private C2215a cyC;
    private final cnr mSharedPreferencesManager;

    class C22141 implements Callback<OauthAccessTokenResponse> {
        final /* synthetic */ cmx cyD;

        C22141(cmx com_fossil_cmx) {
            this.cyD = com_fossil_cmx;
        }

        public /* synthetic */ void success(Object obj, Response response) {
            m7162a((OauthAccessTokenResponse) obj, response);
        }

        public void m7162a(OauthAccessTokenResponse oauthAccessTokenResponse, Response response) {
            if (this.cyD.cyC != null) {
                this.cyD.cyC.mo2349b(oauthAccessTokenResponse, response);
            }
        }

        public void failure(RetrofitError retrofitError) {
            if (this.cyD.cyC != null) {
                this.cyD.cyC.mo2342a(retrofitError);
            }
        }
    }

    public interface C2215a {
        void mo2342a(RetrofitError retrofitError);

        void mo2349b(OauthAccessTokenResponse oauthAccessTokenResponse, Response response);
    }

    public cmx(cnr com_fossil_cnr) {
        this.mSharedPreferencesManager = com_fossil_cnr;
    }

    public static Intent by(Context context) {
        List arrayList = new ArrayList();
        arrayList.add(UpPlatformAuthScope.GENERIC_EVENT_WRITE);
        arrayList.add(UpPlatformAuthScope.GENERIC_EVENT_READ);
        arrayList.add(UpPlatformAuthScope.TIME_SERIES_WRITE);
        Builder oauthParameters = OauthUtils.setOauthParameters("tgj1k5_6wy4", "fossil://redirect", arrayList);
        Intent intent = new Intent(context, UpByJawBoneActivity.class);
        intent.putExtra(UpPlatformSdkConstants.AUTH_URI, oauthParameters.build());
        return intent;
    }

    public void m7167a(OauthAccessTokenResponse oauthAccessTokenResponse) {
        this.mSharedPreferencesManager.gO(oauthAccessTokenResponse.access_token);
        this.mSharedPreferencesManager.gP(oauthAccessTokenResponse.refresh_token);
    }

    public void logout() {
        this.mSharedPreferencesManager.gO("");
        this.mSharedPreferencesManager.gP("");
    }

    public boolean abM() {
        return !this.mSharedPreferencesManager.adb().isEmpty();
    }

    public String getAccessToken() {
        return this.mSharedPreferencesManager.adb();
    }

    public String getRefreshToken() {
        return this.mSharedPreferencesManager.adc();
    }

    public void gm(String str) {
        ApiManager.getRequestInterceptor().clearAccessToken();
        ApiManager.getRestApiInterface().getAccessToken("tgj1k5_6wy4", "99d234a7cfcce6ecc7c1ae58a6f381deaa30c7ac", str, new C22141(this));
    }

    public void m7166a(C2215a c2215a) {
        this.cyC = c2215a;
    }
}
