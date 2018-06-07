package com.fossil;

import android.os.Bundle;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import java.util.Collections;

public final class bff implements bfn {
    private final bfo bsG;

    public bff(bfo com_fossil_bfo) {
        this.bsG = com_fossil_bfo;
    }

    public final void mo1317a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z) {
    }

    public final void begin() {
        for (C1888f disconnect : this.bsG.btl.values()) {
            disconnect.disconnect();
        }
        this.bsG.brW.btm = Collections.emptySet();
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1319c(T t) {
        this.bsG.brW.bss.add(t);
        return t;
    }

    public final void connect() {
        this.bsG.NN();
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1321d(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean disconnect() {
        return true;
    }

    public final void hr(int i) {
    }

    public final void mo1324l(Bundle bundle) {
    }
}
