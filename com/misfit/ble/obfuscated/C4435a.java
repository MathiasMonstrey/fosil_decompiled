package com.misfit.ble.obfuscated;

import java.util.HashMap;

public class C4435a {
    private C4434a f1524a;
    private HashMap<String, String> f1525b = new HashMap();

    public enum C4434a {
        EXCEPTION,
        WRITE_BINARY_FILE_FAIL,
        WRITE_TEXT_FILE_FAIL,
        READ_BINARY_FILE_FAIL,
        READ_TEXT_FILE_FAIL,
        LOG_SESSION_TO_JSON_EXCEPTION
    }

    public C4435a(C4434a c4434a) {
        this.f1524a = c4434a;
    }

    public C4435a m14672a(String str, String str2) {
        this.f1525b.put(str, str2);
        return this;
    }

    public C4434a m14671a() {
        return this.f1524a;
    }

    public HashMap<String, String> m14673b() {
        return this.f1525b;
    }
}
