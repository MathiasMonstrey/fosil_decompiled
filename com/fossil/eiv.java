package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eiv<T> implements ece<T> {
    public static final Creator<eiv> CREATOR = new C34191();
    protected final long dFZ;
    protected final int dID;
    protected final String href;
    protected final String id;

    static class C34191 implements Creator<eiv> {
        C34191() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aU(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return op(i);
        }

        public eiv aU(Parcel parcel) {
            return new eiv(parcel);
        }

        public eiv[] op(int i) {
            return new eiv[i];
        }
    }

    public eiv(String str) {
        this(null, str);
    }

    public eiv(String str, String str2) {
        this.id = str;
        this.href = str2;
        this.dFZ = -1;
        this.dID = 0;
    }

    public eiv(String str, long j, String str2) {
        this.id = str;
        this.href = str2;
        this.dFZ = j;
        this.dID = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getHref() {
        return this.href;
    }

    public long aDp() {
        return this.dFZ;
    }

    public boolean checkCache() {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeLong(this.dFZ);
        parcel.writeString(this.href);
        parcel.writeInt(this.dID);
    }

    protected eiv(Parcel parcel) {
        this.id = parcel.readString();
        this.dFZ = parcel.readLong();
        this.href = parcel.readString();
        this.dID = parcel.readInt();
    }
}
