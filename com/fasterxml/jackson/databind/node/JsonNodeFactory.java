package com.fasterxml.jackson.databind.node;

import com.fossil.akh;
import com.fossil.akj;
import com.fossil.akk;
import com.fossil.akl;
import com.fossil.akn;
import com.fossil.ako;
import com.fossil.akp;
import com.fossil.akq;
import com.fossil.akr;
import com.fossil.akt;
import com.fossil.aku;
import com.fossil.akv;
import com.fossil.akw;
import com.fossil.akx;
import com.fossil.aky;
import com.fossil.ala;
import com.fossil.amr;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNodeFactory implements Serializable {
    private static final JsonNodeFactory aTM = new JsonNodeFactory(false);
    private static final JsonNodeFactory aTN = new JsonNodeFactory(true);
    public static final JsonNodeFactory instance = aTM;
    private static final long serialVersionUID = 1;
    private final boolean _cfgBigDecimalExact;

    public JsonNodeFactory(boolean z) {
        this._cfgBigDecimalExact = z;
    }

    protected JsonNodeFactory() {
        this(false);
    }

    public static JsonNodeFactory withExactBigDecimals(boolean z) {
        return z ? aTN : aTM;
    }

    public akl booleanNode(boolean z) {
        return z ? akl.Gl() : akl.Gm();
    }

    public akt nullNode() {
        return akt.Gs();
    }

    public aku numberNode(byte b) {
        return akq.gT(b);
    }

    public ala numberNode(Byte b) {
        return b == null ? nullNode() : akq.gT(b.intValue());
    }

    public aku numberNode(short s) {
        return akx.m3677h(s);
    }

    public ala numberNode(Short sh) {
        return sh == null ? nullNode() : akx.m3677h(sh.shortValue());
    }

    public aku numberNode(int i) {
        return akq.gT(i);
    }

    public ala numberNode(Integer num) {
        return num == null ? nullNode() : akq.gT(num.intValue());
    }

    public aku numberNode(long j) {
        return akr.m3668M(j);
    }

    public ala numberNode(Long l) {
        if (l == null) {
            return nullNode();
        }
        return akr.m3668M(l.longValue());
    }

    public aku numberNode(BigInteger bigInteger) {
        return akj.m3662b(bigInteger);
    }

    public aku numberNode(float f) {
        return akp.m3667U(f);
    }

    public ala numberNode(Float f) {
        return f == null ? nullNode() : akp.m3667U(f.floatValue());
    }

    public aku numberNode(double d) {
        return ako.m3666e(d);
    }

    public ala numberNode(Double d) {
        return d == null ? nullNode() : ako.m3666e(d.doubleValue());
    }

    public aku numberNode(BigDecimal bigDecimal) {
        if (this._cfgBigDecimalExact) {
            return akn.m3665b(bigDecimal);
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) == 0 ? akn.aTC : akn.m3665b(bigDecimal.stripTrailingZeros());
    }

    public aky textNode(String str) {
        return aky.bX(str);
    }

    public akk binaryNode(byte[] bArr) {
        return akk.m3663W(bArr);
    }

    public akk binaryNode(byte[] bArr, int i, int i2) {
        return akk.m3664f(bArr, i, i2);
    }

    public akh arrayNode() {
        return new akh(this);
    }

    public akv objectNode() {
        return new akv(this);
    }

    public ala pojoNode(Object obj) {
        return new akw(obj);
    }

    public ala rawValueNode(amr com_fossil_amr) {
        return new akw(com_fossil_amr);
    }

    protected boolean _inIntRange(long j) {
        return ((long) ((int) j)) == j;
    }
}
