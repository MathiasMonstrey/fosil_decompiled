package com.fossil;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class bip extends bim implements SafeParcelable {
    public Object dI(String str) {
        return null;
    }

    public boolean dJ(String str) {
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        bim com_fossil_bim = (bim) obj;
        for (bin com_fossil_bin : Ox().values()) {
            if (mo1470a(com_fossil_bin)) {
                if (!com_fossil_bim.mo1470a(com_fossil_bin)) {
                    return false;
                }
                if (!mo1471b(com_fossil_bin).equals(com_fossil_bim.mo1471b(com_fossil_bin))) {
                    return false;
                }
            } else if (com_fossil_bim.mo1470a(com_fossil_bin)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (bin com_fossil_bin : Ox().values()) {
            int hashCode;
            if (mo1470a(com_fossil_bin)) {
                hashCode = mo1471b(com_fossil_bin).hashCode() + (i * 31);
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }
}
