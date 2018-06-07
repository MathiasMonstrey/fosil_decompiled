package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bag implements Creator<baf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int z2 = aur.m4535z(parcel);
        float f = 0.0f;
        float[] fArr = null;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    z = aur.m4512c(parcel, readInt);
                    break;
                case 3:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    bundle = aur.m4527r(parcel, readInt);
                    break;
                case 6:
                    iArr = aur.m4530u(parcel, readInt);
                    break;
                case 7:
                    fArr = aur.m4532w(parcel, readInt);
                    break;
                case 8:
                    bArr = aur.m4528s(parcel, readInt);
                    break;
                case 1000:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new baf(i2, i, z, f, str, bundle, iArr, fArr, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new baf[i];
    }
}
