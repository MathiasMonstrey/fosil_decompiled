package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.fossil.car.C1979a;

public final class cbb extends auq {
    public static final Creator<cbb> CREATOR = new cbc();
    private cbd bKO;
    private int bKP;
    private int bKQ;
    private int type;

    public cbb(cbd com_fossil_cbd, int i, int i2, int i3) {
        this.bKO = com_fossil_cbd;
        this.type = i;
        this.bKP = i2;
        this.bKQ = i3;
    }

    public final void m5949a(C1979a c1979a) {
        switch (this.type) {
            case 1:
                c1979a.mo1602a(this.bKO);
                return;
            case 2:
                c1979a.mo1603a(this.bKO, this.bKP, this.bKQ);
                return;
            case 3:
                c1979a.mo1604b(this.bKO, this.bKP, this.bKQ);
                return;
            case 4:
                c1979a.mo1605c(this.bKO, this.bKP, this.bKQ);
                return;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
                return;
        }
    }

    public final String toString() {
        Object obj;
        String valueOf = String.valueOf(this.bKO);
        int i = this.type;
        switch (i) {
            case 1:
                obj = "CHANNEL_OPENED";
                break;
            case 2:
                obj = "CHANNEL_CLOSED";
                break;
            case 3:
                obj = "INPUT_CLOSED";
                break;
            case 4:
                obj = "OUTPUT_CLOSED";
                break;
            default:
                obj = Integer.toString(i);
                break;
        }
        String valueOf2 = String.valueOf(obj);
        i = this.bKP;
        switch (i) {
            case 0:
                obj = "CLOSE_REASON_NORMAL";
                break;
            case 1:
                obj = "CLOSE_REASON_DISCONNECTED";
                break;
            case 2:
                obj = "CLOSE_REASON_REMOTE_CLOSE";
                break;
            case 3:
                obj = "CLOSE_REASON_LOCAL_CLOSE";
                break;
            default:
                obj = Integer.toString(i);
                break;
        }
        String valueOf3 = String.valueOf(obj);
        return new StringBuilder(((String.valueOf(valueOf).length() + 81) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("ChannelEventParcelable[, channel=").append(valueOf).append(", type=").append(valueOf2).append(", closeReason=").append(valueOf3).append(", appErrorCode=").append(this.bKQ).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 2, this.bKO, i, false);
        aus.m4565c(parcel, 3, this.type);
        aus.m4565c(parcel, 4, this.bKP);
        aus.m4565c(parcel, 5, this.bKQ);
        aus.m4540G(parcel, A);
    }
}
