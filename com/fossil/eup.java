package com.fossil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.message.BasicHeader;

public class eup implements HttpEntity {
    private static final char[] dVS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final Header contentType;
    private volatile boolean dIn;
    private final eum dVT;
    private long length;

    public eup(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        if (str == null) {
            str = aHS();
        }
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        this.dVT = new eum("form-data", charset, str, httpMultipartMode);
        this.contentType = new BasicHeader("Content-Type", m11247a(str, charset));
        this.dIn = true;
    }

    public eup() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    protected String m11247a(String str, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(str);
        if (charset != null) {
            stringBuilder.append("; charset=");
            stringBuilder.append(charset.name());
        }
        return stringBuilder.toString();
    }

    protected String aHS() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(dVS[random.nextInt(dVS.length)]);
        }
        return stringBuilder.toString();
    }

    public void m11249b(euk com_fossil_euk) {
        this.dVT.m11246a(com_fossil_euk);
        this.dIn = true;
    }

    public void m11248a(String str, eur com_fossil_eur) {
        m11249b(new euk(str, com_fossil_eur));
    }

    public boolean isRepeatable() {
        for (euk aHO : this.dVT.aHQ()) {
            if (aHO.aHO().getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public long getContentLength() {
        if (this.dIn) {
            this.length = this.dVT.aHR();
            this.dIn = false;
        }
        return this.length;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public Header getContentEncoding() {
        return null;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.dVT.writeTo(outputStream);
    }
}
