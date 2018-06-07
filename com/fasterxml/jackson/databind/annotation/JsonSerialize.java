package com.fasterxml.jackson.databind.annotation;

import com.fossil.ahb;
import com.fossil.ahb.C1638a;
import com.fossil.amk;
import com.fossil.amk.C1703a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerialize {

    @Deprecated
    public enum Inclusion {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    public enum Typing {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class<? extends ahb> Ec() default C1638a.class;

    Class<? extends ahb> Ed() default C1638a.class;

    Class<? extends ahb> Ee() default C1638a.class;

    Class<? extends amk> Eg() default C1703a.class;

    Class<?> Eh() default Void.class;

    Class<?> Ei() default Void.class;

    Class<?> Ej() default Void.class;

    Class<? extends ahb> Em() default C1638a.class;

    Typing En() default Typing.DEFAULT_TYPING;

    @Deprecated
    Inclusion Eo() default Inclusion.DEFAULT_INCLUSION;

    Class<? extends amk> converter() default C1703a.class;
}
