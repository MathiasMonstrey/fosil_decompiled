package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonProperty {

    public enum Access {
        AUTO,
        READ_ONLY,
        WRITE_ONLY,
        READ_WRITE
    }

    String defaultValue() default "";

    String value() default "";

    boolean zn() default false;

    int zo() default -1;

    Access zp() default Access.AUTO;
}
