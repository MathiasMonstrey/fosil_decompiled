package com.google.common.collect;

import com.fossil.cdj.a;
import com.fossil.cdl;
import com.google.common.primitives.Ints;

class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset(cdl.VA());
    private final transient cdl<E> bNZ;
    private transient ImmutableSet<E> bOa;
    private final transient int size;

    final class ElementSet extends ImmutableSet$Indexed<E> {
        private ElementSet() {
        }

        E get(int i) {
            return RegularImmutableMultiset.this.bNZ.is(i);
        }

        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        boolean isPartialView() {
            return true;
        }

        public int size() {
            return RegularImmutableMultiset.this.bNZ.size();
        }
    }

    RegularImmutableMultiset(cdl<E> com_fossil_cdl_E) {
        this.bNZ = com_fossil_cdl_E;
        long j = 0;
        for (int i = 0; i < com_fossil_cdl_E.size(); i++) {
            j += (long) com_fossil_cdl_E.getValue(i);
        }
        this.size = Ints.aw(j);
    }

    boolean isPartialView() {
        return false;
    }

    public int count(Object obj) {
        return this.bNZ.get(obj);
    }

    public int size() {
        return this.size;
    }

    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.bOa;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new ElementSet();
        this.bOa = immutableSet;
        return immutableSet;
    }

    a<E> getEntry(int i) {
        return this.bNZ.getEntry(i);
    }
}
