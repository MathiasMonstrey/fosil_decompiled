package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;

public class eek implements edo {
    public static Creator<eek> CREATOR = new C33431();
    @cga("title")
    String dEP;
    @cga("alias")
    String dEQ;
    @cga("profile_photo")
    C3345a dER;
    @cga("cover_photo")
    C3345a dES;
    @cga("id")
    String mId;

    static class C33431 implements Creator<eek> {
        C33431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10574X(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nn(i);
        }

        public eek m10574X(Parcel parcel) {
            return new eek(parcel);
        }

        public eek[] nn(int i) {
            return new eek[i];
        }
    }

    public static class C3345a implements Parcelable {
        public static Creator<C3345a> CREATOR = new C33441();
        @cga("template")
        String dEz;
        @cga("uri")
        String uri;

        static class C33441 implements Creator<C3345a> {
            C33441() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m10575Y(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return no(i);
            }

            public C3345a m10575Y(Parcel parcel) {
                return new C3345a(parcel);
            }

            public C3345a[] no(int i) {
                return new C3345a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uri);
            parcel.writeString(this.dEz);
        }

        private C3345a(Parcel parcel) {
            this.uri = parcel.readString();
            this.dEz = parcel.readString();
        }
    }

    public Type aCI() {
        return Type.PAGE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.dEP);
        parcel.writeString(this.dEQ);
        parcel.writeParcelable(this.dER, i);
        parcel.writeParcelable(this.dES, i);
    }

    private eek(Parcel parcel) {
        this.mId = parcel.readString();
        this.dEP = parcel.readString();
        this.dEQ = parcel.readString();
        this.dER = (C3345a) parcel.readParcelable(ecg.class.getClassLoader());
        this.dES = (C3345a) parcel.readParcelable(ecg.class.getClassLoader());
    }
}
