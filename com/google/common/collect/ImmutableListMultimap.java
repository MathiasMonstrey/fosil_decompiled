package com.google.common.collect;

import com.fossil.cdh;
import com.fossil.cdi;
import com.fossil.cdn;
import com.google.common.collect.ImmutableMap.a;
import com.google.common.collect.ImmutableMultimap.b;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements cdh<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> bMv;

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        a builder = builder();
        builder.x(k, v);
        return builder.UH();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        a builder = builder();
        builder.x(k, v);
        builder.x(k2, v2);
        return builder.UH();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a builder = builder();
        builder.x(k, v);
        builder.x(k2, v2);
        builder.x(k3, v3);
        return builder.UH();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a builder = builder();
        builder.x(k, v);
        builder.x(k2, v2);
        builder.x(k3, v3);
        builder.x(k4, v4);
        return builder.UH();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a builder = builder();
        builder.x(k, v);
        builder.x(k2, v2);
        builder.x(k3, v3);
        builder.x(k4, v4);
        builder.x(k5, v5);
        return builder.UH();
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V) {
        if (com_fossil_cdi__extends_K___extends_V.isEmpty()) {
            return of();
        }
        if (com_fossil_cdi__extends_K___extends_V instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) com_fossil_cdi__extends_K___extends_V;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        a aVar = new a(com_fossil_cdi__extends_K___extends_V.asMap().size());
        int i = 0;
        for (Entry entry : com_fossil_cdi__extends_K___extends_V.asMap().entrySet()) {
            int i2;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) entry.getValue());
            if (copyOf.isEmpty()) {
                i2 = i;
            } else {
                aVar.z(entry.getKey(), copyOf);
                i2 = copyOf.size() + i;
            }
            i = i2;
        }
        return new ImmutableListMultimap(aVar.UJ(), i);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        return new a().g(iterable).UH();
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public ImmutableList<V> get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.bMv;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        immutableListMultimap = UG();
        this.bMv = immutableListMultimap;
        return immutableListMultimap;
    }

    private ImmutableListMultimap<V, K> UG() {
        a builder = builder();
        Iterator it = entries().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            builder.x(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> UH = builder.UH();
        UH.bMv = this;
        return UH;
    }

    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        cdn.m6027a(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        a builder = ImmutableMap.builder();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            ImmutableList.a builder2 = ImmutableList.builder();
            for (int i3 = 0; i3 < readInt2; i3++) {
                builder2.cp(objectInputStream.readObject());
            }
            builder.z(readObject, builder2.UF());
            i += readInt2;
        }
        try {
            b.bML.set((Object) this, builder.UJ());
            b.bMM.set((Object) this, i);
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
