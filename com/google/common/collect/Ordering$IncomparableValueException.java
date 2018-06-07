package com.google.common.collect;

class Ordering$IncomparableValueException extends ClassCastException {
    private static final long serialVersionUID = 0;
    final Object value;

    Ordering$IncomparableValueException(Object obj) {
        super("Cannot compare value: " + obj);
        this.value = obj;
    }
}
