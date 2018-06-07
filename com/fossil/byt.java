package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.ayq.C1901a;
import com.google.android.gms.maps.model.LatLng;

public final class byt extends auq {
    public static final Creator<byt> CREATOR = new bze();
    private String bFX;
    private LatLng bIP;
    private float bJA = 0.0f;
    private float bJB;
    private String bJr;
    private byq bJs;
    private float bJt = 0.5f;
    private float bJu = 1.0f;
    private boolean bJv;
    private boolean bJw = true;
    private boolean bJx = false;
    private float bJy = 0.0f;
    private float bJz = 0.5f;
    private float mAlpha = 1.0f;

    byt(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.bIP = latLng;
        this.bFX = str;
        this.bJr = str2;
        if (iBinder == null) {
            this.bJs = null;
        } else {
            this.bJs = new byq(C1901a.m4703k(iBinder));
        }
        this.bJt = f;
        this.bJu = f2;
        this.bJv = z;
        this.bJw = z2;
        this.bJx = z3;
        this.bJy = f3;
        this.bJz = f4;
        this.bJA = f5;
        this.mAlpha = f6;
        this.bJB = f7;
    }

    public final boolean TA() {
        return this.bJx;
    }

    public final float TB() {
        return this.bJz;
    }

    public final float TC() {
        return this.bJA;
    }

    public final float TD() {
        return this.bJB;
    }

    public final LatLng Tl() {
        return this.bIP;
    }

    public final String Tw() {
        return this.bJr;
    }

    public final float Tx() {
        return this.bJt;
    }

    public final float Ty() {
        return this.bJu;
    }

    public final boolean Tz() {
        return this.bJv;
    }

    public final byt m5821a(byq com_fossil_byq) {
        this.bJs = com_fossil_byq;
        return this;
    }

    public final byt m5822c(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.bIP = latLng;
        return this;
    }

    public final byt eT(String str) {
        this.bJr = str;
        return this;
    }

    public final float getAlpha() {
        return this.mAlpha;
    }

    public final float getRotation() {
        return this.bJy;
    }

    public final String getTitle() {
        return this.bFX;
    }

    public final boolean isVisible() {
        return this.bJw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 2, Tl(), i, false);
        aus.m4554a(parcel, 3, getTitle(), false);
        aus.m4554a(parcel, 4, Tw(), false);
        aus.m4546a(parcel, 5, this.bJs == null ? null : this.bJs.Tc().asBinder(), false);
        aus.m4543a(parcel, 6, Tx());
        aus.m4543a(parcel, 7, Ty());
        aus.m4556a(parcel, 8, Tz());
        aus.m4556a(parcel, 9, isVisible());
        aus.m4556a(parcel, 10, TA());
        aus.m4543a(parcel, 11, getRotation());
        aus.m4543a(parcel, 12, TB());
        aus.m4543a(parcel, 13, TC());
        aus.m4543a(parcel, 14, getAlpha());
        aus.m4543a(parcel, 15, TD());
        aus.m4540G(parcel, A);
    }
}
