package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.privacy.Privacy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class eeo extends eil implements edd {
    public static Creator<eeo> CREATOR = new C33501();
    @cga("published")
    Date dDW;
    @cga("privacy")
    Privacy dFa;
    @cga("start_time")
    Date dFb;
    @cga("end_time")
    Date dFc;
    @cga("steps")
    Integer dFd;
    @cga("highlights")
    List<edl> dFe;

    static class C33501 implements Creator<eeo> {
        C33501() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ac(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ns(i);
        }

        public eeo ac(Parcel parcel) {
            return new eeo(parcel);
        }

        public eeo[] ns(int i) {
            return new eeo[i];
        }
    }

    public Type aCJ() {
        return Type.ACTIGRAPHY;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        long time;
        long j = -1;
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.dFa, i);
        parcel.writeLong(this.dFb != null ? this.dFb.getTime() : -1);
        if (this.dFc != null) {
            time = this.dFc.getTime();
        } else {
            time = -1;
        }
        parcel.writeLong(time);
        if (this.dDW != null) {
            j = this.dDW.getTime();
        }
        parcel.writeLong(j);
        parcel.writeValue(this.dFd);
        parcel.writeList(this.dFe);
    }

    private eeo(Parcel parcel) {
        super(parcel);
        this.dFa = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        long readLong = parcel.readLong();
        this.dFb = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        this.dFc = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        this.dDW = readLong == -1 ? null : new Date(readLong);
        this.dFd = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dFe = new ArrayList();
        parcel.readList(this.dFe, eet.class.getClassLoader());
        if (this.dFe.isEmpty()) {
            this.dFe = null;
        }
    }
}
