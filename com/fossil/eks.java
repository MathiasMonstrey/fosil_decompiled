package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class eks implements eis<ekn> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10830t(inputStream);
    }

    public eks(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public ekr m10830t(InputStream inputStream) throws UaException {
        try {
            return elc.m10853a((elc) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) elc.class));
        } catch (Throwable e) {
            throw new UaException(e);
        }
    }
}
