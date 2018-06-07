package com.fossil;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class eig<T extends ecm> extends eil implements ecc<T> {
    @cga("total_count")
    Integer dEh;
    @cga("_embedded")
    Map<String, ArrayList<T>> dHW;
    private transient ArrayList<T> dHX;

    protected abstract String aDj();

    public /* synthetic */ ecj aCy() {
        return aDl();
    }

    public ArrayList<T> aDk() {
        if (this.dHX == null) {
            if (this.dHW == null) {
                this.dHW = new HashMap(1);
            }
            this.dHX = (ArrayList) this.dHW.get(aDj());
            if (this.dHX == null) {
                this.dHX = new ArrayList(0);
                this.dHW.put(aDj(), this.dHX);
            }
        }
        return this.dHX;
    }

    public void ok(int i) {
        this.dEh = Integer.valueOf(i);
    }

    public void m10758f(T t) {
        aDk().add(t);
    }

    public ecd<T> aDl() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiw(lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dEh);
        parcel.writeList(aDk());
    }

    protected eig(Parcel parcel) {
        super(parcel);
        this.dEh = (Integer) parcel.readValue(Long.class.getClassLoader());
        this.dHX = new ArrayList();
        parcel.readList(this.dHX, ecm.class.getClassLoader());
        this.dHW = new HashMap(1);
        this.dHW.put(aDj(), this.dHX);
    }
}
