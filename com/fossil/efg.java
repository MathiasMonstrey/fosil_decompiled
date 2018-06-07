package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class efg implements Parcelable, efd {
    public static Creator<efg> CREATOR = new C33661();
    @cga("recorder_type_key")
    String dDM;
    @cga("recorder_identifier")
    String dFC;
    @cga("time_series")
    C3368a dFJ;

    static class C33661 implements Creator<efg> {
        C33661() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ar(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nH(i);
        }

        public efg ar(Parcel parcel) {
            return new efg(parcel);
        }

        public efg[] nH(int i) {
            return new efg[i];
        }
    }

    public static class C3368a implements Parcelable {
        public static final Creator<C3368a> CREATOR = new C33671();
        long[] dFK;
        int[] dFL;
        long[] dFM;
        double[] dFN;
        long[] dFO;
        double[] dFP;

        static class C33671 implements Creator<C3368a> {
            C33671() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return as(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return nI(i);
            }

            public C3368a as(Parcel parcel) {
                return new C3368a(parcel);
            }

            public C3368a[] nI(int i) {
                return new C3368a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLongArray(this.dFK);
            parcel.writeIntArray(this.dFL);
            parcel.writeLongArray(this.dFM);
            parcel.writeDoubleArray(this.dFN);
            parcel.writeLongArray(this.dFO);
            parcel.writeDoubleArray(this.dFP);
        }

        public C3368a() {
            this.dFK = null;
            this.dFL = null;
            this.dFM = null;
            this.dFN = null;
            this.dFO = null;
            this.dFP = null;
        }

        private C3368a(Parcel parcel) {
            this.dFK = null;
            this.dFL = null;
            this.dFM = null;
            this.dFN = null;
            this.dFO = null;
            this.dFP = null;
            this.dFK = parcel.createLongArray();
            this.dFL = parcel.createIntArray();
            this.dFM = parcel.createLongArray();
            this.dFN = parcel.createDoubleArray();
            this.dFO = parcel.createLongArray();
            this.dFP = parcel.createDoubleArray();
        }
    }

    efg() {
    }

    efg(eff com_fossil_eff) {
        this.dDM = com_fossil_eff.dDM;
        this.dFC = com_fossil_eff.dFC;
        if (com_fossil_eff.dFH != null || com_fossil_eff.dFI != null || com_fossil_eff.dFF != null || com_fossil_eff.dFG != null || com_fossil_eff.dFD != null || com_fossil_eff.dFE != null) {
            this.dFJ = new C3368a();
            if (com_fossil_eff.dFD != null) {
                this.dFJ.dFK = com_fossil_eff.dFD.toArray();
                this.dFJ.dFL = com_fossil_eff.dFE.toArray();
            }
            if (com_fossil_eff.dFF != null) {
                this.dFJ.dFO = com_fossil_eff.dFF.toArray();
                this.dFJ.dFP = com_fossil_eff.dFG.toArray();
            }
            if (com_fossil_eff.dFH != null) {
                this.dFJ.dFM = com_fossil_eff.dFH.toArray();
                this.dFJ.dFN = com_fossil_eff.dFI.toArray();
            }
        }
    }

    public String aCM() {
        return this.dDM;
    }

    public String aCN() {
        return this.dFC;
    }

    public ecj aCy() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dDM);
        parcel.writeString(this.dFC);
        parcel.writeParcelable(this.dFJ, i);
    }

    efg(Parcel parcel) {
        this.dDM = parcel.readString();
        this.dFC = parcel.readString();
        this.dFJ = (C3368a) parcel.readParcelable(C3368a.class.getClassLoader());
    }
}
