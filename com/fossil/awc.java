package com.fossil;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class awc implements Creator<awb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    account = (Account) aur.m4505a(parcel, readInt, Account.CREATOR);
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) aur.m4505a(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new awb(i2, account, i, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new awb[i];
    }
}
