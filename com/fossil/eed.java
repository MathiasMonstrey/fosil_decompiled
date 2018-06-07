package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.Attachment$Status;
import com.ua.sdk.activitystory.Attachment$Type;
import java.util.Date;

public class eed implements eec {
    public static final Creator<eed> CREATOR = new C33331();
    @cga("object")
    C3335a dEy;

    static class C33331 implements Creator<eed> {
        C33331() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10566P(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nf(i);
        }

        public eed m10566P(Parcel parcel) {
            return new eed(parcel);
        }

        public eed[] nf(int i) {
            return new eed[i];
        }
    }

    public static class C3335a implements Parcelable {
        public static final Creator<C3335a> CREATOR = new C33341();
        @cga("type")
        Attachment$Type dEA;
        @cga("published")
        Date dEB;
        @cga("status")
        Attachment$Status dEC;
        @cga("template")
        String dEz;
        @cga("uri")
        String uri;

        static class C33341 implements Creator<C3335a> {
            C33341() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m10567Q(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return ng(i);
            }

            public C3335a m10567Q(Parcel parcel) {
                return new C3335a(parcel);
            }

            public C3335a[] ng(int i) {
                return new C3335a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = -1;
            parcel.writeString(this.uri);
            parcel.writeString(this.dEz);
            parcel.writeInt(this.dEA == null ? -1 : this.dEA.ordinal());
            parcel.writeLong(this.dEB != null ? this.dEB.getTime() : -1);
            if (this.dEC != null) {
                i2 = this.dEC.ordinal();
            }
            parcel.writeInt(i2);
        }

        private C3335a(Parcel parcel) {
            Attachment$Status attachment$Status = null;
            this.uri = parcel.readString();
            this.dEz = parcel.readString();
            int readInt = parcel.readInt();
            this.dEA = readInt == -1 ? null : Attachment$Type.values()[readInt];
            long readLong = parcel.readLong();
            this.dEB = readLong == -1 ? null : new Date(readLong);
            readInt = parcel.readInt();
            if (readInt != -1) {
                attachment$Status = Attachment$Status.values()[readInt];
            }
            this.dEC = attachment$Status;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dEy, i);
    }

    private eed(Parcel parcel) {
        this.dEy = (C3335a) parcel.readParcelable(C3335a.class.getClassLoader());
    }
}
