package com.fossil;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.SqlDateTypeAdapter.1;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class cgp extends cfw<Date> {
    public static final cfx bSa = new 1();
    private final DateFormat bSE = new SimpleDateFormat("MMM d, yyyy");

    public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
        return m6269l(com_fossil_cgv);
    }

    public synchronized Date m6269l(cgv com_fossil_cgv) throws IOException {
        Date date;
        if (com_fossil_cgv.WT() == JsonToken.NULL) {
            com_fossil_cgv.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.bSE.parse(com_fossil_cgv.nextString()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    public synchronized void m6267a(cgw com_fossil_cgw, Date date) throws IOException {
        com_fossil_cgw.fv(date == null ? null : this.bSE.format(date));
    }
}
