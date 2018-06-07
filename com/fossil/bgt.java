package com.fossil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bgt {
    private static final ExecutorService btK = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new bja("GAC_Transform"));

    public static ExecutorService NP() {
        return btK;
    }
}
