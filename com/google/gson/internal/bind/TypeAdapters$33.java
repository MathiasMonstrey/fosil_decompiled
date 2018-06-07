package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;

public class TypeAdapters$33 implements cfx {
    final /* synthetic */ cfw bSw;
    final /* synthetic */ Class bTS;
    final /* synthetic */ Class bTT;

    public TypeAdapters$33(Class cls, Class cls2, cfw com_fossil_cfw) {
        this.bTS = cls;
        this.bTT = cls2;
        this.bSw = com_fossil_cfw;
    }

    public <T> cfw<T> m14638a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Class rawType = com_fossil_cgu_T.getRawType();
        return (rawType == this.bTS || rawType == this.bTT) ? this.bSw : null;
    }

    public String toString() {
        return "Factory[type=" + this.bTT.getName() + "+" + this.bTS.getName() + ",adapter=" + this.bSw + "]";
    }
}
