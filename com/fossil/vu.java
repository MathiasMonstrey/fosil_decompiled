package com.fossil;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class vu {
    private final Map<ul, C4169a> aCJ = new HashMap();
    private final C4170b aCK = new C4170b();

    static class C4169a {
        final Lock aCL;
        int aCM;

        private C4169a() {
            this.aCL = new ReentrantLock();
        }
    }

    static class C4170b {
        private final Queue<C4169a> aCN;

        private C4170b() {
            this.aCN = new ArrayDeque();
        }

        C4169a vk() {
            synchronized (this.aCN) {
                C4169a c4169a = (C4169a) this.aCN.poll();
            }
            if (c4169a == null) {
                return new C4169a();
            }
            return c4169a;
        }

        void m13961a(C4169a c4169a) {
            synchronized (this.aCN) {
                if (this.aCN.size() < 10) {
                    this.aCN.offer(c4169a);
                }
            }
        }
    }

    vu() {
    }

    void m13962h(ul ulVar) {
        C4169a c4169a;
        synchronized (this) {
            c4169a = (C4169a) this.aCJ.get(ulVar);
            if (c4169a == null) {
                c4169a = this.aCK.vk();
                this.aCJ.put(ulVar, c4169a);
            }
            c4169a.aCM++;
        }
        c4169a.aCL.lock();
    }

    void m13963i(ul ulVar) {
        C4169a c4169a;
        synchronized (this) {
            c4169a = (C4169a) this.aCJ.get(ulVar);
            if (c4169a == null || c4169a.aCM <= 0) {
                int i;
                StringBuilder append = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(ulVar).append(", interestedThreads: ");
                if (c4169a == null) {
                    i = 0;
                } else {
                    i = c4169a.aCM;
                }
                throw new IllegalArgumentException(append.append(i).toString());
            }
            int i2 = c4169a.aCM - 1;
            c4169a.aCM = i2;
            if (i2 == 0) {
                C4169a c4169a2 = (C4169a) this.aCJ.remove(ulVar);
                if (c4169a2.equals(c4169a)) {
                    this.aCK.m13961a(c4169a2);
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c4169a + ", but actually removed: " + c4169a2 + ", key: " + ulVar);
                }
            }
        }
        c4169a.aCL.unlock();
    }
}
