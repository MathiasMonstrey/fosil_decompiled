package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgk;
import com.fossil.cgu;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class ArrayTypeAdapter$1 implements cfx {
    public <T> cfw<T> m14591a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Type type = com_fossil_cgu_T.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        type = C$Gson$Types.m14577w(type);
        return new cgk(com_fossil_cfj, com_fossil_cfj.a(cgu.get(type)), C$Gson$Types.getRawType(type));
    }
}
