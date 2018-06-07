package com.fossil;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Date;

public class efz extends eil implements Parcelable, efy {
    public static Creator<efz> CREATOR = new C33771();
    private String dGu;
    private Uri dGv;
    private Date dGw;
    private String token;
    private String uid;

    static class C33771 implements Creator<efz> {
        C33771() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ax(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nN(i);
        }

        public efz ax(Parcel parcel) {
            return new efz(parcel);
        }

        public efz[] nN(int i) {
            return new efz[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
        return new eiv("", aDp(), getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeString(this.dGu);
        parcel.writeString(this.uid);
        parcel.writeParcelable(this.dGv, i);
        parcel.writeLong(this.dGw != null ? this.dGw.getTime() : -1);
    }

    private efz(Parcel parcel) {
        super(parcel);
        this.token = parcel.readString();
        this.dGu = parcel.readString();
        this.uid = parcel.readString();
        this.dGv = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        long readLong = parcel.readLong();
        this.dGw = readLong == -1 ? null : new Date(readLong);
    }
}
