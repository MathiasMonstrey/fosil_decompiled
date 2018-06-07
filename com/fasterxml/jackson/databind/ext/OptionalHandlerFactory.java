package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.ahb;
import com.fossil.aia;
import com.fossil.alo;
import java.io.Serializable;

public class OptionalHandlerFactory implements Serializable {
    public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
    private static final long serialVersionUID = 1;

    protected OptionalHandlerFactory() {
    }

    public ahb<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu) {
        Class rawClass = javaType.getRawClass();
        String name = rawClass.getName();
        if (m2742b(rawClass, "org.w3c.dom.Node")) {
            return (ahb) bM("com.fasterxml.jackson.databind.ext.DOMSerializer");
        }
        if (!name.startsWith("javax.xml.") && !m2744d(rawClass, "javax.xml.")) {
            return null;
        }
        Object bM = bM("com.fasterxml.jackson.databind.ext.CoreXMLSerializers");
        if (bM == null) {
            return null;
        }
        return ((alo) bM).findSerializer(serializationConfig, javaType, com_fossil_agu);
    }

    public agy<?> findDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        if (rawClass.getName().startsWith("javax.xml.") || m2744d(rawClass, "javax.xml.")) {
            Object bM = bM("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers");
            if (bM == null) {
                return null;
            }
            return ((aia) bM).m3379a(javaType, deserializationConfig, com_fossil_agu);
        } else if (m2742b(rawClass, "org.w3c.dom.Node")) {
            return (agy) bM("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer");
        } else {
            return m2742b(rawClass, "org.w3c.dom.Node") ? (agy) bM("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer") : null;
        }
    }

    private Object bM(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (LinkageError e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private boolean m2742b(Class<?> cls, String str) {
        while (cls != null) {
            if (cls.getName().equals(str) || m2743c(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean m2743c(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        for (Class name2 : interfaces) {
            if (m2743c(name2, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean m2744d(Class<?> cls, String str) {
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getName().startsWith(str)) {
                return true;
            }
        }
        while (cls != null) {
            if (m2745e(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean m2745e(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().startsWith(str)) {
                return true;
            }
        }
        for (Class name2 : interfaces) {
            if (m2745e(name2, str)) {
                return true;
            }
        }
        return false;
    }
}
