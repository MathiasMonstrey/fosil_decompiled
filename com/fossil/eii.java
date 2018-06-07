package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public abstract class eii<T> implements eit<T> {
    private cfj dHY;

    protected abstract void mo2807a(T t, cfj com_fossil_cfj, OutputStreamWriter outputStreamWriter) throws UaException;

    public eii(cfj com_fossil_cfj) {
        eiy.dd(com_fossil_cfj);
        this.dHY = com_fossil_cfj;
    }

    public final void mo2806b(T t, OutputStream outputStream) throws UaException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            mo2807a(t, this.dHY, outputStreamWriter);
            try {
                outputStreamWriter.flush();
            } catch (InterruptedIOException e) {
                throw new UaException(Code.CANCELED);
            } catch (Throwable e2) {
                ecq.m10489d("Unable to flush json writer during write.", e2);
                throw new UaException(e2);
            }
        } catch (Throwable e22) {
            ecq.m10489d("Unable to write json.", e22);
            throw new UaException(e22);
        }
    }
}
