package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.fossil.arv.d;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.bya;
import com.fossil.bzl;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends auq implements ReflectedParcelable {
    public static final Creator<GoogleMapOptions> CREATOR = new bzl();
    private Float bIA = null;
    private Float bIB = null;
    private LatLngBounds bIC = null;
    private Boolean bIn;
    private Boolean bIo;
    private int bIp = -1;
    private CameraPosition bIq;
    private Boolean bIr;
    private Boolean bIs;
    private Boolean bIt;
    private Boolean bIu;
    private Boolean bIv;
    private Boolean bIw;
    private Boolean bIx;
    private Boolean bIy;
    private Boolean bIz;

    public GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds) {
        this.bIn = bya.f(b);
        this.bIo = bya.f(b2);
        this.bIp = i;
        this.bIq = cameraPosition;
        this.bIr = bya.f(b3);
        this.bIs = bya.f(b4);
        this.bIt = bya.f(b5);
        this.bIu = bya.f(b6);
        this.bIv = bya.f(b7);
        this.bIw = bya.f(b8);
        this.bIx = bya.f(b9);
        this.bIy = bya.f(b10);
        this.bIz = bya.f(b11);
        this.bIA = f;
        this.bIB = f2;
        this.bIC = latLngBounds;
    }

    public static GoogleMapOptions m14259e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(d.MapAttrs_mapType)) {
            googleMapOptions.iq(obtainAttributes.getInt(d.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_zOrderOnTop)) {
            googleMapOptions.bl(obtainAttributes.getBoolean(d.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_useViewLifecycle)) {
            googleMapOptions.bm(obtainAttributes.getBoolean(d.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiCompass)) {
            googleMapOptions.bo(obtainAttributes.getBoolean(d.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiRotateGestures)) {
            googleMapOptions.bs(obtainAttributes.getBoolean(d.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiScrollGestures)) {
            googleMapOptions.bp(obtainAttributes.getBoolean(d.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiTiltGestures)) {
            googleMapOptions.br(obtainAttributes.getBoolean(d.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiZoomGestures)) {
            googleMapOptions.bq(obtainAttributes.getBoolean(d.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiZoomControls)) {
            googleMapOptions.bn(obtainAttributes.getBoolean(d.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_liteMode)) {
            googleMapOptions.bt(obtainAttributes.getBoolean(d.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_uiMapToolbar)) {
            googleMapOptions.bu(obtainAttributes.getBoolean(d.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_ambientEnabled)) {
            googleMapOptions.bv(obtainAttributes.getBoolean(d.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.m14260Z(obtainAttributes.getFloat(d.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.aa(obtainAttributes.getFloat(d.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.m14262b(LatLngBounds.m14277g(context, attributeSet));
        googleMapOptions.m14261a(CameraPosition.m14276f(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public final int Tf() {
        return this.bIp;
    }

    public final CameraPosition Tg() {
        return this.bIq;
    }

    public final Float Th() {
        return this.bIA;
    }

    public final Float Ti() {
        return this.bIB;
    }

    public final LatLngBounds Tj() {
        return this.bIC;
    }

    public final GoogleMapOptions m14260Z(float f) {
        this.bIA = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions m14261a(CameraPosition cameraPosition) {
        this.bIq = cameraPosition;
        return this;
    }

    public final GoogleMapOptions aa(float f) {
        this.bIB = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions m14262b(LatLngBounds latLngBounds) {
        this.bIC = latLngBounds;
        return this;
    }

    public final GoogleMapOptions bl(boolean z) {
        this.bIn = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bm(boolean z) {
        this.bIo = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bn(boolean z) {
        this.bIr = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bo(boolean z) {
        this.bIs = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bp(boolean z) {
        this.bIt = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bq(boolean z) {
        this.bIu = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions br(boolean z) {
        this.bIv = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bs(boolean z) {
        this.bIw = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bt(boolean z) {
        this.bIx = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bu(boolean z) {
        this.bIy = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions bv(boolean z) {
        this.bIz = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions iq(int i) {
        this.bIp = i;
        return this;
    }

    public final String toString() {
        return avx.bN(this).b("MapType", Integer.valueOf(this.bIp)).b("LiteMode", this.bIx).b("Camera", this.bIq).b("CompassEnabled", this.bIs).b("ZoomControlsEnabled", this.bIr).b("ScrollGesturesEnabled", this.bIt).b("ZoomGesturesEnabled", this.bIu).b("TiltGesturesEnabled", this.bIv).b("RotateGesturesEnabled", this.bIw).b("MapToolbarEnabled", this.bIy).b("AmbientEnabled", this.bIz).b("MinZoomPreference", this.bIA).b("MaxZoomPreference", this.bIB).b("LatLngBoundsForCameraTarget", this.bIC).b("ZOrderOnTop", this.bIn).b("UseViewLifecycleInFragment", this.bIo).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 2, bya.b(this.bIn));
        aus.a(parcel, 3, bya.b(this.bIo));
        aus.c(parcel, 4, Tf());
        aus.a(parcel, 5, Tg(), i, false);
        aus.a(parcel, 6, bya.b(this.bIr));
        aus.a(parcel, 7, bya.b(this.bIs));
        aus.a(parcel, 8, bya.b(this.bIt));
        aus.a(parcel, 9, bya.b(this.bIu));
        aus.a(parcel, 10, bya.b(this.bIv));
        aus.a(parcel, 11, bya.b(this.bIw));
        aus.a(parcel, 12, bya.b(this.bIx));
        aus.a(parcel, 14, bya.b(this.bIy));
        aus.a(parcel, 15, bya.b(this.bIz));
        aus.a(parcel, 16, Th(), false);
        aus.a(parcel, 17, Ti(), false);
        aus.a(parcel, 18, Tj(), i, false);
        aus.G(parcel, A);
    }
}
