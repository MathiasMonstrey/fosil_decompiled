package com.fossil;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fossil.afm.C1619a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ahx {
    protected final ObjectReader[] aQZ;
    protected final MatchStrength aRa;
    protected final MatchStrength aRb;
    protected final int aRc;

    public class C1643a extends C1619a {
        final /* synthetic */ ahx aRd;

        public C1643a(ahx com_fossil_ahx, InputStream inputStream, byte[] bArr) {
            this.aRd = com_fossil_ahx;
            super(inputStream, bArr);
        }

        public C1643a(ahx com_fossil_ahx, byte[] bArr, int i, int i2) {
            this.aRd = com_fossil_ahx;
            super(bArr, i, i2);
        }

        public C1644b m3372a(ObjectReader objectReader, MatchStrength matchStrength) {
            return new C1644b(this.aMQ, this.aMR, this.aMS, this.aMT - this.aMS, objectReader, matchStrength);
        }
    }

    public static class C1644b {
        protected final int aMS;
        protected final InputStream aRe;
        protected final byte[] aRf;
        protected final int aRg;
        protected final ObjectReader aRh;
        protected final MatchStrength aRi;

        protected C1644b(InputStream inputStream, byte[] bArr, int i, int i2, ObjectReader objectReader, MatchStrength matchStrength) {
            this.aRe = inputStream;
            this.aRf = bArr;
            this.aMS = i;
            this.aRg = i2;
            this.aRh = objectReader;
            this.aRi = matchStrength;
        }

        public boolean Eu() {
            return this.aRh != null;
        }

        public ObjectReader Ev() {
            return this.aRh;
        }

        public JsonParser Ew() throws IOException {
            if (this.aRh == null) {
                return null;
            }
            JsonFactory factory = this.aRh.getFactory();
            if (this.aRe == null) {
                return factory.createParser(this.aRf, this.aMS, this.aRg);
            }
            return factory.createParser(Ex());
        }

        public InputStream Ex() {
            if (this.aRe == null) {
                return new ByteArrayInputStream(this.aRf, this.aMS, this.aRg);
            }
            return new afq(null, this.aRe, this.aRf, this.aMS, this.aRg);
        }
    }

    public ahx(ObjectReader... objectReaderArr) {
        this(objectReaderArr, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private ahx(ObjectReader[] objectReaderArr, MatchStrength matchStrength, MatchStrength matchStrength2, int i) {
        this.aQZ = objectReaderArr;
        this.aRa = matchStrength;
        this.aRb = matchStrength2;
        this.aRc = i;
    }

    public ahx m3374a(DeserializationConfig deserializationConfig) {
        int length = this.aQZ.length;
        ObjectReader[] objectReaderArr = new ObjectReader[length];
        for (int i = 0; i < length; i++) {
            objectReaderArr[i] = this.aQZ[i].with(deserializationConfig);
        }
        return new ahx(objectReaderArr, this.aRa, this.aRb, this.aRc);
    }

    public ahx m3375b(JavaType javaType) {
        int length = this.aQZ.length;
        ObjectReader[] objectReaderArr = new ObjectReader[length];
        for (int i = 0; i < length; i++) {
            objectReaderArr[i] = this.aQZ[i].forType(javaType);
        }
        return new ahx(objectReaderArr, this.aRa, this.aRb, this.aRc);
    }

    public C1644b m3377i(InputStream inputStream) throws IOException {
        return m3373a(new C1643a(this, inputStream, new byte[this.aRc]));
    }

    public C1644b m3376e(byte[] bArr, int i, int i2) throws IOException {
        return m3373a(new C1643a(this, bArr, i, i2));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        int length = this.aQZ.length;
        if (length > 0) {
            stringBuilder.append(this.aQZ[0].getFactory().getFormatName());
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(this.aQZ[i].getFactory().getFormatName());
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private C1644b m3373a(C1643a c1643a) throws IOException {
        ObjectReader objectReader;
        MatchStrength hasFormat;
        ObjectReader[] objectReaderArr = this.aQZ;
        int length = objectReaderArr.length;
        int i = 0;
        ObjectReader objectReader2 = null;
        MatchStrength matchStrength = null;
        while (i < length) {
            ObjectReader objectReader3;
            objectReader = objectReaderArr[i];
            c1643a.reset();
            hasFormat = objectReader.getFactory().hasFormat(c1643a);
            if (hasFormat == null) {
                objectReader3 = objectReader2;
            } else if (hasFormat.ordinal() < this.aRb.ordinal()) {
                objectReader3 = objectReader2;
            } else if (objectReader2 != null && matchStrength.ordinal() >= hasFormat.ordinal()) {
                objectReader3 = objectReader2;
            } else if (hasFormat.ordinal() >= this.aRa.ordinal()) {
                break;
            } else {
                matchStrength = hasFormat;
                objectReader3 = objectReader;
            }
            i++;
            objectReader2 = objectReader3;
        }
        hasFormat = matchStrength;
        objectReader = objectReader2;
        return c1643a.m3372a(objectReader, hasFormat);
    }
}
