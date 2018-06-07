package com.fossil;

import android.content.Context;

public final class lc {
    static final C3812c Ss;
    private Object Sr;

    interface C3812c {
        Object mo3299g(Context context, int i);
    }

    static class C3813b implements C3812c {
        C3813b() {
        }

        public Object mo3299g(Context context, int i) {
            return null;
        }
    }

    static class C3814a extends C3813b {
        C3814a() {
        }

        public Object mo3299g(Context context, int i) {
            return ld.m12068g(context, i);
        }
    }

    private lc(Object obj) {
        this.Sr = obj;
    }

    public Object jC() {
        return this.Sr;
    }

    static {
        if (it.ji()) {
            Ss = new C3814a();
        } else {
            Ss = new C3813b();
        }
    }

    public static lc m12067f(Context context, int i) {
        return new lc(Ss.mo3299g(context, i));
    }
}
