package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fossil.air;
import com.fossil.ait;
import com.fossil.ama;
import com.fossil.ami;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient Method _method;
    protected Class<?>[] _paramClasses;
    protected Serialization _serialization;

    static final class Serialization implements Serializable {
        private static final long serialVersionUID = 1;
        protected Class<?>[] args;
        protected Class<?> clazz;
        protected String name;

        public Serialization(Method method) {
            this.clazz = method.getDeclaringClass();
            this.name = method.getName();
            this.args = method.getParameterTypes();
        }
    }

    public AnnotatedMethod(air com_fossil_air, Method method, ait com_fossil_ait, ait[] com_fossil_aitArr) {
        super(com_fossil_air, com_fossil_ait, com_fossil_aitArr);
        if (method == null) {
            throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
        }
        this._method = method;
    }

    protected AnnotatedMethod(Serialization serialization) {
        super(null, null, null);
        this._method = null;
        this._serialization = serialization;
    }

    public AnnotatedMethod withMethod(Method method) {
        return new AnnotatedMethod(this._context, method, this._annotations, this._paramAnnotations);
    }

    public AnnotatedMethod withAnnotations(ait com_fossil_ait) {
        return new AnnotatedMethod(this._context, this._method, com_fossil_ait, this._paramAnnotations);
    }

    public Method getAnnotated() {
        return this._method;
    }

    public int getModifiers() {
        return this._method.getModifiers();
    }

    public String getName() {
        return this._method.getName();
    }

    public Type getGenericType() {
        return this._method.getGenericReturnType();
    }

    public Class<?> getRawType() {
        return this._method.getReturnType();
    }

    public JavaType getType(ama com_fossil_ama) {
        return getType(com_fossil_ama, this._method.getTypeParameters());
    }

    public final Object call() throws Exception {
        return this._method.invoke(null, new Object[0]);
    }

    public final Object call(Object[] objArr) throws Exception {
        return this._method.invoke(null, objArr);
    }

    public final Object call1(Object obj) throws Exception {
        return this._method.invoke(null, new Object[]{obj});
    }

    public Class<?> getDeclaringClass() {
        return this._method.getDeclaringClass();
    }

    public Method getMember() {
        return this._method;
    }

    public void setValue(Object obj, Object obj2) throws IllegalArgumentException {
        try {
            this._method.invoke(obj, new Object[]{obj2});
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + e2.getMessage(), e2);
        }
    }

    public Object getValue(Object obj) throws IllegalArgumentException {
        try {
            return this._method.invoke(obj, new Object[0]);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + e2.getMessage(), e2);
        }
    }

    public int getParameterCount() {
        return getRawParameterTypes().length;
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
    }

    public Class<?>[] getRawParameterTypes() {
        if (this._paramClasses == null) {
            this._paramClasses = this._method.getParameterTypes();
        }
        return this._paramClasses;
    }

    public Type[] getGenericParameterTypes() {
        return this._method.getGenericParameterTypes();
    }

    public Class<?> getRawParameterType(int i) {
        Class[] rawParameterTypes = getRawParameterTypes();
        return i >= rawParameterTypes.length ? null : rawParameterTypes[i];
    }

    public Type getGenericParameterType(int i) {
        Type[] genericParameterTypes = this._method.getGenericParameterTypes();
        return i >= genericParameterTypes.length ? null : genericParameterTypes[i];
    }

    public Class<?> getRawReturnType() {
        return this._method.getReturnType();
    }

    public Type getGenericReturnType() {
        return this._method.getGenericReturnType();
    }

    public boolean hasReturnType() {
        Class rawReturnType = getRawReturnType();
        return (rawReturnType == Void.TYPE || rawReturnType == Void.class) ? false : true;
    }

    public String toString() {
        return "[method " + getFullName() + "]";
    }

    public int hashCode() {
        return this._method.getName().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (((AnnotatedMethod) obj)._method != this._method) {
            return false;
        }
        return true;
    }

    Object writeReplace() {
        return new AnnotatedMethod(new Serialization(this._method));
    }

    Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Member declaredMethod = cls.getDeclaredMethod(this._serialization.name, this._serialization.args);
            if (!declaredMethod.isAccessible()) {
                ami.m3862a(declaredMethod);
            }
            return new AnnotatedMethod(null, declaredMethod, null, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find method '" + this._serialization.name + "' from Class '" + cls.getName());
        }
    }
}
