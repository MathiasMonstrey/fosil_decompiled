package com.ua.sdk.activitystory;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eet;
import com.google.gson.JsonParseException;
import com.ua.sdk.activitystory.Attachment.Type;

public class ActivityStoryAttachmentTypeAdapter implements cfo<Type>, cfv<Type> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, java.lang.reflect.Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16116f(com_fossil_cfp, type, com_fossil_cfn);
    }

    public Type m16116f(cfp com_fossil_cfp, java.lang.reflect.Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (Type) com_fossil_cfn.b(com_fossil_cfp, eet.class);
    }

    public cfp m16114a(Type type, java.lang.reflect.Type type2, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(type, type.getClass());
    }
}
