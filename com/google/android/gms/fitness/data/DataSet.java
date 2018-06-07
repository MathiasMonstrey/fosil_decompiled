package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.awa;
import com.fossil.baa;
import com.fossil.baj;
import com.fossil.bam;
import com.fossil.bji;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DataSet extends auq implements ReflectedParcelable {
    public static final Creator<DataSet> CREATOR = new bam();
    private final baa bkI;
    private final DataType bkP;
    private final List<DataPoint> bkQ;
    private final List<baa> bkR;
    private boolean bkS;
    private final int versionCode;

    public DataSet(int i, baa com_fossil_baa, DataType dataType, List<RawDataPoint> list, List<baa> list2, boolean z) {
        List singletonList;
        this.bkS = false;
        this.versionCode = i;
        this.bkI = com_fossil_baa;
        this.bkP = com_fossil_baa.LS();
        this.bkS = z;
        this.bkQ = new ArrayList(list.size());
        if (i < 2) {
            singletonList = Collections.singletonList(com_fossil_baa);
        }
        this.bkR = singletonList;
        for (RawDataPoint dataPoint : list) {
            this.bkQ.add(new DataPoint(this.bkR, dataPoint));
        }
    }

    private DataSet(baa com_fossil_baa) {
        this.bkS = false;
        this.versionCode = 3;
        this.bkI = (baa) awa.bO(com_fossil_baa);
        this.bkP = com_fossil_baa.LS();
        this.bkQ = new ArrayList();
        this.bkR = new ArrayList();
        this.bkR.add(this.bkI);
    }

    private List<RawDataPoint> Mb() {
        return m14242A(this.bkR);
    }

    public static DataSet m14239b(baa com_fossil_baa) {
        awa.p(com_fossil_baa, "DataSource should be specified");
        return new DataSet(com_fossil_baa);
    }

    private final void m14240b(DataPoint dataPoint) {
        this.bkQ.add(dataPoint);
        baa LU = dataPoint.LU();
        if (LU != null && !this.bkR.contains(LU)) {
            this.bkR.add(LU);
        }
    }

    public static void m14241c(DataPoint dataPoint) throws IllegalArgumentException {
        String a = bji.a(dataPoint, baj.boF);
        if (a != null) {
            String valueOf = String.valueOf(dataPoint);
            Log.w("Fitness", new StringBuilder(String.valueOf(valueOf).length() + 20).append("Invalid data point: ").append(valueOf).toString());
            throw new IllegalArgumentException(a);
        }
    }

    final List<RawDataPoint> m14242A(List<baa> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.bkQ.size());
        for (DataPoint rawDataPoint : this.bkQ) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public final DataType LS() {
        return this.bkI.LS();
    }

    public final baa LT() {
        return this.bkI;
    }

    public final DataPoint LZ() {
        return DataPoint.m14232a(this.bkI);
    }

    public final List<DataPoint> Ma() {
        return Collections.unmodifiableList(this.bkQ);
    }

    public final void m14243a(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.LT(), this.bkI};
        awa.b(dataPoint.LT().Mg().equals(this.bkI.Mg()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.LY();
        m14241c(dataPoint);
        m14240b(dataPoint);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DataSet)) {
                return false;
            }
            DataSet dataSet = (DataSet) obj;
            boolean z = avx.equal(LS(), dataSet.LS()) && avx.equal(this.bkI, dataSet.bkI) && avx.equal(this.bkQ, dataSet.bkQ) && this.bkS == dataSet.bkS;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bkI});
    }

    public final String toString() {
        List Mb = Mb();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.bkI.toDebugString();
        if (this.bkQ.size() >= 10) {
            Mb = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.bkQ.size()), Mb.subList(0, 5)});
        }
        objArr[1] = Mb;
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, LT(), i, false);
        aus.a(parcel, 2, LS(), i, false);
        aus.d(parcel, 3, Mb(), false);
        aus.c(parcel, 4, this.bkR, false);
        aus.a(parcel, 5, this.bkS);
        aus.c(parcel, 1000, this.versionCode);
        aus.G(parcel, A);
    }
}
