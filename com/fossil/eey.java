package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.activitystory.ActivityStoryToutObject;
import com.ua.sdk.activitystory.ActivityStoryToutObject.Subtype;

public class eey implements ActivityStoryToutObject {
    public static Creator<eey> CREATOR = new C33601();
    private final Subtype dFp;

    static class C33601 implements Creator<eey> {
        C33601() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return am(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nC(i);
        }

        public eey am(Parcel parcel) {
            return new eey(parcel);
        }

        public eey[] nC(int i) {
            return new eey[i];
        }
    }

    public eey(Subtype subtype) {
        this.dFp = subtype;
    }

    public Subtype aCK() {
        return this.dFp;
    }

    public Type aCJ() {
        return Type.TOUT;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dFp == null ? -1 : this.dFp.ordinal());
    }

    private eey(Parcel parcel) {
        int readInt = parcel.readInt();
        this.dFp = readInt == -1 ? null : Subtype.values()[readInt];
    }
}
