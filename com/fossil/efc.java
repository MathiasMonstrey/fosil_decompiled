package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryTarget;
import com.ua.sdk.activitystory.ActivityStoryTarget$Type;

public class efc implements ActivityStoryTarget {
    public static Creator<efc> CREATOR = new C33651();
    @cga("type")
    ActivityStoryTarget$Type dFB;
    @cga("id")
    String id;

    static class C33651 implements Creator<efc> {
        C33651() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aq(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nG(i);
        }

        public efc aq(Parcel parcel) {
            return new efc(parcel);
        }

        public efc[] nG(int i) {
            return new efc[i];
        }
    }

    private efc(Parcel parcel) {
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
