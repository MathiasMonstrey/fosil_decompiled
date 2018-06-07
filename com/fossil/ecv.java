package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class ecv implements eis<ect> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10496o(inputStream);
    }

    public ecv(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public ect m10496o(InputStream inputStream) throws UaException {
        return edb.m10545a((edb) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) edb.class));
    }
}
