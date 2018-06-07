package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.activitystory.ActivityStoryObject.Type;
import com.ua.sdk.privacy.Privacy;
import java.util.ArrayList;
import java.util.List;

public class eew extends eil implements Parcelable, edu {
    public static Creator<eew> CREATOR = new C33581();
    @cga("title")
    private String dEP;
    @cga("privacy")
    private Privacy dFa;
    @cga("highlights")
    private List<edl> dFe;
    @cga("distance")
    private Double dFn;
    @cga("location")
    private ejd dFo;

    static class C33581 implements Creator<eew> {
        C33581() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ak(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nA(i);
        }

        public eew ak(Parcel parcel) {
            return new eew(parcel);
        }

        public eew[] nA(int i) {
            return new eew[i];
        }
    }

    public Type aCJ() {
        return Type.ROUTE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dFn);
        parcel.writeString(this.dEP);
        parcel.writeParcelable(this.dFa, i);
        parcel.writeList(this.dFe);
        parcel.writeParcelable(this.dFo, 0);
    }

    private eew(Parcel parcel) {
        super(parcel);
        this.dFn = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dEP = parcel.readString();
        this.dFa = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dFe = new ArrayList();
        parcel.readList(this.dFe, eet.class.getClassLoader());
        if (this.dFe.isEmpty()) {
            this.dFe = null;
        }
        this.dFo = (ejd) parcel.readParcelable(ejd.class.getClassLoader());
    }
}
