package com.fossil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ceb<T> {
    protected ceb() {
    }

    public final Type capture() {
        Object genericSuperclass = getClass().getGenericSuperclass();
        cco.m5986a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
