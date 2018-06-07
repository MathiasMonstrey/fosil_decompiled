package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public abstract class cbm extends buk implements cbl {
    public cbm() {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1601e((DataHolder) bul.m5685a(parcel, DataHolder.CREATOR));
                break;
            case 2:
                mo1596a((cbn) bul.m5685a(parcel, cbn.CREATOR));
                break;
            case 3:
                mo1597a((cbp) bul.m5685a(parcel, cbp.CREATOR));
                break;
            case 4:
                mo1600b((cbp) bul.m5685a(parcel, cbp.CREATOR));
                break;
            case 5:
                mo1593E(parcel.createTypedArrayList(cbp.CREATOR));
                break;
            case 6:
                mo1599a((cbu) bul.m5685a(parcel, cbu.CREATOR));
                break;
            case 7:
                mo1595a((cbb) bul.m5685a(parcel, cbb.CREATOR));
                break;
            case 8:
                mo1594a((caz) bul.m5685a(parcel, caz.CREATOR));
                break;
            case 9:
                mo1598a((cbs) bul.m5685a(parcel, cbs.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
