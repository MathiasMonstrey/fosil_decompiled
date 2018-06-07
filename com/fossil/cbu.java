package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbu extends auq {
    public static final Creator<cbu> CREATOR = new cbv();
    private final String bFX;
    private final String bLh;
    private final String bLi;
    private final String bLj;
    private final byte bLk;
    private final byte bLl;
    private final byte bLm;
    private final byte bLn;
    private final String beE;
    private final String bhE;
    private final String mAppId;
    private int mId;

    public cbu(int i, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4, String str7) {
        this.mId = i;
        this.mAppId = str;
        this.bLh = str2;
        this.bLi = str3;
        this.bFX = str4;
        this.bLj = str5;
        this.beE = str6;
        this.bLk = b;
        this.bLl = b2;
        this.bLm = b3;
        this.bLn = b4;
        this.bhE = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cbu com_fossil_cbu = (cbu) obj;
        return this.mId != com_fossil_cbu.mId ? false : this.bLk != com_fossil_cbu.bLk ? false : this.bLl != com_fossil_cbu.bLl ? false : this.bLm != com_fossil_cbu.bLm ? false : this.bLn != com_fossil_cbu.bLn ? false : !this.mAppId.equals(com_fossil_cbu.mAppId) ? false : (this.bLh == null ? com_fossil_cbu.bLh != null : !this.bLh.equals(com_fossil_cbu.bLh)) ? false : !this.bLi.equals(com_fossil_cbu.bLi) ? false : !this.bFX.equals(com_fossil_cbu.bFX) ? false : !this.bLj.equals(com_fossil_cbu.bLj) ? false : (this.beE == null ? com_fossil_cbu.beE != null : !this.beE.equals(com_fossil_cbu.beE)) ? false : this.bhE != null ? this.bhE.equals(com_fossil_cbu.bhE) : com_fossil_cbu.bhE == null;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.beE != null ? this.beE.hashCode() : 0) + (((((((((this.bLh != null ? this.bLh.hashCode() : 0) + ((((this.mId + 31) * 31) + this.mAppId.hashCode()) * 31)) * 31) + this.bLi.hashCode()) * 31) + this.bFX.hashCode()) * 31) + this.bLj.hashCode()) * 31)) * 31) + this.bLk) * 31) + this.bLl) * 31) + this.bLm) * 31) + this.bLn) * 31;
        if (this.bhE != null) {
            i = this.bhE.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        int i = this.mId;
        String str = this.mAppId;
        String str2 = this.bLh;
        String str3 = this.bLi;
        String str4 = this.bFX;
        String str5 = this.bLj;
        String str6 = this.beE;
        byte b = this.bLk;
        byte b2 = this.bLl;
        byte b3 = this.bLm;
        byte b4 = this.bLn;
        String str7 = this.bhE;
        return new StringBuilder(((((((String.valueOf(str).length() + 211) + String.valueOf(str2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length()) + String.valueOf(str5).length()) + String.valueOf(str6).length()) + String.valueOf(str7).length()).append("AncsNotificationParcelable{, id=").append(i).append(", appId='").append(str).append("', dateTime='").append(str2).append("', notificationText='").append(str3).append("', title='").append(str4).append("', subtitle='").append(str5).append("', displayName='").append(str6).append("', eventId=").append(b).append(", eventFlags=").append(b2).append(", categoryId=").append(b3).append(", categoryCount=").append(b4).append(", packageName='").append(str7).append("'}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 2, this.mId);
        aus.m4554a(parcel, 3, this.mAppId, false);
        aus.m4554a(parcel, 4, this.bLh, false);
        aus.m4554a(parcel, 5, this.bLi, false);
        aus.m4554a(parcel, 6, this.bFX, false);
        aus.m4554a(parcel, 7, this.bLj, false);
        aus.m4554a(parcel, 8, this.beE == null ? this.mAppId : this.beE, false);
        aus.m4541a(parcel, 9, this.bLk);
        aus.m4541a(parcel, 10, this.bLl);
        aus.m4541a(parcel, 11, this.bLm);
        aus.m4541a(parcel, 12, this.bLn);
        aus.m4554a(parcel, 13, this.bhE, false);
        aus.m4540G(parcel, A);
    }
}
