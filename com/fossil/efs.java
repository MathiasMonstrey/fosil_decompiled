package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.internal.Period;
import java.util.ArrayList;
import java.util.List;

public class efs extends eil implements efr {
    public static Creator<efs> CREATOR = new C33741();
    @cga("period")
    protected Period dEM;
    @cga("summary")
    protected eft dGg;
    @cga("periods")
    protected List<eft> dGh;

    static class C33741 implements Creator<efs> {
        C33741() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return av(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nL(i);
        }

        public efs av(Parcel parcel) {
            return new efs(parcel);
        }

        public efs[] nL(int i) {
            return new efs[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    protected efs(Parcel parcel) {
        super(parcel);
        this.dGh = new ArrayList();
        this.dGg = (eft) parcel.readValue(efu.class.getClassLoader());
        parcel.readList(this.dGh, eft.class.getClassLoader());
        this.dEM = (Period) parcel.readValue(Period.class.getClassLoader());
    }

    public ece<efr> aCt() {
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
        if (this.dGh == null) {
            this.dGh = new ArrayList();
        }
        parcel.writeValue(this.dGg);
        parcel.writeList(this.dGh);
        parcel.writeValue(this.dEM);
    }
}
