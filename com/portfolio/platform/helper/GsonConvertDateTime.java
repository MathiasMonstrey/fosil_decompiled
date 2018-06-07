package com.portfolio.platform.helper;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class GsonConvertDateTime implements cfo<DateTime>, cfv<DateTime> {
    private static final DateTimeFormatter cyA = ISODateTimeFormat.dateTime();

    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m15627b(com_fossil_cfp, type, com_fossil_cfn);
    }

    public DateTime m15627b(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        String asString = com_fossil_cfp.getAsString();
        if (asString.length() == 0) {
            return null;
        }
        return cyA.parseDateTime(asString);
    }

    public cfp m15626a(DateTime dateTime, Type type, cfu com_fossil_cfu) {
        String str;
        if (dateTime == null) {
            str = "";
        } else {
            str = cyA.print(dateTime);
        }
        return new cft(str);
    }
}
