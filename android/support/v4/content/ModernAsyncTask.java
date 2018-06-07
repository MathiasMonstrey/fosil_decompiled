package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
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

public abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final ThreadFactory MS = new C11441();
    private static final BlockingQueue<Runnable> MT = new LinkedBlockingQueue(10);
    private static C1150b MU;
    private static volatile Executor MV = THREAD_POOL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, Allocation.USAGE_SHARED, 1, TimeUnit.SECONDS, MT, MS);
    private final C1145c<Params, Result> MW = new C11462(this);
    private final FutureTask<Result> MX = new FutureTask<Result>(this, this.MW) {
        final /* synthetic */ ModernAsyncTask Nc;

        protected void done() {
            try {
                this.Nc.m2015n(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.Nc.m2015n(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
            }
        }
    };
    private volatile Status MY = Status.PENDING;
    private final AtomicBoolean MZ = new AtomicBoolean();
    private final AtomicBoolean Na = new AtomicBoolean();

    static class C11441 implements ThreadFactory {
        private final AtomicInteger Nb = new AtomicInteger(1);

        C11441() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.Nb.getAndIncrement());
        }
    }

    static abstract class C1145c<Params, Result> implements Callable<Result> {
        Params[] Nh;

        C1145c() {
        }
    }

    class C11462 extends C1145c<Params, Result> {
        final /* synthetic */ ModernAsyncTask Nc;

        C11462(ModernAsyncTask modernAsyncTask) {
            this.Nc = modernAsyncTask;
        }

        public Result call() throws Exception {
            this.Nc.Na.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = this.Nc.doInBackground(this.Nh);
                Binder.flushPendingCommands();
                this.Nc.m2016o(obj);
                return obj;
            } catch (Throwable th) {
                this.Nc.m2016o(obj);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    static class C1149a<Data> {
        final ModernAsyncTask Ne;
        final Data[] Nf;

        C1149a(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.Ne = modernAsyncTask;
            this.Nf = dataArr;
        }
    }

    static class C1150b extends Handler {
        public C1150b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C1149a c1149a = (C1149a) message.obj;
            switch (message.what) {
                case 1:
                    c1149a.Ne.m2017p(c1149a.Nf[0]);
                    return;
                case 2:
                    c1149a.Ne.onProgressUpdate(c1149a.Nf);
                    return;
                default:
                    return;
            }
        }
    }

    protected abstract Result doInBackground(Params... paramsArr);

    private static Handler getHandler() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (MU == null) {
                MU = new C1150b();
            }
            handler = MU;
        }
        return handler;
    }

    void m2015n(Result result) {
        if (!this.Na.get()) {
            m2016o(result);
        }
    }

    Result m2016o(Result result) {
        getHandler().obtainMessage(1, new C1149a(this, result)).sendToTarget();
        return result;
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
        return this.MZ.get();
    }

    public final boolean cancel(boolean z) {
        this.MZ.set(true);
        return this.MX.cancel(z);
    }

    public final ModernAsyncTask<Params, Progress, Result> m2014a(Executor executor, Params... paramsArr) {
        if (this.MY != Status.PENDING) {
            switch (this.MY) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.MY = Status.RUNNING;
        onPreExecute();
        this.MW.Nh = paramsArr;
        executor.execute(this.MX);
        return this;
    }

    void m2017p(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.MY = Status.FINISHED;
    }
}
