package com.fossil;

import java.lang.reflect.Type;

public abstract class agl<T> implements Comparable<agl<T>> {
    protected final Type _type;

    public Type getType() {
        return this._type;
    }
}
