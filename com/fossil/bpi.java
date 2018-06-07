package com.fossil;

import com.google.android.gms.internal.zzcgh;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class bpi<V> extends FutureTask<V> implements Comparable<bpi> {
    private final String bAW;
    private /* synthetic */ bpg bAX;
    private final long bAY = bpg.bAV.getAndIncrement();
    private final boolean bAZ;

    bpi(bpg com_fossil_bpg, Runnable runnable, boolean z, String str) {
        this.bAX = com_fossil_bpg;
        super(runnable, null);
        awa.bO(str);
        this.bAW = str;
        this.bAZ = false;
        if (this.bAY == ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD) {
            com_fossil_bpg.Pf().Rc().log("Tasks index overflow");
        }
    }

    bpi(bpg com_fossil_bpg, Callable<V> callable, boolean z, String str) {
        this.bAX = com_fossil_bpg;
        super(callable);
        awa.bO(str);
        this.bAW = str;
        this.bAZ = z;
        if (this.bAY == ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD) {
            com_fossil_bpg.Pf().Rc().log("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bpi com_fossil_bpi = (bpi) obj;
        if (this.bAZ != com_fossil_bpi.bAZ) {
            return this.bAZ ? -1 : 1;
        } else {
            if (this.bAY < com_fossil_bpi.bAY) {
                return -1;
            }
            if (this.bAY > com_fossil_bpi.bAY) {
                return 1;
            }
            this.bAX.Pf().Rd().m5439d("Two tasks share the same index. index", Long.valueOf(this.bAY));
            return 0;
        }
    }

    protected final void setException(Throwable th) {
        this.bAX.Pf().Rc().m5439d(this.bAW, th);
        if (th instanceof zzcgh) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
