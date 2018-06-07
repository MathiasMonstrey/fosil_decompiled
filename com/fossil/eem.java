package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;

public class eem implements ActivityStoryActor {
    public static Creator<eem> CREATOR = new C33471();

    static class C33471 implements Creator<eem> {
        C33471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aa(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nq(i);
        }

        public eem aa(Parcel parcel) {
            return new eem(parcel);
        }

        public eem[] nq(int i) {
            return new eem[i];
        }
    }

    private eem(Parcel parcel) {
    }

    public Type aCI() {
        return Type.UNKNOWN;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
