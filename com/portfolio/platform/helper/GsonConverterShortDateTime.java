package com.portfolio.platform.helper;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class GsonConverterShortDateTime implements cfo<DateTime> {
    private static final String TAG = GsonConverterShortDateTime.class.getName();
    private static final DateTimeFormatter cyA = DateTimeFormat.forPattern("yyyy-MM-dd");

    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m15628b(com_fossil_cfp, type, com_fossil_cfn);
    }

    public DateTime m15628b(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        String asString = com_fossil_cfp.getAsString();
        if (asString.length() == 0) {
            return null;
        }
        return cyA.parseDateTime(asString);
    }
}
