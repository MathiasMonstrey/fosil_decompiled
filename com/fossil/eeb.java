package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.Attachment;
import java.util.ArrayList;

public class eeb implements Parcelable {
    public static final Creator<eeb> CREATOR = new C33321();
    @cga("count")
    Integer count;
    @cga("items")
    ArrayList<Attachment> dEx;

    static class C33321 implements Creator<eeb> {
        C33321() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10565O(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ne(i);
        }

        public eeb m10565O(Parcel parcel) {
            return new eeb(parcel);
        }

        public eeb[] ne(int i) {
            return new eeb[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.count);
        parcel.writeList(this.dEx);
    }

    private eeb(Parcel parcel) {
        this.count = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dEx = parcel.readArrayList(eed.class.getClassLoader());
    }
}
