package com.fossil;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

public abstract class aiw {

    public interface C1505a {
        C1505a copy();

        Class<?> findMixInClassFor(Class<?> cls);
    }

    public abstract agu forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a);

    public abstract agu forCreation(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a);

    public abstract agu forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a);

    public abstract agu forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a);

    public abstract agu forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a);

    public abstract agu forSerialization(SerializationConfig serializationConfig, JavaType javaType, C1505a c1505a);

    protected aiw() {
    }
}
