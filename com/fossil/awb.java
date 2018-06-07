package com.fossil;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class awb extends auq {
    public static final Creator<awb> CREATOR = new awc();
    private final Account beU;
    private int ber;
    private final int bhN;
    private final GoogleSignInAccount bhO;

    awb(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.ber = i;
        this.beU = account;
        this.bhN = i2;
        this.bhO = googleSignInAccount;
    }

    public awb(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4548a(parcel, 2, this.beU, i, false);
        aus.m4565c(parcel, 3, this.bhN);
        aus.m4548a(parcel, 4, this.bhO, i, false);
        aus.m4540G(parcel, A);
    }
}
