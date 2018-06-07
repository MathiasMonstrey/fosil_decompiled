package com.fossil;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzq;

public abstract class aze<T> {
    private final String bjP;
    private T bjQ;

    protected aze(String str) {
        this.bjP = str;
    }

    protected final T aB(Context context) throws zzq {
        if (this.bjQ == null) {
            awa.bO(context);
            Context am = ayo.am(context);
            if (am == null) {
                throw new zzq("Could not get remote context.");
            }
            try {
                this.bjQ = mo1206i((IBinder) am.getClassLoader().loadClass(this.bjP).newInstance());
            } catch (Throwable e) {
                throw new zzq("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new zzq("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new zzq("Could not access creator.", e22);
            }
        }
        return this.bjQ;
    }

    protected abstract T mo1206i(IBinder iBinder);
}
