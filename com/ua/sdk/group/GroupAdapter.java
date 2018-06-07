package com.ua.sdk.group;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehl;
import com.fossil.ehm;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupAdapter implements cfo<ehl>, cfv<ehl> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16181z(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehl m16181z(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehl) com_fossil_cfn.b(com_fossil_cfp, ehm.class);
    }

    public cfp m16179a(ehl com_fossil_ehl, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehl, com_fossil_ehl.getClass());
    }
}
