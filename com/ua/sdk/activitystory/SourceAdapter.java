package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eco;
import com.fossil.eef;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class SourceAdapter implements cfo<eco>, cfv<eco> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16140n(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eco m16140n(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eco) com_fossil_cfn.b(com_fossil_cfp, eef.class);
    }

    public cfp m16138a(eco com_fossil_eco, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eco, com_fossil_eco.getClass());
    }
}
