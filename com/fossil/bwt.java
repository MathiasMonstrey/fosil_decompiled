package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.AutocompleteFilter;
import java.util.List;

public final class bwt implements Creator<AutocompleteFilter> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        boolean z2 = false;
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 2:
                    list = aur.m4536z(parcel, readInt);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new AutocompleteFilter(i, z2, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AutocompleteFilter[i];
    }
}
