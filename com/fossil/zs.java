package com.fossil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class zs {
    private final Set<aad> aFP = Collections.newSetFromMap(new WeakHashMap());
    private final List<aad> aFQ = new ArrayList();
    private boolean aFR;

    public void m14170a(aad com_fossil_aad) {
        this.aFP.add(com_fossil_aad);
        if (this.aFR) {
            this.aFQ.add(com_fossil_aad);
        } else {
            com_fossil_aad.begin();
        }
    }

    public void m14171b(aad com_fossil_aad) {
        this.aFP.remove(com_fossil_aad);
        this.aFQ.remove(com_fossil_aad);
    }

    public void tP() {
        this.aFR = true;
        for (aad com_fossil_aad : abl.a(this.aFP)) {
            if (com_fossil_aad.isRunning()) {
                com_fossil_aad.pause();
                this.aFQ.add(com_fossil_aad);
            }
        }
    }

    public void tQ() {
        this.aFR = false;
        for (aad com_fossil_aad : abl.a(this.aFP)) {
            if (!(com_fossil_aad.isComplete() || com_fossil_aad.isCancelled() || com_fossil_aad.isRunning())) {
                com_fossil_aad.begin();
            }
        }
        this.aFQ.clear();
    }

    public void wn() {
        for (aad clear : abl.a(this.aFP)) {
            clear.clear();
        }
        this.aFQ.clear();
    }

    public void wo() {
        for (aad com_fossil_aad : abl.a(this.aFP)) {
            if (!(com_fossil_aad.isComplete() || com_fossil_aad.isCancelled())) {
                com_fossil_aad.pause();
                if (this.aFR) {
                    this.aFQ.add(com_fossil_aad);
                } else {
                    com_fossil_aad.begin();
                }
            }
        }
    }
}
