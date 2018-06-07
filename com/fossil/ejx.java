package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ejx extends eig<eju> {
    public static Creator<ejx> CREATOR = new C34271();

    static class C34271 implements Creator<ejx> {
        C34271() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return be(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oC(i);
        }

        public ejx be(Parcel parcel) {
            return new ejx(parcel);
        }

        public ejx[] oC(int i) {
            return new ejx[i];
        }
    }

    protected String aDj() {
        return "remoteConnectionTypes";
    }

    private ejx(Parcel parcel) {
        super(parcel);
    }
}
