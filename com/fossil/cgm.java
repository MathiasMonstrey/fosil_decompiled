package com.fossil;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class cgm extends cgv {
    private static final Reader bSf = new C20491();
    private static final Object bSg = new Object();
    private Object[] bSh = new Object[32];
    private int bSi = 0;
    private String[] bSj = new String[32];
    private int[] bSk = new int[32];

    static class C20491 extends Reader {
        C20491() {
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    }

    public cgm(cfp com_fossil_cfp) {
        super(bSf);
        push(com_fossil_cfp);
    }

    public void beginArray() throws IOException {
        m6254a(JsonToken.BEGIN_ARRAY);
        push(((cfm) WU()).iterator());
        this.bSk[this.bSi - 1] = 0;
    }

    public void endArray() throws IOException {
        m6254a(JsonToken.END_ARRAY);
        WV();
        WV();
        if (this.bSi > 0) {
            int[] iArr = this.bSk;
            int i = this.bSi - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public void beginObject() throws IOException {
        m6254a(JsonToken.BEGIN_OBJECT);
        push(((cfr) WU()).entrySet().iterator());
    }

    public void endObject() throws IOException {
        m6254a(JsonToken.END_OBJECT);
        WV();
        WV();
        if (this.bSi > 0) {
            int[] iArr = this.bSk;
            int i = this.bSi - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public boolean hasNext() throws IOException {
        JsonToken WT = WT();
        return (WT == JsonToken.END_OBJECT || WT == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken WT() throws IOException {
        if (this.bSi == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object WU = WU();
        if (WU instanceof Iterator) {
            boolean z = this.bSh[this.bSi - 2] instanceof cfr;
            Iterator it = (Iterator) WU;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else {
                if (z) {
                    return JsonToken.NAME;
                }
                push(it.next());
                return WT();
            }
        } else if (WU instanceof cfr) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (WU instanceof cfm) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (WU instanceof cft) {
                cft com_fossil_cft = (cft) WU;
                if (com_fossil_cft.WE()) {
                    return JsonToken.STRING;
                }
                if (com_fossil_cft.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (com_fossil_cft.DI()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (WU instanceof cfq) {
                return JsonToken.NULL;
            } else {
                if (WU == bSg) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object WU() {
        return this.bSh[this.bSi - 1];
    }

    private Object WV() {
        Object[] objArr = this.bSh;
        int i = this.bSi - 1;
        this.bSi = i;
        Object obj = objArr[i];
        this.bSh[this.bSi] = null;
        return obj;
    }

    private void m6254a(JsonToken jsonToken) throws IOException {
        if (WT() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + WT() + WX());
        }
    }

    public String nextName() throws IOException {
        m6254a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) WU()).next();
        String str = (String) entry.getKey();
        this.bSj[this.bSi - 1] = str;
        push(entry.getValue());
        return str;
    }

    public String nextString() throws IOException {
        JsonToken WT = WT();
        if (WT == JsonToken.STRING || WT == JsonToken.NUMBER) {
            String asString = ((cft) WV()).getAsString();
            if (this.bSi > 0) {
                int[] iArr = this.bSk;
                int i = this.bSi - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + WT + WX());
    }

    public boolean nextBoolean() throws IOException {
        m6254a(JsonToken.BOOLEAN);
        boolean asBoolean = ((cft) WV()).getAsBoolean();
        if (this.bSi > 0) {
            int[] iArr = this.bSk;
            int i = this.bSi - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    public void nextNull() throws IOException {
        m6254a(JsonToken.NULL);
        WV();
        if (this.bSi > 0) {
            int[] iArr = this.bSk;
            int i = this.bSi - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public double nextDouble() throws IOException {
        JsonToken WT = WT();
        if (WT == JsonToken.NUMBER || WT == JsonToken.STRING) {
            double asDouble = ((cft) WU()).getAsDouble();
            if (isLenient() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
                WV();
                if (this.bSi > 0) {
                    int[] iArr = this.bSk;
                    int i = this.bSi - 1;
                    iArr[i] = iArr[i] + 1;
                }
                return asDouble;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + WT + WX());
    }

    public long nextLong() throws IOException {
        JsonToken WT = WT();
        if (WT == JsonToken.NUMBER || WT == JsonToken.STRING) {
            long asLong = ((cft) WU()).getAsLong();
            WV();
            if (this.bSi > 0) {
                int[] iArr = this.bSk;
                int i = this.bSi - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asLong;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + WT + WX());
    }

    public int nextInt() throws IOException {
        JsonToken WT = WT();
        if (WT == JsonToken.NUMBER || WT == JsonToken.STRING) {
            int asInt = ((cft) WU()).getAsInt();
            WV();
            if (this.bSi > 0) {
                int[] iArr = this.bSk;
                int i = this.bSi - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asInt;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + WT + WX());
    }

    public void close() throws IOException {
        this.bSh = new Object[]{bSg};
        this.bSi = 1;
    }

    public void skipValue() throws IOException {
        if (WT() == JsonToken.NAME) {
            nextName();
            this.bSj[this.bSi - 2] = "null";
        } else {
            WV();
            this.bSj[this.bSi - 1] = "null";
        }
        int[] iArr = this.bSk;
        int i = this.bSi - 1;
        iArr[i] = iArr[i] + 1;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void WW() throws IOException {
        m6254a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) WU()).next();
        push(entry.getValue());
        push(new cft((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.bSi == this.bSh.length) {
            Object obj2 = new Object[(this.bSi * 2)];
            Object obj3 = new int[(this.bSi * 2)];
            Object obj4 = new String[(this.bSi * 2)];
            System.arraycopy(this.bSh, 0, obj2, 0, this.bSi);
            System.arraycopy(this.bSk, 0, obj3, 0, this.bSi);
            System.arraycopy(this.bSj, 0, obj4, 0, this.bSi);
            this.bSh = obj2;
            this.bSk = obj3;
            this.bSj = obj4;
        }
        Object[] objArr = this.bSh;
        int i = this.bSi;
        this.bSi = i + 1;
        objArr[i] = obj;
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.bSi) {
            if (this.bSh[i] instanceof cfm) {
                i++;
                if (this.bSh[i] instanceof Iterator) {
                    append.append('[').append(this.bSk[i]).append(']');
                }
            } else if (this.bSh[i] instanceof cfr) {
                i++;
                if (this.bSh[i] instanceof Iterator) {
                    append.append('.');
                    if (this.bSj[i] != null) {
                        append.append(this.bSj[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String WX() {
        return " at path " + getPath();
    }
}
