package com.fossil;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

public final class eqk {
    private static final eqh dQY = eqj.m11055g(new C34971());

    static class C34971 implements Callable<eqh> {
        C34971() {
        }

        public /* synthetic */ Object call() throws Exception {
            return aGI();
        }

        public eqh aGI() throws Exception {
            return C3498a.dQZ;
        }
    }

    static final class C3498a {
        static final eqh dQZ = new eql(new Handler(Looper.getMainLooper()));
    }

    public static eqh aGH() {
        return eqj.m11054b(dQY);
    }
}
