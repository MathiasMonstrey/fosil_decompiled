package com.fossil;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class cfp {
    public boolean Ww() {
        return this instanceof cfm;
    }

    public boolean Wx() {
        return this instanceof cfr;
    }

    public boolean Wy() {
        return this instanceof cft;
    }

    public boolean Wz() {
        return this instanceof cfq;
    }

    public cfr WA() {
        if (Wx()) {
            return (cfr) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public cfm WB() {
        if (Ww()) {
            return (cfm) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public cft WC() {
        if (Wy()) {
            return (cft) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean WD() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number Wv() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            cgw com_fossil_cgw = new cgw(stringWriter);
            com_fossil_cgw.setLenient(true);
            cgi.m6242b(this, com_fossil_cgw);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
