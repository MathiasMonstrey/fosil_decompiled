package com.ua.sdk.group.invite;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehn;
import com.fossil.eho;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupInviteAdapter implements cfo<ehn>, cfv<ehn> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16182A(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehn m16182A(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehn) com_fossil_cfn.b(com_fossil_cfp, eho.class);
    }

    public cfp m16183a(ehn com_fossil_ehn, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehn, com_fossil_ehn.getClass());
    }
}
