package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgl;
import com.fossil.cgu;
import java.util.Date;

public class DateTypeAdapter$1 implements cfx {
    public <T> cfw<T> m14597a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        return com_fossil_cgu_T.getRawType() == Date.class ? new cgl() : null;
    }
}
