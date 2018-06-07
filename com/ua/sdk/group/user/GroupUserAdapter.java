package com.ua.sdk.group.user;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eib;
import com.fossil.eic;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GroupUserAdapter implements cfo<eib>, cfv<eib> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16198F(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eib m16198F(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eib) com_fossil_cfn.b(com_fossil_cfp, eic.class);
    }

    public cfp m16199a(eib com_fossil_eib, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eib, com_fossil_eib.getClass());
    }
}
