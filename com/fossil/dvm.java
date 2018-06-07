package com.fossil;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class dvm implements Closeable {
    public abstract etj azH() throws IOException;

    public abstract long contentLength() throws IOException;

    public abstract dvh contentType();

    public final InputStream azG() throws IOException {
        return azH().aHj();
    }

    public void close() throws IOException {
        azH().close();
    }
}
