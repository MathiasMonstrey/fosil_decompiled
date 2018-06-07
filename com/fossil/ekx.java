package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class ekx implements eis<ecc<ekn>> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10843s(inputStream);
    }

    public ekx(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public ecc<ekn> m10843s(InputStream inputStream) throws UaException {
        try {
            return eky.m10844a((eky) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) eky.class));
        } catch (Throwable e) {
            throw new UaException(e);
        }
    }
}
