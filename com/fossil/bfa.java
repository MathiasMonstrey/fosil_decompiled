package com.fossil;

import com.fossil.ats.C1888f;
import java.util.ArrayList;

final class bfa extends bfe {
    private /* synthetic */ beu bsV;
    private final ArrayList<C1888f> btb;

    public bfa(beu com_fossil_beu, ArrayList<C1888f> arrayList) {
        this.bsV = com_fossil_beu;
        super(com_fossil_beu);
        this.btb = arrayList;
    }

    public final void NB() {
        this.bsV.bsG.brW.btm = this.bsV.NH();
        ArrayList arrayList = this.btb;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((C1888f) obj).m4387a(this.bsV.bsS, this.bsV.bsG.brW.btm);
        }
    }
}
