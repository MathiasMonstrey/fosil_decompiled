package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.amt;
import java.io.IOException;
import java.util.UUID;

public class UUIDSerializer extends StdScalarSerializer<UUID> {
    static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public UUIDSerializer() {
        super(UUID.class);
    }

    @Deprecated
    public boolean isEmpty(UUID uuid) {
        return isEmpty(null, uuid);
    }

    public boolean isEmpty(ahg com_fossil_ahg, UUID uuid) {
        if (uuid == null) {
            return true;
        }
        if (uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0) {
            return true;
        }
        return false;
    }

    public void serialize(UUID uuid, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (!jsonGenerator.zF() || (jsonGenerator instanceof amt)) {
            char[] cArr = new char[36];
            long mostSignificantBits = uuid.getMostSignificantBits();
            m2762d((int) (mostSignificantBits >> 32), cArr, 0);
            cArr[8] = '-';
            int i = (int) mostSignificantBits;
            m2763e(i >>> 16, cArr, 9);
            cArr[13] = '-';
            m2763e(i, cArr, 14);
            cArr[18] = '-';
            mostSignificantBits = uuid.getLeastSignificantBits();
            m2763e((int) (mostSignificantBits >>> 48), cArr, 19);
            cArr[23] = '-';
            m2763e((int) (mostSignificantBits >>> 32), cArr, 24);
            m2762d((int) mostSignificantBits, cArr, 28);
            jsonGenerator.mo939a(cArr, 0, 36);
            return;
        }
        jsonGenerator.m2659R(m2760a(uuid));
    }

    private static void m2762d(int i, char[] cArr, int i2) {
        m2763e(i >> 16, cArr, i2);
        m2763e(i, cArr, i2 + 4);
    }

    private static void m2763e(int i, char[] cArr, int i2) {
        cArr[i2] = HEX_CHARS[(i >> 12) & 15];
        int i3 = i2 + 1;
        cArr[i3] = HEX_CHARS[(i >> 8) & 15];
        i3++;
        cArr[i3] = HEX_CHARS[(i >> 4) & 15];
        cArr[i3 + 1] = HEX_CHARS[i & 15];
    }

    private static final byte[] m2760a(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        m2761d((int) (mostSignificantBits >> 32), bArr, 0);
        m2761d((int) mostSignificantBits, bArr, 4);
        m2761d((int) (leastSignificantBits >> 32), bArr, 8);
        m2761d((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    private static final void m2761d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >> 16);
        i3++;
        bArr[i3] = (byte) (i >> 8);
        bArr[i3 + 1] = (byte) i;
    }
}
