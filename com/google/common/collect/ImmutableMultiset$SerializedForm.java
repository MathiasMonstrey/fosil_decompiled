package com.google.common.collect;

import com.fossil.cdj;
import com.fossil.cdj.a;
import java.io.Serializable;

class ImmutableMultiset$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    final int[] counts;
    final Object[] elements;

    ImmutableMultiset$SerializedForm(cdj<?> com_fossil_cdj_) {
        int size = com_fossil_cdj_.entrySet().size();
        this.elements = new Object[size];
        this.counts = new int[size];
        int i = 0;
        for (a aVar : com_fossil_cdj_.entrySet()) {
            this.elements[i] = aVar.getElement();
            this.counts[i] = aVar.getCount();
            i++;
        }
    }

    Object readResolve() {
        ImmutableMultiset$a immutableMultiset$a = new ImmutableMultiset$a(this.elements.length);
        for (int i = 0; i < this.elements.length; i++) {
            immutableMultiset$a.m14336v(this.elements[i], this.counts[i]);
        }
        return immutableMultiset$a.UM();
    }
}
