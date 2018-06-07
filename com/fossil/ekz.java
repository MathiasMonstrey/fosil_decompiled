package com.fossil;

import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.authentication.AuthenticationManager.AuthenticationType;
import java.net.URL;

public class ekz extends eik<ekn> {
    public ekz(ein com_fossil_ein, AuthenticationManager authenticationManager, ejb com_fossil_ejb, eis<ekn> com_fossil_eis_com_fossil_ekn, eit<ekn> com_fossil_eit_com_fossil_ekn, eis<ecc<ekn>> com_fossil_eis_com_fossil_ecc_com_fossil_ekn) {
        super(com_fossil_ein, authenticationManager, com_fossil_ejb, com_fossil_eis_com_fossil_ekn, com_fossil_eit_com_fossil_ekn, com_fossil_eis_com_fossil_ecc_com_fossil_ekn);
    }

    protected URL aCG() {
        return this.dGs.aDS();
    }

    protected AuthenticationType aDm() {
        return AuthenticationType.CLIENT;
    }

    protected URL mo2819a(ecj com_fossil_ecj) {
        if (com_fossil_ecj instanceof ekm) {
            return this.dGs.aDR();
        }
        return this.dGs.mo2888g(com_fossil_ecj);
    }
}
