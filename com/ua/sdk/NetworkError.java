package com.ua.sdk;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.elx;
import com.ua.sdk.UaException.Code;
import java.net.HttpURLConnection;

public class NetworkError extends UaException {
    String message;
    final int responseCode;

    public NetworkError(int i, HttpURLConnection httpURLConnection) {
        super(getErrorCode(i));
        this.message = "";
        this.responseCode = i;
        try {
            this.message = elx.v(httpURLConnection.getErrorStream());
        } catch (Throwable th) {
            this.message = "";
        }
    }

    public NetworkError(int i) {
        this(i, (Throwable) null);
    }

    public NetworkError(int i, Throwable th) {
        super(getErrorCode(i), th);
        this.message = "";
        this.responseCode = i;
    }

    public String toString() {
        return "Response Code " + this.responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.message;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getHttpResponse() {
        return this.message;
    }

    public static final Code getErrorCode(int i) {
        return Code.NETWORK;
    }
}
