package com.fossil;

import com.fossil.chf.C2066b;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class chc implements chb {
    private static final Logger logger = Logger.getLogger(chc.class.getName());
    private final Map<String, C2066b> bUv;
    private final Map<Integer, C2066b> bUw;
    private final String bUx;
    private final cgz bUy;

    public chc(String str, cgz com_fossil_cgz) {
        this.bUv = Collections.synchronizedMap(new HashMap());
        this.bUw = Collections.synchronizedMap(new HashMap());
        this.bUx = str;
        this.bUy = com_fossil_cgz;
    }

    public chc(cgz com_fossil_cgz) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", com_fossil_cgz);
    }

    public C2066b fA(String str) {
        synchronized (this.bUv) {
            if (!this.bUv.containsKey(str)) {
                m6403y(str, 0);
            }
        }
        return (C2066b) this.bUv.get(str);
    }

    public C2066b iV(int i) {
        synchronized (this.bUw) {
            if (!this.bUw.containsKey(Integer.valueOf(i))) {
                List list = (List) cgy.Xw().get(Integer.valueOf(i));
                if (list.size() == 1 && "001".equals(list.get(0))) {
                    m6403y("001", i);
                }
            }
        }
        return (C2066b) this.bUw.get(Integer.valueOf(i));
    }

    void m6403y(String str, int i) {
        Object valueOf;
        String str2;
        boolean equals = "001".equals(str);
        String valueOf2 = String.valueOf(String.valueOf(this.bUx));
        if (equals) {
            valueOf = String.valueOf(i);
        } else {
            str2 = str;
        }
        str2 = String.valueOf(String.valueOf(valueOf));
        valueOf2 = new StringBuilder((valueOf2.length() + 1) + str2.length()).append(valueOf2).append("_").append(str2).toString();
        InputStream fz = this.bUy.fz(valueOf2);
        String str3;
        if (fz == null) {
            Logger logger = logger;
            Level level = Level.SEVERE;
            String str4 = "missing metadata: ";
            str2 = String.valueOf(valueOf2);
            logger.log(level, str2.length() != 0 ? str4.concat(str2) : new String(str4));
            str3 = "missing metadata: ";
            str2 = String.valueOf(valueOf2);
            if (str2.length() != 0) {
                str2 = str3.concat(str2);
            } else {
                str2 = new String(str3);
            }
            throw new IllegalStateException(str2);
        }
        try {
            C2066b[] c2066bArr = m6402a(new ObjectInputStream(fz)).bWa;
            if (c2066bArr.length == 0) {
                logger = logger;
                level = Level.SEVERE;
                str4 = "empty metadata: ";
                str2 = String.valueOf(valueOf2);
                logger.log(level, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                str3 = "empty metadata: ";
                str2 = String.valueOf(valueOf2);
                if (str2.length() != 0) {
                    str2 = str3.concat(str2);
                } else {
                    str2 = new String(str3);
                }
                throw new IllegalStateException(str2);
            }
            if (c2066bArr.length > 1) {
                Logger logger2 = logger;
                Level level2 = Level.WARNING;
                String str5 = "invalid metadata (too many entries): ";
                str2 = String.valueOf(valueOf2);
                logger2.log(level2, str2.length() != 0 ? str5.concat(str2) : new String(str5));
            }
            valueOf = c2066bArr[0];
            if (equals) {
                this.bUw.put(Integer.valueOf(i), valueOf);
            } else {
                this.bUv.put(str, valueOf);
            }
        } catch (Throwable e) {
            Throwable th = e;
            Logger logger3 = logger;
            Level level3 = Level.SEVERE;
            String str6 = "cannot load/parse metadata: ";
            str2 = String.valueOf(valueOf2);
            logger3.log(level3, str2.length() != 0 ? str6.concat(str2) : new String(str6), th);
            str4 = "cannot load/parse metadata: ";
            str2 = String.valueOf(valueOf2);
            if (str2.length() != 0) {
                str2 = str4.concat(str2);
            } else {
                str2 = new String(str4);
            }
            throw new RuntimeException(str2, th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.fossil.chf.C2067c m6402a(java.io.ObjectInputStream r5) {
        /*
        r1 = new com.fossil.chf$c;
        r1.<init>();
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r0 = com.fossil.cha.m6401a(r5, r0);	 Catch:{ IOException -> 0x001d }
        r1.m6412d(r0);	 Catch:{ IOException -> 0x001d }
        r5.close();	 Catch:{ IOException -> 0x0012 }
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = move-exception;
        r2 = logger;
        r3 = java.util.logging.Level.WARNING;
        r4 = "error closing input stream (ignored)";
        r2.log(r3, r4, r0);
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        r2 = logger;	 Catch:{ all -> 0x0036 }
        r3 = java.util.logging.Level.WARNING;	 Catch:{ all -> 0x0036 }
        r4 = "error reading input (ignored)";
        r2.log(r3, r4, r0);	 Catch:{ all -> 0x0036 }
        r5.close();	 Catch:{ IOException -> 0x002b }
        goto L_0x0011;
    L_0x002b:
        r0 = move-exception;
        r2 = logger;
        r3 = java.util.logging.Level.WARNING;
        r4 = "error closing input stream (ignored)";
        r2.log(r3, r4, r0);
        goto L_0x0011;
    L_0x0036:
        r0 = move-exception;
        r5.close();	 Catch:{ IOException -> 0x003b }
    L_0x003a:
        throw r0;
    L_0x003b:
        r1 = move-exception;
        r2 = logger;
        r3 = java.util.logging.Level.WARNING;
        r4 = "error closing input stream (ignored)";
        r2.log(r3, r4, r1);
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.chc.a(java.io.ObjectInputStream):com.fossil.chf$c");
    }
}
