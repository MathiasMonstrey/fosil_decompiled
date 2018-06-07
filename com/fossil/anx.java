package com.fossil;

import com.flurry.sdk.in;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class anx {
    private static final String aYt = anx.class.getName();
    public int f1398a;
    public boolean aWE;
    public int aXp;
    public long aXv;
    public long aXw;
    public in aYu;
    public String aYv;
    public long aYw;
    public boolean aYx;
    public long aYy = 0;
    public anw aYz;
    public int f1399e;

    public static class C1741a implements aqi<anx> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            anx com_fossil_anx = (anx) obj;
            if (outputStream != null && com_fossil_anx != null) {
                DataOutputStream c17391 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1741a aYA;

                    public final void close() {
                    }
                };
                c17391.writeInt(com_fossil_anx.f1398a);
                c17391.writeLong(com_fossil_anx.aXv);
                c17391.writeLong(com_fossil_anx.aXw);
                c17391.writeBoolean(com_fossil_anx.aWE);
                c17391.writeInt(com_fossil_anx.f1399e);
                c17391.writeInt(com_fossil_anx.aYu.f1295e);
                if (com_fossil_anx.aYv != null) {
                    c17391.writeUTF(com_fossil_anx.aYv);
                } else {
                    c17391.writeUTF("");
                }
                c17391.writeInt(com_fossil_anx.aXp);
                c17391.writeLong(com_fossil_anx.aYw);
                c17391.writeBoolean(com_fossil_anx.aYx);
                c17391.writeLong(com_fossil_anx.aYy);
                c17391.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17402 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1741a aYA;

                public final void close() {
                }
            };
            int readInt = c17402.readInt();
            long readLong = c17402.readLong();
            long readLong2 = c17402.readLong();
            boolean readBoolean = c17402.readBoolean();
            int readInt2 = c17402.readInt();
            in a = in.m2767a(c17402.readInt());
            String readUTF = c17402.readUTF();
            int readInt3 = c17402.readInt();
            long readLong3 = c17402.readLong();
            boolean readBoolean2 = c17402.readBoolean();
            long readLong4 = c17402.readLong();
            Object com_fossil_anx = new anx(null, readLong, readLong2, readInt);
            com_fossil_anx.aWE = readBoolean;
            com_fossil_anx.f1399e = readInt2;
            com_fossil_anx.aYu = a;
            com_fossil_anx.aYv = readUTF;
            com_fossil_anx.aXp = readInt3;
            com_fossil_anx.aYw = readLong3;
            com_fossil_anx.aYx = readBoolean2;
            com_fossil_anx.aYy = readLong4;
            return com_fossil_anx;
        }
    }

    public anx(anw com_fossil_anw, long j, long j2, int i) {
        this.aYz = com_fossil_anw;
        this.aXv = j;
        this.aXw = j2;
        this.f1398a = i;
        this.f1399e = 0;
        this.aYu = in.PENDING_COMPLETION;
    }

    public final void HJ() {
        this.aYz.aYm.add(this);
        if (this.aWE) {
            this.aYz.aYq = true;
        }
    }
}
