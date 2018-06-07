package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ahi {

    public @interface C1640a {
        String DZ() default "";

        String Ea() default "";

        Include Eb() default Include.NON_NULL;

        String value();

        boolean zn() default false;
    }

    public @interface C1641b {
        Include Eb() default Include.NON_NULL;

        String name() default "";

        Class<?> type() default Object.class;

        Class<? extends alp> value();

        boolean zn() default false;

        String zr() default "";
    }

    C1640a[] DW() default {};

    C1641b[] DX() default {};

    boolean DY() default false;
}
