package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.UserObjectState;
import java.util.Date;

public class ekr extends eil implements Parcelable, ekn {
    public static Creator<ekr> CREATOR = new C34411();
    private transient String cBN;
    private Gender dFq;
    private ejd dFt;
    private Date dFu;
    private egb dGo;
    private String dKU;
    private String dKV;
    private String dKW;
    private String dKX;
    private String dKY;
    private ech dKZ;
    private Double dKe;
    private Double dLa;
    private Date dLb;
    private MeasurementSystem dLc;
    private eko dLd;
    private ela dLe;
    private eir dLf;
    private UserObjectState dLg;
    private transient Privacy dLh;
    private transient Privacy dLi;
    private transient Privacy dLj;
    private transient Privacy dLk;
    private transient Privacy dLl;
    private transient Privacy dLm;
    private transient Privacy dLn;
    private transient Privacy dLo;
    private transient ehc dLp;
    private String displayName;
    private String email;
    private String firstName;
    private String id;
    private String lastName;
    private String timeZone;
    private String username;

    static class C34411 implements Creator<ekr> {
        C34411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bn(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oL(i);
        }

        public ekr bn(Parcel parcel) {
            return new ekr(parcel);
        }

        public ekr[] oL(int i) {
            return new ekr[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public /* synthetic */ ecg aEu() {
        return aEB();
    }

    public ekr() {
        this.dGo = new egc();
        this.dKX = "";
        this.dLd = new ekp();
        this.dLe = new elb();
        this.dFt = new eje();
        this.dLf = new eir();
        this.dLg = UserObjectState.FULL;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public egb aEA() {
        return this.dGo;
    }

    public String getPassword() {
        return this.cBN;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String aEf() {
        return this.dKU;
    }

    public void lX(String str) {
        this.dKU = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public ech aEg() {
        return this.dKZ;
    }

    public void m10821a(ech com_fossil_ech) {
        this.dKZ = com_fossil_ech;
    }

    public Gender aEh() {
        return this.dFq;
    }

    public void m10825a(Gender gender) {
        this.dFq = gender;
    }

    public Double aEi() {
        return this.dLa;
    }

    public void m10826c(Double d) {
        this.dLa = d;
    }

    public Double aEj() {
        return this.dKe;
    }

    public void m10827d(Double d) {
        this.dKe = d;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public Date aEk() {
        return this.dFu;
    }

    public void m10818B(Date date) {
        this.dFu = date;
    }

    public Date aEl() {
        return this.dLb;
    }

    public void m10819C(Date date) {
        this.dLb = date;
    }

    public MeasurementSystem aEm() {
        return this.dLc;
    }

    public void m10828f(MeasurementSystem measurementSystem) {
        this.dLc = measurementSystem;
    }

    public eko aEn() {
        return this.dLd;
    }

    public void m10823a(eko com_fossil_eko) {
        this.dLd = com_fossil_eko;
    }

    public ela aEo() {
        return this.dLe;
    }

    public void m10824a(ela com_fossil_ela) {
        this.dLe = com_fossil_ela;
    }

    public ejd aEp() {
        return this.dFt;
    }

    public void m10822a(ejd com_fossil_ejd) {
        this.dFt = com_fossil_ejd;
    }

    public String aEq() {
        return this.dKV;
    }

    public void lY(String str) {
        this.dKV = str;
    }

    public String aEr() {
        return this.dKW;
    }

    public void lZ(String str) {
        this.dKW = str;
    }

    public String aEs() {
        return this.dKX;
    }

    public void ma(String str) {
        this.dKX = str;
    }

    public String aEt() {
        return this.dKY;
    }

    public void mb(String str) {
        this.dKY = str;
    }

    public ece aCt() {
        return new eiv(this.id, this.dIl, getHref());
    }

    public eir aEB() {
        return this.dLf;
    }

    public void m10820a(ecg com_fossil_ecg) {
        this.dLf = (eir) com_fossil_ecg;
    }

    public UserObjectState aEC() {
        return this.dLg;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        long time;
        int i2;
        long j = -1;
        int i3 = -1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeParcelable(this.dGo, 0);
        parcel.writeString(this.cBN);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.dKU);
        parcel.writeString(this.displayName);
        parcel.writeString(this.dKV);
        parcel.writeString(this.dKW);
        parcel.writeString(this.dKX);
        parcel.writeString(this.dKY);
        parcel.writeParcelable(this.dKZ, 0);
        parcel.writeInt(this.dFq == null ? -1 : this.dFq.ordinal());
        parcel.writeValue(this.dLa);
        parcel.writeValue(this.dKe);
        parcel.writeString(this.timeZone);
        if (this.dFu != null) {
            time = this.dFu.getTime();
        } else {
            time = -1;
        }
        parcel.writeLong(time);
        if (this.dLb != null) {
            j = this.dLb.getTime();
        }
        parcel.writeLong(j);
        if (this.dLc == null) {
            i2 = -1;
        } else {
            i2 = this.dLc.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.dLd, 0);
        parcel.writeParcelable(this.dLe, 0);
        parcel.writeParcelable(this.dFt, 0);
        parcel.writeParcelable(this.dLf, 0);
        parcel.writeParcelable(this.dLh, i);
        parcel.writeParcelable(this.dLi, i);
        parcel.writeParcelable(this.dLj, i);
        parcel.writeParcelable(this.dLk, i);
        parcel.writeParcelable(this.dLl, i);
        parcel.writeParcelable(this.dLm, i);
        parcel.writeParcelable(this.dLn, i);
        parcel.writeParcelable(this.dLo, i);
        parcel.writeParcelable(this.dLp, 0);
        if (this.dLg != null) {
            i3 = this.dLg.ordinal();
        }
        parcel.writeInt(i3);
    }

    private ekr(Parcel parcel) {
        MeasurementSystem measurementSystem;
        UserObjectState userObjectState = null;
        super(parcel);
        this.dGo = new egc();
        this.dKX = "";
        this.dLd = new ekp();
        this.dLe = new elb();
        this.dFt = new eje();
        this.dLf = new eir();
        this.dLg = UserObjectState.FULL;
        this.id = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.dGo = (egb) parcel.readParcelable(egb.class.getClassLoader());
        this.cBN = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.dKU = parcel.readString();
        this.displayName = parcel.readString();
        this.dKV = parcel.readString();
        this.dKW = parcel.readString();
        this.dKX = parcel.readString();
        this.dKY = parcel.readString();
        this.dKZ = (ech) parcel.readParcelable(ech.class.getClassLoader());
        int readInt = parcel.readInt();
        this.dFq = readInt == -1 ? null : Gender.values()[readInt];
        this.dLa = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dKe = (Double) parcel.readValue(Double.class.getClassLoader());
        this.timeZone = parcel.readString();
        long readLong = parcel.readLong();
        this.dFu = readLong == -1 ? null : new Date(readLong);
        readLong = parcel.readLong();
        this.dLb = readLong == -1 ? null : new Date(readLong);
        readInt = parcel.readInt();
        if (readInt == -1) {
            measurementSystem = null;
        } else {
            measurementSystem = MeasurementSystem.values()[readInt];
        }
        this.dLc = measurementSystem;
        this.dLd = (eko) parcel.readParcelable(eko.class.getClassLoader());
        this.dLe = (ela) parcel.readParcelable(ela.class.getClassLoader());
        this.dFt = (ejd) parcel.readParcelable(ejd.class.getClassLoader());
        this.dLf = (eir) parcel.readParcelable(ecg.class.getClassLoader());
        this.dLh = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLi = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLj = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLk = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLl = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLm = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLn = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLo = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.dLp = (ehc) parcel.readParcelable(ehc.class.getClassLoader());
        readInt = parcel.readInt();
        if (readInt != -1) {
            userObjectState = UserObjectState.values()[readInt];
        }
        this.dLg = userObjectState;
    }
}
