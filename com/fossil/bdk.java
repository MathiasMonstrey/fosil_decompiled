package com.fossil;

import android.os.DeadObjectException;
import com.fossil.ats.C1887c;
import com.google.android.gms.common.api.Status;

public final class bdk<A extends bds<? extends atz, C1887c>> extends bdi {
    private A brf;

    public bdk(int i, A a) {
        super(i);
        this.brf = a;
    }

    public final void mo1269a(ben com_fossil_ben, boolean z) {
        com_fossil_ben.m4988a(this.brf, z);
    }

    public final void mo1270a(bfu<?> com_fossil_bfu_) throws DeadObjectException {
        this.brf.m4410b(com_fossil_bfu_.Nq());
    }

    public final void mo1271h(Status status) {
        this.brf.m4411i(status);
    }
}
