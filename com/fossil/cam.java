package com.fossil;

import java.util.ArrayDeque;
import java.util.Queue;

final class cam<TResult> {
    private final Object Am = new Object();
    private Queue<cal<TResult>> bKv;
    private boolean bKw;

    cam() {
    }

    public final void m5870a(cal<TResult> com_fossil_cal_TResult) {
        synchronized (this.Am) {
            if (this.bKv == null) {
                this.bKv = new ArrayDeque();
            }
            this.bKv.add(com_fossil_cal_TResult);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m5871b(com.fossil.cag<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.Am;
        monitor-enter(r1);
        r0 = r2.bKv;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.bKw;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.bKw = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.Am;
        monitor-enter(r1);
        r0 = r2.bKv;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.fossil.cal) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.bKw = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.mo1587a(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cam.b(com.fossil.cag):void");
    }
}
