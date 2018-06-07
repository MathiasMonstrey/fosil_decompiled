package com.fossil;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

public final class baj implements bjg<DataPoint, DataType> {
    public static final baj boF = new baj();

    private baj() {
    }

    public final bjh<DataType> Mp() {
        return bak.boG;
    }

    public final /* synthetic */ long mo1244a(Object obj, TimeUnit timeUnit) {
        DataPoint dataPoint = (DataPoint) obj;
        return dataPoint.c(timeUnit) - dataPoint.b(timeUnit);
    }

    public final /* synthetic */ Object bR(Object obj) {
        return ((DataPoint) obj).LS();
    }

    public final /* synthetic */ String bS(Object obj) {
        return ((DataPoint) obj).LS().getName();
    }

    public final /* synthetic */ double mo1247o(Object obj, int i) {
        return (double) ((DataPoint) obj).hE(i).Mm();
    }

    public final /* synthetic */ int mo1248p(Object obj, int i) {
        return ((DataPoint) obj).hE(i).Mo();
    }

    public final /* synthetic */ boolean mo1249q(Object obj, int i) {
        return ((DataPoint) obj).hE(i).Mn();
    }
}
