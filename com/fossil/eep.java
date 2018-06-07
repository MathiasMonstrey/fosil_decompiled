package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;

public class eep implements ede {
    public static Creator<eep> CREATOR = new C33511();

    static class C33511 implements Creator<eep> {
        C33511() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ad(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nt(i);
        }

        public eep ad(Parcel parcel) {
            return new eep(parcel);
        }

        public eep[] nt(int i) {
            return new eep[i];
        }
    }

    public Type aCJ() {
        return Type.AD;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    private eep(Parcel parcel) {
    }
}
