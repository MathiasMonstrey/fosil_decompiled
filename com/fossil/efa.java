package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.privacy.Privacy;
import java.util.ArrayList;
import java.util.List;

public class efa extends eil implements eea {
    public static Creator<efa> CREATOR = new C33631();
    @cga("title")
    String dEP;
    @cga("energy_burned")
    Integer dFA;
    @cga("privacy")
    Privacy dFa;
    @cga("steps")
    Integer dFd;
    @cga("highlights")
    List<edl> dFe;
    @cga("distance")
    Double dFn;
    @cga("avg_pace")
    Double dFw;
    @cga("notes")
    String dFx;
    @cga("avg_speed")
    Double dFy;
    @cga("duration")
    Long dFz;

    static class C33631 implements Creator<efa> {
        C33631() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ao(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nE(i);
        }

        public efa ao(Parcel parcel) {
            return new efa(parcel);
        }

        public efa[] nE(int i) {
            return new efa[i];
        }
    }

    public Type aCJ() {
        return Type.WORKOUT;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dFn);
        parcel.writeValue(this.dFw);
        parcel.writeString(this.dEP);
        parcel.writeString(this.dFx);
        parcel.writeParcelable(this.dFa, i);
        parcel.writeValue(this.dFd);
        parcel.writeValue(this.dFy);
        parcel.writeValue(this.dFA);
        parcel.writeValue(this.dFz);
        parcel.writeList(this.dFe);
    }

    private efa(Parcel parcel) {
        super(parcel);
        this.dFn = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dFw = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dEP = parcel.readString();
        this.dFx = parcel.readString();
        this.dFa = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dFd = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dFy = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dFA = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dFz = (Long) parcel.readValue(Long.class.getClassLoader());
        this.dFe = new ArrayList();
        parcel.readList(this.dFe, eet.class.getClassLoader());
        if (this.dFe.isEmpty()) {
            this.dFe = null;
        }
    }
}
