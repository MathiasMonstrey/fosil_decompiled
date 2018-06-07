package com.fossil;

import android.os.Bundle;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bec implements C1898b, C1899c {
    public final ats<?> bfV;
    private final boolean brU;
    private bed brV;

    public bec(ats<?> com_fossil_ats_, boolean z) {
        this.bfV = com_fossil_ats_;
        this.brU = z;
    }

    private final void Nk() {
        awa.m4640p(this.brV, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void mo1273a(atn com_fossil_atn) {
        Nk();
        this.brV.mo1341a(com_fossil_atn, this.bfV, this.brU);
    }

    public final void m4921a(bed com_fossil_bed) {
        this.brV = com_fossil_bed;
    }

    public final void hr(int i) {
        Nk();
        this.brV.hr(i);
    }

    public final void mo1284l(Bundle bundle) {
        Nk();
        this.brV.mo1284l(bundle);
    }
}
