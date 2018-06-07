package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class aum<T extends SafeParcelable> extends aug<T> {
    private static final String[] bgV = new String[]{"data"};
    private final Creator<T> bgW;

    public aum(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.bgW = creator;
    }

    public /* synthetic */ Object get(int i) {
        return hv(i);
    }

    public T hv(int i) {
        byte[] n = this.bgD.n("data", i, this.bgD.hs(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(n, 0, n.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.bgW.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
