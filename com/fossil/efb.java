package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryTarget;
import com.ua.sdk.activitystory.ActivityStoryTarget$Type;

public class efb implements ActivityStoryTarget {
    public static Creator<efb> CREATOR = new C33641();
    @cga("type")
    ActivityStoryTarget$Type dFB;
    @cga("id")
    String id;

    static class C33641 implements Creator<efb> {
        C33641() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ap(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nF(i);
        }

        public efb ap(Parcel parcel) {
            return new efb(parcel);
        }

        public efb[] nF(int i) {
            return new efb[i];
        }
    }

    private efb(Parcel parcel) {
        this.id = parcel.readString();
        this.dFB = (ActivityStoryTarget$Type) parcel.readValue(ActivityStoryTarget$Type.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeValue(this.dFB);
    }
}
