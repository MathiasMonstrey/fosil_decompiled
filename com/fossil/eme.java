package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Date;
import java.util.TimeZone;

public class eme extends eil implements emb {
    public static final Creator<eme> CREATOR = new C34581();
    @cga("reference_key")
    String dGE;
    @cga("created_datetime")
    Date dMA;
    @cga("notes")
    String dMB;
    @cga("start_locale_timezone")
    TimeZone dMC;
    @cga("has_time_series")
    Boolean dMD;
    @cga("is_verified")
    Boolean dME;
    @cga("aggregates")
    emc dMF;
    @cga("time_series")
    ema dMG;
    @cga("sharing")
    eee dMH;
    @cga("attachments")
    eeb dMI;
    @cga("updated_datetime")
    Date dMz;
    @cga("name")
    String name;
    @cga("source")
    String source;
    @cga("start_datetime")
    Date startTime;

    static class C34581 implements Creator<eme> {
        C34581() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bA(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oZ(i);
        }

        public eme bA(Parcel parcel) {
            return new eme(parcel);
        }

        public eme[] oZ(int i) {
            return new eme[i];
        }
    }

    public /* synthetic */ ece aCt() {
        return aEP();
    }

    public /* synthetic */ ecj aCy() {
        return aEP();
    }

    public emf aEP() {
        eiu lA = lA("self");
        if (lA != null) {
            return new emf(lA.getId(), this.dIl, lA.getHref());
        }
        if (this.dIl == -1) {
            return new emf(null);
        }
        return new emf(null, this.dIl, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        long time;
        long j = -1;
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.startTime != null ? this.startTime.getTime() : -1);
        if (this.dMz != null) {
            time = this.dMz.getTime();
        } else {
            time = -1;
        }
        parcel.writeLong(time);
        if (this.dMA != null) {
            j = this.dMA.getTime();
        }
        parcel.writeLong(j);
        parcel.writeString(this.name);
        parcel.writeString(this.dMB);
        parcel.writeSerializable(this.dMC);
        parcel.writeString(this.source);
        parcel.writeString(this.dGE);
        parcel.writeValue(this.dMD);
        parcel.writeValue(this.dME);
        parcel.writeParcelable(this.dMF, i);
        parcel.writeParcelable(this.dMG, i);
        parcel.writeParcelable(this.dMH, i);
        parcel.writeParcelable(this.dMI, i);
    }

    private eme(Parcel parcel) {
        Date date = null;
        super(parcel);
        long readLong = parcel.readLong();
        this.startTime = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        this.dMz = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        if (readLong != -1) {
            date = new Date(readLong);
        }
        this.dMA = date;
        this.name = parcel.readString();
        this.dMB = parcel.readString();
        this.dMC = (TimeZone) parcel.readSerializable();
        this.source = parcel.readString();
        this.dGE = parcel.readString();
        this.dMD = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dME = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dMF = (emc) parcel.readParcelable(emc.class.getClassLoader());
        this.dMG = (ema) parcel.readParcelable(elz.class.getClassLoader());
        this.dMH = (eee) parcel.readParcelable(eee.class.getClassLoader());
        this.dMI = (eeb) parcel.readParcelable(eeb.class.getClassLoader());
    }
}
