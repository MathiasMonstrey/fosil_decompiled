package com.fossil;

import android.os.Build.VERSION;
import android.support.v4.os.OperationCanceledException;

public final class iu {
    private boolean Ps;
    private C3734a Pt;
    private Object Pu;
    private boolean Pv;

    public interface C3734a {
        void onCancel();
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.Ps;
        }
        return z;
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.Ps;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = 1;
        r2.Ps = r0;	 Catch:{ all -> 0x0028 }
        r0 = 1;
        r2.Pv = r0;	 Catch:{ all -> 0x0028 }
        r0 = r2.Pt;	 Catch:{ all -> 0x0028 }
        r1 = r2.Pu;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0017;
    L_0x0014:
        r0.onCancel();	 Catch:{ all -> 0x002b }
    L_0x0017:
        if (r1 == 0) goto L_0x001c;
    L_0x0019:
        com.fossil.iv.aa(r1);	 Catch:{ all -> 0x002b }
    L_0x001c:
        monitor-enter(r2);
        r0 = 0;
        r2.Pv = r0;	 Catch:{ all -> 0x0025 }
        r2.notifyAll();	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        goto L_0x0006;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r0 = move-exception;
        monitor-enter(r2);
        r1 = 0;
        r2.Pv = r1;	 Catch:{ all -> 0x0035 }
        r2.notifyAll();	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.iu.cancel():void");
    }

    public Object jj() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.Pu == null) {
                this.Pu = iv.jk();
                if (this.Ps) {
                    iv.aa(this.Pu);
                }
            }
            obj = this.Pu;
        }
        return obj;
    }
}
