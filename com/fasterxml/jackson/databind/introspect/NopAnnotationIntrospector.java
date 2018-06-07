package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fossil.ahs;
import java.io.Serializable;

public abstract class NopAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    public static final NopAnnotationIntrospector instance = new C15221();
    private static final long serialVersionUID = 1;

    static class C15221 extends NopAnnotationIntrospector {
        private static final long serialVersionUID = 1;

        C15221() {
        }

        public Version version() {
            return ahs.aOo;
        }
    }

    public Version version() {
        return Version.unknownVersion();
    }
}
