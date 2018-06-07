package com.google.common.collect;

import com.fossil.cdm;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

class Ordering$a extends Ordering<Object> {
    private final ConcurrentMap<Object, Integer> bNU = cdm.a(new MapMaker()).Vb();
    private final AtomicInteger counter = new AtomicInteger(0);

    Ordering$a() {
    }

    private Integer cw(Object obj) {
        Integer num = (Integer) this.bNU.get(obj);
        if (num != null) {
            return num;
        }
        Integer valueOf = Integer.valueOf(this.counter.getAndIncrement());
        num = (Integer) this.bNU.putIfAbsent(obj, valueOf);
        return num != null ? num : valueOf;
    }

    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        int identityHashCode = identityHashCode(obj);
        int identityHashCode2 = identityHashCode(obj2);
        if (identityHashCode == identityHashCode2) {
            int compareTo = cw(obj).compareTo(cw(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        } else if (identityHashCode >= identityHashCode2) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Ordering.arbitrary()";
    }

    int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }
}
