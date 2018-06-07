package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryTarget;
import com.ua.sdk.activitystory.ActivityStoryVerb;
import java.util.Date;

public class edm extends eil implements edc {
    public static Creator<edm> CREATOR = new C33241();
    @cga("actor")
    ActivityStoryActor dDT;
    @cga("verb")
    ActivityStoryVerb dDU;
    @cga("object")
    ActivityStoryObject dDV;
    @cga("published")
    Date dDW;
    @cga("template")
    edx dDX;
    @cga("target")
    ActivityStoryTarget dDY;
    @cga("likes")
    edq dDZ;
    @cga("comments")
    edq dEa;
    @cga("reposts")
    edt dEb;
    @cga("attachments")
    eeb dEc;
    @cga("sharing")
    eee dEd;
    @cga("source")
    eco dEe;
    @cga("id")
    String mId;

    static class C33241 implements Creator<edm> {
        C33241() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10547J(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return na(i);
        }

        public edm m10547J(Parcel parcel) {
            return new edm(parcel);
        }

        public edm[] na(int i) {
            return new edm[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public edw aCH() {
        return this.dDX;
    }

    public ece<edc> aCt() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiv(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.dDT, 0);
        parcel.writeInt(this.dDU == null ? -1 : this.dDU.ordinal());
        parcel.writeParcelable(this.dDV, 0);
        parcel.writeLong(this.dDW != null ? this.dDW.getTime() : -1);
        parcel.writeParcelable(this.dDX, i);
        parcel.writeParcelable(this.dDY, i);
        parcel.writeParcelable(this.dEa, i);
        parcel.writeParcelable(this.dDZ, i);
        parcel.writeParcelable(this.dEb, i);
        parcel.writeParcelable(this.dEc, i);
        parcel.writeParcelable(this.dEd, i);
        parcel.writeParcelable(this.dEe, i);
    }

    private edm(Parcel parcel) {
        Date date = null;
        super(parcel);
        this.mId = parcel.readString();
        this.dDT = (ActivityStoryActor) parcel.readParcelable(ActivityStoryActor.class.getClassLoader());
        int readInt = parcel.readInt();
        this.dDU = readInt == -1 ? null : ActivityStoryVerb.values()[readInt];
        this.dDV = (ActivityStoryObject) parcel.readParcelable(ActivityStoryObject.class.getClassLoader());
        long readLong = parcel.readLong();
        if (readLong != -1) {
            date = new Date(readLong);
        }
        this.dDW = date;
        this.dDX = (edx) parcel.readParcelable(edw.class.getClassLoader());
        this.dDY = (ActivityStoryTarget) parcel.readParcelable(ActivityStoryTarget.class.getClassLoader());
        this.dEa = (edq) parcel.readParcelable(edq.class.getClassLoader());
        this.dDZ = (edq) parcel.readParcelable(edq.class.getClassLoader());
        this.dEb = (edt) parcel.readParcelable(edq.class.getClassLoader());
        this.dEc = (eeb) parcel.readParcelable(eeb.class.getClassLoader());
        this.dEd = (eee) parcel.readParcelable(eee.class.getClassLoader());
        this.dEe = (eco) parcel.readParcelable(eco.class.getClassLoader());
    }
}
