package com.fossil;

import java.util.Iterator;

final class bnx implements Iterator<String> {
    private Iterator<String> byo = this.byp.byn.keySet().iterator();
    private /* synthetic */ bnw byp;

    bnx(bnw com_fossil_bnw) {
        this.byp = com_fossil_bnw;
    }

    public final boolean hasNext() {
        return this.byo.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.byo.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
