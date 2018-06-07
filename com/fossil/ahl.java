package com.fossil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ahl {

    public static class C1642a {
        public final String aQD;
        public final String aQE;

        public C1642a(ahl com_fossil_ahl) {
            this.aQD = com_fossil_ahl.Ek();
            this.aQE = com_fossil_ahl.El();
        }
    }

    String Ek() default "build";

    String El() default "with";
}
