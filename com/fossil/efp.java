package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class efp extends eiv<efn> implements ece<efn> {
    public static Creator<efp> CREATOR = new C33711();

    static class C33711 implements Creator<efp> {
        C33711() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return au(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nK(i);
        }

        public efp au(Parcel parcel) {
            return new efp(parcel);
        }

        public efp[] nK(int i) {
            return new efp[i];
        }
    }

    public static class C3372a extends eim {
        private long dFZ = -1;
        private String id;

        protected C3372a() {
            super("/v7.0/activity_type/{id}/");
        }

        public C3372a lv(String str) {
            bi("id", str);
            this.id = str;
            return this;
        }

        public C3372a aT(long j) {
            this.dFZ = j;
            return this;
        }

        public efp aCU() {
            eiy.m10771e(this.id, "id");
            return new efp();
        }
    }

    public static C3372a aCT() {
        return new C3372a();
    }

    private efp(C3372a c3372a) {
        super(c3372a.id, c3372a.dFZ, c3372a.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private efp(Parcel parcel) {
        super(parcel);
    }
}
