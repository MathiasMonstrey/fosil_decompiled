package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryVerbAdapter implements cfo<ActivityStoryVerb>, cfv<ActivityStoryVerb> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16134l(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ActivityStoryVerb m16134l(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        ActivityStoryVerb activityStoryVerb = null;
        String asString = com_fossil_cfp.getAsString();
        if (asString != null) {
            try {
                activityStoryVerb = ActivityStoryVerb.valueOf(asString.toUpperCase());
            } catch (IllegalArgumentException e) {
            }
        }
        return activityStoryVerb;
    }

    public cfp m16132a(ActivityStoryVerb activityStoryVerb, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(activityStoryVerb.toString().toLowerCase(), String.class);
    }
}
