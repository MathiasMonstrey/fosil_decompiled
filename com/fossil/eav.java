package com.fossil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class eav {
    ExecutorService dCQ;

    public eav() {
        this.dCQ = null;
        this.dCQ = Executors.newSingleThreadExecutor();
    }

    public void m10423a(Runnable runnable) {
        this.dCQ.execute(runnable);
    }
}
