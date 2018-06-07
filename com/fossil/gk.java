package com.fossil;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ModernAsyncTask;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class gk<D> extends gx<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile C3627a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile C3627a mTask;
    long mUpdateThrottle;

    final class C3627a extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch Mr = new CountDownLatch(1);
        boolean Ms;
        final /* synthetic */ gk Mt;

        C3627a(gk gkVar) {
            this.Mt = gkVar;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m11520a((Void[]) objArr);
        }

        protected D m11520a(Void... voidArr) {
            try {
                return this.Mt.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (isCancelled()) {
                    return null;
                }
                throw e;
            }
        }

        protected void onPostExecute(D d) {
            try {
                this.Mt.dispatchOnLoadComplete(this, d);
            } finally {
                this.Mr.countDown();
            }
        }

        protected void onCancelled(D d) {
            try {
                this.Mt.dispatchOnCancelled(this, d);
            } finally {
                this.Mr.countDown();
            }
        }

        public void run() {
            this.Ms = false;
            this.Mt.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.Mr.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public abstract D loadInBackground();

    public gk(Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private gk(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new C3627a(this);
        executePendingTask();
    }

    protected boolean onCancelLoad() {
        boolean z = false;
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.Ms) {
                    this.mTask.Ms = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.Ms) {
                this.mTask.Ms = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                z = this.mTask.cancel(false);
                if (z) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
            }
        }
        return z;
    }

    public void onCanceled(D d) {
    }

    void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.Ms) {
                this.mTask.Ms = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.m2014a(this.mExecutor, (Void[]) null);
                return;
            }
            this.mTask.Ms = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    void dispatchOnCancelled(C3627a c3627a, D d) {
        onCanceled(d);
        if (this.mCancellingTask == c3627a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(C3627a c3627a, D d) {
        if (this.mTask != c3627a) {
            dispatchOnCancelled(c3627a, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void cancelLoadInBackground() {
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        C3627a c3627a = this.mTask;
        if (c3627a != null) {
            c3627a.waitForLoader();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.Ms);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.Ms);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            jx.m11905a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            jx.m11904a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
