package com.fossil;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSet;

public final class blf implements azw {
    public final atw<Status> mo1382a(atv com_fossil_atv, DataSet dataSet) {
        awa.m4640p(dataSet, "Must set the data set");
        awa.m4634a(!dataSet.Ma().isEmpty(), "Cannot use an empty data set");
        awa.m4640p(dataSet.LT().Mc(), "Must set the app package name for the data source");
        return com_fossil_atv.mo1334c(new blg(this, com_fossil_atv, dataSet, false));
    }
}
