package com.fossil;

class qf<T> {
    final T afr;

    qf(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.afr = t;
    }
}
