package com.fossil;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class erh<T> implements erd<T> {
    private static final Object dRH = new Object();
    static final int dRy = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    int dRA;
    long dRB;
    final int dRC;
    AtomicReferenceArray<Object> dRD;
    final int dRE;
    AtomicReferenceArray<Object> dRF;
    final AtomicLong dRG = new AtomicLong();
    final AtomicLong dRz = new AtomicLong();

    public erh(int i) {
        int pp = err.pp(Math.max(8, i));
        int i2 = pp - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(pp + 1);
        this.dRD = atomicReferenceArray;
        this.dRC = i2;
        pm(pp);
        this.dRF = atomicReferenceArray;
        this.dRE = i2;
        this.dRB = (long) (i2 - 1);
        aX(0);
    }

    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.dRD;
        long aGM = aGM();
        int i = this.dRC;
        int e = m11083e(aGM, i);
        if (aGM < this.dRB) {
            return m11081a(atomicReferenceArray, t, aGM, e);
        }
        int i2 = this.dRA;
        if (m11082b(atomicReferenceArray, m11083e(((long) i2) + aGM, i)) == null) {
            this.dRB = (((long) i2) + aGM) - 1;
            return m11081a(atomicReferenceArray, t, aGM, e);
        } else if (m11082b(atomicReferenceArray, m11083e(1 + aGM, i)) == null) {
            return m11081a(atomicReferenceArray, t, aGM, e);
        } else {
            m11079a(atomicReferenceArray, aGM, e, t, (long) i);
            return true;
        }
    }

    private boolean m11081a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m11078a((AtomicReferenceArray) atomicReferenceArray, i, (Object) t);
        aX(1 + j);
        return true;
    }

    private void m11079a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.dRD = atomicReferenceArray2;
        this.dRB = (j + j2) - 1;
        m11078a(atomicReferenceArray2, i, (Object) t);
        m11080a((AtomicReferenceArray) atomicReferenceArray, atomicReferenceArray2);
        m11078a((AtomicReferenceArray) atomicReferenceArray, i, dRH);
        aX(j + 1);
    }

    private void m11080a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m11078a((AtomicReferenceArray) atomicReferenceArray, pn(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> m11077a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int pn = pn(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m11082b(atomicReferenceArray, pn);
        m11078a((AtomicReferenceArray) atomicReferenceArray, pn, null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray atomicReferenceArray = this.dRF;
        long aGN = aGN();
        int i = this.dRE;
        int e = m11083e(aGN, i);
        T b = m11082b(atomicReferenceArray, e);
        Object obj = b == dRH ? 1 : null;
        if (b == null || obj != null) {
            return obj != null ? m11076a(m11077a(atomicReferenceArray, i + 1), aGN, i) : null;
        } else {
            m11078a(atomicReferenceArray, e, null);
            aY(1 + aGN);
            return b;
        }
    }

    private T m11076a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.dRF = atomicReferenceArray;
        int e = m11083e(j, i);
        T b = m11082b(atomicReferenceArray, e);
        if (b != null) {
            m11078a((AtomicReferenceArray) atomicReferenceArray, e, null);
            aY(1 + j);
        }
        return b;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return aGK() == aGL();
    }

    private void pm(int i) {
        this.dRA = Math.min(i / 4, dRy);
    }

    private long aGK() {
        return this.dRz.get();
    }

    private long aGL() {
        return this.dRG.get();
    }

    private long aGM() {
        return this.dRz.get();
    }

    private long aGN() {
        return this.dRG.get();
    }

    private void aX(long j) {
        this.dRz.lazySet(j);
    }

    private void aY(long j) {
        this.dRG.lazySet(j);
    }

    private static int m11083e(long j, int i) {
        return pn(((int) j) & i);
    }

    private static int pn(int i) {
        return i;
    }

    private static void m11078a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object m11082b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
