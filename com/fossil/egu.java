package com.fossil;

import java.util.WeakHashMap;

public class egu implements egh {
    WeakHashMap<ecj, ecm> dGX = new WeakHashMap();

    public <R extends ecj> ecm<R> mo2860b(R r) {
        return (ecm) this.dGX.get(r);
    }

    public void mo2861b(ecm com_fossil_ecm) {
        if (com_fossil_ecm != null) {
            this.dGX.put(com_fossil_ecm.aCy(), com_fossil_ecm);
        }
    }

    public long mo2862c(ecj com_fossil_ecj) {
        return 0;
    }
}
