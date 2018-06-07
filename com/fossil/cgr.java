package com.fossil;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class cgr<T> extends cfw<T> {
    private final cfw<T> bQX;
    private final cfj bSO;
    private final Type type;

    public cgr(cfj com_fossil_cfj, cfw<T> com_fossil_cfw_T, Type type) {
        this.bSO = com_fossil_cfj;
        this.bQX = com_fossil_cfw_T;
        this.type = type;
    }

    public T mo1657b(cgv com_fossil_cgv) throws IOException {
        return this.bQX.mo1657b(com_fossil_cgv);
    }

    public void mo1656a(cgw com_fossil_cgw, T t) throws IOException {
        cfw com_fossil_cfw = this.bQX;
        Type b = m6274b(this.type, t);
        if (b != this.type) {
            com_fossil_cfw = this.bSO.m6190a(cgu.get(b));
            if ((com_fossil_cfw instanceof a) && !(this.bQX instanceof a)) {
                com_fossil_cfw = this.bQX;
            }
        }
        com_fossil_cfw.mo1656a(com_fossil_cgw, t);
    }

    private Type m6274b(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
