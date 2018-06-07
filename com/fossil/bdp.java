package com.fossil;

import com.google.android.gms.common.api.zza;
import java.util.Set;

public final class bdp {
    private final cah<Void> bro = new cah();
    private int brp;
    private boolean brq = false;
    private final jl<bdn<?>, atn> zzaAB = new jl();

    public bdp(Iterable<? extends atu<?>> iterable) {
        for (atu KB : iterable) {
            this.zzaAB.put(KB.KB(), null);
        }
        this.brp = this.zzaAB.keySet().size();
    }

    public final Set<bdn<?>> Na() {
        return this.zzaAB.keySet();
    }

    public final cag<Void> Nb() {
        return this.bro.Nb();
    }

    public final void Nc() {
        this.bro.aV(null);
    }

    public final void m4908a(bdn<?> com_fossil_bdn_, atn com_fossil_atn) {
        this.zzaAB.put(com_fossil_bdn_, com_fossil_atn);
        this.brp--;
        if (!com_fossil_atn.Kb()) {
            this.brq = true;
        }
        if (this.brp != 0) {
            return;
        }
        if (this.brq) {
            this.bro.m5862h(new zza(this.zzaAB));
            return;
        }
        this.bro.aV(null);
    }
}
