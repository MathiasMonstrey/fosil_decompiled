package com.fossil;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.Writer;

public final class cgi {

    static final class C2044a extends Writer {
        private final Appendable bRT;
        private final C2043a bRU = new C2043a();

        static class C2043a implements CharSequence {
            char[] bRV;

            C2043a() {
            }

            public int length() {
                return this.bRV.length;
            }

            public char charAt(int i) {
                return this.bRV[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.bRV, i, i2 - i);
            }
        }

        C2044a(Appendable appendable) {
            this.bRT = appendable;
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            this.bRU.bRV = cArr;
            this.bRT.append(this.bRU, i, i + i2);
        }

        public void write(int i) throws IOException {
            this.bRT.append((char) i);
        }

        public void flush() {
        }

        public void close() {
        }
    }

    public static cfp m6243g(cgv com_fossil_cgv) throws JsonParseException {
        Object obj = 1;
        try {
            com_fossil_cgv.WT();
            obj = null;
            return (cfp) cgs.bTM.mo1657b(com_fossil_cgv);
        } catch (Throwable e) {
            if (obj != null) {
                return cfq.bRj;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonIOException(e22);
        } catch (Throwable e222) {
            throw new JsonSyntaxException(e222);
        }
    }

    public static void m6242b(cfp com_fossil_cfp, cgw com_fossil_cgw) throws IOException {
        cgs.bTM.mo1656a(com_fossil_cgw, com_fossil_cfp);
    }

    public static Writer m6241a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C2044a(appendable);
    }
}
