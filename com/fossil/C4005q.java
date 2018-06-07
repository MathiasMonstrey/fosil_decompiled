package com.fossil;

final class C4005q {

    interface C4003a<T> {
        void mo4015a(T[] tArr, int i);

        boolean mo4016e(T t);

        T ea();
    }

    static class C4004b<T> implements C4003a<T> {
        private final Object[] qW;
        private int qX;

        C4004b(int i) {
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

        public boolean mo4016e(T t) {
            if (this.qX >= this.qW.length) {
                return false;
            }
            this.qW[this.qX] = t;
            this.qX++;
            return true;
        }

        public void mo4015a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.qX < this.qW.length) {
                    this.qW[this.qX] = t;
                    this.qX++;
                }
            }
        }
    }
}
