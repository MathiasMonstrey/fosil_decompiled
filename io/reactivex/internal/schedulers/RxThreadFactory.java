package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class C5095a extends Thread {
        C5095a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }

    public Thread newThread(Runnable runnable) {
        String stringBuilder = new StringBuilder(this.prefix).append('-').append(incrementAndGet()).toString();
        Thread c5095a = this.nonBlocking ? new C5095a(runnable, stringBuilder) : new Thread(runnable, stringBuilder);
        c5095a.setPriority(this.priority);
        c5095a.setDaemon(true);
        return c5095a;
    }

    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }
}
