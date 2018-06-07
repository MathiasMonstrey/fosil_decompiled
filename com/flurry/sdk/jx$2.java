package com.flurry.sdk;

import com.fossil.apb;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class jx$2 extends LinkedHashMap<String, String> {
    final /* synthetic */ apb f1323a;

    public jx$2(apb com_fossil_apb) {
        this.f1323a = com_fossil_apb;
    }

    protected final boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 10;
    }
}
