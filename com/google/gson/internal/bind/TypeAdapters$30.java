package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgs.a;
import com.fossil.cgu;

public class TypeAdapters$30 implements cfx {
    public <T> cfw<T> m14635a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Class rawType = com_fossil_cgu_T.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new a(rawType);
    }
}
