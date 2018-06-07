package com.fossil;

import com.fossil.ats.C1888f;
import java.util.Map;

final class bex extends bfe {
    final /* synthetic */ beu bsV;
    private final Map<C1888f, bew> bsX;

    public bex(beu com_fossil_beu, Map<C1888f, bew> map) {
        this.bsV = com_fossil_beu;
        super(com_fossil_beu);
        this.bsX = map;
    }

    public final void NB() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        for (C1888f c1888f : this.bsX.keySet()) {
            if (!c1888f.Kz()) {
                i = 0;
                i4 = i5;
            } else if (!((bew) this.bsX.get(c1888f)).brU) {
                i = 1;
                break;
            } else {
                i = i4;
                i4 = 1;
            }
            i5 = i4;
            i4 = i;
        }
        i2 = i5;
        i = 0;
        if (i2 != 0) {
            i3 = this.bsV.big.aj(this.bsV.mContext);
        }
        if (i3 == 0 || (r0 == 0 && i4 == 0)) {
            if (this.bsV.bsQ) {
                this.bsV.bsO.connect();
            }
            for (C1888f c1888f2 : this.bsX.keySet()) {
                aws com_fossil_aws = (aws) this.bsX.get(c1888f2);
                if (!c1888f2.Kz() || i3 == 0) {
                    c1888f2.m4388a(com_fossil_aws);
                } else {
                    this.bsV.bsG.m5068a(new bez(this, this.bsV, com_fossil_aws));
                }
            }
            return;
        }
        this.bsV.bsG.m5068a(new bey(this, this.bsV, new atn(i3, null)));
    }
}
