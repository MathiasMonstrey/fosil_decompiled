package com.google.common.collect;

import com.fossil.cdt;

abstract class ImmutableSet$Indexed<E> extends ImmutableSet<E> {

    class C43031 extends ImmutableList<E> {
        C43031() {
        }

        public E get(int i) {
            return ImmutableSet$Indexed.this.get(i);
        }

        boolean isPartialView() {
            return ImmutableSet$Indexed.this.isPartialView();
        }

        public int size() {
            return ImmutableSet$Indexed.this.size();
        }
    }

    abstract E get(int i);

    ImmutableSet$Indexed() {
    }

    public cdt<E> iterator() {
        return asList().iterator();
    }

    ImmutableList<E> createAsList() {
        return new C43031();
    }
}
