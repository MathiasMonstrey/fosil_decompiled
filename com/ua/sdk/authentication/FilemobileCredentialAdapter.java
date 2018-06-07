package com.ua.sdk.authentication;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.efy;
import com.fossil.efz;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class FilemobileCredentialAdapter implements cfo<efy>, cfv<efy> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16152r(com_fossil_cfp, type, com_fossil_cfn);
    }

    public efy m16152r(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (efy) com_fossil_cfn.b(com_fossil_cfp, efz.class);
    }

    public cfp m16150a(efy com_fossil_efy, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_efy, com_fossil_efy.getClass());
    }
}
