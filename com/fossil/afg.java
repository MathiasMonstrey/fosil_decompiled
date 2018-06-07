package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class afg extends afh {
    static final BigInteger aMi = BigInteger.valueOf(-2147483648L);
    static final BigInteger aMj = BigInteger.valueOf(2147483647L);
    static final BigInteger aMk = BigInteger.valueOf(Long.MIN_VALUE);
    static final BigInteger aMl = BigInteger.valueOf(ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD);
    static final BigDecimal aMm = new BigDecimal(aMk);
    static final BigDecimal aMn = new BigDecimal(aMl);
    static final BigDecimal aMo = new BigDecimal(aMi);
    static final BigDecimal aMp = new BigDecimal(aMj);
    protected boolean aLR;
    protected final afo aLS;
    protected int aLT = 0;
    protected int aLU = 0;
    protected long aLV = 0;
    protected int aLW = 1;
    protected int aLX = 0;
    protected long aLY = 0;
    protected int aLZ = 1;
    protected int aMa = 0;
    protected afz aMb;
    protected JsonToken aMc;
    protected final agr aMd;
    protected char[] aMe = null;
    protected boolean aMf = false;
    protected agn aMg = null;
    protected byte[] aMh;
    protected int aMq = 0;
    protected int aMr;
    protected long aMs;
    protected double aMt;
    protected BigInteger aMu;
    protected BigDecimal aMv;
    protected boolean aMw;
    protected int aMx;
    protected int aMy;
    protected int aMz;

    protected abstract boolean AN() throws IOException;

    protected abstract void AO() throws IOException;

    protected abstract void AP() throws IOException;

    public /* synthetic */ aez zX() {
        return AI();
    }

    protected afg(afo com_fossil_afo, int i) {
        afx com_fossil_afx = null;
        super(i);
        this.aLS = com_fossil_afo;
        this.aMd = com_fossil_afo.BA();
        if (Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i)) {
            com_fossil_afx = afx.m3181d(this);
        }
        this.aMb = afz.m3186b(com_fossil_afx);
    }

    public void bm(Object obj) {
        this.aMb.bm(obj);
    }

    public JsonParser mo887a(Feature feature) {
        this.aLy |= feature.getMask();
        if (feature == Feature.STRICT_DUPLICATE_DETECTION && this.aMb.BR() == null) {
            this.aMb = this.aMb.m3187a(afx.m3181d(this));
        }
        return this;
    }

    public JsonParser fm(int i) {
        if ((this.aLy ^ i) != 0) {
            this.aLy = i;
            if (!Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i)) {
                this.aMb = this.aMb.m3187a(null);
            } else if (this.aMb.BR() == null) {
                this.aMb = this.aMb.m3187a(afx.m3181d(this));
            }
        }
        return this;
    }

    public String zW() throws IOException {
        if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
            return this.aMb.BQ().zW();
        }
        return this.aMb.zW();
    }

    public void close() throws IOException {
        if (!this.aLR) {
            this.aLR = true;
            try {
                AP();
            } finally {
                AH();
            }
        }
    }

    public afz AI() {
        return this.aMb;
    }

    public JsonLocation zY() {
        return new JsonLocation(this.aLS.Bx(), -1, AJ(), AK(), AL());
    }

    public JsonLocation zZ() {
        return new JsonLocation(this.aLS.Bx(), -1, this.aLV + ((long) this.aLT), this.aLW, (this.aLT - this.aLX) + 1);
    }

    public boolean Ag() {
        if (this.aMA == JsonToken.VALUE_STRING) {
            return true;
        }
        if (this.aMA == JsonToken.FIELD_NAME) {
            return this.aMf;
        }
        return false;
    }

    public Object Aq() throws IOException {
        return null;
    }

    public long AJ() {
        return this.aLY;
    }

    public int AK() {
        return this.aLZ;
    }

    public int AL() {
        int i = this.aMa;
        return i < 0 ? i : i + 1;
    }

    protected final void AM() throws IOException {
        if (!AN()) {
            Bc();
        }
    }

    protected void AH() throws IOException {
        this.aMd.CW();
        char[] cArr = this.aMe;
        if (cArr != null) {
            this.aMe = null;
            this.aLS.m3153c(cArr);
        }
    }

    protected void AQ() throws JsonParseException {
        if (!this.aMb.AB()) {
            bg(": expected close marker for " + this.aMb.AD() + " (from " + this.aMb.bs(this.aLS.Bx()) + ")");
        }
    }

    protected final int AR() throws JsonParseException {
        AQ();
        return -1;
    }

    protected void m3121a(int i, char c) throws JsonParseException {
        aX("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.aMb.AD() + " starting at " + ("" + this.aMb.bs(this.aLS.Bx())) + ")");
    }

    public agn AS() {
        if (this.aMg == null) {
            this.aMg = new agn();
        } else {
            this.aMg.reset();
        }
        return this.aMg;
    }

    protected final JsonToken m3119a(boolean z, int i, int i2, int i3) {
        if (i2 >= 1 || i3 >= 1) {
            return m3122b(z, i, i2, i3);
        }
        return m3124c(z, i);
    }

    protected final JsonToken m3124c(boolean z, int i) {
        this.aMw = z;
        this.aMx = i;
        this.aMy = 0;
        this.aMz = 0;
        this.aMq = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    protected final JsonToken m3122b(boolean z, int i, int i2, int i3) {
        this.aMw = z;
        this.aMx = i;
        this.aMy = i2;
        this.aMz = i3;
        this.aMq = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken m3118a(String str, double d) {
        this.aMd.bB(str);
        this.aMt = d;
        this.aMq = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public Number Ah() throws IOException {
        if (this.aMq == 0) {
            fq(0);
        }
        if (this.aMA == JsonToken.VALUE_NUMBER_INT) {
            if ((this.aMq & 1) != 0) {
                return Integer.valueOf(this.aMr);
            }
            if ((this.aMq & 2) != 0) {
                return Long.valueOf(this.aMs);
            }
            if ((this.aMq & 4) != 0) {
                return this.aMu;
            }
            return this.aMv;
        } else if ((this.aMq & 16) != 0) {
            return this.aMv;
        } else {
            if ((this.aMq & 8) == 0) {
                zN();
            }
            return Double.valueOf(this.aMt);
        }
    }

    public NumberType Ai() throws IOException {
        if (this.aMq == 0) {
            fq(0);
        }
        if (this.aMA == JsonToken.VALUE_NUMBER_INT) {
            if ((this.aMq & 1) != 0) {
                return NumberType.INT;
            }
            if ((this.aMq & 2) != 0) {
                return NumberType.LONG;
            }
            return NumberType.BIG_INTEGER;
        } else if ((this.aMq & 16) != 0) {
            return NumberType.BIG_DECIMAL;
        } else {
            return NumberType.DOUBLE;
        }
    }

    public int getIntValue() throws IOException {
        if ((this.aMq & 1) == 0) {
            if (this.aMq == 0) {
                return AT();
            }
            if ((this.aMq & 1) == 0) {
                AU();
            }
        }
        return this.aMr;
    }

    public long Al() throws IOException {
        if ((this.aMq & 2) == 0) {
            if (this.aMq == 0) {
                fq(2);
            }
            if ((this.aMq & 2) == 0) {
                AV();
            }
        }
        return this.aMs;
    }

    public BigInteger Am() throws IOException {
        if ((this.aMq & 4) == 0) {
            if (this.aMq == 0) {
                fq(4);
            }
            if ((this.aMq & 4) == 0) {
                AW();
            }
        }
        return this.aMu;
    }

    public float An() throws IOException {
        return (float) Ao();
    }

    public double Ao() throws IOException {
        if ((this.aMq & 8) == 0) {
            if (this.aMq == 0) {
                fq(8);
            }
            if ((this.aMq & 8) == 0) {
                AX();
            }
        }
        return this.aMt;
    }

    public BigDecimal Ap() throws IOException {
        if ((this.aMq & 16) == 0) {
            if (this.aMq == 0) {
                fq(16);
            }
            if ((this.aMq & 16) == 0) {
                AY();
            }
        }
        return this.aMv;
    }

    protected void fq(int i) throws IOException {
        if (this.aMA == JsonToken.VALUE_NUMBER_INT) {
            char[] CZ = this.aMd.CZ();
            int Af = this.aMd.Af();
            int i2 = this.aMx;
            if (this.aMw) {
                Af++;
            }
            if (i2 <= 9) {
                Af = afr.m3159c(CZ, Af, i2);
                if (this.aMw) {
                    Af = -Af;
                }
                this.aMr = Af;
                this.aMq = 1;
            } else if (i2 <= 18) {
                long d = afr.m3161d(CZ, Af, i2);
                if (this.aMw) {
                    d = -d;
                }
                if (i2 == 10) {
                    if (this.aMw) {
                        if (d >= -2147483648L) {
                            this.aMr = (int) d;
                            this.aMq = 1;
                            return;
                        }
                    } else if (d <= 2147483647L) {
                        this.aMr = (int) d;
                        this.aMq = 1;
                        return;
                    }
                }
                this.aMs = d;
                this.aMq = 2;
            } else {
                m3114a(i, CZ, Af, i2);
            }
        } else if (this.aMA == JsonToken.VALUE_NUMBER_FLOAT) {
            fr(i);
        } else {
            aX("Current token (" + this.aMA + ") not numeric, can not use numeric value accessors");
        }
    }

    protected int AT() throws IOException {
        if (this.aMA == JsonToken.VALUE_NUMBER_INT) {
            char[] CZ = this.aMd.CZ();
            int Af = this.aMd.Af();
            int i = this.aMx;
            if (this.aMw) {
                Af++;
            }
            if (i <= 9) {
                Af = afr.m3159c(CZ, Af, i);
                if (this.aMw) {
                    Af = -Af;
                }
                this.aMr = Af;
                this.aMq = 1;
                return Af;
            }
        }
        fq(1);
        if ((this.aMq & 1) == 0) {
            AU();
        }
        return this.aMr;
    }

    private void fr(int i) throws IOException {
        if (i == 16) {
            try {
                this.aMv = this.aMd.Dc();
                this.aMq = 16;
                return;
            } catch (Throwable e) {
                m3108a("Malformed numeric value '" + this.aMd.Da() + "'", e);
                return;
            }
        }
        this.aMt = this.aMd.Dd();
        this.aMq = 8;
    }

    private void m3114a(int i, char[] cArr, int i2, int i3) throws IOException {
        String Da = this.aMd.Da();
        try {
            if (afr.m3157a(cArr, i2, i3, this.aMw)) {
                this.aMs = Long.parseLong(Da);
                this.aMq = 2;
                return;
            }
            this.aMu = new BigInteger(Da);
            this.aMq = 4;
        } catch (Throwable e) {
            m3108a("Malformed numeric value '" + Da + "'", e);
        }
    }

    protected void AU() throws IOException {
        if ((this.aMq & 2) != 0) {
            int i = (int) this.aMs;
            if (((long) i) != this.aMs) {
                aX("Numeric value (" + getText() + ") out of range of int");
            }
            this.aMr = i;
        } else if ((this.aMq & 4) != 0) {
            if (aMi.compareTo(this.aMu) > 0 || aMj.compareTo(this.aMu) < 0) {
                AZ();
            }
            this.aMr = this.aMu.intValue();
        } else if ((this.aMq & 8) != 0) {
            if (this.aMt < -2.147483648E9d || this.aMt > 2.147483647E9d) {
                AZ();
            }
            this.aMr = (int) this.aMt;
        } else if ((this.aMq & 16) != 0) {
            if (aMo.compareTo(this.aMv) > 0 || aMp.compareTo(this.aMv) < 0) {
                AZ();
            }
            this.aMr = this.aMv.intValue();
        } else {
            zN();
        }
        this.aMq |= 1;
    }

    protected void AV() throws IOException {
        if ((this.aMq & 1) != 0) {
            this.aMs = (long) this.aMr;
        } else if ((this.aMq & 4) != 0) {
            if (aMk.compareTo(this.aMu) > 0 || aMl.compareTo(this.aMu) < 0) {
                Ba();
            }
            this.aMs = this.aMu.longValue();
        } else if ((this.aMq & 8) != 0) {
            if (this.aMt < -9.223372036854776E18d || this.aMt > 9.223372036854776E18d) {
                Ba();
            }
            this.aMs = (long) this.aMt;
        } else if ((this.aMq & 16) != 0) {
            if (aMm.compareTo(this.aMv) > 0 || aMn.compareTo(this.aMv) < 0) {
                Ba();
            }
            this.aMs = this.aMv.longValue();
        } else {
            zN();
        }
        this.aMq |= 2;
    }

    protected void AW() throws IOException {
        if ((this.aMq & 16) != 0) {
            this.aMu = this.aMv.toBigInteger();
        } else if ((this.aMq & 2) != 0) {
            this.aMu = BigInteger.valueOf(this.aMs);
        } else if ((this.aMq & 1) != 0) {
            this.aMu = BigInteger.valueOf((long) this.aMr);
        } else if ((this.aMq & 8) != 0) {
            this.aMu = BigDecimal.valueOf(this.aMt).toBigInteger();
        } else {
            zN();
        }
        this.aMq |= 4;
    }

    protected void AX() throws IOException {
        if ((this.aMq & 16) != 0) {
            this.aMt = this.aMv.doubleValue();
        } else if ((this.aMq & 4) != 0) {
            this.aMt = this.aMu.doubleValue();
        } else if ((this.aMq & 2) != 0) {
            this.aMt = (double) this.aMs;
        } else if ((this.aMq & 1) != 0) {
            this.aMt = (double) this.aMr;
        } else {
            zN();
        }
        this.aMq |= 8;
    }

    protected void AY() throws IOException {
        if ((this.aMq & 8) != 0) {
            this.aMv = afr.bm(getText());
        } else if ((this.aMq & 4) != 0) {
            this.aMv = new BigDecimal(this.aMu);
        } else if ((this.aMq & 2) != 0) {
            this.aMv = BigDecimal.valueOf(this.aMs);
        } else if ((this.aMq & 1) != 0) {
            this.aMv = BigDecimal.valueOf((long) this.aMr);
        } else {
            zN();
        }
        this.aMq |= 16;
    }

    protected void m3125g(int i, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + afh.fu(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        aX(str2);
    }

    protected void bf(String str) throws JsonParseException {
        aX("Invalid numeric value: " + str);
    }

    protected void AZ() throws IOException {
        aX("Numeric value (" + getText() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
    }

    protected void Ba() throws IOException {
        aX("Numeric value (" + getText() + ") out of range of long (" + Long.MIN_VALUE + " - " + ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD + ")");
    }

    protected char Bb() throws IOException {
        throw new UnsupportedOperationException();
    }

    protected final int m3116a(Base64Variant base64Variant, int i, int i2) throws IOException {
        if (i != 92) {
            throw m3123b(base64Variant, i, i2);
        }
        int Bb = Bb();
        if (Bb <= ' ' && i2 == 0) {
            return -1;
        }
        int decodeBase64Char = base64Variant.decodeBase64Char(Bb);
        if (decodeBase64Char >= 0) {
            return decodeBase64Char;
        }
        throw m3123b(base64Variant, Bb, i2);
    }

    protected final int m3115a(Base64Variant base64Variant, char c, int i) throws IOException {
        if (c != '\\') {
            throw m3123b(base64Variant, c, i);
        }
        char Bb = Bb();
        if (Bb <= ' ' && i == 0) {
            return -1;
        }
        int decodeBase64Char = base64Variant.decodeBase64Char(Bb);
        if (decodeBase64Char >= 0) {
            return decodeBase64Char;
        }
        throw m3123b(base64Variant, Bb, i);
    }

    protected IllegalArgumentException m3123b(Base64Variant base64Variant, int i, int i2) throws IllegalArgumentException {
        return m3120a(base64Variant, i, i2, null);
    }

    protected IllegalArgumentException m3120a(Base64Variant base64Variant, int i, int i2, String str) throws IllegalArgumentException {
        String str2;
        if (i <= 32) {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(i) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(i)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }
}
