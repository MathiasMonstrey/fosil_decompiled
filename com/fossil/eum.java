package com.fossil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.util.ByteArrayBuffer;

public class eum {
    private static final ByteArrayBuffer dVJ = m11239a(eun.dVR, ": ");
    private static final ByteArrayBuffer dVK = m11239a(eun.dVR, "\r\n");
    private static final ByteArrayBuffer dVL = m11239a(eun.dVR, "--");
    private final Charset azA;
    private final String boundary;
    private final String dVM;
    private final List<euk> dVN;
    private final HttpMultipartMode dVO;

    static /* synthetic */ class C35491 {
        static final /* synthetic */ int[] dVP = new int[HttpMultipartMode.values().length];

        static {
            try {
                dVP[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dVP[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static ByteArrayBuffer m11239a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void m11245a(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void m11243a(String str, Charset charset, OutputStream outputStream) throws IOException {
        m11245a(m11239a(charset, str), outputStream);
    }

    private static void m11242a(String str, OutputStream outputStream) throws IOException {
        m11245a(m11239a(eun.dVR, str), outputStream);
    }

    private static void m11240a(euo com_fossil_euo, OutputStream outputStream) throws IOException {
        m11242a(com_fossil_euo.getName(), outputStream);
        m11245a(dVJ, outputStream);
        m11242a(com_fossil_euo.getBody(), outputStream);
        m11245a(dVK, outputStream);
    }

    private static void m11241a(euo com_fossil_euo, Charset charset, OutputStream outputStream) throws IOException {
        m11243a(com_fossil_euo.getName(), charset, outputStream);
        m11245a(dVJ, outputStream);
        m11243a(com_fossil_euo.getBody(), charset, outputStream);
        m11245a(dVK, outputStream);
    }

    public eum(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else {
            this.dVM = str;
            if (charset == null) {
                charset = eun.dVR;
            }
            this.azA = charset;
            this.boundary = str2;
            this.dVN = new ArrayList();
            this.dVO = httpMultipartMode;
        }
    }

    public List<euk> aHQ() {
        return this.dVN;
    }

    public void m11246a(euk com_fossil_euk) {
        if (com_fossil_euk != null) {
            this.dVN.add(com_fossil_euk);
        }
    }

    public String getBoundary() {
        return this.boundary;
    }

    private void m11244a(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) throws IOException {
        ByteArrayBuffer a = m11239a(this.azA, getBoundary());
        for (euk com_fossil_euk : this.dVN) {
            m11245a(dVL, outputStream);
            m11245a(a, outputStream);
            m11245a(dVK, outputStream);
            eul aHP = com_fossil_euk.aHP();
            switch (C35491.dVP[httpMultipartMode.ordinal()]) {
                case 1:
                    Iterator it = aHP.iterator();
                    while (it.hasNext()) {
                        m11240a((euo) it.next(), outputStream);
                    }
                    break;
                case 2:
                    m11241a(com_fossil_euk.aHP().mQ("Content-Disposition"), this.azA, outputStream);
                    if (com_fossil_euk.aHO().aHT() != null) {
                        m11241a(com_fossil_euk.aHP().mQ("Content-Type"), this.azA, outputStream);
                        break;
                    }
                    break;
            }
            m11245a(dVK, outputStream);
            if (z) {
                com_fossil_euk.aHO().writeTo(outputStream);
            }
            m11245a(dVK, outputStream);
        }
        m11245a(dVL, outputStream);
        m11245a(a, outputStream);
        m11245a(dVL, outputStream);
        m11245a(dVK, outputStream);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        m11244a(this.dVO, outputStream, true);
    }

    public long aHR() {
        long j = 0;
        for (euk aHO : this.dVN) {
            long contentLength = aHO.aHO().getContentLength();
            if (contentLength < 0) {
                return -1;
            }
            j = contentLength + j;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m11244a(this.dVO, byteArrayOutputStream, false);
            return ((long) byteArrayOutputStream.toByteArray().length) + j;
        } catch (IOException e) {
            return -1;
        }
    }
}
