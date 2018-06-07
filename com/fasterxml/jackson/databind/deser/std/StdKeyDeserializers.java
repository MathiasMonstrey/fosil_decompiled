package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.aib;
import com.fossil.ami;
import java.io.Serializable;
import java.lang.reflect.Member;

public class StdKeyDeserializers implements aib, Serializable {
    private static final long serialVersionUID = 1;

    public static ahc constructEnumKeyDeserializer(EnumResolver enumResolver) {
        return new EnumKD(enumResolver, null);
    }

    public static ahc constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
        return new EnumKD(enumResolver, annotatedMethod);
    }

    public static ahc constructDelegatingKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, agy<?> com_fossil_agy_) {
        return new DelegatingKD(javaType.getRawClass(), com_fossil_agy_);
    }

    public static ahc findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        agu introspect = deserializationConfig.introspect(javaType);
        Member a = introspect.mo981a(String.class);
        if (a != null) {
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ami.m3862a(a);
            }
            return new StringCtorKeyDeserializer(a);
        }
        a = introspect.mo983b(String.class);
        if (a == null) {
            return null;
        }
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ami.m3862a(a);
        }
        return new StringFactoryKeyDeserializer(a);
    }

    public ahc findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            rawClass = ami.m3851A(rawClass);
        }
        return StdKeyDeserializer.forType(rawClass);
    }
}
