package com.fossil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class aix {
    static final Class<?>[] NO_CLASSES = new Class[0];
    final String _name;
    final Class<?>[] aSD;

    public aix(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public aix(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public aix(String str, Class<?>[] clsArr) {
        this._name = str;
        if (clsArr == null) {
            clsArr = NO_CLASSES;
        }
        this.aSD = clsArr;
    }

    public String toString() {
        return this._name + "(" + this.aSD.length + "-args)";
    }

    public int hashCode() {
        return this._name.hashCode() + this.aSD.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        aix com_fossil_aix = (aix) obj;
        if (!this._name.equals(com_fossil_aix._name)) {
            return false;
        }
        Class[] clsArr = com_fossil_aix.aSD;
        int length = this.aSD.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this.aSD[i]) {
                return false;
            }
        }
        return true;
    }
}
