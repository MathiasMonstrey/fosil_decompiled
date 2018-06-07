package com.google.gson;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.cgt;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DefaultDateTypeAdapter implements cfo<Date>, cfv<Date> {
    private final DateFormat bQF;
    private final DateFormat bQG;

    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m14568a(com_fossil_cfp, type, com_fossil_cfn);
    }

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public DefaultDateTypeAdapter(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bQF = dateFormat;
        this.bQG = dateFormat2;
    }

    public cfp m14567a(Date date, Type type, cfu com_fossil_cfu) {
        cfp com_fossil_cft;
        synchronized (this.bQG) {
            com_fossil_cft = new cft(this.bQF.format(date));
        }
        return com_fossil_cft;
    }

    public Date m14568a(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        if (com_fossil_cfp instanceof cft) {
            Date a = m14565a(com_fossil_cfp);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new JsonParseException("The date should be a string value");
    }

    private Date m14565a(cfp com_fossil_cfp) {
        Date parse;
        synchronized (this.bQG) {
            try {
                parse = this.bQG.parse(com_fossil_cfp.getAsString());
            } catch (ParseException e) {
                try {
                    parse = this.bQF.parse(com_fossil_cfp.getAsString());
                } catch (ParseException e2) {
                    try {
                        parse = cgt.parse(com_fossil_cfp.getAsString(), new ParsePosition(0));
                    } catch (Throwable e3) {
                        throw new JsonSyntaxException(com_fossil_cfp.getAsString(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DefaultDateTypeAdapter.class.getSimpleName());
        stringBuilder.append('(').append(this.bQG.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
