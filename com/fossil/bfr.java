package com.fossil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class bfr {
    private static final ExecutorService btK = Executors.newFixedThreadPool(2, new bja("GAC_Executor"));

    public static ExecutorService NP() {
        return btK;
    }
}
