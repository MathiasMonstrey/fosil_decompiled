package com.fasterxml.jackson.databind.introspect;

import com.fossil.air;
import com.fossil.ait;
import com.fossil.ami;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public final class AnnotatedField extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient Field _field;
    protected Serialization _serialization;

    static final class Serialization implements Serializable {
        private static final long serialVersionUID = 1;
        protected Class<?> clazz;
        protected String name;

        public Serialization(Field field) {
            this.clazz = field.getDeclaringClass();
            this.name = field.getName();
        }
    }

    public AnnotatedField(air com_fossil_air, Field field, ait com_fossil_ait) {
        super(com_fossil_air, com_fossil_ait);
        this._field = field;
    }

    public AnnotatedField withAnnotations(ait com_fossil_ait) {
        return new AnnotatedField(this._context, this._field, com_fossil_ait);
    }

    protected AnnotatedField(Serialization serialization) {
        super(null, null);
        this._field = null;
        this._serialization = serialization;
    }

    public Field getAnnotated() {
        return this._field;
    }

    public int getModifiers() {
        return this._field.getModifiers();
    }

    public String getName() {
        return this._field.getName();
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotations == null ? null : this._annotations.mo959j(cls);
    }

    public Type getGenericType() {
        return this._field.getGenericType();
    }

    public Class<?> getRawType() {
        return this._field.getType();
    }

    public Class<?> getDeclaringClass() {
        return this._field.getDeclaringClass();
    }

    public Member getMember() {
        return this._field;
    }

    public void setValue(Object obj, Object obj2) throws IllegalArgumentException {
        try {
            this._field.set(obj, obj2);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to setValue() for field " + getFullName() + ": " + e.getMessage(), e);
        }
    }

    public Object getValue(Object obj) throws IllegalArgumentException {
        try {
            return this._field.get(obj);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to getValue() for field " + getFullName() + ": " + e.getMessage(), e);
        }
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    public int getAnnotationCount() {
        return this._annotations.size();
    }

    public boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    public int hashCode() {
        return this._field.getName().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (((AnnotatedField) obj)._field != this._field) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[field " + getFullName() + "]";
    }

    Object writeReplace() {
        return new AnnotatedField(new Serialization(this._field));
    }

    Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Member declaredField = cls.getDeclaredField(this._serialization.name);
            if (!declaredField.isAccessible()) {
                ami.m3862a(declaredField);
            }
            return new AnnotatedField(null, declaredField, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find method '" + this._serialization.name + "' from Class '" + cls.getName());
        }
    }
}
