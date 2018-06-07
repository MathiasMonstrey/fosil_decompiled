package com.fossil;

import com.fossil.cdj.C2007a;
import com.google.common.collect.Multisets.a;

public abstract class ccv<K> {
    transient int[] bMm;
    transient Object[] keys;
    transient int modCount;
    transient int size;

    class C2003a extends a<K> {
        int bMn;
        final /* synthetic */ ccv bMo;
        final K key;

        C2003a(ccv com_fossil_ccv, int i) {
            this.bMo = com_fossil_ccv;
            this.key = com_fossil_ccv.keys[i];
            this.bMn = i;
        }

        public K getElement() {
            return this.key;
        }

        void UC() {
            if (this.bMn == -1 || this.bMn >= this.bMo.size() || !ccn.equal(this.key, this.bMo.keys[this.bMn])) {
                this.bMn = this.bMo.indexOf(this.key);
            }
        }

        public int getCount() {
            UC();
            return this.bMn == -1 ? 0 : this.bMo.bMm[this.bMn];
        }
    }

    public abstract int get(Object obj);

    abstract int indexOf(Object obj);

    public abstract int mo1640u(K k, int i);

    ccv() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public K is(int i) {
        cco.bO(i, this.size);
        return this.keys[i];
    }

    public int getValue(int i) {
        cco.bO(i, this.size);
        return this.bMm[i];
    }

    public C2007a<K> getEntry(int i) {
        cco.bO(i, this.size);
        return new C2003a(this, i);
    }

    int UB() {
        return 0;
    }

    int it(int i) {
        return i + 1 < this.size ? i + 1 : -1;
    }
}
