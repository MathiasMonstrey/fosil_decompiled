package com.fossil;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class aom {
    private static final String f1429d = aom.class.getSimpleName();
    final List<aoj> aWP = new ArrayList();
    boolean aXI;
    long aXw;

    public static class C1777a implements aqi<aom> {
        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17761 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1777a aZR;

                public final void close() {
                }
            };
            aom com_fossil_aom = new aom();
            c17761.readUTF();
            c17761.readUTF();
            com_fossil_aom.aXI = c17761.readBoolean();
            com_fossil_aom.aXw = c17761.readLong();
            while (true) {
                int readUnsignedShort = c17761.readUnsignedShort();
                if (readUnsignedShort == 0) {
                    return com_fossil_aom;
                }
                byte[] bArr = new byte[readUnsignedShort];
                c17761.readFully(bArr);
                com_fossil_aom.aWP.add(0, new aoj(bArr));
            }
        }

        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            throw new UnsupportedOperationException("Serialization not supported");
        }
    }
}
