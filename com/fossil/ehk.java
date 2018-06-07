package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehk extends eiv<ehi> {
    public static final Creator<ehk> CREATOR = new C33971();

    static class C33971 implements Creator<ehk> {
        C33971() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aG(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nY(i);
        }

        public ehk aG(Parcel parcel) {
            return new ehk(parcel);
        }

        public ehk[] nY(int i) {
            return new ehk[i];
        }
    }

    public ehk(String str, String str2) {
        super(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private ehk(Parcel parcel) {
        super(parcel);
    }
}
