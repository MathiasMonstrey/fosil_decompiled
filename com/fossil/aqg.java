package com.fossil;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class aqg<ObjectType> extends aqf<ObjectType> {
    public aqg(aqi<ObjectType> com_fossil_aqi_ObjectType) {
        super(com_fossil_aqi_ObjectType);
    }

    public final void mo1105a(OutputStream outputStream, ObjectType objectType) throws IOException {
        Throwable th;
        if (outputStream != null) {
            Closeable gZIPOutputStream;
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    super.mo1105a(gZIPOutputStream, objectType);
                    aqv.m4252a(gZIPOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    aqv.m4252a(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                aqv.m4252a(gZIPOutputStream);
                throw th;
            }
        }
    }

    public final ObjectType mo1106j(InputStream inputStream) throws IOException {
        Throwable th;
        ObjectType objectType = null;
        if (inputStream != null) {
            Closeable gZIPInputStream;
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
                try {
                    objectType = super.mo1106j(gZIPInputStream);
                    aqv.m4252a(gZIPInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    aqv.m4252a(gZIPInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                gZIPInputStream = null;
                th = th4;
                aqv.m4252a(gZIPInputStream);
                throw th;
            }
        }
        return objectType;
    }
}
