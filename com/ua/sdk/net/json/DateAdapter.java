package com.ua.sdk.net.json;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ebx;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Date;

public class DateAdapter implements cfo<Date>, cfv<Date> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16216a(com_fossil_cfp, type, com_fossil_cfn);
    }

    public cfp m16215a(Date date, Type type, cfu com_fossil_cfu) {
        return new cft(ebx.c(date, true));
    }

    public Date m16216a(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return ebx.parse(com_fossil_cfp.getAsString());
    }
}
