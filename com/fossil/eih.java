package com.fossil;

import com.ua.sdk.UaException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class eih<T> implements eis<T> {
    protected cfj dHY;

    protected abstract T mo2834b(cfj com_fossil_cfj, cgv com_fossil_cgv) throws UaException;

    public eih(cfj com_fossil_cfj) {
        eiy.dd(com_fossil_cfj);
        this.dHY = com_fossil_cfj;
    }

    public T mo2803p(InputStream inputStream) throws UaException {
        try {
            return mo2834b(this.dHY, new cgv(new InputStreamReader(inputStream)));
        } catch (Throwable e) {
            throw new UaException(e);
        }
    }
}
