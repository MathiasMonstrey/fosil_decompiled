package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgo;
import com.fossil.cgu;

public class ObjectTypeAdapter$1 implements cfx {
    public <T> cfw<T> m14607a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        if (com_fossil_cgu_T.getRawType() == Object.class) {
            return new cgo(com_fossil_cfj);
        }
        return null;
    }
}
