package com.fossil;

import android.os.Handler;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2133c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class cke implements ckd {
    private static final ThreadFactory MS = new C21361();
    private static final BlockingQueue<Runnable> MT = new LinkedBlockingQueue(Integer.MAX_VALUE);
    private static final int axg = Runtime.getRuntime().availableProcessors();
    private static final int axh = Math.max(2, Math.min(axg - 1, 4));
    private static final int cob = ((axg * 2) + 1);
    private ThreadPoolExecutor coc = new ThreadPoolExecutor(axh, cob, 30, TimeUnit.SECONDS, MT, MS);
    private final Handler mHandler = new Handler();

    static class C21361 implements ThreadFactory {
        private final AtomicInteger Nb = new AtomicInteger(1);

        C21361() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.Nb.getAndIncrement());
        }
    }

    cke() {
        this.coc.allowCoreThreadTimeOut(true);
    }

    public void execute(Runnable runnable) {
        this.coc.execute(runnable);
    }

    public <P extends C2133c, E extends C2131a> void mo1876b(final E e, final C2126d<P, E> c2126d) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ cke cof;

            public void run() {
                if (c2126d != null) {
                    c2126d.onError(e);
                }
            }
        });
    }

    public <P extends C2133c, E extends C2131a> void mo1875a(final P p, final C2126d<P, E> c2126d) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ cke cof;

            public void run() {
                if (c2126d != null) {
                    c2126d.onSuccess(p);
                }
            }
        });
    }
}
