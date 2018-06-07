package com.fossil;

import java.util.Iterator;

final class ayt implements azd<T> {
    private /* synthetic */ ays bjH;

    ayt(ays com_fossil_ays) {
        this.bjH = com_fossil_ays;
    }

    public final void mo1219a(T t) {
        this.bjH.bjD = t;
        Iterator it = this.bjH.bjF.iterator();
        while (it.hasNext()) {
            ((aza) it.next()).mo1220b(this.bjH.bjD);
        }
        this.bjH.bjF.clear();
        this.bjH.bjE = null;
    }
}
