package com.fasterxml.jackson.core.io;

import com.fossil.afo;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream decorate(afo com_fossil_afo, InputStream inputStream) throws IOException;

    public abstract InputStream decorate(afo com_fossil_afo, byte[] bArr, int i, int i2) throws IOException;

    public abstract Reader decorate(afo com_fossil_afo, Reader reader) throws IOException;
}
