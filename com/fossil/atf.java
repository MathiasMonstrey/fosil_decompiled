package com.fossil;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public final class atf implements Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int z2 = aur.m4535z(parcel);
        String str = null;
        String str2 = null;
        boolean z3 = false;
        boolean z4 = false;
        Account account = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = aur.m4511c(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) aur.m4505a(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z4 = aur.m4512c(parcel, readInt);
                    break;
                case 5:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 6:
                    z = aur.m4512c(parcel, readInt);
                    break;
                case 7:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    arrayList = aur.m4511c(parcel, readInt, asq.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new GoogleSignInOptions(i, arrayList2, account, z4, z3, z, str2, str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
