package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class aiq {
    public abstract Iterable<Annotation> annotations();

    public abstract boolean equals(Object obj);

    public abstract ait getAllAnnotations();

    public abstract AnnotatedElement getAnnotated();

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public abstract Type getGenericType();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getRawType();

    public abstract int hashCode();

    public abstract String toString();

    public abstract aiq withAnnotations(ait com_fossil_ait);

    protected aiq() {
    }

    public final <A extends Annotation> boolean hasAnnotation(Class<A> cls) {
        return getAnnotation(cls) != null;
    }

    public final aiq withFallBackAnnotationsFrom(aiq com_fossil_aiq) {
        return withAnnotations(ait.m3448a(getAllAnnotations(), com_fossil_aiq.getAllAnnotations()));
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public JavaType getType(ama com_fossil_ama) {
        return com_fossil_ama.m3829a(getGenericType());
    }
}
