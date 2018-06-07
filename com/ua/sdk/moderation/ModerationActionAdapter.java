package com.ua.sdk.moderation;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejf;
import com.fossil.ejg;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ModerationActionAdapter implements cfo<ejf>, cfv<ejf> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16211J(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ejf m16211J(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ejf) com_fossil_cfn.b(com_fossil_cfp, ejg.class);
    }

    public cfp m16212a(ejf com_fossil_ejf, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ejf, com_fossil_ejf.getClass());
    }
}
