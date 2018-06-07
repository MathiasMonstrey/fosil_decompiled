package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.fossil.arv.d;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.awa;
import com.fossil.bzb;
import com.fossil.wearables.fsl.goaltracking.GoalTracking;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class CameraPosition extends auq implements ReflectedParcelable {
    public static final Creator<CameraPosition> CREATOR = new bzb();
    public final LatLng bJg;
    public final float bJh;
    public final float bJi;
    public final float bJj;

    public static final class C4259a {
        private LatLng bJk;
        private float bJl;
        private float bJm;
        private float bJn;

        public final CameraPosition Tv() {
            return new CameraPosition(this.bJk, this.bJl, this.bJm, this.bJn);
        }

        public final C4259a ac(float f) {
            this.bJl = f;
            return this;
        }

        public final C4259a ad(float f) {
            this.bJm = f;
            return this;
        }

        public final C4259a ae(float f) {
            this.bJn = f;
            return this;
        }

        public final C4259a m14275b(LatLng latLng) {
            this.bJk = latLng;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        awa.p(latLng, "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        awa.b(z, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[]{Float.valueOf(f2)});
        this.bJg = latLng;
        this.bJh = f;
        this.bJi = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.bJj = f3 % 360.0f;
    }

    public static C4259a Tu() {
        return new C4259a();
    }

    public static CameraPosition m14276f(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(d.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(d.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(d.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(d.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        C4259a Tu = Tu();
        Tu.m14275b(latLng);
        if (obtainAttributes.hasValue(d.MapAttrs_cameraZoom)) {
            Tu.ac(obtainAttributes.getFloat(d.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_cameraBearing)) {
            Tu.ae(obtainAttributes.getFloat(d.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(d.MapAttrs_cameraTilt)) {
            Tu.ad(obtainAttributes.getFloat(d.MapAttrs_cameraTilt, 0.0f));
        }
        return Tu.Tv();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.bJg.equals(cameraPosition.bJg) && Float.floatToIntBits(this.bJh) == Float.floatToIntBits(cameraPosition.bJh) && Float.floatToIntBits(this.bJi) == Float.floatToIntBits(cameraPosition.bJi) && Float.floatToIntBits(this.bJj) == Float.floatToIntBits(cameraPosition.bJj);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bJg, Float.valueOf(this.bJh), Float.valueOf(this.bJi), Float.valueOf(this.bJj)});
    }

    public final String toString() {
        return avx.bN(this).b(GoalTracking.COLUMN_TARGET, this.bJg).b("zoom", Float.valueOf(this.bJh)).b("tilt", Float.valueOf(this.bJi)).b("bearing", Float.valueOf(this.bJj)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 2, this.bJg, i, false);
        aus.a(parcel, 3, this.bJh);
        aus.a(parcel, 4, this.bJi);
        aus.a(parcel, 5, this.bJj);
        aus.G(parcel, A);
    }
}
