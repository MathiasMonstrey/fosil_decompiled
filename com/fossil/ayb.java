package com.fossil;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ayb implements Creator<atn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) aur.m4505a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new atn(i2, i, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new atn[i];
    }
}
