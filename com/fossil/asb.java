package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import java.util.List;

public final class asb implements Creator<PasswordSpecification> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int i = 0;
        int z = aur.m4535z(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    list2 = aur.m4500A(parcel, readInt);
                    break;
                case 3:
                    list = aur.m4536z(parcel, readInt);
                    break;
                case 4:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 1000:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new PasswordSpecification(i3, str, list2, list, i2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
