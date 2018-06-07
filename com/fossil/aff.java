package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import java.io.IOException;
import java.io.InputStream;

public abstract class aff extends JsonGenerator {
    protected static final int aLI = ((Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | Feature.ESCAPE_NON_ASCII.getMask()) | Feature.STRICT_DUPLICATE_DETECTION.getMask());
    protected afa _objectCodec;
    protected final String aLJ = "write a binary value";
    protected final String aLK = "write a boolean value";
    protected final String aLL = "write a null";
    protected final String aLM = "write a number";
    protected final String aLN = "write a raw (unencoded) value";
    protected final String aLO = "write a string";
    protected boolean aLP;
    protected aga aLQ;
    protected boolean aLR;
    protected int aLy;

    protected abstract void AH();

    protected abstract void be(String str) throws IOException;

    public /* synthetic */ aez zM() {
        return AG();
    }

    protected aff(int i, afa com_fossil_afa) {
        this.aLy = i;
        this._objectCodec = com_fossil_afa;
        this.aLQ = aga.m3190d(Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? afx.m3180a(this) : null);
        this.aLP = Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
    }

    public void bm(Object obj) {
        this.aLQ.bm(obj);
    }

    public final boolean isEnabled(Feature feature) {
        return (this.aLy & feature.getMask()) != 0;
    }

    public int zB() {
        return this.aLy;
    }

    public JsonGenerator mo848a(Feature feature) {
        int mask = feature.getMask();
        this.aLy &= mask ^ -1;
        if ((mask & aLI) != 0) {
            if (feature == Feature.WRITE_NUMBERS_AS_STRINGS) {
                this.aLP = false;
            } else if (feature == Feature.ESCAPE_NON_ASCII) {
                fj(0);
            } else if (feature == Feature.STRICT_DUPLICATE_DETECTION) {
                this.aLQ = this.aLQ.m3192c(null);
            }
        }
        return this;
    }

    public JsonGenerator fi(int i) {
        int i2 = this.aLy ^ i;
        this.aLy = i;
        if ((aLI & i2) != 0) {
            this.aLP = Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
            if (Feature.ESCAPE_NON_ASCII.enabledIn(i2)) {
                if (Feature.ESCAPE_NON_ASCII.enabledIn(i)) {
                    fj(127);
                } else {
                    fj(0);
                }
            }
            if (Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i2)) {
                if (!Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i)) {
                    this.aLQ = this.aLQ.m3192c(null);
                } else if (this.aLQ.BR() == null) {
                    this.aLQ = this.aLQ.m3192c(afx.m3180a(this));
                }
            }
        }
        return this;
    }

    public final aga AG() {
        return this.aLQ;
    }

    public void mo850b(afc com_fossil_afc) throws IOException {
        aQ(com_fossil_afc.getValue());
    }

    public void mo852c(afc com_fossil_afc) throws IOException {
        writeString(com_fossil_afc.getValue());
    }

    public void aS(String str) throws IOException {
        be("write raw value");
        aR(str);
    }

    public void mo854e(afc com_fossil_afc) throws IOException {
        be("write raw value");
        mo946d(com_fossil_afc);
    }

    public int mo847a(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        zO();
        return 0;
    }

    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            zL();
        } else if (this._objectCodec != null) {
            this._objectCodec.writeValue(this, obj);
        } else {
            bq(obj);
        }
    }

    public void close() throws IOException {
        this.aLR = true;
    }

    protected final int bp(int i, int i2) throws IOException {
        if (i2 < 56320 || i2 > 57343) {
            aX("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return (NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10)) + (i2 - 56320);
    }
}
