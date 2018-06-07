package com.fossil;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class avi extends buj implements avg {
    avi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account KQ() throws RemoteException {
        Parcel a = m4420a(2, SH());
        Account account = (Account) bul.m5685a(a, Account.CREATOR);
        a.recycle();
        return account;
    }
}
