package com.ua.sdk.bodymass;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.egf;
import com.fossil.egg;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class BodyMassAdapter implements cfo<egf>, cfv<egf> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16155s(com_fossil_cfp, type, com_fossil_cfn);
    }

    public egf m16155s(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (egf) com_fossil_cfn.b(com_fossil_cfp, egg.class);
    }

    public cfp m16153a(egf com_fossil_egf, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_egf, com_fossil_egf.getClass());
    }
}
