package com.fossil;

public class bep extends bdu {
    private bfs bgb;
    private final axi<bdn<?>> bsE;

    private final void Nz() {
        if (!this.bsE.isEmpty()) {
            this.bgb.m5092a(this);
        }
    }

    protected final void MZ() {
        this.bgb.MZ();
    }

    final axi<bdn<?>> Ny() {
        return this.bsE;
    }

    protected final void mo1280a(atn com_fossil_atn, int i) {
        this.bgb.m5089a(com_fossil_atn, i);
    }

    public final void onResume() {
        super.onResume();
        Nz();
    }

    public final void onStart() {
        super.onStart();
        Nz();
    }

    public final void onStop() {
        super.onStop();
        this.bgb.m5093b(this);
    }
}
