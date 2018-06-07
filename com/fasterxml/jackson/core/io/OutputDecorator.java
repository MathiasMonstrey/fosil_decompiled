package com.fasterxml.jackson.core.io;

import com.fossil.afo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream decorate(afo com_fossil_afo, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(afo com_fossil_afo, Writer writer) throws IOException;
}
