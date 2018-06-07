package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eku extends eig<ekn> {
    public static Creator<eku> CREATOR = new C34421();

    static class C34421 implements Creator<eku> {
        C34421() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bo(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oM(i);
        }

        public eku bo(Parcel parcel) {
            return new eku(parcel);
        }

        public eku[] oM(int i) {
            return new eku[i];
        }
    }

    protected String aDj() {
        return "user";
    }

    public int describeContents() {
        return 0;
    }

    private eku(Parcel parcel) {
        super(parcel);
    }
}
