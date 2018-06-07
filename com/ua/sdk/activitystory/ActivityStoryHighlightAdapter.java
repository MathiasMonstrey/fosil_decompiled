package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.edl;
import com.fossil.eet;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryHighlightAdapter implements cfo<edl>, cfv<edl> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16122h(com_fossil_cfp, type, com_fossil_cfn);
    }

    public edl m16122h(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (edl) com_fossil_cfn.b(com_fossil_cfp, eet.class);
    }

    public cfp m16120a(edl com_fossil_edl, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_edl, com_fossil_edl.getClass());
    }
}
