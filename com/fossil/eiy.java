package com.fossil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.ua.sdk.NetworkError;
import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import com.ua.sdk.authentication.AuthenticationManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;

public class eiy {
    public static final String[] dIJ = new String[]{"jpg", "png", "gif", "jpeg"};

    public static void m10768a(AuthenticationManager authenticationManager) throws UaException {
        if (authenticationManager == null) {
            throw new UaException("AuthenticaitonManager is null.");
        } else if (!authenticationManager.abM()) {
            throw new UaException(Code.NOT_AUTHENTICATED);
        }
    }

    public static void aDw() throws IllegalStateException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must call on main thread.");
        }
    }

    public static <T> T dd(T t) throws NullPointerException {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T m10771e(T t, String str) throws NullPointerException {
        if (t != null) {
            return t;
        }
        if (str == null) {
            throw new NullPointerException();
        }
        throw new NullPointerException(str + " is null");
    }

    public static void m10770c(HttpURLConnection httpURLConnection) throws UaException {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != MFNetworkReturnCode.RESPONSE_OK) {
                throw new NetworkError(responseCode, httpURLConnection);
            }
        } catch (InterruptedIOException e) {
            throw new UaException(Code.CANCELED);
        } catch (IOException e2) {
            throw new UaException(Code.UNKNOWN);
        }
    }

    public static void ek(Context context) throws UaException {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            throw new UaException(Code.NOT_CONNECTED);
        }
    }

    public static void m10769a(HttpURLConnection httpURLConnection, int i) throws UaException {
        if (httpURLConnection == null) {
            throw new UaException("connection is null, cannot check response code.");
        }
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != i) {
                throw new NetworkError(responseCode, httpURLConnection);
            }
        } catch (InterruptedIOException e) {
            throw new UaException(Code.CANCELED);
        } catch (IOException e2) {
            throw new UaException(Code.UNKNOWN);
        }
    }
}
