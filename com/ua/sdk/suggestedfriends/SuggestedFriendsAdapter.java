package com.ua.sdk.suggestedfriends;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eki;
import com.fossil.ekj;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class SuggestedFriendsAdapter implements cfo<eki>, cfv<eki> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16240R(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eki m16240R(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eki) com_fossil_cfn.b(com_fossil_cfp, ekj.class);
    }

    public cfp m16241a(eki com_fossil_eki, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eki, com_fossil_eki.getClass());
    }
}
