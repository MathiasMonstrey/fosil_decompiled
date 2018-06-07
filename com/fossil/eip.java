package com.fossil;

import com.ua.sdk.UaException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class eip<T> implements eit<T> {
    private final eit<T> dIv;

    public eip(eit<T> com_fossil_eit_T) {
        eiy.dd(com_fossil_eit_T);
        this.dIv = com_fossil_eit_T;
    }

    public void mo2806b(T t, OutputStream outputStream) throws UaException {
        CharSequence str;
        Throwable e;
        Object obj = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.dIv.mo2806b(t, byteArrayOutputStream);
            str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            try {
                elx.m10869a(str, outputStream);
                ecq.debug("request=%s", str);
            } catch (IOException e2) {
                e = e2;
                try {
                    throw new UaException(e);
                } catch (Throwable th) {
                    e = th;
                    obj = str;
                    ecq.debug("request=%s", obj);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            str = null;
            throw new UaException(e);
        } catch (Throwable th2) {
            e = th2;
            ecq.debug("request=%s", obj);
            throw e;
        }
    }
}
