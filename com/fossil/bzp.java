package com.fossil;

import com.fossil.ats.C1879a.C1882c;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1893g;
import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class bzp {
    public static final Scope bJQ = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope bJR = new Scope("https://www.googleapis.com/auth/plus.me");
    @Deprecated
    public static final bzo bJS = new bte();
    @Deprecated
    public static final bzn bJT = new btb();
    @Deprecated
    private static cac bJU = new btd();
    private static cab bJV = new btc();
    @Deprecated
    public static final ats<C1973a> bfF = new ats("Plus.API", bvj, bvi);
    public static final C1893g<bzv> bvi = new C1893g();
    private static C1890b<bzv, C1973a> bvj = new cad();

    public static final class C1973a implements C1882c {
        private String bJW;
        final Set<String> bJX;

        private C1973a() {
            this.bJW = null;
            this.bJX = new HashSet();
        }
    }

    public static bzv m5851a(atv com_fossil_atv, boolean z) {
        awa.m4637b(com_fossil_atv != null, "GoogleApiClient parameter is required.");
        awa.m4634a(com_fossil_atv.isConnected(), "GoogleApiClient must be connected.");
        awa.m4634a(com_fossil_atv.mo1331a(bfF), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean b = com_fossil_atv.mo1309b(bfF);
        if (!z || b) {
            return b ? (bzv) com_fossil_atv.mo1329a(bvi) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
