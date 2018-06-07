package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class elg implements eis<eld> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10863u(inputStream);
    }

    public elg(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public elf m10863u(InputStream inputStream) throws UaException {
        try {
            return ell.m10868a((ell) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) ell.class));
        } catch (Throwable e) {
            throw new UaException(e);
        }
    }
}
