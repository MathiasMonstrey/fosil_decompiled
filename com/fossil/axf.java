package com.fossil;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;

public final class axf implements Creator<axe> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        ayc[] com_fossil_aycArr = null;
        int z = aur.m4535z(parcel);
        Account account = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) aur.m4510b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = aur.m4527r(parcel, readInt);
                    break;
                case 8:
                    account = (Account) aur.m4505a(parcel, readInt, Account.CREATOR);
                    break;
                case 10:
                    com_fossil_aycArr = (ayc[]) aur.m4510b(parcel, readInt, ayc.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new axe(i3, i2, i, str, iBinder, scopeArr, bundle, account, com_fossil_aycArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new axe[i];
    }
}
