package com.fossil;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TimeTypeAdapter.1;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class cgq extends cfw<Time> {
    public static final cfx bSa = new 1();
    private final DateFormat bSE = new SimpleDateFormat("hh:mm:ss a");

    public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
        return m6273m(com_fossil_cgv);
    }

    public synchronized Time m6273m(cgv com_fossil_cgv) throws IOException {
        Time time;
        if (com_fossil_cgv.WT() == JsonToken.NULL) {
            com_fossil_cgv.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.bSE.parse(com_fossil_cgv.nextString()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    public synchronized void m6271a(cgw com_fossil_cgw, Time time) throws IOException {
        com_fossil_cgw.fv(time == null ? null : this.bSE.format(time));
    }
}
