package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class eid extends eil implements Parcelable {
    public static final Creator<eid> CREATOR = new C34091();
    @cga("end")
    int end;
    @cga("name")
    private String name;
    @cga("start")
    private int start;

    static class C34091 implements Creator<eid> {
        C34091() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aQ(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oi(i);
        }

        public eid aQ(Parcel parcel) {
            return new eid(parcel);
        }

        public eid[] oi(int i) {
            return new eid[i];
        }
    }

    private eid(Parcel parcel) {
        super(parcel);
        this.name = parcel.readString();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.name);
        parcel.writeInt(this.start);
        parcel.writeInt(this.end);
    }
}
