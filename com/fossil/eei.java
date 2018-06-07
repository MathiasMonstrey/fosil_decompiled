package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;

public class eei implements ActivityStoryActor {
    public static Creator<eei> CREATOR = new C33411();
    @cga("id")
    String mId;

    static class C33411 implements Creator<eei> {
        C33411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10572V(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nl(i);
        }

        public eei m10572V(Parcel parcel) {
            return new eei(parcel);
        }

        public eei[] nl(int i) {
            return new eei[i];
        }
    }

    public Type aCI() {
        return Type.BRAND;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
    }

    private eei(Parcel parcel) {
        this.mId = parcel.readString();
    }
}
