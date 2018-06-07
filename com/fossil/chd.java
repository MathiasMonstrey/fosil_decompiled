package com.fossil;

import com.google.i18n.phonenumbers.RegexCache.LRUCache.1;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class chd {
    private C2064a<String, Pattern> bVp;

    public static class C2064a<K, V> {
        private LinkedHashMap<K, V> Qp;
        private int size;

        public C2064a(int i) {
            this.size = i;
            this.Qp = new 1(this, ((i * 4) / 3) + 1, 0.75f, true);
        }

        public synchronized V get(K k) {
            return this.Qp.get(k);
        }

        public synchronized void m6405l(K k, V v) {
            this.Qp.put(k, v);
        }
    }

    public chd(int i) {
        this.bVp = new C2064a(i);
    }

    public Pattern fH(String str) {
        Pattern pattern = (Pattern) this.bVp.get(str);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(str);
        this.bVp.m6405l(str, pattern);
        return pattern;
    }
}
