package com.ua.sdk.datasourceidentifier;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.egy;
import com.fossil.egz;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class DataSourceIdentifierAdapter implements cfo<egy>, cfv<egy> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16163t(com_fossil_cfp, type, com_fossil_cfn);
    }

    public egy m16163t(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (egy) com_fossil_cfn.b(com_fossil_cfp, egz.class);
    }

    public cfp m16161a(egy com_fossil_egy, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_egy, com_fossil_egy.getClass());
    }
}
