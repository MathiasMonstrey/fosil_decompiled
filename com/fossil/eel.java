package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;

public class eel implements ActivityStoryActor {
    public static Creator<eel> CREATOR = new C33461();
    @cga("id")
    String mId;

    static class C33461 implements Creator<eel> {
        C33461() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10576Z(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return np(i);
        }

        public eel m10576Z(Parcel parcel) {
            return new eel(parcel);
        }

        public eel[] np(int i) {
            return new eel[i];
        }
    }

    public Type aCI() {
        return Type.SITE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
    }

    private eel(Parcel parcel) {
        this.mId = parcel.readString();
    }
}
