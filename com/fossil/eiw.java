package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eiw<E> implements ecd<E> {
    public static final Creator<eiw> CREATOR = new C34201();
    private final long dFZ;
    private final String href;

    static class C34201 implements Creator<eiw> {
        C34201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aV(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oq(i);
        }

        public eiw aV(Parcel parcel) {
            return new eiw(parcel);
        }

        public eiw[] oq(int i) {
            return new eiw[i];
        }
    }

    public eiw(String str) {
        this.href = str;
        this.dFZ = -1;
    }

    public String getHref() {
        return this.href;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.dFZ);
        parcel.writeString(this.href);
    }

    protected eiw(Parcel parcel) {
        this.dFZ = parcel.readLong();
        this.href = parcel.readString();
    }

    public String getId() {
        return getHref();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        eiw com_fossil_eiw = (eiw) obj;
        if (this.dFZ != com_fossil_eiw.dFZ) {
            return false;
        }
        if (this.href != null) {
            if (this.href.equals(com_fossil_eiw.href)) {
                return true;
            }
        } else if (com_fossil_eiw.href == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.href != null ? this.href.hashCode() : 0) * 31) + ((int) (this.dFZ ^ (this.dFZ >>> 32)));
    }
}
