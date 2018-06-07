package com.fossil;

import android.util.Log;
import com.google.android.gms.common.api.Status;

public abstract class aub<R extends atz> implements aua<R> {
    public final void mo1184a(R r) {
        Status Ka = r.Ka();
        if (Ka.Kb()) {
            mo2340b(r);
            return;
        }
        mo1185e(Ka);
        if (r instanceof atx) {
            try {
                ((atx) r).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(r);
                Log.w("ResultCallbacks", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public abstract void mo2340b(R r);

    public abstract void mo1185e(Status status);
}
