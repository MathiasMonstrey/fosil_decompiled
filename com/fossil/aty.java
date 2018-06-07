package com.fossil;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;

public abstract class aty<R extends atz> extends aub<R> {
    private final Activity IX;
    private final int bgu;

    protected aty(Activity activity, int i) {
        this.IX = (Activity) awa.m4640p(activity, "Activity must not be null");
        this.bgu = i;
    }

    public final void mo1185e(Status status) {
        if (status.Ks()) {
            try {
                status.b(this.IX, this.bgu);
                return;
            } catch (Throwable e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                mo2341f(new Status(8));
                return;
            }
        }
        mo2341f(status);
    }

    public abstract void mo2341f(Status status);
}
