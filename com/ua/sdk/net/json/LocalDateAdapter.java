package com.ua.sdk.net.json;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ech;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class LocalDateAdapter implements cfo<ech>, cfv<ech> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16219K(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ech m16219K(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return ech.lm(com_fossil_cfp.getAsString());
    }

    public cfp m16220a(ech com_fossil_ech, Type type, cfu com_fossil_cfu) {
        return new cft(com_fossil_ech.toString());
    }
}
