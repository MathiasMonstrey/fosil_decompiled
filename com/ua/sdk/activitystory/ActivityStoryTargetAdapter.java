package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.efb;
import com.fossil.efc;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryTargetAdapter implements cfo<ActivityStoryTarget>, cfv<ActivityStoryTarget> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16128j(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ActivityStoryTarget m16128j(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        cfp fq = com_fossil_cfp.WA().fq("type");
        if (fq != null) {
            if ("group".equals(fq.getAsString())) {
                return (ActivityStoryTarget) com_fossil_cfn.b(com_fossil_cfp, efb.class);
            }
        }
        return (ActivityStoryTarget) com_fossil_cfn.b(com_fossil_cfp, efc.class);
    }

    public cfp m16126a(ActivityStoryTarget activityStoryTarget, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(activityStoryTarget, activityStoryTarget.getClass());
    }
}
