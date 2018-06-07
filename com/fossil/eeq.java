package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;

public class eeq implements edf {
    public static Creator<eeq> CREATOR = new C33521();
    @cga("text")
    String mText;

    static class C33521 implements Creator<eeq> {
        C33521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ae(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nu(i);
        }

        public eeq ae(Parcel parcel) {
            return new eeq(parcel);
        }

        public eeq[] nu(int i) {
            return new eeq[i];
        }
    }

    public Type aCJ() {
        return Type.COMMENT;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mText);
    }

    private eeq(Parcel parcel) {
        this.mText = parcel.readString();
    }
}
