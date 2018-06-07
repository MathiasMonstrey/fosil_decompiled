package com.ua.sdk.activitytype;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.efo;
import com.fossil.efq;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ActivityTypeAdapter implements cfo<efo> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16141o(com_fossil_cfp, type, com_fossil_cfn);
    }

    public efo m16141o(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        efq com_fossil_efq = (efq) com_fossil_cfn.b(com_fossil_cfp, efq.class);
        if (com_fossil_efq != null) {
            return efq.a(com_fossil_efq);
        }
        return null;
    }
}
