package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.internal.Period;
import java.util.Date;

public class ees extends eil implements edk {
    public static final Creator<ees> CREATOR = new C33541();
    @cga("period")
    private Period dEM;
    @cga("criteria")
    private ehs dEO;
    @cga("data_type_field")
    private String dFh;
    @cga("invite_accepted")
    private Boolean dFi;
    @cga("end_time")
    private Date endTime;
    @cga("id")
    private String id;
    @cga("name")
    private String name;
    @cga("start_time")
    private Date startTime;

    static class C33541 implements Creator<ees> {
        C33541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ag(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nw(i);
        }

        public ees ag(Parcel parcel) {
            return new ees(parcel);
        }

        public ees[] nw(int i) {
            return new ees[i];
        }
    }

    private ees(Parcel parcel) {
        super(parcel);
        this.startTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.name = parcel.readString();
        this.dFh = parcel.readString();
        this.id = parcel.readString();
        this.dEM = (Period) parcel.readParcelable(Period.class.getClassLoader());
        this.dFi = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dEO = (ehs) parcel.readValue(ehs.class.getClassLoader());
    }

    public Type aCJ() {
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
        parcel.writeString(this.dFh);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.dEM, i);
        parcel.writeValue(this.dFi);
        parcel.writeValue(this.dEO);
    }
}
