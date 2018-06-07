package com.fossil;

import android.os.Handler;
import android.os.Looper;
import com.misfit.frameworks.common.constants.Constants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ciw {
    private final Executor cex;
    private final Executor cey;
    private final Executor cez;

    static final class C2091a implements Executor {
        private final Handler ceA = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            esl.m11128j(runnable, Constants.COMMAND);
            this.ceA.post(runnable);
        }
    }

    private ciw(Executor executor, Executor executor2, Executor executor3) {
        this.cex = executor;
        this.cey = executor2;
        this.cez = executor3;
    }

    public ciw() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        esl.m11127i(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        Executor executor = newSingleThreadExecutor;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        esl.m11127i(newFixedThreadPool, "Executors.newFixedThreadPool(3)");
        this(executor, newFixedThreadPool, new C2091a());
    }

    public Executor YQ() {
        return this.cex;
    }

    public Executor YR() {
        return this.cey;
    }

    public Executor YS() {
        return this.cez;
    }
}
