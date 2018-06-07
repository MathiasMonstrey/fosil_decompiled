package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.asr;
import com.fossil.asz;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class SignInConfiguration extends auq implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new asz();
    private final String bfh;
    private GoogleSignInOptions bfi;
    private int versionCode;

    public SignInConfiguration(int i, String str, GoogleSignInOptions googleSignInOptions) {
        this.versionCode = i;
        this.bfh = awa.df(str);
        this.bfi = googleSignInOptions;
    }

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this(3, str, googleSignInOptions);
    }

    public final GoogleSignInOptions Kd() {
        return this.bfi;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.bfh.equals(signInConfiguration.bfh)) {
                return false;
            }
            if (this.bfi == null) {
                if (signInConfiguration.bfi != null) {
                    return false;
                }
            } else if (!this.bfi.equals(signInConfiguration.bfi)) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final int hashCode() {
        return new asr().bL(this.bfh).bL(this.bfi).Km();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.versionCode);
        aus.a(parcel, 2, this.bfh, false);
        aus.a(parcel, 5, this.bfi, i, false);
        aus.G(parcel, A);
    }
}
