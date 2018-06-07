package com.ua.sdk.workout;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.emb;
import com.fossil.eme;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class WorkoutAdapter implements cfo<emb>, cfv<emb> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16258X(com_fossil_cfp, type, com_fossil_cfn);
    }

    public emb m16258X(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (emb) com_fossil_cfn.b(com_fossil_cfp, eme.class);
    }

    public cfp m16259a(emb com_fossil_emb, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_emb, com_fossil_emb.getClass());
    }
}
