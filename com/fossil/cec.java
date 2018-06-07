package com.fossil;

import java.lang.reflect.TypeVariable;

public abstract class cec<T> extends ceb<T> {
    public final TypeVariable<?> bOq;

    protected cec() {
        Object capture = capture();
        cco.m5986a(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.bOq = (TypeVariable) capture;
    }

    public final int hashCode() {
        return this.bOq.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cec)) {
            return false;
        }
        return this.bOq.equals(((cec) obj).bOq);
    }

    public String toString() {
        return this.bOq.toString();
    }
}
