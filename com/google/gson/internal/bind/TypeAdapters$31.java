package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;

public class TypeAdapters$31 implements cfx {
    final /* synthetic */ cgu bRF;
    final /* synthetic */ cfw bSw;

    public TypeAdapters$31(cgu com_fossil_cgu, cfw com_fossil_cfw) {
        this.bRF = com_fossil_cgu;
        this.bSw = com_fossil_cfw;
    }

    public <T> cfw<T> m14636a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        return com_fossil_cgu_T.equals(this.bRF) ? this.bSw : null;
    }
}
