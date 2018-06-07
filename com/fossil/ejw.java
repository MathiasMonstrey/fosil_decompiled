package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class ejw implements eis<eju> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10788r(inputStream);
    }

    public ejw(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public eju m10788r(InputStream inputStream) throws UaException {
        return eke.m10802a((eke) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) eke.class));
    }
}
