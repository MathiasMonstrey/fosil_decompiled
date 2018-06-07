package com.fossil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class aqh<T> implements aqi<List<T>> {
    aqi<T> bca;

    public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
        return m4221l(inputStream);
    }

    public aqh(aqi<T> com_fossil_aqi_T) {
        this.bca = com_fossil_aqi_T;
    }

    public final void m4219a(OutputStream outputStream, List<T> list) throws IOException {
        int i = 0;
        if (outputStream != null) {
            int size;
            DataOutputStream c18291 = new DataOutputStream(this, outputStream) {
                final /* synthetic */ aqh aYr;

                public final void close() {
                }
            };
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            c18291.writeInt(size);
            while (i < size) {
                this.bca.mo1105a(outputStream, list.get(i));
                i++;
            }
            c18291.flush();
        }
    }

    public final List<T> m4221l(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int readInt = new DataInputStream(this, inputStream) {
            final /* synthetic */ aqh aYr;

            public final void close() {
            }
        }.readInt();
        List<T> arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            Object j = this.bca.mo1106j(inputStream);
            if (j == null) {
                throw new IOException("Missing record.");
            }
            arrayList.add(j);
        }
        return arrayList;
    }
}
