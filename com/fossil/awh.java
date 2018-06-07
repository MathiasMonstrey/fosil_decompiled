package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.zzq;

public final class awh extends aze<avu> {
    private static final awh bhW = new awh();

    private awh() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m4642b(Context context, int i, int i2) throws zzq {
        return bhW.m4643c(context, i, i2);
    }

    private final View m4643c(Context context, int i, int i2) throws zzq {
        try {
            awf com_fossil_awf = new awf(i, i2, null);
            return (View) azc.m4739a(((avu) aB(context)).mo1205a(azc.bQ(context), com_fossil_awf));
        } catch (Throwable e) {
            throw new zzq("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public final /* synthetic */ Object mo1206i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof avu ? (avu) queryLocalInterface : new avv(iBinder);
    }
}
