package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.sleep.SleepMetric;
import com.ua.sdk.sleep.SleepMetric.a;
import com.ua.sdk.sleep.SleepMetric.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class ekf extends eil implements SleepMetric {
    public static final Creator<ekf> CREATOR = new C34301();
    @cga("created_datetime")
    Date dGB;
    @cga("updated_datetime")
    Date dGC;
    @cga("reference_key")
    String dGE;
    @cga("time_series")
    C3434b dJN;
    @cga("recorder_type_key")
    String dJO;
    @cga("start_datetime_utc")
    Date dJP;
    @cga("end_datetime_utc")
    Date dJQ;
    @cga("start_datetime_timezone")
    TimeZone dJR;
    @cga("aggregates")
    C3432a dJS;

    static class C34301 implements Creator<ekf> {
        C34301() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bg(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oE(i);
        }

        public ekf bg(Parcel parcel) {
            return new ekf(parcel);
        }

        public ekf[] oE(int i) {
            return new ekf[i];
        }
    }

    public static class C3432a implements a {
        public static final Creator<C3432a> CREATOR = new C34311();
        @cga("time_to_sleep")
        int dJT;
        @cga("total_time_awake")
        int dJU;
        @cga("total_light_sleep")
        int dJV;
        @cga("total_deep_sleep")
        int dJW;
        @cga("times_awakened")
        int dJX;
        @cga("total_sleep")
        int ddc;

        static class C34311 implements Creator<C3432a> {
            C34311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bh(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return oF(i);
            }

            public C3432a bh(Parcel parcel) {
                return new C3432a(parcel);
            }

            public C3432a[] oF(int i) {
                return new C3432a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dJT);
            parcel.writeInt(this.dJU);
            parcel.writeInt(this.dJV);
            parcel.writeInt(this.dJW);
            parcel.writeInt(this.ddc);
            parcel.writeInt(this.dJX);
        }

        private C3432a(Parcel parcel) {
            this.dJT = parcel.readInt();
            this.dJU = parcel.readInt();
            this.dJV = parcel.readInt();
            this.dJW = parcel.readInt();
            this.ddc = parcel.readInt();
            this.dJX = parcel.readInt();
        }
    }

    public static class C3434b implements b {
        public static final Creator<C3434b> CREATOR = new C34331();
        final ArrayList<ekh> dJY;

        static class C34331 implements Creator<C3434b> {
            C34331() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bi(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return oG(i);
            }

            public C3434b bi(Parcel parcel) {
                return new C3434b(parcel);
            }

            public C3434b[] oG(int i) {
                return new C3434b[i];
            }
        }

        public C3434b() {
            this.dJY = new ArrayList();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeList(this.dJY);
        }

        private C3434b(Parcel parcel) {
            this.dJY = parcel.readArrayList(ekh.class.getClassLoader());
        }
    }

    public /* synthetic */ ece aCt() {
        return aEe();
    }

    public /* synthetic */ ecj aCy() {
        return aEe();
    }

    public ekg aEe() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new ekg(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        long time;
        long j = -1;
        parcel.writeParcelable(this.dJN, 0);
        parcel.writeString(this.dJO);
        parcel.writeString(this.dGE);
        parcel.writeLong(this.dJP != null ? this.dJP.getTime() : -1);
        if (this.dJQ != null) {
            time = this.dJQ.getTime();
        } else {
            time = -1;
        }
        parcel.writeLong(time);
        parcel.writeSerializable(this.dJR);
        parcel.writeParcelable(this.dJS, 0);
        if (this.dGB != null) {
            time = this.dGB.getTime();
        } else {
            time = -1;
        }
        parcel.writeLong(time);
        if (this.dGC != null) {
            j = this.dGC.getTime();
        }
        parcel.writeLong(j);
    }

    private ekf(Parcel parcel) {
        Date date = null;
        this.dJN = (C3434b) parcel.readParcelable(C3434b.class.getClassLoader());
        this.dJO = parcel.readString();
        this.dGE = parcel.readString();
        long readLong = parcel.readLong();
        this.dJP = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        this.dJQ = readLong == -1 ? null : new Date(readLong);
        this.dJR = (TimeZone) parcel.readSerializable();
        this.dJS = (C3432a) parcel.readParcelable(C3432a.class.getClassLoader());
        readLong = parcel.readLong();
        this.dGB = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        if (readLong != -1) {
            date = new Date(readLong);
        }
        this.dGC = date;
    }
}
