package com.ua.sdk.aggregate;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eft;
import com.fossil.efu;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AggregateSummaryAdapter implements cfo<eft>, cfv<eft> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16147q(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eft m16147q(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eft) com_fossil_cfn.b(com_fossil_cfp, efu.class);
    }

    public cfp m16145a(eft com_fossil_eft, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eft, com_fossil_eft.getClass());
    }
}
