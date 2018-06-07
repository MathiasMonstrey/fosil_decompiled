package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ejg extends eil implements ejf {
    public static final Creator<ejg> CREATOR = new C34221();
    @cga("action")
    String dJi;
    @cga("resource")
    String dJj;

    static class C34221 implements Creator<ejg> {
        C34221() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aY(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ou(i);
        }

        public ejg aY(Parcel parcel) {
            return new ejg(parcel);
        }

        public ejg[] ou(int i) {
            return new ejg[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dJi);
        parcel.writeString(this.dJj);
    }

    private ejg(Parcel parcel) {
        super(parcel);
        this.dJi = parcel.readString();
        this.dJj = parcel.readString();
    }
}
