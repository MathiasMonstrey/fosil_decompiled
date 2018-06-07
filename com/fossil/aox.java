package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aox {
    byte[] aXJ;
    boolean aXk;
    byte[] baq;
    int f1435d;

    static class C1782a implements aqi<aox> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            aox com_fossil_aox = (aox) obj;
            if (outputStream != null && com_fossil_aox != null) {
                DataOutputStream c17801 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1782a bar;

                    public final void close() {
                    }
                };
                c17801.writeBoolean(com_fossil_aox.aXk);
                if (com_fossil_aox.baq == null) {
                    c17801.writeInt(0);
                } else {
                    c17801.writeInt(com_fossil_aox.baq.length);
                    c17801.write(com_fossil_aox.baq);
                }
                if (com_fossil_aox.aXJ == null) {
                    c17801.writeInt(0);
                } else {
                    c17801.writeInt(com_fossil_aox.aXJ.length);
                    c17801.write(com_fossil_aox.aXJ);
                }
                c17801.writeInt(com_fossil_aox.f1435d);
                c17801.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17812 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1782a bar;

                public final void close() {
                }
            };
            aox com_fossil_aox = new aox();
            com_fossil_aox.aXk = c17812.readBoolean();
            int readInt = c17812.readInt();
            if (readInt > 0) {
                com_fossil_aox.baq = new byte[readInt];
                c17812.read(com_fossil_aox.baq, 0, readInt);
            } else {
                com_fossil_aox.baq = null;
            }
            readInt = c17812.readInt();
            if (readInt > 0) {
                com_fossil_aox.aXJ = new byte[readInt];
                c17812.read(com_fossil_aox.aXJ, 0, readInt);
            } else {
                com_fossil_aox.aXJ = null;
            }
            com_fossil_aox.f1435d = c17812.readInt();
            return com_fossil_aox;
        }

        C1782a() {
        }
    }

    public aox(byte[] bArr, byte[] bArr2, boolean z, int i) {
        this.baq = bArr2;
        this.aXJ = bArr;
        this.aXk = z;
        this.f1435d = i;
    }

    private aox() {
    }
}
