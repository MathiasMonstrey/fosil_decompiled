package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import java.net.URL;

public class ekd extends eik<eju> {
    public ecj dJE = new eiv(null, null);
    public ecd<eju> dJF = new eiw(null);

    public /* synthetic */ ecm mo2817e(ecj com_fossil_ecj) throws UaException {
        return m10801k(com_fossil_ecj);
    }

    public ekd(ein com_fossil_ein, ejb com_fossil_ejb, AuthenticationManager authenticationManager, eis<eju> com_fossil_eis_com_fossil_eju, eis<ecc<eju>> com_fossil_eis_com_fossil_ecc_com_fossil_eju) {
        super(com_fossil_ein, authenticationManager, com_fossil_ejb, com_fossil_eis_com_fossil_eju, null, com_fossil_eis_com_fossil_ecc_com_fossil_eju);
    }

    protected URL aCG() {
        throw new UnsupportedOperationException("Create RemooteConnectionType is not supported.");
    }

    public eju m10801k(ecj com_fossil_ecj) throws UaException {
        if (com_fossil_ecj == null) {
            com_fossil_ecj = this.dJE;
        }
        return (eju) super.mo2817e(com_fossil_ecj);
    }

    protected URL mo2819a(ecj com_fossil_ecj) {
        return this.dGs.mo2890i(com_fossil_ecj);
    }
}
