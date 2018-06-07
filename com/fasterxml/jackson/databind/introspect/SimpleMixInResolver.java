package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.type.ClassKey;
import com.fossil.aiw.C1505a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleMixInResolver implements C1505a, Serializable {
    private static final long serialVersionUID = 1;
    protected Map<ClassKey, Class<?>> _localMixIns;
    protected final C1505a _overrides;

    public SimpleMixInResolver(C1505a c1505a) {
        this._overrides = c1505a;
    }

    protected SimpleMixInResolver(C1505a c1505a, Map<ClassKey, Class<?>> map) {
        this._overrides = c1505a;
        this._localMixIns = map;
    }

    public SimpleMixInResolver withOverrides(C1505a c1505a) {
        return new SimpleMixInResolver(c1505a, this._localMixIns);
    }

    public SimpleMixInResolver withoutLocalDefinitions() {
        return new SimpleMixInResolver(this._overrides, null);
    }

    public void setLocalDefinitions(Map<Class<?>, Class<?>> map) {
        if (map == null || map.isEmpty()) {
            this._localMixIns = null;
        }
        Map hashMap = new HashMap(map.size());
        for (Entry entry : map.entrySet()) {
            hashMap.put(new ClassKey((Class) entry.getKey()), entry.getValue());
        }
        this._localMixIns = hashMap;
    }

    public void addLocalDefinition(Class<?> cls, Class<?> cls2) {
        if (this._localMixIns == null) {
            this._localMixIns = new HashMap();
        }
        this._localMixIns.put(new ClassKey(cls), cls2);
    }

    public SimpleMixInResolver copy() {
        Map map = null;
        C1505a copy = this._overrides == null ? null : this._overrides.copy();
        if (this._localMixIns != null) {
            map = new HashMap(this._localMixIns);
        }
        return new SimpleMixInResolver(copy, map);
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        Class<?> findMixInClassFor = this._overrides == null ? null : this._overrides.findMixInClassFor(cls);
        if (findMixInClassFor != null || this._localMixIns == null) {
            return findMixInClassFor;
        }
        return (Class) this._localMixIns.get(new ClassKey(cls));
    }

    public int localSize() {
        return this._localMixIns == null ? 0 : this._localMixIns.size();
    }
}
