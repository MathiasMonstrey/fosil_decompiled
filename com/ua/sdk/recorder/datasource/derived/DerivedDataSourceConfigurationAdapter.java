package com.ua.sdk.recorder.datasource.derived;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejo;
import com.fossil.ejr;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class DerivedDataSourceConfigurationAdapter implements cfo<ejo>, cfv<ejo> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16228N(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ejo m16228N(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ejo) com_fossil_cfn.b(com_fossil_cfp, ejr.class);
    }

    public cfp m16229a(ejo com_fossil_ejo, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ejo, com_fossil_ejo.getClass());
    }
}
