package com.ua.sdk.recorder.datasource.sensor.location;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejp;
import com.fossil.ejt;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class LocationSensorDataSourceAdapter implements cfo<ejp>, cfv<ejp> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16234P(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ejp m16234P(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ejp) com_fossil_cfn.b(com_fossil_cfp, ejt.class);
    }

    public cfp m16235a(ejp com_fossil_ejp, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ejp, com_fossil_ejp.getClass());
    }
}
