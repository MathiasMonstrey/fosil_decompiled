package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aqj<T> implements aqi<T> {
    private final String aWB;
    private final int f1449b;
    private final aqk<T> bcb;

    public aqj(String str, int i, aqk<T> com_fossil_aqk_T) {
        this.aWB = str;
        this.f1449b = i;
        this.bcb = com_fossil_aqk_T;
    }

    public final void mo1105a(OutputStream outputStream, T t) throws IOException {
        if (outputStream != null && this.bcb != null) {
            OutputStream c18311 = new DataOutputStream(this, outputStream) {
                final /* synthetic */ aqj bcc;

                public final void close() {
                }
            };
            c18311.writeUTF(this.aWB);
            c18311.writeInt(this.f1449b);
            this.bcb.hi(this.f1449b).mo1105a(c18311, t);
            c18311.flush();
        }
    }

    public final T mo1106j(InputStream inputStream) throws IOException {
        if (inputStream == null || this.bcb == null) {
            return null;
        }
        InputStream c18322 = new DataInputStream(this, inputStream) {
            final /* synthetic */ aqj bcc;

            public final void close() {
            }
        };
        String readUTF = c18322.readUTF();
        if (this.aWB.equals(readUTF)) {
            return this.bcb.hi(c18322.readInt()).mo1106j(c18322);
        }
        throw new IOException("Signature: " + readUTF + " is invalid");
    }
}
