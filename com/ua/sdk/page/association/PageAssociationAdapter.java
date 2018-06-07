package com.ua.sdk.page.association;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eji;
import com.fossil.ejk;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class PageAssociationAdapter implements cfo<eji>, cfv<eji> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16222L(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eji m16222L(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return ejk.a((ejk) com_fossil_cfn.b(com_fossil_cfp, ejk.class));
    }

    public cfp m16223a(eji com_fossil_eji, Type type, cfu com_fossil_cfu) {
        ejk a = ejk.a(com_fossil_eji);
        return com_fossil_cfu.c(a, a.getClass());
    }
}
