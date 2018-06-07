package com.fossil;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class dxh {
    private final ConcurrentMap<Class<?>, Set<dxj>> dAk;
    private final ConcurrentMap<Class<?>, dxk> dAl;
    private final dxo dAm;
    private final dxl dAn;
    private final ThreadLocal<ConcurrentLinkedQueue<C3284a>> dAo;
    private final ThreadLocal<Boolean> dAp;
    private final ConcurrentMap<Class<?>, Set<Class<?>>> dAq;
    private final String identifier;

    class C32821 extends ThreadLocal<ConcurrentLinkedQueue<C3284a>> {
        final /* synthetic */ dxh dAr;

        C32821(dxh com_fossil_dxh) {
            this.dAr = com_fossil_dxh;
        }

        protected /* synthetic */ Object initialValue() {
            return aBw();
        }

        protected ConcurrentLinkedQueue<C3284a> aBw() {
            return new ConcurrentLinkedQueue();
        }
    }

    class C32832 extends ThreadLocal<Boolean> {
        final /* synthetic */ dxh dAr;

        C32832(dxh com_fossil_dxh) {
            this.dAr = com_fossil_dxh;
        }

        protected Boolean initialValue() {
            return Boolean.valueOf(false);
        }
    }

    static class C3284a {
        final Object dAs;
        final dxj dAt;

        public C3284a(Object obj, dxj com_fossil_dxj) {
            this.dAs = obj;
            this.dAt = com_fossil_dxj;
        }
    }

    public dxh(dxo com_fossil_dxo) {
        this(com_fossil_dxo, "default");
    }

    public dxh(dxo com_fossil_dxo, String str) {
        this(com_fossil_dxo, str, dxl.dAv);
    }

    dxh(dxo com_fossil_dxo, String str, dxl com_fossil_dxl) {
        this.dAk = new ConcurrentHashMap();
        this.dAl = new ConcurrentHashMap();
        this.dAo = new C32821(this);
        this.dAp = new C32832(this);
        this.dAq = new ConcurrentHashMap();
        this.dAm = com_fossil_dxo;
        this.identifier = str;
        this.dAn = com_fossil_dxl;
    }

    public String toString() {
        return "[Bus \"" + this.identifier + "\"]";
    }

    public void cV(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        this.dAm.mo2773a(this);
        Map cT = this.dAn.cT(obj);
        for (Class cls : cT.keySet()) {
            dxk com_fossil_dxk = (dxk) cT.get(cls);
            dxk com_fossil_dxk2 = (dxk) this.dAl.putIfAbsent(cls, com_fossil_dxk);
            if (com_fossil_dxk2 != null) {
                throw new IllegalArgumentException("Producer method for type " + cls + " found on type " + com_fossil_dxk.target.getClass() + ", but already registered by type " + com_fossil_dxk2.target.getClass() + ".");
            }
            Set<dxj> set = (Set) this.dAk.get(cls);
            if (!(set == null || set.isEmpty())) {
                for (dxj a : set) {
                    m7040a(a, com_fossil_dxk);
                }
            }
        }
        cT = this.dAn.cU(obj);
        for (Class cls2 : cT.keySet()) {
            Set set2 = (Set) this.dAk.get(cls2);
            if (set2 == null) {
                CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
                set2 = (Set) this.dAk.putIfAbsent(cls2, copyOnWriteArraySet);
                if (set2 == null) {
                    set2 = copyOnWriteArraySet;
                }
            }
            if (!set2.addAll((Set) cT.get(cls2))) {
                throw new IllegalArgumentException("Object already registered.");
            }
        }
        for (Entry entry : cT.entrySet()) {
            com_fossil_dxk = (dxk) this.dAl.get((Class) entry.getKey());
            if (com_fossil_dxk != null && com_fossil_dxk.isValid()) {
                for (dxj a2 : (Set) entry.getValue()) {
                    if (!com_fossil_dxk.isValid()) {
                        break;
                    } else if (a2.isValid()) {
                        m7040a(a2, com_fossil_dxk);
                    }
                }
            }
        }
    }

    private void m7040a(dxj com_fossil_dxj, dxk com_fossil_dxk) {
        Object obj = null;
        try {
            obj = com_fossil_dxk.aBx();
        } catch (InvocationTargetException e) {
            m7041a("Producer " + com_fossil_dxk + " threw an exception.", e);
        }
        if (obj != null) {
            m7043b(obj, com_fossil_dxj);
        }
    }

    public void cW(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to unregister must not be null.");
        }
        this.dAm.mo2773a(this);
        for (Entry entry : this.dAn.cT(obj).entrySet()) {
            Class cls = (Class) entry.getKey();
            dxk aj = aj(cls);
            dxk com_fossil_dxk = (dxk) entry.getValue();
            if (com_fossil_dxk == null || !com_fossil_dxk.equals(aj)) {
                throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + obj.getClass() + " registered?");
            }
            ((dxk) this.dAl.remove(cls)).invalidate();
        }
        for (Entry entry2 : this.dAn.cU(obj).entrySet()) {
            Set<dxj> ak = ak((Class) entry2.getKey());
            Collection collection = (Collection) entry2.getValue();
            if (ak == null || !ak.containsAll(collection)) {
                throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + obj.getClass() + " registered?");
            }
            for (dxj com_fossil_dxj : ak) {
                if (collection.contains(com_fossil_dxj)) {
                    com_fossil_dxj.invalidate();
                }
            }
            ak.removeAll(collection);
        }
    }

    public void cO(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Event to post must not be null.");
        }
        this.dAm.mo2773a(this);
        Object obj2 = null;
        for (Class ak : al(obj.getClass())) {
            Set<dxj> ak2 = ak(ak);
            if (!(ak2 == null || ak2.isEmpty())) {
                obj2 = 1;
                for (dxj a : ak2) {
                    m7042a(obj, a);
                }
            }
            obj2 = obj2;
        }
        if (obj2 == null && !(obj instanceof dxi)) {
            cO(new dxi(this, obj));
        }
        aBv();
    }

    protected void m7042a(Object obj, dxj com_fossil_dxj) {
        ((ConcurrentLinkedQueue) this.dAo.get()).offer(new C3284a(obj, com_fossil_dxj));
    }

    protected void aBv() {
        if (!((Boolean) this.dAp.get()).booleanValue()) {
            this.dAp.set(Boolean.valueOf(true));
            while (true) {
                C3284a c3284a = (C3284a) ((ConcurrentLinkedQueue) this.dAo.get()).poll();
                if (c3284a == null) {
                    break;
                }
                try {
                    if (c3284a.dAt.isValid()) {
                        m7043b(c3284a.dAs, c3284a.dAt);
                    }
                } finally {
                    this.dAp.set(Boolean.valueOf(false));
                }
            }
        }
    }

    protected void m7043b(Object obj, dxj com_fossil_dxj) {
        try {
            com_fossil_dxj.cX(obj);
        } catch (InvocationTargetException e) {
            m7041a("Could not dispatch event: " + obj.getClass() + " to handler " + com_fossil_dxj, e);
        }
    }

    dxk aj(Class<?> cls) {
        return (dxk) this.dAl.get(cls);
    }

    Set<dxj> ak(Class<?> cls) {
        return (Set) this.dAk.get(cls);
    }

    Set<Class<?>> al(Class<?> cls) {
        Set<Class<?>> set = (Set) this.dAq.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> am = am(cls);
        set = (Set) this.dAq.putIfAbsent(cls, am);
        if (set == null) {
            return am;
        }
        return set;
    }

    private Set<Class<?>> am(Class<?> cls) {
        List linkedList = new LinkedList();
        Set<Class<?>> hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            cls2 = cls2.getSuperclass();
            if (cls2 != null) {
                linkedList.add(cls2);
            }
        }
        return hashSet;
    }

    private static void m7041a(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            throw new RuntimeException(str + ": " + cause.getMessage(), cause);
        }
        throw new RuntimeException(str + ": " + invocationTargetException.getMessage(), invocationTargetException);
    }
}
