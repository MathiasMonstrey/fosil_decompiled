package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.user.Gender;

public class een extends eil implements edy {
    public static Creator<een> CREATOR = new C33481();
    @cga("title")
    String dEP;
    @cga("gender")
    Gender dET;
    @cga("is_mvp")
    Boolean dEU;
    @cga("friendship")
    C3349a dEV;
    transient ecg dEW;
    @cga("first_name")
    String dch;
    @cga("last_name")
    String dci;
    @cga("id")
    String mId;

    static class C33481 implements Creator<een> {
        C33481() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ab(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nr(i);
        }

        public een ab(Parcel parcel) {
            return new een(parcel);
        }

        public een[] nr(int i) {
            return new een[i];
        }
    }

    static class C3349a {
        @cga("to_user")
        String dEX;
        @cga("status")
        FriendshipStatus dEY;
        @cga("from_user")
        String dEZ;

        C3349a() {
        }
    }

    public String getFirstName() {
        return this.dch;
    }

    public String getLastName() {
        return this.dci;
    }

    public Type aCI() {
        return Type.USER;
    }

    protected void aCL() {
        if (this.dEV == null) {
            this.dEV = new C3349a();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeString(this.dch);
        parcel.writeString(this.dci);
        parcel.writeString(this.dEP);
        parcel.writeInt(this.dET == null ? -1 : this.dET.ordinal());
        parcel.writeValue(this.dEU);
        parcel.writeParcelable(this.dEW, i);
        String str = (this.dEV == null || this.dEV.dEZ == null) ? "" : this.dEV.dEZ;
        parcel.writeString(str);
        if (!(this.dEV == null || this.dEV.dEY == null)) {
            i2 = this.dEV.dEY.ordinal();
        }
        parcel.writeInt(i2);
        str = (this.dEV == null || this.dEV.dEX == null) ? "" : this.dEV.dEX;
        parcel.writeString(str);
    }

    private een(Parcel parcel) {
        String str = null;
        super(parcel);
        this.mId = parcel.readString();
        this.dch = parcel.readString();
        this.dci = parcel.readString();
        this.dEP = parcel.readString();
        int readInt = parcel.readInt();
        this.dET = readInt == -1 ? null : Gender.values()[readInt];
        this.dEU = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dEW = (ecg) parcel.readParcelable(ecg.class.getClassLoader());
        String readString = parcel.readString();
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
        if (!readString.equals("") || readInt2 != -1 || !readString2.equals("")) {
            aCL();
            C3349a c3349a = this.dEV;
            if (readString.equals("")) {
                readString = null;
            }
            c3349a.dEZ = readString;
            this.dEV.dEY = readInt2 == -1 ? null : FriendshipStatus.values()[readInt2];
            C3349a c3349a2 = this.dEV;
            if (!readString2.equals("")) {
                str = readString2;
            }
            c3349a2.dEX = str;
        }
    }

    public String toString() {
        return getFirstName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getLastName();
    }
}
