package com.fossil;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class ti {
    private static final ti axn = new ti();
    private final ExecutorService axo;
    private final ScheduledExecutorService axp;
    private final Executor axq;

    static class C4110a implements Executor {
        private ThreadLocal<Integer> axr;

        private C4110a() {
            this.axr = new ThreadLocal();
        }

        private int sZ() {
            Integer num = (Integer) this.axr.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.axr.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int ta() {
            Integer num = (Integer) this.axr.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.axr.remove();
            } else {
                this.axr.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (sZ() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    ta();
                }
            } else {
                ti.sX().execute(runnable);
            }
            ta();
        }
    }

    private static boolean sW() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private ti() {
        this.axo = !sW() ? Executors.newCachedThreadPool() : tf.newCachedThreadPool();
        this.axp = Executors.newSingleThreadScheduledExecutor();
        this.axq = new C4110a();
    }

    public static ExecutorService sX() {
        return axn.axo;
    }

    static Executor sY() {
        return axn.axq;
    }
}
