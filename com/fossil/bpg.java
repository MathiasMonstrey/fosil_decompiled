package com.fossil;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class bpg extends bqi {
    private static final AtomicLong bAV = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService bAL;
    private bpj bAM;
    private bpj bAN;
    private final PriorityBlockingQueue<FutureTask<?>> bAO = new PriorityBlockingQueue();
    private final BlockingQueue<FutureTask<?>> bAP = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler bAQ = new bph(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler bAR = new bph(this, "Thread death: Uncaught exception on network thread");
    private final Object bAS = new Object();
    private final Semaphore bAT = new Semaphore(2);
    private volatile boolean bAU;

    bpg(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    public static boolean LM() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private final void m5461a(bpi<?> com_fossil_bpi_) {
        synchronized (this.bAS) {
            this.bAO.add(com_fossil_bpi_);
            if (this.bAM == null) {
                this.bAM = new bpj(this, "Measurement Worker", this.bAO);
                this.bAM.setUncaughtExceptionHandler(this.bAQ);
                this.bAM.start();
            } else {
                this.bAM.Rz();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final void OO() {
        if (Thread.currentThread() != this.bAN) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void OP() {
        if (Thread.currentThread() != this.bAM) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final boolean Rw() {
        return Thread.currentThread() == this.bAM;
    }

    final ExecutorService Rx() {
        ExecutorService executorService;
        synchronized (this.bAS) {
            if (this.bAL == null) {
                this.bAL = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.bAL;
        }
        return executorService;
    }

    public final <V> Future<V> m5467d(Callable<V> callable) throws IllegalStateException {
        RA();
        awa.bO(callable);
        bpi com_fossil_bpi = new bpi(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.bAM) {
            if (!this.bAO.isEmpty()) {
                super.Pf().Re().log("Callable skipped the worker queue.");
            }
            com_fossil_bpi.run();
        } else {
            m5461a(com_fossil_bpi);
        }
        return com_fossil_bpi;
    }

    public final <V> Future<V> m5468e(Callable<V> callable) throws IllegalStateException {
        RA();
        awa.bO(callable);
        bpi com_fossil_bpi = new bpi(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.bAM) {
            com_fossil_bpi.run();
        } else {
            m5461a(com_fossil_bpi);
        }
        return com_fossil_bpi;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void m5469h(Runnable runnable) throws IllegalStateException {
        RA();
        awa.bO(runnable);
        m5461a(new bpi(this, runnable, false, "Task exception on worker thread"));
    }

    public final void m5470i(Runnable runnable) throws IllegalStateException {
        RA();
        awa.bO(runnable);
        bpi com_fossil_bpi = new bpi(this, runnable, false, "Task exception on network thread");
        synchronized (this.bAS) {
            this.bAP.add(com_fossil_bpi);
            if (this.bAN == null) {
                this.bAN = new bpj(this, "Measurement Network", this.bAP);
                this.bAN.setUncaughtExceptionHandler(this.bAR);
                this.bAN.start();
            } else {
                this.bAN.Rz();
            }
        }
    }
}
