package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class agf extends afy {
    protected static final char[] HEX_CHARS = afn.Bv();
    protected int aOB = 0;
    protected int aOC;
    protected final Writer aOM;
    protected char[] aON;
    protected int aOO = 0;
    protected char[] aOP;
    protected afc aOQ;

    public agf(afo com_fossil_afo, int i, afa com_fossil_afa, Writer writer) {
        super(com_fossil_afo, i, com_fossil_afa);
        this.aOM = writer;
        this.aON = com_fossil_afo.BF();
        this.aOC = this.aON.length;
    }

    public void aQ(String str) throws IOException {
        boolean z = true;
        int br = this.aLQ.br(str);
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br != 1) {
            z = false;
        }
        m3295d(str, z);
    }

    public void mo850b(afc com_fossil_afc) throws IOException {
        boolean z = true;
        int br = this.aLQ.br(com_fossil_afc.getValue());
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br != 1) {
            z = false;
        }
        m3284a(com_fossil_afc, z);
    }

    public void zH() throws IOException, JsonGenerationException {
        be("start an array");
        this.aLQ = this.aLQ.BT();
        if (this.aLw != null) {
            this.aLw.writeStartArray(this);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '[';
    }

    public void zI() throws IOException, JsonGenerationException {
        if (!this.aLQ.AA()) {
            aX("Current context not an ARRAY but " + this.aLQ.AD());
        }
        if (this.aLw != null) {
            this.aLw.writeEndArray(this, this.aLQ.getEntryCount());
        } else {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = ']';
        }
        this.aLQ = this.aLQ.BV();
    }

    public void zJ() throws IOException, JsonGenerationException {
        be("start an object");
        this.aLQ = this.aLQ.BU();
        if (this.aLw != null) {
            this.aLw.writeStartObject(this);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '{';
    }

    public void zK() throws IOException, JsonGenerationException {
        if (!this.aLQ.AC()) {
            aX("Current context not an object but " + this.aLQ.AD());
        }
        if (this.aLw != null) {
            this.aLw.writeEndObject(this, this.aLQ.getEntryCount());
        } else {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '}';
        }
        this.aLQ = this.aLQ.BV();
    }

    protected void m3295d(String str, boolean z) throws IOException {
        if (this.aLw != null) {
            m3296e(str, z);
            return;
        }
        if (this.aOB + 1 >= this.aOC) {
            Ct();
        }
        if (z) {
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = ',';
        }
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            cArr = this.aON;
            i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            by(str);
            if (this.aOB >= this.aOC) {
                Ct();
            }
            cArr = this.aON;
            i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            return;
        }
        by(str);
    }

    protected void m3284a(afc com_fossil_afc, boolean z) throws IOException {
        if (this.aLw != null) {
            m3290b(com_fossil_afc, z);
            return;
        }
        if (this.aOB + 1 >= this.aOC) {
            Ct();
        }
        if (z) {
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = ',';
        }
        Object asQuotedChars = com_fossil_afc.asQuotedChars();
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            char[] cArr2 = this.aON;
            int i2 = this.aOB;
            this.aOB = i2 + 1;
            cArr2[i2] = '\"';
            i = asQuotedChars.length;
            if ((this.aOB + i) + 1 >= this.aOC) {
                mo943b(asQuotedChars, 0, i);
                if (this.aOB >= this.aOC) {
                    Ct();
                }
                cArr = this.aON;
                i = this.aOB;
                this.aOB = i + 1;
                cArr[i] = '\"';
                return;
            }
            System.arraycopy(asQuotedChars, 0, this.aON, this.aOB, i);
            this.aOB += i;
            cArr = this.aON;
            i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            return;
        }
        mo943b(asQuotedChars, 0, asQuotedChars.length);
    }

    protected void m3296e(String str, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this.aLw.writeObjectEntrySeparator(this);
        } else {
            this.aLw.beforeObjectEntries(this);
        }
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            by(str);
            if (this.aOB >= this.aOC) {
                Ct();
            }
            cArr = this.aON;
            i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            return;
        }
        by(str);
    }

    protected void m3290b(afc com_fossil_afc, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this.aLw.writeObjectEntrySeparator(this);
        } else {
            this.aLw.beforeObjectEntries(this);
        }
        char[] asQuotedChars = com_fossil_afc.asQuotedChars();
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            char[] cArr = this.aON;
            int i = this.aOB;
            this.aOB = i + 1;
            cArr[i] = '\"';
            mo943b(asQuotedChars, 0, asQuotedChars.length);
            if (this.aOB >= this.aOC) {
                Ct();
            }
            asQuotedChars = this.aON;
            int i2 = this.aOB;
            this.aOB = i2 + 1;
            asQuotedChars[i2] = '\"';
            return;
        }
        mo943b(asQuotedChars, 0, asQuotedChars.length);
    }

    public void writeString(String str) throws IOException {
        be("write a string");
        if (str == null) {
            Cs();
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
        by(str);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr = this.aON;
        i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
    }

    public void mo939a(char[] cArr, int i, int i2) throws IOException {
        be("write a string");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr2 = this.aON;
        int i3 = this.aOB;
        this.aOB = i3 + 1;
        cArr2[i3] = '\"';
        m3275m(cArr, i, i2);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr2 = this.aON;
        i3 = this.aOB;
        this.aOB = i3 + 1;
        cArr2[i3] = '\"';
    }

    public void mo852c(afc com_fossil_afc) throws IOException {
        be("write a string");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
        Object asQuotedChars = com_fossil_afc.asQuotedChars();
        i = asQuotedChars.length;
        if (i < 32) {
            if (i > this.aOC - this.aOB) {
                Ct();
            }
            System.arraycopy(asQuotedChars, 0, this.aON, this.aOB, i);
            this.aOB += i;
        } else {
            Ct();
            this.aOM.write(asQuotedChars, 0, i);
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr = this.aON;
        i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
    }

    public void aR(String str) throws IOException {
        int length = str.length();
        int i = this.aOC - this.aOB;
        if (i == 0) {
            Ct();
            i = this.aOC - this.aOB;
        }
        if (i >= length) {
            str.getChars(0, length, this.aON, this.aOB);
            this.aOB += length;
            return;
        }
        bw(str);
    }

    public void mo946d(afc com_fossil_afc) throws IOException {
        aR(com_fossil_afc.getValue());
    }

    public void mo943b(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 32) {
            if (i2 > this.aOC - this.aOB) {
                Ct();
            }
            System.arraycopy(cArr, i, this.aON, this.aOB, i2);
            this.aOB += i2;
            return;
        }
        Ct();
        this.aOM.write(cArr, i, i2);
    }

    public void mo935a(char c) throws IOException {
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = c;
    }

    private void bw(String str) throws IOException {
        int i = this.aOC - this.aOB;
        str.getChars(0, i, this.aON, this.aOB);
        this.aOB += i;
        Ct();
        int length = str.length() - i;
        while (length > this.aOC) {
            int i2 = this.aOC;
            str.getChars(i, i + i2, this.aON, 0);
            this.aOO = 0;
            this.aOB = i2;
            Ct();
            i += i2;
            length -= i2;
        }
        str.getChars(i, i + length, this.aON, 0);
        this.aOO = 0;
        this.aOB = length;
    }

    public void mo936a(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        be("write a binary value");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i3 = this.aOB;
        this.aOB = i3 + 1;
        cArr[i3] = '\"';
        m3288b(base64Variant, bArr, i, i + i2);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr = this.aON;
        i3 = this.aOB;
        this.aOB = i3 + 1;
        cArr[i3] = '\"';
    }

    public int mo847a(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException, JsonGenerationException {
        be("write a binary value");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        cArr[i2] = '\"';
        byte[] BD = this.aLS.BD();
        if (i < 0) {
            try {
                i = m3280a(base64Variant, inputStream, BD);
            } catch (Throwable th) {
                this.aLS.m3147U(BD);
            }
        } else {
            int a = m3281a(base64Variant, inputStream, BD, i);
            if (a > 0) {
                aX("Too few bytes available: missing " + a + " bytes (out of " + i + ")");
            }
        }
        this.aLS.m3147U(BD);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr = this.aON;
        i2 = this.aOB;
        this.aOB = i2 + 1;
        cArr[i2] = '\"';
        return i;
    }

    public void mo947f(short s) throws IOException {
        be("write a number");
        if (this.aLP) {
            m3274g(s);
            return;
        }
        if (this.aOB + 6 >= this.aOC) {
            Ct();
        }
        this.aOB = afs.m3167a((int) s, this.aON, this.aOB);
    }

    private void m3274g(short s) throws IOException {
        if (this.aOB + 8 >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
        this.aOB = afs.m3167a((int) s, this.aON, this.aOB);
        cArr = this.aON;
        i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
    }

    public void fl(int i) throws IOException {
        be("write a number");
        if (this.aLP) {
            fQ(i);
            return;
        }
        if (this.aOB + 11 >= this.aOC) {
            Ct();
        }
        this.aOB = afs.m3167a(i, this.aON, this.aOB);
    }

    private void fQ(int i) throws IOException {
        if (this.aOB + 13 >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        cArr[i2] = '\"';
        this.aOB = afs.m3167a(i, this.aON, this.aOB);
        cArr = this.aON;
        i2 = this.aOB;
        this.aOB = i2 + 1;
        cArr[i2] = '\"';
    }

    public void mo933J(long j) throws IOException {
        be("write a number");
        if (this.aLP) {
            m3268L(j);
            return;
        }
        if (this.aOB + 21 >= this.aOC) {
            Ct();
        }
        this.aOB = afs.m3169a(j, this.aON, this.aOB);
    }

    private void m3268L(long j) throws IOException {
        if (this.aOB + 23 >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
        this.aOB = afs.m3169a(j, this.aON, this.aOB);
        cArr = this.aON;
        i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
    }

    public void mo938a(BigInteger bigInteger) throws IOException {
        be("write a number");
        if (bigInteger == null) {
            Cs();
        } else if (this.aLP) {
            bv(bigInteger.toString());
        } else {
            aR(bigInteger.toString());
        }
    }

    public void mo945d(double d) throws IOException {
        if (this.aLP || (isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS) && (Double.isNaN(d) || Double.isInfinite(d)))) {
            writeString(String.valueOf(d));
            return;
        }
        be("write a number");
        aR(String.valueOf(d));
    }

    public void mo934T(float f) throws IOException {
        if (this.aLP || (isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS) && (Float.isNaN(f) || Float.isInfinite(f)))) {
            writeString(String.valueOf(f));
            return;
        }
        be("write a number");
        aR(String.valueOf(f));
    }

    public void mo937a(BigDecimal bigDecimal) throws IOException {
        be("write a number");
        if (bigDecimal == null) {
            Cs();
        } else if (this.aLP) {
            bv(isEnabled(Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString());
        } else if (isEnabled(Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
            aR(bigDecimal.toPlainString());
        } else {
            aR(bigDecimal.toString());
        }
    }

    public void aT(String str) throws IOException {
        be("write a number");
        if (this.aLP) {
            bv(str);
        } else {
            aR(str);
        }
    }

    private void bv(String str) throws IOException {
        if (this.aOB >= this.aOC) {
            Ct();
        }
        char[] cArr = this.aON;
        int i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
        aR(str);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        cArr = this.aON;
        i = this.aOB;
        this.aOB = i + 1;
        cArr[i] = '\"';
    }

    public void writeBoolean(boolean z) throws IOException {
        be("write a boolean value");
        if (this.aOB + 5 >= this.aOC) {
            Ct();
        }
        int i = this.aOB;
        char[] cArr = this.aON;
        if (z) {
            cArr[i] = 't';
            i++;
            cArr[i] = 'r';
            i++;
            cArr[i] = 'u';
            i++;
            cArr[i] = 'e';
        } else {
            cArr[i] = 'f';
            i++;
            cArr[i] = 'a';
            i++;
            cArr[i] = 'l';
            i++;
            cArr[i] = 's';
            i++;
            cArr[i] = 'e';
        }
        this.aOB = i + 1;
    }

    public void zL() throws IOException {
        be("write a null");
        Cs();
    }

    protected void be(String str) throws IOException {
        if (this.aLw != null) {
            bx(str);
            return;
        }
        char c;
        int BW = this.aLQ.BW();
        if (BW == 5) {
            aX("Can not " + str + ", expecting field name");
        }
        switch (BW) {
            case 1:
                c = ',';
                break;
            case 2:
                c = ':';
                break;
            case 3:
                if (this._rootValueSeparator != null) {
                    aR(this._rootValueSeparator.getValue());
                    return;
                }
                return;
            default:
                return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        this.aON[this.aOB] = c;
        this.aOB++;
    }

    protected void bx(String str) throws IOException {
        int BW = this.aLQ.BW();
        if (BW == 5) {
            aX("Can not " + str + ", expecting field name");
        }
        switch (BW) {
            case 0:
                if (this.aLQ.AA()) {
                    this.aLw.beforeArrayValues(this);
                    return;
                } else if (this.aLQ.AC()) {
                    this.aLw.beforeObjectEntries(this);
                    return;
                } else {
                    return;
                }
            case 1:
                this.aLw.writeArrayValueSeparator(this);
                return;
            case 2:
                this.aLw.writeObjectFieldValueSeparator(this);
                return;
            case 3:
                this.aLw.writeRootValueSeparator(this);
                return;
            default:
                zN();
                return;
        }
    }

    public void flush() throws IOException {
        Ct();
        if (this.aOM != null && isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.aOM.flush();
        }
    }

    public void close() throws IOException {
        super.close();
        if (this.aON != null && isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                aez AG = AG();
                if (!AG.AA()) {
                    if (!AG.AC()) {
                        break;
                    }
                    zK();
                } else {
                    zI();
                }
            }
        }
        Ct();
        this.aOO = 0;
        this.aOB = 0;
        if (this.aOM != null) {
            if (this.aLS.Bz() || isEnabled(Feature.AUTO_CLOSE_TARGET)) {
                this.aOM.close();
            } else if (isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
                this.aOM.flush();
            }
        }
        AH();
    }

    protected void AH() {
        char[] cArr = this.aON;
        if (cArr != null) {
            this.aON = null;
            this.aLS.m3151b(cArr);
        }
    }

    private void by(String str) throws IOException {
        int length = str.length();
        if (length > this.aOC) {
            bz(str);
            return;
        }
        if (this.aOB + length > this.aOC) {
            Ct();
        }
        str.getChars(0, length, this.aON, this.aOB);
        if (this._characterEscapes != null) {
            gh(length);
        } else if (this.aOg != 0) {
            bB(length, this.aOg);
        } else {
            gf(length);
        }
    }

    private void gf(int i) throws IOException {
        int i2 = this.aOB + i;
        int[] iArr = this.aOf;
        char length = iArr.length;
        while (this.aOB < i2) {
            char c;
            int i3;
            while (true) {
                c = this.aON[this.aOB];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i3 = this.aOB + 1;
                this.aOB = i3;
                if (i3 >= i2) {
                    return;
                }
            }
            i3 = this.aOB - this.aOO;
            if (i3 > 0) {
                this.aOM.write(this.aON, this.aOO, i3);
            }
            char[] cArr = this.aON;
            int i4 = this.aOB;
            this.aOB = i4 + 1;
            c = cArr[i4];
            m3271a(c, iArr[c]);
        }
    }

    private void bz(String str) throws IOException {
        Ct();
        int length = str.length();
        int i = 0;
        do {
            int i2 = this.aOC;
            if (i + i2 > length) {
                i2 = length - i;
            }
            str.getChars(i, i + i2, this.aON, 0);
            if (this._characterEscapes != null) {
                gi(i2);
            } else if (this.aOg != 0) {
                bC(i2, this.aOg);
            } else {
                gg(i2);
            }
            i += i2;
        } while (i < length);
    }

    private void gg(int i) throws IOException {
        int[] iArr = this.aOf;
        char length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            char c;
            do {
                c = this.aON[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i2++;
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.aOM.write(this.aON, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i4 = i2 + 1;
            i3 = m3270a(this.aON, i4, i, c, iArr[c]);
            i2 = i4;
        }
    }

    private void m3275m(char[] cArr, int i, int i2) throws IOException {
        if (this._characterEscapes != null) {
            m3276n(cArr, i, i2);
        } else if (this.aOg != 0) {
            m3272a(cArr, i, i2, this.aOg);
        } else {
            int i3 = i2 + i;
            int[] iArr = this.aOf;
            char length = iArr.length;
            int i4 = i;
            while (i4 < i3) {
                int i5 = i4;
                do {
                    char c = cArr[i5];
                    if (c < length && iArr[c] != 0) {
                        break;
                    }
                    i5++;
                } while (i5 < i3);
                int i6 = i5 - i4;
                if (i6 < 32) {
                    if (this.aOB + i6 > this.aOC) {
                        Ct();
                    }
                    if (i6 > 0) {
                        System.arraycopy(cArr, i4, this.aON, this.aOB, i6);
                        this.aOB += i6;
                    }
                } else {
                    Ct();
                    this.aOM.write(cArr, i4, i6);
                }
                if (i5 < i3) {
                    i4 = i5 + 1;
                    char c2 = cArr[i5];
                    m3273b(c2, iArr[c2]);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bB(int r10, int r11) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
        r9 = this;
        r0 = r9.aOB;
        r1 = r0 + r10;
        r2 = r9.aOf;
        r0 = r2.length;
        r3 = r11 + 1;
        r3 = java.lang.Math.min(r0, r3);
    L_0x000d:
        r0 = r9.aOB;
        if (r0 >= r1) goto L_0x0043;
    L_0x0011:
        r0 = r9.aON;
        r4 = r9.aOB;
        r4 = r0[r4];
        if (r4 >= r3) goto L_0x0037;
    L_0x0019:
        r0 = r2[r4];
        if (r0 == 0) goto L_0x003b;
    L_0x001d:
        r5 = r9.aOB;
        r6 = r9.aOO;
        r5 = r5 - r6;
        if (r5 <= 0) goto L_0x002d;
    L_0x0024:
        r6 = r9.aOM;
        r7 = r9.aON;
        r8 = r9.aOO;
        r6.write(r7, r8, r5);
    L_0x002d:
        r5 = r9.aOB;
        r5 = r5 + 1;
        r9.aOB = r5;
        r9.m3271a(r4, r0);
        goto L_0x000d;
    L_0x0037:
        if (r4 <= r11) goto L_0x003b;
    L_0x0039:
        r0 = -1;
        goto L_0x001d;
    L_0x003b:
        r0 = r9.aOB;
        r0 = r0 + 1;
        r9.aOB = r0;
        if (r0 < r1) goto L_0x0011;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.agf.bB(int, int):void");
    }

    private void bC(int i, int i2) throws IOException, JsonGenerationException {
        int i3 = 0;
        int[] iArr = this.aOf;
        char min = Math.min(iArr.length, i2 + 1);
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            char c;
            int i6;
            do {
                c = this.aON[i5];
                if (c < min) {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                    i3 = i6;
                    i5++;
                } else {
                    if (c > i2) {
                        i6 = -1;
                        break;
                    }
                    i5++;
                }
            } while (i5 < i);
            i6 = i3;
            i3 = i5 - i4;
            if (i3 > 0) {
                this.aOM.write(this.aON, i4, i3);
                if (i5 >= i) {
                    return;
                }
            }
            i4 = i5 + 1;
            i5 = i4;
            i4 = m3270a(this.aON, i4, i, c, i6);
            i3 = i6;
        }
    }

    private void m3272a(char[] cArr, int i, int i2, int i3) throws IOException, JsonGenerationException {
        int i4 = i2 + i;
        int[] iArr = this.aOf;
        char min = Math.min(iArr.length, i3 + 1);
        int i5 = 0;
        int i6 = i;
        while (i6 < i4) {
            int i7 = i6;
            do {
                char c = cArr[i7];
                if (c < min) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                    i7++;
                } else {
                    if (c > i3) {
                        i5 = -1;
                        break;
                    }
                    i7++;
                }
            } while (i7 < i4);
            int i8 = i7 - i6;
            if (i8 < 32) {
                if (this.aOB + i8 > this.aOC) {
                    Ct();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i6, this.aON, this.aOB, i8);
                    this.aOB += i8;
                }
            } else {
                Ct();
                this.aOM.write(cArr, i6, i8);
            }
            if (i7 < i4) {
                i6 = i7 + 1;
                m3273b(c, i5);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gh(int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
        r11 = this;
        r0 = r11.aOB;
        r2 = r0 + r12;
        r3 = r11.aOf;
        r0 = r11.aOg;
        r1 = 1;
        if (r0 >= r1) goto L_0x0041;
    L_0x000b:
        r0 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
    L_0x000e:
        r1 = r3.length;
        r4 = r0 + 1;
        r4 = java.lang.Math.min(r1, r4);
        r5 = r11._characterEscapes;
    L_0x0017:
        r1 = r11.aOB;
        if (r1 >= r2) goto L_0x005a;
    L_0x001b:
        r1 = r11.aON;
        r6 = r11.aOB;
        r6 = r1[r6];
        if (r6 >= r4) goto L_0x0044;
    L_0x0023:
        r1 = r3[r6];
        if (r1 == 0) goto L_0x0052;
    L_0x0027:
        r7 = r11.aOB;
        r8 = r11.aOO;
        r7 = r7 - r8;
        if (r7 <= 0) goto L_0x0037;
    L_0x002e:
        r8 = r11.aOM;
        r9 = r11.aON;
        r10 = r11.aOO;
        r8.write(r9, r10, r7);
    L_0x0037:
        r7 = r11.aOB;
        r7 = r7 + 1;
        r11.aOB = r7;
        r11.m3271a(r6, r1);
        goto L_0x0017;
    L_0x0041:
        r0 = r11.aOg;
        goto L_0x000e;
    L_0x0044:
        if (r6 <= r0) goto L_0x0048;
    L_0x0046:
        r1 = -1;
        goto L_0x0027;
    L_0x0048:
        r1 = r5.getEscapeSequence(r6);
        r11.aOQ = r1;
        if (r1 == 0) goto L_0x0052;
    L_0x0050:
        r1 = -2;
        goto L_0x0027;
    L_0x0052:
        r1 = r11.aOB;
        r1 = r1 + 1;
        r11.aOB = r1;
        if (r1 < r2) goto L_0x001b;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.agf.gh(int):void");
    }

    private void gi(int i) throws IOException, JsonGenerationException {
        int i2 = 0;
        int[] iArr = this.aOf;
        char c = this.aOg < 1 ? '￿' : this.aOg;
        char min = Math.min(iArr.length, c + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            char c2;
            int i5;
            do {
                c2 = this.aON[i2];
                if (c2 < min) {
                    i5 = iArr[c2];
                    if (i5 != 0) {
                        break;
                    }
                    i4 = i5;
                    i2++;
                } else if (c2 > c) {
                    i5 = -1;
                    break;
                } else {
                    afc escapeSequence = characterEscapes.getEscapeSequence(c2);
                    this.aOQ = escapeSequence;
                    if (escapeSequence != null) {
                        i5 = -2;
                        break;
                    }
                    i2++;
                }
            } while (i2 < i);
            i5 = i4;
            i4 = i2 - i3;
            if (i4 > 0) {
                this.aOM.write(this.aON, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i3 = i2 + 1;
            i2 = i3;
            i3 = m3270a(this.aON, i3, i, c2, i5);
            i4 = i5;
        }
    }

    private void m3276n(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = i2 + i;
        int[] iArr = this.aOf;
        char c = this.aOg < 1 ? '￿' : this.aOg;
        char min = Math.min(iArr.length, c + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i4 = 0;
        int i5 = i;
        while (i5 < i3) {
            int i6 = i5;
            do {
                char c2 = cArr[i6];
                if (c2 < min) {
                    i4 = iArr[c2];
                    if (i4 != 0) {
                        break;
                    }
                    i6++;
                } else if (c2 > c) {
                    i4 = -1;
                    break;
                } else {
                    afc escapeSequence = characterEscapes.getEscapeSequence(c2);
                    this.aOQ = escapeSequence;
                    if (escapeSequence != null) {
                        i4 = -2;
                        break;
                    }
                    i6++;
                }
            } while (i6 < i3);
            int i7 = i6 - i5;
            if (i7 < 32) {
                if (this.aOB + i7 > this.aOC) {
                    Ct();
                }
                if (i7 > 0) {
                    System.arraycopy(cArr, i5, this.aON, this.aOB, i7);
                    this.aOB += i7;
                }
            } else {
                Ct();
                this.aOM.write(cArr, i5, i7);
            }
            if (i6 < i3) {
                i5 = i6 + 1;
                m3273b(c2, i4);
            } else {
                return;
            }
        }
    }

    protected void m3288b(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = i2 - 3;
        int i4 = this.aOC - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        while (i <= i3) {
            if (this.aOB > i4) {
                Ct();
            }
            int i5 = i + 1;
            int i6 = bArr[i] << 8;
            int i7 = i5 + 1;
            i = i7 + 1;
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i5] & 255) | i6) << 8) | (bArr[i7] & 255), this.aON, this.aOB);
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.aON;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                cArr[i5] = '\\';
                cArr = this.aON;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                cArr[i5] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        i3 = i2 - i;
        if (i3 > 0) {
            if (this.aOB > i4) {
                Ct();
            }
            i4 = i + 1;
            maxLineLength = bArr[i] << 16;
            if (i3 == 2) {
                i5 = i4 + 1;
                maxLineLength |= (bArr[i4] & 255) << 8;
            }
            this.aOB = base64Variant.encodeBase64Partial(maxLineLength, i3, this.aON, this.aOB);
        }
    }

    protected int m3281a(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException, JsonGenerationException {
        int i2 = 0;
        int i3 = 0;
        int i4 = -3;
        int i5 = this.aOC - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i6 = i;
        while (i6 > 2) {
            if (i2 > i4) {
                i3 = m3269a(inputStream, bArr, i2, i3, i6);
                i2 = 0;
                if (i3 < 3) {
                    break;
                }
                i4 = i3 - 3;
            }
            if (this.aOB > i5) {
                Ct();
            }
            int i7 = i2 + 1;
            int i8 = bArr[i2] << 8;
            int i9 = i7 + 1;
            i2 = i9 + 1;
            i6 -= 3;
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i7] & 255) | i8) << 8) | (bArr[i9] & 255), this.aON, this.aOB);
            i7 = maxLineLength - 1;
            if (i7 <= 0) {
                char[] cArr = this.aON;
                i8 = this.aOB;
                this.aOB = i8 + 1;
                cArr[i8] = '\\';
                cArr = this.aON;
                i8 = this.aOB;
                this.aOB = i8 + 1;
                cArr[i8] = 'n';
                i7 = base64Variant.getMaxLineLength() >> 2;
            }
            maxLineLength = i7;
        }
        if (i6 <= 0) {
            return i6;
        }
        i4 = m3269a(inputStream, bArr, i2, i3, i6);
        if (i4 <= 0) {
            return i6;
        }
        if (this.aOB > i5) {
            Ct();
        }
        i7 = bArr[0] << 16;
        if (1 < i4) {
            i7 |= (bArr[1] & 255) << 8;
            i4 = 2;
        } else {
            i4 = 1;
        }
        this.aOB = base64Variant.encodeBase64Partial(i7, i4, this.aON, this.aOB);
        return i6 - i4;
    }

    protected int m3280a(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException, JsonGenerationException {
        int i = -3;
        int i2 = this.aOC - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 > i) {
                i4 = m3269a(inputStream, bArr, i5, i4, bArr.length);
                if (i4 < 3) {
                    break;
                }
                i = i4 - 3;
                i5 = 0;
            }
            if (this.aOB > i2) {
                Ct();
            }
            int i6 = i5 + 1;
            int i7 = bArr[i5] << 8;
            int i8 = i6 + 1;
            i5 = i8 + 1;
            i3 += 3;
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.aON, this.aOB);
            i6 = maxLineLength - 1;
            if (i6 <= 0) {
                char[] cArr = this.aON;
                i7 = this.aOB;
                this.aOB = i7 + 1;
                cArr[i7] = '\\';
                cArr = this.aON;
                i7 = this.aOB;
                this.aOB = i7 + 1;
                cArr[i7] = 'n';
                i6 = base64Variant.getMaxLineLength() >> 2;
            }
            maxLineLength = i6;
        }
        if (0 >= i4) {
            return i3;
        }
        if (this.aOB > i2) {
            Ct();
        }
        i = bArr[0] << 16;
        if (1 < i4) {
            i6 = ((bArr[1] & 255) << 8) | i;
            i = 2;
        } else {
            i6 = i;
            i = 1;
        }
        i7 = i3 + i;
        this.aOB = base64Variant.encodeBase64Partial(i6, i, this.aON, this.aOB);
        return i7;
    }

    private int m3269a(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        int i5 = 0;
        while (i < i2) {
            i4 = i5 + 1;
            int i6 = i + 1;
            bArr[i5] = bArr[i];
            i5 = i4;
            i = i6;
        }
        i4 = Math.min(i3, bArr.length);
        do {
            i6 = i4 - i5;
            if (i6 != 0) {
                i6 = inputStream.read(bArr, i5, i6);
                if (i6 < 0) {
                    break;
                }
                i5 += i6;
            } else {
                break;
            }
        } while (i5 < 3);
        return i5;
    }

    private final void Cs() throws IOException {
        if (this.aOB + 4 >= this.aOC) {
            Ct();
        }
        int i = this.aOB;
        char[] cArr = this.aON;
        cArr[i] = 'n';
        i++;
        cArr[i] = 'u';
        i++;
        cArr[i] = 'l';
        i++;
        cArr[i] = 'l';
        this.aOB = i + 1;
    }

    private void m3271a(char c, int i) throws IOException, JsonGenerationException {
        int i2;
        int i3;
        char[] cArr;
        if (i >= 0) {
            if (this.aOB >= 2) {
                i2 = this.aOB - 2;
                this.aOO = i2;
                i3 = i2 + 1;
                this.aON[i2] = '\\';
                this.aON[i3] = (char) i;
                return;
            }
            cArr = this.aOP;
            if (cArr == null) {
                cArr = CA();
            }
            this.aOO = this.aOB;
            cArr[1] = (char) i;
            this.aOM.write(cArr, 0, 2);
        } else if (i == -2) {
            String value;
            if (this.aOQ == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = this.aOQ.getValue();
                this.aOQ = null;
            }
            r1 = value.length();
            if (this.aOB >= r1) {
                i3 = this.aOB - r1;
                this.aOO = i3;
                value.getChars(0, r1, this.aON, i3);
                return;
            }
            this.aOO = this.aOB;
            this.aOM.write(value);
        } else if (this.aOB >= 6) {
            char[] cArr2 = this.aON;
            i2 = this.aOB - 6;
            this.aOO = i2;
            cArr2[i2] = '\\';
            i2++;
            cArr2[i2] = 'u';
            if (c > 'ÿ') {
                i3 = (c >> 8) & 255;
                i2++;
                cArr2[i2] = HEX_CHARS[i3 >> 4];
                i2++;
                cArr2[i2] = HEX_CHARS[i3 & 15];
                c = (char) (c & 255);
            } else {
                i2++;
                cArr2[i2] = '0';
                i2++;
                cArr2[i2] = '0';
            }
            i2++;
            cArr2[i2] = HEX_CHARS[c >> 4];
            cArr2[i2 + 1] = HEX_CHARS[c & 15];
        } else {
            cArr = this.aOP;
            if (cArr == null) {
                cArr = CA();
            }
            this.aOO = this.aOB;
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                i3 = c & 255;
                cArr[10] = HEX_CHARS[r1 >> 4];
                cArr[11] = HEX_CHARS[r1 & 15];
                cArr[12] = HEX_CHARS[i3 >> 4];
                cArr[13] = HEX_CHARS[i3 & 15];
                this.aOM.write(cArr, 8, 6);
                return;
            }
            cArr[6] = HEX_CHARS[c >> 4];
            cArr[7] = HEX_CHARS[c & 15];
            this.aOM.write(cArr, 2, 6);
        }
    }

    private int m3270a(char[] cArr, int i, int i2, char c, int i3) throws IOException, JsonGenerationException {
        char[] cArr2;
        if (i3 >= 0) {
            if (i <= 1 || i >= i2) {
                cArr2 = this.aOP;
                if (cArr2 == null) {
                    cArr2 = CA();
                }
                cArr2[1] = (char) i3;
                this.aOM.write(cArr2, 0, 2);
                return i;
            }
            i -= 2;
            cArr[i] = '\\';
            cArr[i + 1] = (char) i3;
            return i;
        } else if (i3 == -2) {
            String value;
            if (this.aOQ == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = this.aOQ.getValue();
                this.aOQ = null;
            }
            r1 = value.length();
            if (i < r1 || i >= i2) {
                this.aOM.write(value);
                return i;
            }
            i -= r1;
            value.getChars(0, r1, cArr, i);
            return i;
        } else if (i <= 5 || i >= i2) {
            cArr2 = this.aOP;
            if (cArr2 == null) {
                cArr2 = CA();
            }
            this.aOO = this.aOB;
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                r2 = c & 255;
                cArr2[10] = HEX_CHARS[r1 >> 4];
                cArr2[11] = HEX_CHARS[r1 & 15];
                cArr2[12] = HEX_CHARS[r2 >> 4];
                cArr2[13] = HEX_CHARS[r2 & 15];
                this.aOM.write(cArr2, 8, 6);
                return i;
            }
            cArr2[6] = HEX_CHARS[c >> 4];
            cArr2[7] = HEX_CHARS[c & 15];
            this.aOM.write(cArr2, 2, 6);
            return i;
        } else {
            int i4 = i - 6;
            r1 = i4 + 1;
            cArr[i4] = '\\';
            i4 = r1 + 1;
            cArr[r1] = 'u';
            if (c > 'ÿ') {
                r1 = (c >> 8) & 255;
                r2 = i4 + 1;
                cArr[i4] = HEX_CHARS[r1 >> 4];
                i4 = r2 + 1;
                cArr[r2] = HEX_CHARS[r1 & 15];
                c = (char) (c & 255);
            } else {
                r1 = i4 + 1;
                cArr[i4] = '0';
                i4 = r1 + 1;
                cArr[r1] = '0';
            }
            r1 = i4 + 1;
            cArr[i4] = HEX_CHARS[c >> 4];
            cArr[r1] = HEX_CHARS[c & 15];
            return r1 - 5;
        }
    }

    private void m3273b(char c, int i) throws IOException, JsonGenerationException {
        int i2;
        if (i >= 0) {
            if (this.aOB + 2 > this.aOC) {
                Ct();
            }
            char[] cArr = this.aON;
            i2 = this.aOB;
            this.aOB = i2 + 1;
            cArr[i2] = '\\';
            cArr = this.aON;
            i2 = this.aOB;
            this.aOB = i2 + 1;
            cArr[i2] = (char) i;
        } else if (i != -2) {
            if (this.aOB + 2 > this.aOC) {
                Ct();
            }
            int i3 = this.aOB;
            char[] cArr2 = this.aON;
            int i4 = i3 + 1;
            cArr2[i3] = '\\';
            i3 = i4 + 1;
            cArr2[i4] = 'u';
            if (c > 'ÿ') {
                i4 = (c >> 8) & 255;
                int i5 = i3 + 1;
                cArr2[i3] = HEX_CHARS[i4 >> 4];
                i3 = i5 + 1;
                cArr2[i5] = HEX_CHARS[i4 & 15];
                c = (char) (c & 255);
            } else {
                i4 = i3 + 1;
                cArr2[i3] = '0';
                i3 = i4 + 1;
                cArr2[i4] = '0';
            }
            i4 = i3 + 1;
            cArr2[i3] = HEX_CHARS[c >> 4];
            i3 = i4 + 1;
            cArr2[i4] = HEX_CHARS[c & 15];
            this.aOB = i3;
        } else {
            String value;
            if (this.aOQ == null) {
                value = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                value = this.aOQ.getValue();
                this.aOQ = null;
            }
            i2 = value.length();
            if (this.aOB + i2 > this.aOC) {
                Ct();
                if (i2 > this.aOC) {
                    this.aOM.write(value);
                    return;
                }
            }
            value.getChars(0, i2, this.aON, this.aOB);
            this.aOB += i2;
        }
    }

    private char[] CA() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.aOP = cArr;
        return cArr;
    }

    protected void Ct() throws IOException {
        int i = this.aOB - this.aOO;
        if (i > 0) {
            int i2 = this.aOO;
            this.aOO = 0;
            this.aOB = 0;
            this.aOM.write(this.aON, i2, i);
        }
    }
}
