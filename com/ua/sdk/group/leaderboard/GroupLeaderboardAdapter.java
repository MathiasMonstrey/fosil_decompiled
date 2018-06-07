package com.ua.sdk.group.leaderboard;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehp;
import com.fossil.ehq;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupLeaderboardAdapter implements cfo<ehp>, cfv<ehp> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16185B(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehp m16185B(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehp) com_fossil_cfn.b(com_fossil_cfp, ehq.class);
    }

    public cfp m16186a(ehp com_fossil_ehp, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehp, com_fossil_ehp.getClass());
    }
}
