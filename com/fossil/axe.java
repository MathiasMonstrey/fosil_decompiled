package com.fossil;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;

public final class axe extends auq {
    public static final Creator<axe> CREATOR = new axf();
    private int biK;
    private int biL;
    String biM;
    IBinder biN;
    Scope[] biO;
    Bundle biP;
    Account biQ;
    ayc[] biR;
    private int version;

    public axe(int i) {
        this.version = 3;
        this.biL = aye.bfN;
        this.biK = i;
    }

    axe(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, ayc[] com_fossil_aycArr) {
        Account account2 = null;
        this.version = i;
        this.biK = i2;
        this.biL = i3;
        if ("com.google.android.gms".equals(str)) {
            this.biM = "com.google.android.gms";
        } else {
            this.biM = str;
        }
        if (i < 2) {
            if (iBinder != null) {
                avg com_fossil_avi;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    com_fossil_avi = queryLocalInterface instanceof avg ? (avg) queryLocalInterface : new avi(iBinder);
                }
                account2 = auu.m4570a(com_fossil_avi);
            }
            this.biQ = account2;
        } else {
            this.biN = iBinder;
            this.biQ = account;
        }
        this.biO = scopeArr;
        this.biP = bundle;
        this.biR = com_fossil_aycArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.version);
        aus.m4565c(parcel, 2, this.biK);
        aus.m4565c(parcel, 3, this.biL);
        aus.m4554a(parcel, 4, this.biM, false);
        aus.m4546a(parcel, 5, this.biN, false);
        aus.m4560a(parcel, 6, this.biO, i, false);
        aus.m4545a(parcel, 7, this.biP, false);
        aus.m4548a(parcel, 8, this.biQ, i, false);
        aus.m4560a(parcel, 10, this.biR, i, false);
        aus.m4540G(parcel, A);
    }
}
