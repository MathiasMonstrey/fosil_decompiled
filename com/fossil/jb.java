package com.fossil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.fossil.iw.C3736a;

public class jb implements Parcelable {
    public static final Creator<jb> CREATOR = new C37411();
    final boolean Px = false;
    iw Py;
    final Handler mHandler = null;

    static class C37411 implements Creator<jb> {
        C37411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11862t(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return be(i);
        }

        public jb m11862t(Parcel parcel) {
            return new jb(parcel);
        }

        public jb[] be(int i) {
            return new jb[i];
        }
    }

    class C3742a extends C3736a {
        final /* synthetic */ jb Pz;

        C3742a(jb jbVar) {
            this.Pz = jbVar;
        }

        public void send(int i, Bundle bundle) {
            if (this.Pz.mHandler != null) {
                this.Pz.mHandler.post(new C3743b(this.Pz, i, bundle));
            } else {
                this.Pz.onReceiveResult(i, bundle);
            }
        }
    }

    class C3743b implements Runnable {
        final int PA;
        final Bundle PB;
        final /* synthetic */ jb Pz;

        C3743b(jb jbVar, int i, Bundle bundle) {
            this.Pz = jbVar;
            this.PA = i;
            this.PB = bundle;
        }

        public void run() {
            this.Pz.onReceiveResult(this.PA, this.PB);
        }
    }

    public void send(int i, Bundle bundle) {
        if (this.Px) {
            if (this.mHandler != null) {
                this.mHandler.post(new C3743b(this, i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else if (this.Py != null) {
            try {
                this.Py.send(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    protected void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.Py == null) {
                this.Py = new C3742a(this);
            }
            parcel.writeStrongBinder(this.Py.asBinder());
        }
    }

    jb(Parcel parcel) {
        this.Py = C3736a.m11853d(parcel.readStrongBinder());
    }
}
