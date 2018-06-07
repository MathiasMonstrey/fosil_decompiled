package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

public final class bwp extends buj implements bwo {
    bwp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlacesService");
    }

    public final void mo1493a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, bvx com_fossil_bvx, bwq com_fossil_bwq) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        bul.m5687a(SH, (Parcelable) latLngBounds);
        bul.m5687a(SH, (Parcelable) autocompleteFilter);
        bul.m5687a(SH, (Parcelable) com_fossil_bvx);
        bul.m5686a(SH, (IInterface) com_fossil_bwq);
        m4421b(13, SH);
    }
}
