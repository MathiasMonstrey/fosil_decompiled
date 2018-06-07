package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;

public class eeu implements edn {
    public static Creator<eeu> CREATOR = new C33561();

    static class C33561 implements Creator<eeu> {
        C33561() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ai(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ny(i);
        }

        public eeu ai(Parcel parcel) {
            return new eeu(parcel);
        }

        public eeu[] ny(int i) {
            return new eeu[i];
        }
    }

    public Type aCJ() {
        return Type.LIKE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    private eeu(Parcel parcel) {
    }
}
