package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehq extends efs implements ehp {
    public static Creator<ehq> CREATOR = new C34001();

    static class C34001 implements Creator<ehq> {
        C34001() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aJ(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ob(i);
        }

        public ehq aJ(Parcel parcel) {
            return new ehq(parcel);
        }

        public ehq[] ob(int i) {
            return new ehq[i];
        }
    }

    private ehq(Parcel parcel) {
        super(parcel);
    }
}
