package com.fossil;

import com.ua.sdk.UaException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class eio<T> implements eis<T> {
    private final eis<T> dIu;

    public eio(eis<T> com_fossil_eis_T) {
        eiy.dd(com_fossil_eis_T);
        this.dIu = com_fossil_eis_T;
    }

    public T mo2803p(InputStream inputStream) throws UaException {
        Object obj = null;
        try {
            obj = elx.m10870v(inputStream);
            T p = this.dIu.mo2803p(new ByteArrayInputStream(obj.getBytes("UTF-8")));
            ecq.debug("response=%s", obj);
            return p;
        } catch (Throwable e) {
            throw new UaException(e);
        } catch (Throwable th) {
            ecq.debug("response=%s", obj);
        }
    }
}
