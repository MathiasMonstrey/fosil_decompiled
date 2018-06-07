package com.fossil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class apt<ObjectType> {
    private static final String aWB = apt.class.getSimpleName();
    private static final byte[] baq = new byte[]{(byte) 113, (byte) -92, (byte) -8, (byte) 125, (byte) 121, (byte) 107, (byte) -65, (byte) -61, (byte) -74, (byte) -114, (byte) -32, (byte) 0, (byte) -57, (byte) -87, (byte) -35, (byte) -56, (byte) -6, (byte) -52, (byte) 51, (byte) 126, (byte) -104, (byte) 49, (byte) 79, (byte) -52, (byte) 118, (byte) -84, (byte) 99, (byte) -52, (byte) -14, (byte) -126, (byte) -27, (byte) -64};
    private String aWS;
    private aqi<ObjectType> bbl;

    public apt(String str, aqi<ObjectType> com_fossil_aqi_ObjectType) {
        this.aWS = str;
        this.bbl = com_fossil_aqi_ObjectType;
    }

    public static int m4187Y(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        aph com_fossil_aph = new aph();
        com_fossil_aph.update(bArr);
        return com_fossil_aph.Iz();
    }

    public final byte[] bK(ObjectType objectType) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bbl.mo1105a(byteArrayOutputStream, objectType);
        Object toByteArray = byteArrayOutputStream.toByteArray();
        app.m4180g(3, aWB, "Encoding " + this.aWS + ": " + new String(toByteArray));
        aqi com_fossil_aqg = new aqg(new aqe());
        OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        com_fossil_aqg.mo1105a(byteArrayOutputStream2, toByteArray);
        byte[] toByteArray2 = byteArrayOutputStream2.toByteArray();
        m4188Z(toByteArray2);
        return toByteArray2;
    }

    private static void m4188Z(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int length2 = baq.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ baq[i % length2]) ^ ((i * 31) % 251));
            }
        }
    }

    public final ObjectType aa(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IOException("Decoding: " + this.aWS + ": Nothing to decode");
        }
        m4188Z(bArr);
        byte[] bArr2 = (byte[]) new aqg(new aqe()).mo1106j(new ByteArrayInputStream(bArr));
        app.m4180g(3, aWB, "Decoding: " + this.aWS + ": " + new String(bArr2));
        return this.bbl.mo1106j(new ByteArrayInputStream(bArr2));
    }
}
