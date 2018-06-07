package com.fossil;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class ub implements Closeable {
    private final Charset azA;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public ub(InputStream inputStream, Charset charset) {
        this(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE, charset);
    }

    public ub(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(uc.US_ASCII)) {
            this.in = inputStream;
            this.azA = charset;
            this.buf = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public String readLine() throws IOException {
        String str;
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.pos >= this.end) {
                ue();
            }
            int i2 = this.pos;
            while (i2 != this.end) {
                if (this.buf[i2] == (byte) 10) {
                    int i3 = (i2 == this.pos || this.buf[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                    str = new String(this.buf, this.pos, i3 - this.pos, this.azA.name());
                    this.pos = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c41351 = new ByteArrayOutputStream(this, (this.end - this.pos) + 80) {
                final /* synthetic */ ub azB;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.azB.azA.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c41351.write(this.buf, this.pos, this.end - this.pos);
                this.end = -1;
                ue();
                i = this.pos;
                while (i != this.end) {
                    if (this.buf[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.pos) {
                c41351.write(this.buf, this.pos, i - this.pos);
            }
            this.pos = i + 1;
            str = c41351.toString();
        }
        return str;
    }

    public boolean ud() {
        return this.end == -1;
    }

    private void ue() throws IOException {
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }
}
