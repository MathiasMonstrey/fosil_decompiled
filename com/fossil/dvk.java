package com.fossil;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.ByteString;

public abstract class dvk {
    public abstract dvh contentType();

    public abstract void writeTo(eti com_fossil_eti) throws IOException;

    public long contentLength() throws IOException {
        return -1;
    }

    public static dvk create(dvh com_fossil_dvh, String str) {
        Charset charset = dvw.UTF_8;
        if (com_fossil_dvh != null) {
            charset = com_fossil_dvh.charset();
            if (charset == null) {
                charset = dvw.UTF_8;
                com_fossil_dvh = dvh.kJ(com_fossil_dvh + "; charset=utf-8");
            }
        }
        return create(com_fossil_dvh, str.getBytes(charset));
    }

    public static dvk create(final dvh com_fossil_dvh, final ByteString byteString) {
        return new dvk() {
            public dvh contentType() {
                return com_fossil_dvh;
            }

            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            public void writeTo(eti com_fossil_eti) throws IOException {
                com_fossil_eti.mo3046f(byteString);
            }
        };
    }

    public static dvk create(dvh com_fossil_dvh, byte[] bArr) {
        return create(com_fossil_dvh, bArr, 0, bArr.length);
    }

    public static dvk create(final dvh com_fossil_dvh, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        dvw.m9973b((long) bArr.length, (long) i, (long) i2);
        return new dvk() {
            public dvh contentType() {
                return com_fossil_dvh;
            }

            public long contentLength() {
                return (long) i2;
            }

            public void writeTo(eti com_fossil_eti) throws IOException {
                com_fossil_eti.mo3049n(bArr, i, i2);
            }
        };
    }

    public static dvk create(final dvh com_fossil_dvh, final File file) {
        if (file != null) {
            return new dvk() {
                public dvh contentType() {
                    return com_fossil_dvh;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(eti com_fossil_eti) throws IOException {
                    Closeable closeable = null;
                    try {
                        closeable = etp.m11175E(file);
                        com_fossil_eti.mo3040b(closeable);
                    } finally {
                        dvw.closeQuietly(closeable);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
