package com.fossil;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class amf {
    public static String m3840a(AnnotatedMethod annotatedMethod, boolean z) {
        String name = annotatedMethod.getName();
        String b = m3841b(annotatedMethod, name, z);
        if (b == null) {
            return m3839a(annotatedMethod, name, z);
        }
        return b;
    }

    public static String m3839a(AnnotatedMethod annotatedMethod, String str, boolean z) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (m3843e(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && m3844f(annotatedMethod)) {
            return null;
        }
        return z ? m3846n(str, 3) : m3845m(str, 3);
    }

    public static String m3841b(AnnotatedMethod annotatedMethod, String str, boolean z) {
        if (str.startsWith("is")) {
            Class rawType = annotatedMethod.getRawType();
            if (rawType == Boolean.class || rawType == Boolean.TYPE) {
                return z ? m3846n(str, 2) : m3845m(str, 2);
            }
        }
        return null;
    }

    public static String m3842c(AnnotatedMethod annotatedMethod, String str, boolean z) {
        String name = annotatedMethod.getName();
        if (name.startsWith(str)) {
            return z ? m3846n(name, str.length()) : m3845m(name, str.length());
        } else {
            return null;
        }
    }

    protected static boolean m3843e(AnnotatedMethod annotatedMethod) {
        Class rawType = annotatedMethod.getRawType();
        if (rawType == null || !rawType.isArray()) {
            return false;
        }
        Package packageR = rawType.getComponentType().getPackage();
        if (packageR == null) {
            return false;
        }
        String name = packageR.getName();
        if (!name.contains(".cglib")) {
            return false;
        }
        if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib")) {
            return true;
        }
        return false;
    }

    protected static boolean m3844f(AnnotatedMethod annotatedMethod) {
        Class rawType = annotatedMethod.getRawType();
        if (rawType == null || rawType.isArray()) {
            return false;
        }
        Package packageR = rawType.getPackage();
        if (packageR == null || !packageR.getName().startsWith("groovy.lang")) {
            return false;
        }
        return true;
    }

    protected static String m3845m(String str, int i) {
        StringBuilder stringBuilder = null;
        int length = str.length();
        if (length == i) {
            return null;
        }
        for (int i2 = i; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            char toLowerCase = Character.toLowerCase(charAt);
            if (charAt == toLowerCase) {
                break;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(length - i);
                stringBuilder.append(str, i, length);
            }
            stringBuilder.setCharAt(i2 - i, toLowerCase);
        }
        if (stringBuilder == null) {
            return str.substring(i);
        }
        return stringBuilder.toString();
    }

    protected static String m3846n(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char charAt = str.charAt(i);
        char toLowerCase = Character.toLowerCase(charAt);
        if (charAt == toLowerCase) {
            return str.substring(i);
        }
        if (i + 1 < length && Character.isUpperCase(str.charAt(i + 1))) {
            return str.substring(i);
        }
        StringBuilder stringBuilder = new StringBuilder(length - i);
        stringBuilder.append(toLowerCase);
        stringBuilder.append(str, i + 1, length);
        return stringBuilder.toString();
    }
}
