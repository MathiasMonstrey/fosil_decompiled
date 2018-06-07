package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

public class amt extends JsonGenerator {
    protected static final int aWh = Feature.collectDefaults();
    protected int _generatorFeatures;
    protected afa _objectCodec;
    protected aga aLQ;
    protected boolean aLR;
    protected boolean aWi;
    protected boolean aWj;
    protected boolean aWk;
    protected C1712b aWl;
    protected C1712b aWm;
    protected int aWn;
    protected Object aWo;
    protected Object aWp;
    protected boolean aWq = false;

    public static final class C1711a extends afh {
        protected JsonLocation _location = null;
        protected boolean aLR;
        protected afz aMb;
        protected final boolean aWi;
        protected final boolean aWj;
        protected afa aWr;
        protected final boolean aWs;
        protected C1712b aWt;
        protected int aWu;
        protected transient agn aWv;

        public C1711a(C1712b c1712b, afa com_fossil_afa, boolean z, boolean z2) {
            super(0);
            this.aWt = c1712b;
            this.aWu = -1;
            this.aWr = com_fossil_afa;
            this.aMb = afz.m3186b(null);
            this.aWi = z;
            this.aWj = z2;
            this.aWs = z | z2;
        }

        public void m3900a(JsonLocation jsonLocation) {
            this._location = jsonLocation;
        }

        public afa getCodec() {
            return this.aWr;
        }

        public void close() throws IOException {
            if (!this.aLR) {
                this.aLR = true;
            }
        }

        public JsonToken zP() throws IOException {
            if (this.aLR || this.aWt == null) {
                return null;
            }
            int i = this.aWu + 1;
            this.aWu = i;
            if (i >= 16) {
                this.aWu = 0;
                this.aWt = this.aWt.Hy();
                if (this.aWt == null) {
                    return null;
                }
            }
            this.aMA = this.aWt.hc(this.aWu);
            if (this.aMA == JsonToken.FIELD_NAME) {
                Object Hw = Hw();
                this.aMb.bq(Hw instanceof String ? (String) Hw : Hw.toString());
            } else if (this.aMA == JsonToken.START_OBJECT) {
                this.aMb = this.aMb.bt(-1, -1);
            } else if (this.aMA == JsonToken.START_ARRAY) {
                this.aMb = this.aMb.bs(-1, -1);
            } else if (this.aMA == JsonToken.END_OBJECT || this.aMA == JsonToken.END_ARRAY) {
                this.aMb = this.aMb.BQ();
                if (this.aMb == null) {
                    this.aMb = afz.m3186b(null);
                }
            }
            return this.aMA;
        }

        public String zR() throws IOException {
            if (this.aLR || this.aWt == null) {
                return null;
            }
            int i = this.aWu + 1;
            if (i < 16 && this.aWt.hc(i) == JsonToken.FIELD_NAME) {
                this.aWu = i;
                Object obj = this.aWt.get(i);
                String obj2 = obj instanceof String ? (String) obj : obj.toString();
                this.aMb.bq(obj2);
                return obj2;
            } else if (zP() == JsonToken.FIELD_NAME) {
                return zW();
            } else {
                return null;
            }
        }

        public aez zX() {
            return this.aMb;
        }

        public JsonLocation zY() {
            return zZ();
        }

        public JsonLocation zZ() {
            return this._location == null ? JsonLocation.NA : this._location;
        }

        public String zW() {
            if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
                return this.aMb.BQ().zW();
            }
            return this.aMb.zW();
        }

        public String getText() {
            Object Hw;
            if (this.aMA == JsonToken.VALUE_STRING || this.aMA == JsonToken.FIELD_NAME) {
                Hw = Hw();
                if (Hw instanceof String) {
                    return (String) Hw;
                }
                return Hw == null ? null : Hw.toString();
            } else if (this.aMA == null) {
                return null;
            } else {
                switch (this.aMA) {
                    case VALUE_NUMBER_INT:
                    case VALUE_NUMBER_FLOAT:
                        Hw = Hw();
                        if (Hw != null) {
                            return Hw.toString();
                        }
                        return null;
                    default:
                        return this.aMA.asString();
                }
            }
        }

        public char[] Ad() {
            String text = getText();
            return text == null ? null : text.toCharArray();
        }

        public int Ae() {
            String text = getText();
            return text == null ? 0 : text.length();
        }

        public int Af() {
            return 0;
        }

        public boolean Ag() {
            return false;
        }

        public BigInteger Am() throws IOException, JsonParseException {
            Number Ah = Ah();
            if (Ah instanceof BigInteger) {
                return (BigInteger) Ah;
            }
            if (Ai() == NumberType.BIG_DECIMAL) {
                return ((BigDecimal) Ah).toBigInteger();
            }
            return BigInteger.valueOf(Ah.longValue());
        }

        public BigDecimal Ap() throws IOException, JsonParseException {
            Number Ah = Ah();
            if (Ah instanceof BigDecimal) {
                return (BigDecimal) Ah;
            }
            switch (Ai()) {
                case INT:
                case LONG:
                    return BigDecimal.valueOf(Ah.longValue());
                case BIG_INTEGER:
                    return new BigDecimal((BigInteger) Ah);
                default:
                    return BigDecimal.valueOf(Ah.doubleValue());
            }
        }

        public double Ao() throws IOException, JsonParseException {
            return Ah().doubleValue();
        }

        public float An() throws IOException, JsonParseException {
            return Ah().floatValue();
        }

        public int getIntValue() throws IOException, JsonParseException {
            if (this.aMA == JsonToken.VALUE_NUMBER_INT) {
                return ((Number) Hw()).intValue();
            }
            return Ah().intValue();
        }

        public long Al() throws IOException, JsonParseException {
            return Ah().longValue();
        }

        public NumberType Ai() throws IOException, JsonParseException {
            Number Ah = Ah();
            if (Ah instanceof Integer) {
                return NumberType.INT;
            }
            if (Ah instanceof Long) {
                return NumberType.LONG;
            }
            if (Ah instanceof Double) {
                return NumberType.DOUBLE;
            }
            if (Ah instanceof BigDecimal) {
                return NumberType.BIG_DECIMAL;
            }
            if (Ah instanceof BigInteger) {
                return NumberType.BIG_INTEGER;
            }
            if (Ah instanceof Float) {
                return NumberType.FLOAT;
            }
            if (Ah instanceof Short) {
                return NumberType.INT;
            }
            return null;
        }

        public final Number Ah() throws IOException, JsonParseException {
            Hx();
            Object Hw = Hw();
            if (Hw instanceof Number) {
                return (Number) Hw;
            }
            if (Hw instanceof String) {
                String str = (String) Hw;
                if (str.indexOf(46) >= 0) {
                    return Double.valueOf(Double.parseDouble(str));
                }
                return Long.valueOf(Long.parseLong(str));
            } else if (Hw == null) {
                return null;
            } else {
                throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + Hw.getClass().getName());
            }
        }

        public Object Aq() {
            if (this.aMA == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return Hw();
            }
            return null;
        }

        public byte[] mo906a(Base64Variant base64Variant) throws IOException, JsonParseException {
            if (this.aMA == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object Hw = Hw();
                if (Hw instanceof byte[]) {
                    return (byte[]) Hw;
                }
            }
            if (this.aMA != JsonToken.VALUE_STRING) {
                throw aZ("Current token (" + this.aMA + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
            }
            String text = getText();
            if (text == null) {
                return null;
            }
            agn com_fossil_agn = this.aWv;
            if (com_fossil_agn == null) {
                com_fossil_agn = new agn(100);
                this.aWv = com_fossil_agn;
            } else {
                this.aWv.reset();
            }
            m3107a(text, com_fossil_agn, base64Variant);
            return com_fossil_agn.toByteArray();
        }

        public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException, JsonParseException {
            byte[] a = mo906a(base64Variant);
            if (a == null) {
                return 0;
            }
            outputStream.write(a, 0, a.length);
            return a.length;
        }

        public boolean Av() {
            return this.aWj;
        }

        public boolean Aw() {
            return this.aWi;
        }

        public Object Ay() {
            return this.aWt.he(this.aWu);
        }

        public Object Ax() {
            return this.aWt.hd(this.aWu);
        }

        protected final Object Hw() {
            return this.aWt.get(this.aWu);
        }

        protected final void Hx() throws JsonParseException {
            if (this.aMA == null || !this.aMA.isNumeric()) {
                throw aZ("Current token (" + this.aMA + ") not numeric, can not use numeric value accessors");
            }
        }

        protected void AQ() throws JsonParseException {
            zN();
        }
    }

    public static final class C1712b {
        private static final JsonToken[] aWw = new JsonToken[16];
        protected TreeMap<Integer, Object> aWA;
        protected C1712b aWx;
        protected long aWy;
        protected final Object[] aWz = new Object[16];

        static {
            Object values = JsonToken.values();
            System.arraycopy(values, 1, aWw, 1, Math.min(15, values.length - 1));
        }

        public JsonToken hc(int i) {
            long j = this.aWy;
            if (i > 0) {
                j >>= i << 2;
            }
            return aWw[((int) j) & 15];
        }

        public Object get(int i) {
            return this.aWz[i];
        }

        public C1712b Hy() {
            return this.aWx;
        }

        public boolean Hz() {
            return this.aWA != null;
        }

        public C1712b m3907a(int i, JsonToken jsonToken) {
            if (i < 16) {
                m3903b(i, jsonToken);
                return null;
            }
            this.aWx = new C1712b();
            this.aWx.m3903b(0, jsonToken);
            return this.aWx;
        }

        public C1712b m3909a(int i, JsonToken jsonToken, Object obj, Object obj2) {
            if (i < 16) {
                m3905b(i, jsonToken, obj, obj2);
                return null;
            }
            this.aWx = new C1712b();
            this.aWx.m3905b(0, jsonToken, obj, obj2);
            return this.aWx;
        }

        public C1712b m3908a(int i, JsonToken jsonToken, Object obj) {
            if (i < 16) {
                m3904b(i, jsonToken, obj);
                return null;
            }
            this.aWx = new C1712b();
            this.aWx.m3904b(0, jsonToken, obj);
            return this.aWx;
        }

        public C1712b m3910a(int i, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            if (i < 16) {
                m3906b(i, jsonToken, obj, obj2, obj3);
                return null;
            }
            this.aWx = new C1712b();
            this.aWx.m3906b(0, jsonToken, obj, obj2, obj3);
            return this.aWx;
        }

        private void m3903b(int i, JsonToken jsonToken) {
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.aWy = ordinal | this.aWy;
        }

        private void m3905b(int i, JsonToken jsonToken, Object obj, Object obj2) {
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.aWy = ordinal | this.aWy;
            m3902a(i, obj, obj2);
        }

        private void m3904b(int i, JsonToken jsonToken, Object obj) {
            this.aWz[i] = obj;
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.aWy = ordinal | this.aWy;
        }

        private void m3906b(int i, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            this.aWz[i] = obj;
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.aWy = ordinal | this.aWy;
            m3902a(i, obj2, obj3);
        }

        private final void m3902a(int i, Object obj, Object obj2) {
            if (this.aWA == null) {
                this.aWA = new TreeMap();
            }
            if (obj != null) {
                this.aWA.put(Integer.valueOf(hg(i)), obj);
            }
            if (obj2 != null) {
                this.aWA.put(Integer.valueOf(hf(i)), obj2);
            }
        }

        public Object hd(int i) {
            return this.aWA == null ? null : this.aWA.get(Integer.valueOf(hg(i)));
        }

        public Object he(int i) {
            return this.aWA == null ? null : this.aWA.get(Integer.valueOf(hf(i)));
        }

        private final int hf(int i) {
            return i + i;
        }

        private final int hg(int i) {
            return (i + i) + 1;
        }
    }

    public /* synthetic */ aez zM() {
        return AG();
    }

    public amt(afa com_fossil_afa, boolean z) {
        this._objectCodec = com_fossil_afa;
        this._generatorFeatures = aWh;
        this.aLQ = aga.m3190d(null);
        C1712b c1712b = new C1712b();
        this.aWm = c1712b;
        this.aWl = c1712b;
        this.aWn = 0;
        this.aWi = z;
        this.aWj = z;
        this.aWk = this.aWi | this.aWj;
    }

    public amt(JsonParser jsonParser) {
        this._objectCodec = jsonParser.getCodec();
        this._generatorFeatures = aWh;
        this.aLQ = aga.m3190d(null);
        C1712b c1712b = new C1712b();
        this.aWm = c1712b;
        this.aWl = c1712b;
        this.aWn = 0;
        this.aWi = jsonParser.Aw();
        this.aWj = jsonParser.Av();
        this.aWk = this.aWi | this.aWj;
    }

    public JsonParser Hu() {
        return m3917a(this._objectCodec);
    }

    public JsonParser m3917a(afa com_fossil_afa) {
        return new C1711a(this.aWl, com_fossil_afa, this.aWi, this.aWj);
    }

    public JsonParser m3933e(JsonParser jsonParser) {
        JsonParser c1711a = new C1711a(this.aWl, jsonParser.getCodec(), this.aWi, this.aWj);
        c1711a.m3900a(jsonParser.zY());
        return c1711a;
    }

    public JsonToken Hv() {
        if (this.aWl != null) {
            return this.aWl.hc(0);
        }
        return null;
    }

    public void m3925b(JsonGenerator jsonGenerator) throws IOException {
        C1712b c1712b = this.aWl;
        boolean z = this.aWk;
        boolean z2 = z && c1712b.Hz();
        int i = -1;
        C1712b c1712b2 = c1712b;
        while (true) {
            int i2;
            i++;
            if (i >= 16) {
                C1712b Hy = c1712b2.Hy();
                if (Hy != null) {
                    z2 = z && Hy.Hz();
                    i2 = 0;
                    c1712b = Hy;
                    boolean z3 = z2;
                } else {
                    return;
                }
            }
            c1712b = c1712b2;
            i2 = i;
            z3 = z2;
            JsonToken hc = c1712b.hc(i2);
            if (hc != null) {
                if (z3) {
                    Object hd = c1712b.hd(i2);
                    if (hd != null) {
                        jsonGenerator.bn(hd);
                    }
                    hd = c1712b.he(i2);
                    if (hd != null) {
                        jsonGenerator.bp(hd);
                    }
                }
                Object obj;
                switch (hc) {
                    case START_OBJECT:
                        jsonGenerator.zJ();
                        break;
                    case END_OBJECT:
                        jsonGenerator.zK();
                        break;
                    case START_ARRAY:
                        jsonGenerator.zH();
                        break;
                    case END_ARRAY:
                        jsonGenerator.zI();
                        break;
                    case FIELD_NAME:
                        obj = c1712b.get(i2);
                        if (!(obj instanceof afc)) {
                            jsonGenerator.aQ((String) obj);
                            break;
                        } else {
                            jsonGenerator.mo850b((afc) obj);
                            break;
                        }
                    case VALUE_STRING:
                        obj = c1712b.get(i2);
                        if (!(obj instanceof afc)) {
                            jsonGenerator.writeString((String) obj);
                            break;
                        } else {
                            jsonGenerator.mo852c((afc) obj);
                            break;
                        }
                    case VALUE_NUMBER_INT:
                        obj = c1712b.get(i2);
                        if (!(obj instanceof Integer)) {
                            if (!(obj instanceof BigInteger)) {
                                if (!(obj instanceof Long)) {
                                    if (!(obj instanceof Short)) {
                                        jsonGenerator.fl(((Number) obj).intValue());
                                        break;
                                    } else {
                                        jsonGenerator.mo947f(((Short) obj).shortValue());
                                        break;
                                    }
                                }
                                jsonGenerator.mo933J(((Long) obj).longValue());
                                break;
                            }
                            jsonGenerator.mo938a((BigInteger) obj);
                            break;
                        }
                        jsonGenerator.fl(((Integer) obj).intValue());
                        break;
                    case VALUE_NUMBER_FLOAT:
                        obj = c1712b.get(i2);
                        if (obj instanceof Double) {
                            jsonGenerator.mo945d(((Double) obj).doubleValue());
                            break;
                        } else if (obj instanceof BigDecimal) {
                            jsonGenerator.mo937a((BigDecimal) obj);
                            break;
                        } else if (obj instanceof Float) {
                            jsonGenerator.mo934T(((Float) obj).floatValue());
                            break;
                        } else if (obj == null) {
                            jsonGenerator.zL();
                            break;
                        } else if (obj instanceof String) {
                            jsonGenerator.aT((String) obj);
                            break;
                        } else {
                            throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + obj.getClass().getName() + ", can not serialize");
                        }
                    case VALUE_TRUE:
                        jsonGenerator.writeBoolean(true);
                        break;
                    case VALUE_FALSE:
                        jsonGenerator.writeBoolean(false);
                        break;
                    case VALUE_NULL:
                        jsonGenerator.zL();
                        break;
                    case VALUE_EMBEDDED_OBJECT:
                        obj = c1712b.get(i2);
                        if (!(obj instanceof amr)) {
                            jsonGenerator.writeObject(obj);
                            break;
                        } else {
                            ((amr) obj).m3893b(jsonGenerator);
                            break;
                        }
                    default:
                        throw new RuntimeException("Internal error: should never end up through this code path");
                }
                z2 = z3;
                i = i2;
                c1712b2 = c1712b;
            } else {
                return;
            }
        }
    }

    public amt deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zV() != JsonToken.FIELD_NAME.id()) {
            mo1097b(jsonParser);
        } else {
            JsonToken zP;
            zJ();
            do {
                mo1097b(jsonParser);
                zP = jsonParser.zP();
            } while (zP == JsonToken.FIELD_NAME);
            if (zP != JsonToken.END_OBJECT) {
                throw deserializationContext.mappingException("Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + zP);
            }
            zK();
        }
        return this;
    }

    public String toString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[TokenBuffer: ");
        JsonParser Hu = Hu();
        int i2 = (this.aWi || this.aWj) ? 1 : 0;
        while (true) {
            JsonToken zP = Hu.zP();
            if (zP == null) {
                break;
            }
            if (i2 != 0) {
                try {
                    m3911b(stringBuilder);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
            if (i < 100) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(zP.toString());
                if (zP == JsonToken.FIELD_NAME) {
                    stringBuilder.append('(');
                    stringBuilder.append(Hu.zW());
                    stringBuilder.append(')');
                }
            }
            i++;
        }
        if (i >= 100) {
            stringBuilder.append(" ... (truncated ").append(i - 100).append(" entries)");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private final void m3911b(StringBuilder stringBuilder) {
        Object hd = this.aWm.hd(this.aWn - 1);
        if (hd != null) {
            stringBuilder.append("[objectId=").append(String.valueOf(hd)).append(']');
        }
        hd = this.aWm.he(this.aWn - 1);
        if (hd != null) {
            stringBuilder.append("[typeId=").append(String.valueOf(hd)).append(']');
        }
    }

    public JsonGenerator mo848a(Feature feature) {
        this._generatorFeatures &= feature.getMask() ^ -1;
        return this;
    }

    public int zB() {
        return this._generatorFeatures;
    }

    public JsonGenerator fi(int i) {
        this._generatorFeatures = i;
        return this;
    }

    public final aga AG() {
        return this.aLQ;
    }

    public boolean zF() {
        return true;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        this.aLR = true;
    }

    public final void zH() throws IOException {
        m3929c(JsonToken.START_ARRAY);
        this.aLQ = this.aLQ.BT();
    }

    public final void zI() throws IOException {
        m3929c(JsonToken.END_ARRAY);
        aga BV = this.aLQ.BV();
        if (BV != null) {
            this.aLQ = BV;
        }
    }

    public final void zJ() throws IOException {
        m3929c(JsonToken.START_OBJECT);
        this.aLQ = this.aLQ.BU();
    }

    public final void zK() throws IOException {
        m3929c(JsonToken.END_OBJECT);
        aga BV = this.aLQ.BV();
        if (BV != null) {
            this.aLQ = BV;
        }
    }

    public final void aQ(String str) throws IOException {
        m3921a(JsonToken.FIELD_NAME, str);
        this.aLQ.br(str);
    }

    public void mo850b(afc com_fossil_afc) throws IOException {
        m3921a(JsonToken.FIELD_NAME, com_fossil_afc);
        this.aLQ.br(com_fossil_afc.getValue());
    }

    public void writeString(String str) throws IOException {
        if (str == null) {
            zL();
        } else {
            m3921a(JsonToken.VALUE_STRING, str);
        }
    }

    public void mo939a(char[] cArr, int i, int i2) throws IOException {
        writeString(new String(cArr, i, i2));
    }

    public void mo852c(afc com_fossil_afc) throws IOException {
        if (com_fossil_afc == null) {
            zL();
        } else {
            m3921a(JsonToken.VALUE_STRING, com_fossil_afc);
        }
    }

    public void aR(String str) throws IOException {
        zO();
    }

    public void mo946d(afc com_fossil_afc) throws IOException {
        zO();
    }

    public void mo943b(char[] cArr, int i, int i2) throws IOException {
        zO();
    }

    public void mo935a(char c) throws IOException {
        zO();
    }

    public void aS(String str) throws IOException {
        m3921a(JsonToken.VALUE_EMBEDDED_OBJECT, new amr(str));
    }

    public void mo947f(short s) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_INT, Short.valueOf(s));
    }

    public void fl(int i) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    public void mo933J(long j) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    public void mo945d(double d) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public void mo934T(float f) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    public void mo937a(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            zL();
        } else {
            m3921a(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    public void mo938a(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            zL();
        } else {
            m3921a(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    public void aT(String str) throws IOException {
        m3921a(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public void writeBoolean(boolean z) throws IOException {
        m3929c(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    public void zL() throws IOException {
        m3929c(JsonToken.VALUE_NULL);
    }

    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            zL();
        } else if (obj.getClass() == byte[].class || (obj instanceof amr)) {
            m3921a(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
        } else if (this._objectCodec == null) {
            m3921a(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            this._objectCodec.writeValue(this, obj);
        }
    }

    public void mo936a(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        writeObject(obj);
    }

    public int mo847a(Base64Variant base64Variant, InputStream inputStream, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean zE() {
        return this.aWi;
    }

    public boolean zD() {
        return this.aWj;
    }

    public void bp(Object obj) {
        this.aWo = obj;
        this.aWq = true;
    }

    public void bn(Object obj) {
        this.aWp = obj;
        this.aWq = true;
    }

    public void mo1096a(JsonParser jsonParser) throws IOException {
        if (this.aWk) {
            m3912f(jsonParser);
        }
        switch (jsonParser.zU()) {
            case START_OBJECT:
                zJ();
                return;
            case END_OBJECT:
                zK();
                return;
            case START_ARRAY:
                zH();
                return;
            case END_ARRAY:
                zI();
                return;
            case FIELD_NAME:
                aQ(jsonParser.zW());
                return;
            case VALUE_STRING:
                if (jsonParser.Ag()) {
                    mo939a(jsonParser.Ad(), jsonParser.Af(), jsonParser.Ae());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case VALUE_NUMBER_INT:
                switch (jsonParser.Ai()) {
                    case INT:
                        fl(jsonParser.getIntValue());
                        return;
                    case BIG_INTEGER:
                        mo938a(jsonParser.Am());
                        return;
                    default:
                        mo933J(jsonParser.Al());
                        return;
                }
            case VALUE_NUMBER_FLOAT:
                switch (jsonParser.Ai()) {
                    case BIG_DECIMAL:
                        mo937a(jsonParser.Ap());
                        return;
                    case FLOAT:
                        mo934T(jsonParser.An());
                        return;
                    default:
                        mo945d(jsonParser.Ao());
                        return;
                }
            case VALUE_TRUE:
                writeBoolean(true);
                return;
            case VALUE_FALSE:
                writeBoolean(false);
                return;
            case VALUE_NULL:
                zL();
                return;
            case VALUE_EMBEDDED_OBJECT:
                writeObject(jsonParser.Aq());
                return;
            default:
                throw new RuntimeException("Internal error: should never end up through this code path");
        }
    }

    public void mo1097b(JsonParser jsonParser) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.FIELD_NAME) {
            if (this.aWk) {
                m3912f(jsonParser);
            }
            aQ(jsonParser.zW());
            zU = jsonParser.zP();
        }
        if (this.aWk) {
            m3912f(jsonParser);
        }
        switch (zU) {
            case START_OBJECT:
                zJ();
                while (jsonParser.zP() != JsonToken.END_OBJECT) {
                    mo1097b(jsonParser);
                }
                zK();
                return;
            case START_ARRAY:
                zH();
                while (jsonParser.zP() != JsonToken.END_ARRAY) {
                    mo1097b(jsonParser);
                }
                zI();
                return;
            default:
                mo1096a(jsonParser);
                return;
        }
    }

    private final void m3912f(JsonParser jsonParser) throws IOException {
        Object Ay = jsonParser.Ay();
        this.aWo = Ay;
        if (Ay != null) {
            this.aWq = true;
        }
        Ay = jsonParser.Ax();
        this.aWp = Ay;
        if (Ay != null) {
            this.aWq = true;
        }
    }

    protected final void m3929c(JsonToken jsonToken) {
        C1712b a = this.aWq ? this.aWm.m3909a(this.aWn, jsonToken, this.aWp, this.aWo) : this.aWm.m3907a(this.aWn, jsonToken);
        if (a == null) {
            this.aWn++;
            return;
        }
        this.aWm = a;
        this.aWn = 1;
    }

    protected final void m3921a(JsonToken jsonToken, Object obj) {
        C1712b a;
        if (this.aWq) {
            a = this.aWm.m3910a(this.aWn, jsonToken, obj, this.aWp, this.aWo);
        } else {
            a = this.aWm.m3908a(this.aWn, jsonToken, obj);
        }
        if (a == null) {
            this.aWn++;
            return;
        }
        this.aWm = a;
        this.aWn = 1;
    }

    protected void zO() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }
}
