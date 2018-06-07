package com.jawbone.upplatformsdk.api;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ApiManager {
    private static RestAdapter restAdapter;
    private static ApiHeaders restApiHeaders;
    private static RestApiInterface restApiInterface;

    static class CustomErrorHandler implements ErrorHandler {
        private CustomErrorHandler() {
        }

        public Throwable handleError(RetrofitError retrofitError) {
            Response response = retrofitError.getResponse();
            if (response == null || response.getStatus() != 401) {
                return retrofitError;
            }
            return retrofitError.getCause();
        }
    }

    private static RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new Builder().setRequestInterceptor(getRequestInterceptor()).setLogLevel(LogLevel.NONE).setEndpoint(UpPlatformSdkConstants.API_URL).build();
        }
        return restAdapter;
    }

    public static RestApiInterface getRestApiInterface() {
        restAdapter = getRestAdapter();
        if (restApiInterface == null) {
            restApiInterface = (RestApiInterface) restAdapter.create(RestApiInterface.class);
        }
        return restApiInterface;
    }

    public static ApiHeaders getRequestInterceptor() {
        if (restApiHeaders == null) {
            restApiHeaders = new ApiHeaders();
        }
        return restApiHeaders;
    }
}
