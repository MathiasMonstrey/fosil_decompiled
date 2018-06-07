package com.fossil;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;

public final class ait implements amc {
    protected HashMap<Class<? extends Annotation>, Annotation> aSx;

    private ait(HashMap<Class<? extends Annotation>, Annotation> hashMap) {
        this.aSx = hashMap;
    }

    public <A extends Annotation> A mo959j(Class<A> cls) {
        if (this.aSx == null) {
            return null;
        }
        return (Annotation) this.aSx.get(cls);
    }

    public Iterable<Annotation> annotations() {
        if (this.aSx == null || this.aSx.size() == 0) {
            return Collections.emptyList();
        }
        return this.aSx.values();
    }

    public static ait m3448a(ait com_fossil_ait, ait com_fossil_ait2) {
        if (com_fossil_ait == null || com_fossil_ait.aSx == null || com_fossil_ait.aSx.isEmpty()) {
            return com_fossil_ait2;
        }
        if (com_fossil_ait2 == null || com_fossil_ait2.aSx == null || com_fossil_ait2.aSx.isEmpty()) {
            return com_fossil_ait;
        }
        HashMap hashMap = new HashMap();
        for (Annotation annotation : com_fossil_ait2.aSx.values()) {
            hashMap.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : com_fossil_ait.aSx.values()) {
            hashMap.put(annotation2.annotationType(), annotation2);
        }
        return new ait(hashMap);
    }

    public int size() {
        return this.aSx == null ? 0 : this.aSx.size();
    }

    public boolean addIfNotPresent(Annotation annotation) {
        if (this.aSx != null && this.aSx.containsKey(annotation.annotationType())) {
            return false;
        }
        m3450c(annotation);
        return true;
    }

    public boolean m3449b(Annotation annotation) {
        return m3450c(annotation);
    }

    public String toString() {
        if (this.aSx == null) {
            return "[null]";
        }
        return this.aSx.toString();
    }

    protected final boolean m3450c(Annotation annotation) {
        if (this.aSx == null) {
            this.aSx = new HashMap();
        }
        Annotation annotation2 = (Annotation) this.aSx.put(annotation.annotationType(), annotation);
        return annotation2 == null || !annotation2.equals(annotation);
    }
}
