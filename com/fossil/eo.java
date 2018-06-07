package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.en.C3467a;
import java.util.ArrayList;

final class eo implements Parcelable {
    public static final Creator<eo> CREATOR = new C34841();
    final int Ib;
    final int Ic;
    final int Ig;
    final CharSequence Ih;
    final int Ii;
    final CharSequence Ij;
    final ArrayList<String> Ik;
    final ArrayList<String> Il;
    final boolean Im;
    final int[] Is;
    final int mIndex;
    final String mName;

    static class C34841 implements Creator<eo> {
        C34841() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10982e(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aD(i);
        }

        public eo m10982e(Parcel parcel) {
            return new eo(parcel);
        }

        public eo[] aD(int i) {
            return new eo[i];
        }
    }

    public eo(en enVar) {
        int size = enVar.HW.size();
        this.Is = new int[(size * 6)];
        if (enVar.Id) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C3467a c3467a = (C3467a) enVar.HW.get(i2);
                int i3 = i + 1;
                this.Is[i] = c3467a.In;
                int i4 = i3 + 1;
                this.Is[i3] = c3467a.fragment != null ? c3467a.fragment.mIndex : -1;
                int i5 = i4 + 1;
                this.Is[i4] = c3467a.Io;
                i3 = i5 + 1;
                this.Is[i5] = c3467a.Ip;
                i5 = i3 + 1;
                this.Is[i3] = c3467a.Iq;
                i = i5 + 1;
                this.Is[i5] = c3467a.Ir;
            }
            this.Ib = enVar.Ib;
            this.Ic = enVar.Ic;
            this.mName = enVar.mName;
            this.mIndex = enVar.mIndex;
            this.Ig = enVar.Ig;
            this.Ih = enVar.Ih;
            this.Ii = enVar.Ii;
            this.Ij = enVar.Ij;
            this.Ik = enVar.Ik;
            this.Il = enVar.Il;
            this.Im = enVar.Im;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public eo(Parcel parcel) {
        this.Is = parcel.createIntArray();
        this.Ib = parcel.readInt();
        this.Ic = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.Ig = parcel.readInt();
        this.Ih = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Ii = parcel.readInt();
        this.Ij = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Ik = parcel.createStringArrayList();
        this.Il = parcel.createStringArrayList();
        this.Im = parcel.readInt() != 0;
    }

    public en m10983a(fb fbVar) {
        int i = 0;
        en enVar = new en(fbVar);
        int i2 = 0;
        while (i < this.Is.length) {
            C3467a c3467a = new C3467a();
            int i3 = i + 1;
            c3467a.In = this.Is[i];
            if (fb.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + enVar + " op #" + i2 + " base fragment #" + this.Is[i3]);
            }
            int i4 = i3 + 1;
            i = this.Is[i3];
            if (i >= 0) {
                c3467a.fragment = (Fragment) fbVar.Jg.get(i);
            } else {
                c3467a.fragment = null;
            }
            i3 = i4 + 1;
            c3467a.Io = this.Is[i4];
            i4 = i3 + 1;
            c3467a.Ip = this.Is[i3];
            i3 = i4 + 1;
            c3467a.Iq = this.Is[i4];
            i4 = i3 + 1;
            c3467a.Ir = this.Is[i3];
            enVar.HX = c3467a.Io;
            enVar.HY = c3467a.Ip;
            enVar.HZ = c3467a.Iq;
            enVar.Ia = c3467a.Ir;
            enVar.m10943a(c3467a);
            i2++;
            i = i4;
        }
        enVar.Ib = this.Ib;
        enVar.Ic = this.Ic;
        enVar.mName = this.mName;
        enVar.mIndex = this.mIndex;
        enVar.Id = true;
        enVar.Ig = this.Ig;
        enVar.Ih = this.Ih;
        enVar.Ii = this.Ii;
        enVar.Ij = this.Ij;
        enVar.Ik = this.Ik;
        enVar.Il = this.Il;
        enVar.Im = this.Im;
        enVar.aB(1);
        return enVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.Is);
        parcel.writeInt(this.Ib);
        parcel.writeInt(this.Ic);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.Ig);
        TextUtils.writeToParcel(this.Ih, parcel, 0);
        parcel.writeInt(this.Ii);
        TextUtils.writeToParcel(this.Ij, parcel, 0);
        parcel.writeStringList(this.Ik);
        parcel.writeStringList(this.Il);
        if (this.Im) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
