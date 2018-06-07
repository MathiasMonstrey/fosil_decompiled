package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.edw;
import com.fossil.edx;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryTemplateAdapter implements cfo<edw>, cfv<edw> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16131k(com_fossil_cfp, type, com_fossil_cfn);
    }

    public edw m16131k(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (edw) com_fossil_cfn.b(com_fossil_cfp, edx.class);
    }

    public cfp m16129a(edw com_fossil_edw, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_edw, com_fossil_edw.getClass());
    }
}
