package com.fossil;

public final class ju {

    public interface C3763a<T> {
        boolean mo3248e(T t);

        T ea();
    }

    public static class C3764b<T> implements C3763a<T> {
        private final Object[] qW;
        private int qX;

        public C3764b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.qW = new Object[i];
        }

        public T ea() {
            if (this.qX <= 0) {
                return null;
            }
            int i = this.qX - 1;
            T t = this.qW[i];
            this.qW[i] = null;
            this.qX--;
            return t;
        }

        public boolean mo3248e(T t) {
            if (ad(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.qX >= this.qW.length) {
                return false;
            } else {
                this.qW[this.qX] = t;
                this.qX++;
                return true;
            }
        }

        private boolean ad(T t) {
            for (int i = 0; i < this.qX; i++) {
                if (this.qW[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class C3765c<T> extends C3764b<T> {
        private final Object Am = new Object();

        public C3765c(int i) {
            super(i);
        }

        public T ea() {
            T ea;
            synchronized (this.Am) {
                ea = super.ea();
            }
            return ea;
        }

        public boolean mo3248e(T t) {
            boolean e;
            synchronized (this.Am) {
                e = super.mo3248e(t);
            }
            return e;
        }
    }
}
