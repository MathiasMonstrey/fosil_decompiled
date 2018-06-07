package com.fossil;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.DateTypeAdapter.1;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class cgl extends cfw<Date> {
    public static final cfx bSa = new 1();
    private final DateFormat bQF = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat bQG = DateFormat.getDateTimeInstance(2, 2);

    public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
        return m6249j(com_fossil_cgv);
    }

    public Date m6249j(cgv com_fossil_cgv) throws IOException {
        if (com_fossil_cgv.WT() != JsonToken.NULL) {
            return ft(com_fossil_cgv.nextString());
        }
        com_fossil_cgv.nextNull();
        return null;
    }

    private synchronized Date ft(String str) {
        Date parse;
        try {
            parse = this.bQG.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.bQF.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = cgt.parse(str, new ParsePosition(0));
                } catch (Throwable e3) {
                    throw new JsonSyntaxException(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void m6247a(cgw com_fossil_cgw, Date date) throws IOException {
        if (date == null) {
            com_fossil_cgw.Xe();
        } else {
            com_fossil_cgw.fv(this.bQF.format(date));
        }
    }
}
