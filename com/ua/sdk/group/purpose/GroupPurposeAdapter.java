package com.ua.sdk.group.purpose;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehz;
import com.fossil.eia;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupPurposeAdapter implements cfo<ehz>, cfv<ehz> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16195E(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehz m16195E(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehz) com_fossil_cfn.b(com_fossil_cfp, eia.class);
    }

    public cfp m16196a(ehz com_fossil_ehz, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehz, com_fossil_ehz.getClass());
    }
}
