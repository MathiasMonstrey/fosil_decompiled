package com.fossil;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class ben {
    private final Map<bdy<?>, Boolean> bsA = Collections.synchronizedMap(new WeakHashMap());
    private final Map<cah<?>, Boolean> bsB = Collections.synchronizedMap(new WeakHashMap());

    private final void m4987a(boolean z, Status status) {
        synchronized (this.bsA) {
            Map hashMap = new HashMap(this.bsA);
        }
        synchronized (this.bsB) {
            Map hashMap2 = new HashMap(this.bsB);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((bdy) entry.getKey()).m4407j(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((cah) entry2.getKey()).m5863i(new ApiException(status));
            }
        }
    }

    final boolean Nv() {
        return (this.bsA.isEmpty() && this.bsB.isEmpty()) ? false : true;
    }

    public final void Nw() {
        m4987a(false, bfs.btL);
    }

    public final void Nx() {
        m4987a(true, bhg.buX);
    }

    final void m4988a(bdy<? extends atz> com_fossil_bdy__extends_com_fossil_atz, boolean z) {
        this.bsA.put(com_fossil_bdy__extends_com_fossil_atz, Boolean.valueOf(z));
        com_fossil_bdy__extends_com_fossil_atz.mo1168a(new beo(this, com_fossil_bdy__extends_com_fossil_atz));
    }
}
