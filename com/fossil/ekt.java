package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ekt implements eit<ekn> {
    private cfj gson;

    public /* synthetic */ void mo2806b(Object obj, OutputStream outputStream) throws UaException {
        m10831a((ekn) obj, outputStream);
    }

    public ekt(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public void m10831a(ekn com_fossil_ekn, OutputStream outputStream) throws UaException {
        Object f = elc.m10854f(com_fossil_ekn);
        Appendable outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.m6200a(f, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException e) {
            throw new UaException(Code.CANCELED);
        } catch (Throwable e2) {
            ecq.error("Unable to flush UserJsonWriter during write.");
            throw new UaException(e2);
        }
    }
}
