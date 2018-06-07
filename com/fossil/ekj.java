package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ekj extends eil implements eki {
    public static Creator<ekj> CREATOR = new C34361();
    @cga("reasons")
    List<ekl> dKb;
    Integer dKc;
    eir dKd;

    static class C34361 implements Creator<ekj> {
        C34361() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bk(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oI(i);
        }

        public ekj bk(Parcel parcel) {
            return new ekj(parcel);
        }

        public ekj[] oI(int i) {
            return new ekj[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ekj() {
        this.dKb = new ArrayList();
        this.dKd = new eir();
    }

    public ece aCt() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.dKb);
        parcel.writeValue(this.dKc);
        parcel.writeParcelable(this.dKd, i);
    }

    private ekj(Parcel parcel) {
        super(parcel);
        this.dKb = new ArrayList();
        this.dKd = new eir();
        parcel.readTypedList(this.dKb, ekl.CREATOR);
        this.dKc = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dKd = (eir) parcel.readParcelable(eir.class.getClassLoader());
    }
}
