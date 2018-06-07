package com.ua.sdk.user.stats;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.els;
import com.fossil.elt;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class UserStatsAdapter implements cfo<els>, cfv<els> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16255W(com_fossil_cfp, type, com_fossil_cfn);
    }

    public els m16255W(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (els) com_fossil_cfn.b(com_fossil_cfp, elt.class);
    }

    public cfp m16256a(els com_fossil_els, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_els, com_fossil_els.getClass());
    }
}
