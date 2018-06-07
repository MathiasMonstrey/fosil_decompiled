package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ejj extends eil implements Parcelable, eji {
    public static Creator<ejj> CREATOR = new C34231();

    static class C34231 implements Creator<ejj> {
        C34231() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bb(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ox(i);
        }

        public ejj bb(Parcel parcel) {
            return new ejj(parcel);
        }

        public ejj[] ox(int i) {
            return new ejj[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiv(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private ejj(Parcel parcel) {
        super(parcel);
    }
}
