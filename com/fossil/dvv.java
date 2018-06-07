package com.fossil;

import java.util.LinkedHashSet;
import java.util.Set;

public final class dvv {
    private final Set<dvn> dwT = new LinkedHashSet();

    public synchronized void m9963a(dvn com_fossil_dvn) {
        this.dwT.add(com_fossil_dvn);
    }

    public synchronized void m9964b(dvn com_fossil_dvn) {
        this.dwT.remove(com_fossil_dvn);
    }

    public synchronized boolean m9965c(dvn com_fossil_dvn) {
        return this.dwT.contains(com_fossil_dvn);
    }
}
