package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

public final class atg implements Creator<SignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) aur.m4505a(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new SignInAccount(i, str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
