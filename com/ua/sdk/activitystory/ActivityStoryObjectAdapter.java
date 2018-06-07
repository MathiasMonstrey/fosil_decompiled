package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfr;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eeo;
import com.fossil.eep;
import com.fossil.eeq;
import com.fossil.eer;
import com.fossil.ees;
import com.fossil.eeu;
import com.fossil.eev;
import com.fossil.eew;
import com.fossil.eex;
import com.fossil.eey;
import com.fossil.eez;
import com.fossil.efa;
import com.google.gson.JsonParseException;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.ua.sdk.activitystory.ActivityStoryToutObject.Subtype;
import java.lang.reflect.Type;

public class ActivityStoryObjectAdapter implements cfo<ActivityStoryObject>, cfv<ActivityStoryObject> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16125i(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ActivityStoryObject m16125i(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        Subtype subtype = null;
        cfr WA = com_fossil_cfp.WA();
        cfp fq = WA.fq("type");
        if (fq == null) {
            return null;
        }
        Type type2;
        String asString = fq.getAsString();
        if ("workout".equals(asString)) {
            type2 = efa.class;
        } else if ("user".equals(asString)) {
            type2 = eez.class;
        } else if ("status".equals(asString)) {
            type2 = eex.class;
        } else if ("repost".equals(asString)) {
            type2 = eev.class;
        } else if ("group".equals(asString)) {
            type2 = ees.class;
        } else if ("group_leaderboard".equals(asString)) {
            type2 = eer.class;
        } else if ("route".equals(asString)) {
            type2 = eew.class;
        } else if ("actigraphy".equals(asString)) {
            type2 = eeo.class;
        } else if ("comment".equals(asString)) {
            type2 = eeq.class;
        } else if ("ad".equals(asString)) {
            return new eep();
        } else {
            if (MicroApp.COLUMN_LIKE.equals(asString)) {
                return new eeu();
            }
            if ("tout".equals(asString)) {
                cfp fq2 = WA.fq("subtype");
                if (fq2 != null) {
                    if ("find_friends".equals(fq2.getAsString())) {
                        subtype = Subtype.FIND_FRIENDS;
                    }
                }
                return new eey(subtype);
            }
            type2 = null;
        }
        if (type2 != null) {
            return (ActivityStoryObject) com_fossil_cfn.b(com_fossil_cfp, type2);
        }
        return null;
    }

    public cfp m16123a(ActivityStoryObject activityStoryObject, Type type, cfu com_fossil_cfu) {
        cfp WA = com_fossil_cfu.c(activityStoryObject, activityStoryObject.getClass()).WA();
        WA.ak("type", activityStoryObject.aCJ().toString().toLowerCase());
        if (activityStoryObject.aCJ() == ActivityStoryObject.Type.TOUT) {
            Subtype aCK = ((ActivityStoryToutObject) activityStoryObject).aCK();
            if (aCK != null) {
                switch (aCK) {
                    case FIND_FRIENDS:
                        WA.ak("subtype", "find_friends");
                        break;
                }
            }
        }
        return WA;
    }
}
