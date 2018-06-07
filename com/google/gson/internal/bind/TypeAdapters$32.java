package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;

public class TypeAdapters$32 implements cfx {
    final /* synthetic */ cfw bSw;
    final /* synthetic */ Class bTR;

    public TypeAdapters$32(Class cls, cfw com_fossil_cfw) {
        this.bTR = cls;
        this.bSw = com_fossil_cfw;
    }

    public <T> cfw<T> m14637a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        return com_fossil_cgu_T.getRawType() == this.bTR ? this.bSw : null;
    }

    public String toString() {
        return "Factory[type=" + this.bTR.getName() + ",adapter=" + this.bSw + "]";
    }
}
