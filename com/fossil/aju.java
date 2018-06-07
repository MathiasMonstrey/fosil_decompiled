package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;

public interface aju<T extends aju<T>> {
    ajs buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection);

    ajv buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    T defaultImpl(Class<?> cls);

    Class<?> getDefaultImpl();

    T inclusion(As as);

    T init(Id id, ajt com_fossil_ajt);

    T typeIdVisibility(boolean z);

    T typeProperty(String str);
}
