package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehf extends eil implements ehe {
    public static final Creator<ehf> CREATOR = new C33941();
    @cga("brand")
    String brand;
    @cga("category")
    String category;
    @cga("color")
    String color;
    @cga("style_number")
    String dHe;
    @cga("product_url")
    String dHf;
    @cga("keywords")
    String dHg;
    @cga("age_group")
    String dHh;
    @cga("department")
    String dHi;
    @cga("available")
    Boolean dHj;
    @cga("price")
    String dHk;
    @cga("purchase_url")
    String dHl;
    @cga("mid_level_product_type")
    String dHm;
    @cga("photo_url")
    String dHn;
    @cga("detail_photo_url")
    String dHo;
    @cga("product_type")
    String dHp;
    @cga("upc")
    Long dHq;
    @cga("thumbnail_url")
    String dHr;
    @cga("styleid")
    String dHs;
    @cga("msrp")
    String dHt;
    @cga("description")
    String description;
    @cga("gender")
    String gender;
    @cga("model")
    String model;
    @cga("size")
    String size;
    @cga("sku")
    String sku;
    @cga("source")
    String source;

    static class C33941 implements Creator<ehf> {
        C33941() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aD(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nV(i);
        }

        public ehf aD(Parcel parcel) {
            return new ehf(parcel);
        }

        public ehf[] nV(int i) {
            return new ehf[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiv(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dHe);
        parcel.writeString(this.color);
        parcel.writeString(this.dHf);
        parcel.writeString(this.dHg);
        parcel.writeString(this.dHh);
        parcel.writeString(this.size);
        parcel.writeString(this.sku);
        parcel.writeString(this.source);
        parcel.writeString(this.dHi);
        parcel.writeString(this.brand);
        parcel.writeValue(this.dHj);
        parcel.writeString(this.category);
        parcel.writeString(this.description);
        parcel.writeString(this.dHk);
        parcel.writeString(this.dHl);
        parcel.writeString(this.dHm);
        parcel.writeString(this.dHn);
        parcel.writeString(this.dHo);
        parcel.writeString(this.dHp);
        parcel.writeString(this.gender);
        parcel.writeValue(this.dHq);
        parcel.writeString(this.dHr);
        parcel.writeString(this.dHs);
        parcel.writeString(this.model);
        parcel.writeString(this.dHt);
    }

    private ehf(Parcel parcel) {
        super(parcel);
        this.dHe = parcel.readString();
        this.color = parcel.readString();
        this.dHf = parcel.readString();
        this.dHg = parcel.readString();
        this.dHh = parcel.readString();
        this.size = parcel.readString();
        this.sku = parcel.readString();
        this.source = parcel.readString();
        this.dHi = parcel.readString();
        this.brand = parcel.readString();
        this.dHj = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.category = parcel.readString();
        this.description = parcel.readString();
        this.dHk = parcel.readString();
        this.dHl = parcel.readString();
        this.dHm = parcel.readString();
        this.dHn = parcel.readString();
        this.dHo = parcel.readString();
        this.dHp = parcel.readString();
        this.gender = parcel.readString();
        this.dHq = (Long) parcel.readValue(Long.class.getClassLoader());
        this.dHr = parcel.readString();
        this.dHs = parcel.readString();
        this.model = parcel.readString();
        this.dHt = parcel.readString();
    }
}
