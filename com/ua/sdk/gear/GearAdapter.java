package com.ua.sdk.gear;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehe;
import com.fossil.ehf;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GearAdapter implements cfo<ehe>, cfv<ehe> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16172w(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehe m16172w(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehe) com_fossil_cfn.b(com_fossil_cfp, ehf.class);
    }

    public cfp m16170a(ehe com_fossil_ehe, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehe, com_fossil_ehe.getClass());
    }
}
