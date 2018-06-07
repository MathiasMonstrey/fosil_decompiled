package com.fossil;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class cdr<T> {
    private final T[] bOd;
    private T bOe;
    private int bufferSize;
    private final Comparator<? super T> comparator;
    private final int f1453k;

    public static <T> cdr<T> m6032a(int i, Comparator<? super T> comparator) {
        return new cdr(comparator, i);
    }

    private cdr(Comparator<? super T> comparator, int i) {
        boolean z;
        this.comparator = (Comparator) cco.m5996s(comparator, "comparator");
        this.f1453k = i;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        cco.m5985a(z, "k must be nonnegative, was %s", i);
        this.bOd = new Object[(i * 2)];
        this.bufferSize = 0;
        this.bOe = null;
    }

    public void cy(T t) {
        if (this.f1453k != 0) {
            if (this.bufferSize == 0) {
                this.bOd[0] = t;
                this.bOe = t;
                this.bufferSize = 1;
            } else if (this.bufferSize < this.f1453k) {
                r0 = this.bOd;
                r1 = this.bufferSize;
                this.bufferSize = r1 + 1;
                r0[r1] = t;
                if (this.comparator.compare(t, this.bOe) > 0) {
                    this.bOe = t;
                }
            } else if (this.comparator.compare(t, this.bOe) < 0) {
                r0 = this.bOd;
                r1 = this.bufferSize;
                this.bufferSize = r1 + 1;
                r0[r1] = t;
                if (this.bufferSize == this.f1453k * 2) {
                    trim();
                }
            }
        }
    }

    private void trim() {
        int i = 0;
        int i2 = (this.f1453k * 2) - 1;
        int a = cdv.m6034a(i2 - 0, RoundingMode.CEILING) * 3;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int E = m6031E(i4, i2, ((i4 + i2) + 1) >>> 1);
            if (E <= this.f1453k) {
                if (E >= this.f1453k) {
                    break;
                }
                i = Math.max(E, i4 + 1);
                int i5 = E;
                E = i2;
                i2 = i;
                i = i5;
            } else {
                E--;
                i2 = i4;
            }
            i4 = i3 + 1;
            if (i4 >= a) {
                Arrays.sort(this.bOd, i2, E, this.comparator);
                break;
            }
            i3 = i4;
            i4 = i2;
            i2 = E;
        }
        this.bufferSize = this.f1453k;
        this.bOe = this.bOd[i];
        for (i++; i < this.f1453k; i++) {
            if (this.comparator.compare(this.bOd[i], this.bOe) > 0) {
                this.bOe = this.bOd[i];
            }
        }
    }

    private int m6031E(int i, int i2, int i3) {
        Object obj = this.bOd[i3];
        this.bOd[i3] = this.bOd[i2];
        int i4 = i;
        while (i < i2) {
            if (this.comparator.compare(this.bOd[i], obj) < 0) {
                bR(i4, i);
                i4++;
            }
            i++;
        }
        this.bOd[i2] = this.bOd[i4];
        this.bOd[i4] = obj;
        return i4;
    }

    private void bR(int i, int i2) {
        Object obj = this.bOd[i];
        this.bOd[i] = this.bOd[i2];
        this.bOd[i2] = obj;
    }

    public void m6033o(Iterator<? extends T> it) {
        while (it.hasNext()) {
            cy(it.next());
        }
    }

    public List<T> VD() {
        Arrays.sort(this.bOd, 0, this.bufferSize, this.comparator);
        if (this.bufferSize > this.f1453k) {
            Arrays.fill(this.bOd, this.f1453k, this.bOd.length, null);
            this.bufferSize = this.f1453k;
            this.bOe = this.bOd[this.f1453k - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.bOd, this.bufferSize)));
    }
}
