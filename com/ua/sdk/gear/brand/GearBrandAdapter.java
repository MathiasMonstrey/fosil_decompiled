package com.ua.sdk.gear.brand;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehg;
import com.fossil.ehh;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class GearBrandAdapter implements cfo<ehg>, cfv<ehg> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16175x(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehg m16175x(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ehg) com_fossil_cfn.b(com_fossil_cfp, ehh.class);
    }

    public cfp m16173a(ehg com_fossil_ehg, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ehg, com_fossil_ehg.getClass());
    }
}
