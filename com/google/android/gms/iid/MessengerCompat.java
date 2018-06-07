package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.fossil.bca;
import com.fossil.bcb;
import com.fossil.bcc;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new bcc();
    private Messenger bpT;
    private bca bpU;

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.bpT = new Messenger(iBinder);
            return;
        }
        bca com_fossil_bca;
        if (iBinder == null) {
            com_fossil_bca = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            com_fossil_bca = queryLocalInterface instanceof bca ? (bca) queryLocalInterface : new bcb(iBinder);
        }
        this.bpU = com_fossil_bca;
    }

    private final IBinder getBinder() {
        return this.bpT != null ? this.bpT.getBinder() : this.bpU.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) throws RemoteException {
        if (this.bpT != null) {
            this.bpT.send(message);
        } else {
            this.bpU.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.bpT != null) {
            parcel.writeStrongBinder(this.bpT.getBinder());
        } else {
            parcel.writeStrongBinder(this.bpU.asBinder());
        }
    }
}
