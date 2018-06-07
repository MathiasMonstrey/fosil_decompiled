package com.fossil;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public final class atd implements Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) aur.m4505a(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 9:
                    str6 = aur.m4525p(parcel, readInt);
                    break;
                case 10:
                    list = aur.m4511c(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = aur.m4525p(parcel, readInt);
                    break;
                case 12:
                    str8 = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
