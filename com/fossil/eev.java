package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;

public class eev extends eex implements edr {
    public static Creator<eev> CREATOR = new C33571();
    @cga("story")
    edc dFm;
    @cga("id")
    String mId;

    static class C33571 implements Creator<eev> {
        C33571() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aj(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nz(i);
        }

        public eev aj(Parcel parcel) {
            return new eev(parcel);
        }

        public eev[] nz(int i) {
            return new eev[i];
        }
    }

    public Type aCJ() {
        return Type.REPOST;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.dFm, i);
    }

    protected eev(Parcel parcel) {
        super(parcel);
        this.mId = parcel.readString();
        this.dFm = (edc) parcel.readParcelable(edc.class.getClassLoader());
    }
}
