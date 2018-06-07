package com.portfolio.platform.helper;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GsonConvertDate implements cfo<Date>, cfv<Date> {
    private static final SimpleDateFormat cyz = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m15624a(com_fossil_cfp, type, com_fossil_cfn);
    }

    public Date m15624a(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) {
        String asString = com_fossil_cfp.getAsString();
        if (!asString.isEmpty()) {
            try {
                return cyz.parse(asString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public cfp m15623a(Date date, Type type, cfu com_fossil_cfu) {
        String str;
        if (date == null) {
            str = "";
        } else {
            str = cyz.format(date);
        }
        return new cft(str);
    }
}
