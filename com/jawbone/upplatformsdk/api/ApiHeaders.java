package com.jawbone.upplatformsdk.api;

import com.misfit.frameworks.common.constants.Constants;
import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;

public class ApiHeaders implements RequestInterceptor {
    private String accessToken;

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void clearAccessToken() {
        this.accessToken = null;
    }

    public void intercept(RequestFacade requestFacade) {
        if (this.accessToken != null) {
            requestFacade.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + this.accessToken);
            requestFacade.addHeader("Accept", "application/json");
            requestFacade.addHeader("Content-Type", "application/x-www-form-urlencoded");
        }
    }
}
