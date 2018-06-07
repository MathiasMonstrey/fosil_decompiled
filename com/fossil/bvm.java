package com.fossil;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class bvm implements Creator<bvl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Uri uri = null;
        int z = aur.m4535z(parcel);
        float f = 0.0f;
        int i = 0;
        String str = null;
        List list = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    list = aur.m4536z(parcel, readInt);
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) aur.m4505a(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 5:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvl(list, str, uri, f, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvl[i];
    }
}
