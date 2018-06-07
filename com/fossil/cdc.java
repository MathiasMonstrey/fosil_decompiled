package com.fossil;

public abstract class cdc {
    protected abstract Object delegate();

    protected cdc() {
    }

    public String toString() {
        return delegate().toString();
    }
}
