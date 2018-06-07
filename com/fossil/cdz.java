package com.fossil;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public abstract class cdz<T, R> extends cdy implements GenericDeclaration {

    public static class C2011a<T> extends cdz<T, T> {
        final Constructor<?> constructor;

        protected C2011a(Constructor<?> constructor) {
            super(constructor);
            this.constructor = constructor;
        }

        public Type[] getGenericParameterTypes() {
            Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !VG()) {
                return genericParameterTypes;
            }
            Class[] parameterTypes = this.constructor.getParameterTypes();
            if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
            }
            return genericParameterTypes;
        }

        public final TypeVariable<?>[] getTypeParameters() {
            Object typeParameters = getDeclaringClass().getTypeParameters();
            Object typeParameters2 = this.constructor.getTypeParameters();
            Object obj = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, obj, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, obj, typeParameters.length, typeParameters2.length);
            return obj;
        }

        private boolean VG() {
            Class declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                if (Modifier.isStatic(enclosingMethod.getModifiers())) {
                    return false;
                }
                return true;
            } else if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class C2012b<T> extends cdz<T, Object> {
        final Method method;

        protected C2012b(Method method) {
            super(method);
            this.method = method;
        }

        public Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }
    }

    public abstract Type[] getGenericParameterTypes();

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    <M extends AccessibleObject & Member> cdz(M m) {
        super(m);
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public TypeToken<T> VF() {
        return TypeToken.of(getDeclaringClass());
    }
}
