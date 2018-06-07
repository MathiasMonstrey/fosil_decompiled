package com.fossil;

import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;

public abstract class bdi {
    private int bfw;

    public bdi(int i) {
        this.bfw = i;
    }

    private static Status m4884a(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (VERSION.SDK_INT >= 15 && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void mo1269a(ben com_fossil_ben, boolean z);

    public abstract void mo1270a(bfu<?> com_fossil_bfu_) throws DeadObjectException;

    public abstract void mo1271h(Status status);
}
