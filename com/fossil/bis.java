package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bis extends auq {
    public static final Creator<bis> CREATOR = new biv();
    private int ber;
    private final HashMap<String, Map<String, bin<?, ?>>> bvD;
    private final ArrayList<bit> bvE = null;
    private final String bvF;

    bis(int i, ArrayList<bit> arrayList, String str) {
        this.ber = i;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            bit com_fossil_bit = (bit) arrayList.get(i2);
            hashMap.put(com_fossil_bit.className, com_fossil_bit.OE());
        }
        this.bvD = hashMap;
        this.bvF = (String) awa.bO(str);
        OC();
    }

    private final void OC() {
        for (String str : this.bvD.keySet()) {
            Map map = (Map) this.bvD.get(str);
            for (String str2 : map.keySet()) {
                ((bin) map.get(str2)).m5211a(this);
            }
        }
    }

    public final String OD() {
        return this.bvF;
    }

    public final Map<String, bin<?, ?>> dK(String str) {
        return (Map) this.bvD.get(str);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.bvD.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.bvD.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        List arrayList = new ArrayList();
        for (String str : this.bvD.keySet()) {
            arrayList.add(new bit(str, (Map) this.bvD.get(str)));
        }
        aus.m4566c(parcel, 2, arrayList, false);
        aus.m4554a(parcel, 3, this.bvF, false);
        aus.m4540G(parcel, A);
    }
}
