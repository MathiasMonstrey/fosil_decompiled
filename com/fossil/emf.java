package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class emf extends eiv<emb> {
    public static final Creator<emf> CREATOR = new C34591();

    static class C34591 implements Creator<emf> {
        C34591() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bB(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return pa(i);
        }

        public emf bB(Parcel parcel) {
            return new emf(parcel);
        }

        public emf[] pa(int i) {
            return new emf[i];
        }
    }

    public emf(String str) {
        super(str);
    }

    public emf(String str, long j, String str2) {
        super(str, j, str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private emf(Parcel parcel) {
        super(parcel);
    }
}
