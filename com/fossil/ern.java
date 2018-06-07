package com.fossil;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ern {
    public static final boolean dSl;
    public static final int dSm;
    static final AtomicReference<ScheduledExecutorService> dSn = new AtomicReference();
    static final Map<ScheduledThreadPoolExecutor, Object> dSo = new ConcurrentHashMap();

    static final class C3521a implements Runnable {
        C3521a() {
        }

        public void run() {
            try {
                Iterator it = new ArrayList(ern.dSo.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        ern.dSo.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                ers.onError(th);
            }
        }
    }

    static {
        boolean z;
        int i = 1;
        Properties properties = System.getProperties();
        if (properties.containsKey("rx2.purge-enabled")) {
            z = Boolean.getBoolean("rx2.purge-enabled");
        } else {
            z = true;
        }
        if (z && properties.containsKey("rx2.purge-period-seconds")) {
            i = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        dSl = z;
        dSm = i;
        start();
    }

    public static void start() {
        if (dSl) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) dSn.get();
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (dSn.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        newScheduledThreadPool.scheduleAtFixedRate(new C3521a(), (long) dSm, (long) dSm, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService m11095a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (dSl && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            dSo.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
