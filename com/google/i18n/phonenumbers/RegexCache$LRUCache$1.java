package com.google.i18n.phonenumbers;

import com.fossil.chd.a;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RegexCache$LRUCache$1 extends LinkedHashMap<K, V> {
    final /* synthetic */ a this$0;

    public RegexCache$LRUCache$1(a aVar, int i, float f, boolean z) {
        this.this$0 = aVar;
        super(i, f, z);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > a.a(this.this$0);
    }
}
