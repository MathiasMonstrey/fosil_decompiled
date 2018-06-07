package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class eer extends eil implements edj {
    public static Creator<eer> CREATOR = new C33531();
    @cga("leaderboard")
    private List<edh> dFf;
    @cga("result")
    private edh dFg;
    @cga("end_time")
    private Date endTime;
    @cga("start_time")
    private Date startTime;

    static class C33531 implements Creator<eer> {
        C33531() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return af(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nv(i);
        }

        public eer af(Parcel parcel) {
            return new eer(parcel);
        }

        public eer[] nv(int i) {
            return new eer[i];
        }
    }

    public eer() {
        this.dFf = new ArrayList(10);
    }

    private eer(Parcel parcel) {
        super(parcel);
        this.dFf = new ArrayList(10);
        this.startTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endTime = (Date) parcel.readValue(Date.class.getClassLoader());
        parcel.readList(this.dFf, edh.class.getClassLoader());
        this.dFg = (edh) parcel.readValue(edh.class.getClassLoader());
    }

    public Type aCJ() {
        return Type.GROUP_LEADERBOARD;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.startTime);
        parcel.writeValue(this.endTime);
        parcel.writeList(this.dFf);
        parcel.writeValue(this.dFg);
    }
}
