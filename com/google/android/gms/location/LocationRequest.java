package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.bxe;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.util.Arrays;

public final class LocationRequest extends auq implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR = new bxe();
    private int Ll;
    private long bGA;
    private long bGu;
    private long bGv;
    private boolean bGw;
    private long bGx;
    private int bGy;
    private float bGz;

    public LocationRequest() {
        this.Ll = 102;
        this.bGu = 3600000;
        this.bGv = 600000;
        this.bGw = false;
        this.bGx = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        this.bGy = Integer.MAX_VALUE;
        this.bGz = 0.0f;
        this.bGA = 0;
    }

    public LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.Ll = i;
        this.bGu = j;
        this.bGv = j2;
        this.bGw = z;
        this.bGx = j3;
        this.bGy = i2;
        this.bGz = f;
        this.bGA = j4;
    }

    private static void at(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public final long SJ() {
        long j = this.bGA;
        return j < this.bGu ? this.bGu : j;
    }

    public final LocationRequest m14249V(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
        this.bGz = f;
        return this;
    }

    public final LocationRequest ar(long j) {
        at(j);
        this.bGu = j;
        if (!this.bGw) {
            this.bGv = (long) (((double) this.bGu) / 6.0d);
        }
        return this;
    }

    public final LocationRequest as(long j) {
        at(j);
        this.bGw = true;
        this.bGv = j;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.Ll == locationRequest.Ll && this.bGu == locationRequest.bGu && this.bGv == locationRequest.bGv && this.bGw == locationRequest.bGw && this.bGx == locationRequest.bGx && this.bGy == locationRequest.bGy && this.bGz == locationRequest.bGz && SJ() == locationRequest.SJ();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Ll), Long.valueOf(this.bGu), Float.valueOf(this.bGz), Long.valueOf(this.bGA)});
    }

    public final LocationRequest ik(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                this.Ll = i;
                return this;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Request[");
        switch (this.Ll) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
            default:
                str = "???";
                break;
        }
        append.append(str);
        if (this.Ll != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.bGu).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.bGv).append("ms");
        if (this.bGA > this.bGu) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.bGA).append("ms");
        }
        if (this.bGz > 0.0f) {
            stringBuilder.append(" smallestDisplacement=");
            stringBuilder.append(this.bGz).append("m");
        }
        if (this.bGx != ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD) {
            long elapsedRealtime = this.bGx - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.bGy != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.bGy);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.Ll);
        aus.a(parcel, 2, this.bGu);
        aus.a(parcel, 3, this.bGv);
        aus.a(parcel, 4, this.bGw);
        aus.a(parcel, 5, this.bGx);
        aus.c(parcel, 6, this.bGy);
        aus.a(parcel, 7, this.bGz);
        aus.a(parcel, 8, this.bGA);
        aus.G(parcel, A);
    }
}
