package com.ua.sdk.aggregate;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.efr;
import com.fossil.efs;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AggregateAdapter implements cfo<efr>, cfv<efr> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16144p(com_fossil_cfp, type, com_fossil_cfn);
    }

    public efr m16144p(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (efr) com_fossil_cfn.b(com_fossil_cfp, efs.class);
    }

    public cfp m16142a(efr com_fossil_efr, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_efr, com_fossil_efr.getClass());
    }
}
