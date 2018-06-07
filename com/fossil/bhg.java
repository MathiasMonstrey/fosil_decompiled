package com.fossil;

import com.fossil.ats.C1888f;
import com.fossil.ats.C1892d;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class bhg {
    public static final Status buX = new Status(8, "The connection to Google Play services was lost");
    private static final bdy<?>[] buY = new bdy[0];
    private final Map<C1892d<?>, C1888f> btl;
    final Set<bdy<?>> buZ = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final bhi bva = new bhh(this);

    public bhg(Map<C1892d<?>, C1888f> map) {
        this.btl = map;
    }

    public final void Ou() {
        for (bdy j : (bdy[]) this.buZ.toArray(buY)) {
            j.m4407j(buX);
        }
    }

    final void m5174b(bdy<? extends atz> com_fossil_bdy__extends_com_fossil_atz) {
        this.buZ.add(com_fossil_bdy__extends_com_fossil_atz);
        com_fossil_bdy__extends_com_fossil_atz.m4404a(this.bva);
    }

    public final void release() {
        for (bdy com_fossil_bdy : (bdy[]) this.buZ.toArray(buY)) {
            com_fossil_bdy.m4404a(null);
            com_fossil_bdy.KJ();
            if (com_fossil_bdy.Nh()) {
                this.buZ.remove(com_fossil_bdy);
            }
        }
    }
}
