package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;

public final class erl extends eqh {
    private static final RxThreadFactory dRJ = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory dOn;

    public erl() {
        this(dRJ);
    }

    public erl(ThreadFactory threadFactory) {
        this.dOn = threadFactory;
    }

    public C3496b aGG() {
        return new erm(this.dOn);
    }
}
