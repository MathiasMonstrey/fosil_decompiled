package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class agd extends afy {
    static final byte[] aOv = afn.Bw();
    private static final byte[] aOw = new byte[]{(byte) 110, (byte) 117, (byte) 108, (byte) 108};
    private static final byte[] aOx = new byte[]{(byte) 116, (byte) 114, (byte) 117, (byte) 101};
    private static final byte[] aOy = new byte[]{(byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101};
    protected boolean aNX;
    protected byte[] aOA;
    protected int aOB = 0;
    protected final int aOC;
    protected final int aOD;
    protected char[] aOE;
    protected final int aOF;
    protected boolean aOG;
    protected final OutputStream aOz;

    public agd(afo com_fossil_afo, int i, afa com_fossil_afa, OutputStream outputStream) {
        boolean z = true;
        super(com_fossil_afo, i, com_fossil_afa);
        this.aOz = outputStream;
        this.aNX = true;
        this.aOA = com_fossil_afo.BC();
        this.aOC = this.aOA.length;
        this.aOD = this.aOC >> 3;
        this.aOE = com_fossil_afo.BF();
        this.aOF = this.aOE.length;
        if (isEnabled(Feature.ESCAPE_NON_ASCII)) {
            fj(127);
        }
        if (Feature.QUOTE_FIELD_NAMES.enabledIn(i)) {
            z = false;
        }
        this.aOG = z;
    }

    public void aQ(String str) throws IOException {
        if (this.aLw != null) {
            bu(str);
            return;
        }
        int br = this.aLQ.br(str);
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br == 1) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            int i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 44;
        }
        if (this.aOG) {
            m3212c(str, false);
            return;
        }
        br = str.length();
        if (br > this.aOF) {
            m3212c(str, true);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr2 = this.aOA;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr2[i2] = (byte) 34;
        if (br <= this.aOD) {
            if (this.aOB + br > this.aOC) {
                Ct();
            }
            m3213d(str, 0, br);
        } else {
            m3211c(str, 0, br);
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    public void mo850b(afc com_fossil_afc) throws IOException {
        if (this.aLw != null) {
            m3243g(com_fossil_afc);
            return;
        }
        int br = this.aLQ.br(com_fossil_afc.getValue());
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br == 1) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            int i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 44;
        }
        if (this.aOG) {
            m3215f(com_fossil_afc);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        br = com_fossil_afc.appendQuotedUTF8(this.aOA, this.aOB);
        if (br < 0) {
            m3206V(com_fossil_afc.asQuotedUTF8());
        } else {
            this.aOB = br + this.aOB;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    private final void m3215f(afc com_fossil_afc) throws IOException {
        int appendQuotedUTF8 = com_fossil_afc.appendQuotedUTF8(this.aOA, this.aOB);
        if (appendQuotedUTF8 < 0) {
            m3206V(com_fossil_afc.asQuotedUTF8());
        } else {
            this.aOB = appendQuotedUTF8 + this.aOB;
        }
    }

    public final void zH() throws IOException {
        be("start an array");
        this.aLQ = this.aLQ.BT();
        if (this.aLw != null) {
            this.aLw.writeStartArray(this);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 91;
    }

    public final void zI() throws IOException {
        if (!this.aLQ.AA()) {
            aX("Current context not an ARRAY but " + this.aLQ.AD());
        }
        if (this.aLw != null) {
            this.aLw.writeEndArray(this, this.aLQ.getEntryCount());
        } else {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            int i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 93;
        }
        this.aLQ = this.aLQ.BV();
    }

    public final void zJ() throws IOException {
        be("start an object");
        this.aLQ = this.aLQ.BU();
        if (this.aLw != null) {
            this.aLw.writeStartObject(this);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 123;
    }

    public final void zK() throws IOException {
        if (!this.aLQ.AC()) {
            aX("Current context not an object but " + this.aLQ.AD());
        }
        if (this.aLw != null) {
            this.aLw.writeEndObject(this, this.aLQ.getEntryCount());
        } else {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            int i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 125;
        }
        this.aLQ = this.aLQ.BV();
    }

    protected final void bu(String str) throws IOException {
        int br = this.aLQ.br(str);
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br == 1) {
            this.aLw.writeObjectEntrySeparator(this);
        } else {
            this.aLw.beforeObjectEntries(this);
        }
        if (this.aOG) {
            m3212c(str, false);
            return;
        }
        br = str.length();
        if (br > this.aOF) {
            m3212c(str, true);
            return;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        str.getChars(0, br, this.aOE, 0);
        if (br <= this.aOD) {
            if (this.aOB + br > this.aOC) {
                Ct();
            }
            m3221i(this.aOE, 0, br);
        } else {
            m3220h(this.aOE, 0, br);
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr2 = this.aOA;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    protected final void m3243g(afc com_fossil_afc) throws IOException {
        Object obj = 1;
        int br = this.aLQ.br(com_fossil_afc.getValue());
        if (br == 4) {
            aX("Can not write a field name, expecting a value");
        }
        if (br == 1) {
            this.aLw.writeObjectEntrySeparator(this);
        } else {
            this.aLw.beforeObjectEntries(this);
        }
        if (this.aOG) {
            obj = null;
        }
        if (obj != null) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            int i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 34;
        }
        m3206V(com_fossil_afc.asQuotedUTF8());
        if (obj != null) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr2 = this.aOA;
            br = this.aOB;
            this.aOB = br + 1;
            bArr2[br] = (byte) 34;
        }
    }

    public void writeString(String str) throws IOException {
        be("write a string");
        if (str == null) {
            Cs();
            return;
        }
        int length = str.length();
        if (length > this.aOD) {
            m3212c(str, true);
            return;
        }
        if (this.aOB + length >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        m3213d(str, 0, length);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr2 = this.aOA;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    public void mo939a(char[] cArr, int i, int i2) throws IOException {
        be("write a string");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) 34;
        if (i2 <= this.aOD) {
            if (this.aOB + i2 > this.aOC) {
                Ct();
            }
            m3221i(cArr, i, i2);
        } else {
            m3220h(cArr, i, i2);
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) 34;
    }

    public final void mo852c(afc com_fossil_afc) throws IOException {
        be("write a string");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        int appendQuotedUTF8 = com_fossil_afc.appendQuotedUTF8(this.aOA, this.aOB);
        if (appendQuotedUTF8 < 0) {
            m3206V(com_fossil_afc.asQuotedUTF8());
        } else {
            this.aOB = appendQuotedUTF8 + this.aOB;
        }
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    public void aR(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.aOE;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            mo943b(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    public void mo946d(afc com_fossil_afc) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = com_fossil_afc.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            m3206V(asUnquotedUTF8);
        }
    }

    public void mo854e(afc com_fossil_afc) throws IOException {
        be("write a raw (unencoded) value");
        byte[] asUnquotedUTF8 = com_fossil_afc.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            m3206V(asUnquotedUTF8);
        }
    }

    public final void mo943b(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = (i2 + i2) + i2;
        if (this.aOB + i3 > this.aOC) {
            if (this.aOC < i3) {
                m3219g(cArr, i, i2);
                return;
            }
            Ct();
        }
        int i4 = i2 + i;
        i3 = i;
        while (i3 < i4) {
            while (true) {
                char c = cArr[i3];
                if (c > '') {
                    break;
                }
                byte[] bArr = this.aOA;
                int i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) c;
                i3++;
                if (i3 >= i4) {
                    return;
                }
            }
            int i6 = i3 + 1;
            i3 = cArr[i3];
            if (i3 < 'ࠀ') {
                bArr = this.aOA;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) ((i3 >> 6) | 192);
                bArr = this.aOA;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) ((i3 & 63) | Allocation.USAGE_SHARED);
                i3 = i6;
            } else {
                i3 = m3210b(i3, cArr, i6, i4);
            }
        }
    }

    public void mo935a(char c) throws IOException, JsonGenerationException {
        if (this.aOB + 3 >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i;
        if (c <= '') {
            i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) c;
        } else if (c < 'ࠀ') {
            i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) ((c >> 6) | 192);
            i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) ((c & 63) | Allocation.USAGE_SHARED);
        } else {
            m3210b((int) c, null, 0, 0);
        }
    }

    private final void m3219g(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = this.aOC;
        byte[] bArr = this.aOA;
        int i4 = i;
        while (i4 < i2) {
            while (true) {
                char c = cArr[i4];
                if (c >= '') {
                    break;
                }
                if (this.aOB >= i3) {
                    Ct();
                }
                int i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) c;
                i4++;
                if (i4 >= i2) {
                    return;
                }
            }
            if (this.aOB + 3 >= this.aOC) {
                Ct();
            }
            int i6 = i4 + 1;
            i4 = cArr[i4];
            if (i4 < 'ࠀ') {
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) ((i4 >> 6) | 192);
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr[i5] = (byte) ((i4 & 63) | Allocation.USAGE_SHARED);
                i4 = i6;
            } else {
                i4 = m3210b(i4, cArr, i6, i2);
            }
        }
    }

    public void mo936a(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        be("write a binary value");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr2 = this.aOA;
        int i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr2[i3] = (byte) 34;
        m3235b(base64Variant, bArr, i, i + i2);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr2 = this.aOA;
        i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr2[i3] = (byte) 34;
    }

    public int mo847a(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException, JsonGenerationException {
        be("write a binary value");
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr[i2] = (byte) 34;
        byte[] BD = this.aLS.BD();
        if (i < 0) {
            try {
                i = m3228a(base64Variant, inputStream, BD);
            } catch (Throwable th) {
                this.aLS.m3147U(BD);
            }
        } else {
            int a = m3229a(base64Variant, inputStream, BD, i);
            if (a > 0) {
                aX("Too few bytes available: missing " + a + " bytes (out of " + i + ")");
            }
        }
        this.aLS.m3147U(BD);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr[i2] = (byte) 34;
        return i;
    }

    public void mo947f(short s) throws IOException, JsonGenerationException {
        be("write a number");
        if (this.aOB + 6 >= this.aOC) {
            Ct();
        }
        if (this.aLP) {
            m3218g(s);
        } else {
            this.aOB = afs.m3166a((int) s, this.aOA, this.aOB);
        }
    }

    private final void m3218g(short s) throws IOException {
        if (this.aOB + 8 >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        this.aOB = afs.m3166a((int) s, this.aOA, this.aOB);
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    public void fl(int i) throws IOException, JsonGenerationException {
        be("write a number");
        if (this.aOB + 11 >= this.aOC) {
            Ct();
        }
        if (this.aLP) {
            fQ(i);
        } else {
            this.aOB = afs.m3166a(i, this.aOA, this.aOB);
        }
    }

    private final void fQ(int i) throws IOException {
        if (this.aOB + 13 >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr[i2] = (byte) 34;
        this.aOB = afs.m3166a(i, this.aOA, this.aOB);
        bArr = this.aOA;
        i2 = this.aOB;
        this.aOB = i2 + 1;
        bArr[i2] = (byte) 34;
    }

    public void mo933J(long j) throws IOException, JsonGenerationException {
        be("write a number");
        if (this.aLP) {
            m3205L(j);
            return;
        }
        if (this.aOB + 21 >= this.aOC) {
            Ct();
        }
        this.aOB = afs.m3168a(j, this.aOA, this.aOB);
    }

    private final void m3205L(long j) throws IOException {
        if (this.aOB + 23 >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        this.aOB = afs.m3168a(j, this.aOA, this.aOB);
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    public void mo938a(BigInteger bigInteger) throws IOException, JsonGenerationException {
        be("write a number");
        if (bigInteger == null) {
            Cs();
        } else if (this.aLP) {
            bv(bigInteger.toString());
        } else {
            aR(bigInteger.toString());
        }
    }

    public void mo945d(double d) throws IOException, JsonGenerationException {
        if (this.aLP || ((Double.isNaN(d) || Double.isInfinite(d)) && isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(d));
            return;
        }
        be("write a number");
        aR(String.valueOf(d));
    }

    public void mo934T(float f) throws IOException, JsonGenerationException {
        if (this.aLP || ((Float.isNaN(f) || Float.isInfinite(f)) && isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(f));
            return;
        }
        be("write a number");
        aR(String.valueOf(f));
    }

    public void mo937a(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
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

    public void aT(String str) throws IOException, JsonGenerationException {
        be("write a number");
        if (this.aLP) {
            bv(str);
        } else {
            aR(str);
        }
    }

    private final void bv(String str) throws IOException {
        if (this.aOB >= this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
        aR(str);
        if (this.aOB >= this.aOC) {
            Ct();
        }
        bArr = this.aOA;
        i = this.aOB;
        this.aOB = i + 1;
        bArr[i] = (byte) 34;
    }

    public void writeBoolean(boolean z) throws IOException, JsonGenerationException {
        be("write a boolean value");
        if (this.aOB + 5 >= this.aOC) {
            Ct();
        }
        Object obj = z ? aOx : aOy;
        int length = obj.length;
        System.arraycopy(obj, 0, this.aOA, this.aOB, length);
        this.aOB += length;
    }

    public void zL() throws IOException, JsonGenerationException {
        be("write a null");
        Cs();
    }

    protected final void be(String str) throws IOException {
        int BW = this.aLQ.BW();
        if (BW == 5) {
            aX("Can not " + str + ", expecting field name");
        }
        if (this.aLw == null) {
            byte b;
            switch (BW) {
                case 1:
                    b = (byte) 44;
                    break;
                case 2:
                    b = (byte) 58;
                    break;
                case 3:
                    if (this._rootValueSeparator != null) {
                        byte[] asUnquotedUTF8 = this._rootValueSeparator.asUnquotedUTF8();
                        if (asUnquotedUTF8.length > 0) {
                            m3206V(asUnquotedUTF8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.aOB >= this.aOC) {
                Ct();
            }
            this.aOA[this.aOB] = b;
            this.aOB++;
            return;
        }
        m3244k(str, BW);
    }

    protected final void m3244k(String str, int i) throws IOException {
        switch (i) {
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
        if (this.aOz != null && isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.aOz.flush();
        }
    }

    public void close() throws IOException {
        super.close();
        if (this.aOA != null && isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)) {
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
        this.aOB = 0;
        if (this.aOz != null) {
            if (this.aLS.Bz() || isEnabled(Feature.AUTO_CLOSE_TARGET)) {
                this.aOz.close();
            } else if (isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
                this.aOz.flush();
            }
        }
        AH();
    }

    protected void AH() {
        byte[] bArr = this.aOA;
        if (bArr != null && this.aNX) {
            this.aOA = null;
            this.aLS.m3146T(bArr);
        }
        char[] cArr = this.aOE;
        if (cArr != null) {
            this.aOE = null;
            this.aLS.m3151b(cArr);
        }
    }

    private final void m3206V(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.aOB + length > this.aOC) {
            Ct();
            if (length > 512) {
                this.aOz.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.aOA, this.aOB, length);
        this.aOB = length + this.aOB;
    }

    private final void m3212c(String str, boolean z) throws IOException {
        int i;
        if (z) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            byte[] bArr = this.aOA;
            i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 34;
        }
        i = str.length();
        int i2 = 0;
        while (i > 0) {
            int min = Math.min(this.aOD, i);
            if (this.aOB + min > this.aOC) {
                Ct();
            }
            m3213d(str, i2, min);
            i2 += min;
            i -= min;
        }
        if (z) {
            if (this.aOB >= this.aOC) {
                Ct();
            }
            bArr = this.aOA;
            i = this.aOB;
            this.aOB = i + 1;
            bArr[i] = (byte) 34;
        }
    }

    private final void m3220h(char[] cArr, int i, int i2) throws IOException {
        do {
            int min = Math.min(this.aOD, i2);
            if (this.aOB + min > this.aOC) {
                Ct();
            }
            m3221i(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void m3211c(String str, int i, int i2) throws IOException {
        do {
            int min = Math.min(this.aOD, i2);
            if (this.aOB + min > this.aOC) {
                Ct();
            }
            m3213d(str, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void m3221i(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        while (i < i3) {
            char c = cArr[i];
            if (c > '' || iArr[c] != 0) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) c;
            i++;
            i4 = i5;
        }
        this.aOB = i4;
        if (i >= i3) {
            return;
        }
        if (this._characterEscapes != null) {
            m3224l(cArr, i, i3);
        } else if (this.aOg == 0) {
            m3222j(cArr, i, i3);
        } else {
            m3223k(cArr, i, i3);
        }
    }

    private final void m3213d(String str, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        while (i < i3) {
            char charAt = str.charAt(i);
            if (charAt > '' || iArr[charAt] != 0) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) charAt;
            i++;
            i4 = i5;
        }
        this.aOB = i4;
        if (i >= i3) {
            return;
        }
        if (this._characterEscapes != null) {
            m3217g(str, i, i3);
        } else if (this.aOg == 0) {
            m3214e(str, i, i3);
        } else {
            m3216f(str, i, i3);
        }
    }

    private final void m3222j(char[] cArr, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            int i5;
            if (c > '') {
                if (c <= '߿') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c & 63) | Allocation.USAGE_SHARED);
                } else {
                    i3 = bv(c, i3);
                }
                i = i4;
            } else if (iArr[c] == 0) {
                i5 = i3 + 1;
                bArr[i3] = (byte) c;
                i3 = i5;
                i = i4;
            } else {
                i5 = iArr[c];
                if (i5 > 0) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) 92;
                    i3 = i6 + 1;
                    bArr[i6] = (byte) i5;
                    i = i4;
                } else {
                    i3 = bw(c, i3);
                    i = i4;
                }
            }
        }
        this.aOB = i3;
    }

    private final void m3214e(String str, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            if (charAt > '') {
                if (charAt <= '߿') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((charAt & 63) | Allocation.USAGE_SHARED);
                } else {
                    i3 = bv(charAt, i3);
                }
                i = i4;
            } else if (iArr[charAt] == 0) {
                i5 = i3 + 1;
                bArr[i3] = (byte) charAt;
                i3 = i5;
                i = i4;
            } else {
                i5 = iArr[charAt];
                if (i5 > 0) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) 92;
                    i3 = i6 + 1;
                    bArr[i6] = (byte) i5;
                    i = i4;
                } else {
                    i3 = bw(charAt, i3);
                    i = i4;
                }
            }
        }
        this.aOB = i3;
    }

    private final void m3223k(char[] cArr, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        char c = this.aOg;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            if (c2 <= '') {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = bw(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = bw(c2, i3);
                i = i4;
            } else {
                if (c2 <= '߿') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c2 >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c2 & 63) | Allocation.USAGE_SHARED);
                } else {
                    i3 = bv(c2, i3);
                }
                i = i4;
            }
        }
        this.aOB = i3;
    }

    private final void m3216f(String str, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        char c = this.aOg;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            if (charAt <= '') {
                if (iArr[charAt] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[charAt];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = bw(charAt, i3);
                        i = i4;
                    }
                }
            } else if (charAt > c) {
                i3 = bw(charAt, i3);
                i = i4;
            } else {
                if (charAt <= '߿') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((charAt & 63) | Allocation.USAGE_SHARED);
                } else {
                    i3 = bv(charAt, i3);
                }
                i = i4;
            }
        }
        this.aOB = i3;
    }

    private final void m3224l(char[] cArr, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        char c = this.aOg <= 0 ? '￿' : this.aOg;
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            afc escapeSequence;
            if (c2 <= '') {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        escapeSequence = characterEscapes.getEscapeSequence(c2);
                        if (escapeSequence == null) {
                            aX("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c2) + ", although was supposed to have one");
                        }
                        i3 = m3209a(bArr, i3, escapeSequence, i2 - i4);
                        i = i4;
                    } else {
                        i3 = bw(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = bw(c2, i3);
                i = i4;
            } else {
                escapeSequence = characterEscapes.getEscapeSequence(c2);
                if (escapeSequence != null) {
                    i3 = m3209a(bArr, i3, escapeSequence, i2 - i4);
                    i = i4;
                } else {
                    if (c2 <= '߿') {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) ((c2 >> 6) | 192);
                        i3 = i5 + 1;
                        bArr[i5] = (byte) ((c2 & 63) | Allocation.USAGE_SHARED);
                    } else {
                        i3 = bv(c2, i3);
                    }
                    i = i4;
                }
            }
        }
        this.aOB = i3;
    }

    private final void m3217g(String str, int i, int i2) throws IOException {
        if (this.aOB + ((i2 - i) * 6) > this.aOC) {
            Ct();
        }
        int i3 = this.aOB;
        byte[] bArr = this.aOA;
        int[] iArr = this.aOf;
        char c = this.aOg <= 0 ? '￿' : this.aOg;
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            afc escapeSequence;
            if (charAt <= '') {
                if (iArr[charAt] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[charAt];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        escapeSequence = characterEscapes.getEscapeSequence(charAt);
                        if (escapeSequence == null) {
                            aX("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(charAt) + ", although was supposed to have one");
                        }
                        i3 = m3209a(bArr, i3, escapeSequence, i2 - i4);
                        i = i4;
                    } else {
                        i3 = bw(charAt, i3);
                        i = i4;
                    }
                }
            } else if (charAt > c) {
                i3 = bw(charAt, i3);
                i = i4;
            } else {
                escapeSequence = characterEscapes.getEscapeSequence(charAt);
                if (escapeSequence != null) {
                    i3 = m3209a(bArr, i3, escapeSequence, i2 - i4);
                    i = i4;
                } else {
                    if (charAt <= '߿') {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) ((charAt >> 6) | 192);
                        i3 = i5 + 1;
                        bArr[i5] = (byte) ((charAt & 63) | Allocation.USAGE_SHARED);
                    } else {
                        i3 = bv(charAt, i3);
                    }
                    i = i4;
                }
            }
        }
        this.aOB = i3;
    }

    private final int m3209a(byte[] bArr, int i, afc com_fossil_afc, int i2) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = com_fossil_afc.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length > 6) {
            return m3208a(bArr, i, this.aOC, asUnquotedUTF8, i2);
        }
        System.arraycopy(asUnquotedUTF8, 0, bArr, i, length);
        return length + i;
    }

    private final int m3208a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException, JsonGenerationException {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this.aOB = i;
            Ct();
            i4 = this.aOB;
            if (length > bArr.length) {
                this.aOz.write(bArr2, 0, length);
                return i4;
            }
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 <= i2) {
            return i4;
        }
        Ct();
        return this.aOB;
    }

    protected final void m3235b(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
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
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i5] & 255) | i6) << 8) | (bArr[i7] & 255), this.aOA, this.aOB);
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.aOA;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr2[i5] = (byte) 92;
                bArr2 = this.aOA;
                i5 = this.aOB;
                this.aOB = i5 + 1;
                bArr2[i5] = (byte) 110;
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
            this.aOB = base64Variant.encodeBase64Partial(maxLineLength, i3, this.aOA, this.aOB);
        }
    }

    protected final int m3229a(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException, JsonGenerationException {
        int i2 = 0;
        int i3 = 0;
        int i4 = -3;
        int i5 = this.aOC - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i6 = i;
        while (i6 > 2) {
            if (i2 > i4) {
                i3 = m3207a(inputStream, bArr, i2, i3, i6);
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
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i7] & 255) | i8) << 8) | (bArr[i9] & 255), this.aOA, this.aOB);
            i7 = maxLineLength - 1;
            if (i7 <= 0) {
                byte[] bArr2 = this.aOA;
                i8 = this.aOB;
                this.aOB = i8 + 1;
                bArr2[i8] = (byte) 92;
                bArr2 = this.aOA;
                i8 = this.aOB;
                this.aOB = i8 + 1;
                bArr2[i8] = (byte) 110;
                i7 = base64Variant.getMaxLineLength() >> 2;
            }
            maxLineLength = i7;
        }
        if (i6 <= 0) {
            return i6;
        }
        i4 = m3207a(inputStream, bArr, i2, i3, i6);
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
        this.aOB = base64Variant.encodeBase64Partial(i7, i4, this.aOA, this.aOB);
        return i6 - i4;
    }

    protected final int m3228a(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException, JsonGenerationException {
        int i = -3;
        int i2 = this.aOC - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 > i) {
                i4 = m3207a(inputStream, bArr, i5, i4, bArr.length);
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
            this.aOB = base64Variant.encodeBase64Chunk((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.aOA, this.aOB);
            i6 = maxLineLength - 1;
            if (i6 <= 0) {
                byte[] bArr2 = this.aOA;
                i7 = this.aOB;
                this.aOB = i7 + 1;
                bArr2[i7] = (byte) 92;
                bArr2 = this.aOA;
                i7 = this.aOB;
                this.aOB = i7 + 1;
                bArr2[i7] = (byte) 110;
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
        this.aOB = base64Variant.encodeBase64Partial(i6, i, this.aOA, this.aOB);
        return i7;
    }

    private final int m3207a(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
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

    private final int m3210b(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i < 55296 || i > 57343) {
            byte[] bArr = this.aOA;
            int i4 = this.aOB;
            this.aOB = i4 + 1;
            bArr[i4] = (byte) ((i >> 12) | 224);
            i4 = this.aOB;
            this.aOB = i4 + 1;
            bArr[i4] = (byte) (((i >> 6) & 63) | Allocation.USAGE_SHARED);
            i4 = this.aOB;
            this.aOB = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | Allocation.USAGE_SHARED);
            return i2;
        }
        if (i2 >= i3 || cArr == null) {
            aX("Split surrogate on writeRaw() input (last character)");
        }
        bu(i, cArr[i2]);
        return i2 + 1;
    }

    protected final void bu(int i, int i2) throws IOException {
        int bp = bp(i, i2);
        if (this.aOB + 4 > this.aOC) {
            Ct();
        }
        byte[] bArr = this.aOA;
        int i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) ((bp >> 18) | 240);
        i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) (((bp >> 12) & 63) | Allocation.USAGE_SHARED);
        i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) (((bp >> 6) & 63) | Allocation.USAGE_SHARED);
        i3 = this.aOB;
        this.aOB = i3 + 1;
        bArr[i3] = (byte) ((bp & 63) | Allocation.USAGE_SHARED);
    }

    private final int bv(int i, int i2) throws IOException {
        byte[] bArr = this.aOA;
        if (i < 55296 || i > 57343) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 12) | 224);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((i >> 6) & 63) | Allocation.USAGE_SHARED);
            i3 = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | Allocation.USAGE_SHARED);
            return i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        i3 = i4 + 1;
        bArr[i4] = aOv[(i >> 12) & 15];
        i4 = i3 + 1;
        bArr[i3] = aOv[(i >> 8) & 15];
        int i5 = i4 + 1;
        bArr[i4] = aOv[(i >> 4) & 15];
        i3 = i5 + 1;
        bArr[i5] = aOv[i & 15];
        return i3;
    }

    private final void Cs() throws IOException {
        if (this.aOB + 4 >= this.aOC) {
            Ct();
        }
        System.arraycopy(aOw, 0, this.aOA, this.aOB, 4);
        this.aOB += 4;
    }

    private int bw(int i, int i2) throws IOException {
        byte[] bArr = this.aOA;
        int i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        int i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        int i5;
        if (i > 255) {
            i5 = (i >> 8) & 255;
            int i6 = i4 + 1;
            bArr[i4] = aOv[i5 >> 4];
            i3 = i6 + 1;
            bArr[i6] = aOv[i5 & 15];
            i &= 255;
        } else {
            i5 = i4 + 1;
            bArr[i4] = (byte) 48;
            i3 = i5 + 1;
            bArr[i5] = (byte) 48;
        }
        i4 = i3 + 1;
        bArr[i3] = aOv[i >> 4];
        i3 = i4 + 1;
        bArr[i4] = aOv[i & 15];
        return i3;
    }

    protected final void Ct() throws IOException {
        int i = this.aOB;
        if (i > 0) {
            this.aOB = 0;
            this.aOz.write(this.aOA, 0, i);
        }
    }
}
