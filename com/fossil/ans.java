package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ans {
    boolean aXI;
    byte[] aXJ;
    long aXm;

    public static class C1721a implements aqi<ans> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            ans com_fossil_ans = (ans) obj;
            if (outputStream != null && com_fossil_ans != null) {
                DataOutputStream c17191 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1721a aXK;

                    public final void close() {
                    }
                };
                c17191.writeLong(com_fossil_ans.aXm);
                c17191.writeBoolean(com_fossil_ans.aXI);
                c17191.writeInt(com_fossil_ans.aXJ.length);
                c17191.write(com_fossil_ans.aXJ);
                c17191.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17202 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1721a aXK;

                public final void close() {
                }
            };
            Object com_fossil_ans = new ans();
            com_fossil_ans.aXm = c17202.readLong();
            com_fossil_ans.aXI = c17202.readBoolean();
            com_fossil_ans.aXJ = new byte[c17202.readInt()];
            c17202.readFully(com_fossil_ans.aXJ);
            return com_fossil_ans;
        }
    }
}
