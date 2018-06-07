package com.fossil;

import java.io.IOException;
import java.io.InputStream;

public class yy implements un<InputStream, yu> {
    private final un<wk, yu> aFq;

    public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
        return m14123a((InputStream) obj, i, i2);
    }

    public yy(un<wk, yu> unVar) {
        this.aFq = unVar;
    }

    public vh<yu> m14123a(InputStream inputStream, int i, int i2) throws IOException {
        return this.aFq.mo4436b(new wk(inputStream, null), i, i2);
    }

    public String getId() {
        return this.aFq.getId();
    }
}
