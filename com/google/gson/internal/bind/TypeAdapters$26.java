package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class TypeAdapters$26 implements cfx {
    public <T> cfw<T> m14634a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        if (com_fossil_cgu_T.getRawType() != Timestamp.class) {
            return null;
        }
        final cfw aa = com_fossil_cfj.aa(Date.class);
        return new cfw<Timestamp>(this) {
            final /* synthetic */ TypeAdapters$26 bTQ;

            public /* synthetic */ Object m14633b(cgv com_fossil_cgv) throws IOException {
                return m14630B(com_fossil_cgv);
            }

            public Timestamp m14630B(cgv com_fossil_cgv) throws IOException {
                Date date = (Date) aa.b(com_fossil_cgv);
                return date != null ? new Timestamp(date.getTime()) : null;
            }

            public void m14632a(cgw com_fossil_cgw, Timestamp timestamp) throws IOException {
                aa.a(com_fossil_cgw, timestamp);
            }
        };
    }
}
