package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ekp implements Parcelable, eko {
    public static Creator<ekp> CREATOR = new C34381();
    @cga("promotions")
    Boolean dKh;
    @cga("newsletter")
    Boolean dKi;
    @cga("system_messages")
    Boolean dKj;

    static class C34381 implements Creator<ekp> {
        C34381() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bm(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oK(i);
        }

        public ekp bm(Parcel parcel) {
            return new ekp(parcel);
        }

        public ekp[] oK(int i) {
            return new ekp[i];
        }
    }

    public static class C3439a {
        private Boolean dKh;
        private Boolean dKj;
        private Boolean dKk;

        public C3439a m10804g(Boolean bool) {
            this.dKh = bool;
            return this;
        }

        public C3439a m10805h(Boolean bool) {
            this.dKk = bool;
            return this;
        }

        public C3439a m10806i(Boolean bool) {
            this.dKj = bool;
            return this;
        }

        public ekp aEz() {
            ekp com_fossil_ekp = new ekp();
            com_fossil_ekp.m10807d(this.dKh);
            com_fossil_ekp.m10808e(this.dKk);
            com_fossil_ekp.m10809f(this.dKj);
            return com_fossil_ekp;
        }
    }

    public Boolean aEv() {
        return this.dKh;
    }

    public void m10807d(Boolean bool) {
        this.dKh = bool;
    }

    public Boolean aEw() {
        return this.dKi;
    }

    public void m10808e(Boolean bool) {
        this.dKi = bool;
    }

    public Boolean aEx() {
        return this.dKj;
    }

    public void m10809f(Boolean bool) {
        this.dKj = bool;
    }

    public static C3439a aEy() {
        return new C3439a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dKh);
        parcel.writeValue(this.dKi);
        parcel.writeValue(this.dKj);
    }

    private ekp(Parcel parcel) {
        this.dKh = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dKi = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dKj = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
