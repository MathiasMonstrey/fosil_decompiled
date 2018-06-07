package com.fossil;

public final class emh<T> implements eru<T> {
    static final /* synthetic */ boolean $assertionsDisabled = (!emh.class.desiredAssertionStatus());
    private static final Object dMJ = new Object();
    private volatile eru<T> dMK;
    private volatile Object dML = dMJ;

    private emh(eru<T> com_fossil_eru_T) {
        if ($assertionsDisabled || com_fossil_eru_T != null) {
            this.dMK = com_fossil_eru_T;
            return;
        }
        throw new AssertionError();
    }

    public T get() {
        T t = this.dML;
        if (t == dMJ) {
            synchronized (this) {
                t = this.dML;
                if (t == dMJ) {
                    t = this.dMK.get();
                    T t2 = this.dML;
                    if (t2 == dMJ || t2 == t) {
                        this.dML = t;
                        this.dMK = null;
                    } else {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + t2 + " & " + t + ". This is likely due to a circular dependency.");
                    }
                }
            }
        }
        return t;
    }

    public static <T> eru<T> m10872a(eru<T> com_fossil_eru_T) {
        emj.ce(com_fossil_eru_T);
        return com_fossil_eru_T instanceof emh ? com_fossil_eru_T : new emh(com_fossil_eru_T);
    }
}
