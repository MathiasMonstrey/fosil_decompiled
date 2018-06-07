package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;

public class TypeAdapters$34 implements cfx {
    final /* synthetic */ cfw bSw;
    final /* synthetic */ Class bTU;
    final /* synthetic */ Class bTV;

    public TypeAdapters$34(Class cls, Class cls2, cfw com_fossil_cfw) {
        this.bTU = cls;
        this.bTV = cls2;
        this.bSw = com_fossil_cfw;
    }

    public <T> cfw<T> m14639a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Class rawType = com_fossil_cgu_T.getRawType();
        return (rawType == this.bTU || rawType == this.bTV) ? this.bSw : null;
    }

    public String toString() {
        return "Factory[type=" + this.bTU.getName() + "+" + this.bTV.getName() + ",adapter=" + this.bSw + "]";
    }
}
