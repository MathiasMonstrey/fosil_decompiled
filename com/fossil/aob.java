package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aob {
    byte[] aYe;

    public static class C1757a implements aqi<aob> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            aob com_fossil_aob = (aob) obj;
            if (outputStream != null && com_fossil_aob != null) {
                DataOutputStream c17551 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1757a aYR;

                    public final void close() {
                    }
                };
                c17551.writeShort(com_fossil_aob.aYe.length);
                c17551.write(com_fossil_aob.aYe);
                c17551.writeShort(0);
                c17551.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17562 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1757a aYR;

                public final void close() {
                }
            };
            short readShort = c17562.readShort();
            if (readShort == (short) 0) {
                return null;
            }
            Object com_fossil_aob = new aob();
            com_fossil_aob.aYe = new byte[readShort];
            c17562.readFully(com_fossil_aob.aYe);
            c17562.readUnsignedShort();
            return com_fossil_aob;
        }
    }

    public aob(byte[] bArr) {
        this.aYe = bArr;
    }
}
