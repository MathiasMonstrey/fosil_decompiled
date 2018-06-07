package com.fossil;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class ais implements Iterable<AnnotatedMethod> {
    protected LinkedHashMap<aix, AnnotatedMethod> aSw;

    public void m3443a(AnnotatedMethod annotatedMethod) {
        if (this.aSw == null) {
            this.aSw = new LinkedHashMap();
        }
        this.aSw.put(new aix(annotatedMethod.getAnnotated()), annotatedMethod);
    }

    public AnnotatedMethod m3445d(Method method) {
        if (this.aSw != null) {
            return (AnnotatedMethod) this.aSw.remove(new aix(method));
        }
        return null;
    }

    public boolean isEmpty() {
        return this.aSw == null || this.aSw.size() == 0;
    }

    public AnnotatedMethod m3444b(String str, Class<?>[] clsArr) {
        if (this.aSw == null) {
            return null;
        }
        return (AnnotatedMethod) this.aSw.get(new aix(str, clsArr));
    }

    public AnnotatedMethod m3446e(Method method) {
        if (this.aSw == null) {
            return null;
        }
        return (AnnotatedMethod) this.aSw.get(new aix(method));
    }

    public Iterator<AnnotatedMethod> iterator() {
        if (this.aSw != null) {
            return this.aSw.values().iterator();
        }
        return Collections.emptyList().iterator();
    }
}
