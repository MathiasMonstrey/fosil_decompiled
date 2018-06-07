package com.fossil;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public final class auu extends avh {
    private int bgZ;

    public static Account m4570a(avg com_fossil_avg) {
        Account account = null;
        if (com_fossil_avg != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = com_fossil_avg.KQ();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final Account KQ() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.bgZ) {
            if (ayo.m4452B(null, callingUid)) {
                this.bgZ = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        Account account = null;
        return this == obj ? true : !(obj instanceof auu) ? false : account.equals(account);
    }
}
