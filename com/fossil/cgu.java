package com.fossil;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class cgu<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected cgu() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    cgu(Type type) {
        this.type = Types.v((Type) cgd.ce(type));
        this.rawType = Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return Types.v(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(Types.getRawType(type));
        }
        if (this.type instanceof ParameterizedType) {
            return isAssignableFrom(type, (ParameterizedType) this.type, new HashMap());
        }
        if (this.type instanceof GenericArrayType) {
            boolean z;
            if (this.rawType.isAssignableFrom(Types.getRawType(type)) && isAssignableFrom(type, (GenericArrayType) this.type)) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    @Deprecated
    public boolean isAssignableFrom(cgu<?> com_fossil_cgu_) {
        return isAssignableFrom(com_fossil_cgu_.getType());
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        int i = 0;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        int i2;
        Class rawType = Types.getRawType(type);
        if (type instanceof ParameterizedType) {
            type = (ParameterizedType) type;
        } else {
            type = null;
        }
        if (type != null) {
            Type[] actualTypeArguments = type.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType.getTypeParameters();
            for (i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Object obj = actualTypeArguments[i2];
                TypeVariable typeVariable = typeParameters[i2];
                while (obj instanceof TypeVariable) {
                    Type type2 = (Type) map.get(((TypeVariable) obj).getName());
                }
                map.put(typeVariable.getName(), obj);
            }
            if (typeEquals(type, parameterizedType, map)) {
                return true;
            }
        }
        Type[] genericInterfaces = rawType.getGenericInterfaces();
        i2 = genericInterfaces.length;
        while (i < i2) {
            if (isAssignableFrom(genericInterfaces[i], parameterizedType, new HashMap(map))) {
                return true;
            }
            i++;
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class name : clsArr) {
            stringBuilder.append(name.getName()).append(", ");
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError(stringBuilder.toString());
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof cgu) && Types.equals(this.type, ((cgu) obj).type);
    }

    public final String toString() {
        return Types.typeToString(this.type);
    }

    public static cgu<?> get(Type type) {
        return new cgu(type);
    }

    public static <T> cgu<T> get(Class<T> cls) {
        return new cgu(cls);
    }

    public static cgu<?> getParameterized(Type type, Type... typeArr) {
        return new cgu(Types.a(null, type, typeArr));
    }

    public static cgu<?> getArray(Type type) {
        return new cgu(Types.u(type));
    }
}
