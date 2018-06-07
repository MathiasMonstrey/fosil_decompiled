package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class eif extends eil implements eie {
    public static final Creator<eif> CREATOR = new C34101();
    @cga("zones")
    private List<eid> dHU;
    private transient ece<eie> dHV;

    static class C34101 implements Creator<eif> {
        C34101() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aR(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oj(i);
        }

        public eif aR(Parcel parcel) {
            return new eif(parcel);
        }

        public eif[] oj(int i) {
            return new eif[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public eif() {
        this.dHU = new ArrayList();
    }

    private eif(Parcel parcel) {
        super(parcel);
        this.dHU = new ArrayList();
        parcel.readList(this.dHU, eid.class.getClassLoader());
    }

    public ece<eie> aCt() {
        if (this.dHV == null) {
            eiu lA = lA("self");
            if (lA != null) {
                this.dHV = new eiv(lA.getId(), lA.getHref());
            }
        }
        return this.dHV;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.dHU);
    }
}
