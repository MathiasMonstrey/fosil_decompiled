package com.fossil;

public class xl<T> implements vh<T> {
    protected final T data;

    public xl(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = t;
    }

    public final T get() {
        return this.data;
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}
