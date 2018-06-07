package com.fasterxml.jackson.databind.introspect;

import com.fossil.aiq;
import com.fossil.air;
import com.fossil.ait;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _declaringClass;
    protected final String _name;
    protected final Class<?> _rawType;

    public VirtualAnnotatedMember(air com_fossil_air, Class<?> cls, String str, Class<?> cls2) {
        super(com_fossil_air, null);
        this._declaringClass = cls;
        this._rawType = cls2;
        this._name = str;
    }

    public aiq withAnnotations(ait com_fossil_ait) {
        return this;
    }

    public Field getAnnotated() {
        return null;
    }

    public int getModifiers() {
        return 0;
    }

    public String getName() {
        return this._name;
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return null;
    }

    public Type getGenericType() {
        return this._rawType;
    }

    public Class<?> getRawType() {
        return this._rawType;
    }

    public Class<?> getDeclaringClass() {
        return this._declaringClass;
    }

    public Member getMember() {
        return null;
    }

    public void setValue(Object obj, Object obj2) throws IllegalArgumentException {
        throw new IllegalArgumentException("Can not set virtual property '" + this._name + "'");
    }

    public Object getValue(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException("Can not get virtual property '" + this._name + "'");
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    public int getAnnotationCount() {
        return 0;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        if (virtualAnnotatedMember._declaringClass == this._declaringClass && virtualAnnotatedMember._name.equals(this._name)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[field " + getFullName() + "]";
    }
}
