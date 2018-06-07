package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aqd {
    String aWB;

    public static class C1828a implements aqi<aqd> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            aqd com_fossil_aqd = (aqd) obj;
            if (outputStream != null && com_fossil_aqd != null) {
                DataOutputStream c18261 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1828a bbZ;

                    public final void close() {
                    }
                };
                c18261.writeUTF(com_fossil_aqd.aWB);
                c18261.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c18272 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1828a bbZ;

                public final void close() {
                }
            };
            Object com_fossil_aqd = new aqd();
            com_fossil_aqd.aWB = c18272.readUTF();
            return com_fossil_aqd;
        }
    }

    private aqd() {
    }

    public aqd(String str) {
        this.aWB = str;
    }
}
