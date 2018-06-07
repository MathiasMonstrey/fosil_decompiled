package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryActor.Type;
import com.ua.sdk.internal.Period;
import java.util.Date;

public class eej extends eil implements edg {
    public static final Creator<eej> CREATOR = new C33421();
    @cga("data_type")
    private String dEL;
    @cga("period")
    private Period dEM;
    @cga("data_type_field")
    private String dEN;
    @cga("criteria")
    private ehs dEO;
    @cga("end_time")
    private Date endTime;
    @cga("id")
    private String id;
    @cga("name")
    private String name;
    @cga("start_time")
    private Date startTime;

    static class C33421 implements Creator<eej> {
        C33421() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10573W(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nm(i);
        }

        public eej m10573W(Parcel parcel) {
            return new eej(parcel);
        }

        public eej[] nm(int i) {
            return new eej[i];
        }
    }

    private eej(Parcel parcel) {
        super(parcel);
        this.startTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.name = parcel.readString();
        this.dEL = parcel.readString();
        this.id = parcel.readString();
        this.dEM = (Period) parcel.readParcelable(Period.class.getClassLoader());
        this.dEN = parcel.readString();
        this.dEO = (ehs) parcel.readValue(ehs.class.getClassLoader());
    }

    public Type aCI() {
        return Type.GROUP;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.startTime);
        parcel.writeValue(this.endTime);
        parcel.writeString(this.name);
        parcel.writeString(this.dEL);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.dEM, i);
        parcel.writeString(this.dEN);
        parcel.writeValue(this.dEO);
    }
}
