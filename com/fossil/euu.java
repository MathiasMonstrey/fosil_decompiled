package com.fossil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class euu extends euq {
    private final Charset azA;
    private final byte[] content;

    public euu(String str, String str2, Charset charset) throws UnsupportedEncodingException {
        super(str2);
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        if (charset == null) {
            charset = Charset.forName("US-ASCII");
        }
        this.content = str.getBytes(charset.name());
        this.azA = charset;
    }

    public euu(String str) throws UnsupportedEncodingException {
        this(str, "text/plain", null);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public String getTransferEncoding() {
        return "8bit";
    }

    public String aHU() {
        return this.azA.name();
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String aHT() {
        return null;
    }
}
