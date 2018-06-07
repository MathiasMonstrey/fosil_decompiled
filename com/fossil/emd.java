package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class emd implements emc {
    public static final Creator<emd> CREATOR = new C34571();
    @cga("heartrate_min")
    Integer dMe;
    @cga("heartrate_max")
    Integer dMf;
    @cga("heartrate_avg")
    Integer dMg;
    @cga("speed_min")
    Double dMh;
    @cga("speed_max")
    Double dMi;
    @cga("speed_avg")
    Double dMj;
    @cga("cadence_min")
    Integer dMk;
    @cga("cadence_max")
    Integer dMl;
    @cga("cadence_avg")
    Integer dMm;
    @cga("power_min")
    Double dMn;
    @cga("power_max")
    Double dMo;
    @cga("power_avg")
    Double dMp;
    @cga("torque_min")
    Double dMq;
    @cga("torque_max")
    Double dMr;
    @cga("torque_avg")
    Double dMs;
    @cga("willpower")
    Double dMt;
    @cga("distance_total")
    Double dMu;
    @cga("metabolic_energy_total")
    Double dMv;
    @cga("active_time_total")
    Double dMw;
    @cga("elapsed_time_total")
    Double dMx;
    @cga("steps_total")
    Integer dMy;

    static class C34571 implements Creator<emd> {
        C34571() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bz(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oY(i);
        }

        public emd bz(Parcel parcel) {
            return new emd(parcel);
        }

        public emd[] oY(int i) {
            return new emd[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dMe);
        parcel.writeValue(this.dMf);
        parcel.writeValue(this.dMg);
        parcel.writeValue(this.dMh);
        parcel.writeValue(this.dMi);
        parcel.writeValue(this.dMj);
        parcel.writeValue(this.dMk);
        parcel.writeValue(this.dMl);
        parcel.writeValue(this.dMm);
        parcel.writeValue(this.dMn);
        parcel.writeValue(this.dMo);
        parcel.writeValue(this.dMp);
        parcel.writeValue(this.dMq);
        parcel.writeValue(this.dMr);
        parcel.writeValue(this.dMs);
        parcel.writeValue(this.dMt);
        parcel.writeValue(this.dMu);
        parcel.writeValue(this.dMv);
        parcel.writeValue(this.dMw);
        parcel.writeValue(this.dMx);
        parcel.writeValue(this.dMy);
    }

    private emd(Parcel parcel) {
        this.dMe = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMf = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMg = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMh = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMi = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMj = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMk = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMl = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMm = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dMn = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMo = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMp = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMq = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMr = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMs = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMt = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMu = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMv = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMw = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMx = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dMy = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        emd com_fossil_emd = (emd) obj;
        if (this.dMw == null ? com_fossil_emd.dMw != null : !this.dMw.equals(com_fossil_emd.dMw)) {
            return false;
        }
        if (this.dMm == null ? com_fossil_emd.dMm != null : !this.dMm.equals(com_fossil_emd.dMm)) {
            return false;
        }
        if (this.dMl == null ? com_fossil_emd.dMl != null : !this.dMl.equals(com_fossil_emd.dMl)) {
            return false;
        }
        if (this.dMk == null ? com_fossil_emd.dMk != null : !this.dMk.equals(com_fossil_emd.dMk)) {
            return false;
        }
        if (this.dMu == null ? com_fossil_emd.dMu != null : !this.dMu.equals(com_fossil_emd.dMu)) {
            return false;
        }
        if (this.dMx == null ? com_fossil_emd.dMx != null : !this.dMx.equals(com_fossil_emd.dMx)) {
            return false;
        }
        if (this.dMg == null ? com_fossil_emd.dMg != null : !this.dMg.equals(com_fossil_emd.dMg)) {
            return false;
        }
        if (this.dMf == null ? com_fossil_emd.dMf != null : !this.dMf.equals(com_fossil_emd.dMf)) {
            return false;
        }
        if (this.dMe == null ? com_fossil_emd.dMe != null : !this.dMe.equals(com_fossil_emd.dMe)) {
            return false;
        }
        if (this.dMv == null ? com_fossil_emd.dMv != null : !this.dMv.equals(com_fossil_emd.dMv)) {
            return false;
        }
        if (this.dMp == null ? com_fossil_emd.dMp != null : !this.dMp.equals(com_fossil_emd.dMp)) {
            return false;
        }
        if (this.dMo == null ? com_fossil_emd.dMo != null : !this.dMo.equals(com_fossil_emd.dMo)) {
            return false;
        }
        if (this.dMn == null ? com_fossil_emd.dMn != null : !this.dMn.equals(com_fossil_emd.dMn)) {
            return false;
        }
        if (this.dMj == null ? com_fossil_emd.dMj != null : !this.dMj.equals(com_fossil_emd.dMj)) {
            return false;
        }
        if (this.dMi == null ? com_fossil_emd.dMi != null : !this.dMi.equals(com_fossil_emd.dMi)) {
            return false;
        }
        if (this.dMh == null ? com_fossil_emd.dMh != null : !this.dMh.equals(com_fossil_emd.dMh)) {
            return false;
        }
        if (this.dMy == null ? com_fossil_emd.dMy != null : !this.dMy.equals(com_fossil_emd.dMy)) {
            return false;
        }
        if (this.dMs == null ? com_fossil_emd.dMs != null : !this.dMs.equals(com_fossil_emd.dMs)) {
            return false;
        }
        if (this.dMr == null ? com_fossil_emd.dMr != null : !this.dMr.equals(com_fossil_emd.dMr)) {
            return false;
        }
        if (this.dMq == null ? com_fossil_emd.dMq != null : !this.dMq.equals(com_fossil_emd.dMq)) {
            return false;
        }
        if (this.dMt != null) {
            if (this.dMt.equals(com_fossil_emd.dMt)) {
                return true;
            }
        } else if (com_fossil_emd.dMt == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.dMe != null ? this.dMe.hashCode() : 0) * 31;
        if (this.dMf != null) {
            hashCode = this.dMf.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMg != null) {
            hashCode = this.dMg.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMh != null) {
            hashCode = this.dMh.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMi != null) {
            hashCode = this.dMi.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMj != null) {
            hashCode = this.dMj.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMk != null) {
            hashCode = this.dMk.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMl != null) {
            hashCode = this.dMl.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMm != null) {
            hashCode = this.dMm.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMn != null) {
            hashCode = this.dMn.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMo != null) {
            hashCode = this.dMo.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMp != null) {
            hashCode = this.dMp.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMq != null) {
            hashCode = this.dMq.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMr != null) {
            hashCode = this.dMr.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMs != null) {
            hashCode = this.dMs.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMt != null) {
            hashCode = this.dMt.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMu != null) {
            hashCode = this.dMu.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMv != null) {
            hashCode = this.dMv.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMw != null) {
            hashCode = this.dMw.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dMx != null) {
            hashCode = this.dMx.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.dMy != null) {
            i = this.dMy.hashCode();
        }
        return hashCode + i;
    }
}
