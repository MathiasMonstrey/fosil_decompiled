package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import java.util.Set;

public final class caz extends auq implements cap {
    public static final Creator<caz> CREATOR = new cba();
    private final Object Am = new Object();
    private final List<cbp> bKM;
    private Set<cax> bKN;
    private final String mName;

    public caz(String str, List<cbp> list) {
        this.mName = str;
        this.bKM = list;
        this.bKN = null;
        awa.bO(this.mName);
        awa.bO(this.bKM);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        caz com_fossil_caz = (caz) obj;
        if (this.mName == null ? com_fossil_caz.mName != null : !this.mName.equals(com_fossil_caz.mName)) {
            return false;
        }
        if (this.bKM != null) {
            if (this.bKM.equals(com_fossil_caz.bKM)) {
                return true;
            }
        } else if (com_fossil_caz.bKM == null) {
            return true;
        }
        return false;
    }

    public final String getName() {
        return this.mName;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + 31) * 31;
        if (this.bKM != null) {
            i = this.bKM.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        String str = this.mName;
        String valueOf = String.valueOf(this.bKM);
        return new StringBuilder((String.valueOf(str).length() + 18) + String.valueOf(valueOf).length()).append("CapabilityInfo{").append(str).append(", ").append(valueOf).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 2, getName(), false);
        aus.m4566c(parcel, 3, this.bKM, false);
        aus.m4540G(parcel, A);
    }
}
