package com.ua.sdk.heartrate;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eie;
import com.fossil.eif;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class HeartRateZonesGsonAdapter implements cfo<eie>, cfv<eie> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16201G(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eie m16201G(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eie) com_fossil_cfn.b(com_fossil_cfp, eif.class);
    }

    public cfp m16202a(eie com_fossil_eie, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eie, com_fossil_eie.getClass());
    }
}
