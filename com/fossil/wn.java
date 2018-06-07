package com.fossil;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class wn implements wi {
    private volatile Map<String, String> aDA;
    private final Map<String, List<wm>> aDz;

    public static final class C4199a {
        private static final String aDB = System.getProperty("http.agent");
        private static final Map<String, List<wm>> aDC;
        private boolean aDD = true;
        private boolean aDE = true;
        private boolean aDF = true;
        private Map<String, List<wm>> aDz = aDC;

        static {
            Map hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(aDB)) {
                hashMap.put("User-Agent", Collections.singletonList(new C4200b(aDB)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new C4200b("identity")));
            aDC = Collections.unmodifiableMap(hashMap);
        }

        public wn vy() {
            this.aDD = true;
            return new wn(this.aDz);
        }
    }

    static final class C4200b implements wm {
        private final String value;

        C4200b(String str) {
            this.value = str;
        }

        public String vw() {
            return this.value;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + '\'' + '}';
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4200b)) {
                return false;
            }
            return this.value.equals(((C4200b) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }

    wn(Map<String, List<wm>> map) {
        this.aDz = Collections.unmodifiableMap(map);
    }

    public Map<String, String> getHeaders() {
        if (this.aDA == null) {
            synchronized (this) {
                if (this.aDA == null) {
                    this.aDA = Collections.unmodifiableMap(vx());
                }
            }
        }
        return this.aDA;
    }

    private Map<String, String> vx() {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.aDz.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(((wm) list.get(i)).vw());
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            hashMap.put(entry.getKey(), stringBuilder.toString());
        }
        return hashMap;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.aDz + '}';
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wn)) {
            return false;
        }
        return this.aDz.equals(((wn) obj).aDz);
    }

    public int hashCode() {
        return this.aDz.hashCode();
    }
}
