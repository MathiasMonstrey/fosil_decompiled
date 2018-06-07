package com.google.common.collect;

import com.fossil.ccm;
import com.fossil.cco;
import com.fossil.cdi;
import com.fossil.cdn;
import com.fossil.cdo;
import com.google.common.collect.ImmutableMap.a;
import com.google.common.collect.ImmutableMultimap.b;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements cdo<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> bMT;
    private transient ImmutableSetMultimap<V, K> bMU;
    private transient ImmutableSet<Entry<K, V>> bMV;

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        a builder = builder();
        builder.A(k, v);
        return builder.UP();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        a builder = builder();
        builder.A(k, v);
        builder.A(k2, v2);
        return builder.UP();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a builder = builder();
        builder.A(k, v);
        builder.A(k2, v2);
        builder.A(k3, v3);
        return builder.UP();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a builder = builder();
        builder.A(k, v);
        builder.A(k2, v2);
        builder.A(k3, v3);
        builder.A(k4, v4);
        return builder.UP();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a builder = builder();
        builder.A(k, v);
        builder.A(k2, v2);
        builder.A(k3, v3);
        builder.A(k4, v4);
        builder.A(k5, v5);
        return builder.UP();
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V) {
        return m12664a((cdi) com_fossil_cdi__extends_K___extends_V, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> m12664a(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V, Comparator<? super V> comparator) {
        cco.ce(com_fossil_cdi__extends_K___extends_V);
        if (com_fossil_cdi__extends_K___extends_V.isEmpty() && comparator == null) {
            return of();
        }
        if (com_fossil_cdi__extends_K___extends_V instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) com_fossil_cdi__extends_K___extends_V;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        a aVar = new a(com_fossil_cdi__extends_K___extends_V.asMap().size());
        int i = 0;
        for (Entry entry : com_fossil_cdi__extends_K___extends_V.asMap().entrySet()) {
            int i2;
            Object key = entry.getKey();
            ImmutableSet a = m12663a((Comparator) comparator, (Collection) entry.getValue());
            if (a.isEmpty()) {
                i2 = i;
            } else {
                aVar.z(key, a);
                i2 = a.size() + i;
            }
            i = i2;
        }
        return new ImmutableSetMultimap(aVar.UJ(), i, comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        return new a().l(iterable).UP();
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.bMT = m12662a(comparator);
    }

    public ImmutableSet<V> get(K k) {
        return (ImmutableSet) ccm.m5981r((ImmutableSet) this.map.get(k), this.bMT);
    }

    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.bMU;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        immutableSetMultimap = UO();
        this.bMU = immutableSetMultimap;
        return immutableSetMultimap;
    }

    private ImmutableSetMultimap<V, K> UO() {
        a builder = builder();
        Iterator it = entries().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            builder.A(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> UP = builder.UP();
        UP.bMU = this;
        return UP;
    }

    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Entry<K, V>> entries() {
        ImmutableSet<Entry<K, V>> immutableSet = this.bMV;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new EntrySet(this);
        this.bMV = immutableSet;
        return immutableSet;
    }

    private static <V> ImmutableSet<V> m12663a(Comparator<? super V> comparator, Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) collection);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet<V> m12662a(Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.emptySet(comparator);
    }

    private static <V> ImmutableSet.a<V> m12665b(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a() : new ImmutableSortedSet.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        cdn.m6027a(this, objectOutputStream);
    }

    Comparator<? super V> valueComparator() {
        return this.bMT instanceof ImmutableSortedSet ? ((ImmutableSortedSet) this.bMT).comparator() : null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
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
            ImmutableSet.a b = m12665b(comparator);
            for (int i3 = 0; i3 < readInt2; i3++) {
                b.cr(objectInputStream.readObject());
            }
            ImmutableSet UN = b.UN();
            if (UN.size() != readInt2) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.z(readObject, UN);
            i += readInt2;
        }
        try {
            b.bML.set((Object) this, builder.UJ());
            b.bMM.set((Object) this, i);
            b.bMN.set((Object) this, m12662a(comparator));
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
