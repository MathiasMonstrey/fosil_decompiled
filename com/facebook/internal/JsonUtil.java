package com.facebook.internal;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class JsonUtil {

    static final class JSONObjectEntry implements Entry<String, Object> {
        private final String key;
        private final Object value;

        JSONObjectEntry(String str, Object obj) {
            this.key = str;
            this.value = obj;
        }

        @SuppressLint({"FieldGetter"})
        public String getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("JSONObjectEntry is immutable");
        }
    }

    JsonUtil() {
    }

    static void jsonObjectClear(JSONObject jSONObject) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            keys.next();
            keys.remove();
        }
    }

    static boolean jsonObjectContainsValue(JSONObject jSONObject, Object obj) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object opt = jSONObject.opt((String) keys.next());
            if (opt != null && opt.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    static Set<Entry<String, Object>> jsonObjectEntrySet(JSONObject jSONObject) {
        Set hashSet = new HashSet();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashSet.add(new JSONObjectEntry(str, jSONObject.opt(str)));
        }
        return hashSet;
    }

    static Set<String> jsonObjectKeySet(JSONObject jSONObject) {
        Set hashSet = new HashSet();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    static void jsonObjectPutAll(JSONObject jSONObject, Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.putOpt((String) entry.getKey(), entry.getValue());
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    static Collection<Object> jsonObjectValues(JSONObject jSONObject) {
        Collection arrayList = new ArrayList();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            arrayList.add(jSONObject.opt((String) keys.next()));
        }
        return arrayList;
    }
}
