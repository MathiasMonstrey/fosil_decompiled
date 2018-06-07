package com.fossil;

import java.io.InputStream;

public class xc implements xe<byte[]> {
    private final String id;

    public /* synthetic */ us m12653c(Object obj, int i, int i2) {
        return m12652a((byte[]) obj, i, i2);
    }

    public xc() {
        this("");
    }

    @Deprecated
    public xc(String str) {
        this.id = str;
    }

    public us<InputStream> m12652a(byte[] bArr, int i, int i2) {
        return new ur(bArr, this.id);
    }
}
