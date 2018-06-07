package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.air;
import com.fossil.ait;
import com.fossil.ama;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final ait[] _paramAnnotations;

    public abstract Object call() throws Exception;

    public abstract Object call(Object[] objArr) throws Exception;

    public abstract Object call1(Object obj) throws Exception;

    public abstract Type getGenericParameterType(int i);

    public abstract int getParameterCount();

    public abstract Class<?> getRawParameterType(int i);

    protected AnnotatedWithParams(air com_fossil_air, ait com_fossil_ait, ait[] com_fossil_aitArr) {
        super(com_fossil_air, com_fossil_ait);
        this._paramAnnotations = com_fossil_aitArr;
    }

    public final void addOrOverrideParam(int i, Annotation annotation) {
        ait com_fossil_ait = this._paramAnnotations[i];
        if (com_fossil_ait == null) {
            com_fossil_ait = new ait();
            this._paramAnnotations[i] = com_fossil_ait;
        }
        com_fossil_ait.m3449b(annotation);
    }

    protected AnnotatedParameter replaceParameterAnnotations(int i, ait com_fossil_ait) {
        this._paramAnnotations[i] = com_fossil_ait;
        return getParameter(i);
    }

    protected JavaType getType(ama com_fossil_ama, TypeVariable<?>[] typeVariableArr) {
        if (typeVariableArr != null && typeVariableArr.length > 0) {
            com_fossil_ama = com_fossil_ama.GX();
            for (TypeVariable typeVariable : typeVariableArr) {
                com_fossil_ama.bZ(typeVariable.getName());
                Type type = typeVariable.getBounds()[0];
                com_fossil_ama.m3830a(typeVariable.getName(), type == null ? TypeFactory.unknownType() : com_fossil_ama.m3829a(type));
            }
        }
        return com_fossil_ama.m3829a(getGenericType());
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotations.mo959j(cls);
    }

    public final ait getParameterAnnotations(int i) {
        if (this._paramAnnotations == null || i < 0 || i >= this._paramAnnotations.length) {
            return null;
        }
        return this._paramAnnotations[i];
    }

    public final AnnotatedParameter getParameter(int i) {
        return new AnnotatedParameter(this, getGenericParameterType(i), getParameterAnnotations(i), i);
    }

    public final JavaType resolveParameterType(int i, ama com_fossil_ama) {
        return com_fossil_ama.m3829a(getGenericParameterType(i));
    }

    public final int getAnnotationCount() {
        return this._annotations.size();
    }
}
