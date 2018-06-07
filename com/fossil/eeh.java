package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.Attachment$Status;
import com.ua.sdk.activitystory.Attachment$Type;
import java.util.Date;

public class eeh implements eeg {
    public static final Creator<eeh> CREATOR = new C33381();
    @cga("object")
    C3340a dEG;

    static class C33381 implements Creator<eeh> {
        C33381() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10570T(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nj(i);
        }

        public eeh m10570T(Parcel parcel) {
            return new eeh(parcel);
        }

        public eeh[] nj(int i) {
            return new eeh[i];
        }
    }

    public static class C3340a implements Parcelable {
        public static final Creator<C3340a> CREATOR = new C33391();
        @cga("type")
        Attachment$Type dEA;
        @cga("published")
        Date dEB;
        @cga("status")
        Attachment$Status dEC;
        @cga("provider")
        String dEH;
        @cga("provider_id")
        String dEI;
        @cga("thumbnail_uri")
        String dEJ;
        @cga("thumbnail_uri_template")
        String dEK;
        @cga("uri")
        String uri;

        static class C33391 implements Creator<C3340a> {
            C33391() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m10571U(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return nk(i);
            }

            public C3340a m10571U(Parcel parcel) {
                return new C3340a(parcel);
            }

            public C3340a[] nk(int i) {
                return new C3340a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = -1;
            parcel.writeString(this.uri);
            parcel.writeInt(this.dEA == null ? -1 : this.dEA.ordinal());
            parcel.writeLong(this.dEB != null ? this.dEB.getTime() : -1);
            parcel.writeString(this.dEH);
            parcel.writeString(this.dEI);
            parcel.writeString(this.dEJ);
            parcel.writeString(this.dEK);
            if (this.dEC != null) {
                i2 = this.dEC.ordinal();
            }
            parcel.writeInt(i2);
        }

        private C3340a(Parcel parcel) {
            Attachment$Status attachment$Status = null;
            this.uri = parcel.readString();
            int readInt = parcel.readInt();
            this.dEA = readInt == -1 ? null : Attachment$Type.values()[readInt];
            long readLong = parcel.readLong();
            this.dEB = readLong == -1 ? null : new Date(readLong);
            this.dEH = parcel.readString();
            this.dEI = parcel.readString();
            this.dEJ = parcel.readString();
            this.dEK = parcel.readString();
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
        parcel.writeParcelable(this.dEG, i);
    }

    private eeh(Parcel parcel) {
        this.dEG = (C3340a) parcel.readParcelable(C3340a.class.getClassLoader());
    }
}
