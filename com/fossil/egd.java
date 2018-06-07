package com.fossil;

import com.google.gson.JsonSyntaxException;
import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class egd implements eis<egb> {
    private cfj gson;

    public /* synthetic */ Object mo2803p(InputStream inputStream) throws UaException {
        return m10652q(inputStream);
    }

    public egd(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public egb m10652q(InputStream inputStream) throws UaException {
        try {
            return ege.m10653a((ege) this.gson.m6195a(new cgv(new InputStreamReader(inputStream)), (Type) ege.class));
        } catch (JsonSyntaxException e) {
            throw new UaException("Parse error");
        } catch (Throwable e2) {
            throw new UaException("Parse error", e2);
        }
    }
}
