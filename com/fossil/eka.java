package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class eka implements eis<ecc<eju>> {
    private final cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10797s(inputStream);
    }

    public eka(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public ecc<eju> m10797s(InputStream inputStream) throws UaException {
        try {
            return ekb.m10798a((ekb) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) ekb.class));
        } catch (Throwable e) {
            throw new UaException(e);
        }
    }
}
