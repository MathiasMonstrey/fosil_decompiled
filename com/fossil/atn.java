package com.fossil;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class atn extends auq {
    public static final Creator<atn> CREATOR = new ayb();
    public static final atn bfH = new atn(0);
    private int ber;
    private final int bfI;
    private final PendingIntent bfJ;
    private final String bfK;

    public atn(int i) {
        this(i, null, null);
    }

    atn(int i, int i2, PendingIntent pendingIntent, String str) {
        this.ber = i;
        this.bfI = i2;
        this.bfJ = pendingIntent;
        this.bfK = str;
    }

    public atn(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public atn(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String hm(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public final boolean Kb() {
        return this.bfI == 0;
    }

    public final boolean Ks() {
        return (this.bfI == 0 || this.bfJ == null) ? false : true;
    }

    public final PendingIntent Kt() {
        return this.bfJ;
    }

    public final void m4433b(Activity activity, int i) throws SendIntentException {
        if (Ks()) {
            activity.startIntentSenderForResult(this.bfJ.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof atn)) {
            return false;
        }
        atn com_fossil_atn = (atn) obj;
        return this.bfI == com_fossil_atn.bfI && avx.equal(this.bfJ, com_fossil_atn.bfJ) && avx.equal(this.bfK, com_fossil_atn.bfK);
    }

    public final int getErrorCode() {
        return this.bfI;
    }

    public final String getErrorMessage() {
        return this.bfK;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.bfI), this.bfJ, this.bfK});
    }

    public final String toString() {
        return avx.bN(this).m4608b("statusCode", hm(this.bfI)).m4608b("resolution", this.bfJ).m4608b("message", this.bfK).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4565c(parcel, 2, getErrorCode());
        aus.m4548a(parcel, 3, Kt(), i, false);
        aus.m4554a(parcel, 4, getErrorMessage(), false);
        aus.m4540G(parcel, A);
    }
}
