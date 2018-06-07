package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.baa;
import com.fossil.baf;
import com.fossil.bau;
import com.fossil.bjf;
import com.google.android.gms.common.annotation.KeepName;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawDataPoint extends auq {
    public static final Creator<RawDataPoint> CREATOR = new bau();
    public final long boq;
    public final long bor;
    public final baf[] bos;
    public final int bot;
    public final int bou;
    public final long bov;
    public final long bow;
    private int versionCode;

    public RawDataPoint(int i, long j, long j2, baf[] com_fossil_bafArr, int i2, int i3, long j3, long j4) {
        this.versionCode = i;
        this.boq = j;
        this.bor = j2;
        this.bot = i2;
        this.bou = i3;
        this.bov = j3;
        this.bow = j4;
        this.bos = com_fossil_bafArr;
    }

    RawDataPoint(DataPoint dataPoint, List<baa> list) {
        this.versionCode = 4;
        this.boq = dataPoint.m14234a(TimeUnit.NANOSECONDS);
        this.bor = dataPoint.m14237b(TimeUnit.NANOSECONDS);
        this.bos = dataPoint.LR();
        this.bot = bjf.a(dataPoint.LT(), list);
        this.bou = bjf.a(dataPoint.LV(), list);
        this.bov = dataPoint.LW();
        this.bow = dataPoint.LX();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof RawDataPoint)) {
                return false;
            }
            RawDataPoint rawDataPoint = (RawDataPoint) obj;
            boolean z = this.boq == rawDataPoint.boq && this.bor == rawDataPoint.bor && Arrays.equals(this.bos, rawDataPoint.bos) && this.bot == rawDataPoint.bot && this.bou == rawDataPoint.bou && this.bov == rawDataPoint.bov;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.boq), Long.valueOf(this.bor)});
    }

    public final String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.bos), Long.valueOf(this.bor), Long.valueOf(this.boq), Integer.valueOf(this.bot), Integer.valueOf(this.bou)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, this.boq);
        aus.a(parcel, 2, this.bor);
        aus.a(parcel, 3, this.bos, i, false);
        aus.c(parcel, 4, this.bot);
        aus.c(parcel, 5, this.bou);
        aus.a(parcel, 6, this.bov);
        aus.a(parcel, 7, this.bow);
        aus.c(parcel, 1000, this.versionCode);
        aus.G(parcel, A);
    }
}
