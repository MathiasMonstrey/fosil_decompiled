package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ecq;
import com.fossil.edc;
import com.fossil.edm;
import com.fossil.edx;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityStoryAdapter implements cfo<edc>, cfv<edc> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16113e(com_fossil_cfp, type, com_fossil_cfn);
    }

    public edc m16113e(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        try {
            edc com_fossil_edc = (edc) com_fossil_cfn.b(com_fossil_cfp, edm.class);
            edx com_fossil_edx = (edx) com_fossil_edc.aCH();
            if (com_fossil_edx == null) {
                return com_fossil_edc;
            }
            com_fossil_edx.a(com_fossil_cfp.WA());
            return com_fossil_edc;
        } catch (Throwable e) {
            ecq.d("Unable to parse ActivityStory=" + com_fossil_cfp, e);
            return new edm();
        }
    }

    public cfp m16111a(edc com_fossil_edc, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_edc, com_fossil_edc.getClass());
    }
}
