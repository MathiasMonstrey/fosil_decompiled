package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;

public final class bzx extends aze<bzr> {
    private static final bzx bKh = new bzx();

    private bzx() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View m5856a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) azc.m4739a(((bzr) bKh.aB(context)).mo1584a(azc.bQ(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new bzq(context, i);
        }
    }

    protected final /* synthetic */ Object mo1206i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        return queryLocalInterface instanceof bzr ? (bzr) queryLocalInterface : new bzs(iBinder);
    }
}
