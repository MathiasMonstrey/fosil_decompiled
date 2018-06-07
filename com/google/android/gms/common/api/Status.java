package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.att;
import com.fossil.atz;
import com.fossil.auf;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class Status extends auq implements atz, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new auf();
    public static final Status bgA = new Status(16);
    private static Status bgB = new Status(17);
    private static Status bgC = new Status(18);
    public static final Status bgw = new Status(0);
    public static final Status bgx = new Status(14);
    public static final Status bgy = new Status(8);
    public static final Status bgz = new Status(15);
    private int ber;
    private final int bfI;
    private final PendingIntent bfJ;
    private final String bfK;

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.ber = i;
        this.bfI = i2;
        this.bfK = str;
        this.bfJ = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final String KL() {
        return this.bfK != null ? this.bfK : att.hp(this.bfI);
    }

    public final Status Ka() {
        return this;
    }

    public final boolean Kb() {
        return this.bfI <= 0;
    }

    public final boolean Ks() {
        return this.bfJ != null;
    }

    public final void m14206b(Activity activity, int i) throws SendIntentException {
        if (Ks()) {
            activity.startIntentSenderForResult(this.bfJ.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.ber == status.ber && this.bfI == status.bfI && avx.equal(this.bfK, status.bfK) && avx.equal(this.bfJ, status.bfJ);
    }

    public final int getStatusCode() {
        return this.bfI;
    }

    public final String getStatusMessage() {
        return this.bfK;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.ber), Integer.valueOf(this.bfI), this.bfK, this.bfJ});
    }

    public final String toString() {
        return avx.bN(this).b("statusCode", KL()).b("resolution", this.bfJ).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, getStatusCode());
        aus.a(parcel, 2, getStatusMessage(), false);
        aus.a(parcel, 3, this.bfJ, i, false);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
