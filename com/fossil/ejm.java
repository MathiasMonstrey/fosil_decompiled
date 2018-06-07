package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.Privacy.Level;

public class ejm extends eil implements Parcelable, Privacy {
    public static Creator<ejm> CREATOR = new C34251();
    private String dJs;
    private Level dJt;

    static class C34251 implements Creator<ejm> {
        C34251() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bc(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oA(i);
        }

        public ejm bc(Parcel parcel) {
            return new ejm(parcel);
        }

        public ejm[] oA(int i) {
            return new ejm[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    protected ejm(Level level, String str) {
        this.dJt = (Level) eiy.dd(level);
        this.dJs = str;
    }

    public Level aEa() {
        return this.dJt;
    }

    public ece<Privacy> aCt() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dJt.toString());
        parcel.writeString(this.dJs);
    }

    private ejm(Parcel parcel) {
        super(parcel);
        this.dJt = Level.valueOf(parcel.readString());
        this.dJs = parcel.readString();
    }
}
