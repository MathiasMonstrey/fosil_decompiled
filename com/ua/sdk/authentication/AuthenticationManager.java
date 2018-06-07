package com.ua.sdk.authentication;

import com.fossil.egb;
import com.ua.sdk.UaException;
import java.net.URLConnection;

public interface AuthenticationManager {

    public enum AuthenticationType {
        NONE,
        USER,
        CLIENT
    }

    void m16148a(egb com_fossil_egb);

    void m16149a(URLConnection uRLConnection, AuthenticationType authenticationType) throws UaException;

    void aCB();

    void aU(long j) throws UaException;

    boolean abM();

    String lo(String str);

    void lx(String str) throws UaException;
}
