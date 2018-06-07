package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eln implements elm {
    public static Creator<eln> CREATOR = new C34501();
    @cga("start")
    ech dLH;
    @cga("end")
    ech dLI;

    static class C34501 implements Creator<eln> {
        C34501() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bs(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oQ(i);
        }

        public eln bs(Parcel parcel) {
            return new eln(parcel);
        }

        public eln[] oQ(int i) {
            return new eln[i];
        }
    }

    protected eln() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dLH, 0);
        parcel.writeParcelable(this.dLI, 0);
    }

    private eln(Parcel parcel) {
        this.dLH = (ech) parcel.readParcelable(ech.class.getClassLoader());
        this.dLI = (ech) parcel.readParcelable(ech.class.getClassLoader());
    }
}
