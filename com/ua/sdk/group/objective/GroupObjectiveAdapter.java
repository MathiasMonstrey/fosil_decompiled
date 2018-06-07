package com.ua.sdk.group.objective;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehx;
import com.fossil.ehy;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupObjectiveAdapter implements cfo<ehx>, cfv<ehx> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16191D(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehx m16191D(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehx) com_fossil_cfn.b(com_fossil_cfp, ehy.class);
    }

    public cfp m16192a(ehx com_fossil_ehx, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehx, com_fossil_ehx.getClass());
    }
}
