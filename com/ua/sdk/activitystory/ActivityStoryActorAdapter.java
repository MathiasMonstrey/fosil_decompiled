package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eei;
import com.fossil.eej;
import com.fossil.eek;
import com.fossil.eel;
import com.fossil.eem;
import com.fossil.een;
import com.google.gson.JsonParseException;
import com.misfit.frameworks.common.constants.Constants;
import java.lang.reflect.Type;

public class ActivityStoryActorAdapter implements cfo<ActivityStoryActor>, cfv<ActivityStoryActor> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16110d(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ActivityStoryActor m16110d(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        cfp fq = com_fossil_cfp.WA().fq("type");
        if (fq != null) {
            String asString = fq.getAsString();
            if ("user".equals(asString)) {
                return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, een.class);
            }
            if (Constants.PROFILE_KEY_BRAND.equals(asString)) {
                return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, eei.class);
            }
            if ("site".equals(asString)) {
                return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, eel.class);
            }
            if ("page".equals(asString)) {
                return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, eek.class);
            }
            if ("group".equals(asString)) {
                return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, eej.class);
            }
        }
        return (ActivityStoryActor) com_fossil_cfn.b(com_fossil_cfp, eem.class);
    }

    public cfp m16108a(ActivityStoryActor activityStoryActor, Type type, cfu com_fossil_cfu) {
        cfp c = com_fossil_cfu.c(activityStoryActor, activityStoryActor.getClass());
        c.WA().ak("type", activityStoryActor.aCI().toString().toLowerCase());
        return c;
    }
}
