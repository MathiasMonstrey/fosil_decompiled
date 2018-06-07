package com.fossil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ajp {
    String Gf() default "any";

    @Deprecated
    String Gg() default "##irrelevant";

    @Deprecated
    String Gh() default "##irrelevant";

    String id() default "";
}
