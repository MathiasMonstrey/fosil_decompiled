package com.ua.sdk.user.stats;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.elo;
import com.fossil.elp;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class HeartRateTimesAggregatesAdapter implements cfo<elo>, cfv<elo> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16249U(com_fossil_cfp, type, com_fossil_cfn);
    }

    public elo m16249U(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (elo) com_fossil_cfn.b(com_fossil_cfp, elp.class);
    }

    public cfp m16250a(elo com_fossil_elo, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_elo, com_fossil_elo.getClass());
    }
}
