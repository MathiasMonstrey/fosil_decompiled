package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.atg;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class SignInAccount extends auq implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new atg();
    @Deprecated
    private String beD;
    private GoogleSignInAccount bff;
    @Deprecated
    private String bfg;
    private int versionCode;

    public SignInAccount(int i, String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.versionCode = i;
        this.bff = googleSignInAccount;
        this.beD = awa.m4639c(str, "8.3 and 8.4 SDKs require non-null email");
        this.bfg = awa.m4639c(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount Kc() {
        return this.bff;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 4, this.beD, false);
        aus.m4548a(parcel, 7, this.bff, i, false);
        aus.m4554a(parcel, 8, this.bfg, false);
        aus.m4540G(parcel, A);
    }
}
