package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public final class aqb {
    String aWB;
    byte[] baq;

    public static class C1818a implements aqi<aqb> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            aqb com_fossil_aqb = (aqb) obj;
            if (outputStream != null && com_fossil_aqb != null) {
                DataOutputStream c18161 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1818a bbV;

                    public final void close() {
                    }
                };
                c18161.writeShort(com_fossil_aqb.baq.length);
                c18161.write(com_fossil_aqb.baq);
                c18161.writeShort(0);
                c18161.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c18172 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1818a bbV;

                public final void close() {
                }
            };
            aqb com_fossil_aqb = new aqb();
            short readShort = c18172.readShort();
            if (readShort == (short) 0) {
                return null;
            }
            com_fossil_aqb.baq = new byte[readShort];
            c18172.readFully(com_fossil_aqb.baq);
            c18172.readUnsignedShort();
            return com_fossil_aqb;
        }
    }

    private aqb() {
        this.aWB = null;
        this.baq = null;
    }

    public aqb(byte[] bArr) {
        this.aWB = null;
        this.baq = null;
        this.aWB = UUID.randomUUID().toString();
        this.baq = bArr;
    }

    public static String m4205a(String str) {
        return ".yflurrydatasenderblock." + str;
    }
}
