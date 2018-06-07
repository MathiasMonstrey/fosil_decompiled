package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class bii extends auq implements bio<String, Integer> {
    public static final Creator<bii> CREATOR = new bik();
    private int ber;
    private final HashMap<String, Integer> bvp;
    private final SparseArray<String> bvq;
    private final ArrayList<bij> bvr;

    public bii() {
        this.ber = 1;
        this.bvp = new HashMap();
        this.bvq = new SparseArray();
        this.bvr = null;
    }

    bii(int i, ArrayList<bij> arrayList) {
        this.ber = i;
        this.bvp = new HashMap();
        this.bvq = new SparseArray();
        this.bvr = null;
        m5197e(arrayList);
    }

    private final void m5197e(ArrayList<bij> arrayList) {
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            bij com_fossil_bij = (bij) obj;
            m5198q(com_fossil_bij.boy, com_fossil_bij.bvs);
        }
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = (String) this.bvq.get(((Integer) obj).intValue());
        return (str == null && this.bvp.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final bii m5198q(String str, int i) {
        this.bvp.put(str, Integer.valueOf(i));
        this.bvq.put(i, str);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        List arrayList = new ArrayList();
        for (String str : this.bvp.keySet()) {
            arrayList.add(new bij(str, ((Integer) this.bvp.get(str)).intValue()));
        }
        aus.m4566c(parcel, 2, arrayList, false);
        aus.m4540G(parcel, A);
    }
}
