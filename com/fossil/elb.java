package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class elb implements Parcelable, ela {
    public static Creator<elb> CREATOR = new C34451();
    @cga("facebook")
    Boolean dED;
    @cga("twitter")
    Boolean dEE;

    static class C34451 implements Creator<elb> {
        C34451() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bp(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oN(i);
        }

        public elb bp(Parcel parcel) {
            return new elb(parcel);
        }

        public elb[] oN(int i) {
            return new elb[i];
        }
    }

    public static class C3446a {
        private Boolean dED;
        private Boolean dEE;

        public C3446a m10849l(Boolean bool) {
            this.dEE = bool;
            return this;
        }

        public C3446a m10850m(Boolean bool) {
            this.dED = bool;
            return this;
        }

        public elb aEI() {
            elb com_fossil_elb = new elb();
            com_fossil_elb.m10851j(this.dEE);
            com_fossil_elb.m10852k(this.dED);
            return com_fossil_elb;
        }
    }

    public Boolean aEF() {
        return this.dEE;
    }

    public void m10851j(Boolean bool) {
        this.dEE = bool;
    }

    public Boolean aEG() {
        return this.dED;
    }

    public void m10852k(Boolean bool) {
        this.dED = bool;
    }

    public static C3446a aEH() {
        return new C3446a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dEE);
        parcel.writeValue(this.dED);
    }

    private elb(Parcel parcel) {
        this.dEE = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dED = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
