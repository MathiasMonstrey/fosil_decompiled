package com.ua.sdk.privacy;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejl;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class PrivacyAdapter implements cfo<Privacy>, cfv<Privacy> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16225M(com_fossil_cfp, type, com_fossil_cfn);
    }

    public Privacy m16225M(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        if (com_fossil_cfp.Wy()) {
            return ejl.oz(com_fossil_cfp.WC().Wv().intValue());
        }
        return null;
    }

    public cfp m16226a(Privacy privacy, Type type, cfu com_fossil_cfu) {
        return new cft(Integer.valueOf(privacy.aEa().id));
    }
}
