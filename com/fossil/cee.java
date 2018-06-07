package com.fossil;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

public abstract class cee {
    private final Set<Type> bOT = Sets.VC();

    protected cee() {
    }

    public final void m6058g(Type... typeArr) {
        for (Object obj : typeArr) {
            if (obj != null && this.bOT.add(obj)) {
                try {
                    if (obj instanceof TypeVariable) {
                        mo1648a((TypeVariable) obj);
                    } else if (obj instanceof WildcardType) {
                        mo1651b((WildcardType) obj);
                    } else if (obj instanceof ParameterizedType) {
                        mo1650b((ParameterizedType) obj);
                    } else if (obj instanceof Class) {
                        mo1647P((Class) obj);
                    } else if (obj instanceof GenericArrayType) {
                        mo1649b((GenericArrayType) obj);
                    } else {
                        throw new AssertionError("Unknown type: " + obj);
                    }
                } catch (Throwable th) {
                    this.bOT.remove(obj);
                }
            }
        }
    }

    public void mo1647P(Class<?> cls) {
    }

    public void mo1649b(GenericArrayType genericArrayType) {
    }

    public void mo1650b(ParameterizedType parameterizedType) {
    }

    public void mo1648a(TypeVariable<?> typeVariable) {
    }

    public void mo1651b(WildcardType wildcardType) {
    }
}
