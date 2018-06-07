package com.fossil;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.ahl.C1642a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class agu {
    protected final JavaType _type;

    public abstract amk<Object, Object> DA();

    public abstract amk<Object, Object> DB();

    public abstract Map<Object, AnnotatedMember> DC();

    public abstract Class<?> DD();

    public abstract C1642a DE();

    public abstract air Dn();

    public abstract boolean Do();

    public abstract ama Dp();

    public abstract amc Dq();

    public abstract List<aiv> Dr();

    public abstract Map<String, AnnotatedMember> Ds();

    public abstract Set<String> Dt();

    public abstract List<AnnotatedConstructor> Du();

    public abstract List<AnnotatedMethod> Dv();

    public abstract AnnotatedConstructor Dw();

    public abstract AnnotatedMember Dx();

    public abstract AnnotatedMethod Dy();

    public abstract AnnotatedMethod Dz();

    public abstract C1501b mo978a(C1501b c1501b);

    public abstract JavaType mo979a(Type type);

    public abstract AnnotatedMethod mo980a(String str, Class<?>[] clsArr);

    public abstract Constructor<?> mo981a(Class<?>... clsArr);

    public abstract Object aI(boolean z);

    public abstract Method mo983b(Class<?>... clsArr);

    public abstract Include mo984c(Include include);

    public abstract Include mo985d(Include include);

    public abstract aiy getObjectIdInfo();

    protected agu(JavaType javaType) {
        this._type = javaType;
    }

    public JavaType getType() {
        return this._type;
    }

    public Class<?> getBeanClass() {
        return this._type.getRawClass();
    }
}
