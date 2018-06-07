package com.ua.sdk.user.stats;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.elq;
import com.fossil.elr;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class StatsAdapter implements cfo<elq>, cfv<elq> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16252V(com_fossil_cfp, type, com_fossil_cfn);
    }

    public elq m16252V(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (elq) com_fossil_cfn.b(com_fossil_cfp, elr.class);
    }

    public cfp m16253a(elq com_fossil_elq, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_elq, com_fossil_elq.getClass());
    }
}
