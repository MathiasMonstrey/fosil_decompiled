package com.fossil;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public final class bvk implements Creator<PlaceEntity> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        String str = null;
        List list = null;
        List list2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z2 = false;
        float f2 = 0.0f;
        int i = 0;
        bvq com_fossil_bvq = null;
        bvs com_fossil_bvs = null;
        bvl com_fossil_bvl = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    bundle = aur.m4527r(parcel, readInt);
                    break;
                case 3:
                    com_fossil_bvq = (bvq) aur.m4505a(parcel, readInt, bvq.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) aur.m4505a(parcel, readInt, LatLng.CREATOR);
                    break;
                case 5:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) aur.m4505a(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    uri = (Uri) aur.m4505a(parcel, readInt, Uri.CREATOR);
                    break;
                case 9:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 10:
                    f2 = aur.m4520k(parcel, readInt);
                    break;
                case 11:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 13:
                    list2 = aur.m4536z(parcel, readInt);
                    break;
                case 14:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 15:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 16:
                    str5 = aur.m4525p(parcel, readInt);
                    break;
                case 17:
                    list3 = aur.m4500A(parcel, readInt);
                    break;
                case 19:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 20:
                    list = aur.m4536z(parcel, readInt);
                    break;
                case 21:
                    com_fossil_bvs = (bvs) aur.m4505a(parcel, readInt, bvs.CREATOR);
                    break;
                case 22:
                    com_fossil_bvl = (bvl) aur.m4505a(parcel, readInt, bvl.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new PlaceEntity(str, list, list2, bundle, str2, str3, str4, str5, list3, latLng, f, latLngBounds, str6, uri, z2, f2, i, com_fossil_bvq, com_fossil_bvs, com_fossil_bvl);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlaceEntity[i];
    }
}
