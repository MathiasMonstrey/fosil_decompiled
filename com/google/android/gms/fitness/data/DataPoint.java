package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.awa;
import com.fossil.baa;
import com.fossil.bac;
import com.fossil.baf;
import com.fossil.bal;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint extends auq implements ReflectedParcelable {
    public static final Creator<DataPoint> CREATOR = new bal();
    private final baa bkI;
    private long bkJ;
    private long bkK;
    private final baf[] bkL;
    private baa bkM;
    private long bkN;
    private long bkO;
    private final int versionCode;

    public DataPoint(int i, baa com_fossil_baa, long j, long j2, baf[] com_fossil_bafArr, baa com_fossil_baa2, long j3, long j4) {
        this.versionCode = i;
        this.bkI = com_fossil_baa;
        this.bkM = com_fossil_baa2;
        this.bkJ = j;
        this.bkK = j2;
        this.bkL = com_fossil_bafArr;
        this.bkN = j3;
        this.bkO = j4;
    }

    private DataPoint(baa com_fossil_baa) {
        this.versionCode = 4;
        this.bkI = (baa) awa.p(com_fossil_baa, "Data source cannot be null");
        List<bac> Mj = com_fossil_baa.LS().Mj();
        this.bkL = new baf[Mj.size()];
        int i = 0;
        for (bac format : Mj) {
            this.bkL[i] = new baf(format.getFormat());
            i++;
        }
    }

    private DataPoint(baa com_fossil_baa, baa com_fossil_baa2, RawDataPoint rawDataPoint) {
        this(4, com_fossil_baa, m14231a(Long.valueOf(rawDataPoint.boq), 0), m14231a(Long.valueOf(rawDataPoint.bor), 0), rawDataPoint.bos, com_fossil_baa2, m14231a(Long.valueOf(rawDataPoint.bov), 0), m14231a(Long.valueOf(rawDataPoint.bow), 0));
    }

    DataPoint(List<baa> list, RawDataPoint rawDataPoint) {
        this(m14233c(list, rawDataPoint.bot), m14233c(list, rawDataPoint.bou), rawDataPoint);
    }

    private static long m14231a(Long l, long j) {
        return l != null ? l.longValue() : 0;
    }

    public static DataPoint m14232a(baa com_fossil_baa) {
        return new DataPoint(com_fossil_baa);
    }

    private static baa m14233c(List<baa> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (baa) list.get(i);
    }

    public final baf[] LR() {
        return this.bkL;
    }

    public final DataType LS() {
        return this.bkI.LS();
    }

    public final baa LT() {
        return this.bkI;
    }

    public final baa LU() {
        return this.bkM != null ? this.bkM : this.bkI;
    }

    public final baa LV() {
        return this.bkM;
    }

    public final long LW() {
        return this.bkN;
    }

    public final long LX() {
        return this.bkO;
    }

    public final void LY() {
        awa.b(LS().getName().equals(LT().LS().getName()), "Conflicting data types found %s vs %s", new Object[]{LS(), LS()});
        awa.b(this.bkJ > 0, "Data point does not have the timestamp set: %s", new Object[]{this});
        awa.b(this.bkK <= this.bkJ, "Data point with start time greater than end time found: %s", new Object[]{this});
    }

    public final long m14234a(TimeUnit timeUnit) {
        return timeUnit.convert(this.bkJ, TimeUnit.NANOSECONDS);
    }

    public final baf m14235a(bac com_fossil_bac) {
        return this.bkL[LS().b(com_fossil_bac)];
    }

    public final DataPoint m14236a(long j, long j2, TimeUnit timeUnit) {
        this.bkK = timeUnit.toNanos(j);
        this.bkJ = timeUnit.toNanos(j2);
        return this;
    }

    public final long m14237b(TimeUnit timeUnit) {
        return timeUnit.convert(this.bkK, TimeUnit.NANOSECONDS);
    }

    public final long m14238c(TimeUnit timeUnit) {
        return timeUnit.convert(this.bkJ, TimeUnit.NANOSECONDS);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof DataPoint)) {
                return false;
            }
            DataPoint dataPoint = (DataPoint) obj;
            boolean z = avx.equal(this.bkI, dataPoint.bkI) && this.bkJ == dataPoint.bkJ && this.bkK == dataPoint.bkK && Arrays.equals(this.bkL, dataPoint.bkL) && avx.equal(LU(), dataPoint.LU());
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final baf hE(int i) {
        DataType LS = LS();
        if (i >= 0 && i < LS.Mj().size()) {
            return this.bkL[i];
        }
        throw new IllegalArgumentException(String.format("fieldIndex %s is out of range for %s", new Object[]{Integer.valueOf(i), LS}));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bkI, Long.valueOf(this.bkJ), Long.valueOf(this.bkK)});
    }

    public final String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.bkL);
        objArr[1] = Long.valueOf(this.bkK);
        objArr[2] = Long.valueOf(this.bkJ);
        objArr[3] = Long.valueOf(this.bkN);
        objArr[4] = Long.valueOf(this.bkO);
        objArr[5] = this.bkI.toDebugString();
        objArr[6] = this.bkM != null ? this.bkM.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, LT(), i, false);
        aus.a(parcel, 3, this.bkJ);
        aus.a(parcel, 4, this.bkK);
        aus.a(parcel, 5, this.bkL, i, false);
        aus.a(parcel, 6, this.bkM, i, false);
        aus.a(parcel, 7, this.bkN);
        aus.c(parcel, 1000, this.versionCode);
        aus.a(parcel, 8, this.bkO);
        aus.G(parcel, A);
    }
}
