package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        USE_DEFAULTS
    }

    public static class C1502a {
        protected static final C1502a aLe = new C1502a(Include.USE_DEFAULTS, Include.USE_DEFAULTS);
        protected final Include aLf;
        protected final Include aLg;

        protected C1502a(Include include, Include include2) {
            if (include == null) {
                include = Include.USE_DEFAULTS;
            }
            this.aLf = include;
            if (include2 == null) {
                include2 = Include.USE_DEFAULTS;
            }
            this.aLg = include2;
        }

        public C1502a m2656a(C1502a c1502a) {
            return c1502a == null ? this : m2655a(c1502a.aLf).m2657b(c1502a.aLg);
        }

        public static C1502a m2654a(Include include, Include include2) {
            if (include == Include.USE_DEFAULTS && include2 == Include.USE_DEFAULTS) {
                return aLe;
            }
            return new C1502a(include, include2);
        }

        public C1502a m2655a(Include include) {
            return include == this.aLf ? this : new C1502a(include, this.aLg);
        }

        public C1502a m2657b(Include include) {
            return include == this.aLg ? this : new C1502a(this.aLf, include);
        }
    }

    Include zl() default Include.ALWAYS;

    Include zm() default Include.ALWAYS;
}
