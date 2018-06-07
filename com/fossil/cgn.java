package com.fossil;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class cgn extends cgw {
    private static final Writer bSl = new C20501();
    private static final cft bSm = new cft("closed");
    private final List<cfp> bSn = new ArrayList();
    private String bSo;
    private cfp bSp = cfq.bRj;

    static class C20501 extends Writer {
        C20501() {
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    }

    public cgn() {
        super(bSl);
    }

    public cfp WY() {
        if (this.bSn.isEmpty()) {
            return this.bSp;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.bSn);
    }

    private cfp WZ() {
        return (cfp) this.bSn.get(this.bSn.size() - 1);
    }

    private void m6260d(cfp com_fossil_cfp) {
        if (this.bSo != null) {
            if (!com_fossil_cfp.Wz() || Xp()) {
                ((cfr) WZ()).m6212a(this.bSo, com_fossil_cfp);
            }
            this.bSo = null;
        } else if (this.bSn.isEmpty()) {
            this.bSp = com_fossil_cfp;
        } else {
            cfp WZ = WZ();
            if (WZ instanceof cfm) {
                ((cfm) WZ).m6210c(com_fossil_cfp);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public cgw Xa() throws IOException {
        cfp com_fossil_cfm = new cfm();
        m6260d(com_fossil_cfm);
        this.bSn.add(com_fossil_cfm);
        return this;
    }

    public cgw Xb() throws IOException {
        if (this.bSn.isEmpty() || this.bSo != null) {
            throw new IllegalStateException();
        } else if (WZ() instanceof cfm) {
            this.bSn.remove(this.bSn.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public cgw Xc() throws IOException {
        cfp com_fossil_cfr = new cfr();
        m6260d(com_fossil_cfr);
        this.bSn.add(com_fossil_cfr);
        return this;
    }

    public cgw Xd() throws IOException {
        if (this.bSn.isEmpty() || this.bSo != null) {
            throw new IllegalStateException();
        } else if (WZ() instanceof cfr) {
            this.bSn.remove(this.bSn.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public cgw fu(String str) throws IOException {
        if (this.bSn.isEmpty() || this.bSo != null) {
            throw new IllegalStateException();
        } else if (WZ() instanceof cfr) {
            this.bSo = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public cgw fv(String str) throws IOException {
        if (str == null) {
            return Xe();
        }
        m6260d(new cft(str));
        return this;
    }

    public cgw Xe() throws IOException {
        m6260d(cfq.bRj);
        return this;
    }

    public cgw bG(boolean z) throws IOException {
        m6260d(new cft(Boolean.valueOf(z)));
        return this;
    }

    public cgw mo1692c(Boolean bool) throws IOException {
        if (bool == null) {
            return Xe();
        }
        m6260d(new cft(bool));
        return this;
    }

    public cgw mo1697h(double d) throws IOException {
        if (isLenient() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            m6260d(new cft(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public cgw ax(long j) throws IOException {
        m6260d(new cft(Long.valueOf(j)));
        return this;
    }

    public cgw mo1689a(Number number) throws IOException {
        if (number == null) {
            return Xe();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m6260d(new cft(number));
        return this;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        if (this.bSn.isEmpty()) {
            this.bSn.add(bSm);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
