package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public interface amk<IN, OUT> {

    public static abstract class C1703a implements amk<Object, Object> {
    }

    JavaType m3878a(TypeFactory typeFactory);

    JavaType m3879b(TypeFactory typeFactory);

    OUT convert(IN in);
}
