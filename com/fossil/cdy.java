package com.fossil;

import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

class cdy extends AccessibleObject implements Member {
    private final AccessibleObject bOo;
    private final Member bOp;

    <M extends AccessibleObject & Member> cdy(M m) {
        cco.ce(m);
        this.bOo = m;
        this.bOp = (Member) m;
    }

    public TypeToken<?> VF() {
        return TypeToken.of(getDeclaringClass());
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.bOo.isAnnotationPresent(cls);
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.bOo.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.bOo.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.bOo.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean z) throws SecurityException {
        this.bOo.setAccessible(z);
    }

    public final boolean isAccessible() {
        return this.bOo.isAccessible();
    }

    public Class<?> getDeclaringClass() {
        return this.bOp.getDeclaringClass();
    }

    public final String getName() {
        return this.bOp.getName();
    }

    public final int getModifiers() {
        return this.bOp.getModifiers();
    }

    public final boolean isSynthetic() {
        return this.bOp.isSynthetic();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cdy)) {
            return false;
        }
        cdy com_fossil_cdy = (cdy) obj;
        if (VF().equals(com_fossil_cdy.VF()) && this.bOp.equals(com_fossil_cdy.bOp)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.bOp.hashCode();
    }

    public String toString() {
        return this.bOp.toString();
    }
}
