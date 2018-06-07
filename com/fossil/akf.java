package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class akf extends ake {
    protected final MapperConfig<?> aSz;
    protected final HashMap<String, String> aTp;
    protected final HashMap<String, JavaType> aTq;

    protected akf(MapperConfig<?> mapperConfig, JavaType javaType, HashMap<String, String> hashMap, HashMap<String, JavaType> hashMap2) {
        super(javaType, mapperConfig.getTypeFactory());
        this.aSz = mapperConfig;
        this.aTp = hashMap;
        this.aTq = hashMap2;
    }

    public static akf m3654a(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        if (z == z2) {
            throw new IllegalArgumentException();
        }
        HashMap hashMap;
        HashMap hashMap2;
        if (z) {
            hashMap = new HashMap();
        } else {
            hashMap = null;
        }
        if (z2) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = null;
        }
        if (collection != null) {
            for (NamedType namedType : collection) {
                Object name;
                Class type = namedType.getType();
                if (namedType.hasName()) {
                    name = namedType.getName();
                } else {
                    String l = m3655l(type);
                }
                if (z) {
                    hashMap.put(type.getName(), name);
                }
                if (z2) {
                    JavaType javaType2 = (JavaType) hashMap2.get(name);
                    if (javaType2 == null || !type.isAssignableFrom(javaType2.getRawClass())) {
                        hashMap2.put(name, mapperConfig.constructType(type));
                    }
                }
            }
        }
        return new akf(mapperConfig, javaType, hashMap, hashMap2);
    }

    public String bA(Object obj) {
        return m3658k(obj.getClass());
    }

    protected String m3658k(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String str;
        Class rawClass = this._typeFactory.constructType((Type) cls).getRawClass();
        String name = rawClass.getName();
        synchronized (this.aTp) {
            str = (String) this.aTp.get(name);
            if (str == null) {
                if (this.aSz.isAnnotationProcessingEnabled()) {
                    str = this.aSz.getAnnotationIntrospector().findTypeName(this.aSz.introspectClassAnnotations(rawClass).Dn());
                }
                if (str == null) {
                    str = m3655l(rawClass);
                }
                this.aTp.put(name, str);
            }
        }
        return str;
    }

    public String mo1045a(Object obj, Class<?> cls) {
        if (obj == null) {
            return m3658k(cls);
        }
        return bA(obj);
    }

    @Deprecated
    public JavaType bT(String str) {
        return bU(str);
    }

    public JavaType mo1042a(agw com_fossil_agw, String str) {
        return bU(str);
    }

    protected JavaType bU(String str) {
        return (JavaType) this.aTq.get(str);
    }

    public String Gj() {
        return new TreeSet(this.aTq.keySet()).toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(getClass().getName());
        stringBuilder.append("; id-to-type=").append(this.aTq);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected static String m3655l(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf < 0 ? name : name.substring(lastIndexOf + 1);
    }
}
