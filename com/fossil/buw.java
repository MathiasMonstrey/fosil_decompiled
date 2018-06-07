package com.fossil;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class buw extends aug<buv> implements atz {
    public buw(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Status Ka() {
        return bvf.io(this.bgD.getStatusCode());
    }

    public /* synthetic */ Object get(int i) {
        return il(i);
    }

    public buv il(int i) {
        return new bwd(this.bgD, i);
    }

    public String toString() {
        return avx.bN(this).m4608b("status", Ka()).toString();
    }
}
