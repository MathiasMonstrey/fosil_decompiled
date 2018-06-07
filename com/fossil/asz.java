package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public final class asz implements Creator<SignInConfiguration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        GoogleSignInOptions googleSignInOptions = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) aur.m4505a(parcel, readInt, GoogleSignInOptions.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new SignInConfiguration(i, str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
