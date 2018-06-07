package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR = new C5085c();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(axh, cob, 1, TimeUnit.SECONDS, dOo, dOn);
    private static final int axg = Runtime.getRuntime().availableProcessors();
    private static final int axh = (axg + 1);
    private static final int cob = ((axg * 2) + 1);
    private static final ThreadFactory dOn = new C08901();
    private static final BlockingQueue<Runnable> dOo = new LinkedBlockingQueue(Allocation.USAGE_SHARED);
    private static final C5083b dOp = new C5083b();
    private static volatile Executor dOq = SERIAL_EXECUTOR;
    private final C5081d<Params, Result> dOr = new C08912(this);
    private final FutureTask<Result> dOs = new FutureTask<Result>(this, this.dOr) {
        final /* synthetic */ AsyncTask dOx;

        protected void done() {
            try {
                this.dOx.m16294n(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.dOx.m16294n(null);
            }
        }
    };
    private volatile Status dOt = Status.PENDING;
    private final AtomicBoolean dOu = new AtomicBoolean();
    private final AtomicBoolean dOv = new AtomicBoolean();

    static class C08901 implements ThreadFactory {
        private final AtomicInteger dOw = new AtomicInteger(1);

        C08901() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.dOw.getAndIncrement());
        }
    }

    static abstract class C5081d<Params, Result> implements Callable<Result> {
        Params[] dOF;

        private C5081d() {
        }
    }

    class C08912 extends C5081d<Params, Result> {
        final /* synthetic */ AsyncTask dOx;

        C08912(AsyncTask asyncTask) {
            this.dOx = asyncTask;
            super();
        }

        public Result call() throws Exception {
            this.dOx.dOv.set(true);
            Process.setThreadPriority(10);
            return this.dOx.m16295o(this.dOx.doInBackground(this.dOF));
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    static class C5082a<Data> {
        final Data[] dOA;
        final AsyncTask dOz;

        C5082a(AsyncTask asyncTask, Data... dataArr) {
            this.dOz = asyncTask;
            this.dOA = dataArr;
        }
    }

    static class C5083b extends Handler {
        public C5083b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C5082a c5082a = (C5082a) message.obj;
            switch (message.what) {
                case 1:
                    c5082a.dOz.m16296p(c5082a.dOA[0]);
                    return;
                case 2:
                    c5082a.dOz.onProgressUpdate(c5082a.dOA);
                    return;
                default:
                    return;
            }
        }
    }

    static class C5085c implements Executor {
        final LinkedList<Runnable> dOB;
        Runnable dOC;

        private C5085c() {
            this.dOB = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.dOB.offer(new Runnable(this) {
                final /* synthetic */ C5085c dOD;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.dOD.scheduleNext();
                    }
                }
            });
            if (this.dOC == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            Runnable runnable = (Runnable) this.dOB.poll();
            this.dOC = runnable;
            if (runnable != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.dOC);
            }
        }
    }

    protected abstract Result doInBackground(Params... paramsArr);

    private void m16294n(Result result) {
        if (!this.dOv.get()) {
            m16295o(result);
        }
    }

    private Result m16295o(Result result) {
        dOp.obtainMessage(1, new C5082a(this, result)).sendToTarget();
        return result;
    }

    public final Status aFH() {
        return this.dOt;
    }

    protected void onPreExecute() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.dOu.get();
    }

    public final boolean cancel(boolean z) {
        this.dOu.set(true);
        return this.dOs.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> m16297b(Executor executor, Params... paramsArr) {
        if (this.dOt != Status.PENDING) {
            switch (this.dOt) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.dOt = Status.RUNNING;
        onPreExecute();
        this.dOr.dOF = paramsArr;
        executor.execute(this.dOs);
        return this;
    }

    private void m16296p(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.dOt = Status.FINISHED;
    }
}
