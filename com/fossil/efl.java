package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public class efl extends eik<efd> {
    protected /* synthetic */ Callable mo2837a(ecm com_fossil_ecm) throws UaException {
        return m10602c((efd) com_fossil_ecm);
    }

    public efl(ein com_fossil_ein, AuthenticationManager authenticationManager, ejb com_fossil_ejb, eit<efd> com_fossil_eit_com_fossil_efd, eis<efd> com_fossil_eis_com_fossil_efd) {
        super(com_fossil_ein, authenticationManager, com_fossil_ejb, com_fossil_eis_com_fossil_efd, com_fossil_eit_com_fossil_efd, null);
    }

    protected URL aCG() {
        return this.dGs.aDU();
    }

    protected Callable<efd> m10602c(final efd com_fossil_efd) throws UaException {
        return new Callable<efd>(this) {
            final /* synthetic */ efl dFR;

            public /* synthetic */ Object call() throws Exception {
                return aCR();
            }

            public efd aCR() throws Exception {
                URLConnection b = this.dFR.dGr.m10760b(this.dFR.aCG());
                eiy.m10768a(this.dFR.dIg);
                try {
                    this.dFR.dIg.a(b, this.dFR.aDm());
                    b.setRequestMethod("PUT");
                    b.setDoOutput(true);
                    b.setUseCaches(false);
                    this.dFR.dIe.mo2806b(com_fossil_efd, b.getOutputStream());
                    eiy.m10769a(b, 204);
                    efd com_fossil_efd = com_fossil_efd;
                    return com_fossil_efd;
                } finally {
                    b.disconnect();
                }
            }
        };
    }

    protected URL mo2819a(ecj com_fossil_ecj) {
        throw new UnsupportedOperationException("Fetch ActivityTimeSeries is unsupported.");
    }
}
