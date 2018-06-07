package com.google.common.collect;

import com.fossil.cdt;
import java.util.Map.Entry;

class ImmutableMap$1 extends cdt<K> {
    final /* synthetic */ cdt bMA;
    final /* synthetic */ ImmutableMap this$0;

    ImmutableMap$1(ImmutableMap immutableMap, cdt com_fossil_cdt) {
        this.this$0 = immutableMap;
        this.bMA = com_fossil_cdt;
    }

    public boolean hasNext() {
        return this.bMA.hasNext();
    }

    public K next() {
        return ((Entry) this.bMA.next()).getKey();
    }
}
