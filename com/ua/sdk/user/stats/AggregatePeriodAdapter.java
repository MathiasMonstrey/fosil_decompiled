package com.ua.sdk.user.stats;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.elm;
import com.fossil.eln;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AggregatePeriodAdapter implements cfo<elm>, cfv<elm> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16246T(com_fossil_cfp, type, com_fossil_cfn);
    }

    public elm m16246T(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (elm) com_fossil_cfn.b(com_fossil_cfp, eln.class);
    }

    public cfp m16247a(elm com_fossil_elm, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_elm, com_fossil_elm.getClass());
    }
}
