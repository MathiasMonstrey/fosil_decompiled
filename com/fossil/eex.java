package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.privacy.Privacy;

public class eex implements edv {
    public static Creator<eex> CREATOR = new C33591();
    @cga("privacy")
    Privacy dFa;
    @cga("text")
    String mText;

    static class C33591 implements Creator<eex> {
        C33591() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return al(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nB(i);
        }

        public eex al(Parcel parcel) {
            return new eex(parcel);
        }

        public eex[] nB(int i) {
            return new eex[i];
        }
    }

    public Type aCJ() {
        return Type.STATUS;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mText);
        parcel.writeParcelable(this.dFa, i);
    }

    protected eex(Parcel parcel) {
        this.mText = parcel.readString();
        this.dFa = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
    }
}
