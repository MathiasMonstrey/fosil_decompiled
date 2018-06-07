package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class bit extends auq {
    public static final Creator<bit> CREATOR = new biw();
    private ArrayList<biu> bvG;
    final String className;
    private int versionCode;

    bit(int i, String str, ArrayList<biu> arrayList) {
        this.versionCode = i;
        this.className = str;
        this.bvG = arrayList;
    }

    bit(String str, Map<String, bin<?, ?>> map) {
        ArrayList arrayList;
        this.versionCode = 1;
        this.className = str;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList2.add(new biu(str2, (bin) map.get(str2)));
            }
            arrayList = arrayList2;
        }
        this.bvG = arrayList;
    }

    final HashMap<String, bin<?, ?>> OE() {
        HashMap<String, bin<?, ?>> hashMap = new HashMap();
        int size = this.bvG.size();
        for (int i = 0; i < size; i++) {
            biu com_fossil_biu = (biu) this.bvG.get(i);
            hashMap.put(com_fossil_biu.key, com_fossil_biu.bvH);
        }
        return hashMap;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 2, this.className, false);
        aus.m4566c(parcel, 3, this.bvG, false);
        aus.m4540G(parcel, A);
    }
}
