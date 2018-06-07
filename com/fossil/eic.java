package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eic extends eil implements eib {
    public static Creator<eic> CREATOR = new C34081();

    static class C34081 implements Creator<eic> {
        C34081() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aP(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oh(i);
        }

        public eic aP(Parcel parcel) {
            return new eic(parcel);
        }

        public eic[] oh(int i) {
            return new eic[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    private eic(Parcel parcel) {
        super(parcel);
    }

    public ece<eib> aCt() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiv(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }
}
