package com.ua.sdk.device;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eha;
import com.fossil.ehb;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class DeviceAdapter implements cfo<eha>, cfv<eha> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16166u(com_fossil_cfp, type, com_fossil_cfn);
    }

    public eha m16166u(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (eha) com_fossil_cfn.b(com_fossil_cfp, ehb.class);
    }

    public cfp m16164a(eha com_fossil_eha, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(com_fossil_eha, com_fossil_eha.getClass());
    }
}
