package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class elt extends eil implements els {
    public static Creator<elt> CREATOR = new C34531();
    @cga("_embedded")
    Map<String, ArrayList<elq>> dLW;
    transient ArrayList<elq> dLX;
    transient ArrayList<elq> dLY;

    static class C34531 implements Creator<elt> {
        C34531() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bv(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oT(i);
        }

        public elt bv(Parcel parcel) {
            return new elt(parcel);
        }

        public elt[] oT(int i) {
            return new elt[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
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
        parcel.writeList(this.dLX != null ? this.dLX : new ArrayList(0));
        parcel.writeList(this.dLY != null ? this.dLY : new ArrayList(0));
    }

    private elt(Parcel parcel) {
        Map map = null;
        this.dLX = new ArrayList();
        parcel.readList(this.dLX, elq.class.getClassLoader());
        this.dLX = this.dLX.size() == 0 ? null : this.dLX;
        this.dLY = new ArrayList();
        parcel.readList(this.dLY, elq.class.getClassLoader());
        this.dLY = this.dLY.size() == 0 ? null : this.dLY;
        if (this.dLX != null) {
            map = new HashMap();
        }
        this.dLW = map;
        if (this.dLW != null) {
            this.dLW.put("stats", this.dLX);
            if (this.dLY != null) {
                this.dLW.put("summary_stats", this.dLY);
            }
        }
    }
}
