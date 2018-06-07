package com.fossil;

import java.util.ArrayDeque;
import java.util.Deque;

public final class dvc {
    private int dvp = 64;
    private int dvq = 5;
    private final Deque<Object> dvr = new ArrayDeque();
    private final Deque<Object> dvs = new ArrayDeque();
    private final Deque<duv> dvt = new ArrayDeque();

    synchronized void m9837b(duv com_fossil_duv) {
        this.dvt.add(com_fossil_duv);
    }

    synchronized void m9838c(duv com_fossil_duv) {
        if (!this.dvt.remove(com_fossil_duv)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }
}
