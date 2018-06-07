package com.fossil;

import com.google.android.gms.common.api.GoogleApiActivity;

final class bdw implements Runnable {
    final /* synthetic */ bdu brA;
    private final bdv brz;

    bdw(bdu com_fossil_bdu, bdv com_fossil_bdv) {
        this.brA = com_fossil_bdu;
        this.brz = com_fossil_bdv;
    }

    public final void run() {
        if (this.brA.mStarted) {
            atn Ld = this.brz.Ld();
            if (Ld.Ks()) {
                this.brA.buq.startActivityForResult(GoogleApiActivity.a(this.brA.getActivity(), Ld.Kt(), this.brz.Nf(), false), 1);
            } else if (this.brA.bgp.hn(Ld.getErrorCode())) {
                this.brA.bgp.m4448a(this.brA.getActivity(), this.brA.buq, Ld.getErrorCode(), 2, this.brA);
            } else if (Ld.getErrorCode() == 18) {
                atp.m4442a(this.brA.getActivity().getApplicationContext(), new bdx(this, atp.m4440a(this.brA.getActivity(), this.brA)));
            } else {
                this.brA.mo1280a(Ld, this.brz.Nf());
            }
        }
    }
}
