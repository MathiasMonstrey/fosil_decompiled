package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.user.Gender;
import java.util.Date;

public class eez extends eil implements edz {
    public static Creator<eez> CREATOR = new C33611();
    @cga("gender")
    Gender dFq;
    @cga("is_mvp")
    Boolean dFr;
    @cga("privacy")
    Privacy dFs;
    @cga("location")
    ejd dFt;
    @cga("date_joined")
    Date dFu;
    @cga("friendship")
    C3362a dFv;
    @cga("first_name")
    String firstName;
    @cga("id")
    String id;
    @cga("last_name")
    String lastName;
    @cga("title")
    String title;

    static class C33611 implements Creator<eez> {
        C33611() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return an(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nD(i);
        }

        public eez an(Parcel parcel) {
            return new eez(parcel);
        }

        public eez[] nD(int i) {
            return new eez[i];
        }
    }

    static class C3362a {
        @cga("to_user")
        String dEX;
        @cga("status")
        FriendshipStatus dEY;
        @cga("from_user")
        String dEZ;

        C3362a() {
        }
    }

    public Type aCJ() {
        return Type.USER;
    }

    protected void aCL() {
        if (this.dFv == null) {
            this.dFv = new C3362a();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.title);
        parcel.writeInt(this.dFq == null ? -1 : this.dFq.ordinal());
        parcel.writeValue(this.dFr);
        parcel.writeParcelable(this.dFs, i);
        parcel.writeParcelable(this.dFt, i);
        parcel.writeLong(this.dFu == null ? -1 : this.dFu.getTime());
        String str = (this.dFv == null || this.dFv.dEZ == null) ? "" : this.dFv.dEZ;
        parcel.writeString(str);
        if (!(this.dFv == null || this.dFv.dEY == null)) {
            i2 = this.dFv.dEY.ordinal();
        }
        parcel.writeInt(i2);
        str = (this.dFv == null || this.dFv.dEX == null) ? "" : this.dFv.dEX;
        parcel.writeString(str);
    }

    private eez(Parcel parcel) {
        String str = null;
        super(parcel);
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.title = parcel.readString();
        int readInt = parcel.readInt();
        this.dFq = readInt == -1 ? null : Gender.values()[readInt];
        this.dFr = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dFs = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dFt = (ejd) parcel.readParcelable(ejd.class.getClassLoader());
        Long valueOf = Long.valueOf(parcel.readLong());
        this.dFu = valueOf.longValue() == -1 ? null : new Date(valueOf.longValue());
        String readString = parcel.readString();
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
        if (!readString.equals("") || readInt2 != -1 || !readString2.equals("")) {
            aCL();
            C3362a c3362a = this.dFv;
            if (readString.equals("")) {
                readString = null;
            }
            c3362a.dEZ = readString;
            this.dFv.dEY = readInt2 == -1 ? null : FriendshipStatus.values()[readInt2];
            C3362a c3362a2 = this.dFv;
            if (!readString2.equals("")) {
                str = readString2;
            }
            c3362a2.dEX = str;
        }
    }
}
