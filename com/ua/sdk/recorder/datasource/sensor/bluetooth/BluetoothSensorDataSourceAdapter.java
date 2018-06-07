package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejn;
import com.fossil.ejs;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class BluetoothSensorDataSourceAdapter implements cfo<ejn>, cfv<ejn> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16231O(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ejn m16231O(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ejn) com_fossil_cfn.b(com_fossil_cfp, ejs.class);
    }

    public cfp m16232a(ejn com_fossil_ejn, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_ejn, com_fossil_ejn.getClass());
    }
}
