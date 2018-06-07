package com.fossil;

import com.fossil.agy.C1636a;
import com.fossil.ahc.C1639a;
import com.fossil.amk.C1703a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ahj {
    Class<? extends agy> Ec() default C1636a.class;

    Class<? extends agy> Ed() default C1636a.class;

    Class<? extends ahc> Ee() default C1639a.class;

    Class<?> Ef() default Void.class;

    Class<? extends amk> Eg() default C1703a.class;

    Class<?> Eh() default Void.class;

    Class<?> Ei() default Void.class;

    Class<?> Ej() default Void.class;

    Class<? extends amk> converter() default C1703a.class;
}
