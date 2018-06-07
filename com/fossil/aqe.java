package com.fossil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aqe implements aqi<byte[]> {
    public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
        byte[] bArr = (byte[]) obj;
        if (outputStream != null && bArr != null) {
            outputStream.write(bArr, 0, bArr.length);
        }
    }

    public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        aqv.m4253b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
