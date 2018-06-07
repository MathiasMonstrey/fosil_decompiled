package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgq;
import com.fossil.cgu;
import java.sql.Time;

public class TimeTypeAdapter$1 implements cfx {
    public <T> cfw<T> m14621a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        return com_fossil_cgu_T.getRawType() == Time.class ? new cgq() : null;
    }
}
