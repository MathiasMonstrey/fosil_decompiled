package com.fossil;

import android.os.RemoteException;
import com.fossil.ats.C1887c;
import com.google.android.gms.fitness.data.DataSet;

final class blg extends bjy {
    private /* synthetic */ DataSet bwa;
    private /* synthetic */ boolean bwb = false;

    blg(blf com_fossil_blf, atv com_fossil_atv, DataSet dataSet, boolean z) {
        this.bwa = dataSet;
        super(com_fossil_atv);
    }

    protected final /* synthetic */ void mo1171a(C1887c c1887c) throws RemoteException {
        ((bkn) ((bjv) c1887c).Lm()).mo1379a(new baw(this.bwa, new bll(this), this.bwb));
    }
}
