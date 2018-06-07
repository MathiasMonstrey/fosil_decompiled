package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgp;
import com.fossil.cgu;
import java.sql.Date;

public class SqlDateTypeAdapter$1 implements cfx {
    public <T> cfw<T> m14620a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        return com_fossil_cgu_T.getRawType() == Date.class ? new cgp() : null;
    }
}
