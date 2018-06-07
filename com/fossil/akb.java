package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.EnumMap;
import java.util.EnumSet;

public class akb extends ake {
    public akb(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
    }

    public String bA(Object obj) {
        return m3652b(obj, obj.getClass());
    }

    public String mo1045a(Object obj, Class<?> cls) {
        return m3652b(obj, cls);
    }

    @Deprecated
    public JavaType bT(String str) {
        return mo1048a(str, this._typeFactory);
    }

    public JavaType mo1042a(agw com_fossil_agw, String str) {
        return mo1048a(str, com_fossil_agw.getTypeFactory());
    }

    protected JavaType mo1048a(String str, TypeFactory typeFactory) {
        if (str.indexOf(60) > 0) {
            return typeFactory.constructFromCanonical(str);
        }
        try {
            return typeFactory.constructSpecializedType(this._baseType, typeFactory.findClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): no such class found");
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): " + e2.getMessage(), e2);
        }
    }

    protected final String m3652b(Object obj, Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (name.startsWith("java.util")) {
            if (obj instanceof EnumSet) {
                return TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, ami.m3858a((EnumSet) obj)).toCanonical();
            } else if (obj instanceof EnumMap) {
                return TypeFactory.defaultInstance().constructMapType(EnumMap.class, ami.m3857a((EnumMap) obj), Object.class).toCanonical();
            } else {
                String substring = name.substring(9);
                if ((substring.startsWith(".Arrays$") || substring.startsWith(".Collections$")) && name.indexOf("List") >= 0) {
                    return "java.util.ArrayList";
                }
                return name;
            }
        } else if (name.indexOf(36) < 0 || ami.m3872w(cls) == null || ami.m3872w(this._baseType.getRawClass()) != null) {
            return name;
        } else {
            return this._baseType.getRawClass().getName();
        }
    }

    public String Gj() {
        return "class name used as type id";
    }
}
