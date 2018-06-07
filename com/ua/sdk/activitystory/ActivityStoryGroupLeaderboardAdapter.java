package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.edh;
import com.fossil.edi;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryGroupLeaderboardAdapter implements cfo<edh>, cfv<edh> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16119g(com_fossil_cfp, type, com_fossil_cfn);
    }

    public edh m16119g(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (edh) com_fossil_cfn.b(com_fossil_cfp, edi.class);
    }

    public cfp m16117a(edh com_fossil_edh, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_edh, com_fossil_edh.getClass());
    }
}
