package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.fossil.atn;
import com.fossil.ats.a;
import com.fossil.atu;
import com.fossil.awa;
import com.fossil.bdn;
import com.fossil.jl;
import java.util.ArrayList;

public final class zza extends Exception {
    private final jl<bdn<?>, atn> zzaAB;

    public zza(jl<bdn<?>, atn> jlVar) {
        this.zzaAB = jlVar;
    }

    public final String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (bdn com_fossil_bdn : this.zzaAB.keySet()) {
            atn com_fossil_atn = (atn) this.zzaAB.get(com_fossil_bdn);
            if (com_fossil_atn.Kb()) {
                obj = null;
            }
            String valueOf = String.valueOf(com_fossil_bdn.MY());
            String valueOf2 = String.valueOf(com_fossil_atn);
            arrayList.add(new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }

    public final atn zza(atu<? extends a> com_fossil_atu__extends_com_fossil_ats_a) {
        bdn KB = com_fossil_atu__extends_com_fossil_ats_a.KB();
        awa.b(this.zzaAB.get(KB) != null, "The given API was not part of the availability request.");
        return (atn) this.zzaAB.get(KB);
    }

    public final jl<bdn<?>, atn> zzpf() {
        return this.zzaAB;
    }
}
