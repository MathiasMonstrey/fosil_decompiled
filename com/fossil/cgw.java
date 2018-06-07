package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class cgw implements Closeable, Flushable {
    private static final String[] bUm = new String[Allocation.USAGE_SHARED];
    private static final String[] bUn = ((String[]) bUm.clone());
    private boolean bQP;
    private boolean bQQ;
    private boolean bQT;
    private int bSi = 0;
    private int[] bUk = new int[32];
    private String bUo;
    private String bUp;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            bUm[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        bUm[34] = "\\\"";
        bUm[92] = "\\\\";
        bUm[9] = "\\t";
        bUm[8] = "\\b";
        bUm[10] = "\\n";
        bUm[13] = "\\r";
        bUm[12] = "\\f";
        bUn[60] = "\\u003c";
        bUn[62] = "\\u003e";
        bUn[38] = "\\u0026";
        bUn[61] = "\\u003d";
        bUn[39] = "\\u0027";
    }

    public cgw(Writer writer) {
        iS(6);
        this.separator = ":";
        this.bQP = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.bUo = null;
            this.separator = ":";
            return;
        }
        this.bUo = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.bQT = z;
    }

    public boolean isLenient() {
        return this.bQT;
    }

    public final void bI(boolean z) {
        this.bQQ = z;
    }

    public final boolean Xo() {
        return this.bQQ;
    }

    public final void bJ(boolean z) {
        this.bQP = z;
    }

    public final boolean Xp() {
        return this.bQP;
    }

    public cgw Xa() throws IOException {
        Xr();
        return m6256p(1, "[");
    }

    public cgw Xb() throws IOException {
        return m6255h(1, 2, "]");
    }

    public cgw Xc() throws IOException {
        Xr();
        return m6256p(3, "{");
    }

    public cgw Xd() throws IOException {
        return m6255h(3, 5, "}");
    }

    private cgw m6256p(int i, String str) throws IOException {
        Xu();
        iS(i);
        this.out.write(str);
        return this;
    }

    private cgw m6255h(int i, int i2, String str) throws IOException {
        int Xq = Xq();
        if (Xq != i2 && Xq != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.bUp != null) {
            throw new IllegalStateException("Dangling name: " + this.bUp);
        } else {
            this.bSi--;
            if (Xq == i2) {
                Xs();
            }
            this.out.write(str);
            return this;
        }
    }

    private void iS(int i) {
        if (this.bSi == this.bUk.length) {
            Object obj = new int[(this.bSi * 2)];
            System.arraycopy(this.bUk, 0, obj, 0, this.bSi);
            this.bUk = obj;
        }
        int[] iArr = this.bUk;
        int i2 = this.bSi;
        this.bSi = i2 + 1;
        iArr[i2] = i;
    }

    private int Xq() {
        if (this.bSi != 0) {
            return this.bUk[this.bSi - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void iU(int i) {
        this.bUk[this.bSi - 1] = i;
    }

    public cgw fu(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.bUp != null) {
            throw new IllegalStateException();
        } else if (this.bSi == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.bUp = str;
            return this;
        }
    }

    private void Xr() throws IOException {
        if (this.bUp != null) {
            Xt();
            fy(this.bUp);
            this.bUp = null;
        }
    }

    public cgw fv(String str) throws IOException {
        if (str == null) {
            return Xe();
        }
        Xr();
        Xu();
        fy(str);
        return this;
    }

    public cgw Xe() throws IOException {
        if (this.bUp != null) {
            if (this.bQP) {
                Xr();
            } else {
                this.bUp = null;
                return this;
            }
        }
        Xu();
        this.out.write("null");
        return this;
    }

    public cgw bG(boolean z) throws IOException {
        Xr();
        Xu();
        this.out.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public cgw mo1692c(Boolean bool) throws IOException {
        if (bool == null) {
            return Xe();
        }
        Xr();
        Xu();
        this.out.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public cgw mo1697h(double d) throws IOException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        Xr();
        Xu();
        this.out.append(Double.toString(d));
        return this;
    }

    public cgw ax(long j) throws IOException {
        Xr();
        Xu();
        this.out.write(Long.toString(j));
        return this;
    }

    public cgw mo1689a(Number number) throws IOException {
        if (number == null) {
            return Xe();
        }
        Xr();
        CharSequence obj = number.toString();
        if (this.bQT || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            Xu();
            this.out.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() throws IOException {
        if (this.bSi == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public void close() throws IOException {
        this.out.close();
        int i = this.bSi;
        if (i > 1 || (i == 1 && this.bUk[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.bSi = 0;
    }

    private void fy(String str) throws IOException {
        int i = 0;
        String[] strArr = this.bQQ ? bUn : bUm;
        this.out.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == ' ') {
                    str2 = "\\u2028";
                } else if (charAt == ' ') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    private void Xs() throws IOException {
        if (this.bUo != null) {
            this.out.write("\n");
            int i = this.bSi;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.bUo);
            }
        }
    }

    private void Xt() throws IOException {
        int Xq = Xq();
        if (Xq == 5) {
            this.out.write(44);
        } else if (Xq != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Xs();
        iU(4);
    }

    private void Xu() throws IOException {
        switch (Xq()) {
            case 1:
                iU(2);
                Xs();
                return;
            case 2:
                this.out.append(',');
                Xs();
                return;
            case 4:
                this.out.append(this.separator);
                iU(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.bQT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        iU(7);
    }
}
