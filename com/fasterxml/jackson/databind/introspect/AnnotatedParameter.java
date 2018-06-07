package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.ait;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final int _index;
    protected final AnnotatedWithParams _owner;
    protected final Type _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, Type type, ait com_fossil_ait, int i) {
        super(annotatedWithParams == null ? null : annotatedWithParams.getContextClass(), com_fossil_ait);
        this._owner = annotatedWithParams;
        this._type = type;
        this._index = i;
    }

    public AnnotatedParameter withAnnotations(ait com_fossil_ait) {
        return com_fossil_ait == this._annotations ? this : this._owner.replaceParameterAnnotations(this._index, com_fossil_ait);
    }

    public AnnotatedElement getAnnotated() {
        return null;
    }

    public int getModifiers() {
        return this._owner.getModifiers();
    }

    public String getName() {
        return "";
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotations == null ? null : this._annotations.mo959j(cls);
    }

    public Type getGenericType() {
        return this._type;
    }

    public Class<?> getRawType() {
        if (this._type instanceof Class) {
            return (Class) this._type;
        }
        return TypeFactory.defaultInstance().constructType(this._type).getRawClass();
    }

    public Class<?> getDeclaringClass() {
        return this._owner.getDeclaringClass();
    }

    public Member getMember() {
        return this._owner.getMember();
    }

    public void setValue(Object obj, Object obj2) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + getDeclaringClass().getName());
    }

    public Object getValue(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + getDeclaringClass().getName());
    }

    public Type getParameterType() {
        return this._type;
    }

    public AnnotatedWithParams getOwner() {
        return this._owner;
    }

    public int getIndex() {
        return this._index;
    }

    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        if (annotatedParameter._owner.equals(this._owner) && annotatedParameter._index == this._index) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[parameter #" + getIndex() + ", annotations: " + this._annotations + "]";
    }
}
