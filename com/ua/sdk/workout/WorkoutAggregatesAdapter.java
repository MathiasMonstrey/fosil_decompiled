package com.ua.sdk.workout;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.emc;
import com.fossil.emd;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class WorkoutAggregatesAdapter implements cfo<emc>, cfv<emc> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16261Y(com_fossil_cfp, type, com_fossil_cfn);
    }

    public emc m16261Y(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (emc) com_fossil_cfn.b(com_fossil_cfp, emd.class);
    }

    public cfp m16262a(emc com_fossil_emc, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_emc, com_fossil_emc.getClass());
    }
}
